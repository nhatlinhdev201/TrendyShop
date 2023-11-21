package gui.admin;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
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
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import constance.ModelExportFileThongKe;
import constance.ModelThongKeDoanhThu;
import daos.Dao_ThongKeDoanhThu;
import entities.NhanVien;
import services.ThongKeDoanhThuServices;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.Label;

public class TK_ThongKeDoanhThuNVQuanLyJPanel extends JPanel implements ActionListener {
	private String[] cols = { "Xếp hạng theo doanh thu", "Nhân viên", "Tổng doanh thu (vnđ)",
			"Tổng lãi trong ngày (vnđ)", "Số hóa đơn được lập" };
	private String[] nam = { "2019", "2020", "2021", "2022", "2023" };
	private String[] thang = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	private DefaultTableModel modelTableThongKeNgay;
	private ModelThongKeDoanhThu dataToanCuaHangTrongNgay;
	private ArrayList<ModelThongKeDoanhThu> dataThongKeNhanVienNgay;
	

	private DefaultTableModel modelTableThongKeThang;
	private ModelThongKeDoanhThu dataToanCuaHangTrongThang;
	private ArrayList<ModelThongKeDoanhThu> dataThongKeNhanVienThang;
	private ArrayList<ModelThongKeDoanhThu> dataThongKeCacNgayTrongThangCh;
	
	private DefaultTableModel modelTableThongKeNam;
	private ModelThongKeDoanhThu dataToanCuaHangTrongNam;
	private ArrayList<ModelThongKeDoanhThu> dataThongKeNhanVienNam;
	private ArrayList<ModelThongKeDoanhThu> dataThongKeCacThangTrongNamCh;

	private JButton btnLocDuLieuNgay;
	private JButton btnXuatDuLieuThongKeNgay;
	private JTable tblDuLieuTKNVNgay;
	private JTextField txtDoanhThuCHNgay;
	private JTextField txtTongLaiCHNgay;
	private JTextField txtTongTienNhapHangCHNgay;
	private JTextField txtTongSoHoaDonDuocLapCHNgay;
	private JTextField txtTongThueCHNgay;
	private JTextField txtTongKhuyenMaiCHNgay;
	private JDateChooser jdcChonNgayThongKe;
	private JButton btnLamMoiDuLieuNhanVienNgay;
	private JPanel panelBieuDoThongKeDoanhThuNgay;
	private JTextField txtThongTinTimKiemNgay;
	private JButton btnThongKeNgay;
	private JButton btnLamMoiThongKeNgay;
	private JTextField txtThongTinTimKiemNhanVienThang;
	private JTextField txtTongDoanhThuThangToanCh;
	private JTextField txtTongLaiThangToanCh;
	private JTextField txtTongTienNhapHangThangToanCh;
	private JTextField txtTongSoHoaDonThangToanCh;
	private JTextField txtTongThueThangToanch;
	private JTextField txtTongKhuyenMaiThangToanCh;
	private JComboBox<String> cbxChonThangThongKe;
	private JComboBox<String> cbxChonNamCuaThangThongKe;
	private JTable tblNhanVienThang;
	private JPanel panelBieuDoThongKeDoanhThuThang;
	private JButton btnThongKeThang;
	private JButton btnXuatDuLieuThongKeThang;
	private JButton btnLocDuLieuThang;
	private JButton btnLamMoiDuLieuNvThang;
	private JButton btnLamMoiThongKeThang;
	private JTextField txtThongTinTimKiemNhanVienNam;
	private JTextField txtTongDoanhThuNam;
	private JTextField txtTongLaiNam;
	private JTextField txtTongTienNhapHangNam;
	private JTextField txtTongSoHoaDonNam;
	private JTextField txtTongThueNam;
	private JTextField txtTongKhuyenMaiNam;
	private JTable tblBangNhanVienNam;
	private JComboBox<String> cbxChonNamThongKe;
	private JButton btnThongKeNam;
	private JButton btnLamMoiThongKeNam;
	private JButton btnLamMoiDuLieuNvNam;
	private JButton btnLocDuLieuNvNam;
	private JPanel panelBieuDoThongKeDoanhThuNam;
	private JButton btnXuatDuLieuThongKeNam;

	/**
	 * Create the panel.
	 */
	public TK_ThongKeDoanhThuNVQuanLyJPanel() {
		this.setBounds(0, 0, 1350, 640);
		setLayout(null);

		JPanel panelCN_CNThongKeDoanhThu = new JPanel();
		panelCN_CNThongKeDoanhThu.setBounds(0, 0, 1350, 638);
		add(panelCN_CNThongKeDoanhThu);
		;
		panelCN_CNThongKeDoanhThu.setLayout(null);

		JLabel lblNewLabel = new JLabel("THỐNG KÊ DOANH THU");
		lblNewLabel.setBounds(583, 0, 196, 25);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelCN_CNThongKeDoanhThu.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 1350, 627);
		panelCN_CNThongKeDoanhThu.add(tabbedPane);
		// <==========================================================>
		JPanel panelTabThongKeTheoNgay = new JPanel();
		panelTabThongKeTheoNgay.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Thống kê trong ngày", null, panelTabThongKeTheoNgay, null);
		panelTabThongKeTheoNgay.setLayout(null);

		JPanel panelDuLieuThongKe = new JPanel();
		panelDuLieuThongKe.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDuLieuThongKe.setBounds(10, 11, 791, 579);
		panelTabThongKeTheoNgay.add(panelDuLieuThongKe);
		panelDuLieuThongKe.setLayout(null);

		JPanel panelBoLocTimKiem = new JPanel();
		panelBoLocTimKiem.setBounds(10, 324, 769, 82);
		panelDuLieuThongKe.add(panelBoLocTimKiem);
		panelBoLocTimKiem.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelBoLocTimKiem.setLayout(null);

		JLabel lblTenNVTimKiem = new JLabel("Thông tin tìm kiếm");
		lblTenNVTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNVTimKiem.setBounds(27, 29, 133, 23);
		panelBoLocTimKiem.add(lblTenNVTimKiem);

		txtThongTinTimKiemNgay = new JTextField();
		txtThongTinTimKiemNgay.setColumns(10);
		txtThongTinTimKiemNgay.setBounds(170, 30, 191, 22);
		panelBoLocTimKiem.add(txtThongTinTimKiemNgay);

		btnLocDuLieuNgay = new JButton("Lọc dữ liệu");
		btnLocDuLieuNgay.setBounds(410, 26, 151, 31);
		panelBoLocTimKiem.add(btnLocDuLieuNgay);
		btnLocDuLieuNgay.addActionListener(this);

		btnLamMoiDuLieuNhanVienNgay = new JButton("Làm mới dữ liệu");
		btnLamMoiDuLieuNhanVienNgay.setBounds(571, 26, 151, 31);
		panelBoLocTimKiem.add(btnLamMoiDuLieuNhanVienNgay);
		btnLamMoiDuLieuNhanVienNgay.addActionListener(this);

		JPanel panelBangNhanVienTKDTNgay = new JPanel();
		panelBangNhanVienTKDTNgay.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBangNhanVienTKDTNgay.setBounds(10, 417, 769, 151);
		panelDuLieuThongKe.add(panelBangNhanVienTKDTNgay);
		panelBangNhanVienTKDTNgay.setLayout(new BorderLayout(0, 0));

