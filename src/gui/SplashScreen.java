package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.user.TrangHangCho;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

//IMPORT JProgressBar
import javax.swing.JProgressBar;

import javax.swing.SwingConstants;
import java.awt.Panel;

public class SplashScreen extends javax.swing.JFrame {

// Tạo JProgressBar\
	JProgressBar jb;
	int i = 0, num = 0;

	private JPanel contentPane;

	/**
	 * Creates new form NewJFrame
	 */
	public SplashScreen() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 396);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(213, 153, 223));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_logo = new JPanel();
		panel_logo.setBackground(new Color(255, 255, 255));
		panel_logo.setBounds(0, 0, 635, 241);
		getContentPane().add(panel_logo);

		ImageIcon originalIcon = new ImageIcon(SplashScreen.class.getResource("/images/AnhSplashscreen.jpg"));

		// Lấy kích thước ban đầu của ảnh
		int originalWidth = originalIcon.getIconWidth();
		int originalHeight = originalIcon.getIconHeight();

		// Tính toán kích thước mới (ví dụ: giảm kích thước xuống còn 100x100 pixel)
		int newWidth = 635;
		int newHeight = 237;

		// Thay đổi kích thước của ảnh
		Image scaledImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

		// Tạo một ImageIcon mới từ ảnh đã thay đổi kích thước
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// Tạo JLabel để hiển thị hình ảnh
		JLabel label = new JLabel(scaledIcon);
		panel_logo.add(label, BorderLayout.CENTER);

		Panel panel = new Panel();
		panel.setBounds(0, 635, 635, 70);
		contentPane.add(panel);

		// Tạo JProgressBar
		jb = new JProgressBar(0, 2000);
		jb.setBounds(47, 296, 519, 30);
		jb.setValue(0);
		// TĂT HOẶC MỞ HIỂN THỊ % Ở ĐÂY
//        jb.setStringPainted(true);
		jb.setForeground(new Color(124, 252, 0));// ĐỔI MÀU Ở ĐÂY
		getContentPane().add(jb);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		pack();
	}// </editor-fold>

	/**
	 * @param args the command line arguments
	 */

	// THỜI GIAN LOADING
	public void iterate() {
		while (i <= 2000) {
			jb.setValue(i);
			i = i + 20;
			try {
				Thread.sleep(30);
			} catch (Exception e) {
			}
		}
	}

	public static void main(String args[]) {
		SplashScreen m = new SplashScreen();
		TrangDangNhap m1 = new TrangDangNhap();
		m.setIconImage(new ImageIcon("img\\logoShop.png").getImage());
		m.setVisible(true);
		m.iterate();
		m.setVisible(false);
		m1.setIconImage(new ImageIcon("img\\logoShop.png").getImage());
		m1.setVisible(true);

	}

	// Variables declaration - do not modify
	// End of variables declaration
}
