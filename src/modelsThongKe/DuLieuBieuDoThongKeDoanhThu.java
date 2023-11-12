package modelsThongKe;

public class DuLieuBieuDoThongKeDoanhThu {
	private String thoiGian;
    private float tongDoanhThu;
	public DuLieuBieuDoThongKeDoanhThu(String thoiGian, float tongDoanhThu) {
		super();
		this.thoiGian = thoiGian;
		this.tongDoanhThu = tongDoanhThu;
	}
	public DuLieuBieuDoThongKeDoanhThu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	public float getTongDoanhThu() {
		return tongDoanhThu;
	}
	public void setTongDoanhThu(float tongDoanhThu) {
		this.tongDoanhThu = tongDoanhThu;
	}
	@Override
	public String toString() {
		return "DuLieuBieuDoThongKeDoanhThuNgay [thoiGian=" + thoiGian + ", tongDoanhThu=" + tongDoanhThu + "]";
	}

}
