package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

import connection.ConnectDataBase;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import entities.VoucherGiamGia;

public class Dao_FindTables {
	public Connection connection;

	public Dao_FindTables() {
		connection = ConnectDataBase.getInstance().connection;
	}
	public NhanVien TimKiemNhanVienTheoMa(String employeeCode) {
        NhanVien employee = null;
        String query = "SELECT * FROM NhanVien WHERE maNhanVien = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, employeeCode);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String maNhanVien = resultSet.getString(1).trim();
                String hoTen = resultSet.getString(2);
            	Date ngaySinh = resultSet.getDate(3);
            	String soCCCD = resultSet.getString(4);
            	String soDienThoai = resultSet.getString(5);
            	String email = resultSet.getString(6);
            	String diaChi = resultSet.getString(7);
            	String chucVu = resultSet.getString(8);
            	boolean trangThai = resultSet.getBoolean(9);
            	String matKhau = resultSet.getString(10);
            	boolean phanQuyen = resultSet.getBoolean(11);
            	String anhDaiDien = resultSet.getString(12);
                employee = new NhanVien(maNhanVien, hoTen, ngaySinh, soCCCD, soDienThoai, email, diaChi, chucVu, trangThai, matKhau, phanQuyen, anhDaiDien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }
	public KhachHang timKiemKhachHangTheoMa(String maKH) {
        KhachHang khachHang = null;
        String query = "SELECT * FROM KhachHang WHERE maKhachHang = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, maKH);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String maKhachHang = resultSet.getString(1);
                String soDienThoai = resultSet.getString(2);
                String tenKhachHang = resultSet.getString(3);
        		String email = resultSet.getString(4);
        		String diaChi = resultSet.getString(5);
        		boolean trangThai = resultSet.getBoolean(6);
        		float diemTichLuy = resultSet.getFloat(7);
        		khachHang = new KhachHang(maKhachHang, soDienThoai, tenKhachHang, email, diaChi, trangThai, diemTichLuy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return khachHang;
    }
	public VoucherGiamGia timKiemVoucherTheoMa(String maVoucher) {
		VoucherGiamGia voucherGiamGia = null;
        String query = "SELECT * FROM VoucherGiamGia WHERE maVoucher = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, maVoucher);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
            	String ma = resultSet.getString(1);
        		String tenVoucher = resultSet.getString(2);
        		String moTaChuongTrinh = resultSet.getString(3);
        		float phanTramGiamTheoHoaDon = resultSet.getFloat(4);
        		Date ngayBatDau = resultSet.getDate(5);
        		Date ngayKetThuc = resultSet.getDate(6);
        		boolean trangThai = resultSet.getBoolean(7);
        		int soLuotSuDung = resultSet.getInt(8);
                voucherGiamGia = new VoucherGiamGia(ma, tenVoucher, moTaChuongTrinh, phanTramGiamTheoHoaDon , ngayBatDau, ngayKetThuc, trangThai, soLuotSuDung);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voucherGiamGia;
	}
	public HoaDon timKiemHoaDonTheoMa(String ma) {
		HoaDon hoaDon = null;
        String query = "SELECT * FROM HoaDon WHERE maHoaDon = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, ma);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
            	String maHoaDon = resultSet.getString(1);
        		Date thoiGianTao = resultSet.getDate(2);
        		float tongThanhTien = resultSet.getFloat(3);
        		String maVoucher = resultSet.getString(4);
        		VoucherGiamGia voucherGiamGia = timKiemVoucherTheoMa(maVoucher);
        		String maKh = resultSet.getString(5);
        		KhachHang kh = timKiemKhachHangTheoMa(maKh);
        		String maNv = resultSet.getString(6);
        		NhanVien nv = TimKiemNhanVienTheoMa(maNv.trim());
        		boolean trangThaiThanhToan = resultSet.getBoolean(7);
        		hoaDon = new HoaDon(maHoaDon, thoiGianTao, tongThanhTien, voucherGiamGia, kh, nv, trangThaiThanhToan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDon;
	}
}
