package io.olkkani.cleancodeleveltest.web

import QuizRequest
import io.olkkani.cleancodeleveltest.service.QuizService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import toResponse

@Controller
class QuizController (
    private val quizService: QuizService
){

    @GetMapping("/list")
    fun list (
    ) = "pages/list"


    @GetMapping("/register")
    fun register (

    ) = "pages/register"

    @PostMapping("/register")
    fun create (
        @RequestBody quizRequest: QuizRequest
    ): String{
        quizService.create(quizRequest)
        return "redirect:/list"
    }

    @PostMapping("/editor")
    fun editor (
       @RequestParam id: Long,
       model: Model
    ): String {
        val quiz = quizService.get(id).toResponse()
        model.addAttribute( "quiz", quiz)
        return "pages/editor"
    }


    @GetMapping
    fun quiz (
        model : Model
    ) : String{
        val quizzes = quizService.getRandomList()?.map { it.toResponse()}
        model.addAttribute("quizzes", quizzes)
        return "pages/level-test"
    }

    @PostMapping("/result")
    fun result () = "pages/result"
}