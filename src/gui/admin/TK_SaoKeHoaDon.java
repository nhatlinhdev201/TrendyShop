package gui.admin;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import com.toedter.calendar.JDateChooser;
import daos.Dao_ThongKeDoanhThu;
import entities.HoaDon;
import entities.NhanVien;
import services.SaoKeHoaDonServices;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TK_SaoKeHoaDon extends JPanel implements ActionListener {
	private JTextField txtSoHoaDonDuocLap;
	private JTable tblHoaDon;
	private JTextField txtSoHoaDonDaThanhToan;
	private JTextField txtSoHoaDonChuaThanhToan;
	private JDateChooser jdcChonNgayThongKe;
	private JButton btnThongKe;
	private JButton btnLamMoi;
	private JButton btnXuatSaoKe;
	private JComboBox<String> cbxNhanVien;
	private DefaultTableModel modelTable;
	private ArrayList<HoaDon> dataThongKe;
	private String[] cols = { "Mã hóa đơn", "Thời gian tạo", "Tổng tiền (vnđ)", "Voucher", "Khách hàng", "Nhân Viên",
			"Trạng thái TT" };
	private String[] nhanVien;

	/**
	 * Create the panel.
	 */
	public TK_SaoKeHoaDon() {
		setBackground(new Color(245, 255, 250));
		this.setBounds(0, 0, 1350, 640);
		setLayout(null);

		String iconPath_thongKe = "/images/pick-icon.png";
		ImageIcon iconThongKe = new ImageIcon(this.getClass().getResource(iconPath_thongKe));
		Image scaledIconThongKe = iconThongKe.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		ImageIcon resizedIconThongKe = new ImageIcon(scaledIconThongKe);

		String iconPath_capnhat = "/images/updated.png";
		ImageIcon iconCapNhat = new ImageIcon(this.getClass().getResource(iconPath_capnhat));
		Image scaledIconCapNhat = iconCapNhat.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		ImageIcon resizedIconCapNhat = new ImageIcon(scaledIconCapNhat);

		String iconPath_timKiem = "/images/icon-search.png";
		ImageIcon iconTimKiem = new ImageIcon(this.getClass().getResource(iconPath_timKiem));
		Image scaledIconTimKiem = iconTimKiem.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		ImageIcon resizedIconTimKiem = new ImageIcon(scaledIconTimKiem);

		String iconPath_excel = "/images/excel-icon.png";
		ImageIcon iconExcel = new ImageIcon(this.getClass().getResource(iconPath_excel)); 
		Image scaledIconExcel = iconExcel.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); 
		ImageIcon resizedIconExcel = new ImageIcon(scaledIconExcel);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ - SAO KÊ HÓA ĐƠN");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(540, 11, 288, 30);
		add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 46, 1330, 5);
		add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(20, 62, 380, 556);
		add(panel_1);
		panel_1.setLayout(null);

		jdcChonNgayThongKe = new JDateChooser();
		jdcChonNgayThongKe.setBounds(131, 29, 212, 30);
		panel_1.add(jdcChonNgayThongKe);

		JLabel lblThongKeNgay = new JLabel("Thống kê ngày :");
		lblThongKeNgay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThongKeNgay.setBounds(10, 29, 150, 30);
		panel_1.add(lblThongKeNgay);

		btnThongKe = new JButton("Thống kê");
		btnThongKe.setBackground(Color.GREEN);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThongKe.setIcon(resizedIconThongKe);
		btnThongKe.setBounds(131, 135, 212, 35);
		btnThongKe.addActionListener(this);
		panel_1.add(btnThongKe);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(Color.ORANGE);
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLamMoi.setIcon(resizedIconCapNhat);
		btnLamMoi.setBounds(131, 181, 212, 35);
		btnLamMoi.addActionListener(this);
		panel_1.add(btnLamMoi);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 242, 347, 3);
		panel_1.add(panel_3);

		JLabel lblSHan = new JLabel("Số hóa đơn được lập :");
		lblSHan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSHan.setBounds(10, 282, 166, 30);
		panel_1.add(lblSHan);

		txtSoHoaDonDuocLap = new JTextField();
		txtSoHoaDonDuocLap.setBounds(176, 282, 75, 30);
		panel_1.add(txtSoHoaDonDuocLap);
		txtSoHoaDonDuocLap.setColumns(10);

		JLabel lblHan = new JLabel("Hóa đơn");
		lblHan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHan.setBounds(261, 282, 96, 30);
		panel_1.add(lblHan);

		txtSoHoaDonDaThanhToan = new JTextField();
		txtSoHoaDonDaThanhToan.setColumns(10);
		txtSoHoaDonDaThanhToan.setBounds(176, 337, 75, 30);
		panel_1.add(txtSoHoaDonDaThanhToan);

		JLabel lblThanhTon = new JLabel("Đã thanh toán :");
		lblThanhTon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThanhTon.setBounds(10, 337, 166, 30);
		panel_1.add(lblThanhTon);

		JLabel lblHan_1 = new JLabel("Hóa đơn");
		lblHan_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHan_1.setBounds(261, 337, 96, 30);
		panel_1.add(lblHan_1);

		txtSoHoaDonChuaThanhToan = new JTextField();
		txtSoHoaDonChuaThanhToan.setColumns(10);
		txtSoHoaDonChuaThanhToan.setBounds(176, 396, 75, 30);
		panel_1.add(txtSoHoaDonChuaThanhToan);

		JLabel lblChaThanhTon = new JLabel("Chưa thanh toán :");
		lblChaThanhTon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChaThanhTon.setBounds(10, 396, 166, 30);
		panel_1.add(lblChaThanhTon);

		JLabel lblHan_2 = new JLabel("Hóa đơn");
		lblHan_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHan_2.setBounds(261, 396, 96, 30);
		panel_1.add(lblHan_2);

		btnXuatSaoKe = new JButton("Xuất sao kê ngày");
		btnXuatSaoKe.setBackground(Color.ORANGE);
		btnXuatSaoKe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXuatSaoKe.setIcon(resizedIconExcel);
		btnXuatSaoKe.setBounds(89, 491, 200, 40);
		btnXuatSaoKe.addActionListener(this);
		panel_1.add(btnXuatSaoKe);

		JLabel lblNhnVin = new JLabel("Nhân viên : ");
		lblNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNhnVin.setBounds(10, 81, 122, 30);
		panel_1.add(lblNhnVin);

		cbxNhanVien = new JComboBox();
		cbxNhanVien.setBackground(Color.WHITE);
		cbxNhanVien.setBounds(131, 79, 212, 30);
		panel_1.add(cbxNhanVien);
		cbxNhanVien.addActionListener(this);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(410, 62, 930, 556);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblDanhSchHa = new JLabel("DANH SÁCH HÓA ĐƠN TRONG NGÀY");
		lblDanhSchHa.setForeground(Color.RED);
		lblDanhSchHa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDanhSchHa.setBounds(360, 11, 317, 30);
		panel_2.add(lblDanhSchHa);

		JPanel panelTableHoaDon = new JPanel();
		panelTableHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTableHoaDon.setBounds(10, 59, 910, 486);
		panel_2.add(panelTableHoaDon);
		panelTableHoaDon.setLayout(new BorderLayout(0, 0));

		modelTable = new DefaultTableModel(cols, 0);
		tblHoaDon = new JTable(modelTable);
		
		panelTableHoaDon.add(new JScrollPane(tblHoaDon), BorderLayout.CENTER);
		JTableHeader header = tblHoaDon.getTableHeader();
		header.setPreferredSize(new Dimension(header.getWidth(), 40));
		header.setBackground(Color.cyan);
		tblHoaDon.setRowHeight(40);
		for (int i = 1; i < cols.length; i++) {
			TableColumn column = tblHoaDon.getColumnModel().getColumn(i);
			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setHorizontalAlignment(SwingConstants.RIGHT);
			column.setCellRenderer(renderer);
		}
		tblHoaDon.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tblHoaDon.getSelectedRow();
				if (selectedRow != -1) {
					String ma = (String) tblHoaDon.getValueAt(selectedRow, 1);
				}
				;
			}
		});

		lamMoiCbx();
		lamMoiNgay(jdcChonNgayThongKe);
		Dao_ThongKeDoanhThu dao = new Dao_ThongKeDoanhThu();
		dataThongKe = dao.getHoaDonTheoNgay(layNgayDuocChon(jdcChonNgayThongKe));
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_1.setBounds(10, 461, 347, 3);
		panel_1.add(panel_3_1);
		loadDuLieu(dataThongKe);
		loadDataToTable(modelTable, dataThongKe);

	}

	public void lamMoiDanhSachHoaDonTrongNgay(LocalDate ngayThongKe, ArrayList<HoaDon> data) {
		Dao_ThongKeDoanhThu dao = new Dao_ThongKeDoanhThu();
		data = dao.getHoaDonTheoNgay(ngayThongKe);
	}

	private LocalDate layNgayDuocChon(JDateChooser chooser) {
		Date date = chooser.getDate();
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private void lamMoiNgay(JDateChooser chooser) {
		Calendar ngayHienTai = Calendar.getInstance();
		chooser.setDate(ngayHienTai.getTime());
	}

	public ArrayList<HoaDon> locTheoNhanVien(String nhanVien, ArrayList<HoaDon> data) {
		ArrayList<HoaDon> result = new ArrayList<>();
		for (HoaDon hd : data) {
			if (hd.getNguoiLapHoaDon().getMaNhanVien().toLowerCase().trim().equals(nhanVien.toLowerCase().trim())) {
				result.add(hd);
			}
		}
		return result;
	}

	public String ChuyenThanhTien(double money) {
		long roundedMoney = Math.round(money);
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String formattedMoney = decimalFormat.format(roundedMoney);
		return formattedMoney;
	}

	public void loadDataToTable(DefaultTableModel model, ArrayList<HoaDon> data) {
		model.setRowCount(0);
		for (HoaDon hd : data) {
			model.addRow(new Object[] { hd.getMaHoaDon().toString().trim(), hd.getThoiGianTao().toString(),
					ChuyenThanhTien(hd.getTongThanhTien()),
					hd.getVoucher().getMaVoucher().trim().equals("VC0000") ? "Không"
							: hd.getVoucher().getMaVoucher().trim(),
					hd.getKhachHang().getMaKhachHang().trim().equals("KH0000") ? "Không"
							: hd.getKhachHang().getMaKhachHang().trim(),
					hd.getNguoiLapHoaDon().getMaNhanVien().trim(),
					hd.isTrangThaiThanhToan() ? "Đã thanh toán" : "Chưa thanh toán" });
		}
	}

	public void layDuLieuThongKe() {
		String selected = (String) cbxNhanVien.getSelectedItem();
		if (selected.trim().equals("Tất cả")) {
			Dao_ThongKeDoanhThu dao = new Dao_ThongKeDoanhThu();
			dataThongKe = dao.getHoaDonTheoNgay(layNgayDuocChon(jdcChonNgayThongKe));
			loadDuLieu(dataThongKe);
			loadDataToTable(modelTable, dataThongKe);
		} else {
			Dao_ThongKeDoanhThu dao = new Dao_ThongKeDoanhThu();
			dataThongKe = dao.getHoaDonTheoNgay(layNgayDuocChon(jdcChonNgayThongKe));
			dataThongKe = locTheoNhanVien(selected, dataThongKe);
			loadDuLieu(dataThongKe);
			loadDataToTable(modelTable, dataThongKe);
		}
	}

	public int tinhSoHoaDonDaThanhToan(ArrayList<HoaDon> data) {
		int d = 0;
		for (HoaDon hd : data) {
			if (hd.isTrangThaiThanhToan()) {
				d += 1;
			}
		}
		return d;
	}

	public void loadDuLieu(ArrayList<HoaDon> data) {
		int soHd = data.size();
		int soHdTT = tinhSoHoaDonDaThanhToan(data);
		txtSoHoaDonDuocLap.setText(ChuyenThanhTien(soHd));
		txtSoHoaDonDaThanhToan.setText(ChuyenThanhTien(soHdTT));
		txtSoHoaDonChuaThanhToan.setText(ChuyenThanhTien(soHd - soHdTT));
	}

	public void lamMoiCbx() {
		Dao_ThongKeDoanhThu dao = new Dao_ThongKeDoanhThu();
		ArrayList<NhanVien> dsNhanVien = dao.layDanhSachNhanVien();
		cbxNhanVien.addItem("Tất cả");
		if (dsNhanVien.size() > 0) {
			for (NhanVien nv : dsNhanVien) {
				cbxNhanVien.addItem(nv.getMaNhanVien().trim());
			}
		} else {
			System.out.println("Không có nhân viên");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThongKe)) {
			layDuLieuThongKe();
		} else if(o.equals(btnLamMoi)) {
			lamMoiNgay(jdcChonNgayThongKe);
			Dao_ThongKeDoanhThu dao = new Dao_ThongKeDoanhThu();
			dataThongKe = dao.getHoaDonTheoNgay(layNgayDuocChon(jdcChonNgayThongKe));
			loadDuLieu(dataThongKe);
			loadDataToTable(modelTable, dataThongKe);
		} else if(o.equals(btnXuatSaoKe)) {
			SaoKeHoaDonServices services = new SaoKeHoaDonServices();
			if (services.xuatFileSaoKe(dataThongKe,"DuLieuThongKe\\"+"SaoKeDoanhThuNgay"+layNgayDuocChon(jdcChonNgayThongKe)+ ".xlsx" )) {
				JOptionPane.showMessageDialog(this, "Dữ liệu đã được lưu tại DuLieuThongKe\\" + "SaoKeDoanhThuNgay"+layNgayDuocChon(jdcChonNgayThongKe).toString()+".xlsx");
			} else {
				JOptionPane.showMessageDialog(this, "Lỗi không thể tạo thống kê !");
			}
		}
	}
}
