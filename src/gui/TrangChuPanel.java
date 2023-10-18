package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import constance.SetBountJPanel;

public class TrangChuPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrangChuPanel() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trang Chu");
		lblNewLabel.setBounds(618, 361, 181, 14);
		add(lblNewLabel);
	}
	
}
