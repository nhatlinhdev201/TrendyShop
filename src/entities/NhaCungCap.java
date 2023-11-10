package entities;

public class NhaCungCap {
	private String maNhaCungCap;
	private String tenNhaCungCap;
	private String soDienThoai;
	private String email;
	private String DiaChi;
	public NhaCungCap() {
		super();
	}
	public NhaCungCap(String maNhaCungCap) {
		super();
		this.maNhaCungCap = maNhaCungCap;
	}
	
	public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String soDienThoai, String email, String diaChi) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.soDienThoai = soDienThoai;
		this.email = email;
		DiaChi = diaChi;
	}
	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}
	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
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
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}
	@Override
	public String toString() {
		return "NhaCungCap [maNhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + ", soDienThoai="
				+ soDienThoai + ", email=" + email + ", DiaChi=" + DiaChi + "]";
	}
	
	
}
