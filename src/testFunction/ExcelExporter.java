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

    public static void exportToExcel(ArrayList<ModelExportFileThongKe> dataList, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DuLieuThongKe");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Thời Gian");

            // Tạo các cột nhân viên
            ArrayList<String> nhanVienList = new ArrayList<>();
            for (ModelExportFileThongKe duLieuThongKe : dataList) {
                for (ModelThongKeDoanhThu duLieuNhanVien : duLieuThongKe.getDataNhanVien()) {
                    String tenNhanVien = duLieuNhanVien.getTenNhanVien();
                    if (!nhanVienList.contains(tenNhanVien)) {
                        nhanVienList.add(tenNhanVien);
                        headerRow.createCell(nhanVienList.indexOf(tenNhanVien) + 1).setCellValue(tenNhanVien);
                    }
                }
            }

            // Ghi dữ liệu
            int rowNum = 1;
            for (ModelExportFileThongKe duLieuThongKe : dataList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(duLieuThongKe.getThoiGian());

                for (ModelThongKeDoanhThu duLieuNhanVien : duLieuThongKe.getDataNhanVien()) {
                    int columnIndex = nhanVienList.indexOf(duLieuNhanVien.getTenNhanVien()) + 1;
                    row.createCell(columnIndex).setCellValue(duLieuNhanVien.getTongDoanhThu());
                }
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
