package ru.otus.springhw2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.springhw2.exception.QuestionsReaderException;
import ru.otus.springhw2.exception.RegistrationServiceException;
import ru.otus.springhw2.service.ICommonIOService;
import ru.otus.springhw2.service.IQuestionnaireExecutor;


/**
 * Homework 02
 *
 */
@ComponentScan
public class App {
    public static void main( String[] args ) {
      //  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(App.class);
        context.refresh();
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
