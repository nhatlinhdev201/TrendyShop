package entities;

public class ChiTietHoaDon {
	private HangHoa hangHoa;
	private HoaDon hoaDon;
	private int soLuong;
	private float thanhTien;
	public ChiTietHoaDon() {
		super();
	}
	public ChiTietHoaDon(HangHoa hangHoa, HoaDon hoaDon) {
		super();
		this.hangHoa = hangHoa;
		this.hoaDon = hoaDon;
	}
	public ChiTietHoaDon(HangHoa hangHoa, HoaDon hoaDon, int soLuong) {
		super();
		this.hangHoa = hangHoa;
		this.hoaDon = hoaDon;
		this.soLuong = soLuong;
		this.thanhTien = 0;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public float getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}
	public HangHoa getHangHoa() {
		return hangHoa;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [hangHoa=" + hangHoa + ", hoaDon=" + hoaDon + ", soLuong=" + soLuong + ", thanhTien="
				+ thanhTien + "]";
	}
	
	
}
