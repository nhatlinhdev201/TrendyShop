package gui.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import constance.SetBountJPanel;

public class TrangTimKiemHoaDon extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrangTimKiemHoaDon() {
		/*Thiết lập jpanel cho trang bán hàng*/
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		/*Tạo 2 button menu cho trang Quản lý bán hàng*/
		JPanel menu = new JPanel();
		menu.setBounds(0, 0, 1370, 43);
		add(menu);
		menu.setLayout(null);
		/*Button lập hóa đơn*/
		JButton btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		btnLapHoaDon.setBackground(new Color(39, 224, 224));
		btnLapHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLapHoaDon.setBounds(0, 0, 187, 43);
		menu.add(btnLapHoaDon);
		
//		Button tìm kiếm hóa đơn
		JButton btnTimHoaDon = new JButton("Tìm kiếm hóa đơn");
		btnTimHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		btnTimHoaDon.setBackground(new Color(255, 255, 255));
		btnTimHoaDon.setBounds(184, 0, 229, 43);
		menu.add(btnTimHoaDon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 128));
		panel_1.setBounds(1253, 0, 55, 43);
		menu.add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 40, 1350, 661);
		add(panel);
		panel.setLayout(null);
	}	
}
