package io.olkkani.question.service;

import io.olkkani.question.dto.QuestionRequest;
import io.olkkani.question.entity.Question;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface QuestionService {

    public void save (Question question);

    public QuestionRequest deleteById (Long id);

    public List<QuestionRequest> findAll ();
    public List<QuestionRequest> find(Pageable pageable);
    public QuestionRequest findById (Long id);


}
