package com.codegymhueJava.Functions;

import com.codegymhueJava.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<MonKhaiVi> readMonKhaiVi () {
        List<MonKhaiVi> khaiVi = new ArrayList<>();
        try {
            FileReader file = new FileReader("khaiviFile.txt");
            BufferedReader bufferedReader = new BufferedReader(file);
            String line = "";
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String [] khaiviTXT = line.split(",");
                String name = khaiviTXT[0];
                int price = Integer.parseInt(khaiviTXT[1]);
                khaiVi.add(new MonKhaiVi(name,price));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return khaiVi;
    }

    public static List<MonHaiSan> readMonHaiSan () {
        List<MonHaiSan> haiSan = new ArrayList<>();
        try {
            FileReader file = new FileReader("haiSanFile.txt");
            BufferedReader bufferedReader = new BufferedReader(file);
            String line = "";
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String [] haiSanTXT = line.split(",");
                String name = haiSanTXT[0];
                int price = Integer.parseInt(haiSanTXT[1]);
                haiSan.add(new MonHaiSan(name,price));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return haiSan;
    }


    public static List<MonRung> readMonRung () {
        List<MonRung> monRung = new ArrayList<>();
        try {
            FileReader file = new FileReader("monRungFile.txt");
            BufferedReader bufferedReader = new BufferedReader(file);
            String line = "";
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String [] monRungTXT = line.split(",");
                String name = monRungTXT[0];
                int price = Integer.parseInt(monRungTXT[1]);
                monRung.add(new MonRung(name,price));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return monRung;
    }

    public static List<MonLau> readMonLau () {
        List<MonLau> monLau = new ArrayList<>();
        try {
            FileReader file = new FileReader("monLauFile.txt");
            BufferedReader bufferedReader = new BufferedReader(file);
            String line = "";
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String [] monLauTXT = line.split(",");
                String name = monLauTXT[0];
                int price = Integer.parseInt(monLauTXT[1]);
                monLau.add(new MonLau(name,price));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return monLau;
    }

    public static List<DoUong> readDoUong () {
        List<DoUong> doUong = new ArrayList<>();
        try {
            FileReader file = new FileReader("doUongFile.txt");
            BufferedReader bufferedReader = new BufferedReader(file);
            String line = "";
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String [] doUongTXT = line.split(",");
                String name = doUongTXT[0];
                int price = Integer.parseInt(doUongTXT[1]);
                doUong.add(new DoUong(name,price));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doUong;
    }
}
