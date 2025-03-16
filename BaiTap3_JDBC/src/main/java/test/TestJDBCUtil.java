package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class TestJDBCUtil {
	public static void main(String[] args) {

		try {
			// Bước 1: Tạo kết nối
			Connection connection = JDBCUtil.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = connection.createStatement();

			// Bước 3: Thực thi 1 câu lệnh SQL
			String sql = "INSERT INTO person(person_id,last_name, first_name, gender, dob, income)" + "VALUE"
					+ "(3,\"Tran\", \"Thi C\", \"F\", \"2000-05-10\", 20000000);";

			int check = st.executeUpdate(sql);

			// Bước 4: Xử lý kết quả
			System.out.println("Số dòng thay đổi:" + check);
			if (check > 0) {
				System.out.println("Thêm dữ liệu thành công");
			} else {
				System.out.println("Thêm dữ liệu thất bại");
			}

			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
