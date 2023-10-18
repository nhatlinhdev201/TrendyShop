package gui.user;

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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constance.SetBoundsJFrameMain;
import gui.TrangChuPanel;
import gui.TrangHuongDanJPanel;
import gui.TrangQLKhachHangPanel;

public class TrangChinhUser extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnMenuTrangChu;
	private JButton btnMenuCnBanHang;
	private JButton btnMenuCnQlyKhachHang;
	private JButton btnMenuCnQlyThongKe;
	private JButton btnMenuCnQlyTroGiup;
	private JButton btnSetUserLogin;
	private AbstractButton btnMenuCnXemThongTinTK;
	private JButton btnMenuCnDangXuatTK;
	private TrangChuPanel trangChuPanel;
	private TrangHuongDanJPanel trangHuongDanJPanel;
	private TrangQLKhachHangPanel trangQLKhachHangPanel;
	private TrangBanHangJPanel trangBanHangJPanel;
	private TrangThongKeUserJPanel trangThongKeUserJPanel;
	private Object currentContent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChinhUser frame = new TrangChinhUser();
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
	public TrangChinhUser() {
		setBackground(new Color(255, 204, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(SetBoundsJFrameMain.WINDOWX, SetBoundsJFrameMain.WINDOWY, SetBoundsJFrameMain.WINDOW_WIDTH,
				SetBoundsJFrameMain.WINDOW_HEIGHT);

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

		btnMenuTrangChu = new JButton("TRANG CHỦ");
		btnMenuTrangChu.setBackground(new Color(255, 250, 250));
		btnMenuTrangChu.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-home.png")).getImage()
				.getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		btnMenuTrangChu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMenuTrangChu.setBounds(10, 0, 148, 50);
		mainMenu.add(btnMenuTrangChu);

		btnMenuCnBanHang = new JButton("Bán Hàng");
		btnMenuCnBanHang.setBackground(new Color(255, 250, 250));
		btnMenuCnBanHang.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-money.png")).getImage()
						.getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		btnMenuCnBanHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMenuCnBanHang.setBounds(168, 0, 148, 50);
		mainMenu.add(btnMenuCnBanHang);

		btnMenuCnQlyKhachHang = new JButton("KHÁCH HÀNG");
		btnMenuCnQlyKhachHang.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyKhachHang.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-customer.png"))
				.getImage().getScaledInstance(32, 35, Image.SCALE_SMOOTH)));
		btnMenuCnQlyKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMenuCnQlyKhachHang.setBounds(326, 0, 164, 50);
		mainMenu.add(btnMenuCnQlyKhachHang);

		btnMenuCnQlyThongKe = new JButton("THỐNG KÊ");
		btnMenuCnQlyThongKe.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyThongKe.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-chart.png"))
				.getImage().getScaledInstance(35, 32, Image.SCALE_SMOOTH)));
		btnMenuCnQlyThongKe.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMenuCnQlyThongKe.setBounds(500, 0, 148, 50);
		mainMenu.add(btnMenuCnQlyThongKe);

		btnMenuCnQlyTroGiup = new JButton("HƯỚNG DẪN");
		btnMenuCnQlyTroGiup.setBackground(new Color(255, 250, 250));
		btnMenuCnQlyTroGiup.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-help.png"))
				.getImage().getScaledInstance(40, 32, Image.SCALE_SMOOTH)));
		btnMenuCnQlyTroGiup.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMenuCnQlyTroGiup.setBounds(658, 0, 156, 50);
		mainMenu.add(btnMenuCnQlyTroGiup);

		JLabel lblUsernameLogin = new JLabel("Nhật Linh");
		lblUsernameLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUsernameLogin.setBounds(1400, 6, 178, 28);
		mainMenu.add(lblUsernameLogin);

		btnMenuCnXemThongTinTK = new JButton("");
		btnMenuCnXemThongTinTK.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/avt-nv1.jpg"))
				.getImage().getScaledInstance(55, 50, Image.SCALE_SMOOTH)));
		btnMenuCnXemThongTinTK.setBounds(1578, 0, 57, 50);
		mainMenu.add(btnMenuCnXemThongTinTK);

		btnMenuCnDangXuatTK = new JButton("");
		btnMenuCnDangXuatTK.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-logout.png"))
				.getImage().getScaledInstance(55, 50, Image.SCALE_SMOOTH)));
		btnMenuCnDangXuatTK.setBounds(1645, 1, 57, 50);
		mainMenu.add(btnMenuCnDangXuatTK);
		// <========================================================================================>
		trangChuPanel = new TrangChuPanel();
		trangHuongDanJPanel = new TrangHuongDanJPanel();
		trangQLKhachHangPanel = new TrangQLKhachHangPanel();
		trangBanHangJPanel = new TrangBanHangJPanel();
		trangThongKeUserJPanel = new TrangThongKeUserJPanel();
		// <<=====================Add action listener============================>>
		btnMenuTrangChu.addActionListener(this);
		btnMenuCnQlyKhachHang.addActionListener(this);
		btnMenuCnQlyThongKe.addActionListener(this);
		btnMenuCnQlyTroGiup.addActionListener(this);
		btnMenuCnDangXuatTK.addActionListener(this);
		btnMenuCnXemThongTinTK.addActionListener(this);
		btnMenuCnBanHang.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
