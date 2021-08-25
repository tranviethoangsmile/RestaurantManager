package com.codegymhueJava.Functions;

import com.codegymhueJava.model.DoanhThu;
import com.codegymhueJava.model.MonRung;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFileDoanhThu {
    public static List<DoanhThu> readDoanhThu () throws FileNotFoundException {
        List<DoanhThu> doanhThu = new ArrayList<DoanhThu>();
        try {
            FileReader file = new FileReader("doanhThuFile.csv");
            BufferedReader bufferedReader = new BufferedReader(file);
            String line = "";
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] doanhThuCSV = line.split(",");
                int  total  = Integer.parseInt(doanhThuCSV[0]);
                String time =  doanhThuCSV[1];
                doanhThu.add(new DoanhThu(total,time));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return doanhThu;
    }
}
