package assignment4.E1.entity;
public class CanBo {
    private String hoTen;
    private int tuoi;
    private String gioiTinh; 
    private String diaChi;

    public CanBo(String hoTen, int tuoi, String gioiTinh, String diaChi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }
    
    
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void showInfo() {
        System.out.println("thong tin can bo:");
        System.out.println("Ho ten: " + hoTen);
        System.out.println("tuoi " + tuoi);
        System.out.println("gioi tinh " + gioiTinh);
        System.out.println("dia chi " + diaChi);
    }
}