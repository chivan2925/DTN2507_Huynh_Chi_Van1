package backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Department;
import utils.JdbcUtils;

public class DepartmentRepository implements IDepartmentRepository {
    private JdbcUtils jdbcUtils;
	public DepartmentRepository() throws FileNotFoundException, IOException {
        jdbcUtils = new JdbcUtils();
	}

	@Override
	public List<Department> getListDepartment() throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Department ORDER BY DepartmentID";
		List<Department> listDep = new ArrayList<Department>();

		try (Connection connection = jdbcUtils.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {

			while (resultSet.next()) {
				Department dep = new Department(resultSet.getInt("DepartmentID"), resultSet.getString("DepartmentName"));
				listDep.add(dep);
			}
		}
		return listDep;
	}

	@Override
	public Department getDepByID(int id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Department WHERE DepartmentID = ?";

		try (Connection connection = jdbcUtils.getConnection();
				PreparedStatement preStatement = connection.prepareStatement(sql)) {

			preStatement.setInt(1, id);
			try (ResultSet result = preStatement.executeQuery()) {
				if (result.next()) {
					return new Department(result.getInt("DepartmentID"), result.getString("DepartmentName"));
				}
			}
		}
		return null;
	}

	@Override
	public Boolean isDepartmentNameExists(String name) throws SQLException {
		String sql = "SELECT * FROM Department WHERE DepartmentName = ?";

		try (Connection connection = jdbcUtils.getConnection();
				PreparedStatement preStatement = connection.prepareStatement(sql)) {

			preStatement.setString(1, name);
			try (ResultSet result = preStatement.executeQuery()) {
				return result.next();
			}
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public boolean createDep(String name) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO Department (DepartmentName) VALUES (?);";
		try (Connection connection = jdbcUtils.getConnection();
				PreparedStatement preStatement = connection.prepareStatement(sql)) {
			preStatement.setString(1, name);
			return preStatement.executeUpdate() > 0;
		}
	}

	@Override
	public boolean updateDepartmentName(int id, String newName) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE Department SET DepartmentName = ? WHERE DepartmentID = ?";
		try (Connection connection = jdbcUtils.getConnection();
				PreparedStatement preStatement = connection.prepareStatement(sql)) {
			preStatement.setString(1, newName);
			preStatement.setInt(2, id);
			return preStatement.executeUpdate() > 0;
		}
	}

	@Override
	public boolean delDepByID(int id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM department WHERE DepartmentID = ?";
		try (Connection connection = jdbcUtils.getConnection();
				PreparedStatement preStatement = connection.prepareStatement(sql)) {
			preStatement.setInt(1, id);
			return preStatement.executeUpdate() > 0;
		}
	}

}
