package com.codegymhueJava.main;

import com.codegymhueJava.working.GoHome;
import com.codegymhueJava.Thread.ThreadWelcome;

import java.io.FileNotFoundException;

public class Main {
    static ThreadWelcome threadWelcome;

    static {
        try {
            threadWelcome = new ThreadWelcome();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static GoHome function = new GoHome();







    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
//        chạy dòng welcome
    threadWelcome.start();
    threadWelcome.join();
    function.begin();


    }

}
