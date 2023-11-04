package gui.admin;

import javax.swing.JPanel;
import java.awt.Color;

public class TK_ThongKeDinhViJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TK_ThongKeDinhViJPanel() {
		this.setBounds(0, 0, 1350, 668);
		setLayout(null);
		
		JPanel panelCN_CNThongKe = new JPanel();
		panelCN_CNThongKe.setBackground(Color.RED);
		panelCN_CNThongKe.setBounds(0, 0, 1350, 668);
		add(panelCN_CNThongKe);;
		panelCN_CNThongKe.setLayout(null);
	}

}
