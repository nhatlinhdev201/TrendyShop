package gui;

import javax.swing.JPanel;

import constance.SetBountJPanel;
import daos.Dao_KhachHang;
import daos.KhachHangDAO;
import entities.KhachHang;
import gui.admin.FromThemNhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class TrangQLKhachHangPanel extends JPanel implements ActionListener, MouseListener, WindowListener {
	private static final Font TABLE_FONT = new Font("Tahoma", Font.PLAIN, 15);
	static Dao_KhachHang khDao = new Dao_KhachHang();
	private JTable table;
	private JTextField txt_makh;
	private JTextField txt_ten;
	private JTextField txt_sDT;
	private JTextField txt_email;
	private JTextField txt_diaChi;
	private JTextField txt_diemTichLuy;
	private JTextField txt_timKiem;
	private JRadioButton btn_hoatDong;
	private JRadioButton btn_nghi;
	private JButton btn_timKiem;
	private JButton btn_them;
	private JButton btn_load;
	private JButton btn_capNhat;
	private static DefaultTableModel tableModel;
	private JComboBox<String> comboBox;
	static int rowCount;

	/**
	 * Create the panel.
	 */
	public TrangQLKhachHangPanel() {
		setBackground(Color.WHITE);
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);

		// Load ảnh từ tệp
		ImageIcon originalIcon = new ImageIcon(TrangQLKhachHangPanel.class.getResource("/images/man.png"));
		Image img = originalIcon.getImage(); // Chuyển ImageIcon thành Image

		// Chỉnh kích thước ảnh
		Image newImg = img.getScaledInstance(230, 230, Image.SCALE_SMOOTH);

		// Tạo ImageIcon mới từ ảnh đã chỉnh kích thước
		ImageIcon resizedIcon = new ImageIcon(newImg);

		JTable table = new JTable(tableModel);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));

		// Tạo font mới với kích cỡ chữ là 20 cho tiêu đề cột
		Font headerFont = new Font("Tahoma", Font.BOLD, 15);

		// Set model cho JTable
		tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Mã khách hàng", "Tên khách hàng",
				"Số điện thoại", "Email", "Địa chỉ", "Trạng thái", "Điểm tích lũy" }) {
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
						String maKH = (String) table.getValueAt(selectedRow, 0);
						String tenKhachHang = (String) table.getValueAt(selectedRow, 1);
						String soDienThoai = (String) table.getValueAt(selectedRow, 2);
						String email = (String) table.getValueAt(selectedRow, 3);
						String diaChi = (String) (table.getValueAt(selectedRow, 4));
						String trangThai = (String) table.getValueAt(selectedRow, 5);
						String diemTichLuy = String.valueOf(table.getValueAt(selectedRow, 6));

						// Display data in text fields
						txt_makh.setText(maKH.trim());
						txt_ten.setText(tenKhachHang.trim());
						txt_sDT.setText(soDienThoai.trim());
						txt_email.setText(email.trim());
						txt_diaChi.setText(diaChi.trim());
						txt_diemTichLuy.setText(diemTichLuy.trim());

						// Cài đặt thuộc tính selected của các nút radio btn_hoatDong và btn_nghi.
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
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		table.getColumnModel().getColumn(5).setPreferredWidth(10);
		table.getColumnModel().getColumn(6).setPreferredWidth(10);
		table.getColumnModel().getColumn(6).setMinWidth(10);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(473, 76, 867, 614);
		add(scrollPane);

		JLabel lbl_makh = new JLabel("Mã khách hàng :");
		lbl_makh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh.setBounds(50, 280, 146, 21);
		add(lbl_makh);

		txt_makh = new JTextField();
		txt_makh.setEditable(false);
		txt_makh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_makh.setForeground(Color.BLACK);
		txt_makh.setBounds(216, 280, 198, 25);
		add(txt_makh);
		txt_makh.setColumns(10);

		JLabel lblTnKhchHng = new JLabel("Tên khách hàng :");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTnKhchHng.setBounds(50, 332, 146, 21);
		add(lblTnKhchHng);

		txt_ten = new JTextField();
		txt_ten.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_ten.setForeground(Color.BLACK);
		txt_ten.setColumns(10);
		txt_ten.setBounds(216, 328, 198, 25);
		add(txt_ten);

		JLabel lblSinThoai = new JLabel("Số điện thoai :");
		lblSinThoai.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSinThoai.setBounds(50, 373, 123, 21);
		add(lblSinThoai);

		txt_sDT = new JTextField();
		txt_sDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_sDT.setForeground(Color.BLACK);
		txt_sDT.setColumns(10);
		txt_sDT.setBounds(216, 372, 198, 25);
		add(txt_sDT);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(50, 416, 123, 21);
		add(lblEmail);

		txt_email = new JTextField();
		txt_email.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_email.setForeground(Color.BLACK);
		txt_email.setColumns(10);
		txt_email.setBounds(216, 416, 198, 25);
		add(txt_email);

		JLabel lblaCh = new JLabel("Địa chỉ :");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblaCh.setBounds(50, 456, 123, 21);
		add(lblaCh);

		txt_diaChi = new JTextField();
		txt_diaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_diaChi.setForeground(Color.BLACK);
		txt_diaChi.setColumns(10);
		txt_diaChi.setBounds(216, 456, 198, 25);
		add(txt_diaChi);

		JLabel lblTrngThi = new JLabel("Trạng thái  :");
		lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrngThi.setBounds(50, 499, 123, 21);
		add(lblTrngThi);

		JLabel lblimTchLu = new JLabel("Điểm tích luỹ :");
		lblimTchLu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblimTchLu.setBounds(50, 545, 123, 21);
		add(lblimTchLu);

		txt_diemTichLuy = new JTextField();
		txt_diemTichLuy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_diemTichLuy.setForeground(Color.BLACK);
		txt_diemTichLuy.setColumns(10);
		txt_diemTichLuy.setBounds(216, 545, 198, 25);
		add(txt_diemTichLuy);

		btn_hoatDong = new JRadioButton("Hoạt động");
		btn_hoatDong.setSelected(true);
		btn_hoatDong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_hoatDong.setBackground(Color.WHITE);
		btn_hoatDong.setBounds(214, 499, 108, 23);
		add(btn_hoatDong);

		btn_nghi = new JRadioButton("Nghỉ");
		btn_nghi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_nghi.setBackground(Color.WHITE);
		btn_nghi.setBounds(324, 499, 75, 23);
		add(btn_nghi);

		ButtonGroup buttonGroup = new ButtonGroup();

		// Thêm nút vào nhóm
		buttonGroup.add(btn_hoatDong);
		buttonGroup.add(btn_nghi);

		JLabel lblNewLabel = new JLabel("Thông tin khách hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(75, 16, 352, 33);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(117, 66, 245, 190); // Set the size of the JLabel to 250x250
		add(lblNewLabel_1);

		ImageIcon originalIcon1 = new ImageIcon(TrangQLKhachHangPanel.class.getResource("/images/man.png"));
		Image originalImage = originalIcon1.getImage();
		Image resizedImage = originalImage.getScaledInstance(210, 210, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon1 = new ImageIcon(resizedImage);
		lblNewLabel_1.setIcon(resizedIcon1);

		btn_timKiem = new JButton("Tìm kiếm");
		btn_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_timKiem.setBounds(595, 21, 123, 44);

		// Tạo nút tìm kiếm

		// Đường dẫn của hình ảnh icon
		String iconPath = "/images/searchphuc.png";
		ImageIcon icon = new ImageIcon(this.getClass().getResource(iconPath)); // Sử dụng getResource để lấy đường dẫn
																				// từ resources của ứng dụng

		Image scaledIcon = icon.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
		ImageIcon resizedIcon11 = new ImageIcon(scaledIcon);

		btn_timKiem.setIcon(resizedIcon11);
		add(btn_timKiem);

		txt_timKiem = new JTextField();
		txt_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_timKiem.setBounds(717, 21, 377, 44);
		add(txt_timKiem);
		txt_timKiem.setColumns(10);

		btn_them = new JButton("Thêm");
		btn_them.setBackground(Color.GREEN);
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_them.setBounds(25, 609, 137, 56);
		String iconPath_them = "/images/plus.png";
		ImageIcon iconThem = new ImageIcon(this.getClass().getResource(iconPath_them)); // Sử dụng getResource để lấy
		Image scaledIconThem = iconThem.getImage().getScaledInstance(33, 33, Image.SCALE_SMOOTH); // Thiết lập kích
		ImageIcon resizedIconThem = new ImageIcon(scaledIconThem);
		btn_them.setIcon(resizedIconThem);
		add(btn_them);

		String iconPath_xoa = "/images/delete.png";
		ImageIcon iconXoa = new ImageIcon(this.getClass().getResource(iconPath_xoa)); // Sử dụng getResource để lấy
		Image scaledIconXoa = iconXoa.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
		ImageIcon resizedIconXoa = new ImageIcon(scaledIconXoa);
		btn_capNhat = new JButton("Cập nhật");
		btn_capNhat.setBackground(Color.ORANGE);
		btn_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_capNhat.setBounds(172, 609, 137, 56);
		String iconPath_capnhat = "/images/updated.png";
		ImageIcon iconCapNhat = new ImageIcon(this.getClass().getResource(iconPath_capnhat)); // Sử dụng getResource để

		Image scaledIconCapNhat = iconCapNhat.getImage().getScaledInstance(33, 33, Image.SCALE_SMOOTH); // Thiết lập
		ImageIcon resizedIconCapNhat = new ImageIcon(scaledIconCapNhat);

		btn_capNhat.setIcon(resizedIconCapNhat);
		add(btn_capNhat);
		docDuLieu();

		btn_load = new JButton("Làm mới");
		btn_load.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_load.setBackground(new Color(135, 206, 235));
		btn_load.setBounds(317, 611, 139, 53);
		String iconPath_load = "/images/loading.png";
		ImageIcon iconLoad = new ImageIcon(this.getClass().getResource(iconPath_load));
		Image scaledIconLoad = iconLoad.getImage().getScaledInstance(33, 33, Image.SCALE_SMOOTH);
		ImageIcon resizedIconLoad = new ImageIcon(scaledIconLoad);
		btn_load.setIcon(resizedIconLoad);
		add(btn_load);

		btn_capNhat.addActionListener(this);
		btn_timKiem.addActionListener(this);
		btn_them.addActionListener(this);
		btn_load.addActionListener(this);

		String[] items = { "Mã khách hàng", "Tên khách hàng", "Số điện thoại" };
		comboBox = new JComboBox<>(items);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(473, 21, 123, 44);
		add(comboBox);
	}

	public static void docDuLieu() {
		try {
			List<KhachHang> list = khDao.getAll();
			int i = 0;
			for (KhachHang khachHang : list) {
				// Tạo một mảng dữ liệu để chứa thông tin của khách hàng
				Object[] rowData = {

						khachHang.getMaKhachHang(), khachHang.getTenKhachHang(), khachHang.getSoDienThoai(),
						khachHang.getEmail(), khachHang.getDiaChi(), khachHang.isTrangThai() ? "Hoạt động" : "Nghỉ", // Chuyển
						(int) khachHang.getDiemTichLuy() };
				// Thêm dữ liệu vào model của bảng
				tableModel.addRow(rowData);

				// Tăng chỉ số
				i++;
			}
			for (int j = tableModel.getRowCount() - 1; j >= 0; j--) {
				String cellValue = (String) tableModel.getValueAt(j, 0);
				if (cellValue != null && cellValue.contains("KC")) {
					tableModel.removeRow(j);
				}
			}
			int rowIndexToHide = 0;
			tableModel.removeRow(rowIndexToHide);
			int rowIndexKH000 = 0;
			tableModel.removeRow(rowIndexKH000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btn_timKiem)) {
			String giatri = txt_timKiem.getText();
			String selectedSearchCriteria = (String) comboBox.getSelectedItem();
			if (giatri.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("images/warning.png"));
			} else {
				KhachHang khachHang = null;
				if (selectedSearchCriteria.equals("Mã khách hàng")) {
					clearTable();
					try {
						khachHang = khDao.timkiemKhachHangByMa(giatri);
					} catch (Exception e2) {
						// TODO: handle exception
					}
				} else if (selectedSearchCriteria.equals("Tên khách hàng")) {
					clearTable();
					try {
						khachHang = khDao.timkiemKhachHangBytenKH(giatri);
					} catch (Exception e2) {
						// TODO: handle exception
					}
				} else if (selectedSearchCriteria.equals("Số điện thoại")) {
					clearTable();
					try {
						khachHang = khDao.timkiemKhachHangBySDT(giatri);
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				try {
					// Kiểm tra xem khách hàng có tồn tại không
					if (khachHang != null) {
						// Hiển thị thông tin khách hàng trong text fields
						txt_makh.setText(khachHang.getMaKhachHang());
						txt_ten.setText(khachHang.getTenKhachHang());
						txt_sDT.setText(khachHang.getSoDienThoai().trim());
						txt_email.setText(khachHang.getEmail().trim());
						txt_diaChi.setText(khachHang.getDiaChi());
						txt_diemTichLuy.setText(String.valueOf(khachHang.getDiemTichLuy()));

						// Cài đặt thuộc tính selected của các nút radio btn_hoatDong và btn_nghi.
						if (khachHang.isTrangThai()) {
							btn_hoatDong.setSelected(false);
							btn_nghi.setSelected(true);
						} else {
							btn_hoatDong.setSelected(true);
							btn_nghi.setSelected(false);
						}

						// Hiển thị thông tin khách hàng trong bảng
						Object[] rowData = { khachHang.getMaKhachHang(), khachHang.getTenKhachHang(),
								khachHang.getSoDienThoai(), khachHang.getEmail(), khachHang.getDiaChi(),
								khachHang.isTrangThai() ? "Không còn thành viên" : "Còn thành viên", // Chuyển boolean thành chuỗi
								khachHang.getDiemTichLuy() };
//		                    int rowIndex = tableModel.getRowCount() - 1;  // Lấy chỉ số của dòng vừa thêm vào bảng
//		                    table.setRowSelectionInterval(rowIndex, rowIndex);
						// Thêm dữ liệu vào model của bảng
						tableModel.addRow(rowData);
					} else {
						JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng!", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} else if (obj.equals(btn_them)) {
			FromThemKhachHang fromThemKhachHang = new FromThemKhachHang();
			fromThemKhachHang.setVisible(true);
		} else if (obj.equals(btn_load)) {
			clearTable();
			docDuLieu();
		} else if (obj.equals(btn_capNhat)) {
			capNhatKhachHang();
		}
	}

	private void clearTable() {
		rowCount = tableModel.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}

	private void capNhatKhachHang() {
		if (kiemTraHople()) {
			KhachHang kh = layKhachHang();
			if (khDao.updateKhachHang(kh)) {
				JOptionPane.showMessageDialog(this, "Đã cập nhật thành công khách hàng: " + kh.getMaKhachHang());
			} else {
				JOptionPane.showMessageDialog(this, "Không thể cập nhật!!!");
			}
		}
	}

	public KhachHang layKhachHang() {
		String maKH = txt_makh.getText().trim();
		String tenKh = txt_ten.getText().trim();
		String sdt = txt_sDT.getText().trim();
		String email = txt_email.getText().trim();
		String diachi = txt_diaChi.getText().trim();
		boolean trangthai = false;
		if (btn_hoatDong.isSelected() && !btn_nghi.isSelected())
			trangthai = true;
		float diemTichLuy = Float.parseFloat(txt_diemTichLuy.getText());
		KhachHang khachHang = new KhachHang(maKH, sdt, tenKh, email, diachi, trangthai, diemTichLuy);
		return khachHang;
	}

	private boolean kiemTraHople() {
		String sdt = txt_sDT.getText().trim();
		String ten = txt_ten.getText().trim();
		String diem = txt_diemTichLuy.getText().trim();
		int lastSpace = ten.lastIndexOf(" ");
		String fistName = ten.substring(lastSpace + 1);
		if (!ten.matches("^[A-Z].*")) {
			JOptionPane.showMessageDialog(this, "Tên phải viết hoa ");
			return false;
		}
		// Kiểm tra các trường không được để trống
		if (txt_ten.getText().isEmpty() || txt_sDT.getText().isEmpty() || txt_email.getText().isEmpty()
				|| txt_diaChi.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
			return false; // Dừng hàm nếu có trường trống
		}
		if (!sdt.matches("0\\d{9}")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải có đúng 10 số bắt đầu là số 0!");
			return false;
		}
		if (!diem.matches("\\d+")) {
			JOptionPane.showMessageDialog(this, "Điểm tích luỹ phải là số!");
			return false;
		}

		String email = txt_email.getText().trim();
		if (!email.endsWith("@gmail.com")) {
			JOptionPane.showMessageDialog(this, "Email phải kết thúc bằng '@gmail.com'!");
			return false;
		}
		// Kiểm tra JRadioButton đã được chọn chưa
		if (!btn_hoatDong.isSelected() && !btn_nghi.isSelected()) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn trạng thái hoạt động hoặc nghỉ!");
			return false; // Dừng hàm nếu không có JRadioButton nào được chọn
		}
		return true;
	}

	private void loadDataIntoTable() {
		try {
			clearTable();
			docDuLieu();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static int getRowCount() {
		return rowCount = tableModel.getRowCount();
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