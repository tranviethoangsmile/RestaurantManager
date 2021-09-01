package com.codegymhueJava.writeFileFoods;

import com.codegymhueJava.model.DoanhThu;
import com.codegymhueJava.model.FoodsObj;
import com.codegymhueJava.service.CheckInput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteBillHistory {
    static CheckInput check = new CheckInput();
    public static <E> void writeBillHistory(List<E> listName, List<E> list) {
        try {
            FileWriter file = new FileWriter("lichsu.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            for (E e : listName) {
                for(E o : list) {
                    bufferedWriter.write(e.toString());
                    bufferedWriter.newLine();
                }

            }
            bufferedWriter.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
