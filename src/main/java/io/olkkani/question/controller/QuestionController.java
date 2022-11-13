package io.olkkani.question.controller;

import io.olkkani.question.dto.QuestionRequest;
import io.olkkani.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("question")
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
        return "pages/question/question_register";}

    @PostMapping("update")
    public String update (long id, Model model){
        QuestionRequest response = service.findById(id);
        model.addAttribute("response", response);
        return "pages/question/question_register";
    }

    @PostMapping("save")
    public String save (QuestionRequest request) {
        service.save(request);
        return "redirect:list";
    }

}



