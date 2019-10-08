package ru.otus.springhw2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.springhw2.domain.Person;
import ru.otus.springhw2.exception.RegistrationServiceException;
import ru.otus.springhw2.utils.ICustomLocaleManager;

@Service
public class QuestionnaireExecutor implements IQuestionnaireExecutor {
    private final IQuestionService questionService;
    private final IRegistrationService registrationService;
    private final ICustomLocaleManager localeManager;

    @Autowired
    public QuestionnaireExecutor(IQuestionService questionService, IRegistrationService registrationService, ICustomLocaleManager localeManager){
        this.questionService = questionService;
        this.registrationService = registrationService;
        this.localeManager = localeManager;
    }

    public void run() throws RegistrationServiceException {
        Person person = registrationService.registerNewPerson();
        localeManager.sayWelcome(new String[]{person.getFirstName(),person.getLastName()});
        questionService.askQuestions();
        questionService.showResult();
    }
}
