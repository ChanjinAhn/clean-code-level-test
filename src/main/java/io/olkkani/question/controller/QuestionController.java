package io.olkkani.question.controller;

import io.olkkani.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService service;

    @GetMapping("/list")
    public String list () {
        return "pages/question/list";
    }

    @PostMapping("register")
    public String register () {

        return "pages/question/register";
    }

    @PostMapping("update")
    public String update (){

        return "pages/question/register";
    }
}



