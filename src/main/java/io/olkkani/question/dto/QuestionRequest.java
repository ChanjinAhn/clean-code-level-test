package io.olkkani.question.dto;


import io.olkkani.common.dto.BaseTimeDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionRequest extends BaseTimeDTO {
    private Long id;
    private String question;
    private String optionA;
    private MultipartFile optionAFile;
    private String optionB;
    private MultipartFile optionBFile;
    private String answer;
    private String answerComment;

    @Builder
    public QuestionRequest(Long id, String question, String optionA, MultipartFile optionAFile,
        String optionB, MultipartFile optionBFile, String answer, String answerComment) {
        this.id = id;
        this.question = question;
        this.optionA = optionA;
        this.optionAFile = optionAFile;
        this.optionB = optionB;
        this.optionBFile = optionBFile;
        this.answer = answer;
        this.answerComment = answerComment;
    }
}