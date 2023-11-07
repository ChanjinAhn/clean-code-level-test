// import hljs from 'highlight.js'
// import java from 'highlight.js/lib/languages/java';
// hljs.registerLanguage('java', java);
// document.addEventListener('DOMContentLoaded', () => {
//     document.querySelectorAll('pre code').forEach((block) => {
//         hljs.highlightBlock(block);
//     });
// });

let score = 0
let quizzes = []
let quizzesIndex = 0
const applyScoreView = (score) => {
    const scoreText = document.getElementById("score")
    const scoreProgress = document.getElementById('score-progress')

   scoreText.textContent = score
   scoreProgress.style.width = score*10+'%'
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

const btnStart = document.getElementById("btn-start")

const toggleQuizView = () => {

}


btnStart.addEventListener("click", () => {


})


// document.getElementsByName('option').item().addEventListener('click', (() =>{
//
// }))
// option.addEventListener('click', (e) => {
//     if (e.id === quiz.correctOption){correctScore++}
//
//
// })





getRandomQuizzes().then(data => {
    data.forEach((item) => {
        quizzes.push(new Quiz(item))
    })
}).catch(e => console.error(e))




function test() {
    applyScoreView(++score)
}














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