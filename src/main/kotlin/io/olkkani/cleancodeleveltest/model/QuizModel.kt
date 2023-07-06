
import io.olkkani.cleancodeleveltest.config.exception.IllegalArgumentException
import io.olkkani.cleancodeleveltest.domain.AnswerOption
import io.olkkani.cleancodeleveltest.domain.Quiz
import org.springframework.data.domain.Page

data class QuizRequest(
    val quizType: String,
    val question: String,
    val optionA: String,
    val optionB: String,
    val description: String,
    val answer: String,
)

data class QuizResponse(
    val id: Long,
    val quizType: String,
    val question: String,
    val optionA: String,
    val optionB: String,
    val answer: String,
    val description: String,
)

fun Quiz.toResponse() = QuizResponse(
    id = id!!,
    quizType = quizType.code,
    question = question,
    optionA = optionA,
    optionB = optionB,
    answer = answer.code,
    description = description
)

fun Page<Quiz>.toPaginationResponse(): Map<String, Any> {
    val totalCount = this.totalElements
    val content = this.content.map { it.toResponse() }
    val page = this.number

    return mutableMapOf<String, Any>().apply {
        put("result", true)
        put("data", mapOf<String, Any>(
            "contents" to content,
            "pagination" to mapOf<String, Any>(
                "page" to page+1,
                "totalCount" to totalCount,
            )
        ))
    }
}