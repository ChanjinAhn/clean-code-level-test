package io.olkkani.cleancodeleveltest.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository


interface QuizRepository : JpaRepository<Quiz, Long>{

    fun findQuizzesBy(pageable: Pageable): Page<Quiz>
}