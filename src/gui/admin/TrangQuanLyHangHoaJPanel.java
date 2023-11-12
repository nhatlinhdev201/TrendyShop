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
	private List<String> listXuatXu;

	private DefaultListModel<String> listItemSearched;
	private JScrollPane scr_ListItemSearched;
	private JList<String> lst_ItemSearched;
	private List<String> listTenHangHoa;
	private List<HangHoa> ds;
	private Dao_HangHoa dao_HangHoa;
	/**
	 * Create the panel.
	 */
	public TrangQuanLyHangHoaJPanel() {
		dao_HangHoa = new Dao_HangHoa();
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
		lbl_iconSearch.setBounds(426, 2, 26, 26);
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

		btn_delete = new JButton("Xoá");
		btn_delete.setIconTextGap(10);
		btn_delete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_delete.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon_delete.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
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
					false,false };

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
				"\u0110\u01A1n gi\u00E1(đ)" ,"Trạng Thái"}, 0) {
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
				if (!e.getValueIsAdjusting() && lst_ItemSearched.getSelectedValue() !=null) {
					if (lst_TieuChi.getSelectedIndex() == 1) {
						String textSearch = lst_ItemSearched.getSelectedValue();
						loadData(dao_HangHoa.getHangHoaByTenHangHoa(textSearch));
						scr_ListItemSearched.setVisible(false);
					} else if (lst_TieuChi.getSelectedIndex() == 2) {
						String item = lst_ItemSearched.getSelectedValue();
						loadData(dao_HangHoa.getHangHoaByThuongHieu(item));
						scr_ListItemSearched.setVisible(false);
					} else if (lst_TieuChi.getSelectedIndex() == 3) {
						String item = lst_ItemSearched.getSelectedValue();
						loadData(dao_HangHoa.getHangHoaByXuatXu(item));
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

	public void data() {
		listThuongHieu = dao_HangHoa.getAllThuongHieu();
		listXuatXu = dao_HangHoa.getAllXuatXu();
		ds = dao_HangHoa.getAll();
		listTenHangHoa = dao_HangHoa.getAllTenHangHoa();
	}

	private void loadData(List<HangHoa> dsHangHoa) {
		dataDefault.setRowCount(0);
		for (HangHoa hangHoa : dsHangHoa) {
			Object[] row = { hangHoa.getMaHangHoa(), hangHoa.getTenHangHoa(), hangHoa.getThuongHieu(),
					hangHoa.getXuatXu(), hangHoa.getChatLieu(), hangHoa.getKichCo(), hangHoa.getMauSac(),
					hangHoa.getSoLuongTon(), hangHoa.getSoLuongDaBan(), hangHoa.getDonGiaNhap() ,hangHoa.isTrangThai()?"Còn bán":"Ngừng bán"};
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
		if (textSearch.length()==6) {
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
			HangHoa hangHoa = new HangHoa();
			Object[] r = { "Thoát" };
			JOptionPane.showOptionDialog(this, new FormThongTinHangHoa(hangHoa, "add"),"Thêm sản phẩm mới.",JOptionPane.DEFAULT_OPTION,JOptionPane.DEFAULT_OPTION,null,r,null);
			ds = dao_HangHoa.getAll();
			loadData(ds);
		} else if (e.getSource().equals(btn_delete)) {
			if (tbl_HangHoa.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm muốn xoá.");
			} else {
				int row = tbl_HangHoa.getSelectedRow();
				if (dao_HangHoa.deleteHangHoa(tbl_HangHoa.getValueAt(row, 0).toString())) {
					JOptionPane.showMessageDialog(this, "Đã xoá thành công sản phẩm");
					ds = dao_HangHoa.getAll();
					loadData(ds);
				}
			}
		} else if (e.getSource().equals(btn_edit)) {
			if (tbl_HangHoa.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm muốn chỉnh sửa.");
			} else {
				int row = tbl_HangHoa.getSelectedRow();
				HangHoa hangHoa = dao_HangHoa.getHangHoaByMaHangHao(tbl_HangHoa.getValueAt(row, 0).toString());
				Object[] r = { "Thoát" };
				JOptionPane.showOptionDialog(this, new FormThongTinHangHoa(hangHoa, "edit"),"Chỉnh sửa thông tin sản phẩm "+hangHoa.getMaHangHoa(),JOptionPane.DEFAULT_OPTION,JOptionPane.DEFAULT_OPTION,null,r,null);
				ds = dao_HangHoa.getAll();
				loadData(ds);
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
