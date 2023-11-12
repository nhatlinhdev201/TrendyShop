package entities;

public class NhaCungCap {
//<<<<<<< HEAD
//	private String maNhaCungCap;
//	private String tenNhaCungCap;
//	private String soDienThoai;
//	private String email;
//	private String DiaChi;
//	public NhaCungCap() {
//		super();
//	}
//	public NhaCungCap(String maNhaCungCap) {
//		super();
//		this.maNhaCungCap = maNhaCungCap;
//	}
//	
//	public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String soDienThoai, String email, String diaChi) {
//		super();
//		this.maNhaCungCap = maNhaCungCap;
//		this.tenNhaCungCap = tenNhaCungCap;
//		this.soDienThoai = soDienThoai;
//		this.email = email;
//		DiaChi = diaChi;
//	}
//	public void setMaNhaCungCap(String maNhaCungCap) {
//		this.maNhaCungCap = maNhaCungCap;
//	}
//	public String getTenNhaCungCap() {
//		return tenNhaCungCap;
//	}
//	public void setTenNhaCungCap(String tenNhaCungCap) {
//		this.tenNhaCungCap = tenNhaCungCap;
//	}
//	public String getSoDienThoai() {
//		return soDienThoai;
//	}
//	public void setSoDienThoai(String soDienThoai) {
//		this.soDienThoai = soDienThoai;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getDiaChi() {
//		return DiaChi;
//	}
//	public void setDiaChi(String diaChi) {
//		DiaChi = diaChi;
//	}
//	public String getMaNhaCungCap() {
//		return maNhaCungCap;
//	}
//	@Override
//	public String toString() {
//		return "NhaCungCap [maNhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + ", soDienThoai="
//				+ soDienThoai + ", email=" + email + ", DiaChi=" + DiaChi + "]";
//	}
//	
//	
//=======
    private String maNhaCungCap;
    private String tenNhaCungCap;
    private String soDienThoai;
    private String email;
    private String diaChi;

    public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String soDienThoai, String email, String diaChi) {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    
    public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    // Các phương thức setter
    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }


	@Override
	public String toString() {
		return this.tenNhaCungCap;
	}
    
//>>>>>>> 948e82c829c1ba0b78b3b340b382183dd6bcf994
}
