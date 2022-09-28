package io.oikk.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class MainController {

    @GetMapping("/main")
    public String main(@RequestParam(name = "name", required = false, defaultValue = "Wolrd") String name, Model model){
        model.addAttribute("name", name);
        System.out.println("ddd");
        System.out.println("ddd");
        System.out.println("ddd");
        log.info("hello");
        log.debug("hello");
        log.warn("hello");
        log.trace("hello");
        log.error("hello");

        return "test/main";
    }
}
