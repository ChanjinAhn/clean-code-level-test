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
    @Column
    var answer: AnswerOption,
    @Column
    var description: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) : BaseEntity()


enum class AnswerOption {
    A,B
}
