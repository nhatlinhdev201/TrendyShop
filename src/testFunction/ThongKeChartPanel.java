package testFunction;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import constance.ModelThongKeNVBanHang;
import entities.NhanVien;
import services.ThongKeNVBanHangServices;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ThongKeChartPanel extends JPanel {

    public ThongKeChartPanel(ArrayList<ModelThongKeNVBanHang> data) {
        JFreeChart barChart = createBarChart(data);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(600, 400));
        add(chartPanel);
    }

    private JFreeChart createBarChart(ArrayList<ModelThongKeNVBanHang> data) {
        CategoryDataset dataset = createDataset(data);
        JFreeChart chart = ChartFactory.createBarChart(
                "Biểu đồ doanh thu",
                "Thời gian",
                "Doanh thu",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        return chart;
    }

    private CategoryDataset createDataset(ArrayList<ModelThongKeNVBanHang> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (ModelThongKeNVBanHang thongKe : data) {
            dataset.addValue(thongKe.getTongDoanhThuBanHang(), "Doanh thu", thongKe.getThoiGianThongKe().toString());
        }

        return dataset;
    }

    public static void main(String[] args) {
    	ThongKeNVBanHangServices services = new ThongKeNVBanHangServices();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Biểu đồ doanh thu");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            NhanVien nv = new NhanVien("NV0002");
            ArrayList<ModelThongKeNVBanHang> data = services.layThongTinThongKe5NgayGanNhat(LocalDate.now(), nv);

            ThongKeChartPanel chartPanel = new ThongKeChartPanel(data);
            frame.add(chartPanel);

            frame.setVisible(true);
        });
    }
}
