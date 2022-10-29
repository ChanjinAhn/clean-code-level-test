package io.olkkani.question.dto;


import io.olkkani.common.dto.BaseTimeDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionRequest extends BaseTimeDTO {
    private Long id;
    private String question;
    private String optionA;
    private String optionB;
    private String answer;
    private String answerComment;

    @Builder
    public QuestionRequest(Long id, String question, String optionA, String optionB, String answer,
        String answerComment) {
        this.id = id;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.answer = answer;
        this.answerComment = answerComment;
    }
}