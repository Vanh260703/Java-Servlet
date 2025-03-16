package test;

import java.util.ArrayList;

import database.ChiTietDonHangDAO;
import database.DonHangDAO;
import model.ChiTietDonHang;
import model.DonHang;
import model.Sach;

public class TestChiTietDonHang {
	public static void main(String[] args) {
		DonHang dh1 = new DonHang("DH1", null, null, null, null, null, 0, 0, null, null, null);
		DonHang dh2 = new DonHang("DH2", null, null, null, null, null, 0, 0, null, null, null);
		DonHang dh3 = new DonHang("DH3", null, null, null, null, null, 0, 0, null, null, null);
		DonHang dh4 = new DonHang("DH4", null, null, null, null, null, 0, 0, null, null, null);
		DonHang dh5 = new DonHang("DH5", null, null, null, null, null, 0, 0, null, null, null);

		Sach sach1 = new Sach("SP1", null, null, 0, 0, 150000, 50, null, null, null);
		Sach sach2 = new Sach("SP2", null, null, 0, 0, 170000, 20, null, null, null);
		Sach sach3 = new Sach("SP3", null, null, 0, 0, 200000, 30, null, null, null);
		Sach sach4 = new Sach("SP4", null, null, 0, 0, 300000, 40, null, null, null);

		// insert

//		ChiTietDonHang ctdh = new ChiTietDonHang("CTDH5", dh5, sach4, sach4, 20000, sach4, 0, 0.3, 330000);
//		ChiTietDonHangDAO.getInstance().insert(ctdh);

		// delete

//		ChiTietDonHang ctdh = new ChiTietDonHang("CTDH5", dh5, sach4, sach4, 20000, sach4, 0, 0.3, 330000);
//		ChiTietDonHangDAO.getInstance().delete(ctdh);

		// selectAll

		ArrayList<ChiTietDonHang> list = ChiTietDonHangDAO.getInstance().selectAll();
		for (ChiTietDonHang chiTietDonHang : list) {
			System.out.println(chiTietDonHang.toString());
		}

		System.out.println("---------------------");

		// selectById
		ChiTietDonHang find = new ChiTietDonHang();
		find.setMaChiTietDonHang("CTDH3");
		ChiTietDonHang ctdh = ChiTietDonHangDAO.getInstance().selectById(find);
		System.out.println(ctdh);

		// delete(DonHang dh)
		ChiTietDonHangDAO.getInstance().deleteAll(dh1);
		DonHangDAO.getInstance().delete(dh1);

	}
}
