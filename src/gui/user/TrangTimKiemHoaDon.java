package gui.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import constance.SetBountJPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class TrangTimKiemHoaDon extends JPanel implements ActionListener{
	private JTextField txt_MaHoaDon;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel currentContent;
	private JButton btn_LapHoaDon;
	private TrangBanHangJPanel trangBanHang;
	private JButton btn_Tim;
	private JPanel panel_2;

	/**
	 * Create the panel.
	 */
	public TrangTimKiemHoaDon() {
		/*Thiết lập jpanel cho trang bán hàng*/
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		/*Tạo 2 button menu cho trang Quản lý bán hàng*/
		JPanel menu = new JPanel();
		menu.setBounds(0, 0, 1370, 43);
		add(menu);
		menu.setLayout(null);
		/*Button lập hóa đơn*/
		btn_LapHoaDon = new JButton("Lập hóa đơn");
		btn_LapHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		btn_LapHoaDon.setBackground(new Color(255, 255, 255));
		btn_LapHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_LapHoaDon.setBounds(0, 0, 187, 43);
		menu.add(btn_LapHoaDon);
		
//		Button tìm kiếm hóa đơn
		JButton btn_TimHoaDon = new JButton("Tìm kiếm hóa đơn");
		btn_TimHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_TimHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		btn_TimHoaDon.setBackground(new Color(39, 224, 224));
		btn_TimHoaDon.setBounds(184, 0, 229, 43);
		menu.add(btn_TimHoaDon);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(158, 226, 173));
		panel.setBounds(0, 40, 1350, 661);
		add(panel);
		panel.setLayout(null);
		
		JLabel lbl_title = new JLabel("Tìm kiếm hóa đơn");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Monospaced", Font.BOLD, 28));
		lbl_title.setBounds(10, 0, 1330, 45);
		panel.add(lbl_title);
		
//		mã hóa đơn
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 57, 220, 45);
		panel.add(panel_1);
		panel_1.setBorder(BorderFactory.createTitledBorder("Mã hóa đơn"));
		panel_1.setLayout(null);
		
		txt_MaHoaDon = new JTextField();
		txt_MaHoaDon.setForeground(new Color(0, 0, 0));
		txt_MaHoaDon.setBounds(10, 14, 200, 25);
		panel_1.add(txt_MaHoaDon);
		txt_MaHoaDon.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(BorderFactory.createTitledBorder("SĐT khách hàng"));
		panel_1_1.setBounds(255, 57, 220, 45);
		panel.add(panel_1_1);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBounds(10, 14, 200, 25);
		panel_1_1.add(textField);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(BorderFactory.createTitledBorder("Mã nhân viên"));
		panel_1_2.setBounds(493, 57, 220, 45);
		panel.add(panel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 14, 200, 25);
		panel_1_2.add(textField_1);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBorder(BorderFactory.createTitledBorder("Từ ngày"));
		panel_1_3.setBounds(735, 57, 220, 45);
		panel.add(panel_1_3);
		
		JDateChooser dateChooser_TuNgay = new JDateChooser();
		dateChooser_TuNgay.setDateFormatString("dd/MM/yyyy");
		dateChooser_TuNgay.setBounds(10, 14, 200, 25);
		panel_1_3.add(dateChooser_TuNgay);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBorder(BorderFactory.createTitledBorder("Đến ngày"));
		panel_1_4.setBounds(976, 56, 220, 45);
		panel.add(panel_1_4);
		
		JDateChooser dateChooser_DenNgay = new JDateChooser();
		dateChooser_DenNgay.setDateFormatString("dd/MM/yyyy");
		dateChooser_DenNgay.setBounds(10, 14, 200, 25);
		panel_1_4.add(dateChooser_DenNgay);
		
		btn_Tim = new JButton("Tìm");
		btn_Tim.setBackground(new Color(131, 198, 252));
		btn_Tim.setBounds(1231, 58, 98, 38);
		panel.add(btn_Tim);
		
