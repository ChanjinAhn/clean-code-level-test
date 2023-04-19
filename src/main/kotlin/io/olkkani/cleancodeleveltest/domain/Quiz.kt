package io.olkkani.cleancodeleveltest.domain

import javax.persistence.*


@Entity
@Table
class Quiz(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val question: String,
    @Column
    val optionA: String,
    @Column
    val optionB: String,
    @Column
    val answer: AnswerOption,
    @Column
    val description: String
) : BaseEntity()
