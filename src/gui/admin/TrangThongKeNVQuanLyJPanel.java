package gui.admin;

import java.awt.Color;
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
	private JTextField txtThongKeTrenNgay;
	private JTextField txtThongKeTrenNV;
	private JTextField txtTenNhanVienTimKiem;
	private JTextField txtMaNhanVienTimKiem;
	private JTable tblDsNhanVien;

	/**
	 * Create the panel.
	 */
	public TrangThongKeNVQuanLyJPanel() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		JPanel menuCN_CNThongKe = new JPanel();
		menuCN_CNThongKe.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		menuCN_CNThongKe.setBounds(0, 0, 1712, 42);
		add(menuCN_CNThongKe);
		menuCN_CNThongKe.setLayout(null);
		
		JButton btnCNThongKeBanHang = new JButton("Thống kê bán hàng");
		btnCNThongKeBanHang.setBackground(new Color(255, 218, 185));
		btnCNThongKeBanHang.setBounds(10, 5, 181, 34);
		btnCNThongKeBanHang.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-home.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnCNThongKeBanHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuCN_CNThongKe.add(btnCNThongKeBanHang);
		
		JButton btnCNThongKeDoanhThu = new JButton("Thống kê doanh thu");
		btnCNThongKeDoanhThu.setBackground(new Color(255, 218, 185));
		btnCNThongKeDoanhThu.setBounds(201, 5, 199, 34);
		btnCNThongKeDoanhThu.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-home.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnCNThongKeDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuCN_CNThongKe.add(btnCNThongKeDoanhThu);
		
		JButton btnCNThongKeHoaDon = new JButton("Thống kê hóa đơn");
		btnCNThongKeHoaDon.setBackground(new Color(255, 218, 185));
		btnCNThongKeHoaDon.setBounds(410, 5, 181, 34);
		btnCNThongKeHoaDon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-home.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnCNThongKeHoaDon.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuCN_CNThongKe.add(btnCNThongKeHoaDon);
		
		JPanel panelCN_CNThongKe = new JPanel();
		panelCN_CNThongKe.setBounds(0, 44, 1712, 837);
		add(panelCN_CNThongKe);
		panelCN_CNThongKe.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ BÁN HÀNG");
		lblNewLabel.setBounds(758, 5, 196, 25);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCN_CNThongKe.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 21, 1712, 816);
		panelCN_CNThongKe.add(tabbedPane);
		
		JPanel panelTabThongKeTheoNgay = new JPanel();
		panelTabThongKeTheoNgay.setBackground(new Color(102, 205, 170));
		tabbedPane.addTab("Theo ngày", null, panelTabThongKeTheoNgay, null);
		panelTabThongKeTheoNgay.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u1EEF li\u1EC7u th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 402, 766);
		panelTabThongKeTheoNgay.add(panel);
		panel.setLayout(null);
		
		JLabel lblThongKeNgay = new JLabel("Thống kê ngày :");
		lblThongKeNgay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongKeNgay.setBounds(21, 33, 108, 23);
		panel.add(lblThongKeNgay);
		
		txtThongKeTrenNgay = new JTextField();
		txtThongKeTrenNgay.setBounds(191, 34, 160, 22);
		panel.add(txtThongKeTrenNgay);
		txtThongKeTrenNgay.setColumns(10);
		
		JLabel lblChiTieuThongKe = new JLabel("Chỉ tiêu thống kê :");
		lblChiTieuThongKe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblChiTieuThongKe.setBounds(21, 67, 108, 23);
		panel.add(lblChiTieuThongKe);
		
		JLabel lblThngKTrn = new JLabel("Thống kê trên nhân viên : ");
		lblThngKTrn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThngKTrn.setBounds(21, 101, 160, 23);
		panel.add(lblThngKTrn);
		
		txtThongKeTrenNV = new JTextField();
		txtThongKeTrenNV.setColumns(10);
		txtThongKeTrenNV.setBounds(191, 102, 160, 22);
		panel.add(txtThongKeTrenNV);
		
		JComboBox cbxChiTieuThongKe = new JComboBox();
		cbxChiTieuThongKe.setModel(new DefaultComboBoxModel(new String[] {"Bán chạy ", "Bán chậm", "Tất cả mắt hàng"}));
		cbxChiTieuThongKe.setBounds(191, 66, 160, 22);
		panel.add(cbxChiTieuThongKe);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1ECDn nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 189, 382, 566);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JCheckBox cbTatCaNhanVien = new JCheckBox("Tất cả nhân viên");
		cbTatCaNhanVien.setBounds(218, 22, 145, 23);
		panel_3.add(cbTatCaNhanVien);
		
		JLabel lblTimNVCanThongKe = new JLabel("Tìm nhân viên cần thống kê :");
		lblTimNVCanThongKe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimNVCanThongKe.setBounds(21, 25, 175, 14);
		panel_3.add(lblTimNVCanThongKe);
		
		JPanel panelBoLocTimKiem = new JPanel();
		panelBoLocTimKiem.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBoLocTimKiem.setBounds(10, 52, 362, 121);
		panel_3.add(panelBoLocTimKiem);
		panelBoLocTimKiem.setLayout(null);
		
		JLabel lblTenNVTimKiem = new JLabel("Tên nhân viên :");
		lblTenNVTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNVTimKiem.setBounds(10, 21, 108, 23);
		panelBoLocTimKiem.add(lblTenNVTimKiem);
		
		txtTenNhanVienTimKiem = new JTextField();
		txtTenNhanVienTimKiem.setColumns(10);
		txtTenNhanVienTimKiem.setBounds(146, 22, 191, 22);
		panelBoLocTimKiem.add(txtTenNhanVienTimKiem);
		
		txtMaNhanVienTimKiem = new JTextField();
		txtMaNhanVienTimKiem.setColumns(10);
		txtMaNhanVienTimKiem.setBounds(146, 56, 191, 22);
		panelBoLocTimKiem.add(txtMaNhanVienTimKiem);
		
		JLabel lblNVMaNhanVienTimKiem = new JLabel("Mã nhân viên");
		lblNVMaNhanVienTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVMaNhanVienTimKiem.setBounds(10, 55, 108, 23);
		panelBoLocTimKiem.add(lblNVMaNhanVienTimKiem);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(10, 87, 89, 23);
		panelBoLocTimKiem.add(btnTimKiem);
		
		JButton btnChonNhanVien = new JButton("Chọn");
		btnChonNhanVien.setBounds(147, 532, 89, 23);
		panel_3.add(btnChonNhanVien);
		
		JPanel panelBangNhanVien = new JPanel();
		panelBangNhanVien.setBorder(new TitledBorder(null, "Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelBangNhanVien.setBounds(10, 184, 362, 346);
		panel_3.add(panelBangNhanVien);
		panelBangNhanVien.setLayout(new BorderLayout(0, 0));
		
		tblDsNhanVien = new JTable();
		/*
		 * Table
		 * */
		panelBangNhanVien.add(tblDsNhanVien, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "K\u1EBFt qu\u1EA3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(422, 11, 798, 766);
		panelTabThongKeTheoNgay.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Bi\u1EC3u \u0111\u1ED3 th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(1230, 11, 467, 658);
		panelTabThongKeTheoNgay.add(panel_2);
		
		JButton btnTaoBaoCaoTkBanHang = new JButton("Tạo báo cáo");
		btnTaoBaoCaoTkBanHang.setBounds(1260, 697, 161, 45);
		btnTaoBaoCaoTkBanHang.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-home.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnTaoBaoCaoTkBanHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelTabThongKeTheoNgay.add(btnTaoBaoCaoTkBanHang);
		
		JButton btnXuatDuLieuTkBanHang = new JButton("Xuất dữ liệu thống kê");
		btnXuatDuLieuTkBanHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXuatDuLieuTkBanHang.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-home.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnXuatDuLieuTkBanHang.setBounds(1470, 697, 204, 45);
		panelTabThongKeTheoNgay.add(btnXuatDuLieuTkBanHang);
		
		JPanel panelTabThongKeTheoThang = new JPanel();
		panelTabThongKeTheoThang.setBackground(new Color(112, 128, 144));
		tabbedPane.addTab("Theo tháng", null, panelTabThongKeTheoThang, null);
		
		JPanel panelTabThongKeTheoNam = new JPanel();
		tabbedPane.addTab("Theo năm", null, panelTabThongKeTheoNam, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		
	}
}
