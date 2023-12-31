package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDataBase;
import entities.KhachHang;
import entities.NhanVien;

public class Dao_NhanVien {
	public Connection connection;
	PreparedStatement preStm;
	ResultSet rs;

	public Dao_NhanVien() {
		connection = ConnectDataBase.getInstance().connection;
	}
	
	public List<NhanVien> getAllNhanVien() throws Exception {
		List<NhanVien> result = null;
		NhanVien dto;
		try {
			String sql = "select * from NhanVien";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				String maNV =rs.getString("maNhanVien");
				String ten = rs.getString("hoTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String soCCCD = rs.getString("soCCCD");
				String soDT = rs.getString("soDienThoai");
				String email = rs.getString("email");
				String diaChi = rs.getString("diaChi");
				String chucVu = rs.getString("chucVu");
				String matKhau = rs.getString("matKhau");
				Boolean phanquyen = rs.getBoolean("phanQuyen");
				Boolean trangThai = rs.getBoolean("trangThai");
				String anh = rs.getString("hinhAnh");
				dto = new NhanVien(maNV, ten, ngaySinh, soCCCD, soDT, email, diaChi, chucVu, trangThai, matKhau, phanquyen, anh);
				result.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public NhanVien getNhanVienTheoMa(String maNhanVien){
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
	
	public boolean themNhanVien(NhanVien nv) {
		int n = 0;
		try {
			connection = ConnectDataBase.getInstance().connection;
			String sql = "insert into NhanVien values(?,?,?,?,?,?,?,?,?,?,?,?)";
			preStm = connection.prepareStatement(sql);
			preStm.setString(1, nv.getMaNhanVien());
			preStm.setString(2, nv.getHoTen());
			preStm.setDate(3, (nv.getNgaySinh()));
			preStm.setString(4, nv.getSoCCCD());
			preStm.setString(5, nv.getSoDienThoai());
			preStm.setString(6, nv.getEmail());
			preStm.setString(7, nv.getDiaChi());
			preStm.setString(8, nv.getChucVu());
			preStm.setBoolean(9, nv.isTrangThai());
			preStm.setString(10, nv.getMatKhau());
			preStm.setBoolean(11, nv.isPhanQuyen());
			preStm.setString(12, nv.getAnhDaiDien());
			n = preStm.executeUpdate();
		} catch (Exception e) {
		}
		return n > 0;
	}
	public boolean updateNhanVien(NhanVien nhanVien) {
	    try {
	        String updateQuery = "UPDATE NhanVien "
	                + "SET soDienThoai = ?, ngaySinh = ?, hoTen = ?, email = ?, diaChi = ?, trangThai = ?, soCCCD = ? "
	                + "WHERE maNhanVien = ?";

	        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	            preparedStatement.setString(1, nhanVien.getSoDienThoai());
	            preparedStatement.setDate(2, nhanVien.getNgaySinh());
	            preparedStatement.setString(3, nhanVien.getHoTen());
	            preparedStatement.setString(4, nhanVien.getEmail());
	            preparedStatement.setString(5, nhanVien.getDiaChi());
	            preparedStatement.setBoolean(6, nhanVien.isTrangThai());
	            preparedStatement.setString(7, nhanVien.getSoCCCD());
	            preparedStatement.setString(8, nhanVien.getMaNhanVien());

	            int n = preparedStatement.executeUpdate();
	            return n > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Xử lý hoặc ghi log lỗi ở đây.
	    }
	    return false;
	}
}