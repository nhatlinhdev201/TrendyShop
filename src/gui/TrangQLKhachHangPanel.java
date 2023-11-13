package gui;

import javax.swing.JPanel;

import constance.SetBountJPanel;
import daos.KhachHangDAO;
import entities.KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class TrangQLKhachHangPanel extends JPanel implements ActionListener,MouseListener{
	 private static final Font TABLE_FONT = new Font("Tahoma", Font.PLAIN, 15);
	static KhachHangDAO khDao = new KhachHangDAO();
	private JTable table;
	private JTextField txt_makh;
	private JTextField txt_ten;
	private JTextField txt_sDT;
	private JTextField txt_email;
	private JTextField txt_diaChi;
	private JTextField txt_diemTichLuy;
	private JTextField txt_timKiem;
	private JRadioButton btn_hoatDong ;
	private JRadioButton btn_nghi;
	private JButton btn_timKiem;
	private static DefaultTableModel tableModel;
	/**
	 * Create the panel.
	 */
	public TrangQLKhachHangPanel() {
		setBackground(Color.WHITE);
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);

        // Load ảnh từ tệp
        ImageIcon originalIcon = new ImageIcon(TrangQLKhachHangPanel.class.getResource("/images/man.png"));
        Image img = originalIcon.getImage(); // Chuyển ImageIcon thành Image

        // Chỉnh kích thước ảnh
        Image newImg = img.getScaledInstance(230, 230, Image.SCALE_SMOOTH);

        // Tạo ImageIcon mới từ ảnh đã chỉnh kích thước
        ImageIcon resizedIcon = new ImageIcon(newImg);
        
        JTable table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));

		// Tạo font mới với kích cỡ chữ là 20 cho tiêu đề cột
		Font headerFont = new Font("Tahoma", Font.BOLD, 15);

		// Set model cho JTable
		tableModel = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {"Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Email", "Địa chỉ", "Trạng thái", "Điểm tích lũy" }
	        ) {
	            // Override phương thức để set font cho dữ liệu trong bảng
	            @Override
	            public Class<?> getColumnClass(int columnIndex) {
	                return String.class;  // Đặt kiểu dữ liệu là String cho tất cả các cột
	            }

	            // Override phương thức để set font cho dữ liệu trong bảng
	            @Override
	            public boolean isCellEditable(int row, int column) {
	                return false;  // Không cho phép chỉnh sửa dữ liệu trong bảng
	            }
	        };
	     // Add ListSelectionListener to the table
	        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	        @Override
	        public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                    int selectedRow = table.getSelectedRow();

	                    // Check if a row is selected
	                    if (selectedRow != -1) {
	                        // Retrieve data from the selected row
	                        String maKH = (String) table.getValueAt(selectedRow, 0);
	                        String tenKhachHang = (String) table.getValueAt(selectedRow, 1);
	                        String soDienThoai = (String) table.getValueAt(selectedRow, 2);
	                        String email = (String) table.getValueAt(selectedRow, 3);
	                        String diaChi = (String) (table.getValueAt(selectedRow, 4));
	                        String trangThai = (String) table.getValueAt(selectedRow, 5);
	                        String diemTichLuy =String.valueOf(table.getValueAt(selectedRow, 6));

	                        // Display data in text fields
	                        txt_makh.setText(maKH.trim());
	                        txt_ten.setText(tenKhachHang.trim());
	                        txt_sDT.setText(soDienThoai.trim());
	                        txt_email.setText(email.trim());
	                        txt_diaChi.setText(diaChi.trim());
	                        txt_diemTichLuy.setText(diemTichLuy.trim());

	                        // Cài đặt thuộc tính selected của các nút radio btn_hoatDong và btn_nghi.
	                       if(trangThai.trim().equalsIgnoreCase("Hoạt động"))
	                       {
	                    	   btn_hoatDong.setSelected(true);
	                    	   btn_nghi.setSelected(false);
	                       }else if(trangThai.trim().equalsIgnoreCase("Nghỉ"))
	                       {
	                    	   btn_hoatDong.setSelected(false);
	                    	   btn_nghi.setSelected(true);
	                       }
	                    }
	                }
	            }
	        });
	    table.setFont(TABLE_FONT);
	    table.setModel(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(473, 65, 867, 625);
        add(scrollPane);
        
        JLabel lbl_makh = new JLabel("Mã khách hàng :");
        lbl_makh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbl_makh.setBounds(92, 312, 123, 21);
        add(lbl_makh);
        
        txt_makh = new JTextField();
        txt_makh.setEditable(false);
        txt_makh.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txt_makh.setForeground(Color.BLACK);
        txt_makh.setBounds(217, 312, 146, 20);
        add(txt_makh);
        txt_makh.setColumns(10);
        
        JLabel lblTnKhchHng = new JLabel("Tên khách hàng :");
        lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTnKhchHng.setBounds(92, 350, 123, 21);
        add(lblTnKhchHng);
        
        txt_ten = new JTextField();
        txt_ten.setEditable(false);
        txt_ten.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txt_ten.setForeground(Color.BLACK);
        txt_ten.setColumns(10);
        txt_ten.setBounds(217, 350, 146, 20);
        add(txt_ten);
        
        JLabel lblSinThoai = new JLabel("Số điện thoai :");
        lblSinThoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSinThoai.setBounds(92, 384, 123, 21);
        add(lblSinThoai);
        
        txt_sDT = new JTextField();
        txt_sDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txt_sDT.setForeground(Color.BLACK);
        txt_sDT.setEnabled(false);
        txt_sDT.setColumns(10);
        txt_sDT.setBounds(217, 384, 146, 20);
        add(txt_sDT);
        
        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setFont(new Font("Sylfaen", Font.PLAIN, 15));
        lblEmail.setBounds(92, 418, 123, 21);
        add(lblEmail);
        
        txt_email = new JTextField();
        txt_email.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txt_email.setForeground(Color.BLACK);
        txt_email.setEnabled(false);
        txt_email.setColumns(10);
        txt_email.setBounds(217, 418, 146, 20);
        add(txt_email);
        
        JLabel lblaCh = new JLabel("Địa chỉ :");
        lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblaCh.setBounds(92, 456, 123, 21);
        add(lblaCh);
        
        txt_diaChi = new JTextField();
        txt_diaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txt_diaChi.setForeground(Color.BLACK);
        txt_diaChi.setEnabled(false);
        txt_diaChi.setColumns(10);
        txt_diaChi.setBounds(217, 456, 146, 20);
        add(txt_diaChi);
        
        JLabel lblTrngThi = new JLabel("Trạng thái  :");
        lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTrngThi.setBounds(92, 488, 123, 21);
        add(lblTrngThi);
        
        JLabel lblimTchLu = new JLabel("Điểm tích luỹ :");
        lblimTchLu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblimTchLu.setBounds(92, 526, 123, 21);
        add(lblimTchLu);
        
        txt_diemTichLuy = new JTextField();
        txt_diemTichLuy.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txt_diemTichLuy.setForeground(Color.BLACK);
        txt_diemTichLuy.setEnabled(false);
        txt_diemTichLuy.setColumns(10);
        txt_diemTichLuy.setBounds(217, 526, 146, 20);
        add(txt_diemTichLuy);
        
        btn_hoatDong = new JRadioButton("Hoạt động");
        btn_hoatDong.setEnabled(false);
        btn_hoatDong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_hoatDong.setBackground(Color.WHITE);
        btn_hoatDong.setBounds(217, 487, 95, 23);
        add(btn_hoatDong);
        
        btn_nghi = new JRadioButton("Nghỉ");
        btn_nghi.setEnabled(false);
        btn_nghi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_nghi.setBackground(Color.WHITE);
        btn_nghi.setBounds(314, 487, 75, 23);
        add(btn_nghi);
        
        JLabel lblNewLabel = new JLabel("Thông tin khách hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(50, 35, 353, 33);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(TrangQLKhachHangPanel.class.getResource("/images/man.png")));
        lblNewLabel_1.setBounds(157, 96, 207, 176);
        add(lblNewLabel_1);
        
        btn_timKiem = new JButton("Tìm kiếm");
        btn_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_timKiem.setBounds(473, 21, 123, 33);
       
        
        
     // Tạo nút tìm kiếm
        
        // Đường dẫn của hình ảnh icon
        String iconPath = "/images/searchphuc.png";
		ImageIcon icon = new ImageIcon(this.getClass().getResource(iconPath)); // Sử dụng getResource để lấy đường dẫn từ resources của ứng dụng

		Image scaledIcon = icon.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
		ImageIcon resizedIcon1 = new ImageIcon(scaledIcon);

		btn_timKiem.setIcon(resizedIcon1);
		add(btn_timKiem);
        
        txt_timKiem = new JTextField();
        txt_timKiem.setBounds(595, 21, 280, 33);
        add(txt_timKiem);
        txt_timKiem.setColumns(10);
        
        JButton btn_them = new JButton("Thêm");
        btn_them.setBackground(Color.GREEN);
        btn_them.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_them.setBounds(33, 619, 123, 33);
        String iconPath_them = "/images/plus.png";
		ImageIcon iconThem = new ImageIcon(this.getClass().getResource(iconPath_them)); // Sử dụng getResource để lấy đường dẫn từ resources của ứng dụng

		Image scaledIconThem = iconThem.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
		ImageIcon resizedIconThem = new ImageIcon(scaledIconThem);

		btn_them.setIcon(resizedIconThem);
        add(btn_them);
        
        JButton btn_xoa = new JButton("Xoá");
        btn_xoa.setBackground(new Color(250, 128, 114));
        btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_xoa.setBounds(172, 619, 123, 33);
        String iconPath_xoa = "/images/delete.png";
		ImageIcon iconXoa = new ImageIcon(this.getClass().getResource(iconPath_xoa)); // Sử dụng getResource để lấy đường dẫn từ resources của ứng dụng

		Image scaledIconXoa = iconXoa.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
		ImageIcon resizedIconXoa = new ImageIcon(scaledIconXoa);

		btn_xoa.setIcon(resizedIconXoa);
        add(btn_xoa);
        
        JButton btn_capNhat = new JButton("Cập nhật");
        btn_capNhat.setBackground(Color.ORANGE);
        btn_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_capNhat.setBounds(315, 619, 123, 33);
        String iconPath_capnhat = "/images/updated.png";
		ImageIcon iconCapNhat = new ImageIcon(this.getClass().getResource(iconPath_capnhat)); // Sử dụng getResource để lấy đường dẫn từ resources của ứng dụng

		Image scaledIconCapNhat = iconCapNhat.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH); // Thiết lập kích thước
		ImageIcon resizedIconCapNhat = new ImageIcon(scaledIconCapNhat);

		btn_capNhat.setIcon(resizedIconCapNhat);
        add(btn_capNhat);
        docDuLieu();
        
        btn_capNhat.addActionListener(this);
        btn_timKiem.addActionListener(this);
        
	}
	  public static void docDuLieu() {
	        try {
	            List<KhachHang> list = khDao.getAllKhachHang();
	            int i = 0;
	            for (KhachHang khachHang : list) {
	                // Tạo một mảng dữ liệu để chứa thông tin của khách hàng
	                Object[] rowData = {
	                
	                    khachHang.getMaKhachHang(),
	                    khachHang.getTenKhachHang(),
	                    khachHang.getSoDienThoai(),
	                    khachHang.getEmail(),
	                    khachHang.getDiaChi(),
	                    khachHang.isTrangThai() ? "Nghỉ" : "Hoạt động",  // Chuyển boolean thành chuỗi
	                    khachHang.getDiemTichLuy()
	                };

	                // Thêm dữ liệu vào model của bảng
	                tableModel.addRow(rowData);

	                // Tăng chỉ số
	                i++;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	  public void actionPerformed(ActionEvent e) {
		    Object obj = e.getSource();
		    if (obj.equals(btn_timKiem)) {
		        String maKH = txt_timKiem.getText().trim();

		        if (maKH.equals("")) {
		            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm !", "Thông báo",
		                    JOptionPane.ERROR_MESSAGE, new ImageIcon("images/warning.png"));
		        } else {
		            try {
		                // Xóa dữ liệu trong bảng trước khi tìm kiếm
		                clearTable();

		                // Tìm kiếm khách hàng theo mã
		                KhachHang khachHang = khDao.timkiemKhachHangByMa(maKH);

		                // Kiểm tra xem khách hàng có tồn tại không
		                if (khachHang != null) {
		                    // Hiển thị thông tin khách hàng trong text fields
		                    txt_makh.setText(maKH);
		                    txt_ten.setText(khachHang.getTenKhachHang());
		                    txt_sDT.setText(khachHang.getSoDienThoai().trim());
		                    txt_email.setText(khachHang.getEmail().trim());
		                    txt_diaChi.setText(khachHang.getDiaChi());
		                    txt_diemTichLuy.setText(String.valueOf(khachHang.getDiemTichLuy()));

		                    // Cài đặt thuộc tính selected của các nút radio btn_hoatDong và btn_nghi.
		                    if (khachHang.isTrangThai()) {
		                        btn_hoatDong.setSelected(false);
		                        btn_nghi.setSelected(true);
		                    } else {
		                        btn_hoatDong.setSelected(true);
		                        btn_nghi.setSelected(false);
		                    }

		                    // Hiển thị thông tin khách hàng trong bảng
		                    Object[] rowData = {
		    	                    khachHang.getMaKhachHang(),
		    	                    khachHang.getTenKhachHang(),
		    	                    khachHang.getSoDienThoai(),
		    	                    khachHang.getEmail(),
		    	                    khachHang.getDiaChi(),
		    	                    khachHang.isTrangThai() ? "Nghỉ" : "Hoạt động",  // Chuyển boolean thành chuỗi
		    	                    khachHang.getDiemTichLuy()
		    	                };
//		                    int rowIndex = tableModel.getRowCount() - 1;  // Lấy chỉ số của dòng vừa thêm vào bảng
//		                    table.setRowSelectionInterval(rowIndex, rowIndex);
		                    // Thêm dữ liệu vào model của bảng
		                    tableModel.addRow(rowData);
		                } else {
		                    JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng!", "Thông báo",
		                            JOptionPane.INFORMATION_MESSAGE);
		                }
		            } catch (Exception ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
		}
	
	  private void clearTable() {
		    // Clear the existing data in the table model
		    while (tableModel.getRowCount() > 0) {
		        tableModel.removeRow(0);
		    }
	  }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
