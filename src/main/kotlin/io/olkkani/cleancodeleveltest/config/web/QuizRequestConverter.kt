package io.olkkani.cleancodeleveltest.config.web

import io.olkkani.cleancodeleveltest.domain.AnswerOption
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class QuizRequestConverter : Converter<String, AnswerOption>{
    override fun convert(answerOptionCode: String): AnswerOption? {
        return AnswerOption.values().firstOrNull(){it.code == answerOptionCode}
    }

}