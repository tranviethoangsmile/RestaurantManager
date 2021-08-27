package com.codegymhueJava.Thread;

import com.codegymhueJava.readFile.ReadFileAds;

import java.io.FileNotFoundException;
import java.util.List;

public class ThreadWelcome extends Thread{
    public static final String ANSI_YELLOW = "\u001B[33m";
    static ReadFileAds readFileAds = new ReadFileAds();

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    List<String> sale = readFileAds.readFileAds();
    int leng = sale.size();

    public ThreadWelcome() throws FileNotFoundException {
    }

    @Override
            public void run() {
                for(int i = 0; i < leng; i++) {
                    System.out.print(ANSI_YELLOW  + sale.get(i) + " " + ANSI_RESET);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
}
