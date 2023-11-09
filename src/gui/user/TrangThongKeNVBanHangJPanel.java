package gui.user;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constance.SetBountJPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class TrangThongKeNVBanHangJPanel extends JPanel implements ActionListener{
	private JTextField txtThongKeTrenTaiKhoanNgay;
	private JTextField txtTenNhanVienThongKeNgay;
	private JTextField txtNgayDuocThongKeNgay;
	private JTextField txtTongDoanhThuNgay;
	private JTextField txtTongTienHangNhapNgay;
	private JTextField txtTongTienLaiTrongNgay;
	private JTextField txtTongThueNgay;
	private JTextField txtTongTienKhuyenMaiNgay;
	private JTextField txtTongSoHoaDonDuocLapNgay;
	private JTextField txtTongSoLuongMatHangBanRaNgay;
	private JTextField txtTaiKhoanDuocThongKeThang;
	private JTextField txtTenNhanVienDuocThongKeThang;
	private JTextField txtThangDuocThongKe;
	private JTextField txtTongDoanhThuTrongThnag;
	private JTextField txtTongTienNhapHangTrongThang;
	private JTextField txtTongTienLaiTrongThang;
	private JTextField txtTongThueTrongThang;
	private JTextField txtTongTienKhuenMaiTrongThang;
	private JTextField txtTongSoHoaDonDuocLapTrongThang;
	private JTextField txtTongSoLuongMatHangBanRaTrongThang;
	private JTextField txtTaiKhoanDuocThongKe;
	private JTextField txtTenNhanVienDuocThongKe;
	private JTextField txtNamDuocThongKe;
	private JTextField txtTongDoanhThuNam;
	private JTextField txtTongTienNhapHangNam;
	private JTextField txtTongTienLaiNam;
	private JTextField txtTongThueNam;
	private JTextField txtTongTienKhuyenMaiNam;
	private JTextField txtTongSoHoaDonDuocLapNam;
	private JTextField txtTongSoLuongMatHangBanRaTrongNam;
	private JButton btnThongKeNgay;
	private JButton btnLamMoiThongKeNgay;
	private JButton btnTaoBaoCaoNgay;
	private JButton btnXuatDuLieuNgay;
	private JButton btnLamMoiThongKeThang;
	private JButton btnThongKeThang;
	private JButton btnXuatDuLieuThang;
	private JButton btnTaoBaoCaoThang;
	private JButton btnLamMoiThongKeNam;
	private JButton btnThongKeNam;
	private JButton btnXuatDuLieuNam;
	private JButton btnTaoBaoCaoNam;
	private JDateChooser jdcChonNgayThongKe;

	/**
	 * Create the panel.
	 */
	public TrangThongKeNVBanHangJPanel() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("THỐNG KÊ DOANH THU");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(579, 11, 196, 25);
		add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 29, 1350, 672);
		add(tabbedPane);

		JPanel panelTabThongKeTheoNgay = new JPanel();
		panelTabThongKeTheoNgay.setLayout(null);
		panelTabThongKeTheoNgay.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo ngày", null, panelTabThongKeTheoNgay, null);

		JPanel panelKetQuaThongKe = new JPanel();
		panelKetQuaThongKe.setLayout(null);
		panelKetQuaThongKe.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelKetQuaThongKe.setBounds(10, 11, 540, 622);
		panelTabThongKeTheoNgay.add(panelKetQuaThongKe);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.PINK));
		panel.setBounds(35, 262, 451, 4);
		panelKetQuaThongKe.add(panel);

		JLabel  lblTKTrenTaiKhoan = new JLabel("Thống kê trên tài khoản : ");
		lblTKTrenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTKTrenTaiKhoan.setBounds(67, 163, 166, 23);
		panelKetQuaThongKe.add(lblTKTrenTaiKhoan);

		txtThongKeTrenTaiKhoanNgay = new JTextField();
		txtThongKeTrenTaiKhoanNgay.setEditable(false);
		txtThongKeTrenTaiKhoanNgay.setColumns(10);
		txtThongKeTrenTaiKhoanNgay.setBounds(269, 163, 182, 22);
		panelKetQuaThongKe.add(txtThongKeTrenTaiKhoanNgay);

		JLabel lblThongKeTheoTieuChi = new JLabel("Tên nhân viên : ");
		lblThongKeTheoTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi.setBounds(67, 197, 166, 23);
		panelKetQuaThongKe.add(lblThongKeTheoTieuChi);

		txtTenNhanVienThongKeNgay = new JTextField();
		txtTenNhanVienThongKeNgay.setEditable(false);
		txtTenNhanVienThongKeNgay.setColumns(10);
		txtTenNhanVienThongKeNgay.setBounds(269, 197, 182, 22);
		panelKetQuaThongKe.add(txtTenNhanVienThongKeNgay);

		txtNgayDuocThongKeNgay = new JTextField();
		txtNgayDuocThongKeNgay.setEditable(false);
		txtNgayDuocThongKeNgay.setColumns(10);
		txtNgayDuocThongKeNgay.setBounds(269, 228, 182, 22);
		panelKetQuaThongKe.add(txtNgayDuocThongKeNgay);

		JLabel labNgayThongKe = new JLabel("Ngày được thống kê  : ");
		labNgayThongKe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labNgayThongKe.setBounds(67, 228, 166, 23);
		panelKetQuaThongKe.add(labNgayThongKe);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(
				new TitledBorder(null, "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA \u0111\u01B0\u1EE3c trong ng\u00E0y :",

						TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 273, 503, 272);
		panelKetQuaThongKe.add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Tổng doanh thu trong ngày  : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(29, 109, 206, 20);
		panel_1.add(lblNewLabel_1);

		txtTongDoanhThuNgay = new JTextField();
		txtTongDoanhThuNgay.setEditable(false);
		txtTongDoanhThuNgay.setColumns(10);
		txtTongDoanhThuNgay.setBounds(233, 109, 180, 20);
		panel_1.add(txtTongDoanhThuNgay);

		JLabel lblNewLabel_2 = new JLabel("VND");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(423, 112, 46, 14);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Tổng tiền nhập hàng : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(29, 136, 206, 20);
		panel_1.add(lblNewLabel_1_1);

		txtTongTienHangNhapNgay = new JTextField();
		txtTongTienHangNhapNgay.setEditable(false);
		txtTongTienHangNhapNgay.setColumns(10);
		txtTongTienHangNhapNgay.setBounds(233, 137, 180, 20);
		panel_1.add(txtTongTienHangNhapNgay);

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
		txtTongTienLaiTrongNgay.setEditable(false);
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

		txtTongThueNgay = new JTextField();
		txtTongThueNgay.setEditable(false);
		txtTongThueNgay.setColumns(10);
		txtTongThueNgay.setBounds(233, 193, 180, 20);
		panel_1.add(txtTongThueNgay);

		JLabel lblNewLabel_2_3 = new JLabel("VND");
		lblNewLabel_2_3.setForeground(Color.RED);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(423, 196, 46, 14);
		panel_1.add(lblNewLabel_2_3);

		txtTongTienKhuyenMaiNgay = new JTextField();
		txtTongTienKhuyenMaiNgay.setEditable(false);
		txtTongTienKhuyenMaiNgay.setColumns(10);
		txtTongTienKhuyenMaiNgay.setBounds(233, 224, 180, 20);
		panel_1.add(txtTongTienKhuyenMaiNgay);

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

		txtTongSoHoaDonDuocLapNgay = new JTextField();
		txtTongSoHoaDonDuocLapNgay.setEditable(false);
		txtTongSoHoaDonDuocLapNgay.setColumns(10);
		txtTongSoHoaDonDuocLapNgay.setBounds(233, 40, 77, 20);
		panel_1.add(txtTongSoHoaDonDuocLapNgay);

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

		txtTongSoLuongMatHangBanRaNgay = new JTextField();
		txtTongSoLuongMatHangBanRaNgay.setEditable(false);
		txtTongSoLuongMatHangBanRaNgay.setColumns(10);
		txtTongSoLuongMatHangBanRaNgay.setBounds(233, 71, 77, 20);
		panel_1.add(txtTongSoLuongMatHangBanRaNgay);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.PINK));
		panel_4.setBounds(35, 423, 451, 4);
		panelKetQuaThongKe.add(panel_4);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.PINK));
		panel_3.setBounds(35, 148, 451, 4);
		panelKetQuaThongKe.add(panel_3);

		JPanel panelDuLieuThongKe = new JPanel();
		panelDuLieuThongKe.setLayout(null);
		panelDuLieuThongKe.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,

				new Color(0, 0, 0)));
		panelDuLieuThongKe.setBounds(10, 11, 503, 61);
		panelKetQuaThongKe.add(panelDuLieuThongKe);

		JLabel lblThongKeNgay = new JLabel("Chọn thống kê ngày :");
		lblThongKeNgay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay.setBounds(50, 23, 137, 23);
		panelDuLieuThongKe.add(lblThongKeNgay);

		jdcChonNgayThongKe = new JDateChooser();
		jdcChonNgayThongKe.setBounds(197, 23, 185, 23);
		panelDuLieuThongKe.add(jdcChonNgayThongKe);

		btnThongKeNgay = new JButton("Thống kê");
		btnThongKeNgay.setBounds(161, 83, 89, 31);
		panelKetQuaThongKe.add(btnThongKeNgay);
		
		btnLamMoiThongKeNgay = new JButton("Làm mới");
		btnLamMoiThongKeNgay.setBounds(274, 83, 89, 31);
		panelKetQuaThongKe.add(btnLamMoiThongKeNgay);

		JPanel panelBieuDoThongKeNgay = new JPanel();
		panelBieuDoThongKeNgay.setLayout(null);
		panelBieuDoThongKeNgay.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,

				new Color(0, 0, 0)));
		panelBieuDoThongKeNgay.setBounds(560, 11, 775, 561);
		panelTabThongKeTheoNgay.add(panelBieuDoThongKeNgay);

		JPanel panelBieuDoThongKeTheoNgay = new JPanel();
		panelBieuDoThongKeTheoNgay.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeTheoNgay.setBounds(10, 31, 755, 346);
		panelBieuDoThongKeNgay.add(panelBieuDoThongKeTheoNgay);

		JPanel panelChuThichBieuDoThongKeNgay = new JPanel();
		panelChuThichBieuDoThongKeNgay.setBorder(
				new TitledBorder(null, "Ch\u00FA th\u00EDch : ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChuThichBieuDoThongKeNgay.setBackground(SystemColor.menu);
		panelChuThichBieuDoThongKeNgay.setBounds(10, 447, 755, 103);
		panelBieuDoThongKeNgay.add(panelChuThichBieuDoThongKeNgay);

		JTextPane txtTenBieuDo1 = new JTextPane();
		txtTenBieuDo1.setText("Biểu đồ thể hiện doanh thu bán hàng của tất cả nhân viên trong 10 ngày qua");
		txtTenBieuDo1.setForeground(Color.RED);
		txtTenBieuDo1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtTenBieuDo1.setBackground(SystemColor.menu);
		txtTenBieuDo1.setBounds(35, 382, 677, 36);
		panelBieuDoThongKeNgay.add(txtTenBieuDo1);

		btnTaoBaoCaoNgay = new JButton("Tạo báo cáo");
		btnTaoBaoCaoNgay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTaoBaoCaoNgay.setBounds(1004, 583, 136, 30);
		panelTabThongKeTheoNgay.add(btnTaoBaoCaoNgay);

		btnXuatDuLieuNgay = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuNgay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuNgay.setBounds(623, 583, 174, 30);
		panelTabThongKeTheoNgay.add(btnXuatDuLieuNgay);

		JPanel panelTabThongKeTheoThang = new JPanel();
		panelTabThongKeTheoThang.setLayout(null);
		panelTabThongKeTheoThang.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo tháng", null, panelTabThongKeTheoThang, null);

		JPanel panelKetQuaThongKe_1 = new JPanel();
		panelKetQuaThongKe_1.setLayout(null);
		panelKetQuaThongKe_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelKetQuaThongKe_1.setBounds(10, 11, 540, 622);
		panelTabThongKeTheoThang.add(panelKetQuaThongKe_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.PINK));
		panel_2.setBounds(35, 262, 451, 4);
		panelKetQuaThongKe_1.add(panel_2);

		JLabel lblTKTrenTaiKhoan_1 = new JLabel("Thống kê trên tài khoản : ");
		lblTKTrenTaiKhoan_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTKTrenTaiKhoan_1.setBounds(67, 163, 166, 23);
		panelKetQuaThongKe_1.add(lblTKTrenTaiKhoan_1);

		txtTaiKhoanDuocThongKeThang = new JTextField();
		txtTaiKhoanDuocThongKeThang.setEditable(false);
		txtTaiKhoanDuocThongKeThang.setColumns(10);
		txtTaiKhoanDuocThongKeThang.setBounds(269, 163, 182, 22);
		panelKetQuaThongKe_1.add(txtTaiKhoanDuocThongKeThang);

		JLabel lblThongKeTheoTieuChi_1 = new JLabel("Tên nhân viên : ");
		lblThongKeTheoTieuChi_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi_1.setBounds(67, 197, 166, 23);
		panelKetQuaThongKe_1.add(lblThongKeTheoTieuChi_1);

		txtTenNhanVienDuocThongKeThang = new JTextField();
		txtTenNhanVienDuocThongKeThang.setEditable(false);
		txtTenNhanVienDuocThongKeThang.setColumns(10);
		txtTenNhanVienDuocThongKeThang.setBounds(269, 197, 182, 22);
		panelKetQuaThongKe_1.add(txtTenNhanVienDuocThongKeThang);

		txtThangDuocThongKe = new JTextField();
		txtThangDuocThongKe.setEditable(false);
		txtThangDuocThongKe.setColumns(10);
		txtThangDuocThongKe.setBounds(269, 228, 182, 22);
		panelKetQuaThongKe_1.add(txtThangDuocThongKe);

		JLabel labNgayThongKe_1 = new JLabel("Tháng được thống kê  : ");
		labNgayThongKe_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labNgayThongKe_1.setBounds(67, 228, 166, 23);
		panelKetQuaThongKe_1.add(labNgayThongKe_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(
				new TitledBorder(null, "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA \u0111\u01B0\u1EE3c trong ng\u00E0y :",

						TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(10, 273, 503, 272);
		panelKetQuaThongKe_1.add(panel_1_1);

		JLabel lblNewLabel_1_5 = new JLabel("Tổng doanh thu trong tháng  : ");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(29, 109, 206, 20);
		panel_1_1.add(lblNewLabel_1_5);

		txtTongDoanhThuTrongThnag = new JTextField();
		txtTongDoanhThuTrongThnag.setEditable(false);
		txtTongDoanhThuTrongThnag.setColumns(10);
		txtTongDoanhThuTrongThnag.setBounds(233, 109, 180, 20);
		panel_1_1.add(txtTongDoanhThuTrongThnag);

		JLabel lblNewLabel_2_5 = new JLabel("VND");
		lblNewLabel_2_5.setForeground(Color.RED);
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_5.setBounds(423, 112, 46, 14);
		panel_1_1.add(lblNewLabel_2_5);

		JLabel lblNewLabel_1_1_1 = new JLabel("Tổng tiền nhập hàng : ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(29, 136, 206, 20);
		panel_1_1.add(lblNewLabel_1_1_1);

		txtTongTienNhapHangTrongThang = new JTextField();
		txtTongTienNhapHangTrongThang.setEditable(false);
		txtTongTienNhapHangTrongThang.setColumns(10);
		txtTongTienNhapHangTrongThang.setBounds(233, 137, 180, 20);
		panel_1_1.add(txtTongTienNhapHangTrongThang);

		JLabel lblNewLabel_2_1_1 = new JLabel("VND");
		lblNewLabel_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(423, 140, 46, 14);
		panel_1_1.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("Tổng lãi trong ngày  : ");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(29, 167, 206, 18);
		panel_1_1.add(lblNewLabel_1_2_1);

		txtTongTienLaiTrongThang = new JTextField();
		txtTongTienLaiTrongThang.setEditable(false);
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
		txtTongThueTrongThang.setEditable(false);
		txtTongThueTrongThang.setColumns(10);
		txtTongThueTrongThang.setBounds(233, 193, 180, 20);
		panel_1_1.add(txtTongThueTrongThang);

		JLabel lblNewLabel_2_3_2 = new JLabel("VND");
		lblNewLabel_2_3_2.setForeground(Color.RED);
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_2.setBounds(423, 196, 46, 14);
		panel_1_1.add(lblNewLabel_2_3_2);

		txtTongTienKhuenMaiTrongThang = new JTextField();
		txtTongTienKhuenMaiTrongThang.setEditable(false);
		txtTongTienKhuenMaiTrongThang.setColumns(10);
		txtTongTienKhuenMaiTrongThang.setBounds(233, 224, 180, 20);
		panel_1_1.add(txtTongTienKhuenMaiTrongThang);

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

		txtTongSoHoaDonDuocLapTrongThang = new JTextField();
		txtTongSoHoaDonDuocLapTrongThang.setEditable(false);
		txtTongSoHoaDonDuocLapTrongThang.setColumns(10);
		txtTongSoHoaDonDuocLapTrongThang.setBounds(233, 40, 77, 20);
		panel_1_1.add(txtTongSoHoaDonDuocLapTrongThang);

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

		txtTongSoLuongMatHangBanRaTrongThang = new JTextField();
		txtTongSoLuongMatHangBanRaTrongThang.setEditable(false);
		txtTongSoLuongMatHangBanRaTrongThang.setColumns(10);
		txtTongSoLuongMatHangBanRaTrongThang.setBounds(233, 71, 77, 20);
		panel_1_1.add(txtTongSoLuongMatHangBanRaTrongThang);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(new LineBorder(Color.PINK));
		panel_4_1.setBounds(35, 423, 451, 4);
		panelKetQuaThongKe_1.add(panel_4_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(new LineBorder(Color.PINK));
		panel_3_1.setBounds(35, 148, 451, 4);
		panelKetQuaThongKe_1.add(panel_3_1);

		JPanel panelDuLieuThongKe_1 = new JPanel();
		panelDuLieuThongKe_1.setLayout(null);
		panelDuLieuThongKe_1.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,

				new Color(0, 0, 0)));
		panelDuLieuThongKe_1.setBounds(10, 11, 503, 74);
		panelKetQuaThongKe_1.add(panelDuLieuThongKe_1);

		JComboBox cbxChonThangThongKe = new JComboBox();
		cbxChonThangThongKe.setBounds(230, 28, 39, 22);
		panelDuLieuThongKe_1.add(cbxChonThangThongKe);

		JLabel lblThongKeNgay_1 = new JLabel("Chọn thống kê tháng :");
		lblThongKeNgay_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay_1.setBounds(99, 27, 137, 23);
		panelDuLieuThongKe_1.add(lblThongKeNgay_1);

		JLabel lblNewLabel_5 = new JLabel("Năm :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(283, 29, 46, 19);
		panelDuLieuThongKe_1.add(lblNewLabel_5);

		JComboBox cbxChonNamCuaThangThongKe = new JComboBox();
		cbxChonNamCuaThangThongKe.setBounds(325, 28, 59, 22);
		panelDuLieuThongKe_1.add(cbxChonNamCuaThangThongKe);
		
		btnLamMoiThongKeThang = new JButton("Làm mới");
		btnLamMoiThongKeThang.setBounds(288, 96, 89, 31);
		panelKetQuaThongKe_1.add(btnLamMoiThongKeThang);
		
		btnThongKeThang = new JButton("Thống kê");
		btnThongKeThang.setBounds(175, 96, 89, 31);
		panelKetQuaThongKe_1.add(btnThongKeThang);

		JPanel panelBieuDoThongKeNgay_1 = new JPanel();
		panelBieuDoThongKeNgay_1.setLayout(null);
		panelBieuDoThongKeNgay_1.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,

				new Color(0, 0, 0)));
		panelBieuDoThongKeNgay_1.setBounds(560, 11, 775, 561);
		panelTabThongKeTheoThang.add(panelBieuDoThongKeNgay_1);

		JPanel panelBieuDoThongKeThang = new JPanel();
		panelBieuDoThongKeThang.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeThang.setBounds(10, 31, 755, 346);
		panelBieuDoThongKeNgay_1.add(panelBieuDoThongKeThang);

		JPanel panelChuThichBieuDoThongKeThang = new JPanel();
		panelChuThichBieuDoThongKeThang.setBorder(
				new TitledBorder(null, "Ch\u00FA th\u00EDch : ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChuThichBieuDoThongKeThang.setBackground(SystemColor.menu);
		panelChuThichBieuDoThongKeThang.setBounds(10, 447, 755, 103);
		panelBieuDoThongKeNgay_1.add(panelChuThichBieuDoThongKeThang);

		JTextPane txtpnBiuTh = new JTextPane();
		txtpnBiuTh.setText("Biểu đồ thể hiện doanh thu bán hàng của nhân viên trong 5 tháng qua");
		txtpnBiuTh.setForeground(Color.RED);
		txtpnBiuTh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtpnBiuTh.setBackground(SystemColor.menu);
		txtpnBiuTh.setBounds(35, 382, 677, 36);
		panelBieuDoThongKeNgay_1.add(txtpnBiuTh);

		btnXuatDuLieuThang = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuThang.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuThang.setBounds(623, 583, 174, 30);
		panelTabThongKeTheoThang.add(btnXuatDuLieuThang);

		btnTaoBaoCaoThang = new JButton("Tạo báo cáo");
		btnTaoBaoCaoThang.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTaoBaoCaoThang.setBounds(1004, 583, 136, 30);
		panelTabThongKeTheoThang.add(btnTaoBaoCaoThang);

		JPanel panelTabThongKeTheoNam = new JPanel();
		panelTabThongKeTheoNam.setLayout(null);
		panelTabThongKeTheoNam.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo năm", null, panelTabThongKeTheoNam, null);

		JPanel panelKetQuaThongKe_1_1 = new JPanel();
		panelKetQuaThongKe_1_1.setLayout(null);
		panelKetQuaThongKe_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelKetQuaThongKe_1_1.setBounds(10, 11, 540, 622);
		panelTabThongKeTheoNam.add(panelKetQuaThongKe_1_1);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new LineBorder(Color.PINK));
		panel_2_1.setBounds(35, 262, 451, 4);
		panelKetQuaThongKe_1_1.add(panel_2_1);

		JLabel lblTKTrenTaiKhoan_1_1 = new JLabel("Thống kê trên tài khoản : ");
		lblTKTrenTaiKhoan_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTKTrenTaiKhoan_1_1.setBounds(67, 163, 166, 23);
		panelKetQuaThongKe_1_1.add(lblTKTrenTaiKhoan_1_1);

		txtTaiKhoanDuocThongKe = new JTextField();
		txtTaiKhoanDuocThongKe.setEditable(false);
		txtTaiKhoanDuocThongKe.setColumns(10);
		txtTaiKhoanDuocThongKe.setBounds(269, 163, 182, 22);
		panelKetQuaThongKe_1_1.add(txtTaiKhoanDuocThongKe);

		JLabel lblThongKeTheoTieuChi_1_1 = new JLabel("Tên nhân viên : ");
		lblThongKeTheoTieuChi_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi_1_1.setBounds(67, 197, 166, 23);
		panelKetQuaThongKe_1_1.add(lblThongKeTheoTieuChi_1_1);

		txtTenNhanVienDuocThongKe = new JTextField();
		txtTenNhanVienDuocThongKe.setEditable(false);
		txtTenNhanVienDuocThongKe.setColumns(10);
		txtTenNhanVienDuocThongKe.setBounds(269, 197, 182, 22);
		panelKetQuaThongKe_1_1.add(txtTenNhanVienDuocThongKe);

		txtNamDuocThongKe = new JTextField();
		txtNamDuocThongKe.setEditable(false);
		txtNamDuocThongKe.setColumns(10);
		txtNamDuocThongKe.setBounds(269, 228, 182, 22);
		panelKetQuaThongKe_1_1.add(txtNamDuocThongKe);

		JLabel labNgayThongKe_1_1 = new JLabel("Năm được thống kê  : ");
		labNgayThongKe_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labNgayThongKe_1_1.setBounds(67, 228, 166, 23);
		panelKetQuaThongKe_1_1.add(labNgayThongKe_1_1);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(
				new TitledBorder(null, "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA \u0111\u01B0\u1EE3c trong ng\u00E0y :",

						TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1_1.setBounds(10, 273, 503, 272);
		panelKetQuaThongKe_1_1.add(panel_1_1_1);

		JLabel lblNewLabel_1_5_1 = new JLabel("Tổng doanh thu trong năm  : ");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5_1.setBounds(29, 109, 206, 20);
		panel_1_1_1.add(lblNewLabel_1_5_1);

		txtTongDoanhThuNam = new JTextField();
		txtTongDoanhThuNam.setEditable(false);
		txtTongDoanhThuNam.setColumns(10);
		txtTongDoanhThuNam.setBounds(233, 109, 180, 20);
		panel_1_1_1.add(txtTongDoanhThuNam);

		JLabel lblNewLabel_2_5_1 = new JLabel("VND");
		lblNewLabel_2_5_1.setForeground(Color.RED);
		lblNewLabel_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_5_1.setBounds(423, 112, 46, 14);
		panel_1_1_1.add(lblNewLabel_2_5_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tổng tiền nhập hàng : ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(29, 136, 206, 20);
		panel_1_1_1.add(lblNewLabel_1_1_1_1);

		txtTongTienNhapHangNam = new JTextField();
		txtTongTienNhapHangNam.setEditable(false);
		txtTongTienNhapHangNam.setColumns(10);
		txtTongTienNhapHangNam.setBounds(233, 137, 180, 20);
		panel_1_1_1.add(txtTongTienNhapHangNam);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("VND");
		lblNewLabel_2_1_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1_1.setBounds(423, 140, 46, 14);
		panel_1_1_1.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tổng lãi trong ngày  : ");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(29, 167, 206, 18);
		panel_1_1_1.add(lblNewLabel_1_2_1_1);

		txtTongTienLaiNam = new JTextField();
		txtTongTienLaiNam.setEditable(false);
		txtTongTienLaiNam.setColumns(10);
		txtTongTienLaiNam.setBounds(233, 165, 180, 20);
		panel_1_1_1.add(txtTongTienLaiNam);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("VND");
		lblNewLabel_2_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_1_1.setBounds(423, 168, 46, 14);
		panel_1_1_1.add(lblNewLabel_2_2_1_1);

		JLabel lblNewLabel_1_3_2_1 = new JLabel("Tổng thuế   : ");
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_2_1.setBounds(29, 193, 206, 20);
		panel_1_1_1.add(lblNewLabel_1_3_2_1);

		txtTongThueNam = new JTextField();
		txtTongThueNam.setEditable(false);
		txtTongThueNam.setColumns(10);
		txtTongThueNam.setBounds(233, 193, 180, 20);
		panel_1_1_1.add(txtTongThueNam);

		JLabel lblNewLabel_2_3_2_1 = new JLabel("VND");
		lblNewLabel_2_3_2_1.setForeground(Color.RED);
		lblNewLabel_2_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_2_1.setBounds(423, 196, 46, 14);
		panel_1_1_1.add(lblNewLabel_2_3_2_1);

		txtTongTienKhuyenMaiNam = new JTextField();
		txtTongTienKhuyenMaiNam.setEditable(false);
		txtTongTienKhuyenMaiNam.setColumns(10);
		txtTongTienKhuyenMaiNam.setBounds(233, 224, 180, 20);
		panel_1_1_1.add(txtTongTienKhuyenMaiNam);

		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("Tổng tiền khuyến mãi : ");
		lblNewLabel_1_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1_1_1.setBounds(29, 224, 206, 20);
		panel_1_1_1.add(lblNewLabel_1_3_1_1_1);

		JLabel lblNewLabel_2_3_1_1_1 = new JLabel("VND");
		lblNewLabel_2_3_1_1_1.setForeground(Color.RED);
		lblNewLabel_2_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_1_1_1.setBounds(423, 227, 46, 14);
		panel_1_1_1.add(lblNewLabel_2_3_1_1_1);

		JLabel lblNewLabel_1_4_2_1 = new JLabel("Tổng số hóa đơn được lập : ");
		lblNewLabel_1_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_2_1.setBounds(29, 40, 206, 20);
		panel_1_1_1.add(lblNewLabel_1_4_2_1);

		txtTongSoHoaDonDuocLapNam = new JTextField();
		txtTongSoHoaDonDuocLapNam.setEditable(false);
		txtTongSoHoaDonDuocLapNam.setColumns(10);
		txtTongSoHoaDonDuocLapNam.setBounds(233, 40, 77, 20);
		panel_1_1_1.add(txtTongSoHoaDonDuocLapNam);

		JLabel lblNewLabel_2_4_2_1 = new JLabel("Hóa đơn");
		lblNewLabel_2_4_2_1.setForeground(Color.RED);
		lblNewLabel_2_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4_2_1.setBounds(320, 43, 69, 17);
		panel_1_1_1.add(lblNewLabel_2_4_2_1);

		JLabel lblNewLabel_2_4_1_1_1 = new JLabel("Mặt hàng");
		lblNewLabel_2_4_1_1_1.setForeground(Color.RED);
		lblNewLabel_2_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4_1_1_1.setBounds(320, 74, 69, 17);
		panel_1_1_1.add(lblNewLabel_2_4_1_1_1);

		JLabel lblNewLabel_1_4_1_1_1 = new JLabel("Tổng số lượng mặt hàng bán ra :");
		lblNewLabel_1_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1_1_1.setBounds(29, 71, 206, 20);
		panel_1_1_1.add(lblNewLabel_1_4_1_1_1);

		txtTongSoLuongMatHangBanRaTrongNam = new JTextField();
		txtTongSoLuongMatHangBanRaTrongNam.setEditable(false);
		txtTongSoLuongMatHangBanRaTrongNam.setColumns(10);
		txtTongSoLuongMatHangBanRaTrongNam.setBounds(233, 71, 77, 20);
		panel_1_1_1.add(txtTongSoLuongMatHangBanRaTrongNam);

		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setBorder(new LineBorder(Color.PINK));
		panel_4_1_1.setBounds(35, 423, 451, 4);
		panelKetQuaThongKe_1_1.add(panel_4_1_1);

		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBorder(new LineBorder(Color.PINK));
		panel_3_1_1.setBounds(35, 148, 451, 4);
		panelKetQuaThongKe_1_1.add(panel_3_1_1);

		JPanel panelDuLieuThongKe_1_1 = new JPanel();
		panelDuLieuThongKe_1_1.setLayout(null);
		panelDuLieuThongKe_1_1.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,

				new Color(0, 0, 0)));
		panelDuLieuThongKe_1_1.setBounds(10, 11, 503, 74);
		panelKetQuaThongKe_1_1.add(panelDuLieuThongKe_1_1);

		JLabel lblThongKeNgay_1_1 = new JLabel("Chọn thống kê Năm\r\n :");
		lblThongKeNgay_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay_1_1.setBounds(99, 27, 137, 23);
		panelDuLieuThongKe_1_1.add(lblThongKeNgay_1_1);

		JComboBox cbxChonNamThongKe = new JComboBox();
		cbxChonNamThongKe.setBounds(246, 28, 59, 22);
		panelDuLieuThongKe_1_1.add(cbxChonNamThongKe);
		
		btnLamMoiThongKeNam = new JButton("Làm mới");
		btnLamMoiThongKeNam.setBounds(263, 96, 89, 31);
		panelKetQuaThongKe_1_1.add(btnLamMoiThongKeNam);
		
		btnThongKeNam = new JButton("Thống kê");
		btnThongKeNam.setBounds(150, 96, 89, 31);
		panelKetQuaThongKe_1_1.add(btnThongKeNam);

		JPanel panelBieuDoThongKeNgay_1_1 = new JPanel();
		panelBieuDoThongKeNgay_1_1.setLayout(null);
		panelBieuDoThongKeNgay_1_1.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,

				new Color(0, 0, 0)));
		panelBieuDoThongKeNgay_1_1.setBounds(560, 11, 775, 561);
		panelTabThongKeTheoNam.add(panelBieuDoThongKeNgay_1_1);

		JPanel panelBieuDoThongKeNam = new JPanel();
		panelBieuDoThongKeNam.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeNam.setBounds(10, 31, 755, 346);
		panelBieuDoThongKeNgay_1_1.add(panelBieuDoThongKeNam);

		JPanel panelChuThichBieuDoThongKeNam = new JPanel();
		panelChuThichBieuDoThongKeNam.setBorder(
				new TitledBorder(null, "Ch\u00FA th\u00EDch : ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChuThichBieuDoThongKeNam.setBackground(SystemColor.menu);
		panelChuThichBieuDoThongKeNam.setBounds(10, 447, 755, 103);
		panelBieuDoThongKeNgay_1_1.add(panelChuThichBieuDoThongKeNam);

		JTextPane txtpnBiuTh_2 = new JTextPane();
		txtpnBiuTh_2.setText("Biểu đồ thể hiện doanh thu bán hàng của nhân viên trong 5 năm qua");
		txtpnBiuTh_2.setForeground(Color.RED);
		txtpnBiuTh_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtpnBiuTh_2.setBackground(SystemColor.menu);
		txtpnBiuTh_2.setBounds(35, 382, 677, 36);
		panelBieuDoThongKeNgay_1_1.add(txtpnBiuTh_2);

		btnXuatDuLieuNam = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuNam.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuNam.setBounds(623, 583, 174, 30);
		panelTabThongKeTheoNam.add(btnXuatDuLieuNam);

		btnTaoBaoCaoNam = new JButton("Tạo báo cáo");
		btnTaoBaoCaoNam.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTaoBaoCaoNam.setBounds(1004, 583, 136, 30);
		panelTabThongKeTheoNam.add(btnTaoBaoCaoNam);
		
		//<==============>
		btnLamMoiThongKeNgay.addActionListener(this);
		btnTaoBaoCaoNgay.addActionListener(this);
		btnXuatDuLieuNgay.addActionListener(this);
		btnLamMoiThongKeThang.addActionListener(this);
		btnThongKeThang.addActionListener(this);
		btnXuatDuLieuThang.addActionListener(this);
		btnTaoBaoCaoThang.addActionListener(this);
		btnLamMoiThongKeNam.addActionListener(this);
		btnThongKeNam.addActionListener(this);
		btnXuatDuLieuNam.addActionListener(this);
		btnTaoBaoCaoNam.addActionListener(this);
		//<====================>
		// Lấy ngày hiện tại từ Calendar
		Calendar ngayHienTai = Calendar.getInstance();

		// Đặt ngày hiện tại cho JDateChooser
		jdcChonNgayThongKe.setDate(ngayHienTai.getTime());
		//<==============>
		//loadDataToFormNgay();
		//System.out.println(formatCurrency(12345678.9f));
	}
	
	 // Định dạng số theo tiền Việt Nam (phân tách hàng nghìn bằng dấu ".")
	public String formatCurrency(float money) {
        long roundedMoney = Math.round(money);
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedMoney = decimalFormat.format(roundedMoney);
        return formattedMoney;
    }
	
	public void loadDataToFormNgay(String tk, String nv, int soHd, int soMh, float dt, float tienNhapHang, float tonglai, float tongThue, float tongKhuyenmai ) {
		Date ngayDuocChonUtil = jdcChonNgayThongKe.getDate();
		// Chuyển đổi java.util.Date sang java.sql.Date
		java.sql.Date ngayDuocChonSQL = new java.sql.Date(ngayDuocChonUtil.getTime());
		System.out.println(ngayDuocChonSQL);
		txtThongKeTrenTaiKhoanNgay.setText(tk.trim());
		txtTenNhanVienThongKeNgay.setText(nv.trim());
		txtNgayDuocThongKeNgay.setText(ngayDuocChonSQL.toString());
		txtTongSoHoaDonDuocLapNgay.setText(String.valueOf(soHd));
		txtTongSoLuongMatHangBanRaNgay.setText(String.valueOf(soMh));
		txtTongDoanhThuNgay.setText(String.valueOf(tongKhuyenmai));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
