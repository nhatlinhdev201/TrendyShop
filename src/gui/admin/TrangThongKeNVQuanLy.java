package gui.admin;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import constance.SetBountJPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class TrangThongKeNVQuanLy extends JPanel implements ActionListener{

	private TK_ThongKeMatHangBanChayNVQuanLyPanel panelThongKeBanHang;
	private TK_ThongKeDoanhThuNVQuanLyJPanel panelThongKeDoanhThu;
	

	/**
	 * Create the panel.
	 */
	public TrangThongKeNVQuanLy() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		panelThongKeBanHang = new TK_ThongKeMatHangBanChayNVQuanLyPanel();
		panelThongKeDoanhThu = new TK_ThongKeDoanhThuNVQuanLyJPanel();
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(Color.RED));
		tabbedPane.setBounds(0, 11, 1350, 690);
		add(tabbedPane);
		
		JPanel panelCN_CNThongKeDoanhThu = new JPanel();
		panelCN_CNThongKeDoanhThu.setLayout(null);
		tabbedPane.addTab("THỐNG KÊ DOANH THU", null, panelCN_CNThongKeDoanhThu, null);
		panelThongKeDoanhThu.setBorder(new LineBorder(Color.RED));
		panelThongKeDoanhThu.setBounds(0, 11, 1350, 657);
		panelCN_CNThongKeDoanhThu.add(panelThongKeDoanhThu);
		
		JPanel panelCN_CNThongKeBanHang = new JPanel();
		panelCN_CNThongKeBanHang.setLayout(null);
		tabbedPane.addTab("THỐNG KÊ MẶT HÀNG BÁN CHẠY", null, panelCN_CNThongKeBanHang, null);
		panelThongKeBanHang.setBorder(new LineBorder(Color.RED));
		panelThongKeBanHang.setBounds(0, 11, 1350, 657);
		panelCN_CNThongKeBanHang.add(panelThongKeBanHang);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
	}
}