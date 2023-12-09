package gui.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import constance.SetBountJPanel;
import daos.Dao_ChiTietHoaDon;
import daos.Dao_HangHoa;
import daos.Dao_HoaDon;
import daos.Dao_KhachHang;
import daos.Dao_NhaCungCap;
import daos.Dao_NhanVien;
import daos.Dao_VoucherGiamGia;
import entities.ChiTietHoaDon;
import entities.HangHoa;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import entities.VoucherGiamGia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class TrangTimKiemHoaDon extends JPanel implements ActionListener{
	private JTextField txt_MaHoaDon;
	private JTextField txt_SDT;
	private JTextField txt_maNV;
	private JPanel currentContent;
	private JButton btn_LapHoaDon;
//	private TrangBanHangJPanel trangBanHang;
	private JButton btn_Tim;
	private JPanel panel_2;
	private Dao_HoaDon dao_HoaDon;
	private Dao_ChiTietHoaDon dao_ChiTietHoaDon;
	private Dao_NhanVien dao_NhanVien;
	private Dao_KhachHang dao_KhachHang;
	private Dao_VoucherGiamGia dao_Voucher;
	private Dao_HangHoa dao_HangHoa;
	private Dao_NhaCungCap Dao_NhaCungCap;

	private DecimalFormat decimalFormat = new DecimalFormat("#,##0");
	private JDateChooser dateChooser_TuNgay;
	private JDateChooser dateChooser_DenNgay;
	private NhanVien nv_DangNhap;
	private JButton btn_LamMoi;

	/**
	 * Create the panel.
	 */
	public TrangTimKiemHoaDon(NhanVien nhanVienDangNhap) {
		dao_HoaDon = new Dao_HoaDon();
		dao_ChiTietHoaDon = new Dao_ChiTietHoaDon();
		dao_NhanVien = new Dao_NhanVien();
		dao_KhachHang = new Dao_KhachHang();
		dao_Voucher = new Dao_VoucherGiamGia();
		dao_HangHoa = new Dao_HangHoa();
		Dao_NhaCungCap = new Dao_NhaCungCap();

		nv_DangNhap = nhanVienDangNhap;

		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);

		JPanel menu = new JPanel();
		menu.setBounds(0, 0, 1370, 43);
		add(menu);
		menu.setLayout(null);
		btn_LapHoaDon = new JButton("Lập hóa đơn");
		btn_LapHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		btn_LapHoaDon.setBackground(new Color(255, 255, 255));
		btn_LapHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_LapHoaDon.setBounds(0, 0, 187, 43);
		menu.add(btn_LapHoaDon);

//		Button tÃ¬m kiáº¿m hÃ³a Ä‘Æ¡n
		JButton btn_TimHoaDon = new JButton("Tìm kiếm hóa đơn");
		btn_TimHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_TimHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		btn_TimHoaDon.setBackground(new Color(39, 224, 224));
		btn_TimHoaDon.setBounds(184, 0, 229, 43);
		menu.add(btn_TimHoaDon);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(158, 226, 173));
		panel.setBounds(0, 40, 1350, 661);
		add(panel);
		panel.setLayout(null);

		JLabel lbl_title = new JLabel("TÌM KIẾM HÓA ĐƠN");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Monospaced", Font.BOLD, 28));
		lbl_title.setBounds(10, 0, 1330, 45);
		panel.add(lbl_title);

