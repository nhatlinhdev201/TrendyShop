package gui.admin;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import connection.ConnectDataBase;
import daos.Dao_KhachHang;
import daos.Dao_NhanVien;
import entities.KhachHang;
import entities.NhanVien;

import java.io.File;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FromThemNhanVien extends JFrame implements WindowListener {
	static Dao_NhanVien nvDao = new Dao_NhanVien();
	public Connection connection = ConnectDataBase.getInstance().connection;;
	private JDateChooser txt_ngaysinh;
	private JPanel contentPane;
	private JTextField txt_manv;
	private JTextField txt_hoten;
	private JTextField textField_2;
	private JTextField txt_scccd;
	private JTextField txt_sdt;
	private JTextField txt_email;
	private JTextField txt_matKhau;
	private JTextField txt_diachi;
	private String imagePath;
	private JRadioButton cbox_quanli;
	private JRadioButton cbox_nhanVien;
	private String chucVu;
	private String ngaySinhtxt;
	private JRadioButton rdbtnNgh;

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
	 * 
	 * @param parentFrame
	 */
	public FromThemNhanVien() {
		setBounds(100, 100, 697, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

//		JLabel lbl_manv = new JLabel("Mã nhân viên :");
//		lbl_manv.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lbl_manv.setBounds(10, 244, 123, 21);
//		contentPane.add(lbl_manv);

		JLabel nameField = new JLabel("Họ tên :");
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nameField.setBounds(10, 276, 123, 21);
		contentPane.add(nameField);

//		txt_manv = new JTextField();
//		txt_manv.setColumns(10);
//		txt_manv.setBounds(135, 244, 177, 25);
//		contentPane.add(txt_manv);

		txt_hoten = new JTextField();
		txt_hoten.setColumns(10);
		txt_hoten.setBounds(135, 277, 177, 25);
		contentPane.add(txt_hoten);

//		textField_2 = new JTextField();
//		textField_2.setColumns(10);
//		textField_2.setBounds(135, 309, 177, 25);
//		contentPane.add(textField_2);

		txt_scccd = new JTextField();
		txt_scccd.setColumns(10);
		txt_scccd.setBounds(135, 341, 177, 25);
		contentPane.add(txt_scccd);

		txt_sdt = new JTextField();
		txt_sdt.setColumns(10);
		txt_sdt.setBounds(135, 373, 177, 25);
		contentPane.add(txt_sdt);

		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(135, 405, 177, 30);
		contentPane.add(txt_email);

		txt_ngaysinh = new JDateChooser();
		txt_ngaysinh.setDateFormatString("dd/MM/yyyy");
//		txt_ngaysinh.getCalendarButton().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// Kiểm tra xem ngày đã được chọn hay chưa
//				if (txt_ngaysinh.getDate() == null) {
//					// Ngày đã được chọn
//					JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày", "Error", JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		});
		txt_ngaysinh.setBounds(135, 309, 177, 25);
		contentPane.add(txt_ngaysinh);

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
		addressField.setBounds(363, 276, 123, 21);
		contentPane.add(addressField);

		JLabel positionField = new JLabel("Chức vụ :");
		positionField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		positionField.setBounds(363, 309, 123, 21);
		contentPane.add(positionField);

		JLabel lbl_trangThai = new JLabel("Trang thái :");
		lbl_trangThai.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_trangThai.setBounds(363, 341, 123, 21);
		contentPane.add(lbl_trangThai);

		JLabel lbl_makh_5 = new JLabel("Mật khẩu  :");
		lbl_makh_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh_5.setBounds(363, 373, 123, 21);
		contentPane.add(lbl_makh_5);

		txt_matKhau = new JTextField();
		txt_matKhau.setColumns(10);
		txt_matKhau.setBounds(488, 373, 177, 25);
		contentPane.add(txt_matKhau);

		txt_diachi = new JTextField();
		txt_diachi.setColumns(10);
		txt_diachi.setBounds(488, 276, 177, 25);
		contentPane.add(txt_diachi);

		JButton saveButton = new JButton("Save");
		saveButton.setBackground(new Color(127, 255, 0));
		saveButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		saveButton.setSize(177, 30);
		saveButton.setLocation(272, 455);
		contentPane.add(saveButton);

		JLabel imageLabel = new JLabel("                    Image");
		imageLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		imageLabel.setBackground(new Color(255, 250, 250));
		imageLabel.setBounds(238, 11, 211, 175);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

		// Thiết lập Border cho JLabel
		imageLabel.setBorder(border);

		JButton chooseImageButton = new JButton("Thêm ảnh");
		chooseImageButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chooseImageButton.setBounds(272, 197, 135, 36);
		contentPane.add(chooseImageButton);
		contentPane.add(imageLabel);
		ButtonGroup buttonGroup1 = new ButtonGroup();

		cbox_quanli = new JRadioButton("Quản Lý");
		cbox_quanli.setBackground(new Color(152, 251, 152));
		cbox_quanli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbox_quanli.setBounds(488, 311, 81, 23);
		contentPane.add(cbox_quanli);

		cbox_nhanVien = new JRadioButton("Nhân viên");
		cbox_nhanVien.setBackground(new Color(152, 251, 152));
		cbox_nhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbox_nhanVien.setBounds(571, 311, 94, 23);
		contentPane.add(cbox_nhanVien);

		buttonGroup1.add(cbox_nhanVien);
		buttonGroup1.add(cbox_quanli);
		JRadioButton rdb_hoatdong = new JRadioButton("Hoạt động");
		rdb_hoatdong.setBackground(new Color(152, 251, 152));
		rdb_hoatdong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdb_hoatdong.setBounds(488, 343, 94, 23);
		contentPane.add(rdb_hoatdong);
		ButtonGroup buttonGroup = new ButtonGroup();

		// Thêm nút vào nhóm

		rdbtnNgh = new JRadioButton("Đã nghỉ");
		rdbtnNgh.setBackground(new Color(152, 251, 152));
		rdbtnNgh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNgh.setBounds(581, 343, 94, 23);
		contentPane.add(rdbtnNgh);
		buttonGroup.add(rdb_hoatdong);
		buttonGroup.add(rdbtnNgh);

		JPanel panel = new JPanel();
		panel.setBounds(222, 0, 238, 194);
		contentPane.add(panel);

		JButton btn_troLai = new JButton("Trở lại");
		btn_troLai.setBackground(new Color(255, 99, 71));
		btn_troLai.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btn_troLai.setBounds(534, 455, 135, 30);
		contentPane.add(btn_troLai);
		btn_troLai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame currentFrame = (JFrame) SwingUtilities.getRoot((Component) e.getSource());
				currentFrame.dispose();

//		        // Open the QL khách hàng window
//		        JFrame qlKhachHangFrame = new JFrame("Quản lý khách hàng");
//		        // Set up the content of the new window (you may need to customize this part)
//		        // ...
//
//		        qlKhachHangFrame.setSize(600, 400);
//		        qlKhachHangFrame.setLocationRelativeTo(null); // Center the new window
//		        qlKhachHangFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		        // Make sure to set the visibility of the new window to true
//		        qlKhachHangFrame.setVisible(true);
			}
		});
		chooseImageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Hành động chọn ảnh, ví dụ sử dụng JFileChooser
				JFileChooser fileChooser = new JFileChooser("D:/");
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					imagePath = fileChooser.getSelectedFile().getAbsolutePath();

					if (imagePath != null && !imagePath.isEmpty()) {
						ImageIcon icon = new ImageIcon(imagePath); // Sử dụng getResource để lấy đường dẫn từ resources
																	// của ứng dụng
						Image scaledIcon = icon.getImage().getScaledInstance(260, 240, Image.SCALE_SMOOTH); // Thiết lập
																											// kích
																											// thước
						ImageIcon resizedIcon1 = new ImageIcon(scaledIcon);
						imageLabel.setIcon(resizedIcon1);
						// Lưu đường dẫn ảnh vào cơ sở dữ liệu sau khi nhấn nút lưu
					} else {
						JOptionPane.showMessageDialog(null, "Chosen image is null or empty!", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
//            	try {
//					JFileChooser f = new JFileChooser();
//					f.setDialogTitle("Chọn Ảnh");
//					f.showOpenDialog(null);
//					File ftenanh = f.getSelectedFile();
//					duongDanAnh = ftenanh.getAbsolutePath();
//					if (duongDanAnh!=null) {
//						imageLabel.setIcon(String.valueOf(duongDanAnh));
//					}
//					
//				} catch (Exception e2) {
//					// TODO: handle exception
//				}
				}
			}
		});
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lưu thông tin vào cơ sở dữ liệu khi nhấn nút "Lưu"
				// Lấy thông tin từ các trường dữ liệu trên giao diện
				String tenNhanVien = txt_hoten.getText().trim();
				String soDienThoai = txt_sdt.getText().trim();
				String email = txt_email.getText().trim();
				String diaChi = txt_diachi.getText().trim();
				java.sql.Date ngaySinh = null;
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					ngaySinhtxt = dateFormat.format(txt_ngaysinh.getDate());
					java.util.Date ngaysinh = dateFormat.parse(ngaySinhtxt);
					ngaySinh = new java.sql.Date(ngaysinh.getTime());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				String soCCCD = txt_scccd.getText().trim();
				String matKhau = txt_matKhau.getText().trim();
				boolean trangThai = rdb_hoatdong.isSelected();
				if (cbox_quanli.isSelected() && !cbox_nhanVien.isSelected()) {
					chucVu = "QL";
				} else if (!cbox_quanli.isSelected() && cbox_nhanVien.isSelected()) {
					chucVu = "NV";
					String manv = chucVu + "00" + TrangQLNhanVienJPanel.getRowCount();

					if (kiemTraHople()) {
//					// Kiểm tra và xử lý các điều kiện khác nếu cần thiết
//						// Tạo đối tượng KhachHang từ thông tin đã nhập
						NhanVien nhanVien = new NhanVien();
						nhanVien.setMaNhanVien(manv);
						nhanVien.setHoTen(tenNhanVien);
						nhanVien.setSoCCCD(soCCCD);
						nhanVien.setNgaySinh(ngaySinh);
						nhanVien.setSoDienThoai(soDienThoai);
						nhanVien.setEmail(email);
						nhanVien.setDiaChi(diaChi);
						nhanVien.setChucVu(chucVu);
						nhanVien.setAnhDaiDien(imagePath);
						nhanVien.setTrangThai(trangThai);
						nhanVien.setMatKhau(matKhau);
						nhanVien.setPhanQuyen(true);
//						// Gọi hàm themKhachHang để lưu thông tin vào cơ sở dữ liệu
						boolean result = nvDao.themNhanVien(nhanVien);
						// Kiểm tra kết quả và thông báo cho người dùng
						if (result) {
							JOptionPane.showMessageDialog(contentPane, "Thêm nhân viên thành công!");
							// Có thể thêm logic để làm mới giao diện hoặc thực hiện các tác vụ khác sau khi
							// thêm
							Window window = SwingUtilities.getWindowAncestor(contentPane);
							if (window != null) {
								window.dispose();
							}
						} else {
							JOptionPane.showMessageDialog(contentPane, "Thêm Nhân viên thất bại!");
						}
					}
				}
			}
		});
		this.addWindowListener(this);
		this.setLocationRelativeTo(null);
		contentPane.setVisible(true);
	}

	public boolean kiemTraHople() {
		if (txt_hoten.getText().isEmpty() || txt_sdt.getText().isEmpty() || txt_email.getText().isEmpty()
				|| txt_diachi.getText().isEmpty() || txt_scccd.getText().isEmpty() || txt_matKhau.getText().isEmpty()) {
			JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập đầy đủ thông tin!");
			return false;
		} else if (txt_ngaysinh.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày", "Error", JOptionPane.ERROR_MESSAGE);
		}

		// Các kiểm tra khác có thể thêm vào tùy theo yêu cầu

		return true; // Tất cả các trường đều hợp lệ
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
