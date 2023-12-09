package gui.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constance.SetBoundsJFrameMain;
import daos.Dao_NhanVien;
import entities.NhanVien;
import gui.TrangChuPanel;
import gui.TrangDangNhap;
import gui.TrangHuongDanJPanel;
import gui.TrangQLKhachHangPanel;
import gui.TrangThongTinDangNhap;

public class TrangChinhNVBanHang extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnMenuTrangChu;
	private JButton btnMenuCnBanHang;
	private JButton btnMenuCnQlyKhachHang;
	private JButton btnMenuCnQlyThongKe;
	private JButton btnMenuCnQlyTroGiup;
	private AbstractButton btnMenuCnXemThongTinTK;
	private JButton btnMenuCnDangXuatTK;
	private TrangChuPanel trangChuPanel;
	private TrangHuongDanJPanel trangHuongDanJPanel;
	private TrangQLKhachHangPanel trangQLKhachHangPanel;
	private TrangBanHangJPanel trangBanHangJPanel;
	private TrangThongKeNVBanHangJPanel trangThongKeNVBanHangJPanel;
	private JPanel currentContent;

	private Dao_NhanVien dao_nhanVien;

	public static NhanVien nv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChinhNVBanHang frame = new TrangChinhNVBanHang();
					frame.setVisible(true);
					frame.setIconImage(new ImageIcon(getClass().getResource("/images/logoShop.png")).getImage());
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TrangChinhNVBanHang() {

		dao_nhanVien = new Dao_NhanVien();

//		nv = dao_nhanVien.getNhanVienTheoMa(nhanVien.trim());
//		nv = dao_nhanVien.getNhanVienTheoMa("NV0002");
		

		setBackground(new Color(255, 204, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(SetBoundsJFrameMain.WINDOWX, SetBoundsJFrameMain.WINDOWY, SetBoundsJFrameMain.WINDOW_WIDTH,
				SetBoundsJFrameMain.WINDOW_HEIGHT);
		setTitle("Trendy Shop - Nhân viên bán hàng");
		// <================ Set size main screen =========================>
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel mainMenu = new JPanel();
		mainMenu.setBackground(new Color(245, 255, 250));
		mainMenu.setBounds(0, 0, 1350, 27);
		contentPane.add(mainMenu);
		mainMenu.setLayout(null);

		btnMenuTrangChu = new JButton("TRANG CHỦ");
		btnMenuTrangChu.setBackground(new Color(255, 250, 250));
		btnMenuTrangChu.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-home.png")).getImage()
				.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnMenuTrangChu.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMenuTrangChu.setBounds(10, 0, 124, 26);
		mainMenu.add(btnMenuTrangChu);

		btnMenuCnBanHang = new JButton("BÁN HÀNG");
		btnMenuCnBanHang.setBackground(new Color(255, 250, 250));
		btnMenuCnBanHang.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-money.png"))
				.getImage().getScaledInstance(18, 20, Image.SCALE_SMOOTH)));
		btnMenuCnBanHang.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMenuCnBanHang.setBounds(144, 0, 124, 27);
		mainMenu.add(btnMenuCnBanHang);

		btnMenuCnQlyKhachHang = new JButton("KHÁCH HÀNG");
		btnMenuCnQlyKhachHang.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyKhachHang.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-customer.png"))
				.getImage().getScaledInstance(18, 20, Image.SCALE_SMOOTH)));
		btnMenuCnQlyKhachHang.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMenuCnQlyKhachHang.setBounds(278, 0, 138, 27);
		mainMenu.add(btnMenuCnQlyKhachHang);

		btnMenuCnQlyThongKe = new JButton("THỐNG KÊ");
		btnMenuCnQlyThongKe.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyThongKe.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-chart.png"))
				.getImage().getScaledInstance(20, 18, Image.SCALE_SMOOTH)));
		btnMenuCnQlyThongKe.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMenuCnQlyThongKe.setBounds(426, 0, 124, 27);
		mainMenu.add(btnMenuCnQlyThongKe);

		btnMenuCnQlyTroGiup = new JButton("HƯỚNG DẪN");
		btnMenuCnQlyTroGiup.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyTroGiup.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-help.png"))
				.getImage().getScaledInstance(22, 18, Image.SCALE_SMOOTH)));
		btnMenuCnQlyTroGiup.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMenuCnQlyTroGiup.setBounds(560, 0, 138, 26);
		mainMenu.add(btnMenuCnQlyTroGiup);

		JLabel lblUsernameLogin = new JLabel(nv.getHoTen());
		lblUsernameLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsernameLogin.setBounds(1113, 5, 158, 21);
		mainMenu.add(lblUsernameLogin);

		btnMenuCnDangXuatTK = new JButton("");
		btnMenuCnDangXuatTK.setBounds(1312, 0, 28, 26);
		btnMenuCnDangXuatTK.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-logout.png"))
				.getImage().getScaledInstance(25, 20, Image.SCALE_SMOOTH)));
		mainMenu.add(btnMenuCnDangXuatTK);

		btnMenuCnXemThongTinTK = new JButton("");
		btnMenuCnXemThongTinTK= createButtonWithIcon(nv.getAnhDaiDien(), 30, 30);
		btnMenuCnXemThongTinTK.setBounds(1272, 0, 30, 26);
		mainMenu.add(btnMenuCnXemThongTinTK);
		// <========================================================================================>

		trangChuPanel = new TrangChuPanel();
		trangHuongDanJPanel = new TrangHuongDanJPanel();
		trangQLKhachHangPanel = new TrangQLKhachHangPanel();
		trangBanHangJPanel = new TrangBanHangJPanel(null, null);
		trangThongKeNVBanHangJPanel = new TrangThongKeNVBanHangJPanel();

		switchContent(trangChuPanel);
		// <<=====================Add action listener============================>>
		btnMenuTrangChu.addActionListener(this);
		btnMenuCnQlyKhachHang.addActionListener(this);
		btnMenuCnQlyThongKe.addActionListener(this);
		btnMenuCnQlyTroGiup.addActionListener(this);
		btnMenuCnDangXuatTK.addActionListener(this);
		btnMenuCnXemThongTinTK.addActionListener(this);
		btnMenuCnBanHang.addActionListener(this);
	}


	private void switchContent(JPanel newContent) {
		newContent.setBounds(0, 28, 1350, 701);
		if (currentContent != null) {
			contentPane.remove(currentContent);
			currentContent.requestFocusInWindow();
		}
		currentContent = newContent;
		contentPane.add(currentContent, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnMenuTrangChu)) {
			switchContent(new TrangChuPanel());
		} else if (o.equals(btnMenuCnQlyKhachHang)) {
			switchContent(trangQLKhachHangPanel);
		} else if (o.equals(btnMenuCnQlyKhachHang)) {
			switchContent(trangQLKhachHangPanel);
		} else if (o.equals(btnMenuCnQlyTroGiup)) {
			switchContent(trangHuongDanJPanel);
		} else if (o.equals(btnMenuCnBanHang)) {
			switchContent(trangBanHangJPanel);
		} else if (o.equals(btnMenuCnQlyThongKe)) {
			switchContent(trangThongKeNVBanHangJPanel);
		} else if (o.equals(btnMenuCnXemThongTinTK)) {
			new TrangThongTinDangNhap(nv).setVisible(true);
		} else if (o.equals(btnMenuCnDangXuatTK)) {
			this.setVisible(false);
			JOptionPane.showMessageDialog(this, "Đăng xuất thành công");
			new TrangDangNhap().setVisible(true);
		} else {
			System.out.println("Chua co chuc nang");
		}
	}
	
//	Hàm thêm icon vào trong button
	public static JButton createButtonWithIcon(String iconPath, int width, int height) {
		ImageIcon originalIcon = new ImageIcon(iconPath);
		Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JButton button = new JButton(scaledIcon);

		return button;
	}
}
