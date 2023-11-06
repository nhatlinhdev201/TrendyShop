package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDataBase;
import entities.HangHoa;

public class Dao_HangHoa {
	public Connection connection;

	public Dao_HangHoa() {
		connection = ConnectDataBase.getInstance().getConnection();
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
				hangHoa.setTenHangHoa(resultSet.getString("tenHangHoa").trim());
				hangHoa.setPhanLoai(resultSet.getString("phanLoai").trim());
				hangHoa.setThuongHieu(resultSet.getString("thuongHieu").trim());
				hangHoa.setXuatXu(resultSet.getString("xuatXu").trim());
				hangHoa.setChatLieu(resultSet.getString("chatLieu").trim());
				hangHoa.setChiTietMoTa(resultSet.getString("chiTietMoTa").trim());
				hangHoa.setHinhAnh(resultSet.getString("hinhAnh").trim());
				hangHoa.setMaNhaCungCap(resultSet.getString("maNhaCungCap").trim());
				hangHoa.setKichCo(resultSet.getString("kichCo").trim());
				hangHoa.setMauSac(resultSet.getString("mauSac").trim());
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
			PreparedStatement statement = connection
					.prepareStatement("select hh.thuongHieu from hang_hoa hh group by hh.thuongHieu");
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

	public List<String> getAllTenHangHoa() {
		List<String> dsThuongHieu = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select hh.tenHangHoa from hang_hoa hh group by hh.tenHangHoa");
			ResultSet resultSet = statement.executeQuery();
			dsThuongHieu = new ArrayList<String>();
			while (resultSet.next()) {
				dsThuongHieu.add(resultSet.getString("tenHangHoa"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThuongHieu;
	}

	public List<String> getAllXuatXu() {
		List<String> dsThuongHieu = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select hh.xuatXu from hang_hoa hh group by hh.xuatXu");
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

	public List<HangHoa> getHangHoaByXuatXu(String xuatXu) {
		List<HangHoa> dsHangHoa = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from hang_hoa where xuatXu = N'" + xuatXu + "'");
			ResultSet resultSet = statement.executeQuery();
			dsHangHoa = new ArrayList<HangHoa>();
			while (resultSet.next()) {
				HangHoa hangHoa = new HangHoa();
				hangHoa.setMaHangHoa(resultSet.getString("maHangHoa").trim());
				hangHoa.setTenHangHoa(resultSet.getString("tenHangHoa").trim());
				hangHoa.setPhanLoai(resultSet.getString("phanLoai").trim());
				hangHoa.setThuongHieu(resultSet.getString("thuongHieu").trim());
				hangHoa.setXuatXu(resultSet.getString("xuatXu").trim());
				hangHoa.setChatLieu(resultSet.getString("chatLieu").trim());
				hangHoa.setChiTietMoTa(resultSet.getString("chiTietMoTa").trim());
				hangHoa.setHinhAnh(resultSet.getString("hinhAnh").trim());
				hangHoa.setMaNhaCungCap(resultSet.getString("maNhaCungCap").trim());
				hangHoa.setKichCo(resultSet.getString("kichCo").trim());
				hangHoa.setMauSac(resultSet.getString("mauSac").trim());
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

	public List<HangHoa> getHangHoaByThuongHieu(String thuongHieu) {
		List<HangHoa> dsHangHoa = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from hang_hoa where thuongHieu = N'" + thuongHieu + "'");
			ResultSet resultSet = statement.executeQuery();
			dsHangHoa = new ArrayList<HangHoa>();
			while (resultSet.next()) {
				HangHoa hangHoa = new HangHoa();
				hangHoa.setMaHangHoa(resultSet.getString("maHangHoa").trim());
				hangHoa.setTenHangHoa(resultSet.getString("tenHangHoa").trim());
				hangHoa.setPhanLoai(resultSet.getString("phanLoai").trim());
				hangHoa.setThuongHieu(resultSet.getString("thuongHieu").trim());
				hangHoa.setXuatXu(resultSet.getString("xuatXu").trim());
				hangHoa.setChatLieu(resultSet.getString("chatLieu").trim());
				hangHoa.setChiTietMoTa(resultSet.getString("chiTietMoTa").trim());
				hangHoa.setHinhAnh(resultSet.getString("hinhAnh").trim());
				hangHoa.setMaNhaCungCap(resultSet.getString("maNhaCungCap").trim());
				hangHoa.setKichCo(resultSet.getString("kichCo").trim());
				hangHoa.setMauSac(resultSet.getString("mauSac").trim());
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

	public List<HangHoa> getHangHoaByTenHangHoa(String ten) {
		List<HangHoa> dsHangHoa = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from hang_hoa where tenHangHoa = N'" + ten + "'");
			ResultSet resultSet = statement.executeQuery();
			dsHangHoa = new ArrayList<HangHoa>();
			while (resultSet.next()) {
				HangHoa hangHoa = new HangHoa();
				hangHoa.setMaHangHoa(resultSet.getString("maHangHoa").trim());
				hangHoa.setTenHangHoa(resultSet.getString("tenHangHoa").trim());
				hangHoa.setPhanLoai(resultSet.getString("phanLoai").trim());
				hangHoa.setThuongHieu(resultSet.getString("thuongHieu").trim());
				hangHoa.setXuatXu(resultSet.getString("xuatXu").trim());
				hangHoa.setChatLieu(resultSet.getString("chatLieu").trim());
				hangHoa.setChiTietMoTa(resultSet.getString("chiTietMoTa").trim());
				hangHoa.setHinhAnh(resultSet.getString("hinhAnh").trim());
				hangHoa.setMaNhaCungCap(resultSet.getString("maNhaCungCap").trim());
				hangHoa.setKichCo(resultSet.getString("kichCo").trim());
				hangHoa.setMauSac(resultSet.getString("mauSac").trim());
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

	public HangHoa getHangHoaByMaHangHao(String ma) {
		HangHoa hangHoa = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from hang_hoa where maHangHoa = N'" + ma + "'");
			ResultSet resultSet = statement.executeQuery();
			hangHoa = new HangHoa();
			while (resultSet.next()) {
				hangHoa.setMaHangHoa(resultSet.getString("maHangHoa").trim());
				hangHoa.setTenHangHoa(resultSet.getString("tenHangHoa").trim());
				hangHoa.setPhanLoai(resultSet.getString("phanLoai").trim());
				hangHoa.setThuongHieu(resultSet.getString("thuongHieu").trim());
				hangHoa.setXuatXu(resultSet.getString("xuatXu").trim());
				hangHoa.setChatLieu(resultSet.getString("chatLieu").trim());
				hangHoa.setChiTietMoTa(resultSet.getString("chiTietMoTa").trim());
				hangHoa.setHinhAnh(resultSet.getString("hinhAnh").trim());
				hangHoa.setMaNhaCungCap(resultSet.getString("maNhaCungCap").trim());
				hangHoa.setKichCo(resultSet.getString("kichCo").trim());
				hangHoa.setMauSac(resultSet.getString("mauSac").trim());
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
	public String getMaHangHoaNew() {
		String maHangHoa = "";
		try {
			PreparedStatement statement = connection
					.prepareStatement("select top(1) maHangHoa from hang_hoa order by maHangHoa desc");
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			maHangHoa = resultSet.getString("maHangHoa").trim();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return maHangHoa;

	}
	public boolean deleteHangHoa(String mahh) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update hang_hoa set trangThai = 0 where maHangHoa = '" + mahh + "'");
			int n = preparedStatement.executeUpdate();
			if (n > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertHangHoa(HangHoa hangHoa) {
		try {

			String insertQuery = "INSERT INTO hang_hoa (maHangHoa, tenHangHoa, phanLoai, thuongHieu, xuatXu, chatLieu, chiTietMoTa, hinhAnh, maNhaCungCap, kichCo, mauSac, soLuongTon, soLuongDaBan, donGiaNhap, trangThai) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, hangHoa.getMaHangHoa());
			preparedStatement.setString(2, hangHoa.getTenHangHoa());
			preparedStatement.setString(3, hangHoa.getPhanLoai());
			preparedStatement.setString(4, hangHoa.getThuongHieu());
			preparedStatement.setString(5, hangHoa.getXuatXu());
			preparedStatement.setString(6, hangHoa.getChatLieu());
			preparedStatement.setString(7, hangHoa.getChiTietMoTa());
			preparedStatement.setString(8, hangHoa.getHinhAnh());
			preparedStatement.setString(9, hangHoa.getMaNhaCungCap());
			preparedStatement.setString(10, hangHoa.getKichCo());
			preparedStatement.setString(11, hangHoa.getMauSac());
			preparedStatement.setInt(12, hangHoa.getSoLuongTon());
			preparedStatement.setInt(13, hangHoa.getSoLuongDaBan());
			preparedStatement.setDouble(14, hangHoa.getDonGiaNhap());
			preparedStatement.setBoolean(15, hangHoa.isTrangThai());

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

	public boolean updateHangHoa(HangHoa hangHoa) {
		try {

			String updateQuery = "UPDATE hang_hoa " + "SET tenHangHoa = ?, phanLoai = ?, thuongHieu = ?, xuatXu = ?, "
					+ "chatLieu = ?, chiTietMoTa = ?, hinhAnh = ?, maNhaCungCap = ?, "
					+ "kichCo = ?, mauSac = ?, soLuongTon = ?, soLuongDaBan = ?, donGiaNhap = ?, " + "trangThai = ? "
					+ "WHERE maHangHoa = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, hangHoa.getTenHangHoa());
			preparedStatement.setString(2, hangHoa.getPhanLoai());
			preparedStatement.setString(3, hangHoa.getThuongHieu());
			preparedStatement.setString(4, hangHoa.getXuatXu());
			preparedStatement.setString(5, hangHoa.getChatLieu());
			preparedStatement.setString(6, hangHoa.getChiTietMoTa());
			preparedStatement.setString(7, hangHoa.getHinhAnh());
			preparedStatement.setString(8, hangHoa.getMaNhaCungCap());
			preparedStatement.setString(9, hangHoa.getKichCo());
			preparedStatement.setString(10, hangHoa.getMauSac());
			preparedStatement.setInt(11, hangHoa.getSoLuongTon());
			preparedStatement.setInt(12, hangHoa.getSoLuongDaBan());
			preparedStatement.setDouble(13, hangHoa.getDonGiaNhap());
			preparedStatement.setBoolean(14, hangHoa.isTrangThai());
			preparedStatement.setString(15, hangHoa.getMaHangHoa());

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
	
}
