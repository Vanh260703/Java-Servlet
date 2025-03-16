package model;

import java.util.Objects;

public class ChiTietDonHang {
	private String maChiTietDonHang;
	private DonHang donHang;
	private String maSanPham;
	private int soLuong;
	private double giaBia;
	private double giaBan;
	private double giamGia;
	private double VAT;
	private double tongTien;

	public ChiTietDonHang() {

	}

	public ChiTietDonHang(String maChiTietDonHang, DonHang donHang, String maSanPham, int soLuong, double giaBia,
			double giaBan, double giamGia, double vAT, double tongTien) {
		super();
		this.maChiTietDonHang = maChiTietDonHang;
		this.donHang = donHang;
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
		this.giaBia = giaBia;
		this.giaBan = giaBan;
		this.giamGia = giamGia;
		VAT = vAT;
		this.tongTien = tongTien;
	}

	public String getMaChiTietDonHang() {
		return maChiTietDonHang;
	}

	public void setMaChiTietDonHang(String maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBia() {
		return giaBia;
	}

	public void setGiaBia(double giaBia) {
		this.giaBia = giaBia;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public double getVAT() {
		return VAT;
	}

	public void setVAT(double vAT) {
		VAT = vAT;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(VAT, donHang, giaBan, giaBia, giamGia, maChiTietDonHang, maSanPham, soLuong, tongTien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDonHang other = (ChiTietDonHang) obj;
		return Double.doubleToLongBits(VAT) == Double.doubleToLongBits(other.VAT)
				&& Objects.equals(maChiTietDonHang, other.maChiTietDonHang);
	}

}
