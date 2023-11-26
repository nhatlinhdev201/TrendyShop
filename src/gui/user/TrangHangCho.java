package gui.user;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import daos.Dao_ChiTietHoaDon;
import daos.Dao_HoaDon;
import daos.Dao_KhachHang;
import daos.Dao_NhanVien;
import daos.Dao_VoucherGiamGia;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;

import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TrangHangCho extends JFrame implements ActionListener {
	private JTextField txt_SDT;
	private JButton btn_Thoat;
	private JButton btn_ThanhToan;
	private JButton btn_ThemHangCho;
	private JButton btn_TimHangCho;

	private AbstractTableHangCho model;
	private JTable table;
	private List<KhachHang> list_KhachHangCho = new ArrayList<>();
	private KhachHang khSelected = null;
	private List<HoaDon> list_HoaDon;
	private HoaDon hoaDonChoThem;
	private ArrayList<ChiTietHoaDon> listDSChiTietHoaDonChoThem;

	private Dao_HoaDon dao_HoaDon;
	private Dao_KhachHang dao_KhachHang;
	private Dao_VoucherGiamGia dao_VoucherGiamGia;
	private Dao_ChiTietHoaDon dao_ChiTiet;
	private Dao_NhanVien dao_NhanVien;
	private TrangBanHangJPanel trangBanHang;

	/**
	 * Create the panel.
	 */
	public TrangHangCho(TrangBanHangJPanel trangBanHangJPanel, HoaDon hoaDonChoXuLy,
			ArrayList<ChiTietHoaDon> danhSachChiTietHoaDonChoXuLy) {

		dao_HoaDon = new Dao_HoaDon();
		dao_KhachHang = new Dao_KhachHang();
		dao_VoucherGiamGia = new Dao_VoucherGiamGia();
		dao_ChiTiet = new Dao_ChiTietHoaDon();
		dao_NhanVien = new Dao_NhanVien();

		trangBanHang = trangBanHangJPanel;
		hoaDonChoThem = hoaDonChoXuLy;
		listDSChiTietHoaDonChoThem = danhSachChiTietHoaDonChoXuLy;

		setSize(500, 444);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);

		JLabel lblNewLabel = new JLabel("Hàng chờ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 464, 37);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(32, 57, 154, 24);
		getContentPane().add(lblNewLabel_1);

		txt_SDT = new JTextField();
		txt_SDT.setBounds(208, 59, 229, 25);
		getContentPane().add(txt_SDT);
		txt_SDT.setColumns(10);

		btn_Thoat = new JButton("Thoát");
		btn_Thoat.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btn_Thoat.setBackground(new Color(237, 140, 135));
		btn_Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Thoat.setBounds(10, 95, 89, 23);
		getContentPane().add(btn_Thoat);

		btn_TimHangCho = new JButton("Tìm");
		btn_TimHangCho.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btn_TimHangCho.setBackground(new Color(153, 188, 247));
		btn_TimHangCho.setBounds(108, 95, 89, 23);
		getContentPane().add(btn_TimHangCho);

		btn_ThemHangCho = new JButton("Thêm hàng chờ");
		btn_ThemHangCho.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btn_ThemHangCho.setBackground(new Color(156, 228, 154));
		btn_ThemHangCho.setBounds(206, 95, 139, 23);
		getContentPane().add(btn_ThemHangCho);

		btn_ThanhToan = new JButton("Thanh toán");
		btn_ThanhToan.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btn_ThanhToan.setBackground(new Color(0, 210, 0));
		btn_ThanhToan.setBounds(355, 95, 115, 23);
		getContentPane().add(btn_ThanhToan);

		JPanel panel = new JPanel();
		panel.setBounds(10, 140, 464, 254);
		getContentPane().add(panel);

		model = new AbstractTableHangCho();
		table = new JTable(model);
		table.setRowHeight(40);
		table.setFont(new Font("Monospaced", Font.PLAIN, 17));
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(270);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.setShowGrid(false);

		table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
		table.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor());
		panel.add(new JScrollPane(table), BorderLayout.CENTER);

		list_HoaDon = dao_HoaDon.getHoaDonChuaThanhToan();
		for (HoaDon hoaDon : list_HoaDon) {
			list_KhachHangCho.add(dao_KhachHang.getKhachHangTheoMa(hoaDon.getKhachHang().getMaKhachHang()));
		}

		for (KhachHang khachHang : list_KhachHangCho) {
			model.addHangCho(khachHang);
		}
		if (hoaDonChoXuLy.getKhachHang() != null)
			txt_SDT.setText(
					dao_KhachHang.getKhachHangTheoMa(hoaDonChoXuLy.getKhachHang().getMaKhachHang()).getSoDienThoai());

//		
		btn_Thoat.addActionListener(this);
		btn_ThanhToan.addActionListener(this);
		btn_ThemHangCho.addActionListener(this);
		btn_TimHangCho.addActionListener(this);

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
				txt_SDT.setText(list_KhachHangCho.get(row).getSoDienThoai());
				timHoaDonDuocChon();

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
					xoaHangCho(selectedRow);
					model.removeHangCho(selectedRow);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_Thoat)) {
			this.dispose();
		} else if (o.equals(btn_TimHangCho)) {
			timHangCho();
		} else if (o.equals(btn_ThemHangCho)) {
			if (!timSoDienThoaiTrungVoiHangCho())
				return;
			themHangCho();
		} else if (o.equals(btn_ThanhToan)) {
			HoaDon hoaDon = timHoaDonDuocChon();
			if (hoaDon == null)
				return;
			NhanVien nv = dao_NhanVien.getNhanVienTheoMa(hoaDon.getNguoiLapHoaDon().getMaNhanVien());
			trangBanHang.switchContent(new TrangBanHangJPanel(nv, hoaDon));

			this.dispose();

		}
	}

	public void timHangCho() {
		String sdt = txt_SDT.getText();
		model.removeAllHangCho();
		if (sdt.equals("")) {
			for (KhachHang khachHang : list_KhachHangCho) {
				model.addHangCho(khachHang);
			}
			return;
		}

		for (KhachHang khachHang : list_KhachHangCho) {
			if (sdt.trim().equals(khachHang.getSoDienThoai())) {
				khSelected = khachHang;
			}
		}
		if (khSelected == null) {
			JOptionPane.showMessageDialog(this, "Không tìm thấy hàng chờ có số điện thoại: " + sdt);
			return;
		}
		model.addHangCho(khSelected);

	}

	public boolean kiemTraSDT() {
		if (!txt_SDT.getText().matches("^(\\+84)\\d{9}$") && !txt_SDT.getText().matches("^(0)\\d{9}$")) {
			JOptionPane.showMessageDialog(this,
					"Só điện thoại phải là số bắt đầu là +84XXXXXXXXX hoặc 0XXXXXXXXX. X là chữ số");
			txt_SDT.requestFocus();
			return false;
		}
		return true;
	}

	public void themHangCho() {
		String sdt = txt_SDT.getText().trim();
		if (sdt.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại");
			txt_SDT.requestFocus();
			return;
		}
		if (!kiemTraSDT()) {
			return;
		}
		KhachHang khThem = null;

		ArrayList<ChiTietHoaDon> list_ChiTietHoaDonCho = listDSChiTietHoaDonChoThem;
		HoaDon hoaDonHangCho = hoaDonChoThem;
		khThem = dao_KhachHang.getKhachHangTheoSDT(sdt);
		if(khThem==null) {
			khThem = hoaDonHangCho.getKhachHang();
		}
		
		if (khThem == null) {
			khThem = new KhachHang();
			khThem.setMaKhachHang("KC" + String.format("%04d", dao_KhachHang.getKhachHangChoGanNhat() + 1));
			khThem.setSoDienThoai(sdt);
			khThem.setDiaChi("");
			khThem.setEmail("");
			khThem.setTenKhachHang("");
			dao_KhachHang.themKhachHang(khThem);
		}
		if (!txt_SDT.getText().trim().equals(khThem.getSoDienThoai())) {
			JOptionPane.showMessageDialog(this,
					"Do khách hàng đã là thành viên nên không được nhập số điện thoại khác");
			txt_SDT.setText(
					dao_KhachHang.getKhachHangTheoMa(hoaDonChoThem.getKhachHang().getMaKhachHang()).getSoDienThoai());
			txt_SDT.requestFocus();
			return;
		}
		hoaDonHangCho.setKhachHang(khThem);
		if (hoaDonHangCho.getVoucher() == null)
			hoaDonHangCho.setVoucher(dao_VoucherGiamGia.getTheoMaVouCher("VC0000"));

		boolean trangThaiThem = dao_HoaDon.insertHoaDon(hoaDonHangCho);
		for (ChiTietHoaDon chiTietHoaDon : list_ChiTietHoaDonCho) {
			dao_ChiTiet.insertChiTietHoadon(chiTietHoaDon);
		}
		if (trangThaiThem)
			JOptionPane.showMessageDialog(this, "Thêm hàng chờ thành công");
		list_HoaDon.add(hoaDonHangCho);
		list_KhachHangCho.add(khThem);
		model.addHangCho(khThem);
	}

	public void xoaHangCho(int selected) {
		HoaDon hoaDon = list_HoaDon.get(selected);
		KhachHang khachHang = list_KhachHangCho.get(selected);

		String maHD = hoaDon.getMaHoaDon();
		dao_ChiTiet.deleteChiTietHoaDon(maHD);
		dao_HoaDon.deleteHoaDon(maHD);
		if (khachHang.getMaKhachHang().substring(0, 2).equals("KC"))
			dao_KhachHang.deleteKhachHang(khachHang.getMaKhachHang());
		list_HoaDon.remove(selected);
		list_KhachHangCho.remove(selected);

	}

	public boolean timSoDienThoaiTrungVoiHangCho() {
		for (KhachHang khachHang : list_KhachHangCho) {
			if (txt_SDT.getText().trim().equals(khachHang.getSoDienThoai())) {
				JOptionPane.showMessageDialog(this, "Số điện thoại " + txt_SDT.getText().trim()
						+ " đã được sử dụng cho 1 hàng chờ trước đó. nên không thể thêm!");
				txt_SDT.requestFocus();
				return false;
			}
		}
		return true;
	}

	public HoaDon timHoaDonDuocChon() {
		if (table.getSelectedRow() >= 0)
			return list_HoaDon.get(table.getSelectedRow());
		else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng chờ bạn muốn thanh toán");
			return null;
		}
	}
}
