package backend;

import DAO.DepartmentDAO;
import entity.Department;

import java.util.List;

public class DepartmentBE {
    private DepartmentDAO departmentDAO;

    public DepartmentBE(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    // Các phương thức nghiệp vụ gọi đến DAO
    public boolean addDepartment(String name, String description) {
        return departmentDAO.addDepartment(name, description);
    }

    public boolean updateDepartment(int id, String name, String description) {
        return departmentDAO.updateDepartment(id, name, description);
    }

    public boolean deleteDepartment(int id) {
        return departmentDAO.deleteDepartment(id);
    }

    public Department getDepartmentById(int id) {
        return departmentDAO.getDepartmentById(id);
    }

    public List<Department> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }
}