//		Panel hiển thị thông tin chi tiết của hóa đơn cần tìm
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(30, 122, 1287, 528);
		panel.add(panel_2);
		DanhSachHoaDon();
		
//		panel_2.setLayout(null);
		
		
		
		
		
		
		
		
//		
//		trangBanHang = new TrangBanHangJPanel();
		
//		
		btn_LapHoaDon.addActionListener(this);
		btn_Tim.addActionListener(this);
		
		
		
		
	}

	
	private void switchContent(JPanel newContent) {
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
		if(o.equals(btn_LapHoaDon)) {
			switchContent(new TrangBanHangJPanel());
		}if(o.equals(btn_Tim)) {
			DanhSachHoaDon();
		}
	}	
	
	
	
	public void DanhSachHoaDon() {
    	JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        p.setBackground(new Color(255, 255, 255));
        panel_2.add(p);
        GridBagConstraints c = new GridBagConstraints();

        

        for (int j = 0; j < 3; j++) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            GridBagConstraints c2 = new GridBagConstraints();
            panel.setBorder(new LineBorder(new Color(0, 0, 0)));
            panel.setBackground(new Color(255, 255, 255));
            
//          c.fill = GridBagConstraints.BOTH;
          c.fill = GridBagConstraints.NONE;
          c.ipadx = 5;
          c.weightx = 1.0;
          c.weighty = 1.0;
          c.insets = new Insets(10, 5, 0, 0);
          c.gridx = 0;
          c.gridy = j;
          p.add(panel, c);
            
            
            
            JPanel panel_3 = new JPanel();
    		panel_3.setBackground(new Color(255, 255, 255));
    		panel_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128)));
    		panel_3.setBounds(29, 11, 1224, 130);