//		mÃ£ hÃ³a Ä‘Æ¡n
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(15, 57, 220, 45);
		panel.add(panel_1);
		panel_1.setBorder(BorderFactory.createTitledBorder("Mã hóa đơn"));
		panel_1.setLayout(null);

		txt_MaHoaDon = new JTextField();
		txt_MaHoaDon.setForeground(new Color(0, 0, 0));
		txt_MaHoaDon.setBounds(10, 14, 200, 25);
		panel_1.add(txt_MaHoaDon);
		txt_MaHoaDon.setColumns(10);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(BorderFactory.createTitledBorder("SDT khách hàng"));
		panel_1_1.setBounds(245, 57, 220, 45);
		panel.add(panel_1_1);

		txt_SDT = new JTextField();
		txt_SDT.setForeground(Color.BLACK);
		txt_SDT.setColumns(10);
		txt_SDT.setBounds(10, 14, 200, 25);
		panel_1_1.add(txt_SDT);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(BorderFactory.createTitledBorder("Mã nhân viên"));
		panel_1_2.setBounds(475, 57, 220, 45);
		panel.add(panel_1_2);

		txt_maNV = new JTextField();
		txt_maNV.setForeground(Color.BLACK);
		txt_maNV.setColumns(10);
		txt_maNV.setBounds(10, 14, 200, 25);
		panel_1_2.add(txt_maNV);

		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBorder(BorderFactory.createTitledBorder("Từ ngày"));
		panel_1_3.setBounds(705, 57, 220, 45);
		panel.add(panel_1_3);

		dateChooser_TuNgay = new JDateChooser();
		dateChooser_TuNgay.setDateFormatString("dd/MM/yyyy");
		dateChooser_TuNgay.setBounds(10, 14, 200, 25);
		panel_1_3.add(dateChooser_TuNgay);

		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBorder(BorderFactory.createTitledBorder("Đến ngày"));
		panel_1_4.setBounds(935, 56, 220, 45);
		panel.add(panel_1_4);

		dateChooser_DenNgay = new JDateChooser();
		dateChooser_DenNgay.setDateFormatString("dd/MM/yyyy");
		dateChooser_DenNgay.setBounds(10, 14, 200, 25);
		panel_1_4.add(dateChooser_DenNgay);

		btn_Tim = new JButton("Tìm (F1)");
		btn_Tim.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn_Tim.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Tim.setBackground(new Color(131, 198, 252));
		btn_Tim.setBounds(1164, 56, 73, 46);
		panel.add(btn_Tim);

		btn_LamMoi = new JButton("Làm mới (F2)");
		btn_LamMoi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn_LamMoi.setHorizontalAlignment(SwingConstants.LEFT);
		btn_LamMoi.setBackground(new Color(131, 198, 252));
		btn_LamMoi.setBounds(1246, 56, 93, 46);
		panel.add(btn_LamMoi);

		hienThiThongTinHoaDon(panel);

		List<HoaDon> listAllHoaDon = new ArrayList<HoaDon>();
		for(HoaDon hoadon: dao_HoaDon.getAll().stream().limit(5).collect(Collectors.toList())) {
			if(hoadon.isTrangThaiThanhToan()) listAllHoaDon.add(hoadon);
		}
//		for(HoaDon hoadon: dao_HoaDon.getAll()) {
//			if(hoadon.isTrangThaiThanhToan()) listAllHoaDon.add(hoadon);
//		}
		
		DanhSachHoaDon(listAllHoaDon);
		
		btn_LapHoaDon.addActionListener(this);
		btn_Tim.addActionListener(this);
		btn_LamMoi.addActionListener(this);
		txt_MaHoaDon.addActionListener(this);
		txt_SDT.addActionListener(this);
		txt_maNV.addActionListener(this);
		
		suKienPhimTat();

	}

	private void switchContent(JPanel newContent) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_LapHoaDon)) {
			switchContent(new TrangBanHangJPanel(null, null));
		} else if (o.equals(btn_Tim)) {
			timKiemHoaDon();
		} else if (o.equals(btn_LamMoi)) {
			txt_MaHoaDon.setText("");
			txt_maNV.setText("");
			txt_SDT.setText("");
			dateChooser_TuNgay.setDate(null);
			dateChooser_DenNgay.setDate(null);
		} else if (o.equals(txt_MaHoaDon)) {
			txt_MaHoaDon.transferFocus();
		} else if (o.equals(txt_SDT)) {
			txt_SDT.transferFocus();
		} else if (o.equals(txt_maNV)) {
			txt_maNV.transferFocus();
		}
	}

	public void DanhSachHoaDon(List<HoaDon> listHoaDon) {
		setPanelChiTietHoaDon();

		JPanel p = new JPanel();
		p.setLayout(new GridBagLayout());
		p.setBackground(new Color(255, 255, 255));
		panel_2.add(p);
		GridBagConstraints c = new GridBagConstraints();

		for (int j = 0; j < listHoaDon.size(); j++) {
			JPanel panel = new JPanel();
			panel.setLayout(new GridBagLayout());
			GridBagConstraints c2 = new GridBagConstraints();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(new Color(255, 255, 255));

//          c.fill = GridBagConstraints.BOTH;
			c.fill = GridBagConstraints.NONE;
			c.ipadx = 5;
			c.weightx = 1.0;
			c.weighty = 1.0;
			c.insets = new Insets(10, 5, 0, 0);
			c.gridx = 0;
			c.gridy = j;
			p.add(panel, c);
			HoaDon hd = listHoaDon.get(j);
			if (!hd.isTrangThaiThanhToan())
				continue;
			KhachHang kh = dao_KhachHang.getKhachHangTheoMa(hd.getKhachHang().getMaKhachHang());
			VoucherGiamGia voucher = dao_Voucher.getTheoMaVouCher(hd.getVoucher().getMaVoucher());

			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(255, 228, 202));
			panel_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128)));
			panel_3.setBounds(29, 11, 1224, 130);
