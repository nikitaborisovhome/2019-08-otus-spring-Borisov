package ru.otus.springhw2.utils;

import java.util.Locale;

public interface ICustomLocaleManager {

    Locale getAppLocale();

    void askName();
    void askSureName();
    void sayWelcome(String[] arg);
    void askEnter();
    void sayResults(String[] arg);

}
