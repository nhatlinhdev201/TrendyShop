package gui.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import daos.Dao_Voucher;
import daos.Dao_NhaCungCap;
import daos.Dao_Voucher;
import entities.HangHoa;
import entities.NhaCungCap;
import entities.VoucherGiamGia;
import javax.swing.SpinnerNumberModel;

public class FormThongTinVoucher extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_Ten;
	private JTextArea txtMoTa;
	private JButton btn_Save;
	private JLabel lbl_CurentTrangThai;
	private VoucherGiamGia voucher;
	private Dao_Voucher dao_Voucher;
	private JCheckBox ckb_kichhoat;
	private File sr;
	private JSpinner spn_PhanTramGiamGia;
	private JSpinner spn_SoLuotDung;
	private static File a;
	private String newMa;
	private VoucherGiamGia voucherOld;
//	private HashMap<String, Integer> listSize;
	private JPanel pnl_NgayBatDau;
	private JLabel lblNgayKetThuc;
	private JLabel lblNgayBatDau;
	private JDateChooser dateBatDau;
	private JDateChooser dateKetThuc;

	public FormThongTinVoucher(VoucherGiamGia vc, String cvThucThi) {
		if (cvThucThi.equals("edit")) {
			System.out.println(vc);
			voucher = vc;
		}
//		listSize = new HashMap<String, Integer>();
		setBackground(new Color(102, 205, 170));
		setLayout(null);
		voucherOld = vc;
		dao_Voucher = new Dao_Voucher();
		this.voucher = vc;
		setPreferredSize(new Dimension(761, 406));

		JPanel pnl_InfoVoucher = new JPanel();
		pnl_InfoVoucher.setBackground(new Color(102, 205, 170));
		pnl_InfoVoucher.setBounds(27, 28, 705, 338);
		add(pnl_InfoVoucher);
		pnl_InfoVoucher.setLayout(null);

		JLabel lbl_Ten = new JLabel("Tên Voucher:");
		lbl_Ten.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_Ten.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_Ten.setBounds(10, 61, 100, 20);
		pnl_InfoVoucher.add(lbl_Ten);

		txt_Ten = new JTextField();
		txt_Ten.setBounds(144, 56, 187, 25);
		pnl_InfoVoucher.add(txt_Ten);
		txt_Ten.setColumns(10);

		JLabel lbl_PhanTramGiamGia = new JLabel("Phần trăm giảm giá:");
		lbl_PhanTramGiamGia.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_PhanTramGiamGia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_PhanTramGiamGia.setBounds(10, 102, 120, 20);
		pnl_InfoVoucher.add(lbl_PhanTramGiamGia);

		JLabel lbl_SoLuotDung = new JLabel("Số lượt dùng");
		lbl_SoLuotDung.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_SoLuotDung.setBounds(10, 143, 100, 20);
		pnl_InfoVoucher.add(lbl_SoLuotDung);

		JLabel lbl_MoTa = new JLabel("Mô tả:");
		lbl_MoTa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_MoTa.setBounds(10, 207, 100, 109);
		pnl_InfoVoucher.add(lbl_MoTa);

		txtMoTa = new JTextArea();
		txtMoTa.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtMoTa.setLineWrap(true);
		txtMoTa.setBounds(111, 207, 557, 114);
		pnl_InfoVoucher.add(txtMoTa);

		JLabel lbl_TrangThai = new JLabel("Trạng Thái:");
		lbl_TrangThai.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_TrangThai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_TrangThai.setBounds(10, 177, 120, 20);
		pnl_InfoVoucher.add(lbl_TrangThai);

		lbl_CurentTrangThai = new JLabel("Đang hoạt động");
		lbl_CurentTrangThai.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_CurentTrangThai.setForeground(Color.RED);
		lbl_CurentTrangThai.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_CurentTrangThai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_CurentTrangThai.setBounds(140, 177, 120, 20);
		pnl_InfoVoucher.add(lbl_CurentTrangThai);

		ckb_kichhoat = new JCheckBox("Kích hoạt lại.");
		ckb_kichhoat.setBackground(new Color(102, 205, 170));
		ckb_kichhoat.setFont(new Font("Tahoma", Font.BOLD, 12));
		ckb_kichhoat.setBounds(272, 177, 120, 21);
		pnl_InfoVoucher.add(ckb_kichhoat);
		if (!vc.isTrangThai()) {
			ckb_kichhoat.setVisible(false);
		}

		spn_PhanTramGiamGia = new JSpinner();
		spn_PhanTramGiamGia.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spn_PhanTramGiamGia.setBounds(144, 97, 187, 25);
		pnl_InfoVoucher.add(spn_PhanTramGiamGia);

		spn_SoLuotDung = new JSpinner();
		spn_SoLuotDung.setBounds(144, 138, 187, 25);
		pnl_InfoVoucher.add(spn_SoLuotDung);

		lblNgayBatDau = new JLabel("Ngày bắt đầu");
		lblNgayBatDau.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayBatDau.setBounds(412, 63, 100, 20);
		pnl_InfoVoucher.add(lblNgayBatDau);

		lblNgayKetThuc = new JLabel("Ngày kết thúc");
		lblNgayKetThuc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayKetThuc.setBounds(412, 99, 100, 30);
		pnl_InfoVoucher.add(lblNgayKetThuc);

		JLabel lblNewLabel = new JLabel("Nhập Thông Tin Voucher");
		lblNewLabel.setForeground(new Color(193, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(267, 0, 234, 46);
		pnl_InfoVoucher.add(lblNewLabel);

		dateKetThuc = new JDateChooser();
		dateKetThuc.setDateFormatString("dd-MM-y");
		dateKetThuc.setBounds(522, 97, 155, 25);
		pnl_InfoVoucher.add(dateKetThuc);

		dateBatDau = new JDateChooser();
		dateBatDau.setDateFormatString("dd-MM-y");
		dateBatDau.setBounds(522, 56, 155, 25);
		pnl_InfoVoucher.add(dateBatDau);

		btn_Save = new JButton("Thêm Voucher");
		btn_Save.setBackground(new Color(250, 250, 210));
		btn_Save.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Save.setFocusable(false);
		btn_Save.setBounds(539, 371, 150, 25);
		add(btn_Save);
		btn_Save.addActionListener(this);

		if (cvThucThi.equals("edit")) {
			setText(vc);
			btn_Save.setText("Lưu Thay Đổi");
			newMa = vc.getMaVoucher();
		} else {
			lbl_CurentTrangThai.setVisible(false);
			ckb_kichhoat.setVisible(false);
		}
	}

	/**
	 * Lấy dữ liệu và chỉnh sửa thông tin hàng hóa
	 * 
	 * @param vc
	 */
	public void setText(VoucherGiamGia vc) {
		txt_Ten.setText(vc.getTenVoucher());
		spn_PhanTramGiamGia.setValue(vc.getPhanTramGiamTheoHoaDon() * 100);
		txtMoTa.setText(vc.getMoTaChuongTrinh());
		spn_SoLuotDung.setValue(vc.getSoLuotDung());
		lbl_CurentTrangThai.setText(vc.isTrangThai() ? "Đang hoạt động" : "Đã ngưng");

		ckb_kichhoat.setVisible(!vc.isTrangThai());
		ckb_kichhoat.setSelected(false);

		dateBatDau.setDate(vc.getNgayBatDau());
		dateKetThuc.setDate(vc.getNgayKetThuc());
	}

	/**
	 * Đặt lại các giá trị trong các texfiled
	 */
	public void reText() {
		txt_Ten.setText("");
		spn_PhanTramGiamGia.setValue(0);
		txtMoTa.setText("");
		spn_SoLuotDung.setValue(0);
		dateBatDau.setDate(null);
		dateKetThuc.setDate(null);

	}

	/**
	 * trả về chuỗi mã voucher
	 * 
	 * @param ma
	 * @return
	 */
	public String createMaVoucher(String ma) {
		System.out.println("sàasfa");
		System.out.println(ma.substring(2));

		int id = Integer.parseInt(ma.substring(2));
		if (id < 9) {
			id++;
			return "VC000" + id;
		} else if (id < 99) {
			id++;
			return "VC00" + id;
		} else if (id < 999) {
			id++;
			return "VC0" + id;
		}
		id++;
		return "VC" + id;
	}

	private String formatDate(java.util.Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return (date != null) ? sdf.format(date) : "";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_Save)) {
			String tenVoucher = txt_Ten.getText().trim();
			float phanTramGiamGia = (float) Float.parseFloat(spn_PhanTramGiamGia.getValue().toString()) / 100;
			String moTa = txtMoTa.getText().trim();
			int soLuotDung = (int) spn_SoLuotDung.getValue();
			boolean trangThai = ckb_kichhoat.isSelected();
			Date ngayBatDau = dateBatDau.getDate();
			Date ngayKetThuc = dateKetThuc.getDate();
			if (tenVoucher.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên voucher.");
			} else if (phanTramGiamGia <= 0 && phanTramGiamGia > 1) {
				JOptionPane.showMessageDialog(this, "Phần trăm giảm giá phải lớn hơn 0 và không được lớn hơn 1.");
			} else if (ngayBatDau == null || ngayBatDau.before(new Date())) {
				JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải từ ngày hiện tại trở về sau.");
			} else if (ngayKetThuc == null || ngayKetThuc.before(new Date())) {
				JOptionPane.showMessageDialog(this, "Ngày kết thúc phải từ ngày hiện tại trở về sau.");
			} else if (moTa.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mô tả voucher.");
			} else {
				if (voucher != null) {
					voucher.setTenVoucher(tenVoucher);
					voucher.setPhanTramGiamTheoHoaDon(phanTramGiamGia);
					voucher.setMoTaChuongTrinh(moTa);
					voucher.setSoLuotDung(soLuotDung);
					voucher.setTrangThai(trangThai);
					voucher.setNgayBatDau(ngayBatDau);
					voucher.setNgayKetThuc(ngayKetThuc);
					System.out.println(voucher);
					saveVoucher(voucher);
				} else {
					VoucherGiamGia newVoucher = new VoucherGiamGia();
					newVoucher.setTenVoucher(tenVoucher);
					newVoucher.setPhanTramGiamTheoHoaDon(phanTramGiamGia);
					newVoucher.setMoTaChuongTrinh(moTa);
					newVoucher.setSoLuotDung(soLuotDung);
					newVoucher.setTrangThai(trangThai);
					newVoucher.setNgayBatDau(ngayBatDau);
					newVoucher.setNgayKetThuc(ngayKetThuc);
					System.out.println(newVoucher);
					saveVoucher(newVoucher);
				}
			}
		}
	}

	private void saveVoucher(VoucherGiamGia voucher) {
		boolean kichHoatLai = ckb_kichhoat.isSelected();
		if (btn_Save.getText().equals("Lưu Thay Đổi")) {
			voucher.setTrangThai(kichHoatLai);

			if (dao_Voucher.updateVoucher(voucher)) {
				JOptionPane.showMessageDialog(this, "Cập nhật voucher thành công.", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Cập nhật voucher thất bại. Vui lòng kiểm tra lại.", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			voucher.setTrangThai(kichHoatLai);
			System.out.println(createMaVoucher(dao_Voucher.getMaHangHoaNew()));
			voucher.setMaVoucher(createMaVoucher(dao_Voucher.getMaHangHoaNew()));
			if (dao_Voucher.insertVoucher(voucher)) {
				JOptionPane.showMessageDialog(this, "Thêm voucher mới thành công.", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				reText();
			} else {
				JOptionPane.showMessageDialog(this, "Thêm voucher mới thất bại. Vui lòng kiểm tra lại.", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}