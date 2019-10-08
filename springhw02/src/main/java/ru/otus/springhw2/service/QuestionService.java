package ru.otus.springhw2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.springhw2.domain.Answer;
import ru.otus.springhw2.domain.Question;
import ru.otus.springhw2.exception.QuestionsReaderException;
import ru.otus.springhw2.utils.ICustomLocaleManager;
import ru.otus.springhw2.utils.IQuestionsReader;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {
    private final  ICommonIOService io;
    private List<Question> questions;
    private int amountOfCorrectAnswers;
    private final ICustomLocaleManager localeManager;

    @Autowired
    public QuestionService(IQuestionsReader reader, ICommonIOService io,ICustomLocaleManager localeManager) throws QuestionsReaderException {
        questions = reader.read();
        this.io = io;
        amountOfCorrectAnswers=0;
        this.localeManager = localeManager;
    }
    @Override
    public void askQuestions() {
        for (Question q : questions) {
            io.writeString(q.getQuestionText());
            for (Answer a : q.getAnswers()) {
                io.writeString(a.getId() + ". " + a.getAnswerText());
            }
            localeManager.askEnter();
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
        localeManager.sayResults(new String[]{String.valueOf(amountOfCorrectAnswers),String.valueOf(questions.size())});
        double c = getAmoutOfCorrectAnswers() / getAmountQuestions();
    }
}
