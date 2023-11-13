package testFunction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modelsThongKe.ModelThongKeDoanhThuNgay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReportPanel extends JPanel {
	private JButton showReportButton;

	public ReportPanel() {
		showReportButton = new JButton("Hiển thị báo cáo");
		showReportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Thực hiện hành động hiển thị báo cáo ở đây
				showReport();
			}
		});

		add(showReportButton);
	}

	private void showReport() {
		// Khởi tạo dữ liệu giả định
		ArrayList<ModelThongKeDoanhThuNgay> data = new ArrayList<>();
		data.add(new ModelThongKeDoanhThuNgay(1, 10, 100.0f, 50.0f, 70.0f, 10.0f, 5.0f, 30.0f, "NV001",
				LocalDate.now()));
		data.add(new ModelThongKeDoanhThuNgay(2, 15, 150.0f, 75.0f, 100.0f, 15.0f, 7.0f, 45.0f, "NV002",
				LocalDate.now()));

		// Tạo bảng và mô hình dữ liệu
		JTable table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("Thời gian");
		model.addColumn("Tổng doanh thu");

		// Thêm dữ liệu vào bảng
		for (ModelThongKeDoanhThuNgay item : data) {
			model.addRow(new Object[] { item.getDate().toString(), item.getTongDoanhThu() });
		}

		// Tạo JScrollPane để cuộn nếu có nhiều dữ liệu
		JScrollPane scrollPane = new JScrollPane(table);

		// Hiển thị cửa sổ thông báo với bảng và nút xuất
		Object[] options = { "Xuất", "Hủy" };
		int result = JOptionPane.showOptionDialog(this, scrollPane, "Danh sách thống kê", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		// Xử lý kết quả khi người dùng bấm nút "Xuất"
		if (result == JOptionPane.OK_OPTION) {
			// Thực hiện hành động xuất ở đây
			exportData(data);
		}
	}

	private void exportData(ArrayList<ModelThongKeDoanhThuNgay> data) {
		// Viết logic xuất dữ liệu vào file ở đây
		// Sau khi xuất xong, thực hiện các hành động khác nếu cần
	}

	public static void main(String[] args) {
		// Thêm ví dụ sử dụng

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);

		ReportPanel reportPanel = new ReportPanel();
		frame.add(reportPanel);

		frame.setVisible(true);
	}
}
