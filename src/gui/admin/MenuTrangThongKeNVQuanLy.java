package gui.admin;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import constance.SetBountJPanel;

public class MenuTrangThongKeNVQuanLy extends JPanel implements ActionListener {

	private JPanel panel_TK_ThongKeBanHang;
	private JPanel panel_TK_ThongKeDinhViKe;
	private JButton btnCNThongKeHoaDon;
	private JButton btnCNThongKeDoanhThu;
	private JButton btnCNThongKeBanHang;
	private JPanel menuCN_CNThongKe;
	private JPanel mainPanel;
	private JPanel panelCN_CNThongKe;

	/**
	 * Create the panel.
	 */
	/**
     * @wbp.parser.entryPoint
     */
	public MenuTrangThongKeNVQuanLy() {

		panel_TK_ThongKeBanHang = new TK_ThongKeBanHangJPanel();
		panel_TK_ThongKeDinhViKe = new TK_ThongKeDinhViJPanel();

		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
//		JPanel panelCN_CNThongKe = new JPanel(new BorderLayout());
//		panelCN_CNThongKe.setBounds(0, 33, 1350, 668);
//		add(panelCN_CNThongKe);
//		panelCN_CNThongKe.setLayout(null);
		
		//<===================================>
		panelCN_CNThongKe = new JPanel(new BorderLayout());
		panelCN_CNThongKe.setBounds(0, 33, 1350, 668);
		panelCN_CNThongKe.setLayout(null);

        JPanel contentPanel = new JPanel(new CardLayout());
        contentPanel.add(panel_TK_ThongKeBanHang, "function1");
        panel_TK_ThongKeBanHang.setLayout(null);
        contentPanel.add(panel_TK_ThongKeDinhViKe, "function2");

        panelCN_CNThongKe.add(createMenuPanel(contentPanel), BorderLayout.NORTH);
        panelCN_CNThongKe.add(contentPanel, BorderLayout.CENTER);
        
       this.add(contentPanel);
		//<===================================>
	}
	
	private JPanel createMenuPanel(JPanel contentPanel) {
		menuCN_CNThongKe = new JPanel();
		menuCN_CNThongKe.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		menuCN_CNThongKe.setBounds(0, 0, 1350, 33);
		menuCN_CNThongKe.setLayout(null);

		btnCNThongKeBanHang = new JButton("Thống kê bán hàng");
		btnCNThongKeBanHang.setBackground(new Color(255, 218, 185));
		btnCNThongKeBanHang.setBounds(10, 5, 181, 26);
		btnCNThongKeBanHang.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-home.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnCNThongKeBanHang.setFont(new Font("Tahoma", Font.BOLD, 10));
		menuCN_CNThongKe.add(btnCNThongKeBanHang);

		btnCNThongKeDoanhThu = new JButton("Thống kê doanh thu");
		btnCNThongKeDoanhThu.setBackground(new Color(255, 218, 185));
		btnCNThongKeDoanhThu.setBounds(201, 5, 186, 26);
		btnCNThongKeDoanhThu.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-home.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnCNThongKeDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 10));
		menuCN_CNThongKe.add(btnCNThongKeDoanhThu);

		btnCNThongKeHoaDon = new JButton("Thống kê hóa đơn");
		btnCNThongKeHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCNThongKeHoaDon.setBackground(new Color(255, 218, 185));
		btnCNThongKeHoaDon.setBounds(410, 5, 181, 26);
		btnCNThongKeHoaDon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon-home.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnCNThongKeHoaDon.setFont(new Font("Tahoma", Font.BOLD, 10));
		menuCN_CNThongKe.add(btnCNThongKeHoaDon);

		btnCNThongKeBanHang.addActionListener(e -> ((CardLayout) contentPanel.getLayout()).show(contentPanel, "function1"));
		btnCNThongKeDoanhThu.addActionListener(e -> ((CardLayout) contentPanel.getLayout()).show(contentPanel, "function2"));
        return menuCN_CNThongKe;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnCNThongKeBanHang)) {

		}

	}

}
