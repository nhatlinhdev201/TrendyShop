package gui.admin;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextPane;
import javax.swing.SingleSelectionModel;

import java.awt.SystemColor;

public class TK_ThongKeDoanhThuJPanel extends JPanel implements ActionListener{
	private JTextField txtTenNhanVienTimKiemTKDTNgay;
	private JTextField txtMaNhanVienTimKiemTKDTNgay;
	private JTable tblDsNhanVienNgay;
	private JTextField txtThongKeTrenTaiKhoanTKDTNgay;
	private JTextField txtTenNhanVienDuocThongKeTKDTNgay;
	private JTextField txtNgayDuocThongKeTKDTNgay;
	private JTextField txtTongDoanhThuTrongNgay;
	private JTextField txtTongTienNhapHangTrongNgay;
	private JTextField txtTongTienLaiTrongNgay;
	private JTextField txtTongThueTrongNgay;
	private JTextField txtTongTienKhuyenMaiTrongNgay;
	private JTextField txtTongSoHoaDonDuocLapTKDTNgay;
	private JTextField txtTongSoMatHangBanRaTKDTNgay;
	private JTextField txtTenNhanVienTimKiemTKDTThang;
	private JTextField txtMaNhanVienTimKiemTKDTThang;
	private JTextField txtThongKeTrenTaiKHoanTKDTThang;
	private JTextField txtTenNhanVienDuocThongKeTKDTThang;
	private JTextField txtTongDoangThuThang;
	private JTextField txtTongTienHangNhapTrongThang;
	private JTextField txtTongTienLaiTrongThang;
	private JTextField txtTongThueTrongThang;
	private JTextField txtTongTienKhuyenMaiTrongThang;
	private JTextField txtTongHoaDonDuocLapTKTThang;
	private JTextField txtTongSoMatHangBanRaTKDTThang;
	private JTextField txtNamCuaThangDuocTkTKDTThang;
	private JTextField txtThangDuocThangKeTKDTThang;
	private JTextField txtTenNhanVienTimKiemTKDTNam;
	private JTextField txtMaNhanVienTimKiemTKDTNam;
	private JTextField txtTaiKhoanDuocThongKeTKDTNam;
	private JTextField txtTenNhanVienDuocThongKeTKDTNam;
	private JTextField txtNamDuocThongKeTKDTNam;
	private JTextField txtTongDoanhThuNam;
	private JTextField txtTongTienNhaphangTrongNam;
	private JTextField txtTonglaiTrongNam;
	private JTextField txtTongThueTrongNam;
	private JTextField txtTongTienKhuyenmaiTrongNam;
	private JTextField txtTongHoaDonDuocLapTKDTNam;
	private JTextField txtTongSoLuongMatHangBanRaTKDTNam;
	private JCheckBox cbTatCaNhanVienNgay;
	private JButton btnTimKiemNhanVienTKDTNgay;
	private JTextPane txtNhanXetThongKeNgay;
	private JTextPane txtTenBieuDo1;
	private JButton btnTaoBaoCaoTkDoanhThuNgay;
	private JButton btnXuatDuLieuTkDoanhThuNgay;
	private JCheckBox cbTatCaNhanVienThang;
	private JButton btnTimNhanVienTKDTThang;
	private JButton btnChonNhanVienTTDTThang;
	private JComboBox cbxChonThangThongKeDT;
	private JComboBox cbxChonNamCuaThangThongKeDT;
	private JTextPane txtTenBieuDo2;
	private JButton btnTaoBaoCaoTKDTThang;
	private JButton btnXuatDuLieuTKDTThang;
	private JButton btnTimKiemNhanVienTKDTNam;
	private JButton btnChonNhanVienTKDTNam;
	private JComboBox cbxChonnamThongKeTKDTNam;
	private JTextPane txtNhanXetThoongKeNam;
	private JTextPane txtTenBieuDo3;
	private JButton btnTaoBaoCaoTkDoanhThuNam;
	private JButton btnXuatDuLieuTkDoanhThuNam;

	/**
	 * Create the panel.
	 */
	public TK_ThongKeDoanhThuJPanel(){
		this.setBounds(0, 0, 1350, 640);
		setLayout(null);
		
		JPanel panelCN_CNThongKeDoanhThu = new JPanel();
		panelCN_CNThongKeDoanhThu.setBounds(0, 0, 1350, 638);
		add(panelCN_CNThongKeDoanhThu);;
		panelCN_CNThongKeDoanhThu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ DOANH THU");
		lblNewLabel.setBounds(583, 0, 196, 25);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelCN_CNThongKeDoanhThu.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 1350, 661);
		panelCN_CNThongKeDoanhThu.add(tabbedPane);
		/*
		 * Table
		 * */
		//<==========================================================>
		JPanel panelTabThongKeTheoNgay = new JPanel();
		panelTabThongKeTheoNgay.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo ngày", null, panelTabThongKeTheoNgay, null);
		panelTabThongKeTheoNgay.setLayout(null);
		
		JPanel panelDuLieuThongKe = new JPanel();
		panelDuLieuThongKe.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDuLieuThongKe.setBounds(10, 11, 387, 579);
		panelTabThongKeTheoNgay.add(panelDuLieuThongKe);
		panelDuLieuThongKe.setLayout(null);
		
		JLabel lblThongKeNgay = new JLabel("Chọn thống kê ngày :");
		lblThongKeNgay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay.setBounds(22, 38, 137, 23);
		panelDuLieuThongKe.add(lblThongKeNgay);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1ECDn nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(0, 85, 382, 500);
		panelDuLieuThongKe.add(panel_3);
		panel_3.setLayout(null);
		
		cbTatCaNhanVienNgay = new JCheckBox("Tất cả nhân viên");
		cbTatCaNhanVienNgay.setBounds(207, 18, 145, 23);
		panel_3.add(cbTatCaNhanVienNgay);
		
		JLabel lblTimNVCanThongKe = new JLabel("Tìm nhân viên cần thống kê :");
		lblTimNVCanThongKe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimNVCanThongKe.setBounds(10, 21, 175, 14);
		panel_3.add(lblTimNVCanThongKe);
		
		JPanel panelBoLocTimKiem = new JPanel();
		panelBoLocTimKiem.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBoLocTimKiem.setBounds(10, 48, 362, 126);
		panel_3.add(panelBoLocTimKiem);
		panelBoLocTimKiem.setLayout(null);
		
