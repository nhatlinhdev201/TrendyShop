package services;

import java.awt.Dimension;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

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
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import constance.ModelThongKeDoanhThu;
import constance.ModelThongKeMatHang;
import daos.Dao_ThongKeMatHang;

public class ThongKeMatHangServices {
	
	public void taoBieuDoCotThongKeMatHangTheoNgay(JPanel panelCointain, LocalDate ngayThongKe) {
        panelCointain.removeAll();
		CategoryDataset dataset = taoDataSetBieuDoThongKeTheoNgay(ngayThongKe);
        JFreeChart barChart = veBieuDoThongKeMatHangTheoNgay(dataset);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(555, 485));

        panelCointain.add(chartPanel);
        panelCointain.revalidate();
        panelCointain.repaint();
    }
	private CategoryDataset taoDataSetBieuDoThongKeTheoNgay(LocalDate ngayThongKe) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (ModelThongKeMatHang matHang : layDuLieuThongkeNgay(ngayThongKe)) {
            dataset.addValue(matHang.getSoLuongBan(), "Số lượng đã bán trong ngày", matHang.getMaHangHoa().trim());
        }
        return dataset;
    }
	
	private JFreeChart veBieuDoThongKeMatHangTheoNgay(CategoryDataset dataset) {
        JFreeChart chart =  ChartFactory.createBarChart(
                "Top mặt hàng bán chạy trong ngày",
                "Mã hàng hóa",
                "Số lượng",
                dataset
        );
     // Lấy CategoryPlot từ biểu đồ
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        // Xác định góc nghiêng của nhãn trục x (CategoryAxis)
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        return chart;
    }
	
	public void taoBieuDoCotThongKeMatHangTheoThang(JPanel panelCointain, int thang, int nam) {
        panelCointain.removeAll();
		CategoryDataset dataset = taoDataSetBieuDoThongKeTheoThang(thang,nam);
        JFreeChart barChart = veBieuDoThongKeMatHangTheoThang(dataset);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(555, 485));

        panelCointain.add(chartPanel);
        panelCointain.revalidate();
        panelCointain.repaint();
    }
	private CategoryDataset taoDataSetBieuDoThongKeTheoThang(int thang, int nam) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (ModelThongKeMatHang matHang : layDuLieuThongkeThang(thang, nam)) {
            dataset.addValue(matHang.getSoLuongBan(), "Số lượng đã bán trong tháng", matHang.getMaHangHoa().trim());
        }
        return dataset;
    }
	
	private JFreeChart veBieuDoThongKeMatHangTheoThang(CategoryDataset dataset) {
        JFreeChart chart =  ChartFactory.createBarChart(
                "TOP mặt hàng bán chạy trong tháng",
                "Mã hàng hóa",
                "Số lượng",
                dataset
        );
//        // Thay đổi kích thước chữ cho cột x (Mã hàng hóa)
//        CategoryPlot plot = chart.getCategoryPlot();
//        CategoryAxis domainAxis = plot.getDomainAxis();
//        domainAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 8)); // Đặt kích thước chữ
//        domainAxis.setLabelFont(new Font("SansSerif", Font.PLAIN, 10)); // Đặt kích thước chữ
//
//        // Thay đổi kích thước chữ cho cột y (Số lượng/Doanh thu)
//        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//        rangeAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 8)); // Đặt kích thước chữ
//        rangeAxis.setLabelFont(new Font("SansSerif", Font.PLAIN, 10)); // Đặt kích thước chữ
//        rangeAxis.setTickUnit(new NumberTickUnit(1)); // Đặt đơn vị tick
     // Lấy CategoryPlot từ biểu đồ
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        // Xác định góc nghiêng của nhãn trục x (CategoryAxis)
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        return chart;
    }
	public void taoBieuDoCotThongKeMatHangTheoNam(JPanel panelCointain, int nam) {
        panelCointain.removeAll();
		CategoryDataset dataset = taoDataSetBieuDoThongKeTheoNam(nam);
        JFreeChart barChart = veBieuDoThongKeMatHangTheoThang(dataset);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(555, 485));

        panelCointain.add(chartPanel);
        panelCointain.revalidate();
        panelCointain.repaint();
    }
	private CategoryDataset taoDataSetBieuDoThongKeTheoNam(int nam) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (ModelThongKeMatHang matHang : layDuLieuThongkeNam(nam)) {
            dataset.addValue(matHang.getSoLuongBan(), "Số lượng đã bán trong năm", matHang.getMaHangHoa().trim());
        }
        return dataset;
    }
	
	private JFreeChart veBieuDoThongKeMatHangTheoNam(CategoryDataset dataset) {
        JFreeChart chart =  ChartFactory.createBarChart(
                "Top mặt hàng bán chạy trong năm",
                "Mã hàng hóa",
                "Số lượng",
                dataset
        );
//        // Thay đổi kích thước chữ cho cột x (Mã hàng hóa)
//        CategoryPlot plot = chart.getCategoryPlot();
//        CategoryAxis domainAxis = plot.getDomainAxis();
//        domainAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 8)); // Đặt kích thước chữ
//        domainAxis.setLabelFont(new Font("SansSerif", Font.PLAIN, 10)); // Đặt kích thước chữ
//
//        // Thay đổi kích thước chữ cho cột y (Số lượng/Doanh thu)
//        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//        rangeAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 8)); // Đặt kích thước chữ
//        rangeAxis.setLabelFont(new Font("SansSerif", Font.PLAIN, 10)); // Đặt kích thước chữ
//        rangeAxis.setTickUnit(new NumberTickUnit(1)); // Đặt đơn vị tick
     // Lấy CategoryPlot từ biểu đồ
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        // Xác định góc nghiêng của nhãn trục x (CategoryAxis)
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        return chart;
    }
	public ArrayList<ModelThongKeMatHang> layDuLieuThongkeNgay(LocalDate ngayThongke) {
		ArrayList<ModelThongKeMatHang> data = new ArrayList<>();
		Dao_ThongKeMatHang dao = new Dao_ThongKeMatHang();
		data = dao.thongKeTop50MatHangTheoNgay(ngayThongke);
		Collections.sort(data, new Comparator<ModelThongKeMatHang>() {

			@Override
			public int compare(ModelThongKeMatHang o1, ModelThongKeMatHang o2) {
				if (o1.getSoLuongBan()< o2.getSoLuongBan())
					return 1;
				else {
					if (o1.getSoLuongBan() == o2.getSoLuongBan())
						return 0;
					else {
						return -1;
					}
				}
			}
		});
		int i = 1;
		for (ModelThongKeMatHang model : data) {
			model.setXepHang("Top " + i);
			i++;
		}
		i = 1;
		return data;
	}
	public ArrayList<ModelThongKeMatHang> layDuLieuThongkeThang(int thang, int namCuaThang) {
		ArrayList<ModelThongKeMatHang> data = new ArrayList<>();
		Dao_ThongKeMatHang dao = new Dao_ThongKeMatHang();
		data = dao.thongKeTop50MatHangTheoThang(thang, namCuaThang);
		Collections.sort(data, new Comparator<ModelThongKeMatHang>() {

			@Override
			public int compare(ModelThongKeMatHang o1, ModelThongKeMatHang o2) {
				if (o1.getSoLuongBan()< o2.getSoLuongBan())
					return 1;
				else {
					if (o1.getSoLuongBan() == o2.getSoLuongBan())
						return 0;
					else {
						return -1;
					}
				}
			}
		});
		int i = 1;
		for (ModelThongKeMatHang model : data) {
			model.setXepHang("Top " + i);
			i++;
		}
		i = 1;
		return data;
	}
	public ArrayList<ModelThongKeMatHang> layDuLieuThongkeNam(int nam) {
		ArrayList<ModelThongKeMatHang> data = new ArrayList<>();
		Dao_ThongKeMatHang dao = new Dao_ThongKeMatHang();
		data = dao.thongKeTop50MatHangTheoNam(nam);
		Collections.sort(data, new Comparator<ModelThongKeMatHang>() {

			@Override
			public int compare(ModelThongKeMatHang o1, ModelThongKeMatHang o2) {
				if (o1.getSoLuongBan()< o2.getSoLuongBan())
					return 1;
				else {
					if (o1.getSoLuongBan() == o2.getSoLuongBan())
						return 0;
					else {
						return -1;
					}
				}
			}
		});
		int i = 1;
		for (ModelThongKeMatHang model : data) {
			model.setXepHang("Top " + i);
			i++;
		}
		i = 1;
		return data;
	}
	public boolean taoFilleExcelNgay(LocalDate ngayThongKe) {
		try (Workbook workbook = new XSSFWorkbook()) {
			ThongKeMatHangServices services = new ThongKeMatHangServices();
			ArrayList<ModelThongKeMatHang> dataList = new ArrayList<>();
			dataList = services.layDuLieuThongkeNgay(ngayThongKe);
			Sheet sheet = workbook.createSheet("ThongKeMatHang");

            Row headerRow = sheet.createRow(0);
			headerRow.createCell(0).setCellValue("Xếp Hạng");
			headerRow.createCell(1).setCellValue("Thời Gian");
			headerRow.createCell(2).setCellValue("Mã Hàng Hóa");
			headerRow.createCell(3).setCellValue("Tên Hàng Hóa");
			headerRow.createCell(4).setCellValue("Số Lượng Bán ra trong tgian thống kê");
			headerRow.createCell(5).setCellValue("Doanh thu cho thời gian thống kê");
			headerRow.createCell(6).setCellValue("Số Lượng Tồn");
			headerRow.createCell(7).setCellValue("Tổng số Lượng Đã Bán");

            // Đổ dữ liệu từ danh sách vào các dòng
            int rowNum = 1;
            for (ModelThongKeMatHang model : dataList) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(model.getXepHang());
                row.createCell(1).setCellValue(model.getThoiGian());
                row.createCell(2).setCellValue(model.getMaHangHoa().trim());
                row.createCell(3).setCellValue(model.getTenHangHoa());
                row.createCell(4).setCellValue(model.getSoLuongBan());
                row.createCell(5).setCellValue(model.getDoanhThu());
                row.createCell(6).setCellValue(model.getSoLuongTon());
                row.createCell(7).setCellValue(model.getSoLuongDaBan());
            }

            // Tự động thay đổi chiều rộng cột
            for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
				sheet.autoSizeColumn(i);
			}

            // Ghi workbook vào file
            try (FileOutputStream fileOut = new FileOutputStream("DuLieuThongKe\\"+"ThongKeMatHangBanChayNgay"+ngayThongKe.toString()+".xlsx")) {
                workbook.write(fileOut);
                return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
	public boolean taoFilleExcelThang(int thang, int namCuaThang) {
		try (Workbook workbook = new XSSFWorkbook()) {
			ThongKeMatHangServices services = new ThongKeMatHangServices();
			ArrayList<ModelThongKeMatHang> dataList = new ArrayList<>();
			dataList = services.layDuLieuThongkeThang(thang, namCuaThang);
			Sheet sheet = workbook.createSheet("ThongKeMatHang");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Xếp Hạng");
			headerRow.createCell(1).setCellValue("Thời Gian");
			headerRow.createCell(2).setCellValue("Mã Hàng Hóa");
			headerRow.createCell(3).setCellValue("Tên Hàng Hóa");
			headerRow.createCell(4).setCellValue("Số Lượng Bán ra trong tgian thống kê");
			headerRow.createCell(5).setCellValue("Doanh thu cho thời gian thống kê");
			headerRow.createCell(6).setCellValue("Số Lượng Tồn");
			headerRow.createCell(7).setCellValue("Tổng số Lượng Đã Bán");

            // Đổ dữ liệu từ danh sách vào các dòng
            int rowNum = 1;
            for (ModelThongKeMatHang model : dataList) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(model.getXepHang());
                row.createCell(1).setCellValue(model.getThoiGian());
                row.createCell(2).setCellValue(model.getMaHangHoa().trim());
                row.createCell(3).setCellValue(model.getTenHangHoa());
                row.createCell(4).setCellValue(model.getSoLuongBan());
                row.createCell(5).setCellValue(model.getDoanhThu());
                row.createCell(6).setCellValue(model.getSoLuongTon());
                row.createCell(7).setCellValue(model.getSoLuongDaBan());
            }

            // Tự động thay đổi chiều rộng cột
            for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
				sheet.autoSizeColumn(i);
			}

            // Ghi workbook vào file
            try (FileOutputStream fileOut = new FileOutputStream("DuLieuThongKe\\"+"ThongKeMatHangBanChayThang"+thang+"-"+namCuaThang+".xlsx")) {
                workbook.write(fileOut);
                return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
	public boolean taoFilleExcelNam(int nam) {
		try (Workbook workbook = new XSSFWorkbook()) {
			ThongKeMatHangServices services = new ThongKeMatHangServices();
			ArrayList<ModelThongKeMatHang> dataList = new ArrayList<>();
			dataList = services.layDuLieuThongkeNam(nam);
			Sheet sheet = workbook.createSheet("ThongKeMatHang");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Xếp Hạng");
			headerRow.createCell(1).setCellValue("Thời Gian");
			headerRow.createCell(2).setCellValue("Mã Hàng Hóa");
			headerRow.createCell(3).setCellValue("Tên Hàng Hóa");
			headerRow.createCell(4).setCellValue("Số Lượng Bán ra trong tgian thống kê");
			headerRow.createCell(5).setCellValue("Doanh thu cho thời gian thống kê");
			headerRow.createCell(6).setCellValue("Số Lượng Tồn");
			headerRow.createCell(7).setCellValue("Tổng số Lượng Đã Bán");

            // Đổ dữ liệu từ danh sách vào các dòng
            int rowNum = 1;
            for (ModelThongKeMatHang model : dataList) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(model.getXepHang());
                row.createCell(1).setCellValue(model.getThoiGian());
                row.createCell(2).setCellValue(model.getMaHangHoa().trim());
                row.createCell(3).setCellValue(model.getTenHangHoa());
                row.createCell(4).setCellValue(model.getSoLuongBan());
                row.createCell(5).setCellValue(model.getDoanhThu());
                row.createCell(6).setCellValue(model.getSoLuongTon());
                row.createCell(7).setCellValue(model.getSoLuongDaBan());
            }

            // Tự động thay đổi chiều rộng cột
            for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
				sheet.autoSizeColumn(i);
			}

            // Ghi workbook vào file
            try (FileOutputStream fileOut = new FileOutputStream("DuLieuThongKe\\"+"ThongKeMatHangBanChayNam"+String.valueOf(nam)+".xlsx")) {
                workbook.write(fileOut);
                return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
