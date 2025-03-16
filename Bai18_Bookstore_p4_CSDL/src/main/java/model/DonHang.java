package model;

import java.sql.Date;
import java.util.Objects;

public class DonHang {
	private String maDonHang;
	private KhachHang khachHang;
	private String diaChiNguoiMua;
	private KhachHang diaChiNhanHang;
	private String hinhThucThanhToan;
	private String TrangThaiThanhToan;
	private double soTienDaThanhToan;
	private double soTienConThieu;
	private String trangThai;
	private Date ngayDatHang;
	private Date ngayNhanHang;

	public DonHang() {

	}

	public DonHang(String maDonHang, KhachHang khachHang, String diaChiNguoiMua, KhachHang diaChiNhanHang,
			String hinhThucThanhToan, String trangThaiThanhToan, double soTienDaThanhToan, double soTienConThieu,
			String trangThai, Date ngayDatHang, Date ngayNhanHang) {
		super();
		this.maDonHang = maDonHang;
		this.khachHang = khachHang;
		this.diaChiNguoiMua = diaChiNguoiMua;
		this.diaChiNhanHang = diaChiNhanHang;
		this.hinhThucThanhToan = hinhThucThanhToan;
		TrangThaiThanhToan = trangThaiThanhToan;
		this.soTienDaThanhToan = soTienDaThanhToan;
		this.soTienConThieu = soTienConThieu;
		this.trangThai = trangThai;
		this.ngayDatHang = ngayDatHang;
		this.ngayNhanHang = ngayNhanHang;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public String getDiaChiNguoiMua() {
		return diaChiNguoiMua;
	}

	public void setDiaChiNguoiMua(String diaChiNguoiMua) {
		this.diaChiNguoiMua = diaChiNguoiMua;
	}

	public KhachHang getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(KhachHang diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}

	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}

	public String getTrangThaiThanhToan() {
		return TrangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
		TrangThaiThanhToan = trangThaiThanhToan;
	}

	public double getSoTienDaThanhToan() {
		return soTienDaThanhToan;
	}

	public void setSoTienDaThanhToan(double soTienDaThanhToan) {
		this.soTienDaThanhToan = soTienDaThanhToan;
	}

	public double getSoTienConThieu() {
		return soTienConThieu;
	}

	public void setSoTienConThieu(double soTienConThieu) {
		this.soTienConThieu = soTienConThieu;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public Date getNgayNhanHang() {
		return ngayNhanHang;
	}

	public void setNgayNhanHang(Date ngayNhanHang) {
		this.ngayNhanHang = ngayNhanHang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(TrangThaiThanhToan, diaChiNguoiMua, diaChiNhanHang, hinhThucThanhToan, khachHang, maDonHang,
				ngayDatHang, ngayNhanHang, soTienConThieu, soTienDaThanhToan, trangThai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonHang other = (DonHang) obj;
		return Objects.equals(maDonHang, other.maDonHang);

	}

	@Override
	public String toString() {
		return "DonHang [maDonHang=" + maDonHang + ", maKhachHang=" + khachHang.getMaKhachHang() + ", diaChiNguoiMua="
				+ diaChiNguoiMua + ", diaChiNhanHang=" + khachHang.getDiaChiNhanHang() + ", hinhThucThanhToan="
				+ hinhThucThanhToan + ", TrangThaiThanhToan=" + TrangThaiThanhToan + ", soTienDaThanhToan="
				+ soTienDaThanhToan + ", soTienConThieu=" + soTienConThieu + ", trangThai=" + trangThai
				+ ", ngayDatHang=" + ngayDatHang + ", ngayNhanHang=" + ngayNhanHang + "]";
	}

}
