package ru.otus.springhw2.utils;


import org.springframework.context.MessageSource;
import ru.otus.springhw2.service.ICommonIOService;

import java.util.Locale;


public class CustomLocaleManager implements ICustomLocaleManager{

    private final Locale locale;
    private final MessageSource messageSource;
    private final  ICommonIOService io;

    public CustomLocaleManager(Locale locale, MessageSource messageSource, ICommonIOService io){
        this.locale = locale;
        this.messageSource = messageSource;
        this.io = io;
    }

    public Locale getAppLocale(){
        return this.locale;
    }

    public void askName(){
        io.writeString(messageSource.getMessage("common.getname",null,this.locale) );
    }

    public void askSureName(){
        io.writeString(messageSource.getMessage("common.getlastname",null,this.locale) );
    }

    public void sayWelcome(String[] args){
        io.writeString(messageSource.getMessage("common.welcome",args,this.locale) );
    }

    public void askEnter(){
        io.writeString(messageSource.getMessage("common.enter",null,this.locale) );
    }

    public void sayResults(String[] args){
        io.writeString(messageSource.getMessage("common.result",args,this.locale) );
    }


}
