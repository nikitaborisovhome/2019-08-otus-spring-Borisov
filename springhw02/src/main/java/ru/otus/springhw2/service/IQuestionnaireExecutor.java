package ru.otus.springhw2.service;

import ru.otus.springhw2.exception.QuestionsReaderException;
import ru.otus.springhw2.exception.RegistrationServiceException;

public interface IQuestionnaireExecutor   {
    void run() throws RegistrationServiceException,QuestionsReaderException;
}
