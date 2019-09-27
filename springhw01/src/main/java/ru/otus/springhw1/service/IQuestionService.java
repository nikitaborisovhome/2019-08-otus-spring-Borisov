package ru.otus.springhw1.service;

import ru.otus.springhw1.domain.Question;

public interface IQuestionService {

    void askQuestions();
    int getAmoutOfCorrectAnswers();
    int getAmountQuestions();
    void showResult();

}
