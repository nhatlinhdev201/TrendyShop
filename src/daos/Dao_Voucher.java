package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDataBase;
import entities.HangHoa;
import entities.VoucherGiamGia;

public class Dao_Voucher {
	public Connection connection;

	public Dao_Voucher() {
		connection = ConnectDataBase.getInstance().getConnection();
	}
	
	/**
	 * lấy toàn bộ danh sách Voucher
	 * @return listHangHoa
	 */

	public List<VoucherGiamGia> getAll() {
		List<VoucherGiamGia> dsVoucher = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from VoucherGiamGia");
			ResultSet resultSet = statement.executeQuery();
			dsVoucher = new ArrayList<VoucherGiamGia>();
			while (resultSet.next()) {
				VoucherGiamGia voucher = new VoucherGiamGia();
				voucher.setMaVoucher(resultSet.getString("maVoucher").trim());
				voucher.setTenVoucher(resultSet.getString("tenVoucher").trim());
				voucher.setMoTaChuongTrinh(resultSet.getString("moTaChuongTrinh").trim());
				voucher.setPhanTramGiamTheoHoaDon(resultSet.getFloat("phanTramGiamTheoHoaDon"));
				voucher.setNgayBatDau(resultSet.getDate("ngayBatDau"));
				voucher.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
				voucher.setSoLuotDung(resultSet.getInt("soLuotDung"));
				voucher.setTrangThai(resultSet.getBoolean("trangThai"));
				dsVoucher.add(voucher);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsVoucher;
	}

	/**
	 * Get tên các phần trăm giảm giá có trong db
	 * @return
	 */
	public List<String> getAllPhanTramGiamGia() {
		List<String> dsThuongHieu = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select hh.phanTramGiamTheoHoaDon from VoucherGiamGia hh group by hh.phanTramGiamTheoHoaDon");
			ResultSet resultSet = statement.executeQuery();
			dsThuongHieu = new ArrayList<String>();
			while (resultSet.next()) {
				dsThuongHieu.add(resultSet.getString("phanTramGiamTheoHoaDon"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThuongHieu;
	}



	/**
	 * get trạng thái có trong db
	 * @return
	 */
	public List<String> getAllTrangThai() {
		List<String> dsThuongHieu = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select hh.trangThai from VoucherGiamGia hh group by hh.trangThai");
			ResultSet resultSet = statement.executeQuery();
			dsThuongHieu = new ArrayList<String>();
			while (resultSet.next()) {
				dsThuongHieu.add(resultSet.getString("trangThai"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThuongHieu;
	}

	/**
	 * Lấy các hàng hóa theo trạng Thái
	 * @param xuatXu
	 * @return
	 */
	public List<VoucherGiamGia> getHangHoaByTrangThai(String trangThai) {
		List<VoucherGiamGia> dsVoucher = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from VoucherGiamGia where trangThai = N'" + trangThai + "'");
			ResultSet resultSet = statement.executeQuery();
			dsVoucher = new ArrayList<VoucherGiamGia>();
			while (resultSet.next()) {
				VoucherGiamGia voucher = new VoucherGiamGia();
				voucher.setMaVoucher(resultSet.getString("maVoucher").trim());
				voucher.setTenVoucher(resultSet.getString("tenVoucher").trim());
				voucher.setMoTaChuongTrinh(resultSet.getString("moTaChuongTrinh").trim());
				voucher.setPhanTramGiamTheoHoaDon(resultSet.getFloat("phanTramGiamTheoHoaDon"));
				voucher.setNgayBatDau(resultSet.getDate("ngayBatDau"));
				voucher.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
				voucher.setSoLuotDung(resultSet.getInt("soLuotDung"));
				voucher.setTrangThai(resultSet.getBoolean("trangThai"));
				dsVoucher.add(voucher);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsVoucher;
	}

	/**
	 * get danh sách các hàng hóa theo thương hiệu
	 * @param thuongHieu
	 * @return
	 */
	public List<VoucherGiamGia> getHangHoaByPhanTramGiamGia(String phanTramTheoHoaDon) {
		List<VoucherGiamGia> dsVoucher = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from VoucherGiamGia where phanTramGiamTheoHoaDon = N'" + phanTramTheoHoaDon + "'");
			ResultSet resultSet = statement.executeQuery();
			dsVoucher = new ArrayList<VoucherGiamGia>();
			while (resultSet.next()) {
				VoucherGiamGia voucher = new VoucherGiamGia();
				voucher.setMaVoucher(resultSet.getString("maVoucher").trim());
				voucher.setTenVoucher(resultSet.getString("tenVoucher").trim());
				voucher.setMoTaChuongTrinh(resultSet.getString("moTaChuongTrinh").trim());
				voucher.setPhanTramGiamTheoHoaDon(resultSet.getFloat("phanTramGiamTheoHoaDon"));
				voucher.setNgayBatDau(resultSet.getDate("ngayBatDau"));
				voucher.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
				voucher.setSoLuotDung(resultSet.getInt("soLuotDung"));
				voucher.setTrangThai(resultSet.getBoolean("trangThai"));
				dsVoucher.add(voucher);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsVoucher;
	}

	/**
	 * get danh sách các hàng hóa theo phần tram giá bán
	 * @param ten
	 * @return
	 */
	public List<VoucherGiamGia> getHangHoaByVoucher(String ten) {
		List<VoucherGiamGia> dsVoucher = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from VoucherGiamGia where tenVoucher = N'" + ten + "'");
			ResultSet resultSet = statement.executeQuery();
			dsVoucher = new ArrayList<VoucherGiamGia>();
			while (resultSet.next()) {
				VoucherGiamGia voucher = new VoucherGiamGia();
				voucher.setMaVoucher(resultSet.getString("maVoucher").trim());
				voucher.setTenVoucher(resultSet.getString("tenVoucher").trim());
				voucher.setMoTaChuongTrinh(resultSet.getString("moTaChuongTrinh").trim());
				voucher.setPhanTramGiamTheoHoaDon(resultSet.getFloat("phanTramGiamTheoHoaDon"));
				voucher.setNgayBatDau(resultSet.getDate("ngayBatDau"));
				voucher.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
				voucher.setSoLuotDung(resultSet.getInt("soLuotDung"));
				voucher.setTrangThai(resultSet.getBoolean("trangThai"));
				dsVoucher.add(voucher);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsVoucher;
	}

	/**
	 * Lấy thông tin mã hàng hóa nhập vào
	 * @param ma
	 * @return hanghoa
	 */
	public VoucherGiamGia getMaVouCher(String ma) {
		VoucherGiamGia voucher = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from VoucherGiamGia where maVoucher = N'" + ma + "'");
			ResultSet resultSet = statement.executeQuery();
			voucher = new VoucherGiamGia();
			while (resultSet.next()) {
				voucher.setMaVoucher(resultSet.getString("maVoucher").trim());
				voucher.setTenVoucher(resultSet.getString("tenVoucher").trim());
				voucher.setMoTaChuongTrinh(resultSet.getString("moTaChuongTrinh").trim());
				voucher.setPhanTramGiamTheoHoaDon(resultSet.getFloat("phanTramGiamTheoHoaDon"));
				voucher.setNgayBatDau(resultSet.getDate("ngayBatDau"));
				voucher.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
				voucher.setSoLuotDung(resultSet.getInt("soLuotDung"));
				voucher.setTrangThai(resultSet.getBoolean("trangThai"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return voucher;

	}
	
	/**
	 * Tìm hàng hóa có mã lớn nhất
	 * @return
	 */
	public int getMaHangHoaNew() {
		int maHangHoa=0;
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
	
	
	/**
	 * Xóa hàng hóa (chuyển trạng thái từ true về false
	 * @param mahh
	 * @return
	 */
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
		// TODO Auto-generated method stub
		return null;
	}
	
}