//    		panel.add(panel_3);
    		panel_3.setLayout(null);
    		
    		JLabel lblNewLabel = new JLabel("Mã hóa đơn:");
    		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
    		lblNewLabel.setBounds(10, 11, 175, 27);
    		panel_3.add(lblNewLabel);
    		
    		JLabel lbl_MaHoaDon = new JLabel("");
    		lbl_MaHoaDon.setFont(new Font("Monospaced", Font.BOLD, 17));
    		lbl_MaHoaDon.setBounds(178, 11, 190, 27);
    		panel_3.add(lbl_MaHoaDon);
    		
    		JLabel lblNewLabel_3 = new JLabel("Nhân viên:");
    		lblNewLabel_3.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lblNewLabel_3.setBounds(10, 49, 118, 20);
    		panel_3.add(lblNewLabel_3);
    		
    		JLabel lbl_NhanVien = new JLabel("");
    		lbl_NhanVien.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lbl_NhanVien.setBounds(150, 49, 133, 20);
    		panel_3.add(lbl_NhanVien);
    		
    		JLabel lblNewLabel_5 = new JLabel("Thuế:");
    		lblNewLabel_5.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lblNewLabel_5.setBounds(10, 80, 118, 20);
    		panel_3.add(lblNewLabel_5);
    		
    		JLabel lbl_Thue = new JLabel("");
    		lbl_Thue.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lbl_Thue.setBounds(150, 80, 133, 20);
    		panel_3.add(lbl_Thue);
    		
    		JLabel lblNewLabel_7 = new JLabel("Khách hàng:");
    		lblNewLabel_7.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lblNewLabel_7.setBounds(322, 49, 133, 20);
    		panel_3.add(lblNewLabel_7);
    		
    		JLabel lblNewLabel_8 = new JLabel("Mã giảm giá:");
    		lblNewLabel_8.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lblNewLabel_8.setBounds(322, 80, 133, 20);
    		panel_3.add(lblNewLabel_8);
    		
    		JLabel lblNewLabel_9 = new JLabel("Số điện thoại:");
    		lblNewLabel_9.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lblNewLabel_9.setBounds(619, 49, 133, 20);
    		panel_3.add(lblNewLabel_9);
    		
    		JLabel lbl_KhachHang = new JLabel("");
    		lbl_KhachHang.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lbl_KhachHang.setBounds(440, 49, 133, 20);
    		panel_3.add(lbl_KhachHang);
    		
    		JLabel lbl_MaGiamGia = new JLabel("");
    		lbl_MaGiamGia.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lbl_MaGiamGia.setBounds(440, 80, 133, 20);
    		panel_3.add(lbl_MaGiamGia);
    		
    		JLabel lbl_SDT = new JLabel("");
    		lbl_SDT.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lbl_SDT.setBounds(750, 49, 133, 20);
    		panel_3.add(lbl_SDT);
    		
    		JLabel lblLblngaylap = new JLabel("Ngày lập:");
    		lblLblngaylap.setHorizontalAlignment(SwingConstants.RIGHT);
    		lblLblngaylap.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lblLblngaylap.setBounds(991, 10, 100, 20);
    		panel_3.add(lblLblngaylap);
    		
    		JLabel lbl_NgayLap = new JLabel("2000");
    		lbl_NgayLap.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lbl_NgayLap.setBounds(1112, 10, 109, 20);
    		panel_3.add(lbl_NgayLap);
    		
    		c2.fill = GridBagConstraints.NONE;
            c2.anchor = GridBagConstraints.WEST;
            c2.ipadx = 1220;
            c2.ipady = 138;
            c2.insets = new Insets(5, 5, 0, 0);  // Các khoảng trống
            c2.gridwidth = 1;
            c2.gridx = 0;
            c2.gridy = 0;
            panel.add(panel_3, c2);
            
           


            for (int i = 0; i < 5; i++) {
                JPanel panel_4 = new JPanel();
                panel_4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
                panel_4.setBackground(new Color(255, 255, 255));
                panel_4.setSize(1224, 138);
                panel_4.setLayout(null);

                JPanel panel_5 = new JPanel();
                panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
                panel_5.setBounds(10, 11, 98, 117);
             // Đọc hình ảnh từ file hoặc URL
                ImageIcon originalIcon = new ImageIcon("img\\plus.png");

                // Lấy kích thước ban đầu của ảnh
                int originalWidth = originalIcon.getIconWidth();
                int originalHeight = originalIcon.getIconHeight();

                // Tính toán kích thước mới (ví dụ: giảm kích thước xuống còn 100x100 pixel)
                int newWidth = 100;
                int newHeight = 100;

                // Thay đổi kích thước của ảnh
                Image scaledImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

                // Tạo một ImageIcon mới từ ảnh đã thay đổi kích thước
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                // Tạo JLabel để hiển thị hình ảnh
                JLabel label = new JLabel(scaledIcon);

                // Thêm JLabel vào panel
                panel_5.add(label, BorderLayout.CENTER);
                
                panel_4.add(panel_5);

                JLabel lblNewLabel_2 = new JLabel("Tên sản phẩm");
                lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 17));
                lblNewLabel_2.setBounds(128, 0, 271, 30);
                panel_4.add(lblNewLabel_2);

                JLabel lblNewLabel_4 = new JLabel("Mã hàng:");
                lblNewLabel_4.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lblNewLabel_4.setBounds(138, 30, 100, 20);
                panel_4.add(lblNewLabel_4);

                JLabel lblNewLabel_4_1 = new JLabel("Kích thước:");
                lblNewLabel_4_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lblNewLabel_4_1.setBounds(138, 61, 100, 20);
                panel_4.add(lblNewLabel_4_1);

                JLabel lblNewLabel_4_2 = new JLabel("Xuất xứ:");
                lblNewLabel_4_2.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lblNewLabel_4_2.setBounds(138, 95, 100, 20);
                panel_4.add(lblNewLabel_4_2);

                JLabel lbl_MaHang = new JLabel("");
                lbl_MaHang.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lbl_MaHang.setBounds(248, 30, 116, 20);
                panel_4.add(lbl_MaHang);

                JLabel lbl_KichThuoc = new JLabel("");
                lbl_KichThuoc.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lbl_KichThuoc.setBounds(248, 61, 116, 20);
                panel_4.add(lbl_KichThuoc);

                JLabel lbl_XuatXu = new JLabel("");
                lbl_XuatXu.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lbl_XuatXu.setBounds(248, 95, 116, 20);
                panel_4.add(lbl_XuatXu);

                JLabel lblNewLabel_4_3 = new JLabel("Màu sắc:");
                lblNewLabel_4_3.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lblNewLabel_4_3.setBounds(448, 65, 100, 20);
                panel_4.add(lblNewLabel_4_3);

                JLabel lblNewLabel_4_4 = new JLabel("Nhà cung cấp:");
                lblNewLabel_4_4.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lblNewLabel_4_4.setBounds(448, 95, 110, 20);
                panel_4.add(lblNewLabel_4_4);

                JLabel lbl_NhaCungCap = new JLabel("");
                lbl_NhaCungCap.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lbl_NhaCungCap.setBounds(568, 95, 183, 20);
                panel_4.add(lbl_NhaCungCap);

                JLabel lblNewLabel_4_6 = new JLabel("Giá bán:");
                lblNewLabel_4_6.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lblNewLabel_4_6.setBounds(776, 95, 100, 20);
                panel_4.add(lblNewLabel_4_6);

                JLabel lblNewLabel_4_7 = new JLabel("Chất liệu:");
                lblNewLabel_4_7.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lblNewLabel_4_7.setBounds(776, 65, 100, 20);
                panel_4.add(lblNewLabel_4_7);

                JLabel lblNewLabel_4_8 = new JLabel("");
                lblNewLabel_4_8.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lblNewLabel_4_8.setBounds(872, 61, 139, 20);
                panel_4.add(lblNewLabel_4_8);

                JLabel lblNewLabel_4_9 = new JLabel("");
                lblNewLabel_4_9.setHorizontalAlignment(SwingConstants.RIGHT);
                lblNewLabel_4_9.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lblNewLabel_4_9.setBounds(872, 95, 139, 20);
                panel_4.add(lblNewLabel_4_9);

                JLabel lblNewLabel_4_10 = new JLabel("VNĐ");
                lblNewLabel_4_10.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lblNewLabel_4_10.setBounds(1026, 95, 56, 20);
                panel_4.add(lblNewLabel_4_10);

                JLabel lbl_MauSac = new JLabel("");
                lbl_MauSac.setFont(new Font("Monospaced", Font.PLAIN, 13));
                lbl_MauSac.setBounds(568, 65, 183, 20);
                panel_4.add(lbl_MauSac);

                c2.fill = GridBagConstraints.NONE;
                c2.anchor = GridBagConstraints.WEST;
                c2.ipadx = 1220;
                c2.ipady = 138;
                c2.insets = new Insets(5, 5, 0, 0);  // Các khoảng trống
                c2.gridwidth = 1;
                c2.gridx = 0;
                c2.gridy = i+1;
                panel.add(panel_4, c2);
            }
            
            
            JPanel panel_6 = new JPanel();
    		panel_6.setBounds(29, 301, 1224, 130);
    		panel_6.setBackground(new Color(255, 255, 255));
