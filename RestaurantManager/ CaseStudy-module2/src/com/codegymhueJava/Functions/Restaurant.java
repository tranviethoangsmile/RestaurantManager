package com.codegymhueJava.Functions;

import com.codegymhueJava.Thread.Loading;
import com.codegymhueJava.Thread.Sale;
import com.codegymhueJava.Thread.ThreadGoodBye;
import com.codegymhueJava.model.*;
import com.codegymhueJava.service.CheckInput;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import static com.codegymhueJava.Functions.WriteFileDoanhThu.writeToFileDoanhThu;
import static com.codegymhueJava.service.CheckInput.checkInteger;

public class Restaurant {
        //        List doanh thu
        static List<DoanhThu> listDoanhThu = new ArrayList<DoanhThu>();
        //    DANH SÁCH MÓN ĂN VÀ ĐỒ UỐNG.
        static List <MonHaiSan> listHaiSan = new ArrayList<MonHaiSan>();
        static List <MonKhaiVi> monKhaiVi = new ArrayList<MonKhaiVi>();
        static List <MonLau> listMonLau = new ArrayList<MonLau>();
        static List <DoUong> listDoUong = new ArrayList<DoUong>();
        static List <MonRung> listMonRung = new ArrayList<MonRung>();
        //    Thread

        static ThreadGoodBye threadGoodBye = new ThreadGoodBye();
        static Loading loading = new Loading();
        static Sale sale = new Sale();

