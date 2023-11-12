package modelsThongKe;

import java.time.LocalDate;

public class ModelThongKeDoanhThuNam {
	private int tongHdDuocLap;
	private int tongMhBanRa;
	private float tongDoanhThu;
	private float tongTienNhapHang;
	private float tongTienHangDaBan;
	private float tongTienKhuyenMai;
	private float tongThue;
	private float tongLai;
	private String maNhanVien;
	private int namThongKe;
	public ModelThongKeDoanhThuNam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModelThongKeDoanhThuNam(int tongHdDuocLap, int tongMhBanRa, float tongDoanhThu, float tongTienNhapHang,
			float tongTienHangDaBan, float tongTienKhuyenMai, float tongThue, float tongLai, String maNhanVien,
			int namThongKe) {
		super();
		this.tongHdDuocLap = tongHdDuocLap;
		this.tongMhBanRa = tongMhBanRa;
		this.tongDoanhThu = tongDoanhThu;
		this.tongTienNhapHang = tongTienNhapHang;
		this.tongTienHangDaBan = tongTienHangDaBan;
		this.tongTienKhuyenMai = tongTienKhuyenMai;
		this.tongThue = tongThue;
		this.tongLai = tongLai;
		this.maNhanVien = maNhanVien;
		this.namThongKe = namThongKe;
	}
	public int getTongHdDuocLap() {
		return tongHdDuocLap;
	}
	public void setTongHdDuocLap(int tongHdDuocLap) {
		this.tongHdDuocLap = tongHdDuocLap;
	}
	public int getTongMhBanRa() {
		return tongMhBanRa;
	}
	public void setTongMhBanRa(int tongMhBanRa) {
		this.tongMhBanRa = tongMhBanRa;
	}
	public float getTongDoanhThu() {
		return tongDoanhThu;
	}
	public void setTongDoanhThu(float tongDoanhThu) {
		this.tongDoanhThu = tongDoanhThu;
	}
	public float getTongTienNhapHang() {
		return tongTienNhapHang;
	}
	public void setTongTienNhapHang(float tongTienNhapHang) {
		this.tongTienNhapHang = tongTienNhapHang;
	}
	public float getTongTienHangDaBan() {
		return tongTienHangDaBan;
	}
	public void setTongTienHangDaBan(float tongTienHangDaBan) {
		this.tongTienHangDaBan = tongTienHangDaBan;
	}
	public float getTongTienKhuyenMai() {
		return tongTienKhuyenMai;
	}
	public void setTongTienKhuyenMai(float tongTienKhuyenMai) {
		this.tongTienKhuyenMai = tongTienKhuyenMai;
	}
	public float getTongThue() {
		return tongThue;
	}
	public void setTongThue(float tongThue) {
		this.tongThue = tongThue;
	}
	public float getTongLai() {
		return tongLai;
	}
	public void setTongLai(float tongLai) {
		this.tongLai = tongLai;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public int getNamThongKe() {
		return namThongKe;
	}
	public void setNamThongKe(int namThongKe) {
		this.namThongKe = namThongKe;
	}
	@Override
	public String toString() {
		return "ModelThongKeDoanhThuNam [tongHdDuocLap=" + tongHdDuocLap + ", tongMhBanRa=" + tongMhBanRa
				+ ", tongDoanhThu=" + tongDoanhThu + ", tongTienNhapHang=" + tongTienNhapHang + ", tongTienHangDaBan="
				+ tongTienHangDaBan + ", tongTienKhuyenMai=" + tongTienKhuyenMai + ", tongThue=" + tongThue
				+ ", tongLai=" + tongLai + ", maNhanVien=" + maNhanVien + ", namThongKe=" + namThongKe + "]";
	}
	
}
