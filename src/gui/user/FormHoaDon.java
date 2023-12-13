package gui.user;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import daos.Dao_ChiTietHoaDon;
import daos.Dao_HangHoa;
import daos.Dao_NhanVien;
import entities.ChiTietHoaDon;
import entities.HangHoa;
import entities.HoaDon;
import entities.NhanVien;

import java.awt.Container;

public class FormHoaDon extends JFrame implements WindowListener{

    private JPanel contentPane;
	private Container panel_1;
	private HoaDon hoaDonDuocIn;
	private Dao_HangHoa daoHangHoa;
	private Dao_ChiTietHoaDon daoChiTietHoaDon;
	private List<ChiTietHoaDon> listChiTiet;
	private Dao_NhanVien dao_NhanVien;

	private DecimalFormat decimalFormat = new DecimalFormat("#,##0");
	private TrangBanHangJPanel banHangPanel;
	private NhanVien nv;

   

    public FormHoaDon(TrangBanHangJPanel banHangJPanel ,HoaDon hoaDon) {
    	daoChiTietHoaDon = new Dao_ChiTietHoaDon();
    	daoHangHoa = new Dao_HangHoa();
    	dao_NhanVien= new Dao_NhanVien();
    	
    	hoaDonDuocIn = hoaDon;
    	listChiTiet = daoChiTietHoaDon.getChiTietTheoMaHoaDon(hoaDon.getMaHoaDon());
    	banHangPanel = banHangJPanel;
    	nv = dao_NhanVien.getNhanVienTheoMa(hoaDon.getNguoiLapHoaDon().getMaNhanVien());
    	
		setBounds(100, 100, 480, 690);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        setContentPane(contentPane);
        panel_1 = new JPanel();
                                                             
        final JScrollPane scroll = new JScrollPane(panel_1);
        getContentPane().setLayout(new BorderLayout());
        contentPane.add(scroll);
        
 
        
        DanhSachHoaDon();
        
        addWindowListener(this);
        
        
        
    }
    
    public void DanhSachHoaDon() {
        
        JPanel p = new JPanel();
        panel_1.add(p);
        GridBagLayout gbl_p = new GridBagLayout();
        gbl_p.columnWidths = new int[]{0};
        gbl_p.rowHeights = new int[]{0};
        gbl_p.columnWeights = new double[]{Double.MIN_VALUE};
        gbl_p.rowWeights = new double[]{Double.MIN_VALUE};
        p.setLayout(gbl_p);
        GridBagConstraints c = new GridBagConstraints();
        
        JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 232);
		p.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cửa hàng Trendy Shop");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 414, 39);
		panel_1.add(lblNewLabel);
		
		JLabel lblaCh = new JLabel("12 Nguyễn Văn Bảo, P4, Gò Vấp, TP.HCM");
		lblaCh.setHorizontalAlignment(SwingConstants.CENTER);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaCh.setBounds(10, 38, 414, 21);
		panel_1.add(lblaCh);
		
		JLabel lblTell = new JLabel("Tell:  0981209501  -  0365227701");
		lblTell.setHorizontalAlignment(SwingConstants.CENTER);
		lblTell.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTell.setBounds(10, 60, 414, 21);
		panel_1.add(lblTell);
		
		JLabel lblHanBn = new JLabel("HÓA ĐƠN BÁN HÀNG");
		lblHanBn.setHorizontalAlignment(SwingConstants.CENTER);
		lblHanBn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHanBn.setBounds(10, 87, 414, 28);
		panel_1.add(lblHanBn);
		
		JLabel lblaCh_1 = new JLabel("Mã HD:");
		lblaCh_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblaCh_1.setBounds(10, 124, 56, 21);
		panel_1.add(lblaCh_1);
		
		JLabel lblaCh_1_1 = new JLabel("Ngày:");
		lblaCh_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblaCh_1_1.setBounds(10, 147, 56, 21);
		panel_1.add(lblaCh_1_1);
		
		JLabel lblaCh_1_2 = new JLabel("Mã NV:");
		lblaCh_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblaCh_1_2.setBounds(216, 126, 57, 21);
		panel_1.add(lblaCh_1_2);
		
		JLabel lblaCh_1_3 = new JLabel("Giờ:");
		lblaCh_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblaCh_1_3.setBounds(216, 147, 57, 21);
		panel_1.add(lblaCh_1_3);
		
		JLabel lbl_MaHD = new JLabel(hoaDonDuocIn.getMaHoaDon().trim());
		lbl_MaHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_MaHD.setBounds(65, 126, 141, 21);
		panel_1.add(lbl_MaHD);
		
