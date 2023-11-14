package gui.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import daos.Dao_Voucher;
import daos.Dao_NhaCungCap;
import daos.Dao_Voucher;
import entities.HangHoa;
import entities.NhaCungCap;
import entities.VoucherGiamGia;

public class FormThongTinVoucher extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_Ten;
	private JTextField txt_PhanTramGiamGia;
	private JTextField txt_TrangThai;
	private JTextField txt_PhanLoai;
	private JTextField txt_ChatLieu;
	private JTextField txt_MauSac;
	private JSpinner spn_SoLuongTon;
	private JSpinner spn_SoLuongBan;
	private JSpinner spn_GiaNhap;
	private JComboBox<NhaCungCap> cmb_NhaCungCap;
	private JTextField txt_KichCo;
	private JTextArea txtMoTa;
	private JButton btn_ChonAnh;
	private JButton btn_Save;
	private JLabel lbl_CurentTrangThai;
	private VoucherGiamGia hangHoa;
	private Dao_Voucher dao_Voucher;
	private JCheckBox ckb_banlai;
	private DefaultComboBoxModel<NhaCungCap> ncc;
	private File sr;
	private JLabel lbl_Image;
	private static File a;

	public FormThongTinVoucher(VoucherGiamGia hh, String cvThucThi) {
		setBackground(new Color(102, 205, 170));
		setLayout(null);
		dao_Voucher = new Dao_Voucher();
		this.hangHoa = hh;
		setPreferredSize(new Dimension(1020, 425));
		JPanel pnl_Image = new JPanel();
		pnl_Image.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnl_Image.setBounds(10, 10, 300, 370);
		add(pnl_Image);
		pnl_Image.setLayout(null);

		lbl_Image = new JLabel("Image");
		lbl_Image.setIconTextGap(0);
		lbl_Image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Image.setBounds(1, 1, 298, 368);
		pnl_Image.add(lbl_Image);

		JPanel pnl_InfoProduct = new JPanel();
		pnl_InfoProduct.setBackground(new Color(102, 205, 170));
		pnl_InfoProduct.setBounds(320, 11, 690, 370);
		add(pnl_InfoProduct);
		pnl_InfoProduct.setLayout(null);

		JLabel lbl_Ten = new JLabel("Tên :");
		lbl_Ten.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_Ten.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_Ten.setBounds(10, 10, 100, 20);
		pnl_InfoProduct.add(lbl_Ten);

		txt_Ten = new JTextField();
		txt_Ten.setBounds(110, 5, 200, 25);
		pnl_InfoProduct.add(txt_Ten);
		txt_Ten.setColumns(10);

		txt_PhanTramGiamGia = new JTextField();
		txt_PhanTramGiamGia.setColumns(10);
		txt_PhanTramGiamGia.setBounds(110, 41, 200, 25);
		pnl_InfoProduct.add(txt_PhanTramGiamGia);

		JLabel lbl_ThuongHieu = new JLabel("Thương hiệu :");
		lbl_ThuongHieu.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_ThuongHieu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_ThuongHieu.setBounds(10, 46, 100, 20);
		pnl_InfoProduct.add(lbl_ThuongHieu);

		txt_TrangThai = new JTextField();
		txt_TrangThai.setColumns(10);
		txt_TrangThai.setBounds(110, 77, 200, 25);
		pnl_InfoProduct.add(txt_TrangThai);

		JLabel lbl_XuatXu = new JLabel("Xuất xứ");
		lbl_XuatXu.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_XuatXu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_XuatXu.setBounds(10, 82, 100, 20);
		pnl_InfoProduct.add(lbl_XuatXu);

		txt_PhanLoai = new JTextField();
		txt_PhanLoai.setColumns(10);
		txt_PhanLoai.setBounds(110, 113, 200, 25);
		pnl_InfoProduct.add(txt_PhanLoai);

		JLabel lbl_PhanLoai = new JLabel("Phân loại:");
		lbl_PhanLoai.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_PhanLoai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_PhanLoai.setBounds(10, 118, 100, 20);
		pnl_InfoProduct.add(lbl_PhanLoai);

		txt_ChatLieu = new JTextField();
		txt_ChatLieu.setColumns(10);
		txt_ChatLieu.setBounds(110, 149, 200, 25);
		pnl_InfoProduct.add(txt_ChatLieu);

		JLabel lbl_ChatLieu = new JLabel("Chất liệu:");
		lbl_ChatLieu.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_ChatLieu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_ChatLieu.setBounds(10, 154, 100, 20);
		pnl_InfoProduct.add(lbl_ChatLieu);

		txt_MauSac = new JTextField();
		txt_MauSac.setColumns(10);
		txt_MauSac.setBounds(110, 185, 200, 25);
		pnl_InfoProduct.add(txt_MauSac);

		JLabel lbl_MauSac = new JLabel("Màu sắc:");
		lbl_MauSac.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_MauSac.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_MauSac.setBounds(10, 190, 100, 20);
		pnl_InfoProduct.add(lbl_MauSac);

		JLabel lbl_SoLuongTon = new JLabel("Số lượng tồn:");
		lbl_SoLuongTon.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_SoLuongTon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_SoLuongTon.setBounds(347, 80, 120, 20);
		pnl_InfoProduct.add(lbl_SoLuongTon);

		JLabel lbl_SoLuongBan = new JLabel("Số lượng đã bán:");
		lbl_SoLuongBan.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_SoLuongBan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_SoLuongBan.setBounds(347, 116, 120, 20);
		pnl_InfoProduct.add(lbl_SoLuongBan);

		JLabel lbl_GiaNhap = new JLabel("Giá nhập:");
		lbl_GiaNhap.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_GiaNhap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_GiaNhap.setBounds(347, 152, 120, 20);
		pnl_InfoProduct.add(lbl_GiaNhap);

		spn_SoLuongTon = new JSpinner();
		spn_SoLuongTon.setModel(new SpinnerNumberModel(0, 0, null, 1));
		spn_SoLuongTon.setBounds(467, 75, 200, 25);
		pnl_InfoProduct.add(spn_SoLuongTon);

		spn_SoLuongBan = new JSpinner();
		spn_SoLuongBan.setModel(new SpinnerNumberModel(0, 0, null, 1));
		spn_SoLuongBan.setBounds(467, 113, 200, 25);
		pnl_InfoProduct.add(spn_SoLuongBan);

		spn_GiaNhap = new JSpinner();
		spn_GiaNhap.setModel(new SpinnerNumberModel(0d, 0d, null, 1.0));
		spn_GiaNhap.setBounds(467, 149, 200, 25);
		pnl_InfoProduct.add(spn_GiaNhap);

		JLabel lbl_KichCo = new JLabel("Kích cỡ:");
		lbl_KichCo.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_KichCo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_KichCo.setBounds(347, 10, 120, 20);
		pnl_InfoProduct.add(lbl_KichCo);

		JLabel lbl_NhaCungCap = new JLabel("Nhà cung cấp:");
		lbl_NhaCungCap.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_NhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_NhaCungCap.setBounds(347, 46, 120, 20);
		pnl_InfoProduct.add(lbl_NhaCungCap);

		JLabel lbl_MoTa = new JLabel("Mô tả:");
		lbl_MoTa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_MoTa.setBounds(10, 226, 100, 133);
		pnl_InfoProduct.add(lbl_MoTa);

		cmb_NhaCungCap = new JComboBox<NhaCungCap>();
		cmb_NhaCungCap.setModel(ncc = new DefaultComboBoxModel<NhaCungCap>());
		cmb_NhaCungCap.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		cmb_NhaCungCap.setFocusable(false);
		cmb_NhaCungCap.setBounds(467, 42, 200, 25);
		pnl_InfoProduct.add(cmb_NhaCungCap);
		for (NhaCungCap item : new Dao_NhaCungCap().getAll()) {
			ncc.addElement(item);
		}

		txt_KichCo = new JTextField();
		txt_KichCo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_KichCo.setBounds(467, 5, 200, 25);
		pnl_InfoProduct.add(txt_KichCo);

		txtMoTa = new JTextArea();
		txtMoTa.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtMoTa.setLineWrap(true);
		txtMoTa.setBounds(110, 221, 557, 138);
		pnl_InfoProduct.add(txtMoTa);

		JLabel lbl_TrangThai = new JLabel("Trạng Thái:");
		lbl_TrangThai.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_TrangThai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_TrangThai.setBounds(347, 185, 120, 20);
		pnl_InfoProduct.add(lbl_TrangThai);

		lbl_CurentTrangThai = new JLabel("Còn Bán");
		lbl_CurentTrangThai.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_CurentTrangThai.setForeground(Color.RED);
		lbl_CurentTrangThai.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_CurentTrangThai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_CurentTrangThai.setBounds(467, 185, 79, 20);
		pnl_InfoProduct.add(lbl_CurentTrangThai);

		ckb_banlai = new JCheckBox("Bán Lại.");
		ckb_banlai.setBackground(new Color(102, 205, 170));
		ckb_banlai.setFont(new Font("Tahoma", Font.BOLD, 12));
		ckb_banlai.setBounds(570, 186, 97, 23);
		if (!hh.isTrangThai() && hh != null) {
			pnl_InfoProduct.add(ckb_banlai);
		}

		btn_ChonAnh = new JButton("Chọn Ảnh");
		btn_ChonAnh.setBackground(new Color(250, 250, 210));
		btn_ChonAnh.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_ChonAnh.setFocusable(false);
		btn_ChonAnh.setBounds(115, 390, 90, 25);
		add(btn_ChonAnh);

		btn_Save = new JButton("Thêm Hàng Hoá");
		btn_Save.setBackground(new Color(250, 250, 210));
		btn_Save.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Save.setFocusable(false);
		btn_Save.setBounds(634, 391, 150, 25);
		add(btn_Save);

		btn_ChonAnh.addActionListener(this);
		btn_Save.addActionListener(this);

		if (cvThucThi.equals("edit")) {
			setText(hangHoa);
			btn_Save.setText("Lưu Thay Đổi");
		}
	}

	/**
	 * Lấy dữ liệu và chỉnh sửa thông tin hàng hóa
	 * @param hangHoa2
	 */
	public void setText(VoucherGiamGia hangHoa2) {
		txt_Ten.setText(hangHoa2.getTenVoucher());
		txt_PhanTramGiamGia.setText(hangHoa2.getMoTaChuongTrinh());
		spn_GiaNhap.setValue(hangHoa2.getPhanTramGiamTheoHoaDon());
		spn_SoLuongTon.setValue(hangHoa2.getSoLuotDung());
		lbl_CurentTrangThai.setText(hangHoa2.isTrangThai() ? "Đang hoạt động" : "Đã Ngưng");
		

	}

	/**
	 * Đặt lại các giá trị trong các texfiled
	 */
	public void reText() {
		txt_Ten.setText("");
		txt_PhanTramGiamGia.setText("");
		txt_TrangThai.setText("");
		txt_MauSac.setText("");
		txt_ChatLieu.setText("");
		txt_PhanLoai.setText("");
		txtMoTa.setText("");
		txt_KichCo.setText("");
		cmb_NhaCungCap.setSelectedItem(0);
		spn_GiaNhap.setValue(0);
		spn_SoLuongTon.setValue(0);
		spn_SoLuongBan.setValue(0);
	}

	/**
	 * trả về chuỗi mã hàng hoa
	 * @param ma
	 * @return
	 */
	public String createMaHangHoa(String ma) {
		System.out.println(ma);
		
		int id = Integer.parseInt(ma.substring(3));
		if (id < 9) {
			id++;
			return "NCC000" + id ;
		} else if (id < 99) {
			id++;
			return "NCC00" + id ;
		} else if (id < 999) {
			id++;
			return "NCC0" + id ;
		}
		id++;
		return "NCC" + id ;
	}
	
	

	public void importImage() {
		JFileChooser f = new JFileChooser();
		f.showOpenDialog(null);
		File fl = f.getSelectedFile();
		if (f.getSelectedFile() != null) {
			String fileName = fl.getAbsolutePath();
			// kiểm tra thư mục image có tồn tại không nêu không thì tạo
			File directory = new File("img\\");
			if (!directory.exists()) {
				directory.mkdirs();
			}
			sr = new File(fileName);
			lbl_Image.setIcon(new ImageIcon(new ImageIcon(sr.getPath().toString()).getImage().getScaledInstance(305,
					368, java.awt.Image.SCALE_SMOOTH)));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//	  
	}
}