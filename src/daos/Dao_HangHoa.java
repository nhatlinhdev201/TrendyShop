package daos;

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
	
	/**
	 * lấy toàn bộ danh sách hàng hóa
	 * @return listHangHoa
	 */

	public List<HangHoa> getAll() {
		List<HangHoa> dsHangHoa = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from HangHoa");
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
				hangHoa.setChiTietMoTa(resultSet.getString("chiTietMoTa"));
				hangHoa.setHinhAnh(resultSet.getString("hinhAnh"));
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

	/**
	 * Get tên các thương hiệu có trong db
	 * @return
	 */
	public List<String> getAllThuongHieu() {
		List<String> dsThuongHieu = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select hh.thuongHieu from HangHoa hh group by hh.thuongHieu");
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

	/**
	 * get tên các hàng hóa có trong db
	 * @return
	 */
	public List<String> getAllTenHangHoa() {
		List<String> dsThuongHieu = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select hh.tenHangHoa from HangHoa hh group by hh.tenHangHoa");
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

	/**
	 * get tên xuất xứ có trong db
	 * @return
	 */
	public List<String> getAllXuatXu() {
		List<String> dsThuongHieu = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select hh.xuatXu from HangHoa hh group by hh.xuatXu");
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

	/**
	 * Lấy các hàng hóa theo xuất xứ
	 * @param xuatXu
	 * @return
	 */
	public List<HangHoa> getHangHoaByXuatXu(String xuatXu) {
		List<HangHoa> dsHangHoa = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from HangHoa where xuatXu = N'" + xuatXu + "'");
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
				hangHoa.setChiTietMoTa(resultSet.getString("chiTietMoTa"));
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

	/**
	 * get danh sách các hàng hóa theo thương hiệu
	 * @param thuongHieu
	 * @return
	 */
	public List<HangHoa> getHangHoaByThuongHieu(String thuongHieu) {
		List<HangHoa> dsHangHoa = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from HangHoa where thuongHieu = N'" + thuongHieu + "'");
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

	/**
	 * get danh sách các hàng hóa theo tên hàng hóa
	 * @param ten
	 * @return
	 */
	public List<HangHoa> getHangHoaByTenHangHoa(String ten) {
		List<HangHoa> dsHangHoa = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from HangHoa where tenHangHoa = N'" + ten + "'");
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
				hangHoa.setChiTietMoTa(resultSet.getString("chiTietMoTa"));
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

	/**
	 * Lấy thông tin mã hàng hóa nhập vào
	 * @param ma
	 * @return hanghoa
	 */
	public HangHoa getHangHoaByMaHangHao(String ma) {
		HangHoa hangHoa = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from HangHoa where maHangHoa = N'" + ma + "'");
			ResultSet resultSet = statement.executeQuery();
			hangHoa = new HangHoa();
			while (resultSet.next()) {
				hangHoa.setMaHangHoa(resultSet.getString("maHangHoa").trim());
				hangHoa.setTenHangHoa(resultSet.getString("tenHangHoa").trim());
				hangHoa.setPhanLoai(resultSet.getString("phanLoai").trim());
				hangHoa.setThuongHieu(resultSet.getString("thuongHieu").trim());
				hangHoa.setXuatXu(resultSet.getString("xuatXu").trim());
				hangHoa.setChatLieu(resultSet.getString("chatLieu").trim());
//<<<<<<< HEAD
//				hangHoa.setChiTietMoTa(resultSet.getString("chiTietMoTa"));
//				hangHoa.setHinhAnh(resultSet.getString("hinhAnh").trim());
//=======
				hangHoa.setChiTietMoTa(resultSet.getString("chiTietMoTa").trim());
				hangHoa.setHinhAnh(resultSet.getString("hinhAnh"));
//>>>>>>> origin/main
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
//<<<<<<< HEAD
	
	/**
	 * Tìm hàng hóa có mã lớn nhất
	 * @return
	 */
	public int getMaHangHoaNew() {
		int maHangHoa=0;
//=======

//	public String getMaHangHoaNew() {
//		String maHangHoa = "";
//>>>>>>> origin/main
		try {
			PreparedStatement statement = connection
					.prepareStatement("select top(1) maHangHoa from HangHoa order by maHangHoa desc");
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
	            String maHangHoaString = resultSet.getString("maHangHoa");
	            if (maHangHoaString != null && maHangHoaString.length() >= 9) {
	                // Lấy phần số từ vị trí 2 đến 5 và chuyển đổi thành số nguyên
	                maHangHoa = Integer.parseInt(maHangHoaString.substring(2, 6));
	            }
	        }
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return maHangHoa;

	}
//<<<<<<< HEAD
	
	
	/**
	 * Xóa hàng hóa (chuyển trạng thái từ true về false
	 * @param mahh
	 * @return
	 */
//=======

//>>>>>>> origin/main
	public boolean deleteHangHoa(String mahh) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update HangHoa set trangThai = 0 where maHangHoa = '" + mahh + "'");
			int n = preparedStatement.executeUpdate();
			if (n > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Thêm hàng hóa vào database
	 * @param hangHoa
	 * @return
	 */
	public boolean insertHangHoa(HangHoa hangHoa) {
		try {

			String insertQuery = "INSERT INTO HangHoa (maHangHoa, tenHangHoa, phanLoai, thuongHieu, xuatXu, chatLieu, chiTietMoTa, hinhAnh, maNhaCungCap, kichCo, mauSac, soLuongTon, soLuongDaBan, donGiaNhap, trangThai) "
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

	/**
	 * Cập nhật thông tin của hàng hóa
	 * @param hangHoa
	 * @return
	 */
	public boolean updateHangHoa(HangHoa hangHoa) {
		try {

			String updateQuery = "UPDATE HangHoa " + "SET tenHangHoa = ?, phanLoai = ?, thuongHieu = ?, xuatXu = ?, "
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

	public List<String> getKichThuocCuaMotSanPham(String ma) {
		List<String> dsKichThuoc = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select kichCo from HangHoa where maHangHoa LIKE '"+ma+"%'");
			ResultSet resultSet = statement.executeQuery();
			dsKichThuoc = new ArrayList<String>();
			while (resultSet.next()) {
				dsKichThuoc.add(resultSet.getString("kichCo"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKichThuoc;
	}

	public HangHoa getListHangHoaByMaHangHoa(String ma) {
		HangHoa hangHoa = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select*from HangHoa where maHangHoa = '"+ma+"'");
			ResultSet resultSet = statement.executeQuery();
			hangHoa = new HangHoa();
			while (resultSet.next()) {
				hangHoa.setMaHangHoa(resultSet.getString("maHangHoa"));
				hangHoa.setTenHangHoa(resultSet.getString("tenHangHoa"));
				hangHoa.setPhanLoai(resultSet.getString("phanLoai"));
				hangHoa.setThuongHieu(resultSet.getString("thuongHieu"));
				hangHoa.setXuatXu(resultSet.getString("xuatXu"));
				hangHoa.setChatLieu(resultSet.getString("chatLieu"));
				hangHoa.setChiTietMoTa(resultSet.getString("chiTietMoTa"));
				hangHoa.setHinhAnh(resultSet.getString("hinhAnh"));
				hangHoa.setMaNhaCungCap(resultSet.getString("maNhaCungCap"));
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
