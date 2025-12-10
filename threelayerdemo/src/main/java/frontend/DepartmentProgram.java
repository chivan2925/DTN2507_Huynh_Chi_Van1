package frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.presentationlayer.DepartmentController;
import entity.Department;
import utils.ScannerUtils;

public class DepartmentProgram {
	private DepartmentController departmentController;

	public DepartmentProgram() throws FileNotFoundException, IOException {
		departmentController = new DepartmentController();

	}

	public void getListDepartment() throws SQLException, ClassNotFoundException {
		List<Department> listDep1 = departmentController.getListDepartment();
		String leftAlignFormat = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Department Name       |%n");
		System.out.format("+--------+-----------------------+%n");

		for (Department department : listDep1) {
			System.out.format(leftAlignFormat, department.getId(), department.getName());
		}
		System.out.format("+--------+-----------------------+%n");
	}

	public void getDepByID() throws SQLException, ClassNotFoundException {
		System.out.println("Tìm kiếm phòng theo ID: ");
		System.out.println("Nhập vào ID cần tìm kiếm: ");
		int idFind = ScannerUtils.inputIntPositive();
		Department depQues3 = departmentController.getDepByID(idFind);
		if (depQues3 != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Department Name       |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, depQues3.getId(), depQues3.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Không tồn tại phòng này trên HT");
		}

	}

	public void isDepartmentNameExists() throws SQLException, ClassNotFoundException {
		System.out.println("Kiểm tra tên phòng đã có trên hệ thông? ");
		System.out.println("Nhập vào tên cần kiểm tra: ");
		String nameCheck = ScannerUtils.inputString();
		Boolean checkResult = departmentController.isDepartmentNameExists(nameCheck);
		if (checkResult) {
			System.out.println("Tên đã có trên hệ thống.");
			getListDepartment();
		} else {
			System.out.println("Tên chưa có trên hệ thống.");
		}
	}

	public void createDep() throws SQLException, ClassNotFoundException {
		String newNameDep = getNewName();
		if (departmentController.createDep(newNameDep)) {
			System.out.println("Tạo thành công.");
			getListDepartment();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}

	}

	private String getNewName() throws SQLException {
		while (true) {
			System.out.println("Nhập vào tên phòng cần tạo: ");
			String newName = ScannerUtils.inputString();
			if (departmentController.isDepartmentNameExists(newName)) {
				System.out.println("Đã có phòng trên hệ thống");
			} else {
				return newName;
			}
		}
	}

	public void updateDepartmentName() throws SQLException, ClassNotFoundException {
		int updateID = getIdUpdate();
		System.out.println("Nhập vào tên cần Updare: ");
		String newName = ScannerUtils.inputString();
		if (departmentController.updateDepartmentName(updateID, newName)) {
			System.out.println("Update tên phòng thành công: ");
			getListDepartment();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}

	}

	private int getIdUpdate() throws SQLException, ClassNotFoundException {
		while (true) {
			System.out.println("Nhập ID phòng cần thao tác: ");
			int id = ScannerUtils.inputIntPositive();
			Department dep = departmentController.getDepByID(id);
			if (dep == null) {
				System.out.println("Không có ID này trên HT");
			} else {
				return id;
			}
		}
	}

	public void delDepByID() throws SQLException, ClassNotFoundException {
		int updateID = getIdUpdate();
		if (departmentController.delDepByID(updateID)) {
			System.out.println("Xóa phòng thành công");
			getListDepartment();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}
	}

}
