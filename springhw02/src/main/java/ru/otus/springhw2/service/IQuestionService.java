package ru.otus.springhw2.service;

public interface IQuestionService {

    void askQuestions();
    int getAmoutOfCorrectAnswers();
    int getAmountQuestions();
    void showResult();

}
