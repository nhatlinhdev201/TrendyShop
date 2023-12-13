package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDataBase;
import entities.HangHoa;
import entities.VoucherGiamGia;

public class Dao_Voucher {
	public Connection connection;

	public Dao_Voucher() {
		connection = ConnectDataBase.getInstance().getConnection();
	}
	
	/**
	 * lấy toàn bộ danh sách Voucher
	 * @return listHangHoa
	 */

	public List<VoucherGiamGia> getAll() {
		List<VoucherGiamGia> dsVoucher = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from VoucherGiamGia");
			ResultSet resultSet = statement.executeQuery();
			dsVoucher = new ArrayList<VoucherGiamGia>();
			while (resultSet.next()) {
				VoucherGiamGia voucher = new VoucherGiamGia();
				voucher.setMaVoucher(resultSet.getString("maVoucher").trim());
				voucher.setTenVoucher(resultSet.getString("tenVoucher").trim());
				voucher.setMoTaChuongTrinh(resultSet.getString("moTaChuongTrinh").trim());
				voucher.setPhanTramGiamTheoHoaDon(resultSet.getFloat("phanTramGiamTheoHoaDon"));
				voucher.setNgayBatDau(resultSet.getDate("ngayBatDau"));
				voucher.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
				voucher.setSoLuotDung(resultSet.getInt("soLuotDung"));
				voucher.setTrangThai(resultSet.getBoolean("trangThai"));
				dsVoucher.add(voucher);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsVoucher;
	}

	/**
	 * Get tên các phần trăm giảm giá có trong db
	 * @return
	 */
	public List<String> getAllPhanTramGiamGia() {
		List<String> dsThuongHieu = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select hh.phanTramGiamTheoHoaDon from VoucherGiamGia hh group by hh.phanTramGiamTheoHoaDon");
			ResultSet resultSet = statement.executeQuery();
			dsThuongHieu = new ArrayList<String>();
			while (resultSet.next()) {
				dsThuongHieu.add(resultSet.getString("phanTramGiamTheoHoaDon"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThuongHieu;
	}



	/**
	 * get trạng thái có trong db
	 * @return
	 */
	public List<String> getAllTrangThai() {
		List<String> dsThuongHieu = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select hh.trangThai from VoucherGiamGia hh group by hh.trangThai");
			ResultSet resultSet = statement.executeQuery();
			dsThuongHieu = new ArrayList<String>();
			while (resultSet.next()) {
				dsThuongHieu.add(resultSet.getString("trangThai"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThuongHieu;
	}

	/**
	 * Lấy các voucher theo trạng Thái
	 * @param xuatXu
	 * @return
	 */
	public List<VoucherGiamGia> getVoucherByTrangThai(String trangThai) {
		List<VoucherGiamGia> dsVoucher = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from VoucherGiamGia where trangThai = N'" + trangThai + "'");
			ResultSet resultSet = statement.executeQuery();
			dsVoucher = new ArrayList<VoucherGiamGia>();
			while (resultSet.next()) {
				VoucherGiamGia voucher = new VoucherGiamGia();
				voucher.setMaVoucher(resultSet.getString("maVoucher").trim());
				voucher.setTenVoucher(resultSet.getString("tenVoucher").trim());
				voucher.setMoTaChuongTrinh(resultSet.getString("moTaChuongTrinh").trim());
				voucher.setPhanTramGiamTheoHoaDon(resultSet.getFloat("phanTramGiamTheoHoaDon"));
				voucher.setNgayBatDau(resultSet.getDate("ngayBatDau"));
				voucher.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
				voucher.setSoLuotDung(resultSet.getInt("soLuotDung"));
				voucher.setTrangThai(resultSet.getBoolean("trangThai"));
				dsVoucher.add(voucher);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsVoucher;
	}

	/**
	 * get danh sách các voucher theo phần trăm giảm giá
	 * @param phanTram
	 * @return
	 */
	public List<VoucherGiamGia> getVoucherByPhanTramGiamGia(String phanTram) {
		List<VoucherGiamGia> dsVoucher = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from VoucherGiamGia where phanTramGiamTheoHoaDon = N'" + phanTram + "'");
			ResultSet resultSet = statement.executeQuery();
			dsVoucher = new ArrayList<VoucherGiamGia>();
			while (resultSet.next()) {
				VoucherGiamGia voucher = new VoucherGiamGia();
				voucher.setMaVoucher(resultSet.getString("maVoucher").trim());
				voucher.setTenVoucher(resultSet.getString("tenVoucher").trim());
				voucher.setMoTaChuongTrinh(resultSet.getString("moTaChuongTrinh").trim());
				voucher.setPhanTramGiamTheoHoaDon(resultSet.getFloat("phanTramGiamTheoHoaDon"));
				voucher.setNgayBatDau(resultSet.getDate("ngayBatDau"));
				voucher.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
				voucher.setSoLuotDung(resultSet.getInt("soLuotDung"));
				voucher.setTrangThai(resultSet.getBoolean("trangThai"));
				dsVoucher.add(voucher);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsVoucher;
	}

	/**
	 * get danh sách các voucher theo tên
	 * @param ten
	 * @return
	 */
	public List<VoucherGiamGia> getHangHoaByVoucher(String ten) {
		List<VoucherGiamGia> dsVoucher = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from VoucherGiamGia where tenVoucher = N'" + ten + "'");
			ResultSet resultSet = statement.executeQuery();
			dsVoucher = new ArrayList<VoucherGiamGia>();
			while (resultSet.next()) {
				VoucherGiamGia voucher = new VoucherGiamGia();
				voucher.setMaVoucher(resultSet.getString("maVoucher").trim());
				voucher.setTenVoucher(resultSet.getString("tenVoucher").trim());
				voucher.setMoTaChuongTrinh(resultSet.getString("moTaChuongTrinh").trim());
				voucher.setPhanTramGiamTheoHoaDon(resultSet.getFloat("phanTramGiamTheoHoaDon"));
				voucher.setNgayBatDau(resultSet.getDate("ngayBatDau"));
				voucher.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
				voucher.setSoLuotDung(resultSet.getInt("soLuotDung"));
				voucher.setTrangThai(resultSet.getBoolean("trangThai"));
				dsVoucher.add(voucher);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsVoucher;
	}

	/**
	 * Lấy thông tin mã hàng hóa nhập vào
	 * @param ma
	 * @return hanghoa
	 */
	public VoucherGiamGia getMaVouCher(String ma) {
		VoucherGiamGia voucher = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from VoucherGiamGia where maVoucher = N'" + ma + "'");
			ResultSet resultSet = statement.executeQuery();
			voucher = new VoucherGiamGia();
			while (resultSet.next()) {
				voucher.setMaVoucher(resultSet.getString("maVoucher").trim());
				voucher.setTenVoucher(resultSet.getString("tenVoucher").trim());
				voucher.setMoTaChuongTrinh(resultSet.getString("moTaChuongTrinh").trim());
				voucher.setPhanTramGiamTheoHoaDon(resultSet.getFloat("phanTramGiamTheoHoaDon"));
				voucher.setNgayBatDau(resultSet.getDate("ngayBatDau"));
				voucher.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
				voucher.setSoLuotDung(resultSet.getInt("soLuotDung"));
				voucher.setTrangThai(resultSet.getBoolean("trangThai"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return voucher;

	}
	

	/**
	 * Tìm voucher có mã lớn nhất
<<<<<<< HEAD
=======
	 * @return
	 */
	public int getMaHangHoaNew() {
		int maHangHoa=0;
		try {
			PreparedStatement statement = connection
					.prepareStatement("select top(1) maHangHoa from HangHoa order by maHangHoa desc");
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
	            String maHangHoaString = resultSet.getString("maHangHoa");
	            if (maHangHoaString != null && maHangHoaString.length() >= 9) {
	                // Lấy phần số từ vị trí 2 đến 5 và chuyển đổi thành số nguyên
	                maHangHoa = Integer.parseInt(maHangHoaString.substring(2, 6));
	            }
	        }
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maHangHoa;
	
	}

	/**
	 * Tìm voucher có mã lớn nhất
>>>>>>> 85d8d62c212f20e0ae21502bb302e8213f647d1e
	 * @return
	 */
	public String getMaHangHoaNew() {
		try {
			PreparedStatement statement = connection
					.prepareStatement("select top(1) maVoucher from VoucherGiamGia order by maVoucher desc");
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("maVoucher").toString().trim();
	        }

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}
	
	
	/**
	 * Xóa voucher (chuyển trạng thái từ true về false
	 * @param mahh
	 * @return
	 */
	public boolean deleteVoucher(String mavc) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update VoucherGiamGia set trangThai = 0 where maVoucher = '" + mavc + "'");
			int n = preparedStatement.executeUpdate();
			if (n > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Thêm voucher vào database
	 * @param hangHoa
	 * @return
	 */
	public boolean insertVoucher(VoucherGiamGia voucher) {
	    try {
<<<<<<< HEAD
	    
	    	Date dateStart = new Date(voucher.getNgayBatDau().getTime());
	        Date dateEnd = new Date(voucher.getNgayKetThuc().getTime());
	        String insertQuery = "INSERT INTO [dbo].[VoucherGiamGia] " +
                    "([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], " +
                    "[ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        
	        System.out.println(insertQuery);
	        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
	        preparedStatement.setString(1, voucher.getMaVoucher());
            preparedStatement.setString(2, voucher.getTenVoucher());
            preparedStatement.setString(3, voucher.getMoTaChuongTrinh());
            preparedStatement.setFloat(4, voucher.getPhanTramGiamTheoHoaDon());
            preparedStatement.setDate(5, dateStart);
            preparedStatement.setDate(6, dateEnd);
            preparedStatement.setBoolean(7, voucher.isTrangThai());
            preparedStatement.setInt(8, voucher.getSoLuotDung());
=======
	        String insertQuery = "INSERT INTO VoucherGiamGia (maVoucher, tenVoucher,  moTaChuongTrinh, phanTramGiamTheoHoaDon"
	                + " ngayBatDau, ngayKetThuc, trangThai,soLuotDung) "
	                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
	        preparedStatement.setString(1, voucher.getMaVoucher());
	        preparedStatement.setString(2, voucher.getTenVoucher());
	        preparedStatement.setFloat(3, voucher.getPhanTramGiamTheoHoaDon());
	        preparedStatement.setString(4, voucher.getMoTaChuongTrinh());
	        preparedStatement.setInt(5, voucher.getSoLuotDung());
	        preparedStatement.setBoolean(6, voucher.isTrangThai());
	        preparedStatement.setDate(7, convertUtilDateToSqlDate(voucher.getNgayBatDau()));
	        preparedStatement.setDate(8, convertUtilDateToSqlDate(voucher.getNgayKetThuc()));

>>>>>>> 85d8d62c212f20e0ae21502bb302e8213f647d1e
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
<<<<<<< HEAD
=======
	}
	private java.sql.Date convertUtilDateToSqlDate(java.util.Date utilDate) {
	    if (utilDate != null) {
	        return new java.sql.Date(utilDate.getTime());
	    }
	    return null;
>>>>>>> 85d8d62c212f20e0ae21502bb302e8213f647d1e
	}
	


	/**
	 * Cập nhật thông tin của voucher
	 * @param hangHoa
	 * @return
	 */
	public boolean updateVoucher(VoucherGiamGia voucher) {
	    try {
	        String updateQuery = "UPDATE VoucherGiamGia "
	                + "SET tenVoucher = ?, phanTramGiamTheoHoaDon = ?, moTaChuongTrinh = ?, soLuotDung = ?, "
	                + "trangThai = ?, ngayBatDau = ?, ngayKetThuc = ? "
	                + "WHERE maVoucher = ?";

	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
	        preparedStatement.setString(1, voucher.getTenVoucher());
	        preparedStatement.setFloat(2, voucher.getPhanTramGiamTheoHoaDon());
	        preparedStatement.setString(3, voucher.getMoTaChuongTrinh());
	        preparedStatement.setInt(4, voucher.getSoLuotDung());
	        preparedStatement.setBoolean(5, voucher.isTrangThai());
	        preparedStatement.setDate(6, new java.sql.Date(voucher.getNgayBatDau().getTime()));
	        preparedStatement.setDate(7, new java.sql.Date(voucher.getNgayKetThuc().getTime()));
	        preparedStatement.setString(8, voucher.getMaVoucher());

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


	
	 public VoucherGiamGia getVoucherByMa(String maVoucher) {
//	        try (Connection connection = // Lấy connection từ nguồn nào đó) {
	            String sql = "SELECT * FROM VoucherGiamGia WHERE MaVoucher = ?";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	                preparedStatement.setString(1, maVoucher);
	                try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                    if (resultSet.next()) {
	                        VoucherGiamGia voucher = new VoucherGiamGia();
	                        voucher.setMaVoucher(resultSet.getString("MaVoucher"));
	                        voucher.setTenVoucher(resultSet.getString("TenVoucher"));
	                        voucher.setPhanTramGiamTheoHoaDon(resultSet.getInt("PhanTramGiamTheoHoaDon"));
	                        voucher.setMoTaChuongTrinh(resultSet.getString("MoTaChuongTrinh"));
	                        voucher.setSoLuotDung(resultSet.getInt("SoLuotDung"));
	                        voucher.setTrangThai(resultSet.getBoolean("TrangThai"));
	                        voucher.setNgayBatDau(resultSet.getDate("NgayBatDau"));
	                        voucher.setNgayKetThuc(resultSet.getDate("NgayKetThuc"));

	                        return voucher;
	                    }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null; 
	    }
	 

	
}
