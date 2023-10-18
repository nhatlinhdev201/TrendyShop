package gui.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import constance.SetBountJPanel;

public class TrangThongKeAdminJPanel extends JPanel implements ActionListener{
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public TrangThongKeAdminJPanel() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trang Thong ke cho admin");
		lblNewLabel.setBounds(618, 361, 181, 14);
		add(lblNewLabel);
		
		btnNewButton = new JButton("Test");
		btnNewButton.setBounds(698, 242, 89, 23);
		add(btnNewButton);
		
		btnNewButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnNewButton)) {
			JOptionPane.showMessageDialog(this, "OK");
		}
		
	}
}
