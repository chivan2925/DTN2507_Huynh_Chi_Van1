package DAO;

import entity.Department;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    private Connection connection;

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }

    // Hàm thêm phòng ban (Create operation)
    public boolean addDepartment(String name, String description) {
        
        String query = "INSERT INTO department (DepartmentName) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm phòng ban: " + e.getMessage());
            return false;
        }
    }

    // Hàm sửa phòng ban (Update operation)
    public boolean updateDepartment(int id, String name, String description) {
        String query = "UPDATE department SET DepartmentName = ? WHERE DepartmentID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, id);
            
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi khi sửa phòng ban: " + e.getMessage());
            return false;
        }
    }

    // Hàm xóa phòng ban (Delete operation)
    public boolean deleteDepartment(int id) {
        String query = "DELETE FROM department WHERE DepartmentID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa phòng ban: " + e.getMessage());
            return false;
        }
    }

    // Hàm lấy phòng ban theo ID (Read operation)
    public Department getDepartmentById(int id) {
        String query = "SELECT DepartmentID, DepartmentName FROM department WHERE DepartmentID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToDepartment(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy phòng ban theo ID: " + e.getMessage());
        }
        return null;
    }

    // Hàm lấy tất cả phòng ban (Read operation)
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT DepartmentID, DepartmentName FROM department";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                departments.add(mapResultSetToDepartment(rs));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy tất cả phòng ban: " + e.getMessage());
        }
        return departments;
    }

    // Phương thức trợ giúp để ánh xạ ResultSet sang đối tượng Department
    private Department mapResultSetToDepartment(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("DepartmentID"));
        department.setName(rs.getString("DepartmentName"));
        return department;
    }
}
