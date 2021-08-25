package com.codegymhueJava.readFile;

import com.codegymhueJava.model.DoanhThu;
import com.codegymhueJava.model.Table;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileTable {
    public static List<Table> readFileTable () throws FileNotFoundException {
        List<Table> table = new ArrayList<Table>();
        try {
            FileReader file = new FileReader("tableFile.csv");
            BufferedReader bufferedReader = new BufferedReader(file);
            String line = "";
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] tableCSV = line.split(",");
                int  id  = Integer.parseInt(tableCSV[0]);
                String name =  tableCSV[1];
                table.add(new Table(id,name));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return table;
    }
}
