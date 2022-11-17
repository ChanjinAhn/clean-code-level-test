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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Service
public class QuestionServiceImpl implements QuestionService{

    private final ModelMapper modelMapper;
    private final QuestionRepository repository;
    private final QuestionQueryRepository queryRepository;

    @Override
    public void save(QuestionRequest request) {
        ImageFile imageFile = new ImageFile();
        // todo 기존에 저장된 이미지 파일을 삭제, 추후 파일을 수정하지 않은 경우에는 삭제하지 않도록 변경(서버 부하량에 따라 결정)
        if (request.getId() != 0){
            Question selectedQuestion = repository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
            imageFile.deleteImageFile(selectedQuestion.getOptionA());
            imageFile.deleteImageFile(selectedQuestion.getOptionB());
        }
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
