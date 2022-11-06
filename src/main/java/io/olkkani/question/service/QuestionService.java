package io.olkkani.question.service;

import io.olkkani.question.dto.QuestionRequest;
import io.olkkani.question.entity.Question;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface QuestionService {

    public void save (QuestionRequest request);
    public List<QuestionRequest> findAll ();

    public QuestionRequest findById (Long id);

    public List<QuestionRequest> findRandomQuestions ();

    public void deleteById (Long id);
//    public List<QuestionRequest> find(Pageable pageable);
}
