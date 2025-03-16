package database;

import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO {
	private ArrayList<TheLoai> data = new ArrayList<TheLoai>();

	private TheLoai selectById(String id) {
		TheLoai theLoai = new TheLoai();
		theLoai.setMaTheLoai(id);
		for (TheLoai item : data) {
			if (theLoai.equals(theLoai)) {
				return item;
			}
		}
		return null;
	}

	public int insert(TheLoai theLoai) {
		TheLoai check = this.selectById(theLoai.getMaTheLoai());
		if (check == null) {
			data.add(theLoai);
			return 1;
		} else {
			return 0;
		}
	}

	public int insertAll(ArrayList<TheLoai> list) {
		int count = 0;
		for (TheLoai theLoai : list) {
			count += this.insert(theLoai);
		}
		return count;
	}

	public int delete(TheLoai theLoai) {
		TheLoai check = this.selectById(theLoai.getMaTheLoai());
		if (check != null) {
			data.remove(theLoai);
			return 1;
		} else {
			return 0;
		}
	}

	public int deleteAll(ArrayList<TheLoai> list) {
		int count = 0;
		for (TheLoai theLoai : list) {
			count += this.delete(theLoai);
		}
		return count;
	}

	public int update(TheLoai theLoai) {
		TheLoai check = this.selectById(theLoai.getMaTheLoai());
		if (check != null) {
			data.remove(theLoai);
			data.add(theLoai);
			return 1;
		} else {
			return 0;
		}
	}

}
