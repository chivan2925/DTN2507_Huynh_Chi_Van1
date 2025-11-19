import java.io.Console;
import java.text.DecimalFormat; 
import java.util.Random;
public class assigement {
    

    public int tinhTong(int a, int b) {
        return a + b;
    }

    // E1 Q1
    public void Q1(){
        float luong1 = 5240.5f;
        float luong2 = 10970.055f;
        int intLuong1 = (int) luong1;
        int intLuong2 = (int) luong2;
        System.out.println("Luong Account 1: " + intLuong1);
        System.out.println("Luong Account 2: " + intLuong2);
    }
    // Q2
    public static String question2_generateRandom5DigitString() {
        Random random = new Random();
        int randomNumber = random.nextInt(100000); 
        String numberString = String.valueOf(randomNumber);
        String formattedString = String.format("%05d", randomNumber);
        return formattedString;
    }
    // Q3

    public void Q3(String n1) { 
            int number = Integer.parseInt(n1);
            int n2 = number % 100;
            String haiSoCuoi = String.format("%02d", n2); 
            System.out.println("2 so cuoi la: " + haiSoCuoi);
    }
    public float Q4(float a, float b){
        if(a==0 || b==0){
            System.out.println("Khong the chia cho 0");
            return -1;
        }else{
            if(a>b){
                return (a/b);
            }else{
                return (b/a);
            }
        }
        
    }
    // E3 
    public void E3Q1(){
        int luongInt = 5000;
        float luongFloat = (float)luongInt;
        System.out.println(luongFloat);
    }
    

    public void E3Q2(){
        String valueString = "1234567";
        int valueInt = Integer.parseInt(valueString);
        System.out.println(valueInt);
    }

    //E4
    public int E4Q1(){
        //  Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có thể cách nhau bằng nhiều khoảng trắng );
        String abc = "    Huynh Chi Van";
        int dem =1;
        for(int i=0; i<abc.length(); i++){
            if(abc.charAt(i)==' ' && abc.charAt(i+1)!=' ' && abc.charAt(i-1)!=' '){
                dem++;  
            }
        }
        return dem;
    }

    public String E4Q2(String s1, String s2) {
        return s1 + s2; 
    }

    public String E4Q3(String abc){
        abc = "    Huynh Chi Van    ";
        String ketqua;
        for(int i=0; i<abc.length(); i++){
            if(abc.charAt(i)!=' ' && abc.charAt(i+1)!=' ' && abc.charAt(i-1)==' ' ||
              (abc.charAt(i)!=' ' && abc.charAt(i+1)==' ' && abc.charAt(i-1)==' ' )
         ){
                abc.charAt[i] = abc.charAt(i)
            }
        }
    }


    public static void main(String[] args) {
        int a;
        a = 10;
        float f = 10.5f;

        System.out.println("Gia tri a: " + a);
        Float f1 = 10.5f; 
        System.out.println("Gia tri f: " + f);
        assigement demo = new assigement();
        int tong = demo.tinhTong(a, (int)f); 
        System.out.println("tong " + tong);
        // nguyen thuy sang doi tuong
        Integer a_w = Integer.valueOf(a);
        // doi tuong sang nguyen thuy
        int b = a_w.intValue();

        // datatype Casting -- ep kieu
       

        double j=5.5f;
        int k= (int)j;
        System.out.println(k);
        
        demo.Q1();
        
        String myName = "Chi Van";
        String myAge = "20";
        
        System.out.println("So tu trong chuoi: " + demo.E4Q1());
        
    }
}