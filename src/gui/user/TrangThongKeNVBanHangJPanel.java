package gui.user;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constance.ModelThongKeDoanhThu;
import constance.ModelThongKeNVBanHang;
import constance.SetBountJPanel;
import entities.HoaDon;
import entities.NhanVien;
import services.ThongKeNVBanHangServices;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TrangThongKeNVBanHangJPanel extends JPanel implements ActionListener{
	private JTextField txtTongHoaDonDaLap;
	private JTextField txtTongSoMatHangDaBan;
	private JTextField txtTongDoanhThuBanHang;
	private JTable tblBangHoaDon;
	private JPanel panelBieuDo;
	private JButton btnLamMoi;
	private String[] cols = { "Mã HĐ", "Thời gian", "Tổng tiền", "Voucher", "Khách hàng", "Trạng thái TT"};
	private DefaultTableModel modelTable;
	private NhanVien nv = new NhanVien("NV0002");

	/**
	 * Create the panel.
	 */
	public TrangThongKeNVBanHangJPanel() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("KẾT QUẢ BÁN HÀNG TRONG NGÀY");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(499, 11, 325, 25);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 47, 1318, 1);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(22, 57, 671, 195);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng số hóa đơn đã lập : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 188, 26);
		panel_1.add(lblNewLabel_1);
		
		txtTongHoaDonDaLap = new JTextField();
		txtTongHoaDonDaLap.setEditable(false);
		txtTongHoaDonDaLap.setBounds(208, 11, 67, 26);
		panel_1.add(txtTongHoaDonDaLap);
		txtTongHoaDonDaLap.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("hóa đơn");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(296, 11, 86, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tổng số mặt hàng đã bán :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 73, 188, 26);
		panel_1.add(lblNewLabel_1_2);
		
		txtTongSoMatHangDaBan = new JTextField();
		txtTongSoMatHangDaBan.setEditable(false);
		txtTongSoMatHangDaBan.setColumns(10);
		txtTongSoMatHangDaBan.setBounds(208, 73, 67, 26);
		panel_1.add(txtTongSoMatHangDaBan);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("mặt hàng");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(296, 73, 86, 26);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tổng doanh thu bán hàng : ");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 128, 188, 26);
		panel_1.add(lblNewLabel_1_2_1);
		
		txtTongDoanhThuBanHang = new JTextField();
		txtTongDoanhThuBanHang.setEditable(false);
		txtTongDoanhThuBanHang.setColumns(10);
		txtTongDoanhThuBanHang.setBounds(208, 128, 174, 26);
		panel_1.add(txtTongDoanhThuBanHang);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("vnđ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(392, 128, 86, 26);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "H\u00D3A \u0110\u01A0N \u0110\u00C3 T\u1EA0O", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panel_3.setBounds(22, 263, 671, 399);
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		modelTable = new DefaultTableModel(cols, 0);
		tblBangHoaDon = new JTable(modelTable);
		panel_3.add(new JScrollPane(tblBangHoaDon), BorderLayout.CENTER);
		TableColumn column = tblBangHoaDon.getColumnModel().getColumn(2);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        column.setCellRenderer(renderer);
		
		panelBieuDo = new JPanel();
		panelBieuDo.setBackground(Color.WHITE);
		panelBieuDo.setBorder(null);
		panelBieuDo.setBounds(719, 59, 621, 516);
		add(panelBieuDo);
		
		btnLamMoi = new JButton("Làm mới ");
		btnLamMoi.setBounds(964, 618, 162, 33);
		btnLamMoi.addActionListener(this);
		add(btnLamMoi);
		thongKe();
	}
	
	public String ChuyenThanhTien(double money) {
		long roundedMoney = Math.round(money);
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String formattedMoney = decimalFormat.format(roundedMoney);
		return formattedMoney;
	}
	private static String layGio(String sqlDateTime) {
        try {
            SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date date = sqlDateFormat.parse(sqlDateTime);
            SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
            return hourFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
	public void thongKe() {
		ThongKeNVBanHangServices services = new ThongKeNVBanHangServices();
		loadDuLieu(nv);
		loadDataToTable(modelTable, services.layDanhSachHoaDon(nv, LocalDate.now()));
		veBieuDo(nv);
	}
	public void loadDataToTable(DefaultTableModel model, ArrayList<HoaDon> dataTable) {
		model.setRowCount(0);
		for (HoaDon data : dataTable) {
			model.addRow(new Object[] {data.getMaHoaDon().trim(), layGio(data.getThoiGianTao().toString()), ChuyenThanhTien(data.getTongThanhTien()), data.getVoucher()==null?"không":data.getVoucher().getMaVoucher().trim(), data.getKhachHang()==null?"không":data.getKhachHang().getMaKhachHang().trim()});
		}
	}
	
	public void loadDuLieu(NhanVien nv) {
		ThongKeNVBanHangServices services = new ThongKeNVBanHangServices();
		ModelThongKeNVBanHang model = new ModelThongKeNVBanHang();
		model = services.layThongTinThongKe(LocalDate.now(), nv);
		txtTongDoanhThuBanHang.setText(ChuyenThanhTien(model.getTongDoanhThuBanHang()));
		txtTongHoaDonDaLap.setText(ChuyenThanhTien(model.getTongHoaDonDaLap()));
		txtTongSoMatHangDaBan.setText(ChuyenThanhTien(model.getTongMatHangDaBan()));
	}
	
	public void veBieuDo(NhanVien nv) {
		ThongKeNVBanHangServices services = new ThongKeNVBanHangServices();
        ArrayList<ModelThongKeNVBanHang> data = services.layThongTinThongKe5NgayGanNhat(LocalDate.now(), nv);
		services.veBieuDo(data, panelBieuDo, LocalDate.now(), nv);
	}
	
	public String formatCurrency(float money) {
        long roundedMoney = Math.round(money);
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedMoney = decimalFormat.format(roundedMoney);
        return formattedMoney;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
