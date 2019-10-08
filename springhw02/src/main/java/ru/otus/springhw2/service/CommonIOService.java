package ru.otus.springhw2.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class CommonIOService implements ICommonIOService {

    private Scanner sc;
    private PrintStream out;

    public CommonIOService(InputStream inputStream, PrintStream out){
        sc = new Scanner(inputStream);
        this.out = out;
    }

    public String readString(){
        return sc.nextLine();
    }
    

    public void writeString(String str){
        out.println(str);
    }
}
