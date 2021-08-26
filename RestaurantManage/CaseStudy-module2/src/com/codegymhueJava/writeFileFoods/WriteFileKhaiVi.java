package com.codegymhueJava.writeFileFoods;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileKhaiVi {
    public static <E> void writeToFileKhaiVi(List<E> listName) {
        try {
            FileWriter file = new FileWriter("khaiviFile.txt");
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
