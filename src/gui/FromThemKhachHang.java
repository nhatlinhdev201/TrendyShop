package gui;

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

public class FromThemKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromThemKhachHang frame = new FromThemKhachHang();
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
	public FromThemKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameField = new JLabel("Tên KH  :");
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nameField.setBounds(154, 79, 123, 21);
		contentPane.add(nameField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(279, 80, 177, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(279, 112, 177, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(279, 144, 177, 25);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(279, 176, 177, 25);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(279, 208, 177, 25);
		contentPane.add(textField_5);
		
		JLabel trangthaiField = new JLabel("Trạng thái :");
		trangthaiField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		trangthaiField.setBounds(154, 208, 123, 21);
		contentPane.add(trangthaiField);
		
		JLabel phoneField = new JLabel("Địa chỉ :");
		phoneField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		phoneField.setBounds(154, 176, 123, 21);
		contentPane.add(phoneField);
		
		JLabel emailield = new JLabel("Email :");
		emailield.setFont(new Font("Tahoma", Font.PLAIN, 17));
		emailield.setBounds(154, 144, 123, 21);
		contentPane.add(emailield);
		
		JLabel fliedsdt = new JLabel("SDT");
		fliedsdt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		fliedsdt.setBounds(154, 112, 123, 21);
		contentPane.add(fliedsdt);
		
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		saveButton.setSize(177, 30);
		saveButton.setLocation(261, 441);
		contentPane.add(saveButton);
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
