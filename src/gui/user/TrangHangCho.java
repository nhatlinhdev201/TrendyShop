package gui.user;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class TrangHangCho extends JFrame implements ActionListener{
	private JTextField textField;
	private JButton btn_Thoat;
	private JButton btn_ThanhToan;
	private JButton btn_ThemHangCho;
	private JButton btn_TimHangCho;

	/**
	 * Create the panel.
	 */
	public TrangHangCho() {
		setSize(500, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hàng chờ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 464, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(32, 57, 154, 24);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(208, 59, 229, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btn_Thoat = new JButton("Thoát");
		btn_Thoat.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btn_Thoat.setBackground(new Color(237, 140, 135));
		btn_Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Thoat.setBounds(10, 95, 89, 23);
		getContentPane().add(btn_Thoat);
		
		btn_TimHangCho = new JButton("Tìm");
		btn_TimHangCho.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btn_TimHangCho.setBackground(new Color(153, 188, 247));
		btn_TimHangCho.setBounds(108, 95, 89, 23);
		getContentPane().add(btn_TimHangCho);
		
		btn_ThemHangCho = new JButton("Thêm hàng chờ");
		btn_ThemHangCho.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btn_ThemHangCho.setBackground(new Color(156, 228, 154));
		btn_ThemHangCho.setBounds(206, 95, 139, 23);
		getContentPane().add(btn_ThemHangCho);
		
		btn_ThanhToan = new JButton("Thanh toán");
		btn_ThanhToan.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btn_ThanhToan.setBackground(new Color(0, 210, 0));
		btn_ThanhToan.setBounds(355, 95, 115, 23);
		getContentPane().add(btn_ThanhToan);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 140, 464, 221);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Abstract Table");
		panel.add(lblNewLabel_2);
		
		
		
		
		
		
//		
		btn_Thoat.addActionListener(this);
		btn_ThanhToan.addActionListener(this);
		btn_ThemHangCho.addActionListener(this);
		btn_TimHangCho.addActionListener(this);
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btn_Thoat)) {
			this.dispose();
		}else if(o.equals(btn_ThanhToan)) {
//			Thực hiện thêm thông tin từ hàng chờ sang hóa đơn
//			Hỏi có muốn thực hiện k
			if(true) {/*Biểu thức kiểm tra xem trang lập hóa đơn có trống kh*/
				int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn tiếp tục không? Nếu tiếp tục sẽ mất dữ liệu đã nhập", "Xác nhận", JOptionPane.YES_NO_OPTION);

		        if (choice == JOptionPane.YES_OPTION) {
		        	/*Chọn yes thì làm rỗng trang lập hóa đơn và load dữ liệu lên*/
		        	
		        	this.dispose();
		        } 
			}else {
				
			}
		}
	}
}