		JLabel lbl_Ngay = new JLabel(hoaDonDuocIn.getThoiGianTao().toString());
		lbl_Ngay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Ngay.setBounds(65, 147, 141, 21);
		panel_1.add(lbl_Ngay);
		
		JLabel lbl_MaNV = new JLabel(nv.getMaNhanVien());
		lbl_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_MaNV.setBounds(283, 126, 141, 21);
		panel_1.add(lbl_MaNV);
		
		
		JLabel lbl_Gio = new JLabel(LocalTime.now().toString());
		lbl_Gio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Gio.setBounds(283, 151, 141, 21);
		panel_1.add(lbl_Gio);
		
		JLabel lblNewLabel_1 = new JLabel("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		lblNewLabel_1.setBounds(10, 179, 414, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblaCh_1_4 = new JLabel("Size");
		lblaCh_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblaCh_1_4.setBounds(38, 204, 56, 21);
		panel_1.add(lblaCh_1_4);
		
		JLabel lblaCh_1_4_1 = new JLabel("SL");
		lblaCh_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblaCh_1_4_1.setBounds(116, 204, 57, 21);
		panel_1.add(lblaCh_1_4_1);
		
		JLabel lblaCh_1_4_2 = new JLabel("Đơn giá");
		lblaCh_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblaCh_1_4_2.setBounds(190, 204, 108, 21);
		panel_1.add(lblaCh_1_4_2);
		
		JLabel lblaCh_1_4_3 = new JLabel("Thành tiền");
		lblaCh_1_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh_1_4_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblaCh_1_4_3.setBounds(289, 204, 121, 21);
		panel_1.add(lblaCh_1_4_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		lblNewLabel_1_1.setBounds(10, 222, 414, 14);
		panel_1.add(lblNewLabel_1_1);
        
		c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.WEST;
        c.ipadx = 434;
        c.ipady = 243;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 0;
        p.add(panel_1, c);

        
        double tongTienHang = 0;
        double tongThanhTien = hoaDonDuocIn.getTongThanhTien();
        double tienGiamGia = hoaDonDuocIn.getVoucher().getPhanTramGiamTheoHoaDon();
        for(int i=1; i<=listChiTiet.size(); i++) {
        	
        	ChiTietHoaDon chiTiet = listChiTiet.get(i-1);
        	HangHoa hangHoa = daoHangHoa.getHangHoaByMaHangHao(chiTiet.getHangHoa().getMaHangHoa());
        	
			JPanel panel_SanPham = new JPanel();
			panel_SanPham.setBounds(0, 293, 434, 59);
			panel_SanPham.setLayout(null);
			
			JLabel lblaCh_1_4_4 = new JLabel(hangHoa.getTenHangHoa());
			lblaCh_1_4_4.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblaCh_1_4_4.setBounds(10, 0, 414, 21);
			panel_SanPham.add(lblaCh_1_4_4);
			
			JLabel lblaCh_1_4_5 = new JLabel(hangHoa.getKichCo());
			lblaCh_1_4_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblaCh_1_4_5.setBounds(38, 22, 56, 21);
			panel_SanPham.add(lblaCh_1_4_5);
			
			JLabel lblaCh_1_4_1_1 = new JLabel(""+chiTiet.getSoLuong());
			lblaCh_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblaCh_1_4_1_1.setBounds(116, 22, 57, 21);
			panel_SanPham.add(lblaCh_1_4_1_1);
			
			JLabel lblaCh_1_4_2_1 = new JLabel(decimalFormat.format(chiTiet.getGiaBan()));
			lblaCh_1_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblaCh_1_4_2_1.setBounds(190, 22, 108, 21);
			panel_SanPham.add(lblaCh_1_4_2_1);
			
			JLabel lblaCh_1_4_3_1 = new JLabel(decimalFormat.format(chiTiet.getThanhTien()));
			lblaCh_1_4_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblaCh_1_4_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblaCh_1_4_3_1.setBounds(289, 22, 121, 21);
			panel_SanPham.add(lblaCh_1_4_3_1);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			lblNewLabel_1_1_1.setBounds(10, 46, 414, 14);
			panel_SanPham.add(lblNewLabel_1_1_1);
			c.fill = GridBagConstraints.NONE;
            c.anchor = GridBagConstraints.WEST;
            c.ipadx = 434;
            c.ipady = 59;
            c.gridwidth = 1;
            c.gridx = 1;
            c.gridy = i;
            p.add(panel_SanPham, c);
            
            
            tongTienHang += chiTiet.getThanhTien();
		}
		
		JPanel panel_TinhTong = new JPanel();
		panel_TinhTong.setBounds(0, 374, 434, 243);
		panel_TinhTong.setLayout(null);
		
		JLabel lblaCh_1_4_6 = new JLabel("Tổng tiền hàng:");
		lblaCh_1_4_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblaCh_1_4_6.setBounds(133, 0, 125, 21);
		panel_TinhTong.add(lblaCh_1_4_6);
		
		JLabel lblaCh_1_4_6_1 = new JLabel("Thuế (10%):");
		lblaCh_1_4_6_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblaCh_1_4_6_1.setBounds(133, 24, 125, 21);
		panel_TinhTong.add(lblaCh_1_4_6_1);
		
		JLabel lblaCh_1_4_6_2 = new JLabel("Giảm giá (0%):");
		lblaCh_1_4_6_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblaCh_1_4_6_2.setBounds(133, 48, 125, 21);
		panel_TinhTong.add(lblaCh_1_4_6_2);
		
		JLabel lblaCh_1_4_6_2_1 = new JLabel("Điểm tích lũy:");
		lblaCh_1_4_6_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblaCh_1_4_6_2_1.setBounds(133, 72, 125, 21);
		panel_TinhTong.add(lblaCh_1_4_6_2_1);
		
		JLabel lblaCh_1_4_6_2_2 = new JLabel("Tổng thành tiền:");
		lblaCh_1_4_6_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblaCh_1_4_6_2_2.setBounds(133, 111, 125, 21);
		panel_TinhTong.add(lblaCh_1_4_6_2_2);
		
		JLabel lblaCh_1_4_6_2_3 = new JLabel(decimalFormat.format(hoaDonDuocIn.getTongThanhTien()));
		lblaCh_1_4_6_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh_1_4_6_2_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblaCh_1_4_6_2_3.setBounds(268, 111, 143, 21);
		panel_TinhTong.add(lblaCh_1_4_6_2_3);
		
		
		
		JLabel lblaCh_1_4_6_3 = new JLabel(decimalFormat.format(tongTienHang));
		lblaCh_1_4_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh_1_4_6_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblaCh_1_4_6_3.setBounds(285, 0, 125, 21);
		panel_TinhTong.add(lblaCh_1_4_6_3);
		
		JLabel lblaCh_1_4_6_1_1 = new JLabel(decimalFormat.format(tongTienHang*0.1));
		lblaCh_1_4_6_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh_1_4_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblaCh_1_4_6_1_1.setBounds(285, 24, 125, 21);
		panel_TinhTong.add(lblaCh_1_4_6_1_1);
		
		tienGiamGia = (tongTienHang+tongTienHang*0.1)*tienGiamGia;
		JLabel lblaCh_1_4_6_2_4 = new JLabel(decimalFormat.format(tienGiamGia));
		lblaCh_1_4_6_2_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh_1_4_6_2_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblaCh_1_4_6_2_4.setBounds(285, 48, 125, 21);
		panel_TinhTong.add(lblaCh_1_4_6_2_4);
		
		JLabel lblaCh_1_4_6_2_1_1 = new JLabel(decimalFormat.format(tongTienHang+tongTienHang*0.1-tienGiamGia-tongThanhTien));
		lblaCh_1_4_6_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh_1_4_6_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblaCh_1_4_6_2_1_1.setBounds(285, 72, 125, 21);
		panel_TinhTong.add(lblaCh_1_4_6_2_1_1);
		
		JLabel lblCmnQu = new JLabel("CẢM ƠN QUÝ KHÁCH");
		lblCmnQu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCmnQu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCmnQu.setBounds(10, 174, 414, 28);
		panel_TinhTong.add(lblCmnQu);
		
		JLabel lblHnGpLi = new JLabel("Hẹn gặp lại !!!");
		lblHnGpLi.setHorizontalAlignment(SwingConstants.CENTER);
		lblHnGpLi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHnGpLi.setBounds(10, 198, 414, 28);
		panel_TinhTong.add(lblHnGpLi);
		
		
		c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.WEST;
        c.ipadx = 434;
        c.ipady = 243;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy =listChiTiet.size()+1 ;
        p.add(panel_TinhTong, c);
        
        
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Closed");
		banHangPanel.switchContent(new TrangBanHangJPanel(nv, null));
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    

}