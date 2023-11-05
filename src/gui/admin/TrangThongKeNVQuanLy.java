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

public class TrangThongKeNVQuanLy extends JPanel implements ActionListener{
	private JTextField txtThongKeTrenNgay;
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
	private TK_ThongKeDinhViJPanel panelDinhVi;

	
	private String selectFunction;
	/**
	 * Create the panel.
	 */
	public TrangThongKeNVQuanLy() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		panelDinhVi = new TK_ThongKeDinhViJPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(Color.RED));
		tabbedPane.setBounds(0, 11, 1350, 690);
		add(tabbedPane);
		
		JPanel panelCN_CNThongKe = new JPanel();
		panelCN_CNThongKe.setLayout(null);
		tabbedPane.addTab("Thống kê bán hàng", null, panelCN_CNThongKe, null);
		
		TK_ThongKeBanHangJPanel panelTKBanHang = new TK_ThongKeBanHangJPanel();
		panelTKBanHang.setBorder(new LineBorder(Color.RED));
		panelTKBanHang.setBounds(0, 11, 1350, 657);
		panelCN_CNThongKe.add(panelTKBanHang);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Thống kê định vị kệ", null, panel, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		
	}
}