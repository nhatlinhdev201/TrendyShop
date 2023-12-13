package gui;

import javax.swing.border.EmptyBorder;

import org.apache.poi.ss.formula.functions.Value;

import connection.ConnectDataBase;
import daos.Dao_KhachHang;
import daos.KhachHangDAO;
import entities.KhachHang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class FromThemKhachHang extends JFrame implements WindowListener{
	static Dao_KhachHang dao_kh = new Dao_KhachHang();
	public Connection connection = ConnectDataBase.getInstance().connection;;
	private JLabel emailield;
	private JRadioButton rdb_hoatdong;
	private JPanel contentPane;
	private JTextField txt_ten;
	private JTextField txt_sdt;
	private JTextField txt_email;
	private JTextField txt_diaChi;
	private JButton btn_save;
	private JLabel nameField;
	private JLabel fliedsdt;
	private JLabel trangthaiField;
	private JLabel phoneField;
	private JRadioButton rdb_nghi;
	private JLabel lblluCc;
	private JLabel lblKhngc;
	private JLabel lblPhiLS;
	private JLabel lblPhiLS_1;
	private JLabel lbl_image;
	private JButton btn_troLai;
	private int ma = 20;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromThemKhachHang frame = new FromThemKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FromThemKhachHang() {
		setBounds(100, 100, 627, 404);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setForeground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		nameField = new JLabel("Tên KH  :");
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nameField.setBounds(290, 37, 84, 21);
		contentPane.add(nameField);

		txt_ten = new JTextField();
		txt_ten.setColumns(10);
		txt_ten.setBounds(380, 37, 177, 25);
		contentPane.add(txt_ten);

		txt_sdt = new JTextField();
		txt_sdt.setColumns(10);
		txt_sdt.setBounds(380, 92, 177, 25);
		contentPane.add(txt_sdt);

		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(380, 141, 177, 25);
		contentPane.add(txt_email);

		txt_diaChi = new JTextField();
		txt_diaChi.setColumns(10);
		txt_diaChi.setBounds(380, 188, 177, 25);
		contentPane.add(txt_diaChi);

		trangthaiField = new JLabel("Trạng thái :");
		trangthaiField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		trangthaiField.setBounds(290, 232, 97, 21);
		contentPane.add(trangthaiField);

		phoneField = new JLabel("Địa chỉ :");
		phoneField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		phoneField.setBounds(290, 189, 69, 21);
		contentPane.add(phoneField);

		emailield = new JLabel("Email :");
		emailield.setFont(new Font("Tahoma", Font.PLAIN, 17));
		emailield.setBounds(290, 142, 69, 21);
		contentPane.add(emailield);

		fliedsdt = new JLabel("SDT");
		fliedsdt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		fliedsdt.setBounds(290, 92, 69, 21);
		contentPane.add(fliedsdt);

		btn_save = new JButton("Lưu");
		btn_save.setBackground(Color.GREEN);
		btn_save.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btn_save.setSize(182, 42);
		btn_save.setLocation(317, 270);
		contentPane.add(btn_save);

		rdb_hoatdong = new JRadioButton("Hoạt động");
		rdb_hoatdong.setSelected(true);
		rdb_hoatdong.setBackground(new Color(152, 251, 152));
		rdb_hoatdong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdb_hoatdong.setBounds(380, 231, 102, 23);
		contentPane.add(rdb_hoatdong);

		rdb_nghi = new JRadioButton("Nghỉ");
		rdb_nghi.setBackground(new Color(152, 251, 152));
		rdb_nghi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdb_nghi.setBounds(484, 231, 75, 24);
		contentPane.add(rdb_nghi);

		lbl_image = new JLabel("");
		lbl_image.setBounds(20, 22, 260, 250);

		// Đặt ImageIcon vào JLabel
		lbl_image.setIcon(new ImageIcon(FromThemKhachHang.class.getResource("/images/add_contact.png")));
		contentPane.add(lbl_image);

		lblluCc = new JLabel("*Lưu ý các trường\r\n");
		lblluCc.setForeground(Color.RED);
		lblluCc.setToolTipText("");
		lblluCc.setVerticalAlignment(SwingConstants.TOP);
		lblluCc.setHorizontalAlignment(SwingConstants.LEFT);
		lblluCc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblluCc.setBounds(44, 283, 199, 30);
		contentPane.add(lblluCc);

		lblKhngc = new JLabel("\r\n không được để trống.");
		lblKhngc.setVerticalAlignment(SwingConstants.TOP);
		lblKhngc.setToolTipText("");
		lblKhngc.setHorizontalAlignment(SwingConstants.LEFT);
		lblKhngc.setForeground(Color.RED);
		lblKhngc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKhngc.setBounds(44, 308, 177, 21);
		contentPane.add(lblKhngc);
		
		ButtonGroup buttonGroup = new ButtonGroup();

		// Thêm nút vào nhóm
		buttonGroup.add(rdb_hoatdong);
		buttonGroup.add(rdb_nghi);
		
		lblPhiLS = new JLabel("Phải là 10 số bắt đầu từ số 0");
		lblPhiLS.setVerticalAlignment(SwingConstants.TOP);
		lblPhiLS.setToolTipText("");
		lblPhiLS.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhiLS.setForeground(Color.RED);
		lblPhiLS.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhiLS.setBounds(380, 116, 213, 21);
		contentPane.add(lblPhiLS);

		lblPhiLS_1 = new JLabel("Email kết thúc bằng @gmail.com");
		lblPhiLS_1.setVerticalAlignment(SwingConstants.TOP);
		lblPhiLS_1.setToolTipText("");
		lblPhiLS_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhiLS_1.setForeground(Color.RED);
		lblPhiLS_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhiLS_1.setBounds(380, 169, 213, 21);
		contentPane.add(lblPhiLS_1);
		
		btn_troLai = new JButton("Trờ lại");
		btn_troLai.setBackground(new Color(255, 99, 71));
		btn_troLai.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btn_troLai.setBounds(509, 270, 92, 42);
		contentPane.add(btn_troLai);
		btn_troLai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame currentFrame = (JFrame) SwingUtilities.getRoot((Component) e.getSource());
		        currentFrame.dispose();

//		        // Open the QL khách hàng window
//		        JFrame qlKhachHangFrame = new JFrame("Quản lý khách hàng");
//		        // Set up the content of the new window (you may need to customize this part)
//		        // ...
//
//		        qlKhachHangFrame.setSize(600, 400);
//		        qlKhachHangFrame.setLocationRelativeTo(null); // Center the new window
//		        qlKhachHangFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		        // Make sure to set the visibility of the new window to true
//		        qlKhachHangFrame.setVisible(true);
			}
		});
		
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy thông tin từ các trường dữ liệu trên giao diện
				ma++;
				String m=String.valueOf(ma);
				String randomNumber = "00" +m;
				String makh = "KH" + randomNumber;
				String tenKhachHang = txt_ten.getText();
				String soDienThoai = txt_sdt.getText();
				String email = txt_email.getText();
				String diaChi = txt_diaChi.getText();
				boolean trangThai = rdb_hoatdong.isSelected(); // true nếu hoạt động, ngược lại là false
				if(kiemTraHople())
					// Kiểm tra và xử lý các điều kiện khác nếu cần thiết
					if (!isEmployeeExists(tenKhachHang, soDienThoai, email)) {
						// Tạo đối tượng KhachHang từ thông tin đã nhập
						KhachHang khachHang = new KhachHang();
						khachHang.setMaKhachHang(makh);
						khachHang.setTenKhachHang(tenKhachHang);
						khachHang.setSoDienThoai(soDienThoai);
						khachHang.setEmail(email);
						khachHang.setDiaChi(diaChi);
						khachHang.setTrangThai(trangThai);

						// Gọi hàm themKhachHang để lưu thông tin vào cơ sở dữ liệu
						boolean result = dao_kh.themKhachHang(khachHang);
						// Kiểm tra kết quả và thông báo cho người dùng
						if (result) {
							JOptionPane.showMessageDialog(contentPane, "Thêm khách hàng thành công!");
							// Có thể thêm logic để làm mới giao diện hoặc thực hiện các tác vụ khác sau khi
							// thêm
							Window window = SwingUtilities.getWindowAncestor(contentPane);
							if (window != null) {
								window.dispose();
							}
						} else {
							JOptionPane.showMessageDialog(contentPane, "Thêm khách hàng thất bại!");
						}

					} else {
						JOptionPane.showMessageDialog(contentPane, "Tên, số điện thoại hoặc email đã tồn tại.");
					}
				}
		});
		addWindowListener(this);
		this.setLocationRelativeTo(null);
		contentPane.setVisible(true);
	}

	private boolean kiemTraHople() {
		String sdt = txt_sdt.getText().trim();
		String ten = txt_ten.getText().trim();
		int lastSpace = ten.lastIndexOf(" ");
		String fistName = ten.substring(lastSpace + 1);
		if (!ten.matches("^[A-Z].*")) {
			JOptionPane.showMessageDialog(contentPane, "Tên phải viết hoa ");
			return false;
		}
		// Kiểm tra các trường không được để trống
		if (txt_ten.getText().isEmpty() || txt_sdt.getText().isEmpty() || txt_email.getText().isEmpty()
				|| txt_diaChi.getText().isEmpty()) {
			JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập đầy đủ thông tin!");
			return false; // Dừng hàm nếu có trường trống
		}
		if (!sdt.matches("0\\d{9}")) {
			JOptionPane.showMessageDialog(contentPane, "Số điện thoại phải có đúng 10 số bắt đầu là số 0!");
			return false;
		}
		
		String email = txt_email.getText().trim();
		if (!email.endsWith("@gmail.com")) {
			JOptionPane.showMessageDialog(contentPane, "Email phải kết thúc bằng '@gmail.com'!");
			return false;
		}
		// Kiểm tra JRadioButton đã được chọn chưa
		if (!rdb_hoatdong.isSelected() && !rdb_nghi.isSelected()) {
			JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn trạng thái hoạt động hoặc nghỉ!");
			return false; // Dừng hàm nếu không có JRadioButton nào được chọn
		}
		return true;
	}

	public boolean isEmployeeExists(String ten, String soDienThoai, String email) {
		String query = "SELECT * FROM KhachHang WHERE tenKhachHang = ? OR soDienThoai = ? OR email = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, ten);
			preparedStatement.setString(2, soDienThoai);
			preparedStatement.setString(3, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet.next(); // Nếu có dữ liệu, tức là tên, số điện thoại hoặc email đã tồn tại
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}