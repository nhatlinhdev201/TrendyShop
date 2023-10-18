package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;

import gui.admin.TrangChinhNhanVienQuanLy;

public class MainScreen {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					TrangChinhNhanVienQuanLy screenMainAdmin = new TrangChinhNhanVienQuanLy();
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