		modelTableThongKeNgay = new DefaultTableModel(cols, 0);
		tblDuLieuTKNVNgay = new JTable(modelTableThongKeNgay);
		panelBangNhanVienTKDTNgay.add(new JScrollPane(tblDuLieuTKNVNgay), BorderLayout.CENTER);
		for(int i=2; i < cols.length; i++) {
        	TableColumn column = tblDuLieuTKNVNgay.getColumnModel().getColumn(i);
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.RIGHT);
            column.setCellRenderer(renderer);
        }
		tblDuLieuTKNVNgay.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tblDuLieuTKNVNgay.getSelectedRow();
				if (selectedRow != -1) {
					String tenNhanVien = (String) tblDuLieuTKNVNgay.getValueAt(selectedRow, 1);
					txtThongTinTimKiemNgay.setText(tenNhanVien);
				}
				;
			}
		});

		JPanel panelBieuDoThongKeNgay = new JPanel();
		panelBieuDoThongKeNgay.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBieuDoThongKeNgay.setBounds(811, 11, 524, 494);
		panelTabThongKeTheoNgay.add(panelBieuDoThongKeNgay);
		panelBieuDoThongKeNgay.setLayout(null);

		panelBieuDoThongKeDoanhThuNgay = new JPanel();
		panelBieuDoThongKeDoanhThuNgay.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeDoanhThuNgay.setBounds(10, 11, 504, 473);
		panelBieuDoThongKeNgay.add(panelBieuDoThongKeDoanhThuNgay);
		panelBieuDoThongKeDoanhThuNgay.setLayout(null);

		btnXuatDuLieuThongKeNgay = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuThongKeNgay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuThongKeNgay.setBounds(1010, 516, 174, 30);
		panelTabThongKeTheoNgay.add(btnXuatDuLieuThongKeNgay);
		btnXuatDuLieuThongKeNgay.addActionListener(this);

		// <=============================================================>
		JPanel panelTabThongKeTheoThang = new JPanel();
		panelTabThongKeTheoThang.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Thống kê trong tháng", null, panelTabThongKeTheoThang, null);
		panelTabThongKeTheoThang.setLayout(null);

		JPanel panelDuLieuThongKe_1 = new JPanel();
		panelDuLieuThongKe_1.setLayout(null);
		panelDuLieuThongKe_1.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",

				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDuLieuThongKe_1.setBounds(10, 11, 791, 579);
		panelTabThongKeTheoThang.add(panelDuLieuThongKe_1);

		JPanel panelBoLocTimKiem_1 = new JPanel();
		panelBoLocTimKiem_1.setLayout(null);
		panelBoLocTimKiem_1
				.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING,

						TitledBorder.TOP, null, null));
		panelBoLocTimKiem_1.setBounds(10, 324, 769, 82);
		panelDuLieuThongKe_1.add(panelBoLocTimKiem_1);

		JLabel lblTenNVTimKiem_1 = new JLabel("Thông tin tìm kiếm");
		lblTenNVTimKiem_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNVTimKiem_1.setBounds(27, 29, 133, 23);
		panelBoLocTimKiem_1.add(lblTenNVTimKiem_1);

		txtThongTinTimKiemNhanVienThang = new JTextField();
		txtThongTinTimKiemNhanVienThang.setColumns(10);
		txtThongTinTimKiemNhanVienThang.setBounds(170, 30, 191, 22);
		panelBoLocTimKiem_1.add(txtThongTinTimKiemNhanVienThang);

		btnLocDuLieuThang = new JButton("Lọc dữ liệu");
		btnLocDuLieuThang.setBounds(410, 26, 151, 31);
		panelBoLocTimKiem_1.add(btnLocDuLieuThang);
		btnLocDuLieuThang.addActionListener(this);

		btnLamMoiDuLieuNvThang = new JButton("Làm mới dữ liệu");
		btnLamMoiDuLieuNvThang.setBounds(571, 26, 151, 31);
		panelBoLocTimKiem_1.add(btnLamMoiDuLieuNvThang);
		btnLamMoiDuLieuNvThang.addActionListener(this);

		JPanel panelBangNhanVienTKDTThang = new JPanel();
		panelBangNhanVienTKDTThang.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBangNhanVienTKDTThang.setBounds(10, 417, 769, 151);
		panelDuLieuThongKe_1.add(panelBangNhanVienTKDTThang);
		panelBangNhanVienTKDTThang.setLayout(new BorderLayout(0, 0));

		modelTableThongKeThang = new DefaultTableModel(cols, 0);
		tblNhanVienThang = new JTable(modelTableThongKeThang);
		panelBangNhanVienTKDTThang.add(new JScrollPane(tblNhanVienThang), BorderLayout.CENTER);
		for(int i=2; i < cols.length; i++) {
        	TableColumn column = tblNhanVienThang.getColumnModel().getColumn(i);
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.RIGHT);
            column.setCellRenderer(renderer);
        }
		tblNhanVienThang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tblNhanVienThang.getSelectedRow();
				if (selectedRow != -1) {
					String tenNhanVien = (String) tblNhanVienThang.getValueAt(selectedRow, 1);
					txtThongTinTimKiemNhanVienThang.setText(tenNhanVien);
				}
				;
			}
		});

		JLabel lblNewLabel_1_2 = new JLabel("DỮ LIỆU THỐNG KÊ DOANH THU BÁN HÀNG THEO NHÂN VIÊN");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(193, 281, 416, 23);
		panelDuLieuThongKe_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("DỮ LIỆU THỐNG KÊ DOANH THU BÁN HÀNG TRÊN TOÀN CỬA HÀNG");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(194, 11, 432, 23);
		panelDuLieuThongKe_1.add(lblNewLabel_1_1_1);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 119, 771, 120);
		panelDuLieuThongKe_1.add(panel_3);

		JLabel lblTngDoanhThu_1 = new JLabel("Tổng doanh thu :");
		lblTngDoanhThu_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngDoanhThu_1.setBounds(10, 11, 108, 23);
		panel_3.add(lblTngDoanhThu_1);

		txtTongDoanhThuThangToanCh = new JTextField();
		txtTongDoanhThuThangToanCh.setText((String) null);
		txtTongDoanhThuThangToanCh.setEditable(false);
		txtTongDoanhThuThangToanCh.setColumns(10);
		txtTongDoanhThuThangToanCh.setBounds(143, 13, 154, 20);
		panel_3.add(txtTongDoanhThuThangToanCh);

		JLabel lblVn_3 = new JLabel("vnđ");
		lblVn_3.setForeground(Color.RED);
		lblVn_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_3.setBounds(303, 11, 36, 23);
		panel_3.add(lblVn_3);

		JLabel lblTngLi_1 = new JLabel("Tổng lãi  :");
		lblTngLi_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngLi_1.setBounds(10, 81, 81, 23);
		panel_3.add(lblTngLi_1);

		txtTongLaiThangToanCh = new JTextField();
		txtTongLaiThangToanCh.setText((String) null);
		txtTongLaiThangToanCh.setEditable(false);
		txtTongLaiThangToanCh.setColumns(10);
		txtTongLaiThangToanCh.setBounds(143, 84, 154, 20);
		panel_3.add(txtTongLaiThangToanCh);

		JLabel lblVn_1_2 = new JLabel("vnđ");
		lblVn_1_2.setForeground(Color.RED);
		lblVn_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_1_2.setBounds(303, 81, 36, 23);
		panel_3.add(lblVn_1_2);

		JLabel lblTngTinNhp_1 = new JLabel("Tổng tiền nhập hàng :");
		lblTngTinNhp_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngTinNhp_1.setBounds(10, 45, 151, 23);
		panel_3.add(lblTngTinNhp_1);

		txtTongTienNhapHangThangToanCh = new JTextField();
		txtTongTienNhapHangThangToanCh.setText((String) null);
		txtTongTienNhapHangThangToanCh.setEditable(false);
		txtTongTienNhapHangThangToanCh.setColumns(10);
		txtTongTienNhapHangThangToanCh.setBounds(143, 48, 154, 20);
		panel_3.add(txtTongTienNhapHangThangToanCh);

		JLabel lblVn_2_1 = new JLabel("vnđ");
		lblVn_2_1.setForeground(Color.RED);
		lblVn_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_2_1.setBounds(303, 45, 36, 23);
		panel_3.add(lblVn_2_1);

		JLabel lblTngThu_2 = new JLabel("Tổng số Hóa đơn  :");
		lblTngThu_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngThu_2.setBounds(415, 11, 122, 23);
		panel_3.add(lblTngThu_2);

		JLabel lblVn_1_1_3 = new JLabel("hóa đơn");
		lblVn_1_1_3.setForeground(Color.RED);
		lblVn_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_1_1_3.setBounds(638, 11, 81, 23);
		panel_3.add(lblVn_1_1_3);

		txtTongSoHoaDonThangToanCh = new JTextField();
		txtTongSoHoaDonThangToanCh.setText((String) null);
		txtTongSoHoaDonThangToanCh.setEditable(false);
		txtTongSoHoaDonThangToanCh.setColumns(10);
		txtTongSoHoaDonThangToanCh.setBounds(547, 13, 81, 20);
		panel_3.add(txtTongSoHoaDonThangToanCh);

		JLabel lblTngThu_1_1 = new JLabel("Tổng thuế  :");
		lblTngThu_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngThu_1_1.setBounds(415, 45, 81, 23);
		panel_3.add(lblTngThu_1_1);

		txtTongThueThangToanch = new JTextField();
		txtTongThueThangToanch.setText((String) null);
		txtTongThueThangToanch.setEditable(false);
		txtTongThueThangToanch.setColumns(10);
		txtTongThueThangToanch.setBounds(547, 47, 154, 20);
		panel_3.add(txtTongThueThangToanch);

		JLabel lblVn_1_1_1_1 = new JLabel("vnđ");
		lblVn_1_1_1_1.setForeground(Color.RED);
		lblVn_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_1_1_1_1.setBounds(707, 45, 36, 23);
		panel_3.add(lblVn_1_1_1_1);

		JLabel lblTngKhuynMi_1 = new JLabel("Tổng khuyến mãi  :");
		lblTngKhuynMi_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngKhuynMi_1.setBounds(415, 81, 122, 23);
		panel_3.add(lblTngKhuynMi_1);

		txtTongKhuyenMaiThangToanCh = new JTextField();
		txtTongKhuyenMaiThangToanCh.setText((String) null);
		txtTongKhuyenMaiThangToanCh.setEditable(false);
		txtTongKhuyenMaiThangToanCh.setColumns(10);
		txtTongKhuyenMaiThangToanCh.setBounds(547, 83, 154, 20);
		panel_3.add(txtTongKhuyenMaiThangToanCh);

		JLabel lblVn_1_1_2_1 = new JLabel("vnđ");
		lblVn_1_1_2_1.setForeground(Color.RED);
		lblVn_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_1_1_2_1.setBounds(707, 81, 36, 23);
		panel_3.add(lblVn_1_1_2_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(Color.RED));
		panel_1_1.setBounds(85, 266, 609, 4);
		panelDuLieuThongKe_1.add(panel_1_1);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBounds(10, 42, 769, 66);
		panelDuLieuThongKe_1.add(panel_2_1);

		JLabel lblThongKeNgay_1 = new JLabel("Thống kê tháng :");
		lblThongKeNgay_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay_1.setBounds(34, 26, 114, 23);
		panel_2_1.add(lblThongKeNgay_1);

		btnThongKeThang = new JButton("Thống kê");
		btnThongKeThang.setBounds(408, 22, 135, 33);
		panel_2_1.add(btnThongKeThang);
		btnThongKeThang.addActionListener(this);

		btnLamMoiThongKeThang = new JButton("Làm mới thống kê");
		btnLamMoiThongKeThang.setBounds(567, 22, 163, 33);
		panel_2_1.add(btnLamMoiThongKeThang);
		btnLamMoiThongKeThang.addActionListener(this);

		cbxChonThangThongKe = new JComboBox(thang);
		cbxChonThangThongKe.setBounds(146, 27, 39, 22);
		panel_2_1.add(cbxChonThangThongKe);

		cbxChonNamCuaThangThongKe = new JComboBox(nam);
		cbxChonNamCuaThangThongKe.setBounds(253, 27, 59, 22);
		panel_2_1.add(cbxChonNamCuaThangThongKe);

		JLabel lblNewLabel_5 = new JLabel("Năm :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(211, 28, 46, 19);
		panel_2_1.add(lblNewLabel_5);

		JPanel panelBieuDoThongKeNgay_1 = new JPanel();
		panelBieuDoThongKeNgay_1.setLayout(null);
		panelBieuDoThongKeNgay_1.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",

				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBieuDoThongKeNgay_1.setBounds(811, 11, 524, 498);
		panelTabThongKeTheoThang.add(panelBieuDoThongKeNgay_1);

		panelBieuDoThongKeDoanhThuThang = new JPanel();
		panelBieuDoThongKeDoanhThuThang.setLayout(null);
		panelBieuDoThongKeDoanhThuThang.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeDoanhThuThang.setBounds(10, 11, 504, 475);
		panelBieuDoThongKeNgay_1.add(panelBieuDoThongKeDoanhThuThang);

		btnXuatDuLieuThongKeThang = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuThongKeThang.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuThongKeThang.setBounds(1011, 520, 174, 30);
		btnXuatDuLieuThongKeThang.addActionListener(this);
		panelTabThongKeTheoThang.add(btnXuatDuLieuThongKeThang);

		// <==================================================>
		JPanel panelTabThongKeTheoNam = new JPanel();
		panelTabThongKeTheoNam.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Thống kê trong năm", null, panelTabThongKeTheoNam, null);
		panelTabThongKeTheoNam.setLayout(null);

		JPanel panelDuLieuThongKe_1_1 = new JPanel();
		panelDuLieuThongKe_1_1.setLayout(null);
		panelDuLieuThongKe_1_1.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",

				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDuLieuThongKe_1_1.setBounds(10, 11, 791, 579);
		panelTabThongKeTheoNam.add(panelDuLieuThongKe_1_1);

		JPanel panelBoLocTimKiem_1_1 = new JPanel();
		panelBoLocTimKiem_1_1.setLayout(null);
		panelBoLocTimKiem_1_1
				.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING,

						TitledBorder.TOP, null, null));
		panelBoLocTimKiem_1_1.setBounds(10, 324, 769, 82);
		panelDuLieuThongKe_1_1.add(panelBoLocTimKiem_1_1);

		JLabel lblTenNVTimKiem_1_1 = new JLabel("Thông tin tìm kiếm");
		lblTenNVTimKiem_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNVTimKiem_1_1.setBounds(27, 29, 133, 23);
		panelBoLocTimKiem_1_1.add(lblTenNVTimKiem_1_1);

		txtThongTinTimKiemNhanVienNam = new JTextField();
		txtThongTinTimKiemNhanVienNam.setColumns(10);
		txtThongTinTimKiemNhanVienNam.setBounds(170, 30, 191, 22);
		panelBoLocTimKiem_1_1.add(txtThongTinTimKiemNhanVienNam);

		btnLocDuLieuNvNam = new JButton("Lọc dữ liệu");
		btnLocDuLieuNvNam.setBounds(410, 26, 151, 31);
		panelBoLocTimKiem_1_1.add(btnLocDuLieuNvNam);
		btnLocDuLieuNvNam.addActionListener(this);

		btnLamMoiDuLieuNvNam = new JButton("Làm mới dữ liệu");
		btnLamMoiDuLieuNvNam.setBounds(571, 26, 151, 31);
		panelBoLocTimKiem_1_1.add(btnLamMoiDuLieuNvNam);
		btnLamMoiDuLieuNvNam.addActionListener(this);

		JPanel panelBangNhanVienTKDTNam = new JPanel();
		panelBangNhanVienTKDTNam.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBangNhanVienTKDTNam.setBounds(10, 417, 769, 151);
		panelDuLieuThongKe_1_1.add(panelBangNhanVienTKDTNam);
		panelBangNhanVienTKDTNam.setLayout(new BorderLayout(0, 0));
		
		modelTableThongKeNam = new DefaultTableModel(cols, 0);
		tblBangNhanVienNam = new JTable(modelTableThongKeNam);
		panelBangNhanVienTKDTNam.add(new JScrollPane(tblBangNhanVienNam), BorderLayout.CENTER);
		// Đặt căn lề phải cho cột 
        for(int i=2; i < cols.length; i++) {
        	TableColumn column = tblBangNhanVienNam.getColumnModel().getColumn(i);
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.RIGHT);
            column.setCellRenderer(renderer);
        }
		tblBangNhanVienNam.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tblBangNhanVienNam.getSelectedRow();
				if (selectedRow != -1) {
					String tenNhanVien = (String) tblBangNhanVienNam.getValueAt(selectedRow, 1);
					txtThongTinTimKiemNhanVienNam.setText(tenNhanVien);
				}
				;
			}
		});
		
		JLabel lblNewLabel_1_2_1 = new JLabel("DỮ LIỆU THỐNG KÊ DOANH THU BÁN HÀNG THEO NHÂN VIÊN");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(193, 281, 416, 23);
		panelDuLieuThongKe_1_1.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("DỮ LIỆU THỐNG KÊ DOANH THU BÁN HÀNG TRÊN TOÀN CỬA HÀNG");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(194, 11, 432, 23);
		panelDuLieuThongKe_1_1.add(lblNewLabel_1_1_1_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3_1.setBounds(10, 119, 771, 120);
		panelDuLieuThongKe_1_1.add(panel_3_1);

		JLabel lblTngDoanhThu_1_1 = new JLabel("Tổng doanh thu :");
		lblTngDoanhThu_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngDoanhThu_1_1.setBounds(10, 11, 108, 23);
		panel_3_1.add(lblTngDoanhThu_1_1);

		txtTongDoanhThuNam = new JTextField();
		txtTongDoanhThuNam.setText((String) null);
		txtTongDoanhThuNam.setEditable(false);
		txtTongDoanhThuNam.setColumns(10);
		txtTongDoanhThuNam.setBounds(143, 13, 154, 20);
		panel_3_1.add(txtTongDoanhThuNam);

		JLabel lblVn_3_1 = new JLabel("vnđ");
		lblVn_3_1.setForeground(Color.RED);
		lblVn_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_3_1.setBounds(303, 11, 36, 23);
		panel_3_1.add(lblVn_3_1);

		JLabel lblTngLi_1_1 = new JLabel("Tổng lãi  :");
		lblTngLi_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngLi_1_1.setBounds(10, 81, 81, 23);
		panel_3_1.add(lblTngLi_1_1);

		txtTongLaiNam = new JTextField();
		txtTongLaiNam.setText((String) null);
		txtTongLaiNam.setEditable(false);
		txtTongLaiNam.setColumns(10);
		txtTongLaiNam.setBounds(143, 84, 154, 20);
		panel_3_1.add(txtTongLaiNam);

		JLabel lblVn_1_2_1 = new JLabel("vnđ");
		lblVn_1_2_1.setForeground(Color.RED);
		lblVn_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_1_2_1.setBounds(303, 81, 36, 23);
		panel_3_1.add(lblVn_1_2_1);

		JLabel lblTngTinNhp_1_1 = new JLabel("Tổng tiền nhập hàng :");
		lblTngTinNhp_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngTinNhp_1_1.setBounds(10, 45, 151, 23);
		panel_3_1.add(lblTngTinNhp_1_1);

		txtTongTienNhapHangNam = new JTextField();
		txtTongTienNhapHangNam.setText((String) null);
		txtTongTienNhapHangNam.setEditable(false);
		txtTongTienNhapHangNam.setColumns(10);
		txtTongTienNhapHangNam.setBounds(143, 48, 154, 20);
		panel_3_1.add(txtTongTienNhapHangNam);

		JLabel lblVn_2_1_1 = new JLabel("vnđ");
		lblVn_2_1_1.setForeground(Color.RED);
		lblVn_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_2_1_1.setBounds(303, 45, 36, 23);
		panel_3_1.add(lblVn_2_1_1);

		JLabel lblTngThu_2_1 = new JLabel("Tổng số Hóa đơn  :");
		lblTngThu_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngThu_2_1.setBounds(415, 11, 122, 23);
		panel_3_1.add(lblTngThu_2_1);

		JLabel lblVn_1_1_3_1 = new JLabel("hóa đơn");
		lblVn_1_1_3_1.setForeground(Color.RED);
		lblVn_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_1_1_3_1.setBounds(638, 11, 81, 23);
		panel_3_1.add(lblVn_1_1_3_1);

		txtTongSoHoaDonNam = new JTextField();
		txtTongSoHoaDonNam.setText((String) null);
		txtTongSoHoaDonNam.setEditable(false);
		txtTongSoHoaDonNam.setColumns(10);
		txtTongSoHoaDonNam.setBounds(547, 13, 81, 20);
		panel_3_1.add(txtTongSoHoaDonNam);

		JLabel lblTngThu_1_1_1 = new JLabel("Tổng thuế  :");
		lblTngThu_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngThu_1_1_1.setBounds(415, 45, 81, 23);
		panel_3_1.add(lblTngThu_1_1_1);

		txtTongThueNam = new JTextField();
		txtTongThueNam.setText((String) null);
		txtTongThueNam.setEditable(false);
		txtTongThueNam.setColumns(10);
		txtTongThueNam.setBounds(547, 47, 154, 20);
		panel_3_1.add(txtTongThueNam);

		JLabel lblVn_1_1_1_1_1 = new JLabel("vnđ");
		lblVn_1_1_1_1_1.setForeground(Color.RED);
		lblVn_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_1_1_1_1_1.setBounds(707, 45, 36, 23);
		panel_3_1.add(lblVn_1_1_1_1_1);

		JLabel lblTngKhuynMi_1_1 = new JLabel("Tổng khuyến mãi  :");
		lblTngKhuynMi_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngKhuynMi_1_1.setBounds(415, 81, 122, 23);
		panel_3_1.add(lblTngKhuynMi_1_1);

		txtTongKhuyenMaiNam = new JTextField();
		txtTongKhuyenMaiNam.setText((String) null);
		txtTongKhuyenMaiNam.setEditable(false);
		txtTongKhuyenMaiNam.setColumns(10);
		txtTongKhuyenMaiNam.setBounds(547, 83, 154, 20);
		panel_3_1.add(txtTongKhuyenMaiNam);

		JLabel lblVn_1_1_2_1_1 = new JLabel("vnđ");
		lblVn_1_1_2_1_1.setForeground(Color.RED);
		lblVn_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_1_1_2_1_1.setBounds(707, 81, 36, 23);
		panel_3_1.add(lblVn_1_1_2_1_1);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(Color.RED));
		panel_1_1_1.setBounds(85, 266, 609, 4);
		panelDuLieuThongKe_1_1.add(panel_1_1_1);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1_1.setBounds(10, 42, 769, 66);
		panelDuLieuThongKe_1_1.add(panel_2_1_1);

		JLabel lblThongKeNgay_1_1 = new JLabel("Thống kê năm :");
		lblThongKeNgay_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay_1_1.setBounds(34, 26, 114, 23);
		panel_2_1_1.add(lblThongKeNgay_1_1);

		btnThongKeNam = new JButton("Thống kê");
		btnThongKeNam.setBounds(408, 22, 135, 33);
		panel_2_1_1.add(btnThongKeNam);
		btnThongKeNam.addActionListener(this);

		btnLamMoiThongKeNam = new JButton("Làm mới thống kê");
		btnLamMoiThongKeNam.setBounds(567, 22, 163, 33);
		panel_2_1_1.add(btnLamMoiThongKeNam);
		btnLamMoiThongKeNam.addActionListener(this);
		cbxChonNamThongKe = new JComboBox(nam);
		cbxChonNamThongKe.setBounds(140, 27, 59, 22);
		panel_2_1_1.add(cbxChonNamThongKe);

		JPanel panelBieuDoThongKeNgay_1_1 = new JPanel();
		panelBieuDoThongKeNgay_1_1.setLayout(null);
		panelBieuDoThongKeNgay_1_1.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",

				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBieuDoThongKeNgay_1_1.setBounds(811, 11, 524, 503);
		panelTabThongKeTheoNam.add(panelBieuDoThongKeNgay_1_1);

		panelBieuDoThongKeDoanhThuNam = new JPanel();
		panelBieuDoThongKeDoanhThuNam.setLayout(null);
		panelBieuDoThongKeDoanhThuNam.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeDoanhThuNam.setBounds(10, 11, 504, 478);
		panelBieuDoThongKeNgay_1_1.add(panelBieuDoThongKeDoanhThuNam);

		btnXuatDuLieuThongKeNam = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuThongKeNam.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuThongKeNam.setBounds(1015, 525, 174, 30);
		panelTabThongKeTheoNam.add(btnXuatDuLieuThongKeNam);
		btnXuatDuLieuThongKeNam.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("DỮ LIỆU THỐNG KÊ DOANH THU BÁN HÀNG THEO NHÂN VIÊN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(193, 281, 416, 23);
		panelDuLieuThongKe.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("DỮ LIỆU THỐNG KÊ DOANH THU BÁN HÀNG TRÊN TOÀN CỬA HÀNG");
		lblNewLabel_1_1.setBounds(194, 11, 432, 23);
		panelDuLieuThongKe.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panel = new JPanel();
		panel.setBounds(10, 119, 771, 120);
		panelDuLieuThongKe.add(panel);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);

		JLabel lblTngDoanhThu = new JLabel("Tổng doanh thu :");
		lblTngDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngDoanhThu.setBounds(10, 11, 108, 23);
		panel.add(lblTngDoanhThu);

		txtDoanhThuCHNgay = new JTextField();
		txtDoanhThuCHNgay.setEditable(false);
		txtDoanhThuCHNgay.setBounds(143, 13, 154, 20);
		panel.add(txtDoanhThuCHNgay);
		txtDoanhThuCHNgay.setColumns(10);

		JLabel lblVn = new JLabel("vnđ");
		lblVn.setForeground(Color.RED);
		lblVn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn.setBounds(303, 11, 36, 23);
		panel.add(lblVn);

		JLabel lblTngLi = new JLabel("Tổng lãi  :");
		lblTngLi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngLi.setBounds(10, 81, 81, 23);
		panel.add(lblTngLi);

		txtTongLaiCHNgay = new JTextField();
		txtTongLaiCHNgay.setEditable(false);
		txtTongLaiCHNgay.setColumns(10);
		txtTongLaiCHNgay.setBounds(143, 84, 154, 20);
		panel.add(txtTongLaiCHNgay);

		JLabel lblVn_1 = new JLabel("vnđ");
		lblVn_1.setForeground(Color.RED);
		lblVn_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_1.setBounds(303, 81, 36, 23);
		panel.add(lblVn_1);

		JLabel lblTngTinNhp = new JLabel("Tổng tiền nhập hàng :");
		lblTngTinNhp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngTinNhp.setBounds(10, 45, 151, 23);
		panel.add(lblTngTinNhp);

		txtTongTienNhapHangCHNgay = new JTextField();
		txtTongTienNhapHangCHNgay.setEditable(false);
		txtTongTienNhapHangCHNgay.setColumns(10);
		txtTongTienNhapHangCHNgay.setBounds(143, 48, 154, 20);
		panel.add(txtTongTienNhapHangCHNgay);

		JLabel lblVn_2 = new JLabel("vnđ");
		lblVn_2.setForeground(Color.RED);
		lblVn_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_2.setBounds(303, 45, 36, 23);
		panel.add(lblVn_2);

		JLabel lblTngThu = new JLabel("Tổng số Hóa đơn  :");
		lblTngThu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngThu.setBounds(415, 11, 122, 23);
		panel.add(lblTngThu);

		JLabel lblVn_1_1 = new JLabel("hóa đơn");
		lblVn_1_1.setForeground(Color.RED);
		lblVn_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_1_1.setBounds(638, 11, 81, 23);
		panel.add(lblVn_1_1);

		txtTongSoHoaDonDuocLapCHNgay = new JTextField();
		txtTongSoHoaDonDuocLapCHNgay.setEditable(false);
		txtTongSoHoaDonDuocLapCHNgay.setColumns(10);
		txtTongSoHoaDonDuocLapCHNgay.setBounds(547, 13, 81, 20);
		panel.add(txtTongSoHoaDonDuocLapCHNgay);

		JLabel lblTngThu_1 = new JLabel("Tổng thuế  :");
		lblTngThu_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngThu_1.setBounds(415, 45, 81, 23);
		panel.add(lblTngThu_1);

		txtTongThueCHNgay = new JTextField();
		txtTongThueCHNgay.setEditable(false);
		txtTongThueCHNgay.setColumns(10);
		txtTongThueCHNgay.setBounds(547, 47, 154, 20);
		panel.add(txtTongThueCHNgay);

		JLabel lblVn_1_1_1 = new JLabel("vnđ");
		lblVn_1_1_1.setForeground(Color.RED);
		lblVn_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_1_1_1.setBounds(707, 45, 36, 23);
		panel.add(lblVn_1_1_1);

		JLabel lblTngKhuynMi = new JLabel("Tổng khuyến mãi  :");
		lblTngKhuynMi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngKhuynMi.setBounds(415, 81, 122, 23);
		panel.add(lblTngKhuynMi);

		txtTongKhuyenMaiCHNgay = new JTextField();
		txtTongKhuyenMaiCHNgay.setEditable(false);
		txtTongKhuyenMaiCHNgay.setColumns(10);
		txtTongKhuyenMaiCHNgay.setBounds(547, 83, 154, 20);
		panel.add(txtTongKhuyenMaiCHNgay);

		JLabel lblVn_1_1_2 = new JLabel("vnđ");
		lblVn_1_1_2.setForeground(Color.RED);
		lblVn_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVn_1_1_2.setBounds(707, 81, 36, 23);
		panel.add(lblVn_1_1_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.RED));
		panel_1.setBounds(85, 266, 609, 4);
		panelDuLieuThongKe.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 42, 769, 66);
		panelDuLieuThongKe.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblThongKeNgay = new JLabel("Thống kê ngày :");
		lblThongKeNgay.setBounds(53, 26, 114, 23);
		panel_2.add(lblThongKeNgay);
		lblThongKeNgay.setFont(new Font("Tahoma", Font.PLAIN, 13));

		jdcChonNgayThongKe = new JDateChooser();
		jdcChonNgayThongKe.setBounds(177, 26, 185, 23);
		panel_2.add(jdcChonNgayThongKe);

		btnThongKeNgay = new JButton("Thống kê");
		btnThongKeNgay.setBounds(408, 22, 135, 33);
		panel_2.add(btnThongKeNgay);
		btnThongKeNgay.addActionListener(this);

		btnLamMoiThongKeNgay = new JButton("Làm mới thống kê");
		btnLamMoiThongKeNgay.setBounds(567, 22, 163, 33);
		panel_2.add(btnLamMoiThongKeNgay);
		btnLamMoiThongKeNgay.addActionListener(this);
		
		lamMoiNgay(jdcChonNgayThongKe);
		
		JLabel lblNewLabel_2 = new JLabel("Chọn thông tin và thực hiện thống kê trước khi xuất dữ liệu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(827, 557, 309, 14);
		panelTabThongKeTheoNgay.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Dữ liệu thống kê sẽ là dữ liệu trên từng nhân viên và cả cửa hàng");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2_1.setBounds(826, 574, 419, 14);
		panelTabThongKeTheoNgay.add(lblNewLabel_2_1);
		thongKeNgay();
		lamMoiThangDuocChon(cbxChonThangThongKe, cbxChonNamCuaThangThongKe);
		
		JLabel lblNewLabel_2_2 = new JLabel("Chọn thông tin và thực hiện thống kê trước khi xuất dữ liệu");
		lblNewLabel_2_2.setForeground(Color.RED);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2_2.setBounds(836, 561, 309, 14);
		panelTabThongKeTheoThang.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Dữ liệu thống kê sẽ là dữ liệu trên từng nhân viên và cả cửa hàng");
		lblNewLabel_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2_1_1.setBounds(835, 578, 419, 14);
		panelTabThongKeTheoThang.add(lblNewLabel_2_1_1);
		thongKeThang();
		lamMoiNamDuocChon(cbxChonNamThongKe);
		
		JLabel lblNewLabel_2_3 = new JLabel("Chọn thông tin và thực hiện thống kê trước khi xuất dữ liệu");
		lblNewLabel_2_3.setForeground(Color.RED);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2_3.setBounds(829, 559, 309, 14);
		panelTabThongKeTheoNam.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Dữ liệu thống kê sẽ là dữ liệu trên từng nhân viên và cả cửa hàng");
		lblNewLabel_2_1_2.setForeground(Color.RED);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2_1_2.setBounds(828, 576, 419, 14);
		panelTabThongKeTheoNam.add(lblNewLabel_2_1_2);
		thongKeNam();
	}
	private void veBieuDoThongKeCacNgayTrongThang(JPanel containPanel, ArrayList<ModelThongKeDoanhThu> data, int thang,
			int namCuaThang) {
		containPanel.removeAll();
		ThongKeDoanhThuServices doanhThuServices = new ThongKeDoanhThuServices();
		data = doanhThuServices.layDuLieuThongKeCacNgayTrongThang(thang, namCuaThang);
		// data = doanhThuServices.layDuLieuThongKeCacNgayTrongThang(8, 2023);
		doanhThuServices.veBieuDoCotDoanhThu(containPanel, data, "Biểu đồ thống kê doanh thu các ngày trong tháng");
		containPanel.revalidate();
		containPanel.repaint();
	}

	private void veBieuDoThongKeCacThangTrongNam(JPanel containPanel, ArrayList<ModelThongKeDoanhThu> data, int nam) {
		containPanel.removeAll();
		ThongKeDoanhThuServices doanhThuServices = new ThongKeDoanhThuServices();
		data = doanhThuServices.layDuLieuThongKeCacThangTrongNam(nam);
		// data = doanhThuServices.layDuLieuThongKeCacNgayTrongThang(8, 2023);
		doanhThuServices.veBieuDoCotDoanhThu(containPanel, data, "Biểu đồ thống kê doanh thu các tháng trong năm");
		containPanel.revalidate();
		containPanel.repaint();
	}

	private void loadDuLieuThongKeNgayToanCuaHang(ModelThongKeDoanhThu model) {
		txtDoanhThuCHNgay.setText(ChuyenThanhTien(model.getTongDoanhThu()));
		txtTongTienNhapHangCHNgay.setText(ChuyenThanhTien(model.getTongTienNhapHang()));
		txtTongLaiCHNgay.setText(ChuyenThanhTien(model.getTongTienLai()));
		txtTongSoHoaDonDuocLapCHNgay.setText(ChuyenThanhTien(model.getTongSoHoaDonDuocLap()));
		txtTongThueCHNgay.setText(ChuyenThanhTien(model.getTongThue()));
		txtTongKhuyenMaiCHNgay.setText(ChuyenThanhTien(model.getTongKhyuenMai()));
	}

	private void loadDuLieuThongKeThangToanCuaHang(ModelThongKeDoanhThu model) {
		txtTongDoanhThuThangToanCh.setText(ChuyenThanhTien(model.getTongDoanhThu()));
		txtTongTienNhapHangThangToanCh.setText(ChuyenThanhTien(model.getTongTienNhapHang()));
		txtTongLaiThangToanCh.setText(ChuyenThanhTien(model.getTongTienLai()));
		txtTongSoHoaDonThangToanCh.setText(ChuyenThanhTien(model.getTongSoHoaDonDuocLap()));
		txtTongThueThangToanch.setText(ChuyenThanhTien(model.getTongThue()));
		txtTongKhuyenMaiThangToanCh.setText(ChuyenThanhTien(model.getTongKhyuenMai()));
	}
	private void loadDuLieuThongKeNamToanCuaHang(ModelThongKeDoanhThu model) {
		txtTongDoanhThuNam.setText(ChuyenThanhTien(model.getTongDoanhThu()));
		txtTongTienNhapHangNam.setText(ChuyenThanhTien(model.getTongTienNhapHang()));
		txtTongLaiNam.setText(ChuyenThanhTien(model.getTongTienLai()));
		txtTongSoHoaDonNam.setText(ChuyenThanhTien(model.getTongSoHoaDonDuocLap()));
		txtTongThueNam.setText(ChuyenThanhTien(model.getTongThue()));
		txtTongKhuyenMaiNam.setText(ChuyenThanhTien(model.getTongKhyuenMai()));
	}

	private void lamMoiDuLieuThongKeNgayToanCuaHang() {
		txtDoanhThuCHNgay.setText("");
		txtTongTienNhapHangCHNgay.setText("");
		txtTongLaiCHNgay.setText("");
		txtTongSoHoaDonDuocLapCHNgay.setText("");
		txtTongThueCHNgay.setText("");
		txtTongKhuyenMaiCHNgay.setText("");
	}

	private LocalDate layNgayDuocChon(JDateChooser chooser) {
		Date date = chooser.getDate();
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private void lamMoiNgay(JDateChooser chooser) {
		Calendar ngayHienTai = Calendar.getInstance();
		chooser.setDate(ngayHienTai.getTime());
	}

	public String ChuyenThanhTien(double money) {
		long roundedMoney = Math.round(money);
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String formattedMoney = decimalFormat.format(roundedMoney);
		return formattedMoney;
	}

	public void loadDataToTable(DefaultTableModel model, ArrayList<ModelThongKeDoanhThu> dataTable) {
		model.setRowCount(0);
		for (ModelThongKeDoanhThu data : dataTable) {
			model.addRow(new Object[] { data.getXepHang(), data.getTenNhanVien(), ChuyenThanhTien(data.getTongDoanhThu()),
					ChuyenThanhTien(data.getTongTienLai()), ChuyenThanhTien(data.getTongSoHoaDonDuocLap()) });
		}
	}

	public void lamMoiTableNgay(DefaultTableModel model) {
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		ArrayList<ModelThongKeDoanhThu> dataTable = services.layDuLieuThongKeDoanhThuNgayTheoNv(layNgayDuocChon(jdcChonNgayThongKe));
		loadDataToTable(model, dataTable);
		txtThongTinTimKiemNgay.setText("");
	}

	public void timKiemNhanVien() {
		LocalDate ngayThongKe = layNgayDuocChon(jdcChonNgayThongKe);
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		ArrayList<ModelThongKeDoanhThu> dataThongKeNhanVien = new ArrayList<>();
		ArrayList<ModelThongKeDoanhThu> dataKetQua = new ArrayList<>();
		dataThongKeNhanVien = services.layDuLieuThongKeDoanhThuNgayTheoNv(ngayThongKe);
		String duLieuTimKiem = txtThongTinTimKiemNgay.getText();
		if (duLieuTimKiem != null)
			duLieuTimKiem = duLieuTimKiem.trim();
		for (ModelThongKeDoanhThu nv : dataThongKeNhanVien) {
			if (nv.toString().toLowerCase().contains(duLieuTimKiem.toLowerCase())) {
				dataKetQua.add(nv);
			}
		}
		loadDataToTable(modelTableThongKeNgay, dataKetQua);
	}

	public void locNhanVienThang() {
		int thang = Integer.parseInt((String) cbxChonThangThongKe.getSelectedItem());
		int namCuaThang = Integer.parseInt((String) cbxChonNamCuaThangThongKe.getSelectedItem());
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		ArrayList<ModelThongKeDoanhThu> dataThongKeNhanVien = new ArrayList<>();
		ArrayList<ModelThongKeDoanhThu> dataKetQua = new ArrayList<>();
		dataThongKeNhanVien = services.layDuLieuThongKeDoanhThuThangTheoNv(thang, namCuaThang);
		String duLieuTimKiem = txtThongTinTimKiemNhanVienThang.getText();
		if (duLieuTimKiem != null)
			duLieuTimKiem = duLieuTimKiem.trim();
		for (ModelThongKeDoanhThu nv : dataThongKeNhanVien) {
			if (nv.toString().toLowerCase().contains(duLieuTimKiem.toLowerCase())) {
				dataKetQua.add(nv);
			}
		}
		loadDataToTable(modelTableThongKeThang, dataKetQua);
	}
	public void locNhanVienNam() {
		int nam = Integer.parseInt((String) cbxChonNamThongKe.getSelectedItem());
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		ArrayList<ModelThongKeDoanhThu> dataThongKeNhanVien = new ArrayList<>();
		ArrayList<ModelThongKeDoanhThu> dataKetQua = new ArrayList<>();
		dataThongKeNhanVien = services.layDuLieuThongKeDoanhThuNamTheoNv(nam);
		String duLieuTimKiem = txtThongTinTimKiemNhanVienNam.getText();
		if (duLieuTimKiem != null)
			duLieuTimKiem = duLieuTimKiem.trim();
		for (ModelThongKeDoanhThu nv : dataThongKeNhanVien) {
			if (nv.toString().toLowerCase().contains(duLieuTimKiem.toLowerCase())) {
				dataKetQua.add(nv);
			}
		}
		loadDataToTable(modelTableThongKeNam, dataKetQua);
	}
//
	private void thongKeNgay() {
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		LocalDate ngayThongKe = layNgayDuocChon(jdcChonNgayThongKe);
		dataThongKeNhanVienNgay = services.layDuLieuThongKeDoanhThuNgayTheoNv(ngayThongKe);
		loadDataToTable(modelTableThongKeNgay, dataThongKeNhanVienNgay);
		dataToanCuaHangTrongNgay = services.layGiuLieuThongKeNgayTrenToanCuaHangTheoNgay(ngayThongKe);
		loadDuLieuThongKeNgayToanCuaHang(dataToanCuaHangTrongNgay);
		/// xem xét
//		LocalDate thoiGianThongKe = layNgayDuocChon(jdcChonNgayThongKe);
//		veBieuDoThongKeCacNgayTrongThang(panelBieuDoThongKeDoanhThuNgay, dataThongKeCacNgayTrongThangCh,
//				thoiGianThongKe.getMonthValue(), thoiGianThongKe.getYear());
		veBieuDoThongKeDoanhThuNvTrongNgay(panelBieuDoThongKeDoanhThuNgay, ngayThongKe);
	}
	private void veBieuDoThongKeDoanhThuNvTrongNgay(JPanel containPanel,LocalDate ngayThongKe) {
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		containPanel.removeAll();
		services.khoiTaoBieuDoTron(panelBieuDoThongKeDoanhThuNgay, ngayThongKe);
		containPanel.revalidate();
		containPanel.repaint();
	}
	// ===========Thong keThang========
	private void thongKeThang() {
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		int thang = Integer.parseInt((String) cbxChonThangThongKe.getSelectedItem());
		int namCuaThang = Integer.parseInt((String) cbxChonNamCuaThangThongKe.getSelectedItem());
		dataThongKeNhanVienThang = services.layDuLieuThongKeDoanhThuThangTheoNv(thang, namCuaThang);
		loadDataToTable(modelTableThongKeThang, dataThongKeNhanVienThang);
		dataToanCuaHangTrongThang = services.layGiuLieuThongKeTrenToanCuaHangTheoThang(thang, namCuaThang);
		loadDuLieuThongKeThangToanCuaHang(dataToanCuaHangTrongThang);
		
		veBieuDoThongKeCacNgayTrongThang(panelBieuDoThongKeDoanhThuThang, dataThongKeCacNgayTrongThangCh,
				thang, namCuaThang);
		//veBieuDoThongKeCacThangTrongNam(panelBieuDoThongKeDoanhThuThang, dataThongKeCacThangTrongNamCh, namCuaThang);
	}
	private void thongKeNam() {
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		int nam = Integer.parseInt((String) cbxChonNamThongKe.getSelectedItem());
		dataThongKeNhanVienNam = services.layDuLieuThongKeDoanhThuNamTheoNv(nam);
		loadDataToTable(modelTableThongKeNam, dataThongKeNhanVienNam);
		dataToanCuaHangTrongNam = services.layGiuLieuThongKeTrenToanCuaHangTheoNam(nam);
		loadDuLieuThongKeNamToanCuaHang(dataToanCuaHangTrongNam);
		
		veBieuDoThongKeCacThangTrongNam(panelBieuDoThongKeDoanhThuNam, dataThongKeCacThangTrongNamCh, nam);
		//veBieuDoThongKeCacThangTrongNam(panelBieuDoThongKeDoanhThuThang, dataThongKeCacThangTrongNamCh, namCuaThang);
	}

	private void lamMoiThangDuocChon(JComboBox<String> cbxThang, JComboBox<String> cbxNam) {
		LocalDate now = LocalDate.now();
		String[] nam = { "2019", "2020", "2021", "2022", "2023", "2024" };
		String[] thang = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		int thangHt = now.getMonthValue();
		int namHt = now.getYear();
		for (String s : thang) {
			if (Integer.parseInt(s) == thangHt) {
				cbxThang.setSelectedItem(s);
				;
			}
		}
		for (String s : nam) {
			if (Integer.parseInt(s) == namHt) {
				cbxNam.setSelectedItem(s);
				;
			}
		}
	}
	private void lamMoiNamDuocChon(JComboBox<String> cbxNam) {
		LocalDate now = LocalDate.now();
		String[] nam = { "2019", "2020", "2021", "2022", "2023", "2024" };
		int namHt = now.getYear();
		for (String s : nam) {
			if (Integer.parseInt(s) == namHt) {
				cbxNam.setSelectedItem(s);
				;
			}
		}
	}

	public void lamMoiTableThang() {
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		int thang = Integer.parseInt((String) cbxChonThangThongKe.getSelectedItem());
		int namCuaThang = Integer.parseInt((String) cbxChonNamCuaThangThongKe.getSelectedItem());
		ArrayList<ModelThongKeDoanhThu> dataTable = services
				.layDuLieuThongKeDoanhThuThangTheoNv(thang, namCuaThang);
		loadDataToTable(modelTableThongKeThang, dataTable);
		txtThongTinTimKiemNhanVienThang.setText("");
	}
	public void lamMoiTableNam() {
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		int nam = Integer.parseInt((String) cbxChonNamThongKe.getSelectedItem());
		ArrayList<ModelThongKeDoanhThu> dataTable = services
				.layDuLieuThongKeDoanhThuNamTheoNv(nam);
		loadDataToTable(modelTableThongKeNam, dataTable);
		txtThongTinTimKiemNhanVienNam.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThongKeNgay)) {
			thongKeNgay();
		} else if (o.equals(btnLocDuLieuNgay)) {
			timKiemNhanVien();
		} else if (o.equals(btnLamMoiThongKeNgay)) {
			lamMoiNgay(jdcChonNgayThongKe);
			thongKeNgay();
		} else if (o.equals(btnLamMoiDuLieuNhanVienNgay)) {
			lamMoiTableNgay(modelTableThongKeNgay);
		} else if (o.equals(btnXuatDuLieuThongKeNgay)) {
			if (dataThongKeNhanVienNgay.size() == 0 || dataToanCuaHangTrongNgay == null) {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu thống kê !");
			} else {
				ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
				LocalDate ngayThongKe = layNgayDuocChon(jdcChonNgayThongKe);
				if (services.xuatFileExcelThongKeNgay(ngayThongKe)) {
					JOptionPane.showMessageDialog(this,
							"Dữ liệu đã được lưu tại DuLieuThongKe\\"+"ThongKeDoanhThuTrongNgay"+ngayThongKe.toString()+".xlsx");
				} else {
					JOptionPane.showMessageDialog(this, "Lỗi không thể tạo thống kê !");
				}
			}
		}

		else if (o.equals(btnThongKeThang)) {
			thongKeThang();
		} else if (o.equals(btnLocDuLieuThang)) {
			locNhanVienThang();
			;
		} else if (o.equals(btnLamMoiThongKeThang)) {
			lamMoiThangDuocChon(cbxChonThangThongKe, cbxChonNamCuaThangThongKe);
			thongKeThang();
		} else if (o.equals(btnLamMoiDuLieuNvThang)) {
			lamMoiTableThang();
		} else if (o.equals(btnXuatDuLieuThongKeThang)) {
			if (dataThongKeNhanVienThang.size() == 0 || dataToanCuaHangTrongThang == null) {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu thống kê !");
			} else {
				ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
				int thang = Integer.parseInt((String) cbxChonThangThongKe.getSelectedItem());
				int namCuaThang = Integer.parseInt((String) cbxChonNamCuaThangThongKe.getSelectedItem());
				if (services.xuatFileExcelThongKeCacNgayTrongThang(thang, namCuaThang)) {
					JOptionPane.showMessageDialog(this, "Dữ liệu đã được lưu tại DuLieuThongKe\\"
							+ "ThongKeDoanhThuCacNgayTrongThang" + thang+"-"+namCuaThang + ".xlsx");
				} else {
					JOptionPane.showMessageDialog(this, "Lỗi không thể tạo thống kê !");
				}
			}
		}
		
		else if (o.equals(btnThongKeNam)) {
			thongKeNam();
		} else if (o.equals(btnLocDuLieuNvNam)) {
			locNhanVienNam();
		} else if (o.equals(btnLamMoiThongKeNam)) {
			lamMoiNamDuocChon(cbxChonNamThongKe);
			thongKeNam();
		} else if (o.equals(btnLamMoiDuLieuNvNam)) {
			lamMoiTableNam();
		} else if (o.equals(btnXuatDuLieuThongKeNam)) {
			if (dataThongKeNhanVienNam.size() == 0 || dataToanCuaHangTrongNam == null) {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu thống kê !");
			} else {
				ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
				int nam = Integer.parseInt((String) cbxChonNamThongKe.getSelectedItem());
				if (services.xuatFileExcelThongKeCacThangTrongNam(nam)) {
					JOptionPane.showMessageDialog(this, "Dữ liệu đã được lưu tại DuLieuThongKe\\"
							+ "ThongKeDoanhThuCacThangTrong" +nam+ ".xlsx");
				} else {
					JOptionPane.showMessageDialog(this, "Lỗi không thể tạo thống kê !");
				}
			}
		}
	}
}
