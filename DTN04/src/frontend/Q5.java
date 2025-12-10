import java.util.Scanner;

public class Q5 {

    public static int inputAge() {
        Scanner scanner = new Scanner(System.in);
        int tuoi = 0;
        boolean value = false;
        do {
            System.out.print("Moi ban nhap vao so tuoi: ");    
            try {
                String input = scanner.nextLine();       
                tuoi = Integer.parseInt(input); 
                if (tuoi < 0) {
                    System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
                    value = false;
                } else {
                    value = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("wrong inputing! Please input an age as int, input again.");
                value = false;
            }

        } while (!value);

        return tuoi;
    }

    public static void main(String[] args) {
        System.out.println("--- Chuong trinh bat dau ---");
        
        int ageResult = inputAge();
        
        System.out.println("--- Chuong trinh ket thuc ---");
        System.out.println("Ban da nhap thanh cong. So tuoi la: " + ageResult);
    }
}