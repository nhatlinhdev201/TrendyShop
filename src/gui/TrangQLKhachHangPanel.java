package gui;

import javax.swing.JPanel;

import constance.SetBountJPanel;
import javax.swing.JLabel;

public class TrangQLKhachHangPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrangQLKhachHangPanel() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trang Khach Hang");
		lblNewLabel.setBounds(618, 361, 181, 14);
		add(lblNewLabel);
	}
}
