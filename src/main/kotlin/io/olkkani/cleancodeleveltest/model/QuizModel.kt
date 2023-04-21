package io.olkkani.cleancodeleveltest.model

import io.olkkani.cleancodeleveltest.domain.Quiz

// request model 을 제대로 불러오지 못하는 이유 찾기
data class QuizRequest(
    val question: String,
    val optionA: String,
    val optionB: String,
    val answer: String,
    val description: String,
)


data class QuizResponse(
    val id: Long,
    val question: String,
    val optionA: String,
    val optionB: String,
    val answer: String,
    val description: String,
)


fun Quiz.toResponse() = QuizResponse (
    id = id!!,
    question = question,
    optionA = optionA,
    optionB = optionB,
    answer = answer,
    description = description
)