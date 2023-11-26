package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				chiTietHoaDon.setHoaDon(new HoaDon(resultSet.getString("maHoaDon").trim()));
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
				chiTietHoaDon.setHoaDon(new HoaDon(resultSet.getString("maHoaDon").trim()));
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

	public boolean insertChiTietHoadon(ChiTietHoaDon chitiet) {
		try {

			String insertQuery = "INSERT INTO ChiTietHoaDon (maHangHoa, maHoaDon, soLuong, giaBan, thanhTien) "
					+ "VALUES (?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, chitiet.getHangHoa().getMaHangHoa());
			preparedStatement.setString(2, chitiet.getHoaDon().getMaHoaDon());
			preparedStatement.setInt(3, chitiet.getSoLuong());
			preparedStatement.setDouble(4, chitiet.getGiaBan());
			preparedStatement.setDouble(5, chitiet.getThanhTien());

			int n = preparedStatement.executeUpdate();
			if (n > 0) {
				return true;
			}
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Quyền Cơ:
	 * Xóa chi tiết hóa đơn 
	 * @param mahd
	 * @return
	 */
	public boolean deleteChiTietHoaDon(String mahd) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from ChiTietHoaDon where maHoaDon ='"+mahd+"'");
			int n = preparedStatement.executeUpdate();
			if (n > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
