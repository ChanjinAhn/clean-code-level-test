package io.olkkani.question.service;

import io.olkkani.question.dto.QuestionRequest;
import io.olkkani.question.entity.Question;
import io.olkkani.question.repository.QuestionRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public void save(Question question) {

    }

    @Override
    public QuestionRequest deleteById(Long id) {
        return null;
    }

    @Override
    public List<QuestionRequest> findAll() {
        return null;
    }

    @Override
    public List<QuestionRequest> find(Pageable pageable) {
        List<Question> questionResult = repository.find(pageable);
        List<QuestionRequest> question = new ArrayList<>();
        modelMapper.map(questionResult, question);
        return question;
    }

    @Override
    public QuestionRequest findById(Long id) {
        Question question = repository.findById(id).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(question, QuestionRequest.class);
    }
}
