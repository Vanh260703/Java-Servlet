package database;

import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai> {

	private ArrayList<TheLoai> data = new ArrayList<TheLoai>();

	@Override
	public ArrayList<TheLoai> selectAll() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public TheLoai selectById(TheLoai t) {
		// TODO Auto-generated method stub
		for (TheLoai theLoai : data) {
			if (theLoai.equals(t)) {
				return theLoai;
			}
		}
		return null;
	}

	@Override
	public int insert(TheLoai t) {
		// TODO Auto-generated method stub
		if (this.selectById(t) == null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<TheLoai> arr) {
		// TODO Auto-generated method stub
		int count = 0;
		for (TheLoai theLoai : arr) {
			count += this.insert(theLoai);
		}
		return count;
	}

	@Override
	public int delete(TheLoai t) {
		// TODO Auto-generated method stub
		if (this.selectById(t) != null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<TheLoai> arr) {
		// TODO Auto-generated method stub
		int count = 0;
		for (TheLoai theLoai : arr) {
			count += this.delete(theLoai);
		}
		return count;
	}

	@Override
	public int update(TheLoai t) {
		// TODO Auto-generated method stub
		if (this.selectById(t) != null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}

}
