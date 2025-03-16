package database;

import java.util.ArrayList;

import model.DonHang;

public class DonHangDAO {
	private ArrayList<DonHang> data = new ArrayList<DonHang>();

	public DonHang selectById(String id) {
		DonHang donHang = new DonHang();
		donHang.setMaDonHang(id);
		for (DonHang item : data) {
			if (donHang.equals(donHang)) {
				return item;
			}
		}
		return null;
	}

	public int insert(DonHang donHang) {
		DonHang check = this.selectById(donHang.getMaDonHang());
		if (check == null) {
			data.add(donHang);
			return 1;
		} else {
			return 0;
		}
	}

	public int insertAll(ArrayList<DonHang> list) {
		int dem = 0;
		for (DonHang donHang : list) {
			dem += this.insert(donHang);
		}
		return dem;
	}

	public int delete(DonHang donHang) {
		DonHang check = this.selectById(donHang.getMaDonHang());

		if (check != null) {
			// Xoá chi tiết đơn hàng
			ChiTietDonHangDAO ctdh = new ChiTietDonHangDAO();
			ctdh.deleteAll(donHang);

			// xoá đơn hàng
			data.remove(donHang);
			return 1;
		} else {
			return 0;
		}
	}

	private int deleteAll(ArrayList<DonHang> list) {
		int dem = 0;
		for (DonHang donHang : list) {
			dem += this.delete(donHang);
		}
		return dem;
	}

	private int update(DonHang donHang) {
		DonHang check = this.selectById(donHang.getMaDonHang());
		if (check != null) {
			data.remove(donHang);
			data.add(donHang);
			return 1;
		} else {
			return 0;
		}
	}
}
