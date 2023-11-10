package entities;

public class ChiTietHoaDon {
	private HangHoa hangHoa;
	private HoaDon hoaDon;
	private int soLuong;
	private float giaBan;
	private float thanhTien;
	public HangHoa getHangHoa() {
		return hangHoa;
	}
	public void setHangHoa(HangHoa hangHoa) {
		this.hangHoa = hangHoa;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public float getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}
	public float getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [hangHoa=" + hangHoa + ", hoaDon=" + hoaDon + ", soLuong=" + soLuong + ", giaBan="
				+ giaBan + ", thanhTien=" + thanhTien + "]";
	}
}
