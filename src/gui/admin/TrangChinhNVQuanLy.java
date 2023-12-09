package gui.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import constance.SetBountJPanel;
import daos.Dao_NhanVien;
import entities.NhanVien;
import gui.TrangChuPanel;
import gui.TrangDangNhap;
//import gui.TrangHuongDanJPanel;
import gui.TrangQLKhachHangPanel;
import gui.TrangThongTinDangNhap;

public class TrangChinhNVQuanLy extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnMenuTrangChu;
	private JButton btnMenuCnQlyHangHoa;
	private JButton btnMenuCnQlyNhanVien;
	private JButton btnMenuCnQlyKhachHang;
	private JButton btnMenuCnQlyThongKe;
	private JButton btnMenuCnQlyTroGiup;
	private JButton btnMenuCnQlyVoucher;
	private JPanel currentContent;
	
	private TrangChuPanel trangChuPanel;
//	private TrangHuongDanJPanel trangHuongDanJPanel ;
	private TrangQLKhachHangPanel trangQLKhachHangPanel;
	private TrangQLNhanVienJPanel trangQLNhanVienJPanel;
	private TrangQuanLyHangHoaJPanel trangQuanLyHangHoaJPanel;
	private TrangThongKeNVQuanLyJPanel trangThongKeNVQuanLyJPanel;
	private JButton btnMenuCnXemThongTinTK;
	private JButton btnMenuCnDangXuatTK;
	private TrangQuanLyVoucher trangQuanLyVoucher;
	private TrangThongKeNVQuanLy trangThongKeNVQuanLy;
	private Dao_NhanVien dao_NhanVien;
	
	public static NhanVien nv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChinhNVQuanLy frame = new TrangChinhNVQuanLy();
					frame.setVisible(true);
					frame.setIconImage(
							new ImageIcon(getClass().getResource("/images/logoShop.png")).getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TrangChinhNVQuanLy() {
		dao_NhanVien = new Dao_NhanVien();
//		nv = dao_NhanVien.getNhanVienTheoMa(nhanVien);
		
		setBackground(new Color(255, 204, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(SetBoundsJFrameMain.WINDOWX, SetBoundsJFrameMain.WINDOWY, SetBoundsJFrameMain.WINDOW_WIDTH, SetBoundsJFrameMain.WINDOW_HEIGHT);
		setTitle("Trendy Shop - Nhân viên quản lý");
		//<================ Set size main screen =========================>

		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//<========================================================================================>
		JPanel mainMenu = new JPanel();
		mainMenu.setBackground(new Color(245, 255, 250));
		mainMenu.setBounds(0, 0, 1350, 27);
		contentPane.add(mainMenu);
		mainMenu.setLayout(null);

		btnMenuTrangChu = new JButton("TRANG CHỦ");
		btnMenuTrangChu.setBackground(new Color(255, 250, 250));
		btnMenuTrangChu.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-home.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnMenuTrangChu.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMenuTrangChu.setBounds(10, 0, 124, 26);
		mainMenu.add(btnMenuTrangChu);

		btnMenuCnQlyHangHoa = new JButton("HÀNG HÓA");
		btnMenuCnQlyHangHoa.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyHangHoa.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-item2.png"))
				.getImage().getScaledInstance(18, 20, Image.SCALE_SMOOTH)));
		btnMenuCnQlyHangHoa.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMenuCnQlyHangHoa.setBounds(278, 0, 124, 26);
		mainMenu.add(btnMenuCnQlyHangHoa);

		btnMenuCnQlyNhanVien = new JButton("NHÂN VIÊN");
		btnMenuCnQlyNhanVien.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyNhanVien.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-employees.png"))
				.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH)));
		btnMenuCnQlyNhanVien.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMenuCnQlyNhanVien.setBounds(144, 0, 124, 26);
		mainMenu.add(btnMenuCnQlyNhanVien);

		btnMenuCnQlyVoucher = new JButton("Voucher");
		btnMenuCnQlyVoucher.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyVoucher.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-customer.png"))
				.getImage().getScaledInstance(19, 20, Image.SCALE_SMOOTH)));
		btnMenuCnQlyVoucher.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMenuCnQlyVoucher.setBounds(565, 0, 143, 26);
		mainMenu.add(btnMenuCnQlyVoucher);
		
		btnMenuCnQlyThongKe = new JButton("THỐNG KÊ");
		btnMenuCnQlyThongKe.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyThongKe.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-chart.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnMenuCnQlyThongKe.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMenuCnQlyThongKe.setBounds(732, 0, 111, 26);
		mainMenu.add(btnMenuCnQlyThongKe);

		btnMenuCnQlyTroGiup = new JButton("HƯỚNG DẪN");
		btnMenuCnQlyTroGiup.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyTroGiup.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-help.png"))
                .getImage().getScaledInstance(25, 20, Image.SCALE_SMOOTH)));
		btnMenuCnQlyTroGiup.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMenuCnQlyTroGiup.setBounds(853, 0, 133, 26);
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
		btnMenuCnXemThongTinTK.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/avt-nv1.jpg"))
                .getImage().getScaledInstance(25, 20, Image.SCALE_SMOOTH)));
		btnMenuCnXemThongTinTK.setBounds(1272, 0, 30, 26);
		mainMenu.add(btnMenuCnXemThongTinTK);
		
				btnMenuCnQlyKhachHang = new JButton("KHÁCH HÀNG");
				btnMenuCnQlyKhachHang.setBounds(412, 0, 143, 26);
				mainMenu.add(btnMenuCnQlyKhachHang);
				btnMenuCnQlyKhachHang.setBackground(new Color(255, 250, 250));
				btnMenuCnQlyKhachHang.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-customer.png"))
						.getImage().getScaledInstance(19, 20, Image.SCALE_SMOOTH)));
				btnMenuCnQlyKhachHang.setFont(new Font("Tahoma", Font.BOLD, 10));
				btnMenuCnQlyKhachHang.addActionListener(this);
		
		//<========================================================================================>
		
		trangChuPanel = new TrangChuPanel();
