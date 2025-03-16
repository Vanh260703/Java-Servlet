package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;
import model.Sach;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang> {

	public static ChiTietDonHangDAO getInstance() {
		return new ChiTietDonHangDAO();
	}

	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		ArrayList<ChiTietDonHang> ketQua = new ArrayList<ChiTietDonHang>();

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "SELECT * FROM chitietdonhang";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			ResultSet rs = pts.executeQuery();

			while (rs.next()) {
				String maChiTietDonHang = rs.getString("ma_chi_tiet_don_hang");
				String maDonHang = rs.getString("ma_don_hang");
				String maSanPham = rs.getString("ma_san_pham");
				double soLuong = rs.getDouble("so_luong");
				double giaBia = rs.getDouble("gia_bia");
				double giaBan = rs.getDouble("gia_ban");
				double giamGia = rs.getDouble("giam_gia");
				double vat = rs.getDouble("vat");
				double tongTien = rs.getDouble("tong_tien");

				DonHang donHang = new DonHang(maDonHang, null, null, null, null, null, 0, 0, null, null, null);
				Sach sach = new Sach(maSanPham, null, null, 0, 0, giaBan, soLuong, null, null, null);

				ChiTietDonHang ctdh = new ChiTietDonHang(maChiTietDonHang, donHang, sach, sach, giaBia, sach, giamGia,
						vat, tongTien);

				ketQua.add(ctdh);
			}
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ChiTietDonHang selectById(ChiTietDonHang t) {
		ChiTietDonHang ketQua = null;
		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "SELECT * FROM chitietdonhang WHERE ma_chi_tiet_don_hang = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaChiTietDonHang());

			ResultSet rs = pts.executeQuery();

			while (rs.next()) {
				String maChiTietDonHang = rs.getString("ma_chi_tiet_don_hang");
				String maDonHang = rs.getString("ma_don_hang");
				String maSanPham = rs.getString("ma_san_pham");
				double soLuong = rs.getDouble("so_luong");
				double giaBia = rs.getDouble("gia_bia");
				double giaBan = rs.getDouble("gia_ban");
				double giamGia = rs.getDouble("giam_gia");
				double vat = rs.getDouble("vat");
				double tongTien = rs.getDouble("tong_tien");

				DonHang donHang = new DonHang(maDonHang, null, null, null, null, null, 0, 0, null, null, null);
				Sach sach = new Sach(maSanPham, null, null, 0, 0, giaBan, soLuong, null, null, null);

				ketQua = new ChiTietDonHang(maChiTietDonHang, donHang, sach, sach, giaBia, sach, giamGia, vat,
						tongTien);

			}
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insert(ChiTietDonHang t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "INSERT INTO chitietdonhang (ma_chi_tiet_don_hang, ma_don_hang, ma_san_pham, so_luong, gia_bia, gia_ban, "
					+ "giam_gia, vat, tong_tien)" + " VALUES (?,?,?,?,?,?,?,?,?)";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaChiTietDonHang());
			pts.setString(2, t.getMaDonHang().getMaDonHang());
			pts.setString(3, t.getMaSanPham().getMaSach());
			pts.setDouble(4, t.getMaSanPham().getSoLuong());
			pts.setDouble(5, t.getGiaBia());
			pts.setDouble(6, t.getMaSanPham().getGiaBan());
			pts.setDouble(7, t.getGiamGia());
			pts.setDouble(8, t.getVat());
			pts.setDouble(9, t.getTongTien());

			ketQua = pts.executeUpdate();

			System.out.println("Số dòng thay đổi: " + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<ChiTietDonHang> arr) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "INSERT INTO chitietdonhang (ma_chi_tiet_don_hang, ma_don_hang, ma_san_pham, so_luong, gia_bia, gia_ban, "
					+ "giam_gia, vat, tong_tien)" + " VALUES (?,?,?,?,?,?,?,?,?)";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);
			for (ChiTietDonHang t : arr) {
				pts.setString(1, t.getMaChiTietDonHang());
				pts.setString(2, t.getMaDonHang().getMaDonHang());
				pts.setString(3, t.getMaSanPham().getMaSach());
				pts.setDouble(4, t.getMaSanPham().getSoLuong());
				pts.setDouble(5, t.getGiaBia());
				pts.setDouble(6, t.getMaSanPham().getGiaBan());
				pts.setDouble(7, t.getGiamGia());
				pts.setDouble(8, t.getVat());
				pts.setDouble(9, t.getTongTien());

				pts.addBatch();
			}
			int[] ketQuaBatch = pts.executeBatch();

			ketQua = ketQuaBatch.length;

			System.out.println("Số dòng thay đổi: " + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(ChiTietDonHang t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "DELETE FROM chitietdonhang WHERE ma_chi_tiet_don_hang = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaChiTietDonHang());

			ketQua = pts.executeUpdate();

			System.out.println("Số dòng thay đổi: " + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<ChiTietDonHang> arr) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "DELETE FROM chitietdonhang WHERE ma_chi_tiet_don_hang = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);
			for (ChiTietDonHang t : arr) {
				pts.setString(1, t.getMaChiTietDonHang());

				pts.addBatch();
			}
			int[] ketQuaBatch = pts.executeBatch();

			ketQua = ketQuaBatch.length;

			System.out.println("Số dòng thay đổi: " + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	public int deleteAll(DonHang dh) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "DELETE FROM chitietdonhang WHERE ma_don_hang = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, dh.getMaDonHang());

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
	public int update(ChiTietDonHang t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "UPDATE chitietdonhang SET " + "ma_don_hang = ?, " + "ma_san_pham = ?, " + "so_luong = ?, "
					+ "gia_bia = ?, " + "gia_ban = ?, " + "giam_gia = ?, " + "vat = ?, " + "tong-tien = ? "
					+ " WHERE ma_chi_tiet_don_hang = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaDonHang().getMaDonHang());
			pts.setString(2, t.getMaSanPham().getMaSach());
			pts.setDouble(3, t.getMaSanPham().getSoLuong());
			pts.setDouble(4, t.getGiaBia());
			pts.setDouble(5, t.getMaSanPham().getGiaBan());
			pts.setDouble(6, t.getGiamGia());
			pts.setDouble(7, t.getVat());
			pts.setDouble(8, t.getTongTien());
			pts.setString(9, t.getMaChiTietDonHang());

			ketQua = pts.executeUpdate();

			System.out.println("Số dòng thay đổi: " + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
}