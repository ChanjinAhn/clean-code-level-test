package io.olkkani.cleancodeleveltest.web

import io.olkkani.cleancodeleveltest.model.toResponse
import io.olkkani.cleancodeleveltest.service.QuestionService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/questions/")
class QuestionController (
    private val questionService: QuestionService
){

    @PostMapping
    fun create (
//        @RequestBody request: QuestionRequest
    ){
//        questionService.create(request)
    }

    @GetMapping
    fun getAll (

    ) = questionService.getAll()

    @GetMapping("/{id}")
    fun get (
        @PathVariable id: Long
    ) = questionService.get(id).toResponse()
}