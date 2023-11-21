package constance;

import java.util.ArrayList;

public class ModelExportFileThongKe {
	private String thoiGian;
	private ArrayList<ModelThongKeDoanhThu> dataNhanVien;
	public ModelExportFileThongKe(String thoiGian, ArrayList<ModelThongKeDoanhThu> dataNhanVien) {
		super();
		this.thoiGian = thoiGian;
		this.dataNhanVien = dataNhanVien;
	}
	public ModelExportFileThongKe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	public ArrayList<ModelThongKeDoanhThu> getDataNhanVien() {
		return dataNhanVien;
	}
	public void setDataNhanVien(ArrayList<ModelThongKeDoanhThu> dataNhanVien) {
		this.dataNhanVien = dataNhanVien;
	}
	@Override
	public String toString() {
		return "ModelExportFileThongKe [thoiGian=" + thoiGian + ", dataNhanVien=" + dataNhanVien + "]";
	}
}
