package constance;

import java.time.LocalDate;

public class ModelHoaDonSaoKe {
	private LocalDate ngayThongKe;
	private int soHoaDonDuocLap;
	private int soHoaDonDaThanhToan;
	private int soHOaDonChuaThanhToan;
	public ModelHoaDonSaoKe(LocalDate ngayThongKe, int soHoaDonDuocLap, int soHoaDonDaThanhToan,
			int soHOaDonChuaThanhToan) {
		super();
		this.ngayThongKe = ngayThongKe;
		this.soHoaDonDuocLap = soHoaDonDuocLap;
		this.soHoaDonDaThanhToan = soHoaDonDaThanhToan;
		this.soHOaDonChuaThanhToan = soHOaDonChuaThanhToan;
	}
	public ModelHoaDonSaoKe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalDate getNgayThongKe() {
		return ngayThongKe;
	}
	public void setNgayThongKe(LocalDate ngayThongKe) {
		this.ngayThongKe = ngayThongKe;
	}
	public int getSoHoaDonDuocLap() {
		return soHoaDonDuocLap;
	}
	public void setSoHoaDonDuocLap(int soHoaDonDuocLap) {
		this.soHoaDonDuocLap = soHoaDonDuocLap;
	}
	public int getSoHoaDonDaThanhToan() {
		return soHoaDonDaThanhToan;
	}
	public void setSoHoaDonDaThanhToan(int soHoaDonDaThanhToan) {
		this.soHoaDonDaThanhToan = soHoaDonDaThanhToan;
	}
	public int getSoHOaDonChuaThanhToan() {
		return soHOaDonChuaThanhToan;
	}
	public void setSoHOaDonChuaThanhToan(int soHOaDonChuaThanhToan) {
		this.soHOaDonChuaThanhToan = soHOaDonChuaThanhToan;
	}
	@Override
	public String toString() {
		return "ModelHoaDonSaoKe [ngayThongKe=" + ngayThongKe + ", soHoaDonDuocLap=" + soHoaDonDuocLap
				+ ", soHoaDonDaThanhToan=" + soHoaDonDaThanhToan + ", soHOaDonChuaThanhToan=" + soHOaDonChuaThanhToan
				+ "]";
	}
}
