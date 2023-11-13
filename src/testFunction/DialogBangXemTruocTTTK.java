package testFunction;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class DialogBangXemTruocTTTK extends JPanel {

	/**
	 * Create the panel.
	 */
	public DialogBangXemTruocTTTK() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 29, 1250, 602);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Xuất dữ liệu");
		btnNewButton.setBounds(453, 545, 142, 30);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Hủy");
		btnNewButton_1.setBounds(628, 545, 130, 30);
		panel.add(btnNewButton_1);
		
		JPanel panelTable = new JPanel();
		panelTable.setBounds(27, 43, 1189, 491);
		panel.add(panelTable);

	}
}
