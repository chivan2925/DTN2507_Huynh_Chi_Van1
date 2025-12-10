package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	private static Properties property = new Properties();
	static {
		try (InputStream input = JdbcUtils.class.getClassLoader().getResourceAsStream("database.properties")) {
			if (input == null) {
				System.err.println("Không tìm thấy file database.properties");
			} else {
				property.load(input);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		String url = property.getProperty("db.url");
		String username = property.getProperty("db.user");
		String password = property.getProperty("db.password");
		// Không cần Class.forName(driver) với các driver JDBC hiện đại
		return DriverManager.getConnection(url, username, password);
	}
}
