package frontend;

import java.sql.*;
import java.util.Scanner;

public class Program {
    static String url = "jdbc:mysql://localhost:3307/testingsystem";
    static String user = "root";
    static String password = "";
    
    // Danh sach cac position hop le
    static String[] validPositions = {"Dev", "Test", "Scrum Master", "PM"};
    
    public static void main(String[] args) {
        // Cau hoi 1: Kiem tra ket noi
        if (testConnection()) {
            System.out.println("Connect success!");
        }
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("\nmoi ban nhap");
            System.out.println("1. Hien thi tat ca cac vi tri (Cau 2)");
            System.out.println("2. Tao vi tri moi (Cau 3)");
            System.out.println("3. Cap nhat vi tri id=5 thanh 'Dev' (Cau 4)");
            System.out.println("4. Xoa vi tri (Cau 5)");
            System.out.println("5. Thoat");
            System.out.print("Chon lua chon: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice) {
                case 1:
                    hienThiTatCaViTri();
                    break;
                case 2:
                    System.out.println("Cac vi tri hop le: Dev, Test, Scrum Master, PM");
                    System.out.print("Nhap ten vi tri: ");
                    String tenViTri = scanner.nextLine();
                    taoViTri(tenViTri);
                    break;
                case 3:
                    capNhatViTri(5, "Dev");
                    break;
                case 4:
                    System.out.print("Nhap id vi tri can xoa: ");
                    int idViTri = scanner.nextInt();
                    xoaViTri(idViTri);
                    break;
                case 5:
                    running = false;
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
        scanner.close();
    }
    
    // Cau hoi 1: Kiem tra ket noi
    public static boolean testConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            connection.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Cau hoi 2: Hien thi tat ca vi tri (id, ten)
    public static void hienThiTatCaViTri() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT PositionID, PositionName FROM position";
            ResultSet resultSet = statement.executeQuery(sql);
            
            System.out.println("\n========== DANH SACH VI TRI ==========");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("PositionID") + 
                                 " | Ten: " + resultSet.getString("PositionName"));
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Cau hoi 3: Tao vi tri moi
    public static void taoViTri(String tenViTri) {
        Connection connection = null;
        try {
            // Kiem tra do dai ten vi tri
            if (tenViTri == null || tenViTri.trim().isEmpty()) {
                System.out.println("Ten vi tri khong the trong!");
                return;
            }
            
            // Kiem tra xem ten vi tri co hop le khong
            if (!isValidPosition(tenViTri)) {
                System.out.println("Ten vi tri khong hop le! Cac gia tri hop le: Dev, Test, Scrum Master, PM");
                return;
            }
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO position (PositionName) VALUES (?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, tenViTri);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Vi tri '" + tenViTri + "' da duoc tao thanh cong!");
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Loi SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Khong tim thay driver: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Cau hoi 4: Cap nhat vi tri co id=5 thanh "Dev"
    public static void capNhatViTri(int idViTri, String tenMoi) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            String sql = "UPDATE position SET PositionName = ? WHERE PositionID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, tenMoi);
            pstmt.setInt(2, idViTri);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Vi tri id=" + idViTri + " da cap nhat thanh '" + tenMoi + "' thanh cong!");
            } else {
                System.out.println("Vi tri id=" + idViTri + " khong ton tai!");
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Loi SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Khong tim thay driver: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Cau hoi 5: Xoa vi tri theo id
    public static void xoaViTri(int idViTri) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM position WHERE PositionID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, idViTri);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Vi tri id=" + idViTri + " da xoa thanh cong!");
            } else {
                System.out.println("Vi tri id=" + idViTri + " khong ton tai!");
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Loi SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Khong tim thay driver: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Ham kiem tra xem position co hop le khong
    public static boolean isValidPosition(String positionName) {
        for (String valid : validPositions) {
            if (valid.equalsIgnoreCase(positionName)) {
                return true;
            }
        }
        return false;
    }
}