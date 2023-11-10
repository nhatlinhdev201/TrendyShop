package entities;

import java.time.LocalDateTime;

public class HoaDon {
	private String maHoaDon;
	private LocalDateTime thoiGiamTao;
	private KhachHang khachHang;
	private NhanVien nguoiLapHoaDon;
	private VoucherGiamGia maVoucher;
	private double tongThanhTien;
	private boolean trangThaiThanhToan;
	public HoaDon() {
		super();
	}
	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	
	public HoaDon(String maHoaDon, LocalDateTime thoiGiamTao, KhachHang khachHang, NhanVien nguoiLapHoaDon,
			VoucherGiamGia maVoucher) {
		super();
		this.maHoaDon = maHoaDon;
		this.thoiGiamTao = thoiGiamTao;
		this.khachHang = khachHang;
		this.nguoiLapHoaDon = nguoiLapHoaDon;
		this.maVoucher = maVoucher;
		this.trangThaiThanhToan=false;
	}
	public boolean isTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}
	public LocalDateTime getThoiGiamTao() {
		return thoiGiamTao;
	}
	public void setThoiGiamTao(LocalDateTime thoiGiamTao) {
		this.thoiGiamTao = thoiGiamTao;
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
	public VoucherGiamGia getMaVoucher() {
		return maVoucher;
	}
	public void setMaVoucher(VoucherGiamGia maVoucher) {
		this.maVoucher = maVoucher;
	}
	public double getTongThanhTien() {
		return tongThanhTien;
	}
	public void setTongThanhTien(double tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", thoiGiamTao=" + thoiGiamTao + ", khachHang="
				+ khachHang + ", nguoiLapHoaDon=" + nguoiLapHoaDon + ", maVoucher=" + maVoucher + ", tongThanhTien="
				+ tongThanhTien + "]";
	}
	
	public float kiemTraVoucherGiamGia(VoucherGiamGia voucher) {
		return 0;
		
	}
	public boolean kiemTraKhachHangThanhVien(KhachHang khachHang) {
		return true;
	}
}
