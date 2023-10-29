package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;

import gui.admin.TrangChinhNVQuanLy;

public class MainScreen {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
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
