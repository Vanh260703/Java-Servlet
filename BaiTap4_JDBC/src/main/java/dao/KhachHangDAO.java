package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang> {

	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}

	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: Tạo kết nối
			Connection c = JDBCUtil.getConnection();

			// Bước 2: Khởi tạo statement

			Statement st = c.createStatement();

			// Bước 3: Viết câu lệnh sql
			String sql = "INSERT INTO khachhang(id, ho_va_ten, ngay_sinh, dia_chi) VALUES('" + t.getId() + "'" + " , '"
					+ t.getHoVaTen() + "'" + " , '" + t.getNgaySinh() + "'" + " , '" + t.getDiaChi() + "')";
			System.out.println("Bạn đã thực thi: " + sql);

			// Bước 4: Xử lý dữ liệu
			ketQua = st.executeUpdate(sql);

			if (ketQua > 0) {
				ketQua++;
				System.out.println("Số câu lệnh đã được thực thi:" + ketQua);
			} else {
				System.out.println("Bạn chưa thực thi câu lệnh nào");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: Tạo kết nối
			Connection c = JDBCUtil.getConnection();

			// Bước 2: Khởi tạo statement

			Statement st = c.createStatement();

			// Bước 3: Viết câu lệnh sql
			String sql = "UPDATE khachhang SET" + " ho_va_ten ='" + t.getHoVaTen() + "', " + " ngay_sinh ='"
					+ t.getNgaySinh() + "', " + " dia_chi ='" + t.getDiaChi() + "'" + " WHERE id ='" + t.getId() + "'";
			System.out.println("Bạn đã thực thi: " + sql);

			// Bước 4: Xử lý dữ liệu
			ketQua = st.executeUpdate(sql);

			if (ketQua > 0) {
				ketQua++;
				System.out.println("Số câu lệnh đã được thực thi:" + ketQua);
			} else {
				System.out.println("Bạn chưa thực thi câu lệnh nào");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: Tạo kết nối
			Connection c = JDBCUtil.getConnection();

			// Bước 2: Khởi tạo statement

			Statement st = c.createStatement();

			// Bước 3: Viết câu lệnh sql
			String sql = "DELETE from khachhang " + " WHERE id ='" + t.getId() + "'";

			// Bước 4: Xử lý dữ liệu
			ketQua = st.executeUpdate(sql);

			if (ketQua > 0) {
				ketQua++;
				System.out.println("Số câu lệnh đã được thực thi:" + ketQua);
			} else {
				System.out.println("Bạn chưa thực thi câu lệnh nào");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> ketQua = new ArrayList<>();
		try {
			ketQua = new ArrayList<>();
			// Bước 1: Tạo ra connection
			Connection c = JDBCUtil.getConnection();
			// Bước 2: Tạo ra statement
			Statement st = c.createStatement();
			// Bước 3: Viết câu lệnh sql
			String sql = "SELECT * FROM khachhang";
			System.out.println(sql);
			// Tạo ra ResultSet
			ResultSet rs = st.executeQuery(sql);
			// Bước 4: Xử lý dữ liệu
			while (rs.next()) {
				String id = rs.getString("id");
				String hoVaTen = rs.getString("ho_va_ten");
				Date ngaySinh = rs.getDate("ngay_sinh");
				String diaChi = rs.getString("dia_chi");

				KhachHang khachHang = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
				ketQua.add(khachHang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String condition) {
		ArrayList<KhachHang> ketQua = new ArrayList<>();
		try {

			// Bước 1: Tạo ra connection
			Connection c = JDBCUtil.getConnection();
			// Bước 2: Tạo ra statement
			Statement st = c.createStatement();
			// Bước 3: Viết câu lệnh sql
			String sql = "SELECT * FROM khachhang WHERE " + condition;
			System.out.println(sql);
			// Tạo ra ResultSet
			ResultSet rs = st.executeQuery(sql);
			// Bước 4: Xử lý dữ liệu
			while (rs.next()) {
				String id = rs.getString("id");
				String hoVaTen = rs.getString("ho_va_ten");
				Date ngaySinh = rs.getDate("ngay_sinh");
				String diaChi = rs.getString("dia_chi");

				KhachHang khachHang = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
				ketQua.add(khachHang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

}
