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
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;

public class TrangBanHangJPanel extends JPanel implements ActionListener, Action, ListSelectionListener, ItemListener {
	private LocalDate ngayLapHD = LocalDate.now();
	private JTextField txt_MaHangHoa;
	private JTextField txt_SDTKhachHang;
	private JTextField txt_TienNhan;

	private JButton btn_TimHoaDon;
	private TrangTimKiemHoaDon trangTimKiemHoaDon;
	private JPanel currentContent;
	private JButton btn_ThongTinKhachHang;
	private JButton btn_HangCho;
	private JLabel lbl_NgayLapHD;
	private JLabel lbl_NVLapHD;
	private JComboBox<String> comboBox_KichThuoc;
	private JButton btn_LamMoi;
	private JButton btn_Them;
	private JLabel lbl_TenKhachHang;
	private JComboBox comboBox_MaGiamGia;
	private JLabel lbl_TongTienHang;
	private JLabel lbl_Thue;
	private JLabel lbl_TienGiamGia;
	private JLabel lbl_TienThua;
	private JLabel lbl_TongTienTra;

	private DefaultComboBoxModel<String> modelCombobox;
	private SpinnerModel model_Spinner;
	private DecimalFormat decimalFormat = new DecimalFormat("#,##0");

	private AbstractTableHoaDon model;
	private JTable table;
	private JSpinner spinner_SoLuong;
	private JButton btn_HuyHoaDon;
	private JButton btn_ThanhToan;

	private NhanVien nv;
	private KhachHang kh = null;
	private VoucherGiamGia vc = null;
	static ArrayList<ChiTietHoaDon> listChiTietHD = new ArrayList<>();
	private List<VoucherGiamGia> listVoucherGiamGia;
	static HoaDon hoaDon;
	private JCheckBox chckx_DiemTichLuy;

	private Dao_HangHoa dao_HangHoa;
	private Dao_VoucherGiamGia dao_VoucherGiamGia;
	private Dao_KhachHang dao_KhachHang;
	private Dao_HoaDon dao_HoaDon;
	private Dao_ChiTietHoaDon dao_ChiTietHoaDon;

