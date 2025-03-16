package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia> {

	public static TacGiaDAO getInstance() {
		return new TacGiaDAO();
	}

	@Override
	public ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> ketQua = new ArrayList<>();

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "SELECT * FROM tacgia";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			ResultSet rs = pts.executeQuery();

			while (rs.next()) {
				String maTacGia = rs.getString("ma_tac_gia");
				String hoVaTen = rs.getString("ho_va_ten");
				Date ngaySinh = rs.getDate("ngay_sinh");
				String tieuSu = rs.getString("tieu_su");

				TacGia tacGia = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);

				ketQua.add(tacGia);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public TacGia selectById(TacGia t) {
		TacGia ketQua = null;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "SELECT * FROM tacgia WHERE ma_tac_gia = ?";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaTacGia());

			ResultSet rs = pts.executeQuery();

			while (rs.next()) {
				String maTacGia = rs.getString("ma_tac_gia");
				String hoVaTen = rs.getString("ho_va_ten");
				Date ngaySinh = rs.getDate("ngay_sinh");
				String tieuSu = rs.getString("tieu_su");

				ketQua = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insert(TacGia t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "INSERT INTO tacgia (ma_tac_gia, ho_va_ten, ngay_sinh, tieu_su ) VALUES ( ?, ?, ?, ?)";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaTacGia());
			pts.setString(2, t.getHoVaTen());
			pts.setDate(3, t.getNgaySinh());
			pts.setString(4, t.getTieuSu());

			ketQua = pts.executeUpdate();

			System.out.println("Số dòng đã thay đổi:" + ketQua);

			JDBCUtil.closeConnection(c);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<TacGia> arr) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "INSERT INTO tacgia (ma_tac_gia, ho_va_ten, ngay_sinh, tieu_su ) VALUES ( ?, ?, ?, ?)";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			for (TacGia tacGia : arr) {
				pts.setString(1, tacGia.getMaTacGia());
				pts.setString(2, tacGia.getHoVaTen());
				pts.setDate(3, tacGia.getNgaySinh());
				pts.setString(4, tacGia.getTieuSu());

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
	public int delete(TacGia t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "DELETE FROM tacgia WHERE ma_tac_gia = ? ";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getMaTacGia());

			ketQua = pts.executeUpdate();

			System.out.println("Số dòng đã thay đổi:" + ketQua);

			JDBCUtil.closeConnection(c);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<TacGia> arr) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "DELETE FROM tacgia WHERE ma_tac_gia = ? ";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			for (TacGia tacGia : arr) {
				pts.setString(1, tacGia.getMaTacGia());

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
	public int update(TacGia t) {
		int ketQua = 0;

		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "UPDATE tacgia SET " + "ho_va_ten = ?, " + "ngay_sinh = ?, " + "tieu_su = ? "
					+ "WHERE ma_tac_gia = ? ";
			System.out.println(sql);

			PreparedStatement pts = c.prepareStatement(sql);

			pts.setString(1, t.getHoVaTen());
			pts.setDate(2, t.getNgaySinh());
			pts.setString(3, t.getTieuSu());
			pts.setString(4, t.getMaTacGia());

			ketQua = pts.executeUpdate();

			System.out.println("Số dòng đã thay đổi:" + ketQua);

			JDBCUtil.closeConnection(c);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

}
