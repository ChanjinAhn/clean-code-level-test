package io.oikk.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class MainController {

    @GetMapping("/main")
    public String main(@RequestParam(name = "name", required = false, defaultValue = "world") String name, Model model){
        model.addAttribute("name", name);
        return "test/main";
    }
}