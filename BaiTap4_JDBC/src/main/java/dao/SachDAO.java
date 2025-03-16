package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Sach;

public class SachDAO implements DAOInterface<Sach> {

	public static SachDAO getInstance() {
		return new SachDAO();
	}

	@Override
	public int insert(Sach t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection c = JDBCUtil.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi câu lệnh SQL
			String sql = "INSERT INTO sach(id, ten_sach, gia_ban, nam_xuat_ban) VALUES ('" + t.getId() + "', '"
					+ t.getTenSach() + "', '" + t.getGiaBan() + "' , '" + t.getNamXuatBan() + "')";
			System.out.println("Bạn đã thực thi" + sql);

			ketQua = st.executeUpdate(sql);

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
	public int update(Sach t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection c = JDBCUtil.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi câu lệnh SQL
			String sql = "UPDATE sach SET " + " ten_sach = '" + t.getTenSach() + "', " + " gia_ban =" + t.getGiaBan()
					+ " , " + " nam_xuat_ban = " + t.getNamXuatBan() + " WHERE id='" + t.getId() + "'";

			System.out.println("Bạn đã thực thi" + sql);

			ketQua = st.executeUpdate(sql);

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
	public int delete(Sach t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection c = JDBCUtil.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi câu lệnh SQL
			String sql = "DELETE from sach  " + "WHERE id ='" + t.getId() + "'";

			System.out.println("Bạn đã thực thi" + sql);

			ketQua = st.executeUpdate(sql);

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
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> ketQua = new ArrayList<>();
		// TODO Auto-generated method stub
		try {

			// Bước 1: Tạo ra kết nối
			Connection c = JDBCUtil.getConnection();

			// Bước 2: Tạo ra statement
			Statement st = c.createStatement();

			// Bước 3: Viết câu lệnh sql
			String sql = "SELECT * FROM sach ";
			System.out.println(sql);

			ResultSet rs = st.executeQuery(sql);

			// Bước 4: Xử lý dữ liệu
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("ten_sach");
				double giaBan = rs.getDouble("gia_ban");
				int namXuatBan = rs.getInt("nam_xuat_ban");

				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				ketQua.add(sach);
			}
			return ketQua;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public Sach selectById(Sach t) {
		Sach ketQua = null;
		try {
			ketQua = null;
			// Bước 1: Tạo kết nối
			Connection c = JDBCUtil.getConnection();
			// Bước 2: Tạo statement
			Statement st = c.createStatement();
			// Bước 3: Viết câu lệnh sql
			String sql = "SELECT * FROM sach WHERE id ='" + t.getId() + "'";

			System.out.println(sql);

			ResultSet rs = st.executeQuery(sql);

			// Bước 4: Xử lý dữ liêu

			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("ten_sach");
				double giaBan = rs.getDouble("gia_ban");
				int namXuatBan = rs.getInt("nam_xuat_ban");

				ketQua = new Sach(id, tenSach, giaBan, namXuatBan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String condition) {
		ArrayList<Sach> ketQua = new ArrayList<>();
		try {
			ketQua = new ArrayList<>();

			// Bước 1: Tạo connection
			Connection c = JDBCUtil.getConnection();
			// Bước 2: Tạo statement
			Statement st = c.createStatement();
			// Bước 3: Viết câu lệnh sql
			String sql = "SELECT * FROM sach WHERE " + condition;
			System.out.println(sql);

			// Tạo ra resultSet(có tác dụng như một table mới để lưu dữ liệu trong sql)
			ResultSet rs = st.executeQuery(sql);

			// Bước 4: Xử lý dữ liệu
			while (rs.next()) { // kiểm tra từng phần tử trong table
				String id = rs.getString("id");
				String tenSach = rs.getString("ten_sach");
				double giaBan = rs.getDouble("gia_ban");
				int namXuatBan = rs.getInt("nam_xuat_ban");

				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				ketQua.add(sach);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

}
