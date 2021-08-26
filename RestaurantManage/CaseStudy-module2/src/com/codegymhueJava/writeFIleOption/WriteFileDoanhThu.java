package com.codegymhueJava.writeFIleOption;

import com.codegymhueJava.service.CheckInput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileDoanhThu {
    static CheckInput check = new CheckInput();
    public static <E> void writeToFileDoanhThu(List<E> listName) {
        try {
            FileWriter file = new FileWriter("doanhThuFile.csv",true);
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
