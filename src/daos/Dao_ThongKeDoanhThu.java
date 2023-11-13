package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDataBase;
import modelsThongKe.DuLieuBieuDoThongKeDoanhThu;

public class Dao_ThongKeDoanhThu {
	public Connection connection;

	public Dao_ThongKeDoanhThu() {
		connection = ConnectDataBase.getInstance().connection;
	}

	public int TongHoaDonTrongNgay(LocalDate ngayThongKe) {
		int totalOrders = 0;
		String query = "SELECT COUNT(*) AS TotalOrders " + "FROM HoaDon " + "WHERE CONVERT(DATE, thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setDate(1, Date.valueOf(ngayThongKe));
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalOrders = resultSet.getInt("TotalOrders");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalOrders;
	}

	public int TongHoaDonDocNhanVienLapTrongNgay(LocalDate ngayThongKe, String maNhanVien) {
		int totalOrders = 0;
		String query = "SELECT COUNT(*) AS TotalOrders " + "FROM HoaDon "
				+ "WHERE CONVERT(DATE, thoiGianTao) = ? AND maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			Date sqlDate = Date.valueOf(ngayThongKe);
			preparedStatement.setDate(1, sqlDate);
			preparedStatement.setString(2, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalOrders = resultSet.getInt("TotalOrders");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalOrders;
	}

	public int TongHoaDonTrongThang(int thangThongKe, int namCuaThangThongKe) {
		int totalOrders = 0;
		String query = "SELECT COUNT(*) AS TotalOrders " + "FROM HoaDon "
				+ "WHERE MONTH(thoiGianTao) = ? AND YEAR(thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, thangThongKe);
			preparedStatement.setInt(2, namCuaThangThongKe);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalOrders = resultSet.getInt("TotalOrders");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalOrders;
	}

	public int TongHoaDonDuocNhanVienLapTrongThang(int thangThongKe, int namCuaThangThongKe, String maNhanVien) {
		int totalOrders = 0;
		String query = "SELECT COUNT(*) AS TotalOrders " + "FROM HoaDon "
				+ "WHERE MONTH(thoiGianTao) = ? AND YEAR(thoiGianTao) = ? AND maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, thangThongKe);
			preparedStatement.setInt(2, namCuaThangThongKe);
			preparedStatement.setString(3, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalOrders = resultSet.getInt("TotalOrders");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalOrders;
	}

	public int TongHoaDonDuocLapTrongNam(int namThongKe) {
		int totalOrders = 0;
		String query = "SELECT COUNT(*) AS TotalOrders " + "FROM HoaDon " + "WHERE YEAR(thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, namThongKe);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalOrders = resultSet.getInt("TotalOrders");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalOrders;
	}

	public int TongHoaDonDuocNhanVienLapTrongNam(int namThongKe, String maNhanVien) {
		int totalOrders = 0;
		String query = "SELECT COUNT(*) AS TotalOrders " + "FROM HoaDon "
				+ "WHERE YEAR(thoiGianTao) = ? AND maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, namThongKe);
			preparedStatement.setString(2, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalOrders = resultSet.getInt("TotalOrders");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalOrders;
	}

	// <==============pass testing================>

	public int TongSoLuongMatHangBanRaTrongNgay(LocalDate ngayThongKe) {
		int totalItemsSold = 0;
		String query = "SELECT SUM(soLuong) AS TotalItemsSold " + "FROM ChiTietHoaDon "
				+ "JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon "
				+ "WHERE CONVERT(DATE, HoaDon.thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setDate(1, java.sql.Date.valueOf(ngayThongKe));
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalItemsSold = resultSet.getInt("TotalItemsSold");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalItemsSold;
	}

	public int TongSoLuongMatHangNhanVienBanRaTrongNgay(LocalDate ngayThongKe, String maNhanVien) {
		int totalItemsSold = 0;
		String query = "SELECT SUM(soLuong) AS TotalItemsSold " + "FROM ChiTietHoaDon "
				+ "JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon "
				+ "WHERE CONVERT(DATE, HoaDon.thoiGianTao) = ? AND HoaDon.maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setDate(1, java.sql.Date.valueOf(ngayThongKe));
			preparedStatement.setString(2, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalItemsSold = resultSet.getInt("TotalItemsSold");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalItemsSold;
	}

	public int TongSoLuongMatHangBanRaTrongThang(int thangDuocThongKe, int namCuaThangDuocThongKe) {
		int totalItemsSold = 0;
		String query = "SELECT SUM(soLuong) AS TotalItemsSold " + "FROM ChiTietHoaDon "
				+ "JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon "
				+ "WHERE MONTH(HoaDon.thoiGianTao) = ? AND YEAR(HoaDon.thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, thangDuocThongKe);
			preparedStatement.setInt(2, namCuaThangDuocThongKe);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalItemsSold = resultSet.getInt("TotalItemsSold");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalItemsSold;
	}

	public int TongSoLuongMatHangNhanVienBanRaTrongThang(int thangDuocThongKe, int namCuaThangDuocThongKe,
			String maNhanVien) {
		int totalItemsSold = 0;
		String query = "SELECT SUM(soLuong) AS TotalItemsSold " + "FROM ChiTietHoaDon "
				+ "JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon "
				+ "WHERE MONTH(HoaDon.thoiGianTao) = ? AND YEAR(HoaDon.thoiGianTao) = ? AND HoaDon.maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, thangDuocThongKe);
			preparedStatement.setInt(2, namCuaThangDuocThongKe);
			preparedStatement.setString(3, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalItemsSold = resultSet.getInt("TotalItemsSold");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalItemsSold;
	}

	public int TongSoLuongMatHangBanRaTrongNam(int namThongKe) {
		int totalItemsSold = 0;
		String query = "SELECT SUM(soLuong) AS TotalItemsSold " + "FROM ChiTietHoaDon "
				+ "JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon " + "WHERE YEAR(HoaDon.thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, namThongKe);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalItemsSold = resultSet.getInt("TotalItemsSold");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalItemsSold;
	}

	public int TongSoLuongMatHangNhanVienBanRaTrongNam(int namThongKe, String maNhanVien) {
		int totalItemsSold = 0;
		String query = "SELECT SUM(soLuong) AS TotalItemsSold " + "FROM ChiTietHoaDon "
				+ "JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon "
				+ "WHERE YEAR(HoaDon.thoiGianTao) = ? AND HoaDon.maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, namThongKe);
			preparedStatement.setString(2, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalItemsSold = resultSet.getInt("TotalItemsSold");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalItemsSold;
	}

	// <===========pass testing 2===========>

	public float TongDoanhThuTrongNgay(LocalDate ngayThongKe) {
		float totalRevenue = 0;
		String query = "SELECT SUM(tongThanhTien) AS TotalRevenue " + "FROM HoaDon "
				+ "WHERE CONVERT(DATE, thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			Date sqlDate = Date.valueOf(ngayThongKe);
			preparedStatement.setDate(1, sqlDate);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalRevenue = resultSet.getFloat("TotalRevenue");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalRevenue;
	}

	public float TongDoanhThuTrongNgayCuaNhanVien(LocalDate ngayThongKe, String maNhanVien) {
		float totalRevenue = 0;
		String query = "SELECT SUM(tongThanhTien) AS TotalRevenue " + "FROM HoaDon "
				+ "WHERE CONVERT(DATE, thoiGianTao) = ? AND maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			Date sqlDate = Date.valueOf(ngayThongKe);
			preparedStatement.setDate(1, sqlDate);
			preparedStatement.setString(2, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalRevenue = resultSet.getFloat("TotalRevenue");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalRevenue;
	}

	public float TongDoanhThuTrongThang(int thangThongKe, int namCuaThangThongKe) {
		float totalRevenue = 0;
		String query = "SELECT SUM(tongThanhTien) AS TotalRevenue " + "FROM HoaDon "
				+ "WHERE MONTH(thoiGianTao) = ? AND YEAR(thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, thangThongKe);
			preparedStatement.setInt(2, namCuaThangThongKe);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalRevenue = resultSet.getFloat("TotalRevenue");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalRevenue;
	}

	public float TongDoanhThuTrongThangCuaNhanVien(int thangThongKe, int namCuaThangThongKe, String maNhanVien) {
		float totalRevenue = 0;
		String query = "SELECT SUM(tongThanhTien) AS TotalRevenue " + "FROM HoaDon "
				+ "WHERE MONTH(thoiGianTao) = ? AND YEAR(thoiGianTao) = ? AND maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, thangThongKe);
			preparedStatement.setInt(2, namCuaThangThongKe);
			preparedStatement.setString(3, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalRevenue = resultSet.getFloat("TotalRevenue");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalRevenue;
	}

	public float TongDoanhThuTrongNam(int namThongKe) {
		float totalRevenue = 0;
		String query = "SELECT SUM(tongThanhTien) AS TotalRevenue " + "FROM HoaDon " + "WHERE YEAR(thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, namThongKe);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalRevenue = resultSet.getFloat("TotalRevenue");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalRevenue;
	}

	public float TongDoanhThuTrongNamCuaNhanVien(int namThongKe, String maNhanVien) {
		float totalRevenue = 0;
		String query = "SELECT SUM(tongThanhTien) AS TotalRevenue " + "FROM HoaDon "
				+ "WHERE YEAR(thoiGianTao) = ? AND maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, namThongKe);
			preparedStatement.setString(2, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalRevenue = resultSet.getFloat("TotalRevenue");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalRevenue;
	}

	// <============pass testing 3================>
	public float TongVonNhapHangTrongNgay(LocalDate ngayThongKe) {
		float totalCostPrice = 0;
		String query = "SELECT SUM(hh.donGiaNhap * cthd.soLuong) AS TotalCostPrice " + "FROM ChiTietHoaDon cthd "
				+ "JOIN HangHoa hh ON cthd.maHangHoa = hh.maHangHoa " + "JOIN HoaDon hd ON cthd.maHoaDon = hd.maHoaDon "
				+ "WHERE CONVERT(DATE, hd.thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			Date sqlDate = Date.valueOf(ngayThongKe);
			preparedStatement.setDate(1, sqlDate);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalCostPrice = resultSet.getFloat("TotalCostPrice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCostPrice;
	}

	public float TongVonNhapHangTrongNgayNhanVienBan(LocalDate ngayThongKe, String maNhanVien) {
		float totalCostPrice = 0;
		String query = "SELECT SUM(hh.donGiaNhap * cthd.soLuong) AS TotalCostPrice " + "FROM ChiTietHoaDon cthd "
				+ "JOIN HangHoa hh ON cthd.maHangHoa = hh.maHangHoa " + "JOIN HoaDon hd ON cthd.maHoaDon = hd.maHoaDon "
				+ "WHERE CONVERT(DATE, hd.thoiGianTao) = ? AND hd.maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			Date sqlDate = Date.valueOf(ngayThongKe);
			preparedStatement.setDate(1, sqlDate);
			preparedStatement.setString(2, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalCostPrice = resultSet.getFloat("TotalCostPrice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCostPrice;
	}

	public float TongVonNhapHangTrongThang(int thangThongKe, int namCuaThangThongKe) {
		float totalCostPrice = 0;
		String query = "SELECT SUM(hh.donGiaNhap * cthd.soLuong) AS TotalCostPrice " + "FROM ChiTietHoaDon cthd "
				+ "JOIN HangHoa hh ON cthd.maHangHoa = hh.maHangHoa " + "JOIN HoaDon hd ON cthd.maHoaDon = hd.maHoaDon "
				+ "WHERE MONTH(hd.thoiGianTao) = ? AND YEAR(hd.thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, thangThongKe);
			preparedStatement.setInt(2, namCuaThangThongKe);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalCostPrice = resultSet.getFloat("TotalCostPrice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCostPrice;
	}

	public float TongVonNhapHangTrongThangNhanVienBan(int thangThongKe, int namCuaThangThongKe, String maNhanVien) {
		float totalCostPrice = 0;
		String query = "SELECT SUM(hh.donGiaNhap * cthd.soLuong) AS TotalCostPrice " + "FROM ChiTietHoaDon cthd "
				+ "JOIN HangHoa hh ON cthd.maHangHoa = hh.maHangHoa " + "JOIN HoaDon hd ON cthd.maHoaDon = hd.maHoaDon "
				+ "WHERE MONTH(hd.thoiGianTao) = ? AND YEAR(hd.thoiGianTao) = ? AND hd.maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, thangThongKe);
			preparedStatement.setInt(2, namCuaThangThongKe);
			preparedStatement.setString(3, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalCostPrice = resultSet.getFloat("TotalCostPrice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCostPrice;
	}

	public float TongVonNhapHangTrongNam(int namThongKe) {
		float totalCostPrice = 0;
		String query = "SELECT SUM(hh.donGiaNhap * cthd.soLuong) AS TotalCostPrice " + "FROM ChiTietHoaDon cthd "
				+ "JOIN HangHoa hh ON cthd.maHangHoa = hh.maHangHoa " + "JOIN HoaDon hd ON cthd.maHoaDon = hd.maHoaDon "
				+ "WHERE YEAR(hd.thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, namThongKe);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalCostPrice = resultSet.getFloat("TotalCostPrice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCostPrice;
	}

	public float TongVonNhapHangTrongNamNhanVienBan(int namThongKe, String maNhanVien) {
		float totalCostPrice = 0;
		String query = "SELECT SUM(hh.donGiaNhap * cthd.soLuong) AS TotalCostPrice " + "FROM ChiTietHoaDon cthd "
				+ "JOIN HangHoa hh ON cthd.maHangHoa = hh.maHangHoa " + "JOIN HoaDon hd ON cthd.maHoaDon = hd.maHoaDon "
				+ "WHERE YEAR(hd.thoiGianTao) = ? AND hd.maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, namThongKe);
			preparedStatement.setString(2, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalCostPrice = resultSet.getFloat("TotalCostPrice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCostPrice;
	}

	// <===========pass testing 04=================>

	public float TongTienGiamGiaTrongNgay(LocalDate ngayThongKe) {
		float totalDiscountAmount = 0;
		String query = "SELECT SUM(hd.tongThanhTien * vg.phanTramGiamTheoHoaDon / 100) AS TotalDiscountAmount "
				+ "FROM HoaDon hd " + "LEFT JOIN VoucherGiamGia vg ON hd.maVoucher = vg.maVoucher "
				+ "WHERE CONVERT(DATE, hd.thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setDate(1, java.sql.Date.valueOf(ngayThongKe));
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalDiscountAmount = resultSet.getFloat("TotalDiscountAmount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalDiscountAmount;
	}

	public float TongTienGiamGiaTrongNgayTheoNhanVien(LocalDate ngayThongKe, String maNhanVien) {
		float totalDiscountAmount = 0;
		String query = "SELECT SUM(hd.tongThanhTien * vg.phanTramGiamTheoHoaDon / 100) AS TotalDiscountAmount "
				+ "FROM HoaDon hd " + "LEFT JOIN VoucherGiamGia vg ON hd.maVoucher = vg.maVoucher "
				+ "WHERE CONVERT(DATE, hd.thoiGianTao) = ? AND hd.maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setDate(1, java.sql.Date.valueOf(ngayThongKe));
			preparedStatement.setString(2, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalDiscountAmount = resultSet.getFloat("TotalDiscountAmount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalDiscountAmount;
	}

	public float TongTienGiamGiaTrongThang(int thangThongKe, int namCuaThangThongKe) {
		float totalDiscountAmount = 0;
		String query = "SELECT SUM(hd.tongThanhTien * vg.phanTramGiamTheoHoaDon / 100) AS TotalDiscountAmount "
				+ "FROM HoaDon hd " + "LEFT JOIN VoucherGiamGia vg ON hd.maVoucher = vg.maVoucher "
				+ "WHERE MONTH(hd.thoiGianTao) = ? AND YEAR(hd.thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, thangThongKe);
			preparedStatement.setInt(2, namCuaThangThongKe);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalDiscountAmount = resultSet.getFloat("TotalDiscountAmount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalDiscountAmount;
	}

	public float TongTienGiamGiaTrongThangTheoNhanVien(int thangThongKe, int namCuaThangThongKe, String maNhanVien) {
		float totalDiscountAmount = 0;
		String query = "SELECT SUM(hd.tongThanhTien * vg.phanTramGiamTheoHoaDon / 100) AS TotalDiscountAmount "
				+ "FROM HoaDon hd " + "LEFT JOIN VoucherGiamGia vg ON hd.maVoucher = vg.maVoucher "
				+ "WHERE MONTH(hd.thoiGianTao) = ? AND YEAR(hd.thoiGianTao) = ? AND hd.maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, thangThongKe);
			preparedStatement.setInt(2, namCuaThangThongKe);
			preparedStatement.setString(3, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalDiscountAmount = resultSet.getFloat("TotalDiscountAmount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalDiscountAmount;
	}

	public float TongTienGiamGiaTrongNam(int namThongKe) {
		float totalDiscountAmount = 0;
		String query = "SELECT SUM(hd.tongThanhTien * vg.phanTramGiamTheoHoaDon / 100) AS TotalDiscountAmount "
				+ "FROM HoaDon hd " + "LEFT JOIN VoucherGiamGia vg ON hd.maVoucher = vg.maVoucher "
				+ "WHERE YEAR(hd.thoiGianTao) = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, namThongKe);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalDiscountAmount = resultSet.getFloat("TotalDiscountAmount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalDiscountAmount;
	}

	public float TongTienGiamGiaTrongNamTheoNhanVien(int namThongKe, String maNhanVien) {
		float totalDiscountAmount = 0;
		String query = "SELECT SUM(hd.tongThanhTien * vg.phanTramGiamTheoHoaDon / 100) AS TotalDiscountAmount "
				+ "FROM HoaDon hd " + "LEFT JOIN VoucherGiamGia vg ON hd.maVoucher = vg.maVoucher "
				+ "WHERE YEAR(hd.thoiGianTao) = ? AND hd.maNhanVien = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, namThongKe);
			preparedStatement.setString(2, maNhanVien);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalDiscountAmount = resultSet.getFloat("TotalDiscountAmount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalDiscountAmount;
	}

	public ArrayList<DuLieuBieuDoThongKeDoanhThu> duLieuBieuDo_Top5NgayDoanhThuCaoNhatTrongThang(int thangThongKe,
			int namCuaThangThongKe, String maNhanVien) {
		ArrayList<DuLieuBieuDoThongKeDoanhThu> danhSachDuLieu = new ArrayList<>();

		String query = "SELECT CONVERT(varchar, thoiGianTao, 23) AS ngay, SUM(tongThanhTien) AS tongDoanhThu "
				+ "FROM HoaDon " + "WHERE MONTH(thoiGianTao) = ? AND YEAR(thoiGianTao) = ? AND maNhanVien = ? "
				+ "GROUP BY CONVERT(varchar, thoiGianTao, 23) " + "ORDER BY tongDoanhThu DESC "
				+ "OFFSET 0 ROWS FETCH NEXT 5 ROWS ONLY";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, thangThongKe);
			preparedStatement.setInt(2, namCuaThangThongKe);
			preparedStatement.setString(3, maNhanVien);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					String ngay = resultSet.getString(1);
					float tongDoanhThu = resultSet.getFloat(2);

					DuLieuBieuDoThongKeDoanhThu duLieu = new DuLieuBieuDoThongKeDoanhThu(ngay, tongDoanhThu);
					danhSachDuLieu.add(duLieu);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return danhSachDuLieu;
	}

	public ArrayList<DuLieuBieuDoThongKeDoanhThu> duLieuBieuDo_DoanhThuCacNgaTrongThang(int thangThongKe,
			int namCuaThangThongKe, String maNhanVien) {
		ArrayList<DuLieuBieuDoThongKeDoanhThu> danhSachDoanhThu = new ArrayList<>();

		String query = "SELECT CONVERT(varchar, thoiGianTao, 23) AS ngay, SUM(tongThanhTien) AS tongDoanhThu "
				+ "FROM HoaDon " + "WHERE MONTH(thoiGianTao) = ? AND YEAR(thoiGianTao) = ? AND maNhanVien = ? "
				+ "GROUP BY CONVERT(varchar, thoiGianTao, 23)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, thangThongKe);
			preparedStatement.setInt(2, namCuaThangThongKe);
			preparedStatement.setString(3, maNhanVien);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					String ngay = resultSet.getString("ngay");
					float tongDoanhThu = resultSet.getFloat("tongDoanhThu");

					DuLieuBieuDoThongKeDoanhThu duLieu = new DuLieuBieuDoThongKeDoanhThu(ngay, tongDoanhThu);
					danhSachDoanhThu.add(duLieu);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return danhSachDoanhThu;
	}

	public ArrayList<DuLieuBieuDoThongKeDoanhThu> duLieuBieuDo_DoanhThuCacThangTrongNam(int namThongKe, String maNhanVien) {
		ArrayList<DuLieuBieuDoThongKeDoanhThu> danhSachDoanhThu = new ArrayList<>();

		String query = "SELECT FORMAT(thoiGianTao, 'MM') AS thang, SUM(tongThanhTien) AS tongDoanhThu " + "FROM HoaDon "
				+ "WHERE YEAR(thoiGianTao) = ? AND maNhanVien = ? " + "GROUP BY FORMAT(thoiGianTao, 'MM')";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, namThongKe);
			preparedStatement.setString(2, maNhanVien);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					String thang = "Tháng "+resultSet.getString("thang")+"/"+namThongKe;
					float tongDoanhThu = resultSet.getFloat("tongDoanhThu");

					DuLieuBieuDoThongKeDoanhThu duLieu = new DuLieuBieuDoThongKeDoanhThu(thang, tongDoanhThu);
					danhSachDoanhThu.add(duLieu);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return danhSachDoanhThu;
	}

	public ArrayList<DuLieuBieuDoThongKeDoanhThu> getTop5ThangDoanhThuCaoNhatTrongNam(int namThongKe) {
		ArrayList<DuLieuBieuDoThongKeDoanhThu> result = new ArrayList<>();

		String query = "SELECT CONVERT(varchar, thoiGianTao, 23) AS ngay, SUM(tongThanhTien) AS doanhThu "
				+ "FROM HoaDon " + "WHERE YEAR(thoiGianTao) = ? " + "GROUP BY CONVERT(varchar, thoiGianTao, 23) "
				+ "ORDER BY doanhThu DESC " + "LIMIT 5";

		try (Connection connection = ConnectDataBase.getInstance().connection;
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, namThongKe);

			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					String ngay = resultSet.getString("ngay");
					float doanhThu = resultSet.getFloat("doanhThu");
					result.add(new DuLieuBieuDoThongKeDoanhThu(ngay, doanhThu));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<DuLieuBieuDoThongKeDoanhThu> Top5ThangDoanhThuCaoNhatTrongNam(int namThongKe) {
		ArrayList<DuLieuBieuDoThongKeDoanhThu> result = new ArrayList<>();

		String query = "SELECT TOP 5 MONTH(thoiGianTao) AS thang, SUM(tongThanhTien) AS doanhThu " + "FROM HoaDon "
				+ "WHERE YEAR(thoiGianTao) = ? " + "GROUP BY MONTH(thoiGianTao) " + "ORDER BY doanhThu DESC";

		try (Connection connection = ConnectDataBase.getInstance().connection;
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, namThongKe);

			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					String thang = resultSet.getString(1) + " năm " + namThongKe;
					float doanhThu = resultSet.getFloat(2);
					result.add(new DuLieuBieuDoThongKeDoanhThu(thang, doanhThu));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<String> layCacNamCoHoaDon() {
		ArrayList<String> distinctYears = new ArrayList<>();
		String query = "SELECT DISTINCT YEAR(thoiGianLap) AS nam FROM HoaDon";

		try (Connection connection = ConnectDataBase.getInstance().connection;
				PreparedStatement statement = connection.prepareStatement(query)) {
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					String year = resultSet.getString("nam");
					distinctYears.add(year);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return distinctYears;
	}
}
