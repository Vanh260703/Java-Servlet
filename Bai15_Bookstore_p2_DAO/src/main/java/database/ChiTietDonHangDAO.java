package database;

import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;

public class ChiTietDonHangDAO {
	private ArrayList<ChiTietDonHang> data = new ArrayList<ChiTietDonHang>();

	public ArrayList<ChiTietDonHang> selectAll() {
		return data;
	}

	public ChiTietDonHang selectById(String id) {
		ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
		chiTietDonHang.setMaChiTietDonHang(id);
		for (ChiTietDonHang item : data) {
			if (chiTietDonHang.equals(chiTietDonHang)) {
				return item;
			}
		}
		return null;
	}

	public int insert(ChiTietDonHang chiTietDonHang) {
		ChiTietDonHang check = this.selectById(chiTietDonHang.getMaChiTietDonHang());
		if (check == null) {
			data.add(chiTietDonHang);
			return 1;
		} else {
			return 0;
		}
	}

	public int insertAll(ArrayList<ChiTietDonHang> list) {
		int count = 0;
		for (ChiTietDonHang chiTietDonHang : list) {
			count += this.insert(chiTietDonHang);
		}
		return count;
	}

	public int delete(ChiTietDonHang chiTietDonHang) {
		ChiTietDonHang check = this.selectById(chiTietDonHang.getMaChiTietDonHang());
		if (check != null) {
			data.remove(chiTietDonHang);
			return 1;
		} else {
			return 0;
		}
	}

	public int deleteAll(DonHang donHang) {
		int count = 0;
		for (ChiTietDonHang chiTietDonHang : data) {
			if (chiTietDonHang.getDonHang().equals(donHang)) {
				this.delete(chiTietDonHang);
			}
		}
		return count;
	}

	public int update(ChiTietDonHang chiTietDonHang) {
		ChiTietDonHang check = this.selectById(chiTietDonHang.getMaChiTietDonHang());
		if (check != null) {
			data.remove(chiTietDonHang);
			data.add(chiTietDonHang);
			return 1;
		} else {
			return 0;
		}
	}
}
