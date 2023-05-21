package io.olkkani.cleancodeleveltest.domain

import javax.persistence.*


@Entity
@Table
class Quiz(

    @Column
    var question: String,
    @Column
    var optionA: String,
    @Column
    var optionB: String,
    @Convert(converter = AnswerOptionConverter::class)
    @Column
    var answer: AnswerOption,
    @Column
    var description: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) : BaseEntity()


enum class AnswerOption(var code: String, var value: Long) {
    OPTION_A("A",0),
    OPTION_B("B",1);

    companion object {
        infix fun from(value: Long?): AnswerOption? = AnswerOption.values().firstOrNull { it.value == value }
    }
}

@Converter
class AnswerOptionConverter : AttributeConverter<AnswerOption, Long> {
    override fun convertToDatabaseColumn(answerOption: AnswerOption): Long {
        return answerOption.value
    }
    override fun convertToEntityAttribute(dbData: Long): AnswerOption? {
        return AnswerOption from dbData
    }
}