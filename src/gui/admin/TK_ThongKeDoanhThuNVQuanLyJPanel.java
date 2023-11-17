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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Label;

public class TK_ThongKeDoanhThuNVQuanLyJPanel extends JPanel implements ActionListener {
	private String[] cols = { "Xếp hạng theo doanh thu", "Nhân viên", "Tổng doanh thu (vnđ)", "Tổng lãi trên nhân viên (vnđ)", "Số hóa đơn được lập" };
	private DefaultTableModel modelTableThongKeNgay;

	private JTextField txtTenNhanVienTimKiemNgay;
	private JTextField txtMaNhanVienTimKiemNgay;
	private JButton btnLocDuLieuNgay;
	private JButton btnXuatDuLieuThongKeNgay;
	private JTable tblDuLieuTKNVNgay;
	private JTextField txtDoanhThuCHNgay;
	private JTextField txtTongLaiCHNgay;
	private JTextField txtTongTienNhapHangCHNgay;
	private JTextField txtTongSoHoaDonDuocLapCHNgay;
	private JTextField txtTongThueCHNgay;
	private JTextField txtTongKhuyenMaiCHNgay;

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
		tabbedPane.addTab("Theo ngày", null, panelTabThongKeTheoNgay, null);
		panelTabThongKeTheoNgay.setLayout(null);

		JPanel panelDuLieuThongKe = new JPanel();
		panelDuLieuThongKe.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panelDuLieuThongKe.setBounds(10, 11, 791, 579);
		panelTabThongKeTheoNgay.add(panelDuLieuThongKe);
		panelDuLieuThongKe.setLayout(null);

		JPanel panelBoLocTimKiem = new JPanel();
		panelBoLocTimKiem.setBounds(10, 11, 769, 115);
		panelDuLieuThongKe.add(panelBoLocTimKiem);
		panelBoLocTimKiem.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelBoLocTimKiem.setLayout(null);

		JLabel lblTenNVTimKiem = new JLabel("Tên nhân viên :");
		lblTenNVTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNVTimKiem.setBounds(34, 29, 108, 23);
		panelBoLocTimKiem.add(lblTenNVTimKiem);

		txtTenNhanVienTimKiemNgay = new JTextField();
		txtTenNhanVienTimKiemNgay.setColumns(10);
		txtTenNhanVienTimKiemNgay.setBounds(170, 30, 191, 22);
		panelBoLocTimKiem.add(txtTenNhanVienTimKiemNgay);

		txtMaNhanVienTimKiemNgay = new JTextField();
		txtMaNhanVienTimKiemNgay.setColumns(10);
		txtMaNhanVienTimKiemNgay.setBounds(170, 71, 191, 22);
		panelBoLocTimKiem.add(txtMaNhanVienTimKiemNgay);

		JLabel lblNVMaNhanVienTimKiem = new JLabel("Mã nhân viên");
		lblNVMaNhanVienTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem.setBounds(34, 70, 108, 23);
		panelBoLocTimKiem.add(lblNVMaNhanVienTimKiem);

		btnLocDuLieuNgay = new JButton("Lọc dữ liệu");
		btnLocDuLieuNgay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLocDuLieuNgay.setBounds(412, 73, 100, 31);
		panelBoLocTimKiem.add(btnLocDuLieuNgay);

		JLabel lblThongKeNgay = new JLabel("Thống kê ngày :");
		lblThongKeNgay.setBounds(412, 30, 114, 23);
		panelBoLocTimKiem.add(lblThongKeNgay);
		lblThongKeNgay.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JDateChooser jdcChonNgayThongKe = new JDateChooser();
		jdcChonNgayThongKe.setBounds(536, 30, 185, 23);
		panelBoLocTimKiem.add(jdcChonNgayThongKe);

		JButton btnLamMoiDuLieuNgay = new JButton("Làm mới dữ liệu");
		btnLamMoiDuLieuNgay.setBounds(537, 73, 124, 31);
		panelBoLocTimKiem.add(btnLamMoiDuLieuNgay);

		JPanel panelBangNhanVienTKDTNgay = new JPanel();
		panelBangNhanVienTKDTNgay.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBangNhanVienTKDTNgay.setBounds(10, 159, 769, 201);
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
					String maNhanVien = (String) tblDuLieuTKNVNgay.getValueAt(selectedRow, 0);
					String tenNhanVien = (String) tblDuLieuTKNVNgay.getValueAt(selectedRow, 1);
//					txtTenNhanVienTimKiemTKDTNgay.setText(maNhanVien);
//					txtMaNhanVienTimKiemTKDTNgay.setText(tenNhanVien);
//					taiKhoanThongKeNgay.setMaNhanVien(maNhanVien);
//					taiKhoanThongKeNgay.setHoTen(tenNhanVien);
//					chonNhanVienNgay(maNhanVien, tenNhanVien);
				}
				;
			}
		});

		JLabel lblNewLabel_1 = new JLabel("DỮ LIỆU THỐNG KÊ DOANH THU BÁN HÀNG THEO NHÂN VIÊN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(211, 125, 416, 23);
		panelDuLieuThongKe.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 405, 771, 147);
		panelDuLieuThongKe.add(panel);
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
		
		JLabel lblNewLabel_1_1 = new JLabel("DỮ LIỆU THỐNG KÊ DOANH THU BÁN HÀNG TRÊN TOÀN CỬA HÀNG");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(194, 371, 432, 23);
		panelDuLieuThongKe.add(lblNewLabel_1_1);

		JPanel panelBieuDoThongKeNgay = new JPanel();
		panelBieuDoThongKeNgay.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBieuDoThongKeNgay.setBounds(811, 11, 524, 537);
		panelTabThongKeTheoNgay.add(panelBieuDoThongKeNgay);
		panelBieuDoThongKeNgay.setLayout(null);

		JPanel panelBieuDoThongKeDoanhThuNgay = new JPanel();
		panelBieuDoThongKeDoanhThuNgay.setBackground(SystemColor.activeCaptionBorder);
		panelBieuDoThongKeDoanhThuNgay.setBounds(10, 11, 504, 515);
		panelBieuDoThongKeNgay.add(panelBieuDoThongKeDoanhThuNgay);
		panelBieuDoThongKeDoanhThuNgay.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("doanh thu các nhân viên trong ngày");
		lblNewLabel_2.setBounds(104, 237, 218, 14);
		panelBieuDoThongKeDoanhThuNgay.add(lblNewLabel_2);

		btnXuatDuLieuThongKeNgay = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuThongKeNgay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuThongKeNgay.setBounds(1017, 560, 174, 30);
		panelTabThongKeTheoNgay.add(btnXuatDuLieuThongKeNgay);

		// <=============================================================>
		JPanel panelTabThongKeTheoThang = new JPanel();
		panelTabThongKeTheoThang.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo tháng", null, panelTabThongKeTheoThang, null);
		panelTabThongKeTheoThang.setLayout(null);

		// <==================================================>
		JPanel panelTabThongKeTheoNam = new JPanel();
		panelTabThongKeTheoNam.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo năm", null, panelTabThongKeTheoNam, null);
		panelTabThongKeTheoNam.setLayout(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLocDuLieuNgay)) {
			JOptionPane.showMessageDialog(this, "Ok fen");
		}
	}
}
