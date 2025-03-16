package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang> {

	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		try {
			// Bước 1: Tạo connection
			Connection c = JDBCUtil.getConnection();
			// Bước 2: Viết câu lệnh sql
			String sql = "SELECT * FROM khachhang ";
			System.out.println(sql);
			// Bước 3: Tạo PreparedStatement
			PreparedStatement pst = c.prepareStatement(sql);

			// Tạo ResultSet
			ResultSet rs = pst.executeQuery();

			// Bước 4: Xử lý kết quả
			while (rs.next()) {
				String maKhachHang = rs.getString("ma_khach_hang");
				String tenDangNhap = rs.getString("ten_dang_nhap");
				String matKhau = rs.getString("mat_khau");
				String hoVaTen = rs.getString("ho_va_ten");
				String gioiTinh = rs.getString("gioi_tinh");
				String diaChi = rs.getString("dia_chi");
				String diaChiNhanHang = rs.getString("dia_chi_nhan_hang");
				String diaChiMuaHang = rs.getString("dia_chi_mua_hang");
				Date ngaySinh = rs.getDate("ngay_sinh");
				String soDienThoai = rs.getString("so_dien_thoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dang_ky_nhan_ban_tin");

				KhachHang khachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi,
						diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin);

				ketQua.add(khachHang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang ketQua = null;
		try {
			// B1: Tạo connection
			Connection c = JDBCUtil.getConnection();
			// B2: Viết sql
			String sql = "SELECT * FROM khachhang" + " WHERE ma_khach_hang = ?";
			System.out.println(sql);
			// B3: Tạo PreparedStatement
			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaKhachHang());

			// Tạo ResultSet
			ResultSet rs = pts.executeQuery();

			// Bước 4: Xử lý kết quả
			while (rs.next()) {
				String maKhachHang = rs.getString("ma_khach_hang");
				String tenDangNhap = rs.getString("ten_dang_nhap");
				String matKhau = rs.getString("mat_khau");
				String hoVaTen = rs.getString("ho_va_ten");
				String gioiTinh = rs.getString("gioi_tinh");
				String diaChi = rs.getString("dia_chi");
				String diaChiNhanHang = rs.getString("dia_chi_nhan_hang");
				String diaChiMuaHang = rs.getString("dia_chi_mua_hang");
				Date ngaySinh = rs.getDate("ngay_sinh");
				String soDienThoai = rs.getString("so_dien_thoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dang_ky_nhan_ban_tin");

				ketQua = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang,
						diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			// B1: Tạo connection
			Connection c = JDBCUtil.getConnection();
			// Bước 2: Viết sql
			String sql = "INSERT INTO khachhang ( ma_khach_hang, ten_dang_nhap, mat_khau, ho_va_ten, gioi_tinh, dia_chi, dia_chi_nhan_hang, dia_chi_mua_hang, ngay_sinh, so_dien_thoai, email, dang_ky_nhan_ban_tin) "
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(sql);

			// Bước 3: Tạo PreparedStatement
			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaKhachHang());
			pts.setString(2, t.getTenDangNhap());
			pts.setString(3, t.getMatKhau());
			pts.setString(4, t.getHoVaTen());
			pts.setString(5, t.getGioiTinh());
			pts.setString(6, t.getDiaChi());
			pts.setString(7, t.getDiaChiNhanHang());
			pts.setString(8, t.getDiaChiMuaHang());
			pts.setDate(9, t.getNgaySinh());
			pts.setString(10, t.getSoDienThoai());
			pts.setString(11, t.getEmail());
			pts.setBoolean(12, t.isDangKyNhanBanTin());

			ketQua = pts.executeUpdate();
			// Bước 4: Xử lý dữ liệu
			System.out.println("Số dòng thay đổi: " + ketQua);

			// Bước 5: Đóng
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
	public int insertAll(ArrayList<KhachHang> arr) {
		int ketQua = 0;
		try {
			// B1: Tạo connection
			Connection c = JDBCUtil.getConnection();
			// Bước 2: Viết sql
			String sql = "INSERT INTO khachhang ( ma_khach_hang, ten_dang_nhap, mat_khau, ho_va_ten, gioi_tinh, dia_chi, dia_chi_nhan_hang, dia_chi_mua_hang, ngay_sinh, so_dien_thoai, email, dang_ky_nhan_ban_tin) "
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(sql);
			// B3: Tạo PreparedStatement
			PreparedStatement pts = c.prepareStatement(sql);
			for (KhachHang khachHang : arr) {
				pts.setString(1, khachHang.getMaKhachHang());
				pts.setString(2, khachHang.getTenDangNhap());
				pts.setString(3, khachHang.getMatKhau());
				pts.setString(4, khachHang.getHoVaTen());
				pts.setString(5, khachHang.getGioiTinh());
				pts.setString(6, khachHang.getDiaChi());
				pts.setString(7, khachHang.getDiaChiNhanHang());
				pts.setString(8, khachHang.getDiaChiMuaHang());
				pts.setDate(9, khachHang.getNgaySinh());
				pts.setString(10, khachHang.getSoDienThoai());
				pts.setString(11, khachHang.getEmail());
				pts.setBoolean(12, khachHang.isDangKyNhanBanTin());

				pts.addBatch(); // Thêm vào batch
			}
			int[] khachHangBatch = pts.executeBatch(); // thực thi batch

			ketQua = khachHangBatch.length; // Số dòng
			JDBCUtil.closeConnection(c);

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
			// B1: Tạo connection
			Connection c = JDBCUtil.getConnection();
			// B2: Viết sql
			String sql = "DELETE FROM khachhang" + " WHERE ma_khach_hang = ?";
			System.out.println(sql);
			// B3: Tạo PreparedStatement
			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaKhachHang());

			ketQua = pts.executeUpdate();

			// B4:Xử lý dữ liệu
			System.out.println("Số dòng thay đổi: " + ketQua);

			// close
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<KhachHang> arr) {
		int ketQua = 0;
		try {
			// B1: Tạo connection
			Connection c = JDBCUtil.getConnection();
			// B2: Viết sql
			String sql = "DELETE FROM khachhang WHERE ma_khach_hang = ?";
			System.out.println(sql);
			// B3: Tạo PreparedStatement
			PreparedStatement pts = c.prepareStatement(sql);

			for (KhachHang khachHang : arr) {
				pts.setString(1, khachHang.getMaKhachHang());
				pts.addBatch(); // thêm vào batch
			}

			int[] ketQuaBatch = pts.executeBatch();

			ketQua = ketQuaBatch.length; // số dòng

			JDBCUtil.closeConnection(c);
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
			// B1: Tạo connection
			Connection c = JDBCUtil.getConnection();
			// B2: Viết sql
			String sql = "UPDATE  khachhang SET" + " ten_dang_nhap = ?," + "mat_khau = ?," + "ho_va_ten = ?,"
					+ "gioi_tinh = ?," + "dia_chi = ?," + "dia_chi_nhan_hang = ?," + "dia_chi_mua_hang = ?,"
					+ "ngay_sinh = ?," + "so_dien_thoai = ?," + "email = ?," + "dang_ky_nhan_ban_tin = ?"
					+ " WHERE ma_khach_hang = ?";
			System.out.println(sql);
			// B3: Tạo PreparedStatement
			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getTenDangNhap());
			pts.setString(2, t.getMatKhau());
			pts.setString(3, t.getHoVaTen());
			pts.setString(4, t.getGioiTinh());
			pts.setString(5, t.getDiaChi());
			pts.setString(6, t.getDiaChiNhanHang());
			pts.setString(7, t.getDiaChiMuaHang());
			pts.setDate(8, t.getNgaySinh());
			pts.setString(9, t.getSoDienThoai());
			pts.setString(10, t.getEmail());
			pts.setBoolean(11, t.isDangKyNhanBanTin());
			pts.setString(12, t.getMaKhachHang());

			ketQua = pts.executeUpdate();

			// B4:Xử lý dữ liệu
			System.out.println("Số dòng thay đổi: " + ketQua);

			// close
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

}
