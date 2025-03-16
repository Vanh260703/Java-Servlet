package database;

import java.util.ArrayList;

import model.Sach;

public class SachDAO {

	ArrayList<Sach> data = new ArrayList<Sach>();

	public ArrayList<Sach> selectAll() {
		return data;
	}

	public Sach selectById(String id) {
		Sach sach = new Sach();
		sach.setMaSach(id);
		for (Sach item : data) {
			if (sach.equals(sach)) {
				return item;
			}
		}
		return null;
	}

	public int insert(Sach sach) {
		Sach check = this.selectById(sach.getMaSach());
		if (check == null) {
			data.add(sach);
			return 1;
		} else {
			return 0;
		}
	}

	public int insertAll(ArrayList<Sach> list) {
		int count = 0;
		for (Sach sach : list) {
			count += this.insert(sach);
		}
		return count;
	}

	public int delete(Sach sach) {
		Sach check = this.selectById(sach.getMaSach());
		if (check != null) {
			data.remove(sach);
			return 1;
		} else {
			return 0;
		}
	}

	public int deleteAll(ArrayList<Sach> list) {
		int count = 0;
		for (Sach sach : list) {
			count += this.delete(sach);
		}
		return count;
	}

	public int update(Sach sach) {
		Sach check = this.selectById(sach.getMaSach());
		if (check != null) {
			data.remove(sach);
			data.add(sach);
			return 1;
		} else {
			return 0;
		}
	}
}
