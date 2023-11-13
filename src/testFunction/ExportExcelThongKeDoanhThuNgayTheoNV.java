package testFunction;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import entities.NhanVien;
import modelsThongKe.ModelThongKeDoanhThuNgay;
import services.ThongKeDoanhThuServices;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ExportExcelThongKeDoanhThuNgayTheoNV {
	
	private ArrayList<ModelThongKeDoanhThuNgay> dataList;
	

    public ExportExcelThongKeDoanhThuNgayTheoNV(ArrayList<ModelThongKeDoanhThuNgay> dataList) {
		this.setDataList(dataList);
		export(dataList);
	}
	public static void fomatExportToExcel(ArrayList<ModelThongKeDoanhThuNgay> dataList, String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("DoanhThuNgay");

        // Tạo header
        Row headerRow = sheet.createRow(0);
        String[] columns = { "Thời gian","Tổng HĐ Được Lập", "Tổng MH Bán Ra", "Tổng Doanh Thu", "Tổng Tiền Nhập Hàng",
                "Tổng Tiền Hàng Đã Bán", "Tổng Tiền Khuyến Mãi", "Tổng Thuế", "Tổng Lãi", "Mã Nhân Viên"};
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
    public static double lamTron(float value) {
        double scaleFactor = Math.pow(10, 1);
        return Math.ceil(value * scaleFactor) / scaleFactor;
    }
    public static void export(ArrayList<ModelThongKeDoanhThuNgay> data) {
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
            fomatExportToExcel(data, filePath+".xlsx");
            System.out.println("File selected: " + filePath);
        } else {
            // Người dùng đã hủy bỏ chọn đường dẫn
            System.out.println("Export canceled.");
        }
    }

    public static void main(String[] args) {
        // Giả sử bạn có một danh sách dữ liệu
    	// Gọi phương thức xuất Excel với đường dẫn đã chọn
        ThongKeDoanhThuServices doanhThuServices = new ThongKeDoanhThuServices();
    	NhanVien nv = new NhanVien("NV0002", "Phạm Nhật Linh", null, null, null, null, null, null, true,
				null, false, null);
        ArrayList<ModelThongKeDoanhThuNgay> dataList = doanhThuServices.thongKeCacNgayTrongThang(10, 2023, nv);
    	export(dataList);
    }
	public ArrayList<ModelThongKeDoanhThuNgay> getDataList() {
		return dataList;
	}
	public void setDataList(ArrayList<ModelThongKeDoanhThuNgay> dataList) {
		this.dataList = dataList;
	}
}
