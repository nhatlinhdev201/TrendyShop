package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import connection.ConnectDataBase;
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
        		Boolean trangThai = resultSet.getBoolean(6);
        		float diemTichLuy = resultSet.getFloat(7);
                KhachHang kh = new KhachHang(maKhachHang, soDienThoai, tenKhachHang, email, diaChi, false, diemTichLuy);
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
        		Float phanTramGiamTheoHoaDon = resultSet.getFloat(4);
        		java.util.Date ngayBatDau = resultSet.getDate(5);
        		java.util.Date ngayKetThuc = resultSet.getDate(6);
        		Boolean trangThai = resultSet.getBoolean(7);
        		int soLuotSuDung = resultSet.getInt(8);
                voucherGiamGia = new VoucherGiamGia(ma, tenVoucher, moTaChuongTrinh, phanTramGiamTheoHoaDon , ngayBatDau, ngayKetThuc, trangThai, soLuotSuDung);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voucherGiamGia;
	}
}
