package gui;

import javax.swing.JPanel;

import constance.SetBountJPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class TrangQLKhachHangPanel extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public TrangQLKhachHangPanel() {
		setBackground(new Color(255, 255, 255));
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);

        // Load ảnh từ tệp
        ImageIcon originalIcon = new ImageIcon(TrangQLKhachHangPanel.class.getResource("/images/man.png"));
        Image img = originalIcon.getImage(); // Chuyển ImageIcon thành Image

        // Chỉnh kích thước ảnh
        Image newImg = img.getScaledInstance(180, 180, Image.SCALE_SMOOTH);

        // Tạo ImageIcon mới từ ảnh đã chỉnh kích thước
        ImageIcon resizedIcon = new ImageIcon(newImg);
        
        JTable table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));

		// Tạo font mới với kích cỡ chữ là 20 cho tiêu đề cột
		Font headerFont = new Font("Tahoma", Font.BOLD, 15);

		// Set model cho JTable
		table.setModel(new DefaultTableModel(
		    new Object[][] {
		    },
		    new String[] {
		        "STT", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Email", "Địa chỉ", "Trạng thái", "Điểm tích lũy"
		    }
		));
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(473, 48, 867, 642);
        add(scrollPane);
        
        JLabel lbl_makh = new JLabel("Mã khách hàng :");
        lbl_makh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbl_makh.setBounds(92, 312, 123, 21);
        add(lbl_makh);
        
        textField = new JTextField();
        textField.setBounds(217, 312, 146, 20);
        add(textField);
        textField.setColumns(10);
        
        JLabel lblTnKhchHng = new JLabel("Tên khách hàng :");
        lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTnKhchHng.setBounds(92, 350, 123, 21);
        add(lblTnKhchHng);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(217, 350, 146, 20);
        add(textField_1);
        
        JLabel lblSinThoai = new JLabel("Số điện thoai :");
        lblSinThoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSinThoai.setBounds(92, 384, 123, 21);
        add(lblSinThoai);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(217, 384, 146, 20);
        add(textField_2);
        
        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setFont(new Font("Sylfaen", Font.PLAIN, 15));
        lblEmail.setBounds(92, 418, 123, 21);
        add(lblEmail);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(217, 418, 146, 20);
        add(textField_3);
        
        JLabel lblaCh = new JLabel("Địa chỉ :");
        lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblaCh.setBounds(92, 456, 123, 21);
        add(lblaCh);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(217, 456, 146, 20);
        add(textField_4);
        
        JLabel lblTrngThi = new JLabel("Trạng thái  :");
        lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTrngThi.setBounds(92, 488, 123, 21);
        add(lblTrngThi);
        
        JLabel lblimTchLu = new JLabel("Điểm tích luỹ :");
        lblimTchLu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblimTchLu.setBounds(92, 526, 123, 21);
        add(lblimTchLu);
        
        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(217, 526, 146, 20);
        add(textField_6);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Hoạt động");
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
        rdbtnNewRadioButton.setBounds(217, 487, 95, 23);
        add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNgh = new JRadioButton("Nghỉ");
        rdbtnNgh.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnNgh.setBackground(new Color(255, 255, 255));
        rdbtnNgh.setBounds(314, 487, 75, 23);
        add(rdbtnNgh);
        
        JLabel lblNewLabel = new JLabel("Thông tin khách hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblNewLabel.setBounds(79, 23, 310, 33);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(TrangQLKhachHangPanel.class.getResource("/images/man.png")));
        lblNewLabel_1.setBounds(145, 96, 167, 149);
        add(lblNewLabel_1);
        
        
	}
}
