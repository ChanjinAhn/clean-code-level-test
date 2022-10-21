package io.olkkani.question.entity;

import io.oikk.common.repository.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Question extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String question;
    @Column
    private String optionA;
    @Column
    private String optionB;
    @Column
    private String answer;
    @Column
    private String answerComment;

    @Builder
    public Question(Long id, String question, String optionA, String optionB, String answer,
        String answerComment) {
        this.id = id;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.answer = answer;
        this.answerComment = answerComment;
    }
}
