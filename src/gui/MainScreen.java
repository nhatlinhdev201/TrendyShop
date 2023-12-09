package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import gui.admin.TrangChinhNVQuanLy;
import gui.user.TrangChinhNVBanHang;

public class MainScreen {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					SplashScreen m = new SplashScreen();
					m.setIconImage(
							new ImageIcon(getClass().getResource("/images/logoShop.png")).getImage());
			         TrangDangNhap m1 = new TrangDangNhap();
//			         m.setVisible(true);
//			         m.iterate();
//			         m.setVisible(false);
//			         m1.setVisible(true);
			         
//					TrangChinhNVBanHang trangChinhNVBanHang = new TrangChinhNVBanHang();
//					TrangChinhNVQuanLy screenMainAdmin = new TrangChinhNVQuanLy();
//					trangChinhNVBanHang.setVisible(true);
//					trangChinhNVBanHang.setIconImage(
//							new ImageIcon(getClass().getResource("/images/logoShop.png")).getImage());
//					trangChinhNVBanHang.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});    
	}
}
