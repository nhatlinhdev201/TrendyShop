package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDataBase;
import entities.NhaCungCap;

public class Dao_NhaCungCap {
	private Connection connection;

	public Dao_NhaCungCap() {
		connection = ConnectDataBase.getInstance().connection;
	}
	
	public List<NhaCungCap> getAll() {
		List<NhaCungCap> list = null;
		try {
			list = new ArrayList<NhaCungCap>();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from nha_cung_cap");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				NhaCungCap nhaCungCap = new NhaCungCap();
				nhaCungCap.setMaNhaCungCap(resultSet.getString("maNhaCungCap").trim());
				nhaCungCap.setTenNhaCungCap(resultSet.getString("tenNhaCungCap"));
				nhaCungCap.setSoDienThoai(resultSet.getString("soDienThoai"));
				nhaCungCap.setEmail(resultSet.getString("email"));
				nhaCungCap.setDiaChi(resultSet.getString("diaChi"));
				list.add(nhaCungCap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
