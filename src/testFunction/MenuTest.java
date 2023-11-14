package testFunction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import daos.Dao_FindTables;
import daos.Dao_ThongKeDoanhThu;
import entities.NhanVien;
import gui.TrangChuPanel;
import modelsThongKe.DuLieuBieuDoThongKeDoanhThu;
import modelsThongKe.ModelThongKeDoanhThuNgay;
import services.ThongKeDoanhThuServices;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuTest extends JFrame {

	private JPanel contentPane;
	private JPanel currentContent;

	public MenuTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel menuPanel = new JPanel();
		contentPane.add(menuPanel, BorderLayout.NORTH);

		JButton btnTrangChu = new JButton("Trang Chủ");
		menuPanel.add(btnTrangChu);

		JButton btnThongKe = new JButton("Thống kê");
		menuPanel.add(btnThongKe);

		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchContent(new TrangChuPanel());
			}
		});

		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchContent(new ThongKePanel());
			}
		});

		switchContent(new TrangChuPanel());
	}

	private void switchContent(JPanel newContent) {
		if (currentContent != null) {
			contentPane.remove(currentContent);
		}
		currentContent = newContent;
		contentPane.add(currentContent, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuTest frame = new MenuTest();
					frame.setVisible(true);

//                    Dao_FindTables dao_FindTables = new Dao_FindTables();
//                    System.out.println(dao_FindTables.TimKiemNhanVienTheoMa("NV0001"));
//                    System.out.println(dao_FindTables.timKiemHoaDonTheoMa("HD0002"));
//                    System.out.println(dao_FindTables.timKiemVoucherTheoMa("VC0002"));
//                    System.out.println(dao_FindTables.timKiemKhachHangTheoMa("KH0001"));

					Dao_ThongKeDoanhThu dao_ThongKeDoanhThu = new Dao_ThongKeDoanhThu();
//                    System.out.println(dao_ThongKeDoanhThu.TongHoaDonTrongNgay(LocalDate.of(2023, 10, 03)));
//                    System.out.println(dao_ThongKeDoanhThu.TongHoaDonDocNhanVienLapTrongNgay(LocalDate.of(2023, 10, 03), "NV0002"));
//                    System.out.println(dao_ThongKeDoanhThu.TongHoaDonTrongThang(10, 2020));
//                    System.out.println(dao_ThongKeDoanhThu.TongHoaDonDuocNhanVienLapTrongThang(10, 2022, "NV0003"));
//                    System.out.println(dao_ThongKeDoanhThu.TongHoaDonDuocLapTrongNam(2022));
//                    System.out.println(dao_ThongKeDoanhThu.TongHoaDonDuocNhanVienLapTrongNam(2022,"NV0002"));
//                    System.out.println(dao_ThongKeDoanhThu.TongSoLuongMatHangBanRaTrongNgay(LocalDate.of(2023, 10, 03)));
//                    System.out.println(dao_ThongKeDoanhThu.TongSoLuongMatHangNhanVienBanRaTrongNgay(LocalDate.of(2023, 10, 03),"NV0002"));
//                    System.out.println(dao_ThongKeDoanhThu.TongSoLuongMatHangBanRaTrongThang(10,2023));
//                    System.out.println(dao_ThongKeDoanhThu.TongSoLuongMatHangNhanVienBanRaTrongThang(10,2023,"NV0002"));
//                    System.out.println(dao_ThongKeDoanhThu.TongSoLuongMatHangBanRaTrongNam(2023));
//                    System.out.println(dao_ThongKeDoanhThu.TongSoLuongMatHangNhanVienBanRaTrongNam(2023, "NV0003"));
//                    System.out.println(dao_ThongKeDoanhThu.TongDoanhThuTrongNgay(LocalDate.of(2023, 10, 03)));
//                    System.out.println(dao_ThongKeDoanhThu.TongDoanhThuTrongNgayCuaNhanVien(LocalDate.of(2023, 10, 03),"NV0003"));
//                    System.out.println(dao_ThongKeDoanhThu.TongDoanhThuTrongThang(10, 2023));
//                    System.out.println(dao_ThongKeDoanhThu.TongDoanhThuTrongThangCuaNhanVien(10, 2023, "NV0003"));
//                    System.out.println(dao_ThongKeDoanhThu.TongDoanhThuTrongNam(2022));
//                    System.out.println(dao_ThongKeDoanhThu.TongDoanhThuTrongNamCuaNhanVien(2022, "NV0003"));
//                    System.out.println(dao_ThongKeDoanhThu.TongVonNhapHangTrongNgay(LocalDate.of(2022, 12, 04)));
//                    System.out.println(dao_ThongKeDoanhThu.TongVonNhapHangTrongNgayNhanVienBan(LocalDate.of(2023, 10, 03), "NV0002"));
//                    System.out.println(dao_ThongKeDoanhThu.TongVonNhapHangTrongThang(10, 2023));
//                    System.out.println(dao_ThongKeDoanhThu.TongVonNhapHangTrongThangNhanVienBan(10, 2023, "NV0002"));
//                    System.out.println(dao_ThongKeDoanhThu.TongVonNhapHangTrongNam(2023));
//                    System.out.println(dao_ThongKeDoanhThu.TongVonNhapHangTrongNamNhanVienBan(2023, "NV0002"));
					NhanVien nv = new NhanVien("NV0002", "Phạm Nhật Linh", null, null, null, null, null, null, true,
							null, false, null);
//					List<DuLieuBieuDoThongKeDoanhThu> arr = new ArrayList<>();
//                    arr = dao_ThongKeDoanhThu.Top5NgayDoanhThuCaoNhatTrongThang(10, 2022, nv.getMaNhanVien());
//                    for(DuLieuBieuDoThongKeDoanhThu dl : arr) {
//                    	System.out.println(dl.toString());
//                    }
//					ThongKeDoanhThuServices doanhThuServices = new ThongKeDoanhThuServices();
//					ArrayList<ModelThongKeDoanhThuNgay> list = doanhThuServices.thongKeCacNgayTrongThang(10, 2023, nv);
//					for (ModelThongKeDoanhThuNgay dl : list) {
//						System.out.println(dl.toString());
//					}
					//export 
					ThongKeDoanhThuServices doanhThuServices = new ThongKeDoanhThuServices();
			        ArrayList<ModelThongKeDoanhThuNgay> dataList = doanhThuServices.thongKeCacNgayTrongThangTheoNv(10, 2023, nv);
					ExportExcelThongKeDoanhThuNgayTheoNV e = new ExportExcelThongKeDoanhThuNgayTheoNV(dataList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
