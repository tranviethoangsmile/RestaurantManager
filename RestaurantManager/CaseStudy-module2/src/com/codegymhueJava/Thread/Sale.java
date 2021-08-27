package com.codegymhueJava.Thread;

import com.codegymhueJava.readFile.ReadFileAds;

import java.io.FileNotFoundException;
import java.util.List;

public class Sale extends Thread {
//    đọc file ads
    static ReadFileAds readFileAds = new ReadFileAds();

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    List<String> sale = readFileAds.readFileAds();
    int leng = sale.size();

    public Sale() throws FileNotFoundException {
    }

    @Override
    public void run() {
        for(int i = 0; i < leng; i++) {
            System.out.print(ANSI_CYAN  + sale.get(i) + " " + ANSI_RESET);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
