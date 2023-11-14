package gui.user;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import constance.SetBountJPanel;
import daos.Dao_ThongKeDoanhThu;
import entities.NhanVien;
import modelsThongKe.BieuDoThongKePanel;
import modelsThongKe.DuLieuBieuDoThongKeDoanhThu;
import modelsThongKe.ModelThongKeDoanhThuNam;
import modelsThongKe.ModelThongKeDoanhThuNgay;
import modelsThongKe.ModelThongKeDoanhThuThang;
import services.ThongKeDoanhThuServices;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
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
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class TrangThongKeNVBanHangJPanel extends JPanel implements ActionListener {
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
	private JTextField txtTongTienHangDaBanNgay;
	private JTextField txtTongTienHangDaBanThang;
	private JTextField txtTongTienHangDaBanNam;
	private String[] nam = {"2019","2020", "2021", "2022", "2023"};
	private String[] thang = {"1", "2", "3","4","5","6","7","8","9","10","11","12"};
	// <=======dữ liệu cho thong ke========>
	private ModelThongKeDoanhThuNgay modelThongKeDoanhThuNgay = new ModelThongKeDoanhThuNgay();
	ArrayList<ModelThongKeDoanhThuNgay> listModalThongKeNgay = new ArrayList<>();

	private ModelThongKeDoanhThuThang modelThongKeDoanhThuThang = new ModelThongKeDoanhThuThang();
	ArrayList<ModelThongKeDoanhThuThang> listModelThongKeThang = new ArrayList<>();

	private ModelThongKeDoanhThuNam modelThongKeDoanhThuNam = new ModelThongKeDoanhThuNam();
	ArrayList<ModelThongKeDoanhThuNam> listModelThongKeDoanhThuNam = new ArrayList<>();

	// <========data default================>

	private NhanVien taiKhoan = new NhanVien("NV0002", "Phạm Nhật Linh", null, null, null, null, null, null, true, null,
			false, null);
	LocalDate today = LocalDate.now();

	// <============panel bieu do ===============>
	private JPanel panelBieuDoThongKeTheoNgay;
	// <==================>
	private JComboBox<String> cbxChonNamCuaThangThongKe;
	private JComboBox<String> cbxChonThangThongKe;
	private JPanel panelBieuDoThongKeThang;
	private JComboBox<String> cbxChonNamThongKe;
	private JPanel panelBieuDoThongKeNam;

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

		JLabel lblTKTrenTaiKhoan = new JLabel("Thống kê trên tài khoản : ");
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
		panel_1.setBounds(10, 273, 503, 323);
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
		lblNewLabel_1_2.setBounds(29, 283, 206, 18);
		panel_1.add(lblNewLabel_1_2);

		txtTongTienLaiTrongNgay = new JTextField();
		txtTongTienLaiTrongNgay.setEditable(false);
		txtTongTienLaiTrongNgay.setColumns(10);
		txtTongTienLaiTrongNgay.setBounds(233, 281, 180, 20);
		panel_1.add(txtTongTienLaiTrongNgay);

		JLabel lblNewLabel_2_2 = new JLabel("VND");
		lblNewLabel_2_2.setForeground(Color.RED);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(423, 284, 46, 14);
		panel_1.add(lblNewLabel_2_2);

		JLabel lblNewLabel_1_3 = new JLabel("Tổng thuế   : ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(29, 229, 206, 20);
		panel_1.add(lblNewLabel_1_3);

		txtTongThueNgay = new JTextField();
		txtTongThueNgay.setEditable(false);
		txtTongThueNgay.setColumns(10);
		txtTongThueNgay.setBounds(233, 229, 180, 20);
		panel_1.add(txtTongThueNgay);

		JLabel lblNewLabel_2_3 = new JLabel("VND");
		lblNewLabel_2_3.setForeground(Color.RED);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(423, 232, 46, 14);
		panel_1.add(lblNewLabel_2_3);

		txtTongTienKhuyenMaiNgay = new JTextField();
		txtTongTienKhuyenMaiNgay.setEditable(false);
		txtTongTienKhuyenMaiNgay.setColumns(10);
		txtTongTienKhuyenMaiNgay.setBounds(233, 198, 180, 20);
		panel_1.add(txtTongTienKhuyenMaiNgay);

		JLabel lblNewLabel_1_3_1 = new JLabel("Tổng tiền khuyến mãi : ");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1.setBounds(29, 198, 206, 20);
		panel_1.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_2_3_1 = new JLabel("VND");
		lblNewLabel_2_3_1.setForeground(Color.RED);
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_1.setBounds(423, 201, 46, 14);
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

		JLabel lblNewLabel_1_1_2 = new JLabel("Tổng tiền hàng đã bán :");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(29, 167, 206, 20);
		panel_1.add(lblNewLabel_1_1_2);

		txtTongTienHangDaBanNgay = new JTextField();
		txtTongTienHangDaBanNgay.setEditable(false);
		txtTongTienHangDaBanNgay.setColumns(10);
		txtTongTienHangDaBanNgay.setBounds(233, 168, 180, 20);
		panel_1.add(txtTongTienHangDaBanNgay);

		JLabel lblNewLabel_2_1_2 = new JLabel("VND");
		lblNewLabel_2_1_2.setForeground(Color.RED);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_2.setBounds(423, 171, 46, 14);
		panel_1.add(lblNewLabel_2_1_2);

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

		panelBieuDoThongKeTheoNgay = new JPanel();
		panelBieuDoThongKeTheoNgay.setBounds(10, 31, 755, 405);
		panelBieuDoThongKeTheoNgay.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeNgay.add(panelBieuDoThongKeTheoNgay);
		panelBieuDoThongKeTheoNgay.setLayout(new BorderLayout(0, 0));

//		VeBieuDoThongKeDoanhThuNgay(panelBieuDoThongKeTheoNgay, today, taiKhoan);

		JPanel panelChuThichBieuDoThongKeNgay = new JPanel();
		panelChuThichBieuDoThongKeNgay.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nh\u1EADn X\u00E9t : ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChuThichBieuDoThongKeNgay.setBackground(SystemColor.menu);
		panelChuThichBieuDoThongKeNgay.setBounds(10, 447, 755, 103);
		panelBieuDoThongKeNgay.add(panelChuThichBieuDoThongKeNgay);
		panelChuThichBieuDoThongKeNgay.setLayout(null);

		JTextPane txtPaneNhanXetThongKeNgay = new JTextPane();
		txtPaneNhanXetThongKeNgay.setEditable(false);
		txtPaneNhanXetThongKeNgay.setText("Thống kê ngày 14/11/2023 trên tài khoản NV0002 \r\nDoanh thu hôm nay là 0 VND\r\nThấp hơn so với ngày có doanh thu cao nhất trong tháng là ngày 2/11/2023 với doanh thu 365.000.000VND\r\n");
		txtPaneNhanXetThongKeNgay.setBounds(42, 25, 703, 52);
		panelChuThichBieuDoThongKeNgay.add(txtPaneNhanXetThongKeNgay);

		JLabel lblNewLabel_3 = new JLabel("=>");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(10, 25, 32, 37);
		panelChuThichBieuDoThongKeNgay.add(lblNewLabel_3);

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
		panel_1_1.setBounds(10, 273, 503, 322);
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

		JLabel lblNewLabel_1_2_1 = new JLabel("Tổng lãi trong tháng  : ");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(29, 278, 206, 18);
		panel_1_1.add(lblNewLabel_1_2_1);

		txtTongTienLaiTrongThang = new JTextField();
		txtTongTienLaiTrongThang.setEditable(false);
		txtTongTienLaiTrongThang.setColumns(10);
		txtTongTienLaiTrongThang.setBounds(233, 276, 180, 20);
		panel_1_1.add(txtTongTienLaiTrongThang);

		JLabel lblNewLabel_2_2_1 = new JLabel("VND");
		lblNewLabel_2_2_1.setForeground(Color.RED);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(423, 279, 46, 14);
		panel_1_1.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_1_3_2 = new JLabel("Tổng thuế   : ");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_2.setBounds(29, 199, 206, 20);
		panel_1_1.add(lblNewLabel_1_3_2);

		txtTongThueTrongThang = new JTextField();
		txtTongThueTrongThang.setEditable(false);
		txtTongThueTrongThang.setColumns(10);
		txtTongThueTrongThang.setBounds(233, 199, 180, 20);
		panel_1_1.add(txtTongThueTrongThang);

		JLabel lblNewLabel_2_3_2 = new JLabel("VND");
		lblNewLabel_2_3_2.setForeground(Color.RED);
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_2.setBounds(423, 202, 46, 14);
		panel_1_1.add(lblNewLabel_2_3_2);

		txtTongTienKhuenMaiTrongThang = new JTextField();
		txtTongTienKhuenMaiTrongThang.setEditable(false);
		txtTongTienKhuenMaiTrongThang.setColumns(10);
		txtTongTienKhuenMaiTrongThang.setBounds(233, 230, 180, 20);
		panel_1_1.add(txtTongTienKhuenMaiTrongThang);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Tổng tiền khuyến mãi : ");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1_1.setBounds(29, 230, 206, 20);
		panel_1_1.add(lblNewLabel_1_3_1_1);

		JLabel lblNewLabel_2_3_1_1 = new JLabel("VND");
		lblNewLabel_2_3_1_1.setForeground(Color.RED);
		lblNewLabel_2_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_1_1.setBounds(423, 233, 46, 14);
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

		txtTongTienHangDaBanThang = new JTextField();
		txtTongTienHangDaBanThang.setEditable(false);
		txtTongTienHangDaBanThang.setColumns(10);
		txtTongTienHangDaBanThang.setBounds(233, 168, 180, 20);
		panel_1_1.add(txtTongTienHangDaBanThang);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Tổng tiền hàng đã bán :");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1.setBounds(29, 167, 206, 20);
		panel_1_1.add(lblNewLabel_1_1_2_1);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("VND");
		lblNewLabel_2_1_2_1.setForeground(Color.RED);
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_2_1.setBounds(423, 171, 46, 14);
		panel_1_1.add(lblNewLabel_2_1_2_1);

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

		cbxChonThangThongKe = new JComboBox(thang);
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
		
		cbxChonNamCuaThangThongKe = new JComboBox(nam);
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

		panelBieuDoThongKeThang = new JPanel();
		panelBieuDoThongKeThang.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeThang.setBounds(10, 31, 755, 420);
		panelBieuDoThongKeNgay_1.add(panelBieuDoThongKeThang);

		JPanel panelChuThichBieuDoThongKeThang = new JPanel();
		panelChuThichBieuDoThongKeThang.setBorder(
				new TitledBorder(null, "Ch\u00FA th\u00EDch : ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChuThichBieuDoThongKeThang.setBackground(SystemColor.menu);
		panelChuThichBieuDoThongKeThang.setBounds(10, 462, 755, 88);
		panelBieuDoThongKeNgay_1.add(panelChuThichBieuDoThongKeThang);

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
		panel_1_1_1.setBounds(10, 273, 503, 317);
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

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tổng lãi trong năm  : ");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(29, 277, 206, 18);
		panel_1_1_1.add(lblNewLabel_1_2_1_1);

		txtTongTienLaiNam = new JTextField();
		txtTongTienLaiNam.setEditable(false);
		txtTongTienLaiNam.setColumns(10);
		txtTongTienLaiNam.setBounds(233, 275, 180, 20);
		panel_1_1_1.add(txtTongTienLaiNam);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("VND");
		lblNewLabel_2_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_1_1.setBounds(423, 278, 46, 14);
		panel_1_1_1.add(lblNewLabel_2_2_1_1);

		JLabel lblNewLabel_1_3_2_1 = new JLabel("Tổng thuế   : ");
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_2_1.setBounds(29, 201, 206, 20);
		panel_1_1_1.add(lblNewLabel_1_3_2_1);

		txtTongThueNam = new JTextField();
		txtTongThueNam.setEditable(false);
		txtTongThueNam.setColumns(10);
		txtTongThueNam.setBounds(233, 201, 180, 20);
		panel_1_1_1.add(txtTongThueNam);

		JLabel lblNewLabel_2_3_2_1 = new JLabel("VND");
		lblNewLabel_2_3_2_1.setForeground(Color.RED);
		lblNewLabel_2_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_2_1.setBounds(423, 204, 46, 14);
		panel_1_1_1.add(lblNewLabel_2_3_2_1);

		txtTongTienKhuyenMaiNam = new JTextField();
		txtTongTienKhuyenMaiNam.setEditable(false);
		txtTongTienKhuyenMaiNam.setColumns(10);
		txtTongTienKhuyenMaiNam.setBounds(233, 232, 180, 20);
		panel_1_1_1.add(txtTongTienKhuyenMaiNam);

		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("Tổng tiền khuyến mãi : ");
		lblNewLabel_1_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1_1_1.setBounds(29, 232, 206, 20);
		panel_1_1_1.add(lblNewLabel_1_3_1_1_1);

		JLabel lblNewLabel_2_3_1_1_1 = new JLabel("VND");
		lblNewLabel_2_3_1_1_1.setForeground(Color.RED);
		lblNewLabel_2_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_1_1_1.setBounds(423, 235, 46, 14);
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

		txtTongTienHangDaBanNam = new JTextField();
		txtTongTienHangDaBanNam.setEditable(false);
		txtTongTienHangDaBanNam.setColumns(10);
		txtTongTienHangDaBanNam.setBounds(233, 168, 180, 20);
		panel_1_1_1.add(txtTongTienHangDaBanNam);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("Tổng tiền hàng đã bán :");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_2.setBounds(29, 167, 206, 20);
		panel_1_1_1.add(lblNewLabel_1_1_2_2);

		JLabel lblNewLabel_2_1_2_2 = new JLabel("VND");
		lblNewLabel_2_1_2_2.setForeground(Color.RED);
		lblNewLabel_2_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_2_2.setBounds(423, 171, 46, 14);
		panel_1_1_1.add(lblNewLabel_2_1_2_2);

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

		cbxChonNamThongKe = new JComboBox(nam);
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

		panelBieuDoThongKeNam = new JPanel();
		panelBieuDoThongKeNam.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeNam.setBounds(10, 31, 755, 415);
		panelBieuDoThongKeNgay_1_1.add(panelBieuDoThongKeNam);

		JPanel panelChuThichBieuDoThongKeNam = new JPanel();
		panelChuThichBieuDoThongKeNam.setBorder(
				new TitledBorder(null, "Ch\u00FA th\u00EDch : ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChuThichBieuDoThongKeNam.setBackground(SystemColor.menu);
		panelChuThichBieuDoThongKeNam.setBounds(10, 468, 755, 82);
		panelBieuDoThongKeNgay_1_1.add(panelChuThichBieuDoThongKeNam);

		btnXuatDuLieuNam = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuNam.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuNam.setBounds(623, 583, 174, 30);
		panelTabThongKeTheoNam.add(btnXuatDuLieuNam);

		btnTaoBaoCaoNam = new JButton("Tạo báo cáo");
		btnTaoBaoCaoNam.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTaoBaoCaoNam.setBounds(1004, 583, 136, 30);
		panelTabThongKeTheoNam.add(btnTaoBaoCaoNam);

		// <==============>
		btnThongKeNgay.addActionListener(this);
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
		// <====================>
		lamMoiThongKeNgay(jdcChonNgayThongKe);
		LoadDataThongKeNgay();
		
		lamMoiThongKeThang(cbxChonThangThongKe, cbxChonNamCuaThangThongKe);
		LoadDataThongKeThang();
		
		lamMoiThongKeNam(cbxChonNamThongKe);
		LoadDataThongKeNam();
	}

	
	// Định dạng số theo tiền Việt Nam (phân tách hàng nghìn bằng dấu ".")
		public String ChuyenThanhTien(float money) {
			long roundedMoney = Math.round(money);
			DecimalFormat decimalFormat = new DecimalFormat("#,###");
			String formattedMoney = decimalFormat.format(roundedMoney);
			return formattedMoney;
		}
	//<=================Thong ke ngay================>
	public void LoadDataThongKeNgay() {
		LocalDate ngayChonThongKe = getDateSelected(jdcChonNgayThongKe);
		LayDuLieuThongKeNgay(modelThongKeDoanhThuNgay, taiKhoan, ngayChonThongKe);
		loadDuLieuThongKeNgay(modelThongKeDoanhThuNgay, ngayChonThongKe, taiKhoan);
		VeBieuDoThongKeDoanhThuNgay(panelBieuDoThongKeTheoNgay, ngayChonThongKe, taiKhoan);
	}

	public void loadDuLieuThongKeNgay(ModelThongKeDoanhThuNgay modelThongKeDoanhThuNgay, LocalDate ngayChonThongKe,
			NhanVien taiKhoan) {
		modelThongKeDoanhThuNgay.setDate(ngayChonThongKe);
		modelThongKeDoanhThuNgay.setMaNhanVien(taiKhoan.getMaNhanVien().trim());

		txtThongKeTrenTaiKhoanNgay.setText(taiKhoan.getMaNhanVien().trim());
		txtTenNhanVienThongKeNgay.setText(taiKhoan.getHoTen().trim());
		txtNgayDuocThongKeNgay.setText(ngayChonThongKe.toString());

		txtTenNhanVienThongKeNgay.setText(taiKhoan.getHoTen().trim());
		txtNgayDuocThongKeNgay.setText(ngayChonThongKe.toString());
		txtTongSoHoaDonDuocLapNgay.setText(String.valueOf(modelThongKeDoanhThuNgay.getTongHdDuocLap()));
		txtTongSoLuongMatHangBanRaNgay.setText(String.valueOf(modelThongKeDoanhThuNgay.getTongMhBanRa()));
		txtTongDoanhThuNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongDoanhThu()));
		txtTongTienHangNhapNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongTienNhapHang()));
		txtTongTienHangDaBanNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongTienHangDaBan()));
		txtTongTienKhuyenMaiNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongTienKhuyenMai()));
		txtTongThueNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongThue()));
		txtTongTienLaiTrongNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongLai()));

	}

	private void LayDuLieuThongKeNgay(ModelThongKeDoanhThuNgay model, NhanVien taiKhoan, LocalDate today) {
		int tongHdDuocLap;
		int tongMhBanRa;
		float tongDoanhThu;
		float tongTienNhapHang;
		float tongTienHangDaBan;
		float tongTienKhuyenMai;
		float tongThue;
		float tongLai;
		model.setDate(today);
		model.setMaNhanVien(taiKhoan.getMaNhanVien().trim());
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();

		tongHdDuocLap = dao_ThongKeDoanhThu.TongHoaDonDocNhanVienLapTrongNgay(model.getDate(), model.getMaNhanVien());
		tongMhBanRa = dao_ThongKeDoanhThu.TongSoLuongMatHangNhanVienBanRaTrongNgay(model.getDate(),
				model.getMaNhanVien());
		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongNgayCuaNhanVien(model.getDate(), model.getMaNhanVien());
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongNgayNhanVienBan(model.getDate(),
				model.getMaNhanVien());
		tongTienHangDaBan = tongTienNhapHang + tongTienNhapHang * 0.7f;
		tongTienKhuyenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongNgayTheoNhanVien(model.getDate(),
				model.getMaNhanVien());
		tongThue = tongDoanhThu * 0.1f;
		tongLai = tongDoanhThu - tongTienNhapHang - tongTienKhuyenMai - tongThue;
		model.setTongHdDuocLap(tongHdDuocLap);
		model.setTongMhBanRa(tongMhBanRa);
		model.setTongDoanhThu(tongDoanhThu);
		model.setTongTienNhapHang(tongTienNhapHang);
		model.setTongTienHangDaBan(tongTienHangDaBan);
		model.setTongTienKhuyenMai(tongTienKhuyenMai);
		model.setTongThue(tongThue);
		model.setTongLai(tongLai);
	}

	public void VeBieuDoThongKeDoanhThuNgay(JPanel panelContain, LocalDate date, NhanVien nhanVien) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		LocalDate today = LocalDate.now();
		DuLieuBieuDoThongKeDoanhThu doanhThuNgayHienTai = new DuLieuBieuDoThongKeDoanhThu("Hôm nay ",
				dao_ThongKeDoanhThu.TongDoanhThuTrongNgayCuaNhanVien(today, nhanVien.getMaNhanVien().trim()));

		//ArrayList<DuLieuBieuDoThongKeDoanhThu> data = dao_ThongKeDoanhThu.Top5NgayDoanhThuCaoNhatTrongThang(10, 2022);
		ArrayList<DuLieuBieuDoThongKeDoanhThu> data = dao_ThongKeDoanhThu.duLieuBieuDo_Top5NgayDoanhThuCaoNhatTrongThangCuaNhanVien(date.getMonthValue(), date.getYear(), nhanVien.getMaNhanVien().trim());
		data.add(0, doanhThuNgayHienTai);
		panelContain.removeAll();
