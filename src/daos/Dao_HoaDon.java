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

public class Dao_HoaDon {
	public Connection connection;

	public Dao_HoaDon() {
		connection = ConnectDataBase.getInstance().connection;
	}

	public boolean insertHoaDon(HoaDon hoaDon) {
		try {

			String insertQuery = "INSERT INTO HoaDon (maHoaDon, thoiGianTao,tongThanhTien, maVoucher,maKhachHang,maNhanVien,  trangThaiThanhToan) "
					+ "VALUES (?, ?, ?, ?, ?, ?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

			preparedStatement.setString(1, hoaDon.getMaHoaDon());
			preparedStatement.setDate(2, Date.valueOf(hoaDon.getThoiGianTao()));
			preparedStatement.setLong(3,(long)  hoaDon.getTongThanhTien());
			preparedStatement.setString(4, hoaDon.getVoucher().getMaVoucher());
			preparedStatement.setString(5, hoaDon.getKhachHang().getMaKhachHang());
			preparedStatement.setString(6, hoaDon.getNguoiLapHoaDon().getMaNhanVien());
			preparedStatement.setBoolean(7, hoaDon.isTrangThaiThanhToan());

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

	public List<HoaDon> getAll() {
		List<HoaDon> dsHoaDon = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from HoaDon");
			ResultSet resultSet = statement.executeQuery();
			dsHoaDon = new ArrayList<HoaDon>();
			while (resultSet.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(resultSet.getString("maHoaDon").trim());
				hoaDon.setThoiGianTao(resultSet.getDate("thoiGianTao").toLocalDate());
				hoaDon.setTongThanhTien(resultSet.getDouble("tongThanhTien"));
				hoaDon.setVoucher(new VoucherGiamGia(resultSet.getString("maVoucher").trim()));
				hoaDon.setKhachHang(new KhachHang(resultSet.getString("maKhachHang").trim()));
				hoaDon.setNguoiLapHoaDon(new NhanVien(resultSet.getString("maNhanVien").trim()));
				hoaDon.setTrangThaiThanhToan(resultSet.getBoolean("trangThaiThanhToan"));

				dsHoaDon.add(hoaDon);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoaDon;
	}

	public List<HoaDon> getHoaDonTheoMa(String maHD) {
		List<HoaDon> dsHoaDon = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from HoaDon where maHoaDon = '" + maHD + "'");
			ResultSet resultSet = statement.executeQuery();
			dsHoaDon = new ArrayList<HoaDon>();
			while (resultSet.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(resultSet.getString("maHoaDon").trim());
				hoaDon.setThoiGianTao(resultSet.getDate("thoiGianTao").toLocalDate());
				hoaDon.setTongThanhTien(resultSet.getDouble("tongThanhTien"));
				hoaDon.setVoucher(new VoucherGiamGia(resultSet.getString("maVoucher").trim()));
				hoaDon.setKhachHang(new KhachHang(resultSet.getString("maKhachHang").trim()));
				hoaDon.setNguoiLapHoaDon(new NhanVien(resultSet.getString("maNhanVien").trim()));
				hoaDon.setTrangThaiThanhToan(resultSet.getBoolean("trangThaiThanhToan"));

				dsHoaDon.add(hoaDon);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoaDon;
	}

	public List<HoaDon> getHoaDonTheoMaKhachHang(String maKH) {
		List<HoaDon> dsHoaDon = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from HoaDon where maKhachHang = '" + maKH + "'");
			ResultSet resultSet = statement.executeQuery();
			dsHoaDon = new ArrayList<HoaDon>();
			while (resultSet.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(resultSet.getString("maHoaDon").trim());
				hoaDon.setThoiGianTao(resultSet.getDate("thoiGianTao").toLocalDate());
				hoaDon.setTongThanhTien(resultSet.getDouble("tongThanhTien"));
				hoaDon.setVoucher(new VoucherGiamGia(resultSet.getString("maVoucher").trim()));
				hoaDon.setKhachHang(new KhachHang(resultSet.getString("maKhachHang").trim()));
				hoaDon.setNguoiLapHoaDon(new NhanVien(resultSet.getString("maNhanVien").trim()));
				hoaDon.setTrangThaiThanhToan(resultSet.getBoolean("trangThaiThanhToan"));

				dsHoaDon.add(hoaDon);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoaDon;
	}

	public List<HoaDon> getHoaDonTheoMaNhanVien(String maNhanVien) {
		List<HoaDon> dsHoaDon = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from HoaDon where maNhanVien = '" + maNhanVien + "'");
			ResultSet resultSet = statement.executeQuery();
			dsHoaDon = new ArrayList<HoaDon>();
			while (resultSet.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(resultSet.getString("maHoaDon").trim());
				hoaDon.setThoiGianTao(resultSet.getDate("thoiGianTao").toLocalDate());
				hoaDon.setTongThanhTien(resultSet.getDouble("tongThanhTien"));
				hoaDon.setVoucher(new VoucherGiamGia(resultSet.getString("maVoucher").trim()));
				hoaDon.setKhachHang(new KhachHang(resultSet.getString("maKhachHang").trim()));
				hoaDon.setNguoiLapHoaDon(new NhanVien(resultSet.getString("maNhanVien").trim()));
				hoaDon.setTrangThaiThanhToan(resultSet.getBoolean("trangThaiThanhToan"));

				dsHoaDon.add(hoaDon);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoaDon;
	}

	/**
	 * Quyền Cơ
	 * Lay ra ma hoa don duoc lap gan nhat trong ngay
	 * @param ngay
	 * @return Mã hóa đơn
	 */
	public int getHoaDonDuocLapGanNhatTrongNgay(String ngay) {
		int maHoaDon = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"select top 1 *from HoaDon where thoiGianTao = '" + ngay + "' order by maHoaDon desc");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				maHoaDon = Integer.parseInt(resultSet.getString("maHoaDon").trim().substring(10));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return maHoaDon;
	}

	/**
	 * Quyền Cơ:
	 * Lấy danh sách những hóa đơn chưa được thanh toán (đưa vào hàng chờ)
	 * @return
	 */
	public List<HoaDon> getHoaDonChuaThanhToan() {
		List<HoaDon> dsHoaDon = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select*from HoaDon where trangThaiThanhToan = 0");
			ResultSet resultSet = statement.executeQuery();
			dsHoaDon = new ArrayList<HoaDon>();
			while (resultSet.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(resultSet.getString("maHoaDon").trim());
				hoaDon.setThoiGianTao(resultSet.getDate("thoiGianTao").toLocalDate());
				hoaDon.setTongThanhTien(resultSet.getDouble("tongThanhTien"));
				hoaDon.setVoucher(new VoucherGiamGia(resultSet.getString("maVoucher").trim()));
				hoaDon.setKhachHang(new KhachHang(resultSet.getString("maKhachHang").trim()));
				hoaDon.setNguoiLapHoaDon(new NhanVien(resultSet.getString("maNhanVien").trim()));
				hoaDon.setTrangThaiThanhToan(resultSet.getBoolean("trangThaiThanhToan"));

				dsHoaDon.add(hoaDon);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoaDon;
	}
	
	/**
	 * Quyền Cơ:
	 * Xóa hóa đơn là hàng chờ ra hỏi database
	 * @param mahd
	 * @return
	 */
	public boolean deleteHoaDon(String mahd) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from HoaDon where maHoaDon ='"+mahd+"'");
			int n = preparedStatement.executeUpdate();
			if (n > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
