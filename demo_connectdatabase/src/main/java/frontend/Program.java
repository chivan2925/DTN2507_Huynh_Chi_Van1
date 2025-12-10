package frontend;

import DAO.DepartmentDAO;
import backend.DepartmentBE;
import entity.Department;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
       
        Properties properties = new Properties();
        try (InputStream input = Program.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                System.out.println("Không tìm thấy file database.properties");
                return;
                
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        try {
            // Tải driver một cách tường minh
            String driver = properties.getProperty("db.driver");
            if (driver != null && !driver.isEmpty()) {
                Class.forName(driver);
            }

            Connection connection = DriverManager.getConnection(url, user, password);
            DepartmentDAO departmentDAO = new DepartmentDAO(connection);
            DepartmentBE departmentBE = new DepartmentBE(departmentDAO);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                printMenu();
                int choice = -1;
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Lựa chọn phải là một số. Vui lòng thử lại.");
                    scanner.nextLine(); // Xóa bộ đệm đầu vào
                    continue; // Quay lại đầu vòng lặp
                }
                scanner.nextLine(); // Tiêu thụ ký tự dòng mới còn lại

                switch (choice) {
                    case 1:
                        showAllDepartments(departmentBE);
                        break;
                    case 2:
                        findDepartmentById(departmentBE, scanner);
                        break;
                    case 3:
                        addNewDepartment(departmentBE, scanner);
                        break;
                    case 4:
                        updateDepartmentInfo(departmentBE, scanner);
                        break;
                    case 5:
                        deleteDepartmentById(departmentBE, scanner);
                        break;
                    case 0:
                        System.out.println("Đã thoát chương trình.");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu: " + e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println("\n===== MENU QUẢN LÝ PHÒNG BAN =====");
        System.out.println("1. Xem danh sách tất cả phòng ban");
        System.out.println("2. Tìm phòng ban theo ID");
        System.out.println("3. Thêm phòng ban mới");
        System.out.println("4. Cập nhật thông tin phòng ban");
        System.out.println("5. Xóa phòng ban");
        System.out.println("0. Thoát");
        System.out.print("Mời bạn chọn chức năng: ");
    }

    private static void showAllDepartments(DepartmentBE departmentBE) {
        System.out.println("\n--- DANH SÁCH PHÒNG BAN ---");
        List<Department> departments = departmentBE.getAllDepartments();
        if (departments.isEmpty()) {
            System.out.println("Không có phòng ban nào.");
        } else {
            for (Department dept : departments) {
                System.out.printf("ID: %d, Tên: %s\n", dept.getId(), dept.getName());
            }
        }
    }

    private static void findDepartmentById(DepartmentBE departmentBE, Scanner scanner) {
        System.out.print("Nhập ID phòng ban cần tìm: ");
        int id;
        try {
            id = scanner.nextInt();
            scanner.nextLine(); // Tiêu thụ ký tự dòng mới
        } catch (InputMismatchException e) {
            System.out.println("ID phải là một số nguyên. Thao tác đã bị hủy.");
            scanner.nextLine(); // Xóa bộ đệm
            return;
        }
        Department dept = departmentBE.getDepartmentById(id);
        if (dept != null) {
            System.out.println("--- THÔNG TIN PHÒNG BAN ---");
            System.out.printf("ID: %d, Tên: %s\n", dept.getId(), dept.getName());
        } else {
            System.out.println("Không tìm thấy phòng ban với ID = " + id);
        }
    }

    private static void addNewDepartment(DepartmentBE departmentBE, Scanner scanner) {
        System.out.println("\n--- THÊM PHÒNG BAN MỚI ---");
        System.out.print("Nhập tên phòng ban: ");
        String name = scanner.nextLine();
        // Bỏ qua việc nhập mô tả
        if (departmentBE.addDepartment(name, null)) { // Truyền null cho description
            System.out.println("Thêm phòng ban thành công!");
        } else {
            System.out.println("Thêm phòng ban thất bại.");
        }
    }

    private static void updateDepartmentInfo(DepartmentBE departmentBE, Scanner scanner) {
        System.out.println("\n--- CẬP NHẬT PHÒNG BAN ---");
        System.out.print("Nhập ID phòng ban cần cập nhật: ");
        int id;
        try {
            id = scanner.nextInt();
            scanner.nextLine(); // Tiêu thụ ký tự dòng mới
        } catch (InputMismatchException e) {
            System.out.println("ID phải là một số nguyên. Thao tác đã bị hủy.");
            scanner.nextLine(); // Xóa bộ đệm
            return;
        }
        System.out.print("Nhập tên mới: ");
        String name = scanner.nextLine();
        // Bỏ qua việc nhập mô tả
        if (departmentBE.updateDepartment(id, name, null)) { // Truyền null cho description
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Cập nhật thất bại (có thể do ID không tồn tại).");
        }
    }

    private static void deleteDepartmentById(DepartmentBE departmentBE, Scanner scanner) {
        System.out.println("\n--- XÓA PHÒNG BAN ---");
        System.out.print("Nhập ID phòng ban cần xóa: ");
        int id;
        try {
            id = scanner.nextInt();
            scanner.nextLine(); // Tiêu thụ ký tự dòng mới
        } catch (InputMismatchException e) {
            System.out.println("ID phải là một số nguyên. Thao tác đã bị hủy.");
            scanner.nextLine(); // Xóa bộ đệm
            return;
        }
        if (departmentBE.deleteDepartment(id)) {
            System.out.println("Xóa phòng ban thành công!");
        } else {
            System.out.println("Xóa thất bại (có thể do ID không tồn tại).");
        }
    }
}