package io.olkkani.cleancodeleveltest.config.web

import io.olkkani.cleancodeleveltest.domain.CorrectOption
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class QuizRequestConverter : Converter<String, CorrectOption>{
    override fun convert(answerOptionCode: String): CorrectOption? {
        return CorrectOption.values().firstOrNull(){it.code == answerOptionCode}
    }

}