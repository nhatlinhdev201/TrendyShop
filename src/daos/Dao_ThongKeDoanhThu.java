package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connection.ConnectDataBase;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import entities.VoucherGiamGia;

public class Dao_ThongKeDoanhThu {
	public Connection connection;

	public Dao_ThongKeDoanhThu() {
		connection = ConnectDataBase.getInstance().connection;
	}

	public ArrayList<NhanVien> layDanhSachNhanVienBanHang() {
		ArrayList<NhanVien> employees = new ArrayList<>();

		try {
			String sql = "SELECT * FROM NhanVien nv where nv.phanQuyen=0";
			try (Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(sql)) {
				while (resultSet.next()) {
					NhanVien employee = new NhanVien();
					employee.setMaNhanVien(resultSet.getString("maNhanVien"));
					employee.setHoTen(resultSet.getString("hoTen"));
					employee.setNgaySinh(resultSet.getDate("ngaySinh"));
					employee.setSoCCCD(resultSet.getString("soCCCD"));
					employee.setSoDienThoai(resultSet.getString("soDienThoai"));
					employee.setEmail(resultSet.getString("email"));
					employee.setDiaChi(resultSet.getString("diaChi"));
					employee.setChucVu(resultSet.getString("chucVu"));
					employee.setTrangThai(resultSet.getBoolean("trangThai"));
					employee.setMatKhau(resultSet.getString("matKhau"));
					employee.setPhanQuyen(resultSet.getBoolean("phanQuyen"));
					employee.setAnhDaiDien(resultSet.getString("hinhAnh"));

					employees.add(employee);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
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

	public double TongDoanhThuTrongNgayCuaNhanVien(LocalDate ngayThongKe, String maNhanVien) {
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

	public double TongDoanhThuTrongThangCuaNhanVien(int thangThongKe, int namCuaThangThongKe, String maNhanVien) {
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

	public double TongDoanhThuTrongNamCuaNhanVien(int namThongKe, String maNhanVien) {
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

	public double TongVonNhapHangTrongNgayNhanVienBan(LocalDate ngayThongKe, String maNhanVien) {
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

	public double TongVonNhapHangTrongThangNhanVienBan(int thangThongKe, int namCuaThangThongKe, String maNhanVien) {
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

	public double TongVonNhapHangTrongNamNhanVienBan(int namThongKe, String maNhanVien) {
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

	public double TongTienGiamGiaTrongNgayTheoNhanVien(LocalDate ngayThongKe, String maNhanVien) {
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

	public double TongTienGiamGiaTrongThangTheoNhanVien(int thangThongKe, int namCuaThangThongKe, String maNhanVien) {
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

	public double TongTienGiamGiaTrongNamTheoNhanVien(int namThongKe, String maNhanVien) {
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

	public ArrayList<HoaDon> getHoaDonTheoNhanVienVaNgay(String maNhanVien, LocalDate thoiGianTao) {
        ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();

        try {
            String sql = "SELECT * FROM HoaDon " +
                         "WHERE maNhanVien = ? AND CAST(thoiGianTao AS DATE) = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, maNhanVien);
                statement.setDate(2, Date.valueOf(thoiGianTao));

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                    	HoaDon hoaDon = new HoaDon();
        				hoaDon.setMaHoaDon(resultSet.getString("maHoaDon").trim());
        				hoaDon.setThoiGianTao(resultSet.getDate("thoiGianTao").toLocalDate());
        				hoaDon.setTongThanhTien(resultSet.getDouble("tongThanhTien"));
        				hoaDon.setVoucher(new VoucherGiamGia(resultSet.getString("maVoucher").trim()));
        				hoaDon.setKhachHang(new KhachHang(resultSet.getString("maKhachHang").trim()));
        				hoaDon.setNguoiLapHoaDon(new NhanVien(resultSet.getString("maNhanVien").trim()));
        				hoaDon.setTrangThaiThanhToan(resultSet.getBoolean("trangThaiThanhToan"));
                        danhSachHoaDon.add(hoaDon);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachHoaDon;
    }
}
