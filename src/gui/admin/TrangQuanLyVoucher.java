package gui.admin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import constance.SetBountJPanel;
import daos.Dao_Voucher;
import daos.Dao_Voucher;
import entities.HangHoa;
import entities.VoucherGiamGia;
import rojerusan.RSTableMetro;

public class TrangQuanLyVoucher extends JPanel implements ActionListener, MouseListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_Search;
	private JPanel pnl_tieuchi;
	private RSTableMetro tbl_Voucher;
	private JList<String> lst_TieuChi;
	private JLabel lbl_TieuChiSearch;
	private DefaultTableModel dataDefault;
	private JButton btn_add;
	private JButton btn_edit;
	private JButton btn_delete;
	private JPanel pnl_Search;
	private List<String> listPhanTramGiamGia;
	private List<String> listTrangThai;

	private DefaultListModel<String> listItemSearched;
	private JScrollPane scr_ListItemSearched;
	private JList<String> lst_ItemSearched;
//	private List<String> listTenVoucher;
	private List<VoucherGiamGia> ds;
	private Dao_Voucher dao_Voucher;
	/**
	 * Create the panel.
	 */
	public TrangQuanLyVoucher() {
		dao_Voucher = new Dao_Voucher();
		data();
		setBackground(new Color(36, 170, 120));
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);

		lst_TieuChi = new JList<String>();
		lst_TieuChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lst_TieuChi.setModel(new AbstractListModel<String>() {
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] { "Mã Voucher", "Phần trăm giá bán(%)", "Trạng thái" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
		lst_TieuChi.setSelectedIndex(0);
		lst_TieuChi.setBounds(130, 75, 120, 70);
		lst_TieuChi.setVisible(false);
		add(lst_TieuChi);

		scr_ListItemSearched = new JScrollPane();
		scr_ListItemSearched.setBorder(null);
		scr_ListItemSearched.setBounds(257, 75, 295, 100);
		scr_ListItemSearched.setVisible(false);
		add(scr_ListItemSearched);

		lst_ItemSearched = new JList<String>();
		scr_ListItemSearched.setViewportView(lst_ItemSearched);
		lst_ItemSearched.setFont(new Font("Tahoma", Font.BOLD, 12));
		listItemSearched = new DefaultListModel<String>();
		lst_ItemSearched.setModel(listItemSearched);
		lst_ItemSearched.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JPanel pnl_Header = new JPanel();
		pnl_Header.setBackground(new Color(140, 200, 200));
		pnl_Header.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnl_Header.setBounds(0, 38, 1350, 52);

		add(pnl_Header);
		pnl_Header.setLayout(null);

		pnl_Search = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				// Paint Border
				g2.setColor(Color.BLACK);
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
				g2.setColor(Color.white);
				// Border set 2 Pix
				g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 10, 10);
				super.paintComponent(g);
			}
		};
		pnl_Search.setOpaque(false);
		pnl_Search.setBackground(Color.WHITE);
		pnl_Search.setBounds(127, 10, 468, 30);
		pnl_Header.add(pnl_Search);
		pnl_Search.setLayout(null);

		txt_Search = new JTextField();

		txt_Search.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_Search.getText().equals("")) {
					loadData(ds);
				}else {
					renderSeatch();
				}
			}

		});
		txt_Search.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_Search.setBorder(null);
		txt_Search.setBounds(130, 2, 293, 26);
		pnl_Search.add(txt_Search);
		txt_Search.setColumns(10);

		pnl_tieuchi = new JPanel();
		pnl_tieuchi.setBackground(Color.WHITE);
		pnl_tieuchi.setBounds(2, 2, 123, 26);
		pnl_Search.add(pnl_tieuchi);
		pnl_tieuchi.setLayout(null);

		lbl_TieuChiSearch = new JLabel(lst_TieuChi.getSelectedValue());
		lbl_TieuChiSearch.setIconTextGap(5);
		lbl_TieuChiSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TieuChiSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_TieuChiSearch.setBounds(0, 1, 92, 24);
		pnl_tieuchi.add(lbl_TieuChiSearch);

		JLabel lbl_IconDropDown = new JLabel("");
		lbl_IconDropDown.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon_down_chevron.png"))
				.getImage().getScaledInstance(12, 12, Image.SCALE_SMOOTH)));
		lbl_IconDropDown.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(119, 136, 153)));
		lbl_IconDropDown.setBounds(100, 1, 26, 24);
		pnl_tieuchi.add(lbl_IconDropDown);

		JLabel lbl_iconSearch = new JLabel("");
		lbl_iconSearch.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon_search.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		lbl_iconSearch.setBounds(433, 2, 26, 26);
		pnl_Search.add(lbl_iconSearch);

		btn_add = new JButton("Thêm");
		btn_add.setIconTextGap(10);
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_add.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_add.setBackground(SystemColor.info);
		btn_add.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon_add_sign.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btn_add.setFocusable(false);
		btn_add.setBounds(826, 10, 100, 30);
		pnl_Header.add(btn_add);

		btn_edit = new JButton("Sửa");
		btn_edit.setIconTextGap(10);
		btn_edit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_edit.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon_edit.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btn_edit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_edit.setBackground(SystemColor.info);
		btn_edit.setFocusable(false);
		btn_edit.setBounds(1026, 10, 100, 30);
		pnl_Header.add(btn_edit);

		btn_delete = new JButton("Tạm ngưng");
		btn_delete.setIconTextGap(10);
		btn_delete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_delete.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon_delete.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btn_delete.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_delete.setBackground(SystemColor.info);
		btn_delete.setFocusable(false);
		btn_delete.setBounds(1206, 10, 120, 30);
		pnl_Header.add(btn_delete);

		JLabel lbl_timkiem = new JLabel("Tìm Kiếm Theo:");
		lbl_timkiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_timkiem.setBounds(10, 10, 120, 30);
		pnl_Header.add(lbl_timkiem);

		JPanel pnl_title = new JPanel();
		pnl_title.setBackground(new Color(192, 192, 192));
		pnl_title.setBounds(0, 0, 1350, 40);
		add(pnl_title);

		JLabel lbl_Title = new JLabel("QUẢN LÝ VOUCHER");
		lbl_Title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title.setForeground(new Color(94, 94, 174));
		lbl_Title.setPreferredSize(new Dimension(300, 30));
		lbl_Title.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		pnl_title.add(lbl_Title);

		JPanel pnl_TableVocuher = new JPanel();
		pnl_TableVocuher.setForeground(new Color(128, 191, 191));
		pnl_TableVocuher.setBackground(new Color(128, 191, 191));
		pnl_TableVocuher.setBorder(new CompoundBorder(new LineBorder(new Color(128, 191, 191), 2),new CompoundBorder(new TitledBorder(new LineBorder(new Color(128, 191, 191), 2),"	Danh sách voucher", TitledBorder.LEADING,TitledBorder.TOP,new Font("Tahoma", Font.PLAIN, 17),new Color(0, 0, 0)),new EmptyBorder(5, 18, 18, 18))));
		pnl_TableVocuher.setBounds(0, 89, 1350, 610);
		add(pnl_TableVocuher);
		pnl_TableVocuher.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		JScrollPane scr_voucher = new JScrollPane();
		scr_voucher.setPreferredSize(new Dimension(1335, 580));
		scr_voucher.setBorder(null);
		scr_voucher.setFont(new Font("Tahoma", Font.PLAIN, 25));
		scr_voucher.setForeground(new Color(192, 192, 192));
		scr_voucher.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scr_voucher.setBackground(new Color(107, 182, 182));
		scr_voucher.setEnabled(false);

		scr_voucher.setFocusable(false);
		pnl_TableVocuher.add(scr_voucher);

		tbl_Voucher = new RSTableMetro() {
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false,
					false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tbl_Voucher.setFuenteFilas(new Font("Tahoma", Font.PLAIN, 14));
		tbl_Voucher.setBorder(null);
		tbl_Voucher.setIntercellSpacing(new Dimension(0, 0));
		tbl_Voucher.setAlignmentY(Component.TOP_ALIGNMENT);
		tbl_Voucher.setAlignmentX(Component.LEFT_ALIGNMENT);
		tbl_Voucher.setRowMargin(0);
		tbl_Voucher.setColorBordeFilas(new Color(0, 128, 128));
		tbl_Voucher.setGridColor(new Color(0, 128, 128));
		tbl_Voucher.setColorSelForeground(Color.WHITE);
		tbl_Voucher.setColorFilasForeground2(Color.BLACK);
		tbl_Voucher.setColorFilasForeground1(Color.BLACK);
		tbl_Voucher.setColorSelBackgound(new Color(102, 205, 170));
		tbl_Voucher.setColorFilasBackgound2(Color.WHITE);
		tbl_Voucher.setColorFilasBackgound1(Color.WHITE);
		tbl_Voucher.setColorBackgoundHead(new Color(0, 128, 128));
		tbl_Voucher.setColorBordeHead(new Color(0, 128, 128));
		tbl_Voucher.setBackground(Color.WHITE);
		tbl_Voucher.setFuenteFilasSelect(new Font("Tahoma", Font.BOLD, 13));
		tbl_Voucher.setFuenteHead(new Font("Tahoma", Font.BOLD, 13));
		tbl_Voucher.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_Voucher.setAltoHead(30);
		dataDefault = new DefaultTableModel(new String[] { "Mã Voucher", "Tên Voucher", "Phần trăm Voucher", "Ngày bắt đầu", "Ngày kết thúc",
				"Số lượt dùng", "Trạng Thái"}, 0) {
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tbl_Voucher.setModel(dataDefault);
		tbl_Voucher.getColumnModel().getColumn(0).setResizable(false);
		tbl_Voucher.getColumnModel().getColumn(1).setResizable(false);
		tbl_Voucher.getColumnModel().getColumn(2).setResizable(false);
		tbl_Voucher.getColumnModel().getColumn(3).setResizable(false);
		tbl_Voucher.getColumnModel().getColumn(4).setResizable(false);
		tbl_Voucher.getColumnModel().getColumn(5).setResizable(false);
		tbl_Voucher.getColumnModel().getColumn(6).setResizable(false);

		scr_voucher.setViewportView(tbl_Voucher);

		// event
		pnl_tieuchi.addMouseListener(this);
		lst_TieuChi.addMouseListener(this);
		txt_Search.addMouseListener(this);
		pnl_Search.addMouseListener(this);
		tbl_Voucher.addMouseListener(this);
		scr_ListItemSearched.addMouseListener(this);
		//

		btn_add.addActionListener(this);
		btn_delete.addActionListener(this);
		btn_edit.addActionListener(this);
		lst_TieuChi.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					lbl_TieuChiSearch.setText(lst_TieuChi.getSelectedValue());
					lst_TieuChi.setVisible(false);
				}
			}
		});
		lst_ItemSearched.addListSelectionListener(new ListSelectionListener() {

			/**
			 * Chọn tiêu chí để hiển thị danh sách các tên trong tiêu chí đã chọn
			 * @param e
			 */
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting() && lst_ItemSearched.getSelectedValue() !=null) {
					if (lst_TieuChi.getSelectedIndex() == 1) {
						String textSearch = lst_ItemSearched.getSelectedValue();
						loadData(dao_Voucher.getVoucherByPhanTramGiamGia(textSearch));
						scr_ListItemSearched.setVisible(false);
					} else if (lst_TieuChi.getSelectedIndex() == 2) {
						String item = lst_ItemSearched.getSelectedValue();
						loadData(dao_Voucher.getVoucherByTrangThai(item));
						scr_ListItemSearched.setVisible(false);
					} 
				}

			}
		});
		//
		txt_Search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				renderSeatch();
			}
		});
		// data
		loadData(ds);
	}

	/**
	 * get danh sách các tiêu chí
	 */
	public void data() {
		listPhanTramGiamGia = dao_Voucher.getAllPhanTramGiamGia();
		listTrangThai = dao_Voucher.getAllTrangThai();
		ds = dao_Voucher.getAll();
	}

	
	/**
	 * Load ds 
	 * @param dsVoucher
	 */
	private void loadData(List<VoucherGiamGia> dsVoucher) {
		dataDefault.setRowCount(0);
		for (VoucherGiamGia voucher : dsVoucher) {
			Object[] row = { voucher.getMaVoucher(), voucher.getTenVoucher(), voucher.getPhanTramGiamTheoHoaDon(), voucher.getNgayBatDau(), voucher.getNgayKetThuc(), voucher.getSoLuotDung(), voucher.isTrangThai()?"Đang hoạt động":"Đã ngưng"};
			dataDefault.addRow(row);
			
		}
	}

	
	/**
	 * Tìm kiếm và hiển thị nhóm các mục tương ứng với kí tự nhập vào
	 * @param list
	 * @param textSearch
	 */
	public void searchItem(List<String> list, String textSearch) {
		scr_ListItemSearched.setVisible(true);
		listItemSearched.removeAllElements();
		List<String> temp = new ArrayList<String>();
		if (!textSearch.equals("")) {
			for (String item : list) {
				if (item.toLowerCase().contains(textSearch.toLowerCase())) {
					temp.add(item + "-" + item.toLowerCase().indexOf(textSearch.toLowerCase()));
				}
			}
			Collections.sort(temp, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					int item1 = Integer.parseInt(o1.substring(o1.lastIndexOf("-"), o1.length()));
					int item2 = Integer.parseInt(o2.substring(o2.lastIndexOf("-"), o2.length()));
					return item1 > item2 ? -1 : 1;
				}
			});
			for (String item : temp) {
				listItemSearched.addElement(item.substring(0, item.lastIndexOf("-")));
			}
		} else {
			temp = list;
			for (String item : temp) {
				listItemSearched.addElement(item);
			}
		}
	}

	/**
	 * Thực hiện tìm kiếm các từ khóa nhập vào dựa trên các tiêu chí tìm kiếm
	 */
	public void renderSeatch() {
		
			if (lst_TieuChi.getSelectedIndex() == 0) {
				String textSearch = txt_Search.getText();
				searchOnTable(textSearch, 0);
			} else if (lst_TieuChi.getSelectedIndex() == 1) {
				searchItem(listPhanTramGiamGia, txt_Search.getText());
			} else if (lst_TieuChi.getSelectedIndex() == 2) {
				searchItem(listTrangThai, txt_Search.getText());
			} 
		
	}

	
	public void searchOnTable(String textSearch, int column) {
		tbl_Voucher.removeRowSelectionInterval(0, tbl_Voucher.getRowCount()-1);
		if (textSearch.length()<=9) {
			for (int i = 0; i < tbl_Voucher.getRowCount(); i++) {
				if (textSearch.toLowerCase().compareToIgnoreCase(tbl_Voucher.getValueAt(i, column)+"")==0) {
//					tbl_Voucher.setRowSelectionInterval(i, i);
					tbl_Voucher.changeSelection(i, i, false, false);
					break;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_add)) {
			VoucherGiamGia voucher = new VoucherGiamGia();
			Object[] r = { "Thoát" };
			JOptionPane.showOptionDialog(this, new FormThongTinVoucher(voucher, "add"),"Thêm voucher mới.",JOptionPane.DEFAULT_OPTION,JOptionPane.DEFAULT_OPTION,null,r,null);
			ds = dao_Voucher.getAll();
			loadData(ds);
		} else if (e.getSource().equals(btn_delete)) {
		    if (tbl_Voucher.getSelectedRow() == -1) {
		        JOptionPane.showMessageDialog(this, "Vui lòng chọn Voucher mong muốn.");
		    } else {
		        int row = tbl_Voucher.getSelectedRow();
		        String maVoucher = tbl_Voucher.getValueAt(row, 0).toString();
		        String trangThai = tbl_Voucher.getValueAt(row, 6).toString();

		        // Kiểm tra trạng thái thay đổi của sản phẩm
		        if (trangThai == "Đã ngưng") {
		            JOptionPane.showMessageDialog(this, "Voucher hiện đã ngưng hoạt động. Vui lòng chọn Voucher khác");
		        } else {
		            // Hiển thị hộp thoại xác nhận
		            int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn dừng hoạt động voucher này không?", "Xác nhận ngưng", JOptionPane.YES_NO_OPTION);

		            // Xác nhận nếu người dùng chọn "Yes"
		            if (option == JOptionPane.YES_OPTION) {
		                if (dao_Voucher.deleteVoucher(maVoucher)) {
		                    JOptionPane.showMessageDialog(this, "Đã thay đổi cập nhật trạng thái");
		                    ds = dao_Voucher.getAll();
		                    loadData(ds);
		                }
		            }
		        }
		    }
		} else if (e.getSource().equals(btn_edit)) {
			if (tbl_Voucher.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn Voucher muốn chỉnh sửa.");
			} else {
				int row = tbl_Voucher.getSelectedRow();
				VoucherGiamGia voucher = dao_Voucher.getMaVouCher(tbl_Voucher.getValueAt(row, 0).toString());
				Object[] r = { "Thoát" };
				JOptionPane.showOptionDialog(this, new FormThongTinVoucher(voucher, "edit"),"Chỉnh sửa thông tin sản phẩm "+voucher.getMaVoucher(),JOptionPane.DEFAULT_OPTION,JOptionPane.DEFAULT_OPTION,null,r,null);
				ds = dao_Voucher.getAll();
				loadData(ds);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(tbl_Voucher)) {
			if (e.getClickCount() == 2) {
				System.out.println(tbl_Voucher.getModel().getValueAt(tbl_Voucher.getSelectedRow(), 0));
			}
		} else if (e.getSource().equals(pnl_tieuchi)) {
			lst_TieuChi.setVisible(true);
		} else if (e.getSource().equals(txt_Search)) {
				renderSeatch();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(pnl_tieuchi)) {
			lst_TieuChi.setVisible(false);
		} else if (e.getSource().equals(pnl_Search)) {
			lst_TieuChi.setVisible(false);
			scr_ListItemSearched.setVisible(false);
		} else if (e.getSource().equals(tbl_Voucher)) {
			scr_ListItemSearched.setVisible(false);
			txt_Search.setFocusable(false);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(lst_TieuChi)) {
			lst_TieuChi.setVisible(false);
		} else if (e.getSource().equals(tbl_Voucher)) {
			txt_Search.setFocusable(true);
		} else if (e.getSource().equals(scr_ListItemSearched)) {
			scr_ListItemSearched.setVisible(false);
		}

	}

}
