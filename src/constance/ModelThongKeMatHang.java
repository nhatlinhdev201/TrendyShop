package constance;

public class ModelThongKeMatHang {
	private String xepHang;
	private String thoiGian;
	private String maHangHoa;
	private String tenHangHoa;
	private int soLuongBan;
	private float doanhThu;
	private int soLuongTon;
	private int soLuongDaBan;
	public ModelThongKeMatHang(String xepHang, String thoiGian, String maHangHoa, String tenHangHoa, int soLuongBan,
			float doanhThu, int soLuongTon, int soLuongDaBan) {
		super();
		this.xepHang = xepHang;
		this.thoiGian = thoiGian;
		this.maHangHoa = maHangHoa;
		this.tenHangHoa = tenHangHoa;
		this.soLuongBan = soLuongBan;
		this.doanhThu = doanhThu;
		this.soLuongTon = soLuongTon;
		this.soLuongDaBan = soLuongDaBan;
	}
	public ModelThongKeMatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getXepHang() {
		return xepHang;
	}
	public void setXepHang(String xepHang) {
		this.xepHang = xepHang;
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	public String getMaHangHoa() {
		return maHangHoa;
	}
	public void setMaHangHoa(String maHangHoa) {
		this.maHangHoa = maHangHoa;
	}
	public String getTenHangHoa() {
		return tenHangHoa;
	}
	public void setTenHangHoa(String tenHangHoa) {
		this.tenHangHoa = tenHangHoa;
	}
	public int getSoLuongBan() {
		return soLuongBan;
	}
	public void setSoLuongBan(int soLuongBan) {
		this.soLuongBan = soLuongBan;
	}
	public float getDoanhThu() {
		return doanhThu;
	}
	public void setDoanhThu(float doanhThu) {
		this.doanhThu = doanhThu;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public int getSoLuongDaBan() {
		return soLuongDaBan;
	}
	public void setSoLuongDaBan(int soLuongDaBan) {
		this.soLuongDaBan = soLuongDaBan;
	}
	@Override
	public String toString() {
		return "ModelThongKeMatHang [xepHang=" + xepHang + ", thoiGian=" + thoiGian + ", maHangHoa=" + maHangHoa
				+ ", tenHangHoa=" + tenHangHoa + ", soLuongBan=" + soLuongBan + ", doanhThu=" + doanhThu
				+ ", soLuongTon=" + soLuongTon + ", soLuongDaBan=" + soLuongDaBan + "]";
	} 
}
