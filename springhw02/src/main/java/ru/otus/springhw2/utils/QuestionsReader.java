package ru.otus.springhw2.utils;

import org.springframework.stereotype.Service;
import ru.otus.springhw2.exception.QuestionsReaderException;
import ru.otus.springhw2.domain.Answer;
import ru.otus.springhw2.domain.Question;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class QuestionsReader implements IQuestionsReader {
    private static String resourceName;


    public QuestionsReader(String resourceName) {
        this.resourceName = resourceName;
    }

    public List<Question> read() throws QuestionsReaderException {
        InputStream inputStream = QuestionsReader.class.getResourceAsStream(resourceName);
        Scanner mainScanner = new Scanner(inputStream);
        List<Question> questions = new ArrayList<Question>();
        while (mainScanner.hasNextLine()) {
            Scanner valueScanner = new Scanner(mainScanner.nextLine());
            valueScanner.useDelimiter(";");
            int id = 0;
            Question question = new Question();
            while (valueScanner.hasNext()) {
                String data = valueScanner.next();
                if (id == 0) {
                    question.setQuestionText(fetchQuestionText(data));
                } else {
                    question.addAnswer(fetchAnswer(data, id));
                }
                id++;

            }
            if (question.getQuestionText() != null && !question.getQuestionText().isEmpty() && question.getAnswers().size() > 0)
                questions.add(question);
            else throw new QuestionsReaderException("Incorrect format of the question.");
        }
        return questions;

    }


    private String fetchQuestionText(String data) throws QuestionsReaderException {
        if (!(data.startsWith("Q[") && data.endsWith("]")))
            throw new QuestionsReaderException("Incorrect format of the question.");

        String question = data.substring(2, data.length() - 1);
        return question;

    }

    private Answer fetchAnswer(String data, int id) throws QuestionsReaderException {
        if (!(data.startsWith("A[") && data.endsWith("]")))
            throw new QuestionsReaderException("Incorrect format of the answer.");
        String ansStr = data.substring(2, data.length() - 1);
        Answer answer = new Answer();
        answer.setId(id);
        String parts[] = ansStr.split(",");
        if (parts.length == 2 && parts[0] != null && !parts[0].isEmpty()) {
            answer.setAnswerText(parts[0]);
            answer.setCorrect(Boolean.parseBoolean(parts[1]));
        } else {
            new QuestionsReaderException("Incorrect arguments in the answer.");
        }
        return answer;
    }
}
