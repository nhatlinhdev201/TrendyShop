package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.ConnectDataBase;
import entities.KhachHang;
import entities.NhanVien;

public class Dao_NhanVien {
	public Connection connection;

	public Dao_NhanVien() {
		connection = ConnectDataBase.getInstance().connection;
	}
	
	
	
	public NhanVien getNhanVienTheoMa(String maNhanVien) {
		NhanVien nv = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select*from NhanVien where maNhanVien = '"+maNhanVien+"'");
			ResultSet resultSet = statement.executeQuery();
			nv = new NhanVien();
			while (resultSet.next()) {
				nv.setMaNhanVien(resultSet.getString("maNhanVien").trim());
				nv.setHoTen(resultSet.getString("hoTen").trim());
				nv.setNgaySinh(resultSet.getDate("ngaySinh"));
				nv.setSoCCCD(resultSet.getString("soCCCD"));
				nv.setSoDienThoai(resultSet.getString("soDienThoai"));
				nv.setEmail(resultSet.getString("email"));
				nv.setDiaChi(resultSet.getString("diaChi"));
				nv.setChucVu(resultSet.getString("chucVu"));
				nv.setTrangThai(resultSet.getBoolean("trangThai"));
				nv.setMatKhau(resultSet.getString("matKhau"));
				nv.setPhanQuyen(resultSet.getBoolean("phanQuyen"));
				nv.setAnhDaiDien(resultSet.getString("hinhAnh"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
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
