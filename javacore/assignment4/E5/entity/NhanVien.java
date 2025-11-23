package assignment4.E1.entity;
public class NhanVien extends CanBo {
    private String congViec;

    public NhanVien(String hoTen, int tuoi, String gioiTinh, String diaChi, String congViec) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.congViec = congViec;
    }
    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("COng viec: " + congViec);
    }
}