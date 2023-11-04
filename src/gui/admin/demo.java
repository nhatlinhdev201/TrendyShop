package gui.admin;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class demo extends JPanel {
	private int stateFunction;
	

	/**
	 * Create the panel.
	 */
	public demo() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 1, 451, 39);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button1");
		btnNewButton.setBounds(15, 6, 109, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button2");
		btnNewButton_1.setBounds(143, 4, 122, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 43, 448, 254);
		
		JLabel lblNewLabel = new JLabel("New label 1");
		panel_1.add(lblNewLabel);
		
		JPanel panel_11 = new JPanel();
		panel_1.setBounds(0, 43, 448, 254);
		
		JLabel lblNewLabel1 = new JLabel("New label 1");
		panel_1.add(lblNewLabel);
		
		JPanel panel_111 = new JPanel();
		panel_1.setBounds(0, 43, 448, 254);
		
		JLabel lblNewLabel11 = new JLabel("New label 1");
		panel_1.add(lblNewLabel);

	}
}
