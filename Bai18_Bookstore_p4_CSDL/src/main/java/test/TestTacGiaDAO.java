package test;

import java.util.ArrayList;

import database.TacGiaDAO;
import model.TacGia;

public class TestTacGiaDAO {
	public static void main(String[] args) {
		// test insert
		/*
		 * TacGia tg1 = new TacGia("TG_05", "Nguyễn Phương Anh",
		 * Date.valueOf("2004-07-24"), "");
		 * 
		 * TacGiaDAO.getInstance().insert(tg1);
		 */

		// test insertAll
		/*
		 * ArrayList<TacGia> list = new ArrayList<>();
		 * 
		 * list.add(new TacGia("TG_06", "Nguyễn Vân Anh", Date.valueOf("2001-05-24"),
		 * "giới thiệu tác giả 6")); list.add(new TacGia("TG_07", "Nguyễn Ngọc Hân",
		 * Date.valueOf("2009-12-20"), "giới thiệu tác giả 7"));
		 * 
		 * TacGiaDAO.getInstance().insertAll(list);
		 */

		// test update
		/*
		 * TacGia tg1 = new TacGia("TG_05", "Nguyễn Phương Anh",
		 * Date.valueOf("2004-07-24"), "xinhgai"); TacGiaDAO.getInstance().update(tg1);
		 */

		// test delete

		TacGia tg1 = new TacGia("TG_06", null, null, null);
		TacGiaDAO.getInstance().delete(tg1);

		// test selectAll
		ArrayList<TacGia> list = TacGiaDAO.getInstance().selectAll();
		for (TacGia tacGia : list) {
			System.out.println(tacGia.toString());
		}

		System.out.println("--------------------------");

		// test SelectById
		TacGia find = new TacGia();
		find.setMaTacGia("TG_01");
		TacGia tg = TacGiaDAO.getInstance().selectById(find);

		System.out.println(tg);
	}
}
