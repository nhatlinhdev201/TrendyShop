package entities;

public class HangHoa {
	 private String maHangHoa;
	    private String tenHangHoa;
	    private String phanLoai;
	    private String thuongHieu;
	    private String xuatXu;
	    private String chatLieu;
	    private String chiTietMoTa;
	    private String hinhAnh;
	    private String maNhaCungCap;
	    private String kichCo;
	    private String mauSac;
	    private int soLuongTon;
	    private int soLuongDaBan;
	    private double donGiaNhap;
	    private boolean trangThai;

	    
	    public HangHoa() {
		}

		public HangHoa(String maHangHoa, String tenHangHoa, String phanLoai, String thuongHieu, String xuatXu,
				String chatLieu, String chiTietMoTa, String hinhAnh, String maNhaCungCap, String kichCo, String mauSac,
				int soLuongTon, int soLuongDaBan, double donGiaNhap, boolean trangThai) {
			this.maHangHoa = maHangHoa;
			this.tenHangHoa = tenHangHoa;
			this.phanLoai = phanLoai;
			this.thuongHieu = thuongHieu;
			this.xuatXu = xuatXu;
			this.chatLieu = chatLieu;
			this.chiTietMoTa = chiTietMoTa;
			this.hinhAnh = hinhAnh;
			this.maNhaCungCap = maNhaCungCap;
			this.kichCo = kichCo;
			this.mauSac = mauSac;
			this.soLuongTon = soLuongTon;
			this.soLuongDaBan = soLuongDaBan;
			this.donGiaNhap = donGiaNhap;
			this.trangThai = trangThai;
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

		public String getPhanLoai() {
			return phanLoai;
		}

		public void setPhanLoai(String phanLoai) {
			this.phanLoai = phanLoai;
		}

		public String getThuongHieu() {
			return thuongHieu;
		}

		public void setThuongHieu(String thuongHieu) {
			this.thuongHieu = thuongHieu;
		}

		public String getXuatXu() {
			return xuatXu;
		}

		public void setXuatXu(String xuatXu) {
			this.xuatXu = xuatXu;
		}

		public String getChatLieu() {
			return chatLieu;
		}

		public void setChatLieu(String chatLieu) {
			this.chatLieu = chatLieu;
		}

		public String getChiTietMoTa() {
			return chiTietMoTa;
		}

		public void setChiTietMoTa(String chiTietMoTa) {
			this.chiTietMoTa = chiTietMoTa;
		}

		public String getHinhAnh() {
			return hinhAnh;
		}

		public void setHinhAnh(String hinhAnh) {
			this.hinhAnh = hinhAnh;
		}

		public String getMaNhaCungCap() {
			return maNhaCungCap;
		}

		public void setMaNhaCungCap(String maNhaCungCap) {
			this.maNhaCungCap = maNhaCungCap;
		}

		public String getKichCo() {
			return kichCo;
		}

		public void setKichCo(String kichCo) {
			this.kichCo = kichCo;
		}

		public String getMauSac() {
			return mauSac;
		}

		public void setMauSac(String mauSac) {
			this.mauSac = mauSac;
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

		public double getDonGiaNhap() {
			return donGiaNhap;
		}

		public void setDonGiaNhap(double donGiaNhap) {
			this.donGiaNhap = donGiaNhap;
		}

		public boolean isTrangThai() {
			return trangThai;
		}

		public void setTrangThai(boolean trangThai) {
			this.trangThai = trangThai;
		}

		@Override
		public String toString() {
			return "HangHoa [maHangHoa=" + maHangHoa + ", tenHangHoa=" + tenHangHoa + ", phanLoai=" + phanLoai
					+ ", thuongHieu=" + thuongHieu + ", xuatXu=" + xuatXu + ", chatLieu=" + chatLieu + ", chiTietMoTa="
					+ chiTietMoTa + ", hinhAnh=" + hinhAnh + ", maNhaCungCap=" + maNhaCungCap + ", kichCo=" + kichCo
					+ ", mauSac=" + mauSac + ", soLuongTon=" + soLuongTon + ", soLuongDaBan=" + soLuongDaBan
					+ ", donGiaNhap=" + donGiaNhap + ", trangThai=" + trangThai + "]";
		}

		
}