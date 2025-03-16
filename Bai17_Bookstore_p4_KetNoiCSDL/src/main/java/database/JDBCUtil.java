package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;

		try {
			// Kết nối với MySQL
			String url = "jdbc:mysql://localhost:3306/ontap?useSSL=false&serverTimezone=UTC";
			String username = "root";
			String password = "";

			// Tạo kết nối
			c = DriverManager.getConnection(url, username, password);
			System.out.println("Kết nối thành công!");

		} catch (SQLException e) {
			System.out.println("Lỗi kết nối database!");
			e.printStackTrace();
		}

		return c;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
				System.out.println("Đóng kết nối thành công!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void printInfo(Connection c) {
		try {
			if (c != null) {
				DatabaseMetaData metaData = c.getMetaData();
				System.out.println("Database: " + metaData.getDatabaseProductName());
				System.out.println("Version: " + metaData.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
