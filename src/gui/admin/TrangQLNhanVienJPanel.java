package gui.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constance.SetBountJPanel;
import daos.Dao_KhachHang;
import daos.Dao_NhanVien;
import entities.KhachHang;
import entities.NhanVien;

import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class TrangQLNhanVienJPanel extends JPanel implements ActionListener, MouseListener, WindowListener {
	private static final Font TABLE_FONT = new Font("Tahoma", Font.PLAIN, 15);
	private static DefaultTableModel tableModel;
	static Dao_NhanVien nvDao = new Dao_NhanVien();
	private JLabel label_anh;
	private JTextField txt_ma;
	private JTextField textField_ten;
	private JTextField textField_ngaySinh;
	private JTextField textField_diachi;
	private JTextField textField_cccd;
	private JTextField textField_sdt;
	private JTextField textField_email;
	private JTextField txt_timkiem;
	private JRadioButton btn_nghi;
	private JRadioButton btn_hoatDong;
	private JFrame parentFrame;
	private JButton btn_capNhat;
	private JButton btn_timKiem;
	private JButton btn_load;
	static int rowCount;

	/**
	 * Create the panel.
	 */
	public TrangQLNhanVienJPanel() {
		setBackground(new Color(152, 251, 152));
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		this.parentFrame = parentFrame;

		JTable table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));

		// Tạo font mới với kích cỡ chữ là 20 cho tiêu đề cột
		Font headerFont = new Font("Tahoma", Font.BOLD, 15);

		tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Mã NV", "Tên NV", "Ngày sinh", "Số CCCD",
				"SDT", "Email", "Địa chỉ", "Trạng thái", "Images" }) {
			// Override phương thức để set font cho dữ liệu trong bảng
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return String.class; // Đặt kiểu dữ liệu là String cho tất cả các cột
			}

			// Override phương thức để set font cho dữ liệu trong bảng
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Không cho phép chỉnh sửa dữ liệu trong bảng
			}
		};
		// Add ListSelectionListener to the table
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();

					// Check if a row is selected
					if (selectedRow != -1) {
						// Retrieve data from the selected row
						String maNV = (String) table.getValueAt(selectedRow, 0);
						String tenNV = (String) table.getValueAt(selectedRow, 1);
						String ngaySinh = (String) table.getValueAt(selectedRow, 2);
						String soCCCD = (String) table.getValueAt(selectedRow, 3);
						String soDienThoai = (String) table.getValueAt(selectedRow, 4);
						String email = (String) table.getValueAt(selectedRow, 5);
						String diaChi = (String) (table.getValueAt(selectedRow, 6));
						String trangThai = (String) table.getValueAt(selectedRow, 7);
						String hinhAnh = (String) table.getValueAt(selectedRow, 8);

						// Display data in text fields
						txt_ma.setText(maNV.trim());
						textField_cccd.setText(soCCCD.trim());
						textField_ten.setText(tenNV.trim());
						textField_ngaySinh.setText(ngaySinh);
						textField_sdt.setText(soDienThoai.trim());
						textField_email.setText(email.trim());
						textField_diachi.setText(diaChi.trim());
						ImageIcon icon = new ImageIcon(hinhAnh); // Sử dụng getResource để lấy đường dẫn từ resources
																	// của ứng dụng
						Image scaledIcon = icon.getImage().getScaledInstance(260, 240, Image.SCALE_SMOOTH); // Thiết lập
																											// kích
																											// thước
						ImageIcon resizedIcon1 = new ImageIcon(scaledIcon);
						label_anh.setIcon(resizedIcon1);

//						 Cài đặt thuộc tính selected của các nút radio btn_hoatDong và btn_nghi.
						if (trangThai.trim().equalsIgnoreCase("Hoạt động")) {
							btn_hoatDong.setSelected(true);
							btn_nghi.setSelected(false);
						} else if (trangThai.trim().equalsIgnoreCase("Nghỉ")) {
							btn_hoatDong.setSelected(false);
							btn_nghi.setSelected(true);
						}
					}
				}
			}
		});
		table.setFont(TABLE_FONT);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
	    table.getColumnModel().getColumn(1).setPreferredWidth(95); 
	    table.getColumnModel().getColumn(2).setPreferredWidth(30);
	    table.getColumnModel().getColumn(3).setPreferredWidth(30);
	    table.getColumnModel().getColumn(4).setPreferredWidth(30);
	    table.getColumnModel().getColumn(5).setPreferredWidth(100);
	    table.getColumnModel().getColumn(7).setPreferredWidth(20);
	    table.getColumnModel().getColumn(8).setPreferredWidth(0);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 319, 1330, 371);
		add(scrollPane);

		JLabel lbl_manv = new JLabel("Mã nhân viên :");
		lbl_manv.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_manv.setBounds(464, 99, 123, 21);
		add(lbl_manv);

		txt_ma = new JTextField();
		txt_ma.setEditable(false);
		txt_ma.setEnabled(false);
		txt_ma.setColumns(10);
		txt_ma.setBounds(589, 97, 196, 27);
		add(txt_ma);

		JLabel lbl_tennv = new JLabel("Họ tên :");
		lbl_tennv.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_tennv.setBounds(464, 142, 123, 21);
		add(lbl_tennv);

		textField_ten = new JTextField();
		textField_ten.setColumns(10);
		textField_ten.setBounds(589, 140, 196, 27);
		add(textField_ten);

		JLabel lbl_Dfb = new JLabel("Ngày sinh :");
		lbl_Dfb.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_Dfb.setBounds(812, 142, 123, 21);
		add(lbl_Dfb);

		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setEnabled(false);
		textField_ngaySinh.setEditable(false);
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(937, 140, 196, 27);
		add(textField_ngaySinh);

		JLabel lbl_diachi = new JLabel("Đại chỉ :");
		lbl_diachi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_diachi.setBounds(812, 99, 123, 21);
		add(lbl_diachi);

		textField_diachi = new JTextField();
		textField_diachi.setColumns(10);
		textField_diachi.setBounds(937, 97, 196, 27);
		add(textField_diachi);

		JLabel lbl_makh_6 = new JLabel("Số CCCD :");
		lbl_makh_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh_6.setBounds(812, 178, 123, 21);
		add(lbl_makh_6);

		textField_cccd = new JTextField();
		textField_cccd.setColumns(10);
		textField_cccd.setBounds(937, 176, 196, 27);
		add(textField_cccd);

		JLabel lbl_trangThai = new JLabel("Trang thái :");
		lbl_trangThai.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_trangThai.setBounds(812, 219, 123, 21);
		add(lbl_trangThai);

		JLabel lbl_sdt = new JLabel("Số điện thoại :");
		lbl_sdt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_sdt.setBounds(464, 178, 123, 21);
		add(lbl_sdt);

		textField_sdt = new JTextField();
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(589, 176, 196, 27);
		add(textField_sdt);

		JLabel lbl_email = new JLabel("Email :");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_email.setBounds(464, 219, 321, 21);
		add(lbl_email);

		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(589, 216, 196, 27);
		add(textField_email);

		btn_timKiem = new JButton("Tìm kiếm theo mã");
		btn_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_timKiem.setBounds(448, 275, 173, 33);

		// Đường dẫn của hình ảnh icon
		String iconPath = "/images/searchphuc.png";
		ImageIcon icon = new ImageIcon(this.getClass().getResource(iconPath));
		Image scaledIcon = icon.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
		ImageIcon resizedIcon1 = new ImageIcon(scaledIcon);
		btn_timKiem.setIcon(resizedIcon1);
		add(btn_timKiem);

		JButton btn_them = new JButton("Thêm");
		btn_them.setBackground(Color.GREEN);
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_them.setBounds(879, 275, 123, 33);
		String iconPath_them = "/images/plus.png";
		ImageIcon iconThem = new ImageIcon(this.getClass().getResource(iconPath_them));
		Image scaledIconThem = iconThem.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích
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

		btn_capNhat = new JButton("Cập nhật");
		btn_capNhat.setBackground(Color.ORANGE);
		btn_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_capNhat.setBounds(1034, 275, 123, 33);
		String iconPath_capnhat = "/images/updated.png";
		ImageIcon iconCapNhat = new ImageIcon(this.getClass().getResource(iconPath_capnhat));
		Image scaledIconCapNhat = iconCapNhat.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập
		ImageIcon resizedIconCapNhat = new ImageIcon(scaledIconCapNhat);
		btn_capNhat.setIcon(resizedIconCapNhat);
		add(btn_capNhat);

		txt_timkiem = new JTextField();
		txt_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_timkiem.setColumns(10);
		txt_timkiem.setBounds(621, 275, 248, 33);
		add(txt_timkiem);

		label_anh = new JLabel("");
		label_anh.setIcon(new ImageIcon(TrangQLNhanVienJPanel.class.getResource("/images/picture.png")));
		label_anh.setBounds(139, 50, 263, 248);
		add(label_anh);

		btn_hoatDong = new JRadioButton("Hoạt động");
		btn_hoatDong.setBackground(new Color(152, 251, 152));
		btn_hoatDong.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_hoatDong.setBounds(930, 218, 102, 23);
		add(btn_hoatDong);

		btn_nghi = new JRadioButton("Đã nghỉ");
		btn_nghi.setBackground(new Color(152, 251, 152));
		btn_nghi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_nghi.setBounds(1044, 219, 83, 23);
		add(btn_nghi);

		ButtonGroup buttonGroup = new ButtonGroup();

		// Thêm nút vào nhóm
		buttonGroup.add(btn_hoatDong);
		buttonGroup.add(btn_nghi);

		JLabel lblNewLabel_1 = new JLabel("Thông tin nhân viên\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_1.setBounds(478, 11, 457, 43);
		add(lblNewLabel_1);

		btn_load = new JButton("Làm mới");

		btn_load = new JButton("Làm mới");
		btn_load.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_load.setBounds(1184, 275, 123, 33);
		String iconPath_load = "/images/loading.png";
		ImageIcon iconLoad = new ImageIcon(this.getClass().getResource(iconPath_load)); // Sử dụng getResource để lấy đường dẫn

		Image scaledIconLoad = iconLoad.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập
		ImageIcon resizedIconLoad = new ImageIcon(scaledIconLoad);
		btn_load.setIcon(resizedIconLoad);
		add(btn_load);

		btn_timKiem.addActionListener(this);
		btn_capNhat.addActionListener(this);
		btn_load.addActionListener(this);
		docDuLieu();
	}

	public static void docDuLieu() {
		try {
			List<NhanVien> list = nvDao.getAllNhanVien();
			int i = 0;
			for (NhanVien nv : list) {
				// Định dạng ngày tháng năm
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				// Định dạng ngày tháng năm và lấy ngày sinh từ đối tượng NhanVien
				String ngaySinhFormatted = dateFormat.format(nv.getNgaySinh());

				// Tạo một mảng dữ liệu để chứa thông tin của khách hàng
				Object[] rowData = {

						nv.getMaNhanVien().trim(), nv.getHoTen().trim(), ngaySinhFormatted, nv.getSoCCCD().trim(), nv.getSoDienThoai().trim(),
						nv.getEmail().trim(), nv.getDiaChi().trim(), nv.isTrangThai() ? "Hoạt động" : "Nghỉ" // Chuyển boolean thành
																								// chuỗi
						, nv.getAnhDaiDien() };
				// Thêm dữ liệu vào model của bảng
				tableModel.addRow(rowData);

				// Tăng chỉ số
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btn_timKiem)) {
			String giaTri = txt_timkiem.getText().trim();
			if (giaTri.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images/warning.png"));
			} else {
				NhanVien nhanVien = null;
				clearTable();
				try {
					nhanVien = nvDao.getNhanVienTheoMa(giaTri);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				try {
					if (nhanVien != null) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//						// Chuyển đổi Date thành chuỗi
						String ngaySinhString = dateFormat.format(nhanVien.getNgaySinh());
//						 Hiển thị thông tin khách hàng trong text fields
						txt_ma.setText(nhanVien.getMaNhanVien());
						textField_cccd.setText(nhanVien.getSoCCCD());
						textField_ten.setText(nhanVien.getHoTen());
						textField_ngaySinh.setText(ngaySinhString);
						textField_sdt.setText(nhanVien.getSoDienThoai());
						textField_email.setText(nhanVien.getEmail().trim());
						textField_diachi.setText(nhanVien.getDiaChi().trim());
						if (nhanVien.isTrangThai()) {
							btn_hoatDong.setSelected(false);
							btn_nghi.setSelected(true);
						} else {
							btn_hoatDong.setSelected(true);
							btn_nghi.setSelected(false);
						}
						ImageIcon icon = new ImageIcon(nhanVien.getAnhDaiDien()); // Sử dụng getResource để lấy đường
																					// dẫn từ hệ thống
						Image scaledIcon = icon.getImage().getScaledInstance(260, 240, Image.SCALE_SMOOTH);
						// Thiết lập kích thước ảnh
						ImageIcon resizedIcon1 = new ImageIcon(scaledIcon);
						label_anh.setIcon(resizedIcon1);

						// Hiển thị thông tin khách hàng trong bảng
						Object[] rowData = { nhanVien.getMaNhanVien(), nhanVien.getHoTen(), ngaySinhString,
								nhanVien.getSoCCCD(), nhanVien.getSoDienThoai(), nhanVien.getEmail(),
								nhanVien.getDiaChi(), nhanVien.isTrangThai() ? "Nghỉ" : "Hoạt động",
								nhanVien.getAnhDaiDien() };
//		                    int rowIndex = tableModel.getRowCount() - 1;  // Lấy chỉ số của dòng vừa thêm vào bảng
//		                    table.setRowSelectionInterval(rowIndex, rowIndex);
						// Thêm dữ liệu vào model của bảng
						tableModel.addRow(rowData);
					} else {
						JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng!", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		} else if (obj.equals(btn_capNhat)) {
			try {
				capNhatNhanVien();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (obj.equals(btn_load)) {
			loadDataIntoTable();
		}
	}

	private void clearTable() {
		int rowCount = tableModel.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}

	public static int getRowCount() {
		return rowCount = tableModel.getRowCount();
	}

	private void loadDataIntoTable() {
		try {
			// Clear existing data in the table
			clearTable();

			// Load data from the database into the table
			docDuLieu();

			// Additional logic if needed after loading data
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void capNhatNhanVien() throws ParseException {
		if (kiemTraHople()) {
			NhanVien nv = layNhanVien();
			if (nvDao.updateNhanVien(nv)) {
				JOptionPane.showMessageDialog(this, "Đã cập nhật thành công nhân viên: " + nv.getMaNhanVien());
			} else {
				JOptionPane.showMessageDialog(this, "Không thể cập nhật!!!");
			}
		}
	}

	public NhanVien layNhanVien() throws ParseException {
		Date ngaySinh =  new Date(9, 11, 2003);
		String ngaySinhText = textField_ngaySinh.getText();
		String maNV = txt_ma.getText().trim();
		String tenNV = textField_ten.getText().trim();
		String sdt = textField_sdt.getText().trim();
		String email = textField_email.getText().trim();
		String diachi = textField_diachi.getText().trim();
//		// Parse the date string into a Date object
		String socccd = textField_cccd.getText().trim();
		boolean trangthai = false;
		if (btn_hoatDong.isSelected() && !btn_nghi.isSelected())
			trangthai = true;
		NhanVien nhanVien = new NhanVien(maNV, tenNV, ngaySinh, socccd, sdt, email, diachi, trangthai);
		return nhanVien;
	}

	public boolean kiemTraHople() {
		String soCCCD = textField_cccd.getText().trim();
		String email = textField_email.getText().trim();
		String sdt = textField_sdt.getText().trim();
		if (textField_ngaySinh.getText().isEmpty() || txt_ma.getText().isEmpty() || textField_ten.getText().isEmpty()
				|| textField_diachi.getText().isEmpty() || textField_email.getText().isEmpty()
				|| textField_cccd.getText().isEmpty() || textField_cccd.getText().isEmpty()) {
			// Display an error message or handle the empty fields in some way
			JOptionPane.showMessageDialog(null, "Vui lòng điền dầy đủ thông tin các trường", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!soCCCD.matches("\\d")) {
			JOptionPane.showMessageDialog(this, "Số cccd phải là số!");
			return false;
		}
		if (!email.endsWith("@gmail.com")) {
			JOptionPane.showMessageDialog(this, "Email phải kết thúc bằng '@gmail.com'!");
			return false;
		}
		if (!sdt.matches("0\\d{9}")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải có đúng 10 số bắt đầu từ số 0!");
			return false;
		}
		if (!btn_hoatDong.isSelected() && !btn_nghi.isSelected()) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn trạng thái hoạt động hoặc nghỉ!");
			return false; // Dừng hàm nếu không có JRadioButton nào được chọn
		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

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
