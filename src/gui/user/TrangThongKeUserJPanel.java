package gui.user;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constance.SetBountJPanel;

public class TrangThongKeUserJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrangThongKeUserJPanel() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trang thong ke cho nhan vien");
		lblNewLabel.setBounds(618, 361, 181, 14);
		add(lblNewLabel);
	}

}
