package ru.otus.springhw1.service;

import java.util.Scanner;

public class CommonIOService implements ICommonIOService {

    private Scanner sc;

    public CommonIOService(){
        sc = new Scanner(System.in);
    }

    public String readString(){
        return sc.nextLine();
    }
    

    public void writeString(String str){
        System.out.println(str);
    }
}
