package gui.user;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import constance.SetBountJPanel;
import daos.Dao_ChiTietHoaDon;
import daos.Dao_HangHoa;
import daos.Dao_HoaDon;
import daos.Dao_KhachHang;
import daos.Dao_NhanVien;
import daos.Dao_VoucherGiamGia;
import entities.ChiTietHoaDon;
import entities.HangHoa;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import entities.VoucherGiamGia;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;

public class TrangBanHangJPanel extends JPanel
		implements ActionListener, Action, ListSelectionListener, ItemListener, DocumentListener {
	private LocalDate ngayLapHD = LocalDate.now();
	private JTextField txt_MaHangHoa;
	private JTextField txt_SDTKhachHang;
	private JTextField txt_TienNhan;

	private JButton btn_TimHoaDon;
	private TrangTimKiemHoaDon trangTimKiemHoaDon;
	private JPanel currentContent;
	private JButton btn_HangCho;
	private JLabel lbl_NgayLapHD;
	private JLabel lbl_NVLapHD;
	private JComboBox<String> comboBox_KichThuoc;
	private JButton btn_LamMoi;
	private JButton btn_Them;
	private JLabel lbl_TenKhachHang;
	private JLabel lbl_TongTienHang;
	private JLabel lbl_Thue;
	private JLabel lbl_TienGiamGia;
	private JLabel lbl_TienThua;
	private JLabel lbl_TongTienTra;

	private DefaultComboBoxModel<String> modelCombobox;
	private SpinnerModel model_Spinner;

	private AbstractTableHoaDon model;
	private JTable table;
	private JSpinner spinner_SoLuong;

	private DecimalFormat decimalFormat = new DecimalFormat("#,##0");

	private JButton btn_HuyHoaDon;
	private JButton btn_ThanhToan;

	private NhanVien nv;
	private KhachHang kh = null;
	private VoucherGiamGia vc = null;
	private ArrayList<ChiTietHoaDon> listChiTietHD = new ArrayList<>();
	private HoaDon hoaDon;
	private JCheckBox chckx_DiemTichLuy;

	private Dao_HangHoa dao_HangHoa;
	private Dao_VoucherGiamGia dao_VoucherGiamGia;
	private Dao_KhachHang dao_KhachHang;
	private Dao_HoaDon dao_HoaDon;
	private Dao_ChiTietHoaDon dao_ChiTietHoaDon;
	private Dao_NhanVien dao_NhanVien;
	private JTextField txt_VoucherGiamGia;
	private JLabel lbl_DiemTichLuy;
	private JLabel lbl_TenVoucher;
	private JLabel lbl_PhanTramGiamGia;

	/**
	 * Create the panel.
	 */
	public TrangBanHangJPanel(NhanVien nhanVien, HoaDon HD_TruyenVao) {

		dao_HangHoa = new Dao_HangHoa();
		dao_VoucherGiamGia = new Dao_VoucherGiamGia();
		dao_KhachHang = new Dao_KhachHang();
		dao_HoaDon = new Dao_HoaDon();
		dao_ChiTietHoaDon = new Dao_ChiTietHoaDon();
		dao_NhanVien = new Dao_NhanVien();

		nv = TrangChinhNVBanHang.nv;
		taoHoaDon(nhanVien, HD_TruyenVao);

		setBackground(new Color(158, 226, 173));

		/* Thiết lập jpanel cho trang bán hàng */
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);

		/* Tạo 2 button menu cho trang Quản lý bán hàng */
		JPanel menu = new JPanel();
		menu.setBounds(0, 0, 1350, 43);
		menu.setBackground(new Color(158, 226, 173));
		add(menu);
		menu.setLayout(null);

		/* Button lập hóa đơn */
		JButton btn_LapHoaDon = new JButton("Lập hóa đơn");
		btn_LapHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		btn_LapHoaDon.setBackground(new Color(39, 224, 224));
		btn_LapHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_LapHoaDon.setBounds(0, 0, 187, 43);
		menu.add(btn_LapHoaDon);

//		Button tìm kiếm hóa đơn
		btn_TimHoaDon = new JButton("Tìm kiếm hóa đơn");
		btn_TimHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_TimHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		btn_TimHoaDon.setBackground(new Color(255, 255, 255));
		btn_TimHoaDon.setBounds(184, 0, 229, 43);
		menu.add(btn_TimHoaDon);

//		Tạo panel Thông tin hóa đơn
		JPanel panel_ThongTinHoaDon = new JPanel();
		panel_ThongTinHoaDon.setBounds(5, 43, 497, 96);
		panel_ThongTinHoaDon.setBackground(new Color(255, 255, 255));
		add(panel_ThongTinHoaDon);
		panel_ThongTinHoaDon.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		panel_ThongTinHoaDon.setLayout(null);

//		Label ngày nhập
//		Lấy ngày hiện tại là ngày lập hóa đơn
		JLabel lbl_NgayLap = new JLabel("Ngày lập: ");
		lbl_NgayLap.setFont(new Font("Arial", Font.PLAIN, 18));
		lbl_NgayLap.setBounds(20, 23, 109, 22);
		panel_ThongTinHoaDon.add(lbl_NgayLap);

		lbl_NgayLapHD = new JLabel(ngayLapHD.toString());
		lbl_NgayLapHD.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_NgayLapHD.setBounds(246, 23, 138, 23);
		panel_ThongTinHoaDon.add(lbl_NgayLapHD);

//		label nhân viên
		JLabel lbl_NhanVien = new JLabel("Nhân viên:");
		lbl_NhanVien.setFont(new Font("Arial", Font.PLAIN, 18));
		lbl_NhanVien.setBounds(20, 53, 109, 22);
		panel_ThongTinHoaDon.add(lbl_NhanVien);

		lbl_NVLapHD = new JLabel(nv.getHoTen());
		lbl_NVLapHD.setForeground(new Color(226, 41, 69));
		lbl_NVLapHD.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_NVLapHD.setBounds(246, 53, 152, 23);
		panel_ThongTinHoaDon.add(lbl_NVLapHD);

//		Tạo panel Nhập thông tin của mặt hàng được bán
		JPanel panel_NhapThongTinMatHang = new JPanel();
		panel_NhapThongTinMatHang.setBounds(5, 143, 497, 206);
		panel_NhapThongTinMatHang.setBackground(new Color(255, 255, 255));
		add(panel_NhapThongTinMatHang);
		panel_NhapThongTinMatHang.setBorder(BorderFactory.createTitledBorder("Nhập thông tin mặt hàng"));
		panel_NhapThongTinMatHang.setLayout(null);

//		Nhập mã hàng hóa, không được để rỗng
		JLabel lbl_MaHangHoa = new JLabel("Mã hàng hóa:");
		lbl_MaHangHoa.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_MaHangHoa.setBounds(21, 20, 157, 31);
		panel_NhapThongTinMatHang.add(lbl_MaHangHoa);

		txt_MaHangHoa = new JTextField();
		txt_MaHangHoa.setBounds(236, 20, 243, 31);
		panel_NhapThongTinMatHang.add(txt_MaHangHoa);
		txt_MaHangHoa.setColumns(10);

//		chọn kích thước cho hàng hóa
		JLabel lbl_KichThuoc = new JLabel("Kích thước:");
		lbl_KichThuoc.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_KichThuoc.setBounds(21, 60, 157, 31);
		panel_NhapThongTinMatHang.add(lbl_KichThuoc);

		modelCombobox = new DefaultComboBoxModel<>();
		comboBox_KichThuoc = new JComboBox<>(modelCombobox);
		comboBox_KichThuoc.setBounds(236, 60, 243, 29);
		panel_NhapThongTinMatHang.add(comboBox_KichThuoc);

		JLabel lbl_SoLuong = new JLabel("Số lượng");
		lbl_SoLuong.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_SoLuong.setBounds(21, 100, 157, 31);
		panel_NhapThongTinMatHang.add(lbl_SoLuong);

		// Tạo một SpinnerModel để quy định giá trị ban đầu, giá trị tối thiểu, giá trị
		// tối đa và bước nhảy
		model_Spinner = new SpinnerNumberModel(1, 1, 100, 1);
		spinner_SoLuong = new JSpinner(model_Spinner);
		spinner_SoLuong.setBounds(236, 100, 243, 30);
		panel_NhapThongTinMatHang.add(spinner_SoLuong);
	

//		2 nút thêm và refresh lại các jtextfield ở trên
//		Tìm hiểu phần button icon để tạo các nút
		btn_LamMoi = createButtonWithIcon("img\\repeat.png", 40, 40);
		btn_LamMoi.setBorderPainted(false); // Bỏ viền
		btn_LamMoi.setBounds(330, 150, 40, 40);
		btn_LamMoi.setBackground(new Color(255, 255, 255));
		panel_NhapThongTinMatHang.add(btn_LamMoi);

		btn_Them = new JButton();
		btn_Them = createButtonWithIcon("img\\plus.png", 40, 40);
		btn_Them.setBorderPainted(false); // Bỏ viền
		btn_Them.setBounds(400, 150, 40, 40);
		btn_Them.setBackground(new Color(255, 255, 255));
		panel_NhapThongTinMatHang.add(btn_Them);

//		tạo panel nhập thông tin khách hàng và tiền nhận
		JPanel panel_KhachHangVaTienNhan = new JPanel();
		panel_KhachHangVaTienNhan.setBounds(5, 355, 497, 324);
		panel_KhachHangVaTienNhan.setBackground(new Color(255, 255, 255));
		add(panel_KhachHangVaTienNhan);
		panel_KhachHangVaTienNhan.setLayout(null);
		panel_KhachHangVaTienNhan.setBorder(BorderFactory.createTitledBorder("Nhập thông tin khách hàng và tiền nhận"));

		JLabel lblNewLabel = new JLabel("Tên khách hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 20, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel);

		lbl_TenKhachHang = new JLabel("");
		lbl_TenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TenKhachHang.setBounds(241, 20, 219, 30);
		panel_KhachHangVaTienNhan.add(lbl_TenKhachHang);

		JLabel lblNewLabel_1 = new JLabel("SĐT:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 58, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel_1);

		txt_SDTKhachHang = new JTextField();
		txt_SDTKhachHang.setBounds(241, 58, 219, 31);
		panel_KhachHangVaTienNhan.add(txt_SDTKhachHang);
		txt_SDTKhachHang.setColumns(10);

		chckx_DiemTichLuy = new JCheckBox("Sử dụng điểm tích lũy");
		chckx_DiemTichLuy.setBackground(new Color(255, 255, 255));
		chckx_DiemTichLuy.setBounds(439, 100, 21, 31);

		panel_KhachHangVaTienNhan.add(chckx_DiemTichLuy);

		JLabel lblNewLabel_2 = new JLabel("Mã voucher:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 155, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tiền nhận:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 280, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel_3);

		txt_TienNhan = new JTextField();
		txt_TienNhan.setBounds(241, 280, 219, 31);
		panel_KhachHangVaTienNhan.add(txt_TienNhan);
		txt_TienNhan.setColumns(10);

		txt_VoucherGiamGia = new JTextField();
		txt_VoucherGiamGia.setBounds(241, 155, 219, 31);
		panel_KhachHangVaTienNhan.add(txt_VoucherGiamGia);
		txt_VoucherGiamGia.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("Dùng điểm tích lũy:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14.setBounds(20, 100, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel_14);

		lbl_DiemTichLuy = new JLabel("0");
		lbl_DiemTichLuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_DiemTichLuy.setBounds(238, 100, 195, 31);
		panel_KhachHangVaTienNhan.add(lbl_DiemTichLuy);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 138, 482, 6);
		panel_KhachHangVaTienNhan.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 263, 482, 4);
		panel_KhachHangVaTienNhan.add(panel_1);

		JLabel lblNewLabel_2_1 = new JLabel("Tên voucher:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(20, 190, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel_2_1);

		lbl_TenVoucher = new JLabel("");
		lbl_TenVoucher.setBounds(241, 190, 219, 31);
		lbl_TenVoucher.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_KhachHangVaTienNhan.add(lbl_TenVoucher);

		JLabel lblNewLabel_2_1_1 = new JLabel("Phần trăm giảm giá:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(20, 225, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel_2_1_1);

		lbl_PhanTramGiamGia = new JLabel("");
		lbl_PhanTramGiamGia.setBounds(241, 225, 219, 31);
		lbl_PhanTramGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_KhachHangVaTienNhan.add(lbl_PhanTramGiamGia);

//		Tạo panel table chưa danh sách các mặt hàng được bán
		JPanel panel_KhachHangVaTienNhan_1 = new JPanel();
		panel_KhachHangVaTienNhan_1.setBorder(BorderFactory.createTitledBorder("Danh sách mặt hàng được đặt mua"));
		panel_KhachHangVaTienNhan_1.setBounds(506, 41, 840, 409);
		panel_KhachHangVaTienNhan_1.setBackground(new Color(255, 255, 255));
		add(panel_KhachHangVaTienNhan_1);
		panel_KhachHangVaTienNhan_1.setLayout(new GridLayout(1, 1));

		model = new AbstractTableHoaDon();
		table = new JTable(model);
		table.setRowHeight(40);
		table.setFont(new Font("Monospaced", Font.PLAIN, 17));
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(270);
		table.getColumnModel().getColumn(2).setPreferredWidth(5);
		table.getColumnModel().getColumn(3).setPreferredWidth(15);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(5);
		table.setShowGrid(false);

		table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
		table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor());
		panel_KhachHangVaTienNhan_1.add(new JScrollPane(table));

//		Tạo panel Thông tin tổng tiền
		JPanel panel_KhachHangVaTienNhan_2 = new JPanel();
		panel_KhachHangVaTienNhan_2.setBorder(BorderFactory.createTitledBorder("Tính tổng tiền"));
		panel_KhachHangVaTienNhan_2.setBounds(674, 454, 672, 225);
		panel_KhachHangVaTienNhan_2.setBackground(new Color(255, 255, 255));
		add(panel_KhachHangVaTienNhan_2);
		panel_KhachHangVaTienNhan_2.setLayout(null);

		JPanel panel_TongThanhTien = new JPanel();
		panel_TongThanhTien.setBackground(new Color(143, 211, 237));
		panel_TongThanhTien.setBounds(383, 20, 273, 192);
		panel_KhachHangVaTienNhan_2.add(panel_TongThanhTien);
		panel_TongThanhTien.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Tổng tiền trả:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.BOLD, 22));
		lblNewLabel_4.setBounds(0, 24, 273, 59);
		panel_TongThanhTien.add(lblNewLabel_4);

		lbl_TongTienTra = new JLabel("0");
		lbl_TongTienTra.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TongTienTra.setForeground(new Color(226, 41, 69));
		lbl_TongTienTra.setFont(new Font("Sitka Text", Font.BOLD, 29));
		lbl_TongTienTra.setBounds(0, 70, 222, 75);
		panel_TongThanhTien.add(lbl_TongTienTra);

		JLabel lblNewLabel_6 = new JLabel("VNĐ");
		lblNewLabel_6.setFont(new Font("Sitka Small", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(226, 94, 39, 31);
		panel_TongThanhTien.add(lblNewLabel_6);

		JLabel lblNewLabel_5 = new JLabel("Tổng tiền hàng:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 36, 169, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel("Thuế VAT (10%):");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 86, 169, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Tổng tiền được giảm giá:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(10, 132, 169, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Tiền thừa:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(10, 179, 169, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_9);

		lbl_TongTienHang = new JLabel("0");
		lbl_TongTienHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TongTienHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TongTienHang.setBounds(177, 36, 150, 24);
		panel_KhachHangVaTienNhan_2.add(lbl_TongTienHang);

		lbl_Thue = new JLabel("0");
		lbl_Thue.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Thue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Thue.setBounds(177, 86, 150, 24);
		panel_KhachHangVaTienNhan_2.add(lbl_Thue);

		lbl_TienGiamGia = new JLabel("0");
		lbl_TienGiamGia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TienGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TienGiamGia.setBounds(177, 132, 150, 24);
		panel_KhachHangVaTienNhan_2.add(lbl_TienGiamGia);

		lbl_TienThua = new JLabel("0");
		lbl_TienThua.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TienThua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TienThua.setBounds(177, 179, 150, 24);
		panel_KhachHangVaTienNhan_2.add(lbl_TienThua);

		JLabel lblNewLabel_10 = new JLabel("VNĐ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(337, 36, 36, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("VNĐ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(337, 86, 36, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("VNĐ");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(337, 132, 36, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("VNĐ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(337, 179, 36, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_13);

		btn_HuyHoaDon = new JButton("Hủy Hóa Đơn (F1)");
		btn_HuyHoaDon.setBackground(new Color(226, 41, 69));
		btn_HuyHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_HuyHoaDon.setBounds(507, 473, 163, 50);
		add(btn_HuyHoaDon);

		btn_HangCho = new JButton("Hàng chờ (F2)");
		btn_HangCho.setBackground(new Color(245, 114, 27));
		btn_HangCho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_HangCho.setBounds(507, 534, 163, 50);
		add(btn_HangCho);

		btn_ThanhToan = new JButton("Thanh toán (F3)");
		btn_ThanhToan.setBackground(new Color(34, 176, 45));
		btn_ThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_ThanhToan.setBounds(507, 595, 163, 50);
		add(btn_ThanhToan);

		if (listChiTietHD.size() > 0) {
			loadToanBoDuLieuTrongHoaDonCho();
		}

		trangTimKiemHoaDon = new TrangTimKiemHoaDon(nv);
//
		btn_TimHoaDon.addActionListener(this);
		btn_HangCho.addActionListener(this);
		btn_LamMoi.addActionListener(this);
		txt_SDTKhachHang.addActionListener(this);
		btn_Them.addActionListener(this);
		btn_HuyHoaDon.addActionListener(this);
		btn_ThanhToan.addActionListener(this);
		txt_MaHangHoa.addActionListener(this);
		table.getSelectionModel().addListSelectionListener(this);
		txt_TienNhan.addActionListener(this);
		txt_VoucherGiamGia.addActionListener(this);
		txt_TienNhan.getDocument().addDocumentListener(this);

		chckx_DiemTichLuy.addItemListener(this);
		
		
		suKienPhimTat();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_TimHoaDon)) {
			switchContent(trangTimKiemHoaDon);

		} else if (o.equals(btn_HangCho)) {
			taoHangCho();

		} else if (o.equals(txt_SDTKhachHang)) {
			String sdt = txt_SDTKhachHang.getText();
			timThongTinKhachHang(sdt);

		} else if (o.equals(txt_MaHangHoa)) {
			loadKichCoSanPham(txt_MaHangHoa.getText().trim());

		} else if (o.equals(btn_LamMoi)) {
			txt_MaHangHoa.setText("");
			comboBox_KichThuoc.removeAllItems();
			spinner_SoLuong.setValue(1);

		} else if (o.equals(btn_Them)) {
			tinhDiemTichLuy();
			themHangHoa();

		} else if (o.equals(btn_HuyHoaDon)) {
			huyHoaDon();

		} else if (o.equals(btn_ThanhToan)) {
//			tạo 1 hóa đơn mới
			thanhToanHoaDon();

		} else if (o.equals(txt_TienNhan)) {
			tinhTongCacThanhTien();

		} else if (o.equals(txt_VoucherGiamGia)) {
			timThongTinVoucherGiamGia();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			timThongTinKhachHang(txt_SDTKhachHang.getText());
			tinhTongCacThanhTien();
		} else {
			timThongTinKhachHang(txt_SDTKhachHang.getText());
			tinhTongCacThanhTien();
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int selected = table.getSelectedRow();
		if (selected >= 0) {
			ChiTietHoaDon chitiet = listChiTietHD.get(selected);
			txt_MaHangHoa.setText(chitiet.getHangHoa().getMaHangHoa().trim().substring(0, 6));
			spinner_SoLuong.setValue(chitiet.getSoLuong());
			comboBox_KichThuoc.removeAllItems();
			loadKichCoSanPham(txt_MaHangHoa.getText());
			comboBox_KichThuoc.setSelectedItem(chitiet.getHangHoa().getMaHangHoa().substring(6));
			String kt = dao_HangHoa.getKichThuocCuaMotSanPham(txt_MaHangHoa.getText()).get(0);
			comboBox_KichThuoc.addItem(kt);
		}
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		capNhatTienNhan();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		capNhatTienNhan();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		capNhatTienNhan();
	}

	public void switchContent(JPanel newContent) {
//		newContent.setBounds(0, 28, 1350, 701);
		this.removeAll();
		if (currentContent != null) {
			this.remove(currentContent);
			currentContent.requestFocusInWindow();
		}
		currentContent = newContent;

		this.add(currentContent, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

//	Hàm thêm icon vào trong button
	public static JButton createButtonWithIcon(String iconPath, int width, int height) {
		ImageIcon originalIcon = new ImageIcon(iconPath);
		Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JButton button = new JButton(scaledIcon);

		return button;
	}

//	Làm rỗng tất cả dữ liệu
	public void lamRongTrangBanHang() {
//		Làm rỗng dữ liệu bảng
		lbl_NgayLapHD.setText("");
		lbl_NVLapHD.setText("");
		txt_MaHangHoa.setText("");
		modelCombobox.removeAllElements();

	}

	private class ButtonRenderer extends DefaultTableCellRenderer {
		private JButton button;

		public ButtonRenderer() {

			button = new JButton();
			button.setOpaque(true);
			// Thêm biểu tượng vào nút
			Icon deleteIcon = new ImageIcon(
					new ImageIcon("img\\remove.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			button.setIcon(deleteIcon);
			button.setBackground(new Color(255, 255, 255));
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());

			} else {
				button.setForeground(table.getForeground());
			}
			button.setText(value == null ? "" : value.toString());
			return button;
		}
	}

	private class ButtonEditor extends DefaultCellEditor {
		private JButton button;
		private String label;
		private boolean isPushed;
		private int selectedRow;

		public ButtonEditor() {
			super(new JCheckBox());
			button = new JButton();
			button.setOpaque(true);

			// Thêm biểu tượng vào nút
			Icon deleteIcon = new ImageIcon(
					new ImageIcon("img\\remove.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			button.setIcon(deleteIcon);
			button.setBackground(new Color(255, 255, 255));
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			selectedRow = row;
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
			} else {
				button.setForeground(table.getForeground());
			}
			label = (value == null) ? "" : value.toString();
			button.setText(label);
			isPushed = true;
			return button;
		}

		public Object getCellEditorValue() {
			if (isPushed) {
				// Xử lý sự kiện khi nút được nhấn
				int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa !!", "Xác nhận",
						JOptionPane.YES_NO_OPTION);

				if (choice == JOptionPane.YES_OPTION) {
					listChiTietHD.remove(selectedRow);
					tinhTongCacThanhTien();
					tinhDiemTichLuy();
					model.removeHangHoa(selectedRow);
				}

			}
			isPushed = false;
			return label;
		}

		public boolean stopCellEditing() {
			isPushed = false;
			return super.stopCellEditing();
		}

		protected void fireEditingStopped() {
			super.fireEditingStopped();
		}
	}

	public void tinhTongCacThanhTien() {
		double tongTienHang = 0;
		double tongTienThue = 0;
		double tongTienGiamGia = 0;
		double diemTichLuy = 0;
		double tongTienTra = 0;
		// tổng tiền hàng
		for (ChiTietHoaDon chiTietHoaDon : listChiTietHD) {
			tongTienHang += chiTietHoaDon.tinhTongThanhTien();
		}
		// tổng tiền thuế
		tongTienThue = tongTienHang * 0.1;
		lbl_TongTienHang.setText(decimalFormat.format(tongTienHang));
		lbl_Thue.setText(decimalFormat.format(tongTienThue));

		// tổng tiền mã giảm giá;
		vc = dao_VoucherGiamGia.getTheoMaVouCher(txt_VoucherGiamGia.getText().trim());
		if (txt_VoucherGiamGia.getText().trim().equals("")) {
			vc = dao_VoucherGiamGia.getTheoMaVouCher("VC0000");
		}
		hoaDon.setVoucher(vc);
		tongTienGiamGia = (tongTienHang + tongTienThue) * vc.getPhanTramGiamTheoHoaDon();
//		Checkbox điểm tích lũy
//		Chỉ được sử dụng điểm tích lũy để giảm tối đa 1 nửa giá so với hóa đơn
		diemTichLuy = tinhDiemTichLuy();

		if (chckx_DiemTichLuy.isSelected()) {
			tongTienGiamGia += diemTichLuy;
		}

		lbl_TienGiamGia.setText(decimalFormat.format(tongTienGiamGia));

		tongTienTra = tongTienHang + tongTienThue - tongTienGiamGia;
		if (tongTienTra < 0) {
			tongTienTra = 0;
		}
		hoaDon.setTongThanhTien(tongTienTra);

		lbl_TongTienTra.setText(decimalFormat.format(tongTienTra));
		hoaDon.setTongThanhTien(tongTienTra);

		// tiền thừa
		capNhatTienNhan();
	}

	/**
	 * tao 1 hoa đơn mới hoặc lấy thông tin hóa đơn từ hàng chờ
	 * 
	 * @return HoaDon
	 */
	public void taoHoaDon(NhanVien nhanVien, HoaDon hoaDonTruyen) {
		if (hoaDonTruyen != null) {
			nv = nhanVien;
			hoaDon = hoaDonTruyen;
			kh = dao_KhachHang.getKhachHangTheoMa(hoaDon.getKhachHang().getMaKhachHang());
			listChiTietHD = (ArrayList<ChiTietHoaDon>) dao_ChiTietHoaDon.getChiTietTheoMaHoaDon(hoaDon.getMaHoaDon());
			vc = dao_VoucherGiamGia.getTheoMaVouCher(hoaDon.getVoucher().getMaVoucher());
			for (ChiTietHoaDon chiTietHoaDon : listChiTietHD) {
				HangHoa hh = dao_HangHoa.getHangHoaByMaHangHao(chiTietHoaDon.getHangHoa().getMaHangHoa());
				chiTietHoaDon.setHoaDon(hoaDon);
				chiTietHoaDon.setHangHoa(hh);
			}
			if (kh.getMaKhachHang().equals("KH0000"))
				kh = null;
			if (kh.getMaKhachHang().startsWith("KC")) {
				dao_KhachHang.deleteKhachHang(kh.getMaKhachHang());
				kh = null;
			}
			if (vc.getMaVoucher().equals("VC0000"))
				vc = null;
			hoaDon.setKhachHang(kh);
			hoaDon.setVoucher(vc);

			return;
		}
		LocalDate ngayTao = LocalDate.now();

		String sttHoaDon = String.format("%04d", (dao_HoaDon.getHoaDonDuocLapGanNhatTrongNgay(ngayTao.toString()) + 1));
		String maHD = "HD" + ngayTao.toString().replaceAll("-", "") + sttHoaDon;

		hoaDon = new HoaDon(maHD, ngayTao, null, nv, null);

	}

//	Chua tìm dao của sđt
	public void timThongTinKhachHang(String sdt) {
		if (sdt.trim().equals("")) {
			kh = null;
			hoaDon.setKhachHang(kh);
			JOptionPane.showMessageDialog(this, "Vui lòng nhật số điện thoại");
			lbl_TenKhachHang.setText("");
			return;
		}
		kh = dao_KhachHang.getKhachHangTheoSDT(sdt);
		hoaDon.setKhachHang(kh);
		if (kh.getMaKhachHang() == null) {
			JOptionPane.showMessageDialog(this, "Không tồn tại khách hàng có số điện thoại: " + sdt);
			lbl_TenKhachHang.setText("");
			return;
		}

		if (!kh.isTrangThai()) {
			JOptionPane.showMessageDialog(this, "Khách hàng không còn là thành viên nữa");
			lbl_TenKhachHang.setText("");
			return;
		}

		lbl_TenKhachHang.setText(kh.getTenKhachHang());
		tinhDiemTichLuy();
		txt_SDTKhachHang.transferFocus();
	}

	public boolean loadKichCoSanPham(String ma) {
		if (ma.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm!");
			txt_MaHangHoa.selectAll();
			txt_MaHangHoa.requestFocus();
			return false;
		} else {
			if (txt_MaHangHoa.getText().length() < 6) {
				JOptionPane.showMessageDialog(this, "Không tồn tại mã hàng hóa: " + ma);
				txt_MaHangHoa.selectAll();
				txt_MaHangHoa.requestFocus();
				return false;
			}

			List<String> listHH = dao_HangHoa.getKichThuocCuaMotSanPham(ma);
			if (listHH.size() == 0 && dao_HangHoa.getHangHoaByMaHangHao(ma).getMaHangHoa() == null) {
				JOptionPane.showMessageDialog(this, "Không tồn tại mã hàng hóa: " + ma);
				txt_MaHangHoa.selectAll();
				txt_MaHangHoa.requestFocus();
				return false;
			} else {
				if (comboBox_KichThuoc.getSelectedItem() != null)
					return true;
				modelCombobox.removeAllElements();

				for (String string : listHH) {
					modelCombobox.addElement(string);
//					comboBox_KichThuoc.addItem(string);
				}
				txt_MaHangHoa.transferFocus();
			}
		}
		return true;

	}

	public void themHangHoa() {
		boolean ktMaHH = loadKichCoSanPham(txt_MaHangHoa.getText().trim());
		if (!ktMaHH)
			return;
		HangHoa hh = dao_HangHoa
				.getHangHoaByMaHangHao(txt_MaHangHoa.getText().trim() + (String) comboBox_KichThuoc.getSelectedItem());

//		Tạo ra arraylist chi tiết hóa đơn
		int soLuong = (int) spinner_SoLuong.getValue();
		ChiTietHoaDon ct = new ChiTietHoaDon(hh, hoaDon, soLuong, hh.getDonGiaNhap());

//		kiểm tra số lượng hàng tồn
		if (!kiemTraSoLuongHangTon(ct))
			return;

		for (int i = 0; i < listChiTietHD.size(); i++) {
			if (ct.getHangHoa().getMaHangHoa().equals(listChiTietHD.get(i).getHangHoa().getMaHangHoa())) {
				listChiTietHD.set(i, ct);
				model.setHangHoa(i, listChiTietHD.get(i));
				txt_MaHangHoa.setText("");
				tinhTongCacThanhTien();
				comboBox_KichThuoc.removeAllItems();
				spinner_SoLuong.setValue(1);

				return;
			}
		}

		listChiTietHD.add(ct);
		txt_MaHangHoa.setText("");
		model.removeAllHoaDon();
		for (ChiTietHoaDon chiTietHoaDon : listChiTietHD) {
			model.addHangHoa(chiTietHoaDon);
		}

		lbl_DiemTichLuy.setText(decimalFormat.format(tinhDiemTichLuy()));
		tinhTongCacThanhTien();
		comboBox_KichThuoc.removeAllItems();
		spinner_SoLuong.setValue(1);
	}

	public void thanhToanHoaDon() {

		if (lbl_TenKhachHang.getText().equals("")) {
			kh = null;
		}

		if (listChiTietHD.size() == 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn mặt hàng muôn thanh toán!");
			txt_MaHangHoa.requestFocus();
			return;
		}
		if (txt_TienNhan.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Tiền nhận không được rỗng");
			txt_TienNhan.selectAll();
			txt_TienNhan.requestFocus();
			return;
		}
		if (!txt_TienNhan.getText().matches("\\d+")) {
			JOptionPane.showMessageDialog(this, "Tiền nhận bắt buộc phải là số");
			txt_TienNhan.selectAll();
			txt_TienNhan.requestFocus();
			return;
		}
		if (Double.parseDouble(lbl_TienThua.getText().replaceAll(",", "")) < 0) {
			JOptionPane.showMessageDialog(this, "Tiền nhận không đủ vui lòng nhập thêm");
			txt_TienNhan.selectAll();
			txt_TienNhan.requestFocus();
			return;
		}
		int choice = JOptionPane.showConfirmDialog(null,
				"Xác nhận thanh toán: " + lbl_TongTienTra.getText() + " VNĐ \n Tiền thừa: "
						+decimalFormat.format( (hoaDon.getTongThanhTien() - Double.parseDouble(txt_TienNhan.getText()))) + " VNĐ",
				"Xác nhận", JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			hoaDon.setTrangThaiThanhToan(true);
			if (kh == null)
				kh = dao_KhachHang.getKhachHangTheoMa("KH0000");
			if (vc == null)
				vc = dao_VoucherGiamGia.getTheoMaVouCher("VC0000");
			hoaDon.setKhachHang(kh);
			hoaDon.setVoucher(vc);

			boolean themHoaDon = dao_HoaDon.insertHoaDon(hoaDon);

			int i = 0;
			for (ChiTietHoaDon chiTietHoaDon : listChiTietHD) {
				chiTietHoaDon.setThanhTien(chiTietHoaDon.tinhTongThanhTien());
				HangHoa hh = dao_HangHoa.getHangHoaByMaHangHao(chiTietHoaDon.getHangHoa().getMaHangHoa());
				if (!kiemTraSoLuongHangTon(chiTietHoaDon)) {
					table.setRowSelectionInterval(i, i);
					return;
				}
				hh.setSoLuongTon(hh.getSoLuongTon() - chiTietHoaDon.getSoLuong());
				hh.setSoLuongDaBan(hh.getSoLuongDaBan() + chiTietHoaDon.getSoLuong());
				dao_ChiTietHoaDon.insertChiTietHoadon(chiTietHoaDon);
				dao_HangHoa.updateHangHoa(hh);
				i++;
			}

			if (!vc.getMaVoucher().equals("VC0000")) {
				vc.setSoLuotDung(vc.getSoLuotDung() + 1);
				dao_VoucherGiamGia.updateVoucher(vc);
			}
			if (!kh.getMaKhachHang().equals("KH0000")) {
//				Trừ và thêm điểm thành viên
				double diemTichLuy = 0;
				double tongTienHang = 0;
				double tongTienThue = 0;
				double tongTienGiamGia = 0;
				// tổng tiền hàng
				for (ChiTietHoaDon chiTietHoaDon : listChiTietHD) {
					tongTienHang += chiTietHoaDon.tinhTongThanhTien();
				}
				// tổng tiền thuế
				tongTienThue = tongTienHang * 0.1;
				lbl_TongTienHang.setText(decimalFormat.format(tongTienHang));
				lbl_Thue.setText(decimalFormat.format(tongTienThue));
				// tổng tiền mã giảm giá
				tongTienGiamGia = vc.getPhanTramGiamTheoHoaDon();
				if (chckx_DiemTichLuy.isSelected()) {

					diemTichLuy = kh.getDiemTichLuy();
					double tongTienTra = tongTienHang + tongTienThue - tongTienGiamGia;
					if (diemTichLuy > (tongTienTra / 2)) {
						diemTichLuy -= tongTienTra / 2;
					}
				}
				String diemTichLuyTangThem = "" + hoaDon.getTongThanhTien() * 0.001;
				if (diemTichLuyTangThem.contains(".")) {
					diemTichLuyTangThem = diemTichLuyTangThem.split("\\.")[0];
				}

				diemTichLuy += Double.parseDouble(diemTichLuyTangThem);
				if(!kh.isTrangThai())
				kh.setDiemTichLuy((float) diemTichLuy);
				dao_KhachHang.updateKhachHang(kh);
			}
			if (themHoaDon) {
				new FormHoaDon(TrangBanHangJPanel.this, hoaDon).setVisible(true);

			} else {
				JOptionPane.showMessageDialog(this, "Thất bại!!");
				return;
			}
		}
	}

	public void loadToanBoDuLieuTrongHoaDonCho() {
		for (ChiTietHoaDon chiTietHoaDon : listChiTietHD) {
			model.addHangHoa(chiTietHoaDon);
		}
		tinhTongCacThanhTien();
		if (kh == null || kh.getMaKhachHang().equals("KH0000")) {
			txt_SDTKhachHang.setText("");
		} else {
			txt_SDTKhachHang.setText(kh.getSoDienThoai().trim());
		}
		if (kh != null)
			timThongTinKhachHang(txt_SDTKhachHang.getText());
		if (vc == null || vc.getMaVoucher().equals("VC0000"))
			txt_VoucherGiamGia.setText("");
		else
			txt_VoucherGiamGia.setText(vc.getMaVoucher());
		timThongTinVoucherGiamGia();

	}

	public boolean timThongTinVoucherGiamGia() {
		String maGiamGia = txt_VoucherGiamGia.getText().trim();
		VoucherGiamGia voucher = dao_VoucherGiamGia.getTheoMaVouCher(maGiamGia);
		if (maGiamGia.trim().equals(""))
			return false;
		if (voucher == null) {
			JOptionPane.showMessageDialog(this, "Mã giảm giá không hợp lệ");
			txt_VoucherGiamGia.requestFocus();
			txt_VoucherGiamGia.selectAll();
			return false;
		}
		if (voucher.getNgayBatDau().after(new Date())) {
			JOptionPane.showMessageDialog(this, "Voucher này chỉ được sử dụng từ ngày: " + voucher.getNgayBatDau());
			txt_VoucherGiamGia.requestFocus();
			txt_VoucherGiamGia.selectAll();
			return false;
		}
		if (voucher.getNgayKetThuc().before(new Date())) {
			JOptionPane.showMessageDialog(this, "Voucher này đã kết thúc vào ngày: " + voucher.getNgayKetThuc());
			txt_VoucherGiamGia.requestFocus();
			txt_VoucherGiamGia.selectAll();
			return false;
		}
		lbl_TenVoucher.setText(voucher.getTenVoucher());
		lbl_PhanTramGiamGia.setText(voucher.getPhanTramGiamTheoHoaDon() * 100 + " %");

		tinhTongCacThanhTien();
		txt_VoucherGiamGia.transferFocus();
		return true;
	}

	public void capNhatTienNhan() {
		double tienThua = 0;
		if (txt_TienNhan.getText().trim().equals("")) {
			tienThua = 0;
		} else if (!txt_TienNhan.getText().matches("\\d+")) {
			JOptionPane.showMessageDialog(this, "Tiền nhận bắt buộc phải là số");
			return;
		} else
			tienThua = Double.parseDouble(txt_TienNhan.getText().trim());
		lbl_TienThua.setText(decimalFormat.format(tienThua - hoaDon.getTongThanhTien()));
	}

	public double tinhDiemTichLuy() {
		if (kh == null)
			return 0;
		double diemTichLuy = 0;
		diemTichLuy = kh.getDiemTichLuy();
		double tongTienHang = 0;
		double tongTienThue = 0;
		for (ChiTietHoaDon chiTietHoaDon : listChiTietHD) {
			tongTienHang += chiTietHoaDon.tinhTongThanhTien();
		}
		tongTienThue = tongTienHang * 0.1;

		double tongTienGiamGia = 0;
		if (vc != null)
			tongTienGiamGia = vc.getPhanTramGiamTheoHoaDon() * (tongTienHang + tongTienThue);

		double tongTienTra = tongTienHang + tongTienThue - tongTienGiamGia;
		if (diemTichLuy > (tongTienTra / 2)) {
			diemTichLuy = tongTienTra / 2;
		}
		lbl_DiemTichLuy.setText(decimalFormat.format(diemTichLuy));
		return diemTichLuy;
	}

	public void huyHoaDon() {
		int choice = JOptionPane.showConfirmDialog(null,
				"Bạn có chắc muốn hủy hóa đơn đang thanh toán?" + " Nếu tiếp tục sẽ mất dữ liệu đã nhập!", "Xác nhận",
				JOptionPane.YES_NO_OPTION);

		if (choice == JOptionPane.YES_OPTION) {
			if (dao_HoaDon.getHoaDonTheoMa(hoaDon.getMaHoaDon()) != null) {
				for (ChiTietHoaDon chiTietHoaDon : listChiTietHD) {
					dao_ChiTietHoaDon.deleteChiTietHoaDon(chiTietHoaDon.getHoaDon().getMaHoaDon());
				}
				dao_HoaDon.deleteHoaDon(hoaDon.getMaHoaDon());
			}
			switchContent(new TrangBanHangJPanel(nv, null));
		}
	}

	public void taoHangCho() {
		new TrangHangCho(TrangBanHangJPanel.this, hoaDon, listChiTietHD).setVisible(true);
	}

	public boolean kiemTraSoLuongHangTon(ChiTietHoaDon ct) {
		HangHoa hangHoaNhap = dao_HangHoa.getHangHoaByMaHangHao(ct.getHangHoa().getMaHangHoa());
		if (hangHoaNhap.getSoLuongTon() < ct.getSoLuong()) {
			JOptionPane.showMessageDialog(this,
					"Số lượng hàng của mặt hàng " + hangHoaNhap.getTenHangHoa() + " không đủ!");
			txt_MaHangHoa.requestFocus();
			return false;
		}

		return true;
	}

	public void suKienPhimTat() {
		// Đăng ký sự kiện phím tắt
        InputMap inputMap = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "F1");
        actionMap.put("F1", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	huyHoaDon();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "F2");
        actionMap.put("F2", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	taoHangCho();
            }
        });
        
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "F3");
        actionMap.put("F3", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	thanhToanHoaDon();
            }
        });
        
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "F4");
        actionMap.put("F4", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            }
        });
	}
	
	
}
