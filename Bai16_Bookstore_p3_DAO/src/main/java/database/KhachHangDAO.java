package database;

import java.util.ArrayList;

import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang> {

	private ArrayList<KhachHang> data = new ArrayList<KhachHang>();

	@Override
	public ArrayList<KhachHang> selectAll() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		// TODO Auto-generated method stub
		for (KhachHang khachHang : data) {
			if (khachHang.equals(t)) {
				return khachHang;
			}
		}
		return null;
	}

	@Override
	public int insert(KhachHang t) {
		// TODO Auto-generated method stub
		if (this.selectById(t) == null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<KhachHang> arr) {
		// TODO Auto-generated method stub
		int count = 0;
		for (KhachHang khachHang : arr) {
			count += this.insert(khachHang);
		}
		return count;
	}

	@Override
	public int delete(KhachHang t) {
		// TODO Auto-generated method stub
		if (this.selectById(t) != null) {
			data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<KhachHang> arr) {
		// TODO Auto-generated method stub
		int count = 0;
		for (KhachHang khachHang : arr) {
			count += this.delete(khachHang);
		}
		return count;
	}

	@Override
	public int update(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
