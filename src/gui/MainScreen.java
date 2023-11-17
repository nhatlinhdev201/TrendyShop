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
					TrangChinhNVBanHang trangChinhNVBanHang = new TrangChinhNVBanHang();
					TrangChinhNVQuanLy screenMainAdmin = new TrangChinhNVQuanLy();
					screenMainAdmin.setVisible(true);
					screenMainAdmin.setIconImage(
							new ImageIcon(getClass().getResource("/images/logoShop.png")).getImage());
					screenMainAdmin.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});    
	}
}
