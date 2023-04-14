package io.olkkani.cleancodeleveltest.domain

import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository : JpaRepository<Question, Long>{

}