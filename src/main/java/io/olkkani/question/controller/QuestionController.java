package io.olkkani.question.controller;

import io.olkkani.question.dto.QuestionRequest;
import io.olkkani.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping("/question")
@RequiredArgsConstructor
@Slf4j
@Controller
public class QuestionController {

    private final QuestionService service;

    @GetMapping("list")
    public String list () {
        return "pages/question/list";
    }

    @GetMapping("register")
    public String register () {
        // todo list Page 생성 후 PostMapping 으로 변경
        return "pages/question/question_register";
    }

    @PostMapping("update")
    public String update (){
        return "pages/question/register";
    }

    @PostMapping("save")
    public String save (QuestionRequest request) {
        service.save(request);
        return "redirect:list";
    }

}



