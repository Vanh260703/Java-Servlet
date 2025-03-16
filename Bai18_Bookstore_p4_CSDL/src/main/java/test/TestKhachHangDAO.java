package test;

import java.sql.Date;
import java.util.ArrayList;

import database.KhachHangDAO;
import model.KhachHang;

public class TestKhachHangDAO {
	public static void main(String[] args) {
		// test insert
		/*
		 * KhachHang khachHang = new KhachHang("KH5", "abc567", "567", "Nguyen Van D",
		 * "Nam", "HP", "Cau Giay", "Hai Phong", Date.valueOf("2004-06-09"),
		 * "0987654121", "tiu@gmail.com", true);
		 * KhachHangDAO.getInstance().insert(khachHang);
		 */

		// test insertAll
		/*
		 * ArrayList<KhachHang> list = new ArrayList<>(); list.add(new KhachHang("KH6",
		 * "user1", "pass1", "Nguyen Van E", "Nam", "Hà Nội", "Hà Nội", "Hà Nội",
		 * Date.valueOf("1990-01-01"), "0123456789", "user1@gmail.com", true));
		 * list.add(new KhachHang("KH7", "user2", "pass2", "Tran Thi Y", "Nữ", "HCM",
		 * "HCM", "HCM", Date.valueOf("1995-05-10"), "0987654321", "user2@gmail.com",
		 * false));
		 * 
		 * KhachHangDAO.getInstance().insertAll(list);
		 */

		// test delete
		KhachHang khachHang = new KhachHang("KH7", null, null, null, null, null, null, null, null, null, null, false);
		KhachHangDAO.getInstance().delete(khachHang);

		// test update
		KhachHang khachHang1 = new KhachHang("KH6", "abc678", "678", "Nguyen Van E", "Nam", "Hà Nội", "Hà Nội",
				"Hà Nội", Date.valueOf("1990-01-01"), "0123456798", "kiu@gmail.com", false);
		KhachHangDAO.getInstance().update(khachHang1);

		// test selectAll

		ArrayList<KhachHang> list = KhachHangDAO.getInstance().selectAll();

		for (KhachHang item : list) {
			System.out.println(item.toString());
		}

		System.out.println("--------------------------");

		// test selectByID
		KhachHang find = new KhachHang();
		find.setMaKhachHang("KH3");
		KhachHang kh1 = KhachHangDAO.getInstance().selectById(find);
		System.out.println(kh1.toString());
	}
}
