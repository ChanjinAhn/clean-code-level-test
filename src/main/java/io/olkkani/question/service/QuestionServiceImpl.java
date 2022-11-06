package io.olkkani.question.service;

import io.olkkani.common.util.ImageFile;
import io.olkkani.question.dto.QuestionRequest;
import io.olkkani.question.entity.Question;
import io.olkkani.question.repository.QuestionQueryRepository;
import io.olkkani.question.repository.QuestionRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class QuestionServiceImpl implements QuestionService{

    private final ModelMapper modelMapper;
    private final QuestionRepository repository;
    private final QuestionQueryRepository queryRepository;

    @Override
    public void save(QuestionRequest request) {
        ImageFile imageFile = new ImageFile();
        request.setOptionA(imageFile.saveFileAndReturnHashedFileName(request.getOptionAFile()));
        request.setOptionB(imageFile.saveFileAndReturnHashedFileName(request.getOptionBFile()));
        Question question = modelMapper.map(request, Question.class);
        repository.save(question);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<QuestionRequest> findAll() {
        List<QuestionRequest> response = new ArrayList<>();
        modelMapper.map(queryRepository.findRandomQuestions(), response);
        return response;
    }

//    @Override
//    public List<QuestionRequest> find(Pageable pageable) {
//        List<Question> questionResult = repository.find(pageable);
//        List<QuestionRequest> question = new ArrayList<>();
//        modelMapper.map(questionResult, question);
//        return question;
//        return null;
//    }

    @Override
    public QuestionRequest findById(Long id) {
        Question question = repository.findById(id).orElseThrow(IllegalArgumentException::new);
        QuestionRequest response = modelMapper.map(question, QuestionRequest.class);
        ImageFile imageFile = new ImageFile();
        response.setOptionAFile(imageFile.getMultipartFileByFileName(response.getOptionA()));
        response.setOptionBFile(imageFile.getMultipartFileByFileName(response.getOptionB()));
        return response;
    }

    @Override
    public List<QuestionRequest> findRandomQuestions() {
        List<QuestionRequest> response = new ArrayList<>();
        modelMapper.map(queryRepository.findRandomQuestions(), response);
        return response;
    }
}
