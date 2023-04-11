package io.olkkani.cleancodeleveltest.domain

import jakarta.persistence.*

@Entity
@Table
class Question(
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
