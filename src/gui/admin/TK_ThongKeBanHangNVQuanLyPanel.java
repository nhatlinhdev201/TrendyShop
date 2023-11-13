package gui.admin;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

//import entities.AccountLogin;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class TK_ThongKeBanHangNVQuanLyPanel extends JPanel implements ActionListener {
	private String[] cols = { "Xếp hạng", "Mã sản phẩm", "Tên sản phẩm", "Số lượng bán ra" };
	private DefaultTableModel modelTblThongKeBanHangNgay;
	private JTable tblThongKeBanHangNgay;
	private DefaultTableModel modelTblThongKeBanHangThang;
	private JTable tblThongKeBanHangThang;
	private DefaultTableModel modelTblThongKeBanHangNam;
	private JTable tblThongKeBanHangNam;
	private JPanel panelTbale;
	private JButton btnThongKeNgay;

//	private void loadDataToTable(ArrayList<AccountLogin> dsIn, DefaultTableModel model) {
//		model.setRowCount(0);
//		for (AccountLogin nv : dsIn) {
//			addOneRowToTable(nv, model);
//		}
//	}

//	private void addOneRowToTable(AccountLogin nv, DefaultTableModel model) {
//		model.addRow(new Object[] { "a", "b", "c", "d" });
//	}

	/**
	 * Create the panel.
	 */
	public TK_ThongKeBanHangNVQuanLyPanel() {
		this.setBounds(0, 0, 1350, 640);
		setLayout(null);

		JPanel panelCN_CNThongKeBanhang = new JPanel();
		panelCN_CNThongKeBanhang.setLayout(null);
		panelCN_CNThongKeBanhang.setBounds(0, 0, 1350, 638);
		add(panelCN_CNThongKeBanhang);

		JLabel lblNewLabel = new JLabel("THỐNG KÊ BÁN HÀNG");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(580, 0, 196, 25);
		panelCN_CNThongKeBanhang.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 1350, 627);
		panelCN_CNThongKeBanhang.add(tabbedPane);

		JPanel panelTabThongKeTheoNgay = new JPanel();
		panelTabThongKeTheoNgay.setLayout(null);
		panelTabThongKeTheoNgay.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo ngày", null, panelTabThongKeTheoNgay, null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 668, 577);
		panelTabThongKeTheoNgay.add(panel_1);
		panel_1.setLayout(null);

		JPanel panelBoLocTimKiem_2 = new JPanel();
		panelBoLocTimKiem_2.setLayout(null);
		panelBoLocTimKiem_2.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBoLocTimKiem_2.setBounds(10, 11, 648, 127);
		panel_1.add(panelBoLocTimKiem_2);

		btnThongKeNgay = new JButton("Thống kê");
		btnThongKeNgay.setBounds(10, 89, 89, 23);
		panelBoLocTimKiem_2.add(btnThongKeNgay);

		JLabel lblNVMaNhanVienTimKiem_2_1 = new JLabel("Loại mặt hàng :");
		lblNVMaNhanVienTimKiem_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem_2_1.setBounds(326, 25, 102, 23);
		panelBoLocTimKiem_2.add(lblNVMaNhanVienTimKiem_2_1);

		JComboBox cbxLoaiMatHangTKBHNgay = new JComboBox();
		cbxLoaiMatHangTKBHNgay.setModel(new DefaultComboBoxModel(new String[] { "Loại mặt hàng" }));
		cbxLoaiMatHangTKBHNgay.setBounds(436, 26, 202, 22);
		panelBoLocTimKiem_2.add(cbxLoaiMatHangTKBHNgay);

		JLabel lblThiGianNgy = new JLabel("Thời gian ngày : ");
		lblThiGianNgy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThiGianNgy.setBounds(10, 25, 108, 23);
		panelBoLocTimKiem_2.add(lblThiGianNgy);

		JDateChooser jdcChonNgayTKBHNgay = new JDateChooser();
		jdcChonNgayTKBHNgay.setBounds(120, 25, 178, 23);
		panelBoLocTimKiem_2.add(jdcChonNgayTKBHNgay);

		JRadioButton radbtnMatHangBanChayNgay = new JRadioButton("Mặt hàng bán chạy");
		radbtnMatHangBanChayNgay.setBounds(232, 58, 143, 23);
		panelBoLocTimKiem_2.add(radbtnMatHangBanChayNgay);

		JRadioButton radbtnMatHangBanChamNgay = new JRadioButton("Mặt hàng bán chậm");
		radbtnMatHangBanChamNgay.setBounds(436, 58, 143, 23);
		panelBoLocTimKiem_2.add(radbtnMatHangBanChamNgay);

		JLabel lblNVMaNhanVienTimKiem_2_2 = new JLabel("Thống kê top :");
		lblNVMaNhanVienTimKiem_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem_2_2.setBounds(10, 55, 102, 23);
		panelBoLocTimKiem_2.add(lblNVMaNhanVienTimKiem_2_2);

		JComboBox cbxThongKeTopTKBHNgay = new JComboBox();
		cbxThongKeTopTKBHNgay.setModel(new DefaultComboBoxModel(new String[] { "5", "10", "15", "20", "30" }));
		cbxThongKeTopTKBHNgay.setBounds(121, 55, 57, 22);
		panelBoLocTimKiem_2.add(cbxThongKeTopTKBHNgay);

		panelTbale = new JPanel();
		panelTbale.setBorder(new TitledBorder(null, "K\u1EBFt qu\u1EA3 th\u1ED1ng k\u00EA", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelTbale.setBounds(10, 149, 648, 417);
		panel_1.add(panelTbale);
		panelTbale.setLayout(new BorderLayout(0, 0));

		// <Table Thống kê bán hàng ngày>

		modelTblThongKeBanHangNgay = new DefaultTableModel(cols, 0);
		tblThongKeBanHangNgay = new JTable(modelTblThongKeBanHangNgay);
		panelTbale.add(new JScrollPane(tblThongKeBanHangNgay));
		// <======>

		JPanel panelBieuDoThongKe = new JPanel();
		panelBieuDoThongKe.setBounds(688, 11, 647, 577);
		panelTabThongKeTheoNgay.add(panelBieuDoThongKe);
		panelBieuDoThongKe.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA theo ng\u00E0y",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 11, 627, 555);
		panelBieuDoThongKe.add(panel_3);
		panel_3.setLayout(null);

		JPanel panelBieuDoThongKeNgay = new JPanel();
		panelBieuDoThongKeNgay.setBackground(new Color(64, 224, 208));
		panelBieuDoThongKeNgay.setBounds(10, 22, 607, 348);
		panel_3.add(panelBieuDoThongKeNgay);

		JLabel lblNewLabel_1 = new JLabel("Biểu đồ thống kê lượng bán ra top 10 mặt hàng trong ngày");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(126, 381, 343, 14);
		panel_3.add(lblNewLabel_1);

		JPanel panelChuThichNgay = new JPanel();
		panelChuThichNgay.setBorder(
				new TitledBorder(null, "Ch\u00FA th\u00EDch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChuThichNgay.setBounds(10, 407, 607, 91);
		panel_3.add(panelChuThichNgay);

		JButton btnXuatDuLieuThongKeNgay = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuThongKeNgay.setBounds(111, 509, 143, 23);
		panel_3.add(btnXuatDuLieuThongKeNgay);

		JButton btnTaoBaoCaoNgay = new JButton("Tạo báo cáo");
		btnTaoBaoCaoNgay.setBounds(380, 509, 122, 23);
		panel_3.add(btnTaoBaoCaoNgay);

		JPanel panelTabThongKeTheoThang = new JPanel();
		panelTabThongKeTheoThang.setLayout(null);
		panelTabThongKeTheoThang.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo tháng", null, panelTabThongKeTheoThang, null);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 11, 668, 577);
		panelTabThongKeTheoThang.add(panel_1_1);

		JPanel panelBoLocTimKiem_2_1 = new JPanel();
		panelBoLocTimKiem_2_1.setLayout(null);
		panelBoLocTimKiem_2_1.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBoLocTimKiem_2_1.setBounds(10, 11, 648, 127);
		panel_1_1.add(panelBoLocTimKiem_2_1);

		JButton btnThongKeNgay_1 = new JButton("Thống kê");
		btnThongKeNgay_1.setBounds(10, 89, 89, 23);
		panelBoLocTimKiem_2_1.add(btnThongKeNgay_1);

		JLabel lblNVMaNhanVienTimKiem_2_1_1 = new JLabel("Loại mặt hàng :");
		lblNVMaNhanVienTimKiem_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem_2_1_1.setBounds(326, 25, 102, 23);
		panelBoLocTimKiem_2_1.add(lblNVMaNhanVienTimKiem_2_1_1);

		JComboBox cbxLoaiMatHangTKBHThang = new JComboBox();
		cbxLoaiMatHangTKBHThang.setBounds(436, 26, 202, 22);
		panelBoLocTimKiem_2_1.add(cbxLoaiMatHangTKBHThang);

		JLabel lblThiGianThng = new JLabel("Thời gian tháng : ");
		lblThiGianThng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThiGianThng.setBounds(10, 25, 102, 23);
		panelBoLocTimKiem_2_1.add(lblThiGianThng);

		JRadioButton radbtnMatHangBanChayThang = new JRadioButton("Mặt hàng bán chạy");
		radbtnMatHangBanChayThang.setBounds(232, 58, 143, 23);
		panelBoLocTimKiem_2_1.add(radbtnMatHangBanChayThang);

		JRadioButton radbtnMatHangBanChamThang = new JRadioButton("Mặt hàng bán chậm");
		radbtnMatHangBanChamThang.setBounds(436, 58, 143, 23);
		panelBoLocTimKiem_2_1.add(radbtnMatHangBanChamThang);

		JLabel lblNVMaNhanVienTimKiem_2_2_1 = new JLabel("Thống kê top :");
		lblNVMaNhanVienTimKiem_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem_2_2_1.setBounds(10, 55, 102, 23);
		panelBoLocTimKiem_2_1.add(lblNVMaNhanVienTimKiem_2_2_1);

		JComboBox cbxThongKeTopTKBHThang = new JComboBox();
		cbxThongKeTopTKBHThang.setModel(new DefaultComboBoxModel(new String[] { "5", "10", "15", "20", "30" }));
		cbxThongKeTopTKBHThang.setBounds(121, 55, 57, 22);
		panelBoLocTimKiem_2_1.add(cbxThongKeTopTKBHThang);

		JComboBox cbxThoiGianthangTKBHThang = new JComboBox();
		cbxThoiGianthangTKBHThang.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		cbxThoiGianthangTKBHThang.setBounds(122, 26, 44, 22);
		panelBoLocTimKiem_2_1.add(cbxThoiGianthangTKBHThang);

		JLabel lblNm = new JLabel("Năm : ");
		lblNm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNm.setBounds(169, 25, 44, 23);
		panelBoLocTimKiem_2_1.add(lblNm);

		JComboBox cbxThoiGianNamCuaThangTKBHThang = new JComboBox();
		cbxThoiGianNamCuaThangTKBHThang.setModel(new DefaultComboBoxModel(new String[] { "2022", "2023" }));
		cbxThoiGianNamCuaThangTKBHThang.setBounds(211, 26, 57, 22);
		panelBoLocTimKiem_2_1.add(cbxThoiGianNamCuaThangTKBHThang);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "K\u1EBFt qu\u1EA3 th\u1ED1ng k\u00EA", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 149, 648, 417);
		panel_1_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		// <Table Thống kê bán hàng tháng>

		modelTblThongKeBanHangThang = new DefaultTableModel(cols, 0);
		tblThongKeBanHangThang = new JTable(modelTblThongKeBanHangThang);
		panel_2.add(new JScrollPane(tblThongKeBanHangThang));
		// <======>

		JPanel panelBieuDoThongKe_1 = new JPanel();
		panelBieuDoThongKe_1.setLayout(null);
		panelBieuDoThongKe_1.setBounds(688, 11, 647, 577);
		panelTabThongKeTheoThang.add(panelBieuDoThongKe_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA theo th\u00E1ng", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		panel_3_1.setBounds(10, 11, 627, 555);
		panelBieuDoThongKe_1.add(panel_3_1);

		JPanel panelBieuDoThongKeThang = new JPanel();
		panelBieuDoThongKeThang.setBackground(new Color(64, 224, 208));
		panelBieuDoThongKeThang.setBounds(10, 22, 607, 348);
		panel_3_1.add(panelBieuDoThongKeThang);

		JLabel lblNewLabel_1_1 = new JLabel("Biểu đồ thống kê lượng bán ra top 10 mặt hàng trong tháng");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1_1.setBounds(126, 381, 343, 14);
		panel_3_1.add(lblNewLabel_1_1);

		JPanel panelChuThichThang = new JPanel();
		panelChuThichThang.setBorder(
				new TitledBorder(null, "Ch\u00FA th\u00EDch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChuThichThang.setBounds(10, 407, 607, 91);
		panel_3_1.add(panelChuThichThang);

		JButton btnXuatDuLieuThongKeThang = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuThongKeThang.setBounds(111, 509, 143, 23);
		panel_3_1.add(btnXuatDuLieuThongKeThang);

		JButton btnTaoBaoCaoThang = new JButton("Tạo báo cáo");
		btnTaoBaoCaoThang.setBounds(380, 509, 122, 23);
		panel_3_1.add(btnTaoBaoCaoThang);

		JPanel panelTabThongKeTheoNam = new JPanel();
		panelTabThongKeTheoNam.setLayout(null);
		panelTabThongKeTheoNam.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo năm", null, panelTabThongKeTheoNam, null);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(10, 11, 668, 577);
		panelTabThongKeTheoNam.add(panel_1_2);

		JPanel panelBoLocTimKiem_2_2 = new JPanel();
		panelBoLocTimKiem_2_2.setLayout(null);
		panelBoLocTimKiem_2_2.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBoLocTimKiem_2_2.setBounds(10, 11, 648, 127);
		panel_1_2.add(panelBoLocTimKiem_2_2);

		JButton btnThongKeNam = new JButton("Thống kê");
		btnThongKeNam.setBounds(10, 89, 89, 23);
		panelBoLocTimKiem_2_2.add(btnThongKeNam);

		JLabel lblNVMaNhanVienTimKiem_2_1_2 = new JLabel("Loại mặt hàng :");
		lblNVMaNhanVienTimKiem_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem_2_1_2.setBounds(326, 25, 102, 23);
		panelBoLocTimKiem_2_2.add(lblNVMaNhanVienTimKiem_2_1_2);

		JComboBox cbxLoaiMatHangTKBHNam = new JComboBox();
		cbxLoaiMatHangTKBHNam.setBounds(436, 26, 202, 22);
		panelBoLocTimKiem_2_2.add(cbxLoaiMatHangTKBHNam);

		JLabel lblThiGianNm = new JLabel("Thời gian năm : ");
		lblThiGianNm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThiGianNm.setBounds(10, 25, 108, 23);
		panelBoLocTimKiem_2_2.add(lblThiGianNm);

		JRadioButton radbtnMatHangBanChayNam = new JRadioButton("Mặt hàng bán chạy");
		radbtnMatHangBanChayNam.setBounds(232, 58, 143, 23);
		panelBoLocTimKiem_2_2.add(radbtnMatHangBanChayNam);

		JRadioButton radbtnMatHangBanChamNam = new JRadioButton("Mặt hàng bán chậm");
		radbtnMatHangBanChamNam.setBounds(436, 58, 143, 23);
		panelBoLocTimKiem_2_2.add(radbtnMatHangBanChamNam);

		JLabel lblNVMaNhanVienTimKiem_2_2_2 = new JLabel("Thống kê top :");
		lblNVMaNhanVienTimKiem_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem_2_2_2.setBounds(10, 55, 102, 23);
		panelBoLocTimKiem_2_2.add(lblNVMaNhanVienTimKiem_2_2_2);

		JComboBox cbxThongKeTopTKBHNam = new JComboBox();
		cbxThongKeTopTKBHNam.setBounds(121, 55, 69, 22);
		panelBoLocTimKiem_2_2.add(cbxThongKeTopTKBHNam);

		JComboBox cbxNamThongKeTKBHNam = new JComboBox();
		cbxNamThongKeTKBHNam.setModel(new DefaultComboBoxModel(new String[] { "2022", "2023" }));
		cbxNamThongKeTKBHNam.setBounds(121, 26, 69, 22);
		panelBoLocTimKiem_2_2.add(cbxNamThongKeTKBHNam);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "K\u1EBFt qu\u1EA3 th\u1ED1ng k\u00EA", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 149, 648, 417);
		panel_1_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		// <Table Thống kê bán hàng Năm>

		modelTblThongKeBanHangNam = new DefaultTableModel(cols, 0);
		tblThongKeBanHangNam = new JTable(modelTblThongKeBanHangNam);
		panel_4.add(new JScrollPane(tblThongKeBanHangNam));
		// <======>

		JPanel panelBieuDoThongKe_2 = new JPanel();
		panelBieuDoThongKe_2.setLayout(null);
		panelBieuDoThongKe_2.setBounds(688, 11, 647, 577);
		panelTabThongKeTheoNam.add(panelBieuDoThongKe_2);

		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA theo n\u0103m", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_3_2.setBounds(10, 11, 627, 555);
		panelBieuDoThongKe_2.add(panel_3_2);

		JPanel panelBieuDoThongKeNgay_2 = new JPanel();
		panelBieuDoThongKeNgay_2.setBackground(new Color(64, 224, 208));
		panelBieuDoThongKeNgay_2.setBounds(10, 22, 607, 348);
		panel_3_2.add(panelBieuDoThongKeNgay_2);

		JLabel lblNewLabel_1_2 = new JLabel("Biểu đồ thống kê lượng bán ra top 10 mặt hàng trong năm");
		lblNewLabel_1_2.setForeground(Color.RED);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1_2.setBounds(126, 381, 343, 14);
		panel_3_2.add(lblNewLabel_1_2);

		JPanel panelChuThichNam = new JPanel();
		panelChuThichNam.setBorder(
				new TitledBorder(null, "Ch\u00FA th\u00EDch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChuThichNam.setBounds(10, 407, 607, 91);
		panel_3_2.add(panelChuThichNam);

		JButton btnXuatDuLieuThongKeNam = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuThongKeNam.setBounds(111, 509, 143, 23);
		panel_3_2.add(btnXuatDuLieuThongKeNam);

		JButton btnTaoBaoCaoNam = new JButton("Tạo báo cáo");
		btnTaoBaoCaoNam.setBounds(380, 509, 122, 23);
		panel_3_2.add(btnTaoBaoCaoNam);
		;

		// <===================>
		btnThongKeNgay.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThongKeNgay)) {
//			AccountLogin a = new AccountLogin();
//			addOneRowToTable(a, modelTblThongKeBanHangNgay);
		}
	}
}
