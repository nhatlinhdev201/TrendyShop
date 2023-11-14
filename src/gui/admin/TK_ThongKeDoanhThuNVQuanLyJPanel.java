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
import javax.swing.AbstractButton;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import daos.Dao_ThongKeDoanhThu;
import entities.NhanVien;
import modelsThongKe.BieuDoThongKePanel;
import modelsThongKe.DuLieuBieuDoThongKeDoanhThu;
import modelsThongKe.ModelThongKeDoanhThuNam;
import modelsThongKe.ModelThongKeDoanhThuNgay;
import modelsThongKe.ModelThongKeDoanhThuThang;
import services.ThongKeDoanhThuServices;

import javax.swing.JTextPane;
import java.awt.SystemColor;

public class TK_ThongKeDoanhThuNVQuanLyJPanel extends JPanel implements ActionListener {
	private String[] cols = { "Mã NV", "Tên nhân viên" };
	private String[] nam = { "2019", "2020", "2021", "2022", "2023" };
	private String[] thang = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	private ArrayList<NhanVien> danhSachNhanVienNgay;
	private DefaultTableModel modelTblNhanVienThongKeDoanhThuNgay;
	private JTable tblNhanVienThongKeDoanhThuNgay;
	private DefaultTableModel modelTblNhanVienThongKeDoanhThuThang;
	private DefaultTableModel modelTblNhanVienThongKeDoanhThuNam;

	private JTextField txtTenNhanVienTimKiemTKDTNgay;
	private JTextField txtMaNhanVienTimKiemTKDTNgay;
	private JTextField txtThongKeTrenTaiKhoanNgay;
	private JTextField txtTenNhanVienDuocThongKeNgay;
	private JTextField txtNgayDuocThongKe;
	private JCheckBox cbTatCaNhanVienNgay;
	private JButton btnTimKiemNhanVienTKDTNgay;
	private JTextPane txtTenBieuDo2;

	// <======nhân viên được chọn========>
	// <.
	private JButton btnLamMoiTimKiemNgay;
	private JPanel panelChonNhanVienNgay;
	private JDateChooser jdcChonNgayThongKe;
	// <=======dữ liệu cho thong ke========>
	private ModelThongKeDoanhThuNgay modelThongKeDoanhThuNgay = new ModelThongKeDoanhThuNgay();
	ArrayList<ModelThongKeDoanhThuNgay> listModalThongKeNgay = new ArrayList<>();
	private ModelThongKeDoanhThuThang modelThongKeDoanhThuThang = new ModelThongKeDoanhThuThang();
	ArrayList<ModelThongKeDoanhThuThang> listModelThongKeThang = new ArrayList<>();

	private ModelThongKeDoanhThuNam modelThongKeDoanhThuNam = new ModelThongKeDoanhThuNam();
	ArrayList<ModelThongKeDoanhThuNam> listModelThongKeDoanhThuNam = new ArrayList<>();

	// <=========dữ liệu ban đầu =================>
	private LocalDate today = LocalDate.now();
	private NhanVien taiKhoanDangNhap = new NhanVien("NV0001", "Phạm Nhật Linh", null, null, null, null, null, null,
			true, null, false, null);
	private NhanVien taiKhoanThongKeNgay = new NhanVien();
	private NhanVien taiKhoanThongKeThang = new NhanVien();
	private NhanVien taiKhoanThongKeNam = new NhanVien();
	private JButton btnThongKeNgay;
	private JTextField txtTongDoanhThuTrongNgay;
	private JTextField txtTongTienNhapHangNgay;
	private JTextField txtTongLaiTrongNgay;
	private JTextField txtTongThueNgay;
	private JTextField txtTongTienKhuyenMaiNgay;
	private JTextField txtTongSoHoaDonDuocLapNgay;
	private JTextField txtTongSoLuongMatHangBanRaNgay;
	private JTextField txtTongTienHangDaBanNgay;
	private JPanel panelBieuDoThongKeDoanhThuNgay;
	private JTextField txtTenNhamVienTimKiemThang;
	private JTextField txtMaNhanVienTimKiemThang;
	private JTextField txtTaiKhoanDuocThongKeThang;
	private JTextField txtTenNhanVienDuocThongKeThang;
	private JTextField txtNgaDuocThongKeThang;
	private JTextField txtTongDoanhThuThang;
	private JTextField txtTongTienHangNhapThang;
	private JTextField txtTongLaiThang;
	private JTextField txtTongThueThang;
	private JTextField txtTongTienKhuyenMaiThang;
	private JTextField txtTongSoHoaDonDuocLapThang;
	private JTextField txtTongSoMatHangBanRaThang;
	private JTextField txtTongTienHangDaBanThang;
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
	private JButton xuatThongKeNgayExcel;
	private JTable tblNhanVienThongKeDoanhThuThang;
	private JComboBox<String> cbxChonThangThongKe;
	private JComboBox<String> cbxChonNamCuaThangThongKe;
	private JPanel panelBieuDoThongKeDoanhThuThang;
	private JButton btnTimKiemNhanVienTKDTNThang;
	private JButton btnLamMoiTimKiemThang;
	private JButton btnThongKeThang;
	private ArrayList<NhanVien> danhSachNhanVienThang;
	private JCheckBox cbTatCaNhanVienThang;
	private JButton btnXuatDuLieuThongKeThang;

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
		tabbedPane.setBounds(0, 11, 1350, 661);
		panelCN_CNThongKeDoanhThu.add(tabbedPane);

		// <Table Thống kê doanh thu ngày>
		modelTblNhanVienThongKeDoanhThuNgay = new DefaultTableModel(cols, 0);
		modelTblNhanVienThongKeDoanhThuThang = new DefaultTableModel(cols, 0);

		JPanel panelTabThongKeTheoNgay = new JPanel();
		panelTabThongKeTheoNgay.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo ngày", null, panelTabThongKeTheoNgay, null);
		panelTabThongKeTheoNgay.setLayout(null);

		JPanel panelDuLieuThongKe = new JPanel();
		panelDuLieuThongKe.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panelDuLieuThongKe.setBounds(10, 11, 387, 579);
		panelTabThongKeTheoNgay.add(panelDuLieuThongKe);
		panelDuLieuThongKe.setLayout(null);

		JLabel lblThongKeNgay = new JLabel("Chọn thống kê ngày :");
		lblThongKeNgay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay.setBounds(22, 38, 137, 23);
		panelDuLieuThongKe.add(lblThongKeNgay);

		panelChonNhanVienNgay = new JPanel();
		panelChonNhanVienNgay.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Ch\u1ECDn nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChonNhanVienNgay.setBounds(0, 85, 382, 500);
		panelDuLieuThongKe.add(panelChonNhanVienNgay);
		panelChonNhanVienNgay.setLayout(null);

