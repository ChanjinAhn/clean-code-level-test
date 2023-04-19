package io.olkkani.cleancodeleveltest.domain

import com.querydsl.core.types.dsl.NumberExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import io.olkkani.cleancodeleveltest.domain.QQuiz.quiz
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class QuizRepositorySupport(
    val queryFactory: JPAQueryFactory
) : QuerydslRepositorySupport(
    Quiz::class.java
//    val jpaQueryFactory: JPAQueryFactor
){


    fun findRandomQuiz(): List<Quiz> {
        return queryFactory.selectFrom(quiz)
            .orderBy(NumberExpression.random().asc())
            .limit(10).fetch()
    }
}
//    val jpaQueryFactory: JPAQueryFactory
//){
//    fun findRandomQuiz(): List<Quiz> {
//        return jpaQueryFactory.selectFrom(QQuiz.quiz1)
//            .orderBy(NumberExpression.random().asc())
//            .limit(10).fetch()
//    }
//}