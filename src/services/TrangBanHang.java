package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entities.KhachHang;
import gui.user.TrangBanHangJPanel;
import gui.user.TrangThongTinKhachHang;

public class TrangBanHang {
	private KhachHang kh = new KhachHang("KH001","0123456789", "Đặng Thị Quyền Cơ", "dangthiquyenco@gmail.com",
			"12 Nguyễn Văn Bảo, phường 4, Gò Vấp");

	public void timKhachHangTheoSDT(String sdt, JLabel lbl_TenKhachHang, TrangBanHangJPanel trangBanHangJPanel) {
		if (sdt.trim().equals(kh.getSoDienThoai())) {
			lbl_TenKhachHang.setText(kh.getTenKhachHang());
		} else
			JOptionPane.showMessageDialog(trangBanHangJPanel, "Không tồn tại khách hàng có số điện thoại: " + sdt);
	}
	
	public void xuatHoaDonRaiFile(String tongTienTra , TrangBanHangJPanel trangBanHangJPanel) {
		int choice = JOptionPane.showConfirmDialog(null,
				"Xác nhận thanh toán: " + tongTienTra + " VNĐ", "Xác nhận",
				JOptionPane.YES_NO_OPTION);

		if (choice == JOptionPane.YES_OPTION) {
//			Xuất hóa đơn
//        	code xuất hóa đơn
			try {
				// Tạo một đối tượng FileWriter để ghi vào tệp tin

				// sau sẽ thay bằng mã hóa đơn
				LocalDateTime ngayHT = LocalDateTime.now();
				String hoaDon = "HD" + ngayHT.getDayOfMonth() + ngayHT.getMonthValue() + ngayHT.getYear()
						+ ngayHT.getHour() + ngayHT.getSecond();
				FileWriter writer = new FileWriter("hoaDon\\" + hoaDon + ".txt");
				BufferedWriter bufferedWriter = new BufferedWriter(writer);

				// Ghi nội dung hóa đơn vào tệp tin
				bufferedWriter.write("------------------------------------------------------");
				bufferedWriter.newLine();
				bufferedWriter.write("|                      HÓA ĐƠN                       |");
				bufferedWriter.newLine();
				bufferedWriter.write("------------------------------------------------------");
				bufferedWriter.newLine();
				bufferedWriter.write("Người cung cấp dịch vụ: ABC Company");
				bufferedWriter.newLine();
				// ... (Ghi các thông tin khác tương tự)

				// Đóng BufferedWriter
				bufferedWriter.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			JOptionPane.showMessageDialog(trangBanHangJPanel, "Xác nhận đã xuất hóa đơn!");
			trangBanHangJPanel.switchContent(new TrangBanHangJPanel());
		}
	}
}
