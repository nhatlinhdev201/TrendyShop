package gui.user;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entities.HangHoa;

public class AbstractTableHoaDon extends AbstractTableModel  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames = {"#", "Tên hàng hóa", "Đơn giá", "Số lượng","Thành tiền", "Xóa"};
    private ArrayList<Object> data = new ArrayList<>();

    public void addHangHoa(Object hangHoa) {
        data.add(hangHoa);
        fireTableDataChanged();
    }

    public void removeHangHoa(int row) {
        data.remove(row);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        if (col == 0) return row+1;
        if (col == 1) return ((HangHoa) data.get(row)).getTenHangHoa();
        if (col == 2) return ((HangHoa) data.get(row)).getDonGiaNhap();
        if (col == 3) return 1;
        if(col == 4) return ((HangHoa) data.get(row)).getDonGiaNhap();
        if (col == 5) return "";
        return null;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 5;
    }
}