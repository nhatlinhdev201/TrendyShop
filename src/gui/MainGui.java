package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MainGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui frame = new MainGui();
					frame.setVisible(true);
					frame.setIconImage(
							new ImageIcon("D:\\\\PTUD\\\\TrendyShop\\\\src\\\\image\\\\logoShop.png").getImage());
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
	public MainGui() {
		setBackground(new Color(255, 204, 153));
		int screenWidth = 1920; // Độ phân giải ngang của màn hình (pixels)
		int screenHeight = 1080; // Độ phân giải dọc của màn hình (pixels)

		int windowWidth = (int) (screenWidth * 0.9); // Ví dụ, 60% chiều ngang của màn hình
		int windowHeight = (int) (screenHeight * 0.9); // Ví dụ, 60% chiều dọc của màn hình

		int windowX = (screenWidth - windowWidth) / 2; // Để đặt cửa sổ ở giữa màn hình theo chiều ngang
		int windowY = (screenHeight - windowHeight) / 2; // Để đặt cửa sổ ở giữa màn hình theo chiều dọc

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(windowX, windowY, 1728, 972);

//<================ Set size main screen =========================>

		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel mainMenu = new JPanel();
		mainMenu.setBackground(new Color(245, 255, 250));
		mainMenu.setBounds(0, 0, 1712, 50);
		contentPane.add(mainMenu);
		mainMenu.setLayout(null);

		JButton btnMenuTrangChu = new JButton("TRANG CHỦ");
		btnMenuTrangChu.setBackground(new Color(255, 250, 250));
		btnMenuTrangChu.setIcon(new ImageIcon(new ImageIcon("D:\\PTUD\\TrendyShop\\src\\image\\icon-home.png")
				.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		btnMenuTrangChu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMenuTrangChu.setBounds(10, 0, 148, 50);
		mainMenu.add(btnMenuTrangChu);

		JButton btnMenuCnQlyHangHoa = new JButton("HÀNG HÓA");
		btnMenuCnQlyHangHoa.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyHangHoa.setIcon(new ImageIcon(new ImageIcon("D:\\PTUD\\TrendyShop\\src\\image\\icon-item2.png")
				.getImage().getScaledInstance(32, 40, Image.SCALE_SMOOTH)));
		btnMenuCnQlyHangHoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMenuCnQlyHangHoa.setBounds(326, 0, 148, 50);
		mainMenu.add(btnMenuCnQlyHangHoa);

		JButton btnMenuCnQlyNhanVien = new JButton("NHÂN VIÊN");
		btnMenuCnQlyNhanVien.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyNhanVien.setIcon(new ImageIcon(new ImageIcon("D:\\PTUD\\TrendyShop\\src\\image\\icon-employees.png")
				.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btnMenuCnQlyNhanVien.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMenuCnQlyNhanVien.setBounds(168, 0, 148, 50);
		mainMenu.add(btnMenuCnQlyNhanVien);

		JButton btnMenuCnQlyKhachHang = new JButton("KHÁCH HÀNG");
		btnMenuCnQlyKhachHang.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyKhachHang.setIcon(new ImageIcon(new ImageIcon("D:\\PTUD\\TrendyShop\\src\\image\\icon-customer.png")
				.getImage().getScaledInstance(32, 35, Image.SCALE_SMOOTH)));
		btnMenuCnQlyKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMenuCnQlyKhachHang.setBounds(487, 0, 164, 50);
		mainMenu.add(btnMenuCnQlyKhachHang);

		JButton btnMenuCnQlyThongKe = new JButton("THỐNG KÊ");
		btnMenuCnQlyThongKe.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyThongKe.setIcon(new ImageIcon(new ImageIcon("D:\\PTUD\\TrendyShop\\src\\image\\icon-chart.png")
				.getImage().getScaledInstance(35, 32, Image.SCALE_SMOOTH)));
		btnMenuCnQlyThongKe.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMenuCnQlyThongKe.setBounds(661, 0, 148, 50);
		mainMenu.add(btnMenuCnQlyThongKe);

		JButton btnMenuCnQlyTroGiup = new JButton("HƯỚNG DẪN");
		btnMenuCnQlyTroGiup.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyTroGiup.setIcon(new ImageIcon(new ImageIcon("D:\\PTUD\\TrendyShop\\src\\image\\icon-help.png")
				.getImage().getScaledInstance(40, 32, Image.SCALE_SMOOTH)));
		btnMenuCnQlyTroGiup.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMenuCnQlyTroGiup.setBounds(821, 0, 156, 50);
		mainMenu.add(btnMenuCnQlyTroGiup);

		JLabel lblUsernameLogin = new JLabel("Nhật Linh");
		lblUsernameLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUsernameLogin.setBounds(1334, 11, 187, 28);
		mainMenu.add(lblUsernameLogin);
		// <================ circle avatar ===============================>
		/*
		 * JPanel circlePanel = new JPanel() {
		 * 
		 * @Override protected void paintComponent(Graphics g) {
		 * super.paintComponent(g); int diameter = Math.min(getWidth(), getHeight());
		 * g.setColor(Color.WHITE); g.fillOval(0, 0, diameter, diameter); } };
		 * circlePanel.setLayout(null); JLabel imageAvatarLabel = new JLabel(new
		 * ImageIcon("D:\\\\PTUD\\\\TrendyShop\\\\src\\\\image\\\\icon-help.png"));
		 * imageAvatarLabel.setEnabled(false); imageAvatarLabel.setBounds(1400, 8, 40,
		 * 40); circlePanel.add(imageAvatarLabel);
		 */
		//mainMenu.add(circlePanel);
		// Chưa hiển thị được
		// --------------------------------------------------------------
		
		
		JLabel imgUserLogin = new JLabel("");
		imgUserLogin.setIcon(new ImageIcon(new ImageIcon("D:\\PTUD\\TrendyShop\\src\\image\\avt-nv1.jpg")
				.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		imgUserLogin.setBounds(1531, 0, 50, 50);
		mainMenu.add(imgUserLogin);
		
		JButton btnSetUserLogin = new JButton("Tùy chỉnh");
		btnSetUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSetUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSetUserLogin.setBounds(1591, 5, 111, 39);
		mainMenu.add(btnSetUserLogin);

		JPanel mainFunction = new JPanel();
		mainFunction.setBackground(new Color(255, 255, 240));
		mainFunction.setBounds(0, 52, 1712, 881);
		contentPane.add(mainFunction);
	}
}
