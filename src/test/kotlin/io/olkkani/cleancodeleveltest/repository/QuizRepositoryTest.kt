package io.olkkani.cleancodeleveltest.repository

import io.olkkani.cleancodeleveltest.domain.AnswerOption
import io.olkkani.cleancodeleveltest.domain.Quiz
import io.olkkani.cleancodeleveltest.domain.QuizRepository
import io.olkkani.cleancodeleveltest.domain.QuizRepositorySupport
import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional

private val logger = KotlinLogging.logger {}

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class QuizRepositoryTest(
    @Autowired private val quizRepository: QuizRepository,
    @Autowired private val quizRepositorySupport: QuizRepositorySupport
) {

    @DisplayName("Quiz 생성 테스트")
    @Test
    fun createQuizTest() {
        // given
        val quiz = Quiz(
            question = "test question",
            answer = "123",
            optionA = "test optionA",
            optionB = "test optionB",
            description = "test description"
        )
        // when
        val savedQuiz = quizRepository.save(quiz)

        // then
        assertThat(quiz.question).isEqualTo(savedQuiz.question)

    }


    @DisplayName("Quiz 랜덤 항목 조회 테스트")
    @Test
    @Disabled
    fun getRandomQuizTest() {

    }

    @Test
    fun editQuizTest() {
        // given
        val quiz = Quiz(
            question = "최초 질문",
            answer = "123",
            optionA = "test optionA",
            optionB = "test optionB",
            description = "test description"
        )
        val savedQuiz = quizRepository.save(quiz)

        //when
        val editedQuiz =
            quizRepository.save(
                Quiz(
                    question = "변경된 질문",
                    answer = savedQuiz.answer,
                    optionA = savedQuiz.optionA,
                    optionB = savedQuiz.optionB,
                    description = savedQuiz.description
                )
            )

//         than
        assertThat(savedQuiz.id).isEqualTo(editedQuiz.id)
        assertThat(savedQuiz.question).isNotEqualTo(editedQuiz.question)
    }


}