	/**
	 * Create the panel.
	 */
	public TrangBanHangJPanel(HoaDon HD_TruyenVao) {

		dao_HangHoa = new Dao_HangHoa();
		dao_VoucherGiamGia = new Dao_VoucherGiamGia();
		dao_KhachHang = new Dao_KhachHang();
		dao_HoaDon = new Dao_HoaDon();
		dao_ChiTietHoaDon = new Dao_ChiTietHoaDon();

		nv = TrangChinhNVBanHang.nv;

		taoHoaDon(HD_TruyenVao);

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
		panel_ThongTinHoaDon.setBounds(0, 43, 525, 135);
		panel_ThongTinHoaDon.setBackground(new Color(255, 255, 255));
		add(panel_ThongTinHoaDon);
		panel_ThongTinHoaDon.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		panel_ThongTinHoaDon.setLayout(null);

//		Label ngày nhập
//		Lấy ngày hiện tại là ngày lập hóa đơn
		JLabel lbl_NgayLap = new JLabel("Ngày lập: ");
		lbl_NgayLap.setFont(new Font("Arial", Font.PLAIN, 18));
		lbl_NgayLap.setBounds(20, 35, 109, 22);
		panel_ThongTinHoaDon.add(lbl_NgayLap);

		lbl_NgayLapHD = new JLabel(ngayLapHD.toString());
		lbl_NgayLapHD.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_NgayLapHD.setBounds(246, 36, 138, 23);
		panel_ThongTinHoaDon.add(lbl_NgayLapHD);

//		label nhân viên
		JLabel lbl_NhanVien = new JLabel("Nhân viên:");
		lbl_NhanVien.setFont(new Font("Arial", Font.PLAIN, 18));
		lbl_NhanVien.setBounds(20, 83, 109, 22);
		panel_ThongTinHoaDon.add(lbl_NhanVien);

		lbl_NVLapHD = new JLabel(nv.getHoTen());
		lbl_NVLapHD.setForeground(new Color(226, 41, 69));
		lbl_NVLapHD.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_NVLapHD.setBounds(246, 84, 152, 23);
		panel_ThongTinHoaDon.add(lbl_NVLapHD);

//		Tạo panel Nhập thông tin của mặt hàng được bán
		JPanel panel_NhapThongTinMatHang = new JPanel();
		panel_NhapThongTinMatHang.setBounds(0, 182, 525, 243);
		panel_NhapThongTinMatHang.setBackground(new Color(255, 255, 255));
		add(panel_NhapThongTinMatHang);
		panel_NhapThongTinMatHang.setBorder(BorderFactory.createTitledBorder("Nhập thông tin mặt hàng"));
		panel_NhapThongTinMatHang.setLayout(null);

//		Nhập mã hàng hóa, không được để rỗng
		JLabel lbl_MaHangHoa = new JLabel("Mã hàng hóa:");
		lbl_MaHangHoa.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_MaHangHoa.setBounds(21, 29, 157, 31);
		panel_NhapThongTinMatHang.add(lbl_MaHangHoa);

		txt_MaHangHoa = new JTextField();
		txt_MaHangHoa.setBounds(236, 29, 243, 31);
		panel_NhapThongTinMatHang.add(txt_MaHangHoa);
		txt_MaHangHoa.setColumns(10);

//		chọn kích thước cho hàng hóa
		JLabel lbl_KichThuoc = new JLabel("Kích thước:");
		lbl_KichThuoc.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_KichThuoc.setBounds(21, 82, 157, 31);
		panel_NhapThongTinMatHang.add(lbl_KichThuoc);

		modelCombobox = new DefaultComboBoxModel<>();
		comboBox_KichThuoc = new JComboBox<>(modelCombobox);
		comboBox_KichThuoc.setBounds(236, 83, 243, 29);
		panel_NhapThongTinMatHang.add(comboBox_KichThuoc);

		JLabel lbl_SoLuong = new JLabel("Số lượng");
		lbl_SoLuong.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_SoLuong.setBounds(21, 140, 157, 31);
		panel_NhapThongTinMatHang.add(lbl_SoLuong);

		// Tạo một SpinnerModel để quy định giá trị ban đầu, giá trị tối thiểu, giá trị
		// tối đa và bước nhảy
		model_Spinner = new SpinnerNumberModel(1, 1, 100, 1);
		spinner_SoLuong = new JSpinner(model_Spinner);
		spinner_SoLuong.setBounds(236, 140, 243, 30);
		panel_NhapThongTinMatHang.add(spinner_SoLuong);

//		

//		2 nút thêm và refresh lại các jtextfield ở trên
//		Tìm hiểu phần button icon để tạo các nút
		btn_LamMoi = createButtonWithIcon("img\\repeat.png", 40, 40);
		btn_LamMoi.setBorderPainted(false); // Bỏ viền
		btn_LamMoi.setBounds(330, 185, 40, 40);
		btn_LamMoi.setBackground(new Color(255, 255, 255));
		panel_NhapThongTinMatHang.add(btn_LamMoi);

		btn_Them = new JButton();
		btn_Them = createButtonWithIcon("img\\plus.png", 40, 40);
		btn_Them.setBorderPainted(false); // Bỏ viền
		btn_Them.setBounds(400, 185, 40, 40);
		btn_Them.setBackground(new Color(255, 255, 255));
		panel_NhapThongTinMatHang.add(btn_Them);

//		tạo panel nhập thông tin khách hàng và tiền nhận
		JPanel panel_KhachHangVaTienNhan = new JPanel();
		panel_KhachHangVaTienNhan.setBounds(0, 430, 525, 249);
		panel_KhachHangVaTienNhan.setBackground(new Color(255, 255, 255));
		add(panel_KhachHangVaTienNhan);
		panel_KhachHangVaTienNhan.setLayout(null);
		panel_KhachHangVaTienNhan.setBorder(BorderFactory.createTitledBorder("Nhập thông tin khách hàng và tiền nhận"));

		JLabel lblNewLabel = new JLabel("Tên khách hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 30, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel);

		lbl_TenKhachHang = new JLabel("");
		lbl_TenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TenKhachHang.setBounds(241, 31, 219, 30);
		panel_KhachHangVaTienNhan.add(lbl_TenKhachHang);

		JLabel lblNewLabel_1 = new JLabel("SĐT:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 72, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel_1);

		txt_SDTKhachHang = new JTextField();
		txt_SDTKhachHang.setBounds(241, 74, 219, 31);
		panel_KhachHangVaTienNhan.add(txt_SDTKhachHang);
		txt_SDTKhachHang.setColumns(10);

		chckx_DiemTichLuy = new JCheckBox("Sử dụng điểm tích lũy");
		chckx_DiemTichLuy.setBackground(new Color(255, 255, 255));
		chckx_DiemTichLuy.setBounds(241, 105, 219, 31);
		;
		panel_KhachHangVaTienNhan.add(chckx_DiemTichLuy);

		JLabel lblNewLabel_2 = new JLabel("Mã giảm giá:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 150, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel_2);

		comboBox_MaGiamGia = new JComboBox();
		comboBox_MaGiamGia.setBounds(241, 150, 219, 31);
		panel_KhachHangVaTienNhan.add(comboBox_MaGiamGia);

		String ngaySuDungVoucher = LocalDate.now().toString();
		listVoucherGiamGia = dao_VoucherGiamGia.getVoucherTheoNgayBatDau_NgayKetThuc(ngaySuDungVoucher);

		comboBox_MaGiamGia.addItem("");
		listVoucherGiamGia.remove(0);
		for (VoucherGiamGia voucher : listVoucherGiamGia) {
			comboBox_MaGiamGia.addItem(voucher.getTenVoucher());
		}

		JLabel lblNewLabel_3 = new JLabel("Tiền nhận:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 197, 194, 31);
		panel_KhachHangVaTienNhan.add(lblNewLabel_3);

		txt_TienNhan = new JTextField();
		txt_TienNhan.setBounds(241, 199, 219, 31);
		panel_KhachHangVaTienNhan.add(txt_TienNhan);
		txt_TienNhan.setColumns(10);

		btn_ThongTinKhachHang = createButtonWithIcon("img\\search.png", 30, 30);
		btn_ThongTinKhachHang.setBackground(new Color(255, 255, 255));
		btn_ThongTinKhachHang.setBorderPainted(false);
		btn_ThongTinKhachHang.setBounds(470, 30, 49, 35);
		panel_KhachHangVaTienNhan.add(btn_ThongTinKhachHang);

//		Tạo panel table chưa danh sách các mặt hàng được bán
		JPanel panel_KhachHangVaTienNhan_1 = new JPanel();
		panel_KhachHangVaTienNhan_1.setBorder(BorderFactory.createTitledBorder("Danh sách mặt hàng được đặt mua"));
		panel_KhachHangVaTienNhan_1.setBounds(530, 41, 810, 409);
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
		panel_KhachHangVaTienNhan_2.setBounds(700, 454, 640, 225);
		panel_KhachHangVaTienNhan_2.setBackground(new Color(255, 255, 255));
		add(panel_KhachHangVaTienNhan_2);
		panel_KhachHangVaTienNhan_2.setLayout(null);

		JPanel panel_TongThanhTien = new JPanel();
		panel_TongThanhTien.setBackground(new Color(143, 211, 237));
		panel_TongThanhTien.setBounds(408, 20, 222, 192);
		panel_KhachHangVaTienNhan_2.add(panel_TongThanhTien);
		panel_TongThanhTien.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Tổng tiền trả:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.BOLD, 22));
		lblNewLabel_4.setBounds(31, 35, 181, 48);
		panel_TongThanhTien.add(lblNewLabel_4);

		lbl_TongTienTra = new JLabel("0");
		lbl_TongTienTra.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TongTienTra.setForeground(new Color(226, 41, 69));
		lbl_TongTienTra.setFont(new Font("Sitka Text", Font.BOLD, 29));
		lbl_TongTienTra.setBounds(0, 70, 181, 75);
		panel_TongThanhTien.add(lbl_TongTienTra);

		JLabel lblNewLabel_6 = new JLabel("VNĐ");
		lblNewLabel_6.setFont(new Font("Sitka Small", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(183, 94, 39, 31);
		panel_TongThanhTien.add(lblNewLabel_6);

		JLabel lblNewLabel_5 = new JLabel("Tổng tiền hàng:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(22, 42, 169, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel("Thuế VAT (10%):");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(22, 92, 169, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Tổng tiền được giảm giá:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(22, 138, 169, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Tiền thừa:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(22, 188, 169, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_9);

		lbl_TongTienHang = new JLabel("0");
		lbl_TongTienHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TongTienHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TongTienHang.setBounds(189, 42, 150, 24);
		panel_KhachHangVaTienNhan_2.add(lbl_TongTienHang);

		lbl_Thue = new JLabel("0");
		lbl_Thue.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Thue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Thue.setBounds(189, 92, 150, 24);
		panel_KhachHangVaTienNhan_2.add(lbl_Thue);

		lbl_TienGiamGia = new JLabel("0");
		lbl_TienGiamGia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TienGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TienGiamGia.setBounds(189, 138, 150, 24);
		panel_KhachHangVaTienNhan_2.add(lbl_TienGiamGia);

		lbl_TienThua = new JLabel("0");
		lbl_TienThua.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TienThua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TienThua.setBounds(189, 188, 150, 24);
		panel_KhachHangVaTienNhan_2.add(lbl_TienThua);

		JLabel lblNewLabel_10 = new JLabel("VNĐ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(349, 42, 36, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("VNĐ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(349, 92, 36, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("VNĐ");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(349, 138, 36, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("VNĐ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(349, 188, 36, 24);
		panel_KhachHangVaTienNhan_2.add(lblNewLabel_13);

		btn_HuyHoaDon = new JButton("Hủy Hóa Đơn");
		btn_HuyHoaDon.setBackground(new Color(226, 41, 69));
		btn_HuyHoaDon.setFont(new Font("Monospaced", Font.BOLD, 18));
		btn_HuyHoaDon.setBounds(530, 465, 163, 50);
		add(btn_HuyHoaDon);

		btn_HangCho = new JButton("Hàng chờ");
		btn_HangCho.setBackground(new Color(245, 114, 27));
		btn_HangCho.setFont(new Font("Monospaced", Font.BOLD, 18));
		btn_HangCho.setBounds(530, 526, 163, 50);
		add(btn_HangCho);

		btn_ThanhToan = new JButton("Thanh toán");
		btn_ThanhToan.setBackground(new Color(34, 176, 45));
		btn_ThanhToan.setFont(new Font("Monospaced", Font.BOLD, 18));
		btn_ThanhToan.setBounds(530, 587, 163, 50);
		add(btn_ThanhToan);
		
		
		if(listChiTietHD.size()>0) {
			loadToanBoDuLieuTrongHoaDonCho();
		}

		trangTimKiemHoaDon = new TrangTimKiemHoaDon(nv);

		btn_TimHoaDon.addActionListener(this);
		btn_ThongTinKhachHang.addActionListener(this);
		btn_HangCho.addActionListener(this);
		btn_LamMoi.addActionListener(this);
		txt_SDTKhachHang.addActionListener(this);
		btn_Them.addActionListener(this);
		btn_HuyHoaDon.addActionListener(this);
		btn_ThanhToan.addActionListener(this);
		txt_MaHangHoa.addActionListener(this);
		table.getSelectionModel().addListSelectionListener(this);
		txt_TienNhan.addActionListener(this);
		comboBox_MaGiamGia.addActionListener(this);

		chckx_DiemTichLuy.addItemListener(this);

		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_TimHoaDon)) {
			switchContent(trangTimKiemHoaDon);

		} else if (o.equals(btn_ThongTinKhachHang)) {
			String sdt = txt_SDTKhachHang.getText();
			timThongTinKhachHang(sdt, true);

		} else if (o.equals(btn_HangCho)) {
			new TrangHangCho().setVisible(true);

		} else if (o.equals(txt_SDTKhachHang)) {
			String sdt = txt_SDTKhachHang.getText();
			timThongTinKhachHang(sdt, false);

		} else if (o.equals(txt_MaHangHoa)) {
			loadKichCoSanPham(txt_MaHangHoa.getText().trim());

		} else if (o.equals(btn_LamMoi)) {
			txt_MaHangHoa.setText("");
			comboBox_KichThuoc.removeAllItems();
			spinner_SoLuong.setValue(1);

		} else if (o.equals(btn_Them)) {
			themHangHoa();

		} else if (o.equals(btn_HuyHoaDon)) {
			int choice = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc muốn hủy hóa đơn đang thanh toán?" + " Nếu tiếp tục sẽ mất dữ liệu đã nhập!",
					"Xác nhận", JOptionPane.YES_NO_OPTION);

			if (choice == JOptionPane.YES_OPTION) {
				switchContent(new TrangBanHangJPanel(null));
			}

		} else if (o.equals(btn_ThanhToan)) {
//			tạo 1 hóa đơn mới
			thanhToanHoaDon();

		} else if (o.equals(txt_TienNhan)) {
			tinhTongCacThanhTien();
		} else if (o.equals(comboBox_MaGiamGia)) {
			tinhTongCacThanhTien();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			timThongTinKhachHang(txt_SDTKhachHang.getText(), false);
			tinhTongCacThanhTien();
		} else {
			timThongTinKhachHang(txt_SDTKhachHang.getText(), false);
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
		// tổng tiền mã giảm giá
		if (comboBox_MaGiamGia.getSelectedIndex() > 0) {
			int comboSelected = comboBox_MaGiamGia.getSelectedIndex() - 1;
			float phanTramDuocGiam = listVoucherGiamGia.get(comboSelected).getPhanTramGiamTheoHoaDon();
			vc = listVoucherGiamGia.get(comboSelected);
			hoaDon.setVoucher(vc);
			tongTienGiamGia = (tongTienHang + tongTienThue) * phanTramDuocGiam;
		}
//		Checkbox điểm tích lũy
//		Chỉ được sử dụng điểm tích lũy để giảm tối đa 1 nửa giá so với hóa đơn
		if (kh != null) {
			if (chckx_DiemTichLuy.isSelected()) {
				diemTichLuy = kh.getDiemTichLuy();
			}
			tongTienTra = tongTienHang + tongTienThue - tongTienGiamGia;
			if (diemTichLuy > (tongTienTra / 2)) {
				diemTichLuy = tongTienTra / 2;
			}
			tongTienGiamGia += diemTichLuy;

		}
		lbl_TienGiamGia.setText(decimalFormat.format(tongTienGiamGia));
		tongTienTra = tongTienHang + tongTienThue - tongTienGiamGia;
		if (tongTienTra < 0) {
			tongTienTra = 0;
		}
		hoaDon.setTongThanhTien(tongTienTra);

		lbl_TongTienTra.setText(decimalFormat.format(tongTienTra));

		// tiền thừa
		double tienThua = 0;
		if (txt_TienNhan.getText().trim().equals("")) {
			tienThua = 0;
		} else if (!txt_TienNhan.getText().matches("\\d+")) {
			JOptionPane.showMessageDialog(this, "Tiền nhận bắt buộc phải là số");
			return;
		} else
			tienThua = Double.parseDouble(txt_TienNhan.getText().trim());
		lbl_TienThua.setText(decimalFormat.format(tienThua - tongTienTra));
	}

	/**
	 * tao 1 hoa đơn mới
	 * 
	 * @return HoaDon
	 */
	public void taoHoaDon(HoaDon hoaDonTruyen) {
		if(hoaDonTruyen!=null) {
			hoaDon = hoaDonTruyen;
			kh = dao_KhachHang.getKhachHangTheoMa(hoaDon.getKhachHang().getMaKhachHang());
			for (ChiTietHoaDon chiTietHoaDon : dao_ChiTietHoaDon.getChiTietTheoMaHoaDon(hoaDon.getMaHoaDon())) {
				listChiTietHD.add(chiTietHoaDon);
			}
			vc = dao_VoucherGiamGia.getTheoMaVouCher(hoaDon.getVoucher().getMaVoucher());
			for (ChiTietHoaDon chiTietHoaDon : listChiTietHD) {
				HangHoa hh = dao_HangHoa
						.getHangHoaByMaHangHao(chiTietHoaDon.getHangHoa().getMaHangHoa());
				chiTietHoaDon.setHangHoa(hh);
			}
			return;
		}
		LocalDate ngayTao = LocalDate.now();

		String sttHoaDon = String.format("%04d", (dao_HoaDon.getHoaDonDuocLapGanNhatTrongNgay(ngayTao.toString()) + 1));
		String maHD = "HD" + ngayTao.toString().replaceAll("-", "") + sttHoaDon;

		hoaDon = new HoaDon(maHD, ngayTao, null, nv, null);
	}

//	Chua tìm dao của sđt
	public void timThongTinKhachHang(String sdt, boolean trangThaiTrangThongtin) {
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
		} else {

			TrangThongTinKhachHang tt = new TrangThongTinKhachHang(kh);
			lbl_TenKhachHang.setText(kh.getTenKhachHang());
			tt.setVisible(trangThaiTrangThongtin);
		}
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

		HangHoa hangHoaNhap = dao_HangHoa.getHangHoaByMaHangHao(ct.getHangHoa().getMaHangHoa());
		if (hangHoaNhap.getSoLuongTon() < ct.getSoLuong()) {
			JOptionPane.showMessageDialog(this, "Số lượng hàng không đủ!");
			txt_MaHangHoa.requestFocus();
			return;
		}

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
		
//		model.addHangHoa(ct);
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
		int choice = JOptionPane.showConfirmDialog(null, "Xác nhận thanh toán: " + lbl_TongTienTra.getText() + " VNĐ",
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

			for (ChiTietHoaDon chiTietHoaDon : listChiTietHD) {
				chiTietHoaDon.setThanhTien(chiTietHoaDon.tinhTongThanhTien());
				HangHoa hh = dao_HangHoa.getHangHoaByMaHangHao(chiTietHoaDon.getHangHoa().getMaHangHoa());
				hh.setSoLuongTon(hh.getSoLuongTon() - chiTietHoaDon.getSoLuong());
				dao_ChiTietHoaDon.insertChiTietHoadon(chiTietHoaDon);
				dao_HangHoa.updateHangHoa(hh);
			}

			if (!vc.getMaVoucher().equals("VC0000")) {
				vc.setSoLuotDung(vc.getSoLuotDung() + 1);
				dao_VoucherGiamGia.updateVoucher(vc);
			}
			if (!kh.getMaKhachHang().equals("KH0000")) {
//				Trừ và thêm điểm thành viên
				double diemTichLuy = 0;
				double tongTienHang =0;
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
					}else diemTichLuy = 0;
				}
				diemTichLuy+=(long) hoaDon.getTongThanhTien()*0.001;
				kh.setDiemTichLuy((float) diemTichLuy);
				dao_KhachHang.updateKhachHang(kh);
			}
			if (themHoaDon) {
				JOptionPane.showMessageDialog(this, "Thanh toán thành công và tiến hành in hóa đơn");
				xuatHoaDonRaiFile();

			} else {
				JOptionPane.showMessageDialog(this, "Thất bại!!");
				return;
			}

		}

//		
	}

	public void xuatHoaDonRaiFile() {
//			Xuất hóa đơn
		try {
			// Tạo một đối tượng FileWriter để ghi vào tệp tin

			// sau sẽ thay bằng mã hóa đơn
			LocalDateTime ngayHT = LocalDateTime.now();
			String maHoaDon = hoaDon.getMaHoaDon();
			FileWriter writer = new FileWriter("hoaDon\\" + maHoaDon + ".txt");
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

			// Ghi nội dung hóa đơn vào tệp tin
			bufferedWriter.write("               Cửa hàng quần áo TRENDY");
			bufferedWriter.newLine();
			bufferedWriter.write("   Địa chỉ: 12 Nguyễn Văn Bảo, p4, Q.Gò Vấp, TPHCM");
			bufferedWriter.newLine();
			bufferedWriter.write("------------------------------------------------------");
			bufferedWriter.newLine();
			bufferedWriter.write("|                      HÓA ĐƠN                       |");
			bufferedWriter.newLine();
			bufferedWriter.write("------------------------------------------------------");
			bufferedWriter.newLine();
			bufferedWriter.write("Cửa hàng quần áo Trendy");
			bufferedWriter.newLine();
			// ... (Ghi các thông tin khác tương tự)

			// Đóng BufferedWriter
			bufferedWriter.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		JOptionPane.showMessageDialog(this, "Xác nhận đã xuất hóa đơn!");
		switchContent(new TrangBanHangJPanel(null));
	}

	public void loadToanBoDuLieuTrongHoaDonCho() {
		model.removeAllHoaDon();
		ArrayList<ChiTietHoaDon> listChiTiet = new ArrayList<ChiTietHoaDon>();
		for (ChiTietHoaDon ct : listChiTietHD) {
			
			listChiTiet.add(ct);
		}
//		txt_SDTKhachHang.setText(kh.getSoDienThoai());
//		comboBox_MaGiamGia.setSelectedItem(vc.getMaVoucher().trim());
//		tinhTongCacThanhTien();
	}
	
}
