package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.ConnectDataBase;
import entities.KhachHang;

public class Dao_NhanVien {
	public Connection connection;

	public Dao_NhanVien() {
		connection = ConnectDataBase.getInstance().connection;
	}
	
	
	public String getTenNhanVienTheoMa(String maNhanVien) {
		String tenNhanVien="";
		try {
			PreparedStatement statement = connection.prepareStatement("select hoTen from NhanVien where maNhanVien = '"+maNhanVien+"'");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				tenNhanVien = resultSet.getString("hoTen");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tenNhanVien;
	}
}