		JLabel lblTenNVTimKiem = new JLabel("Tên nhân viên :");
		lblTenNVTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNVTimKiem.setBounds(10, 29, 108, 23);
		panelBoLocTimKiem.add(lblTenNVTimKiem);
		
		txtTenNhanVienTimKiemTKDTNgay = new JTextField();
		txtTenNhanVienTimKiemTKDTNgay.setColumns(10);
		txtTenNhanVienTimKiemTKDTNgay.setBounds(146, 30, 191, 22);
		panelBoLocTimKiem.add(txtTenNhanVienTimKiemTKDTNgay);
		
		txtMaNhanVienTimKiemTKDTNgay = new JTextField();
		txtMaNhanVienTimKiemTKDTNgay.setColumns(10);
		txtMaNhanVienTimKiemTKDTNgay.setBounds(146, 62, 191, 22);
		panelBoLocTimKiem.add(txtMaNhanVienTimKiemTKDTNgay);
		
		JLabel lblNVMaNhanVienTimKiem = new JLabel("Mã nhân viên");
		lblNVMaNhanVienTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem.setBounds(10, 61, 108, 23);
		panelBoLocTimKiem.add(lblNVMaNhanVienTimKiem);
		
		btnTimKiemNhanVienTKDTNgay = new JButton("Tìm kiếm");
		btnTimKiemNhanVienTKDTNgay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiemNhanVienTKDTNgay.setBounds(10, 87, 89, 23);
		panelBoLocTimKiem.add(btnTimKiemNhanVienTKDTNgay);
		
		JPanel panelBangNhanVienTKDTNgay = new JPanel();
		panelBangNhanVienTKDTNgay.setBorder(new TitledBorder(null, "Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelBangNhanVienTKDTNgay.setBounds(10, 175, 362, 277);
		panel_3.add(panelBangNhanVienTKDTNgay);
		panelBangNhanVienTKDTNgay.setLayout(new BorderLayout(0, 0));
		
		tblDsNhanVienNgay = new JTable();
		panelBangNhanVienTKDTNgay.add(tblDsNhanVienNgay, BorderLayout.CENTER);
		
		JButton btnChonNhanVienTKDTNgay = new JButton("Chọn");
		btnChonNhanVienTKDTNgay.setBounds(130, 457, 89, 23);
		panel_3.add(btnChonNhanVienTKDTNgay);
		
		JDateChooser jdcChonNgayThongKe = new JDateChooser();
		jdcChonNgayThongKe.setBounds(169, 38, 185, 23);
		panelDuLieuThongKe.add(jdcChonNgayThongKe);
		
		JPanel panelKetQuaThongKe = new JPanel();
		panelKetQuaThongKe.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "K\u1EBFt qu\u1EA3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelKetQuaThongKe.setBounds(407, 11, 523, 579);
		panelTabThongKeTheoNgay.add(panelKetQuaThongKe);
		panelKetQuaThongKe.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.PINK));
		panel.setBounds(35, 126, 451, 4);
		panelKetQuaThongKe.add(panel);
		
		JLabel lblTKTrenTaiKhoan = new JLabel("Thống kê trên tài khoản : ");
		lblTKTrenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTKTrenTaiKhoan.setBounds(67, 27, 166, 23);
		panelKetQuaThongKe.add(lblTKTrenTaiKhoan);
		
		txtThongKeTrenTaiKhoanTKDTNgay = new JTextField();
		txtThongKeTrenTaiKhoanTKDTNgay.setColumns(10);
		txtThongKeTrenTaiKhoanTKDTNgay.setBounds(269, 27, 182, 22);
		panelKetQuaThongKe.add(txtThongKeTrenTaiKhoanTKDTNgay);
		
		JLabel lblThongKeTheoTieuChi = new JLabel("Tên nhân viên : ");
		lblThongKeTheoTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi.setBounds(67, 61, 166, 23);
		panelKetQuaThongKe.add(lblThongKeTheoTieuChi);
		
		txtTenNhanVienDuocThongKeTKDTNgay = new JTextField();
		txtTenNhanVienDuocThongKeTKDTNgay.setColumns(10);
		txtTenNhanVienDuocThongKeTKDTNgay.setBounds(269, 61, 182, 22);
		panelKetQuaThongKe.add(txtTenNhanVienDuocThongKeTKDTNgay);
		
		txtNgayDuocThongKeTKDTNgay = new JTextField();
		txtNgayDuocThongKeTKDTNgay.setColumns(10);
		txtNgayDuocThongKeTKDTNgay.setBounds(269, 92, 182, 22);
		panelKetQuaThongKe.add(txtNgayDuocThongKeTKDTNgay);
		
		JLabel labNgayThongKe = new JLabel("Ngày được thống kê  : ");
		labNgayThongKe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labNgayThongKe.setBounds(67, 92, 166, 23);
		panelKetQuaThongKe.add(labNgayThongKe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA \u0111\u01B0\u1EE3c trong ng\u00E0y :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 137, 503, 272);
		panelKetQuaThongKe.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng doanh thu trong ngày  : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(29, 109, 206, 20);
		panel_1.add(lblNewLabel_1);
		
