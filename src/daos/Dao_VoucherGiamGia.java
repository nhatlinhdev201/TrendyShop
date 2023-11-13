package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.ConnectDataBase;
import entities.HangHoa;
import entities.VoucherGiamGia;

public class Dao_VoucherGiamGia {
	public Connection connection;

	public Dao_VoucherGiamGia() {
		connection = ConnectDataBase.getInstance().connection;
	} 
	
	public List<VoucherGiamGia> getAll() {
		List<VoucherGiamGia> dsVoucher = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select*from VoucherGiamGia");
			ResultSet resultSet = statement.executeQuery();
			dsVoucher = new ArrayList<VoucherGiamGia>();
			while (resultSet.next()) {
				VoucherGiamGia voucher = new VoucherGiamGia(resultSet.getString("maVoucher").trim());
				voucher.setTenVoucher(resultSet.getString("tenVoucher").trim());
				voucher.setMoTaChuongTrinh(resultSet.getString("moTaChuongTrinh"));
				voucher.setPhanTramGiamTheoHoaDon(resultSet.getFloat("phanTramGiamTheoHoaDon"));
				voucher.setNgayBatDau(resultSet.getDate("ngayBatDau"));
				voucher.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
				voucher.setTrangThai(resultSet.getBoolean("trangThai"));
				voucher.setSoLuotSuDung(resultSet.getInt("soLuotDung"));
				dsVoucher.add(voucher);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsVoucher;
	}
	
	public List<VoucherGiamGia> getVoucherTheoNgayBatDau_NgayKetThuc(String ngaySuDung) {
		List<VoucherGiamGia> dsVoucher = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select*from VoucherGiamGia where ngayBatDau <='"+ngaySuDung+"' and ngayKetThuc>='"+ngaySuDung+"'");
			ResultSet resultSet = statement.executeQuery();
			dsVoucher = new ArrayList<VoucherGiamGia>();
			while (resultSet.next()) {
				VoucherGiamGia voucher = new VoucherGiamGia(resultSet.getString("maVoucher").trim());
				voucher.setTenVoucher(resultSet.getString("tenVoucher").trim());
				voucher.setMoTaChuongTrinh(resultSet.getString("moTaChuongTrinh"));
				voucher.setPhanTramGiamTheoHoaDon(resultSet.getFloat("phanTramGiamTheoHoaDon"));
				voucher.setNgayBatDau(resultSet.getDate("ngayBatDau"));
				voucher.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
				voucher.setTrangThai(resultSet.getBoolean("trangThai"));
				voucher.setSoLuotSuDung(resultSet.getInt("soLuotDung"));
				dsVoucher.add(voucher);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsVoucher;
	}
	
	public VoucherGiamGia getTheoMaVouCher(String maVoucher) {
		VoucherGiamGia voucher =null;
		try {
			PreparedStatement statement = connection.prepareStatement("select*from VoucherGiamGia where maVoucher = '"+maVoucher+"'");
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				voucher = new VoucherGiamGia(resultSet.getString("maVoucher").trim());
				voucher.setTenVoucher(resultSet.getString("tenVoucher").trim());
				voucher.setMoTaChuongTrinh(resultSet.getString("moTaChuongTrinh"));
				voucher.setPhanTramGiamTheoHoaDon(resultSet.getFloat("phanTramGiamTheoHoaDon"));
				voucher.setNgayBatDau(resultSet.getDate("ngayBatDau"));
				voucher.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
				voucher.setTrangThai(resultSet.getBoolean("trangThai"));
				voucher.setSoLuotSuDung(resultSet.getInt("soLuotDung"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return voucher;
	}
	
	
	public List<String> getAllPhanTramGiamGia() {
		List<String> dsPhanTramGiamGia = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select vc.phanTramGiamTheoHoaDon from VoucherGiamGia vc group by vc.phanTramGiamTheoHoaDon");
			ResultSet resultSet = statement.executeQuery();
			dsPhanTramGiamGia = new ArrayList<String>();
			while (resultSet.next()) {
				dsPhanTramGiamGia.add(resultSet.getString("phanTramGiamTheoHoaDon"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhanTramGiamGia;
	}
	
	public List<String> getAllTrangThai() {
		List<String> dsTrangThai = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select vc.trangThai from VoucherGiamGia vc group by vc.trangThai");
			ResultSet resultSet = statement.executeQuery();
			dsTrangThai = new ArrayList<String>();
			while (resultSet.next()) {
				dsTrangThai.add(resultSet.getString("trangThai"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTrangThai;
	}
	
	public List<String> getAllTenVoucher() {
		List<String> dsTenVoucher = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select vc.tenVoucher from VoucherGiamGia vc group by vc.tenVoucher");
			ResultSet resultSet = statement.executeQuery();
			dsTenVoucher = new ArrayList<String>();
			while (resultSet.next()) {
				dsTenVoucher.add(resultSet.getString("tenVoucher"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTenVoucher;
	}
}
