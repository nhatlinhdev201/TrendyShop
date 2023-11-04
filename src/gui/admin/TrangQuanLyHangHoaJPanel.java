package gui.admin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import constance.SetBountJPanel;
import dao.Dao_HangHoa;
import entities.HangHoa;
import rojerusan.RSTableMetro;
import testFunction.ImageUploader;

public class TrangQuanLyHangHoaJPanel extends JPanel implements ActionListener, MouseListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_Search;
	private JPanel pnl_tieuchi;
	private RSTableMetro tbl_HangHoa;
	private JList<String> lst_TieuChi;
	private JLabel lbl_TieuChiSearch;
	private DefaultTableModel dataDefault;
	private JButton btn_add;
	private JButton btn_edit;
	private JButton btn_delete;
	private JPanel pnl_Search;
	private List<String> listThuongHieu;
	private List<String> listChatLieu;
	private List<String> listXuatXu;

	private DefaultListModel<String> listItemSearched;
	private JScrollPane scr_ListItemSearched;
	private JList<String> lst_ItemSearched;
	private List<String> listTenHangHoa;
	private List<HangHoa> ds;

	/**
	 * Create the panel.
	 */
	public TrangQuanLyHangHoaJPanel() {
		data();
		setBackground(new Color(102, 205, 170));
		this.setBounds(SetBountJPanel.X, SetBountJPanel.Y, SetBountJPanel.WIDTH, SetBountJPanel.HEIGHT);
		setLayout(null);

		lst_TieuChi = new JList<String>();
		lst_TieuChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lst_TieuChi.setModel(new AbstractListModel<String>() {
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] { "Mã Sản Phẩm", "Tên Sản Phẩm", "Thương Hiệu", "Xuất Xứ" };

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
		pnl_Header.setBackground(new Color(102, 205, 170));
		pnl_Header.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnl_Header.setBounds(0, 40, 1350, 50);

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
		pnl_Search.setBounds(127, 10, 455, 30);
		pnl_Header.add(pnl_Search);
		pnl_Search.setLayout(null);

		txt_Search = new JTextField();

		txt_Search.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tbl_HangHoa.removeRowSelectionInterval(0, tbl_HangHoa.getModel().getRowCount() - 1);
				renderSeatch();
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
		lbl_IconDropDown.setIcon(new ImageIcon("D:\\Tran\\TrendyShop\\src\\images\\bottom_down_Black.png"));
		lbl_IconDropDown.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(119, 136, 153)));
		lbl_IconDropDown.setBounds(100, 1, 26, 24);
		pnl_tieuchi.add(lbl_IconDropDown);

		JLabel lbl_iconSearch = new JLabel("");
		lbl_iconSearch.setIcon(new ImageIcon(
				"C:\\Users\\Leon\\Downloads\\5349754_explore_find_magnifier_magnifying glass_search_icon.png"));
		lbl_iconSearch.setBounds(426, 2, 26, 26);
		pnl_Search.add(lbl_iconSearch);

		btn_add = new JButton("Thêm");
		btn_add.setIconTextGap(10);
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_add.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_add.setBackground(SystemColor.info);
		btn_add.setIcon(new ImageIcon("C:\\Users\\Leon\\Downloads\\299068_add_sign_icon.png"));
		btn_add.setFocusable(false);
		btn_add.setBounds(826, 10, 100, 30);
		pnl_Header.add(btn_add);

		btn_edit = new JButton("Sửa");
		btn_edit.setIconTextGap(10);
		btn_edit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_edit.setIcon(
				new ImageIcon("C:\\Users\\Leon\\Downloads\\2530835_compose_create_edit_edit file_office_icon.png"));
		btn_edit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_edit.setBackground(SystemColor.info);
		btn_edit.setFocusable(false);
		btn_edit.setBounds(1026, 10, 100, 30);
		pnl_Header.add(btn_edit);

		btn_delete = new JButton("Xoá");
		btn_delete.setIconTextGap(10);
		btn_delete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_delete.setIcon(new ImageIcon("C:\\Users\\Leon\\Downloads\\8664938_trash_can_delete_remove_icon.png"));
		btn_delete.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_delete.setBackground(SystemColor.info);
		btn_delete.setFocusable(false);
		btn_delete.setBounds(1226, 10, 100, 30);
		pnl_Header.add(btn_delete);

		JLabel lbl_timkiem = new JLabel("Tìm Kiếm Theo:");
		lbl_timkiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_timkiem.setBounds(10, 10, 107, 30);
		pnl_Header.add(lbl_timkiem);

		JPanel pnl_title = new JPanel();
		pnl_title.setBackground(new Color(255, 218, 185));
		pnl_title.setBounds(0, 0, 1350, 40);
		add(pnl_title);

		JLabel lbl_Title = new JLabel("QUẢN LÝ HÀNG HOÁ");
		lbl_Title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title.setForeground(Color.RED);
		lbl_Title.setPreferredSize(new Dimension(300, 30));
		lbl_Title.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		pnl_title.add(lbl_Title);

		JPanel pnl_TableHangHoa = new JPanel();
		pnl_TableHangHoa.setBackground(new Color(102, 205, 170));
		pnl_TableHangHoa.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 2),
				"Danh S\u00E1ch H\u00E0ng Ho\u00E1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_TableHangHoa.setBounds(0, 94, 1350, 605);
		add(pnl_TableHangHoa);
		pnl_TableHangHoa.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		JScrollPane scr_hanghoa = new JScrollPane();
		scr_hanghoa.setPreferredSize(new Dimension(1335, 580));
		scr_hanghoa.setBorder(null);
		scr_hanghoa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scr_hanghoa.setForeground(new Color(0, 0, 0));
		scr_hanghoa.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scr_hanghoa.setBackground(new Color(102, 205, 170));
		scr_hanghoa.setEnabled(false);

		scr_hanghoa.setFocusable(false);
		pnl_TableHangHoa.add(scr_hanghoa);

		tbl_HangHoa = new RSTableMetro() {
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tbl_HangHoa.setBorder(null);
		tbl_HangHoa.setIntercellSpacing(new Dimension(0, 0));
		tbl_HangHoa.setAlignmentY(Component.TOP_ALIGNMENT);
		tbl_HangHoa.setAlignmentX(Component.LEFT_ALIGNMENT);
		tbl_HangHoa.setRowMargin(0);
		tbl_HangHoa.setColorBordeFilas(new Color(0, 128, 128));
		tbl_HangHoa.setGridColor(new Color(0, 128, 128));
		tbl_HangHoa.setColorSelForeground(Color.WHITE);
		tbl_HangHoa.setColorFilasForeground2(Color.BLACK);
		tbl_HangHoa.setColorFilasForeground1(Color.BLACK);
		tbl_HangHoa.setColorSelBackgound(new Color(102, 205, 170));
		tbl_HangHoa.setColorFilasBackgound2(Color.WHITE);
		tbl_HangHoa.setColorFilasBackgound1(Color.WHITE);
		tbl_HangHoa.setColorBackgoundHead(new Color(0, 128, 128));
		tbl_HangHoa.setColorBordeHead(new Color(0, 128, 128));
		tbl_HangHoa.setBackground(Color.WHITE);
		tbl_HangHoa.setFuenteFilasSelect(new Font("Tahoma", Font.BOLD, 13));
		tbl_HangHoa.setFuenteHead(new Font("Tahoma", Font.BOLD, 13));
		tbl_HangHoa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_HangHoa.setAltoHead(30);
		dataDefault = new DefaultTableModel(new String[] { "M\u00E3 H\u00E0ng Ho\u00E1", "T\u00EAn",
				"Th\u01B0\u01A1ng hi\u1EC7u", "Xu\u1EA5t x\u1EE9", "Ch\u1EA5t li\u1EC7u", "K\u00EDch c\u1EE1",
				"M\u00E0u s\u1EAFc", "S\u1ED1 l\u01B0\u1EE3ng t\u1ED3n", "S\u1ED1 l\u01B0\u1EE3ng b\u00E1n",
				"\u0110\u01A1n gi\u00E1(đ)" }, 0) {
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tbl_HangHoa.setModel(dataDefault);
		tbl_HangHoa.getColumnModel().getColumn(0).setResizable(false);
		tbl_HangHoa.getColumnModel().getColumn(1).setResizable(false);
		tbl_HangHoa.getColumnModel().getColumn(2).setResizable(false);
		tbl_HangHoa.getColumnModel().getColumn(3).setResizable(false);
		tbl_HangHoa.getColumnModel().getColumn(4).setResizable(false);
		tbl_HangHoa.getColumnModel().getColumn(5).setResizable(false);
		tbl_HangHoa.getColumnModel().getColumn(6).setResizable(false);
		tbl_HangHoa.getColumnModel().getColumn(7).setResizable(false);
		tbl_HangHoa.getColumnModel().getColumn(8).setResizable(false);
		tbl_HangHoa.getColumnModel().getColumn(9).setResizable(false);

		scr_hanghoa.setViewportView(tbl_HangHoa);

		// event
		pnl_tieuchi.addMouseListener(this);
		lst_TieuChi.addMouseListener(this);
		txt_Search.addMouseListener(this);
		pnl_Search.addMouseListener(this);
		tbl_HangHoa.addMouseListener(this);
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

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					if (lst_TieuChi.getSelectedIndex() == 1) {
						String textSearch = lst_ItemSearched.getSelectedValue();
						System.out.println(textSearch);
					} else if (lst_TieuChi.getSelectedIndex() == 2) {
						String item = lst_ItemSearched.getSelectedValue();
						System.out.println(item);
						List<HangHoa> ds = new ArrayList<HangHoa>();
						loadData(ds);
					} else if (lst_TieuChi.getSelectedIndex() == 3) {
						String item = lst_ItemSearched.getSelectedValue();
						System.out.println(item);
						List<HangHoa> ds = new ArrayList<HangHoa>();
						loadData(ds);
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

	public String createMaHangHoa(String ma) {
		int id = Integer.parseInt(ma.substring(2));
		if (id < 9) {
			id++;
			return "HH000" + id;
		} else if (id < 99) {
			id++;
			return "HH00" + id;
		} else if (id < 999) {
			id++;
			return "HH0" + id;
		}
		id++;
		return "HH" + id;
	}

	public void data() {
		listThuongHieu = new ArrayList<String>();
		listThuongHieu.add("adidas");
		listThuongHieu.add("nike");
		listThuongHieu.add("jordan");
		listThuongHieu.add("convert");
		listThuongHieu.add("hunter");

		listChatLieu = new ArrayList<String>();
		listChatLieu.add("Cotton");
		listChatLieu.add("Jean");
		listChatLieu.add("Silk");
		listChatLieu.add("Leather");
		listChatLieu.add("Nylon");
		listChatLieu.add("Spandex");
		listChatLieu.add("Chiffon");
		listChatLieu.add("Wool");

		listXuatXu = new ArrayList<String>();
		listXuatXu.add("Việt Nam");
		listXuatXu.add("Mỹ");
		listXuatXu.add("Thái lan");
		listXuatXu.add("Nhật");
		listXuatXu.add("Hàn");

		ds = new ArrayList<HangHoa>();
		ds.add(new HangHoa("HH001", "Áo thun nam", "Áo thun", "Adidas", "Việt Nam", "Cotton",
				"Áo thun nam Adidas màu đen", "image1.jpg", "NCC001", "L", "Đen", 100, 0, 25.5, true));
		ds.add(new HangHoa("HH002", "Quần jean nữ", "Quần jean", "Levi's", "Mỹ", "Jean", "Quần jean nữ Levi's màu xanh",
				"image2.jpg", "NCC002", "M", "Xanh", 80, 10, 40.0, true));
		ds.add(new HangHoa("HH003", "Áo thun nam", "Áo thun", "Adidas", "Việt Nam", "Cotton",
				"Áo thun nam Adidas màu đen", "image1.jpg", "NCC001", "L", "Đen", 100, 0, 25.5, true));
		ds.add(new HangHoa("HH004", "Quần jean nữ", "Quần jean", "Levi's", "Mỹ", "Jean", "Quần jean nữ Levi's màu xanh",
				"image2.jpg", "NCC002", "M", "Xanh", 80, 10, 40.0, true));
		ds.add(new HangHoa("HH005", "Áo thun nam", "Áo thun", "Adidas", "Việt Nam", "Cotton",
				"Áo thun nam Adidas màu đen", "image1.jpg", "NCC001", "L", "Đen", 100, 0, 25.5, true));
		ds.add(new HangHoa("HH006", "Quần jean nữ", "Quần jean", "Levi's", "Mỹ", "Jean", "Quần jean nữ Levi's màu xanh",
				"image2.jpg", "NCC002", "M", "Xanh", 80, 10, 40.0, true));
		ds.add(new HangHoa("HH007", "Áo thun nam", "Áo thun", "Adidas", "Việt Nam", "Cotton",
				"Áo thun nam Adidas màu đen", "image1.jpg", "NCC001", "L", "Đen", 100, 0, 25.5, true));
		ds.add(new HangHoa("HH008", "Quần jean nữ", "Quần jean", "Levi's", "Mỹ", "Jean", "Quần jean nữ Levi's màu xanh",
				"image2.jpg", "NCC002", "M", "Xanh", 80, 10, 40.0, true));
		ds.add(new HangHoa("HH009", "Áo thun nam", "Áo thun", "Adidas", "Việt Nam", "Cotton",
				"Áo thun nam Adidas màu đen", "image1.jpg", "NCC001", "L", "Đen", 100, 0, 25.5, true));
		ds.add(new HangHoa("HH010", "Quần jean nữ", "Quần jean", "Levi's", "Mỹ", "Jean", "Quần jean nữ Levi's màu xanh",
				"image2.jpg", "NCC002", "M", "Xanh", 80, 10, 40.0, true));
		listTenHangHoa = new ArrayList<String>();
		for (HangHoa hangHoa : ds) {
			listTenHangHoa.add(hangHoa.getTenHangHoa());
		}
	}

	private void loadData(List<HangHoa> dsHangHoa) {
		Dao_HangHoa dao_HangHoa = new Dao_HangHoa();
		for (HangHoa hangHoa : dao_HangHoa.getAll()) {
			System.out.println(hangHoa);
		}
		for (HangHoa hangHoa : dsHangHoa) {
			Object[] row = { hangHoa.getMaHangHoa(), hangHoa.getTenHangHoa(), hangHoa.getThuongHieu(),
					hangHoa.getXuatXu(), hangHoa.getChatLieu(), hangHoa.getKichCo(), hangHoa.getMauSac(),
					hangHoa.getSoLuongTon(), hangHoa.getSoLuongDaBan(), hangHoa.getDonGiaNhap() };
			dataDefault.addRow(row);
		}
	}

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

	public void renderSeatch() {
		if (lst_TieuChi.getSelectedIndex() == 0) {
			String textSearch = txt_Search.getText();
			searchOnTable(textSearch, 0);
		} else if (lst_TieuChi.getSelectedIndex() == 1) {
			searchItem(listTenHangHoa, txt_Search.getText());
		} else if (lst_TieuChi.getSelectedIndex() == 2) {
			searchItem(listThuongHieu, txt_Search.getText());
		} else if (lst_TieuChi.getSelectedIndex() == 3) {
			searchItem(listXuatXu, txt_Search.getText());
		}
	}

	public void searchOnTable(String textSearch, int column) {
		tbl_HangHoa.removeRowSelectionInterval(0, tbl_HangHoa.getRowCount()-1);
		if (textSearch.length()==5) {
			for (int i = 0; i < tbl_HangHoa.getRowCount(); i++) {
				if (textSearch.toLowerCase().compareToIgnoreCase(tbl_HangHoa.getValueAt(i, column)+"")==0) {
					tbl_HangHoa.setRowSelectionInterval(i, i);
					break;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_add)) {
			new ImageUploader().setVisible(true);

		} else if (e.getSource().equals(btn_delete)) {
			if (tbl_HangHoa.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm muốn xoá.");
			} else {
				int row = tbl_HangHoa.getSelectedRow();
				System.out.println("xoá sản phẩm:" + tbl_HangHoa.getValueAt(row, 0));
			}
		} else if (e.getSource().equals(btn_edit)) {
			if (tbl_HangHoa.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm muốn chỉnh sửa.");
			} else {
				int row = tbl_HangHoa.getSelectedRow();
				System.out.println("load data sản phẩm" + tbl_HangHoa.getValueAt(row, 0));
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(tbl_HangHoa)) {
			if (e.getClickCount() == 2) {
				System.out.println(tbl_HangHoa.getModel().getValueAt(tbl_HangHoa.getSelectedRow(), 0));
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
		} else if (e.getSource().equals(tbl_HangHoa)) {
			scr_ListItemSearched.setVisible(false);
			txt_Search.setFocusable(false);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(lst_TieuChi)) {
			lst_TieuChi.setVisible(false);
		} else if (e.getSource().equals(tbl_HangHoa)) {
			txt_Search.setFocusable(true);
		} else if (e.getSource().equals(scr_ListItemSearched)) {
			scr_ListItemSearched.setVisible(false);
		}

	}
}
