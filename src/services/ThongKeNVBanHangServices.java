package services;

import java.awt.Dimension;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import constance.ModelThongKeNVBanHang;
import daos.Dao_ThongKeDoanhThu;
import entities.HoaDon;
import entities.NhanVien;

public class ThongKeNVBanHangServices {
	public ModelThongKeNVBanHang layThongTinThongKe(LocalDate ngayThongKe, NhanVien nhanVien) {
		Dao_ThongKeDoanhThu dao = new Dao_ThongKeDoanhThu();
		ModelThongKeNVBanHang model = new ModelThongKeNVBanHang();
		model.setThoiGianThongKe(ngayThongKe);
		model.setTongHoaDonDaLap(dao.TongHoaDonDocNhanVienLapTrongNgay(ngayThongKe, nhanVien.getMaNhanVien()));
		model.setTongMatHangDaBan(dao.TongSoLuongMatHangNhanVienBanRaTrongNgay(ngayThongKe, nhanVien.getMaNhanVien()));
		model.setTongDoanhThuBanHang(dao.TongDoanhThuTrongNgayCuaNhanVien(ngayThongKe, nhanVien.getMaNhanVien()));
		return model;
	}

	public ArrayList<ModelThongKeNVBanHang> layThongTinThongKe5NgayGanNhat(LocalDate thoiGian, NhanVien nhanVien) {
		LocalDate ngayHienTai = thoiGian;
		ModelThongKeNVBanHang model = new ModelThongKeNVBanHang();
		ArrayList<ModelThongKeNVBanHang> data = new ArrayList<>();
		model = layThongTinThongKe(thoiGian, nhanVien);
		data.add(model);
		for (int i = 1; i <= 4; i++) {
			LocalDate previousDay = ngayHienTai.minusDays(i);
			model = layThongTinThongKe(previousDay, nhanVien);
			data.add(model);
		}

		return data;
	}
	
	private CategoryDataset createDataset(ArrayList<ModelThongKeNVBanHang> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (ModelThongKeNVBanHang thongKe : data) {
            dataset.addValue(thongKe.getTongDoanhThuBanHang(), "Doanh thu", thongKe.getThoiGianThongKe().toString());
        }

        return dataset;
    }
	private JFreeChart createBarChart(ArrayList<ModelThongKeNVBanHang> data) {
        CategoryDataset dataset = createDataset(data);
        JFreeChart chart = ChartFactory.createBarChart(
                "Doanh thu 5 ngày gần nhất",
                "Thời gian",
                "Doanh thu",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        return chart;
    }
	public void veBieuDo(ArrayList<ModelThongKeNVBanHang> data, JPanel panelContain, LocalDate thoiGian, NhanVien nv) {
		panelContain.removeAll();
		data = layThongTinThongKe5NgayGanNhat(LocalDate.now(), nv);
        JFreeChart barChart = createBarChart(data);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(600, 400));
        panelContain.add(chartPanel);
        panelContain.revalidate();
        panelContain.repaint();
    }
	
	public ArrayList<HoaDon> layDanhSachHoaDon(NhanVien nv, LocalDate ngay) {
		Dao_ThongKeDoanhThu dao = new Dao_ThongKeDoanhThu();
		ArrayList<HoaDon> data = new ArrayList<>();
		data = dao.getHoaDonTheoNhanVienVaNgay(nv.getMaNhanVien().trim(), ngay);
		return data;
	}
}
