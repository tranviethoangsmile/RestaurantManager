package com.codegymhueJava.Thread;

public class ThreadGoodBye extends Thread{
    public static final String ANSI_BLUE = "\u001B[34m";
    String [] bye = {"G","o","o","d","b","y","e ","s","e","e ","y","o","u ","a","g","a","i","n","<3","<3","<3","<3"};
    int byeLength = bye.length;

    public void run() {
        for (int i = 0; i < bye.length; i++) {
            System.out.print(ANSI_BLUE + bye[i]);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
