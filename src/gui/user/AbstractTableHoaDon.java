package gui.user;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entities.ChiTietHoaDon;
import entities.HangHoa;
import entities.HoaDon;
import entities.KhachHang;

class AbstractTableHoaDon extends AbstractTableModel  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames = {"#", "Tên hàng hóa","Kích cỡ",  "Số lượng","Đơn giá","Thành tiền", "Xóa"};
    private ArrayList<ChiTietHoaDon> data = new ArrayList<>();
    private DecimalFormat decimalFormat = new DecimalFormat("#,##0");
    

    public void addHangHoa(ChiTietHoaDon chiTiet) {
        data.add(chiTiet);
        fireTableDataChanged();
    }
    public void removeAllHoaDon() {
        data.removeAll(data);
        fireTableDataChanged();
    }
    
    public void setHangHoa(int row, ChiTietHoaDon chiTiet) {
        data.set(row, chiTiet);
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
        if (col == 1) return ((ChiTietHoaDon) data.get(row)).getHangHoa().getTenHangHoa();
        if (col == 2) return ((ChiTietHoaDon) data.get(row)).getHangHoa().getKichCo();
        if (col == 3) return ((ChiTietHoaDon) data.get(row)).getSoLuong();
        if(col == 4) return decimalFormat.format(((ChiTietHoaDon) data.get(row)).getGiaBan());
        if(col == 5) return decimalFormat.format(((ChiTietHoaDon) data.get(row)).tinhTongThanhTien());
        if (col == 6) return "";
        return null;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 6;
    }
}

class AbstractTableHangCho extends AbstractTableModel  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames = {"#", "Số điện thoại","Xóa"};
    private ArrayList<KhachHang> data = new ArrayList<>();
    private DecimalFormat decimalFormat = new DecimalFormat("#,##0");
    

    public void addHangCho(KhachHang kh) {
        data.add(kh);
        fireTableDataChanged();
    }
    
    public void setHangCho(int row, KhachHang khachHang) {
        data.set(row, khachHang);
        fireTableDataChanged();
    }
    
    public void removeHangCho(int row) {
        data.remove(row);
        fireTableDataChanged();
    }
    public void removeAllHangCho() {
        data.removeAll(data);
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
        if(col ==1) return data.get(row).getSoDienThoai();
        if (col == 2) return "";
        return null;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 2;
    }
}