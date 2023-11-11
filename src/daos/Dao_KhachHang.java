package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDataBase;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import entities.VoucherGiamGia;

public class Dao_KhachHang {
	public Connection connection;

	public Dao_KhachHang() {
		connection = ConnectDataBase.getInstance().connection;
	}
	
	public List<KhachHang> getAll() {
		List<KhachHang> dsKhachHang = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select*from KhachHang");
			ResultSet resultSet = statement.executeQuery();
			dsKhachHang = new ArrayList<KhachHang>();
			while (resultSet.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKhachHang(resultSet.getString("maKhachHang"));
				kh.setSoDienThoai(resultSet.getString("soDienThoai"));
				kh.setTenKhachHang(resultSet.getString("tenKhachHang"));
				kh.setEmail(resultSet.getString("email"));
				kh.setDiaChi(resultSet.getString("diaChi"));
				kh.setTrangThai(resultSet.getBoolean("trangThai"));
				kh.setDiemTichLuy(resultSet.getFloat("diemTichLuy"));

				dsKhachHang.add(kh);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}
	
	public KhachHang getKhachHangTheoMa(String maKhachHang) {
		KhachHang kh =null;
		try {
			PreparedStatement statement = connection.prepareStatement("select*from KhachHang where maKhachHang = '"+maKhachHang+"'");
			ResultSet resultSet = statement.executeQuery();
			kh= new KhachHang();
			while (resultSet.next()) {
				
				kh.setMaKhachHang(resultSet.getString("maKhachHang"));
				kh.setSoDienThoai(resultSet.getString("soDienThoai"));
				kh.setTenKhachHang(resultSet.getString("tenKhachHang"));
				kh.setEmail(resultSet.getString("email"));
				kh.setDiaChi(resultSet.getString("diaChi"));
				kh.setTrangThai(resultSet.getBoolean("trangThai"));
				kh.setDiemTichLuy(resultSet.getFloat("diemTichLuy"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}
	
}
