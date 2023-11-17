package testFunction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import constance.ModelThongKeDoanhThu;
import services.ThongKeDoanhThuServices;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ThongKeDoanhThuPanel extends JPanel {
    private ArrayList<ModelThongKeDoanhThu> dataList;

    public ThongKeDoanhThuPanel(ArrayList<ModelThongKeDoanhThu> dataList) {
        this.dataList = dataList;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        DefaultPieDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createPieChart(
                "Biểu đồ tổng doanh thu",
                dataset,
                true, // include legend
                true,
                false);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(true);

        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
    }

    private DefaultPieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (ModelThongKeDoanhThu data : dataList) {
            dataset.setValue(data.getTenNhanVien(), data.getTongDoanhThu());
        }
        return dataset;
    }

    public static void main(String[] args) {
    	ThongKeDoanhThuServices doanhThuServices = new ThongKeDoanhThuServices();
  
        // Tạo một danh sách dữ liệu mẫu
        ArrayList<ModelThongKeDoanhThu> dataList = new ArrayList<>();
        
        dataList = doanhThuServices.layDuLieuThongKeDoanhThuNgayTheoNv(LocalDate.now());
        // Tạo JFrame và thêm panel vào đó
        JFrame frame = new JFrame("Test Biểu đồ tròn");
        ThongKeDoanhThuPanel panel = new ThongKeDoanhThuPanel(dataList);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