        //    màu chữ
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_WHITE = "\u001B[37m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_CYAN = "\u001B[36m";

        static Scanner scanner = new Scanner(System.in);
        //    kiểm tra đầu vào
        static CheckInput check = new CheckInput();

        //    đọc file
        public static ReadFile readFile = new ReadFile();

        //    ghi file
        static WriteFile writeFile = new WriteFile();

        //    List
        static List<FoodsObj> listFoods = new ArrayList<FoodsObj>();
        static Function function = new Function();

        static String id = "";
        public static void chonBan () throws FileNotFoundException, InterruptedException {
            System.out.println(ANSI_YELLOW + "\n|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||       MỜI QUÝ KHÁCH CHỌN BÀN        ||");
            System.out.println("||-------------------------------------||");
            System.out.println("|| 1.|B1|      2.|B2|       3.|B3|     ||");
            System.out.println("|| 4.|B1|      5.|B2|       6.|B3|     ||");
            System.out.println("|| 7.|B1|      8.|B2|       9.|B3|     ||");
            System.out.println("___________                            ||");
            System.out.println("||QUẦY    |                  0. _BACK_ ||");
            System.out.println("|||||||||||||||CỬA CHÍNH|||||||||||||||||");
            while (true) {
                System.out.print(ANSI_YELLOW + "select: ");
                int select = (int) checkInteger(0,9);
                switch (select)
                {
                    case 0 :
                        function.menu();
                        break;
                    case 1 :
                        id = "b1";
                        menu ();
                        break;
                    case 2 :
                        id = "b2";
                        menu ();
                        break;
                    case 3 :
                        id = "b3";
                        menu ();
                        break;
                    case 4 :
                        id = "b4";
                        menu ();
                        break;
                    case 5 :
                        id = "b4";
                        menu ();
                        break;
                    case 6 :
                        id = "b6";
                        menu ();
                        break;
                    case 7 :
                        id = "b7";
                        menu ();
                        break;
                    case 8 :
                        id = "b8";
                        menu ();
                        break;
                    case 9 :
                        id = "b9";
                        menu ();
                        break;
                }
            }
        }

        public static void menu () throws FileNotFoundException, InterruptedException {
            System.out.println(ANSI_BLUE + "\n|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||           THỰC ĐƠN HÔM NAY CÓ       ||");
            System.out.println("||-------------------------------------||");
            System.out.println("||     1. KHAI VỊ                      ||");
            System.out.println("||     2. HẢI SẢN                      ||");
            System.out.println("||     3. NÚI RỪNG                     ||");
            System.out.println("||     4. LẪU                          ||");
            System.out.println("||     5. ĐỒ UỐNG CÁC LOẠI             ||");
            System.out.println("||     6. HOÁ ĐƠN TẠM TÍNH             ||");
            System.out.println("||     7. IN HOÁ ĐƠN                   ||");
            System.out.println("||     8. XEM KHUYẾN MÃI               ||");
            System.out.println("||                           0. _BACK_ ||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            while (true) {
                System.out.print(ANSI_YELLOW + "select: ");
                int select = (int) checkInteger(0,8);
                switch (select)
                {
                    case 0 :
                        chonBan();
                        break;
                    case 1 :
                        menuKhaiVi();
                        break;
                    case 2 :
                        menuHaiSan ();
                        break;
                    case 3 :
                        menuNuiRung();
                        break;
                    case 4 :
                        menuLau ();
                        break;
                    case 5 :
                        menuDoUong();
                        break;
                    case 6 :
                        xemHoaDon();
                        break;
                    case 7 :
                        inHoaDon();
                        break;
                    case 8 :
                        function.xemKhuyenMai();
                        break;

                }
            }
        }

        public static void menuKhaiVi() throws FileNotFoundException, InterruptedException {
            List <MonKhaiVi> monKhaiVi = readFile.readMonKhaiVi();
            if (monKhaiVi.size() == 0) {
                System.out.println(ANSI_YELLOW + "TẠM HẾT HÀNG");
            }else {
                System.out.println(ANSI_PURPLE + "\n|||||||||||||||||||||||||||||||||||||||||");
                System.out.println("||           THỰC ĐƠN KHAI VỊ          ||");
                System.out.println("||-------------------------------------||");
                System.out.printf("%2s%10s%10d","1",monKhaiVi.get(0).getName(),monKhaiVi.get(0).getPrice());
                System.out.printf("\n%2s%10s%10d","2",monKhaiVi.get(1).getName(),monKhaiVi.get(1).getPrice());
                System.out.printf("\n%2s%10s%10d","3",monKhaiVi.get(2).getName(),monKhaiVi.get(2).getPrice());
                System.out.println("\n||                           0. _back_ ||");
                System.out.println("|||||||||||||||||||||||||||||||||||||||||");
                int selectKV;
                String khai_vi = "";
                int quantitykv = 0;
                int pricekv = 0;

                do {
                    System.out.print(ANSI_YELLOW + "select: ");
                    selectKV = (int) checkInteger(0,3);
                    switch (selectKV)
                    {
                        case 0 :
                            menu();
                            break;
                        case 1 :
                            khai_vi = monKhaiVi.get(0).getName();
                            System.out.print("Số lượng: ");
                            quantitykv = (int) checkInteger(0,10);
                            pricekv = monKhaiVi.get(0).getPrice() * quantitykv;
                            listFoods.add(new FoodsObj(id,khai_vi,quantitykv, pricekv));
                            break;
                        case 2 :
                            khai_vi = monKhaiVi.get(1).getName();
                            System.out.print("Số lượng: ");
                            quantitykv = (int) checkInteger(0,10);
                            pricekv = monKhaiVi.get(1).getPrice() * quantitykv;
                            listFoods.add(new FoodsObj(id,khai_vi,quantitykv, pricekv));
                            break;
                        case 3 :
                            khai_vi = monKhaiVi.get(2).getName();
                            System.out.print("Số lượng: ");
                            quantitykv = (int) checkInteger(0,10);
                            pricekv = monKhaiVi.get(2).getPrice() * quantitykv;
                            listFoods.add(new FoodsObj(id,khai_vi,quantitykv, pricekv));
                            break;

                    }
                }while (selectKV != 0);
            }
        }

    public static void menuHaiSan () throws InterruptedException, FileNotFoundException {
        List <MonHaiSan> monHaiSan = readFile.readMonHaiSan();
        if (monHaiSan.size() == 0) {
            System.out.println(ANSI_YELLOW + "TẠM HẾT HÀNG");
        }else {
            System.out.println(ANSI_YELLOW + "\n|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||           THỰC ĐƠN HẢI SẢN          ||");
            System.out.println("||-------------------------------------||");
            System.out.printf("%2s%10s%10d","1",monHaiSan.get(0).getName(),monHaiSan.get(0).getPrice());
            System.out.printf("\n%2s%10s%10d","2",monHaiSan.get(1).getName(),monHaiSan.get(1).getPrice());
            System.out.printf("\n%2s%10s%10d","3",monHaiSan.get(2).getName(),monHaiSan.get(2).getPrice());
            System.out.println("\n||                           0. _back_ ||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            int selectHS;
            String hai_san = "";
            int quantityHS = 0;
            int priceHS = 0;

            do {
                System.out.print(ANSI_YELLOW + "select: ");
                selectHS = (int) checkInteger(0,3);
                switch (selectHS)
                {
                    case 0 :
                        menu();
                        break;
                    case 1 :
                        hai_san = monHaiSan.get(0).getName();
                        System.out.print("Số lượng: ");
                        quantityHS = (int) checkInteger(0,10);
                        priceHS = monHaiSan.get(0).getPrice()* quantityHS;
                        listFoods.add(new FoodsObj(id,hai_san,quantityHS, priceHS));
                        break;
                    case 2 :
                        hai_san = monHaiSan.get(1).getName();
                        System.out.print("Số lượng: ");
                        quantityHS = (int) checkInteger(0,10);
                        priceHS = monHaiSan.get(0).getPrice() * quantityHS;
                        listFoods.add(new FoodsObj(id,hai_san,quantityHS, priceHS));
                        break;
                    case 3 :
                        hai_san =monHaiSan.get(2).getName();
                        System.out.print("Số lượng: ");
                        quantityHS = (int) checkInteger(0,10);
                        priceHS = monHaiSan.get(0).getPrice() * quantityHS;
                        listFoods.add(new FoodsObj(id,hai_san,quantityHS, priceHS));
                        break;

                }
            }while (selectHS != 0);
        }
    }

    public static void menuNuiRung() throws InterruptedException, FileNotFoundException {
        List <MonRung> monRung = readFile.readMonRung();
        if (monRung.size() == 0) {
            System.out.println(ANSI_YELLOW + "TẠM HẾT HÀNG");
        }else {
            System.out.println(ANSI_GREEN + "\n|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||           THỰC ĐƠN NÚI RỪNG         ||");
            System.out.println("||-------------------------------------||");
            System.out.printf("%2s%10s%10d","1",monRung.get(0).getName(),monRung.get(0).getPrice());
            System.out.printf("\n%2s%10s%10d","2",monRung.get(1).getName(),monRung.get(1).getPrice());
            System.out.printf("\n%2s%10s%10d","3",monRung.get(2).getName(),monRung.get(2).getPrice());
            System.out.println("\n||                           0. _back_ ||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        }
        int selectR;
        String rung = "";
        int quantityR = 0;
        int priceR = 0;

        do {
            System.out.print(ANSI_YELLOW + "select: ");
            selectR = (int) checkInteger(0,3);
            switch (selectR)
            {
                case 0 :
                    menu();
                    break;
                case 1 :
                    rung = monRung.get(0).getName();
                    System.out.print("Số lượng: ");
                    quantityR = (int) checkInteger(0,10);
                    priceR = monRung.get(0).getPrice()* quantityR;
                    listFoods.add(new FoodsObj(id,rung,quantityR, priceR));
                    break;
                case 2 :
                    rung = monRung.get(1).getName();
                    System.out.print("Số lượng: ");
                    quantityR = (int) checkInteger(0,10);
                    priceR = monRung.get(0).getPrice() * quantityR;
                    listFoods.add(new FoodsObj(id,rung,quantityR, priceR));
                    break;
                case 3 :
                    rung =monRung.get(2).getName();
                    System.out.print("Số lượng: ");
                    quantityR = (int) checkInteger(0,10);
                    priceR = monRung.get(0).getPrice() * quantityR;
                    listFoods.add(new FoodsObj(id,rung,quantityR, priceR));
                    break;

            }
        }while (selectR != 0);
    }

    public static void menuLau () throws InterruptedException, FileNotFoundException {
        List<MonLau> lau = readFile.readMonLau();
        if (lau.size() == 0) {
            System.out.println(ANSI_YELLOW + "TẠM HẾT HÀNG");
        }else {
            System.out.println(ANSI_WHITE + "\n|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||           THỰC ĐƠN LẨU              ||");
            System.out.println("||-------------------------------------||");
            System.out.printf("%2s%10s%10d","1",lau.get(0).getName(),lau.get(0).getPrice());
            System.out.printf("\n%2s%10s%10d","2",lau.get(1).getName(),lau.get(1).getPrice());
            System.out.printf("\n%2s%10s%10d","3",lau.get(2).getName(),lau.get(2).getPrice());
            System.out.println("\n||                           0. _back_ ||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        }
        int selectR;
        String mLau = "";
        int quantityL = 0;
        int priceR = 0;

        do {
            System.out.print(ANSI_YELLOW + "select: ");
            selectR = (int) checkInteger(0,3);
            switch (selectR)
            {
                case 0 :
                    menu();
                    break;
                case 1 :
                    mLau = lau.get(0).getName();
                    System.out.print("Số lượng: ");
                    quantityL = (int) checkInteger(0,10);
                    priceR = lau.get(0).getPrice()* quantityL;
                    listFoods.add(new FoodsObj(id,mLau,quantityL, priceR));
                    break;
                case 2 :
                    mLau = lau.get(1).getName();
                    System.out.print("Số lượng: ");
                    quantityL = (int) checkInteger(0,10);
                    priceR = lau.get(0).getPrice() * quantityL;
                    listFoods.add(new FoodsObj(id,mLau,quantityL, priceR));
                    break;
                case 3 :
                    mLau =lau.get(2).getName();
                    System.out.print("Số lượng: ");
                    quantityL = (int) checkInteger(0,10);
                    priceR = lau.get(0).getPrice() * quantityL;
                    listFoods.add(new FoodsObj(id,mLau,quantityL, priceR));
                    break;
            }
        }while (selectR != 0);
    }

    public static void menuDoUong() throws InterruptedException, FileNotFoundException {
        List<DoUong> douong = readFile.readDoUong();
        if (douong.size() == 0) {
            System.out.println(ANSI_YELLOW + "TẠM HẾT HÀNG");
        }else {
            System.out.println(ANSI_CYAN + "\n|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||           THỰC ĐƠN ĐỒ UỐNG          ||");
            System.out.println("-----------------------------------------");
            System.out.printf("%2s%10s%10d","1",douong.get(0).getName(),douong.get(0).getPrice());
            System.out.printf("\n%2s%10s%10d","2",douong.get(1).getName(),douong.get(1).getPrice());
            System.out.printf("\n%2s%10s%10d","3",douong.get(2).getName(),douong.get(2).getPrice());
            System.out.println("\n||                           0. _back_ ||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        }
        int selectDU;
        String du = "";
        int quantityL = 0;
        int priceR = 0;

        do {
            System.out.print(ANSI_YELLOW + "select: ");
            selectDU = (int) checkInteger(0,3);
            switch (selectDU)
            {
                case 0 :
                    menu();
                    break;
                case 1 :
                    du = douong.get(0).getName();
                    System.out.print("Số lượng: ");
                    quantityL = (int) checkInteger(0,10);
                    priceR = douong.get(0).getPrice()* quantityL;
                    listFoods.add(new FoodsObj(id,du,quantityL, priceR));
                    break;
                case 2 :
                    du = douong.get(1).getName();
                    System.out.print("Số lượng: ");
                    quantityL = (int) checkInteger(0,10);
                    priceR = douong.get(0).getPrice() * quantityL;
                    listFoods.add(new FoodsObj(id,du,quantityL, priceR));
                    break;
                case 3 :
                    du =douong.get(2).getName();
                    System.out.print("Số lượng: ");
                    quantityL = (int) checkInteger(0,10);
                    priceR = douong.get(0).getPrice() * quantityL;
                    listFoods.add(new FoodsObj(id,du,quantityL, priceR));
                    break;
            }
        }while (selectDU != 0);
    }

    public static void xemHoaDon() throws InterruptedException, FileNotFoundException {
        loading.start();
        loading.join();
        if(listFoods.size() == 0) {
            System.out.println("\nDanh sách trống.");
        }else {
            int totalPrice = 0;
            System.out.println("\n--------HOÁ ĐƠN TẠM TÍNH----------");
            System.out.printf("%2s.%5s%10s%5s%10s","STT","BÀN","TÊN","SL","TỔNG");
            for(int i = 0; i < listFoods.size(); i++) {
                System.out.printf("\n%2d.%5s%10s%5d%10d",i+1,listFoods.get(i).getId(),listFoods.get(i).getName(),listFoods.get(i).getQuantity(),listFoods.get(i).getPrice());
                System.out.println("\n");
            }
            for(FoodsObj o : listFoods) {
                totalPrice += o.getPrice();
            }
            System.out.println("\nTotal: " + totalPrice + " k");
            System.out.println("Thời gian: " + java.time.LocalDateTime.now());
            luaChonThanhToan();

        }
    }

    public static void luaChonThanhToan() throws InterruptedException, FileNotFoundException {
        System.out.println(ANSI_BLUE + "\n|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("      BẠN CÓ THAY ĐỔI KHÔNG?           ");
        System.out.println("-----------------------------------------");
        System.out.println("||     1. CÓ                           ||");
        System.out.println("||     2. KHÔNG                        ||");
        System.out.println("||                                     ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        while (true) {
            System.out.println("chọn: ");
            int chon = (int) checkInteger(1,2);
            switch (chon) {
                case 1 :
                    xoaMonAn();
                    break;
                case 2 :
                    inHoaDon ();
                    break;
            }
        }
    }

    public static void inHoaDon () throws InterruptedException, FileNotFoundException {
        int totalPrice = 0;
        System.out.println("\n--------HOÁ ĐƠN THANH TOÁN----------");
        System.out.printf("%2s.%5s%10s%5s%10s","STT","BÀN","TÊN","SL","TỔNG");
        for(int i = 0; i < listFoods.size(); i++) {
            System.out.printf("\n%2d.%5s%10s%5d%10d",i+1,listFoods.get(i).getId(),listFoods.get(i).getName(),listFoods.get(i).getQuantity(),listFoods.get(i).getPrice());
            System.out.println("\n");
        }
        for(FoodsObj o : listFoods) {
            totalPrice += o.getPrice();
        }
        Date date = new Date();
        System.out.println("\nTotal: " + totalPrice + " k");
        System.out.println("Thời gian: " + date);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String time = formatter.format(date);
        listDoanhThu.add(new DoanhThu(totalPrice,time));
//        ghi dữ liệu doanh thu vào file.
        writeToFileDoanhThu(listDoanhThu);

        System.out.println("||||||||||||||||||||||||");
        System.out.println("||    1. Quay Lai     ||");
        System.out.println("||    0. Thoát        ||");
        System.out.println("||||||||||||||||||||||||");
        while (true) {
            System.out.print("Chọn: ");
            int chon = (int) checkInteger(0,1);
            switch (chon) {
                case 1:
                    menu();
                    break;
                case 0 :
                    function.begin();
                    break;
            }
        }
    }

    public static void xoaMonAn() throws InterruptedException, FileNotFoundException {
        System.out.println(ANSI_BLUE + "\n|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||            BẠN CẦN XOÁ MÓN NÀO?     ||");
        System.out.println("||-------------------------------------||");
        System.out.printf("%2s.%5s%10s%5s%10s","STT","BÀN","TÊN","SL","TỔNG");
        for(int i = 0; i < listFoods.size(); i++) {
            System.out.printf("\n%2d.%5s%10s%5d%10d",i+1,listFoods.get(i).getId(),listFoods.get(i).getName(),listFoods.get(i).getQuantity(),listFoods.get(i).getPrice());
            System.out.println("\n");
        }
        System.out.println("||                           0. _BACK_ ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
//        xoá món ăn trong danh sách chọn
        System.out.print("lựa chọn: ");
        int luaChon = (int) checkInteger(1,listFoods.size());
        listFoods.remove(luaChon - 1);
        luaChonThanhToan();
    }


}
