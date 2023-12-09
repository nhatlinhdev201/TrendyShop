package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.ConnectDataBase;
import daos.Dao_NhanVien;
import entities.NhanVien;
import gui.admin.TrangChinhNVQuanLy;
import gui.user.TrangChinhNVBanHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TrangDangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txt_taiKhoan;
	private JPasswordField passwordField;
	public Connection connection;
	public static NhanVien taiKhoan;
	private String tenTaiKhoanAdmin = "ADMIN";
	private String matKhauAdmin = "ADMIN";
	private Dao_NhanVien dao_NV;
	public static boolean TrangThaiDangNhapNhanVien = false;
	public static boolean TrangThaiDangNhapQuanLy = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangDangNhap frame = new TrangDangNhap();
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
	public TrangDangNhap() {
		dao_NV = new Dao_NhanVien();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon icon = new ImageIcon(TrangDangNhap.class.getResource("/images/logoShop.png"));
		Image img = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(img);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(newIcon);
		lblNewLabel.setBounds(10, 61, 300, 300); // Điều chỉnh kích thước JLabel
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(310, 0, 305, 415);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("L O G I N");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel_1.setBounds(39, 102, 239, 60);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(19, 185, 270, 34);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Tài khoản :");
		lblNewLabel_2.setBackground(new Color(255, 182, 193));
		lblNewLabel_2.setBounds(0, 0, 83, 32);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));

		txt_taiKhoan = new JTextField();
		txt_taiKhoan.setForeground(new Color(0, 0, 0));
		txt_taiKhoan.setBounds(81, 0, 152, 32);
		txt_taiKhoan.setBorder(null);
		panel_1.add(txt_taiKhoan);
		txt_taiKhoan.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TrangDangNhap.class.getResource("/images/profilep.png")));
		lblNewLabel_3.setBounds(234, 0, 36, 32);
		panel_1.add(lblNewLabel_3);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setBounds(19, 238, 270, 34);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("Mật khẩu :");
		lblNewLabel_2_1.setBounds(5, 0, 71, 32);
		panel_1_1.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(TrangDangNhap.class.getResource("/images/key.png")));
		lblNewLabel_3_1.setBounds(231, 0, 39, 32);
		panel_1_1.add(lblNewLabel_3_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(77, 0, 155, 32);
		passwordField.setBorder(null);
		panel_1_1.add(passwordField);

		JButton btn_dangNhap = new JButton("Đăng nhập");
		btn_dangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tentaiKhoan = txt_taiKhoan.getText();
				String matKhau = new String(passwordField.getPassword());
				taiKhoan = dao_NV.getNhanVienTheoMa(tentaiKhoan);
				if(taiKhoan.getMaNhanVien()==null) taiKhoan=null;
				if (tentaiKhoan.trim().equals("") && matKhau.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Tài khoản mật khẩu không được để trống !", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("images/warning.png"));
				} else {
					try {
						kiemTraDangNhap(tentaiKhoan, matKhau);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		btn_dangNhap.setBackground(new Color(124, 252, 0));
		btn_dangNhap.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_dangNhap.setBounds(81, 294, 161, 39);
		setLocationRelativeTo(null);
		panel.add(btn_dangNhap);
		;

	}

	public boolean kiemTraDangNhap(String tenDangNhap, String matKhau) {
		if (taiKhoan != null && taiKhoan.getMatKhau().equals(matKhau)) {
			if (!taiKhoan.isPhanQuyen()) {
				TrangChinhNVBanHang.nv = taiKhoan;
				TrangChinhNVBanHang trangChinhNVBanHang = new TrangChinhNVBanHang();
				this.dispose();
				trangChinhNVBanHang.setVisible(true);
				return true;
			} else  {
				this.dispose();
				TrangChinhNVQuanLy.nv = taiKhoan;
				TrangChinhNVQuanLy trangChinhNVQuanLy2 = new TrangChinhNVQuanLy();
				trangChinhNVQuanLy2.setVisible(true);

				return true;
			}
		} else {
			
			JOptionPane.showMessageDialog(null, "Tài khoản mật khẩu không đúng !", "Thông báo",
					JOptionPane.ERROR_MESSAGE, new ImageIcon("images/warning.png"));
		}
		return false;
	}

	public boolean KiemTraDuLieu() {
		String tenUser = txt_taiKhoan.getText();
		// ten dang nhap phai la chu hoac so va khong co ki tu dac biet co toi da tu
		// 5-20 ki tu
		boolean match = tenUser.matches("[a-zA-z0-9 ]{3,20}");
		if (match != true) {
			JOptionPane.showMessageDialog(this, "Tài Khoản Không Hợp lệ");
			return false;
		} else
			return true;
	}
}
