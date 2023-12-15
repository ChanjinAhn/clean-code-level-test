export class Quiz {
    id: number;
    quizType: string;
    question: string;
    optionA: string;
    optionB: string;
    correctOption: string;
    answer: string;
    description: string;

    // 생성자
    constructor(
        id: number,
        quizType: string,
        question: string,
        optionA: string,
        optionB: string,
        correctOption: string,
        answer: string,
        description: string,
    ) {
        this.id = id;
        this.quizType = quizType;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.correctOption = correctOption;
        this.answer = answer;
        this.description = description;
    }
}