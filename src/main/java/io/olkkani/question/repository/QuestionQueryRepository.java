package io.olkkani.question.repository;


import static io.olkkani.question.entity.QQuestion.question1;

import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.olkkani.question.entity.Question;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class QuestionQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<Question> findRandomQuestions () {
        return  queryFactory.selectFrom(question1)
            .orderBy(NumberExpression.random().asc())
            .limit(10).fetch();
    }
}
