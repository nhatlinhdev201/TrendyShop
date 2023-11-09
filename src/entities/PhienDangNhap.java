package entities;

import java.time.LocalDateTime;

public class PhienDangNhap {
	private String maPhienDangNhap;
	private LocalDateTime thoiGianDangNhap;
	private LocalDateTime thoiGianDangXuat;
	private NhanVien nhanVienDangNhap;
	public PhienDangNhap() {
		super();
	}
	public PhienDangNhap(String maPhienDangNhap) {
		super();
		this.maPhienDangNhap = maPhienDangNhap;
	}
	public PhienDangNhap(String maPhienDangNhap, LocalDateTime thoiGianDangNhap, LocalDateTime thoiGianDangXuat,
			NhanVien nhanVienDangNhap) {
		super();
		this.maPhienDangNhap = maPhienDangNhap;
		this.thoiGianDangNhap = thoiGianDangNhap;
		this.thoiGianDangXuat = thoiGianDangXuat;
		this.nhanVienDangNhap = nhanVienDangNhap;
	}
	public LocalDateTime getThoiGianDangNhap() {
		return thoiGianDangNhap;
	}
	public void setThoiGianDangNhap(LocalDateTime thoiGianDangNhap) {
		this.thoiGianDangNhap = thoiGianDangNhap;
	}
	public LocalDateTime getThoiGianDangXuat() {
		return thoiGianDangXuat;
	}
	public void setThoiGianDangXuat(LocalDateTime thoiGianDangXuat) {
		this.thoiGianDangXuat = thoiGianDangXuat;
	}
	public NhanVien getNhanVienDangNhap() {
		return nhanVienDangNhap;
	}
	public void setNhanVienDangNhap(NhanVien nhanVienDangNhap) {
		this.nhanVienDangNhap = nhanVienDangNhap;
	}
	public String getMaPhienDangNhap() {
		return maPhienDangNhap;
	}
	@Override
	public String toString() {
		return "PhienDangNhap [maPhienDangNhap=" + maPhienDangNhap + ", thoiGianDangNhap=" + thoiGianDangNhap
				+ ", thoiGianDangXuat=" + thoiGianDangXuat + ", nhanVienDangNhap=" + nhanVienDangNhap + "]";
	}
	
	
}
