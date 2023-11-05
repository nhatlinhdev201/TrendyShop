package gui.user;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class TrangThongTinKhachHang extends JFrame {

	/**
	 * Create the panel.
	 */
	public TrangThongTinKhachHang() {
		getContentPane().setFont(new Font("Monospaced", Font.PLAIN, 13));
		
		setSize(407, 213);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SĐT:");
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel.setBounds(38, 59, 130, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(38, 84, 130, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Trạng thái:");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(38, 109, 130, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Điểm tích lũy:");
		lblNewLabel_3.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(38, 134, 130, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblNewLabel_4.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(28, 15, 338, 33);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lbl_SDT = new JLabel("");
		lbl_SDT.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_SDT.setBounds(208, 59, 145, 14);
		getContentPane().add(lbl_SDT);
		
		JLabel lbl_TenKhachHang = new JLabel("");
		lbl_TenKhachHang.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_TenKhachHang.setBounds(208, 84, 145, 14);
		getContentPane().add(lbl_TenKhachHang);
		
		JLabel lbl_TrangThai = new JLabel("");
		lbl_TrangThai.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_TrangThai.setBounds(208, 109, 145, 14);
		getContentPane().add(lbl_TrangThai);
		
		JLabel lbl_DiemTichLuy = new JLabel("");
		lbl_DiemTichLuy.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lbl_DiemTichLuy.setBounds(208, 134, 145, 14);
		getContentPane().add(lbl_DiemTichLuy);

	}
	public static void main(String[] args) {
		TrangThongTinKhachHang tt = new TrangThongTinKhachHang();
		tt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tt.setVisible(true);
	}
}
