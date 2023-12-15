import {Quiz} from "./quiz"
import hljs from 'highlight.js/lib/core';
import java from 'highlight.js/lib/languages/java';

hljs.registerLanguage('java', java)

const highlightedCode = hljs.highlight(
    '<span>Hello World!</span>',
    { language: 'xml' }
).value



let score = 0
let quizzes = []
let quizzesIndex = 0

const toggleHideWelcomeSection = () => {}
const toggleHideTestSection = () => {}
const toggleHideResultSection = () => {}

const btnNext = document.getElementById('btn-next')
const btnRetry = document.getElementById('btn-retry')
const option = document.getElementsByName('option')
const btnStart = document.getElementById("btn-start")

window.onload = () => {
    const codeBlock = document.getElementsByTagName('pre code')
    console.log(codeBlock)
}




btnStart.addEventListener("click", () => {
    getRandomQuizzes()
    toggleHideSection("welcome-section")
    toggleHideSection("test-section")
})

btnNext.addEventListener("click", () => {

})

btnRetry.addEventListener("click", () => {
    toggleHideSection("result-section")
    toggleHideSection("welcome-section")
    score = 0
    quizzesIndex = 0
    applyScoreView(score)
})








const toggleHideSection = (sectionId: string) => {
    const element =  document.getElementById(sectionId)
    if(element.style.display === "none") {
        element.style.display = "block"
    } else {
        element.style.display = "none"
    }
}


const applyScoreView = (score: number) => {
    const scoreText = document.getElementById("score")
    const scoreProgress = document.getElementById('score-progress')

    scoreText.textContent = score.toString()
    scoreProgress.style.width = score*10+'%'
}
const getRandomQuizzes = () => {
    fetch('/quizzes/random')
        .then(response => response.json())
        .then(data =>  {
            data.forEach((quiz: { id: number; quizType: string; question: string; optionA: string; optionB: string; correctOption: string; answer: string; description: string }) => {
                quizzes.push(
                    new Quiz(
                        quiz.id,
                        quiz.quizType,
                        quiz.question,
                        quiz.optionA,
                        quiz.optionB,
                        quiz.correctOption,
                        quiz.answer,
                        quiz.description
                    )
                )
            })
        })
}



const toggleQuizView = () => {

}








// document.getElementsByName('option').item().addEventListener('click', (() =>{
//
// }))
// option.addEventListener('click', (e) => {
//     if (e.id === quiz.correctOption){correctScore++}
//
//
// })














function moveRegisterPage(){
    window.location.href = "/register"
}
function moveEditPage(id){
    window.location.href = "/editor/" + id
}


function validateQuizForm() {

}


function moveListPage() {
    location.replace("/list")
}




















// getRandomQuizzes().then(data => {quizzes = data}).catch(e => console.error(e))


// console.log(quizzes)
//
// console.log(quizzes)
// for문을 돌면서 contact[i]의 값을 출력한다.
// for (var i = 0; i < quizzes.length; i++) {
//     console.log("11")
//     console.log(quizzes[i]);
// }
//







function onEvent(){
    const container = document.querySelectorAll(".container")

    // container.addEventListener("click", (e) => {
    //     e.target.classList.toggle("active")
    // })
    // container.addEventListener("click", (e) => {
    //     console.log("click")
    // })


}

// window.addEventListener('DOMContentLoaded', onEvent())