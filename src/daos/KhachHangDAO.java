package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
				int maKH = rs.getInt("MaKhachHang");
				String ten = rs.getString("Ten");
				String ho = rs.getString("Ho");
				Date ngaySinh = rs.getDate("NgaySinh");
				String gioiTinh = rs.getString("GioiTinh");
				String cmnd = rs.getString("CMND");
				String soDT = rs.getString("SoDienThoai");
				int maDiaChi = rs.getInt("MaDiaChi");
//				DiaChi diaChi = new DiaChi();
//				diaChi.setMaDiaChi(maDiaChi);
//				dto = new KhachHang(soDT, ten, cmnd, soDT, false)
//				result.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
