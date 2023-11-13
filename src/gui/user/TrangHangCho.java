package gui.user;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import daos.Dao_HoaDon;
import daos.Dao_KhachHang;
import entities.KhachHang;

import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TrangHangCho extends JFrame implements ActionListener{
	private JTextField textField;
	private JButton btn_Thoat;
	private JButton btn_ThanhToan;
	private JButton btn_ThemHangCho;
	private JButton btn_TimHangCho;
	
	private AbstractTableHangCho model;
	private JTable table;
	private Dao_HoaDon dao_HoaDon;
	private Dao_KhachHang dao_KhachHang;
	private List<KhachHang> list_KhachHangCho;

	/**
	 * Create the panel.
	 */
	public TrangHangCho() {
		
		dao_HoaDon = new Dao_HoaDon();
		dao_KhachHang = new Dao_KhachHang();
		
		list_KhachHangCho = dao_KhachHang.getAllKhachHangCho();
		
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
		
		
		model = new AbstractTableHangCho();
		table = new JTable(model);
		table.setRowHeight(40);
		table.setFont(new Font("Monospaced", Font.PLAIN, 17));
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(270);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.setShowGrid(false);

		table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
		table.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor());
		panel.add(new JScrollPane(table));
		
		for (KhachHang khachHang : list_KhachHangCho) {
			model.addHangCho(khachHang);
		}
		
		
//		
		btn_Thoat.addActionListener(this);
		btn_ThanhToan.addActionListener(this);
		btn_ThemHangCho.addActionListener(this);
		btn_TimHangCho.addActionListener(this);
		
	}

	private class ButtonRenderer extends DefaultTableCellRenderer {
		private JButton button;

		public ButtonRenderer() {

			button = new JButton();
			button.setOpaque(true);
			// Thêm biểu tượng vào nút
			Icon deleteIcon = new ImageIcon(
					new ImageIcon("img\\remove.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			button.setIcon(deleteIcon);
			button.setBackground(new Color(255, 255, 255));
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());

			} else {
				button.setForeground(table.getForeground());
			}
			button.setText(value == null ? "" : value.toString());
			return button;
		}
	}

	private class ButtonEditor extends DefaultCellEditor {
		private JButton button;
		private String label;
		private boolean isPushed;
		private int selectedRow;

		public ButtonEditor() {
			super(new JCheckBox());
			button = new JButton();
			button.setOpaque(true);

			// Thêm biểu tượng vào nút
			Icon deleteIcon = new ImageIcon(
					new ImageIcon("img\\remove.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			button.setIcon(deleteIcon);
			button.setBackground(new Color(255, 255, 255));
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			selectedRow = row;
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
			} else {
				button.setForeground(table.getForeground());
			}
			label = (value == null) ? "" : value.toString();
			button.setText(label);
			isPushed = true;
			return button;
		}

		public Object getCellEditorValue() {
			if (isPushed) {
				// Xử lý sự kiện khi nút được nhấn
				int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa !!", "Xác nhận",
						JOptionPane.YES_NO_OPTION);

				if (choice == JOptionPane.YES_OPTION) {
					model.removeHangCho(selectedRow);
				}

			}
			isPushed = false;
			return label;
		}

		public boolean stopCellEditing() {
			isPushed = false;
			return super.stopCellEditing();
		}

		protected void fireEditingStopped() {
			super.fireEditingStopped();
		}
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
	
	public void timHangCho() {
		
	}
	
	public static void main(String[] args) {
		new TrangHangCho().setVisible(true);
	}
}
