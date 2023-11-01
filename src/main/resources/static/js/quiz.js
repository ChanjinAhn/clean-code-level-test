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