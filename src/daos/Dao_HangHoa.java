package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDataBase;
import entities.HangHoa;

public class Dao_HangHoa {
	public Connection connection;

	public Dao_HangHoa() {
		connection = ConnectDataBase.getInstance().connection;
	}
	
	public List<HangHoa> getAll() {
		List<HangHoa> dsHangHoa = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from hang_hoa");
			ResultSet resultSet = statement.executeQuery();
			dsHangHoa = new ArrayList<HangHoa>();
			while (resultSet.next()) {
				HangHoa hangHoa = new HangHoa();
				hangHoa.setMaHangHoa(resultSet.getString("maHangHoa").trim());
				hangHoa.setTenHangHoa(resultSet.getString("tenHangHoa"));
				hangHoa.setPhanLoai(resultSet.getString("phanLoai"));
				hangHoa.setThuongHieu(resultSet.getString("thuongHieu"));
				hangHoa.setXuatXu(resultSet.getString("xuatXu"));
				hangHoa.setChatLieu(resultSet.getString("chatLieu"));
				hangHoa.setChiTietMoTa(resultSet.getString("chiTietMoTa"));
				hangHoa.setHinhAnh(resultSet.getString("hinhAnh"));
				hangHoa.setMaNhaCungCap(resultSet.getString("maNhaCungCap").trim());
				hangHoa.setKichCo(resultSet.getString("kichCo"));
				hangHoa.setMauSac(resultSet.getString("mauSac"));
				hangHoa.setSoLuongTon(resultSet.getInt("soLuongTon"));
				hangHoa.setSoLuongDaBan(resultSet.getInt("soLuongDaBan"));
				hangHoa.setDonGiaNhap(resultSet.getDouble("donGiaNhap"));
				hangHoa.setTrangThai(resultSet.getBoolean("trangThai"));
				dsHangHoa.add(hangHoa);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHangHoa;
	}
	
	public List<String> getAllThuongHieu() {
		List<String> dsThuongHieu = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select hh.thuongHieu from hang_hoa hh group by hh.thuongHieu");
			ResultSet resultSet = statement.executeQuery();
			dsThuongHieu = new ArrayList<String>();
			while (resultSet.next()) {
				dsThuongHieu.add(resultSet.getString("thuongHieu"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThuongHieu;
	}
	public List<String> getAllXuatXu() {
		List<String> dsThuongHieu = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select hh.xuatXu from hang_hoa hh group by hh.xuatXu");
			ResultSet resultSet = statement.executeQuery();
			dsThuongHieu = new ArrayList<String>();
			while (resultSet.next()) {
				dsThuongHieu.add(resultSet.getString("xuatXu"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThuongHieu;
	}
	public HangHoa getHangHoaTheoMa() {
		HangHoa hangHoa = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from hang_hoa hh where ");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				hangHoa.setMaHangHoa(resultSet.getString("maHangHoa").trim());
				hangHoa.setTenHangHoa(resultSet.getString("tenHangHoa"));
				hangHoa.setPhanLoai(resultSet.getString("phanLoai"));
				hangHoa.setThuongHieu(resultSet.getString("thuongHieu"));
				hangHoa.setXuatXu(resultSet.getString("xuatXu"));
				hangHoa.setChatLieu(resultSet.getString("chatLieu"));
				hangHoa.setChiTietMoTa(resultSet.getString("chiTietMoTa"));
				hangHoa.setHinhAnh(resultSet.getString("hinhAnh"));
				hangHoa.setMaNhaCungCap(resultSet.getString("maNhaCungCap").trim());
				hangHoa.setKichCo(resultSet.getString("kichCo"));
				hangHoa.setMauSac(resultSet.getString("mauSac"));
				hangHoa.setSoLuongTon(resultSet.getInt("soLuongTon"));
				hangHoa.setSoLuongDaBan(resultSet.getInt("soLuongDaBan"));
				hangHoa.setDonGiaNhap(resultSet.getDouble("donGiaNhap"));
				hangHoa.setTrangThai(resultSet.getBoolean("trangThai"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hangHoa;
	}
	

}