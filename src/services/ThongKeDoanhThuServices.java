package services;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constance.ModelExportFileThongKe;
import constance.ModelThongKeDoanhThu;
import services.ThongKeDoanhThuServices;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import constance.ModelExportFileThongKe;
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
		String xepHang = "";

		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongNgayNhanVienBan(today, nhanVien.getMaNhanVien());
		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongNgayCuaNhanVien(today, nhanVien.getMaNhanVien());
		tongSoHoaDonDuocLap = dao_ThongKeDoanhThu.TongHoaDonDocNhanVienLapTrongNgay(today, nhanVien.getMaNhanVien());
		tongKhyuenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongNgayTheoNhanVien(today, nhanVien.getMaNhanVien());
		double gia = (tongTienNhapHang+0.7f*tongTienNhapHang)*0.1f;
		tongThue = (tongTienNhapHang+0.7f*tongTienNhapHang)*0.1f;
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
	public ModelThongKeDoanhThu layDuLieuModelThongKeDoanhThuThangTheoNv(NhanVien nhanVien, int thang, int namCuaThang) {
		ModelThongKeDoanhThu model = new ModelThongKeDoanhThu();
		String maNhanVien = nhanVien.getMaNhanVien();
		String tenNhanVien = nhanVien.getHoTen();
		double tongDoanhThu;
		double tongTienNhapHang;
		double tongTienLai;
		double tongSoHoaDonDuocLap;
		double tongThue;
		double tongKhyuenMai;
		String thoiGianThongKe = thang+"/"+namCuaThang;
		String xepHang = "";

		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongThangNhanVienBan(thang, namCuaThang, maNhanVien);
		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongThangCuaNhanVien(thang, namCuaThang, maNhanVien);
		tongSoHoaDonDuocLap = dao_ThongKeDoanhThu.TongHoaDonDuocNhanVienLapTrongThang(thang, namCuaThang, maNhanVien);
		tongKhyuenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongThangTheoNhanVien(thang, namCuaThang, maNhanVien);
		tongThue = (tongTienNhapHang+0.7f*tongTienNhapHang)*0.1f;
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
	public ModelThongKeDoanhThu layDuLieuModelThongKeDoanhThuNamTheoNv(NhanVien nhanVien,int nam) {
		ModelThongKeDoanhThu model = new ModelThongKeDoanhThu();
		String maNhanVien = nhanVien.getMaNhanVien();
		String tenNhanVien = nhanVien.getHoTen();
		double tongDoanhThu;
		double tongTienNhapHang;
		double tongTienLai;
		double tongSoHoaDonDuocLap;
		double tongThue;
		double tongKhyuenMai;
		String thoiGianThongKe = String.valueOf(nam);
		String xepHang = "";

		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongNamNhanVienBan(nam, maNhanVien);
		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongNamCuaNhanVien(nam, maNhanVien);
		tongSoHoaDonDuocLap = dao_ThongKeDoanhThu.TongHoaDonDuocNhanVienLapTrongNam(nam, maNhanVien);
		tongKhyuenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongNamTheoNhanVien(nam, maNhanVien);
		tongThue = (tongTienNhapHang+0.7f*tongTienNhapHang)*0.1f;
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

	public ModelThongKeDoanhThu layGiuLieuThongKeNgayTrenToanCuaHangTheoNgay(LocalDate ngayThongKe) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		ModelThongKeDoanhThu model = new ModelThongKeDoanhThu();
		String maNhanVien = "Toàn cửa hàng";
		String tenNhanVien = "Toàn cửa hàng";
		double tongDoanhThu;
		double tongTienNhapHang;
		double tongTienLai;
		double tongSoHoaDonDuocLap;
		double tongThue;
		double tongKhyuenMai;
		String thoiGianThongKe = ngayThongKe.toString();
		String xepHang = "Toàn cửa hàng";

		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongNgay(ngayThongKe);
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongNgay(ngayThongKe);
		tongSoHoaDonDuocLap = dao_ThongKeDoanhThu.TongHoaDonTrongNgay(ngayThongKe);
		tongKhyuenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongNgay(ngayThongKe);
		tongThue = (tongTienNhapHang+0.7f*tongTienNhapHang)*0.1f;
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
	public ModelThongKeDoanhThu layGiuLieuThongKeTrenToanCuaHangTheoThang(int thang, int namCuaThang) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		ModelThongKeDoanhThu model = new ModelThongKeDoanhThu();
		String maNhanVien = "Toàn cửa hàng";
		String tenNhanVien = "Toàn cửa hàng";
		double tongDoanhThu;
		double tongTienNhapHang;
		double tongTienLai;
		double tongSoHoaDonDuocLap;
		double tongThue;
		double tongKhyuenMai;
		String thoiGianThongKe = thang+"/"+namCuaThang;
		String xepHang = "Toàn cửa hàng";

		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongThang(thang, namCuaThang);
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongThang(thang, namCuaThang);
		tongSoHoaDonDuocLap = dao_ThongKeDoanhThu.TongHoaDonTrongThang(thang, namCuaThang);
		tongKhyuenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongThang(thang, namCuaThang);
		tongThue = (tongTienNhapHang+0.7f*tongTienNhapHang)*0.1f;
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
	
	public ModelThongKeDoanhThu layGiuLieuThongKeTrenToanCuaHangTheoNam(int nam) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		ModelThongKeDoanhThu model = new ModelThongKeDoanhThu();
		String maNhanVien = "Toàn cửa hàng";
		String tenNhanVien = "Toàn cửa hàng";
		double tongDoanhThu;
		double tongTienNhapHang;
		double tongTienLai;
		double tongSoHoaDonDuocLap;
		double tongThue;
		double tongKhyuenMai;
		String thoiGianThongKe = String.valueOf(nam);
		String xepHang = "Toàn cửa hàng";

		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongNam(nam);
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongNam(nam);
		tongSoHoaDonDuocLap = dao_ThongKeDoanhThu.TongHoaDonDuocLapTrongNam(nam);
		tongKhyuenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongNam(nam);
		tongThue = (tongTienNhapHang+0.7f*tongTienNhapHang)*0.1f;
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
		for (NhanVien nv : dataNhanVien) {
			ModelThongKeDoanhThu model = new ModelThongKeDoanhThu();
			model = layDuLieuModelThongKeDoanhThuNgayTheoNv(nv, ngayThongKe);
			arr.add(model);
		}
		Collections.sort(arr, new Comparator<ModelThongKeDoanhThu>() {

			@Override
			public int compare(ModelThongKeDoanhThu o1, ModelThongKeDoanhThu o2) {
				if (o1.getTongDoanhThu() < o2.getTongDoanhThu())
					return 1;
				else {
					if (o1.getTongDoanhThu() == o2.getTongDoanhThu())
						return 0;
					else {
						return -1;
					}
				}
			}
		});
		int i = 1;
		for (ModelThongKeDoanhThu model : arr) {
			model.setXepHang("Top " + i + " doanh thu");
			i++;
		}
		i = 1;
		return arr;
	}
	public ArrayList<ModelThongKeDoanhThu> layDuLieuThongKeDoanhThuThangTheoNv(int thang, int namCuaThang) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		ArrayList<ModelThongKeDoanhThu> arr = new ArrayList<>();
		ArrayList<NhanVien> dataNhanVien = dao_ThongKeDoanhThu.layDanhSachNhanVienBanHang();
		for (NhanVien nv : dataNhanVien) {
			ModelThongKeDoanhThu model = new ModelThongKeDoanhThu();
			model = layDuLieuModelThongKeDoanhThuThangTheoNv(nv, thang, namCuaThang);
			arr.add(model);
		}
		Collections.sort(arr, new Comparator<ModelThongKeDoanhThu>() {

			@Override
			public int compare(ModelThongKeDoanhThu o1, ModelThongKeDoanhThu o2) {
				if (o1.getTongDoanhThu() < o2.getTongDoanhThu())
					return 1;
				else {
					if (o1.getTongDoanhThu() == o2.getTongDoanhThu())
						return 0;
					else {
						return -1;
					}
				}
			}
		});
		int i = 1;
		for (ModelThongKeDoanhThu model : arr) {
			model.setXepHang("Top " + i + " doanh thu");
			i++;
		}
		i = 1;
		return arr;
	}
	public ArrayList<ModelThongKeDoanhThu> layDuLieuThongKeDoanhThuNamTheoNv(int nam) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		ArrayList<ModelThongKeDoanhThu> arr = new ArrayList<>();
		ArrayList<NhanVien> dataNhanVien = dao_ThongKeDoanhThu.layDanhSachNhanVienBanHang();
		for (NhanVien nv : dataNhanVien) {
			ModelThongKeDoanhThu model = new ModelThongKeDoanhThu();
			model = layDuLieuModelThongKeDoanhThuNamTheoNv(nv, nam);
			arr.add(model);
		}
		Collections.sort(arr, new Comparator<ModelThongKeDoanhThu>() {

			@Override
			public int compare(ModelThongKeDoanhThu o1, ModelThongKeDoanhThu o2) {
				if (o1.getTongDoanhThu() < o2.getTongDoanhThu())
					return 1;
				else {
					if (o1.getTongDoanhThu() == o2.getTongDoanhThu())
						return 0;
					else {
						return -1;
					}
				}
			}
		});
		int i = 1;
		for (ModelThongKeDoanhThu model : arr) {
			model.setXepHang("Top " + i + " doanh thu");
			i++;
		}
		i = 1;
		return arr;
	}
	private DefaultPieDataset taoDataSetBieuDoTron(ArrayList<ModelThongKeDoanhThu> dataList) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (ModelThongKeDoanhThu data : dataList) {
			dataset.setValue(data.getTenNhanVien(), data.getTongDoanhThu());
		}
		return dataset;
	}

	public void khoiTaoBieuDoTron(JPanel containPanel, LocalDate ngayThongKe) {
		ArrayList<ModelThongKeDoanhThu> dataList = new ArrayList<>();
		dataList = layDuLieuThongKeDoanhThuNgayTheoNv(ngayThongKe);
		containPanel.setLayout(new BorderLayout());

		DefaultPieDataset dataset = taoDataSetBieuDoTron(dataList);

		JFreeChart chart = ChartFactory.createPieChart("Doanh thu các nhân viên trong ngày", dataset, true, true,
				false);

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
		plot.setNoDataMessage("Không có dữ liệu doanh thu trong ngày");
		plot.setCircular(true);
		 // Thiết lập hiển thị phần trăm
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", new DecimalFormat("0.0"), new DecimalFormat("0.0%")));
		ChartPanel chartPanel = new ChartPanel(chart);
		containPanel.add(chartPanel, BorderLayout.CENTER);
	}

	public ArrayList<ModelThongKeDoanhThu> layDuLieuThongKeCacNgayTrongThang(int thang, int namCuaThang) {
		ArrayList<ModelThongKeDoanhThu> dataDoanhThuCacNgayTrongThangTrenToanCh = new ArrayList<>();
		YearMonth yearMonth = YearMonth.of(namCuaThang, thang);

		for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
			ModelThongKeDoanhThu model;
			LocalDate date = yearMonth.atDay(day);
			model = layGiuLieuThongKeNgayTrenToanCuaHangTheoNgay(date);
			dataDoanhThuCacNgayTrongThangTrenToanCh.add(model);
		}
		return dataDoanhThuCacNgayTrongThangTrenToanCh;
	}
	public ArrayList<ModelThongKeDoanhThu> layDuLieuThongKeCacThangTrongNam(int nam) {
		ArrayList<ModelThongKeDoanhThu> dataDoanhThuCacThangTrongNamTrenToanCh = new ArrayList<>();

		for (int month = 1; month < 13; month++) {
			ModelThongKeDoanhThu model;
			model = layGiuLieuThongKeTrenToanCuaHangTheoThang(month, nam);
			dataDoanhThuCacThangTrongNamTrenToanCh.add(model);
		}
		return dataDoanhThuCacThangTrongNamTrenToanCh;
	}

	public void veBieuDoCotDoanhThu(JPanel contaiPanel, ArrayList<ModelThongKeDoanhThu> data, String tenBieuDo) {
		contaiPanel.setLayout(new BorderLayout());

		JFreeChart barChart = taoBieuDo(data, tenBieuDo);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(504, 515));

		contaiPanel.add(chartPanel, BorderLayout.CENTER);
	}

	private JFreeChart taoBieuDo(ArrayList<ModelThongKeDoanhThu> data, String tenBieuDo) {
		DefaultCategoryDataset dataset = taoDataSet(data);

		JFreeChart barChart = ChartFactory.createBarChart(tenBieuDo, "Thời gian", "Doanh thu", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		if (data.size() > 10) {
			CategoryPlot plot = barChart.getCategoryPlot();
			CategoryAxis domainAxis = plot.getDomainAxis();
			domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
			// domainAxis.setCategoryLabelWidthType(CategoryLabelWidthType.RANGE);

			// Đặt kích cỡ chữ cho tiêu đề biểu đồ
			barChart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 12));

			// Đặt kích cỡ chữ cho nhãn trục x
			domainAxis.setLabelFont(new Font("SansSerif", Font.PLAIN, 10));
			domainAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 8));

			// Đặt kích cỡ chữ cho nhãn trục y
			ValueAxis rangeAxis = plot.getRangeAxis();
			rangeAxis.setLabelFont(new Font("SansSerif", Font.PLAIN, 10));
			rangeAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 8));
			DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
			decimalFormat.setGroupingUsed(true);
			decimalFormat.setGroupingSize(3);

			rangeAxis = (NumberAxis) plot.getRangeAxis();
			((NumberAxis) rangeAxis).setNumberFormatOverride(decimalFormat);

			BarRenderer renderer = (BarRenderer) plot.getRenderer();
			renderer.setItemMargin(0.05);
		}

		return barChart;
	}

	private DefaultCategoryDataset taoDataSet(ArrayList<ModelThongKeDoanhThu> data) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (ModelThongKeDoanhThu model : data) {
			dataset.addValue(model.getTongDoanhThu(), "Tổng doanh thu", model.getThoiGianThongKe());
		}

		return dataset;
	}

	public ArrayList<ModelExportFileThongKe> layDuLieuFileThongKeCacNgayTrongThang(int thang, int namCuaThang) {
		ArrayList<ModelExportFileThongKe> dataExport = new ArrayList<>();
		YearMonth yearMonth = YearMonth.of(namCuaThang, thang);
		for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
			ModelExportFileThongKe model = new ModelExportFileThongKe();
			LocalDate date = yearMonth.atDay(day);
			model.setThoiGian(date.toString());
			ArrayList<ModelThongKeDoanhThu> dataDoanhThu = layDuLieuThongKeDoanhThuNgayTheoNv(date);
			ModelThongKeDoanhThu doanhThuTong = layGiuLieuThongKeNgayTrenToanCuaHangTheoNgay(date);
			dataDoanhThu.add(doanhThuTong);
			model.setDataNhanVien(dataDoanhThu);
			dataExport.add(model);
		}
