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
import javax.swing.table.DefaultTableModel;
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
import java.awt.SystemColor;
import java.awt.Label;

public class TK_ThongKeDoanhThuNVQuanLyJPanel extends JPanel implements ActionListener {
	private String[] cols = { "Xếp hạng theo doanh thu", "Nhân viên", "Tổng doanh thu (vnđ)",
			"Tổng lãi trong ngày (vnđ)", "Số hóa đơn được lập" };
	private DefaultTableModel modelTableThongKeNgay;
	private ModelThongKeDoanhThu dataToanCuaHangTrongNgay;
	private ArrayList<ModelThongKeDoanhThu> dataThongKeNhanVienNgay;
	private ArrayList<ModelThongKeDoanhThu> dataThongKeCacNgayTrongThangCh;
	private ArrayList<ModelExportFileThongKe> dataFileThongKeTrenNgay;

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
	private JButton btnLamMoiDuLieuNgay;
	private JPanel panelBieuDoThongKeDoanhThuNgay;
	private JTextField txtThongTinTimKiemNgay;
	private JButton btnThongKeNgay;

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
		tabbedPane.addTab("Thống kê trên ngày", null, panelTabThongKeTheoNgay, null);
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

		btnLamMoiDuLieuNgay = new JButton("Làm mới dữ liệu");
		btnLamMoiDuLieuNgay.setBounds(571, 26, 151, 31);
		panelBoLocTimKiem.add(btnLamMoiDuLieuNgay);
		btnLamMoiDuLieuNgay.addActionListener(this);

		JPanel panelBangNhanVienTKDTNgay = new JPanel();
		panelBangNhanVienTKDTNgay.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBangNhanVienTKDTNgay.setBounds(10, 417, 769, 151);
		panelDuLieuThongKe.add(panelBangNhanVienTKDTNgay);
		panelBangNhanVienTKDTNgay.setLayout(new BorderLayout(0, 0));

		modelTableThongKeNgay = new DefaultTableModel(cols, 0);
		tblDuLieuTKNVNgay = new JTable(modelTableThongKeNgay);
		panelBangNhanVienTKDTNgay.add(new JScrollPane(tblDuLieuTKNVNgay), BorderLayout.CENTER);
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
		panelBieuDoThongKeNgay.setBounds(811, 11, 524, 537);
		panelTabThongKeTheoNgay.add(panelBieuDoThongKeNgay);
		panelBieuDoThongKeNgay.setLayout(null);

		panelBieuDoThongKeDoanhThuNgay = new JPanel();
		panelBieuDoThongKeDoanhThuNgay.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeDoanhThuNgay.setBounds(10, 11, 504, 515);
		panelBieuDoThongKeNgay.add(panelBieuDoThongKeDoanhThuNgay);
		panelBieuDoThongKeDoanhThuNgay.setLayout(null);

		btnXuatDuLieuThongKeNgay = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuThongKeNgay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuThongKeNgay.setBounds(1017, 560, 174, 30);
		panelTabThongKeTheoNgay.add(btnXuatDuLieuThongKeNgay);
		btnXuatDuLieuThongKeNgay.addActionListener(this);

		// <=============================================================>
		JPanel panelTabThongKeTheoThang = new JPanel();
		panelTabThongKeTheoThang.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Thống kê trên tháng", null, panelTabThongKeTheoThang, null);
		panelTabThongKeTheoThang.setLayout(null);

		// <==================================================>
		JPanel panelTabThongKeTheoNam = new JPanel();
		panelTabThongKeTheoNam.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Thống kê trên năm", null, panelTabThongKeTheoNam, null);
		panelTabThongKeTheoNam.setLayout(null);

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
		
