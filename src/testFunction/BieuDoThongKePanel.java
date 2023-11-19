package testFunction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import constance.ModelThongKeDoanhThu;
import services.ThongKeDoanhThuServices;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BieuDoThongKePanel extends JPanel {

    private ArrayList<ModelThongKeDoanhThu> dataThongKeCacNgayTrongThang;

    public BieuDoThongKePanel(ArrayList<ModelThongKeDoanhThu> dataThongKeCacNgayTrongThang) {
        this.dataThongKeCacNgayTrongThang = dataThongKeCacNgayTrongThang;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        JFreeChart barChart = createBarChart();

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(504, 515));

        add(chartPanel, BorderLayout.CENTER);
    }

    private JFreeChart createBarChart() {
        DefaultCategoryDataset dataset = createDataset();

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ doanh thu ngày trong tháng",
                "Ngày",
                "Doanh thu",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        CategoryPlot plot = barChart.getCategoryPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        //domainAxis.setCategoryLabelWidthType(CategoryLabelWidthType.RANGE);
        
        // Đặt kích cỡ chữ cho nhãn trục x
        domainAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 7));

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemMargin(0.05);

        return barChart;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (ModelThongKeDoanhThu data : dataThongKeCacNgayTrongThang) {
            dataset.addValue(data.getTongDoanhThu(), "Tổng doanh thu các ngày trong tháng", data.getThoiGianThongKe());
        }

        return dataset;
    }

    public static void main(String[] args) {
    	ThongKeDoanhThuServices doanhThuServices = new ThongKeDoanhThuServices();
        // Tạo một danh sách dữ liệu mẫu
        ArrayList<ModelThongKeDoanhThu> dataThongKeCacNgayTrongThang = new ArrayList<>();
        dataThongKeCacNgayTrongThang = doanhThuServices.layDuLieuThongKeCacNgayTrongThang(8, 2023);

        // Tạo JFrame và thêm panel vào đó
        JFrame frame = new JFrame("Biểu đồ doanh thu ngày trong tháng");
        BieuDoThongKePanel panel = new BieuDoThongKePanel(dataThongKeCacNgayTrongThang);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
