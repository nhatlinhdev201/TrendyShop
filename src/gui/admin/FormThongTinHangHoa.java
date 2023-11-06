package gui.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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

import dao.Dao_HangHoa;
import dao.Dao_NhaCungCap;
import entities.HangHoa;
import entities.NhaCungCap;

public class FormThongTinHangHoa extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_Ten;
	private JTextField txt_ThuongHieu;
	private JTextField txt_XuatXu;
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
	private HangHoa hangHoa;
	private Dao_HangHoa dao_HangHoa;
	private JCheckBox ckb_banlai;
	private DefaultComboBoxModel<NhaCungCap> ncc;
	public FormThongTinHangHoa(HangHoa hh, String cvThucThi) {
		setBackground(new Color(102, 205, 170));
		setLayout(null);
		dao_HangHoa =new Dao_HangHoa();
		this.hangHoa =hh;
		setPreferredSize(new Dimension(1020,425));
		JPanel pnl_Image = new JPanel();
		pnl_Image.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnl_Image.setBounds(10, 10, 300, 370);
		add(pnl_Image);
		pnl_Image.setLayout(null);
		
		JLabel lbl_Image = new JLabel("Image");
		lbl_Image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Image.setBounds(0, 0, 300, 370);
		pnl_Image.add(lbl_Image);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 205, 170));
		panel_1.setBounds(320, 11, 690, 370);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_Ten = new JLabel("Tên :");
		lbl_Ten.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_Ten.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_Ten.setBounds(10, 10, 100, 20);
		panel_1.add(lbl_Ten);
		
		txt_Ten = new JTextField();
		txt_Ten.setBounds(110, 5, 200, 25);
		panel_1.add(txt_Ten);
		txt_Ten.setColumns(10);
		
		txt_ThuongHieu = new JTextField();
		txt_ThuongHieu.setColumns(10);
		txt_ThuongHieu.setBounds(110, 41, 200, 25);
		panel_1.add(txt_ThuongHieu);
		
		JLabel lbl_ThuongHieu = new JLabel("Thương hiệu :");
		lbl_ThuongHieu.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_ThuongHieu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_ThuongHieu.setBounds(10, 46, 100, 20);
		panel_1.add(lbl_ThuongHieu);
		
		txt_XuatXu = new JTextField();
		txt_XuatXu.setColumns(10);
		txt_XuatXu.setBounds(110, 77, 200, 25);
		panel_1.add(txt_XuatXu);
		
		JLabel lbl_XuatXu = new JLabel("Xuất xứ");
		lbl_XuatXu.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_XuatXu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_XuatXu.setBounds(10, 82, 100, 20);
		panel_1.add(lbl_XuatXu);
		
		txt_PhanLoai = new JTextField();
		txt_PhanLoai.setColumns(10);
		txt_PhanLoai.setBounds(110, 113, 200, 25);
		panel_1.add(txt_PhanLoai);
		
		JLabel lbl_PhanLoai = new JLabel("Phân loại:");
		lbl_PhanLoai.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_PhanLoai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_PhanLoai.setBounds(10, 118, 100, 20);
		panel_1.add(lbl_PhanLoai);
		
		txt_ChatLieu = new JTextField();
		txt_ChatLieu.setColumns(10);
		txt_ChatLieu.setBounds(110, 149, 200, 25);
		panel_1.add(txt_ChatLieu);
		
		JLabel lbl_ChatLieu = new JLabel("Chất liệu:");
		lbl_ChatLieu.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_ChatLieu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_ChatLieu.setBounds(10, 154, 100, 20);
		panel_1.add(lbl_ChatLieu);
		
		txt_MauSac = new JTextField();
		txt_MauSac.setColumns(10);
		txt_MauSac.setBounds(110, 185, 200, 25);
		panel_1.add(txt_MauSac);
		
		JLabel lbl_MauSac = new JLabel("Màu sắc:");
		lbl_MauSac.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_MauSac.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_MauSac.setBounds(10, 190, 100, 20);
		panel_1.add(lbl_MauSac);
		
		JLabel lbl_SoLuongTon = new JLabel("Số lượng tồn:");
		lbl_SoLuongTon.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_SoLuongTon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_SoLuongTon.setBounds(347, 80, 120, 20);
		panel_1.add(lbl_SoLuongTon);
		
		JLabel lbl_SoLuongBan = new JLabel("Số lượng đã bán:");
		lbl_SoLuongBan.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_SoLuongBan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_SoLuongBan.setBounds(347, 116, 120, 20);
		panel_1.add(lbl_SoLuongBan);
		
		JLabel lbl_GiaNhap = new JLabel("Giá nhập:");
		lbl_GiaNhap.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_GiaNhap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_GiaNhap.setBounds(347, 152, 120, 20);
		panel_1.add(lbl_GiaNhap);
		
		spn_SoLuongTon = new JSpinner();
		spn_SoLuongTon.setModel(new SpinnerNumberModel(0,0, null, 1));
		spn_SoLuongTon.setBounds(467, 75, 200, 25);
		panel_1.add(spn_SoLuongTon);
		
		spn_SoLuongBan = new JSpinner();
		spn_SoLuongBan.setModel(new SpinnerNumberModel(0, 0, null,1));
		spn_SoLuongBan.setBounds(467, 113, 200, 25);
		panel_1.add(spn_SoLuongBan);
		
		spn_GiaNhap = new JSpinner();
		spn_GiaNhap.setModel(new SpinnerNumberModel(0, 0, null,1));
		spn_GiaNhap.setBounds(467, 149, 200, 25);
		panel_1.add(spn_GiaNhap);
		
		JLabel lbl_KichCo = new JLabel("Kích cỡ:");
		lbl_KichCo.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_KichCo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_KichCo.setBounds(347, 10, 120, 20);
		panel_1.add(lbl_KichCo);
		
		JLabel lbl_NhaCungCap = new JLabel("Nhà cung cấp:");
		lbl_NhaCungCap.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_NhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_NhaCungCap.setBounds(347, 46, 120, 20);
		panel_1.add(lbl_NhaCungCap);
		
		JLabel lbl_MoTa = new JLabel("Mô tả:");
		lbl_MoTa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_MoTa.setBounds(10, 226, 100, 133);
		panel_1.add(lbl_MoTa);
		
		cmb_NhaCungCap = new JComboBox<NhaCungCap>();
		cmb_NhaCungCap.setModel(ncc=new DefaultComboBoxModel<NhaCungCap>());
		cmb_NhaCungCap.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		cmb_NhaCungCap.setFocusable(false);
		cmb_NhaCungCap.setBounds(467, 42, 200, 25);
		panel_1.add(cmb_NhaCungCap);
		for (NhaCungCap item : new Dao_NhaCungCap().getAll()) {
			ncc.addElement(item);
		}
		
		txt_KichCo = new JTextField();
		txt_KichCo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_KichCo.setBounds(467, 5, 200, 25);
		panel_1.add(txt_KichCo);
		
		txtMoTa = new JTextArea();
		txtMoTa.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtMoTa.setLineWrap(true);
		txtMoTa.setBounds(110, 221, 557, 138);
		panel_1.add(txtMoTa);
		
		JLabel lbl_TrangThai = new JLabel("Trạng Thái:");
		lbl_TrangThai.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_TrangThai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_TrangThai.setBounds(347, 185, 120, 20);
		panel_1.add(lbl_TrangThai);
		
		lbl_CurentTrangThai = new JLabel("Còn Bán");
		lbl_CurentTrangThai.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_CurentTrangThai.setForeground(Color.RED);
		lbl_CurentTrangThai.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_CurentTrangThai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_CurentTrangThai.setBounds(467, 185, 79, 20);
		panel_1.add(lbl_CurentTrangThai);
		
		ckb_banlai = new JCheckBox("Bán Lại.");
		ckb_banlai.setBackground(new Color(102, 205, 170));
		ckb_banlai.setFont(new Font("Tahoma", Font.BOLD, 12));
		ckb_banlai.setBounds(570, 186, 97, 23);
		if (!hh.isTrangThai() && hh != null) {
			panel_1.add(ckb_banlai);
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
		btn_Save.setBounds(634, 391, 120, 25);
		add(btn_Save);
		
		btn_ChonAnh.addActionListener(this);
		btn_Save.addActionListener(this);
		if (cvThucThi.equals("edit")) {
			setText(hangHoa);
			btn_Save.setText("Lưu Thay Đổi");
		}
	}
	
	public void setText(HangHoa hh) {
		txt_Ten.setText(hh.getTenHangHoa());
		txt_ThuongHieu.setText(hh.getThuongHieu());
		txt_XuatXu.setText(hh.getXuatXu());
		txt_MauSac.setText(hh.getMauSac());
		txt_ChatLieu.setText(hh.getChatLieu());
		txt_PhanLoai.setText(hh.getPhanLoai());
		txtMoTa.setText(hh.getChiTietMoTa());
		txt_KichCo.setText(hh.getKichCo());
		
		spn_GiaNhap.setValue(hh.getDonGiaNhap());
		spn_SoLuongTon.setValue(hh.getSoLuongTon());
		spn_SoLuongBan.setValue(hh.getSoLuongDaBan());
		lbl_CurentTrangThai.setText(hh.isTrangThai()?"Còn Bán":"Ngừng Bán");
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
	public void reText() {
		txt_Ten.setText("");
		txt_ThuongHieu.setText("");
		txt_XuatXu.setText("");
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
	
	public String createMaHangHoa(String ma) {
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

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_ChonAnh)) {
			
		}else if (e.getSource().equals(btn_Save)) {
			String ten = txt_Ten.getText().trim();
			String thuongHieu = txt_ThuongHieu.getText().trim();
			String xuatXu = txt_XuatXu.getText().trim();
			String mauSac = txt_MauSac.getText().trim();
			String chatLieu = txt_ChatLieu.getText().trim();
			String phanLoai = txt_PhanLoai.getText().trim();
			String kichCo = txt_KichCo.getText().trim();
			String moTa = txtMoTa.getText().trim();
			String nhaCungCap = ((NhaCungCap)cmb_NhaCungCap.getSelectedItem()).getMaNhaCungCap();
			double giaNhap = (double)spn_GiaNhap.getValue();
			int soLuongTon = (int) spn_SoLuongTon.getValue();
			int soLuongBan = (int) spn_SoLuongBan.getValue();
			HangHoa hh = new HangHoa(hangHoa.getMaHangHoa(), ten, phanLoai, thuongHieu, xuatXu, chatLieu, moTa, "Hình ảnh", nhaCungCap, kichCo, mauSac, soLuongTon, soLuongBan, giaNhap, true);
			if (btn_Save.getText().equals("Lưu Thay Đổi")) {
				hh.setTrangThai(ckb_banlai.isSelected());
				if (dao_HangHoa.updateHangHoa(hh)) {
					JOptionPane.showMessageDialog(this, "Đã cập nhật thông tin sản phẩm "+hangHoa.getMaHangHoa()+" thành công.");
					reText();
				}else {
					JOptionPane.showMessageDialog(this, "Cập nhật thông tin sản phẩm "+hangHoa.getMaHangHoa()+" Thất Bại.");
				}
			}else {
				String ma = dao_HangHoa.getMaHangHoaNew();
				hangHoa.setMaHangHoa(createMaHangHoa(ma));
				if (dao_HangHoa.insertHangHoa(hh)) {
					JOptionPane.showMessageDialog(this, "Đã thêm thông tin sản phẩm "+hangHoa.getMaHangHoa()+" thành công.");
					reText();
				}else {
					JOptionPane.showMessageDialog(this, "Thêm thông tin sản phẩm "+hangHoa.getMaHangHoa()+" Thất Bại.");
				}
			}
			
		}
		
	}
}
