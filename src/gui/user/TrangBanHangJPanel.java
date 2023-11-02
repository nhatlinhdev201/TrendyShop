package gui.user;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constance.SetBountJPanel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class TrangBanHangJPanel extends JPanel {
	private LocalDate ngayLapHD = LocalDate.now();
	private JTextField txt_MaHangHoa;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TrangBanHangJPanel() {
		
		/*Thiết lập jpanel cho trang bán hàng*/
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		/*Tạo 2 button menu cho trang Quản lý bán hàng*/
		JPanel menu = new JPanel();
		menu.setBounds(0, 0, 1350, 43);
		add(menu);
		menu.setLayout(null);
		
		/*Button lập hóa đơn*/
		JButton btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		btnLapHoaDon.setBackground(new Color(39, 224, 224));
		btnLapHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLapHoaDon.setBounds(0, 0, 187, 43);
		menu.add(btnLapHoaDon);
		
//		Button tìm kiếm hóa đơn
		JButton btnTimHoaDon = new JButton("Tìm kiếm hóa đơn");
		btnTimHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		btnTimHoaDon.setBackground(new Color(255, 255, 255));
		btnTimHoaDon.setBounds(184, 0, 229, 43);
		menu.add(btnTimHoaDon);

		
//		Tạo panel Thông tin hóa đơn
		JPanel panel_ThongTinHoaDon = new JPanel();
		panel_ThongTinHoaDon.setBounds(0, 43, 529, 141);
		add(panel_ThongTinHoaDon);
		panel_ThongTinHoaDon.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		panel_ThongTinHoaDon.setLayout(null);
		
//		Label ngày nhập
//		Lấy ngày hiện tại là ngày lập hóa đơn
		JLabel lbl_NgayLap = new JLabel("Ngày lập: ");
		lbl_NgayLap.setFont(new Font("Arial", Font.PLAIN, 18));
		lbl_NgayLap.setBounds(20, 35, 109, 22);
		panel_ThongTinHoaDon.add(lbl_NgayLap);

		JLabel lbl_NgayLapHD = new JLabel(ngayLapHD.toString());
		lbl_NgayLapHD.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_NgayLapHD.setBounds(246, 36, 138, 23);
		panel_ThongTinHoaDon.add(lbl_NgayLapHD);

//		label nhân viên
//		lấy nhân viên là nhân đăng nhập vào trong hệ thống
//		do chưa có data nên tạm thời để mặc định là đặng thị quyền cơ
		JLabel lbl_NhanVien = new JLabel("Nhân viên:");
		lbl_NhanVien.setFont(new Font("Arial", Font.PLAIN, 18));
		lbl_NhanVien.setBounds(20, 83, 109, 22);
		panel_ThongTinHoaDon.add(lbl_NhanVien);

		JLabel lbl_NVLapHD = new JLabel("Đặng Thị Quyền Cơ");
		lbl_NVLapHD.setForeground(new Color(226, 41, 69));
		lbl_NVLapHD.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_NVLapHD.setBounds(246, 84, 152, 23);
		panel_ThongTinHoaDon.add(lbl_NVLapHD);
		
		
//		Tạo panel Nhập thông tin của mặt hàng được bán
		JPanel panel_NhapThongTinMatHang = new JPanel();
		panel_NhapThongTinMatHang.setBounds(0, 182, 529, 249);
		add(panel_NhapThongTinMatHang);
		panel_NhapThongTinMatHang.setBorder(BorderFactory.createTitledBorder("Nhập thông tin mặt hàng"));
		panel_NhapThongTinMatHang.setLayout(null);
		
//		Nhập mã hàng hóa, không được để rỗng
		JLabel lbl_MaHangHoa = new JLabel("Mã hàng hóa:");
		lbl_MaHangHoa.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_MaHangHoa.setBounds(21, 29, 157, 31);
		panel_NhapThongTinMatHang.add(lbl_MaHangHoa);
		
		txt_MaHangHoa = new JTextField();
		txt_MaHangHoa.setBounds(236, 29, 243, 31);
		panel_NhapThongTinMatHang.add(txt_MaHangHoa);
		txt_MaHangHoa.setColumns(10);
		
//		chọn kích thước cho hàng hóa
		JLabel lbl_KichThuoc = new JLabel("Kích thước:");
		lbl_KichThuoc.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_KichThuoc.setBounds(21, 82, 157, 31);
		panel_NhapThongTinMatHang.add(lbl_KichThuoc);
		
		JComboBox comboBox_KichThuoc = new JComboBox();
		comboBox_KichThuoc.setBounds(236, 83, 243, 29);
		panel_NhapThongTinMatHang.add(comboBox_KichThuoc);
		
		
//		2 nút thêm và refresh lại các jtextfield ở trên
//		Tìm hiểu phần button icon để tạo các nút
		JButton btn_LamMoi = new JButton("Làm mới");
		btn_LamMoi.setIcon(null);
		btn_LamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_LamMoi.setBounds(282, 148, 92, 41);
		panel_NhapThongTinMatHang.add(btn_LamMoi);
		
		JButton btn_Them = new JButton("Thêm");
		btn_Them.setBounds(384, 148, 92, 41);
		panel_NhapThongTinMatHang.add(btn_Them);
		
		
//		tạo panel nhập thông tin khách hàng và tiền nhận
		JPanel panel_KhachHangVaTienNhan = new JPanel();
		panel_KhachHangVaTienNhan.setBounds(0, 430, 529, 271);
		add(panel_KhachHangVaTienNhan);
		panel_KhachHangVaTienNhan.setLayout(null);
		panel_KhachHangVaTienNhan.setBorder(BorderFactory.createTitledBorder("Nhập thông tin khách hàng và tiền nhận"));
		
		JLabel lblNewLabel = new JLabel("Tên khách hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 30, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel);
		
		JLabel lbl_TenKhachHang = new JLabel("");
		lbl_TenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TenKhachHang.setBounds(241, 31, 219, 30);
		panel_KhachHangVaTienNhan.add(lbl_TenKhachHang);
		
		JLabel lblNewLabel_1 = new JLabel("SĐT:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 90, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(241, 92, 219, 31);
		panel_KhachHangVaTienNhan.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mã giảm giá:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 148, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(241, 150, 219, 31);
		panel_KhachHangVaTienNhan.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Tiền nhận:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 209, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(241, 211, 219, 31);
		panel_KhachHangVaTienNhan.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("...");
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setBounds(470, 30, 49, 31);
		panel_KhachHangVaTienNhan.add(btnNewButton);
		
		
//		Tạo panel table chưa danh sách các mặt hàng được bán
		JPanel panel_KhachHangVaTienNhan_1 = new JPanel();
		panel_KhachHangVaTienNhan_1.setBorder(BorderFactory.createTitledBorder("Danh sách mặt hàng được đặt mua"));
		panel_KhachHangVaTienNhan_1.setBounds(530, 43, 820, 409);
		add(panel_KhachHangVaTienNhan_1);
		panel_KhachHangVaTienNhan_1.setLayout(null);
		
//		Tạo panel Thông tin tổng tiền
		JPanel panel_KhachHangVaTienNhan_2 = new JPanel();
		panel_KhachHangVaTienNhan_2.setBorder(BorderFactory.createTitledBorder("Tính tổng tiền"));
		panel_KhachHangVaTienNhan_2.setBounds(700, 454, 600, 194);
		add(panel_KhachHangVaTienNhan_2);
		panel_KhachHangVaTienNhan_2.setLayout(null);
		
		JPanel panel_TongThanhTien = new JPanel();
		panel_TongThanhTien.setBackground(new Color(143, 211, 237));
		panel_TongThanhTien.setBounds(378, 20, 222, 159);
		panel_KhachHangVaTienNhan_2.add(panel_TongThanhTien);
		panel_TongThanhTien.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Tổng tiền trả:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.BOLD, 22));
		lblNewLabel_4.setBounds(31, 35, 181, 48);
		panel_TongThanhTien.add(lblNewLabel_4);
		
		JLabel lbl_TongTienTra = new JLabel("20.000.000");
		lbl_TongTienTra.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TongTienTra.setForeground(new Color(226, 41, 69));
		lbl_TongTienTra.setFont(new Font("Sitka Text", Font.BOLD, 29));
		lbl_TongTienTra.setBounds(0, 70, 181, 75);
		panel_TongThanhTien.add(lbl_TongTienTra);
		
		JLabel lblNewLabel_6 = new JLabel("VNĐ");
		lblNewLabel_6.setFont(new Font("Sitka Small", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(183, 94, 39, 31);
		panel_TongThanhTien.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("Tổng tiền hàng:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(22, 30, 169, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Thuế VAT (10%):");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(22, 70, 169, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Tổng tiền được giảm giá:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(22, 115, 169, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Tiền thừa:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(22, 155, 169, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_9);
		
		JLabel lbl_TongTienHang = new JLabel("0");
		lbl_TongTienHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TongTienHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TongTienHang.setBounds(189, 30, 150, 24);
		panel_KhachHangVaTienNhan_2.add(lbl_TongTienHang);
		
		JLabel lbl_Thue = new JLabel("0");
		lbl_Thue.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Thue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Thue.setBounds(189, 70, 150, 24);
		panel_KhachHangVaTienNhan_2.add(lbl_Thue);
		
		JLabel lbl_TienGiamGia = new JLabel("0");
		lbl_TienGiamGia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TienGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TienGiamGia.setBounds(189, 115, 150, 24);
		panel_KhachHangVaTienNhan_2.add(lbl_TienGiamGia);
		
		JLabel lbl_TienThua = new JLabel("0");
		lbl_TienThua.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TienThua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TienThua.setBounds(189, 155, 150, 24);
		panel_KhachHangVaTienNhan_2.add(lbl_TienThua);
		
		JLabel lblNewLabel_10 = new JLabel("VNĐ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(349, 30, 36, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("VNĐ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(349, 70, 36, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("VNĐ");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(349, 115, 36, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("VNĐ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(349, 155, 36, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_13);
		
		JButton btn_HuyHoaDon = new JButton("Hủy Hóa Đơn");
		btn_HuyHoaDon.setBackground(new Color(226, 41, 69));
		btn_HuyHoaDon.setFont(new Font("Verdana", Font.BOLD, 18));
		btn_HuyHoaDon.setBounds(530, 465, 163, 50);
		add(btn_HuyHoaDon);
		
		JButton btn_HangCho = new JButton("Hàng chờ");
		btn_HangCho.setBackground(new Color(245, 114, 27));
		btn_HangCho.setFont(new Font("Verdana", Font.BOLD, 18));
		btn_HangCho.setBounds(530, 526, 163, 50);
		add(btn_HangCho);
		
		JButton btn_ThanhToan = new JButton("Thanh toán");
		btn_ThanhToan.setBackground(new Color(34, 176, 45));
		btn_ThanhToan.setFont(new Font("Verdana", Font.BOLD, 18));
		btn_ThanhToan.setBounds(530, 587, 163, 50);
		add(btn_ThanhToan);

	}
}
