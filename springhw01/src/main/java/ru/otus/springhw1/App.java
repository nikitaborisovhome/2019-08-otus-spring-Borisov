package ru.otus.springhw1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.springhw1.exception.QuestionsReaderException;
import ru.otus.springhw1.exception.RegistrationServiceException;
import ru.otus.springhw1.service.ICommonIOService;
import ru.otus.springhw1.service.IQuestionnaireExecutor;


/**
 * Homework 01
 *
 */
public class App {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        ICommonIOService ioService = context.getBean(ICommonIOService.class);
        try{
            IQuestionnaireExecutor executor = context.getBean(IQuestionnaireExecutor.class);
            executor.run();
        }catch (RegistrationServiceException e){
            ioService.writeString(e.getMessage());
        }catch (QuestionsReaderException e){
            ioService.writeString(e.getMessage());
        }

    }
}
