package io.olkkani.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Slf4j
public class ImageFile {
    // todo 고정 경로를 환경에 맞춰서 변경될 수 있도록 수정
//    @Value("${image.filePath}")
    private final String savedImageFilePath = "/Users/acj/Documents/images";


    private String fileNameToHash (String fileName) {
        try {
            // 난수 생성
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            byte[] bytes = new byte[16];
            random.nextBytes(bytes);
            // salt 생성
            String salt = new String(Base64.getEncoder().encode(bytes));
            fileName = fileName + salt;
            // sha-256 + salt hash
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(fileName.getBytes());
            return String.format("%064x", new BigInteger(1, md.digest()));
        } catch (NoSuchAlgorithmException e) {
            log.error("not found algorithm, please check algorithm get instance", e);
        }
        return fileName;
    }
    private boolean isDuplicateFileName (String fileName) {
        File file = new File(fileName);
        return !file.exists();
    }
    private void saveImageFile (String fileName, MultipartFile imageFile) {
        try {
            imageFile.transferTo(new File(fileName));
        }catch (IOException e){
            log.error("",e);
        }
    }


    public String saveFileAndReturnHashedFileName (MultipartFile imageFile) {
        String originalFileName = imageFile.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFileName);
        String fileFullName;

        String hashedFileName;
        do {
            hashedFileName = fileNameToHash(FilenameUtils.getBaseName(originalFileName));
            fileFullName = Paths.get(savedImageFilePath, hashedFileName + "." + extension).toString();
        } while (isDuplicateFileName(fileFullName));

        saveImageFile(fileFullName, imageFile);
        return hashedFileName + "." + extension;
    }

    public MultipartFile getMultipartFileByFileName (String fileName){
        File file = Paths.get(savedImageFilePath, fileName).toFile();
        FileItem fileItem = null;
        try {
            fileItem = new DiskFileItem(fileName, Files.probeContentType(file.toPath()), false, file.getName(), (int) file.length(), file.getParentFile());
            IOUtils.copy(new FileInputStream(file), fileItem.getOutputStream());
        } catch (IOException ex) {
            log.error("", ex);
        }
        return new CommonsMultipartFile(Objects.requireNonNull(fileItem));
    }

    public void deleteImageFile (String fileName)  {
        try {
            Files.deleteIfExists(Paths.get(savedImageFilePath, fileName).toAbsolutePath());
        } catch (IOException e) {
            log.error("file has already been deleted", e);
        }
    }
}
