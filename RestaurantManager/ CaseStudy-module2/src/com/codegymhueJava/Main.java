package com.codegymhueJava;

import com.codegymhueJava.Functions.Function;
import com.codegymhueJava.Thread.ThreadWelcome;

import java.io.FileNotFoundException;

public class Main {
    static ThreadWelcome threadWelcome = new ThreadWelcome();
    static Function function = new Function();







    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
//        chạy dòng welcome
    threadWelcome.start();
    threadWelcome.join();
    function.begin();


    }

}
