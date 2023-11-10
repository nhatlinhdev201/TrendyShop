package entities;

import java.util.Date;

public class HoaDon {
	private String maHoaDon;
	private Date thoiGiamTao;
	private float tongThanhTien;
	private VoucherGiamGia voucher;
	private KhachHang khachHang;
	private NhanVien NhanVien;
	private Boolean trangThaiThanhToan;
	public HoaDon() {
		super();
	}
	public HoaDon(String maHoaDon, Date thoiGiamTao, float tongThanhTien, VoucherGiamGia voucher, KhachHang khachHang,
			entities.NhanVien nhanVien, Boolean trangThaiThanhToan) {
		super();
		this.maHoaDon = maHoaDon;
		this.thoiGiamTao = thoiGiamTao;
		this.tongThanhTien = tongThanhTien;
		this.voucher = voucher;
		this.khachHang = khachHang;
		NhanVien = nhanVien;
		this.trangThaiThanhToan = trangThaiThanhToan;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public Date getThoiGiamTao() {
		return thoiGiamTao;
	}
	public void setThoiGiamTao(Date thoiGiamTao) {
		this.thoiGiamTao = thoiGiamTao;
	}
	public float getTongThanhTien() {
		return tongThanhTien;
	}
	public void setTongThanhTien(float tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}
	public VoucherGiamGia getVoucher() {
		return voucher;
	}
	public void setVoucher(VoucherGiamGia voucher) {
		this.voucher = voucher;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return NhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		NhanVien = nhanVien;
	}
	public Boolean getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}
	public void setTrangThaiThanhToan(Boolean trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", thoiGiamTao=" + thoiGiamTao + ", tongThanhTien=" + tongThanhTien
				+ ", voucher=" + voucher + ", khachHang=" + khachHang + ", NhanVien=" + NhanVien
				+ ", trangThaiThanhToan=" + trangThaiThanhToan + "]";
	}
	
}
