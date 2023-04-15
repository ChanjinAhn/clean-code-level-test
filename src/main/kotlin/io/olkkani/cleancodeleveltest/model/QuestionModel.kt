package io.olkkani.cleancodeleveltest.model

import io.olkkani.cleancodeleveltest.domain.AnswerOption
import io.olkkani.cleancodeleveltest.domain.Question

// request model 을 제대로 불러오지 못하는 이유 찾기
data class QuestionRequest(
    val question: String,
    val optionA: String,
    val optionB: String,
    val answer: AnswerOption,
    val description: String,
)


data class QuestionResponse(
    val id: Long,
    val question: String,
    val optionA: String,
    val optionB: String,
    val answer: AnswerOption,
    val description: String,
)


fun Question.toResponse() = QuestionResponse (
    id = id!!,
    question = question,
    optionA = optionA,
    optionB = optionB,
    answer = answer,
    description = description
)