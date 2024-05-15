import {Quiz} from "./quiz.js"

let score = 0
let countQuizProgress = 1
let quizzes = []
let quiz

const btnDecideQuiz = document.getElementById('btn-decide')
const btnNextQuiz = document.getElementById('btn-next')
const btnRetry = document.getElementById('btn-retry')
const btnStart = document.getElementById("btn-start")

const getSelectedRatioValue = (name) => {
    const radios = document.getElementsByName(name)
    for (const radio of radios) {
        if (radio.checked) {
            return radio.value;
        }
    }
    return null;
}

const toggleHideSection = (sectionId) => {
    const element = document.getElementById(sectionId)
    if (element.style.display === "none") {
        element.style.display = "block"
    } else {
        element.style.display = "none"
    }
}

const getRandomQuizzes = async () => {
    try {
        const response = await fetch('/quizzes/random');
        return await response.json();
    } catch (error) {
        console.error(error);
        throw error;
    }
}
const scoringQuiz = (choseOption, correctOption) => {
    if (choseOption === correctOption) {
        score++
    }
    countQuizProgress++
}
const applyQuizProgress = (countQuizProgress) => {
    const quizCountText = document.getElementById("quiz-count")
    const quizProgress = document.getElementById('quiz-progress')

    quizCountText.textContent = countQuizProgress.toString()
    quizProgress.style.width = countQuizProgress * 10 + '%'
}
const applyTestContent = (quiz) => {
    const question = document.getElementById("question")
    const optionACode = document.getElementById("option-a-code")
    const optionA = document.getElementById("option1")
    const optionBCode = document.getElementById("option-b-code")
    optionA.checked = true
    question.textContent = quiz.question
    optionACode.textContent = quiz.optionA
    optionBCode.textContent = quiz.optionB
}
const applyAnswerContent = (quiz) => {
    const answer = document.getElementById("answer")
    const description = document.getElementById("description")

    answer.textContent = quiz.answer
    description.textContent = quiz.description
}
const applyResultContent = (score) => {
    const resultScore = document.getElementById("result-score")
    const resultComment = document.getElementById("result-comment")
    const resultComments = [
        "아직 부족해요",
        "1",
        "2",
        "3",
        "완벽해요"
    ]
    resultComment.innerText = resultComments[Math.ceil(score / 3)] // 점수에 따른 4등급 분류
    resultScore.innerText = score.toString()
}


btnStart.addEventListener("click", () => {
    getRandomQuizzes()
        .then(data => {
            let quizzesArray = []
            data.forEach(quiz => {
                quizzesArray.push(
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
            quizzes = quizzesArray.values()
        })
        .then(() => {
            quiz = quizzes.next().value
            applyQuizProgress(countQuizProgress)
            applyTestContent(quiz)
        })
        .then(() => {
            toggleHideSection("welcome")
            toggleHideSection("level-test")
        })
})

btnDecideQuiz.addEventListener("click", () => {
    const choseOption = getSelectedRatioValue("option")
    scoringQuiz(choseOption, quiz.correctOption)
    applyAnswerContent(quiz)
    toggleHideSection("quiz")
    toggleHideSection("description-answer")
})

btnNextQuiz.addEventListener("click", () => {
    if (countQuizProgress > 10) { // 문제 개수
        applyResultContent(score)
        toggleHideSection("level-test")
        toggleHideSection("result")
    } else {
        quiz = quizzes.next().value
        applyTestContent(quiz)
        applyQuizProgress(countQuizProgress)
        toggleHideSection("description-answer")
        toggleHideSection("quiz")
    }
})


btnRetry.addEventListener("click", () => {
    score = 0
    countQuizProgress = 1

    toggleHideSection("result")
    toggleHideSection("welcome")
    toggleHideSection("quiz")
    toggleHideSection("description-answer")
})


// document.getElementsByName('option').item().addEventListener('click', (() =>{
//
// }))
// option.addEventListener('click', (e) => {
//     if (e.id === quiz.correctOption){correctScore++}
//
//
// })


function validateQuizForm() {

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


function onEvent() {
    const container = document.querySelectorAll(".container")

    // container.addEventListener("click", (e) => {
    //     e.target.classList.toggle("active")
    // })
    // container.addEventListener("click", (e) => {
    //     console.log("click")
    // })


}

// window.addEventListener('DOMContentLoaded', onEvent())