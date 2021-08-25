package com.codegymhueJava.Functions;

import com.codegymhueJava.service.CheckInput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    static CheckInput check = new CheckInput();
    public static <E> void writeToFile(List<E> listName) {
        System.out.println("Nhập tên file: ");
        String fileName = check.checkString();
        try {
            FileWriter file = new FileWriter(fileName,true);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            for (E e : listName) {
                bufferedWriter.write(e.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
