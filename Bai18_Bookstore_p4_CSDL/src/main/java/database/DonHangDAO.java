package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DonHang;
import model.KhachHang;

public class DonHangDAO implements DAOInterface<DonHang> {

	public static DonHangDAO getInstance() {
		return new DonHangDAO();
	}

	@Override
	public ArrayList<DonHang> selectAll() {
		ArrayList<DonHang> ketQua = new ArrayList<DonHang>();

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "SELECT * FROM donhang";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			ResultSet rs = pts.executeQuery();

			while (rs.next()) {
				String maDonHang = rs.getString("ma_don_hang");
				String maKhachHang = rs.getString("ma_khach_hang");
				String diaChiNguoiMua = rs.getString("dia_chi_nguoi_mua");
				String diaChiNguoiNhan = rs.getString("dia_chi_nhan_hang");
				String hinhThucThanhToan = rs.getString("hinh_thuc_thanh_toan");
				String trangThaiThanhToan = rs.getString("trang_thai_thanh_toan");
				double soTienDaThanhToan = rs.getDouble("so_tien_da_thanh_toan");
				double soTienConThieu = rs.getDouble("so_tien_con_thieu");
				String trangThai = rs.getString("trang_thai");
				Date ngayDatHang = rs.getDate("ngay_dat_hang");
				Date ngayNhanHang = rs.getDate("ngay_nhan_hang");

				KhachHang khachHang = new KhachHang(maKhachHang, null, null, null, null, null, diaChiNguoiNhan, null,
						null, null, null, false);

				DonHang donHang = new DonHang(maDonHang, khachHang, diaChiNguoiMua, khachHang, hinhThucThanhToan,
						trangThaiThanhToan, soTienDaThanhToan, soTienConThieu, trangThai, ngayDatHang, ngayNhanHang);

				ketQua.add(donHang);

			}

			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public DonHang selectById(DonHang t) {
		DonHang ketQua = null;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "SELECT * FROM donhang WHERE ma_don_hang = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaDonHang());

			ResultSet rs = pts.executeQuery();

			while (rs.next()) {
				String maDonHang = rs.getString("ma_don_hang");
				String maKhachHang = rs.getString("ma_khach_hang");
				String diaChiNguoiMua = rs.getString("dia_chi_nguoi_mua");
				String diaChiNguoiNhan = rs.getString("dia_chi_nhan_hang");
				String hinhThucThanhToan = rs.getString("hinh_thuc_thanh_toan");
				String trangThaiThanhToan = rs.getString("trang_thai_thanh_toan");
				double soTienDaThanhToan = rs.getDouble("so_tien_da_thanh_toan");
				double soTienConThieu = rs.getDouble("so_tien_con_thieu");
				String trangThai = rs.getString("trang_thai");
				Date ngayDatHang = rs.getDate("ngay_dat_hang");
				Date ngayNhanHang = rs.getDate("ngay_nhan_hang");

				KhachHang khachHang = new KhachHang(maKhachHang, null, null, null, null, null, diaChiNguoiNhan, null,
						null, null, null, false);

				ketQua = new DonHang(maDonHang, khachHang, diaChiNguoiMua, khachHang, hinhThucThanhToan,
						trangThaiThanhToan, soTienDaThanhToan, soTienConThieu, trangThai, ngayDatHang, ngayNhanHang);

			}
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insert(DonHang t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "INSERT INTO donhang( ma_don_hang, ma_khach_hang, dia_chi_nguoi_mua, dia_chi_nhan_hang, hinh_thuc_thanh_toan, trang_thai_thanh_toan, so_tien_da_thanh_toan, so_tien_con_thieu, trang_thai, ngay_dat_hang, ngay_nhan_hang)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaDonHang());
			pts.setString(2, t.getKhachHang().getMaKhachHang());
			pts.setString(3, t.getDiaChiNguoiMua());
			pts.setString(4, t.getKhachHang().getDiaChiNhanHang());
			pts.setString(5, t.getHinhThucThanhToan());
			pts.setString(6, t.getTrangThaiThanhToan());
			pts.setDouble(7, t.getSoTienDaThanhToan());
			pts.setDouble(8, t.getSoTienConThieu());
			pts.setString(9, t.getTrangThai());
			pts.setDate(10, t.getNgayDatHang());
			pts.setDate(11, t.getNgayNhanHang());

			ketQua = pts.executeUpdate();

			System.out.println("Số dòng thay đổi: " + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<DonHang> arr) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "INSERT INTO donhang( ma_don_hang, ma_khach_hang, dia_chi_nguoi_mua, dia_chi_nhan_hang, hinh_thuc_thanh_toan, trang_thai_thanh_toan, so_tien_da_thanh_toan, so_tien_con_thieu, trang_thai, ngay_dat_hang, ngay_nhan_hang)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);
			for (DonHang t : arr) {
				pts.setString(1, t.getMaDonHang());
				pts.setString(2, t.getKhachHang().getMaKhachHang());
				pts.setString(3, t.getDiaChiNguoiMua());
				pts.setString(4, t.getKhachHang().getDiaChiNhanHang());
				pts.setString(5, t.getHinhThucThanhToan());
				pts.setString(6, t.getTrangThaiThanhToan());
				pts.setDouble(7, t.getSoTienDaThanhToan());
				pts.setDouble(8, t.getSoTienConThieu());
				pts.setString(9, t.getTrangThai());
				pts.setDate(10, t.getNgayDatHang());
				pts.setDate(11, t.getNgayNhanHang());

				pts.addBatch();
			}

			int[] ketQuaBatch = pts.executeBatch();

			ketQua = ketQuaBatch.length;

			System.out.println("Số dòng thay đổi: " + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(DonHang t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "DELETE FROM donhang WHERE ma_don_hang = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaDonHang());

			ketQua = pts.executeUpdate();

			System.out.println("Số dòng thay đổi: " + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<DonHang> arr) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "DELETE FROM donhang WHERE ma_don_hang = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			for (DonHang donHang : arr) {

				pts.setString(1, donHang.getMaDonHang());
				pts.addBatch();
			}
			int[] ketQuaBatch = pts.executeBatch();
			ketQua = ketQuaBatch.length;

			System.out.println("Số dòng thay đổi: " + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(DonHang t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "UPDATE donhang SET " + "ma_khach_hang = ?, " + "dia_chi_nguoi_mua = ?, "
					+ "dia_chi_nhan_hang = ?, " + "hinh_thuc_thanh_toan = ?, " + "trang_thai_thanh_toan = ?, "
					+ "so_tien_da_thanh_toan = ?, " + "so_tien_con_thieu = ?, " + "trang_thai = ?, "
					+ "ngay_dat_hang = ?, " + "ngay_nhan_hang = ?" + " WHERE ma_don_hang = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getKhachHang().getMaKhachHang());
			pts.setString(2, t.getDiaChiNguoiMua());
			pts.setString(3, t.getKhachHang().getDiaChiNhanHang());
			pts.setString(4, t.getHinhThucThanhToan());
			pts.setString(5, t.getTrangThaiThanhToan());
			pts.setDouble(6, t.getSoTienDaThanhToan());
			pts.setDouble(7, t.getSoTienConThieu());
			pts.setString(8, t.getTrangThai());
			pts.setDate(9, t.getNgayDatHang());
			pts.setDate(10, t.getNgayNhanHang());
			pts.setString(11, t.getMaDonHang());

			ketQua = pts.executeUpdate();

			System.out.println("Số dòng thay đổi: " + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

}
