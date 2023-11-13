package services;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

		ArrayList<DuLieuBieuDoThongKeDoanhThu> data = dao_ThongKeDoanhThu
				.duLieuBieuDo_Top5NgayDoanhThuCaoNhatTrongThang(10, 2022, nhanVien.getMaNhanVien().trim());
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

		tongHdDuocLap = dao_ThongKeDoanhThu.TongHoaDonDuocNhanVienLapTrongThang(model.getThangThongKe(),
				model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongMhBanRa = dao_ThongKeDoanhThu.TongSoLuongMatHangNhanVienBanRaTrongThang(model.getThangThongKe(),
				model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongThangCuaNhanVien(model.getThangThongKe(),
				model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongThangNhanVienBan(model.getThangThongKe(),
				model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongTienHangDaBan = tongTienNhapHang + tongTienNhapHang * 0.7f;
		tongTienKhuyenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongThangTheoNhanVien(model.getThangThongKe(),
				model.getNamCuaThangThongKe(), model.getMaNhanVien());
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
		for (int i = 1; i < 13; i++) {
			ModelThongKeDoanhThuThang doanhThuThang = new ModelThongKeDoanhThuThang();
			doanhThuThang.setThangThongKe(i);
			doanhThuThang.setNamCuaThangThongKe(nam);
			doanhThuThang.setMaNhanVien(taiKhoan.getMaNhanVien());
			callDataThongKeThang(doanhThuThang);
			duLieuThongKe.add(doanhThuThang);
		}
		return duLieuThongKe;
	}

	// <===============Xuất file excel=================>
	public static double lamTron(float value) {
		double scaleFactor = Math.pow(10, 1);
		return Math.ceil(value * scaleFactor) / scaleFactor;
	}

	public void dinhDangFileExcelThongKeNgayTheoNV(ModelThongKeDoanhThuNgay data, String filePath) {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("DoanhThuNgay");

		// Tạo header
		Row headerRow = sheet.createRow(0);
		String[] columns = { "Thời gian", "Tổng HĐ Được Lập", "Tổng MH Bán Ra", "Tổng Doanh Thu", "Tổng Tiền Nhập Hàng",
				"Tổng Tiền Hàng Đã Bán", "Tổng Tiền Khuyến Mãi", "Tổng Thuế", "Tổng Lãi", "Mã Nhân Viên" };
		CellStyle boldStyle = workbook.createCellStyle();
		Font boldFont = workbook.createFont();
		boldFont.setBold(true);
		boldStyle.setFont(boldFont);
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(boldStyle);

			// Đặt độ rộng cột tự động dựa trên nội dung
			sheet.autoSizeColumn(i);
		}

		// Đổ dữ liệu từ danh sách vào sheet
		int rowNum = 1;
		Row row = sheet.createRow(rowNum++);
		row.createCell(0).setCellValue(data.getDate().toString());
		row.createCell(1).setCellValue(data.getTongHdDuocLap());
		row.createCell(2).setCellValue(data.getTongMhBanRa());
		row.createCell(3).setCellValue(lamTron(data.getTongDoanhThu()));
		row.createCell(4).setCellValue(lamTron(data.getTongTienNhapHang()));
		row.createCell(5).setCellValue(lamTron(data.getTongTienHangDaBan()));
		row.createCell(6).setCellValue(lamTron(data.getTongTienKhuyenMai()));
		row.createCell(7).setCellValue(lamTron(data.getTongThue()));
		row.createCell(8).setCellValue(lamTron(data.getTongLai()));
		row.createCell(9).setCellValue(data.getMaNhanVien());
		sheet.autoSizeColumn(rowNum);

		// Lưu workbook vào file
		try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
			workbook.write(fileOut);
			System.out.println("Xuất dữ liệu thành công!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean xuatDuLieuThongKeDoanhThuNgayTheoNvExcel(ModelThongKeDoanhThuNgay data) {
		JFileChooser fileChooser = new JFileChooser();
		// Thiết lập bộ lọc để chỉ hiển thị các tệp Excel
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xls", "xlsx");
		fileChooser.setFileFilter(filter);
		// Hiển thị hộp thoại chọn tệp và kiểm tra xem người dùng đã chọn hay chưa
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			// Người dùng đã chọn một đường dẫn, tiếp tục với việc lưu file Excel
			File selectedFile = fileChooser.getSelectedFile();
			String filePath = selectedFile.getAbsolutePath();
			// Xuất dữ liệu ra file Excel
			dinhDangFileExcelThongKeNgayTheoNV(data, filePath + ".xlsx");
			System.out.println("File selected: " + filePath + ".xlsx");
			return true;
		} else {
			// Người dùng đã hủy bỏ chọn đường dẫn
			System.out.println("Export canceled.");
			return false;
		}
	}

	public void dinhDangFileExcelThongKeThangTheoNV(ArrayList<ModelThongKeDoanhThuNgay> dataList, String filePath) {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("DoanhThuNgay");

		// Tạo header
		Row headerRow = sheet.createRow(0);
		String[] columns = { "Thời gian", "Tổng HĐ Được Lập", "Tổng MH Bán Ra", "Tổng Doanh Thu", "Tổng Tiền Nhập Hàng",
				"Tổng Tiền Hàng Đã Bán", "Tổng Tiền Khuyến Mãi", "Tổng Thuế", "Tổng Lãi", "Mã Nhân Viên" };
		CellStyle boldStyle = workbook.createCellStyle();
		Font boldFont = workbook.createFont();
		boldFont.setBold(true);
		boldStyle.setFont(boldFont);
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(boldStyle);

			// Đặt độ rộng cột tự động dựa trên nội dung
			sheet.autoSizeColumn(i);
		}

		// Đổ dữ liệu từ danh sách vào sheet
		int rowNum = 1;
		for (ModelThongKeDoanhThuNgay data : dataList) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(data.getDate().toString());
			row.createCell(1).setCellValue(data.getTongHdDuocLap());
			row.createCell(2).setCellValue(data.getTongMhBanRa());
			row.createCell(3).setCellValue(lamTron(data.getTongDoanhThu()));
			row.createCell(4).setCellValue(lamTron(data.getTongTienNhapHang()));
			row.createCell(5).setCellValue(lamTron(data.getTongTienHangDaBan()));
			row.createCell(6).setCellValue(lamTron(data.getTongTienKhuyenMai()));
			row.createCell(7).setCellValue(lamTron(data.getTongThue()));
			row.createCell(8).setCellValue(lamTron(data.getTongLai()));
			row.createCell(9).setCellValue(data.getMaNhanVien());
			sheet.autoSizeColumn(rowNum);
		}

		// Lưu workbook vào file
		try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
			workbook.write(fileOut);
			System.out.println("Xuất dữ liệu thành công!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean xuatDuLieuThongKeDoanhThuThangTheoNvExcel(ArrayList<ModelThongKeDoanhThuNgay> data) {
		JFileChooser fileChooser = new JFileChooser();
		// Thiết lập bộ lọc để chỉ hiển thị các tệp Excel
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xls", "xlsx");
		fileChooser.setFileFilter(filter);
		// Hiển thị hộp thoại chọn tệp và kiểm tra xem người dùng đã chọn hay chưa
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			// Người dùng đã chọn một đường dẫn, tiếp tục với việc lưu file Excel
			File selectedFile = fileChooser.getSelectedFile();
			String filePath = selectedFile.getAbsolutePath();
			// Xuất dữ liệu ra file Excel
			dinhDangFileExcelThongKeThangTheoNV(data, filePath + ".xlsx");
			System.out.println("File selected: " + filePath + ".xlsx");
			return true;
		} else {
			// Người dùng đã hủy bỏ chọn đường dẫn
			System.out.println("Export canceled.");
			return false;
		}
	}

	public void dinhDangFileExcelThongKeNamTheoNV(ArrayList<ModelThongKeDoanhThuThang> dataList, String filePath) {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("DoanhThuNgay");

		// Tạo header
		Row headerRow = sheet.createRow(0);
		String[] columns = { "Thời gian", "Tổng HĐ Được Lập", "Tổng MH Bán Ra", "Tổng Doanh Thu", "Tổng Tiền Nhập Hàng",
				"Tổng Tiền Hàng Đã Bán", "Tổng Tiền Khuyến Mãi", "Tổng Thuế", "Tổng Lãi", "Mã Nhân Viên" };
		CellStyle boldStyle = workbook.createCellStyle();
		Font boldFont = workbook.createFont();
		boldFont.setBold(true);
		boldStyle.setFont(boldFont);
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(boldStyle);

			// Đặt độ rộng cột tự động dựa trên nội dung
			sheet.autoSizeColumn(i);
		}

		// Đổ dữ liệu từ danh sách vào sheet
		int rowNum = 1;
		for (ModelThongKeDoanhThuThang data : dataList) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(data.getThangThongKe() + "/" + data.getNamCuaThangThongKe());
			row.createCell(1).setCellValue(data.getTongHdDuocLap());
			row.createCell(2).setCellValue(data.getTongMhBanRa());
			row.createCell(3).setCellValue(lamTron(data.getTongDoanhThu()));
			row.createCell(4).setCellValue(lamTron(data.getTongTienNhapHang()));
			row.createCell(5).setCellValue(lamTron(data.getTongTienHangDaBan()));
			row.createCell(6).setCellValue(lamTron(data.getTongTienKhuyenMai()));
			row.createCell(7).setCellValue(lamTron(data.getTongThue()));
			row.createCell(8).setCellValue(lamTron(data.getTongLai()));
			row.createCell(9).setCellValue(data.getMaNhanVien());
			sheet.autoSizeColumn(rowNum);
		}

		// Lưu workbook vào file
		try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
			workbook.write(fileOut);
			System.out.println("Xuất dữ liệu thành công!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean xuatDuLieuThongKeDoanhThuNamTheoNvExcel(ArrayList<ModelThongKeDoanhThuThang> data) {
		JFileChooser fileChooser = new JFileChooser();
		// Thiết lập bộ lọc để chỉ hiển thị các tệp Excel
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xls", "xlsx");
		fileChooser.setFileFilter(filter);
		// Hiển thị hộp thoại chọn tệp và kiểm tra xem người dùng đã chọn hay chưa
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			// Người dùng đã chọn một đường dẫn, tiếp tục với việc lưu file Excel
			File selectedFile = fileChooser.getSelectedFile();
			String filePath = selectedFile.getAbsolutePath();
			// Xuất dữ liệu ra file Excel
			dinhDangFileExcelThongKeNamTheoNV(data, filePath + ".xlsx");
			System.out.println("File selected: " + filePath + ".xlsx");
			return true;
		} else {
			// Người dùng đã hủy bỏ chọn đường dẫn
			System.out.println("Export canceled.");
			return false;
		}
	}
	// <=============================>
}
