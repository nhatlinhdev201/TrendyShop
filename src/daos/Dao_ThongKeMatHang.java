package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import connection.ConnectDataBase;
import constance.ModelThongKeMatHang;

public class Dao_ThongKeMatHang {
	public Connection connection;

	public Dao_ThongKeMatHang() {
		connection = ConnectDataBase.getInstance().connection;
	}
	public ArrayList<ModelThongKeMatHang> thongKeTop50MatHangTheoNgay(LocalDate ngayThongKe) {
        ArrayList<ModelThongKeMatHang> danhSachMatHang = new ArrayList<>();

        String sqlQuery = "SELECT CONVERT(VARCHAR, hd.thoiGianTao, 103) AS thoiGian, " +
                          "hh.maHangHoa, hh.tenHangHoa, " +
                          "SUM(chd.soLuong) AS soLuongBan, " +
                          "SUM(chd.thanhTien) AS doanhThu, " +
                          "SUM(hh.soLuongTon) AS soLuongTon, " +
                          "SUM(hh.soLuongDaBan) AS soLuongDaBan " +
                          "FROM HangHoa hh " +
                          "JOIN ChiTietHoaDon chd ON hh.maHangHoa = chd.maHangHoa " +
                          "JOIN HoaDon hd ON chd.maHoaDon = hd.maHoaDon " +
                          "WHERE CONVERT(DATE, hd.thoiGianTao) = ? " +
                          "GROUP BY CONVERT(VARCHAR, hd.thoiGianTao, 103), hh.maHangHoa, hh.tenHangHoa " +
                          "ORDER BY soLuongBan DESC, doanhThu DESC " +
                          "OFFSET 0 ROWS FETCH NEXT 15 ROWS ONLY";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setDate(1, java.sql.Date.valueOf(ngayThongKe));

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String thoiGian = resultSet.getString("thoiGian");
                    String maHangHoa = resultSet.getString("maHangHoa");
                    String tenHangHoa = resultSet.getString("tenHangHoa");
                    int soLuongBan = resultSet.getInt("soLuongBan");
                    float doanhThu = resultSet.getFloat("doanhThu");
                    int soLuongTon = resultSet.getInt("soLuongTon");
                    int soLuongDaBan = resultSet.getInt("soLuongDaBan");

                    ModelThongKeMatHang model = new ModelThongKeMatHang("", thoiGian, maHangHoa, tenHangHoa, soLuongBan, doanhThu, soLuongTon, soLuongDaBan);
                    danhSachMatHang.add(model);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachMatHang;
    }
	public ArrayList<ModelThongKeMatHang> thongKeTop50MatHangTheoThang(int thang, int namCuaThang) {
        ArrayList<ModelThongKeMatHang> danhSachThongKe = new ArrayList<>();
        String sqlQuery = "SELECT TOP 15 hh.maHangHoa, hh.tenHangHoa, " +
                          "SUM(chd.soLuong) AS soLuongBan, " +
                          "SUM(chd.thanhTien) AS doanhThu, " +
                          "hh.soLuongTon, " +
                          "hh.soLuongDaBan " +
                          "FROM HangHoa hh " +
                          "LEFT JOIN ChiTietHoaDon chd ON hh.maHangHoa = chd.maHangHoa " +
                          "LEFT JOIN HoaDon hd ON chd.maHoaDon = hd.maHoaDon " +
                          "WHERE MONTH(hd.thoiGianTao) = ? " +
                          "AND YEAR(hd.thoiGianTao) = ? " +
                          "GROUP BY hh.maHangHoa, hh.tenHangHoa, hh.soLuongTon, hh.soLuongDaBan " +
                          "ORDER BY soLuongBan DESC, doanhThu DESC";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, thang);
            preparedStatement.setInt(2, namCuaThang);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                	String thoiGian = thang+"/"+namCuaThang;
                    String maHangHoa = resultSet.getString("maHangHoa");
                    String tenHangHoa = resultSet.getString("tenHangHoa");
                    int soLuongBan = resultSet.getInt("soLuongBan");
                    float doanhThu = resultSet.getFloat("doanhThu");
                    int soLuongTon = resultSet.getInt("soLuongTon");
                    int soLuongDaBan = resultSet.getInt("soLuongDaBan");

                    ModelThongKeMatHang thongKeMatHang = new ModelThongKeMatHang("", thoiGian, maHangHoa, tenHangHoa, soLuongBan, doanhThu, soLuongTon, soLuongDaBan);
                    danhSachThongKe.add(thongKeMatHang);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý exception theo yêu cầu
        }

        return danhSachThongKe;
    }
	public ArrayList<ModelThongKeMatHang> thongKeTop50MatHangTheoNam(int nam) {
        ArrayList<ModelThongKeMatHang> danhSachThongKe = new ArrayList<>();
        String sqlQuery = "SELECT TOP 15 hh.maHangHoa, hh.tenHangHoa, " +
                "SUM(chd.soLuong) AS soLuongBan, " +
                "SUM(chd.thanhTien) AS doanhThu, " +
                "hh.soLuongTon, " +
                "hh.soLuongDaBan " +
                "FROM HangHoa hh " +
                "LEFT JOIN ChiTietHoaDon chd ON hh.maHangHoa = chd.maHangHoa " +
                "LEFT JOIN HoaDon hd ON chd.maHoaDon = hd.maHoaDon " +
                "WHERE YEAR(hd.thoiGianTao) = ? " +
                "GROUP BY hh.maHangHoa, hh.tenHangHoa, hh.soLuongTon, hh.soLuongDaBan " +
                "ORDER BY soLuongBan DESC, doanhThu DESC";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, nam);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                	String thoiGian = String.valueOf(nam);
                    String maHangHoa = resultSet.getString("maHangHoa");
                    String tenHangHoa = resultSet.getString("tenHangHoa");
                    int soLuongBan = resultSet.getInt("soLuongBan");
                    float doanhThu = resultSet.getFloat("doanhThu");
                    int soLuongTon = resultSet.getInt("soLuongTon");
                    int soLuongDaBan = resultSet.getInt("soLuongDaBan");

                    ModelThongKeMatHang thongKeMatHang = new ModelThongKeMatHang("", thoiGian, maHangHoa, tenHangHoa, soLuongBan, doanhThu, soLuongTon, soLuongDaBan);
                    danhSachThongKe.add(thongKeMatHang);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý exception theo yêu cầu
        }

        return danhSachThongKe;
    }
}
