package gui.user;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constance.SetBountJPanel;
import java.awt.Font;
import java.awt.Color;
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

public class TrangThongKeNVBanHangJPanel extends JPanel {
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;

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
		tabbedPane.addTab("New tab", null, panelTabThongKeTheoNgay, null);
		
		JPanel panelKetQuaThongKe = new JPanel();
		panelKetQuaThongKe.setLayout(null);
		panelKetQuaThongKe.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelKetQuaThongKe.setBounds(10, 11, 540, 622);
		panelTabThongKeTheoNgay.add(panelKetQuaThongKe);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.PINK));
		panel.setBounds(35, 262, 451, 4);
		panelKetQuaThongKe.add(panel);
		
		JLabel lblTKTrenTaiKhoan = new JLabel("Thống kê trên tài khoản : ");
		lblTKTrenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTKTrenTaiKhoan.setBounds(67, 163, 166, 23);
		panelKetQuaThongKe.add(lblTKTrenTaiKhoan);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(269, 163, 182, 22);
		panelKetQuaThongKe.add(textField_2);
		
		JLabel lblThongKeTheoTieuChi = new JLabel("Tên nhân viên : ");
		lblThongKeTheoTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi.setBounds(67, 197, 166, 23);
		panelKetQuaThongKe.add(lblThongKeTheoTieuChi);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(269, 197, 182, 22);
		panelKetQuaThongKe.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(269, 228, 182, 22);
		panelKetQuaThongKe.add(textField_4);
		
		JLabel labNgayThongKe = new JLabel("Ngày được thống kê  : ");
		labNgayThongKe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labNgayThongKe.setBounds(67, 228, 166, 23);
		panelKetQuaThongKe.add(labNgayThongKe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA \u0111\u01B0\u1EE3c trong ng\u00E0y :",
								TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 273, 503, 272);
		panelKetQuaThongKe.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng doanh thu trong ngày  : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(29, 109, 206, 20);
		panel_1.add(lblNewLabel_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(233, 109, 180, 20);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel_2 = new JLabel("VND");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(423, 112, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tổng tiền nhập hàng : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(29, 136, 206, 20);
		panel_1.add(lblNewLabel_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(233, 137, 180, 20);
		panel_1.add(textField_6);
		
		JLabel lblNewLabel_2_1 = new JLabel("VND");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(423, 140, 46, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tổng lãi trong ngày  : ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(29, 167, 206, 18);
		panel_1.add(lblNewLabel_1_2);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(233, 165, 180, 20);
		panel_1.add(textField_7);
		
		JLabel lblNewLabel_2_2 = new JLabel("VND");
		lblNewLabel_2_2.setForeground(Color.RED);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(423, 168, 46, 14);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tổng thuế   : ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(29, 193, 206, 20);
		panel_1.add(lblNewLabel_1_3);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(233, 193, 180, 20);
		panel_1.add(textField_8);
		
		JLabel lblNewLabel_2_3 = new JLabel("VND");
		lblNewLabel_2_3.setForeground(Color.RED);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(423, 196, 46, 14);
		panel_1.add(lblNewLabel_2_3);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(233, 224, 180, 20);
		panel_1.add(textField_9);
		
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
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(233, 40, 77, 20);
		panel_1.add(textField_10);
		
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
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(233, 71, 77, 20);
		panel_1.add(textField_11);
		
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
		
		JDateChooser jdcChonNgayThongKe = new JDateChooser();
		jdcChonNgayThongKe.setBounds(197, 23, 185, 23);
		panelDuLieuThongKe.add(jdcChonNgayThongKe);
		
		JButton btnNewButton = new JButton("Thống kê");
		btnNewButton.setBounds(234, 83, 89, 23);
		panelKetQuaThongKe.add(btnNewButton);
		
		JLabel lblNewLabel_6_1 = new JLabel("Tháng :");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6_1.setBounds(77, 117, 46, 21);
		panelKetQuaThongKe.add(lblNewLabel_6_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(130, 117, 41, 20);
		panelKetQuaThongKe.add(textField);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Năm :");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1_1.setBounds(176, 118, 46, 19);
		panelKetQuaThongKe.add(lblNewLabel_5_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(215, 117, 62, 20);
		panelKetQuaThongKe.add(textField_1);
		
		JPanel panelBieuDoThongKeNgay = new JPanel();
		panelBieuDoThongKeNgay.setLayout(null);
		panelBieuDoThongKeNgay.setBorder(new TitledBorder(
						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
						"Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 0, 0)));
		panelBieuDoThongKeNgay.setBounds(560, 11, 775, 561);
		panelTabThongKeTheoNgay.add(panelBieuDoThongKeNgay);
		
		JPanel panelBieuDoThongKeDoanhThuNgay = new JPanel();
		panelBieuDoThongKeDoanhThuNgay.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeDoanhThuNgay.setBounds(10, 31, 755, 346);
		panelBieuDoThongKeNgay.add(panelBieuDoThongKeDoanhThuNgay);
		
		JPanel panelChuThichBieuDoThongKeDTNgay = new JPanel();
		panelChuThichBieuDoThongKeDTNgay.setBorder(new TitledBorder(null, "Ch\u00FA th\u00EDch : ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChuThichBieuDoThongKeDTNgay.setBackground(SystemColor.menu);
		panelChuThichBieuDoThongKeDTNgay.setBounds(10, 447, 755, 103);
		panelBieuDoThongKeNgay.add(panelChuThichBieuDoThongKeDTNgay);
		
		JTextPane txtTenBieuDo1 = new JTextPane();
		txtTenBieuDo1.setText("Biểu đồ thể hiện doanh thu bán hàng của tất cả nhân viên trong 10 ngày qua");
		txtTenBieuDo1.setForeground(Color.RED);
		txtTenBieuDo1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtTenBieuDo1.setBackground(SystemColor.menu);
		txtTenBieuDo1.setBounds(35, 382, 677, 36);
		panelBieuDoThongKeNgay.add(txtTenBieuDo1);
		
		JButton btnTaoBaoCaoTkDoanhThuNgay = new JButton("Tạo báo cáo");
		btnTaoBaoCaoTkDoanhThuNgay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTaoBaoCaoTkDoanhThuNgay.setBounds(1004, 583, 136, 30);
		panelTabThongKeTheoNgay.add(btnTaoBaoCaoTkDoanhThuNgay);
		
		JButton btnXuatDuLieuTkDoanhThuNgay = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuTkDoanhThuNgay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuTkDoanhThuNgay.setBounds(623, 583, 174, 30);
		panelTabThongKeTheoNgay.add(btnXuatDuLieuTkDoanhThuNgay);
		
		JPanel panelTabThongKeTheoThang = new JPanel();
		panelTabThongKeTheoThang.setLayout(null);
		panelTabThongKeTheoThang.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("New tab", null, panelTabThongKeTheoThang, null);
		
		JPanel panelKetQuaThongKe_1 = new JPanel();
		panelKetQuaThongKe_1.setLayout(null);
		panelKetQuaThongKe_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(269, 163, 182, 22);
		panelKetQuaThongKe_1.add(textField_12);
		
		JLabel lblThongKeTheoTieuChi_1 = new JLabel("Tên nhân viên : ");
		lblThongKeTheoTieuChi_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi_1.setBounds(67, 197, 166, 23);
		panelKetQuaThongKe_1.add(lblThongKeTheoTieuChi_1);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(269, 197, 182, 22);
		panelKetQuaThongKe_1.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(269, 228, 182, 22);
		panelKetQuaThongKe_1.add(textField_14);
		
		JLabel labNgayThongKe_1 = new JLabel("Ngày được thống kê  : ");
		labNgayThongKe_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labNgayThongKe_1.setBounds(67, 228, 166, 23);
		panelKetQuaThongKe_1.add(labNgayThongKe_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA \u0111\u01B0\u1EE3c trong ng\u00E0y :",
										TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(10, 273, 503, 272);
		panelKetQuaThongKe_1.add(panel_1_1);
		
		JLabel lblNewLabel_1_5 = new JLabel("Tổng doanh thu trong ngày  : ");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(29, 109, 206, 20);
		panel_1_1.add(lblNewLabel_1_5);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(233, 109, 180, 20);
		panel_1_1.add(textField_15);
		
		JLabel lblNewLabel_2_5 = new JLabel("VND");
		lblNewLabel_2_5.setForeground(Color.RED);
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_5.setBounds(423, 112, 46, 14);
		panel_1_1.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tổng tiền nhập hàng : ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(29, 136, 206, 20);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(233, 137, 180, 20);
		panel_1_1.add(textField_16);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("VND");
		lblNewLabel_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(423, 140, 46, 14);
		panel_1_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tổng lãi trong ngày  : ");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(29, 167, 206, 18);
		panel_1_1.add(lblNewLabel_1_2_1);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(233, 165, 180, 20);
		panel_1_1.add(textField_17);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("VND");
		lblNewLabel_2_2_1.setForeground(Color.RED);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(423, 168, 46, 14);
		panel_1_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Tổng thuế   : ");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_2.setBounds(29, 193, 206, 20);
		panel_1_1.add(lblNewLabel_1_3_2);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(233, 193, 180, 20);
		panel_1_1.add(textField_18);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("VND");
		lblNewLabel_2_3_2.setForeground(Color.RED);
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_2.setBounds(423, 196, 46, 14);
		panel_1_1.add(lblNewLabel_2_3_2);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(233, 224, 180, 20);
		panel_1_1.add(textField_19);
		
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
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(233, 40, 77, 20);
		panel_1_1.add(textField_20);
		
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
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(233, 71, 77, 20);
		panel_1_1.add(textField_21);
		
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
		
		JComboBox cbxChonThangThongKeDT = new JComboBox();
		cbxChonThangThongKeDT.setBounds(230, 28, 39, 22);
		panelDuLieuThongKe_1.add(cbxChonThangThongKeDT);
		
		JLabel lblThongKeNgay_1 = new JLabel("Chọn thống kê tháng :");
		lblThongKeNgay_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay_1.setBounds(99, 27, 137, 23);
		panelDuLieuThongKe_1.add(lblThongKeNgay_1);
		
		JLabel lblNewLabel_5 = new JLabel("Năm :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(283, 29, 46, 19);
		panelDuLieuThongKe_1.add(lblNewLabel_5);
		
		JComboBox cbxChonNamCuaThangThongKeDT = new JComboBox();
		cbxChonNamCuaThangThongKeDT.setBounds(325, 28, 59, 22);
		panelDuLieuThongKe_1.add(cbxChonNamCuaThangThongKeDT);
		
		JButton btnNewButton_1 = new JButton("Thống kê");
		btnNewButton_1.setBounds(227, 100, 89, 23);
		panelKetQuaThongKe_1.add(btnNewButton_1);
		
		JPanel panelBieuDoThongKeNgay_1 = new JPanel();
		panelBieuDoThongKeNgay_1.setLayout(null);
		panelBieuDoThongKeNgay_1.setBorder(new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
								"Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,
								new Color(0, 0, 0)));
		panelBieuDoThongKeNgay_1.setBounds(560, 11, 775, 561);
		panelTabThongKeTheoThang.add(panelBieuDoThongKeNgay_1);
		
		JPanel panelBieuDoThongKeDoanhThuNgay_1 = new JPanel();
		panelBieuDoThongKeDoanhThuNgay_1.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeDoanhThuNgay_1.setBounds(10, 31, 755, 346);
		panelBieuDoThongKeNgay_1.add(panelBieuDoThongKeDoanhThuNgay_1);
		
		JPanel panelChuThichBieuDoThongKeDTNgay_1 = new JPanel();
		panelChuThichBieuDoThongKeDTNgay_1.setBorder(new TitledBorder(null, "Ch\u00FA th\u00EDch : ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChuThichBieuDoThongKeDTNgay_1.setBackground(SystemColor.menu);
		panelChuThichBieuDoThongKeDTNgay_1.setBounds(10, 447, 755, 103);
		panelBieuDoThongKeNgay_1.add(panelChuThichBieuDoThongKeDTNgay_1);
		
		JTextPane txtpnBiuTh = new JTextPane();
		txtpnBiuTh.setText("Biểu đồ thể hiện doanh thu bán hàng của nhân viên trong 5 tháng qua");
		txtpnBiuTh.setForeground(Color.RED);
		txtpnBiuTh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtpnBiuTh.setBackground(SystemColor.menu);
		txtpnBiuTh.setBounds(35, 382, 677, 36);
		panelBieuDoThongKeNgay_1.add(txtpnBiuTh);
		
		JButton btnXuatDuLieuTkDoanhThuNgay_1 = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuTkDoanhThuNgay_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuTkDoanhThuNgay_1.setBounds(623, 583, 174, 30);
		panelTabThongKeTheoThang.add(btnXuatDuLieuTkDoanhThuNgay_1);
		
		JButton btnTaoBaoCaoTkDoanhThuNgay_1 = new JButton("Tạo báo cáo");
		btnTaoBaoCaoTkDoanhThuNgay_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTaoBaoCaoTkDoanhThuNgay_1.setBounds(1004, 583, 136, 30);
		panelTabThongKeTheoThang.add(btnTaoBaoCaoTkDoanhThuNgay_1);
		
		JPanel panelTabThongKeTheoNam = new JPanel();
		panelTabThongKeTheoNam.setLayout(null);
		panelTabThongKeTheoNam.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("New tab", null, panelTabThongKeTheoNam, null);
		
		JPanel panelKetQuaThongKe_1_1 = new JPanel();
		panelKetQuaThongKe_1_1.setLayout(null);
		panelKetQuaThongKe_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelKetQuaThongKe_1_1.setBounds(10, 22, 540, 622);
		panelTabThongKeTheoNam.add(panelKetQuaThongKe_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new LineBorder(Color.PINK));
		panel_2_1.setBounds(35, 262, 451, 4);
		panelKetQuaThongKe_1_1.add(panel_2_1);
		
		JLabel lblTKTrenTaiKhoan_1_1 = new JLabel("Thống kê trên tài khoản : ");
		lblTKTrenTaiKhoan_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTKTrenTaiKhoan_1_1.setBounds(67, 163, 166, 23);
		panelKetQuaThongKe_1_1.add(lblTKTrenTaiKhoan_1_1);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(269, 163, 182, 22);
		panelKetQuaThongKe_1_1.add(textField_22);
		
		JLabel lblThongKeTheoTieuChi_1_1 = new JLabel("Tên nhân viên : ");
		lblThongKeTheoTieuChi_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi_1_1.setBounds(67, 197, 166, 23);
		panelKetQuaThongKe_1_1.add(lblThongKeTheoTieuChi_1_1);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(269, 197, 182, 22);
		panelKetQuaThongKe_1_1.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(269, 228, 182, 22);
		panelKetQuaThongKe_1_1.add(textField_24);
		
		JLabel labNgayThongKe_1_1 = new JLabel("Ngày được thống kê  : ");
		labNgayThongKe_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labNgayThongKe_1_1.setBounds(67, 228, 166, 23);
		panelKetQuaThongKe_1_1.add(labNgayThongKe_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new TitledBorder(null, "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA \u0111\u01B0\u1EE3c trong ng\u00E0y :",
												TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1_1.setBounds(10, 273, 503, 272);
		panelKetQuaThongKe_1_1.add(panel_1_1_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Tổng doanh thu trong ngày  : ");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5_1.setBounds(29, 109, 206, 20);
		panel_1_1_1.add(lblNewLabel_1_5_1);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(233, 109, 180, 20);
		panel_1_1_1.add(textField_25);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("VND");
		lblNewLabel_2_5_1.setForeground(Color.RED);
		lblNewLabel_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_5_1.setBounds(423, 112, 46, 14);
		panel_1_1_1.add(lblNewLabel_2_5_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tổng tiền nhập hàng : ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(29, 136, 206, 20);
		panel_1_1_1.add(lblNewLabel_1_1_1_1);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(233, 137, 180, 20);
		panel_1_1_1.add(textField_26);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("VND");
		lblNewLabel_2_1_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1_1.setBounds(423, 140, 46, 14);
		panel_1_1_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tổng lãi trong ngày  : ");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(29, 167, 206, 18);
		panel_1_1_1.add(lblNewLabel_1_2_1_1);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(233, 165, 180, 20);
		panel_1_1_1.add(textField_27);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("VND");
		lblNewLabel_2_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_1_1.setBounds(423, 168, 46, 14);
		panel_1_1_1.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("Tổng thuế   : ");
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_2_1.setBounds(29, 193, 206, 20);
		panel_1_1_1.add(lblNewLabel_1_3_2_1);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(233, 193, 180, 20);
		panel_1_1_1.add(textField_28);
		
		JLabel lblNewLabel_2_3_2_1 = new JLabel("VND");
		lblNewLabel_2_3_2_1.setForeground(Color.RED);
		lblNewLabel_2_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_2_1.setBounds(423, 196, 46, 14);
		panel_1_1_1.add(lblNewLabel_2_3_2_1);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(233, 224, 180, 20);
		panel_1_1_1.add(textField_29);
		
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
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(233, 40, 77, 20);
		panel_1_1_1.add(textField_30);
		
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
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBounds(233, 71, 77, 20);
		panel_1_1_1.add(textField_31);
		
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
		
		JComboBox cbxChonNamCuaThangThongKeDT_1 = new JComboBox();
		cbxChonNamCuaThangThongKeDT_1.setBounds(246, 28, 59, 22);
		panelDuLieuThongKe_1_1.add(cbxChonNamCuaThangThongKeDT_1);
		
		JButton btnNewButton_1_1 = new JButton("Thống kê");
		btnNewButton_1_1.setBounds(227, 100, 89, 23);
		panelKetQuaThongKe_1_1.add(btnNewButton_1_1);
		
		JPanel panelBieuDoThongKeNgay_1_1 = new JPanel();
		panelBieuDoThongKeNgay_1_1.setLayout(null);
		panelBieuDoThongKeNgay_1_1.setBorder(new TitledBorder(
										new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
										"Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,
										new Color(0, 0, 0)));
		panelBieuDoThongKeNgay_1_1.setBounds(560, 22, 775, 561);
		panelTabThongKeTheoNam.add(panelBieuDoThongKeNgay_1_1);
		
		JPanel panelBieuDoThongKeDoanhThuNgay_1_1 = new JPanel();
		panelBieuDoThongKeDoanhThuNgay_1_1.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeDoanhThuNgay_1_1.setBounds(10, 31, 755, 346);
		panelBieuDoThongKeNgay_1_1.add(panelBieuDoThongKeDoanhThuNgay_1_1);
		
		JPanel panelChuThichBieuDoThongKeDTNgay_1_1 = new JPanel();
		panelChuThichBieuDoThongKeDTNgay_1_1.setBorder(new TitledBorder(null, "Ch\u00FA th\u00EDch : ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChuThichBieuDoThongKeDTNgay_1_1.setBackground(SystemColor.menu);
		panelChuThichBieuDoThongKeDTNgay_1_1.setBounds(10, 447, 755, 103);
		panelBieuDoThongKeNgay_1_1.add(panelChuThichBieuDoThongKeDTNgay_1_1);
		
		JTextPane txtpnBiuTh_2 = new JTextPane();
		txtpnBiuTh_2.setText("Biểu đồ thể hiện doanh thu bán hàng của nhân viên trong 5 năm qua");
		txtpnBiuTh_2.setForeground(Color.RED);
		txtpnBiuTh_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtpnBiuTh_2.setBackground(SystemColor.menu);
		txtpnBiuTh_2.setBounds(35, 382, 677, 36);
		panelBieuDoThongKeNgay_1_1.add(txtpnBiuTh_2);
		
		JButton btnXuatDuLieuTkDoanhThuNgay_1_1 = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuTkDoanhThuNgay_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuTkDoanhThuNgay_1_1.setBounds(623, 594, 174, 30);
		panelTabThongKeTheoNam.add(btnXuatDuLieuTkDoanhThuNgay_1_1);
		
		JButton btnTaoBaoCaoTkDoanhThuNgay_1_1 = new JButton("Tạo báo cáo");
		btnTaoBaoCaoTkDoanhThuNgay_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTaoBaoCaoTkDoanhThuNgay_1_1.setBounds(1004, 594, 136, 30);
		panelTabThongKeTheoNam.add(btnTaoBaoCaoTkDoanhThuNgay_1_1);
	}
}
