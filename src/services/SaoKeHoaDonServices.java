package services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entities.HoaDon;

public class SaoKeHoaDonServices {
	public boolean xuatFileSaoKe(ArrayList<HoaDon> dataThongKe, String filePath) {
		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("DanhSachHoaDon");

			// Tạo hàng tiêu đề
			Row headerRow = sheet.createRow(0);
			headerRow.createCell(0).setCellValue("Mã Hóa Đơn");
			headerRow.createCell(1).setCellValue("Thời Gian Tạo");
			headerRow.createCell(2).setCellValue("Khách Hàng");
			headerRow.createCell(3).setCellValue("Nhân Viên");
			headerRow.createCell(4).setCellValue("Voucher");
			headerRow.createCell(5).setCellValue("Tổng Thành Tiền");
			headerRow.createCell(6).setCellValue("Trạng Thái Thanh Toán");

			// Định dạng ngày
			CellStyle dateCellStyle = workbook.createCellStyle();
			CreationHelper createHelper = workbook.getCreationHelper();
			dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));

			// Đổ dữ liệu từ ArrayList vào tệp Excel
			for (int i = 0; i < dataThongKe.size(); i++) {
				HoaDon hoaDon = dataThongKe.get(i);
				Row row = sheet.createRow(i + 1);
				row.createCell(0).setCellValue(hoaDon.getMaHoaDon().trim());
				Cell dateCell = row.createCell(1);
				dateCell.setCellValue(hoaDon.getThoiGianTao());
				dateCell.setCellStyle(dateCellStyle);
				row.createCell(2).setCellValue(hoaDon.getKhachHang().getMaKhachHang().trim());
				row.createCell(3).setCellValue(hoaDon.getNguoiLapHoaDon().getMaNhanVien().trim());
				row.createCell(4).setCellValue(hoaDon.getVoucher().getMaVoucher().trim());
				row.createCell(5).setCellValue(ChuyenThanhTien(hoaDon.getTongThanhTien()));
				row.createCell(6).setCellValue(hoaDon.isTrangThaiThanhToan() ? "Đã thanh toán" : "Chưa thanh toán");
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
	public String ChuyenThanhTien(double money) {
		long roundedMoney = Math.round(money);
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String formattedMoney = decimalFormat.format(roundedMoney);
		return formattedMoney;
	}
}
