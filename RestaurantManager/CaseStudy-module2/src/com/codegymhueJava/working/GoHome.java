package com.codegymhueJava.working;

import com.codegymhueJava.Thread.PrintBill;
import com.codegymhueJava.readFile.ReadFileAdmin;
import com.codegymhueJava.readFile.ReadFileAds;
import com.codegymhueJava.writeFIleOption.*;
import com.codegymhueJava.Thread.Loading;
import com.codegymhueJava.Thread.Sale;
import com.codegymhueJava.Thread.ThreadGoodBye;
import com.codegymhueJava.readFile.ReadFile;
import com.codegymhueJava.readFile.ReadFileDoanhThu;
import com.codegymhueJava.service.CheckInput;
import com.codegymhueJava.model.*;
import com.codegymhueJava.writeFileFoods.*;

import java.io.FileNotFoundException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static com.codegymhueJava.writeFIleOption.WriteFileDoanhThu.writeToFileDoanhThu;
import static com.codegymhueJava.service.CheckInput.checkInteger;

    public class GoHome {
//        List ads
    static List <String> quangCao = new ArrayList<String>();
//        List doanh thu
    static List <DoanhThu> listDoanhThu = new ArrayList<DoanhThu>();
//    DANH SÁCH MÓN ĂN VÀ ĐỒ UỐNG.
    static List <MonHaiSan> listHaiSan = new ArrayList<MonHaiSan>();
    static List <MonKhaiVi> monKhaiVi = new ArrayList<MonKhaiVi>();
    static List <MonLau> listMonLau = new ArrayList<MonLau>();
    static List <DoUong> listDoUong = new ArrayList<DoUong>();
    static List <MonRung> listMonRung = new ArrayList<MonRung>();

//    Danh sách addmin
    static List <Admin> listAdmin = new ArrayList<Admin>();

//    Bàn
    static List<Table> listTable = new ArrayList<Table>();

    //    Thread
    static ThreadGoodBye threadGoodBye = new ThreadGoodBye();
    static Loading loading = new Loading();
    static Sale sale;

        static {
            try {
                sale = new Sale();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        //    màu chữ
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    static Scanner scanner = new Scanner(System.in);
    //    kiểm tra đầu vào
    static CheckInput check = new CheckInput();

//    đọc file
    public static ReadFile readFile = new ReadFile();
    static ReadFileAdmin readFileAdmin = new ReadFileAdmin();

//    ghi file
    static WriteFileDoUong writeFileDoUong = new WriteFileDoUong();
    static WriteFileHaiSan writeFileHaiSan = new WriteFileHaiSan();
    static WriteFileKhaiVi writeFileKhaiVi = new WriteFileKhaiVi();
    static WriteFileMonLau writeFileMonLau = new WriteFileMonLau();
    static WriteFileMonRung writeFileMonRung = new WriteFileMonRung();
    static WriteFileAdmin writeFileAdmin = new WriteFileAdmin();

    static WriteFileTable writeFileTable = new WriteFileTable();
    static WriteFileAds writeFileAds = new WriteFileAds();

    //    List
    static List<FoodsObj> listFoods = new ArrayList<FoodsObj>();

//    rẽ nhánh khách dùng tại nhà hàng
        static Restaurant restaurant = new Restaurant();

    public static void inHoaDon () throws InterruptedException, FileNotFoundException {
        int totalPrice = 0;
        System.out.println(ANSI_WHITE + "\n----------HOÁ ĐƠN THANH TOÁN------------");
        System.out.printf("\n%2s.%15s%10s%10s","STT","TÊN","SL","TỔNG");
        for(int i = 0; i < listFoods.size(); i++) {
            System.out.printf("\n%2d.%15s%10d%10d",(i+1),listFoods.get(i).getName(),listFoods.get(i).getQuantity(),listFoods.get(i).getPrice());
            System.out.println("\n");
        }
        for(FoodsObj o : listFoods) {
            totalPrice += o.getPrice();
        }
        Date date = new Date();
        System.out.println("\nTotal: " + totalPrice + " k");
        System.out.println("Thời gian: " + date);
        System.out.println(ANSI_BLUE+"CẢM ƠN QUÝ KHÁCH"+ANSI_RESET);
        System.out.println("-----------------------------------------");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String time = formatter.format(date);
        listDoanhThu.add(new DoanhThu(totalPrice,time));
//        ghi dữ liệu doanh thu vào file.
        writeToFileDoanhThu(listDoanhThu);
        listFoods.clear();

        System.out.println("||||||||||||||||||||||||");
        System.out.println("||    1. Quay Lai     ||");
        System.out.println("||    0. Thoát        ||");
        System.out.println("||||||||||||||||||||||||");
        while (true) {
            System.out.print("Chọn: ");
            int chon = (int) checkInteger(0,1);
            switch (chon) {
                case 1:
                    menu ();
                    break;
                case 0 :
                    begin ();
                    break;
            }
        }
    }

    public static void xemHoaDon() throws InterruptedException, FileNotFoundException {
        hoaDonTamTinh ();
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
                System.out.print("chọn: ");
                int chon = (int) checkInteger(1,2);
                switch (chon) {
                    case 1 :
                        xoaMonAn ();
                        break;
                    case 2 :
                        inHoaDon ();
                        break;
                }
            }

        }

        public static void menuDoUong() throws InterruptedException, FileNotFoundException {
        List<DoUong> douong = ReadFile.readDoUong();
        if (douong.size() == 0) {
            System.out.println(ANSI_YELLOW + "TẠM HẾT HÀNG");
        }else {
            System.out.println(ANSI_CYAN + "\n|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||           THỰC ĐƠN ĐỒ UỐNG          ||");
            System.out.println("-----------------------------------------");
            for( int  i = 0; i < douong.size(); i ++) {
                System.out.printf("\n%5s.%15s%10d",i+1,douong.get(i).getName(),douong.get(i).getPrice());
            }
            System.out.println("\n||                           0. _<--<_||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        }
        int selectDU;
        String du = "";
        int quantityL = 0;
        int priceR = 0;

        do {
            System.out.print(ANSI_YELLOW + "Chọn: ");
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
                    listFoods.add(new FoodsObj(du,quantityL, priceR));
                    break;
                case 2 :
                    du = douong.get(1).getName();
                    System.out.print("Số lượng: ");
                    quantityL = (int) checkInteger(0,10);
                    priceR = douong.get(0).getPrice() * quantityL;
                    listFoods.add(new FoodsObj(du,quantityL, priceR));
                    break;
                case 3 :
                    du =douong.get(2).getName();
                    System.out.print("Số lượng: ");
                    quantityL = (int) checkInteger(0,10);
                    priceR = douong.get(0).getPrice() * quantityL;
                    listFoods.add(new FoodsObj(du,quantityL, priceR));
                    break;

            }
        }while (selectDU != 0);

    }

    public static void menuLau () throws InterruptedException, FileNotFoundException {
        List<MonLau> lau = ReadFile.readMonLau();
        if (lau.size() == 0) {
            System.out.println(ANSI_YELLOW + "TẠM HẾT HÀNG");
        }else {
            System.out.println(ANSI_WHITE + "\n|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||           THỰC ĐƠN LẨU              ||");
            System.out.println("||-------------------------------------||");
            for( int  i = 0; i < lau.size(); i ++) {
                System.out.printf("\n%5s.%15s%10d",i+1,lau.get(i).getName(),lau.get(i).getPrice());
            }
            System.out.println("\n||                           0. _<--<_||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        }
        int selectR;
        String mLau = "";
        int quantityL = 0;
        int priceR = 0;

        do {
            System.out.print(ANSI_YELLOW + "Chọn: ");
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
                    listFoods.add(new FoodsObj(mLau,quantityL, priceR));
                    break;
                case 2 :
                    mLau = lau.get(1).getName();
                    System.out.print("Số lượng: ");
                    quantityL = (int) checkInteger(0,10);
                    priceR = lau.get(0).getPrice() * quantityL;
                    listFoods.add(new FoodsObj(mLau,quantityL, priceR));
                    break;
                case 3 :
                    mLau =lau.get(2).getName();
                    System.out.print("Số lượng: ");
                    quantityL = (int) checkInteger(0,10);
                    priceR = lau.get(0).getPrice() * quantityL;
                    listFoods.add(new FoodsObj(mLau,quantityL, priceR));
                    break;

            }
        }while (selectR != 0);

    }

    public static void menuNuiRung() throws InterruptedException, FileNotFoundException {
        List <MonRung> monRung = ReadFile.readMonRung();
        if (monRung.size() == 0) {
            System.out.println(ANSI_YELLOW + "TẠM HẾT HÀNG");
        }else {
            System.out.println(ANSI_GREEN + "\n|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||           THỰC ĐƠN NÚI RỪNG         ||");
            System.out.println("||-------------------------------------||");
            for( int  i = 0; i < monRung.size(); i ++) {
                System.out.printf("\n%5s.%15s%10d",i+1,monRung.get(i).getName(),monRung.get(i).getPrice());
            }
            System.out.println("\n||                           0. _<--<_||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        }
        int selectR;
        String rung = "";
        int quantityR = 0;
        int priceR = 0;

        do {
            System.out.print(ANSI_YELLOW + "Chọn: ");
            selectR = (int) checkInteger(0,3);
            switch (selectR)
            {
                case 0 :
                    menu ();
                    break;
                case 1 :
                    rung = monRung.get(0).getName();
                    System.out.print("Số lượng: ");
                    quantityR = (int) checkInteger(0,10);
                    priceR = monRung.get(0).getPrice()* quantityR;
                    listFoods.add(new FoodsObj(rung,quantityR, priceR));
                    break;
                case 2 :
                    rung = monRung.get(1).getName();
                    System.out.print("Số lượng: ");
                    quantityR = (int) checkInteger(0,10);
                    priceR = monRung.get(0).getPrice() * quantityR;
                    listFoods.add(new FoodsObj(rung,quantityR, priceR));
                    break;
                case 3 :
                    rung =monRung.get(2).getName();
                    System.out.print("Số lượng: ");
                    quantityR = (int) checkInteger(0,10);
                    priceR = monRung.get(0).getPrice() * quantityR;
                    listFoods.add(new FoodsObj(rung,quantityR, priceR));
                    break;

            }
        }while (selectR != 0);
    }

    public static void menuHaiSan () throws InterruptedException, FileNotFoundException {
        List <MonHaiSan> monHaiSan = ReadFile.readMonHaiSan();
        if (monHaiSan.size() == 0) {
            System.out.println(ANSI_YELLOW + "TẠM HẾT HÀNG");
        }else {
            System.out.println(ANSI_RED + "\n|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||           THỰC ĐƠN HẢI SẢN          ||");
            System.out.println("||-------------------------------------||");
            for( int  i = 0; i < monHaiSan.size(); i ++) {
                System.out.printf("\n%5s.%15s%10d",i+1,monHaiSan.get(i).getName(),monHaiSan.get(i).getPrice());
            }
            System.out.println("\n||                           0. _<--<_||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            int selectHS;
            String hai_san = "";
            int quantityHS = 0;
            int priceHS = 0;

            do {
                System.out.print(ANSI_YELLOW + "Chọn: ");
                selectHS = (int) checkInteger(0,3);
                switch (selectHS)
                {
                    case 0 :
                        menu ();
                        break;
                    case 1 :
                        hai_san = monHaiSan.get(0).getName();
                        System.out.print("Số lượng: ");
                        quantityHS = (int) checkInteger(0,10);
                        priceHS = monHaiSan.get(0).getPrice()* quantityHS;
                        listFoods.add(new FoodsObj(hai_san,quantityHS, priceHS));
                        break;
                    case 2 :
                        hai_san = monHaiSan.get(1).getName();
                        System.out.print("Số lượng: ");
                        quantityHS = (int) checkInteger(0,10);
                        priceHS = monHaiSan.get(0).getPrice() * quantityHS;
                        listFoods.add(new FoodsObj(hai_san,quantityHS, priceHS));
                        break;
                    case 3 :
                        hai_san =monHaiSan.get(2).getName();
                        System.out.print("Số lượng: ");
                        quantityHS = (int) checkInteger(0,10);
                        priceHS = monHaiSan.get(0).getPrice() * quantityHS;
                        listFoods.add(new FoodsObj(hai_san,quantityHS, priceHS));
                        break;

                }
            }while (selectHS != 0);
        }

    }

    public static void menuKhaiVi() throws InterruptedException, FileNotFoundException {
        List <MonKhaiVi> monKhaiVi = ReadFile.readMonKhaiVi();
        if (monKhaiVi.size() == 0) {
            System.out.println(ANSI_YELLOW + "TẠM HẾT HÀNG");
        }else {
            System.out.println(ANSI_PURPLE + "\n|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||           THỰC ĐƠN KHAI VỊ          ||");
            System.out.println("||-------------------------------------||");
            for( int  i = 0; i < monKhaiVi.size(); i ++) {
                System.out.printf("\n%5s.%15s%10d",i+1,monKhaiVi.get(i).getName(),monKhaiVi.get(i).getPrice());
            }
            System.out.println("\n||                           0. _<--<_||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            int selectKV;
            String khai_vi = "";
            int quantitykv = 0;
            int pricekv = 0;

            do {
                System.out.print(ANSI_YELLOW + "Chọn: ");
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
                        listFoods.add(new FoodsObj(khai_vi,quantitykv, pricekv));
                        break;
                    case 2 :
                        khai_vi = monKhaiVi.get(1).getName();
                        System.out.print("Số lượng: ");
                        quantitykv = (int) checkInteger(0,10);
                        pricekv = monKhaiVi.get(1).getPrice() * quantitykv;
                        listFoods.add(new FoodsObj(khai_vi,quantitykv, pricekv));
                        break;
                    case 3 :
                        khai_vi = monKhaiVi.get(2).getName();
                        System.out.print("Số lượng: ");
                        quantitykv = (int) checkInteger(0,10);
                        pricekv = monKhaiVi.get(2).getPrice() * quantitykv;
                        listFoods.add(new FoodsObj(khai_vi,quantitykv, pricekv));
                        break;

                }
            }while (selectKV != 0);
        }
    }


    public static void menu() throws InterruptedException, FileNotFoundException {
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
        System.out.println("||                           0. _<--<_ ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        while (true) {
            System.out.print(ANSI_CYAN + "Chọn: ");
            int select = (int) checkInteger(0,8);
            switch (select)
            {
                case 0 :
                    begin ();
                    break;
                case 1 :
                    menuKhaiVi ();
                    break;
                case 2 :
                    menuHaiSan ();
                    break;
                case 3 :
                    menuNuiRung ();
                    break;
                case 4 :
                    menuLau ();
                    break;
                case 5 :
                    menuDoUong ();
                    break;
                case 6 :
                    xemHoaDon ();
                    break;
                case 7 :
                    inHoaDon ();
                    break;
                case 8 :
                    xemKhuyenMai ();
                    break;
            }
        }

    }

        public static void xemKhuyenMai() throws InterruptedException, FileNotFoundException {
//        CHẠY CHỮ KHUYẾN MÃI
            sale.start();
            sale.join();
            menu ();
        }


        public static void begin () throws InterruptedException, FileNotFoundException {
        System.out.println(ANSI_BLUE + "\n|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||     1. ĐĂNG NHẬP                    ||");
        System.out.println("||     2. KHÁCH HÀNG                   ||");
        System.out.println("||     3. ĐĂNG KÝ                      ||");
        System.out.println("||                           0. _Thoát_||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        while (true) {
            System.out.print(ANSI_YELLOW + "Chọn: ");
            int select = (int) checkInteger(0,3);
            switch (select)
            {
                case 0 :
//                    Chạy dòng goodbye...
                    threadGoodBye.start();
                    threadGoodBye.join();
                    System.exit(0);
                case 1 :
//                    ĐĂNG NHẬP
                    List <Admin> admin = ReadFileAdmin.readFileAdmin();
                    boolean checkName = false;
                        System.out.print("Tên: ");
                        String name = check.checkString();
                        for(Admin ad : admin) {
                            if(ad.getName().equals(name)) {
                                checkName = true;
                                System.out.print("Mật khẩu: ");
                                String password = check.checkString();
                                    if (ad.getPassword ().equals(password)) {
                                        System.out.print("Chào " + ad.getName ());
                                        addmin ();
                                    } else {
                                        System.out.print("Mật khẩu sai...Vui lòng kiểm tra lại");
                                        begin ();
                                    }

                            }else {
                                checkName = false;
                            }
                        }
                        if(!checkName) {
                            System.out.println("Nhân viên " + name + " Không tồn tại");
                        }
                    break;
                case 2 :
//                    CHUYỂN HƯỚNG ĐẾN CHỌN CÁCH DÙNG BỮA
                    cachDungBua();
                    break;
                case 3 :

//                    ĐĂNG KÍ
                    boolean checkpas = false;
                    System.out.print("Nhập tên: ");
                    String adminName = check.checkString();
                    System.out.print("Mật khẩu: ");
                    String password = check.checkString();
                        System.out.print("Nhập lại mật khẩu: ");
                        String rePassword = check.checkString();
                    if(password.equals(rePassword)) {
                        checkpas = true;
                    }else {
                        checkpas = false;
                    }
                    if(checkpas) {
                        listAdmin.add(new Admin(adminName,password));
                        WriteFileAdmin.writeToFileAdmin(listAdmin);
                        System.out.println(ANSI_WHITE + "Đăng kí thành công.");
                        break;
                    }else {
                        System.out.println("Mật khẩu không giống. Vui lòng kiểm tra lại...");
                        begin ();
                    }
            }
        }
    }

    private static void addmin() throws InterruptedException, FileNotFoundException {
        System.out.println(ANSI_CYAN + "\n|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||            TRANG QUẢN LÝ            ||");
        System.out.println("||-------------------------------------||");
        System.out.println("||     1. THÊM MÓN ĂN                  ||");
        System.out.println("||     2. SỬA MÓN ĂN                   ||");
        System.out.println("||     3. KIỂM TRA DOANH THU           ||");
        System.out.println("||     4. HIỂN THỊ TẤT CẢ CÁC MÓN      ||");
        System.out.println("||     5. THIẾT LẬP BÀN                ||");
        System.out.println("||     6. QUẢN LÝ DANH SÁCH NHÂN VIÊN  ||");
        System.out.println("||     7. THIẾT LẬP QUẢNG CÁO          ||");
        System.out.println("||                           0. _<--<_ ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        int select;
        do {
            System.out.print(ANSI_YELLOW + "Chọn: ");
             select = (int) checkInteger(0,7);
            switch (select)
            {
                case 0 :
                    begin ();
                    break;
                case 1 :
                    addMonAn ();
                    break;
                case 2 :
                    suaMonAn ();
                    break;
                case 3 :
                    List <Admin> admin = ReadFileAdmin.readFileAdmin();
                    System.out.println(ANSI_PURPLE + "\n|||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("||     Bạn có phải là admin không?     ||");
                    System.out.println("||-------------------------------------||");
                    System.out.println("||     1. PHẢI                         ||");
                    System.out.println("||     2. KHÔNG                        ||");
                    System.out.println("||                           0. _<--<_ ||");
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||");
                    int selected;
                    do {
                        System.out.print(ANSI_YELLOW + "Chọn: ");
                        selected = (int) checkInteger(0,2);
                        switch (selected)
                        {
                            case 0 :
                                addmin ();
                                break;
                            case 1 :
                                System.out.print("Tên: ");
                                String name = check.checkString();
                                if(name.equals("admin")) {
                                    System.out.print("Mật khẩu: ");
                                    String password = check.checkString();
                                    for(Admin adPas : admin) {
                                        if(adPas.getPassword ().equals(password)) {
                                            System.out.println("Chào " + adPas.getName());
                                            kiemTraDoanhThu ();
                                            break;
                                        }else {
                                            System.out.println("Mật khẩu sai...Vui lòng kiểm tra lại");
                                            addmin ();
                                        }
                                    }
                                }else {
                                    System.out.println("bạn không được cấp quyền.");
                                    addmin ();
                                }
                                break;
                            case 2 :
                                addmin ();
                                break;
                        }
                    }while(select != 0);
                    break;
                case 4 :
                    hienThiTatCa ();
                    break;
                case 5 :
                    thietLapBan ();
                    break;
                case 6 :
                    danhSachNhanVien ();
                    break;
                case 7 :
                    thietLapQuangCao ();
                    break;

            }
        }while(select != 0);
    }

        private static void thietLapQuangCao() throws FileNotFoundException, InterruptedException {
            System.out.print("số chữ: ");
            int num = scanner.nextInt();
            for(int i = 1; i <= num; i++) {
                System.out.print("Chữ " + i + ": ");
                String word = check.checkString();
                quangCao.add(word);
                WriteFileAds.writeToFileAds(quangCao);

            }
            addmin();
        }

        private static void danhSachNhanVien() throws FileNotFoundException, InterruptedException {
            List <Admin> admin = ReadFileAdmin.readFileAdmin();
            System.out.println(ANSI_BLUE + "\n|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||      TRANG QUẢN LÝ NHÂN VIÊN        ||");
            System.out.println("||-------------------------------------||");
            System.out.println("||     1. DANH SÁCH NHÂN VIÊN          ||");
            System.out.println("||     2. XOÁ NHÂN VIÊN                ||");
            System.out.println("||                           0. _<--<_ ||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            int select;
            do {
                System.out.print(ANSI_YELLOW + "Chọn: ");
                select = (int) checkInteger(0,2);
                switch (select)
                {
                    case 0 :
                        addmin();
                        break;
                    case 1 :
                        for(int i = 0; i < admin.size(); i ++) {
                            System.out.printf("%2d%10s",i + 1,admin.get(i).getName());
                            System.out.println("\n");
                        }
                        danhSachNhanVien();
                        break;
                    case 2 :
                        xoaNhanVien();
                        break;
                }
            }while(select != 0);


        }

        private static void xoaNhanVien() throws FileNotFoundException, InterruptedException {
            List <Admin> admin = ReadFileAdmin.readFileAdmin();
            System.out.println(ANSI_BLUE + "\n|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||     Bạn có phải là admin không?     ||");
            System.out.println("||-------------------------------------||");
            System.out.println("||     1. PHẢI                         ||");
            System.out.println("||     2. KHÔNG                        ||");
            System.out.println("||                           0. _<--<_ ||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            int select;
            do {
                System.out.print(ANSI_YELLOW + "Chọn: ");
                select = (int) checkInteger(0,2);
                switch (select)
                {
                    case 0 :
                        addmin();
                        break;
                    case 1 :
                        System.out.print("Tên: ");
                        String name = check.checkString();
                        if(name.equals("admin")) {
                            System.out.print("Mật khẩu: ");
                            String password = check.checkString();
                            for(Admin adPas : admin) {
                                if(adPas.getPassword().equals(password)) {
                                    System.out.println("Chào " + adPas.getName());
                                    System.out.print("Chọn nhân nv: ");
                                    int chon = scanner.nextInt();
                                    if(chon == 1 ) {
                                        System.out.println("Bạn không thể xoá chính mình");
                                        danhSachNhanVien();
                                        break;
                                    }else {
                                        admin.remove(chon - 1);
                                        WriteFileAdmin.writeToFileAdmin(admin);
                                        for( int i = 0; i < admin.size(); i++ ) {
                                            System.out.printf("%2d%10s",i + 1,admin.get(i).getName());
                                            System.out.println("\n");
                                        }
                                        danhSachNhanVien();
                                    }

                                }else {
                                    System.out.println("Mật khẩu sai...Vui lòng kiểm tra lại");
                                    begin ();
                                }
                            }
                        }else {
                            System.out.println("bạn không được cấp quyền.");
                            danhSachNhanVien();
                        }
                        break;
                    case 2 :
                        danhSachNhanVien();
                        break;
                }
            }while(select != 0);
        }

//        Tăng id tự động.
        static int count;
        public static int autoID()
        {
            return count +=1;
        }


        public static void thietLapBan() {
            System.out.print("Nhập số bàn: ");
            int ban = (int) checkInteger(1,10);
            for(int  i = 1; i <= ban ; i++) {
//                System.out.println("ID: ");
                int id = autoID();
                System.out.print("Tên bàn " + i + ": ");
                String tenBan = check.checkString();
                listTable.add(new Table(id,tenBan));
                WriteFileTable.writeToFileTable(listTable);

            }
        }

        private static void hienThiTatCa() {
//        hiển thị file khai vị
        List <MonKhaiVi> monKhaiVi = ReadFile.readMonKhaiVi();
        System.out.println(ANSI_GREEN + "Món khai vị:");
        if(monKhaiVi.size() == 0) {
            System.out.println(ANSI_WHITE + "CHƯA CÓ THÔNG TIN MÓN ĂN");
        }else {
            for(MonKhaiVi kv : monKhaiVi)
            {
                System.out.printf("\n%20s%10d%10d",kv.getName(),kv.getPrice(),kv.getQuantity());
            }
        }

//        hiển thị file hải sản
        List <MonHaiSan> monHaiSan = ReadFile.readMonHaiSan();
        System.out.println("\n" +ANSI_GREEN + "Hải Sản: ");
        if(monHaiSan.size() == 0) {
            System.out.println(ANSI_WHITE + "CHƯA CÓ THÔNG TIN MÓN ĂN");
        }else {

            for (MonHaiSan hs: monHaiSan)
            {
                System.out.printf("\n%20s%10d%10d",hs.getName(),hs.getPrice(),hs.getQuantity());
            }
        }

//        Hiển thị file Món Rừng
        List <MonRung> monRung = ReadFile.readMonRung();
        System.out.println("\n" +ANSI_GREEN + "Món Rừng: ");
        if(monRung.size() == 0) {
            System.out.println(ANSI_WHITE + "CHƯA CÓ THÔNG TIN MÓN ĂN");
        }else {

            for (MonRung mr : monRung) {
                System.out.printf("\n%20s%10d%10d",mr.getName(),mr.getPrice(),mr.getQuantity());
            }
        }

//        Hiển thị file Lẫu
        List<MonLau> lau = ReadFile.readMonLau();
        System.out.println("\n" +ANSI_GREEN + "Món Lẫu: ");
        if(lau.size() == 0) {
            System.out.println(ANSI_WHITE + "CHƯA CÓ THÔNG TIN MÓN ĂN");
        }else {

            for (MonLau ml : lau) {
                System.out.printf("\n%20s%10d%10d",ml.getName(),ml.getPrice(),ml.getQuantity());
            }
        }

//        Đọc file Đồ uống
        List<DoUong> douong = ReadFile.readDoUong();
        System.out.println("\n" +ANSI_GREEN + "Đồ Uống:");
        if(douong.size() == 0) {
            System.out.println(ANSI_WHITE + "CHƯA CÓ THÔNG TIN MÓN ĂN");
        }else {

            for (DoUong du : douong) {
                System.out.printf("\n%20s%10d%10d",du.getName(),du.getPrice(),du.getQuantity());
            }
        }
            System.out.println("\n");

    }

    private static void kiemTraDoanhThu() throws FileNotFoundException {
        ReadFileDoanhThu dt = new ReadFileDoanhThu();
    List<DoanhThu> listDoanhThu = ReadFileDoanhThu.readDoanhThu();
    int total = 0;
        System.out.printf("%20s%24s","Ngày","Tiền");
        System.out.println("\n-----------------------------------------------");
    for(DoanhThu o : listDoanhThu) {
        System.out.printf("\n|%20s |%20sk |",o.getTime(),o.getTotalPrice());
    }

    for(DoanhThu o : listDoanhThu) {
        total += o.getTotalPrice();
    }
        System.out.println("\n-------------------------------------------");
        System.out.println("\nTổng doanh thu: " + total + "k");
        System.out.println("\n-------------------------------------------");
    }


    public static void xoaMonAn() throws InterruptedException, FileNotFoundException {
        System.out.println(ANSI_BLUE + "\n|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||         BẠN CẦN XOÁ MÓN NÀO?        ||");
        System.out.println("||-------------------------------------||");
        for(int i = 0; i < listFoods.size(); i++) {
            System.out.printf("%2d.%10s%5d%10d",i+1,listFoods.get(i).getName(),listFoods.get(i).getQuantity(),listFoods.get(i).getPrice());
            System.out.println("\n");
        }
        System.out.println("||                           0. _<--<_ ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
//        xoá món ăn trong danh sách chọn
            System.out.print("lựa chọn: ");
            int luaChon = (int) checkInteger(0,listFoods.size());
            if(luaChon == 0) {
                hoaDonTamTinh();
            }else {
                listFoods.remove(luaChon - 1);
            }

        hoaDonTamTinh();
        luaChonThanhToan();
    }

    private static void suaMonAn() throws InterruptedException, FileNotFoundException {

        System.out.println(ANSI_BLUE + "\n|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||            TRANG SỬA MÓN ĂN        ||");
        System.out.println("||-------------------------------------||");
        System.out.println("||     1. SỬA MÓN KHAI VỊ              ||");
        System.out.println("||     2. SỬA MÓN HAI SẢN              ||");
        System.out.println("||     3. SỬA MÓN RỪNG                 ||");
        System.out.println("||     4. SỬA MÓN LẪU                  ||");
        System.out.println("||     5. SỬA ĐỒ UỐNG                  ||");
        System.out.println("||                           0. _<--<_ ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        int option;
        do {
            System.out.print(ANSI_BLUE + "chọn: ");
            option = (int) checkInteger(0,5);
            switch (option) {
                case 0 :
                    addmin();
                    break;
                case 1 :
                    List <MonKhaiVi> monKhaiVi = ReadFile.readMonKhaiVi();
                    System.out.print("Nhập tên món: ");
                    String name = check.checkString();
                    for (MonKhaiVi khaiVi : monKhaiVi) {
                        if(khaiVi.getName().equals(name)) {
                            System.out.print("Nhập tên mới: ");
                            String newName= check.checkString();
                            khaiVi.setName(newName);
                            System.out.print("Nhập giá: ");
                            int newPrice = (int) checkInteger(0,1000);
                            khaiVi.setPrice(newPrice);
                            System.out.print("Nhập số lượng: ");
                            khaiVi.setQuantity(1000);
                            WriteFileKhaiVi.writeToFileKhaiVi(monKhaiVi);
                        }
                    }
                    break;
                case 2 :
                    List <MonHaiSan> monHaiSan = ReadFile.readMonHaiSan();
                    System.out.print("Nhập tên món: ");
                    String ten = check.checkString();
                    for (MonHaiSan haiSan : monHaiSan) {
                        if(haiSan.getName().equals(ten)) {
                            System.out.print("Nhập tên mới: ");
                            String newName= check.checkString();
                            haiSan.setName(newName);
                            System.out.print("Nhập giá: ");
                            int newPrice = (int) checkInteger(0,1000);
                            haiSan.setPrice(newPrice);
                            System.out.print("Nhập số lượng: ");
                            haiSan.setQuantity(1000);
                            WriteFileHaiSan.writeToFileHaiSan(monHaiSan);
                        }
                    }
                    break;
                case 3 :
                    List <MonRung> monRung = ReadFile.readMonRung();
                    System.out.print("Nhập tên món: ");
                    String mon = check.checkString();
                    for (MonRung mr : monRung) {
                        if (mr.getName().equals(mon)) {
                            System.out.println("Nhập tên mới: ");
                            String newName = check.checkString();
                            mr.setName(newName);
                            System.out.println("Nhập giá: ");
                            int newPrice = (int) checkInteger(0, 1000);
                            mr.setPrice(newPrice);
                            System.out.print("Nhập số lượng: ");
                            mr.setQuantity(1000);
                            WriteFileMonRung.writeToFileMonRung(monRung);
                        }
                    }
                    break;
                case 4 :
                    List<MonLau> lau = ReadFile.readMonLau();
                    System.out.print("Nhập tên món: ");
                    String monL = check.checkString();
                    for (MonLau monLau : lau) {
                        if (monLau.getName().equals(monL)) {
                            System.out.println("Nhập tên mới: ");
                            String newName = check.checkString();
                            monLau.setName(newName);
                            System.out.println("Nhập giá: ");
                            int newPrice = (int) checkInteger(0, 1000);
                            monLau.setPrice(newPrice);
                            System.out.print("Nhập số lượng: ");
                            monLau.setQuantity(1000);
                            WriteFileMonLau.writeFileMonLau(lau);
                        }
                    }
                    break;
                case 5 :
                    List<DoUong> douong = ReadFile.readDoUong();
                    System.out.print("Nhập tên món: ");
                    String du = check.checkString();
                    for (DoUong doU : douong) {
                        if (doU.getName().equals(du)) {
                            System.out.println("Nhập tên mới: ");
                            String newName = check.checkString();
                            doU.setName(newName);
                            System.out.println("Nhập giá: ");
                            int newPrice = (int) checkInteger(0, 1000);
                            doU.setPrice(newPrice);
                            System.out.print("Nhập số lượng: ");
                            doU.setQuantity(1000);
                            WriteFileDoUong.writeToFileDoUong(douong);
                        }
                    }
                    break;
            }
        }while (option != 0);
    }

    private static void addMonAn() throws InterruptedException, FileNotFoundException {
        System.out.println(ANSI_BLUE + "\n|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||            TRANG THÊM MÓN ĂN        ||");
        System.out.println("||-------------------------------------||");
        System.out.println("||     1. THÊM MÓN KHAI VỊ             ||");
        System.out.println("||     2. THÊM MÓN HAI SẢN             ||");
        System.out.println("||     3. THÊM MÓN RỪNG                ||");
        System.out.println("||     4. THÊM MÓN LẪU                 ||");
        System.out.println("||     5. THÊM ĐỒ UỐNG                 ||");
        System.out.println("||                           0. _<--<_ ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        int selectThemMon;
        do {
            System.out.print(ANSI_YELLOW + "Chọn: ");
            selectThemMon = (int) checkInteger(0,5);
            switch (selectThemMon)
            {
                case 0 :
                    addmin();
                    break;
                case 1 :
                    System.out.print("Nhập số món: ");
                    int n = (int) checkInteger(1,3);
                    for(int i = 0; i < n; i++ ){
                        System.out.print("Món " + (i + 1) + ": " );
                        String name = check.checkString();
                        System.out.print("Giá: " );
                        int price = (int) checkInteger(0,1000);
                        System.out.print("số lượng : ");
                        int quantity = (int) checkInteger(0,1000);
                        monKhaiVi.add(new MonKhaiVi(name,price,quantity));
                    }
                    WriteFileKhaiVi.writeToFileKhaiVi(monKhaiVi);
                    break;
                case 2 :
                    System.out.print("Nhập số món: ");
                    int m = (int) checkInteger(1,3);
                    for(int i = 0; i < m; i++ ){
                        System.out.print("Món " + (i + 1) + ": " );
                        String name = check.checkString();
                        System.out.print("Giá: " );
                        int price = (int) checkInteger(0,1000);
                        System.out.print("số lượng : ");
                        int quantity = (int) checkInteger(0,1000);
                        listHaiSan.add(new MonHaiSan(name,price,quantity));
                    }
                    WriteFileHaiSan.writeToFileHaiSan(listHaiSan);
                    break;
                case 3 :
                    System.out.print("Nhập số món: ");
                    int k = (int) checkInteger(1,3);
                    for(int i = 0; i < k; i++ ){
                        System.out.print("Món " +( i + 1) + ": " );
                        String name = check.checkString();
                        System.out.print("Giá: " );
                        int price = (int) checkInteger(0,1000);
                        System.out.print("số lượng : ");
                        int quantity = (int) checkInteger(0,1000);
                        listMonRung.add(new MonRung(name,price,quantity));
                    }
                    WriteFileMonRung.writeToFileMonRung(listMonRung);
                    break;
                case 4 :
                    System.out.print("Nhập số món: ");
                    int h = (int) checkInteger(1,3);
                    for(int i = 0; i < h; i++ ){
                        System.out.print("Món " +( i + 1 )+ ": " );
                        String name = check.checkString();
                        System.out.print("Giá: " );
                        int price = (int) checkInteger(0,1000);
                        System.out.print("số lượng : ");
                        int quantity = (int) checkInteger(0,1000);
                        listMonLau.add(new MonLau(name,price,quantity));
                    }
                    WriteFileMonLau.writeFileMonLau(listMonLau);
                    break;
                case 5 :
                    System.out.print("Nhập số món: ");
                    int e = (int) checkInteger(1,3);
                    for(int i = 0; i < e; i++ ){
                        System.out.print("Món " + (i + 1) + ": " );
                        String name = check.checkString();
                        System.out.print("Giá: " );
                        int price = (int) checkInteger(0,1000);
                        System.out.print("số lượng : ");
                        int quantity = (int) checkInteger(0,1000);
                        listDoUong.add(new DoUong(name,price,quantity));
                    }
                    WriteFileDoUong.writeToFileDoUong(listDoUong);
                    break;
            }
        }while (selectThemMon != 0);
    }


    public static void cachDungBua() throws FileNotFoundException, InterruptedException {
        System.out.println(ANSI_YELLOW + "\n|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||      BẠN MUỐN DÙNG BỮA Ở ĐÂU?       ||");
        System.out.println("-----------------------------------------");
        System.out.println("||     1. TẠI NHÀ HÀNG                 ||");
        System.out.println("||     2. MANG VỀ                      ||");
        System.out.println("||                           0. _Thoát_||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        while (true) {
            System.out.print(ANSI_YELLOW + "Chọn: ");
            int select = (int) checkInteger(0,2);
            switch (select)
            {
                case 0 :
//                    Chạy dòng goodbye...
                    threadGoodBye.start();
                    threadGoodBye.join();
                    System.exit(0);
                case 1 :
                    Restaurant.chonBan();
                    break;
                case 2 :
                    menu();
                    break;

            }
        }
    }


    public static void hoaDonTamTinh() throws FileNotFoundException, InterruptedException {
        if(listFoods.size() == 0) {
            System.out.println("\nDanh sách trống.");
        }else {
            int totalPrice = 0;
            System.out.println(ANSI_YELLOW + "\n------------HOÁ ĐƠN TẠM TÍNH--------------");
            System.out.printf("\n%2s.%15s%10s%10s", "STT", "TÊN", "SL", "TỔNG");
            for (int i = 0; i < listFoods.size(); i++) {
                System.out.printf("\n%2d.%15s%10d%10d", i + 1, listFoods.get(i).getName(), listFoods.get(i).getQuantity(), listFoods.get(i).getPrice());
                System.out.println("\n");
            }
            for (FoodsObj o : listFoods) {
                totalPrice += o.getPrice();
            }
            System.out.println("\nTotal: " + totalPrice + " k");
            System.out.println("Thời gian: " + java.time.LocalDateTime.now());
            System.out.println("-----------------------------------------");
            luaChonThanhToan();
        }
    }

}
