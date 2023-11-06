package entities;

public class KhachHang {
	private String soDienThoai;
	private String email;
	private String diaChi;
	private boolean trangThai;
	private float diemTichLuy;
	public KhachHang() {
		super();
	}
	public KhachHang(String soDienThoai) {
		super();
		this.soDienThoai = soDienThoai;
		
	}
	public KhachHang(String soDienThoai, String email, String diaChi, boolean trangThai) {
		super();
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
		this.trangThai = trangThai;
		this.diemTichLuy = 0;
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
	public String getSoDienThoai() {
		return soDienThoai;
	}
	@Override
	public String toString() {
		return "KhachHang [soDienThoai=" + soDienThoai + ", email=" + email + ", diaChi=" + diaChi + ", trangThai="
				+ trangThai + ", diemTichLuy=" + diemTichLuy + "]";
	}
	
	public float tinhDiemTichLuyTuHoaDon() {
		return 0;
	}
}
