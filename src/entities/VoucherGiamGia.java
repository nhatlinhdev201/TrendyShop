package entities;

import java.util.Date;

public class VoucherGiamGia {
	private String maVoucher;
	private String tenVoucher;
	private String moTaChuongTrinh;
	private float phanTramGiamTheoHoaDon;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private boolean trangThai;
	private int soLuotDung;

	public VoucherGiamGia() {
		super();
	}

	public VoucherGiamGia(String maVoucher) {
		super();
		this.maVoucher = maVoucher;
	}

	public VoucherGiamGia(String maVoucher, String tenVoucher, String moTaChuongTrinh, float phanTramGiamTheoHoaDon,
			float giaGiamKhongtheoHoaDon, Date ngayBatDau, Date ngayKetThuc, boolean trangThai, int soLuotSuDung) {
		super();
		this.maVoucher = maVoucher;
		this.tenVoucher = tenVoucher;
		this.moTaChuongTrinh = moTaChuongTrinh;
		this.phanTramGiamTheoHoaDon = phanTramGiamTheoHoaDon;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.trangThai = trangThai;
		this.soLuotDung = soLuotSuDung;
	}

	

	public String getMaVoucher() {
		return maVoucher;
	}

	public void setMaVoucher(String maVoucher) {
		this.maVoucher = maVoucher;
	}

	public String getTenVoucher() {
		return tenVoucher;
	}

	public void setTenVoucher(String tenVoucher) {
		this.tenVoucher = tenVoucher;
	}

	public String getMoTaChuongTrinh() {
		return moTaChuongTrinh;
	}

	public void setMoTaChuongTrinh(String moTaChuongTrinh) {
		this.moTaChuongTrinh = moTaChuongTrinh;
	}

	public float getPhanTramGiamTheoHoaDon() {
		return phanTramGiamTheoHoaDon;
	}

	public void setPhanTramGiamTheoHoaDon(float phanTramGiamTheoHoaDon) {
		this.phanTramGiamTheoHoaDon = phanTramGiamTheoHoaDon;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public int getSoLuotDung() {
		return soLuotDung;
	}

	public void setSoLuotDung(int soLuotDung) {
		this.soLuotDung = soLuotDung;
	}

	@Override
	public String toString() {
		return "VoucherGiamGia [maVoucher=" + maVoucher + ", tenVoucher=" + tenVoucher + ", moTaChuongTrinh="
				+ moTaChuongTrinh + ", phanTramGiamTheoHoaDon=" + phanTramGiamTheoHoaDon + ", ngayBatDau=" + ngayBatDau
				+ ", ngayKetThuc=" + ngayKetThuc + ", trangThai=" + trangThai + ", soLuotSuDung=" + soLuotDung + "]";
	}

}
