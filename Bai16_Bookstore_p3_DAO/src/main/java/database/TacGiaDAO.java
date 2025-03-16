package database;

import java.util.ArrayList;

import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia> {

	private ArrayList<TacGia> data = new ArrayList<TacGia>();

	@Override
	public ArrayList<TacGia> selectAll() {
		// TODO Auto-generated method stub
		return this.data;
	}

	@Override
	public TacGia selectById(TacGia t) {
		// TODO Auto-generated method stub
		for (TacGia tacGia : data) {
			if (tacGia.equals(t)) {
				return tacGia;
			}
		}
		return null;
	}

	@Override
	public int insert(TacGia t) {
		// TODO Auto-generated method stub
		if (this.selectById(t) == null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<TacGia> arr) {
		// TODO Auto-generated method stub
		int count = 0;
		for (TacGia tacGia : arr) {
			count += this.insert(tacGia);
		}
		return count;
	}

	@Override
	public int delete(TacGia t) {
		// TODO Auto-generated method stub
		if (this.selectById(t) != null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<TacGia> arr) {
		// TODO Auto-generated method stub
		int count = 0;
		for (TacGia tacGia : arr) {
			count += this.delete(tacGia);
		}
		return count;
	}

	@Override
	public int update(TacGia t) {
		// TODO Auto-generated method stub
		if (this.selectById(t) != null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}

}
