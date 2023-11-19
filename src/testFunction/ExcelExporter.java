package testFunction;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constance.ModelExportFileThongKe;
import constance.ModelThongKeDoanhThu;
import services.ThongKeDoanhThuServices;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ExcelExporter {

	public static void exportToExcel(ArrayList<ModelExportFileThongKe> duLieuFileExcel, String filePath) {
		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("DuLieuThongKe");

			// Tạo Font cho tiêu đề in đậm
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);

			// Tạo CellStyle cho tiêu đề in đậm
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

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
			

			// Áp dụng CellStyle cho tiêu đề
			for (Cell cell : headerRow) {
				cell.setCellStyle(headerCellStyle);
			}
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		// Tạo một danh sách dữ liệu mẫu
		ArrayList<ModelExportFileThongKe> dataList = new ArrayList<>();
		dataList = services.layDuLieuFileThongKeNgay(LocalDate.now());
		// Thêm dữ liệu vào dataList

		// Xuất ra file Excel
		exportToExcel(dataList, "DuLieuThongKe.xlsx");
	}
}
