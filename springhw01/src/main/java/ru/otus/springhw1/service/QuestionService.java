package ru.otus.springhw1.service;

import ru.otus.springhw1.domain.Answer;
import ru.otus.springhw1.domain.Question;
import ru.otus.springhw1.exception.QuestionsReaderException;
import ru.otus.springhw1.service.IQuestionService;
import ru.otus.springhw1.utils.IQuestionsReader;

import java.util.List;
import java.util.Scanner;

public class QuestionService implements IQuestionService {
    IQuestionsReader reader;
    ICommonIOService io;
    private List<Question> questions;
    private int amountOfCorrectAnswers;

    public QuestionService(IQuestionsReader reader, ICommonIOService io) throws QuestionsReaderException {
        questions = reader.read();
        this.io = io;
        amountOfCorrectAnswers=0;
    }
    @Override
    public void askQuestions() {
        for (Question q : questions) {
            io.writeString(q.getQuestionText());
            for (Answer a : q.getAnswers()) {
                io.writeString(a.getId() + ". " + a.getAnswerText());
            }
            io.writeString("please enter answer id and press enter:");
            int i = 0;
            try {
                i = Integer.parseInt(io.readString());
            }catch ( NumberFormatException e){
                i = -1;
            }
            for (Answer a : q.getAnswers()) {
                if ((a.getId() == i)&&a.getIsCorrect()) {
                    amountOfCorrectAnswers++;
                    break;
                }
            }
        }
    }

    @Override
    public int getAmountQuestions() {
        return questions.size();
    }

    @Override
    public int getAmoutOfCorrectAnswers() {
        return amountOfCorrectAnswers;
    }

    @Override
    public void showResult() {
        io.writeString("You answered "+amountOfCorrectAnswers+" out of "+questions.size()+"questions!");
    }
}
