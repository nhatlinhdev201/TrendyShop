package gui.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class TrangQLNhanVienJPanel extends JPanel {
	private static final Font TABLE_FONT = new Font("Tahoma", Font.PLAIN, 15);
	private static DefaultTableModel tableModel;
	static Dao_NhanVien nvDao = new Dao_NhanVien();
	private JLabel label_anh;
	private JTextField textField_maNV;
	private JTextField textField_ten;
	private JTextField textField_ngaySinh;
	private JTextField textField_diachi;
	private JTextField textField_cccd;
	private JTextField textField_sdt;
	private JTextField textField_email;
	private JTextField textField_12;
	private JRadioButton btn_nghi;
	private JRadioButton btn_hoatDong;
	private JFrame parentFrame;
	/**
	 * Create the panel.
	 */
	public TrangQLNhanVienJPanel() {
		setBackground(new Color(127, 255, 212));
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		this.parentFrame = parentFrame;
		
		JTable table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));

		// Tạo font mới với kích cỡ chữ là 20 cho tiêu đề cột
		Font headerFont = new Font("Tahoma", Font.BOLD, 15);

		tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Mã NV", "Tên NV",
				"Ngày sinh","Số CCCD","SDT","Email", "Địa chỉ", "Trạng thái","Images" }) {
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
						String maNV= (String) table.getValueAt(selectedRow, 0);
						String tenNV = (String) table.getValueAt(selectedRow, 1);
						String ngaySinh = (String) table.getValueAt(selectedRow, 2);
						String soCCCD = (String) table.getValueAt(selectedRow, 3);
						String soDienThoai = (String) table.getValueAt(selectedRow, 4);
						String email = (String) table.getValueAt(selectedRow, 5);
						String diaChi = (String) (table.getValueAt(selectedRow, 6));
						String trangThai = (String)table.getValueAt(selectedRow, 7);
						String hinhAnh = (String)table.getValueAt(selectedRow, 8);

						// Display data in text fields
						textField_maNV.setText(maNV.trim());
						textField_cccd.setText(soCCCD.trim());
						textField_ten.setText(tenNV.trim());
						textField_ngaySinh.setText(ngaySinh);
						textField_sdt.setText(soDienThoai.trim());
						textField_email.setText(email.trim());
						textField_diachi.setText(diaChi.trim());
						ImageIcon icon = new ImageIcon(this.getClass().getResource(hinhAnh.trim())); // Sử dụng getResource để lấy đường dẫn từ resources của ứng dụng
						Image scaledIcon = icon.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
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
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 319, 1330, 371);
		add(scrollPane);
		
		JLabel lbl_manv = new JLabel("Mã nhân viên :");
		lbl_manv.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_manv.setBounds(464, 99, 123, 21);
		add(lbl_manv);
		
		textField_maNV = new JTextField();
		textField_maNV.setColumns(10);
		textField_maNV.setBounds(589, 97, 177, 25);
		add(textField_maNV);
		
		JLabel lbl_tennv = new JLabel("Họ tên :");
		lbl_tennv.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_tennv.setBounds(464, 142, 123, 21);
		add(lbl_tennv);
		
		textField_ten = new JTextField();
		textField_ten.setColumns(10);
		textField_ten.setBounds(589, 140, 177, 25);
		add(textField_ten);
		
		JLabel lbl_Dfb = new JLabel("Ngày sinh :");
		lbl_Dfb.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_Dfb.setBounds(812, 142, 123, 21);
		add(lbl_Dfb);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(937, 140, 177, 25);
		add(textField_ngaySinh);
		
		JLabel lbl_diachi = new JLabel("Đại chỉ :");
		lbl_diachi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_diachi.setBounds(812, 99, 123, 21);
		add(lbl_diachi);
		
		textField_diachi = new JTextField();
		textField_diachi.setColumns(10);
		textField_diachi.setBounds(937, 97, 177, 25);
		add(textField_diachi);
		
		JLabel lbl_makh_6 = new JLabel("Số CCCD :");
		lbl_makh_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_makh_6.setBounds(812, 178, 123, 21);
		add(lbl_makh_6);
		
		textField_cccd = new JTextField();
		textField_cccd.setColumns(10);
		textField_cccd.setBounds(937, 176, 177, 25);
		add(textField_cccd);
		
		JLabel lbl_trangThai = new JLabel("Trang thái :");
		lbl_trangThai.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_trangThai.setBounds(812, 212, 123, 21);
		add(lbl_trangThai);
		
		JLabel lbl_sdt = new JLabel("Số điện thoại :");
		lbl_sdt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_sdt.setBounds(464, 178, 123, 21);
		add(lbl_sdt);
		
		textField_sdt = new JTextField();
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(589, 176, 177, 25);
		add(textField_sdt);
		
		JLabel lbl_email = new JLabel("Email :");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_email.setBounds(464, 212, 123, 21);
		add(lbl_email);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(589, 210, 177, 25);
		add(textField_email);
		
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
		textField_12.setBounds(593, 275, 222, 33);
		add(textField_12);
		
		label_anh = new JLabel("");
		label_anh.setIcon(new ImageIcon(TrangQLNhanVienJPanel.class.getResource("/images/picture.png")));
		label_anh.setBounds(139, 50, 263, 248);
		add(label_anh);
		
		btn_hoatDong = new JRadioButton("Hoạt động");
		btn_hoatDong.setBackground(new Color(127, 255, 212));
		btn_hoatDong.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_hoatDong.setBounds(930, 210, 102, 23);
		add(btn_hoatDong);
		
		
		btn_nghi = new JRadioButton("Đã nghỉ");
		btn_nghi.setBackground(new Color(127, 255, 212));
		btn_nghi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_nghi.setBounds(1034, 210, 83, 23);
		add(btn_nghi);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin nhân viên\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_1.setBounds(517, 11, 497, 43);
		add(lblNewLabel_1);
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

						nv.getMaNhanVien(), nv.getHoTen(), ngaySinhFormatted,nv.getSoCCCD(),nv.getSoDienThoai(),
						nv.getEmail(), nv.getDiaChi(), nv.isTrangThai() ? "Hoạt động" : "Nghỉ" // Chuyển boolean thành chuỗi
						,nv.getAnhDaiDien() };
				// Thêm dữ liệu vào model của bảng
				tableModel.addRow(rowData);

				// Tăng chỉ số
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
