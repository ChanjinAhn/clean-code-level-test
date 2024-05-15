// import tui from "tui-grid";
// import Grid = tui.Grid;

const quizAPI = {
    api: {
        readData: {url: '/quizzes/', method: 'GET'}
    },
}

// const grid = new Grid({
//     el: document.getElementById('quizzesList'),
// })

// const grid = tui.Grid({
//     el: document.getElementById('quizzesList'),
//     data: quizAPI,
//     contentType: 'application/json',
//     rowHeaders: ['rowNum'],
//     pageOptions: {
//         perPage: 10
//     },
//     scrollX: false,
//     scrollY: false,
//     columns: [
//         {
//             header: 'id',
//             name: 'id',
//             hidden: true
//         },
//         {
//             header: '질문',
//             name: 'question'
//         },
//         {
//             header: '답',
//             name: 'answer',
//             // maxWidth: 3
//         }
//     ],
//     showDummyRows: true
// });


const moveRegisterPage = () => {
    location.href = '/quiz/register'
}
const moveEditPage = (id) => {
    window.location.href = "/editor/" + id
}
const registerButton = document.getElementById("register_button")
// function getColumnId(el){
//     return grid.getFormattedValue(el.rowKey, 'id')
// }

registerButton.addEventListener('click', function () {
    moveRegisterPage()
})



// grid.on('click', el => {
//     const id = getColumnId(el)
//     if(!id) return null
//
//     moveEditPage(id)
// })
//
