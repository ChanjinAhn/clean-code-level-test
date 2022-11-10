package io.olkkani.common.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
public class ImageFileTest {

    @Test
    public void saveDuplicateFileNameTest () {
        String fileName = "test.rtf";
        ImageFile imageFile = new ImageFile();
        MultipartFile multipartFile = imageFile.getMultipartFileByFileName(fileName);
        String hashedFileName = imageFile.saveFileAndReturnHashedFileName(multipartFile);
        log.debug(hashedFileName);
    }
}
