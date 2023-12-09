package gui.admin;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import constance.ModelThongKeDoanhThu;
import constance.ModelThongKeMatHang;
import daos.Dao_ThongKeMatHang;
import services.ThongKeDoanhThuServices;
import services.ThongKeMatHangServices;

//import entities.AccountLogin;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class TK_ThongKeMatHangBanChayNVQuanLyPanel extends JPanel implements ActionListener {
	private String[] cols = { "Xếp hạng", "Mã mặt hàng", "Tên Mặt hàng", "Số lượng bán ra(mh)", "Doanh thu (vnd)",
			"Số lượng tồn(mh)" };
	private String[] nam = { "2019", "2020", "2021", "2022", "2023" };
	private String[] thang = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

	private DefaultTableModel modelTableThongKeNgay;
	private ModelThongKeMatHang dataTrongNgay;
	private ArrayList<ModelThongKeMatHang> dataThongKeNgay;

	private DefaultTableModel modelTableThongKeThang;
	private ModelThongKeMatHang dataTrongThang;
	private ArrayList<ModelThongKeMatHang> dataThongKeThang;
	private ArrayList<ModelThongKeMatHang> dataThongKeCacNgayTrongThang;

	private DefaultTableModel modelTableThongKeNam;
	private ModelThongKeMatHang dataTrongNam;
	private ArrayList<ModelThongKeMatHang> dataThongKeNam;
	private ArrayList<ModelThongKeMatHang> dataThongKeCacThangTrongNam;

	private JTable tblThongKeMatHangNgay;
	private JPanel panelTbaleNgay;
	private JButton btnThongKeNgay;
	private JPanel panelBieuDoThongKeNgay;
	private JTextField txtTimKiemMatHangThongKeNgay;
	private JTextField txtTimKiemMatHangThang;
	private JTextField txtTimKiemMatHangNam;
	private JTable tblThongKeNam;
	private JTable tblThongKeThang;
	private JButton btnTimKiemMatHangThongKeNgay;
	private JButton btnLamMoiMatHangThongKeNgay;
	private JDateChooser jdcChonNgayThongKe;
	private JButton btnLamMoiThongKeNgay;
	private JButton btnXuatDuLieuThongKeMatHangNgay;
	private JButton btnThongKeThang;
	private JButton btnLamMoiThongKeThang;
	private JComboBox<String> cbxChonThangThongKe;
	private JComboBox<String> cbxChonNamCuaThangThongKe;
	private JButton btnTimKiemThang;
	private JButton btnLamMoiMatHangThongKeThang;
	private JButton btnXuatDuLieuThongKeMatHangThang;
	private JButton btnThongKeNam;
	private JButton btnLamMoiThongKeNam;
	private JComboBox<String> cbxChonNamThongKe;
	private JButton btnTimKiemMatHangThongKeNam;
	private JButton btnLamMoiMatHangThongKeNam;
	private JButton btnXuatDuLieuThongKeMatHangNam;
	private JPanel panelBieuDoThongKeThang;
	private JPanel panelBieuDoThongKeNam;

	/**
	 * Create the panel.
	 */
	public TK_ThongKeMatHangBanChayNVQuanLyPanel() {
		this.setBounds(0, 0, 1350, 640);
		setLayout(null);

		JPanel panelCN_CNThongKeBanhang = new JPanel();
		panelCN_CNThongKeBanhang.setLayout(null);
		panelCN_CNThongKeBanhang.setBounds(0, 0, 1350, 638);
		add(panelCN_CNThongKeBanhang);

		JLabel lblNewLabel = new JLabel("THỐNG KÊ HÀNG HÓA");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(647, 0, 216, 25);
		panelCN_CNThongKeBanhang.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 1350, 627);
		panelCN_CNThongKeBanhang.add(tabbedPane);

		JPanel panelTabThongKeTheoNgay = new JPanel();
		panelTabThongKeTheoNgay.setLayout(null);
		panelTabThongKeTheoNgay.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Thống kê trong ngày", null, panelTabThongKeTheoNgay, null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 740, 577);
		panelTabThongKeTheoNgay.add(panel_1);
		panel_1.setLayout(null);

		JPanel panelBoLocTimKiem_2 = new JPanel();
		panelBoLocTimKiem_2.setBackground(Color.WHITE);
		panelBoLocTimKiem_2.setLayout(null);
		panelBoLocTimKiem_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBoLocTimKiem_2.setBounds(10, 56, 720, 59);
		panel_1.add(panelBoLocTimKiem_2);

		btnThongKeNgay = new JButton("Thống kê");
		btnThongKeNgay.setBackground(Color.green);
		btnThongKeNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
        String iconPath_thongKe = "/images/pick-icon.png";
		ImageIcon iconThongKe = new ImageIcon(this.getClass().getResource(iconPath_thongKe)); 
		Image scaledIconThongKe = iconThongKe.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); 
		ImageIcon resizedIconThongKe = new ImageIcon(scaledIconThongKe);
		btnThongKeNgay.setIcon(resizedIconThongKe);
		btnThongKeNgay.setBounds(357, 11, 150, 37);
		panelBoLocTimKiem_2.add(btnThongKeNgay);
		btnThongKeNgay.addActionListener(this);

		JLabel lblThiGianNgy = new JLabel("Thời gian ngày : ");
		lblThiGianNgy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThiGianNgy.setBounds(10, 14, 129, 34);
		panelBoLocTimKiem_2.add(lblThiGianNgy);

		jdcChonNgayThongKe = new JDateChooser();
		jdcChonNgayThongKe.setBounds(138, 11, 178, 37);
		panelBoLocTimKiem_2.add(jdcChonNgayThongKe);

		btnLamMoiThongKeNgay = new JButton("Làm mới thống kê");
		btnLamMoiThongKeNgay.setBackground(Color.ORANGE);
		btnLamMoiThongKeNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
        String iconPath_capnhat = "/images/updated.png";
		ImageIcon iconCapNhat = new ImageIcon(this.getClass().getResource(iconPath_capnhat)); 
		Image scaledIconCapNhat = iconCapNhat.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); 
		ImageIcon resizedIconCapNhat = new ImageIcon(scaledIconCapNhat);
		btnLamMoiThongKeNgay.setIcon(resizedIconCapNhat);
		btnLamMoiThongKeNgay.setBounds(517, 11, 193, 37);
		panelBoLocTimKiem_2.add(btnLamMoiThongKeNgay);
		btnLamMoiThongKeNgay.addActionListener(this);

		panelTbaleNgay = new JPanel();
		panelTbaleNgay.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTbaleNgay.setBounds(10, 249, 720, 285);
		panel_1.add(panelTbaleNgay);
		panelTbaleNgay.setLayout(new BorderLayout(0, 0));

		modelTableThongKeNgay = new DefaultTableModel(cols, 0);
		tblThongKeMatHangNgay = new JTable(modelTableThongKeNgay);
		JTableHeader header = tblThongKeMatHangNgay.getTableHeader();
		header.setPreferredSize(new Dimension(header.getWidth(), 40));
        header.setBackground(Color.cyan);
        tblThongKeMatHangNgay.setRowHeight(40);
		panelTbaleNgay.add(new JScrollPane(tblThongKeMatHangNgay), BorderLayout.CENTER);
		for (int i = 3; i < cols.length; i++) {
			TableColumn column = tblThongKeMatHangNgay.getColumnModel().getColumn(i);
			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setHorizontalAlignment(SwingConstants.RIGHT);
			column.setCellRenderer(renderer);
		}
		tblThongKeMatHangNgay.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tblThongKeMatHangNgay.getSelectedRow();
				if (selectedRow != -1) {
					String tenNhanVien = (String) tblThongKeMatHangNgay.getValueAt(selectedRow, 2);
					txtTimKiemMatHangThongKeNgay.setText(tenNhanVien);
				}
				;
			}
		});

		JLabel lblNewLabel_2 = new JLabel(
				"Chọn thông tin và thực hiện thống kê trước khi xuất dữ liệu - Dữ liệu thống kê sẽ là dữ liệu trên từng nhân viên và cả cửa hàng");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2.setBounds(10, 552, 648, 14);
		panel_1.add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 141, 720, 105);
		panel_1.add(panel);
		panel.setLayout(null);

		JLabel lblTmKimMt = new JLabel("Tìm kiếm Mặt hàng :");
		lblTmKimMt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTmKimMt.setBounds(10, 56, 129, 38);
		panel.add(lblTmKimMt);

		txtTimKiemMatHangThongKeNgay = new JTextField();
		txtTimKiemMatHangThongKeNgay.setBounds(132, 61, 186, 30);
		panel.add(txtTimKiemMatHangThongKeNgay);
		txtTimKiemMatHangThongKeNgay.setColumns(10);

		btnTimKiemMatHangThongKeNgay = new JButton("Tìm kiếm");
		btnTimKiemMatHangThongKeNgay.setBackground(Color.white);
		btnTimKiemMatHangThongKeNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
        String iconPath_timKiem = "/images/icon-search.png";
		ImageIcon iconTimKiem = new ImageIcon(this.getClass().getResource(iconPath_timKiem)); 
		Image scaledIconTimKiem = iconTimKiem.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); 
		ImageIcon resizedIconTimKiem = new ImageIcon(scaledIconTimKiem);
		btnTimKiemMatHangThongKeNgay.setIcon(resizedIconTimKiem);
		btnTimKiemMatHangThongKeNgay.setBounds(346, 56, 151, 36);
		panel.add(btnTimKiemMatHangThongKeNgay);
		btnTimKiemMatHangThongKeNgay.addActionListener(this);

		btnLamMoiMatHangThongKeNgay = new JButton("Làm mới");
		btnLamMoiMatHangThongKeNgay.setBackground(Color.ORANGE);
		btnLamMoiMatHangThongKeNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLamMoiMatHangThongKeNgay.setIcon(resizedIconCapNhat);
		btnLamMoiMatHangThongKeNgay.setBounds(518, 54, 192, 38);
		panel.add(btnLamMoiMatHangThongKeNgay);
		
				JLabel lblDLiuThng = new JLabel("TOP MẶT HÀNG BÁN CHẠY");
				lblDLiuThng.setBounds(257, 0, 216, 34);
				panel.add(lblDLiuThng);
				lblDLiuThng.setForeground(Color.RED);
				lblDLiuThng.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				JPanel panel_4 = new JPanel();
				panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_4.setBounds(10, 32, 700, 4);
				panel.add(panel_4);
		btnLamMoiMatHangThongKeNgay.addActionListener(this);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("Mặc định dữ liệu sẽ lấy tối đa top 15 mặt hàng bán chạy nhất.");
		lblNewLabel_2_1_2_1.setForeground(Color.RED);
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2_1_2_1.setBounds(10, 539, 648, 14);
		panel_1.add(lblNewLabel_2_1_2_1);
		// <======>

		JPanel panelBieuDoThongKe = new JPanel();
		panelBieuDoThongKe.setBounds(760, 11, 575, 577);
		panelTabThongKeTheoNgay.add(panelBieuDoThongKe);
		panelBieuDoThongKe.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(0, 0, 575, 577);
		panelBieuDoThongKe.add(panel_3);
		panel_3.setLayout(null);

		panelBieuDoThongKeNgay = new JPanel();
		panelBieuDoThongKeNgay.setBackground(Color.WHITE);
		panelBieuDoThongKeNgay.setBounds(10, 11, 555, 491);
		panel_3.add(panelBieuDoThongKeNgay);

		btnXuatDuLieuThongKeMatHangNgay = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuThongKeMatHangNgay.setBackground(Color.white);
		btnXuatDuLieuThongKeMatHangNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
        String iconPath_excel = "/images/excel-icon.png";
		ImageIcon iconExcel = new ImageIcon(this.getClass().getResource(iconPath_excel)); 
		Image scaledIconExcel = iconExcel.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); 
		ImageIcon resizedIconExcel = new ImageIcon(scaledIconExcel);
		btnXuatDuLieuThongKeMatHangNgay.setIcon(resizedIconExcel);
		btnXuatDuLieuThongKeMatHangNgay.setBounds(173, 513, 240, 42);
		panel_3.add(btnXuatDuLieuThongKeMatHangNgay);
		btnXuatDuLieuThongKeMatHangNgay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuThongKeMatHangNgay.addActionListener(this);

		JPanel panelTabThongKeTheoThang = new JPanel();
		panelTabThongKeTheoThang.setLayout(null);
		panelTabThongKeTheoThang.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Thống kê trong tháng", null, panelTabThongKeTheoThang, null);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 11, 740, 577);
		panelTabThongKeTheoThang.add(panel_1_1);

		JPanel panelBoLocTimKiem_2_1 = new JPanel();
		panelBoLocTimKiem_2_1.setBackground(Color.WHITE);
		panelBoLocTimKiem_2_1.setLayout(null);
		panelBoLocTimKiem_2_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBoLocTimKiem_2_1.setBounds(10, 56, 720, 63);
		panel_1_1.add(panelBoLocTimKiem_2_1);

		btnThongKeThang = new JButton("Thống kê");
		btnThongKeThang.setBounds(326, 11, 153, 41);
		btnThongKeThang.setIcon(resizedIconThongKe);
		btnThongKeThang.setBackground(Color.green);
		btnThongKeThang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBoLocTimKiem_2_1.add(btnThongKeThang);
		btnThongKeThang.addActionListener(this);

		JLabel lblThiGianThng = new JLabel("Thời gian tháng : ");
		lblThiGianThng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThiGianThng.setBounds(10, 14, 137, 38);
		panelBoLocTimKiem_2_1.add(lblThiGianThng);

		btnLamMoiThongKeThang = new JButton("Làm mới thống kê");
		btnLamMoiThongKeThang.setBounds(504, 11, 206, 41);
		btnLamMoiThongKeThang.setIcon(resizedIconCapNhat);
		btnLamMoiThongKeThang.setBackground(Color.ORANGE);
		btnLamMoiThongKeThang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBoLocTimKiem_2_1.add(btnLamMoiThongKeThang);
		btnLamMoiThongKeThang.addActionListener(this);

		JLabel lblNewLabel_5 = new JLabel("Năm :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(187, 13, 46, 36);
		panelBoLocTimKiem_2_1.add(lblNewLabel_5);

		cbxChonThangThongKe = new JComboBox(thang);
		cbxChonThangThongKe.setBackground(Color.WHITE);
		cbxChonThangThongKe.setBounds(146, 15, 39, 37);
		panelBoLocTimKiem_2_1.add(cbxChonThangThongKe);

		cbxChonNamCuaThangThongKe = new JComboBox(nam);
		cbxChonNamCuaThangThongKe.setBackground(Color.WHITE);
		cbxChonNamCuaThangThongKe.setBounds(231, 15, 59, 37);
		panelBoLocTimKiem_2_1.add(cbxChonNamCuaThangThongKe);

		JPanel panelTbaleNgay_1 = new JPanel();
		panelTbaleNgay_1.setBackground(Color.WHITE);
		panelTbaleNgay_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTbaleNgay_1.setBounds(10, 249, 720, 272);
		panel_1_1.add(panelTbaleNgay_1);
		panelTbaleNgay_1.setLayout(new BorderLayout(0, 0));

		modelTableThongKeThang = new DefaultTableModel(cols, 0);
		tblThongKeThang = new JTable(modelTableThongKeThang);
		JTableHeader header2 = tblThongKeThang.getTableHeader();
		header2.setPreferredSize(new Dimension(header.getWidth(), 40));
		header2.setBackground(Color.cyan);
		tblThongKeThang.setRowHeight(40);
		panelTbaleNgay_1.add(new JScrollPane(tblThongKeThang), BorderLayout.CENTER);
		for (int i = 2; i < cols.length; i++) {
			TableColumn column = tblThongKeThang.getColumnModel().getColumn(i);
			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setHorizontalAlignment(SwingConstants.RIGHT);
			column.setCellRenderer(renderer);
		}
		tblThongKeThang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tblThongKeThang.getSelectedRow();
				if (selectedRow != -1) {
					String tenNhanVien = (String) tblThongKeThang.getValueAt(selectedRow, 1);
					txtTimKiemMatHangThang.setText(tenNhanVien);
				}
				;
			}
		});

		JLabel lblNewLabel_2_1 = new JLabel(
				"Chọn thông tin và thực hiện thống kê trước khi xuất dữ liệu - Dữ liệu thống kê sẽ là dữ liệu trên từng nhân viên và cả cửa hàng");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2_1.setBounds(10, 552, 648, 14);
		panel_1_1.add(lblNewLabel_2_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 145, 720, 98);
		panel_1_1.add(panel_2);

		JLabel lblTmKimMt_1 = new JLabel("Tìm kiếm Mặt hàng :");
		lblTmKimMt_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTmKimMt_1.setBounds(10, 49, 129, 38);
		panel_2.add(lblTmKimMt_1);

		txtTimKiemMatHangThang = new JTextField();
		txtTimKiemMatHangThang.setColumns(10);
		txtTimKiemMatHangThang.setBounds(131, 54, 186, 30);
		panel_2.add(txtTimKiemMatHangThang);

		btnTimKiemThang = new JButton("Tìm kiếm");
		btnTimKiemThang.setBounds(344, 49, 129, 38);
		btnTimKiemThang.setBackground(Color.white);
		btnTimKiemThang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiemThang.setIcon(resizedIconTimKiem);
		panel_2.add(btnTimKiemThang);
		btnTimKiemThang.addActionListener(this);

		btnLamMoiMatHangThongKeThang = new JButton("Làm mới");
		btnLamMoiMatHangThongKeThang.setBackground(Color.ORANGE);
		btnLamMoiMatHangThongKeThang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLamMoiMatHangThongKeThang.setBounds(504, 49, 206, 38);
		btnLamMoiMatHangThongKeThang.setIcon(resizedIconCapNhat);
		panel_2.add(btnLamMoiMatHangThongKeThang);
		
		JLabel lblDLiuThng_1 = new JLabel("TOP MẶT HÀNG BÁN CHẠY");
		lblDLiuThng_1.setForeground(Color.RED);
		lblDLiuThng_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDLiuThng_1.setBounds(257, 0, 216, 34);
		panel_2.add(lblDLiuThng_1);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4_1.setBounds(10, 32, 700, 4);
		panel_2.add(panel_4_1);
		btnLamMoiMatHangThongKeThang.addActionListener(this);

		JLabel lblNewLabel_2_1_2 = new JLabel("Mặc định dữ liệu sẽ lấy tối đa top 15 mặt hàng bán chạy nhất.");
		lblNewLabel_2_1_2.setForeground(Color.RED);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2_1_2.setBounds(10, 532, 648, 14);
		panel_1_1.add(lblNewLabel_2_1_2);

		JPanel panelBieuDoThongKe_1 = new JPanel();
		panelBieuDoThongKe_1.setLayout(null);
		panelBieuDoThongKe_1.setBounds(760, 11, 575, 577);
		panelTabThongKeTheoThang.add(panelBieuDoThongKe_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_1.setBounds(0, 0, 575, 577);
		panelBieuDoThongKe_1.add(panel_3_1);

		panelBieuDoThongKeThang = new JPanel();
		panelBieuDoThongKeThang.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBieuDoThongKeThang.setBackground(Color.WHITE);
		panelBieuDoThongKeThang.setBounds(10, 11, 555, 491);
		panel_3_1.add(panelBieuDoThongKeThang);

		btnXuatDuLieuThongKeMatHangThang = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuThongKeMatHangThang.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuThongKeMatHangThang.setBackground(Color.white);
		btnXuatDuLieuThongKeMatHangThang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXuatDuLieuThongKeMatHangThang.setIcon(resizedIconExcel);
		btnXuatDuLieuThongKeMatHangThang.setBounds(167, 513, 227, 42);
		panel_3_1.add(btnXuatDuLieuThongKeMatHangThang);
		btnXuatDuLieuThongKeMatHangThang.addActionListener(this);

		JPanel panelTabThongKeTheoNam = new JPanel();
		panelTabThongKeTheoNam.setLayout(null);
		panelTabThongKeTheoNam.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Thống kê trong năm", null, panelTabThongKeTheoNam, null);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(10, 11, 740, 577);
		panelTabThongKeTheoNam.add(panel_1_1_1);

		JPanel panelBoLocTimKiem_2_1_1 = new JPanel();
		panelBoLocTimKiem_2_1_1.setBackground(Color.WHITE);
		panelBoLocTimKiem_2_1_1.setLayout(null);
		panelBoLocTimKiem_2_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBoLocTimKiem_2_1_1.setBounds(10, 56, 720, 61);
		panel_1_1_1.add(panelBoLocTimKiem_2_1_1);

		btnThongKeNam = new JButton("Thống kê");
		btnThongKeNam.setBackground(Color.green);
		btnThongKeNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThongKeNam.setIcon(resizedIconThongKe);
		btnThongKeNam.setBounds(350, 11, 138, 39);
		panelBoLocTimKiem_2_1_1.add(btnThongKeNam);
		btnThongKeNam.addActionListener(this);

		JLabel lblThiGianNm = new JLabel("Thời gian năm : ");
		lblThiGianNm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThiGianNm.setBounds(26, 12, 125, 33);
		panelBoLocTimKiem_2_1_1.add(lblThiGianNm);

		btnLamMoiThongKeNam = new JButton("Làm mới thống kê");
		btnLamMoiThongKeNam.setBackground(Color.ORANGE);
		btnLamMoiThongKeNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLamMoiThongKeNam.setIcon(resizedIconCapNhat);
		btnLamMoiThongKeNam.setBounds(517, 11, 193, 39);
		panelBoLocTimKiem_2_1_1.add(btnLamMoiThongKeNam);
		btnLamMoiThongKeNam.addActionListener(this);

		cbxChonNamThongKe = new JComboBox(nam);
		cbxChonNamThongKe.setBackground(Color.WHITE);
		cbxChonNamThongKe.setBounds(143, 13, 59, 34);
		panelBoLocTimKiem_2_1_1.add(cbxChonNamThongKe);

		JPanel panelTbaleNgay_1_1 = new JPanel();
		panelTbaleNgay_1_1.setBackground(Color.WHITE);
		panelTbaleNgay_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTbaleNgay_1_1.setBounds(10, 237, 720, 280);
		panel_1_1_1.add(panelTbaleNgay_1_1);
		panelTbaleNgay_1_1.setLayout(new BorderLayout(0, 0));

		modelTableThongKeNam = new DefaultTableModel(cols, 0);
		tblThongKeNam = new JTable(modelTableThongKeNam);
		panelTbaleNgay_1_1.add(new JScrollPane(tblThongKeNam), BorderLayout.CENTER);
		for (int i = 2; i < cols.length; i++) {
			TableColumn column = tblThongKeNam.getColumnModel().getColumn(i);
			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setHorizontalAlignment(SwingConstants.RIGHT);
			column.setCellRenderer(renderer);
		}
		tblThongKeNam.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tblThongKeNam.getSelectedRow();
				if (selectedRow != -1) {
					String tenNhanVien = (String) tblThongKeNam.getValueAt(selectedRow, 1);
					txtTimKiemMatHangNam.setText(tenNhanVien);
				}
				;
			}
		});

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBounds(10, 128, 720, 107);
		panel_1_1_1.add(panel_2_1);

		JLabel lblTmKimMt_1_1 = new JLabel("Tìm kiếm Mặt hàng :");
		lblTmKimMt_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTmKimMt_1_1.setBounds(10, 58, 129, 38);
		panel_2_1.add(lblTmKimMt_1_1);

		txtTimKiemMatHangNam = new JTextField();
		txtTimKiemMatHangNam.setColumns(10);
		txtTimKiemMatHangNam.setBounds(149, 63, 180, 30);
		panel_2_1.add(txtTimKiemMatHangNam);

		btnTimKiemMatHangThongKeNam = new JButton("Tìm kiếm");
		btnTimKiemMatHangThongKeNam.setBackground(Color.white);
		btnTimKiemMatHangThongKeNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiemMatHangThongKeNam.setIcon(resizedIconTimKiem);
		btnTimKiemMatHangThongKeNam.setBounds(348, 58, 140, 36);
		panel_2_1.add(btnTimKiemMatHangThongKeNam);
		btnTimKiemMatHangThongKeNam.addActionListener(this);

		btnLamMoiMatHangThongKeNam = new JButton("Làm mới");
		btnLamMoiMatHangThongKeNam.setBackground(Color.ORANGE);
		btnLamMoiMatHangThongKeNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLamMoiMatHangThongKeNam.setIcon(resizedIconCapNhat);
		btnLamMoiMatHangThongKeNam.setBounds(527, 55, 183, 38);
		panel_2_1.add(btnLamMoiMatHangThongKeNam);
		
		JLabel lblDLiuThng_1_1 = new JLabel("TOP MẶT HÀNG BÁN CHẠY");
		lblDLiuThng_1_1.setForeground(Color.RED);
		lblDLiuThng_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDLiuThng_1_1.setBounds(257, 0, 216, 34);
		panel_2_1.add(lblDLiuThng_1_1);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4_1_1.setBounds(10, 32, 700, 4);
		panel_2_1.add(panel_4_1_1);
		btnLamMoiMatHangThongKeNam.addActionListener(this);

		JLabel lblNewLabel_2_2 = new JLabel(
				"Chọn thông tin và thực hiện thống kê trước khi xuất dữ liệu - Dữ liệu thống kê sẽ là dữ liệu trên từng nhân viên và cả cửa hàng");
		lblNewLabel_2_2.setForeground(Color.RED);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2_2.setBounds(20, 552, 648, 14);
		panel_1_1_1.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("Mặc định dữ liệu sẽ lấy tối đa top 15 mặt hàng bán chạy nhất.");
		lblNewLabel_2_1_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_2_1_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2_1_2_1_1.setBounds(20, 539, 648, 14);
		panel_1_1_1.add(lblNewLabel_2_1_2_1_1);

		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_1_1.setBounds(760, 11, 575, 577);
		panelTabThongKeTheoNam.add(panel_3_1_1);

		panelBieuDoThongKeNam = new JPanel();
		panelBieuDoThongKeNam.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBieuDoThongKeNam.setBackground(Color.WHITE);
		panelBieuDoThongKeNam.setBounds(10, 11, 555, 491);
		panel_3_1_1.add(panelBieuDoThongKeNam);

		btnXuatDuLieuThongKeMatHangNam = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuThongKeMatHangNam.setBackground(Color.white);
		btnXuatDuLieuThongKeMatHangNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXuatDuLieuThongKeMatHangNam.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuThongKeMatHangNam.setIcon(resizedIconExcel);
		btnXuatDuLieuThongKeMatHangNam.setBounds(208, 513, 203, 42);
		panel_3_1_1.add(btnXuatDuLieuThongKeMatHangNam);
		btnXuatDuLieuThongKeMatHangNam.addActionListener(this);

		lamMoiNgay(jdcChonNgayThongKe);
		
		JLabel lblThngKMt = new JLabel("THỐNG KÊ MẶT HÀNG BÁN CHẠY NGÀY");
		lblThngKMt.setForeground(Color.RED);
		lblThngKMt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThngKMt.setBounds(245, 11, 301, 34);
		panel_1.add(lblThngKMt);
		thongKeNgay();
		lamMoiThangDuocChon(cbxChonThangThongKe, cbxChonNamCuaThangThongKe);
		
		JLabel lblThngKMt_2 = new JLabel("THỐNG KÊ MẶT HÀNG BÁN CHẠY TRONG THÁNG");
		lblThngKMt_2.setForeground(Color.RED);
		lblThngKMt_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThngKMt_2.setBounds(200, 11, 384, 34);
		panel_1_1.add(lblThngKMt_2);
		thongKeThang();
		lamMoiNamDuocChon(cbxChonNamThongKe);
		
		JLabel lblThngKMt_2_1 = new JLabel("THỐNG KÊ MẶT HÀNG BÁN CHẠY TRONG NĂM");
		lblThngKMt_2_1.setForeground(Color.RED);
		lblThngKMt_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThngKMt_2_1.setBounds(200, 11, 384, 34);
		panel_1_1_1.add(lblThngKMt_2_1);
		thongKeNam();
	}

	private void test() {
		ThongKeMatHangServices services = new ThongKeMatHangServices();
		services.taoBieuDoCotThongKeMatHangTheoNgay(panelBieuDoThongKeNgay, LocalDate.of(2023, 8, 18));
	}

	public void thongKeNgay() {
		ThongKeMatHangServices services = new ThongKeMatHangServices();
		LocalDate ngayThongke = layNgayDuocChon(jdcChonNgayThongKe);
		dataThongKeNgay = services.layDuLieuThongkeNgay(ngayThongke);
		loadDataToTable(modelTableThongKeNgay, dataThongKeNgay);
		veBieuDoThongKeNgay();
	}

	public void thongKeThang() {
		ThongKeMatHangServices services = new ThongKeMatHangServices();
		int thang = Integer.parseInt((String) cbxChonThangThongKe.getSelectedItem());
		int namCuaThang = Integer.parseInt((String) cbxChonNamCuaThangThongKe.getSelectedItem());
		dataThongKeThang = services.layDuLieuThongkeThang(thang, namCuaThang);
		loadDataToTable(modelTableThongKeThang, dataThongKeThang);
		veBieuDoThongKeThang();
	}

	public void thongKeNam() {
		ThongKeMatHangServices services = new ThongKeMatHangServices();
		int nam = Integer.parseInt((String) cbxChonNamThongKe.getSelectedItem());
		dataThongKeNam = services.layDuLieuThongkeNam(nam);
		loadDataToTable(modelTableThongKeNam, dataThongKeNam);
		veBieuDoThongKeNam();
	}

	private void veBieuDoThongKeNgay() {
		LocalDate ngayDuocChon = layNgayDuocChon(jdcChonNgayThongKe);
		ThongKeMatHangServices services = new ThongKeMatHangServices();
		services.taoBieuDoCotThongKeMatHangTheoNgay(panelBieuDoThongKeNgay, ngayDuocChon);
	}

	private void veBieuDoThongKeThang() {
		int thang = Integer.parseInt((String) cbxChonThangThongKe.getSelectedItem());
		int namCuaThang = Integer.parseInt((String) cbxChonNamCuaThangThongKe.getSelectedItem());
		ThongKeMatHangServices services = new ThongKeMatHangServices();
		services.taoBieuDoCotThongKeMatHangTheoThang(panelBieuDoThongKeThang, thang, namCuaThang);
	}

	private void veBieuDoThongKeNam() {
		int nam = Integer.parseInt((String) cbxChonNamThongKe.getSelectedItem());
		ThongKeMatHangServices services = new ThongKeMatHangServices();
		services.taoBieuDoCotThongKeMatHangTheoNam(panelBieuDoThongKeNam, nam);
		;
	}

	// ==================
	public String ChuyenThanhTien(float money) {
		long roundedMoney = Math.round(money);
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String formattedMoney = decimalFormat.format(roundedMoney);
		return formattedMoney;
	}

	public void loadDataToTable(DefaultTableModel model, ArrayList<ModelThongKeMatHang> dataTable) {
		model.setRowCount(0);
		for (ModelThongKeMatHang data : dataTable) {
			model.addRow(new Object[] { data.getXepHang(), data.getMaHangHoa().trim(), data.getTenHangHoa(),
					ChuyenThanhTien(data.getSoLuongBan()), ChuyenThanhTien(data.getDoanhThu()),
					ChuyenThanhTien(data.getSoLuongTon()) });
		}
	}

	private LocalDate layNgayDuocChon(JDateChooser chooser) {
		Date date = chooser.getDate();
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private void lamMoiNgay(JDateChooser chooser) {
		Calendar ngayHienTai = Calendar.getInstance();
		chooser.setDate(ngayHienTai.getTime());
	}

	private void layThangDuocChon() {
		int thang = Integer.parseInt((String) cbxChonThangThongKe.getSelectedItem());
		int namCuaThang = Integer.parseInt((String) cbxChonNamCuaThangThongKe.getSelectedItem());
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

	public void lamMoiTableNgay() {
		ThongKeMatHangServices services = new ThongKeMatHangServices();
		ArrayList<ModelThongKeMatHang> data = new ArrayList<>();
		data = services.layDuLieuThongkeNgay(layNgayDuocChon(jdcChonNgayThongKe));
		loadDataToTable(modelTableThongKeNgay, data);
		dataThongKeNgay = new ArrayList<>();
		dataThongKeNgay = data;
		txtTimKiemMatHangThongKeNgay.setText("");
	}

	public void lamMoiTableThang() {
		ThongKeMatHangServices services = new ThongKeMatHangServices();
		ArrayList<ModelThongKeMatHang> data = new ArrayList<>();
		int thang = Integer.parseInt((String) cbxChonThangThongKe.getSelectedItem());
		int namCuaThang = Integer.parseInt((String) cbxChonNamCuaThangThongKe.getSelectedItem());
		data = services.layDuLieuThongkeThang(thang, namCuaThang);
		loadDataToTable(modelTableThongKeThang, data);
		dataThongKeThang = new ArrayList<>();
		dataThongKeThang = data;
		txtTimKiemMatHangThang.setText("");
	}

	public void lamMoiTableNam() {
		ThongKeMatHangServices services = new ThongKeMatHangServices();
		ArrayList<ModelThongKeMatHang> data = new ArrayList<>();
		int nam = Integer.parseInt((String) cbxChonNamThongKe.getSelectedItem());
		data = services.layDuLieuThongkeNam(nam);
		loadDataToTable(modelTableThongKeNam, data);
		dataThongKeNam = new ArrayList<>();
		dataThongKeNam = data;
		txtTimKiemMatHangNam.setText("");
	}

	public void locMatHangNgay() {
		LocalDate ngayThongKe = layNgayDuocChon(jdcChonNgayThongKe);
		ThongKeMatHangServices services = new ThongKeMatHangServices();
		ArrayList<ModelThongKeMatHang> dataKetQua = new ArrayList<>();
		dataThongKeNgay = services.layDuLieuThongkeNgay(ngayThongKe);
		String duLieuTimKiem = txtTimKiemMatHangThongKeNgay.getText();
		if (duLieuTimKiem != null)
			duLieuTimKiem = duLieuTimKiem.trim();
		for (ModelThongKeMatHang m : dataThongKeNgay) {
			if (m.toString().toLowerCase().contains(duLieuTimKiem.toLowerCase())) {
				dataKetQua.add(m);
			}
		}
		loadDataToTable(modelTableThongKeNgay, dataKetQua);
	}

	public void locMatHangThang() {
		int thang = Integer.parseInt((String) cbxChonThangThongKe.getSelectedItem());
		int nam = Integer.parseInt((String) cbxChonNamCuaThangThongKe.getSelectedItem());
		ThongKeMatHangServices services = new ThongKeMatHangServices();
		ArrayList<ModelThongKeMatHang> dataKetQua = new ArrayList<>();
		dataThongKeThang = services.layDuLieuThongkeThang(thang, nam);
		String duLieuTimKiem = txtTimKiemMatHangThang.getText();
		if (duLieuTimKiem != null)
			duLieuTimKiem = duLieuTimKiem.trim();
		for (ModelThongKeMatHang m : dataThongKeThang) {
			if (m.toString().toLowerCase().contains(duLieuTimKiem.toLowerCase())) {
				dataKetQua.add(m);
			}
		}
		loadDataToTable(modelTableThongKeThang, dataKetQua);
	}

	public void locMatHangNam() {
		int nam = Integer.parseInt((String) cbxChonNamThongKe.getSelectedItem());
		ThongKeMatHangServices services = new ThongKeMatHangServices();
		ArrayList<ModelThongKeMatHang> dataKetQua = new ArrayList<>();
		dataThongKeNam = services.layDuLieuThongkeNam(nam);
		String duLieuTimKiem = txtTimKiemMatHangNam.getText();
		if (duLieuTimKiem != null)
			duLieuTimKiem = duLieuTimKiem.trim();
		for (ModelThongKeMatHang m : dataThongKeNam) {
			if (m.toString().toLowerCase().contains(duLieuTimKiem.toLowerCase())) {
				dataKetQua.add(m);
			}
		}
		loadDataToTable(modelTableThongKeNam, dataKetQua);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThongKeNgay)) {
			thongKeNgay();
		} else if (o.equals(btnLamMoiThongKeNgay)) {
			lamMoiNgay(jdcChonNgayThongKe);
			thongKeNgay();
		} else if (o.equals(btnTimKiemMatHangThongKeNgay)) {
			locMatHangNgay();
		} else if (o.equals(btnLamMoiMatHangThongKeNgay)) {
			lamMoiTableNgay();
		}

		else if (o.equals(btnThongKeThang)) {
			thongKeThang();
		} else if (o.equals(btnLamMoiThongKeThang)) {
			lamMoiThangDuocChon(cbxChonThangThongKe, cbxChonNamCuaThangThongKe);
			thongKeThang();
		} else if (o.equals(btnTimKiemThang)) {
			locMatHangThang();
		} else if (o.equals(btnLamMoiMatHangThongKeThang)) {
			lamMoiTableThang();
		}

		else if (o.equals(btnThongKeNam)) {
			thongKeNam();
		} else if (o.equals(btnLamMoiThongKeNam)) {
			lamMoiNamDuocChon(cbxChonNamThongKe);
			thongKeNam();
		} else if (o.equals(btnTimKiemMatHangThongKeNam)) {
			locMatHangNam();
		} else if (o.equals(btnLamMoiMatHangThongKeNam)) {
			lamMoiTableNam();
		}

		else if (o.equals(btnXuatDuLieuThongKeMatHangNgay)) {
			if (dataThongKeNgay.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu thống kê !");
			} else {
				ThongKeMatHangServices services = new ThongKeMatHangServices();
				if (services.taoFilleExcelNgay(layNgayDuocChon(jdcChonNgayThongKe))) {
					JOptionPane.showMessageDialog(this,
							"Dữ liệu đã được lưu tại DuLieuThongKe\\" + "ThongKeMatHangBanChayTrongNgay"
									+ layNgayDuocChon(jdcChonNgayThongKe).toString() + ".xlsx");
				} else {
					JOptionPane.showMessageDialog(this, "Lỗi không thể tạo thống kê !");
				}
			}
		}
		else if (o.equals(btnXuatDuLieuThongKeMatHangThang)) {
			if (dataThongKeThang.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu thống kê !");
			} else {
				ThongKeMatHangServices services = new ThongKeMatHangServices();
				int thang = Integer.parseInt((String) cbxChonThangThongKe.getSelectedItem());
				int nam = Integer.parseInt((String) cbxChonNamCuaThangThongKe.getSelectedItem());
				if (services.taoFilleExcelThang(thang, nam)) {
					JOptionPane.showMessageDialog(this,
							"Dữ liệu đã được lưu tại DuLieuThongKe\\" + "ThongKeMatHangBanChayTrongThang"+ thang+"/"+ nam + ".xlsx");
				} else {
					JOptionPane.showMessageDialog(this, "Lỗi không thể tạo thống kê !");
				}
			}
		}
		else if (o.equals(btnXuatDuLieuThongKeMatHangNam)) {
			if (dataThongKeNam.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu thống kê !");
			} else {
				ThongKeMatHangServices services = new ThongKeMatHangServices();
				int nam = Integer.parseInt((String) cbxChonNamThongKe.getSelectedItem());
				if (services.taoFilleExcelNam(nam)) {
					JOptionPane.showMessageDialog(this,
							"Dữ liệu đã được lưu tại DuLieuThongKe\\" + "ThongKeMatHangBanChayTrongNam"+ nam + ".xlsx");
				} else {
					JOptionPane.showMessageDialog(this, "Lỗi không thể tạo thống kê !");
				}
			}
		}
	}
}
