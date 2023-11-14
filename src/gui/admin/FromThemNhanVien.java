package gui.admin;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JTextField;

public class FromThemNhanVien extends JFrame {

	private JPanel contentPane;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromThemNhanVien frame = new FromThemNhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param parentFrame 
	 */
	public FromThemNhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_manv = new JLabel("Mã nhân viên :");
		lbl_manv.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_manv.setBounds(10, 244, 123, 21);
		contentPane.add(lbl_manv);
		
		JLabel nameField = new JLabel("Họ tên :");
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nameField.setBounds(10, 276, 123, 21);
		contentPane.add(nameField);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(135, 244, 177, 25);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(135, 277, 177, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(135, 309, 177, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(135, 341, 177, 25);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(135, 373, 177, 25);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(135, 405, 177, 25);
		contentPane.add(textField_5);
		
		JLabel emailField = new JLabel("Email :");
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		emailField.setBounds(10, 405, 123, 21);
		contentPane.add(emailField);
		
		JLabel phoneField = new JLabel("Số điện thoại :");
		phoneField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		phoneField.setBounds(10, 373, 123, 21);
		contentPane.add(phoneField);
		
		JLabel cccdField = new JLabel("Số CCCD :");
		cccdField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cccdField.setBounds(10, 341, 123, 21);
		contentPane.add(cccdField);
		
		JLabel dobField = new JLabel("Ngày sinh :");
		dobField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		dobField.setBounds(10, 309, 123, 21);
		contentPane.add(dobField);
		
		JLabel addressField = new JLabel("Đại chỉ :");
		addressField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		addressField.setBounds(367, 244, 123, 21);
		contentPane.add(addressField);
		
		JLabel positionField = new JLabel("Chức vụ :");
		positionField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		positionField.setBounds(367, 277, 123, 21);
		contentPane.add(positionField);
		
		JLabel lbl_trangThai = new JLabel("Trang thái :");
		lbl_trangThai.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_trangThai.setBounds(367, 309, 123, 21);
		contentPane.add(lbl_trangThai);
		
		JLabel lbl_makh_5 = new JLabel("Mật khẩu  :");
		lbl_makh_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh_5.setBounds(367, 341, 123, 21);
		contentPane.add(lbl_makh_5);
		
		JLabel lbl_makh_10 = new JLabel("Phân quyền :");
		lbl_makh_10.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh_10.setBounds(367, 373, 123, 21);
		contentPane.add(lbl_makh_10);
		
		JLabel lbl_makh_11 = new JLabel("Hình ảnh :");
		lbl_makh_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh_11.setBounds(367, 405, 123, 21);
		contentPane.add(lbl_makh_11);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(492, 405, 177, 25);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(492, 373, 177, 25);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(492, 341, 177, 25);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(492, 309, 177, 25);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(492, 277, 177, 25);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(492, 244, 177, 25);
		contentPane.add(textField_11);
		
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		saveButton.setSize(177, 30);
		saveButton.setLocation(261, 441);
		contentPane.add(saveButton);
		
		JLabel imageLabel = new JLabel("Ảnh");
		imageLabel.setBounds(238, 11, 162, 175);
        JButton chooseImageButton = new JButton("Thêm ảnh");
        chooseImageButton.setBounds(261, 197, 135, 36);
        contentPane.add(chooseImageButton);
        contentPane.add(imageLabel);
        
        chooseImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Hành động chọn ảnh, ví dụ sử dụng JFileChooser
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Lấy đường dẫn của ảnh đã chọn và xử lý nó ở đây
                    String imagePath = fileChooser.getSelectedFile().getAbsolutePath();
                    // Lưu đường dẫn ảnh vào cơ sở dữ liệu sau khi nhấn nút lưu
                }
            }
        });
//        saveButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Lưu thông tin vào cơ sở dữ liệu khi nhấn nút "Lưu"
//                saveEmployeeInfo(
//                    nameField.getText(),
//                    dobField.getText(),
//                    cccdField.getText(),
//                    phoneField.getText(),
//                    emailField.getText(),
//                    addressField.getText(),
//                    positionField.getText(),
//                    statusField.getText(),
//                    passwordField.getPassword(), 
//                    permissionField.getText()
//                    // Thêm đường dẫn ảnh vào hàm lưu thông tin
//                );
//            }
//        });

        contentPane.setVisible(true);
	}
}
