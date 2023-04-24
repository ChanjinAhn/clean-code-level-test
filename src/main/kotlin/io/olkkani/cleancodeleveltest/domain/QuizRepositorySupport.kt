package io.olkkani.cleancodeleveltest.domain

import com.querydsl.core.types.dsl.NumberExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import io.olkkani.cleancodeleveltest.domain.QQuiz.quiz
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class QuizRepositorySupport(
    private val queryFactory: JPAQueryFactory
) : QuerydslRepositorySupport(
    Quiz::class.java
){

    fun getRandomQuiz(): List<Quiz>? =
        queryFactory.selectFrom(quiz)
            .orderBy(NumberExpression.random().asc())
            .limit(10).fetch()
}