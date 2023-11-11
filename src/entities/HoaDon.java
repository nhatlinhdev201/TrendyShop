package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HoaDon {
	private String maHoaDon;
	private LocalDate thoiGianTao;
	private KhachHang khachHang;
	private NhanVien nguoiLapHoaDon;
	private VoucherGiamGia Voucher;
	private double tongThanhTien;
	private boolean trangThaiThanhToan;
	public HoaDon() {
		super();
	}
	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	
	public HoaDon(String maHoaDon, LocalDate thoiGiamTao, KhachHang khachHang, NhanVien nguoiLapHoaDon,
			VoucherGiamGia Voucher) {
		super();
		this.maHoaDon = maHoaDon;
		this.thoiGianTao = thoiGiamTao;
		this.khachHang = khachHang;
		this.nguoiLapHoaDon = nguoiLapHoaDon;
		this.Voucher = Voucher;
		this.trangThaiThanhToan=false;
	}
	public VoucherGiamGia getVoucher() {
		return Voucher;
	}
	
	
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public LocalDate getThoiGianTao() {
		return thoiGianTao;
	}
	public void setThoiGianTao(LocalDate thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNguoiLapHoaDon() {
		return nguoiLapHoaDon;
	}
	public void setNguoiLapHoaDon(NhanVien nguoiLapHoaDon) {
		this.nguoiLapHoaDon = nguoiLapHoaDon;
	}
	public double getTongThanhTien() {
		return tongThanhTien;
	}
	public void setTongThanhTien(double tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}
	public boolean isTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}
	public void setTrangThaiThanhToan(boolean trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}
	public void setVoucher(VoucherGiamGia voucher) {
		Voucher = voucher;
	}
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", thoiGiamTao=" + thoiGianTao + ", khachHang="
				+ khachHang + ", nguoiLapHoaDon=" + nguoiLapHoaDon + ", maVoucher=" + Voucher + ", tongThanhTien="
				+ tongThanhTien + "]";
	}
	
	public float kiemTraVoucherGiamGia(VoucherGiamGia voucher) {
		return 0;
		
	}
	public boolean kiemTraKhachHangThanhVien(KhachHang khachHang) {
		return true;
	}
}
