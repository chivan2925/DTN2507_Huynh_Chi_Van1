package backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import entity.Department;

public interface IDepartmentService {
	public List<Department> getListDepartment() throws SQLException, ClassNotFoundException;

	public Department getDepByID(int id) throws SQLException, ClassNotFoundException;

	public Boolean isDepartmentNameExists(String name) throws SQLException;

	public boolean createDep(String name) throws SQLException, ClassNotFoundException;

	public boolean updateDepartmentName(int id, String newName) throws SQLException, ClassNotFoundException;

	public boolean delDepByID(int id) throws SQLException, ClassNotFoundException;
}