//        for(ModelExportFileThongKe model : dataExport) {
//        	System.out.println(model.toString());
//        }
		return dataExport;
	}
	public ArrayList<ModelExportFileThongKe> layDuLieuFileThongKeNgay(LocalDate ngayThongKe) {
		ArrayList<ModelExportFileThongKe> dataExport = new ArrayList<>();
		ModelExportFileThongKe model = new ModelExportFileThongKe();
		model.setThoiGian(ngayThongKe.toString());
		ArrayList<ModelThongKeDoanhThu> dataDoanhThu = layDuLieuThongKeDoanhThuNgayTheoNv(ngayThongKe);
		ModelThongKeDoanhThu doanhThuTong = layGiuLieuThongKeNgayTrenToanCuaHangTheoNgay(ngayThongKe);
		dataDoanhThu.add(doanhThuTong);
		model.setDataNhanVien(dataDoanhThu);
		dataExport.add(model);
		return dataExport;
	}
	public ArrayList<ModelExportFileThongKe> layDuLieuFileThongKeCachThangTrongNam(int namCuaThang) {
		ArrayList<ModelExportFileThongKe> dataExport = new ArrayList<>();
		for (int month = 1; month < 13; month++) {
			ModelExportFileThongKe model = new ModelExportFileThongKe();
			model.setThoiGian(month+"/"+namCuaThang);
			ArrayList<ModelThongKeDoanhThu> dataDoanhThu = layDuLieuThongKeDoanhThuThangTheoNv(month, namCuaThang);
			ModelThongKeDoanhThu doanhThuTong = layGiuLieuThongKeTrenToanCuaHangTheoThang(month, namCuaThang);
			dataDoanhThu.add(doanhThuTong);
			model.setDataNhanVien(dataDoanhThu);
			dataExport.add(model);
		}
//        for(ModelExportFileThongKe model : dataExport) {
//        	System.out.println(model.toString());
//        }
		return dataExport;
	}

	public boolean taoMauXuatFileExcel(ArrayList<ModelExportFileThongKe> duLieuFileExcel, String filePath) {
		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("DuLieuThongKe");

//			// Tạo Font cho tiêu đề in đậm
//			Font headerFont = workbook.createFont();
//			headerFont.setBold(true);
//
//			// Tạo CellStyle cho tiêu đề in đậm
//			CellStyle headerCellStyle = workbook.createCellStyle();
//			headerCellStyle.setFont(headerFont);

			// Tạo header
			Row headerRow = sheet.createRow(0);
			headerRow.createCell(0).setCellValue("Thời Gian");
			headerRow.createCell(1).setCellValue("Xếp hạng doanh thu");
			headerRow.createCell(2).setCellValue("Mã nhân viên");
			headerRow.createCell(3).setCellValue("Tên nhân viên");
			headerRow.createCell(4).setCellValue("Tổng doanh thu");
			headerRow.createCell(5).setCellValue("Tổng tiền nhập hàng");
			headerRow.createCell(6).setCellValue("Tổng lãi trong ngày");
			headerRow.createCell(7).setCellValue("Tổng hóa đơn được lập");
			headerRow.createCell(8).setCellValue("Tổng thuế");
			headerRow.createCell(9).setCellValue("Tổng tiền khuyến mãi");

//			// Áp dụng CellStyle cho tiêu đề
//			for (Cell cell : headerRow) {
//				cell.setCellStyle(headerCellStyle);
//			}
			// Ghi dữ liệu
			int rowNum = 1;
			for (ModelExportFileThongKe modelExportFileThongKe : duLieuFileExcel) {
				String thoiGian = modelExportFileThongKe.getThoiGian();
				ArrayList<ModelThongKeDoanhThu> dataNhanVien = modelExportFileThongKe.getDataNhanVien();

				for (int i = 0; i < dataNhanVien.size(); i++) {
					ModelThongKeDoanhThu modelThongKeDoanhThu = dataNhanVien.get(i);

					Row row = sheet.createRow(rowNum++);

					// Chỉ ghi giá trị ở dòng đầu tiên của mỗi nhóm thời gian
					if (i == 0) {
						row.createCell(0).setCellValue(thoiGian);
					}

					// if(modelThongKeDoanhThu.getTongDoanhThu()!=0) {
					row.createCell(1).setCellValue(modelThongKeDoanhThu.getXepHang());
					row.createCell(2).setCellValue(modelThongKeDoanhThu.getMaNhanVien().trim());
					row.createCell(3).setCellValue(modelThongKeDoanhThu.getTenNhanVien().trim());
					row.createCell(4).setCellValue(modelThongKeDoanhThu.getTongDoanhThu());
					row.createCell(5).setCellValue(modelThongKeDoanhThu.getTongTienNhapHang());
					row.createCell(6).setCellValue(modelThongKeDoanhThu.getTongTienLai());
					row.createCell(7).setCellValue(modelThongKeDoanhThu.getTongSoHoaDonDuocLap());
					row.createCell(8).setCellValue(modelThongKeDoanhThu.getTongThue());
					row.createCell(9).setCellValue(modelThongKeDoanhThu.getTongKhyuenMai());

					// }
				}
			}
			// Đặt độ rộng của các cột
			for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
				sheet.autoSizeColumn(i);
			}

			// Lưu file
			try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
				workbook.write(fileOut);
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean xuatFileExcelThongKeNgay(LocalDate ngayThongKe) {
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		ArrayList<ModelExportFileThongKe> dataList = new ArrayList<>();
		dataList = layDuLieuFileThongKeNgay(ngayThongKe);

		// Xuất ra file Excel
		return taoMauXuatFileExcel(dataList, "DuLieuThongKe\\"+"ThongKeDoanhThuTrongNgay"+ngayThongKe.toString()+".xlsx");
	}
	public boolean xuatFileExcelThongKeCacNgayTrongThang(int thang, int namCuaThang) {
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		ArrayList<ModelExportFileThongKe> dataList = new ArrayList<>();
		dataList = services.layDuLieuFileThongKeCacNgayTrongThang(thang,namCuaThang);

		// Xuất ra file Excel
		return taoMauXuatFileExcel(dataList, "DuLieuThongKe\\"+"ThongKeDoanhThuCacNgayTrongThang"+thang+"-"+namCuaThang+ ".xlsx");
	}
	public boolean xuatFileExcelThongKeCacThangTrongNam(int namThongKe) {
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		ArrayList<ModelExportFileThongKe> dataList = new ArrayList<>();
		dataList = services.layDuLieuFileThongKeCachThangTrongNam(namThongKe);

		// Xuất ra file Excel
		return taoMauXuatFileExcel(dataList, "DuLieuThongKe\\"+"ThongKeDoanhThuCacThangTrongNam"+namThongKe+".xlsx");
	}
}
