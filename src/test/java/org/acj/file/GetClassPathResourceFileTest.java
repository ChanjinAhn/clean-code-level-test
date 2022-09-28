package org.acj.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * packageName    : example.demospringboot
 * <p>
 * fileName       : GetClassPathResourceFileTest
 * <p>
 * author         : acj
 * <p>
 * date           : 2022/02/02
 * <p>
 * description    : resource 경로의 있는 파일을 잘 가져오는지 테스트
 * <p>
 * ===========================================================
 * <p>
 * DATE              AUTHOR             NOTE
 * <p>
 * -----------------------------------------------------------
 * <p>
 * 2022/02/02        acj       최초 생성
 */
public class GetClassPathResourceFileTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetClassPath(){
        String filePathWithName = Paths.get("sampleFile", "data.txt").toString();
        ClassPathResource resource = new ClassPathResource(filePathWithName);
        // 텍스트에 속한 내용을 읽는 작업
        try {
            Path path = Paths.get(resource.getURI());
            // 해당 파일의 실제 경로
            System.out.println(path);
            List<String> content = Files.readAllLines(path);
            content.forEach(System.out::println);
        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
        }
    }
}
