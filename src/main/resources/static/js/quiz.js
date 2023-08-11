class Quizzes {


    constructor() {
    }
    increaseCorrectProblemCount () {
        this.correctScore++
    }

    getCorrectScore () {
        return this.correctScore
    }
    getNextQuizzes() {
        this.quizzes[this.quizIndex++]
    }



}

class Quiz{
    id
    quizType
    question
    optionA
    optionB
    correctOption
    answer
    description

    constructor(quiz) {
        this.id = quiz.id
        this.quizType = quiz.quizType
        this.question = quiz.question
        this.optionA = quiz.optionA
        this.optionB = quiz.optionB
        this.correctOption = quiz.correctOption
        this.answer = quiz.answer
        this.description = quiz.description
    }
}
let quizIndex = 0
let correctScore = 0
let quiz


const btnStart = document.getElementById("btn-start")
const btnNext = document.getElementById('btn-next')
const btnRetry = document.getElementById('btn-retry')

const option = document.getElementsByName('option')
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



const getRandomQuizzes = () => {
    return new Promise((resolve, reject) => {
        $.ajax({
            type: 'GET',
            url: '/quizzes/random',
            dataType: 'json',
        }).done((data) => resolve(data)
        ).fail((xhr, status, error) => reject(error)
        )
    })
}


let quizzes
( function (){
    // quizzes = new Quizzes(getRandomQuizzes().then(data => {return data}).catch(e => console.error(e)))
    getRandomQuizzes().then(data => {quizzes = data}).catch(e => console.error(e))


    // console.log(quizzes)
    //
    // console.log(quizzes)
    // for문을 돌면서 contact[i]의 값을 출력한다.
    // for (var i = 0; i < quizzes.length; i++) {
    //     console.log("11")
    //     console.log(quizzes[i]);
    // }
//


})()



btnStart.addEventListener("click", () => {
     quiz = new Quiz(quizzes[quizIndex++])



})
// document.getElementsByName('option').item().addEventListener('click', (() =>{
//
// }))
// option.addEventListener('click', (e) => {
//     if (e.id === quiz.correctOption){correctScore++}
//
//
// })

