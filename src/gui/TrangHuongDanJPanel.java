package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constance.SetBountJPanel;

public class TrangHuongDanJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrangHuongDanJPanel() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trang Huong dan");
		lblNewLabel.setBounds(618, 361, 181, 14);
		add(lblNewLabel);
	}

}