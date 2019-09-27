package ru.otus.springhw1.utils;

import ru.otus.springhw1.exception.QuestionsReaderException;
import ru.otus.springhw1.domain.Question;

import java.util.List;

public interface IQuestionsReader  {
     List<Question> read()  throws QuestionsReaderException;
}
