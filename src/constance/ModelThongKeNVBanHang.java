package constance;

import java.time.LocalDate;

public class ModelThongKeNVBanHang {
	private LocalDate ThoiGianThongKe;
	private int tongHoaDonDaLap;
	private int tongMatHangDaBan;
	private double tongDoanhThuBanHang;
	public ModelThongKeNVBanHang(LocalDate thoiGianThongKe, int tongHoaDonDaLap, int tongMatHangDaBan,
			double tongDoanhThuBanHang) {
		super();
		ThoiGianThongKe = thoiGianThongKe;
		this.tongHoaDonDaLap = tongHoaDonDaLap;
		this.tongMatHangDaBan = tongMatHangDaBan;
		this.tongDoanhThuBanHang = tongDoanhThuBanHang;
	}
	public ModelThongKeNVBanHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalDate getThoiGianThongKe() {
		return ThoiGianThongKe;
	}
	public void setThoiGianThongKe(LocalDate thoiGianThongKe) {
		ThoiGianThongKe = thoiGianThongKe;
	}
	public int getTongHoaDonDaLap() {
		return tongHoaDonDaLap;
	}
	public void setTongHoaDonDaLap(int tongHoaDonDaLap) {
		this.tongHoaDonDaLap = tongHoaDonDaLap;
	}
	public int getTongMatHangDaBan() {
		return tongMatHangDaBan;
	}
	public void setTongMatHangDaBan(int tongMatHangDaBan) {
		this.tongMatHangDaBan = tongMatHangDaBan;
	}
	public double getTongDoanhThuBanHang() {
		return tongDoanhThuBanHang;
	}
	public void setTongDoanhThuBanHang(double tongDoanhThuBanHang) {
		this.tongDoanhThuBanHang = tongDoanhThuBanHang;
	}
	@Override
	public String toString() {
		return "ModelThongKeNVBanHang [ThoiGianThongKe=" + ThoiGianThongKe + ", tongHoaDonDaLap=" + tongHoaDonDaLap
				+ ", tongMatHangDaBan=" + tongMatHangDaBan + ", tongDoanhThuBanHang=" + tongDoanhThuBanHang + "]";
	}
}
