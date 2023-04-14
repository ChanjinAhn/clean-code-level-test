package io.olkkani.cleancodeleveltest.service

import io.olkkani.cleancodeleveltest.config.exception.NotFoundException
import io.olkkani.cleancodeleveltest.domain.Question
import io.olkkani.cleancodeleveltest.domain.QuestionRepository
import io.olkkani.cleancodeleveltest.model.toResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QuestionService (
    private val questionRepository: QuestionRepository
){
        @Transactional(readOnly = true)
    fun getAll() =
            questionRepository.findAll().map { it.toResponse() }
    fun get(id: Long): Question {
        return questionRepository.findByIdOrNull(id) ?: throw NotFoundException("질문이 존재하지 않습니다.")
    }
}