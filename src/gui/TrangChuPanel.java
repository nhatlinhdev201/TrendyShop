package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import constance.SetBountJPanel;
import gui.admin.TrangQLNhanVienJPanel;
import gui.admin.TrangQuanLyHangHoaJPanel;
import gui.admin.TrangThongKeNVQuanLy;
import gui.user.TrangBanHangJPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;

public class TrangChuPanel extends JPanel implements ActionListener{

	private JButton btn_ThongKe;
	private JButton btn_QuanLyBanHang;
	private JButton btn_QuanLyKhachHang;
	private JButton btn_QuanLyNhanVien;
	private JButton btn_QuanLyHangHoa;
	

	private TrangQLKhachHangPanel trangQLKhachHangPanel;
	private TrangBanHangJPanel trangBanHangJPanel;
	private JPanel currentContent;
	

	/**
	 * Create the panel.
	 */
	public TrangChuPanel() {
		setBackground(new Color(255, 255, 255));
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		btn_ThongKe = new JButton("Thống kê");
		btn_ThongKe.setBackground(new Color(253, 172, 62));
		btn_ThongKe.setFont(new Font("Monospaced", Font.BOLD, 18));
		btn_ThongKe.setBounds(1055, 120, 267, 124);
		
		add(btn_ThongKe);
		
		btn_QuanLyBanHang = new JButton("Quản lý bán hàng");
		btn_QuanLyBanHang.setBackground(new Color(244, 128, 128));
		btn_QuanLyBanHang.setFont(new Font("Monospaced", Font.BOLD, 18));
		btn_QuanLyBanHang.setBounds(736, 120, 267, 124);
		add(btn_QuanLyBanHang);
		
		btn_QuanLyKhachHang = new JButton("Quản lý khách hàng");
		btn_QuanLyKhachHang.setFont(new Font("Monospaced", Font.BOLD, 18));
		btn_QuanLyKhachHang.setBackground(new Color(234, 138, 179));
		btn_QuanLyKhachHang.setBounds(736, 316, 267, 124);
		add(btn_QuanLyKhachHang);
		
		btn_QuanLyNhanVien = new JButton("Quản lý nhân viên");
		btn_QuanLyNhanVien.setFont(new Font("Monospaced", Font.BOLD, 18));
		btn_QuanLyNhanVien.setBackground(new Color(150, 207, 254));
		btn_QuanLyNhanVien.setBounds(1055, 316, 267, 124);
		add(btn_QuanLyNhanVien);
		
		btn_QuanLyHangHoa = new JButton("Quản lý hàng hóa");
		btn_QuanLyHangHoa.setFont(new Font("Monospaced", Font.BOLD, 18));
		btn_QuanLyHangHoa.setBackground(new Color(209, 235, 171));
		btn_QuanLyHangHoa.setBounds(908, 508, 305, 124);
		add(btn_QuanLyHangHoa);
		
		JLabel lblNewLabel = new JLabel("TRENDY SHOP");
		lblNewLabel.setForeground(new Color(244, 141, 138));
		lblNewLabel.setFont(new Font("Goudy Old Style", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(206, 45, 294, 57);
		add(lblNewLabel);
		
		JPanel panel_logo = new JPanel();
		panel_logo.setBackground(new Color(255, 255, 255));
		panel_logo.setBounds(66, 0, 130, 130);
		add(panel_logo);
		
		ImageIcon originalIcon = new ImageIcon("images\\logoShop.png");

        // Lấy kích thước ban đầu của ảnh
        int originalWidth = originalIcon.getIconWidth();
        int originalHeight = originalIcon.getIconHeight();

        // Tính toán kích thước mới (ví dụ: giảm kích thước xuống còn 100x100 pixel)
        int newWidth = 130;
        int newHeight = 130;

        // Thay đổi kích thước của ảnh
        Image scaledImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Tạo một ImageIcon mới từ ảnh đã thay đổi kích thước
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Tạo JLabel để hiển thị hình ảnh
        JLabel label = new JLabel(scaledIcon);
        panel_logo.add(label, BorderLayout.CENTER);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 206, 706, 436);
		add(panel);
		ImageIcon originalIcon1 = new ImageIcon("img\\anhTrangChu.jpg");
		JLabel lbl2 = new JLabel(originalIcon1);
		panel.add(lbl2,BorderLayout.CENTER);
		
		btn_QuanLyBanHang.addActionListener(this);
		btn_QuanLyHangHoa.addActionListener(this);
		btn_QuanLyKhachHang.addActionListener(this);
		btn_QuanLyNhanVien.addActionListener(this);
		btn_ThongKe.addActionListener(this);
	}

	public void switchContent(JPanel newContent) {
//		newContent.setBounds(0, 28, 1350, 701);
		this.removeAll();
		if (currentContent != null) {
			this.remove(currentContent);
			currentContent.requestFocusInWindow();
		}
		currentContent = newContent;

		this.add(currentContent, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btn_QuanLyBanHang)) {
			switchContent(new TrangBanHangJPanel(null,null));
		}else if(o.equals(btn_QuanLyHangHoa)) {
			switchContent(new TrangQuanLyHangHoaJPanel());
		}else if(o.equals(btn_QuanLyKhachHang)) {
			switchContent(new TrangQLKhachHangPanel());
		}else if(o.equals(btn_QuanLyNhanVien)) {
			switchContent(new TrangQLNhanVienJPanel());
		}else if(o.equals(btn_ThongKe)) {
			switchContent(new TrangThongKeNVQuanLy());
		}
	}
	
}
