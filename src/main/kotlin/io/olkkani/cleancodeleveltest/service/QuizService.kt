package io.olkkani.cleancodeleveltest.service

import io.olkkani.cleancodeleveltest.config.exception.NotFoundException
import io.olkkani.cleancodeleveltest.domain.Quiz
import io.olkkani.cleancodeleveltest.domain.QuizRepository
import io.olkkani.cleancodeleveltest.domain.QuizRepositorySupport
import io.olkkani.cleancodeleveltest.model.QuizRequest
import io.olkkani.cleancodeleveltest.model.toResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QuizService(
    private val quizRepository: QuizRepository,
    private val quizRepositorySupport: QuizRepositorySupport
) {


    @Transactional
    fun create(request: QuizRequest) {
        val question = Quiz(
            question = request.question,
            optionA = request.optionA,
            optionB = request.optionB,
            answer = request.answer,
            description = request.description
        )
        quizRepository.save(question)

    }

    @Transactional(readOnly = true)
    fun getAll() =
        quizRepository.findAll().map { it.toResponse() }

//    @Transactional(readOnly = true)
//    fun getList(): MutableList<Quiz> {
//        return quizRepository.findAll()
//    }

    @Transactional(readOnly = true)
    fun get(id: Long): Quiz {
        return quizRepository.findByIdOrNull(id) ?: throw NotFoundException("질문이 존재하지 않습니다.")
    }

    @Transactional
    fun delete(id: Long) = quizRepository.deleteById(id)

    @Transactional(readOnly = true)
    fun getRandomList(): List<Quiz>? = quizRepositorySupport.getRandomQuiz()

    @Transactional
    fun edit(id: Long, request: QuizRequest) {
//        val quiz = quizRepository.findByIdOrNull(id)?: throw NotFoundException("질문이 존재하지 않습니다.")
//
//        quiz.apply {
//            question = request.question
//            optionA = request.optionA
//            optionB = request.optionB
//            answer = request.answer
//            description = request.description
//        }
//
        quizRepository.findByIdOrNull(id)?.run{
                question = request.question
                optionA = request.optionA
                optionB = request.optionB
                answer = request.answer
                description = request.description
            } ?: throw NotFoundException("질문이 존재하지 않습니다.")
    }
}