		lamMoiNgay(jdcChonNgayThongKe);
		thongKeNgay();
	}

	private void thongKeNgay() {
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		LocalDate ngayThongKe = layNgayDuocChon(jdcChonNgayThongKe);
		dataThongKeNhanVienNgay = services.layDuLieuThongKeDoanhThuNgayTheoNv(ngayThongKe);
		loadDataToTableNgay(modelTableThongKeNgay, dataThongKeNhanVienNgay);
		dataToanCuaHangTrongNgay = services.layGiuLieuThongKeNgayTrenToanCuaHangTheoNgay(ngayThongKe);
		loadDuLieuThongKeNgayToanCuaHang(dataToanCuaHangTrongNgay);
		veBieuDoThongKeNgay(panelBieuDoThongKeDoanhThuNgay, dataThongKeCacNgayTrongThangCh);
	}

	private void veBieuDoThongKeNgay(JPanel containPanel, ArrayList<ModelThongKeDoanhThu> data) {
		containPanel.removeAll();
		LocalDate thoiGianThongKe = layNgayDuocChon(jdcChonNgayThongKe);
		ThongKeDoanhThuServices doanhThuServices = new ThongKeDoanhThuServices();
		data = doanhThuServices.layDuLieuThongKeCacNgayTrongThang(thoiGianThongKe.getMonthValue(),
				thoiGianThongKe.getYear());
		// data = doanhThuServices.layDuLieuThongKeCacNgayTrongThang(8, 2023);
		doanhThuServices.veBieuDoCotDoanhThu(containPanel, data, "Biểu đồ thống kê doanh thu các ngày trong tháng");
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

	public void loadDataToTableNgay(DefaultTableModel model, ArrayList<ModelThongKeDoanhThu> dataTable) {
		model.setRowCount(0);
		for (ModelThongKeDoanhThu data : dataTable) {
			model.addRow(new Object[] { data.getXepHang(), data.getTenNhanVien(), data.getTongDoanhThu(),
					data.getTongTienLai(), data.getTongSoHoaDonDuocLap() });
		}
	}

	public void lamMoiTableNgay(DefaultTableModel model) {
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		ArrayList<ModelThongKeDoanhThu> dataTable = services.layDuLieuThongKeDoanhThuNgayTheoNv(LocalDate.now());
		loadDataToTableNgay(model, dataTable);
	}
	public void timKiemNhanVien() {
		LocalDate ngayThongKe = layNgayDuocChon(jdcChonNgayThongKe);
		ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
		ArrayList<ModelThongKeDoanhThu> dataThongKeNhanVien = new ArrayList<>();  
		ArrayList<ModelThongKeDoanhThu> dataKetQua = new ArrayList<>();  
		dataThongKeNhanVien = services.layDuLieuThongKeDoanhThuNgayTheoNv(ngayThongKe);
		String duLieuTimKiem = txtThongTinTimKiemNgay.getText();
		if(duLieuTimKiem !=null) duLieuTimKiem = duLieuTimKiem.trim();
		for (ModelThongKeDoanhThu nv : dataThongKeNhanVien) {
			if (nv.toString().toLowerCase().contains(duLieuTimKiem.toLowerCase())) {
				dataKetQua.add(nv);
			}
		}
		loadDataToTableNgay(modelTableThongKeNgay, dataKetQua);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThongKeNgay)) {
			thongKeNgay();
		}
		else if (o.equals(btnLocDuLieuNgay)) {
			timKiemNhanVien();
		} else if(o.equals(btnLamMoiDuLieuNgay)) {
			lamMoiNgay(jdcChonNgayThongKe);
			thongKeNgay();
		} else if(o.equals(btnXuatDuLieuThongKeNgay)) {
			if(dataThongKeNhanVienNgay.size()==0 || dataToanCuaHangTrongNgay == null) {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu thống kê !");
			} else {
				ThongKeDoanhThuServices services = new ThongKeDoanhThuServices();
				LocalDate ngayThongKe = layNgayDuocChon(jdcChonNgayThongKe);
				if(services.xuatFileExcelThongKeNgay(ngayThongKe)) {
					JOptionPane.showMessageDialog(this, "Dữ liệu đã được lưu tại DuLieuThongKe\\"+"ThongKeDoanhThuCacNgayTrongThang" + ngayThongKe.getMonthValue() + "-"
							+ ngayThongKe.getYear() + ".xlsx");
				} else {
					JOptionPane.showMessageDialog(this, "Lỗi không thể tạo thống kê !");
				}
			}
		}
	}
}
