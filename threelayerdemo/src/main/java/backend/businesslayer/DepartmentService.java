package backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.datalayer.DepartmentRepository;
import entity.Department;

public class DepartmentService implements IDepartmentService {
	private DepartmentRepository departmentRepository;

	public DepartmentService() throws FileNotFoundException, IOException {
		departmentRepository = new DepartmentRepository();
	}

	@Override
	public List<Department> getListDepartment() throws SQLException, ClassNotFoundException {

		return departmentRepository.getListDepartment();
	}

	@Override
	public Department getDepByID(int id) throws SQLException, ClassNotFoundException {

		return departmentRepository.getDepByID(id);
	}

	@Override
	public Boolean isDepartmentNameExists(String name) throws SQLException {

		return departmentRepository.isDepartmentNameExists(name);
	}

	@Override
	public boolean createDep(String name) throws SQLException, ClassNotFoundException {

		return departmentRepository.createDep(name);
	}

	@Override
	public boolean updateDepartmentName(int id, String newName) throws SQLException, ClassNotFoundException {

		return departmentRepository.updateDepartmentName(id, newName);
	}

	@Override
	public boolean delDepByID(int id) throws SQLException, ClassNotFoundException {

		return departmentRepository.delDepByID(id);
	}

}
