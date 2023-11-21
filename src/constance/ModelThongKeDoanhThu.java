package constance;

public class ModelThongKeDoanhThu {
	private String maNhanVien;
	private String tenNhanVien;
	private double tongDoanhThu;
	private double tongTienNhapHang;
	private double tongTienLai;
	private double tongSoHoaDonDuocLap;
	private double tongThue;
	private double tongKhyuenMai;
	private String thoiGianThongKe;
	private String xepHang;
	public ModelThongKeDoanhThu(String maNhanVien, String tenNhanVien, double tongDoanhThu, double tongTienNhapHang,
			double tongTienLai, double tongSoHoaDonDuocLap, double tongThue, double tongKhyuenMai,
			String thoiGianThongKe, String xepHang) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.tongDoanhThu = tongDoanhThu;
		this.tongTienNhapHang = tongTienNhapHang;
		this.tongTienLai = tongTienLai;
		this.tongSoHoaDonDuocLap = tongSoHoaDonDuocLap;
		this.tongThue = tongThue;
		this.tongKhyuenMai = tongKhyuenMai;
		this.thoiGianThongKe = thoiGianThongKe;
		this.xepHang = xepHang;
	}
	public ModelThongKeDoanhThu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public double getTongDoanhThu() {
		return tongDoanhThu;
	}
	public void setTongDoanhThu(double tongDoanhThu) {
		this.tongDoanhThu = tongDoanhThu;
	}
	public double getTongTienNhapHang() {
		return tongTienNhapHang;
	}
	public void setTongTienNhapHang(double tongTienNhapHang) {
		this.tongTienNhapHang = tongTienNhapHang;
	}
	public double getTongTienLai() {
		return tongTienLai;
	}
	public void setTongTienLai(double tongTienLai) {
		this.tongTienLai = tongTienLai;
	}
	public double getTongSoHoaDonDuocLap() {
		return tongSoHoaDonDuocLap;
	}
	public void setTongSoHoaDonDuocLap(double tongSoHoaDonDuocLap) {
		this.tongSoHoaDonDuocLap = tongSoHoaDonDuocLap;
	}
	public double getTongThue() {
		return tongThue;
	}
	public void setTongThue(double tongThue) {
		this.tongThue = tongThue;
	}
	public double getTongKhyuenMai() {
		return tongKhyuenMai;
	}
	public void setTongKhyuenMai(double tongKhyuenMai) {
		this.tongKhyuenMai = tongKhyuenMai;
	}
	public String getThoiGianThongKe() {
		return thoiGianThongKe;
	}
	public void setThoiGianThongKe(String thoiGianThongKe) {
		this.thoiGianThongKe = thoiGianThongKe;
	}
	public String getXepHang() {
		return xepHang;
	}
	public void setXepHang(String xepHang) {
		this.xepHang = xepHang;
	}
	@Override
	public String toString() {
		return "ModelThongKeDoanhThu [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", tongDoanhThu="
				+ tongDoanhThu + ", tongTienNhapHang=" + tongTienNhapHang + ", tongTienLai=" + tongTienLai
				+ ", tongSoHoaDonDuocLap=" + tongSoHoaDonDuocLap + ", tongThue=" + tongThue + ", tongKhyuenMai="
				+ tongKhyuenMai + ", thoiGianThongKe=" + thoiGianThongKe + ", xepHang=" + xepHang + "]";
	}
}
