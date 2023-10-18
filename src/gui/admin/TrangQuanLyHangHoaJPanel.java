package gui.admin;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constance.SetBountJPanel;

public class TrangQuanLyHangHoaJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrangQuanLyHangHoaJPanel() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trang Quan Ly Hang hoa");
		lblNewLabel.setBounds(618, 361, 181, 14);
		add(lblNewLabel);

	}

}
