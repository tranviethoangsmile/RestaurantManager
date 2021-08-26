package com.codegymhueJava.service;

import java.util.Scanner;

public class CheckInput {
    static Scanner scanner = new Scanner(System.in);

    public static double checkInteger(int min, int max) {
        double num = 0;
        while (true) {

            try {
                num = Double.parseDouble(scanner.nextLine());
                if( num >=min && num <= max ) {
                    break;
                }else {
                    System.out.println("only within " + min + " - " + max);
                }

            }catch (Exception e) {
                System.out.println("Please enter again with datatype Integer...");

            }
        }
        return num;
    }

    public String checkString () {
        String str = "";
        while (true){
            str = scanner.nextLine();
            if(!str.trim().equals("")) {
                break;
            }
        }
        return str;
    }
}
