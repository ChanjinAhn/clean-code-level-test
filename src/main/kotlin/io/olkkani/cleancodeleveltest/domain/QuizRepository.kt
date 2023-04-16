package io.olkkani.cleancodeleveltest.domain

import org.springframework.data.jpa.repository.JpaRepository

interface QuizRepository : JpaRepository<Quiz, Long>{

}