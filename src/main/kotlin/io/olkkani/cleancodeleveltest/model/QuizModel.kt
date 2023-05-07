package io.olkkani.cleancodeleveltest.model

import io.olkkani.cleancodeleveltest.domain.AnswerOption
import io.olkkani.cleancodeleveltest.domain.Quiz
import org.springframework.data.domain.Page

data class QuizRequest(
    val question: String,
    val optionA: String,
    val optionB: String,
    val answer: AnswerOption,
    val description: String,
)

data class QuizResponse(
    val id: Long,
    val question: String,
    val optionA: String,
    val optionB: String,
    val answer: AnswerOption,
    val description: String,
)

fun Quiz.toResponse() = QuizResponse(
    id = id!!,
    question = question,
    optionA = optionA,
    optionB = optionB,
    answer = answer,
    description = description
)

fun Page<Quiz>.toPaginationResponse(): Map<String, Any> {
    val totalPageCount = this.totalPages
    val content = this.content.map { it.toResponse() }
    val page = this.number

    return mutableMapOf<String, Any>().apply {
        put("result", true)
        put("data", mapOf<String, Any>(
            "content" to content,
            "pagination" to mapOf<String, Any>(
                "page" to page,
                "totalCount" to totalPageCount,
            )
        ))
    }
}