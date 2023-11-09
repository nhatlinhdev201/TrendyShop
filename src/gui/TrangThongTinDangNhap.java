package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class TrangThongTinDangNhap extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangThongTinDangNhap frame = new TrangThongTinDangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TrangThongTinDangNhap() {
		setSize(542, 344);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lbl_ThoiGianDangNhap = new JLabel("19/01/2023");
		lbl_ThoiGianDangNhap.setBounds(418, 54, 77, 14);
		contentPane.add(lbl_ThoiGianDangNhap);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(45, 90, 118, 148);
		contentPane.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("Mã nhân viên:");
		lblNewLabel_3.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(184, 90, 123, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lbl_MaNhanVien = new JLabel("NV001");
		lbl_MaNhanVien.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_MaNhanVien.setBounds(328, 90, 147, 14);
		contentPane.add(lbl_MaNhanVien);
		
		JLabel lblNewLabel_3_2 = new JLabel("Họ tên:");
		lblNewLabel_3_2.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_3_2.setBounds(184, 115, 123, 14);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lbl_HoTen = new JLabel("Đặng Thị Quyền Cơ");
		lbl_HoTen.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_HoTen.setBounds(328, 115, 147, 14);
		contentPane.add(lbl_HoTen);
		
		JLabel lblNewLabel_3_4 = new JLabel("CCCD:");
		lblNewLabel_3_4.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_3_4.setBounds(184, 140, 82, 14);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lbl_CCCD = new JLabel("080123456789");
		lbl_CCCD.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_CCCD.setBounds(328, 140, 147, 14);
		contentPane.add(lbl_CCCD);
		
		JLabel lblNewLabel_3_6 = new JLabel("Giới tính: ");
		lblNewLabel_3_6.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_3_6.setBounds(184, 165, 123, 14);
		contentPane.add(lblNewLabel_3_6);
		
		JLabel lbl_GioiTinh = new JLabel("Nữ");
		lbl_GioiTinh.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_GioiTinh.setBounds(328, 165, 147, 14);
		contentPane.add(lbl_GioiTinh);
		
		JLabel lblNewLabel_3_8 = new JLabel("Ngày sinh:");
		lblNewLabel_3_8.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_3_8.setBounds(184, 190, 123, 14);
		contentPane.add(lblNewLabel_3_8);
		
		JLabel lbl_NgaySinh = new JLabel("31/01/2002");
		lbl_NgaySinh.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_NgaySinh.setBounds(328, 190, 147, 14);
		contentPane.add(lbl_NgaySinh);
		
		JLabel lblNewLabel_3_10 = new JLabel("SĐT:");
		lblNewLabel_3_10.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_3_10.setBounds(184, 215, 112, 14);
		contentPane.add(lblNewLabel_3_10);
		
		JLabel lbl_SDT = new JLabel("0123456789");
		lbl_SDT.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_SDT.setBounds(328, 215, 147, 14);
		contentPane.add(lbl_SDT);
		
		JLabel lblNewLabel_3_12 = new JLabel("Chức vụ:");
		lblNewLabel_3_12.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_3_12.setBounds(184, 240, 112, 14);
		contentPane.add(lblNewLabel_3_12);
		
		JLabel lbl_ChucVu = new JLabel("Nhân viên bán hàng");
		lbl_ChucVu.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_ChucVu.setBounds(328, 240, 147, 14);
		contentPane.add(lbl_ChucVu);
	}
}
