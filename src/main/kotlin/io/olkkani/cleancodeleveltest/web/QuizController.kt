package io.olkkani.cleancodeleveltest.web

import io.olkkani.cleancodeleveltest.model.toResponse
import io.olkkani.cleancodeleveltest.service.QuizService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Controller
class QuizController (
    private val quizService: QuizService
){

    @GetMapping
    fun list (

    ) = "list"

    @GetMapping
    fun register (

    ) = "register"


    @GetMapping
    fun editor (
       id: Long,

        @ModelAttribute modelAttribute: ModelAttribute
    ): String {
        val quiz = quizService.get(id).toResponse()
//        modelAttribute.
        return "editor"
    }

    @GetMapping
    fun quiz () = "quiz"

    @PostMapping
    fun result () = "result"
}