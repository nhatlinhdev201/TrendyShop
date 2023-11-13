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

public class KhachHangDAO {
	Connection con;
	PreparedStatement preStm;
	ResultSet rs;

	public KhachHangDAO() {
	}
	
	public List<KhachHang> getAllKhachHang() throws Exception {
		List<KhachHang> result = null;
		KhachHang dto;
		try {
			con = ConnectDataBase.getInstance().connection;
			String sql = "select * from KhachHang";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				String maKH =rs.getString("maKhachHang");
				String ten = rs.getString("tenKhachHang");
				String diaChi = rs.getString("diaChi");
				float diemTichLuy = rs.getFloat("diemTichLuy");
				String email = rs.getString("email");
				String soDT = rs.getString("soDienThoai");
				boolean trangThai = rs.getBoolean("trangThai");
				dto = new KhachHang(maKH, soDT, ten, email, diaChi, trangThai, diemTichLuy);
				result.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public KhachHang timkiemKhachHangByMa(String ma) throws SQLException {
	    KhachHang dto = null;

	    try {
	        con = ConnectDataBase.getInstance().connection;
	        String sql = "SELECT * FROM KhachHang WHERE maKhachHang LIKE ?";
	        
	        try (PreparedStatement preStm = con.prepareStatement(sql)) {
	            preStm.setString(1, "%" + ma + "%");
	            
	            try (ResultSet rs = preStm.executeQuery()) {
	                while (rs.next()) {
	                    String maKH = rs.getString("maKhachHang");
	                    String ten = rs.getString("tenKhachHang");
	                    String diaChi = rs.getString("diaChi");
	                    float diemTichLuy = rs.getFloat("diemTichLuy");
	                    String email = rs.getString("email");
	                    String soDT = rs.getString("soDienThoai");
	                    boolean trangThai = rs.getBoolean("trangThai");
	                    dto = new KhachHang(maKH, soDT, ten, email, diaChi, trangThai, diemTichLuy);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e; // Re-throw the exception after logging or handling as needed
	    }

	    return dto;
	}
	
}
