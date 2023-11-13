package gui.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constance.SetBountJPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class TrangQLNhanVienJPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * Create the panel.
	 */
	public TrangQLNhanVienJPanel() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);

		JTable table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));

		// Tạo font mới với kích cỡ chữ là 20 cho tiêu đề cột
		Font headerFont = new Font("Tahoma", Font.BOLD, 15);

		// Set model cho JTable
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Mã NV", "Tên NV",
				"Ngày sinh", "Email", "Địa chỉ", "Chức vụ", "Trạng thái","Hình ảnh" }));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 319, 1330, 371);
		add(scrollPane);
		
		JLabel lbl_manv = new JLabel("Mã nhân viên :");
		lbl_manv.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_manv.setBounds(464, 65, 123, 21);
		add(lbl_manv);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(589, 65, 177, 25);
		add(textField);
		
		JLabel lbl_tennv = new JLabel("Họ tên :");
		lbl_tennv.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_tennv.setBounds(464, 97, 123, 21);
		add(lbl_tennv);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(589, 98, 177, 25);
		add(textField_1);
		
		JLabel lbl_Dfb = new JLabel("Ngày sinh :");
		lbl_Dfb.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_Dfb.setBounds(464, 130, 123, 21);
		add(lbl_Dfb);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(589, 130, 177, 25);
		add(textField_2);
		
		JLabel lbl_diachi = new JLabel("Đại chỉ :");
		lbl_diachi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_diachi.setBounds(821, 65, 123, 21);
		add(lbl_diachi);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(946, 65, 177, 25);
		add(textField_3);
		
		JLabel lbl_chucVuu = new JLabel("Chức vụ :");
		lbl_chucVuu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_chucVuu.setBounds(821, 98, 123, 21);
		add(lbl_chucVuu);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(946, 98, 177, 25);
		add(textField_4);
		
		JLabel lbl_makh_5 = new JLabel("Mật khẩu  :");
		lbl_makh_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh_5.setBounds(821, 162, 123, 21);
		add(lbl_makh_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(946, 162, 177, 25);
		add(textField_5);
		
		JLabel lbl_makh_6 = new JLabel("Số CCCD :");
		lbl_makh_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh_6.setBounds(464, 162, 123, 21);
		add(lbl_makh_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(589, 162, 177, 25);
		add(textField_6);
		
		JLabel lbl_trangThai = new JLabel("Trang thái :");
		lbl_trangThai.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_trangThai.setBounds(821, 130, 123, 21);
		add(lbl_trangThai);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(946, 130, 177, 25);
		add(textField_7);
		
		JLabel lbl_sdt = new JLabel("Số điện thoại :");
		lbl_sdt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_sdt.setBounds(464, 194, 123, 21);
		add(lbl_sdt);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(589, 194, 177, 25);
		add(textField_8);
		
		JLabel lbl_email = new JLabel("Email :");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_email.setBounds(464, 226, 123, 21);
		add(lbl_email);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(589, 226, 177, 25);
		add(textField_9);
		
		JLabel lbl_makh_10 = new JLabel("Phân quyền :");
		lbl_makh_10.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh_10.setBounds(821, 194, 123, 21);
		add(lbl_makh_10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(946, 194, 177, 25);
		add(textField_10);
		
		JLabel lbl_makh_11 = new JLabel("Hình ảnh :");
		lbl_makh_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh_11.setBounds(821, 226, 123, 21);
		add(lbl_makh_11);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(946, 226, 177, 25);
		add(textField_11);
		
		JButton btn_timKiem = new JButton("Tìm kiếm");
		btn_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_timKiem.setBounds(464, 275, 130, 33);

        // Đường dẫn của hình ảnh icon
        String iconPath = "/images/searchphuc.png";
		ImageIcon icon = new ImageIcon(this.getClass().getResource(iconPath)); // Sử dụng getResource để lấy đường dẫn từ resources của ứng dụng

		Image scaledIcon = icon.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
		ImageIcon resizedIcon1 = new ImageIcon(scaledIcon);

		btn_timKiem.setIcon(resizedIcon1);
		add(btn_timKiem);
		
		JButton btn_them = new JButton("Thêm");
        btn_them.setBackground(Color.GREEN);
        btn_them.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_them.setBounds(836, 275, 123, 33);
        String iconPath_them = "/images/plus.png";
		ImageIcon iconThem = new ImageIcon(this.getClass().getResource(iconPath_them)); // Sử dụng getResource để lấy đường dẫn từ resources của ứng dụng

		Image scaledIconThem = iconThem.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
		ImageIcon resizedIconThem = new ImageIcon(scaledIconThem);

		btn_them.setIcon(resizedIconThem);
        add(btn_them);
        btn_them.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Hiển thị form nhập thông tin nhân viên khi nhấn nút "Thêm"
            	FromThemNhanVien formThemNhanVien = new FromThemNhanVien();
                 formThemNhanVien.setVisible(true);
            }
        });
		
        JButton btn_capNhat = new JButton("Cập nhật");
        btn_capNhat.setBackground(Color.ORANGE);
        btn_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_capNhat.setBounds(991, 275, 123, 33);
        String iconPath_capnhat = "/images/updated.png";
		ImageIcon iconCapNhat = new ImageIcon(this.getClass().getResource(iconPath_capnhat)); // Sử dụng getResource để lấy đường dẫn từ resources của ứng dụng

		Image scaledIconCapNhat = iconCapNhat.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
		ImageIcon resizedIconCapNhat = new ImageIcon(scaledIconCapNhat);

		btn_capNhat.setIcon(resizedIconCapNhat);
        add(btn_capNhat);
        
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(592, 275, 223, 33);
		add(textField_12);
	}
	
