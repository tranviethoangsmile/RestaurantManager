package com.codegymhueJava.Thread;

public class ThreadGoodBye extends Thread{
    public static final String ANSI_BLUE = "\u001B[34m";
    String [] bye = {"C","H","À","O"," ","T","Ạ","M"," ","B","I","Ệ","T"," ","Q","U","Ý"," ","K","H","Á","C","H"," ","H","Ẹ","N"," ","G","Ặ","P"," ","L","Ạ","I","."};
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
