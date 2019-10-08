package ru.otus.springhw1.service;

import ru.otus.springhw1.exception.QuestionsReaderException;
import ru.otus.springhw1.exception.RegistrationServiceException;

public interface IQuestionnaireExecutor   {
    void run() throws RegistrationServiceException,QuestionsReaderException;
}
