package com.codegymhueJava.Thread;

public class PrintBill extends Thread{
    public static final String ANSI_YELLOW = "\u001B[33m";
    @Override
    public void run() {
        System.out.print(ANSI_YELLOW + "Đang in hoá đơn");
        try {
            for(int i = 0; i < 29; i ++) {
                System.out.print(".");
                Thread.sleep(100);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
