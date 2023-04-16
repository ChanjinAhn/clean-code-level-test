package io.olkkani.cleancodeleveltest.service

import io.olkkani.cleancodeleveltest.config.exception.NotFoundException
import io.olkkani.cleancodeleveltest.domain.Quiz
import io.olkkani.cleancodeleveltest.domain.QuizRepository
import io.olkkani.cleancodeleveltest.model.QuizRequest
import io.olkkani.cleancodeleveltest.model.toResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QuizService (
    private val questionRepository: QuizRepository
){


    @Transactional
    fun create(request: QuizRequest) {
        val question = Quiz(
            question = request.question,
            optionA = request.optionA,
            optionB = request.optionB,
            answer = request.answer,
            description = request.description
        )
        questionRepository.save(question)

    }
        @Transactional(readOnly = true)
    fun getAll() =
            questionRepository.findAll().map { it.toResponse() }

    @Transactional(readOnly = true)
    fun get(id: Long): Quiz {
        return questionRepository.findByIdOrNull(id) ?: throw NotFoundException("질문이 존재하지 않습니다.")
    }

    @Transactional
    fun delete(id: Long) = questionRepository.deleteById(id)
    fun getRandomList() {

        return
//        questionRepository.findAllRam
    }

    fun edit(id: Long, request: QuizRequest) {
        val quiz = questionRepository.findByIdOrNull(id) ?: throw NotFoundException("질문이 존재하지 않습니다.")
//        (quiz){
//            question = request.question,
//            optionA = request.optionA,
//            optionB = request.optionB,
//            answer = request.answer,
//            description = request.description
//            questionRepository.save(this)
//        }
    }
}