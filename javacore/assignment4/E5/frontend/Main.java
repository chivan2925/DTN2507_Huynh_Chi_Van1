package assignment4.E1.frontend;

import entity.*;

import java.util.Scanner;

import assignment4.E1.backendE1.QLCB;

public class Main {
    public static void main(String[] args) {
        QLCB quanLy = new QLCB();
        Scanner scanner = new Scanner(System.in);
        int luaChon = -1;

        while (luaChon != 5) { // e) Thoat khoi chuong trinh
            System.out.println("\n*** CHUONG TRINH QUAN LY CAN BO ***");
            System.out.println("1. Them moi can bo (a)");
            System.out.println("2. Tim kiem theo ho ten (b)");
            System.out.println("3. Hien thi thong tin danh sach (c)");
            System.out.println("4. Xoa can bo theo ho ten (d)");
            System.out.println("5. Thoat khoi chuong trinh (e)");
            System.out.print("Nhap lua chon cua ban: ");
            
            try {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    continue; 
                }
                luaChon = Integer.parseInt(input);
                
                switch (luaChon) {
                    case 1:
                        System.out.println("Ban da chon them moi. Can phai nhap thong tin chi tiet cho tung loai CB.");
                        break;
                    case 2:
                        System.out.print("Nhap ho ten can bo can tim: ");
                        String tenTim = scanner.nextLine();
                        quanLy.timKiemTheoHoTen(tenTim);
                        break;
                    case 3:
                        quanLy.hienThiDanhSachCanBo();
                        break;
                    case 4:
                        System.out.print("Nhap ho ten can bo can xoa: ");
                        String tenXoa = scanner.nextLine();
                        quanLy.xoaCanBoTheoHoTen(tenXoa);
                        break;
                    case 5:
                        System.out.println("Da thoat khoi chuong trinh QLCB. Hen gap lai!");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so.");
            }
        }
        scanner.close();
    }
}