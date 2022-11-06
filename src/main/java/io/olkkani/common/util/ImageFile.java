package io.olkkani.common.util;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
public class ImageFile {

    String filePath = Paths.get("question_images").toString();

    public String fileNameToHash (String fileName) {
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

    public File getFileByFileName (String fileName) {
        return Paths.get(filePath,fileName).toFile();
    }

    public void saveImageFile (String fileName, File imageFile) {
//        try {
//            BufferedImage image =
//        }catch (IOException e){
//            log.error("",e);
//        }
    }


    public String saveFileAndReturnHashedFileName (MultipartFile imageFile) {
        String originalFileName = imageFile.getOriginalFilename();
        String hashedImageFIleName = fileNameToHash(FilenameUtils.getBaseName(originalFileName));
        String extension = FilenameUtils.getExtension(originalFileName);

//        imageFile.
//        saveImageFile(im);

        return hashedImageFIleName + "." + extension;
    }

    public MultipartFile getMultipartFileByFileName (String fileName){

        return null;
    }


}
