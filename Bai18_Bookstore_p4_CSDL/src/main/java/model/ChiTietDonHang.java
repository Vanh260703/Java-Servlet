package model;

import java.util.Objects;

public class ChiTietDonHang {
	private String maChiTietDonHang;
	private DonHang maDonHang;
	private Sach maSanPham;
	private Sach soLuong;
	private double giaBia;
	private Sach giaBan;
	private double giamGia;
	private double vat;
	private double tongTien;

	public ChiTietDonHang() {

	}

	public ChiTietDonHang(String maChiTietDonHang, DonHang maDonHang, Sach maSanPham, Sach soLuong, double giaBia,
			Sach giaBan, double giamGia, double vat, double tongTien) {
		super();
		this.maChiTietDonHang = maChiTietDonHang;
		this.maDonHang = maDonHang;
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
		this.giaBia = giaBia;
		this.giaBan = giaBan;
		this.giamGia = giamGia;
		this.vat = vat;
		this.tongTien = tongTien;
	}

	public String getMaChiTietDonHang() {
		return maChiTietDonHang;
	}

	public void setMaChiTietDonHang(String maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}

	public DonHang getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(DonHang maDonHang) {
		this.maDonHang = maDonHang;
	}

	public Sach getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(Sach maSanPham) {
		this.maSanPham = maSanPham;
	}

	public Sach getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Sach soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBia() {
		return giaBia;
	}

	public void setGiaBia(double giaBia) {
		this.giaBia = giaBia;
	}

	public Sach getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(Sach giaBan) {
		this.giaBan = giaBan;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(giaBan, giaBia, giamGia, maChiTietDonHang, maDonHang, maSanPham, soLuong, tongTien, vat);
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
		return Objects.equals(giaBan, other.giaBan)
				&& Double.doubleToLongBits(giaBia) == Double.doubleToLongBits(other.giaBia)
				&& Double.doubleToLongBits(giamGia) == Double.doubleToLongBits(other.giamGia)
				&& Objects.equals(maChiTietDonHang, other.maChiTietDonHang)
				&& Objects.equals(maDonHang, other.maDonHang) && Objects.equals(maSanPham, other.maSanPham)
				&& Objects.equals(soLuong, other.soLuong)
				&& Double.doubleToLongBits(tongTien) == Double.doubleToLongBits(other.tongTien)
				&& Double.doubleToLongBits(vat) == Double.doubleToLongBits(other.vat);
	}

	@Override
	public String toString() {
		return "ChiTietDonHang [maChiTietDonHang=" + maChiTietDonHang + ", maDonHang=" + maDonHang.getMaDonHang()
				+ ", maSanPham=" + maSanPham.getMaSach() + ", soLuong=" + maSanPham.getSoLuong() + ", giaBia=" + giaBia
				+ ", giaBan=" + maSanPham.getGiaBan() + ", giamGia=" + giamGia + ", vat=" + vat + ", tongTien="
				+ tongTien + "]";
	}

}