//	public static void showEmployeeForm() {
//		JFrame frame = new JFrame("Employee Information");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 500);
//        frame.getContentPane().setLayout(new GridLayout(11, 2));
//
//        JLabel nameLabel = new JLabel("Name:");
//        JTextField nameField = new JTextField(20);
//
//        JLabel dobLabel = new JLabel("Date of Birth (YYYY-MM-DD):");
//        JTextField dobField = new JTextField(20);
//
//        JLabel cccdLabel = new JLabel("CCCD:");
//        JTextField cccdField = new JTextField(20);
//
//        JLabel phoneLabel = new JLabel("Phone Number:");
//        JTextField phoneField = new JTextField(20);
//
//        JLabel emailLabel = new JLabel("Email:");
//        JTextField emailField = new JTextField(20);
//
//        JLabel addressLabel = new JLabel("Address:");
//        JTextField addressField = new JTextField(20);
//
//        JLabel positionLabel = new JLabel("Position:");
//        JTextField positionField = new JTextField(20);
//
//        JLabel statusLabel = new JLabel("Status:");
//        JTextField statusField = new JTextField(20);
//
//        JLabel passwordLabel = new JLabel("Password:");
//        JPasswordField passwordField = new JPasswordField(20);
//
//        JLabel permissionLabel = new JLabel("Permission:");
//        JTextField permissionField = new JTextField(20);
//
//        JLabel imageLabel = new JLabel("Choose Image:");
//        JButton chooseImageButton = new JButton("Choose Image");
//
//        JButton saveButton = new JButton("Save");
//
//        frame.getContentPane().add(nameLabel);
//        frame.getContentPane().add(nameField);
//        frame.getContentPane().add(dobLabel);
//        frame.getContentPane().add(dobField);
//        frame.getContentPane().add(cccdLabel);
//        frame.getContentPane().add(cccdField);
//        frame.getContentPane().add(phoneLabel);
//        frame.getContentPane().add(phoneField);
//        frame.getContentPane().add(emailLabel);
//        frame.getContentPane().add(emailField);
//        frame.getContentPane().add(addressLabel);
//        frame.getContentPane().add(addressField);
//        frame.getContentPane().add(positionLabel);
//        frame.getContentPane().add(positionField);
//        frame.getContentPane().add(statusLabel);
//        frame.getContentPane().add(statusField);
//        frame.getContentPane().add(passwordLabel);
//        frame.getContentPane().add(passwordField);
//        frame.getContentPane().add(permissionLabel);
//        frame.getContentPane().add(permissionField);
//        frame.getContentPane().add(imageLabel);
//        frame.getContentPane().add(chooseImageButton);
//        frame.getContentPane().add(saveButton);
//
//        chooseImageButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Hành động chọn ảnh, ví dụ sử dụng JFileChooser
//                JFileChooser fileChooser = new JFileChooser();
//                int result = fileChooser.showOpenDialog(null);
//                if (result == JFileChooser.APPROVE_OPTION) {
//                    // Lấy đường dẫn của ảnh đã chọn và xử lý nó ở đây
//                    String imagePath = fileChooser.getSelectedFile().getAbsolutePath();
//                    // Lưu đường dẫn ảnh vào cơ sở dữ liệu sau khi nhấn nút lưu
//                }
//            }
//        });
//
//        frame.setVisible(true);
//    }
}
