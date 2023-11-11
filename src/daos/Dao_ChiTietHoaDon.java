package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDataBase;
import entities.ChiTietHoaDon;
import entities.HangHoa;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import entities.VoucherGiamGia;

public class Dao_ChiTietHoaDon {
	public Connection connection;

	public Dao_ChiTietHoaDon() {
		connection = ConnectDataBase.getInstance().connection;
	}
	
	public List<ChiTietHoaDon> getAll() {
		List<ChiTietHoaDon> dsChiTietHoaDon = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from ChiTietHoaDon");
			ResultSet resultSet = statement.executeQuery();
			dsChiTietHoaDon = new ArrayList<ChiTietHoaDon>();
			while (resultSet.next()) {
				ChiTietHoaDon chiTietHoaDon= new ChiTietHoaDon();
				chiTietHoaDon.setHangHoa(new HangHoa(resultSet.getString("maHangHoa").trim()));
				chiTietHoaDon.setHoaDon(new HoaDon(resultSet.getString("maHoaDon")));
				chiTietHoaDon.setSoLuong(resultSet.getInt("soLuong"));
				chiTietHoaDon.setGiaBan(resultSet.getDouble("giaBan"));
				chiTietHoaDon.setThanhTien(resultSet.getDouble("thanhTien"));
				
				
				dsChiTietHoaDon.add(chiTietHoaDon);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsChiTietHoaDon;
	}
	
	public List<ChiTietHoaDon> getChiTietTheoMaHoaDon(String maHoaDon) {
		List<ChiTietHoaDon> dsChiTietHoaDon = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select*from ChiTietHoaDon where maHoaDon='"+maHoaDon+"'");
			ResultSet resultSet = statement.executeQuery();
			dsChiTietHoaDon = new ArrayList<ChiTietHoaDon>();
			while (resultSet.next()) {
				ChiTietHoaDon chiTietHoaDon= new ChiTietHoaDon();
				chiTietHoaDon.setHangHoa(new HangHoa(resultSet.getString("maHangHoa").trim()));
				chiTietHoaDon.setHoaDon(new HoaDon(resultSet.getString("maHoaDon")));
				chiTietHoaDon.setSoLuong(resultSet.getInt("soLuong"));
				chiTietHoaDon.setGiaBan(resultSet.getDouble("giaBan"));
				chiTietHoaDon.setThanhTien(resultSet.getDouble("thanhTien"));
				
				
				dsChiTietHoaDon.add(chiTietHoaDon);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsChiTietHoaDon;
	}
	
	
}
