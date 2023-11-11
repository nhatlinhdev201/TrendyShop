package entities;

public class ChiTietHoaDon {
	private HangHoa hangHoa;
	private HoaDon hoaDon;
	private int soLuong;
	private double giaBan;
	private double thanhTien;
	public ChiTietHoaDon() {
		super();
	}
	public ChiTietHoaDon(HangHoa hangHoa, HoaDon hoaDon) {
		super();
		this.hangHoa = hangHoa;
		this.hoaDon = hoaDon;
	}
	public ChiTietHoaDon(HangHoa hangHoa, HoaDon hoaDon, int soLuong, double giaBan) {
		super();
		this.hangHoa = hangHoa;
		this.hoaDon = hoaDon;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.thanhTien = 0;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	public HangHoa getHangHoa() {
		return hangHoa;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHangHoa(HangHoa hangHoa) {
		this.hangHoa = hangHoa;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [hangHoa=" + hangHoa + ", hoaDon=" + hoaDon + ", soLuong=" + soLuong + ", thanhTien="
				+ thanhTien + "]";
	}
	
	public double tinhTongThanhTien() {
		return giaBan*soLuong;
	}
}
