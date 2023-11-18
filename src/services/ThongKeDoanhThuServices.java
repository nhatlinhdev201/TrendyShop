package services;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
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
		String xepHang="Toàn cửa hàng";
		
		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongNgay(ngayThongKe);
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongNgay(ngayThongKe);
		tongSoHoaDonDuocLap = dao_ThongKeDoanhThu.TongHoaDonTrongNgay(ngayThongKe);
		tongKhyuenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongNgay(ngayThongKe);
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
		int i=1;
		for(ModelThongKeDoanhThu model : arr) {
			model.setXepHang("Top "+i+" doanh thu");
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
	private void khoiTaoBieuDoTron(JPanel containPanel, LocalDate ngayThongKe) {
		ArrayList<ModelThongKeDoanhThu> dataList = new ArrayList<>();
		dataList = layDuLieuThongKeDoanhThuNgayTheoNv(ngayThongKe);
		containPanel.setLayout(new BorderLayout());

        DefaultPieDataset dataset = taoDataSetBieuDoTron(dataList);

        JFreeChart chart = ChartFactory.createPieChart(
                "Doanh thu các nhân viên trong ngày",
                dataset,
                true,
                true,
                false);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(true);

        ChartPanel chartPanel = new ChartPanel(chart);
        containPanel.add(chartPanel, BorderLayout.CENTER);
    }
	public ArrayList<ModelThongKeDoanhThu> layDuLieuThongKeCacNgayTrongThang(int thang, int namCuaThang) {
		ArrayList<ModelThongKeDoanhThu> dataDoanhThuCacNgayTrongThangTrenToanCh = new ArrayList<>();
		YearMonth yearMonth = YearMonth.of(namCuaThang, thang);
        System.out.println("Các ngày trong tháng " + thang + "/" + namCuaThang + ":");

        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
        	ModelThongKeDoanhThu model;
            LocalDate date = yearMonth.atDay(day);
            System.out.println(date);
            model = layGiuLieuThongKeNgayTrenToanCuaHangTheoNgay(date);
            dataDoanhThuCacNgayTrongThangTrenToanCh.add(model);
        }
        return dataDoanhThuCacNgayTrongThangTrenToanCh;
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

        JFreeChart barChart = ChartFactory.createBarChart(
                tenBieuDo,
                "Thời gian",
                "Doanh thu",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        if(data.size()>13) {
        	CategoryPlot plot = barChart.getCategoryPlot();
            CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
            //domainAxis.setCategoryLabelWidthType(CategoryLabelWidthType.RANGE);
            
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
    public ArrayList<ModelExportFileThongKe> layDuLieuFileThongKeNgay(LocalDate ngayThongKe) {
    	ArrayList<ModelExportFileThongKe> dataExport = new ArrayList<>();
    	YearMonth yearMonth = YearMonth.of(ngayThongKe.getYear(), ngayThongKe.getMonthValue());
        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
        	ModelExportFileThongKe model = new ModelExportFileThongKe();
        	model.setThoiGian(ngayThongKe.toString());
            LocalDate date = yearMonth.atDay(day);
            model.setDataNhanVien(layDuLieuThongKeDoanhThuNgayTheoNv(date));
            dataExport.add(model);
        }
    	return dataExport;
    }
}
