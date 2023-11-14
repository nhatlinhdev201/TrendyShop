package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import daos.Dao_KhachHang;
import daos.KhachHangDAO;
import entities.KhachHang;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

import javax.swing.JTextField;

public class FromThemKhachHang extends JFrame {
	static Dao_KhachHang dao_kh = new Dao_KhachHang();
	private JPanel contentPane;
	private JTextField txt_ten;
	private JTextField txt_sdt;
	private JTextField txt_email;
	private JTextField txt_diachi;
	private JButton btn_save;
	private JRadioButton rdb_hoatdong;
	private JRadioButton rdb_nghi;
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
		
		txt_ten = new JTextField();
		txt_ten.setColumns(10);
		txt_ten.setBounds(279, 80, 177, 25);
		contentPane.add(txt_ten);
		
		txt_sdt = new JTextField();
		txt_sdt.setColumns(10);
		txt_sdt.setBounds(279, 112, 177, 25);
		contentPane.add(txt_sdt);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(279, 144, 177, 25);
		contentPane.add(txt_email);
		
		txt_diachi = new JTextField();
		txt_diachi.setColumns(10);
		txt_diachi.setBounds(279, 176, 177, 25);
		contentPane.add(txt_diachi);
		
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
		
		JButton btn_save = new JButton("Save");
		btn_save.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btn_save.setSize(177, 30);
		btn_save.setLocation(261, 441);
		contentPane.add(btn_save);
		
		JRadioButton rdb_hoatdong = new JRadioButton("Hoạt động");
		rdb_hoatdong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdb_hoatdong.setBounds(279, 208, 109, 23);
		contentPane.add(rdb_hoatdong);
		
		JRadioButton rdb_nghi = new JRadioButton("Nghỉ");
		rdb_nghi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdb_nghi.setBounds(383, 208, 109, 23);
		contentPane.add(rdb_nghi);
		btn_save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   // Lấy thông tin từ các trường dữ liệu trên giao diện
            	Random random = new Random();
                int randomNumber = random.nextInt(900) + 100;
            	String makh = "KH" + randomNumber;
                String tenKhachHang = txt_ten.getText();
                String soDienThoai = txt_sdt.getText();
                String email = txt_email.getText();
                String diaChi = txt_diachi.getText();
                boolean trangThai = rdb_hoatdong.isSelected(); // true nếu hoạt động, ngược lại là false

                // Kiểm tra và xử lý các điều kiện khác nếu cần thiết

                // Tạo đối tượng KhachHang từ thông tin đã nhập
                KhachHang khachHang = new KhachHang();
	            khachHang.setMaKhachHang(makh);
	            khachHang.setTenKhachHang(tenKhachHang);
                khachHang.setSoDienThoai(soDienThoai);
                khachHang.setEmail(email);
                khachHang.setDiaChi(diaChi);
                khachHang.setTrangThai(trangThai);

                // Gọi hàm themKhachHang để lưu thông tin vào cơ sở dữ liệu
                boolean result = dao_kh.themKhachHang(khachHang);

                // Kiểm tra kết quả và thông báo cho người dùng
                if (result) {
                    JOptionPane.showMessageDialog(contentPane, "Thêm khách hàng thành công!");
                    // Có thể thêm logic để làm mới giao diện hoặc thực hiện các tác vụ khác sau khi thêm
                    Window window = SwingUtilities.getWindowAncestor(contentPane);
                    if (window != null) {
                        window.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Thêm khách hàng thất bại!");
                }
                
            }
        });


        contentPane.setVisible(true);
	}
	private void kiemTraHople() {
	    // Kiểm tra các trường không được để trống
	    if (txt_ten.getText().isEmpty() || txt_sdt.getText().isEmpty() || txt_email.getText().isEmpty() || txt_diachi.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập đầy đủ thông tin!");
	        return; // Dừng hàm nếu có trường trống
	    }

	    // Kiểm tra JRadioButton đã được chọn chưa
	    if (!rdb_hoatdong.isSelected() && !rdb_nghi.isSelected()) {
	        JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn trạng thái hoạt động hoặc nghỉ!");
	        return; // Dừng hàm nếu không có JRadioButton nào được chọn
	    }

	    // Nếu không có lỗi, tiếp tục thêm khách hàng
//	    themKhachHang();
	}
}
