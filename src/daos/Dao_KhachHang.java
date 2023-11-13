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
				kh.setMaKhachHang(resultSet.getString("maKhachHang").trim());
				kh.setSoDienThoai(resultSet.getString("soDienThoai").trim());
				kh.setTenKhachHang(resultSet.getString("tenKhachHang").trim());
				kh.setEmail(resultSet.getString("email").trim());
				kh.setDiaChi(resultSet.getString("diaChi").trim());
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
				kh.setMaKhachHang(resultSet.getString("maKhachHang").trim());
				kh.setSoDienThoai(resultSet.getString("soDienThoai").trim());
				kh.setTenKhachHang(resultSet.getString("tenKhachHang").trim());
				kh.setEmail(resultSet.getString("email").trim());
				kh.setDiaChi(resultSet.getString("diaChi").trim());
				kh.setTrangThai(resultSet.getBoolean("trangThai"));
				kh.setDiemTichLuy(resultSet.getFloat("diemTichLuy"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}
	
	public KhachHang getKhachHangTheoSDT(String sdt) {
		KhachHang kh =null;
		try {
			PreparedStatement statement = connection.prepareStatement("select*from KhachHang where soDienThoai = '"+sdt+"'");
			ResultSet resultSet = statement.executeQuery();
			kh= new KhachHang();
			while (resultSet.next()) {
				kh.setMaKhachHang(resultSet.getString("maKhachHang").trim());
				kh.setSoDienThoai(resultSet.getString("soDienThoai").trim());
				kh.setTenKhachHang(resultSet.getString("tenKhachHang").trim());
				kh.setEmail(resultSet.getString("email").trim());
				kh.setDiaChi(resultSet.getString("diaChi").trim());
				kh.setTrangThai(resultSet.getBoolean("trangThai"));
				kh.setDiemTichLuy(resultSet.getFloat("diemTichLuy"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}
	
	public boolean updateKhachHang(KhachHang khachHang) {
		try {

			String updateQuery = "UPDATE KhachHang " + "SET soDienThoai = ?, tenKhachHang = ?, email = ?, diaChi = ?, "
					+ "trangThai = ?, diemTichLuy = ? "
					+ "WHERE maKhachHang = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, khachHang.getSoDienThoai());
			preparedStatement.setString(2,khachHang.getTenKhachHang());
			preparedStatement.setString(3,khachHang.getEmail());
			preparedStatement.setString(4,khachHang.getDiaChi());			
			preparedStatement.setBoolean(5, khachHang.isTrangThai());
			preparedStatement.setFloat(6, khachHang.getDiemTichLuy());
			preparedStatement.setString(7, khachHang.getMaKhachHang());

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

	public List<KhachHang> getAllKhachHangCho() {
		List<KhachHang> dsKhachHang = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select*from KhachHang where maKhachHang like 'KC%'");
			ResultSet resultSet = statement.executeQuery();
			dsKhachHang = new ArrayList<KhachHang>();
			while (resultSet.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKhachHang(resultSet.getString("maKhachHang").trim());
				kh.setSoDienThoai(resultSet.getString("soDienThoai").trim());
				kh.setTenKhachHang(resultSet.getString("tenKhachHang").trim());
				kh.setEmail(resultSet.getString("email").trim());
				kh.setDiaChi(resultSet.getString("diaChi").trim());
				kh.setTrangThai(resultSet.getBoolean("trangThai"));
				kh.setDiemTichLuy(resultSet.getFloat("diemTichLuy"));

				dsKhachHang.add(kh);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}
	
	
	
//	public boolean insertKhachHang(KhachHang khachHang) {
//		try {
//
//			String insertQuery = "INSERT INTO KhachHang (maHoaDon, thoiGianTao,tongThanhTien, maVoucher,maKhachHang,maNhanVien,  trangThaiThanhToan) "
//					+ "VALUES (?, ?, ?, ?, ?, ?,?)";
//
//			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
//
//			preparedStatement.setString(1, hoaDon.getMaHoaDon());
//			preparedStatement.setDate(2, Date.valueOf(hoaDon.getThoiGianTao()));
//			preparedStatement.setLong(3,(long)  hoaDon.getTongThanhTien());
//			preparedStatement.setString(4, hoaDon.getVoucher().getMaVoucher());
//			preparedStatement.setString(5, hoaDon.getKhachHang().getMaKhachHang());
//			preparedStatement.setString(6, hoaDon.getNguoiLapHoaDon().getMaNhanVien());
//			preparedStatement.setBoolean(7, hoaDon.isTrangThaiThanhToan());
//
//			int n = preparedStatement.executeUpdate();
//			if (n > 0) {
//				return true;
//			}
//			preparedStatement.close();
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
	
}
