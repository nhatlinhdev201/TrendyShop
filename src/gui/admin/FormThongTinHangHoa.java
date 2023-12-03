package gui.admin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import daos.Dao_HangHoa;
import daos.Dao_NhaCungCap;
import entities.HangHoa;
import entities.NhaCungCap;
import rojerusan.RSTableMetro;

public class FormThongTinHangHoa extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_Ten;
	private JTextField txt_ThuongHieu;
	private JTextField txt_XuatXu;
	private JTextField txt_ChatLieu;
	private JTextField txt_MauSac;
	private JSpinner spn_SoLuongBan;
	private JSpinner spn_GiaNhap;
	private JComboBox<NhaCungCap> cmb_NhaCungCap;
	private JTextArea txtMoTa;
	private JButton btn_ChonAnh;
	private JButton btn_Save;
	private JLabel lbl_CurentTrangThai;
	private Dao_HangHoa dao_HangHoa;
	private JCheckBox ckb_banlai;
	private DefaultComboBoxModel<NhaCungCap> ncc;
	
	private File sr;
	private JLabel lbl_Image;
	private JButton btn_addSize;
	private static File a;
	private JScrollPane src_size;
	private DefaultTableModel dtm_size;
	private JButton btn_XoaSize;
	private JTextField txt_NewSize;
	private JSpinner spn_SoLuong;
	private RSTableMetro tbl_size;
	private HashMap<String, Integer> listSize;
	private HangHoa hangHoaOld;
	private String newMa;
	private JComboBox<String> cmb_phanLoai;
	private DefaultComboBoxModel<String> pl;


	public FormThongTinHangHoa(HangHoa hh, String cvThucThi) {

		listSize = new HashMap<String, Integer>();
		setBackground(new Color(102, 205, 170));
		setLayout(null);
		hangHoaOld = hh;
		dao_HangHoa = new Dao_HangHoa();
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

		txt_ThuongHieu = new JTextField();
		txt_ThuongHieu.setColumns(10);
		txt_ThuongHieu.setBounds(110, 41, 200, 25);
		pnl_InfoProduct.add(txt_ThuongHieu);

		JLabel lbl_ThuongHieu = new JLabel("Thương hiệu :");
		lbl_ThuongHieu.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_ThuongHieu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_ThuongHieu.setBounds(10, 46, 100, 20);
		pnl_InfoProduct.add(lbl_ThuongHieu);

		txt_XuatXu = new JTextField();
		txt_XuatXu.setColumns(10);
		txt_XuatXu.setBounds(110, 77, 200, 25);
		pnl_InfoProduct.add(txt_XuatXu);

		JLabel lbl_XuatXu = new JLabel("Xuất xứ");
		lbl_XuatXu.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_XuatXu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_XuatXu.setBounds(10, 82, 100, 20);
		pnl_InfoProduct.add(lbl_XuatXu);

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

		JLabel lbl_SoLuongBan = new JLabel("Số lượng đã bán:");
		lbl_SoLuongBan.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_SoLuongBan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_SoLuongBan.setBounds(347, 44, 120, 20);
		pnl_InfoProduct.add(lbl_SoLuongBan);

		JLabel lbl_GiaNhap = new JLabel("Giá nhập:");
		lbl_GiaNhap.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_GiaNhap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_GiaNhap.setBounds(347, 80, 120, 20);
		pnl_InfoProduct.add(lbl_GiaNhap);

		spn_SoLuongBan = new JSpinner();
		spn_SoLuongBan.setModel(new SpinnerNumberModel(0, 0, null, 1));
		spn_SoLuongBan.setBounds(467, 41, 200, 25);
		pnl_InfoProduct.add(spn_SoLuongBan);

		spn_GiaNhap = new JSpinner();
		spn_GiaNhap.setModel(new SpinnerNumberModel(0d, 0d, null, 1.0));
		spn_GiaNhap.setBounds(467, 77, 200, 25);
		pnl_InfoProduct.add(spn_GiaNhap);

		JLabel lbl_KichCo = new JLabel("Size:");
		lbl_KichCo.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_KichCo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_KichCo.setBounds(347, 112, 120, 20);
		pnl_InfoProduct.add(lbl_KichCo);

		JLabel lbl_NhaCungCap = new JLabel("Nhà cung cấp:");
		lbl_NhaCungCap.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_NhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_NhaCungCap.setBounds(347, 9, 120, 20);
		pnl_InfoProduct.add(lbl_NhaCungCap);

		JLabel lbl_MoTa = new JLabel("Mô tả:");
		lbl_MoTa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_MoTa.setBounds(10, 226, 100, 133);
		pnl_InfoProduct.add(lbl_MoTa);

		cmb_NhaCungCap = new JComboBox<NhaCungCap>();
		cmb_NhaCungCap.setModel(ncc = new DefaultComboBoxModel<NhaCungCap>());
		cmb_NhaCungCap.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		cmb_NhaCungCap.setFocusable(false);
		cmb_NhaCungCap.setBounds(467, 5, 200, 25);
		pnl_InfoProduct.add(cmb_NhaCungCap);
		for (NhaCungCap item : new Dao_NhaCungCap().getAll()) {
			ncc.addElement(item);
		}

		txtMoTa = new JTextArea();
		txtMoTa.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtMoTa.setLineWrap(true);
		txtMoTa.setBounds(110, 221, 200, 138);
		pnl_InfoProduct.add(txtMoTa);

		JLabel lbl_TrangThai = new JLabel("Trạng Thái:");
		lbl_TrangThai.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_TrangThai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_TrangThai.setBounds(347, 339, 120, 20);
		pnl_InfoProduct.add(lbl_TrangThai);

		lbl_CurentTrangThai = new JLabel("Còn Bán");
		lbl_CurentTrangThai.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_CurentTrangThai.setForeground(Color.RED);
		lbl_CurentTrangThai.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_CurentTrangThai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_CurentTrangThai.setBounds(467, 339, 79, 20);
		pnl_InfoProduct.add(lbl_CurentTrangThai);

		ckb_banlai = new JCheckBox("Bán Lại.");
		ckb_banlai.setBackground(new Color(102, 205, 170));
		ckb_banlai.setFont(new Font("Tahoma", Font.BOLD, 12));
		ckb_banlai.setBounds(570, 339, 97, 23);
		pnl_InfoProduct.add(ckb_banlai);
		if (hh.isTrangThai()) {
			ckb_banlai.setVisible(false);
		}

		btn_addSize = new JButton("Thêm Size");
		btn_addSize.setFocusable(false);
		btn_addSize.setBackground(new Color(250, 250, 210));
		btn_addSize.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_addSize.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_addSize.setBounds(467, 114, 90, 23);
		pnl_InfoProduct.add(btn_addSize);

		src_size = new JScrollPane();
		src_size.setBorder(null);
		src_size.setBounds(347, 149, 320, 180);
		pnl_InfoProduct.add(src_size);

		tbl_size = new RSTableMetro();
		tbl_size.setModel(dtm_size = new DefaultTableModel(new Object[][] {},
				new String[] { "Size", "S\u1ED1 l\u01B0\u1EE3ng t\u1ED3n" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbl_size.getColumnModel().getColumn(0).setResizable(false);
		tbl_size.getColumnModel().getColumn(1).setResizable(false);
		tbl_size.setFont(new Font("Tahoma", Font.BOLD, 9));
		tbl_size.setFuenteFilas(new Font("Tahoma", Font.BOLD, 14));
		tbl_size.setBorder(null);
		tbl_size.setIntercellSpacing(new Dimension(0, 0));
		tbl_size.setAlignmentY(Component.TOP_ALIGNMENT);
		tbl_size.setAlignmentX(Component.LEFT_ALIGNMENT);
		tbl_size.setRowMargin(0);
		tbl_size.setColorBordeFilas(new Color(0, 128, 128));
		tbl_size.setGridColor(new Color(0, 128, 128));
		tbl_size.setColorSelForeground(Color.WHITE);
		tbl_size.setColorFilasForeground2(Color.BLACK);
		tbl_size.setColorFilasForeground1(Color.BLACK);
		tbl_size.setColorSelBackgound(new Color(102, 205, 170));
		tbl_size.setColorFilasBackgound2(Color.WHITE);
		tbl_size.setColorFilasBackgound1(Color.WHITE);
		tbl_size.setColorBackgoundHead(new Color(0, 128, 128));
		tbl_size.setColorBordeHead(new Color(0, 128, 128));
		tbl_size.setBackground(Color.WHITE);
		tbl_size.setFuenteFilasSelect(new Font("Tahoma", Font.BOLD, 13));
		tbl_size.setFuenteHead(new Font("Tahoma", Font.BOLD, 13));
		tbl_size.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_size.setAltoHead(30);
		src_size.setViewportView(tbl_size);

		btn_XoaSize = new JButton("Xoá Size");
		btn_XoaSize.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_XoaSize.setFocusable(false);
		btn_XoaSize.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_XoaSize.setBackground(new Color(250, 250, 210));
		btn_XoaSize.setBounds(577, 114, 90, 23);
		pnl_InfoProduct.add(btn_XoaSize);
		
		cmb_phanLoai = new JComboBox<String>();
		cmb_phanLoai.setModel(pl = new DefaultComboBoxModel<String>());
		cmb_phanLoai.setBounds(110, 112, 200, 25);
		cmb_phanLoai.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		cmb_phanLoai.setFocusable(false);
		pnl_InfoProduct.add(cmb_phanLoai);
		for (String phanLoai : new Dao_HangHoa().getAllPhanLoai()) {
		    cmb_phanLoai.addItem(phanLoai);
		}

		btn_ChonAnh = new JButton("Chọn Ảnh");
		btn_ChonAnh.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_ChonAnh.setBackground(new Color(250, 250, 210));
		btn_ChonAnh.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_ChonAnh.setFocusable(false);
		btn_ChonAnh.setBounds(115, 390, 90, 25);
		add(btn_ChonAnh);

		btn_Save = new JButton("Thêm Hàng Hoá");
		btn_Save.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Save.setBackground(new Color(250, 250, 210));
		btn_Save.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Save.setFocusable(false);
		btn_Save.setBounds(634, 391, 150, 25);
		add(btn_Save);

		if (cvThucThi.equals("edit")) {
			setText(hh);
			btn_Save.setText("Lưu Thay Đổi");
			src_size.setBounds(347, 149, 320, 180);
			btn_addSize.setBounds(467, 114, 200, 23);
			btn_addSize.setText("Chỉnh sửa Size");
			btn_XoaSize.setVisible(false);
			newMa = hh.getMaHangHoa();

		} else {
			lbl_TrangThai.setVisible(false);
			lbl_CurentTrangThai.setVisible(false);
			src_size.setBounds(347, 149, 320, 210);
			ckb_banlai.setVisible(false);
		}

		btn_ChonAnh.addActionListener(this);
		btn_Save.addActionListener(this);
		btn_addSize.addActionListener(this);
		btn_XoaSize.addActionListener(this);
	}

	/**
	 * Lấy dữ liệu và chỉnh sửa thông tin hàng hóa
	 * 
	 * @param hh
	 */
	public void setText(HangHoa hh) {
		txt_Ten.setText(hh.getTenHangHoa());
		txt_ThuongHieu.setText(hh.getThuongHieu());
		txt_XuatXu.setText(hh.getXuatXu());
		txt_MauSac.setText(hh.getMauSac());
		txt_ChatLieu.setText(hh.getChatLieu());
		cmb_phanLoai.setToolTipText(hh.getPhanLoai());
		txtMoTa.setText(hh.getChiTietMoTa());
		lbl_Image.setIcon(new ImageIcon(
				new ImageIcon(hh.getHinhAnh()).getImage().getScaledInstance(305, 368, java.awt.Image.SCALE_SMOOTH)));
		spn_GiaNhap.setValue(hh.getDonGiaNhap());
		spn_SoLuongBan.setValue(hh.getSoLuongDaBan());
		lbl_CurentTrangThai.setText(hh.isTrangThai() ? "Còn Bán" : "Ngừng Bán");
		listSize.put(hh.getKichCo(), hh.getSoLuongTon());
		Object[] rowSize = { hh.getKichCo(), hh.getSoLuongTon() };
		dtm_size.addRow(rowSize);
		String maNCC = hh.getMaNhaCungCap();
		int index = 0;
		for (NhaCungCap item : new Dao_NhaCungCap().getAll()) {
			if (maNCC.equalsIgnoreCase(item.getMaNhaCungCap())) {
				cmb_NhaCungCap.setSelectedIndex(index);
				break;
			}
			index++;
		}
	}

	public Component addSize(String size, int soLuong) {

		JPanel pnl_AddSize = new JPanel();
		pnl_AddSize.setBounds(95, 177, 309, 87);
		pnl_AddSize.setPreferredSize(new Dimension(310, 90));
		pnl_AddSize.setLayout(null);

		JLabel lbl_NewSize = new JLabel("Size:");
		lbl_NewSize.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_NewSize.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_NewSize.setBounds(0, 16, 100, 20);
		pnl_AddSize.add(lbl_NewSize);

		txt_NewSize = new JTextField();
		txt_NewSize.setColumns(10);
		txt_NewSize.setBounds(100, 11, 200, 25);
		pnl_AddSize.add(txt_NewSize);

		JLabel lbl_SoLuong = new JLabel("Số Lượng:");
		lbl_SoLuong.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_SoLuong.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_SoLuong.setBounds(0, 52, 100, 20);
		pnl_AddSize.add(lbl_SoLuong);

		spn_SoLuong = new JSpinner();
		spn_SoLuong.setModel(new SpinnerNumberModel(0, 0, null, 1));
		spn_SoLuong.setBounds(100, 47, 200, 25);
		pnl_AddSize.add(spn_SoLuong);
		if (!size.equals("")) {
			txt_NewSize.setText(size);
			spn_SoLuong.setValue(soLuong);
		}
		return pnl_AddSize;
	}

	/**
	 * Đặt lại các giá trị trong các texfiled
	 */
	public void reText() {
		txt_Ten.setText("");
		txt_ThuongHieu.setText("");
		txt_XuatXu.setText("");
		txt_MauSac.setText("");
		txt_ChatLieu.setText("");
		cmb_phanLoai.setSelectedItem(0);;
		txtMoTa.setText("");
		cmb_NhaCungCap.setSelectedItem(0);
		spn_GiaNhap.setValue(0);
		spn_SoLuongBan.setValue(0);
		for (int i = 0; i < tbl_size.getRowCount(); i++) {
			dtm_size.removeRow(i);
		}
		lbl_Image.setIcon(
				new ImageIcon(new ImageIcon("").getImage().getScaledInstance(305, 368, java.awt.Image.SCALE_SMOOTH)));

	}

	/**
	 * trả về chuỗi mã hàng hoa
	 * 
	 * @param ma
	 * @return
	 */
	public String createMaHangHoa(String ma) {
		ma = ma.substring(0, 6);
		int id = Integer.parseInt(ma.substring(2));
		if (id < 9) {
			id++;
			return "HH000" + id;
		} else if (id < 99) {
			id++;
			return "HH00" + id;
		} else if (id < 999) {
			id++;
			return "HH0" + id;
		}
		id++;
		return "HH" + id;
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
		if (e.getSource().equals(btn_ChonAnh)) {
			importImage();
		} else if (e.getSource().equals(btn_Save)) {

			// Kiểm tra các trường dữ liệu nếu là null hoặc trống
			String ten = txt_Ten.getText().trim();
			String thuongHieu = txt_ThuongHieu.getText().trim();
			String xuatXu = txt_XuatXu.getText().trim();
			String mauSac = txt_MauSac.getText().trim();
			String chatLieu = txt_ChatLieu.getText().trim();
			String phanLoai = (String) cmb_phanLoai.getSelectedItem();
			
			String moTa = txtMoTa.getText().trim();
			String nhaCungCap = ((NhaCungCap) cmb_NhaCungCap.getSelectedItem()).getMaNhaCungCap();
			Object giaNhapObject = spn_GiaNhap.getValue();
			double giaNhap = giaNhapObject instanceof Number ? ((Number) giaNhapObject).doubleValue() : 0.0;
			int soLuongBan = (int) spn_SoLuongBan.getValue();
			int soSize = listSize.size();
			// Kiểm tra các trường dữ liệu
			if (ten.isEmpty()) {
			    JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm.");
			} else if (thuongHieu.isEmpty()) {
			    JOptionPane.showMessageDialog(this, "Vui lòng nhập thương hiệu.");
			} else if (xuatXu.isEmpty()) {
			    JOptionPane.showMessageDialog(this, "Vui lòng nhập xuất xứ.");
			} else if (mauSac.isEmpty()) {
			    JOptionPane.showMessageDialog(this, "Vui lòng nhập màu sắc.");
			} else if (chatLieu.isEmpty() ) {
			    JOptionPane.showMessageDialog(this, "Vui lòng nhập chất liệu.");
			} else if (phanLoai == null || phanLoai.isEmpty()) {
			    JOptionPane.showMessageDialog(this, "Vui lòng chọn phân loại.");
			} else if (moTa.isEmpty()) {
			    JOptionPane.showMessageDialog(this, "Vui lòng nhập mô tả sản phẩm.");
			} else if (soSize == 0) {
			    JOptionPane.showMessageDialog(this, "Vui lòng nhập ít nhất một size.");
			}
		
			else {
				HangHoa hh = new HangHoa(hangHoaOld.getMaHangHoa(), ten, phanLoai, thuongHieu, xuatXu, chatLieu, moTa,
						hangHoaOld.getHinhAnh(), nhaCungCap, "", mauSac, 0, soLuongBan, giaNhap, true);
		
				if (btn_Save.getText().equals("Lưu Thay Đổi")) {
					String tienTo = hangHoaOld.getHinhAnh().substring(hangHoaOld.getHinhAnh().lastIndexOf("."));
					if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn cập nhật sản phẩm này", "Cập nhật",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						hh.setTrangThai(ckb_banlai.isSelected());
						// nếu có chọn hình ảnh mới thì thực hiện copy hình ảnh thay thế ảnh củ
						// =================================
						if (sr != null) {
							try {
								File anh = new File(hh.getHinhAnh());
								Files.copy(sr.toPath(), anh.toPath(), StandardCopyOption.REPLACE_EXISTING);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}else {
							try {
								File anh = new File(hh.getHinhAnh());
								File anhNew = new File("img\\" + newMa + tienTo);
								Files.copy(anh.toPath(), anhNew.toPath(), StandardCopyOption.REPLACE_EXISTING);
								anh.delete();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						hh.setHinhAnh("img\\" + newMa + tienTo);
						hh.setKichCo(newMa.substring(6));
						// =================================
						if (dao_HangHoa.updateHangHoa(hh, newMa)) {
							JOptionPane.showMessageDialog(this,
									"Đã cập nhật thông tin sản phẩm " + hangHoaOld.getMaHangHoa() + " thành công.");
							reText();
						} else {
							JOptionPane.showMessageDialog(this,
									"Cập nhật thông tin sản phẩm " + hangHoaOld.getMaHangHoa() + " Thất Bại.");
						}
					}
				} else {
					// nếu mà có chọn hình ảnh thì sr sẽ khác null
					if (sr != null) {
						if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thêm sản phẩm này?",
								"Thêm sản phẩm ?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
							// Lấy mã hàng hóa mới
							String ma = createMaHangHoa(dao_HangHoa.getMaHangHoaNew());
							boolean checkADD = true;
							String listMaThanhCong = "";
							String listMaThemThatBai = "";
							// duyệt qua danh sách size thêm từng phần tử vào csdl
							for (Entry<String, Integer> i : listSize.entrySet()) {
								hh.setMaHangHoa(ma + i.getKey());
								String tienToFile = sr.getAbsolutePath()
										.substring(sr.getAbsolutePath().lastIndexOf("."));
								a = new File("img\\" + hh.getMaHangHoa() + tienToFile);
								hh.setHinhAnh("img\\" + hh.getMaHangHoa() + tienToFile);
								if (dao_HangHoa.insertHangHoa(hh)) {
									listMaThanhCong += hh.getMaHangHoa() + "\n";
									// Thực hiện copy hình ảnh vào thư mục img
									try {
										if (Files.exists(a.toPath())) {
										    String timestamp = String.valueOf(System.currentTimeMillis());
										    a = new File("img\\" + newMa + "_" + timestamp + tienToFile);
										}
										Files.copy(sr.toPath(), a.toPath(), StandardCopyOption.REPLACE_EXISTING);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								} else {
									listMaThemThatBai += hh.getMaHangHoa() + "\n";
								}
							}
							if (checkADD) {

								JOptionPane.showMessageDialog(this,
										"Thêm sản phẩm \n" + listMaThanhCong + " thành công.");
								reText();
							} else if (checkADD || !listMaThemThatBai.equals("")) {
								JOptionPane.showMessageDialog(this,
										"Thêm thông tin sản phẩm \n" + listMaThemThatBai + " Thất Bại.");
							}
						}

					} else {
						JOptionPane.showMessageDialog(this, "vui lòng chọn hình ảnh cho sản phẩm này.");
					}
				}

			}
		} else if (e.getSource().equals(btn_addSize)) {
			if (btn_addSize.getText().equals("Chỉnh sửa Size")) {
				Object[] r = { "Thêm", "Thoát" };

				if (JOptionPane.showOptionDialog(this, addSize(hangHoaOld.getKichCo(), hangHoaOld.getSoLuongTon()),
						"Chỉnh sửa Size.", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, r,
						null) == JOptionPane.YES_OPTION) {
					String size = txt_NewSize.getText().toUpperCase();
					int soLuong = Integer.parseInt(spn_SoLuong.getValue().toString());
					String ma = hangHoaOld.getMaHangHoa().substring(0, 6);
					if (size.isEmpty()) {
						JOptionPane.showMessageDialog(this, "không được bỏ trống");
					} else if (!hangHoaOld.getKichCo().trim().equalsIgnoreCase(size.trim())
							&& dao_HangHoa.getKichThuocCuaMotSanPham(ma).contains(size)) {
						JOptionPane.showMessageDialog(this, "Đã tồn tại Size " + size);
					} else {
						if (listSize.compute(size, (key, value) -> value = soLuong) == soLuong) {
							dtm_size.setValueAt(size, 0, 0);
							dtm_size.setValueAt(soLuong, 0, 1);
							newMa = hangHoaOld.getMaHangHoa().substring(0, 6) + size;
							JOptionPane.showMessageDialog(this, "Cập nhật size thành công");
						} else {
							JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
						}
					}
				}
				txt_NewSize.setText("");
				spn_SoLuong.setValue(0);
			} else {
				Object[] r = { "Thêm", "Thoát" };
				if (JOptionPane.showOptionDialog(this, addSize("", 0), "Thêm sản phẩm mới.", JOptionPane.DEFAULT_OPTION,
						JOptionPane.DEFAULT_OPTION, null, r, null) == JOptionPane.YES_OPTION) {
					String size = txt_NewSize.getText().toUpperCase();
					int soLuong = Integer.parseInt(spn_SoLuong.getValue().toString());
					if (size.isEmpty()) {
						JOptionPane.showMessageDialog(this, "không được bỏ trống");
					} else {
						if (listSize.put(size, soLuong) == null) {
							Object[] rowSize = { size, soLuong };
							dtm_size.addRow(rowSize);
							JOptionPane.showMessageDialog(this, "thêm size thành công");
						} else {
							JOptionPane.showMessageDialog(this, "Đã tồn tại Size " + size);
						}
					}
				}
			}
		} else if (e.getSource().equals(btn_XoaSize)) {
			if (tbl_size.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn size muốn xoá.");
			} else {
				String size = tbl_size.getValueAt(tbl_size.getSelectedRow(), 0).toString();
				listSize.remove(size);
				dtm_size.removeRow(0);

			}
		}
	}
}