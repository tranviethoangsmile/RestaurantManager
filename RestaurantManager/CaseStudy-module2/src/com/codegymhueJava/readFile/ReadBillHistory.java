package com.codegymhueJava.readFile;

import com.codegymhueJava.model.FoodsObj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadBillHistory {
    List<FoodsObj> billHistory = new ArrayList<FoodsObj>();
    public static List<FoodsObj> readFileBillHistory () throws FileNotFoundException {
        List<FoodsObj> billHistory = new ArrayList<FoodsObj>();
        try {
            FileReader file = new FileReader("lichsu.txt");
            BufferedReader bufferedReader = new BufferedReader(file);
            String line = "";
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] bill = line.split(",");
                String name  = bill[0];
               int quantity =  Integer.parseInt(bill[1]);
               int price = Integer.parseInt(bill[2]);

                billHistory.add(new FoodsObj(name,quantity,price));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return billHistory;
    }
}
