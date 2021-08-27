package com.codegymhueJava.readFile;

import com.codegymhueJava.model.Admin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileAds {
    public static List<String> readFileAds () throws FileNotFoundException {
        List<String> ads = new ArrayList<String>();
        try {
            FileReader file = new FileReader("adsFile.txt");
            BufferedReader bufferedReader = new BufferedReader(file);
            String line = "";
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }

                ads.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ads;
    }
}
