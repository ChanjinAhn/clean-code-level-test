package io.olkkani.cleancodeleveltest.domain

import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


interface QuizRepository : JpaRepository<Quiz, Long>{

    fun findQuizzesBy(pageable: Pageable) : Slice<Quiz>
}