//    		panel.add(panel_3);
			panel_3.setLayout(null);

			JLabel lblNewLabel = new JLabel("Mã hóa đơn:");
			lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
			lblNewLabel.setBounds(10, 11, 175, 27);
			panel_3.add(lblNewLabel);

			JLabel lbl_MaHoaDon = new JLabel("");
			lbl_MaHoaDon.setText(hd.getMaHoaDon());
			lbl_MaHoaDon.setFont(new Font("Monospaced", Font.BOLD, 17));
			lbl_MaHoaDon.setBounds(178, 11, 190, 27);
			panel_3.add(lbl_MaHoaDon);

			JLabel lblNewLabel_3 = new JLabel("Nhân viên:");
			lblNewLabel_3.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lblNewLabel_3.setBounds(10, 49, 118, 20);
			panel_3.add(lblNewLabel_3);

			JLabel lbl_NhanVien = new JLabel("");
			lbl_NhanVien
					.setText(dao_NhanVien.getTenNhanVienTheoMa(hd.getNguoiLapHoaDon().getMaNhanVien()));
			lbl_NhanVien.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lbl_NhanVien.setBounds(120, 49, 163, 20);
			panel_3.add(lbl_NhanVien);

			JLabel lblNewLabel_5 = new JLabel("Thuế:");
			lblNewLabel_5.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lblNewLabel_5.setBounds(10, 80, 118, 20);
			panel_3.add(lblNewLabel_5);

			JLabel lbl_Thue = new JLabel("");
			lbl_Thue.setText("10%");
			lbl_Thue.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lbl_Thue.setBounds(120, 80, 163, 20);
			panel_3.add(lbl_Thue);

			JLabel lblNewLabel_7 = new JLabel("Khách hàng:");
			lblNewLabel_7.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lblNewLabel_7.setBounds(322, 49, 133, 20);
			panel_3.add(lblNewLabel_7);

			JLabel lblNewLabel_8 = new JLabel("Mã giảm giá:");
			lblNewLabel_8.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lblNewLabel_8.setBounds(322, 80, 133, 20);
			panel_3.add(lblNewLabel_8);

			JLabel lblNewLabel_9 = new JLabel("SĐT khách hàng:");
			lblNewLabel_9.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lblNewLabel_9.setBounds(619, 49, 133, 20);
			panel_3.add(lblNewLabel_9);

			JLabel lbl_KhachHang = new JLabel("");
			lbl_KhachHang.setText(kh.getTenKhachHang());
			lbl_KhachHang.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lbl_KhachHang.setBounds(420, 49, 170, 20);
			panel_3.add(lbl_KhachHang);

			JLabel lbl_SDT = new JLabel(kh.getSoDienThoai());
			lbl_SDT.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lbl_SDT.setBounds(750, 49, 133, 20);
			panel_3.add(lbl_SDT);

			JLabel lblLblngaylap = new JLabel("Ngày lập:");
			lblLblngaylap.setHorizontalAlignment(SwingConstants.RIGHT);
			lblLblngaylap.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lblLblngaylap.setBounds(991, 10, 100, 20);
			panel_3.add(lblLblngaylap);

			JLabel lbl_NgayLap = new JLabel("");
			LocalDate ngayLap = hd.getThoiGianTao();
			lbl_NgayLap.setText(ngayLap.getDayOfMonth() + "-" + ngayLap.getMonthValue() + "-" + ngayLap.getYear());
			lbl_NgayLap.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lbl_NgayLap.setBounds(1112, 10, 109, 20);
			panel_3.add(lbl_NgayLap);

			c2.fill = GridBagConstraints.NONE;
			c2.anchor = GridBagConstraints.WEST;
			c2.ipadx = 1220;
			c2.ipady = 138;
			c2.insets = new Insets(5, 5, 0, 0); // CÃ¡c khoáº£ng trá»‘ng
			c2.gridwidth = 1;
			c2.gridx = 0;
			c2.gridy = 0;
			panel.add(panel_3, c2);

			List<ChiTietHoaDon> listChiTietHoaDon = dao_ChiTietHoaDon
					.getChiTietTheoMaHoaDon(hd.getMaHoaDon());
			double tongTienHang = 0;

			for (int i = 0; i < listChiTietHoaDon.size(); i++) {
				ChiTietHoaDon ct = listChiTietHoaDon.get(i);
				HangHoa hh = dao_HangHoa.getHangHoaByMaHangHao(ct.getHangHoa().getMaHangHoa());

				JPanel panel_4 = new JPanel();
				panel_4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
				panel_4.setBackground(new Color(255, 255, 255));
				panel_4.setSize(1224, 138);
				panel_4.setLayout(null);

				JPanel panel_5 = new JPanel();
				panel_5.setBounds(10, 11, 100, 120);
				panel_5.setBackground(new Color(255, 255, 255));
				// Đọc hình ảnh từ file hoặc URL
				ImageIcon originalIcon = new ImageIcon(hh.getHinhAnh());

				int originalWidth = originalIcon.getIconWidth();
				int originalHeight = originalIcon.getIconHeight();


				int newWidth = 100;
				int newHeight = 120;

				
				Image scaledImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

				
				ImageIcon scaledIcon = new ImageIcon(scaledImage);

				// Táº¡o JLabel Ä‘á»ƒ hiá»ƒn thá»‹ hÃ¬nh áº£nh
				JLabel label = new JLabel(scaledIcon);

				// ThÃªm JLabel vÃ o panel
				panel_5.add(label, BorderLayout.CENTER);

				panel_4.add(panel_5);

				JLabel lblNewLabel_2 = new JLabel(hh.getTenHangHoa());
				lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 17));
				lblNewLabel_2.setBounds(128, 0, 271, 30);
				panel_4.add(lblNewLabel_2);

				JLabel lblNewLabel_4 = new JLabel("Mã hàng:");
				lblNewLabel_4.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lblNewLabel_4.setBounds(138, 30, 100, 20);
				panel_4.add(lblNewLabel_4);

				JLabel lblNewLabel_4_1 = new JLabel("Kích thước:");
				lblNewLabel_4_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lblNewLabel_4_1.setBounds(138, 61, 100, 20);
				panel_4.add(lblNewLabel_4_1);

				JLabel lblNewLabel_4_2 = new JLabel("Xuất xứ:");
				lblNewLabel_4_2.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lblNewLabel_4_2.setBounds(138, 95, 100, 20);
				panel_4.add(lblNewLabel_4_2);

				JLabel lblNewLabel_4_5 = new JLabel("Số lượng:");
				lblNewLabel_4_5.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lblNewLabel_4_5.setBounds(448, 30, 100, 20);
				panel_4.add(lblNewLabel_4_5);

				JLabel lbl_MaHang = new JLabel(hh.getMaHangHoa().trim());
				lbl_MaHang.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lbl_MaHang.setBounds(248, 30, 116, 20);
				panel_4.add(lbl_MaHang);

				JLabel lbl_KichThuoc = new JLabel(hh.getKichCo());
				lbl_KichThuoc.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lbl_KichThuoc.setBounds(248, 61, 116, 20);
				panel_4.add(lbl_KichThuoc);

				JLabel lbl_XuatXu = new JLabel(hh.getXuatXu());
				lbl_XuatXu.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lbl_XuatXu.setBounds(248, 95, 116, 20);
				panel_4.add(lbl_XuatXu);

				JLabel lbl_SoLuong = new JLabel("" + ct.getSoLuong());
				lbl_SoLuong.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lbl_SoLuong.setBounds(568, 30, 116, 20);
				panel_4.add(lbl_SoLuong);

				JLabel lblNewLabel_4_3 = new JLabel("Màu sắc:");
				lblNewLabel_4_3.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lblNewLabel_4_3.setBounds(448, 65, 100, 20);
				panel_4.add(lblNewLabel_4_3);

				JLabel lblNewLabel_4_4 = new JLabel("Nhà cung cấp:");
				lblNewLabel_4_4.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lblNewLabel_4_4.setBounds(448, 95, 110, 20);
				panel_4.add(lblNewLabel_4_4);

				JLabel lbl_NhaCungCap = new JLabel(hh.getMaNhaCungCap().trim());
				lbl_NhaCungCap.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lbl_NhaCungCap.setBounds(568, 95, 183, 20);
				panel_4.add(lbl_NhaCungCap);

				JLabel lblNewLabel_4_6 = new JLabel("Giá bán:");
				lblNewLabel_4_6.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lblNewLabel_4_6.setBounds(776, 95, 100, 20);
				panel_4.add(lblNewLabel_4_6);

				JLabel lblNewLabel_4_7 = new JLabel("Chất liệu:");
				lblNewLabel_4_7.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lblNewLabel_4_7.setBounds(776, 65, 100, 20);
				panel_4.add(lblNewLabel_4_7);

				JLabel lbl_ChatLieu = new JLabel(hh.getChatLieu());
				lbl_ChatLieu.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lbl_ChatLieu.setBounds(872, 65, 139, 20);
				panel_4.add(lbl_ChatLieu);

				JLabel lbl_GiaBan = new JLabel(decimalFormat.format(ct.getGiaBan()));
				lbl_GiaBan.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_GiaBan.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lbl_GiaBan.setBounds(872, 95, 139, 20);
				panel_4.add(lbl_GiaBan);

				JLabel lblNewLabel_4_10 = new JLabel("VNĐ");
				lblNewLabel_4_10.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lblNewLabel_4_10.setBounds(1026, 95, 56, 20);
				panel_4.add(lblNewLabel_4_10);

				JLabel lbl_MauSac = new JLabel(hh.getMauSac());
				lbl_MauSac.setFont(new Font("Monospaced", Font.PLAIN, 13));
				lbl_MauSac.setBounds(568, 65, 183, 20);
				panel_4.add(lbl_MauSac);

				c2.fill = GridBagConstraints.NONE;
				c2.anchor = GridBagConstraints.WEST;
				c2.ipadx = 1220;
				c2.ipady = 138;
				c2.insets = new Insets(5, 5, 0, 0); // CÃ¡c khoáº£ng trá»‘ng
				c2.gridwidth = 1;
				c2.gridx = 0;
				c2.gridy = i + 1;
				panel.add(panel_4, c2);

				tongTienHang += ct.getGiaBan() * ct.getSoLuong();
			}

			JPanel panel_6 = new JPanel();
			panel_6.setBounds(29, 301, 1224, 130);
			panel_6.setBackground(new Color(255, 255, 255));
