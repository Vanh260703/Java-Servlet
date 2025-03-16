package test;

import java.util.ArrayList;

import database.DonHangDAO;
import model.DonHang;
import model.KhachHang;

public class TestDonHangDAO {
	public static void main(String[] args) {
		KhachHang kh1 = new KhachHang("KH1", null, null, null, null, null, "Q2", null, null, null, null, false);
		KhachHang kh2 = new KhachHang("KH2", null, null, null, null, null, "Dong Da", null, null, null, null, false);
		KhachHang kh3 = new KhachHang("KH3", null, null, null, null, null, "Kien An", null, null, null, null, false);
		KhachHang kh4 = new KhachHang("KH4", null, null, null, null, null, "Ha Long", null, null, null, null, false);
		KhachHang kh5 = new KhachHang("KH5", null, null, null, null, null, "Cau Giay", null, null, null, null, false);
		KhachHang kh6 = new KhachHang("KH6", null, null, null, null, null, "Hà Nội", null, null, null, null, false);

		// test insert
//		DonHang donHang = new DonHang("DH5", kh5, "HP", kh5, "chuyen khoan", "dang giao", 0, 200000, "0",
//				Date.valueOf("2025-03-17"), Date.valueOf("2025-03-20"));
//
//		DonHangDAO.getInstance().insert(donHang);

		// test insertAll
//		ArrayList<DonHang> list = new ArrayList<>();
//
//		list.add(new DonHang("DH6", kh6, "HP", kh6, "chuyen khoan", "da giao", 500000, 0, "0",
//				Date.valueOf("2025-03-15"), Date.valueOf("2025-03-17")));
//		DonHangDAO.getInstance().insertAll(list);

		// test delete
//		DonHang donHang = new DonHang("DH6", kh5, "HP", kh5, "chuyen khoan", "dang giao", 0, 200000, "0",
//				Date.valueOf("2025-03-17"), Date.valueOf("2025-03-20"));
//
//		DonHangDAO.getInstance().delete(donHang);

		// test update
//		DonHang donHang1 = new DonHang("DH5", kh5, "HP", kh5, "tien mat", "dang giao", 0, 200000, "0",
//				Date.valueOf("2025-03-17"), Date.valueOf("2025-03-20"));
//
//		DonHangDAO.getInstance().update(donHang1);

		// test selectAll

		ArrayList<DonHang> list = DonHangDAO.getInstance().selectAll();
		for (DonHang donHang : list) {
			System.out.println(donHang.toString());
		}

		System.out.println("------------------");

		DonHang find = new DonHang();
		find.setMaDonHang("DH1");
		DonHang dh1 = DonHangDAO.getInstance().selectById(find);

		System.out.println(dh1.toString());
	}
}