		txtTongDoanhThuTrongNgay = new JTextField();
		txtTongDoanhThuTrongNgay.setBounds(233, 109, 180, 20);
		panel_1.add(txtTongDoanhThuTrongNgay);
		txtTongDoanhThuTrongNgay.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("VND");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(423, 112, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tổng tiền nhập hàng : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(29, 136, 206, 20);
		panel_1.add(lblNewLabel_1_1);
		
		txtTongTienNhapHangTrongNgay = new JTextField();
		txtTongTienNhapHangTrongNgay.setColumns(10);
		txtTongTienNhapHangTrongNgay.setBounds(233, 137, 180, 20);
		panel_1.add(txtTongTienNhapHangTrongNgay);
		
		JLabel lblNewLabel_2_1 = new JLabel("VND");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(423, 140, 46, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tổng lãi trong ngày  : ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(29, 167, 206, 18);
		panel_1.add(lblNewLabel_1_2);
		
		txtTongTienLaiTrongNgay = new JTextField();
		txtTongTienLaiTrongNgay.setColumns(10);
		txtTongTienLaiTrongNgay.setBounds(233, 165, 180, 20);
		panel_1.add(txtTongTienLaiTrongNgay);
		
		JLabel lblNewLabel_2_2 = new JLabel("VND");
		lblNewLabel_2_2.setForeground(Color.RED);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(423, 168, 46, 14);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tổng thuế   : ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(29, 193, 206, 20);
		panel_1.add(lblNewLabel_1_3);
		
		txtTongThueTrongNgay = new JTextField();
		txtTongThueTrongNgay.setColumns(10);
		txtTongThueTrongNgay.setBounds(233, 193, 180, 20);
		panel_1.add(txtTongThueTrongNgay);
		
		JLabel lblNewLabel_2_3 = new JLabel("VND");
		lblNewLabel_2_3.setForeground(Color.RED);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(423, 196, 46, 14);
		panel_1.add(lblNewLabel_2_3);
		
		txtTongTienKhuyenMaiTrongNgay = new JTextField();
		txtTongTienKhuyenMaiTrongNgay.setColumns(10);
		txtTongTienKhuyenMaiTrongNgay.setBounds(233, 224, 180, 20);
		panel_1.add(txtTongTienKhuyenMaiTrongNgay);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Tổng tiền khuyến mãi : ");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1.setBounds(29, 224, 206, 20);
		panel_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("VND");
		lblNewLabel_2_3_1.setForeground(Color.RED);
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_1.setBounds(423, 227, 46, 14);
		panel_1.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tổng số hóa đơn được lập : ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(29, 40, 206, 20);
		panel_1.add(lblNewLabel_1_4);
		
		txtTongSoHoaDonDuocLapTKDTNgay = new JTextField();
		txtTongSoHoaDonDuocLapTKDTNgay.setColumns(10);
		txtTongSoHoaDonDuocLapTKDTNgay.setBounds(233, 40, 77, 20);
		panel_1.add(txtTongSoHoaDonDuocLapTKDTNgay);
		
		JLabel lblNewLabel_2_4 = new JLabel("Hóa đơn");
		lblNewLabel_2_4.setForeground(Color.RED);
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4.setBounds(320, 43, 69, 17);
		panel_1.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Mặt hàng");
		lblNewLabel_2_4_1.setForeground(Color.RED);
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4_1.setBounds(320, 74, 69, 17);
		panel_1.add(lblNewLabel_2_4_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Tổng số lượng mặt hàng bán ra :");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1.setBounds(29, 71, 206, 20);
		panel_1.add(lblNewLabel_1_4_1);
		
		txtTongSoMatHangBanRaTKDTNgay = new JTextField();
		txtTongSoMatHangBanRaTKDTNgay.setColumns(10);
		txtTongSoMatHangBanRaTKDTNgay.setBounds(233, 71, 77, 20);
		panel_1.add(txtTongSoMatHangBanRaTKDTNgay);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.PINK));
		panel_4.setBounds(35, 423, 451, 4);
		panelKetQuaThongKe.add(panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Nhận xét kết quả thống kê : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(13, 449, 194, 23);
		panelKetQuaThongKe.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("=>");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(10, 483, 31, 23);
		panelKetQuaThongKe.add(lblNewLabel_4);
		
		txtNhanXetThongKeNgay = new JTextPane();
		txtNhanXetThongKeNgay.setText("Tài khoản A còn 23 ngà để đạt doanh thu bằng với tháng trước đó là 999.999.999 VND. Tài khoản A còn 23 ngà để đạt doanh thu bằng với tháng trước đó là 999.999.999 VND.");
		txtNhanXetThongKeNgay.setBackground(SystemColor.menu);
		txtNhanXetThongKeNgay.setBounds(37, 486, 451, 48);
		panelKetQuaThongKe.add(txtNhanXetThongKeNgay);
		
		JPanel panelBieuDoThongKeNgay = new JPanel();
		panelBieuDoThongKeNgay.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBieuDoThongKeNgay.setBounds(940, 11, 395, 537);
		panelTabThongKeTheoNgay.add(panelBieuDoThongKeNgay);
		panelBieuDoThongKeNgay.setLayout(null);
		
		JPanel panelBieuDoThongKeDoanhThuNgay = new JPanel();
		panelBieuDoThongKeDoanhThuNgay.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeDoanhThuNgay.setBounds(10, 31, 375, 346);
		panelBieuDoThongKeNgay.add(panelBieuDoThongKeDoanhThuNgay);
		
		JPanel panelChuThichBieuDoThongKeDTNgay = new JPanel();
		panelChuThichBieuDoThongKeDTNgay.setBorder(new TitledBorder(null, "Ch\u00FA th\u00EDch : ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChuThichBieuDoThongKeDTNgay.setBackground(SystemColor.control);
		panelChuThichBieuDoThongKeDTNgay.setBounds(10, 447, 375, 68);
		panelBieuDoThongKeNgay.add(panelChuThichBieuDoThongKeDTNgay);
		
		txtTenBieuDo1 = new JTextPane();
		txtTenBieuDo1.setBackground(SystemColor.control);
		txtTenBieuDo1.setForeground(Color.RED);
		txtTenBieuDo1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtTenBieuDo1.setText("Biểu đồ thể hiện doanh thu bán hàng của tất cả nhân viên trong ngày");
		txtTenBieuDo1.setBounds(35, 382, 324, 36);
		panelBieuDoThongKeNgay.add(txtTenBieuDo1);
		StyledDocument doc1 = txtTenBieuDo1.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc1.setParagraphAttributes(0, doc1.getLength(), center, false);
		
		btnTaoBaoCaoTkDoanhThuNgay = new JButton("Tạo báo cáo");
		btnTaoBaoCaoTkDoanhThuNgay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTaoBaoCaoTkDoanhThuNgay.setBounds(1177, 559, 136, 30);
		panelTabThongKeTheoNgay.add(btnTaoBaoCaoTkDoanhThuNgay);
		
		btnXuatDuLieuTkDoanhThuNgay = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuTkDoanhThuNgay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuTkDoanhThuNgay.setBounds(950, 559, 174, 30);
		panelTabThongKeTheoNgay.add(btnXuatDuLieuTkDoanhThuNgay);
		
		
		
		
		//<=============================================================>
		JPanel panelTabThongKeTheoThang = new JPanel();
		panelTabThongKeTheoThang.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo tháng", null, panelTabThongKeTheoThang, null);
		panelTabThongKeTheoThang.setLayout(null);
		
		JPanel panelDuLieuThongKe_1 = new JPanel();
		panelDuLieuThongKe_1.setLayout(null);
		panelDuLieuThongKe_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDuLieuThongKe_1.setBounds(10, 11, 387, 579);
		panelTabThongKeTheoThang.add(panelDuLieuThongKe_1);
		
		JLabel lblThongKeNgay_1 = new JLabel("Chọn thống kê tháng :");
		lblThongKeNgay_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay_1.setBounds(20, 21, 137, 23);
		panelDuLieuThongKe_1.add(lblThongKeNgay_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1ECDn nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_1.setBounds(0, 85, 382, 500);
		panelDuLieuThongKe_1.add(panel_3_1);
		
		cbTatCaNhanVienThang = new JCheckBox("Tất cả nhân viên");
		cbTatCaNhanVienThang.setBounds(207, 18, 145, 23);
		panel_3_1.add(cbTatCaNhanVienThang);
		
		JLabel lblTimNVCanThongKe_1 = new JLabel("Tìm nhân viên cần thống kê :");
		lblTimNVCanThongKe_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimNVCanThongKe_1.setBounds(10, 21, 175, 14);
		panel_3_1.add(lblTimNVCanThongKe_1);
		
		JPanel panelBoLocTimKiem_1 = new JPanel();
		panelBoLocTimKiem_1.setLayout(null);
		panelBoLocTimKiem_1.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBoLocTimKiem_1.setBounds(10, 48, 362, 121);
		panel_3_1.add(panelBoLocTimKiem_1);
		
		JLabel lblTenNVTimKiem_1 = new JLabel("Tên nhân viên :");
		lblTenNVTimKiem_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNVTimKiem_1.setBounds(10, 29, 108, 23);
		panelBoLocTimKiem_1.add(lblTenNVTimKiem_1);
		
		txtTenNhanVienTimKiemTKDTThang = new JTextField();
		txtTenNhanVienTimKiemTKDTThang.setColumns(10);
		txtTenNhanVienTimKiemTKDTThang.setBounds(146, 30, 191, 22);
		panelBoLocTimKiem_1.add(txtTenNhanVienTimKiemTKDTThang);
		
		txtMaNhanVienTimKiemTKDTThang = new JTextField();
		txtMaNhanVienTimKiemTKDTThang.setColumns(10);
		txtMaNhanVienTimKiemTKDTThang.setBounds(146, 62, 191, 22);
		panelBoLocTimKiem_1.add(txtMaNhanVienTimKiemTKDTThang);
		
		JLabel lblNVMaNhanVienTimKiem_1 = new JLabel("Mã nhân viên");
		lblNVMaNhanVienTimKiem_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem_1.setBounds(10, 61, 108, 23);
		panelBoLocTimKiem_1.add(lblNVMaNhanVienTimKiem_1);
		
		btnTimNhanVienTKDTThang = new JButton("Tìm kiếm");
		btnTimNhanVienTKDTThang.setBounds(10, 87, 89, 23);
		panelBoLocTimKiem_1.add(btnTimNhanVienTKDTThang);
		
		JPanel panelBangNhanVienTKDTThang = new JPanel();
		panelBangNhanVienTKDTThang.setBorder(new TitledBorder(null, "Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelBangNhanVienTKDTThang.setBounds(10, 180, 362, 272);
		panel_3_1.add(panelBangNhanVienTKDTThang);
		panelBangNhanVienTKDTThang.setLayout(new BorderLayout(0, 0));
		
		btnChonNhanVienTTDTThang = new JButton("Chọn");
		btnChonNhanVienTTDTThang.setBounds(130, 457, 89, 23);
		panel_3_1.add(btnChonNhanVienTTDTThang);
		
		cbxChonThangThongKeDT = new JComboBox();
		cbxChonThangThongKeDT.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbxChonThangThongKeDT.setBounds(151, 22, 39, 22);
		panelDuLieuThongKe_1.add(cbxChonThangThongKeDT);
		
		JLabel lblNewLabel_5 = new JLabel("Năm :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(204, 23, 46, 19);
		panelDuLieuThongKe_1.add(lblNewLabel_5);
		
		cbxChonNamCuaThangThongKeDT = new JComboBox();
		cbxChonNamCuaThangThongKeDT.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "Viết hàm getYear[]"}));
		cbxChonNamCuaThangThongKeDT.setBounds(246, 22, 59, 22);
		panelDuLieuThongKe_1.add(cbxChonNamCuaThangThongKeDT);
		
		JPanel panelKetQuaThongKe_1 = new JPanel();
		panelKetQuaThongKe_1.setLayout(null);
		panelKetQuaThongKe_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "K\u1EBFt qu\u1EA3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelKetQuaThongKe_1.setBounds(407, 11, 523, 579);
		panelTabThongKeTheoThang.add(panelKetQuaThongKe_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.PINK));
		panel_2.setBounds(35, 126, 451, 4);
		panelKetQuaThongKe_1.add(panel_2);
		
		JLabel lblTKTrenTaiKhoan_1 = new JLabel("Thống kê trên tài khoản : ");
		lblTKTrenTaiKhoan_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTKTrenTaiKhoan_1.setBounds(67, 27, 166, 23);
		panelKetQuaThongKe_1.add(lblTKTrenTaiKhoan_1);
		
		txtThongKeTrenTaiKHoanTKDTThang = new JTextField();
		txtThongKeTrenTaiKHoanTKDTThang.setColumns(10);
		txtThongKeTrenTaiKHoanTKDTThang.setBounds(269, 27, 200, 22);
		panelKetQuaThongKe_1.add(txtThongKeTrenTaiKHoanTKDTThang);
		
		JLabel lblThongKeTheoTieuChi_1 = new JLabel("Tên nhân viên : ");
		lblThongKeTheoTieuChi_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi_1.setBounds(67, 61, 166, 23);
		panelKetQuaThongKe_1.add(lblThongKeTheoTieuChi_1);
		
		txtTenNhanVienDuocThongKeTKDTThang = new JTextField();
		txtTenNhanVienDuocThongKeTKDTThang.setColumns(10);
		txtTenNhanVienDuocThongKeTKDTThang.setBounds(269, 61, 200, 22);
		panelKetQuaThongKe_1.add(txtTenNhanVienDuocThongKeTKDTThang);
		
		JLabel labNgayThongKe_1 = new JLabel("Tháng được thống kê  : ");
		labNgayThongKe_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labNgayThongKe_1.setBounds(67, 92, 166, 23);
		panelKetQuaThongKe_1.add(labNgayThongKe_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA \u0111\u01B0\u1EE3c trong th\u00E1ng :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(10, 137, 503, 272);
		panelKetQuaThongKe_1.add(panel_1_1);
		
		JLabel lblNewLabel_1_5 = new JLabel("Tổng doanh thu trong tháng  : ");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(29, 109, 206, 20);
		panel_1_1.add(lblNewLabel_1_5);
		
		txtTongDoangThuThang = new JTextField();
		txtTongDoangThuThang.setColumns(10);
		txtTongDoangThuThang.setBounds(233, 109, 180, 20);
		panel_1_1.add(txtTongDoangThuThang);
		
		JLabel lblNewLabel_2_5 = new JLabel("VND");
		lblNewLabel_2_5.setForeground(Color.RED);
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_5.setBounds(423, 112, 46, 14);
		panel_1_1.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tổng tiền nhập hàng : ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(29, 136, 206, 20);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		txtTongTienHangNhapTrongThang = new JTextField();
		txtTongTienHangNhapTrongThang.setColumns(10);
		txtTongTienHangNhapTrongThang.setBounds(233, 137, 180, 20);
		panel_1_1.add(txtTongTienHangNhapTrongThang);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("VND");
		lblNewLabel_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(423, 140, 46, 14);
		panel_1_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tổng lãi trong tháng  : ");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(29, 167, 206, 18);
		panel_1_1.add(lblNewLabel_1_2_1);
		
		txtTongTienLaiTrongThang = new JTextField();
		txtTongTienLaiTrongThang.setColumns(10);
		txtTongTienLaiTrongThang.setBounds(233, 165, 180, 20);
		panel_1_1.add(txtTongTienLaiTrongThang);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("VND");
		lblNewLabel_2_2_1.setForeground(Color.RED);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(423, 168, 46, 14);
		panel_1_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Tổng thuế   : ");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_2.setBounds(29, 193, 206, 20);
		panel_1_1.add(lblNewLabel_1_3_2);
		
		txtTongThueTrongThang = new JTextField();
		txtTongThueTrongThang.setColumns(10);
		txtTongThueTrongThang.setBounds(233, 193, 180, 20);
		panel_1_1.add(txtTongThueTrongThang);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("VND");
		lblNewLabel_2_3_2.setForeground(Color.RED);
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_2.setBounds(423, 196, 46, 14);
		panel_1_1.add(lblNewLabel_2_3_2);
		
		txtTongTienKhuyenMaiTrongThang = new JTextField();
		txtTongTienKhuyenMaiTrongThang.setColumns(10);
		txtTongTienKhuyenMaiTrongThang.setBounds(233, 224, 180, 20);
		panel_1_1.add(txtTongTienKhuyenMaiTrongThang);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Tổng tiền khuyến mãi : ");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1_1.setBounds(29, 224, 206, 20);
		panel_1_1.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("VND");
		lblNewLabel_2_3_1_1.setForeground(Color.RED);
		lblNewLabel_2_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_1_1.setBounds(423, 227, 46, 14);
		panel_1_1.add(lblNewLabel_2_3_1_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Tổng số hóa đơn được lập : ");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_2.setBounds(29, 40, 206, 20);
		panel_1_1.add(lblNewLabel_1_4_2);
		
		txtTongHoaDonDuocLapTKTThang = new JTextField();
		txtTongHoaDonDuocLapTKTThang.setColumns(10);
		txtTongHoaDonDuocLapTKTThang.setBounds(233, 40, 77, 20);
		panel_1_1.add(txtTongHoaDonDuocLapTKTThang);
		
		JLabel lblNewLabel_2_4_2 = new JLabel("Hóa đơn");
		lblNewLabel_2_4_2.setForeground(Color.RED);
		lblNewLabel_2_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4_2.setBounds(320, 43, 69, 17);
		panel_1_1.add(lblNewLabel_2_4_2);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel("Mặt hàng");
		lblNewLabel_2_4_1_1.setForeground(Color.RED);
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4_1_1.setBounds(320, 74, 69, 17);
		panel_1_1.add(lblNewLabel_2_4_1_1);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Tổng số lượng mặt hàng bán ra :");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1_1.setBounds(29, 71, 206, 20);
		panel_1_1.add(lblNewLabel_1_4_1_1);
		
		txtTongSoMatHangBanRaTKDTThang = new JTextField();
		txtTongSoMatHangBanRaTKDTThang.setColumns(10);
		txtTongSoMatHangBanRaTKDTThang.setBounds(233, 71, 77, 20);
		panel_1_1.add(txtTongSoMatHangBanRaTKDTThang);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(new LineBorder(Color.PINK));
		panel_4_1.setBounds(35, 423, 451, 4);
		panelKetQuaThongKe_1.add(panel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nhận xét kết quả thống kê : ");
		lblNewLabel_3_1.setForeground(Color.RED);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3_1.setBounds(13, 449, 194, 23);
		panelKetQuaThongKe_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("=>");
		lblNewLabel_4_1.setForeground(Color.RED);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(10, 483, 31, 23);
		panelKetQuaThongKe_1.add(lblNewLabel_4_1);
		
		JTextPane txtNhanXetTKDTThang = new JTextPane();
		txtNhanXetTKDTThang.setText("Tài khoản A còn 23 ngà để đạt doanh thu bằng với tháng trước đó là 999.999.999 VND. Tài khoản A còn 23 ngà để đạt doanh thu bằng với tháng trước đó là 999.999.999 VND.");
		txtNhanXetTKDTThang.setBackground(SystemColor.menu);
		txtNhanXetTKDTThang.setBounds(37, 486, 451, 48);
		panelKetQuaThongKe_1.add(txtNhanXetTKDTThang);
		
		JLabel lblNewLabel_5_1 = new JLabel("Năm :");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(368, 95, 46, 19);
		panelKetQuaThongKe_1.add(lblNewLabel_5_1);
		
		txtNamCuaThangDuocTkTKDTThang = new JTextField();
		txtNamCuaThangDuocTkTKDTThang.setBounds(407, 94, 62, 20);
		panelKetQuaThongKe_1.add(txtNamCuaThangDuocTkTKDTThang);
		txtNamCuaThangDuocTkTKDTThang.setColumns(10);
		
		txtThangDuocThangKeTKDTThang = new JTextField();
		txtThangDuocThangKeTKDTThang.setColumns(10);
		txtThangDuocThangKeTKDTThang.setBounds(322, 94, 41, 20);
		panelKetQuaThongKe_1.add(txtThangDuocThangKeTKDTThang);
		
		JLabel lblNewLabel_6 = new JLabel("Tháng :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(269, 94, 46, 21);
		panelKetQuaThongKe_1.add(lblNewLabel_6);
		
		JPanel panelBieuDoThongKeNgay_1 = new JPanel();
		panelBieuDoThongKeNgay_1.setLayout(null);
		panelBieuDoThongKeNgay_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBieuDoThongKeNgay_1.setBounds(940, 11, 395, 537);
		panelTabThongKeTheoThang.add(panelBieuDoThongKeNgay_1);
		
		JPanel panelBieuDoThongKeDoanhThuThang = new JPanel();
		panelBieuDoThongKeDoanhThuThang.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeDoanhThuThang.setBounds(10, 31, 375, 346);
		panelBieuDoThongKeNgay_1.add(panelBieuDoThongKeDoanhThuThang);
		
		JPanel panelChuThichBieuDoTKDTThang = new JPanel();
		panelChuThichBieuDoTKDTThang.setBorder(new TitledBorder(null, "Ch\u00FA th\u00EDch : ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChuThichBieuDoTKDTThang.setBackground(SystemColor.menu);
		panelChuThichBieuDoTKDTThang.setBounds(10, 447, 375, 68);
		panelBieuDoThongKeNgay_1.add(panelChuThichBieuDoTKDTThang);
		
		
		txtTenBieuDo2 = new JTextPane();
		txtTenBieuDo2.setText("Biểu đồ thể hiện doanh thu bán hàng của tất cả nhân viên trong tháng");
		txtTenBieuDo2.setForeground(Color.RED);
		txtTenBieuDo2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtTenBieuDo2.setBackground(SystemColor.menu);
		txtTenBieuDo2.setBounds(35, 382, 324, 36);
		panelBieuDoThongKeNgay_1.add(txtTenBieuDo2);
		StyledDocument doc2 = txtTenBieuDo2.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc2.setParagraphAttributes(0, doc2.getLength(), center, false);
		
		btnTaoBaoCaoTKDTThang = new JButton("Tạo báo cáo");
		btnTaoBaoCaoTKDTThang.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTaoBaoCaoTKDTThang.setBounds(1177, 559, 136, 30);
		panelTabThongKeTheoThang.add(btnTaoBaoCaoTKDTThang);
		
		btnXuatDuLieuTKDTThang = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuTKDTThang.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuTKDTThang.setBounds(950, 559, 174, 30);
		panelTabThongKeTheoThang.add(btnXuatDuLieuTKDTThang);
		
		
		
		
		//<==================================================>
		JPanel panelTabThongKeTheoNam = new JPanel();
		panelTabThongKeTheoNam.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo năm", null, panelTabThongKeTheoNam, null);
		panelTabThongKeTheoNam.setLayout(null);
		
		JPanel panelDuLieuThongKe_2 = new JPanel();
		panelDuLieuThongKe_2.setLayout(null);
		panelDuLieuThongKe_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDuLieuThongKe_2.setBounds(10, 11, 387, 579);
		panelTabThongKeTheoNam.add(panelDuLieuThongKe_2);
		
		JLabel lblChnThngK = new JLabel("Chọn thống kê trong năm  :");
		lblChnThngK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblChnThngK.setBounds(23, 36, 178, 23);
		panelDuLieuThongKe_2.add(lblChnThngK);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1ECDn nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_2.setBounds(0, 85, 382, 500);
		panelDuLieuThongKe_2.add(panel_3_2);
		
		JCheckBox cbTatCaNhanVienTKDTNam = new JCheckBox("Tất cả nhân viên");
		cbTatCaNhanVienTKDTNam.setBounds(207, 18, 145, 23);
		panel_3_2.add(cbTatCaNhanVienTKDTNam);
		
		JLabel lblTimNVCanThongKe_2 = new JLabel("Tìm nhân viên cần thống kê :");
		lblTimNVCanThongKe_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimNVCanThongKe_2.setBounds(10, 21, 175, 14);
		panel_3_2.add(lblTimNVCanThongKe_2);
		
		JPanel panelBoLocTimKiem_2 = new JPanel();
		panelBoLocTimKiem_2.setLayout(null);
		panelBoLocTimKiem_2.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBoLocTimKiem_2.setBounds(10, 48, 362, 126);
		panel_3_2.add(panelBoLocTimKiem_2);
		
		JLabel lblTenNVTimKiem_2 = new JLabel("Tên nhân viên :");
		lblTenNVTimKiem_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNVTimKiem_2.setBounds(10, 29, 108, 23);
		panelBoLocTimKiem_2.add(lblTenNVTimKiem_2);
		
		txtTenNhanVienTimKiemTKDTNam = new JTextField();
		txtTenNhanVienTimKiemTKDTNam.setColumns(10);
		txtTenNhanVienTimKiemTKDTNam.setBounds(146, 30, 191, 22);
		panelBoLocTimKiem_2.add(txtTenNhanVienTimKiemTKDTNam);
		
		txtMaNhanVienTimKiemTKDTNam = new JTextField();
		txtMaNhanVienTimKiemTKDTNam.setColumns(10);
		txtMaNhanVienTimKiemTKDTNam.setBounds(146, 62, 191, 22);
		panelBoLocTimKiem_2.add(txtMaNhanVienTimKiemTKDTNam);
		
		JLabel lblNVMaNhanVienTimKiem_2 = new JLabel("Mã nhân viên");
		lblNVMaNhanVienTimKiem_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem_2.setBounds(10, 61, 108, 23);
		panelBoLocTimKiem_2.add(lblNVMaNhanVienTimKiem_2);
		
		btnTimKiemNhanVienTKDTNam = new JButton("Tìm kiếm");
		btnTimKiemNhanVienTKDTNam.setBounds(10, 87, 89, 23);
		panelBoLocTimKiem_2.add(btnTimKiemNhanVienTKDTNam);
		
		JPanel panelBangNhanVienTKDTNam = new JPanel();
		panelBangNhanVienTKDTNam.setBorder(new TitledBorder(null, "Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelBangNhanVienTKDTNam.setBounds(10, 175, 362, 277);
		panel_3_2.add(panelBangNhanVienTKDTNam);
		panelBangNhanVienTKDTNam.setLayout(new BorderLayout(0, 0));
		
		btnChonNhanVienTKDTNam = new JButton("Chọn");
		btnChonNhanVienTKDTNam.setBounds(130, 457, 89, 23);
		panel_3_2.add(btnChonNhanVienTKDTNam);
		
		cbxChonnamThongKeTKDTNam = new JComboBox();
		cbxChonnamThongKeTKDTNam.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023"}));;
		cbxChonnamThongKeTKDTNam.setBounds(193, 37, 71, 22);
		panelDuLieuThongKe_2.add(cbxChonnamThongKeTKDTNam);
		
		JPanel panelKetQuaThongKe_2 = new JPanel();
		panelKetQuaThongKe_2.setLayout(null);
		panelKetQuaThongKe_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "K\u1EBFt qu\u1EA3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelKetQuaThongKe_2.setBounds(407, 11, 523, 579);
		panelTabThongKeTheoNam.add(panelKetQuaThongKe_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(Color.PINK));
		panel_5.setBounds(35, 126, 451, 4);
		panelKetQuaThongKe_2.add(panel_5);
		
		JLabel lblTKTrenTaiKhoan_2 = new JLabel("Thống kê trên tài khoản : ");
		lblTKTrenTaiKhoan_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTKTrenTaiKhoan_2.setBounds(67, 27, 166, 23);
		panelKetQuaThongKe_2.add(lblTKTrenTaiKhoan_2);
		
		txtTaiKhoanDuocThongKeTKDTNam = new JTextField();
		txtTaiKhoanDuocThongKeTKDTNam.setColumns(10);
		txtTaiKhoanDuocThongKeTKDTNam.setBounds(269, 27, 182, 22);
		panelKetQuaThongKe_2.add(txtTaiKhoanDuocThongKeTKDTNam);
		
		JLabel lblThongKeTheoTieuChi_2 = new JLabel("Tên nhân viên : ");
		lblThongKeTheoTieuChi_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi_2.setBounds(67, 61, 166, 23);
		panelKetQuaThongKe_2.add(lblThongKeTheoTieuChi_2);
		
		txtTenNhanVienDuocThongKeTKDTNam = new JTextField();
		txtTenNhanVienDuocThongKeTKDTNam.setColumns(10);
		txtTenNhanVienDuocThongKeTKDTNam.setBounds(269, 61, 182, 22);
		panelKetQuaThongKe_2.add(txtTenNhanVienDuocThongKeTKDTNam);
		
		txtNamDuocThongKeTKDTNam = new JTextField();
		txtNamDuocThongKeTKDTNam.setColumns(10);
		txtNamDuocThongKeTKDTNam.setBounds(269, 92, 68, 22);
		panelKetQuaThongKe_2.add(txtNamDuocThongKeTKDTNam);
		
		JLabel lblNmcThng = new JLabel("Năm được thống kê  : ");
		lblNmcThng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNmcThng.setBounds(67, 92, 166, 23);
		panelKetQuaThongKe_2.add(lblNmcThng);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA \u0111\u01B0\u1EE3c trong n\u0103m :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2.setBounds(10, 137, 503, 272);
		panelKetQuaThongKe_2.add(panel_1_2);
		
		JLabel lblNewLabel_1_6 = new JLabel("Tổng doanh thu trong năm  : ");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_6.setBounds(29, 109, 206, 20);
		panel_1_2.add(lblNewLabel_1_6);
		
		txtTongDoanhThuNam = new JTextField();
		txtTongDoanhThuNam.setColumns(10);
		txtTongDoanhThuNam.setBounds(233, 109, 180, 20);
		panel_1_2.add(txtTongDoanhThuNam);
		
		JLabel lblNewLabel_2_6 = new JLabel("VND");
		lblNewLabel_2_6.setForeground(Color.RED);
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_6.setBounds(423, 112, 46, 14);
		panel_1_2.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Tổng tiền nhập hàng : ");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(29, 136, 206, 20);
		panel_1_2.add(lblNewLabel_1_1_2);
		
		txtTongTienNhaphangTrongNam = new JTextField();
		txtTongTienNhaphangTrongNam.setColumns(10);
		txtTongTienNhaphangTrongNam.setBounds(233, 137, 180, 20);
		panel_1_2.add(txtTongTienNhaphangTrongNam);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("VND");
		lblNewLabel_2_1_2.setForeground(Color.RED);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_2.setBounds(423, 140, 46, 14);
		panel_1_2.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Tổng lãi trong năm  : ");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_2.setBounds(29, 167, 206, 18);
		panel_1_2.add(lblNewLabel_1_2_2);
		
		txtTonglaiTrongNam = new JTextField();
		txtTonglaiTrongNam.setColumns(10);
		txtTonglaiTrongNam.setBounds(233, 165, 180, 20);
		panel_1_2.add(txtTonglaiTrongNam);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("VND");
		lblNewLabel_2_2_2.setForeground(Color.RED);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_2.setBounds(423, 168, 46, 14);
		panel_1_2.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("Tổng thuế   : ");
		lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_3.setBounds(29, 193, 206, 20);
		panel_1_2.add(lblNewLabel_1_3_3);
		
		txtTongThueTrongNam = new JTextField();
		txtTongThueTrongNam.setColumns(10);
		txtTongThueTrongNam.setBounds(233, 193, 180, 20);
		panel_1_2.add(txtTongThueTrongNam);
		
		JLabel lblNewLabel_2_3_3 = new JLabel("VND");
		lblNewLabel_2_3_3.setForeground(Color.RED);
		lblNewLabel_2_3_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_3.setBounds(423, 196, 46, 14);
		panel_1_2.add(lblNewLabel_2_3_3);
		
		txtTongTienKhuyenmaiTrongNam = new JTextField();
		txtTongTienKhuyenmaiTrongNam.setColumns(10);
		txtTongTienKhuyenmaiTrongNam.setBounds(233, 224, 180, 20);
		panel_1_2.add(txtTongTienKhuyenmaiTrongNam);
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("Tổng tiền khuyến mãi : ");
		lblNewLabel_1_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1_2.setBounds(29, 224, 206, 20);
		panel_1_2.add(lblNewLabel_1_3_1_2);
		
		JLabel lblNewLabel_2_3_1_2 = new JLabel("VND");
		lblNewLabel_2_3_1_2.setForeground(Color.RED);
		lblNewLabel_2_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_1_2.setBounds(423, 227, 46, 14);
		panel_1_2.add(lblNewLabel_2_3_1_2);
		
		JLabel lblNewLabel_1_4_3 = new JLabel("Tổng số hóa đơn được lập : ");
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_3.setBounds(29, 40, 206, 20);
		panel_1_2.add(lblNewLabel_1_4_3);
		
		txtTongHoaDonDuocLapTKDTNam = new JTextField();
		txtTongHoaDonDuocLapTKDTNam.setColumns(10);
		txtTongHoaDonDuocLapTKDTNam.setBounds(233, 40, 77, 20);
		panel_1_2.add(txtTongHoaDonDuocLapTKDTNam);
		
		JLabel lblNewLabel_2_4_3 = new JLabel("Hóa đơn");
		lblNewLabel_2_4_3.setForeground(Color.RED);
		lblNewLabel_2_4_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4_3.setBounds(320, 43, 69, 17);
		panel_1_2.add(lblNewLabel_2_4_3);
		
		JLabel lblNewLabel_2_4_1_2 = new JLabel("Mặt hàng");
		lblNewLabel_2_4_1_2.setForeground(Color.RED);
		lblNewLabel_2_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4_1_2.setBounds(320, 74, 69, 17);
		panel_1_2.add(lblNewLabel_2_4_1_2);
		
		JLabel lblNewLabel_1_4_1_2 = new JLabel("Tổng số lượng mặt hàng bán ra :");
		lblNewLabel_1_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1_2.setBounds(29, 71, 206, 20);
		panel_1_2.add(lblNewLabel_1_4_1_2);
		
		txtTongSoLuongMatHangBanRaTKDTNam = new JTextField();
		txtTongSoLuongMatHangBanRaTKDTNam.setColumns(10);
		txtTongSoLuongMatHangBanRaTKDTNam.setBounds(233, 71, 77, 20);
		panel_1_2.add(txtTongSoLuongMatHangBanRaTKDTNam);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBorder(new LineBorder(Color.PINK));
		panel_4_2.setBounds(35, 423, 451, 4);
		panelKetQuaThongKe_2.add(panel_4_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Nhận xét kết quả thống kê : ");
		lblNewLabel_3_2.setForeground(Color.RED);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3_2.setBounds(13, 449, 194, 23);
		panelKetQuaThongKe_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("=>");
		lblNewLabel_4_2.setForeground(Color.RED);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_2.setBounds(10, 483, 31, 23);
		panelKetQuaThongKe_2.add(lblNewLabel_4_2);
		
		txtNhanXetThoongKeNam = new JTextPane();
		txtNhanXetThoongKeNam.setText("Tài khoản A còn 23 ngà để đạt doanh thu bằng với tháng trước đó là 999.999.999 VND. Tài khoản A còn 23 ngà để đạt doanh thu bằng với tháng trước đó là 999.999.999 VND.");
		txtNhanXetThoongKeNam.setBackground(SystemColor.menu);
		txtNhanXetThoongKeNam.setBounds(37, 486, 451, 48);
		panelKetQuaThongKe_2.add(txtNhanXetThoongKeNam);
		
		JPanel panelBieuDoThongKeNgay_2 = new JPanel();
		panelBieuDoThongKeNgay_2.setLayout(null);
		panelBieuDoThongKeNgay_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBieuDoThongKeNgay_2.setBounds(940, 11, 395, 537);
		panelTabThongKeTheoNam.add(panelBieuDoThongKeNgay_2);
		
		JPanel panelBieuDoThongKeDoanhThuNam = new JPanel();
		panelBieuDoThongKeDoanhThuNam.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeDoanhThuNam.setBounds(10, 31, 375, 346);
		panelBieuDoThongKeNgay_2.add(panelBieuDoThongKeDoanhThuNam);
		
		JPanel panelChuThichBieuDoThongKeDTNam = new JPanel();
		panelChuThichBieuDoThongKeDTNam.setBorder(new TitledBorder(null, "Ch\u00FA th\u00EDch : ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChuThichBieuDoThongKeDTNam.setBackground(SystemColor.menu);
		panelChuThichBieuDoThongKeDTNam.setBounds(10, 447, 375, 68);
		panelBieuDoThongKeNgay_2.add(panelChuThichBieuDoThongKeDTNam);
		
		txtTenBieuDo3 = new JTextPane();
		txtTenBieuDo3.setText("Biểu đồ thể hiện doanh thu bán hàng của tất cả nhân viên trong 12 tháng của năm");
		txtTenBieuDo3.setForeground(Color.RED);
		txtTenBieuDo3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtTenBieuDo3.setBackground(SystemColor.menu);
		txtTenBieuDo3.setBounds(35, 382, 324, 36);
		panelBieuDoThongKeNgay_2.add(txtTenBieuDo3);
		StyledDocument doc3 = txtTenBieuDo3.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc3.setParagraphAttributes(0, doc3.getLength(), center, false);
		
		btnTaoBaoCaoTkDoanhThuNam = new JButton("Tạo báo cáo");
		btnTaoBaoCaoTkDoanhThuNam.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTaoBaoCaoTkDoanhThuNam.setBounds(1177, 559, 136, 30);
		panelTabThongKeTheoNam.add(btnTaoBaoCaoTkDoanhThuNam);
		
		btnXuatDuLieuTkDoanhThuNam = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuTkDoanhThuNam.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuTkDoanhThuNam.setBounds(950, 559, 174, 30);
		panelTabThongKeTheoNam.add(btnXuatDuLieuTkDoanhThuNam);
		
		//<====================================>
		btnTimKiemNhanVienTKDTNgay.addActionListener(this);
	}

	private ComboBoxModel DefaultComboBoxModel(String[] strings) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTimKiemNhanVienTKDTNgay)) {
			JOptionPane.showMessageDialog(this, "Ok fen");
		}
	}
}
