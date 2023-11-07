package gui.admin;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import constance.SetBountJPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class TrangThongKeNVQuanLyJPanel extends JPanel implements ActionListener{
	private JTextField txtTenNhanVienTimKiemNgay;
	private JTextField txtMaNhanVienTimKiem;
	private JTable tblDsNhanVienNgay;
	private JTextField txtSlMhDaBanTrongNgay;
	private JTextField txtTongHoaDonLapNgay;
	private JTextField txtTongDoanhThuNgay;
	private JTextField txtTongLaiNgay;
	private JTextField txtTongThueNgay;
	private JTextField txtTongTienHangNgay;
	private JTable tblTopMatHangNgay;
	private JTextField txtThongKeTrenTaiKhoanNgay;
	private JTextField txtThongKeTheoTieuChiNgay;
	private JTextField txtNgayDuocThongKe;
	private JTextField txtThongKeThangNam;
	private JTextField txtTenNhanVienTimKiemThang;
	private JTextField txtMaNhanVienTimKiemThang;
	private JTextField txtSoLuongMatHangDaBanThang;
	private JTextField txtTongHoaDonLapThang;
	private JTextField txtDoanhThuTrongNgayThang;
	private JTextField txtTongTienLaiThang;
	private JTextField txtTongThueThang;
	private JTextField txtTongTienHangThang;
	private JTextField txtThongkeTrenTaiKhoanThang;
	private JTextField txtThongKeTheoTieuChiThang;
	private JTextField txtThangDuocThongKe;
	private JTextField txtSoLuongMatHangDaBanNam;
	private JTextField txtTongHoaDonDuocLapNam;
	private JTextField txtTongDoanhThuTrongNam;
	private JTextField txtTongLaiTrongNam;
	private JTextField txtTongThueTrongNam;
	private JTextField txtTongTienHangTrongNam;
	private JTextField txtThongKeTrenTaiKhoanNam;
	private JTextField xtxThongKeTheoTieuChiNam;
	private JTextField txtNamDuocTK;
	private JTextField txtNamThongKeNam;
	private JTextField txtTenNhanVienTimKiemNam;
	private JTextField txtMaNhanVienTimKiemNam;
	private JTextField txtNamDuocThongKe;
	private JPanel currentContent;
	private Container contentPane;
	/**
	 * Create the panel.
	 */
	public TrangThongKeNVQuanLyJPanel() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		JPanel panelCN_CNThongKe = new JPanel();
		panelCN_CNThongKe.setBounds(0, 11, 1350, 690);
		add(panelCN_CNThongKe);
		panelCN_CNThongKe.setLayout(null);
		
//		//<=====================================>

		
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ BÁN HÀNG");
		lblNewLabel.setBounds(583, 0, 196, 25);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelCN_CNThongKe.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 1350, 679);
		panelCN_CNThongKe.add(tabbedPane);
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
		panelDuLieuThongKe.setBounds(10, 11, 387, 629);
		panelTabThongKeTheoNgay.add(panelDuLieuThongKe);
		panelDuLieuThongKe.setLayout(null);
		
		JLabel lblThongKeNgay = new JLabel("Thống kê ngày :");
		lblThongKeNgay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay.setBounds(20, 21, 108, 23);
		panelDuLieuThongKe.add(lblThongKeNgay);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1ECDn nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(0, 129, 382, 502);
		panelDuLieuThongKe.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panelBoLocTimKiem = new JPanel();
		panelBoLocTimKiem.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBoLocTimKiem.setBounds(10, 25, 362, 123);
		panel_3.add(panelBoLocTimKiem);
		panelBoLocTimKiem.setLayout(null);
		
		JLabel lblTenNVTimKiem = new JLabel("Tên nhân viên :");
		lblTenNVTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNVTimKiem.setBounds(10, 21, 108, 23);
		panelBoLocTimKiem.add(lblTenNVTimKiem);
		
		txtTenNhanVienTimKiemNgay = new JTextField();
		txtTenNhanVienTimKiemNgay.setColumns(10);
		txtTenNhanVienTimKiemNgay.setBounds(146, 22, 191, 22);
		panelBoLocTimKiem.add(txtTenNhanVienTimKiemNgay);
		
		txtMaNhanVienTimKiem = new JTextField();
		txtMaNhanVienTimKiem.setColumns(10);
		txtMaNhanVienTimKiem.setBounds(146, 54, 191, 22);
		panelBoLocTimKiem.add(txtMaNhanVienTimKiem);
		
		JLabel lblNVMaNhanVienTimKiem = new JLabel("Mã nhân viên");
		lblNVMaNhanVienTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem.setBounds(10, 53, 108, 23);
		panelBoLocTimKiem.add(lblNVMaNhanVienTimKiem);
		
		JButton btnTimKiemNgay = new JButton("Tìm kiếm");
		btnTimKiemNgay.setBounds(10, 89, 89, 23);
		panelBoLocTimKiem.add(btnTimKiemNgay);
		
		JPanel panelBangNhanVienNgay = new JPanel();
		panelBangNhanVienNgay.setBorder(new TitledBorder(null, "Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelBangNhanVienNgay.setBounds(10, 148, 362, 310);
		panel_3.add(panelBangNhanVienNgay);
		panelBangNhanVienNgay.setLayout(new BorderLayout(0, 0));
		
		tblDsNhanVienNgay = new JTable();
		panelBangNhanVienNgay.add(tblDsNhanVienNgay, BorderLayout.CENTER);
		
		JButton btnChonNhanVien = new JButton("Chọn");
		btnChonNhanVien.setBounds(139, 468, 89, 23);
		panel_3.add(btnChonNhanVien);
		
		JPanel panelKetQuaThongKe = new JPanel();
		panelKetQuaThongKe.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "K\u1EBFt qu\u1EA3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelKetQuaThongKe.setBounds(407, 11, 523, 629);
		panelTabThongKeTheoNgay.add(panelKetQuaThongKe);
		panelKetQuaThongKe.setLayout(null);
		
		JLabel lblSlMhBanTrongNgay = new JLabel("Số lượng mặt hàng đã bán :");
		lblSlMhBanTrongNgay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSlMhBanTrongNgay.setBounds(10, 148, 166, 23);
		panelKetQuaThongKe.add(lblSlMhBanTrongNgay);
		
		txtSlMhDaBanTrongNgay = new JTextField();
		txtSlMhDaBanTrongNgay.setColumns(10);
		txtSlMhDaBanTrongNgay.setBounds(174, 149, 78, 22);
		panelKetQuaThongKe.add(txtSlMhDaBanTrongNgay);
		
		JLabel lblTongHdLapTrongNgay = new JLabel("Tổng hóa đơn được lập :");
		lblTongHdLapTrongNgay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTongHdLapTrongNgay.setBounds(292, 148, 147, 23);
		panelKetQuaThongKe.add(lblTongHdLapTrongNgay);
		
		txtTongHoaDonLapNgay = new JTextField();
		txtTongHoaDonLapNgay.setColumns(10);
		txtTongHoaDonLapNgay.setBounds(438, 149, 51, 22);
		panelKetQuaThongKe.add(txtTongHoaDonLapNgay);
		
		JLabel lblTongDoanhThuNgay = new JLabel("Doanh thu trong ngày:");
		lblTongDoanhThuNgay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTongDoanhThuNgay.setBounds(10, 181, 147, 23);
		panelKetQuaThongKe.add(lblTongDoanhThuNgay);
		
		txtTongDoanhThuNgay = new JTextField();
		txtTongDoanhThuNgay.setColumns(10);
		txtTongDoanhThuNgay.setBounds(138, 182, 114, 22);
		panelKetQuaThongKe.add(txtTongDoanhThuNgay);
		
		JLabel lblCnd = new JLabel("VND");
		lblCnd.setBounds(255, 186, 31, 14);
		panelKetQuaThongKe.add(lblCnd);
		
		txtTongLaiNgay = new JTextField();
		txtTongLaiNgay.setColumns(10);
		txtTongLaiNgay.setBounds(366, 213, 123, 22);
		panelKetQuaThongKe.add(txtTongLaiNgay);
		
		JLabel lblTienLai = new JLabel("Tổng lãi  :");
		lblTienLai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTienLai.setBounds(292, 212, 64, 23);
		panelKetQuaThongKe.add(lblTienLai);
		
		JLabel lblCnd_1 = new JLabel("VND");
		lblCnd_1.setBounds(493, 217, 30, 14);
		panelKetQuaThongKe.add(lblCnd_1);
		
		JLabel lblTongThue = new JLabel("Tổng thuế  :");
		lblTongThue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTongThue.setBounds(292, 182, 79, 23);
		panelKetQuaThongKe.add(lblTongThue);
		
		txtTongThueNgay = new JTextField();
		txtTongThueNgay.setColumns(10);
		txtTongThueNgay.setBounds(366, 182, 123, 22);
		panelKetQuaThongKe.add(txtTongThueNgay);
		
		JLabel lblCnd_1_1 = new JLabel("VND");
		lblCnd_1_1.setBounds(493, 187, 30, 14);
		panelKetQuaThongKe.add(lblCnd_1_1);
		
		JLabel lblMatHang = new JLabel("MH");
		lblMatHang.setBounds(262, 153, 20, 14);
		panelKetQuaThongKe.add(lblMatHang);
		
		JLabel lblHD = new JLabel("HĐ");
		lblHD.setBounds(493, 153, 20, 14);
		panelKetQuaThongKe.add(lblHD);
		
		JLabel lblTongTienHang = new JLabel("Tiền hàng : ");
		lblTongTienHang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTongTienHang.setBounds(10, 215, 96, 23);
		panelKetQuaThongKe.add(lblTongTienHang);
		
		txtTongTienHangNgay = new JTextField();
		txtTongTienHangNgay.setColumns(10);
		txtTongTienHangNgay.setBounds(138, 213, 114, 22);
		panelKetQuaThongKe.add(txtTongTienHangNgay);
		
		JLabel lblCnd_1_2 = new JLabel("VND");
		lblCnd_1_2.setBounds(255, 217, 31, 14);
		panelKetQuaThongKe.add(lblCnd_1_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.PINK));
		panel.setBounds(285, 148, 1, 86);
		panelKetQuaThongKe.add(panel);
		
		JPanel panelTblTopMatHangNgay = new JPanel();
		panelTblTopMatHangNgay.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Top 10 m\u1EB7t h\u00E0ng b\u00E1n ch\u1EA1y nh\u1EA5t", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTblTopMatHangNgay.setBounds(10, 281, 503, 304);
		panelKetQuaThongKe.add(panelTblTopMatHangNgay);
		panelTblTopMatHangNgay.setLayout(new BorderLayout(0, 0));
		
		tblTopMatHangNgay = new JTable();
		panelTblTopMatHangNgay.add(tblTopMatHangNgay, BorderLayout.CENTER);
		
		JLabel lblTKTrenTaiKhoan = new JLabel("Thống kê trên tài khoản : ");
		lblTKTrenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTKTrenTaiKhoan.setBounds(10, 27, 166, 23);
		panelKetQuaThongKe.add(lblTKTrenTaiKhoan);
		
		txtThongKeTrenTaiKhoanNgay = new JTextField();
		txtThongKeTrenTaiKhoanNgay.setColumns(10);
		txtThongKeTrenTaiKhoanNgay.setBounds(174, 28, 182, 22);
		panelKetQuaThongKe.add(txtThongKeTrenTaiKhoanNgay);
		
		JLabel lblThongKeTheoTieuChi = new JLabel("Thống kê theo tiêu chí : ");
		lblThongKeTheoTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi.setBounds(10, 61, 166, 23);
		panelKetQuaThongKe.add(lblThongKeTheoTieuChi);
		
		txtThongKeTheoTieuChiNgay = new JTextField();
		txtThongKeTheoTieuChiNgay.setColumns(10);
		txtThongKeTheoTieuChiNgay.setBounds(174, 62, 182, 22);
		panelKetQuaThongKe.add(txtThongKeTheoTieuChiNgay);
		
		txtNgayDuocThongKe = new JTextField();
		txtNgayDuocThongKe.setColumns(10);
		txtNgayDuocThongKe.setBounds(174, 93, 182, 22);
		panelKetQuaThongKe.add(txtNgayDuocThongKe);
		
		JLabel labNgayThongKe = new JLabel("Ngày được thống kê  : ");
		labNgayThongKe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labNgayThongKe.setBounds(10, 92, 166, 23);
		panelKetQuaThongKe.add(labNgayThongKe);
		
		JPanel panelBieuDoThongKeNgay = new JPanel();
		panelBieuDoThongKeNgay.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBieuDoThongKeNgay.setBounds(940, 11, 395, 570);
		panelTabThongKeTheoNgay.add(panelBieuDoThongKeNgay);
		
		JButton btnTaoBaoCaoTkBanHang = new JButton("Tạo báo cáo");
		btnTaoBaoCaoTkBanHang.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTaoBaoCaoTkBanHang.setBounds(1179, 592, 136, 30);
		panelTabThongKeTheoNgay.add(btnTaoBaoCaoTkBanHang);
		
		JButton btnXuatDuLieuTkBanHang = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuTkBanHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXuatDuLieuTkBanHang.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuTkBanHang.setBounds(961, 592, 174, 30);
		panelTabThongKeTheoNgay.add(btnXuatDuLieuTkBanHang);
		
		JPanel panelTabThongKeTheoThang = new JPanel();
		panelTabThongKeTheoThang.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo tháng", null, panelTabThongKeTheoThang, null);
		panelTabThongKeTheoThang.setLayout(null);
		
		JPanel panelDuLieuThongKeThang = new JPanel();
		panelDuLieuThongKeThang.setLayout(null);
		panelDuLieuThongKeThang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDuLieuThongKeThang.setBounds(10, 11, 387, 611);
		panelTabThongKeTheoThang.add(panelDuLieuThongKeThang);
		
		JLabel lblThongKeNgay_1 = new JLabel("Thống  kê tháng :");
		lblThongKeNgay_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay_1.setBounds(20, 21, 108, 23);
		panelDuLieuThongKeThang.add(lblThongKeNgay_1);
		
		txtThongKeThangNam = new JTextField();
		txtThongKeThangNam.setColumns(10);
		txtThongKeThangNam.setBounds(285, 22, 65, 22);
		panelDuLieuThongKeThang.add(txtThongKeThangNam);
		
		JLabel lblTieuChiThongKe_1 = new JLabel("Tiêu chí thống kê :");
		lblTieuChiThongKe_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTieuChiThongKe_1.setBounds(20, 55, 108, 23);
		panelDuLieuThongKeThang.add(lblTieuChiThongKe_1);
		
		JComboBox cbxChiTieuThongKeThang = new JComboBox();
		cbxChiTieuThongKeThang.setModel(new DefaultComboBoxModel(new String[] {"Top 10 mặt hàng bán chạy", "Top 10 mặt hàng bán chậm"}));
		cbxChiTieuThongKeThang.setBounds(190, 54, 160, 22);
		panelDuLieuThongKeThang.add(cbxChiTieuThongKeThang);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1ECDn nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_1.setBounds(0, 129, 382, 492);
		panelDuLieuThongKeThang.add(panel_3_1);
		
		JCheckBox cbTatCaNhanVienThang = new JCheckBox("Tất cả nhân viên");
		cbTatCaNhanVienThang.setBounds(207, 18, 145, 23);
		panel_3_1.add(cbTatCaNhanVienThang);
		
		JLabel lblTimNVCanThongKe_1 = new JLabel("Tìm nhân viên cần thống kê :");
		lblTimNVCanThongKe_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimNVCanThongKe_1.setBounds(10, 21, 175, 14);
		panel_3_1.add(lblTimNVCanThongKe_1);
		
		JPanel panelBoLocTimKiem_1 = new JPanel();
		panelBoLocTimKiem_1.setLayout(null);
		panelBoLocTimKiem_1.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBoLocTimKiem_1.setBounds(10, 41, 362, 107);
		panel_3_1.add(panelBoLocTimKiem_1);
		
		JLabel lblTenNVTimKiem_1 = new JLabel("Tên nhân viên :");
		lblTenNVTimKiem_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNVTimKiem_1.setBounds(10, 21, 108, 23);
		panelBoLocTimKiem_1.add(lblTenNVTimKiem_1);
		
		txtTenNhanVienTimKiemThang = new JTextField();
		txtTenNhanVienTimKiemThang.setColumns(10);
		txtTenNhanVienTimKiemThang.setBounds(146, 22, 191, 22);
		panelBoLocTimKiem_1.add(txtTenNhanVienTimKiemThang);
		
		txtMaNhanVienTimKiemThang = new JTextField();
		txtMaNhanVienTimKiemThang.setColumns(10);
		txtMaNhanVienTimKiemThang.setBounds(146, 54, 191, 22);
		panelBoLocTimKiem_1.add(txtMaNhanVienTimKiemThang);
		
		JLabel lblNVMaNhanVienTimKiem_1 = new JLabel("Mã nhân viên");
		lblNVMaNhanVienTimKiem_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem_1.setBounds(10, 53, 108, 23);
		panelBoLocTimKiem_1.add(lblNVMaNhanVienTimKiem_1);
		
		JButton btnTimKiemNVThang = new JButton("Tìm kiếm");
		btnTimKiemNVThang.setBounds(10, 79, 89, 23);
		panelBoLocTimKiem_1.add(btnTimKiemNVThang);
		
		JPanel panelBangNhanVienTimKiemThang = new JPanel();
		panelBangNhanVienTimKiemThang.setBorder(new TitledBorder(null, "Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelBangNhanVienTimKiemThang.setBounds(10, 148, 362, 309);
		panel_3_1.add(panelBangNhanVienTimKiemThang);
		panelBangNhanVienTimKiemThang.setLayout(new BorderLayout(0, 0));
		
		JButton btnChonNhanVienTKThang = new JButton("Chọn");
		btnChonNhanVienTKThang.setBounds(138, 458, 89, 23);
		panel_3_1.add(btnChonNhanVienTKThang);
		
		JComboBox cbxThongKeThang = new JComboBox();
		cbxThongKeThang.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbxThongKeThang.setBounds(127, 22, 58, 22);
		panelDuLieuThongKeThang.add(cbxThongKeThang);
		
		JLabel lblThongKeNgay_1_2 = new JLabel("Năm :");
		lblThongKeNgay_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay_1_2.setBounds(226, 21, 49, 23);
		panelDuLieuThongKeThang.add(lblThongKeNgay_1_2);
		
		JPanel panelKetQuaThongKe_1 = new JPanel();
		panelKetQuaThongKe_1.setLayout(null);
		panelKetQuaThongKe_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "K\u1EBFt qu\u1EA3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelKetQuaThongKe_1.setBounds(407, 11, 523, 611);
		panelTabThongKeTheoThang.add(panelKetQuaThongKe_1);
		
		JLabel lblSlMhBanTrongNgay_1 = new JLabel("Số lượng mặt hàng đã bán :");
		lblSlMhBanTrongNgay_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSlMhBanTrongNgay_1.setBounds(10, 148, 166, 23);
		panelKetQuaThongKe_1.add(lblSlMhBanTrongNgay_1);
		
		txtSoLuongMatHangDaBanThang = new JTextField();
		txtSoLuongMatHangDaBanThang.setColumns(10);
		txtSoLuongMatHangDaBanThang.setBounds(174, 149, 78, 22);
		panelKetQuaThongKe_1.add(txtSoLuongMatHangDaBanThang);
		
		JLabel lblTongHdLapTrongNgay_1 = new JLabel("Tổng hóa đơn được lập :");
		lblTongHdLapTrongNgay_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTongHdLapTrongNgay_1.setBounds(292, 148, 147, 23);
		panelKetQuaThongKe_1.add(lblTongHdLapTrongNgay_1);
		
		txtTongHoaDonLapThang = new JTextField();
		txtTongHoaDonLapThang.setColumns(10);
		txtTongHoaDonLapThang.setBounds(438, 149, 51, 22);
		panelKetQuaThongKe_1.add(txtTongHoaDonLapThang);
		
		JLabel lblTongDoanhThuNgay_1 = new JLabel("Doanh thu tháng:");
		lblTongDoanhThuNgay_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTongDoanhThuNgay_1.setBounds(10, 181, 147, 23);
		panelKetQuaThongKe_1.add(lblTongDoanhThuNgay_1);
		
		txtDoanhThuTrongNgayThang = new JTextField();
		txtDoanhThuTrongNgayThang.setColumns(10);
		txtDoanhThuTrongNgayThang.setBounds(138, 182, 114, 22);
		panelKetQuaThongKe_1.add(txtDoanhThuTrongNgayThang);
		
		JLabel lblCnd_2 = new JLabel("VND");
		lblCnd_2.setBounds(255, 186, 31, 14);
		panelKetQuaThongKe_1.add(lblCnd_2);
		
		txtTongTienLaiThang = new JTextField();
		txtTongTienLaiThang.setColumns(10);
		txtTongTienLaiThang.setBounds(366, 213, 123, 22);
		panelKetQuaThongKe_1.add(txtTongTienLaiThang);
		
		JLabel lblTienLai_1 = new JLabel("Tổng lãi  :");
		lblTienLai_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTienLai_1.setBounds(292, 212, 64, 23);
		panelKetQuaThongKe_1.add(lblTienLai_1);
		
		JLabel lblCnd_1_3 = new JLabel("VND");
		lblCnd_1_3.setBounds(493, 217, 30, 14);
		panelKetQuaThongKe_1.add(lblCnd_1_3);
		
		JLabel lblTongThue_1 = new JLabel("Tổng thuế  :");
		lblTongThue_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTongThue_1.setBounds(292, 182, 79, 23);
		panelKetQuaThongKe_1.add(lblTongThue_1);
		
		txtTongThueThang = new JTextField();
		txtTongThueThang.setColumns(10);
		txtTongThueThang.setBounds(366, 182, 123, 22);
		panelKetQuaThongKe_1.add(txtTongThueThang);
		
		JLabel lblCnd_1_1_1 = new JLabel("VND");
		lblCnd_1_1_1.setBounds(493, 187, 30, 14);
		panelKetQuaThongKe_1.add(lblCnd_1_1_1);
		
		JLabel lblMatHang_1 = new JLabel("MH");
		lblMatHang_1.setBounds(262, 153, 20, 14);
		panelKetQuaThongKe_1.add(lblMatHang_1);
		
		JLabel lblHD_1 = new JLabel("HĐ");
		lblHD_1.setBounds(493, 153, 20, 14);
		panelKetQuaThongKe_1.add(lblHD_1);
		
		JLabel lblTongTienHang_1 = new JLabel("Tiền hàng : ");
		lblTongTienHang_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTongTienHang_1.setBounds(10, 215, 96, 23);
		panelKetQuaThongKe_1.add(lblTongTienHang_1);
		
		txtTongTienHangThang = new JTextField();
		txtTongTienHangThang.setColumns(10);
		txtTongTienHangThang.setBounds(138, 213, 114, 22);
		panelKetQuaThongKe_1.add(txtTongTienHangThang);
		
		JLabel lblCnd_1_2_1 = new JLabel("VND");
		lblCnd_1_2_1.setBounds(255, 217, 31, 14);
		panelKetQuaThongKe_1.add(lblCnd_1_2_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.PINK));
		panel_2.setBounds(285, 148, 1, 86);
		panelKetQuaThongKe_1.add(panel_2);
		
		JPanel panelTableTopMatHangThang = new JPanel();
		panelTableTopMatHangThang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Top 10 m\u1EB7t h\u00E0ng b\u00E1n ch\u1EA1y nh\u1EA5t", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTableTopMatHangThang.setBounds(10, 281, 503, 303);
		panelKetQuaThongKe_1.add(panelTableTopMatHangThang);
		panelTableTopMatHangThang.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTKTrenTaiKhoan_1 = new JLabel("Thống kê trên tài khoản : ");
		lblTKTrenTaiKhoan_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTKTrenTaiKhoan_1.setBounds(10, 27, 166, 23);
		panelKetQuaThongKe_1.add(lblTKTrenTaiKhoan_1);
		
		txtThongkeTrenTaiKhoanThang = new JTextField();
		txtThongkeTrenTaiKhoanThang.setColumns(10);
		txtThongkeTrenTaiKhoanThang.setBounds(174, 28, 182, 22);
		panelKetQuaThongKe_1.add(txtThongkeTrenTaiKhoanThang);
		
		JLabel lblThongKeTheoTieuChi_1 = new JLabel("Thống kê theo tiêu chí : ");
		lblThongKeTheoTieuChi_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi_1.setBounds(10, 61, 166, 23);
		panelKetQuaThongKe_1.add(lblThongKeTheoTieuChi_1);
		
		txtThongKeTheoTieuChiThang = new JTextField();
		txtThongKeTheoTieuChiThang.setColumns(10);
		txtThongKeTheoTieuChiThang.setBounds(174, 62, 182, 22);
		panelKetQuaThongKe_1.add(txtThongKeTheoTieuChiThang);
		
		txtThangDuocThongKe = new JTextField();
		txtThangDuocThongKe.setColumns(10);
		txtThangDuocThongKe.setBounds(174, 93, 51, 22);
		panelKetQuaThongKe_1.add(txtThangDuocThongKe);
		
		JLabel labNgayThongKe_1 = new JLabel("Tháng được thống kê : ");
		labNgayThongKe_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labNgayThongKe_1.setBounds(10, 92, 166, 23);
		panelKetQuaThongKe_1.add(labNgayThongKe_1);
		
		txtNamDuocThongKe = new JTextField();
		txtNamDuocThongKe.setColumns(10);
		txtNamDuocThongKe.setBounds(314, 93, 44, 22);
		panelKetQuaThongKe_1.add(txtNamDuocThongKe);
		
		JLabel lblThongKeNgay_1_2_1 = new JLabel("Năm :");
		lblThongKeNgay_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay_1_2_1.setBounds(262, 92, 57, 23);
		panelKetQuaThongKe_1.add(lblThongKeNgay_1_2_1);
		
		JPanel panelBieuDoThongKeThang = new JPanel();
		panelBieuDoThongKeThang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBieuDoThongKeThang.setBounds(940, 11, 395, 570);
		panelTabThongKeTheoThang.add(panelBieuDoThongKeThang);
		
		JButton btnTaoBaoCaoTkBanHangThang = new JButton("Tạo báo cáo");
		btnTaoBaoCaoTkBanHangThang.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTaoBaoCaoTkBanHangThang.setBounds(1179, 592, 136, 30);
		panelTabThongKeTheoThang.add(btnTaoBaoCaoTkBanHangThang);
		
		JButton btnXuatDuLieuTkBanHangThang = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuTkBanHangThang.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuTkBanHangThang.setBounds(960, 592, 174, 30);
		panelTabThongKeTheoThang.add(btnXuatDuLieuTkBanHangThang);
		
		JPanel panelTabThongKeTheoNam = new JPanel();
		panelTabThongKeTheoNam.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo năm", null, panelTabThongKeTheoNam, null);
		panelTabThongKeTheoNam.setLayout(null);
		
		JPanel panelBieuDoThongKeNam = new JPanel();
		panelBieuDoThongKeNam.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBieuDoThongKeNam.setBounds(940, 11, 395, 570);
		panelTabThongKeTheoNam.add(panelBieuDoThongKeNam);
		
		JButton btnTaoBaoCaoTkBanHang_1_1 = new JButton("Tạo báo cáo");
		btnTaoBaoCaoTkBanHang_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTaoBaoCaoTkBanHang_1_1.setBounds(1179, 592, 136, 30);
		panelTabThongKeTheoNam.add(btnTaoBaoCaoTkBanHang_1_1);
		
		JButton btnXuatDuLieuTkBanHang_1_1 = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuTkBanHang_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatDuLieuTkBanHang_1_1.setBounds(960, 592, 174, 30);
		panelTabThongKeTheoNam.add(btnXuatDuLieuTkBanHang_1_1);
		
		JPanel panelKetQuaThongKe_1_1 = new JPanel();
		panelKetQuaThongKe_1_1.setLayout(null);
		panelKetQuaThongKe_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "K\u1EBFt qu\u1EA3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelKetQuaThongKe_1_1.setBounds(407, 11, 523, 611);
		panelTabThongKeTheoNam.add(panelKetQuaThongKe_1_1);
		
		JLabel lblSlMhBanTrongNgay_1_1 = new JLabel("Số lượng mặt hàng đã bán :");
		lblSlMhBanTrongNgay_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSlMhBanTrongNgay_1_1.setBounds(10, 148, 166, 23);
		panelKetQuaThongKe_1_1.add(lblSlMhBanTrongNgay_1_1);
		
		txtSoLuongMatHangDaBanNam = new JTextField();
		txtSoLuongMatHangDaBanNam.setColumns(10);
		txtSoLuongMatHangDaBanNam.setBounds(174, 149, 78, 22);
		panelKetQuaThongKe_1_1.add(txtSoLuongMatHangDaBanNam);
		
		JLabel lblTongHdLapTrongNgay_1_1 = new JLabel("Tổng hóa đơn được lập :");
		lblTongHdLapTrongNgay_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTongHdLapTrongNgay_1_1.setBounds(292, 148, 147, 23);
		panelKetQuaThongKe_1_1.add(lblTongHdLapTrongNgay_1_1);
		
		txtTongHoaDonDuocLapNam = new JTextField();
		txtTongHoaDonDuocLapNam.setColumns(10);
		txtTongHoaDonDuocLapNam.setBounds(438, 149, 51, 22);
		panelKetQuaThongKe_1_1.add(txtTongHoaDonDuocLapNam);
		
		JLabel lblTongDoanhThuNgay_1_1 = new JLabel("Doanh thu trong năm:");
		lblTongDoanhThuNgay_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTongDoanhThuNgay_1_1.setBounds(10, 181, 147, 23);
		panelKetQuaThongKe_1_1.add(lblTongDoanhThuNgay_1_1);
		
		txtTongDoanhThuTrongNam = new JTextField();
		txtTongDoanhThuTrongNam.setColumns(10);
		txtTongDoanhThuTrongNam.setBounds(138, 182, 114, 22);
		panelKetQuaThongKe_1_1.add(txtTongDoanhThuTrongNam);
		
		JLabel lblCnd_2_1 = new JLabel("VND");
		lblCnd_2_1.setBounds(255, 186, 31, 14);
		panelKetQuaThongKe_1_1.add(lblCnd_2_1);
		
		txtTongLaiTrongNam = new JTextField();
		txtTongLaiTrongNam.setColumns(10);
		txtTongLaiTrongNam.setBounds(366, 213, 123, 22);
		panelKetQuaThongKe_1_1.add(txtTongLaiTrongNam);
		
		JLabel lblTienLai_1_1 = new JLabel("Tổng lãi  :");
		lblTienLai_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTienLai_1_1.setBounds(292, 212, 64, 23);
		panelKetQuaThongKe_1_1.add(lblTienLai_1_1);
		
		JLabel lblCnd_1_3_1 = new JLabel("VND");
		lblCnd_1_3_1.setBounds(493, 217, 30, 14);
		panelKetQuaThongKe_1_1.add(lblCnd_1_3_1);
		
		JLabel lblTongThue_1_1 = new JLabel("Tổng thuế  :");
		lblTongThue_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTongThue_1_1.setBounds(292, 182, 79, 23);
		panelKetQuaThongKe_1_1.add(lblTongThue_1_1);
		
		txtTongThueTrongNam = new JTextField();
		txtTongThueTrongNam.setColumns(10);
		txtTongThueTrongNam.setBounds(366, 182, 123, 22);
		panelKetQuaThongKe_1_1.add(txtTongThueTrongNam);
		
		JLabel lblCnd_1_1_1_1 = new JLabel("VND");
		lblCnd_1_1_1_1.setBounds(493, 187, 30, 14);
		panelKetQuaThongKe_1_1.add(lblCnd_1_1_1_1);
		
		JLabel lblMatHang_1_1 = new JLabel("MH");
		lblMatHang_1_1.setBounds(258, 153, 20, 14);
		panelKetQuaThongKe_1_1.add(lblMatHang_1_1);
		
		JLabel lblHD_1_1 = new JLabel("HĐ");
		lblHD_1_1.setBounds(493, 153, 20, 14);
		panelKetQuaThongKe_1_1.add(lblHD_1_1);
		
		JLabel lblTongTienHang_1_1 = new JLabel("Tiền hàng : ");
		lblTongTienHang_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTongTienHang_1_1.setBounds(10, 215, 96, 23);
		panelKetQuaThongKe_1_1.add(lblTongTienHang_1_1);
		
		txtTongTienHangTrongNam = new JTextField();
		txtTongTienHangTrongNam.setColumns(10);
		txtTongTienHangTrongNam.setBounds(138, 213, 114, 22);
		panelKetQuaThongKe_1_1.add(txtTongTienHangTrongNam);
		
		JLabel lblCnd_1_2_1_1 = new JLabel("VND");
		lblCnd_1_2_1_1.setBounds(255, 217, 31, 14);
		panelKetQuaThongKe_1_1.add(lblCnd_1_2_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new LineBorder(Color.PINK));
		panel_2_1.setBounds(285, 148, 1, 86);
		panelKetQuaThongKe_1_1.add(panel_2_1);
		
		JPanel panelTableTopMatHangNam = new JPanel();
		panelTableTopMatHangNam.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Top 10 m\u1EB7t h\u00E0ng b\u00E1n ch\u1EA1y nh\u1EA5t", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTableTopMatHangNam.setBounds(10, 281, 503, 303);
		panelKetQuaThongKe_1_1.add(panelTableTopMatHangNam);
		panelTableTopMatHangNam.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTKTrenTaiKhoan_1_1 = new JLabel("Thống kê trên tài khoản : ");
		lblTKTrenTaiKhoan_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTKTrenTaiKhoan_1_1.setBounds(10, 27, 166, 23);
		panelKetQuaThongKe_1_1.add(lblTKTrenTaiKhoan_1_1);
		
		txtThongKeTrenTaiKhoanNam = new JTextField();
		txtThongKeTrenTaiKhoanNam.setColumns(10);
		txtThongKeTrenTaiKhoanNam.setBounds(174, 28, 182, 22);
		panelKetQuaThongKe_1_1.add(txtThongKeTrenTaiKhoanNam);
		
		JLabel lblThongKeTheoTieuChi_1_1 = new JLabel("Thống kê theo tiêu chí : ");
		lblThongKeTheoTieuChi_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeTheoTieuChi_1_1.setBounds(10, 61, 166, 23);
		panelKetQuaThongKe_1_1.add(lblThongKeTheoTieuChi_1_1);
		
		xtxThongKeTheoTieuChiNam = new JTextField();
		xtxThongKeTheoTieuChiNam.setColumns(10);
		xtxThongKeTheoTieuChiNam.setBounds(174, 62, 182, 22);
		panelKetQuaThongKe_1_1.add(xtxThongKeTheoTieuChiNam);
		
		txtNamDuocTK = new JTextField();
		txtNamDuocTK.setColumns(10);
		txtNamDuocTK.setBounds(174, 93, 182, 22);
		panelKetQuaThongKe_1_1.add(txtNamDuocTK);
		
		JLabel labNgayThongKe_1_1 = new JLabel("Năm được thống kê  : ");
		labNgayThongKe_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labNgayThongKe_1_1.setBounds(10, 92, 166, 23);
		panelKetQuaThongKe_1_1.add(labNgayThongKe_1_1);
		
		JPanel panelDuLieuThongKe_1_1 = new JPanel();
		panelDuLieuThongKe_1_1.setLayout(null);
		panelDuLieuThongKe_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDuLieuThongKe_1_1.setBounds(10, 11, 387, 611);
		panelTabThongKeTheoNam.add(panelDuLieuThongKe_1_1);
		
		JLabel lblThongKeNgay_1_1 = new JLabel("Nhập năm thống kê :");
		lblThongKeNgay_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay_1_1.setBounds(20, 21, 138, 23);
		panelDuLieuThongKe_1_1.add(lblThongKeNgay_1_1);
		
		txtNamThongKeNam = new JTextField();
		txtNamThongKeNam.setColumns(10);
		txtNamThongKeNam.setBounds(190, 22, 79, 22);
		panelDuLieuThongKe_1_1.add(txtNamThongKeNam);
		
		JLabel lblTieuChiThongKe_1_1 = new JLabel("Tiêu chí thống kê :");
		lblTieuChiThongKe_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTieuChiThongKe_1_1.setBounds(20, 55, 108, 23);
		panelDuLieuThongKe_1_1.add(lblTieuChiThongKe_1_1);
		
		JComboBox cbxChiTieuThongKeNam = new JComboBox();
		cbxChiTieuThongKeNam.setBounds(190, 54, 160, 22);
		panelDuLieuThongKe_1_1.add(cbxChiTieuThongKeNam);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1ECDn nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_1_1.setBounds(0, 129, 382, 492);
		panelDuLieuThongKe_1_1.add(panel_3_1_1);
		
		JCheckBox cbTatCaNhanVienNam = new JCheckBox("Tất cả nhân viên");
		cbTatCaNhanVienNam.setBounds(207, 18, 145, 23);
		panel_3_1_1.add(cbTatCaNhanVienNam);
		
		JLabel lblTimNVCanThongKe_1_1 = new JLabel("Tìm nhân viên cần thống kê :");
		lblTimNVCanThongKe_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimNVCanThongKe_1_1.setBounds(10, 21, 175, 14);
		panel_3_1_1.add(lblTimNVCanThongKe_1_1);
		
		JPanel panelBoLocTimKiemNam = new JPanel();
		panelBoLocTimKiemNam.setLayout(null);
		panelBoLocTimKiemNam.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBoLocTimKiemNam.setBounds(10, 41, 362, 107);
		panel_3_1_1.add(panelBoLocTimKiemNam);
		
		JLabel lblTenNVTimKiem_1_1 = new JLabel("Tên nhân viên :");
		lblTenNVTimKiem_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNVTimKiem_1_1.setBounds(10, 21, 108, 23);
		panelBoLocTimKiemNam.add(lblTenNVTimKiem_1_1);
		
		txtTenNhanVienTimKiemNam = new JTextField();
		txtTenNhanVienTimKiemNam.setColumns(10);
		txtTenNhanVienTimKiemNam.setBounds(146, 22, 191, 22);
		panelBoLocTimKiemNam.add(txtTenNhanVienTimKiemNam);
		
		txtMaNhanVienTimKiemNam = new JTextField();
		txtMaNhanVienTimKiemNam.setColumns(10);
		txtMaNhanVienTimKiemNam.setBounds(146, 54, 191, 22);
		panelBoLocTimKiemNam.add(txtMaNhanVienTimKiemNam);
		
		JLabel lblNVMaNhanVienTimKiem_1_1 = new JLabel("Mã nhân viên");
		lblNVMaNhanVienTimKiem_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem_1_1.setBounds(10, 53, 108, 23);
		panelBoLocTimKiemNam.add(lblNVMaNhanVienTimKiem_1_1);
		
		JButton btnTimKiemNhanVienNam = new JButton("Tìm kiếm");
		btnTimKiemNhanVienNam.setBounds(10, 79, 89, 23);
		panelBoLocTimKiemNam.add(btnTimKiemNhanVienNam);
		
		JPanel panelBangNhanVienTimKiemNam = new JPanel();
		panelBangNhanVienTimKiemNam.setBorder(new TitledBorder(null, "Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelBangNhanVienTimKiemNam.setBounds(10, 148, 362, 309);
		panel_3_1_1.add(panelBangNhanVienTimKiemNam);
		panelBangNhanVienTimKiemNam.setLayout(new BorderLayout(0, 0));
		
		JButton btnChonNhanVienNam = new JButton("Chọn");
		btnChonNhanVienNam.setBounds(138, 458, 89, 23);
		panel_3_1_1.add(btnChonNhanVienNam);
	}
	
	private void switchContent(JPanel newContent) {
		newContent.setBounds(0, 28, 1350, 701);
        if (currentContent != null) {
            contentPane.remove(currentContent);
            currentContent.requestFocusInWindow();
        }
        currentContent = newContent;
        contentPane.add(currentContent, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		
	}
}