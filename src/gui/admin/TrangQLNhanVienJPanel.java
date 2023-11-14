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
	private JTextField textField_maNV;
	private JTextField textField_ten;
	private JTextField textField_ngaySinh;
	private JTextField textField_diachi;
	private JTextField textField_chucVu;
	private JTextField textField_matKhau;
	private JTextField textField_cccd;
	private JTextField textField_trangThai;
	private JTextField textField_sdt;
	private JTextField textField_email;
	private JTextField textField_phanQuyen;
	private JTextField textField_anh;
	private JTextField textField_12;
	private JFrame parentFrame;
	/**
	 * Create the panel.
	 */
	public TrangQLNhanVienJPanel() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		this.parentFrame = parentFrame;
		
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
		
		textField_maNV = new JTextField();
		textField_maNV.setColumns(10);
		textField_maNV.setBounds(589, 65, 177, 25);
		add(textField_maNV);
		
		JLabel lbl_tennv = new JLabel("Họ tên :");
		lbl_tennv.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_tennv.setBounds(464, 97, 123, 21);
		add(lbl_tennv);
		
		textField_ten = new JTextField();
		textField_ten.setColumns(10);
		textField_ten.setBounds(589, 98, 177, 25);
		add(textField_ten);
		
		JLabel lbl_Dfb = new JLabel("Ngày sinh :");
		lbl_Dfb.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_Dfb.setBounds(464, 130, 123, 21);
		add(lbl_Dfb);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(589, 130, 177, 25);
		add(textField_ngaySinh);
		
		JLabel lbl_diachi = new JLabel("Đại chỉ :");
		lbl_diachi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_diachi.setBounds(821, 65, 123, 21);
		add(lbl_diachi);
		
		textField_diachi = new JTextField();
		textField_diachi.setColumns(10);
		textField_diachi.setBounds(946, 65, 177, 25);
		add(textField_diachi);
		
		JLabel lbl_chucVuu = new JLabel("Chức vụ :");
		lbl_chucVuu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_chucVuu.setBounds(821, 98, 123, 21);
		add(lbl_chucVuu);
		
		textField_chucVu = new JTextField();
		textField_chucVu.setColumns(10);
		textField_chucVu.setBounds(946, 98, 177, 25);
		add(textField_chucVu);
		
		JLabel lbl_makh_5 = new JLabel("Mật khẩu  :");
		lbl_makh_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh_5.setBounds(821, 162, 123, 21);
		add(lbl_makh_5);
		
		textField_matKhau = new JTextField();
		textField_matKhau.setColumns(10);
		textField_matKhau.setBounds(946, 162, 177, 25);
		add(textField_matKhau);
		
		JLabel lbl_makh_6 = new JLabel("Số CCCD :");
		lbl_makh_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh_6.setBounds(464, 162, 123, 21);
		add(lbl_makh_6);
		
		textField_cccd = new JTextField();
		textField_cccd.setColumns(10);
		textField_cccd.setBounds(589, 162, 177, 25);
		add(textField_cccd);
		
		JLabel lbl_trangThai = new JLabel("Trang thái :");
		lbl_trangThai.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_trangThai.setBounds(821, 130, 123, 21);
		add(lbl_trangThai);
		
		textField_trangThai = new JTextField();
		textField_trangThai.setColumns(10);
		textField_trangThai.setBounds(946, 130, 177, 25);
		add(textField_trangThai);
		
		JLabel lbl_sdt = new JLabel("Số điện thoại :");
		lbl_sdt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_sdt.setBounds(464, 194, 123, 21);
		add(lbl_sdt);
		
		textField_sdt = new JTextField();
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(589, 194, 177, 25);
		add(textField_sdt);
		
		JLabel lbl_email = new JLabel("Email :");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_email.setBounds(464, 226, 123, 21);
		add(lbl_email);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(589, 226, 177, 25);
		add(textField_email);
		
		JLabel lbl_makh_10 = new JLabel("Phân quyền :");
		lbl_makh_10.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh_10.setBounds(821, 194, 123, 21);
		add(lbl_makh_10);
		
		textField_phanQuyen = new JTextField();
		textField_phanQuyen.setColumns(10);
		textField_phanQuyen.setBounds(946, 194, 177, 25);
		add(textField_phanQuyen);
		
		JLabel lbl_makh_11 = new JLabel("Hình ảnh :");
		lbl_makh_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh_11.setBounds(821, 226, 123, 21);
		add(lbl_makh_11);
		
		textField_anh = new JTextField();
		textField_anh.setColumns(10);
		textField_anh.setBounds(946, 226, 177, 25);
		add(textField_anh);
		
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
