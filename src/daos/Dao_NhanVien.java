package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDataBase;
import entities.KhachHang;
import entities.NhanVien;

public class Dao_NhanVien {
	public Connection connection;

	public Dao_NhanVien() {
		connection = ConnectDataBase.getInstance().connection;
	}
	
	public List<NhanVien> getAllNhanVien() throws Exception {
		List<NhanVien> result = null;
		NhanVien dto;
		try {
			String sql = "select * from KhachHang";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				String maKH =rs.getString("maNhanVien");
				String ten = rs.getString("hoTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String soCCCD = rs.getString("soCCCD");
				String soDT = rs.getString("soDienThoai");
				String email = rs.getString("email");
				String chucVu = rs.getString("matKhau");
				String matKhau = rs.getString("chucVu");		
				Boolean trangThai = rs.getBoolean("phanQuyen");
				String anh = rs.getString("anhDaiDien");
				dto = new NhanVien(anh, ten, ngaySinh, soCCCD, soDT, email, email, chucVu, false, matKhau, false, anh);
				result.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public NhanVien getNhanVienTheoMa(String maNhanVien) {
		NhanVien nv = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select*from NhanVien where maNhanVien = '"+maNhanVien+"'");
			ResultSet resultSet = statement.executeQuery();
			nv = new NhanVien();
			while (resultSet.next()) {
				nv.setMaNhanVien(resultSet.getString("maNhanVien").trim());
				nv.setHoTen(resultSet.getString("hoTen").trim());
				nv.setNgaySinh(resultSet.getDate("ngaySinh"));
				nv.setSoCCCD(resultSet.getString("soCCCD").trim());
				nv.setSoDienThoai(resultSet.getString("soDienThoai").trim());
				nv.setEmail(resultSet.getString("email").trim());
				nv.setDiaChi(resultSet.getString("diaChi").trim());
				nv.setChucVu(resultSet.getString("chucVu").trim());
				nv.setTrangThai(resultSet.getBoolean("trangThai"));
				nv.setMatKhau(resultSet.getString("matKhau").trim());
				nv.setPhanQuyen(resultSet.getBoolean("phanQuyen"));
				nv.setAnhDaiDien(resultSet.getString("hinhAnh"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}
	
	
	
	public String getTenNhanVienTheoMa(String maNhanVien) {
		String tenNhanVien="";
		try {
			PreparedStatement statement = connection.prepareStatement("select hoTen from NhanVien where maNhanVien = '"+maNhanVien+"'");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				tenNhanVien = resultSet.getString("hoTen");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tenNhanVien;
	}
}
