package gui.user;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constance.SetBountJPanel;

public class TrangBanHangJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrangBanHangJPanel() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trang Ban hang");
		lblNewLabel.setBounds(618, 361, 181, 14);
		add(lblNewLabel);
	}

}
