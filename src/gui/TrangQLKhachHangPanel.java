package gui;

import javax.swing.JPanel;

import constance.SetBountJPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class TrangQLKhachHangPanel extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public TrangQLKhachHangPanel() {
		setBackground(new Color(128, 255, 255));
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);

        // Load ảnh từ tệp
        ImageIcon originalIcon = new ImageIcon(TrangQLKhachHangPanel.class.getResource("/images/man.png"));
        Image img = originalIcon.getImage(); // Chuyển ImageIcon thành Image

        // Chỉnh kích thước ảnh
        Image newImg = img.getScaledInstance(230, 230, Image.SCALE_SMOOTH);

        // Tạo ImageIcon mới từ ảnh đã chỉnh kích thước
        ImageIcon resizedIcon = new ImageIcon(newImg);
        
        JTable table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));

		// Tạo font mới với kích cỡ chữ là 20 cho tiêu đề cột
		Font headerFont = new Font("Tahoma", Font.BOLD, 15);

		// Set model cho JTable
		table.setModel(new DefaultTableModel(
		    new Object[][] {
		    },
		    new String[] {
		        "STT", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Email", "Địa chỉ", "Trạng thái", "Điểm tích lũy"
		    }
		));
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(473, 65, 867, 625);
        add(scrollPane);
        
        JLabel lbl_makh = new JLabel("Mã khách hàng :");
        lbl_makh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbl_makh.setBounds(92, 312, 123, 21);
        add(lbl_makh);
        
        textField = new JTextField();
        textField.setBounds(217, 312, 146, 20);
        add(textField);
        textField.setColumns(10);
        
        JLabel lblTnKhchHng = new JLabel("Tên khách hàng :");
        lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTnKhchHng.setBounds(92, 350, 123, 21);
        add(lblTnKhchHng);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(217, 350, 146, 20);
        add(textField_1);
        
        JLabel lblSinThoai = new JLabel("Số điện thoai :");
        lblSinThoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSinThoai.setBounds(92, 384, 123, 21);
        add(lblSinThoai);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(217, 384, 146, 20);
        add(textField_2);
        
        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setFont(new Font("Sylfaen", Font.PLAIN, 15));
        lblEmail.setBounds(92, 418, 123, 21);
        add(lblEmail);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(217, 418, 146, 20);
        add(textField_3);
        
        JLabel lblaCh = new JLabel("Địa chỉ :");
        lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblaCh.setBounds(92, 456, 123, 21);
        add(lblaCh);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(217, 456, 146, 20);
        add(textField_4);
        
        JLabel lblTrngThi = new JLabel("Trạng thái  :");
        lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTrngThi.setBounds(92, 488, 123, 21);
        add(lblTrngThi);
        
        JLabel lblimTchLu = new JLabel("Điểm tích luỹ :");
        lblimTchLu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblimTchLu.setBounds(92, 526, 123, 21);
        add(lblimTchLu);
        
        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(217, 526, 146, 20);
        add(textField_6);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Hoạt động");
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
        rdbtnNewRadioButton.setBounds(217, 487, 95, 23);
        add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNgh = new JRadioButton("Nghỉ");
        rdbtnNgh.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnNgh.setBackground(new Color(255, 255, 255));
        rdbtnNgh.setBounds(314, 487, 75, 23);
        add(rdbtnNgh);
        
        JLabel lblNewLabel = new JLabel("Thông tin khách hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(50, 35, 353, 33);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(TrangQLKhachHangPanel.class.getResource("/images/man.png")));
        lblNewLabel_1.setBounds(156, 92, 207, 176);
        add(lblNewLabel_1);
        
        JButton btn_timKiem = new JButton("Tìm kiếm");
        btn_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_timKiem.setBounds(473, 21, 123, 33);
       
        
     // Tạo nút tìm kiếm
        
        // Đường dẫn của hình ảnh icon
        String iconPath = "/images/searchphuc.png";
		ImageIcon icon = new ImageIcon(this.getClass().getResource(iconPath)); // Sử dụng getResource để lấy đường dẫn từ resources của ứng dụng

		Image scaledIcon = icon.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
		ImageIcon resizedIcon1 = new ImageIcon(scaledIcon);

		btn_timKiem.setIcon(resizedIcon1);
		add(btn_timKiem);
        
        textField_5 = new JTextField();
        textField_5.setBounds(595, 21, 280, 33);
        add(textField_5);
        textField_5.setColumns(10);
        
        JButton btn_them = new JButton("Thêm");
        btn_them.setBackground(Color.GREEN);
        btn_them.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_them.setBounds(33, 619, 123, 33);
        String iconPath_them = "/images/plus.png";
		ImageIcon iconThem = new ImageIcon(this.getClass().getResource(iconPath_them)); // Sử dụng getResource để lấy đường dẫn từ resources của ứng dụng

		Image scaledIconThem = iconThem.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
		ImageIcon resizedIconThem = new ImageIcon(scaledIconThem);

		btn_them.setIcon(resizedIconThem);
        add(btn_them);
        
        JButton btn_xoa = new JButton("Xoá");
        btn_xoa.setBackground(new Color(250, 128, 114));
        btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_xoa.setBounds(172, 619, 123, 33);
        String iconPath_xoa = "/images/delete.png";
		ImageIcon iconXoa = new ImageIcon(this.getClass().getResource(iconPath_xoa)); // Sử dụng getResource để lấy đường dẫn từ resources của ứng dụng

		Image scaledIconXoa = iconXoa.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
		ImageIcon resizedIconXoa = new ImageIcon(scaledIconXoa);

		btn_xoa.setIcon(resizedIconXoa);
        add(btn_xoa);
        
        JButton btn_capNhat = new JButton("Cập nhật");
        btn_capNhat.setBackground(Color.ORANGE);
        btn_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_capNhat.setBounds(315, 619, 123, 33);
        String iconPath_capnhat = "/images/updated.png";
		ImageIcon iconCapNhat = new ImageIcon(this.getClass().getResource(iconPath_capnhat)); // Sử dụng getResource để lấy đường dẫn từ resources của ứng dụng

		Image scaledIconCapNhat = iconCapNhat.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
		ImageIcon resizedIconCapNhat = new ImageIcon(scaledIconCapNhat);

		btn_capNhat.setIcon(resizedIconCapNhat);
        add(btn_capNhat);
        
        
	}
}
