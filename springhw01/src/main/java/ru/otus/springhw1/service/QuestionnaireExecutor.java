package ru.otus.springhw1.service;

import ru.otus.springhw1.domain.Person;
import ru.otus.springhw1.exception.QuestionsReaderException;
import ru.otus.springhw1.exception.RegistrationServiceException;

public class QuestionnaireExecutor implements IQuestionnaireExecutor {
    IQuestionService questionService;
    IRegistrationService registrationService;
    ICommonIOService io;

    public QuestionnaireExecutor(IQuestionService questionService,IRegistrationService registrationService, ICommonIOService io){
        this.questionService = questionService;
        this.registrationService=registrationService;
        this.io=io;
    }

    public void run() throws RegistrationServiceException {
            Person person = registrationService.registerNewPerson();
            io.writeString("Welcome "+person.getFirstName() + " "+person.getLastName()+"! Lets get started!" );
            questionService.askQuestions();
            questionService.showResult();
            //estimation
            double c = questionService.getAmoutOfCorrectAnswers() / questionService.getAmountQuestions();
            if (c > 0.6)
                io.writeString(person.getFirstName() + " you are so smart!");
            else io.writeString(person.getFirstName()+ " perhaps you need to read more wikipedia");


    }
}