//		trangHuongDanJPanel = new TrangHuongDanJPanel();
		trangQLKhachHangPanel = new TrangQLKhachHangPanel();
		trangQLNhanVienJPanel = new TrangQLNhanVienJPanel();
		trangQuanLyHangHoaJPanel = new TrangQuanLyHangHoaJPanel();
		trangThongKeNVQuanLyJPanel = new TrangThongKeNVQuanLyJPanel();
		trangThongKeNVQuanLy = new TrangThongKeNVQuanLy();
		trangQuanLyVoucher = new TrangQuanLyVoucher();
		switchContent(trangChuPanel);
		
		//<<=====================Add action listener============================>>
		btnMenuTrangChu.addActionListener(this);
		btnMenuCnQlyNhanVien.addActionListener(this);
		btnMenuCnQlyHangHoa.addActionListener(this);
		btnMenuCnQlyThongKe.addActionListener(this);
		btnMenuCnQlyTroGiup.addActionListener(this);
		btnMenuCnXemThongTinTK.addActionListener(this);
		btnMenuCnDangXuatTK.addActionListener(this);
		btnMenuCnQlyVoucher.addActionListener(this);
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
		if(o.equals(btnMenuTrangChu)) {
			switchContent(new TrangChuPanel());
		} else if(o.equals(btnMenuCnQlyHangHoa)) {
			switchContent(trangQuanLyHangHoaJPanel);
		}else if(o.equals(btnMenuCnQlyKhachHang)) {
			switchContent(trangQLKhachHangPanel);
		}else if(o.equals(btnMenuCnQlyNhanVien)) {
			switchContent(trangQLNhanVienJPanel);
		}else if(o.equals(btnMenuCnQlyThongKe)) {
			switchContent(trangThongKeNVQuanLy);
		}else if (o.equals(btnMenuCnQlyVoucher)) {
			switchContent(trangQuanLyVoucher);
		}
		else if(o.equals(btnMenuCnQlyTroGiup)) {
//			switchContent(trangHuongDanJPanel);
		}else if(o.equals(btnMenuCnXemThongTinTK)) {
			new TrangThongTinDangNhap().setVisible(true);;
		}else if(o.equals(btnMenuCnDangXuatTK)) {
			this.setVisible(false);
			JOptionPane.showMessageDialog(this, "Đăng xuất thành công");
			new TrangDangNhap().setVisible(true);
		}else {
			System.out.println("Chua co chuc nang");
		}
	}
}