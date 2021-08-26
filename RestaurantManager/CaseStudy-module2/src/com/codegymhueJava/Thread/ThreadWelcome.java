package com.codegymhueJava.Thread;

public class ThreadWelcome extends Thread{
    public static final String ANSI_YELLOW = "\u001B[33m";
            String [] wc = {"w","e","l","c","o","m","e"," ","t","o"," ","C","a","s","e","S","t","u","d","y"," ","M","o","d","u","l","e"," 2"," b","y ","H","o","a","n","g",".T","r","a","n"};
            int leng = wc.length;
            @Override
            public void run() {
                for(int i = 0; i < leng; i++) {
                    System.out.print(ANSI_YELLOW  + wc[i]);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
}
