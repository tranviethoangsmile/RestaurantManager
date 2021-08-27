package com.codegymhueJava.writeFIleOption;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileAdmin {
    public static <E> void writeToFileAdmin(List<E> listName) {
        try {
            FileWriter file = new FileWriter("adminFile.csv");
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
