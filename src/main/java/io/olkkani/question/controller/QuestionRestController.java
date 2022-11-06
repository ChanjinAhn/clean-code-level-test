package io.olkkani.question.controller;

import io.olkkani.question.dto.QuestionRequest;
import io.olkkani.question.service.QuestionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class QuestionRestController {

//    private final QuestionService service;

    @GetMapping ("questions")
    public List<QuestionRequest> find (Pageable pageable) {
//        return service.find(pageable);
        return null;
    }

}
