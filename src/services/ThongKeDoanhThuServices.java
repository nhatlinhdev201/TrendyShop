package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import constance.ModelThongKeDoanhThu;
import daos.Dao_ThongKeDoanhThu;
import entities.NhanVien;

public class ThongKeDoanhThuServices {
	public ModelThongKeDoanhThu layDuLieuModelThongKeDoanhThuNgayTheoNv(NhanVien nhanVien, LocalDate today) {
		ModelThongKeDoanhThu model = new ModelThongKeDoanhThu();
		String maNhanVien = nhanVien.getMaNhanVien();
		String tenNhanVien = nhanVien.getHoTen();
		double tongDoanhThu;
		double tongTienNhapHang;
		double tongTienLai;
		double tongSoHoaDonDuocLap;
		double tongThue;
		double tongKhyuenMai;
		String thoiGianThongKe = today.toString();
		String xepHang="";
		
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongNgayNhanVienBan(today, nhanVien.getMaNhanVien());
		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongNgayCuaNhanVien(today, nhanVien.getMaNhanVien());
		tongSoHoaDonDuocLap = dao_ThongKeDoanhThu.TongHoaDonDocNhanVienLapTrongNgay(today, nhanVien.getMaNhanVien());
		tongKhyuenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongNgayTheoNhanVien(today, nhanVien.getMaNhanVien());
		tongThue = tongDoanhThu * 0.1f;
		tongTienLai = tongDoanhThu - tongTienNhapHang - tongKhyuenMai - tongThue;
		
		model.setMaNhanVien(maNhanVien);
		model.setTenNhanVien(tenNhanVien);
		model.setTongDoanhThu(tongDoanhThu);
		model.setTongTienNhapHang(tongTienNhapHang);
		model.setTongTienLai(tongTienLai);
		model.setTongSoHoaDonDuocLap(tongSoHoaDonDuocLap);
		model.setTongThue(tongThue);
		model.setTongKhyuenMai(tongKhyuenMai);
		model.setThoiGianThongKe(thoiGianThongKe);
		model.setXepHang(xepHang);
		return model;
	}
	public ArrayList<ModelThongKeDoanhThu> layDuLieuThongKeDoanhThuNgayTheoNv(LocalDate ngayThongKe) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		ArrayList<ModelThongKeDoanhThu> arr = new ArrayList<>();
		ArrayList<NhanVien> dataNhanVien = dao_ThongKeDoanhThu.layDanhSachNhanVienBanHang();
		for(NhanVien nv : dataNhanVien) {
			ModelThongKeDoanhThu model = new ModelThongKeDoanhThu();
			model = layDuLieuModelThongKeDoanhThuNgayTheoNv(nv, ngayThongKe);
			arr.add(model);
		}
		Collections.sort(arr, new Comparator<ModelThongKeDoanhThu>() {

			@Override
			public int compare(ModelThongKeDoanhThu o1, ModelThongKeDoanhThu o2) {
				if(o1.getTongDoanhThu()<o2.getTongDoanhThu()) 
					return 1;
				else {
					if(o1.getTongDoanhThu() == o2.getTongDoanhThu())
						return 0;
					else {
						return -1;
					}
				}
			}
		});
		for(ModelThongKeDoanhThu model : arr) {
			int i=1;
			model.setXepHang("Top "+i+" doanh thu");
			i++;
		}
		return arr;
	}
}
