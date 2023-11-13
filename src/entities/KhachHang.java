package entities;

public class KhachHang {
	private String maKhachHang;
	private String soDienThoai;
	private String tenKhachHang;
	private String email;
	private String diaChi;
	private boolean trangThai;
	private float diemTichLuy;

	public KhachHang() {
		super();
	}

	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;

	}

	public KhachHang(String maKhachHang, String soDienThoai, String tenKhachHang, String email, String diaChi) {
		super();
		this.maKhachHang = maKhachHang;
		this.soDienThoai = soDienThoai;
		this.tenKhachHang = tenKhachHang;
		this.email = email;
		this.diaChi = diaChi;
		this.trangThai = trangThai;
		this.diemTichLuy = diemTichLuy;
	}
	public KhachHang(String maKhachHang, String soDienThoai, String tenKhachHang, String email, String diaChi,boolean trangThai,float diemTichLuy) {
		super();
		this.maKhachHang = maKhachHang;
		this.soDienThoai = soDienThoai;
		this.tenKhachHang = tenKhachHang;
		this.email = email;
		this.diaChi = diaChi;
		this.trangThai = trangThai;
		this.diemTichLuy = diemTichLuy;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
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

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public float getDiemTichLuy() {
		return diemTichLuy;
	}

	public void setDiemTichLuy(float diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", soDienThoai=" + soDienThoai + ", tenKhachHang="
				+ tenKhachHang + ", email=" + email + ", diaChi=" + diaChi + ", trangThai=" + trangThai
				+ ", diemTichLuy=" + diemTichLuy + "]";
	}
	
	

}
