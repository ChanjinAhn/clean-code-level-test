package io.olkkani.cleancodeleveltest.web

import QuizRequest
import io.olkkani.cleancodeleveltest.service.QuizService
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import toPaginationResponse
import toResponse

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
        @RequestParam(defaultValue = "10") perPage : Int,
        @RequestParam(defaultValue = "0") page : Int
    ) = quizService.getAll(PageRequest.of(page-1,perPage)).toPaginationResponse()

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ) = quizService.get(id).toResponse()

    @GetMapping("/random")
    fun getRandomQuizzes() = quizService.getRandomList()?.map { it.toResponse() }

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