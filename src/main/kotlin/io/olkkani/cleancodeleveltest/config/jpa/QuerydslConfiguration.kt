package io.olkkani.cleancodeleveltest.config.jpa

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Configuration
class QuerydslConfiguration (
    @PersistenceContext
    private val entityManager: EntityManager
) {

//    @PersistenceContext
//    lateinit var entityManager: EntityManager
    @Bean
    fun jpaQueryFactory(): JPAQueryFactory = JPAQueryFactory(entityManager)
    }
