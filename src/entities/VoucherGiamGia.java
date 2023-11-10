package entities;

import java.time.LocalDateTime;

public class VoucherGiamGia {
	private String maVoucher;
	private String tenVoucher;
	private String moTaChuongTrinh;
	private float phanTramGiamTheoHoaDon;
	private float giaGiamKhongtheoHoaDon;
	private LocalDateTime ngayBatDau;
	private LocalDateTime ngayKetThuc;
	private boolean trangThai;
	private int soLuotSuDung;
	public VoucherGiamGia() {
		super();
	}
	public VoucherGiamGia(String maVoucher) {
		super();
		this.maVoucher = maVoucher;
	}
	public VoucherGiamGia(String maVoucher, String tenVoucher, String moTaChuongTrinh, float phanTramGiamTheoHoaDon,
			float giaGiamKhongtheoHoaDon, LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc, boolean trangThai, int soLuotSuDung) {
		super();
		this.maVoucher = maVoucher;
		this.tenVoucher = tenVoucher;
		this.moTaChuongTrinh = moTaChuongTrinh;
		this.phanTramGiamTheoHoaDon = phanTramGiamTheoHoaDon;
		this.giaGiamKhongtheoHoaDon = giaGiamKhongtheoHoaDon;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.trangThai = trangThai;
		this.soLuotSuDung = soLuotSuDung;
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
	public float getGiaGiamKhongtheoHoaDon() {
		return giaGiamKhongtheoHoaDon;
	}
	public void setGiaGiamKhongtheoHoaDon(float giaGiamKhongtheoHoaDon) {
		this.giaGiamKhongtheoHoaDon = giaGiamKhongtheoHoaDon;
	}
	public LocalDateTime getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(LocalDateTime ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public LocalDateTime getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(LocalDateTime ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public int getSoLuotSuDung() {
		return soLuotSuDung;
	}
	public void setSoLuotSuDung(int soLuotSuDung) {
		this.soLuotSuDung = soLuotSuDung;
	}
	public String getMaVoucher() {
		return maVoucher;
	}
	@Override
	public String toString() {
		return "VoucherGiamGia [maVoucher=" + maVoucher + ", tenVoucher=" + tenVoucher + ", moTaChuongTrinh="
				+ moTaChuongTrinh + ", phanTramGiamTheoHoaDon=" + phanTramGiamTheoHoaDon + ", giaGiamKhongtheoHoaDon="
				+ giaGiamKhongtheoHoaDon + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc
				+ ", trangThai=" + trangThai + ", soLuotSuDung=" + soLuotSuDung
				+ "]";
	}
	
}