//		for(DuLieuBieuDoThongKeDoanhThu dl : data) {
//			System.out.println(dl.toString());
//		}
		BieuDoThongKePanel bieuDoThongKePanel = new BieuDoThongKePanel(data, "Doanh thu hôm nay và 5 ngày có doanh thu cao nhất tháng");
		panelContain.setLayout(new BorderLayout());
		panelContain.add(bieuDoThongKePanel, BorderLayout.CENTER);
		panelContain.revalidate(); // Cần revalidate để cập nhật giao diện
		panelContain.repaint(); // Cần repaint để vẽ lại giao diện
	}

	private LocalDate getDateSelected(JDateChooser chooser) {
		Date date = chooser.getDate();
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private void lamMoiThongKeNgay(JDateChooser chooser) {
		Calendar ngayHienTai = Calendar.getInstance();
		chooser.setDate(ngayHienTai.getTime());
	}
	
	//<===========thong ke thang ===========================>
	public void LoadDataThongKeThang() {
		int thangDuocChon = Integer.parseInt((String)cbxChonThangThongKe.getSelectedItem());
		int namCuaThang = Integer.parseInt((String)cbxChonNamCuaThangThongKe.getSelectedItem());
		LayDuLieuThongKeThang(modelThongKeDoanhThuThang, taiKhoan, thangDuocChon, namCuaThang);
		loadDuLieuThongKeThang(modelThongKeDoanhThuThang, thangDuocChon, namCuaThang, taiKhoan);
		VeBieuDoThongKeDoanhThuThang(panelBieuDoThongKeThang, thangDuocChon, namCuaThang, taiKhoan);
	}
	private void lamMoiThongKeThang(JComboBox<String> cbxThang, JComboBox<String> cbxNam) {
		LocalDate now = LocalDate.now();
		String[] nam = {"2019","2020", "2021", "2022", "2023","2024"};
		String[] thang = {"01", "02", "03","04","05","06","07","08","09","10","11","12"};
		int thangHt = now.getMonthValue();
		int namHt = now.getYear();
		for(String s : thang) {
			if(Integer.parseInt(s)== thangHt) {
				cbxThang.setSelectedItem(s);;
			}
		}
		for(String s : nam) {
			if(Integer.parseInt(s)== namHt) {
				cbxNam.setSelectedItem(s);;
			}
		}
	}
	private void LayDuLieuThongKeThang(ModelThongKeDoanhThuThang model, NhanVien taiKhoan, int thang, int namCuaThang) {
		int tongHdDuocLap;
		int tongMhBanRa;
		float tongDoanhThu;
		float tongTienNhapHang;
		float tongTienHangDaBan;
		float tongTienKhuyenMai;
		float tongThue;
		float tongLai;
		model.setThangThongKe(thang);
		model.setNamCuaThangThongKe(namCuaThang);
		model.setMaNhanVien(taiKhoan.getMaNhanVien().trim());
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();

		tongHdDuocLap = dao_ThongKeDoanhThu.TongHoaDonDuocNhanVienLapTrongThang(model.getThangThongKe(), model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongMhBanRa = dao_ThongKeDoanhThu.TongSoLuongMatHangNhanVienBanRaTrongThang(model.getThangThongKe(), model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongThangCuaNhanVien(model.getThangThongKe(), model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongThangNhanVienBan(model.getThangThongKe(), model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongTienHangDaBan = tongTienNhapHang + tongTienNhapHang * 0.7f;
		tongTienKhuyenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongThangTheoNhanVien(model.getThangThongKe(), model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongThue = tongDoanhThu * 0.1f;
		tongLai = tongDoanhThu - tongTienNhapHang - tongTienKhuyenMai - tongThue;
		model.setTongHdDuocLap(tongHdDuocLap);
		model.setTongMhBanRa(tongMhBanRa);
		model.setTongDoanhThu(tongDoanhThu);
		model.setTongTienNhapHang(tongTienNhapHang);
		model.setTongTienHangDaBan(tongTienHangDaBan);
		model.setTongTienKhuyenMai(tongTienKhuyenMai);
		model.setTongThue(tongThue);
		model.setTongLai(tongLai);
	}
	public void loadDuLieuThongKeThang(ModelThongKeDoanhThuThang model,int thang, int namCuaThang,
			NhanVien taiKhoan) {
		
		model.setThangThongKe(thang);
		model.setNamCuaThangThongKe(namCuaThang);
		model.setMaNhanVien(taiKhoan.getMaNhanVien().trim());

		txtTaiKhoanDuocThongKeThang.setText(taiKhoan.getMaNhanVien().trim());
		txtTenNhanVienDuocThongKeThang.setText(taiKhoan.getHoTen().trim());
		txtThangDuocThongKe.setText("Tháng "+thang+" năm "+namCuaThang);
		txtTongSoHoaDonDuocLapTrongThang.setText(String.valueOf(model.getTongHdDuocLap()));
		txtTongSoLuongMatHangBanRaTrongThang.setText(String.valueOf(model.getTongMhBanRa()));
		txtTongDoanhThuTrongThnag.setText(ChuyenThanhTien(model.getTongDoanhThu()));
		txtTongTienNhapHangTrongThang.setText(ChuyenThanhTien(model.getTongTienNhapHang()));
		txtTongTienHangDaBanThang.setText(ChuyenThanhTien(model.getTongTienHangDaBan()));
		txtTongTienKhuenMaiTrongThang.setText(ChuyenThanhTien(model.getTongTienKhuyenMai()));
		txtTongThueTrongThang.setText(ChuyenThanhTien(model.getTongThue()));
		txtTongTienLaiTrongThang.setText(ChuyenThanhTien(model.getTongLai()));
	}
	public void VeBieuDoThongKeDoanhThuThang(JPanel panelContain, int thang, int namCuaThang, NhanVien nhanVien) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		ArrayList<DuLieuBieuDoThongKeDoanhThu> data = dao_ThongKeDoanhThu.duLieuBieuDo_DoanhThuCacNgaTrongThangTheoNhanVien(thang, namCuaThang, nhanVien.getMaNhanVien().trim());
		panelContain.removeAll();
		BieuDoThongKePanel bieuDoThongKePanel = new BieuDoThongKePanel(data, "Doanh thu các ngày trong tháng " + thang + " năm "+namCuaThang);
		panelContain.setLayout(new BorderLayout());
		panelContain.add(bieuDoThongKePanel, BorderLayout.CENTER);
		panelContain.revalidate(); // Cần revalidate để cập nhật giao diện
		panelContain.repaint(); // Cần repaint để vẽ lại giao diện
	}
	
	//<=========Thong ke nam==========>
	public void LoadDataThongKeNam() {
		int namDuocChon = Integer.parseInt((String)cbxChonNamThongKe.getSelectedItem());
		LayDuLieuThongKeNam(modelThongKeDoanhThuNam, taiKhoan, namDuocChon);
		loadDuLieuThongKeNam(modelThongKeDoanhThuNam, namDuocChon,taiKhoan);
		VeBieuDoThongKeDoanhThuNam(panelBieuDoThongKeNam, namDuocChon, taiKhoan);
	}
	private void lamMoiThongKeNam(JComboBox<String> cbxNamThongke) {
		LocalDate now = LocalDate.now();
		String[] nam = {"2019","2020", "2021", "2022", "2023","2024"};
		int thangHt = now.getMonthValue();
		int namHt = now.getYear();
		
		for(String s : nam) {
			if(Integer.parseInt(s)== namHt) {
				cbxNamThongke.setSelectedItem(s);;
			}
		}
	}
	private void LayDuLieuThongKeNam(ModelThongKeDoanhThuNam model, NhanVien taiKhoan, int namThongKe) {
		int tongHdDuocLap;
		int tongMhBanRa;
		float tongDoanhThu;
		float tongTienNhapHang;
		float tongTienHangDaBan;
		float tongTienKhuyenMai;
		float tongThue;
		float tongLai;
		model.setNamThongKe(namThongKe);
		model.setMaNhanVien(taiKhoan.getMaNhanVien().trim());
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();

		tongHdDuocLap = dao_ThongKeDoanhThu.TongHoaDonDuocNhanVienLapTrongNam(namThongKe, taiKhoan.getMaNhanVien().trim());
		tongMhBanRa = dao_ThongKeDoanhThu.TongSoLuongMatHangNhanVienBanRaTrongNam(namThongKe, taiKhoan.getMaNhanVien().trim());
		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongNamCuaNhanVien(namThongKe, taiKhoan.getMaNhanVien().trim());
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongNamNhanVienBan(namThongKe, taiKhoan.getMaNhanVien().trim());
		tongTienHangDaBan = tongTienNhapHang + tongTienNhapHang * 0.7f;
		tongTienKhuyenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongNamTheoNhanVien(namThongKe, taiKhoan.getMaNhanVien().trim());
		tongThue = tongDoanhThu * 0.1f;
		tongLai = tongDoanhThu - tongTienNhapHang - tongTienKhuyenMai - tongThue;
		model.setTongHdDuocLap(tongHdDuocLap);
		model.setTongMhBanRa(tongMhBanRa);
		model.setTongDoanhThu(tongDoanhThu);
		model.setTongTienNhapHang(tongTienNhapHang);
		model.setTongTienHangDaBan(tongTienHangDaBan);
		model.setTongTienKhuyenMai(tongTienKhuyenMai);
		model.setTongThue(tongThue);
		model.setTongLai(tongLai);
	}
	public void loadDuLieuThongKeNam(ModelThongKeDoanhThuNam model,int namThongKe,
			NhanVien taiKhoan) {
		
		model.setNamThongKe(namThongKe);
		model.setMaNhanVien(taiKhoan.getMaNhanVien().trim());

		txtTaiKhoanDuocThongKe.setText(taiKhoan.getMaNhanVien().trim());
		txtTenNhanVienDuocThongKe.setText(taiKhoan.getHoTen().trim());
		txtNamDuocThongKe.setText(String.valueOf(namThongKe));
		txtTongSoHoaDonDuocLapNam.setText(String.valueOf(model.getTongHdDuocLap()));
		txtTongSoLuongMatHangBanRaTrongNam.setText(String.valueOf(model.getTongMhBanRa()));
		txtTongDoanhThuNam.setText(ChuyenThanhTien(model.getTongDoanhThu()));
		txtTongTienNhapHangNam.setText(ChuyenThanhTien(model.getTongTienNhapHang()));
		txtTongTienHangDaBanNam.setText(ChuyenThanhTien(model.getTongTienHangDaBan()));
		txtTongTienKhuyenMaiNam.setText(ChuyenThanhTien(model.getTongTienKhuyenMai()));
		txtTongThueNam.setText(ChuyenThanhTien(model.getTongThue()));
		txtTongTienLaiNam.setText(ChuyenThanhTien(model.getTongLai()));
	}
	public void VeBieuDoThongKeDoanhThuNam(JPanel panelContain, int namThongKe, NhanVien nhanVien) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		ArrayList<DuLieuBieuDoThongKeDoanhThu> data = dao_ThongKeDoanhThu.duLieuBieuDo_DoanhThuCacThangTrongNam(namThongKe, nhanVien.getMaNhanVien().trim());
		panelContain.removeAll();
		BieuDoThongKePanel bieuDoThongKePanel = new BieuDoThongKePanel(data, "Doanh thu các tháng trong năm "+namThongKe);
		panelContain.setLayout(new BorderLayout());
		panelContain.add(bieuDoThongKePanel, BorderLayout.CENTER);
		panelContain.revalidate(); // Cần revalidate để cập nhật giao diện
		panelContain.repaint(); // Cần repaint để vẽ lại giao diện
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThongKeNgay)) {
			LoadDataThongKeNgay();
		} else if (o.equals(btnLamMoiThongKeNgay)) {
			lamMoiThongKeNgay(jdcChonNgayThongKe);
			LoadDataThongKeNgay();
		} else if(o.equals(btnThongKeThang)) {
			LoadDataThongKeThang();
		} else if(o.equals(btnLamMoiThongKeThang)) {
			lamMoiThongKeThang(cbxChonThangThongKe, cbxChonNamCuaThangThongKe);
			LoadDataThongKeThang();
		}else if(o.equals(btnXuatDuLieuNgay)) {
			ThongKeDoanhThuServices thongKeDoanhThuServices = new ThongKeDoanhThuServices();
			boolean flag = thongKeDoanhThuServices.xuatDuLieuThongKeDoanhThuNgayTheoNvExcel(modelThongKeDoanhThuNgay);
			if(flag)
				JOptionPane.showMessageDialog(this, "Xuất dữ liệu thành công ");
			else 
				JOptionPane.showMessageDialog(this, "Đã hủy quá trình xuất dữ liệu ");
		} else if(o.equals(btnXuatDuLieuThang)) {
			ThongKeDoanhThuServices thongKeDoanhThuServices = new ThongKeDoanhThuServices();
			int thang = Integer.parseInt((String)cbxChonThangThongKe.getSelectedItem());
			int nam = Integer.parseInt((String)cbxChonNamCuaThangThongKe.getSelectedItem());
			ArrayList<ModelThongKeDoanhThuNgay> data = thongKeDoanhThuServices.thongKeCacNgayTrongThangTheoNv(thang, nam, taiKhoan);
			boolean flag = thongKeDoanhThuServices.xuatDuLieuThongKeDoanhThuThangTheoNvExcel(data);
			if(flag)
				JOptionPane.showMessageDialog(this, "Xuất dữ liệu thành công ");
			else 
				JOptionPane.showMessageDialog(this, "Đã hủy quá trình xuất dữ liệu ");
		} else if(o.equals(btnXuatDuLieuNam)) {
			ThongKeDoanhThuServices thongKeDoanhThuServices = new ThongKeDoanhThuServices();
			int nam = Integer.parseInt((String)cbxChonNamCuaThangThongKe.getSelectedItem());
			ArrayList<ModelThongKeDoanhThuThang> data = thongKeDoanhThuServices.thongKeDoanhThuCacThangTrongNam(nam, taiKhoan);
			boolean flag = thongKeDoanhThuServices.xuatDuLieuThongKeDoanhThuNamTheoNvExcel(data);
			if(flag)
				JOptionPane.showMessageDialog(this, "Xuất dữ liệu thành công ");
			else 
				JOptionPane.showMessageDialog(this, "Đã hủy quá trình xuất dữ liệu ");
		}else if(o.equals(btnThongKeNam)) {
			LoadDataThongKeNam();
		} else if(o.equals(btnLamMoiThongKeNam)) {
			lamMoiThongKeNam(cbxChonNamThongKe);
			LoadDataThongKeNam();
		}
	}
}
