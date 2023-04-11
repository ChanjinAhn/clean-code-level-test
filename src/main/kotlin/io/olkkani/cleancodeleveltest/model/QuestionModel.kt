package io.olkkani.cleancodeleveltest.model

import io.olkkani.cleancodeleveltest.domain.AnswerOption
import io.olkkani.cleancodeleveltest.domain.Question
import io.olkkani.cleancodeleveltest.model.QuestionResponse


data class QuestionRequest(
    val id : Long? = null,
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