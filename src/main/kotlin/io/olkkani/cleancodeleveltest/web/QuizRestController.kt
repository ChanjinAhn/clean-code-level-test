package io.olkkani.cleancodeleveltest.web

import io.olkkani.cleancodeleveltest.model.QuizRequest
import io.olkkani.cleancodeleveltest.model.toResponse
import io.olkkani.cleancodeleveltest.service.QuizService
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/quizzes/")
class QuizRestController(
    private val quizService: QuizService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @RequestBody request: QuizRequest
    ) {
        quizService.create(request)
    }

    @GetMapping
    fun getAll(
        @RequestBody pageable: Pageable
    ) = quizService.getAll(pageable).map { it.toResponse() }

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ) = quizService.get(id).toResponse()


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun edit (
        @PathVariable id: Long,
        @RequestBody request: QuizRequest
    ) {
        quizService.edit(id, request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable id: Long
    ) {
        quizService.delete(id)
    }
}