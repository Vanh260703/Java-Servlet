package test;

import java.util.ArrayList;

import dao.KhachHangDAO;
import model.KhachHang;

public class TestKhachHangDAO {
	public static void main(String[] args) {
//		 Insert test
//		for (int i = 0; i < 100; i++) {
//			KhachHang kh1 = new KhachHang("2" + i, "Nguyen Van" + i, java.sql.Date.valueOf("2022-07-01"), "HN");
//			KhachHangDAO.getInstance().insert(kh1);
//		}
		// test update
		KhachHang kh2 = new KhachHang("20", "Nguyen Van17", java.sql.Date.valueOf("2022-07-01"), "QN");
		KhachHangDAO.getInstance().update(kh2);
		// test delete
		KhachHang kh3 = new KhachHang("218", "Nguyen Van18", java.sql.Date.valueOf("2022-07-01"), "HN");
		KhachHangDAO.getInstance().delete(kh3);

		System.out.println("------------------------------");
		// test selectAll
		ArrayList<KhachHang> list = KhachHangDAO.getInstance().selectAll();
		for (KhachHang khachHang : list) {
			System.out.println(khachHang.toString());
		}

		// test selectById
		KhachHang find = new KhachHang();
		find.setId("210");
		KhachHang kh4 = KhachHangDAO.getInstance().selectById(find);
		System.out.println(kh4.toString());

		System.out.println("-----------------------");
		// test selectByCondition

		ArrayList<KhachHang> list2 = KhachHangDAO.getInstance().selectByCondition("id < 50");
		for (KhachHang khachHang : list2) {
			System.out.println(khachHang.toString());
		}
	}
}
