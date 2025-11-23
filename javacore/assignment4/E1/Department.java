package assignment4.E1;

public class Department {
    private int id;
    private String nameDepartment;

    public Department(){
    }
    public Department(String nameDepartment) {
        this.id = 0;
        this.nameDepartment = nameDepartment;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setNameDepartment(String nameDepartment){
        this.nameDepartment = nameDepartment;
    }
    public int getId() {
         return id;
    }
    public String getNameDepartment(){
        return nameDepartment;
    }
    
    
}
