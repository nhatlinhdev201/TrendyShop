package entities;

import java.time.LocalDateTime;
import java.util.Date;

public class PhienDangNhap {
	private String maPhienDangNhap;
	private Date thoiGianDangNhap;
	private Date thoiGianDangXuat;
	private NhanVien nhanVienDangNhap;
	public PhienDangNhap() {
		super();
	}
	
	public PhienDangNhap(String maPhienDangNhap, Date thoiGianDangNhap, Date thoiGianDangXuat,
			NhanVien nhanVienDangNhap) {
		super();
		this.maPhienDangNhap = maPhienDangNhap;
		this.thoiGianDangNhap = thoiGianDangNhap;
		this.thoiGianDangXuat = thoiGianDangXuat;
		this.nhanVienDangNhap = nhanVienDangNhap;
	}

	public PhienDangNhap(String maPhienDangNhap) {
		super();
		this.maPhienDangNhap = maPhienDangNhap;
	}
	public String getMaPhienDangNhap() {
		return maPhienDangNhap;
	}
	public void setMaPhienDangNhap(String maPhienDangNhap) {
		this.maPhienDangNhap = maPhienDangNhap;
	}
	public Date getThoiGianDangNhap() {
		return thoiGianDangNhap;
	}
	public void setThoiGianDangNhap(Date thoiGianDangNhap) {
		this.thoiGianDangNhap = thoiGianDangNhap;
	}
	public Date getThoiGianDangXuat() {
		return thoiGianDangXuat;
	}
	public void setThoiGianDangXuat(Date thoiGianDangXuat) {
		this.thoiGianDangXuat = thoiGianDangXuat;
	}
	public NhanVien getNhanVienDangNhap() {
		return nhanVienDangNhap;
	}
	public void setNhanVienDangNhap(NhanVien nhanVienDangNhap) {
		this.nhanVienDangNhap = nhanVienDangNhap;
	}
	@Override
	public String toString() {
		return "PhienDangNhap [maPhienDangNhap=" + maPhienDangNhap + ", nhanVienDangNhap=" + nhanVienDangNhap
				+ ", thoiGianDangNhap=" + thoiGianDangNhap + ", thoiGianDangXuat=" + thoiGianDangXuat + "]";
	}
	
}
