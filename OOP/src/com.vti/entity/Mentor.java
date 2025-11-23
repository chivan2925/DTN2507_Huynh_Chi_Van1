
public class Mentor extends Account {
    private int namKinhNghiem;
    public Mentor(int id, String email, String username, String fullname, int namKinhNghiem) {
        super(id, email, username, fullname);
        this.namKinhNghiem = namKinhNghiem;
    }
    public Mentor() {
        super(); 
    }
    public int getNamKinhNghiem() {
        return namKinhNghiem;
    }

    public void setNamKinhNghiem(int namKinhNghiem) {
        this.namKinhNghiem = namKinhNghiem;
    }

    public void showInfoMentor(){
        super.showInfo();
        System.out.println("Năm kinh nghiệm: " + getNamKinhNghiem() + " năm");
    }

    
    @Override
    public String toString() {
        return "Mentor [id=" + getId() 
                + ", email=" + getEmail()
               + ", username=" + getUsername() 
               + ", fullname=" + getFullname()
               + ", namKinhNghiem=" + namKinhNghiem + " năm]";
    }
}