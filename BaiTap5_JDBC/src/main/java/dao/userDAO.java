package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.user;

public class userDAO implements DAOInterface<user> {

	public static userDAO getInstance() {
		return new userDAO();
	}

	public int insert(user t) {
		int ketQua = 0;
		try {
			// Bước 1: Tạo connection
			Connection c = JDBCUtil.getConnection();

			String sql = "INSERT INTO user (username, password, ho_va_ten) VALUES (?, ?, ?)";

			PreparedStatement pst = c.prepareStatement(sql);

			pst.setString(1, t.getUserName());
			pst.setString(2, t.getPassword());
			pst.setString(3, t.getHoVaTen());

			ketQua = pst.executeUpdate();

			// Bước 4: Xử lý dữ liệu
			System.out.println("Số dòng đã thay đổi:" + ketQua);
			// Bước 5: Đóng connection
			if (c != null) {
				JDBCUtil.closeConnection(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	public int update(user t) {
		int ketQua = 0;
		try {
			// Bước 1: Tạo connection
			Connection c = JDBCUtil.getConnection();
			// Bước 2: Viết câu lệnh sq;
			String sql = "UPDATE user SET" + " password = ?, ho_va_ten = ? WHERE username = ?";
			System.out.println(sql);
			// Bước 3: Tạo PreparedStatement
			PreparedStatement pst = c.prepareStatement(sql);

			pst.setString(1, t.getPassword());
			pst.setString(2, t.getHoVaTen());
			pst.setString(3, t.getUserName());

			ketQua = pst.executeUpdate();
			// Bước 4: Xử lý kết quả
			System.out.println("Số lượng dòng thay đổi:" + ketQua);

			// Bước 5: Ngắt kết nối
			if (c != null) {
				JDBCUtil.closeConnection(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	public int delete(user t) {
		int ketQua = 0;
		try {
			// Bước 1: Tạo connection
			Connection c = JDBCUtil.getConnection();
			// Bước 2: Viết câu lệnh sql
			String sql = "DELETE from user" + " WHERE username = ?";
			System.out.println(sql);
			// Bước 3: Tạo PreparedStatement
			PreparedStatement pst = c.prepareStatement(sql);

			pst.setString(1, t.getUserName());

			ketQua = pst.executeUpdate();

			// Bước 4: Xử lý kết quả
			System.out.println("Số lượng dòng thay đổi:" + ketQua);

			// Bước 5: Ngắt kết nối
			if (c != null) {
				JDBCUtil.closeConnection(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<user> selectAll() {
		ArrayList<user> ketQua = new ArrayList<>();
		try {
			// Bước 1: Tạo connection
			Connection c = JDBCUtil.getConnection();
			// Bước 2: Viết câu lệnh sql
			String sql = "SELECT * FROM user";
			System.out.println(sql);
			// Bước 3: Tạo PrepardeStatement
			PreparedStatement pst = c.prepareStatement(sql);

			// Tạo ResultSet
			ResultSet rs = pst.executeQuery();

			// Bước 4: Xử lý dữ liệu
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoVaTen = rs.getString("ho_va_ten");

				user user = new user(username, password, hoVaTen);
				ketQua.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public user selectById(user t) {
		user ketQua = null;
		try {
			// Bước 1: Tạo connection
			Connection c = JDBCUtil.getConnection();
			// Bước 2: Viết câu lệnh sql
			String sql = "SELECT * FROM user" + " WHERE username = ?";
			System.out.println(sql);
			// Bước 3: Tạo PreparedStatement
			PreparedStatement pst = c.prepareStatement(sql);

			pst.setString(1, t.getUserName());
			// Tạo ResultSet
			ResultSet rs = pst.executeQuery();
			// Bước 4: Xử lý dữ liệu
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoVaTen = rs.getString("ho_va_ten");

				ketQua = new user(username, password, hoVaTen);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public ArrayList<user> selectByCondition(String condition) {
		ArrayList<user> ketQua = new ArrayList<>();
		try {
			// Bước 1: Tạo connection
			Connection c = JDBCUtil.getConnection();
			// Bước 2: Viết câu lệnh sql
			String sql = "SELECT * FROM user WHERE " + condition;
			System.out.println(sql);
			// Bước 3: Tạo PreparedStatement
			PreparedStatement pst = c.prepareStatement(sql);
			// Tạo ResultSet
			ResultSet rs = pst.executeQuery();
			// Bước 4: Xử lý kết quả
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoVaTen = rs.getString("ho_va_ten");

				user user = new user(username, password, hoVaTen);
				ketQua.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

}
