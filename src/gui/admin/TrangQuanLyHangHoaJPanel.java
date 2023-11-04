package gui.admin;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constance.SetBountJPanel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TrangQuanLyHangHoaJPanel extends JPanel {
	private JTextField txtNhpMHng;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TrangQuanLyHangHoaJPanel() {
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		JPanel panelHeader_QLHH = new JPanel();
		panelHeader_QLHH.setBounds(0, 0, 1283, 187);
		add(panelHeader_QLHH);
		panelHeader_QLHH.setLayout(null);
		
		JLabel lblHeaderQLHH = new JLabel("QUẢN LÝ HÀNG HÓA");
		lblHeaderQLHH.setForeground(new Color(0, 102, 0));
		lblHeaderQLHH.setBounds(437, 0, 481, 78);
		panelHeader_QLHH.add(lblHeaderQLHH);
		lblHeaderQLHH.setFont(new Font("Times New Roman", Font.BOLD, 44));
		
		JPanel panel_ChucNangQLHH = new JPanel();
		panel_ChucNangQLHH.setBounds(0, 125, 1283, 62);
		panelHeader_QLHH.add(panel_ChucNangQLHH);
		panel_ChucNangQLHH.setLayout(null);
		
		JButton btnNewButton = new JButton("Trở về");
		btnNewButton.setBounds(10, 11, 130, 51);
		panel_ChucNangQLHH.add(btnNewButton);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Tran\\Downloads\\undo-removebg-preview (1).png"));
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setBounds(161, 11, 130, 50);
		panel_ChucNangQLHH.add(btnNewButton_1);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Tran\\Downloads\\add-removebg-preview (1).png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_3 = new JButton("Cập nhật");
		btnNewButton_3.setBounds(316, 11, 137, 51);
		panel_ChucNangQLHH.add(btnNewButton_3);
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Tran\\Downloads\\update-removebg-preview (1).png"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_1_1 = new JButton("Thêm Excel");
		btnNewButton_1_1.setBounds(483, 11, 157, 51);
		panel_ChucNangQLHH.add(btnNewButton_1_1);
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\Tran\\Downloads\\Excel-icon-removebg-preview (1).png"));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel panel_TimKiem = new JPanel();
		panel_TimKiem.setBounds(814, 11, 459, 51);
		panel_ChucNangQLHH.add(panel_TimKiem);
		panel_TimKiem.setLayout(null);
		
		txtNhpMHng = new JTextField();
		txtNhpMHng.setBounds(0, 0, 312, 51);
		panel_TimKiem.add(txtNhpMHng);
		txtNhpMHng.setForeground(new Color(153, 153, 153));
		txtNhpMHng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNhpMHng.setText("Nhập mã hàng hóa");
		txtNhpMHng.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Tìm kiếm");
		btnNewButton_5.setBounds(315, 0, 144, 51);
		panel_TimKiem.add(btnNewButton_5);
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\Tran\\Downloads\\search-removebg-preview (1).png"));
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblDanhSchHng = new JLabel("DANH SÁCH HÀNG HÓA");
		lblDanhSchHng.setForeground(SystemColor.activeCaption);
		lblDanhSchHng.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblDanhSchHng.setBounds(372, 221, 406, 63);
		add(lblDanhSchHng);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 h\u00E0ng h\u00F3a", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(698, 461, -455, -111);
		add(table);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	}
}
