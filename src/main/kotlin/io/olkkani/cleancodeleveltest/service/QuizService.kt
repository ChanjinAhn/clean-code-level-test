package io.olkkani.cleancodeleveltest.service

import QuizRequest
import io.olkkani.cleancodeleveltest.config.exception.NotFoundException
import io.olkkani.cleancodeleveltest.domain.*
import org.springframework.data.domain.Pageable
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
            quizType = QuizTypeOption to request.quizType,
            question = request.question,
            optionA = request.optionA,
            optionB = request.optionB,
            correctOption = CorrectOption to request.correctOption,
            answer = request.answer,
            description = request.description,
        )
        quizRepository.save(question)

    }

    @Transactional(readOnly = true)
    fun getAll(pageable: Pageable) = quizRepository.findQuizzesBy(pageable)


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
        quizRepository.findByIdOrNull(id)?.apply{
            quizType = QuizTypeOption to request.quizType
            question = request.question
            optionA = request.optionA
            optionB = request.optionB
            correctOption = CorrectOption to request.correctOption
            answer = request.answer
            description = request.description
        } ?: throw NotFoundException("질문이 존재하지 않습니다.")
    }
}