//    		panel_2.add(panel_6);
    		panel_6.setLayout(null);
    		
    		JLabel lblNewLabel_4_5 = new JLabel("Tổng tiền hàng:");
    		lblNewLabel_4_5.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lblNewLabel_4_5.setBounds(28, 11, 205, 20);
    		panel_6.add(lblNewLabel_4_5);
    		
    		JLabel lbl_TongTienHang = new JLabel("");
    		lbl_TongTienHang.setHorizontalAlignment(SwingConstants.RIGHT);
    		lbl_TongTienHang.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lbl_TongTienHang.setBounds(266, 11, 129, 20);
    		panel_6.add(lbl_TongTienHang);
    		
    		JLabel lblNewLabel_4_10_1 = new JLabel("VNĐ");
    		lblNewLabel_4_10_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lblNewLabel_4_10_1.setBounds(402, 11, 56, 20);
    		panel_6.add(lblNewLabel_4_10_1);
    		
    		JLabel lblNewLabel_4_12 = new JLabel("Tổng tiền thuế:");
    		lblNewLabel_4_12.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lblNewLabel_4_12.setBounds(28, 36, 205, 20);
    		panel_6.add(lblNewLabel_4_12);
    		
    		JLabel lbl_TongTienThue = new JLabel("");
    		lbl_TongTienThue.setHorizontalAlignment(SwingConstants.RIGHT);
    		lbl_TongTienThue.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lbl_TongTienThue.setBounds(266, 36, 129, 20);
    		panel_6.add(lbl_TongTienThue);
    		
    		JLabel lblNewLabel_4_10_2 = new JLabel("VNĐ");
    		lblNewLabel_4_10_2.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lblNewLabel_4_10_2.setBounds(402, 36, 56, 20);
    		panel_6.add(lblNewLabel_4_10_2);
    		
    		JLabel lblNewLabel_4_12_1 = new JLabel("Tổng tiền giảm giá:");
    		lblNewLabel_4_12_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lblNewLabel_4_12_1.setBounds(28, 60, 205, 20);
    		panel_6.add(lblNewLabel_4_12_1);
    		
    		JLabel lbl_TongTienGiamGia = new JLabel("");
    		lbl_TongTienGiamGia.setHorizontalAlignment(SwingConstants.RIGHT);
    		lbl_TongTienGiamGia.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lbl_TongTienGiamGia.setBounds(266, 60, 129, 20);
    		panel_6.add(lbl_TongTienGiamGia);
    		
    		JLabel lblNewLabel_4_10_2_1 = new JLabel("VNĐ");
    		lblNewLabel_4_10_2_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
    		lblNewLabel_4_10_2_1.setBounds(402, 60, 56, 20);
    		panel_6.add(lblNewLabel_4_10_2_1);
    		
    		JLabel lblNewLabel_4_14 = new JLabel("Tổng tiền thanh toán:");
    		lblNewLabel_4_14.setFont(new Font("Monospaced", Font.PLAIN, 16));
    		lblNewLabel_4_14.setBounds(28, 91, 225, 20);
    		panel_6.add(lblNewLabel_4_14);
    		
    		JLabel lbl_TongTienThanhToan = new JLabel("1.000.000");
    		lbl_TongTienThanhToan.setHorizontalAlignment(SwingConstants.RIGHT);
    		lbl_TongTienThanhToan.setForeground(new Color(236, 109, 91));
    		lbl_TongTienThanhToan.setFont(new Font("Monospaced", Font.BOLD, 20));
    		lbl_TongTienThanhToan.setBounds(253, 91, 142, 20);
    		panel_6.add(lbl_TongTienThanhToan);
    		
    		JLabel lblNewLabel_4_10_3 = new JLabel("VNĐ");
    		lblNewLabel_4_10_3.setForeground(new Color(236, 109, 91));
    		lblNewLabel_4_10_3.setFont(new Font("Monospaced", Font.PLAIN, 16));
    		lblNewLabel_4_10_3.setBounds(402, 91, 56, 20);
    		panel_6.add(lblNewLabel_4_10_3);
            
    		c2.fill = GridBagConstraints.NONE;
            c2.anchor = GridBagConstraints.WEST;
            c2.ipadx = 1220;
            c2.ipady = 138;
            c2.insets = new Insets(5, 5, 0, 0);  // Các khoảng trống
            c2.gridwidth = 1;
            c2.gridx = 0;
            c2.gridy = 5+1;
            panel.add(panel_6, c2);
        }
        panel_2.setLayout(new BorderLayout());
        panel_2.add(new JScrollPane(p));
	}

	
	
	
}
