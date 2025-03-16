package model;

import java.util.Objects;

public class Sach {
	private String maSach;
	private String tenSach; // Tên sách
	private TacGia TacGia;
	private int namXuatBan; // Năm xuất bản
	private double giaNhap; // Giá nhập
	private double giaBan; // Giá bán
	private double soLuong; // Số lượng
	private TheLoai theLoai; // Thể loại
	private String ngonNgu; // Ngôn ngữ
	private String moTa; // Mô tả

	public Sach() {

	}

	public Sach(String maSach, String tenSach, model.TacGia tacGia, int namXuatBan, double giaNhap, double giaBan,
			double soLuong, TheLoai theLoai, String ngonNgu, String moTa) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		TacGia = tacGia;
		this.namXuatBan = namXuatBan;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.theLoai = theLoai;
		this.ngonNgu = ngonNgu;
		this.moTa = moTa;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public TacGia getTacGia() {
		return TacGia;
	}

	public void setTacGia(TacGia tacGia) {
		TacGia = tacGia;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public TheLoai getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}

	public String getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(TacGia, giaBan, giaNhap, maSach, moTa, namXuatBan, ngonNgu, soLuong, tenSach, theLoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", maTacGia=" + TacGia.getMaTacGia()
				+ ", namXuatBan=" + namXuatBan + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", soLuong=" + soLuong
				+ ", theLoai=" + theLoai + ", ngonNgu=" + ngonNgu + ", moTa=" + moTa + "]";
	}

}
