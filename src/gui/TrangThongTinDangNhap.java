package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import entities.NhanVien;
import gui.admin.TrangChinhNVQuanLy;
import gui.user.TrangChinhNVBanHang;

import java.awt.BorderLayout;
import java.awt.Color;

public class TrangThongTinDangNhap extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public TrangThongTinDangNhap(NhanVien nv) {
//		NhanVien nv = TrangChinhNVBanHang.nv;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		setSize(542, 306);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin nhân viên đăng nhập");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 506, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thời gian đăng nhâp:");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(262, 54, 140, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbl_ThoiGianDangNhap = new JLabel(dateFormat.format(new Date()));
		lbl_ThoiGianDangNhap.setBounds(418, 54, 77, 14);
		contentPane.add(lbl_ThoiGianDangNhap);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(35, 90, 120, 150);
		contentPane.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("Mã nhân viên:");
		lblNewLabel_3.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(184, 90, 123, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lbl_MaNhanVien = new JLabel(nv.getMaNhanVien());
		lbl_MaNhanVien.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_MaNhanVien.setBounds(328, 90, 167, 14);
		contentPane.add(lbl_MaNhanVien);
		
		JLabel lblNewLabel_3_2 = new JLabel("Họ tên:");
		lblNewLabel_3_2.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_3_2.setBounds(184, 115, 123, 14);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lbl_HoTen = new JLabel(nv.getHoTen());
		lbl_HoTen.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_HoTen.setBounds(328, 115, 167, 14);
		contentPane.add(lbl_HoTen);
		
		JLabel lblNewLabel_3_4 = new JLabel("CCCD:");
		lblNewLabel_3_4.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_3_4.setBounds(184, 140, 82, 14);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lbl_CCCD = new JLabel(nv.getSoCCCD());
		lbl_CCCD.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_CCCD.setBounds(328, 140, 167, 14);
		contentPane.add(lbl_CCCD);
		
		
		
		JLabel lblNewLabel_3_8 = new JLabel("Ngày sinh:");
		lblNewLabel_3_8.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_3_8.setBounds(184, 165, 123, 14);
		contentPane.add(lblNewLabel_3_8);
		
		JLabel lbl_NgaySinh = new JLabel(dateFormat.format(nv.getNgaySinh()));
		lbl_NgaySinh.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_NgaySinh.setBounds(328, 165, 167, 14);
		contentPane.add(lbl_NgaySinh);
		
		JLabel lblNewLabel_3_10 = new JLabel("SĐT:");
		lblNewLabel_3_10.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_3_10.setBounds(184, 190, 112, 14);
		contentPane.add(lblNewLabel_3_10);
		
		JLabel lbl_SDT = new JLabel(nv.getSoDienThoai());
		lbl_SDT.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_SDT.setBounds(328, 190, 167, 14);
		contentPane.add(lbl_SDT);
		
		JLabel lblNewLabel_3_12 = new JLabel("Chức vụ:");
		lblNewLabel_3_12.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_3_12.setBounds(184, 215, 112, 14);
		contentPane.add(lblNewLabel_3_12);
		
		String chucVu ="";
		if(nv.getChucVu().equals("QL")) {
			chucVu = "Nhân viên quản lý";
		}else chucVu  ="Nhân viên bán hàng";
		JLabel lbl_ChucVu = new JLabel(chucVu);
		lbl_ChucVu.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_ChucVu.setBounds(328, 215, 167, 14);
		contentPane.add(lbl_ChucVu);
		
		// Đọc hình ảnh từ file hoặc URL
//		ImageIcon originalIcon = new ImageIcon(listChiTietHoaDon.get(i).getHangHoa().getHinhAnh());
		ImageIcon originalIcon = new ImageIcon(nv.getAnhDaiDien());

		// Lấy kích thước ban đầu của ảnh
		int originalWidth = originalIcon.getIconWidth();
		int originalHeight = originalIcon.getIconHeight();

		// Tính toán kích thước mới (ví dụ: giảm kích thước xuống còn 100x100 pixel)
		int newWidth = 120;
		int newHeight = 150;

		// Thay đổi kích thước của ảnh
		Image scaledImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

		// Tạo một ImageIcon mới từ ảnh đã thay đổi kích thước
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		panel.setLayout(new BorderLayout(0, 0));

		// Tạo JLabel để hiển thị hình ảnh
		JLabel label = new JLabel(scaledIcon);

		// Thêm JLabel vào panel
		panel.add(label);
	}
}
