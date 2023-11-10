package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.ConnectDataBase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
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
				String taiKhoan = txt_taiKhoan.getText();
		        String matKhau = new String(passwordField.getPassword());
//		        if()
			}
		});
		btn_dangNhap.setBackground(new Color(124, 252, 0));
		btn_dangNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_dangNhap.setBounds(96, 294, 119, 39);
		
		panel.add(btn_dangNhap);;
	}
	public static void kiemTraDangNhap(String taiKhoan, String matKhau) {
        boolean dangNhapThanhCong = false;
        
        
        

        if (dangNhapThanhCong) {
            // Nếu đăng nhập thành công, kiểm tra loại tài khoản và thực hiện các hành động tương ứng
            if (taiKhoan.contains("QL")) {
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công! Chuyển đến trang quản lý.");
                // Thực hiện các hành động cho trang quản lý
                // Ví dụ: Mở JFrame trang quản lý
                // MainFormQuanLy mainFormQuanLy = new MainFormQuanLy();
                // mainFormQuanLy.setVisible(true);
            } else if (taiKhoan.contains("NV")) {
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công! Chuyển đến trang nhân viên.");
                // Thực hiện các hành động cho trang nhân viên
                // Ví dụ: Mở JFrame trang nhân viên
                // MainFormNhanVien mainFormNhanVien = new MainFormNhanVien();
                // mainFormNhanVien.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Loại tài khoản không hợp lệ!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Đăng nhập không thành công. Vui lòng kiểm tra tài khoản và mật khẩu.");
        }
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
	public void loadTaiKhoanQL(String maNhanVien, String matKhau) {
	    try {
	        connection = ConnectDataBase.getInstance().connection;
	        PreparedStatement stmt = null;
	        String sql = "SELECT * FROM dbo.NhanVien WHERE maNhanVien=? AND matKhau=?";

	        stmt = connection.prepareStatement(sql);
	        stmt.setString(1, maNhanVien);
	        stmt.setString(2, matKhau);
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            String ten = rs.getString("ten").trim(); // Thay đổi chỉ số cột nếu cần thiết
	            String mk = rs.getString("matKhau").trim();
	            String loaiTk = rs.getString("phanQuyen").trim();
//	            taiKhoan = new TaiKhoan(ten, mk, loaiTk);
	        }
	    } catch (Exception e) {
	        // Xử lý ngoại lệ (exception handling) nên được thực hiện cụ thể hơn để có thể hiểu và xử lý lỗi một cách chính xác.
	        e.printStackTrace();
	    }
	}
}
