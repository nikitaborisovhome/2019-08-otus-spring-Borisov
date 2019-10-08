package ru.otus.springhw2.utils;

import ru.otus.springhw2.exception.QuestionsReaderException;
import ru.otus.springhw2.domain.Question;

import java.util.List;

public interface IQuestionsReader  {
     List<Question> read()  throws QuestionsReaderException;
}
