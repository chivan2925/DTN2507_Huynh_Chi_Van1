
public abstract class Account {
    private int id;
    private String email;
    private String username;
    private String fullname;

    public Account() {
    }

    // Constructor đầy đủ 4 tham số
    public Account(int id, String email, String username, String fullname) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.fullname = fullname;
    }
    public abstract void goToVTI();
    // Getter & Setter đúng tên theo đúng 4 thuộc tính

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {           
        return username;
    }

    public void setUsername(String username) {  
        this.username = username;
    }

    public String getFullname() {           
        return fullname;
    }

    public void setFullname(String fullname) { 
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "Account [id=" + id 
               + ", email=" + email 
               + ", username=" + username 
               + ", fullname=" + fullname + "]";
    }
    public void showInfo(){
        System.out.println("ID        : " + getId());
        System.out.println("Email     : " + getEmail());
        System.out.println("Username  : " + getUsername());
        System.out.println("Fullname  : " + getFullname());
    }
}