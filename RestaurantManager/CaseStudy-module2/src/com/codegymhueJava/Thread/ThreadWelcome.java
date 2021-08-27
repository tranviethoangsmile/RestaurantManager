package com.codegymhueJava.Thread;

public class ThreadWelcome extends Thread{
    public static final String ANSI_YELLOW = "\u001B[33m";
            String [] wc = {"W","E","L","C","O","M","E"," ","T","O"," ","C","A","S","E","S","T","U","D","Y"," ","M","O","D","U","L","E"," 2"," B","Y ","H","O","A","N","G",".T","R","A","N"," <3"};
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
