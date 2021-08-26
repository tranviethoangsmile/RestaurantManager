package com.codegymhueJava.Thread;

public class Sale extends Thread {
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    String [] sale = {"H","Ô","M"," ","N","A","Y"," ","B","Ạ","N"," ","S","Ẽ"," ","Đ","Ư","Ợ","C"," ","T","Ặ","N","G"," ","1"," ","C","H","i","Ế","C"," ","I","P","H","O","N","E"," ","9"," ","N","Ế","U"," ","B","Ạ","N"," ","Đ","Á","N","H"," ","G","I","Á"," ","T","Ố","T"," "," Ứ","N","G"," ","D","Ụ","N","G"," ","N","À","Y"," ","<3"};
    int leng = sale.length;
    @Override
    public void run() {
        for(int i = 0; i < leng; i++) {
            System.out.print(ANSI_CYAN  + sale[i] + ANSI_RESET);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
