package io.oikk.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : example.demospringboot.test.controller
 * <p>
 * fileName       : MainRestController
 * <p>
 * author         : acj
 * <p>
 * date           : 2022/01/29
 * <p>
 * description    :
 * <p>
 * ===========================================================
 * <p>
 * DATE              AUTHOR             NOTE
 * <p>
 * -----------------------------------------------------------
 * <p>
 * 2022/01/29        acj       최초 생성
 */
@RestController
public class MainRestController {

    @GetMapping("test-get")
    public String testGet(String param){

        return param;
    }

    @PostMapping("test-post")
    public String testPost(String param){
        return param;
    }

}
