class Quizzes {
    quizIndex = 0
    correctScore = 0

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

Quizzes.quiz = class {
    id
    quizType
    question
    optionA
    optionB
    answer

    description
}

class quiz {}



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
    quizzes = new Quizzes(getRandomQuizzes().then(data => {return data}).catch(e => console.error(e)))
    getRandomQuizzes().then(data => {quizzes =  JSON.parse(data)}).catch(e => console.error(e))


    console.log(quizzes)


    //for문을 돌면서 contact[i]의 값을 출력한다.
    for (var i = 0; i < quizzes.length; i++) {
        console.log(quizzes[i]);
    }



})()





