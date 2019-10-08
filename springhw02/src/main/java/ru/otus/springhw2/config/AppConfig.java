package ru.otus.springhw2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.springhw2.service.*;
import ru.otus.springhw2.utils.CustomLocaleManager;
import ru.otus.springhw2.utils.ICustomLocaleManager;
import ru.otus.springhw2.utils.IQuestionsReader;
import ru.otus.springhw2.utils.QuestionsReader;

import java.util.Locale;

@Configuration
@PropertySource("classpath:app.properties")
public class AppConfig {

    @Bean
    public IQuestionsReader questionsReader(@Value("${file.prefix}") String filePrefix, @Value("${default.locale}") String defaultLocale){
        return new QuestionsReader(filePrefix+"_"+defaultLocale+".csv");
    }

    @Bean
    public ICustomLocaleManager localeManager(@Value("${default.locale}") String defaultLocale,ICommonIOService io,MessageSource messageSource){
        if("ru".equals(defaultLocale))
             return new CustomLocaleManager(new Locale("ru","RU"),messageSource,io);
        else
            return new CustomLocaleManager(Locale.ENGLISH,messageSource,io);
    }


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms
                = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public ICommonIOService io(){
        return new CommonIOService(System.in,System.out);
    }


}