//    		panel_2.add(panel_6);
			panel_6.setLayout(null);

			JLabel lblNewLabel_4_5 = new JLabel("Tổng tiền hàng:");
			lblNewLabel_4_5.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lblNewLabel_4_5.setBounds(28, 11, 205, 20);
			panel_6.add(lblNewLabel_4_5);

			JLabel lbl_TongTienHang = new JLabel(decimalFormat.format(tongTienHang));
			lbl_TongTienHang.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_TongTienHang.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lbl_TongTienHang.setBounds(266, 11, 129, 20);
			panel_6.add(lbl_TongTienHang);

			JLabel lblNewLabel_4_10_1 = new JLabel("VNĐ");
			lblNewLabel_4_10_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lblNewLabel_4_10_1.setBounds(402, 11, 56, 20);
			panel_6.add(lblNewLabel_4_10_1);

			JLabel lblNewLabel_4_12 = new JLabel("Tổng tiền thuế:");
			lblNewLabel_4_12.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lblNewLabel_4_12.setBounds(28, 36, 205, 20);
			panel_6.add(lblNewLabel_4_12);

			JLabel lbl_TongTienThue = new JLabel(decimalFormat.format(tongTienHang * 0.1));
			lbl_TongTienThue.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_TongTienThue.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lbl_TongTienThue.setBounds(266, 36, 129, 20);
			panel_6.add(lbl_TongTienThue);

			JLabel lblNewLabel_4_10_2 = new JLabel("VNĐ");
			lblNewLabel_4_10_2.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lblNewLabel_4_10_2.setBounds(402, 36, 56, 20);
			panel_6.add(lblNewLabel_4_10_2);

			JLabel lblNewLabel_4_12_1 = new JLabel("Tổng tiền giảm giá:");
			lblNewLabel_4_12_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lblNewLabel_4_12_1.setBounds(28, 60, 205, 20);
			panel_6.add(lblNewLabel_4_12_1);

			JLabel lbl_TongTienGiamGia = new JLabel("0");
			if (voucher != null)
				lbl_TongTienGiamGia.setText(decimalFormat.format(tongTienHang * (voucher.getPhanTramGiamTheoHoaDon())));
			lbl_TongTienGiamGia.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_TongTienGiamGia.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lbl_TongTienGiamGia.setBounds(266, 60, 129, 20);
			panel_6.add(lbl_TongTienGiamGia);

			JLabel lblNewLabel_4_10_2_1 = new JLabel("VNĐ");
			lblNewLabel_4_10_2_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
			lblNewLabel_4_10_2_1.setBounds(402, 60, 56, 20);
			panel_6.add(lblNewLabel_4_10_2_1);

			JLabel lblNewLabel_4_14 = new JLabel("Tổng tiền thanh toán:");
			lblNewLabel_4_14.setFont(new Font("Monospaced", Font.PLAIN, 16));
			lblNewLabel_4_14.setBounds(28, 91, 225, 20);
			panel_6.add(lblNewLabel_4_14);

			JLabel lbl_TongTienThanhToan = new JLabel(decimalFormat.format(hd.getTongThanhTien()));
			lbl_TongTienThanhToan.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_TongTienThanhToan.setForeground(new Color(236, 109, 91));
			lbl_TongTienThanhToan.setFont(new Font("Monospaced", Font.BOLD, 20));
			lbl_TongTienThanhToan.setBounds(253, 91, 142, 20);
			panel_6.add(lbl_TongTienThanhToan);

			JLabel lblNewLabel_4_10_3 = new JLabel("VNĐ");
			lblNewLabel_4_10_3.setForeground(new Color(236, 109, 91));
			lblNewLabel_4_10_3.setFont(new Font("Monospaced", Font.PLAIN, 16));
			lblNewLabel_4_10_3.setBounds(402, 91, 56, 20);
			panel_6.add(lblNewLabel_4_10_3);

			c2.fill = GridBagConstraints.NONE;
			c2.anchor = GridBagConstraints.WEST;
			c2.ipadx = 1220;
			c2.ipady = 138;
			c2.insets = new Insets(5, 5, 0, 0); // CÃ¡c khoáº£ng trá»‘ng
			c2.gridwidth = 1;
			c2.gridx = 0;
			c2.gridy = 5 + 1;
			panel.add(panel_6, c2);
		}
		panel_2.setLayout(new BorderLayout());
		JScrollPane jsc = new JScrollPane(p);
		jsc.getVerticalScrollBar().setUnitIncrement(20);
		panel_2.add(jsc);
	}

	public JPanel hienThiThongTinHoaDon(JPanel panel) {
//		Panel hiá»ƒn thá»‹ thÃ´ng tin chi tiáº¿t cá»§a hÃ³a Ä‘Æ¡n cáº§n tÃ¬m
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_2.setBounds(30, 122, 1287, 528);
		panel.add(panel_2);
		return panel_2;
	}

	public void setPanelChiTietHoaDon() {
		panel_2.removeAll();
		panel_2.revalidate();
		panel_2.repaint();

	}

	public void timKiemHoaDon() {
		String maHD = txt_MaHoaDon.getText().trim();
		String soDienThoai = txt_SDT.getText().trim();
		String ma_NV = txt_maNV.getText().trim();
		Date tuNgay = dateChooser_TuNgay.getDate();
		Date denNgay = dateChooser_DenNgay.getDate();
		
		

		List<HoaDon> dsHD = null;
		if (!maHD.trim().equals("")) {
			if(!maHD.trim().matches("^[a-zA-Z0-9]+$")) {
				JOptionPane.showMessageDialog(this, "Mã hóa dơn chỉ có thể là các kí tự chữ và số");
				txt_MaHoaDon.selectAll();
				txt_MaHoaDon.requestFocus();
				return;
			}
//			
			List<HoaDon> dsHoaDon = dao_HoaDon.getHoaDonTheoMa(maHD);
			if (dsHoaDon.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn có mã: " + maHD);
				
			}
			DanhSachHoaDon(dsHoaDon);
			return;
		}

		dsHD = dao_HoaDon.getAll();
		if (ma_NV.equals("") && soDienThoai.equals("") && ma_NV.equals("") && tuNgay == null && denNgay == null) {
			DanhSachHoaDon(dsHD);
			return;
		}
		if (!soDienThoai.equals("")) {
			if(!soDienThoai.matches("^(0)\\d{9}$")) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải là số");
				txt_SDT.selectAll();
				txt_SDT.requestFocus();
				return;
			}
			KhachHang kh = dao_KhachHang.getKhachHangTheoSDT(soDienThoai);

			List<HoaDon> ds = new ArrayList<>();
			for (HoaDon hoaDon : dsHD) {
				if (kh.getMaKhachHang() == null)
					break;
				if (kh.getMaKhachHang().equals(hoaDon.getKhachHang().getMaKhachHang())) {
					ds.add(hoaDon);
				}
			}
			if (ds.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn có SĐT khách hàng là : " + soDienThoai);
				setPanelChiTietHoaDon();
				return;
			}
			dsHD = ds;
		}

		if (!ma_NV.equals("")) {
			if(!ma_NV.matches("^[a-zA-Z0-9]+$")) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên chỉ có thể là các kí tự chữ và số");
				txt_maNV.selectAll();
				txt_maNV.requestFocus();
				return;
			}
			List<HoaDon> ds = new ArrayList<>();
			for (HoaDon hoaDon : dsHD) {
				if (ma_NV.equals(hoaDon.getNguoiLapHoaDon().getMaNhanVien())) {
					ds.add(hoaDon);
				}
			}
			if (ds.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn có mã nhân viên: " + ma_NV);
				setPanelChiTietHoaDon();
				return;
			}
			dsHD = ds;
		}

		if (tuNgay == null && denNgay != null) {
			JOptionPane.showMessageDialog(this, "Phải nhập ngày bắt đầu");
			dateChooser_TuNgay.requestFocus();
			return;
		} else if (tuNgay != null && denNgay == null) {
			JOptionPane.showMessageDialog(this, "Phải nhập ngày kết thúc");
			dateChooser_DenNgay.requestFocus();
			return;
		} else if (tuNgay != null && denNgay != null) {
			if (tuNgay.compareTo(denNgay) >= 0) {
				JOptionPane.showMessageDialog(this, "Ngày kết thúc phải lớn hơn ngày bắt đầu");
				return;
			} else if (tuNgay.compareTo(new Date()) >= 0) {
				JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải nhỏ hơn ngày hiện tại");
				return;
			}
			List<HoaDon> ds = new ArrayList<>();
			for (HoaDon hoaDon : dsHD) {
				Date thoiGianTao = Date.from(hoaDon.getThoiGianTao().atStartOfDay(ZoneId.systemDefault()).toInstant());
				if (tuNgay.compareTo(thoiGianTao) < 0 && denNgay.compareTo(thoiGianTao) >= 0) {
					ds.add(hoaDon);
				}
			}
			if (ds.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn từ dữ liệu trên ");
				setPanelChiTietHoaDon();
				return;
			}
			dsHD = ds;
		}

		DanhSachHoaDon(dsHD);

	}
	
	public void suKienPhimTat() {
		// Đăng ký sự kiện phím tắt
        InputMap inputMap = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "F1");
        actionMap.put("F1", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
    			timKiemHoaDon();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "F2");
        actionMap.put("F2", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	txt_MaHoaDon.setText("");
    			txt_maNV.setText("");
    			txt_SDT.setText("");
    			dateChooser_TuNgay.setDate(null);
    			dateChooser_DenNgay.setDate(null);
            }
        });
        
	}
	
}
