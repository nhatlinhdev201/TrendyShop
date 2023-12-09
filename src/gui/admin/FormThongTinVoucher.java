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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

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
import entities.NhaCungCap;
import entities.VoucherGiamGia;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;

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
	private HashMap<String, Integer> listSize;
	private JPanel pnl_NgayBatDau;
	private JDateChooser dateBatDau;
	private JLabel lblNgayKetThuc;
	private JPanel pnl_NgayKetThuc;
	private JDateChooser dateKetThuc;
	private JLabel lblNgayBatDau;

	public FormThongTinVoucher(VoucherGiamGia vc, String cvThucThi) {
		listSize = new HashMap<String, Integer>();
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
//		lbl_SoLuotDung.setVerticalAlignment(SwingConstants.BOTTOM);
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
		ckb_kichhoat.setBounds(272,177,120,21);
		pnl_InfoVoucher.add(ckb_kichhoat);
		if (!vc.isTrangThai()) {
			ckb_kichhoat.setVisible(false);
		}
		
		spn_PhanTramGiamGia = new JSpinner();
		spn_PhanTramGiamGia.setBounds(144, 97, 187, 25);
		pnl_InfoVoucher.add(spn_PhanTramGiamGia);
		
		spn_SoLuotDung = new JSpinner();
		spn_SoLuotDung.setBounds(144, 138, 187, 25);
		pnl_InfoVoucher.add(spn_SoLuotDung);
		
		lblNgayBatDau = new JLabel("Ngày bắt đầu");
		lblNgayBatDau.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayBatDau.setBounds(412, 63, 100, 20);
		pnl_InfoVoucher.add(lblNgayBatDau);
		
		pnl_NgayBatDau = new JPanel();
		pnl_NgayBatDau.setBounds(522, 56, 155, 30);
		pnl_InfoVoucher.add(pnl_NgayBatDau);
		
		dateBatDau = new JDateChooser();
		pnl_NgayBatDau.add(dateBatDau);
		BorderLayout bl_dateBatDau = (BorderLayout) dateBatDau.getLayout();
		bl_dateBatDau.setVgap(25);
		bl_dateBatDau.setHgap(40);
		dateBatDau.setDateFormatString("dd/MM/yyyy");
		
		lblNgayKetThuc = new JLabel("Ngày kết thúc");
		lblNgayKetThuc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayKetThuc.setBounds(412, 99, 100, 30);
		pnl_InfoVoucher.add(lblNgayKetThuc);
		
		pnl_NgayKetThuc = new JPanel();
		pnl_NgayKetThuc.setBounds(522, 102, 155, 30);
		pnl_InfoVoucher.add(pnl_NgayKetThuc);
		
		dateKetThuc = new JDateChooser();
		BorderLayout bl_dateKetThuc = (BorderLayout) dateKetThuc.getLayout();
		bl_dateKetThuc.setVgap(25);
		bl_dateKetThuc.setHgap(40);
		dateKetThuc.setDateFormatString("dd/MM/yyyy");
		pnl_NgayKetThuc.add(dateKetThuc);
		
		JLabel lblNewLabel = new JLabel("Nhập Thông Tin Voucher");
		lblNewLabel.setForeground(new Color(193, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(267, 0, 234, 46);
		pnl_InfoVoucher.add(lblNewLabel);

	

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
		}
		else {
//			lbl_TrangThai.setVisible(false);
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
		    spn_PhanTramGiamGia.setValue(vc.getPhanTramGiamTheoHoaDon());
		    txtMoTa.setText(vc.getMoTaChuongTrinh());
		    spn_SoLuotDung.setValue(vc.getSoLuotDung());
		    lbl_CurentTrangThai.setText(vc.isTrangThai() ? "Đang hoạt động" : "Đã ngưng");

		    // Ẩn hoặc hiện checkbox dựa trên trạng thái
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
	 * @param ma
	 * @return
	 */
	public String createMaVoucher(String ma) {
		System.out.println(ma);
		
		int id = Integer.parseInt(ma.substring(3));
		if (id < 9) {
			id++;
			return "VC000" + id ;
		} else if (id < 99) {
			id++;
			return "VC00" + id ;
		} else if (id < 999) {
			id++;
			return "VC0" + id ;
		}
		id++;
		return "VC" + id ;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	  if (e.getSource().equals(btn_Save)) {
        saveVoucher();
	  }
    }
	
	private void saveVoucher() {
        String ten = txt_Ten.getText().trim();
        int phanTramGiamGia = (int) spn_PhanTramGiamGia.getValue();
        String moTa = txtMoTa.getText().trim();
        int soLuotDung = (int) spn_SoLuotDung.getValue();
        boolean trangThai = ckb_kichhoat.isSelected();
        String ngayBatDau = formatDate(dateBatDau.getDate());
        String ngayKetThuc = formatDate(dateKetThuc.getDate());

        if (ten.isEmpty() || moTa.isEmpty()) {
            System.out.println("Vui lòng nhập đầy đủ thông tin Voucher.");
        } else {
            VoucherGiamGia newVoucher = new VoucherGiamGia();
            newVoucher.setMaVoucher(createMaVoucher(newMa));
            newVoucher.setTenVoucher(ten);
            newVoucher.setPhanTramGiamTheoHoaDon(phanTramGiamGia);
            newVoucher.setMoTaChuongTrinh(moTa);
            newVoucher.setSoLuotDung(soLuotDung);
            newVoucher.setTrangThai(trangThai);

            // Kiểm tra và định dạng ngày bắt đầu
            if (dateBatDau.getDate() != null) {
                newVoucher.setNgayBatDau(dateBatDau.getDate());
            }

            // Kiểm tra và định dạng ngày kết thúc
            if (dateKetThuc.getDate() != null) {
                newVoucher.setNgayKetThuc(dateKetThuc.getDate());
            }

            if (dao_Voucher.saveOrUpdateVoucher(newVoucher)) {
                System.out.println("Lưu Voucher thành công.");
                reText();
            } else {
                System.out.println("Lưu Voucher thất bại.");
            }
        }
    }


    private String formatDate(java.util.Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return (date != null) ? sdf.format(date) : "";
    }
}