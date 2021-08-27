package com.codegymhueJava.Thread;

public class Loading extends Thread{
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";

    @Override
    public void run() {
        System.out.print("VUI LÒNG ĐỢI");
        for (int i = 0; i < 29; i++) {
            System.out.print(ANSI_BLACK + ANSI_WHITE_BACKGROUND + " " + ANSI_RESET);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
