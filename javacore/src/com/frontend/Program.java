import src.com.entity.Student;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int a = 5;
        int b= 4;
        Gender gender = Gender.MALE;
        System.out.println(a+b);
        

        String[] name = {"abc","def","ghi"};

        int[] numbers = {1,2,3,4,5};
        
        Student st1 = new Student();
        st1.id = 1;
        st1.name = "Nguyen Van A";
        st1.email = "A@gmail.com";

        System.out.println("ID: " + st1.id);
    }   
    public boolean laNT(){
        return true;
    }
    public enum Gender{
        MALE, FEMALE;
    }
    
}
