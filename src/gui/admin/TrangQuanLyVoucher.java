package gui.admin;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constance.SetBountJPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Graphics;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;

public class TrangQuanLyVoucher extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public TrangQuanLyVoucher() {
		setForeground(new Color(96, 96, 176));
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trang Huong dan");
		lblNewLabel.setBounds(618, 361, 181, 14);
		add(lblNewLabel);
		
		JPanel panel_Header = new JPanel();
		panel_Header.setBackground(new Color(192, 192, 192));
		panel_Header.setBounds(0, 0, 1350, 47);
		add(panel_Header);
		
		JLabel lblTitel = new JLabel("QUẢN LÝ VOUCHER");
		lblTitel.setForeground(new Color(91, 91, 174));
		lblTitel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		panel_Header.add(lblTitel);
		
		JPanel pnl_Header = new JPanel();
		pnl_Header.setLayout(null);
		pnl_Header.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnl_Header.setBackground(new Color(88, 171, 171));
		pnl_Header.setBounds(0, 49, 1350, 50);
		add(pnl_Header);
		
		JPanel pnl_Search = new JPanel() {
			protected void paintComponent(Graphics g) {
			}
		};
		pnl_Search.setLayout(null);
		pnl_Search.setOpaque(false);
		pnl_Search.setBackground(Color.WHITE);
		pnl_Search.setBounds(127, 10, 468, 30);
		pnl_Header.add(pnl_Search);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(135, 2, 288, 26);
		pnl_Search.add(textField);
		
		JPanel pnl_tieuchi = new JPanel();
		pnl_tieuchi.setLayout(null);
		pnl_tieuchi.setBackground(Color.WHITE);
		pnl_tieuchi.setBounds(2, 2, 123, 26);
		pnl_Search.add(pnl_tieuchi);
		
		JLabel lbl_TieuChiSearch = new JLabel("Mã Sản Phẩm");
		lbl_TieuChiSearch.setIconTextGap(5);
		lbl_TieuChiSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TieuChiSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_TieuChiSearch.setBounds(0, 1, 92, 24);
		pnl_tieuchi.add(lbl_TieuChiSearch);
		
		JLabel lbl_IconDropDown = new JLabel("");
		lbl_IconDropDown.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(119, 136, 153)));
		lbl_IconDropDown.setBounds(100, 1, 26, 24);
		pnl_tieuchi.add(lbl_IconDropDown);
		
		JLabel lbl_iconSearch = new JLabel("");
		lbl_iconSearch.setBounds(433, 2, 26, 26);
		pnl_Search.add(lbl_iconSearch);
		
		JButton btn_add = new JButton("Thêm");
		btn_add.setIconTextGap(10);
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_add.setFocusable(false);
		btn_add.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_add.setBackground(SystemColor.info);
		btn_add.setBounds(826, 10, 100, 30);
		pnl_Header.add(btn_add);
		
		JButton btn_edit = new JButton("Sửa");
		btn_edit.setIconTextGap(10);
		btn_edit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_edit.setFocusable(false);
		btn_edit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_edit.setBackground(SystemColor.info);
		btn_edit.setBounds(1026, 10, 100, 30);
		pnl_Header.add(btn_edit);
		
		JButton btn_delete = new JButton("Xoá");
		btn_delete.setIconTextGap(10);
		btn_delete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_delete.setFocusable(false);
		btn_delete.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_delete.setBackground(SystemColor.info);
		btn_delete.setBounds(1226, 10, 100, 30);
		pnl_Header.add(btn_delete);
		
		JLabel lbl_timkiem = new JLabel("Tìm Kiếm Theo:");
		lbl_timkiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_timkiem.setBounds(10, 10, 120, 30);
		pnl_Header.add(lbl_timkiem);
		
		JPanel pnl_TableHangHoa = new JPanel();
		pnl_TableHangHoa.setBounds(0, 50, 1350, 605);
		pnl_Header.add(pnl_TableHangHoa);
		pnl_TableHangHoa.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 2),
						"Danh S\u00E1ch H\u00E0ng Ho\u00E1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_TableHangHoa.setBackground(new Color(102, 205, 170));
		pnl_TableHangHoa.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JScrollPane scr_hanghoa = new JScrollPane();
		scr_hanghoa.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scr_hanghoa.setPreferredSize(new Dimension(1335, 580));
		scr_hanghoa.setForeground(Color.BLACK);
		scr_hanghoa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scr_hanghoa.setFocusable(false);
		scr_hanghoa.setEnabled(false);
		scr_hanghoa.setBorder(null);
		scr_hanghoa.setBackground(new Color(102, 205, 170));
		pnl_TableHangHoa.add(scr_hanghoa);
	}

}