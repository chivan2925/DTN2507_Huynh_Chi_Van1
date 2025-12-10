package backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.businesslayer.DepartmentService;
import backend.businesslayer.IDepartmentService;
import entity.Department;

public class DepartmentController {
	private IDepartmentService departmentService;

	public DepartmentController() throws FileNotFoundException, IOException {
		departmentService = new DepartmentService();

	}

	public List<Department> getListDepartment() throws SQLException, ClassNotFoundException {

		return departmentService.getListDepartment();

	}

	public Department getDepByID(int id) throws SQLException, ClassNotFoundException {

		return departmentService.getDepByID(id);
	}

	public Boolean isDepartmentNameExists(String name) throws SQLException {

		return departmentService.isDepartmentNameExists(name);
	}

	public boolean createDep(String name) throws SQLException, ClassNotFoundException {

		return departmentService.createDep(name);
	}

	public boolean updateDepartmentName(int id, String newName) throws SQLException, ClassNotFoundException {

		return departmentService.updateDepartmentName(id, newName);
	}

	public boolean delDepByID(int id) throws SQLException, ClassNotFoundException {

		return departmentService.delDepByID(id);
	}
    

}
