package com.codegymhueJava.readFile;

import com.codegymhueJava.model.Admin;
import com.codegymhueJava.model.DoanhThu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileAdmin {
    public static List<Admin> readFileAdmin () throws FileNotFoundException {
        List<Admin> admin = new ArrayList<Admin>();
        try {
            FileReader file = new FileReader("adminFile.csv");
            BufferedReader bufferedReader = new BufferedReader(file);
            String line = "";
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] adminCSV = line.split(",");
                String name  = adminCSV[0];
                String password =  adminCSV[1];
                admin.add(new Admin(name,password));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
