package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Sach;
import model.TacGia;
import model.TheLoai;

public class SachDAO implements DAOInterface<Sach> {

	public static SachDAO getInstance() {
		return new SachDAO();
	}

	@Override
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> ketQua = new ArrayList<>();

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "SELECT * FROM sanpham";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			ResultSet rs = pts.executeQuery();

			while (rs.next()) {
				String maSanPham = rs.getString("ma_san_pham");
				String tenSanPham = rs.getString("ten_san_pham");
				String maTacGia = rs.getString("ma_tac_gia");
				int namXuatBan = rs.getInt("nam_xuat_ban");
				double giaNhap = rs.getDouble("gia_nhap");
				double giaBan = rs.getDouble("gia_ban");
				double soLuong = rs.getDouble("so_luong");
				String maTheLoai = rs.getString("ma_the_loai");
				String ngonNgu = rs.getString("ngon_ngu");
				String moTa = rs.getString("mo_ta");

				TacGia tacGia = new TacGia(maTacGia, null, null, null);
				TheLoai theLoai = new TheLoai(maTheLoai, null);

				Sach sach = new Sach(maSanPham, tenSanPham, tacGia, namXuatBan, giaNhap, giaBan, soLuong, theLoai,
						ngonNgu, moTa);

				ketQua.add(sach);
			}

			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public Sach selectById(Sach t) {
		Sach ketQua = null;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "SELECT * FROM sanpham WHERE ma_san_pham = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaSach());

			ResultSet rs = pts.executeQuery();

			while (rs.next()) {
				String maSanPham = rs.getString("ma_san_pham");
				String tenSanPham = rs.getString("ten_san_pham");
				String maTacGia = rs.getString("ma_tac_gia");
				int namXuatBan = rs.getInt("nam_xuat_ban");
				double giaNhap = rs.getDouble("gia_nhap");
				double giaBan = rs.getDouble("gia_ban");
				double soLuong = rs.getDouble("so_luong");
				String maTheLoai = rs.getString("ma_the_loai");
				String ngonNgu = rs.getString("ngon_ngu");
				String moTa = rs.getString("mo_ta");

				TacGia tacGia = new TacGia(maTacGia, null, null, null);
				TheLoai theLoai = new TheLoai(maTheLoai, null);

				ketQua = new Sach(maSanPham, tenSanPham, tacGia, namXuatBan, giaNhap, giaBan, soLuong, theLoai, ngonNgu,
						moTa);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insert(Sach t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "INSERT INTO sanpham (ma_san_pham, ten_san_pham, ma_tac_gia, nam_xuat_ban, gia_nhap, gia_ban, so_luong, ma_the_loai, ngon_ngu, mo_ta )"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaSach());
			pts.setString(2, t.getTenSach());
			pts.setString(3, t.getTacGia().getMaTacGia());
			pts.setInt(4, t.getNamXuatBan());
			pts.setDouble(5, t.getGiaNhap());
			pts.setDouble(6, t.getGiaBan());
			pts.setDouble(7, t.getSoLuong());
			pts.setString(8, t.getTheLoai().getMaTheLoai());
			pts.setString(9, t.getNgonNgu());
			pts.setString(10, t.getMoTa());

			ketQua = pts.executeUpdate();

			System.out.println("số dòng thay đổi:" + ketQua);
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<Sach> arr) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "INSERT INTO sanpham (ma_san_pham, ten_san_pham, ma_tac_gia, nam_xuat_ban, gia_nhap, gia_ban, so_luong, ma_the_loai, ngon_ngu, mo_ta )"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			for (Sach t : arr) {
				pts.setString(1, t.getMaSach());
				pts.setString(2, t.getTenSach());
				pts.setString(3, t.getTacGia().getMaTacGia());
				pts.setInt(4, t.getNamXuatBan());
				pts.setDouble(5, t.getGiaNhap());
				pts.setDouble(6, t.getGiaBan());
				pts.setDouble(7, t.getSoLuong());
				pts.setString(8, t.getTheLoai().getMaTheLoai());
				pts.setString(9, t.getNgonNgu());
				pts.setString(10, t.getMoTa());

				pts.addBatch();
			}
			int[] ketQuaBatch = pts.executeBatch();
			ketQua = ketQuaBatch.length;

			System.out.println("Số dòng thay đổi:" + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(Sach t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "DELETE FROM sanpham WHERE ma_san_pham = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaSach());

			ketQua = pts.executeUpdate();

			System.out.println("số dòng thay đổi:" + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<Sach> arr) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "DELETE FROM sanpham WHERE ma_san_pham = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			for (Sach t : arr) {
				pts.setString(1, t.getMaSach());

				pts.addBatch();
			}

			int[] ketQuaBatch = pts.executeBatch();
			ketQua = ketQuaBatch.length;

			System.out.println("Số dòng đã thay đổi:" + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(Sach t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "UPDATE sanpham SET" + " ten_san_pham = ?, " + "ma_tac_gia = ?, " + "nam_xuat_ban = ?, "
					+ "gia_nhap = ?, " + "gia_ban = ?, " + "so_luong = ?, " + "ma_the_loai = ?, " + "ngon_ngu = ?, "
					+ "mo_ta = ?" + " WHERE ma_san_pham = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getTenSach());
			pts.setString(2, t.getTacGia().getMaTacGia());
			pts.setInt(3, t.getNamXuatBan());
			pts.setDouble(4, t.getGiaNhap());
			pts.setDouble(5, t.getGiaBan());
			pts.setDouble(6, t.getSoLuong());
			pts.setString(7, t.getTheLoai().getMaTheLoai());
			pts.setString(8, t.getNgonNgu());
			pts.setString(9, t.getMoTa());
			pts.setString(10, t.getMaSach());

			ketQua = pts.executeUpdate();

			System.out.println("số dòng thay đổi:" + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

}
