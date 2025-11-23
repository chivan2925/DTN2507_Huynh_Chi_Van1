package bbb;
import java.util.ArrayList;
import java.util.Scanner;

public class MyNews {

    private static ArrayList<News> newsList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự xuống dòng
            } else {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số.");
                scanner.nextLine(); // Đọc bỏ input không hợp lệ
                choice = 0;
            }

            switch (choice) {
                case 1:
                    insertNews();
                    break;
                case 2:
                    viewListNews();
                    break;
                case 3:
                    averageRate();
                    break;
                case 4:
                    System.out.println("Thoát khỏi chương trình. Tạm biệt!");
                    break;
                default:
                    if (choice != 0) {
                        System.out.println("Lựa chọn không tồn tại. Vui lòng chọn lại (1-4).");
                    }
                    break;
            }
        } while (choice != 4);
        
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n===== MENU QUẢN LÝ TIN TỨC =====");
        System.out.println("1. Insert news");
        System.out.println("2. View list news");
        System.out.println("3. Average rate");
        System.out.println("4. Exit");
        System.out.print("Vui lòng chọn chức năng (1-4): ");
    }

    private static void insertNews() {
        News news = new News();
        news.setID(nextId++);

        System.out.println("\n--- Nhập thông tin Tin tức mới ---");
        System.out.print("Nhập Tiêu đề: ");
        news.setTitle(scanner.nextLine());
        
        System.out.print("Nhập Ngày xuất bản: ");
        news.setPublishDate(scanner.nextLine());

        System.out.print("Nhập Tác giả: ");
        news.setAuthor(scanner.nextLine());

        System.out.print("Nhập Nội dung: ");
        news.setContent(scanner.nextLine());
        
        int[] rates = new int[3];
        System.out.println("Vui lòng nhập 3 đánh giá (Rates) từ 1 đến 10:");
        for (int i = 0; i < 3; i++) {
            int rate = 0;
            boolean valid = false;
            while (!valid) {
                System.out.print("Đánh giá thứ " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    rate = scanner.nextInt();
                    if (rate >= 1 && rate <= 10) {
                        rates[i] = rate;
                        valid = true;
                    } else {
                        System.out.println("Đánh giá phải nằm trong khoảng 1-10.");
                    }
                } else {
                    System.out.println("Lỗi: Vui lòng nhập số nguyên.");
                    scanner.next();
                }
            }
        }
        scanner.nextLine();

        news.setRates(rates);
        newsList.add(news);
        System.out.println("Tin tức đã được thêm thành công! ID: " + news.getID());
    }

    private static void viewListNews() {
        if (newsList.isEmpty()) {
            System.out.println("Danh sách tin tức trống.");
            return;
        }
        System.out.println("\n--- DANH SÁCH TIN TỨC ĐÃ LƯU ---");
        for (News news : newsList) {
            news.Display();
        }
    }

    private static void averageRate() {
        if (newsList.isEmpty()) {
            System.out.println("Danh sách tin tức trống. Không thể tính trung bình.");
            return;
        }
        System.out.println("\n--- TÍNH ĐÁNH GIÁ TRUNG BÌNH ---");
        for (News news : newsList) {
            news.Calculate(); 
            System.out.println("Tin tức ID " + news.getID() + " - Tiêu đề: " + news.getTitle());
            news.Display();
        }
        System.out.println("Đã tính xong đánh giá trung bình cho tất cả tin tức.");
    }
}