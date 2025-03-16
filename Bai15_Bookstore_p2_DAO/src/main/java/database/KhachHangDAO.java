package database;

import java.util.ArrayList;

import model.KhachHang;

public class KhachHangDAO {
	private ArrayList<KhachHang> data = new ArrayList<KhachHang>(); // Tạo ra mảng data để lưu thông tin khách hàng

	public ArrayList<KhachHang> selectAll() {
		return data;
	}

	public KhachHang selectById(String id) {
		KhachHang khachHang = new KhachHang();
		khachHang.setMaKhachHang(id);

		for (KhachHang item : data) {
			if (khachHang.equals(khachHang)) {
				return item;
			}
		}
		return null;
	}

	public int insert(KhachHang khachHang) {
		KhachHang check = this.selectById(khachHang.getMaKhachHang());
		if (check == null) {
			data.add(khachHang);
			return 1;
		} else {
			return 0;
		}
	}

	public int insertAll(ArrayList<KhachHang> list) {
		int count = 0;
		for (KhachHang khachHang : list) {
			count += this.insert(khachHang);
		}
		return count;
	}

	public int delete(KhachHang khachHang) {
		KhachHang check = this.selectById(khachHang.getMaKhachHang());
		if (check != null) {
			data.remove(khachHang);
			return 1;
		} else {
			return 0;
		}
	}

	public int deleteAll(ArrayList<KhachHang> list) {
		int count = 0;
		for (KhachHang khachHang : list) {
			count += this.delete(khachHang);
		}
		return count;
	}

	public int update(KhachHang khachHang) {
		KhachHang check = this.selectById(khachHang.getMaKhachHang());
		if (check != null) {
			data.remove(khachHang);
			data.add(khachHang);
			return 1;
		} else {
			return 0;
		}
	}
}
