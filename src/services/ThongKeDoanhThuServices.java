package services;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import daos.Dao_ThongKeDoanhThu;
import entities.NhanVien;
import modelsThongKe.BieuDoThongKePanel;
import modelsThongKe.DuLieuBieuDoThongKeDoanhThu;
import modelsThongKe.ModelThongKeDoanhThuNgay;
import modelsThongKe.ModelThongKeDoanhThuThang;

public class ThongKeDoanhThuServices {
	public void VeBieuDoThongKeDoanhThuNgay(JPanel panelContain, LocalDate date, NhanVien nhanVien, String tenBieuDo) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		LocalDate today = LocalDate.now();
		DuLieuBieuDoThongKeDoanhThu doanhThuNgayHienTai = new DuLieuBieuDoThongKeDoanhThu("Hôm nay ",
				dao_ThongKeDoanhThu.TongDoanhThuTrongNgayCuaNhanVien(today, nhanVien.getMaNhanVien().trim()));

		ArrayList<DuLieuBieuDoThongKeDoanhThu> data = dao_ThongKeDoanhThu.duLieuBieuDo_Top5NgayDoanhThuCaoNhatTrongThang(10, 2022, nhanVien.getMaNhanVien().trim());
		data.add(0, doanhThuNgayHienTai);
		panelContain.removeAll();
		BieuDoThongKePanel bieuDoThongKePanel = new BieuDoThongKePanel(data, tenBieuDo);
		panelContain.setLayout(new BorderLayout());
		panelContain.add(bieuDoThongKePanel, BorderLayout.CENTER);

		panelContain.revalidate(); // Cần revalidate để cập nhật giao diện
		panelContain.repaint(); // Cần repaint để vẽ lại giao diện
	}

	private void LayDuLieuThongKeNgay(ModelThongKeDoanhThuNgay model, NhanVien taiKhoan, LocalDate today) {
		int tongHdDuocLap;
		int tongMhBanRa;
		float tongDoanhThu;
		float tongTienNhapHang;
		float tongTienHangDaBan;
		float tongTienKhuyenMai;
		float tongThue;
		float tongLai;
		model.setDate(today);
		model.setMaNhanVien(taiKhoan.getMaNhanVien().trim());
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();

		tongHdDuocLap = dao_ThongKeDoanhThu.TongHoaDonDocNhanVienLapTrongNgay(model.getDate(), model.getMaNhanVien());
		tongMhBanRa = dao_ThongKeDoanhThu.TongSoLuongMatHangNhanVienBanRaTrongNgay(model.getDate(),
				model.getMaNhanVien());
		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongNgayCuaNhanVien(model.getDate(), model.getMaNhanVien());
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongNgayNhanVienBan(model.getDate(),
				model.getMaNhanVien());
		tongTienHangDaBan = tongTienNhapHang + tongTienNhapHang * 0.7f;
		tongTienKhuyenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongNgayTheoNhanVien(model.getDate(),
				model.getMaNhanVien());
		tongThue = tongDoanhThu * 0.1f;
		tongLai = tongDoanhThu - tongTienNhapHang - tongTienKhuyenMai - tongThue;
		model.setTongHdDuocLap(tongHdDuocLap);
		model.setTongMhBanRa(tongMhBanRa);
		model.setTongDoanhThu(tongDoanhThu);
		model.setTongTienNhapHang(tongTienNhapHang);
		model.setTongTienHangDaBan(tongTienHangDaBan);
		model.setTongTienKhuyenMai(tongTienKhuyenMai);
		model.setTongThue(tongThue);
		model.setTongLai(tongLai);
	}
	private void callDataThongKeThang(ModelThongKeDoanhThuThang model) {
		int tongHdDuocLap;
		int tongMhBanRa;
		float tongDoanhThu;
		float tongTienNhapHang;
		float tongTienHangDaBan;
		float tongTienKhuyenMai;
		float tongThue;
		float tongLai;
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();

		tongHdDuocLap = dao_ThongKeDoanhThu.TongHoaDonDuocNhanVienLapTrongThang(model.getThangThongKe(), model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongMhBanRa = dao_ThongKeDoanhThu.TongSoLuongMatHangNhanVienBanRaTrongThang(model.getThangThongKe(), model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongThangCuaNhanVien(model.getThangThongKe(), model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongThangNhanVienBan(model.getThangThongKe(), model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongTienHangDaBan = tongTienNhapHang + tongTienNhapHang * 0.7f;
		tongTienKhuyenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongThangTheoNhanVien(model.getThangThongKe(), model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongThue = tongDoanhThu / 0.9f;
		tongLai = tongDoanhThu - tongTienNhapHang;
		model.setTongHdDuocLap(tongHdDuocLap);
		model.setTongMhBanRa(tongMhBanRa);
		model.setTongDoanhThu(tongDoanhThu);
		model.setTongTienNhapHang(tongTienNhapHang);
		model.setTongTienHangDaBan(tongTienHangDaBan);
		model.setTongTienKhuyenMai(tongTienKhuyenMai);
		model.setTongThue(tongThue);
		model.setTongLai(tongLai);
	}
	// Định dạng số theo tiền Việt Nam (phân tách hàng nghìn bằng dấu ".")
	public String ChuyenThanhTien(float money) {
		long roundedMoney = Math.round(money);
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String formattedMoney = decimalFormat.format(roundedMoney);
		return formattedMoney;
	}

	private static LocalDate convertDateToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	private static LocalDate convertCalendarToLocalDate(Calendar calendar) {
        Instant instant = calendar.toInstant();
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }
	public ArrayList<ModelThongKeDoanhThuNgay> thongKeCacNgayTrongThang(int thang, int nam, NhanVien taiKhoan) {
        ArrayList<ModelThongKeDoanhThuNgay> duLieuThongKe = new ArrayList<>();
		LocalDate ngayHienTai = LocalDate.of(nam, thang, 1);
        // Lặp qua từng ngày của tháng
        while (ngayHienTai.getMonthValue() == thang) {
            System.out.println(ngayHienTai); // Xuất ngày
            ModelThongKeDoanhThuNgay doanhThuNgay = new ModelThongKeDoanhThuNgay();
            doanhThuNgay.setDate(ngayHienTai);
            doanhThuNgay.setMaNhanVien(taiKhoan.getMaNhanVien().toString());
            LayDuLieuThongKeNgay(doanhThuNgay, taiKhoan, ngayHienTai);
            duLieuThongKe.add(doanhThuNgay);
            // Chuyển sang ngày tiếp theo
            ngayHienTai = ngayHienTai.plusDays(1);
        }
        return duLieuThongKe;
    }
	
	public ArrayList<ModelThongKeDoanhThuThang> thongKeDoanhThuCacThangTrongNam(int nam, NhanVien taiKhoan) {
		ArrayList<ModelThongKeDoanhThuThang> duLieuThongKe = new ArrayList<>();
		for(int i = 1; i<13; i++) {
			ModelThongKeDoanhThuThang doanhThuThang = new ModelThongKeDoanhThuThang();
			doanhThuThang.setThangThongKe(i);
			doanhThuThang.setNamCuaThangThongKe(nam);
			doanhThuThang.setMaNhanVien(taiKhoan.getMaNhanVien());
			callDataThongKeThang(doanhThuThang);
			duLieuThongKe.add(doanhThuThang);
		}
		return duLieuThongKe;
	}
}
