package test;

import java.util.ArrayList;

import database.TheLoaiDAO;
import model.TheLoai;

public class TestTheLoaiDAO {
	public static void main(String[] args) {
		// test insert
//		TheLoai tl1 = new TheLoai("TL3", "Sách giáo khoa");
//		TheLoaiDAO.getInstance().insert(tl1);

		// test insertAll
//		ArrayList<TheLoai> list = new ArrayList<>();
//		list.add(new TheLoai("TL4", "Sách tôn giáo"));
//		list.add(new TheLoai("TL5", "Sách lịch sử"));
//
//		TheLoaiDAO.getInstance().insertAll(list);

		// test delete
		TheLoai tl1 = new TheLoai("TL3", "Sách giáo khoa");
		TheLoaiDAO.getInstance().delete(tl1);

		// test deleteAll
//		ArrayList<TheLoai> list = new ArrayList<>();
//		list.add(new TheLoai("TL4", "Sách tôn giáo"));
//		list.add(new TheLoai("TL5", "Sách lịch sử"));
//
//		TheLoaiDAO.getInstance().deleteAll(list);

		// test update
//		TheLoai tl2 = new TheLoai("TL2", "Lịch sử");
//		TheLoaiDAO.getInstance().update(tl2);

		// test selectAll
		ArrayList<TheLoai> list = TheLoaiDAO.getInstance().selectAll();

		for (TheLoai theLoai : list) {
			System.out.println(theLoai.toString());
		}

		System.out.println("--------------------------");

		// test selectById
		TheLoai find = new TheLoai();
		find.setMaTheLoai("TL1");
		TheLoai theLoai = TheLoaiDAO.getInstance().selectById(find);
		System.out.println(theLoai);
	}
}
