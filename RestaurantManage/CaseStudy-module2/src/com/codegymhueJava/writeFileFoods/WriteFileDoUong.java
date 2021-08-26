package com.codegymhueJava.writeFileFoods;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileDoUong {
    public static <E> void writeToFileDoUong(List<E> listName) {
        try {
            FileWriter file = new FileWriter("doUongFile.txt");
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
