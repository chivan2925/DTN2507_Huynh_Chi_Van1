package assignment4.E1.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import assignment4.E1.entityE1.CanBo;

public class QLCB {
    private List<CanBo> danhSachCanBo;

    public QLCB() {
        this.danhSachCanBo = new ArrayList<>();
    }

    // a) Them moi can bo
    public void themMoiCanBo(CanBo cb) {
        this.danhSachCanBo.add(cb);
        System.out.println("Da them can bo " + cb.getHoTen() + " vao danh sach.");
    }

    // b) Tim kiem theo ho ten
    public void timKiemTheoHoTen(String hoTenTimKiem) {
        List<CanBo> ketQua = this.danhSachCanBo.stream()
            .filter(cb -> cb.getHoTen().equalsIgnoreCase(hoTenTimKiem))
            .collect(Collectors.toList());

        if (ketQua.isEmpty()) {
            System.out.println("Khong tim thay can bo nao co ten: " + hoTenTimKiem);
        } else {
            System.out.println("Ket qua tim kiem cho '" + hoTenTimKiem + "':");
            for (CanBo cb : ketQua) {
                cb.showInfo();
            }
        }
    }

    // c) Hien thi thong tin ve danh sach cac can bo
    public void hienThiDanhSachCanBo() {
        if (this.danhSachCanBo.isEmpty()) {
            System.out.println("Danh sach can bo hien dang trong.");
            return;
        }

        System.out.println("\n DANH SACH TAT CA CAN BO (" + this.danhSachCanBo.size() + " nguoi)");
        for (CanBo cb : this.danhSachCanBo) {
            String loaiCB = cb.getClass().getSimpleName(); 
            System.out.println("Loai: " + loaiCB);
            cb.showInfo();
        }
    }

    // d) Xoa can bo theo ho ten
    public void xoaCanBoTheoHoTen(String hoTenXoa) {
        List<CanBo> canBoCanXoa = this.danhSachCanBo.stream()
            .filter(cb -> cb.getHoTen().equalsIgnoreCase(hoTenXoa))
            .collect(Collectors.toList());

        if (canBoCanXoa.isEmpty()) {
            System.out.println("Khong tim thay can bo nao co ten '" + hoTenXoa + "' de xoa.");
        } else {
            this.danhSachCanBo.removeAll(canBoCanXoa);
            System.out.println("Da xoa thanh cong " + canBoCanXoa.size() + " can bo co ten: " + hoTenXoa);
        }
    }
}