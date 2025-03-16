package test;

import java.util.ArrayList;

import database.SachDAO;
import model.Sach;
import model.TacGia;
import model.TheLoai;

public class TestSachDAO {
	public static void main(String[] args) {

		TacGia tacGia1 = new TacGia("TG_01", null, null, null);
		TacGia tacGia2 = new TacGia("TG_02", null, null, null);
		TacGia tacGia3 = new TacGia("TG_03", null, null, null);
		TacGia tacGia4 = new TacGia("TG_04", null, null, null);
		TacGia tacGia5 = new TacGia("TG_05", null, null, null);
		TacGia tacGia7 = new TacGia("TG_07", null, null, null);
		TheLoai theLoai2 = new TheLoai("TL2", null);
		TheLoai theLoai1 = new TheLoai("TL1", null);

		// test insert
//		TacGia tacGia = new TacGia("TG_05", null, null, null);
//		TheLoai theLoai = new TheLoai("TL2", null);
//		Sach sach1 = new Sach("SP5", "Lịch sử", tacGia, 2022, 100000, 180000, 60, theLoai, "Tiếng Việt", null);
//
//		SachDAO.getInstance().insert(sach1);

		// test insertAll
//		ArrayList<Sach> list = new ArrayList<>();
//		list.add(new Sach("SP6", "GoLang", tacGia7, 2017, 100000, 120000, 90, theLoai1, "Anh", null));
//		list.add(new Sach("SP7", "Cuộc đời HCM", tacGia5, 2021, 90000, 100000, 70, theLoai2, "Tiếng Việt", null));
//
//		SachDAO.getInstance().insertAll(list);

		// test delete
		Sach sach1 = new Sach("SP7", null, tacGia5, 0, 0, 0, 0, theLoai2, null, null);

		SachDAO.getInstance().delete(sach1);

		// test deleteAll
		ArrayList<Sach> list = new ArrayList<>();
		list.add(new Sach("SP6", null, tacGia7, 0, 0, 0, 0, theLoai1, null, null));
		list.add(new Sach("SP5", null, tacGia5, 0, 0, 0, 0, theLoai2, null, null));

		SachDAO.getInstance().deleteAll(list);

		// test update
//		Sach sach2 = new Sach("SP3", "Lịch sử đảng", tacGia4, 2025, 170000, 200000, 30, theLoai2, "Tiếng Việt", null);
//		SachDAO.getInstance().update(sach2);

		System.out.println("----------------");

		// test selectAll
		ArrayList<Sach> list1 = SachDAO.getInstance().selectAll();
		for (Sach sach : list1) {
			System.out.println(sach.toString());
		}

		System.out.println("----------------");

		// test selectById
		Sach find = new Sach();
		find.setMaSach("SP1");
		Sach sach = SachDAO.getInstance().selectById(find);
		System.out.println(sach.toString());
	}
}
