package test;

import java.util.ArrayList;

import dao.SachDAO;
import model.Sach;

public class TestSachDAO {
	public static void main(String[] args) {
//		Sach sach1 = new Sach("Giáo trình", "Lập trình Java", 50000, 2025);
//		Sach sach2 = new Sach("Tiểu thuyết", "Thám tử", 70000, 2024);
//
//		SachDAO.getInstance().insert(sach1);
//		SachDAO.getInstance().insert(sach2);

		// Test insert
//		for (int i = 0; i < 1000; i++) {
//			Sach sach1 = new Sach("LT" + i, "Lập trình" + i, 20000, 2025);
//			SachDAO.getInstance().insert(sach1);
//		}

//		// Test Update
//		Sach sach2 = new Sach("LT20", "Lập trình D", 100000, 2030);
//		SachDAO.getInstance().update(sach2);
//
//		// Test Delete
//		for (int i = 0; i < 1000; i++) {
//			Sach sach3 = new Sach("LT" + i, "Lập trình" + i, 20000, 2025);
//			SachDAO.getInstance().delete(sach3);
//		}
		// Test selectAll
		ArrayList<Sach> list = SachDAO.getInstance().selectAll();
		for (Sach sach : list) {
			System.out.println(sach.toString());
		}
		// Test selectById
		Sach find = new Sach();
		find.setId("Giáo trình");
		Sach sach2 = SachDAO.getInstance().selectById(find);
		System.out.println(sach2);

		System.out.println("-----------------------");

		// Test selectByCondition
		ArrayList<Sach> list2 = SachDAO.getInstance().selectByCondition("gia_ban > 50000");
		for (Sach sach : list2) {
			System.out.println(sach.toString());
		}
	}
}
