// package frontend;

// public class Program {
//     public static void main(String[] args) {
// // menu

// // function
//     }
// }
package frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import utils.ScannerUtils;

public class Program {
	public static void main(String[] args) throws Exception {
		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Quan ly phong ban.");
			System.out.format(leftAlignFormat, "2. thoat chuong trinh.");
			// System.out.format(leftAlignFormat, "3. Quản lý vị trí.");
			// System.out.format(leftAlignFormat, "4. Thoát chương trình.");
			switch (ScannerUtils.inputIntPositive()) {
			case 1:
				getMenuDepartment();
				break;
			case 2:
				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}

	}

	// private static void getMenuPosition()
	// 		throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
	// 	PositionFunciton positionFunciton = new PositionFunciton();
	// 	while (true) {
	// 		String leftAlignFormat = "| %-72s |%n";
	// 		System.out.format("+--------------------------------------------------------------------------+%n");
	// 		System.out.format("|                        Choose please                                     |%n");
	// 		System.out.format("+--------------------------------------------------------------------------+%n");
	// 		System.out.format(leftAlignFormat, "1. Get list possition");
	// 		System.out.format(leftAlignFormat, "2. Get possition by id");
	// 		System.out.format(leftAlignFormat, "3. Exit");
	// 		System.out.format("+--------------------------------------------------------------------------+%n");
	// 		switch (ScannerUtils.inputIntPositive()) {
	// 		case 1:
	// 			positionFunciton.getListPossition();
	// 			break;
	// 		case 2:
	// 			positionFunciton.getPossitonByID();
	// 			;
	// 			break;
	// 		case 3:
	// 			return;
	// 		default:
	// 			System.out.println("Nhập lại:");
	// 			break;
	// 		}
	// 	}

	// }

	private static void getMenuDepartment() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		DepartmentProgram departmentFunction = new DepartmentProgram
        ();
		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Get list department");
			System.out.format(leftAlignFormat, "2. Get department by id");
			System.out.format(leftAlignFormat, "3. Check department name exists");
			System.out.format(leftAlignFormat, "4. create new department");
			System.out.format(leftAlignFormat, "5. update department");
			System.out.format(leftAlignFormat, "6. Delete department ID");
			System.out.format(leftAlignFormat, "7. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUtils.inputIntPositive()) {
			case 1:
				departmentFunction.getListDepartment();
				break;
			case 2:
				departmentFunction.getDepByID();
				;
				break;
			case 3:
				departmentFunction.isDepartmentNameExists();
				;
				break;
			case 4:
				departmentFunction.createDep();
				;
				break;
			case 5:
				departmentFunction.updateDepartmentName();
				;
				break;
			case 6:
				departmentFunction.delDepByID();
				;
				break;
			case 7:
				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}

	}

	// private static void getMenuAccount() throws Exception {
	// 	AccountFunction accountFunction = new AccountFunction();
	// 	while (true) {
	// 		String leftAlignFormat = "| %-72s |%n";
	// 		System.out.format("+--------------------------------------------------------------------------+%n");
	// 		System.out.format("|                        Choose please                                     |%n");
	// 		System.out.format("+--------------------------------------------------------------------------+%n");
	// 		System.out.format(leftAlignFormat, "1. Read data – get list account");
	// 		System.out.format(leftAlignFormat, "2. Read data – get account by id");
	// 		System.out.format(leftAlignFormat, "3. Check account name exists");
	// 		System.out.format(leftAlignFormat, "4. create account");
	// 		System.out.format(leftAlignFormat, "5. update account");
	// 		System.out.format(leftAlignFormat, "6. Delete by ID");
	// 		System.out.format(leftAlignFormat, "7. Exit");
	// 		System.out.format("+--------------------------------------------------------------------------+%n");
	// 		switch (ScannerUtils.inputIntPositive()) {
	// 		case 1:
	// 			accountFunction.getListAllAccount();
	// 			break;
	// 		case 2:
	// 			accountFunction.getAccountByID();
	// 			break;
	// 		case 3:
	// 			accountFunction.isAccNameExists();
	// 			break;
	// 		case 4:
	// 			accountFunction.createAccount();
	// 			break;
	// 		case 5:
	// 			accountFunction.updateAccount();
	// 			break;
	// 		case 6:
	// 			accountFunction.deleteById();
	// 			break;
	// 		case 7:
	// 			return;
	// 		default:
	// 			System.out.println("Nhập lại:");
	// 			break;
	// 		}
	// 	}
	// }

}
