package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDataBase;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import entities.VoucherGiamGia;

public class Dao_HoaDon {
	public Connection connection;

	public Dao_HoaDon() {
		connection = ConnectDataBase.getInstance().connection;
	}
	public boolean insertHoaDon(HoaDon hoaDon) {
		try {

			String insertQuery = "INSERT INTO HoaDon (maHoaDon, thoiGianTao,tongThanhTien, maVoucher,maKhachHang,maNhanVien,  trangThaiThanhToan) "
					+ "VALUES (?, ?, ?, ?, ?, ?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(0, hoaDon.getMaHoaDon());
			preparedStatement.setDate(1, Date.valueOf(hoaDon.getThoiGianTao()));
			preparedStatement.setDouble(2, hoaDon.getTongThanhTien());
			preparedStatement.setString(3, hoaDon.getVoucher().getMaVoucher());
			preparedStatement.setString(4, hoaDon.getKhachHang().getMaKhachHang());
			preparedStatement.setString(5, hoaDon.getNguoiLapHoaDon().getMaNhanVien());
			preparedStatement.setBoolean(6, hoaDon.isTrangThaiThanhToan());
			

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
	
	public List<HoaDon> getAll() {
		List<HoaDon> dsHoaDon = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from HoaDon");
			ResultSet resultSet = statement.executeQuery();
			dsHoaDon = new ArrayList<HoaDon>();
			while (resultSet.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(resultSet.getString("maHoaDon").trim());
				hoaDon.setThoiGianTao(resultSet.getDate("thoiGianTao").toLocalDate());
				hoaDon.setTongThanhTien(resultSet.getDouble("tongThanhTien"));
				hoaDon.setVoucher(new VoucherGiamGia(resultSet.getString("maVoucher")));
				hoaDon.setKhachHang(new KhachHang(resultSet.getString("maKhachHang")));
				hoaDon.setNguoiLapHoaDon(new NhanVien(resultSet.getString("maNhanVien")));
				hoaDon.setTrangThaiThanhToan(resultSet.getBoolean("trangThaiThanhToan"));
				
				
				dsHoaDon.add(hoaDon);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoaDon;
	}
}	
