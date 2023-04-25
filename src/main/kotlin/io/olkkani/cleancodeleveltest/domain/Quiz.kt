package io.olkkani.cleancodeleveltest.domain

import javax.persistence.*


@Entity
@Table
data class Quiz(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var question: String,
    @Column
    var optionA: String,
    @Column
    var optionB: String,
    @Column
    var answer: String,
    @Column
    var description: String
)
//) : BaseEntity()
