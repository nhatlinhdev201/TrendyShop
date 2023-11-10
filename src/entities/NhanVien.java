package entities;

import java.util.Date;

public class NhanVien {
	private String maNhanVien;
	private String hoTen;
	private Date ngaySinh;
	private String soCCCD;
	private String soDienThoai;
	private String email;
	private String diaChi;
	private String chucVu;
	private boolean trangThai;
	private String matKhau;
	private boolean phanQuyen;
	private String anhDaiDien;
	

	
	public NhanVien() {
		super();
	}
	public NhanVien(String maNhanVien, String hoTen, Date ngaySinh, String soCCCD, String soDienThoai, String email,
			String diaChi, String chucVu, boolean trangThai, String matKhau, boolean phanQuyen, String anhDaiDien) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.soCCCD = soCCCD;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.trangThai = trangThai;
		this.matKhau = matKhau;
		this.phanQuyen = phanQuyen;
		this.anhDaiDien = anhDaiDien;
	}
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", soCCCD="
				+ soCCCD + ", soDienThoai=" + soDienThoai + ", email=" + email + ", diaChi=" + diaChi + ", chucVu="
				+ chucVu + ", trangThai=" + trangThai + ", matKhau=" + matKhau + ", phanQuyen=" + phanQuyen
				+ ", anhDaiDien=" + anhDaiDien + "]";
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSoCCCD() {
		return soCCCD;
	}
	public void setSoCCCD(String soCCCD) {
		this.soCCCD = soCCCD;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public boolean isPhanQuyen() {
		return phanQuyen;
	}
	public void setPhanQuyen(boolean phanQuyen) {
		this.phanQuyen = phanQuyen;
	}
	public String getAnhDaiDien() {
		return anhDaiDien;
	}
	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	
	
}