		cbTatCaNhanVienNgay = new JCheckBox("Tất cả nhân viên");
		cbTatCaNhanVienNgay.setSelected(true);
		cbTatCaNhanVienNgay.setBounds(207, 18, 145, 23);
		panelChonNhanVienNgay.add(cbTatCaNhanVienNgay);
		cbTatCaNhanVienNgay.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// Xử lý sự kiện khi trạng thái của checkbox thay đổi
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Nếu checkbox được chọn, ẩn panel1
					lamMoiDuLieuNgay();
					tatCaNhanVienNgay(true);
				} else {
					// Nếu checkbox không được chọn, hiển thị cả hai panel1 và panel2
					tatCaNhanVienNgay(false);
					lamMoiDuLieuNgay();
					lamMoiTableNhanVienNgay(modelTblNhanVienThongKeDoanhThuNgay);
				}
				;
			};
		});

		JLabel lblTimNVCanThongKe = new JLabel("Tìm nhân viên cần thống kê :");
		lblTimNVCanThongKe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimNVCanThongKe.setBounds(10, 21, 175, 14);
		panelChonNhanVienNgay.add(lblTimNVCanThongKe);

		JPanel panelBoLocTimKiem = new JPanel();
		panelBoLocTimKiem.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelBoLocTimKiem.setBounds(10, 48, 362, 126);
		panelChonNhanVienNgay.add(panelBoLocTimKiem);
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
		btnTimKiemNhanVienTKDTNgay.setBounds(72, 92, 89, 23);
		panelBoLocTimKiem.add(btnTimKiemNhanVienTKDTNgay);

		btnLamMoiTimKiemNgay = new JButton("Làm mới");
		btnLamMoiTimKiemNgay.setBounds(197, 92, 89, 23);
		panelBoLocTimKiem.add(btnLamMoiTimKiemNgay);

		JPanel panelBangNhanVienTKDTNgay = new JPanel();
		panelBangNhanVienTKDTNgay.setBorder(
				new TitledBorder(null, "Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelBangNhanVienTKDTNgay.setBounds(10, 175, 362, 277);
		panelChonNhanVienNgay.add(panelBangNhanVienTKDTNgay);
		panelBangNhanVienTKDTNgay.setLayout(new BorderLayout(0, 0));
		tblNhanVienThongKeDoanhThuNgay = new JTable(modelTblNhanVienThongKeDoanhThuNgay);
		panelBangNhanVienTKDTNgay.add(new JScrollPane(tblNhanVienThongKeDoanhThuNgay));
		tblNhanVienThongKeDoanhThuNgay.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tblNhanVienThongKeDoanhThuNgay.getSelectedRow();
				if (selectedRow != -1) {
					String maNhanVien = (String) tblNhanVienThongKeDoanhThuNgay.getValueAt(selectedRow, 0);
					String tenNhanVien = (String) tblNhanVienThongKeDoanhThuNgay.getValueAt(selectedRow, 1);
					txtTenNhanVienTimKiemTKDTNgay.setText(maNhanVien);
					txtMaNhanVienTimKiemTKDTNgay.setText(tenNhanVien);
					taiKhoanThongKeNgay.setMaNhanVien(maNhanVien);
					taiKhoanThongKeNgay.setHoTen(tenNhanVien);
					chonNhanVienNgay(maNhanVien, tenNhanVien);
				}
				;

			}
		});
		// <======>

		btnThongKeNgay = new JButton("Thống kê");
		btnThongKeNgay.setBounds(130, 457, 89, 23);
		panelChonNhanVienNgay.add(btnThongKeNgay);

		jdcChonNgayThongKe = new JDateChooser();
		jdcChonNgayThongKe.setBounds(169, 38, 185, 23);
		panelDuLieuThongKe.add(jdcChonNgayThongKe);

		JPanel panelKetQuaThongKe = new JPanel();
		panelKetQuaThongKe.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"K\u1EBFt qu\u1EA3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panelKetQuaThongKe.setBounds(407, 11, 928, 227);
		panelTabThongKeTheoNgay.add(panelKetQuaThongKe);
		panelKetQuaThongKe.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.PINK));
		panel.setBounds(44, 131, 328, 3);
		panelKetQuaThongKe.add(panel);

		JLabel lblTKTrenTaiKhoan = new JLabel("Thống kê trên tài khoản : ");
		lblTKTrenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTKTrenTaiKhoan.setBounds(22, 33, 166, 23);
		panelKetQuaThongKe.add(lblTKTrenTaiKhoan);

		txtThongKeTrenTaiKhoanNgay = new JTextField();
		txtThongKeTrenTaiKhoanNgay.setEditable(false);
		txtThongKeTrenTaiKhoanNgay.setColumns(10);
		txtThongKeTrenTaiKhoanNgay.setBounds(224, 33, 166, 22);
		panelKetQuaThongKe.add(txtThongKeTrenTaiKhoanNgay);

		JLabel lblThongKeTheoTieuChi = new JLabel("Tên nhân viên : ");
		lblThongKeTheoTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi.setBounds(22, 67, 166, 23);
		panelKetQuaThongKe.add(lblThongKeTheoTieuChi);

		txtTenNhanVienDuocThongKeNgay = new JTextField();
		txtTenNhanVienDuocThongKeNgay.setEditable(false);
		txtTenNhanVienDuocThongKeNgay.setColumns(10);
		txtTenNhanVienDuocThongKeNgay.setBounds(224, 67, 166, 22);
		panelKetQuaThongKe.add(txtTenNhanVienDuocThongKeNgay);

		txtNgayDuocThongKe = new JTextField();
		txtNgayDuocThongKe.setEditable(false);
		txtNgayDuocThongKe.setColumns(10);
		txtNgayDuocThongKe.setBounds(224, 98, 166, 22);
		panelKetQuaThongKe.add(txtNgayDuocThongKe);

		JLabel labNgayThongKe = new JLabel("Ngày được thống kê  : ");
		labNgayThongKe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labNgayThongKe.setBounds(22, 98, 166, 23);
		panelKetQuaThongKe.add(labNgayThongKe);

		JLabel lblNewLabel_1 = new JLabel("Tổng doanh thu trong ngày  : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(456, 20, 206, 20);
		panelKetQuaThongKe.add(lblNewLabel_1);

		txtTongDoanhThuTrongNgay = new JTextField();
		txtTongDoanhThuTrongNgay.setText((String) null);
		txtTongDoanhThuTrongNgay.setEditable(false);
		txtTongDoanhThuTrongNgay.setColumns(10);
		txtTongDoanhThuTrongNgay.setBounds(660, 20, 180, 20);
		panelKetQuaThongKe.add(txtTongDoanhThuTrongNgay);

		JLabel lblNewLabel_2 = new JLabel("VND");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(850, 23, 46, 14);
		panelKetQuaThongKe.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Tổng tiền nhập hàng : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(456, 47, 206, 20);
		panelKetQuaThongKe.add(lblNewLabel_1_1);

		txtTongTienNhapHangNgay = new JTextField();
		txtTongTienNhapHangNgay.setText((String) null);
		txtTongTienNhapHangNgay.setEditable(false);
		txtTongTienNhapHangNgay.setColumns(10);
		txtTongTienNhapHangNgay.setBounds(660, 48, 180, 20);
		panelKetQuaThongKe.add(txtTongTienNhapHangNgay);

		JLabel lblNewLabel_2_1 = new JLabel("VND");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(850, 51, 46, 14);
		panelKetQuaThongKe.add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_2 = new JLabel("Tổng lãi trong ngày  : ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(456, 178, 206, 18);
		panelKetQuaThongKe.add(lblNewLabel_1_2);

		txtTongLaiTrongNgay = new JTextField();
		txtTongLaiTrongNgay.setText((String) null);
		txtTongLaiTrongNgay.setEditable(false);
		txtTongLaiTrongNgay.setColumns(10);
		txtTongLaiTrongNgay.setBounds(660, 176, 180, 20);
		panelKetQuaThongKe.add(txtTongLaiTrongNgay);

		JLabel lblNewLabel_2_2 = new JLabel("VND");
		lblNewLabel_2_2.setForeground(Color.RED);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(850, 179, 46, 14);
		panelKetQuaThongKe.add(lblNewLabel_2_2);

		JLabel lblNewLabel_1_3 = new JLabel("Tổng thuế   : ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(456, 140, 206, 20);
		panelKetQuaThongKe.add(lblNewLabel_1_3);

		txtTongThueNgay = new JTextField();
		txtTongThueNgay.setText((String) null);
		txtTongThueNgay.setEditable(false);
		txtTongThueNgay.setColumns(10);
		txtTongThueNgay.setBounds(660, 140, 180, 20);
		panelKetQuaThongKe.add(txtTongThueNgay);

		JLabel lblNewLabel_2_3 = new JLabel("VND");
		lblNewLabel_2_3.setForeground(Color.RED);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(850, 143, 46, 14);
		panelKetQuaThongKe.add(lblNewLabel_2_3);

		txtTongTienKhuyenMaiNgay = new JTextField();
		txtTongTienKhuyenMaiNgay.setText((String) null);
		txtTongTienKhuyenMaiNgay.setEditable(false);
		txtTongTienKhuyenMaiNgay.setColumns(10);
		txtTongTienKhuyenMaiNgay.setBounds(660, 109, 180, 20);
		panelKetQuaThongKe.add(txtTongTienKhuyenMaiNgay);

		JLabel lblNewLabel_1_3_1 = new JLabel("Tổng tiền khuyến mãi : ");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1.setBounds(456, 109, 206, 20);
		panelKetQuaThongKe.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_2_3_1 = new JLabel("VND");
		lblNewLabel_2_3_1.setForeground(Color.RED);
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_1.setBounds(850, 112, 46, 14);
		panelKetQuaThongKe.add(lblNewLabel_2_3_1);

		JLabel lblNewLabel_1_4 = new JLabel("Tổng số hóa đơn được lập : ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(22, 145, 206, 20);
		panelKetQuaThongKe.add(lblNewLabel_1_4);

		txtTongSoHoaDonDuocLapNgay = new JTextField();
		txtTongSoHoaDonDuocLapNgay.setText("0");
		txtTongSoHoaDonDuocLapNgay.setEditable(false);
		txtTongSoHoaDonDuocLapNgay.setColumns(10);
		txtTongSoHoaDonDuocLapNgay.setBounds(226, 145, 77, 20);
		panelKetQuaThongKe.add(txtTongSoHoaDonDuocLapNgay);

		JLabel lblNewLabel_2_4 = new JLabel("Hóa đơn");
		lblNewLabel_2_4.setForeground(Color.RED);
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4.setBounds(313, 148, 69, 17);
		panelKetQuaThongKe.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_4_1 = new JLabel("Mặt hàng");
		lblNewLabel_2_4_1.setForeground(Color.RED);
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4_1.setBounds(313, 179, 69, 17);
		panelKetQuaThongKe.add(lblNewLabel_2_4_1);

		JLabel lblNewLabel_1_4_1 = new JLabel("Tổng số lượng mặt hàng bán ra :");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1.setBounds(22, 176, 206, 20);
		panelKetQuaThongKe.add(lblNewLabel_1_4_1);

		txtTongSoLuongMatHangBanRaNgay = new JTextField();
		txtTongSoLuongMatHangBanRaNgay.setText("0");
		txtTongSoLuongMatHangBanRaNgay.setEditable(false);
		txtTongSoLuongMatHangBanRaNgay.setColumns(10);
		txtTongSoLuongMatHangBanRaNgay.setBounds(226, 176, 77, 20);
		panelKetQuaThongKe.add(txtTongSoLuongMatHangBanRaNgay);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Tổng tiền hàng đã bán :");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1.setBounds(456, 78, 206, 20);
		panelKetQuaThongKe.add(lblNewLabel_1_1_2_1);

		txtTongTienHangDaBanNgay = new JTextField();
		txtTongTienHangDaBanNgay.setText((String) null);
		txtTongTienHangDaBanNgay.setEditable(false);
		txtTongTienHangDaBanNgay.setColumns(10);
		txtTongTienHangDaBanNgay.setBounds(660, 79, 180, 20);
		panelKetQuaThongKe.add(txtTongTienHangDaBanNgay);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("VND");
		lblNewLabel_2_1_2_1.setForeground(Color.RED);
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_2_1.setBounds(850, 82, 46, 14);
		panelKetQuaThongKe.add(lblNewLabel_2_1_2_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.PINK));
		panel_1.setBounds(428, 30, 3, 176);
		panelKetQuaThongKe.add(panel_1);

		panelBieuDoThongKeDoanhThuNgay = new JPanel();
		panelBieuDoThongKeDoanhThuNgay.setBorder(new TitledBorder(null, "Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBieuDoThongKeDoanhThuNgay.setBackground(Color.WHITE);
		panelBieuDoThongKeDoanhThuNgay.setBounds(407, 243, 796, 347);
		panelTabThongKeTheoNgay.add(panelBieuDoThongKeDoanhThuNgay);

		xuatThongKeNgayExcel = new JButton("xuất excel");
		xuatThongKeNgayExcel.setBounds(1213, 549, 108, 42);
		panelTabThongKeTheoNgay.add(xuatThongKeNgayExcel);

		// <====================================>
		btnTimKiemNhanVienTKDTNgay.addActionListener(this);
		btnThongKeNgay.addActionListener(this);
		btnLamMoiTimKiemNgay.addActionListener(this);

		// <=============================================================>
		JPanel panelTabThongKeTheoThang = new JPanel();
		panelTabThongKeTheoThang.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo tháng", null, panelTabThongKeTheoThang, null);
		panelTabThongKeTheoThang.setLayout(null);

		JPanel panelDuLieuThongKe_1 = new JPanel();
		panelDuLieuThongKe_1.setLayout(null);
		panelDuLieuThongKe_1.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,

				new Color(0, 0, 0)));
		panelDuLieuThongKe_1.setBounds(10, 11, 387, 579);
		panelTabThongKeTheoThang.add(panelDuLieuThongKe_1);

		JPanel panelChonNhanVienThang = new JPanel();
		panelChonNhanVienThang.setLayout(null);
		panelChonNhanVienThang.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"Ch\u1ECDn nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChonNhanVienThang.setBounds(0, 85, 382, 500);
		panelDuLieuThongKe_1.add(panelChonNhanVienThang);

		cbTatCaNhanVienThang = new JCheckBox("Tất cả nhân viên");
		cbTatCaNhanVienThang.setSelected(true);
		cbTatCaNhanVienThang.setBounds(207, 18, 145, 23);
		panelChonNhanVienThang.add(cbTatCaNhanVienThang);
		cbTatCaNhanVienThang.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// Xử lý sự kiện khi trạng thái của checkbox thay đổi
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Nếu checkbox được chọn, ẩn panel1
					lamMoiDuLieuThang();
					tatCaNhanVienThang(true);
				} else {
					// Nếu checkbox không được chọn, hiển thị cả hai panel1 và panel2
					tatCaNhanVienThang(false);
					lamMoiDuLieuThang();
					lamMoiTableNhanVienThang(modelTblNhanVienThongKeDoanhThuThang);
				}
				;
			};
		});

		JLabel lblTimNVCanThongKe_1 = new JLabel("Tìm nhân viên cần thống kê :");
		lblTimNVCanThongKe_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimNVCanThongKe_1.setBounds(10, 21, 175, 14);
		panelChonNhanVienThang.add(lblTimNVCanThongKe_1);

		JPanel panelBoLocTimKiem_1 = new JPanel();
		panelBoLocTimKiem_1.setLayout(null);
		panelBoLocTimKiem_1
				.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING,

						TitledBorder.TOP, null, null));
		panelBoLocTimKiem_1.setBounds(10, 48, 362, 126);
		panelChonNhanVienThang.add(panelBoLocTimKiem_1);

		JLabel lblTenNVTimKiem_1 = new JLabel("Tên nhân viên :");
		lblTenNVTimKiem_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNVTimKiem_1.setBounds(10, 29, 108, 23);
		panelBoLocTimKiem_1.add(lblTenNVTimKiem_1);

		txtTenNhamVienTimKiemThang = new JTextField();
		txtTenNhamVienTimKiemThang.setColumns(10);
		txtTenNhamVienTimKiemThang.setBounds(146, 30, 191, 22);
		panelBoLocTimKiem_1.add(txtTenNhamVienTimKiemThang);

		txtMaNhanVienTimKiemThang = new JTextField();
		txtMaNhanVienTimKiemThang.setColumns(10);
		txtMaNhanVienTimKiemThang.setBounds(146, 62, 191, 22);
		panelBoLocTimKiem_1.add(txtMaNhanVienTimKiemThang);

		JLabel lblNVMaNhanVienTimKiem_1 = new JLabel("Mã nhân viên");
		lblNVMaNhanVienTimKiem_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem_1.setBounds(10, 61, 108, 23);
		panelBoLocTimKiem_1.add(lblNVMaNhanVienTimKiem_1);

		btnTimKiemNhanVienTKDTNThang = new JButton("Tìm kiếm");
		btnTimKiemNhanVienTKDTNThang.setBounds(72, 92, 89, 23);
		panelBoLocTimKiem_1.add(btnTimKiemNhanVienTKDTNThang);

		btnLamMoiTimKiemThang = new JButton("Làm mới");
		btnLamMoiTimKiemThang.setBounds(197, 92, 89, 23);
		panelBoLocTimKiem_1.add(btnLamMoiTimKiemThang);

		// <>
		JPanel panelBangNhanVienTKDTThang = new JPanel();
		panelBangNhanVienTKDTThang.setBorder(
				new TitledBorder(null, "Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelBangNhanVienTKDTThang.setBounds(10, 175, 362, 277);
		panelChonNhanVienThang.add(panelBangNhanVienTKDTThang);
		panelBangNhanVienTKDTThang.setLayout(new BorderLayout(0, 0));
		tblNhanVienThongKeDoanhThuThang = new JTable(modelTblNhanVienThongKeDoanhThuThang);
		panelBangNhanVienTKDTThang.add(new JScrollPane(tblNhanVienThongKeDoanhThuThang));
		tblNhanVienThongKeDoanhThuThang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tblNhanVienThongKeDoanhThuThang.getSelectedRow();
				if (selectedRow != -1) {
					String maNhanVien = (String) tblNhanVienThongKeDoanhThuThang.getValueAt(selectedRow, 0);
					String tenNhanVien = (String) tblNhanVienThongKeDoanhThuThang.getValueAt(selectedRow, 1);
					txtTenNhamVienTimKiemThang.setText(maNhanVien);
					txtMaNhanVienTimKiemThang.setText(tenNhanVien);
					taiKhoanThongKeThang.setMaNhanVien(maNhanVien);
					taiKhoanThongKeThang.setHoTen(tenNhanVien);
					chonNhanVienThang(maNhanVien, tenNhanVien);
				}
				;

			}
		});
		// <>

		btnThongKeThang = new JButton("Thống kê");
		btnThongKeThang.setBounds(130, 457, 89, 23);
		panelChonNhanVienThang.add(btnThongKeThang);

		JLabel lblThongKeNgay_1 = new JLabel("Chọn thống kê tháng :");
		lblThongKeNgay_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay_1.setBounds(49, 35, 137, 23);
		panelDuLieuThongKe_1.add(lblThongKeNgay_1);

		cbxChonThangThongKe = new JComboBox(thang);
		cbxChonThangThongKe.setBounds(180, 36, 39, 22);
		panelDuLieuThongKe_1.add(cbxChonThangThongKe);

		cbxChonNamCuaThangThongKe = new JComboBox(nam);
		cbxChonNamCuaThangThongKe.setBounds(275, 36, 59, 22);
		panelDuLieuThongKe_1.add(cbxChonNamCuaThangThongKe);

		JLabel lblNewLabel_5 = new JLabel("Năm :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(233, 37, 46, 19);
		panelDuLieuThongKe_1.add(lblNewLabel_5);

		JPanel panelKetQuaThongKe_1 = new JPanel();
		panelKetQuaThongKe_1.setLayout(null);
		panelKetQuaThongKe_1.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"K\u1EBFt qu\u1EA3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,

				new Color(0, 0, 0)));
		panelKetQuaThongKe_1.setBounds(407, 11, 928, 227);
		panelTabThongKeTheoThang.add(panelKetQuaThongKe_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.PINK));
		panel_2.setBounds(44, 131, 328, 3);
		panelKetQuaThongKe_1.add(panel_2);

		JLabel lblTKTrenTaiKhoan_1 = new JLabel("Thống kê trên tài khoản : ");
		lblTKTrenTaiKhoan_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTKTrenTaiKhoan_1.setBounds(22, 33, 166, 23);
		panelKetQuaThongKe_1.add(lblTKTrenTaiKhoan_1);

		txtTaiKhoanDuocThongKeThang = new JTextField();
		txtTaiKhoanDuocThongKeThang.setEditable(false);
		txtTaiKhoanDuocThongKeThang.setColumns(10);
		txtTaiKhoanDuocThongKeThang.setBounds(224, 33, 166, 22);
		panelKetQuaThongKe_1.add(txtTaiKhoanDuocThongKeThang);

		JLabel lblThongKeTheoTieuChi_1 = new JLabel("Tên nhân viên : ");
		lblThongKeTheoTieuChi_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi_1.setBounds(22, 67, 166, 23);
		panelKetQuaThongKe_1.add(lblThongKeTheoTieuChi_1);

		txtTenNhanVienDuocThongKeThang = new JTextField();
		txtTenNhanVienDuocThongKeThang.setEditable(false);
		txtTenNhanVienDuocThongKeThang.setColumns(10);
		txtTenNhanVienDuocThongKeThang.setBounds(224, 67, 166, 22);
		panelKetQuaThongKe_1.add(txtTenNhanVienDuocThongKeThang);

		txtNgaDuocThongKeThang = new JTextField();
		txtNgaDuocThongKeThang.setEditable(false);
		txtNgaDuocThongKeThang.setColumns(10);
		txtNgaDuocThongKeThang.setBounds(224, 98, 166, 22);
		panelKetQuaThongKe_1.add(txtNgaDuocThongKeThang);

		JLabel labNgayThongKe_1 = new JLabel("Ngày được thống kê  : ");
		labNgayThongKe_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labNgayThongKe_1.setBounds(22, 98, 166, 23);
		panelKetQuaThongKe_1.add(labNgayThongKe_1);

		JLabel lblNewLabel_1_5 = new JLabel("Tổng doanh thu trong tháng  : ");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(456, 20, 206, 20);
		panelKetQuaThongKe_1.add(lblNewLabel_1_5);

		txtTongDoanhThuThang = new JTextField();
		txtTongDoanhThuThang.setText((String) null);
		txtTongDoanhThuThang.setEditable(false);
		txtTongDoanhThuThang.setColumns(10);
		txtTongDoanhThuThang.setBounds(660, 20, 180, 20);
		panelKetQuaThongKe_1.add(txtTongDoanhThuThang);

		JLabel lblNewLabel_2_5 = new JLabel("VND");
		lblNewLabel_2_5.setForeground(Color.RED);
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_5.setBounds(850, 23, 46, 14);
		panelKetQuaThongKe_1.add(lblNewLabel_2_5);

		JLabel lblNewLabel_1_1_1 = new JLabel("Tổng tiền nhập hàng : ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(456, 47, 206, 20);
		panelKetQuaThongKe_1.add(lblNewLabel_1_1_1);

		txtTongTienHangNhapThang = new JTextField();
		txtTongTienHangNhapThang.setText((String) null);
		txtTongTienHangNhapThang.setEditable(false);
		txtTongTienHangNhapThang.setColumns(10);
		txtTongTienHangNhapThang.setBounds(660, 48, 180, 20);
		panelKetQuaThongKe_1.add(txtTongTienHangNhapThang);

		JLabel lblNewLabel_2_1_1 = new JLabel("VND");
		lblNewLabel_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(850, 51, 46, 14);
		panelKetQuaThongKe_1.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("Tổng lãi trong tháng  : ");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(456, 178, 206, 18);
		panelKetQuaThongKe_1.add(lblNewLabel_1_2_1);

		txtTongLaiThang = new JTextField();
		txtTongLaiThang.setText((String) null);
		txtTongLaiThang.setEditable(false);
		txtTongLaiThang.setColumns(10);
		txtTongLaiThang.setBounds(660, 176, 180, 20);
		panelKetQuaThongKe_1.add(txtTongLaiThang);

		JLabel lblNewLabel_2_2_1 = new JLabel("VND");
		lblNewLabel_2_2_1.setForeground(Color.RED);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(850, 179, 46, 14);
		panelKetQuaThongKe_1.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_1_3_2 = new JLabel("Tổng thuế   : ");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_2.setBounds(456, 140, 206, 20);
		panelKetQuaThongKe_1.add(lblNewLabel_1_3_2);

		txtTongThueThang = new JTextField();
		txtTongThueThang.setText((String) null);
		txtTongThueThang.setEditable(false);
		txtTongThueThang.setColumns(10);
		txtTongThueThang.setBounds(660, 140, 180, 20);
		panelKetQuaThongKe_1.add(txtTongThueThang);

		JLabel lblNewLabel_2_3_2 = new JLabel("VND");
		lblNewLabel_2_3_2.setForeground(Color.RED);
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_2.setBounds(850, 143, 46, 14);
		panelKetQuaThongKe_1.add(lblNewLabel_2_3_2);

		txtTongTienKhuyenMaiThang = new JTextField();
		txtTongTienKhuyenMaiThang.setText((String) null);
		txtTongTienKhuyenMaiThang.setEditable(false);
		txtTongTienKhuyenMaiThang.setColumns(10);
		txtTongTienKhuyenMaiThang.setBounds(660, 109, 180, 20);
		panelKetQuaThongKe_1.add(txtTongTienKhuyenMaiThang);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Tổng tiền khuyến mãi : ");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1_1.setBounds(456, 109, 206, 20);
		panelKetQuaThongKe_1.add(lblNewLabel_1_3_1_1);

		JLabel lblNewLabel_2_3_1_1 = new JLabel("VND");
		lblNewLabel_2_3_1_1.setForeground(Color.RED);
		lblNewLabel_2_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_1_1.setBounds(850, 112, 46, 14);
		panelKetQuaThongKe_1.add(lblNewLabel_2_3_1_1);

		JLabel lblNewLabel_1_4_2 = new JLabel("Tổng số hóa đơn được lập : ");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_2.setBounds(22, 145, 206, 20);
		panelKetQuaThongKe_1.add(lblNewLabel_1_4_2);

		txtTongSoHoaDonDuocLapThang = new JTextField();
		txtTongSoHoaDonDuocLapThang.setText("0");
		txtTongSoHoaDonDuocLapThang.setEditable(false);
		txtTongSoHoaDonDuocLapThang.setColumns(10);
		txtTongSoHoaDonDuocLapThang.setBounds(226, 145, 77, 20);
		panelKetQuaThongKe_1.add(txtTongSoHoaDonDuocLapThang);

		JLabel lblNewLabel_2_4_2 = new JLabel("Hóa đơn");
		lblNewLabel_2_4_2.setForeground(Color.RED);
		lblNewLabel_2_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4_2.setBounds(313, 148, 69, 17);
		panelKetQuaThongKe_1.add(lblNewLabel_2_4_2);

		JLabel lblNewLabel_2_4_1_1 = new JLabel("Mặt hàng");
		lblNewLabel_2_4_1_1.setForeground(Color.RED);
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4_1_1.setBounds(313, 179, 69, 17);
		panelKetQuaThongKe_1.add(lblNewLabel_2_4_1_1);

		JLabel lblNewLabel_1_4_1_1 = new JLabel("Tổng số lượng mặt hàng bán ra :");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1_1.setBounds(22, 176, 206, 20);
		panelKetQuaThongKe_1.add(lblNewLabel_1_4_1_1);

		txtTongSoMatHangBanRaThang = new JTextField();
		txtTongSoMatHangBanRaThang.setText("0");
		txtTongSoMatHangBanRaThang.setEditable(false);
		txtTongSoMatHangBanRaThang.setColumns(10);
		txtTongSoMatHangBanRaThang.setBounds(226, 176, 77, 20);
		panelKetQuaThongKe_1.add(txtTongSoMatHangBanRaThang);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Tổng tiền hàng đã bán :");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1_1.setBounds(456, 78, 206, 20);
		panelKetQuaThongKe_1.add(lblNewLabel_1_1_2_1_1);

		txtTongTienHangDaBanThang = new JTextField();
		txtTongTienHangDaBanThang.setText((String) null);
		txtTongTienHangDaBanThang.setEditable(false);
		txtTongTienHangDaBanThang.setColumns(10);
		txtTongTienHangDaBanThang.setBounds(660, 79, 180, 20);
		panelKetQuaThongKe_1.add(txtTongTienHangDaBanThang);

		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("VND");
		lblNewLabel_2_1_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_2_1_1.setBounds(850, 82, 46, 14);
		panelKetQuaThongKe_1.add(lblNewLabel_2_1_2_1_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(Color.PINK));
		panel_1_1.setBounds(428, 30, 3, 176);
		panelKetQuaThongKe_1.add(panel_1_1);

		panelBieuDoThongKeDoanhThuThang = new JPanel();
		panelBieuDoThongKeDoanhThuThang.setBorder(new TitledBorder(null, "Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA",

				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBieuDoThongKeDoanhThuThang.setBackground(Color.WHITE);
		panelBieuDoThongKeDoanhThuThang.setBounds(407, 243, 796, 347);
		panelTabThongKeTheoThang.add(panelBieuDoThongKeDoanhThuThang);

		btnXuatDuLieuThongKeThang = new JButton("xuất excel");
		btnXuatDuLieuThongKeThang.setBounds(1213, 492, 108, 40);
		panelTabThongKeTheoThang.add(btnXuatDuLieuThongKeThang);

		// <==================================================>
		JPanel panelTabThongKeTheoNam = new JPanel();
		panelTabThongKeTheoNam.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo năm", null, panelTabThongKeTheoNam, null);
		panelTabThongKeTheoNam.setLayout(null);

		JPanel panelDuLieuThongKe_2 = new JPanel();
		panelDuLieuThongKe_2.setLayout(null);
		panelDuLieuThongKe_2.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,

				new Color(0, 0, 0)));
		panelDuLieuThongKe_2.setBounds(10, 11, 387, 579);
		panelTabThongKeTheoNam.add(panelDuLieuThongKe_2);

		JLabel lblThongKeNgay_2 = new JLabel("Chọn thống kê ngày :");
		lblThongKeNgay_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay_2.setBounds(22, 38, 137, 23);
		panelDuLieuThongKe_2.add(lblThongKeNgay_2);

		JPanel panelChonNhanVienNgay_2 = new JPanel();
		panelChonNhanVienNgay_2.setLayout(null);
		panelChonNhanVienNgay_2.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"Ch\u1ECDn nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChonNhanVienNgay_2.setBounds(0, 85, 382, 500);
		panelDuLieuThongKe_2.add(panelChonNhanVienNgay_2);

		JCheckBox cbTatCaNhanVienNgay_2 = new JCheckBox("Tất cả nhân viên");
		cbTatCaNhanVienNgay_2.setSelected(true);
		cbTatCaNhanVienNgay_2.setBounds(207, 18, 145, 23);
		panelChonNhanVienNgay_2.add(cbTatCaNhanVienNgay_2);

		JLabel lblTimNVCanThongKe_2 = new JLabel("Tìm nhân viên cần thống kê :");
		lblTimNVCanThongKe_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimNVCanThongKe_2.setBounds(10, 21, 175, 14);
		panelChonNhanVienNgay_2.add(lblTimNVCanThongKe_2);

		JPanel panelBoLocTimKiem_2 = new JPanel();
		panelBoLocTimKiem_2.setLayout(null);
		panelBoLocTimKiem_2
				.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING,

						TitledBorder.TOP, null, null));
		panelBoLocTimKiem_2.setBounds(10, 48, 362, 126);
		panelChonNhanVienNgay_2.add(panelBoLocTimKiem_2);

		JLabel lblTenNVTimKiem_2 = new JLabel("Tên nhân viên :");
		lblTenNVTimKiem_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNVTimKiem_2.setBounds(10, 29, 108, 23);
		panelBoLocTimKiem_2.add(lblTenNVTimKiem_2);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(146, 30, 191, 22);
		panelBoLocTimKiem_2.add(textField_13);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(146, 62, 191, 22);
		panelBoLocTimKiem_2.add(textField_14);

		JLabel lblNVMaNhanVienTimKiem_2 = new JLabel("Mã nhân viên");
		lblNVMaNhanVienTimKiem_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem_2.setBounds(10, 61, 108, 23);
		panelBoLocTimKiem_2.add(lblNVMaNhanVienTimKiem_2);

		JButton btnTimKiemNhanVienTKDTNgay_2 = new JButton("Tìm kiếm");
		btnTimKiemNhanVienTKDTNgay_2.setBounds(72, 92, 89, 23);
		panelBoLocTimKiem_2.add(btnTimKiemNhanVienTKDTNgay_2);

		JButton btnLamMoiTimKiemNgay_2 = new JButton("Làm mới");
		btnLamMoiTimKiemNgay_2.setBounds(197, 92, 89, 23);
		panelBoLocTimKiem_2.add(btnLamMoiTimKiemNgay_2);

		JPanel panelBangNhanVienTKDTNgay_2 = new JPanel();
		panelBangNhanVienTKDTNgay_2.setBorder(
				new TitledBorder(null, "Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelBangNhanVienTKDTNgay_2.setBounds(10, 175, 362, 277);
		panelChonNhanVienNgay_2.add(panelBangNhanVienTKDTNgay_2);
		panelBangNhanVienTKDTNgay_2.setLayout(new BorderLayout(0, 0));

		JButton btnThongKeNgay_2 = new JButton("Thống kê");
		btnThongKeNgay_2.setBounds(130, 457, 89, 23);
		panelChonNhanVienNgay_2.add(btnThongKeNgay_2);

		JDateChooser jdcChonNgayThongKe_2 = new JDateChooser();
		jdcChonNgayThongKe_2.setBounds(169, 38, 185, 23);
		panelDuLieuThongKe_2.add(jdcChonNgayThongKe_2);

		JPanel panelKetQuaThongKe_2 = new JPanel();
		panelKetQuaThongKe_2.setLayout(null);
		panelKetQuaThongKe_2.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"K\u1EBFt qu\u1EA3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,

				new Color(0, 0, 0)));
		panelKetQuaThongKe_2.setBounds(407, 11, 928, 227);
		panelTabThongKeTheoNam.add(panelKetQuaThongKe_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.PINK));
		panel_3.setBounds(44, 131, 328, 3);
		panelKetQuaThongKe_2.add(panel_3);

		JLabel lblTKTrenTaiKhoan_2 = new JLabel("Thống kê trên tài khoản : ");
		lblTKTrenTaiKhoan_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTKTrenTaiKhoan_2.setBounds(22, 33, 166, 23);
		panelKetQuaThongKe_2.add(lblTKTrenTaiKhoan_2);

		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBounds(224, 33, 166, 22);
		panelKetQuaThongKe_2.add(textField_15);

		JLabel lblThongKeTheoTieuChi_2 = new JLabel("Tên nhân viên : ");
		lblThongKeTheoTieuChi_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi_2.setBounds(22, 67, 166, 23);
		panelKetQuaThongKe_2.add(lblThongKeTheoTieuChi_2);

		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBounds(224, 67, 166, 22);
		panelKetQuaThongKe_2.add(textField_16);

		textField_17 = new JTextField();
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		textField_17.setBounds(224, 98, 166, 22);
		panelKetQuaThongKe_2.add(textField_17);

		JLabel labNgayThongKe_2 = new JLabel("Ngày được thống kê  : ");
		labNgayThongKe_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labNgayThongKe_2.setBounds(22, 98, 166, 23);
		panelKetQuaThongKe_2.add(labNgayThongKe_2);

		JLabel lblNewLabel_1_6 = new JLabel("Tổng doanh thu trong ngày  : ");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_6.setBounds(456, 20, 206, 20);
		panelKetQuaThongKe_2.add(lblNewLabel_1_6);

		textField_18 = new JTextField();
		textField_18.setText((String) null);
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		textField_18.setBounds(660, 20, 180, 20);
		panelKetQuaThongKe_2.add(textField_18);

		JLabel lblNewLabel_2_6 = new JLabel("VND");
		lblNewLabel_2_6.setForeground(Color.RED);
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_6.setBounds(850, 23, 46, 14);
		panelKetQuaThongKe_2.add(lblNewLabel_2_6);

		JLabel lblNewLabel_1_1_2 = new JLabel("Tổng tiền nhập hàng : ");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(456, 47, 206, 20);
		panelKetQuaThongKe_2.add(lblNewLabel_1_1_2);

		textField_19 = new JTextField();
		textField_19.setText((String) null);
		textField_19.setEditable(false);
		textField_19.setColumns(10);
		textField_19.setBounds(660, 48, 180, 20);
		panelKetQuaThongKe_2.add(textField_19);

		JLabel lblNewLabel_2_1_2 = new JLabel("VND");
		lblNewLabel_2_1_2.setForeground(Color.RED);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_2.setBounds(850, 51, 46, 14);
		panelKetQuaThongKe_2.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_1_2_2 = new JLabel("Tổng lãi trong ngày  : ");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_2.setBounds(456, 178, 206, 18);
		panelKetQuaThongKe_2.add(lblNewLabel_1_2_2);

		textField_20 = new JTextField();
		textField_20.setText((String) null);
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBounds(660, 176, 180, 20);
		panelKetQuaThongKe_2.add(textField_20);

		JLabel lblNewLabel_2_2_2 = new JLabel("VND");
		lblNewLabel_2_2_2.setForeground(Color.RED);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_2.setBounds(850, 179, 46, 14);
		panelKetQuaThongKe_2.add(lblNewLabel_2_2_2);

		JLabel lblNewLabel_1_3_3 = new JLabel("Tổng thuế   : ");
		lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_3.setBounds(456, 140, 206, 20);
		panelKetQuaThongKe_2.add(lblNewLabel_1_3_3);

		textField_21 = new JTextField();
		textField_21.setText((String) null);
		textField_21.setEditable(false);
		textField_21.setColumns(10);
		textField_21.setBounds(660, 140, 180, 20);
		panelKetQuaThongKe_2.add(textField_21);

		JLabel lblNewLabel_2_3_3 = new JLabel("VND");
		lblNewLabel_2_3_3.setForeground(Color.RED);
		lblNewLabel_2_3_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_3.setBounds(850, 143, 46, 14);
		panelKetQuaThongKe_2.add(lblNewLabel_2_3_3);

		textField_22 = new JTextField();
		textField_22.setText((String) null);
		textField_22.setEditable(false);
		textField_22.setColumns(10);
		textField_22.setBounds(660, 109, 180, 20);
		panelKetQuaThongKe_2.add(textField_22);

		JLabel lblNewLabel_1_3_1_2 = new JLabel("Tổng tiền khuyến mãi : ");
		lblNewLabel_1_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1_2.setBounds(456, 109, 206, 20);
		panelKetQuaThongKe_2.add(lblNewLabel_1_3_1_2);

		JLabel lblNewLabel_2_3_1_2 = new JLabel("VND");
		lblNewLabel_2_3_1_2.setForeground(Color.RED);
		lblNewLabel_2_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_1_2.setBounds(850, 112, 46, 14);
		panelKetQuaThongKe_2.add(lblNewLabel_2_3_1_2);

		JLabel lblNewLabel_1_4_3 = new JLabel("Tổng số hóa đơn được lập : ");
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_3.setBounds(22, 145, 206, 20);
		panelKetQuaThongKe_2.add(lblNewLabel_1_4_3);

		textField_23 = new JTextField();
		textField_23.setText("0");
		textField_23.setEditable(false);
		textField_23.setColumns(10);
		textField_23.setBounds(226, 145, 77, 20);
		panelKetQuaThongKe_2.add(textField_23);

		JLabel lblNewLabel_2_4_3 = new JLabel("Hóa đơn");
		lblNewLabel_2_4_3.setForeground(Color.RED);
		lblNewLabel_2_4_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4_3.setBounds(313, 148, 69, 17);
		panelKetQuaThongKe_2.add(lblNewLabel_2_4_3);

		JLabel lblNewLabel_2_4_1_2 = new JLabel("Mặt hàng");
		lblNewLabel_2_4_1_2.setForeground(Color.RED);
		lblNewLabel_2_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4_1_2.setBounds(313, 179, 69, 17);
		panelKetQuaThongKe_2.add(lblNewLabel_2_4_1_2);

		JLabel lblNewLabel_1_4_1_2 = new JLabel("Tổng số lượng mặt hàng bán ra :");
		lblNewLabel_1_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1_2.setBounds(22, 176, 206, 20);
		panelKetQuaThongKe_2.add(lblNewLabel_1_4_1_2);

		textField_24 = new JTextField();
		textField_24.setText("0");
		textField_24.setEditable(false);
		textField_24.setColumns(10);
		textField_24.setBounds(226, 176, 77, 20);
		panelKetQuaThongKe_2.add(textField_24);

		JLabel lblNewLabel_1_1_2_1_2 = new JLabel("Tổng tiền hàng đã bán :");
		lblNewLabel_1_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1_2.setBounds(456, 78, 206, 20);
		panelKetQuaThongKe_2.add(lblNewLabel_1_1_2_1_2);

		textField_25 = new JTextField();
		textField_25.setText((String) null);
		textField_25.setEditable(false);
		textField_25.setColumns(10);
		textField_25.setBounds(660, 79, 180, 20);
		panelKetQuaThongKe_2.add(textField_25);

		JLabel lblNewLabel_2_1_2_1_2 = new JLabel("VND");
		lblNewLabel_2_1_2_1_2.setForeground(Color.RED);
		lblNewLabel_2_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_2_1_2.setBounds(850, 82, 46, 14);
		panelKetQuaThongKe_2.add(lblNewLabel_2_1_2_1_2);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new LineBorder(Color.PINK));
		panel_1_2.setBounds(428, 30, 3, 176);
		panelKetQuaThongKe_2.add(panel_1_2);

		JPanel panelBieuDoThongKeDoanhThuNgay_2 = new JPanel();
		panelBieuDoThongKeDoanhThuNgay_2.setBorder(new TitledBorder(null, "Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA",

				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBieuDoThongKeDoanhThuNgay_2.setBackground(Color.WHITE);
		panelBieuDoThongKeDoanhThuNgay_2.setBounds(407, 243, 796, 347);
		panelTabThongKeTheoNam.add(panelBieuDoThongKeDoanhThuNgay_2);

		JButton btnNewButton_3 = new JButton("xuất excel");
		btnNewButton_3.setBounds(1213, 465, 108, 23);
		panelTabThongKeTheoNam.add(btnNewButton_3);

		JButton btnNewButton_1_2 = new JButton("Tạo báo cáo");
		btnNewButton_1_2.setBounds(1213, 499, 108, 23);
		panelTabThongKeTheoNam.add(btnNewButton_1_2);
		// <Table Thống kê doanh thu Tháng>
		modelTblNhanVienThongKeDoanhThuThang = new DefaultTableModel(cols, 0);

		txtTenBieuDo2 = new JTextPane();
		txtTenBieuDo2.setText("Biểu đồ thể hiện doanh thu bán hàng của tất cả nhân viên trong tháng");
		txtTenBieuDo2.setForeground(Color.RED);
		txtTenBieuDo2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtTenBieuDo2.setBackground(SystemColor.menu);
		txtTenBieuDo2.setBounds(35, 382, 324, 36);
		// <Table Thống kê doanh thu Năm>
		modelTblNhanVienThongKeDoanhThuNam = new DefaultTableModel(cols, 0);
		// <=======================>
		if (cbTatCaNhanVienNgay.isSelected()) {
			lamMoiDuLieuNgay();
			lamMoiThongKeNgay(jdcChonNgayThongKe);
			LoadDataThongKeNgay();

			lamMoiDuLieuThang();
			lamMoiThongKeThang();
			LoadDataThongKeThang();
		} else {
			lamMoiDuLieuNgay();
			lamMoiThongKeNgay(jdcChonNgayThongKe);
			LoadDataThongKeNgayTheoNV();
			lamMoiDuLieuNgay();
			lamMoiThongKeNgay(jdcChonNgayThongKe);
			LoadDataThongKeThangTheoNV();
		}
		xuatThongKeNgayExcel.addActionListener(this);
		btnThongKeThang.addActionListener(this);
		btnXuatDuLieuThongKeThang.addActionListener(this);
		btnLamMoiTimKiemThang.addActionListener(this);
		btnTimKiemNhanVienTKDTNThang.addActionListener(this);
		btnXuatDuLieuThongKeThang.addActionListener(this);
	}

	// <======table==========>
	public void loadDataToTableNhanVienNgay(DefaultTableModel modelTable, ArrayList<NhanVien> danhSachNhanVien) {
		modelTable.setRowCount(0);
		for (NhanVien nv : danhSachNhanVien) {
			modelTable.addRow(new Object[] { nv.getMaNhanVien().trim(), nv.getHoTen().trim() });
		}
	}

	public void loadDataToTableNhanVienThang(DefaultTableModel modelTable, ArrayList<NhanVien> danhSachNhanVien) {
		modelTable.setRowCount(0);
		for (NhanVien nv : danhSachNhanVien) {
			modelTable.addRow(new Object[] { nv.getMaNhanVien().trim(), nv.getHoTen().trim() });
		}
	}

	public void lamMoiTableNhanVienNgay(DefaultTableModel modelTable) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		danhSachNhanVienNgay = dao_ThongKeDoanhThu.layDanhSachNhanVien();
		loadDataToTableNhanVienNgay(modelTable, danhSachNhanVienNgay);
	}

	public void lamMoiTableNhanVienThang(DefaultTableModel modelTable) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		danhSachNhanVienThang = dao_ThongKeDoanhThu.layDanhSachNhanVien();
		loadDataToTableNhanVienThang(modelTable, danhSachNhanVienThang);
	}

	public void lamMoiFormTimKiemNgay() {
		txtTenNhanVienTimKiemTKDTNgay.setText("");
		txtMaNhanVienTimKiemTKDTNgay.setText("");
		txtTenNhanVienTimKiemTKDTNgay.requestFocus();
	}

	public void chonNhanVienNgay(String maNhanVien, String tenNhanVien) {
		txtTenNhanVienTimKiemTKDTNgay.setText(maNhanVien);
		txtMaNhanVienTimKiemTKDTNgay.setText(tenNhanVien);
	}

	public static ArrayList<NhanVien> timKiemNhanVienBangMa(ArrayList<NhanVien> data, String maNhanVien) {
		ArrayList<NhanVien> ketQua = new ArrayList<>();
		for (NhanVien nv : data) {
			if (nv.getMaNhanVien().equals(maNhanVien)) {
				ketQua.add(nv);
			}
		}
		return ketQua;
	}

	public static ArrayList<NhanVien> timKiemNhanVien(ArrayList<NhanVien> data, String keyword) {
		ArrayList<NhanVien> ketQua = new ArrayList<>();
		for (NhanVien nv : data) {
			if (nv.getHoTen().toLowerCase().contains(keyword.toLowerCase())) {
				ketQua.add(nv);
			}
		}
		return ketQua;
	}

	public void tatCaNhanVienNgay(boolean state) {
		if (state) {
			btnTimKiemNhanVienTKDTNgay.setEnabled(false);
			btnLamMoiTimKiemNgay.setEnabled(false);
			txtTenNhanVienTimKiemTKDTNgay.setText("");
			txtMaNhanVienTimKiemTKDTNgay.setText("");
			modelTblNhanVienThongKeDoanhThuNgay.setRowCount(0);
			taiKhoanThongKeNgay = new NhanVien();
		} else {
			btnTimKiemNhanVienTKDTNgay.setEnabled(true);
			btnLamMoiTimKiemNgay.setEnabled(true);
			lamMoiTableNhanVienNgay(modelTblNhanVienThongKeDoanhThuNgay);
		}
	}

	public void tatCaNhanVienThang(boolean state) {
		if (state) {
			btnTimKiemNhanVienTKDTNThang.setEnabled(false);
			btnLamMoiTimKiemThang.setEnabled(false);
			txtTenNhamVienTimKiemThang.setText("");
			txtMaNhanVienTimKiemThang.setText("");
			modelTblNhanVienThongKeDoanhThuThang.setRowCount(0);
			taiKhoanThongKeThang = new NhanVien();
		} else {
			btnTimKiemNhanVienTKDTNThang.setEnabled(true);
			btnLamMoiTimKiemThang.setEnabled(true);
			lamMoiTableNhanVienThang(modelTblNhanVienThongKeDoanhThuThang);
		}
	}

	public void lamMoiDuLieuNgay() {
		Calendar ngayHienTai = Calendar.getInstance();
		jdcChonNgayThongKe.setDate(ngayHienTai.getTime());
		modelThongKeDoanhThuNgay = new ModelThongKeDoanhThuNgay();
		taiKhoanThongKeNgay = new NhanVien();
		listModalThongKeNgay = new ArrayList<>();
		modelThongKeDoanhThuThang = new ModelThongKeDoanhThuThang();
		modelThongKeDoanhThuThang = new ModelThongKeDoanhThuThang();
		modelThongKeDoanhThuNam = new ModelThongKeDoanhThuNam();
		listModelThongKeDoanhThuNam = new ArrayList<>();
		txtThongKeTrenTaiKhoanNgay.setText("");
		txtTenNhanVienDuocThongKeNgay.setText("");
		txtNgayDuocThongKe.setText("");

		txtTongSoHoaDonDuocLapNgay.setText("");
		txtTongSoLuongMatHangBanRaNgay.setText("");
		txtTongDoanhThuTrongNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongDoanhThu()));
		txtTongTienNhapHangNgay.setText("");
		txtTongTienHangDaBanNgay.setText("");
		txtTongTienKhuyenMaiNgay.setText("");
		txtTongThueNgay.setText("");
		txtTongLaiTrongNgay.setText("");
		VeBieuDoThongKeDoanhThuNgay(panelBieuDoThongKeDoanhThuNgay, today);
	}

	private void lamMoiThongKeThang() {
		LocalDate now = LocalDate.now();
		String[] nam = { "2019", "2020", "2021", "2022", "2023", "2024" };
		String[] thang = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		int thangHt = now.getMonthValue();
		int namHt = now.getYear();
		for (String s : thang) {
			if (Integer.parseInt(s) == thangHt) {
				cbxChonThangThongKe.setSelectedItem(s);
				;
			}
		}
		for (String s : nam) {
			if (Integer.parseInt(s) == namHt) {
				cbxChonNamCuaThangThongKe.setSelectedItem(s);
				;
			}
		}
	}

	public void lamMoiDuLieuThang() {
		lamMoiThongKeThang();
		modelThongKeDoanhThuNgay = new ModelThongKeDoanhThuNgay();
		taiKhoanThongKeNgay = new NhanVien();
		listModalThongKeNgay = new ArrayList<>();
		modelThongKeDoanhThuThang = new ModelThongKeDoanhThuThang();
		modelThongKeDoanhThuThang = new ModelThongKeDoanhThuThang();
		modelThongKeDoanhThuNam = new ModelThongKeDoanhThuNam();
		listModelThongKeDoanhThuNam = new ArrayList<>();
		txtTaiKhoanDuocThongKeThang.setText("");
		txtTenNhanVienDuocThongKeThang.setText("");
		txtNgaDuocThongKeThang.setText("");

		txtTongSoHoaDonDuocLapThang.setText("");
		txtTongSoMatHangBanRaThang.setText("");
		txtTongDoanhThuThang.setText("");
		txtTongTienHangNhapThang.setText("");
		txtTongTienHangDaBanThang.setText("");
		txtTongTienKhuyenMaiThang.setText("");
		txtTongThueThang.setText("");
		txtTongLaiTrongNgay.setText("");
		lamMoiTableNhanVienThang(modelTblNhanVienThongKeDoanhThuThang);
		VeBieuDoThongKeDoanhThuThang(panelBieuDoThongKeDoanhThuThang, LocalDate.now().getMonthValue(),
				LocalDate.now().getYear());
	}

	public void VeBieuDoThongKeDoanhThuThangTheoNhanVien(JPanel panelContain, int thang, int namCuaThang,
			NhanVien nhanVien) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		ArrayList<DuLieuBieuDoThongKeDoanhThu> data = dao_ThongKeDoanhThu
				.duLieuBieuDo_DoanhThuCacNgaTrongThangTheoNhanVien(thang, namCuaThang, nhanVien.getMaNhanVien().trim());
		panelContain.removeAll();
		BieuDoThongKePanel bieuDoThongKePanel = new BieuDoThongKePanel(data,
				"Doanh thu các ngày trong tháng " + thang + " năm " + namCuaThang);
		panelContain.setLayout(new BorderLayout());
		panelContain.add(bieuDoThongKePanel, BorderLayout.CENTER);
		panelContain.revalidate(); // Cần revalidate để cập nhật giao diện
		panelContain.repaint(); // Cần repaint để vẽ lại giao diện
	}

	public void VeBieuDoThongKeDoanhThuThang(JPanel panelContain, int thang, int namCuaThang) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		ArrayList<DuLieuBieuDoThongKeDoanhThu> data = dao_ThongKeDoanhThu.duLieuBieuDo_DoanhThuCacNgaTrongThang(thang,
				namCuaThang);
		panelContain.removeAll();
		BieuDoThongKePanel bieuDoThongKePanel = new BieuDoThongKePanel(data,
				"Doanh thu các ngày trong tháng " + thang + " năm " + namCuaThang);
		panelContain.setLayout(new BorderLayout());
		panelContain.add(bieuDoThongKePanel, BorderLayout.CENTER);
		panelContain.revalidate(); // Cần revalidate để cập nhật giao diện
		panelContain.repaint(); // Cần repaint để vẽ lại giao diện
	}

	public String ChuyenThanhTien(float money) {
		long roundedMoney = Math.round(money);
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String formattedMoney = decimalFormat.format(roundedMoney);
		return formattedMoney;
	}

	// <========thongKeNgay==========>
	public void LoadDataThongKeNgay() {
		LocalDate ngayChonThongKe = layNgayDuocChon(jdcChonNgayThongKe);
		LayDuLieuThongKeNgay(modelThongKeDoanhThuNgay, ngayChonThongKe);
		loadDuLieuThongKeNgay(modelThongKeDoanhThuNgay, ngayChonThongKe);
		VeBieuDoThongKeDoanhThuNgay(panelBieuDoThongKeDoanhThuNgay, ngayChonThongKe);
	}

	public void LoadDataThongKeThang() {
		int thangDuocChon = Integer.parseInt((String) cbxChonThangThongKe.getSelectedItem());
		int namCuaThang = Integer.parseInt((String) cbxChonNamCuaThangThongKe.getSelectedItem());
		LayDuLieuThongKeThang(modelThongKeDoanhThuThang, thangDuocChon, namCuaThang);
		loadDuLieuThongKeThang(modelThongKeDoanhThuThang, thangDuocChon, namCuaThang);
		VeBieuDoThongKeDoanhThuThang(panelBieuDoThongKeDoanhThuThang, thangDuocChon, namCuaThang);
	}

	public void loadDuLieuThongKeThangTheoNhanVien(ModelThongKeDoanhThuThang model, int thang, int namCuaThang,
			NhanVien taiKhoan) {

		model.setThangThongKe(thang);
		model.setNamCuaThangThongKe(namCuaThang);
		model.setMaNhanVien(taiKhoan.getMaNhanVien().trim());

		txtTaiKhoanDuocThongKeThang.setText(taiKhoan.getMaNhanVien().trim());
		txtTenNhanVienDuocThongKeThang.setText(taiKhoan.getHoTen().trim());
		txtNgaDuocThongKeThang.setText("Tháng " + thang + " năm " + namCuaThang);
		txtTongSoHoaDonDuocLapThang.setText(String.valueOf(model.getTongHdDuocLap()));
		txtTongSoMatHangBanRaThang.setText(String.valueOf(model.getTongMhBanRa()));
		txtTongDoanhThuThang.setText(ChuyenThanhTien(model.getTongDoanhThu()));
		txtTongTienHangNhapThang.setText(ChuyenThanhTien(model.getTongTienNhapHang()));
		txtTongTienHangDaBanThang.setText(ChuyenThanhTien(model.getTongTienHangDaBan()));
		txtTongTienKhuyenMaiThang.setText(ChuyenThanhTien(model.getTongTienKhuyenMai()));
		txtTongThueThang.setText(ChuyenThanhTien(model.getTongThue()));
		txtTongLaiThang.setText(ChuyenThanhTien(model.getTongLai()));
	}

	public void loadDuLieuThongKeThang(ModelThongKeDoanhThuThang model, int thang, int namCuaThang) {

		model.setThangThongKe(thang);
		model.setNamCuaThangThongKe(namCuaThang);
		model.setMaNhanVien("Tất cả");

		txtTaiKhoanDuocThongKeThang.setText("tất cả");
		txtTenNhanVienDuocThongKeThang.setText("tất cả nhân viên");
		txtNgaDuocThongKeThang.setText("Tháng " + thang + " năm " + namCuaThang);
		txtTongSoHoaDonDuocLapThang.setText(String.valueOf(model.getTongHdDuocLap()));
		txtTongSoMatHangBanRaThang.setText(String.valueOf(model.getTongMhBanRa()));
		txtTongDoanhThuThang.setText(ChuyenThanhTien(model.getTongDoanhThu()));
		txtTongTienHangNhapThang.setText(ChuyenThanhTien(model.getTongTienNhapHang()));
		txtTongTienHangDaBanThang.setText(ChuyenThanhTien(model.getTongTienHangDaBan()));
		txtTongTienKhuyenMaiThang.setText(ChuyenThanhTien(model.getTongTienKhuyenMai()));
		txtTongThueThang.setText(ChuyenThanhTien(model.getTongThue()));
		txtTongLaiThang.setText(ChuyenThanhTien(model.getTongLai()));
	}

	private void LayDuLieuThongKeThangTheoNhanVien(ModelThongKeDoanhThuThang model, NhanVien taiKhoan, int thang,
			int namCuaThang) {
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

		tongHdDuocLap = dao_ThongKeDoanhThu.TongHoaDonDuocNhanVienLapTrongThang(model.getThangThongKe(),
				model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongMhBanRa = dao_ThongKeDoanhThu.TongSoLuongMatHangNhanVienBanRaTrongThang(model.getThangThongKe(),
				model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongThangCuaNhanVien(model.getThangThongKe(),
				model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongThangNhanVienBan(model.getThangThongKe(),
				model.getNamCuaThangThongKe(), model.getMaNhanVien());
		tongTienHangDaBan = tongTienNhapHang + tongTienNhapHang * 0.7f;
		tongTienKhuyenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongThangTheoNhanVien(model.getThangThongKe(),
				model.getNamCuaThangThongKe(), model.getMaNhanVien());
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

	private void LayDuLieuThongKeThang(ModelThongKeDoanhThuThang model, int thang, int namCuaThang) {
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
		model.setMaNhanVien("Tất cả");
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();

		tongHdDuocLap = dao_ThongKeDoanhThu.TongHoaDonTrongThang(model.getThangThongKe(),
				model.getNamCuaThangThongKe());
		tongMhBanRa = dao_ThongKeDoanhThu.TongSoLuongMatHangBanRaTrongThang(model.getThangThongKe(),
				model.getNamCuaThangThongKe());
		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongThang(model.getThangThongKe(),
				model.getNamCuaThangThongKe());
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongThang(model.getThangThongKe(),
				model.getNamCuaThangThongKe());
		tongTienHangDaBan = tongTienNhapHang + tongTienNhapHang * 0.7f;
		tongTienKhuyenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongThang(model.getThangThongKe(),
				model.getNamCuaThangThongKe());
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

	public void loadDuLieuThongKeNgay(ModelThongKeDoanhThuNgay modelThongKeDoanhThuNgay, LocalDate ngayChonThongKe) {
		modelThongKeDoanhThuNgay.setDate(ngayChonThongKe);
		modelThongKeDoanhThuNgay.setMaNhanVien("Tất cả");

		txtThongKeTrenTaiKhoanNgay.setText("Tất cả");
		txtTenNhanVienDuocThongKeNgay.setText("Tất cả nhân viên");
		txtNgayDuocThongKe.setText(ngayChonThongKe.toString());

		txtTongSoHoaDonDuocLapNgay.setText(String.valueOf(modelThongKeDoanhThuNgay.getTongHdDuocLap()));
		txtTongSoLuongMatHangBanRaNgay.setText(String.valueOf(modelThongKeDoanhThuNgay.getTongMhBanRa()));
		txtTongDoanhThuTrongNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongDoanhThu()));
		txtTongTienNhapHangNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongTienNhapHang()));
		txtTongTienHangDaBanNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongTienHangDaBan()));
		txtTongTienKhuyenMaiNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongTienKhuyenMai()));
		txtTongThueNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongThue()));
		txtTongLaiTrongNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongLai()));
	}

	private void LayDuLieuThongKeNgay(ModelThongKeDoanhThuNgay model, LocalDate today) {
		int tongHdDuocLap;
		int tongMhBanRa;
		float tongDoanhThu;
		float tongTienNhapHang;
		float tongTienHangDaBan;
		float tongTienKhuyenMai;
		float tongThue;
		float tongLai;
		model.setDate(today);
		model.setMaNhanVien("Tất cả");
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();

		tongHdDuocLap = dao_ThongKeDoanhThu.TongHoaDonDocNhanVienLapTrongNgay(model.getDate(), model.getMaNhanVien());
		tongMhBanRa = dao_ThongKeDoanhThu.TongSoLuongMatHangBanRaTrongNgay(model.getDate());
		tongDoanhThu = dao_ThongKeDoanhThu.TongDoanhThuTrongNgay(model.getDate());
		tongTienNhapHang = dao_ThongKeDoanhThu.TongVonNhapHangTrongNgay(model.getDate());
		tongTienHangDaBan = tongTienNhapHang + tongTienNhapHang * 0.7f;
		tongTienKhuyenMai = dao_ThongKeDoanhThu.TongTienGiamGiaTrongNgay(model.getDate());
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

	public void VeBieuDoThongKeDoanhThuNgay(JPanel panelContain, LocalDate date) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		LocalDate today = LocalDate.now();
		DuLieuBieuDoThongKeDoanhThu doanhThuNgayHienTai = new DuLieuBieuDoThongKeDoanhThu("Hôm nay ",
				dao_ThongKeDoanhThu.TongDoanhThuTrongNgay(today));

		ArrayList<DuLieuBieuDoThongKeDoanhThu> data = dao_ThongKeDoanhThu
				.duLieuBieuDo_Top5NgayDoanhThuCaoNhatTrongThang(date.getMonthValue(), date.getYear());
		data.add(0, doanhThuNgayHienTai);
		panelContain.removeAll();
		BieuDoThongKePanel bieuDoThongKePanel = new BieuDoThongKePanel(data,
				"Doanh thu hôm nay và 5 ngày có doanh thu cao nhất tháng");
		panelContain.setLayout(new BorderLayout());
		panelContain.add(bieuDoThongKePanel, BorderLayout.CENTER);
		panelContain.revalidate(); // Cần revalidate để cập nhật giao diện
		panelContain.repaint(); // Cần repaint để vẽ lại giao diện
	}

	private LocalDate layNgayDuocChon(JDateChooser chooser) {
		Date date = chooser.getDate();
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private void lamMoiThongKeNgay(JDateChooser chooser) {
		Calendar ngayHienTai = Calendar.getInstance();
		chooser.setDate(ngayHienTai.getTime());
	}

	// <>
	public void LoadDataThongKeNgayTheoNV() {
		LocalDate ngayChonThongKe = layNgayDuocChon(jdcChonNgayThongKe);
		LayDuLieuThongKeNgayTheoNV(modelThongKeDoanhThuNgay, taiKhoanThongKeNgay, ngayChonThongKe);
		loadDuLieuThongKeNgayTheoNV(modelThongKeDoanhThuNgay, ngayChonThongKe, taiKhoanThongKeNgay);
		VeBieuDoThongKeDoanhThuNgayTheoNhanVien(panelBieuDoThongKeDoanhThuNgay, ngayChonThongKe, taiKhoanThongKeNgay);
	}

	public void LoadDataThongKeThangTheoNV() {
		int thangDuocChon = Integer.parseInt((String) cbxChonThangThongKe.getSelectedItem());
		int namCuaThang = Integer.parseInt((String) cbxChonNamCuaThangThongKe.getSelectedItem());
		LayDuLieuThongKeThangTheoNhanVien(modelThongKeDoanhThuThang, taiKhoanThongKeThang, thangDuocChon, namCuaThang);
		loadDuLieuThongKeThangTheoNhanVien(modelThongKeDoanhThuThang, thangDuocChon, namCuaThang, taiKhoanThongKeNgay);
		VeBieuDoThongKeDoanhThuThangTheoNhanVien(panelBieuDoThongKeDoanhThuNgay, thangDuocChon, namCuaThang,
				taiKhoanThongKeNgay);
	}

	public void loadDuLieuThongKeNgayTheoNV(ModelThongKeDoanhThuNgay modelThongKeDoanhThuNgay,
			LocalDate ngayChonThongKe, NhanVien taiKhoan) {
		modelThongKeDoanhThuNgay.setDate(ngayChonThongKe);
		modelThongKeDoanhThuNgay.setMaNhanVien(taiKhoan.getMaNhanVien().trim());

		txtThongKeTrenTaiKhoanNgay.setText(taiKhoan.getMaNhanVien().trim());
		txtTenNhanVienDuocThongKeNgay.setText(taiKhoan.getHoTen().trim());
		txtNgayDuocThongKe.setText(ngayChonThongKe.toString());

		txtTongSoHoaDonDuocLapNgay.setText(String.valueOf(modelThongKeDoanhThuNgay.getTongHdDuocLap()));
		txtTongSoLuongMatHangBanRaNgay.setText(String.valueOf(modelThongKeDoanhThuNgay.getTongMhBanRa()));
		txtTongDoanhThuTrongNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongDoanhThu()));
		txtTongTienNhapHangNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongTienNhapHang()));
		txtTongTienHangDaBanNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongTienHangDaBan()));
		txtTongTienKhuyenMaiNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongTienKhuyenMai()));
		txtTongThueNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongThue()));
		txtTongLaiTrongNgay.setText(ChuyenThanhTien(modelThongKeDoanhThuNgay.getTongLai()));
	}

	private void LayDuLieuThongKeNgayTheoNV(ModelThongKeDoanhThuNgay model, NhanVien taiKhoan, LocalDate today) {
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

	public void VeBieuDoThongKeDoanhThuNgayTheoNhanVien(JPanel panelContain, LocalDate date, NhanVien nhanVien) {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		LocalDate today = LocalDate.now();
		DuLieuBieuDoThongKeDoanhThu doanhThuNgayHienTai = new DuLieuBieuDoThongKeDoanhThu("Hôm nay ",
				dao_ThongKeDoanhThu.TongDoanhThuTrongNgayCuaNhanVien(today, nhanVien.getMaNhanVien().trim()));

		// ArrayList<DuLieuBieuDoThongKeDoanhThu> data =
		// dao_ThongKeDoanhThu.Top5NgayDoanhThuCaoNhatTrongThang(10, 2022);
		ArrayList<DuLieuBieuDoThongKeDoanhThu> data = dao_ThongKeDoanhThu
				.duLieuBieuDo_Top5NgayDoanhThuCaoNhatTrongThangCuaNhanVien(date.getMonthValue(), date.getYear(),
						nhanVien.getMaNhanVien().trim());
		data.add(0, doanhThuNgayHienTai);
		panelContain.removeAll();
//		for(DuLieuBieuDoThongKeDoanhThu dl : data) {
//			System.out.println(dl.toString());
//		}
		BieuDoThongKePanel bieuDoThongKePanel = new BieuDoThongKePanel(data,
				"Doanh thu hôm nay và 5 ngày có doanh thu cao nhất tháng");
		panelContain.setLayout(new BorderLayout());
		panelContain.add(bieuDoThongKePanel, BorderLayout.CENTER);
		panelContain.revalidate(); // Cần revalidate để cập nhật giao diện
		panelContain.repaint(); // Cần repaint để vẽ lại giao diện
	}

	public void timKiemNhanVienNgay() {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		ArrayList<NhanVien> danhSachNhanVien = dao_ThongKeDoanhThu.layDanhSachNhanVien();
		// ArrayList<NhanVien> danhSachDaLoc = new ArrayList<>();
		String maNvTimKiem = txtMaNhanVienTimKiemTKDTNgay.getText().trim();
		String tenNhanVienTimKiem = txtTenNhanVienTimKiemTKDTNgay.getText().trim();
		if (maNvTimKiem != "" && tenNhanVienTimKiem == "") {
			danhSachNhanVien = timKiemNhanVien(danhSachNhanVien, maNvTimKiem);
		} else if (maNvTimKiem == "" && tenNhanVienTimKiem != "") {
			danhSachNhanVien = timKiemNhanVien(danhSachNhanVien, tenNhanVienTimKiem);
		} else {
			danhSachNhanVien = timKiemNhanVien(danhSachNhanVien, tenNhanVienTimKiem);
			danhSachNhanVien = timKiemNhanVien(danhSachNhanVien, maNvTimKiem);
		}
		loadDataToTableNhanVienNgay(modelTblNhanVienThongKeDoanhThuNgay, danhSachNhanVien);
	}
	public void timKiemNhanVienThang() {
		Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
		ArrayList<NhanVien> danhSachNhanVien = dao_ThongKeDoanhThu.layDanhSachNhanVien();
		// ArrayList<NhanVien> danhSachDaLoc = new ArrayList<>();
		String maNvTimKiem = txtMaNhanVienTimKiemThang.getText().trim();
		String tenNhanVienTimKiem = txtTenNhamVienTimKiemThang.getText().trim();
		if (maNvTimKiem != "" && tenNhanVienTimKiem == "") {
			danhSachNhanVien = timKiemNhanVien(danhSachNhanVien, maNvTimKiem);
		} else if (maNvTimKiem == "" && tenNhanVienTimKiem != "") {
			danhSachNhanVien = timKiemNhanVien(danhSachNhanVien, tenNhanVienTimKiem);
		} else {
			danhSachNhanVien = timKiemNhanVien(danhSachNhanVien, tenNhanVienTimKiem);
			danhSachNhanVien = timKiemNhanVien(danhSachNhanVien, maNvTimKiem);
		}
		loadDataToTableNhanVienThang(modelTblNhanVienThongKeDoanhThuThang, danhSachNhanVien);
	}

	// <>
	public void chonNhanVienThang(String maNhanVien, String tenNhanVien) {
		txtTenNhamVienTimKiemThang.setText(maNhanVien);
		txtMaNhanVienTimKiemThang.setText(tenNhanVien);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (cbTatCaNhanVienNgay.isSelected()) {
			if (o.equals(btnThongKeNgay)) {
				LoadDataThongKeNgay();
			} else if (o.equals(xuatThongKeNgayExcel)) {
				ThongKeDoanhThuServices thongKeDoanhThuServices = new ThongKeDoanhThuServices();
				boolean flag = thongKeDoanhThuServices
						.xuatDuLieuThongKeDoanhThuNgayTheoNvExcel(modelThongKeDoanhThuNgay);
				if (flag)
					JOptionPane.showMessageDialog(this, "Xuất dữ liệu thành công ");
				else
					JOptionPane.showMessageDialog(this, "Đã hủy quá trình xuất dữ liệu ");
			}
		} else if(!cbTatCaNhanVienNgay.isSelected()) {
			if (o.equals(btnThongKeNgay)) {
				if (taiKhoanThongKeNgay == null || taiKhoanThongKeNgay.getMaNhanVien() == null) {
					JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên thống kê");
				} else {
					LoadDataThongKeNgayTheoNV();
				}
			} else if (o.equals(btnTimKiemNhanVienTKDTNgay)) {
				timKiemNhanVienNgay();
			} else if (o.equals(btnLamMoiTimKiemNgay)) {
				lamMoiFormTimKiemNgay();
				lamMoiTableNhanVienNgay(modelTblNhanVienThongKeDoanhThuNgay);
			} else if (o.equals(xuatThongKeNgayExcel)) {
				ThongKeDoanhThuServices thongKeDoanhThuServices = new ThongKeDoanhThuServices();
				boolean flag = thongKeDoanhThuServices
						.xuatDuLieuThongKeDoanhThuNgayTheoNvExcel(modelThongKeDoanhThuNgay);
				if (flag)
					JOptionPane.showMessageDialog(this, "Xuất dữ liệu thành công ");
				else
					JOptionPane.showMessageDialog(this, "Đã hủy quá trình xuất dữ liệu ");
			}
		} 
		if(cbTatCaNhanVienThang.isSelected()) {
			if (o.equals(btnThongKeThang)) {
				LoadDataThongKeThang();
			} else if (o.equals(btnXuatDuLieuThongKeThang)) {
				ThongKeDoanhThuServices thongKeDoanhThuServices = new ThongKeDoanhThuServices();
				ArrayList<ModelThongKeDoanhThuNgay> data = thongKeDoanhThuServices.thongKeCacNgayTrongThang(Integer.parseInt((String)cbxChonThangThongKe.getSelectedItem()), Integer.parseInt((String)cbxChonNamCuaThangThongKe.getSelectedItem()));
				boolean flag = thongKeDoanhThuServices
						.xuatDuLieuThongKeDoanhThuThangTheoNvExcel(data);
				if (flag)
					JOptionPane.showMessageDialog(this, "Xuất dữ liệu thành công ");
				else
					JOptionPane.showMessageDialog(this, "Đã hủy quá trình xuất dữ liệu ");
			}
		}else if(!cbTatCaNhanVienThang.isSelected()) {
			if (o.equals(btnThongKeThang)) {
				LoadDataThongKeThangTheoNV();
			} else if (o.equals(btnXuatDuLieuThongKeThang)) {
				ThongKeDoanhThuServices thongKeDoanhThuServices = new ThongKeDoanhThuServices();
				ArrayList<ModelThongKeDoanhThuNgay> data = thongKeDoanhThuServices.thongKeCacNgayTrongThangTheoNv(Integer.parseInt((String)cbxChonThangThongKe.getSelectedItem()), Integer.parseInt((String)cbxChonNamCuaThangThongKe.getSelectedItem()),taiKhoanThongKeThang);
				boolean flag = thongKeDoanhThuServices
						.xuatDuLieuThongKeDoanhThuThangTheoNvExcel(data);
				if (flag)
					JOptionPane.showMessageDialog(this, "Xuất dữ liệu thành công ");
				else
					JOptionPane.showMessageDialog(this, "Đã hủy quá trình xuất dữ liệu ");
			}
		}
	}
}
