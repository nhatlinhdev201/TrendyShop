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

public class Dao_KhachHang {
	public Connection connection;
	PreparedStatement preStm;
	ResultSet rs;

	public Dao_KhachHang() {
		connection = ConnectDataBase.getInstance().connection;
	}

	public List<KhachHang> getAll() {
		List<KhachHang> dsKhachHang = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select*from KhachHang");
			ResultSet resultSet = statement.executeQuery();
			dsKhachHang = new ArrayList<KhachHang>();
			while (resultSet.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKhachHang(resultSet.getString("maKhachHang").trim());
				kh.setSoDienThoai(resultSet.getString("soDienThoai").trim());
				kh.setTenKhachHang(resultSet.getString("tenKhachHang").trim());
				kh.setEmail(resultSet.getString("email").trim());
				kh.setDiaChi(resultSet.getString("diaChi").trim());
				kh.setTrangThai(resultSet.getBoolean("trangThai"));
				kh.setDiemTichLuy(resultSet.getFloat("diemTichLuy"));

				dsKhachHang.add(kh);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	public KhachHang getKhachHangTheoMa(String maKhachHang) {
		KhachHang kh = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select*from KhachHang where maKhachHang = '" + maKhachHang + "'");
			ResultSet resultSet = statement.executeQuery();
			kh = new KhachHang();
			while (resultSet.next()) {
				kh.setMaKhachHang(resultSet.getString("maKhachHang").trim());
				kh.setSoDienThoai(resultSet.getString("soDienThoai").trim());
				kh.setTenKhachHang(resultSet.getString("tenKhachHang").trim());
				kh.setEmail(resultSet.getString("email").trim());
				kh.setDiaChi(resultSet.getString("diaChi").trim());
				kh.setTrangThai(resultSet.getBoolean("trangThai"));
				kh.setDiemTichLuy(resultSet.getFloat("diemTichLuy"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}
	public KhachHang timkiemKhachHangByMa(String ma) throws SQLException {
	    KhachHang dto = null;

	    try {
	    	connection = ConnectDataBase.getInstance().connection;
	        String sql = "SELECT * FROM KhachHang WHERE maKhachHang LIKE ?";
	        
	        try (PreparedStatement preStm = connection.prepareStatement(sql)) {
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
	
	public KhachHang timkiemKhachHangBySDT(String SDT) throws SQLException {
	    KhachHang dto = null;

	    try {
	    	connection = ConnectDataBase.getInstance().connection;
	        String sql = "SELECT * FROM KhachHang WHERE soDienThoai LIKE ?";
	        
	        try (PreparedStatement preStm = connection.prepareStatement(sql)) {
	            preStm.setString(1, "%" + SDT + "%");
	            
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
	
	public KhachHang timkiemKhachHangBytenKH(String tenkh) throws SQLException {
	    KhachHang dto = null;

	    try {
	    	connection = ConnectDataBase.getInstance().connection;
	        String sql = "SELECT * FROM KhachHang WHERE tenKhachHang LIKE ?";
	        
	        try (PreparedStatement preStm = connection.prepareStatement(sql)) {
	            preStm.setString(1, "%" + tenkh + "%");
	            
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

	public KhachHang getKhachHangTheoSDT(String sdt) {
		KhachHang kh = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select*from KhachHang where soDienThoai = '" + sdt + "'");
			ResultSet resultSet = statement.executeQuery();
			kh = new KhachHang();
			while (resultSet.next()) {
				kh.setMaKhachHang(resultSet.getString("maKhachHang").trim());
				kh.setSoDienThoai(resultSet.getString("soDienThoai").trim());
				kh.setTenKhachHang(resultSet.getString("tenKhachHang").trim());
				kh.setEmail(resultSet.getString("email").trim());
				kh.setDiaChi(resultSet.getString("diaChi").trim());
				kh.setTrangThai(resultSet.getBoolean("trangThai"));
				kh.setDiemTichLuy(resultSet.getFloat("diemTichLuy"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}

	public boolean updateKhachHang(KhachHang khachHang) {
		try {

			String updateQuery = "UPDATE KhachHang " + "SET soDienThoai = ?, tenKhachHang = ?, email = ?, diaChi = ?, "
					+ "trangThai = ?, diemTichLuy = ? " + "WHERE maKhachHang = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, khachHang.getSoDienThoai());
			preparedStatement.setString(2, khachHang.getTenKhachHang());
			preparedStatement.setString(3, khachHang.getEmail());
			preparedStatement.setString(4, khachHang.getDiaChi());
			preparedStatement.setBoolean(5, khachHang.isTrangThai());
			preparedStatement.setLong(6, (long) khachHang.getDiemTichLuy());
			preparedStatement.setString(7, khachHang.getMaKhachHang());

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
	
	public List<KhachHang> getAllKhachHangCho() {
		List<KhachHang> dsKhachHang = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select*from KhachHang where maKhachHang like 'KC%'");
			ResultSet resultSet = statement.executeQuery();
			dsKhachHang = new ArrayList<KhachHang>();
			while (resultSet.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKhachHang(resultSet.getString("maKhachHang").trim());
				kh.setSoDienThoai(resultSet.getString("soDienThoai").trim());
				kh.setTenKhachHang(resultSet.getString("tenKhachHang").trim());
				kh.setEmail(resultSet.getString("email").trim());
				kh.setDiaChi(resultSet.getString("diaChi").trim());
				kh.setTrangThai(resultSet.getBoolean("trangThai"));
				kh.setDiemTichLuy(resultSet.getFloat("diemTichLuy"));

				dsKhachHang.add(kh);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	public boolean themKhachHang(KhachHang kh) {
		int n = 0;
		try {
			connection = ConnectDataBase.getInstance().connection;
			String sql = "insert into KhachHang values(?,?,?,?,?,?,?)";
			preStm = connection.prepareStatement(sql);
			preStm.setString(1, kh.getMaKhachHang());
			preStm.setString(2, kh.getSoDienThoai());
			preStm.setString(3, kh.getTenKhachHang());
			preStm.setString(4, kh.getEmail());
			preStm.setString(5, kh.getDiaChi());
			preStm.setBoolean(6, kh.isTrangThai());
			preStm.setFloat(7, kh.getDiemTichLuy());
			n = preStm.executeUpdate();
		} catch (Exception e) {
		}
		return n > 0;
	}

	/**
	 * Quyền Cơ: lấy số thứ tự mã khách hàng chờ lớn nhất
	 * 
	 * @param ngay
	 * @return
	 */
	public int getKhachHangChoGanNhat() {
		int maKH = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"select top 1*from KhachHang where maKhachHang like 'KC%' order by maKhachHang desc");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				maKH = Integer.parseInt(resultSet.getString("maKhachHang").trim().substring(2));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return maKH;
	}

	/**
	 * Quyền Cơ:
	 * Xóa khách hàng chờ khỏi danh sách 
	 * @param mahd
	 * @return
	 */
	public boolean deleteKhachHang(String maKH) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from KhachHang where maKhachHang ='" + maKH + "'");
			int n = preparedStatement.executeUpdate();
			if (n > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isEmployeeExists(String ten, String soDienThoai, String email) {
	    String query = "SELECT * FROM ten_bang WHERE tenKhachHang = ? OR soDienThoai = ? OR email = ?";
	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, ten);
	        preparedStatement.setString(2, soDienThoai);
	        preparedStatement.setString(3, email);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        return resultSet.next(); // Nếu có dữ liệu, tức là tên, số điện thoại hoặc email đã tồn tại
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
