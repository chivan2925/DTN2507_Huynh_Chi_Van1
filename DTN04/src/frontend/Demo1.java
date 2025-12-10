// package DTN04.src.frontend;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");

        String[] nameAraay = new String[3];
        nameAraay[0] = "Van";
        // ArithmeticException
        //NumberFormatException
        try{
            // String numberString = "một";
            // int number = Integer.parseInt(numberString); // LỖI ở đây
            System.out.println(0/0);
        }catch(NumberFormatException e){ // ĐÃ SỬA: catch(Exception e)
            System.out.println("Loi roi nha");
        }

        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");

    }
}
