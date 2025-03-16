package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai> {

	public static TheLoaiDAO getInstance() {
		return new TheLoaiDAO();
	}

	@Override
	public ArrayList<TheLoai> selectAll() {
		ArrayList<TheLoai> ketQua = new ArrayList<>();

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "SELECT * FROM theloai";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			ResultSet rs = pts.executeQuery();

			while (rs.next()) {
				String maTheLoai = rs.getString("ma_the_loai");
				String tenTheLoai = rs.getString("ten_the_loai");

				TheLoai theLoai = new TheLoai(maTheLoai, tenTheLoai);

				ketQua.add(theLoai);

			}

			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public TheLoai selectById(TheLoai t) {
		TheLoai ketQua = null;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "SELECT * FROM theloai WHERE ma_the_loai = ? ";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaTheLoai());

			ResultSet rs = pts.executeQuery();

			while (rs.next()) {
				String maTheLoai = rs.getString("ma_the_loai");
				String tenTheLoai = rs.getString("ten_the_loai");

				ketQua = new TheLoai(maTheLoai, tenTheLoai);

			}
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insert(TheLoai t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "INSERT INTO theloai( ma_the_loai, ten_the_loai)  VALUES ( ?, ? )";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaTheLoai());
			pts.setString(2, t.getTenTheLoai());

			ketQua = pts.executeUpdate();

			System.out.println("Số dòng thay đổi:" + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<TheLoai> arr) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "INSERT INTO theloai( ma_the_loai, ten_the_loai)  VALUES ( ?, ? )";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			for (TheLoai theLoai : arr) {
				pts.setString(1, theLoai.getMaTheLoai());
				pts.setString(2, theLoai.getTenTheLoai());

				pts.addBatch();
			}

			int[] ketQuaBatch = pts.executeBatch();

			ketQua = ketQuaBatch.length;

			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(TheLoai t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "DELETE FROM theloai WHERE ma_the_loai = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaTheLoai());

			ketQua = pts.executeUpdate();

			System.out.println("Số lượng dòng thay đổi:" + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<TheLoai> arr) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "DELETE FROM theloai WHERE ma_the_loai = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			for (TheLoai theLoai : arr) {
				pts.setString(1, theLoai.getMaTheLoai());

				pts.addBatch();
			}

			int[] ketQuaBatch = pts.executeBatch();

			ketQua = ketQuaBatch.length;

			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(TheLoai t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "UPDATE theloai SET" + " ten_the_loai = ? WHERE ma_the_loai = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getTenTheLoai());
			pts.setString(2, t.getMaTheLoai());

			ketQua = pts.executeUpdate();

			System.out.println("Số dòng đã thay đổi: " + ketQua);

			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
}
