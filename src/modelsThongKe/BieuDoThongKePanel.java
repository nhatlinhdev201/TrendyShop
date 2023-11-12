package modelsThongKe;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BieuDoThongKePanel extends JPanel {

    private ArrayList<DuLieuBieuDoThongKeDoanhThu> data;
    private String TenBieuDo;

    public BieuDoThongKePanel(ArrayList<DuLieuBieuDoThongKeDoanhThu> data, String TenBieuDo) {
    	this.data = data;
    	this.TenBieuDo = TenBieuDo;
        drawChart();
    }

    
    public String getTenBieuDo() {
		return TenBieuDo;
	}


	public void setTenBieuDo(String tenBieuDo) {
		TenBieuDo = tenBieuDo;
	}


	private void drawChart() {
        JFreeChart barChart = createBarChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(755, 346));
        add(chartPanel, BorderLayout.CENTER);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (DuLieuBieuDoThongKeDoanhThu item : data) {
            dataset.addValue(item.getTongDoanhThu(), TenBieuDo, item.getThoiGian());
        }

        return dataset;
    }

    private JFreeChart createBarChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Biểu đồ thống kê doanh thu",
                "Thời gian",
                "Doanh thu",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        CategoryAxis xAxis = plot.getDomainAxis();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();

        xAxis.setCategoryMargin(0.4);
        renderer.setItemMargin(0.05);
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        return chart;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Biểu đồ thống kê");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panelBieuDoThongKeTheoNgay = new JPanel();
		panelBieuDoThongKeTheoNgay.setBounds(10, 31, 755, 346);
		panelBieuDoThongKeTheoNgay.setBackground(SystemColor.activeCaptionBorder);
		frame.add(panelBieuDoThongKeTheoNgay);
		panelBieuDoThongKeTheoNgay.setLayout(new BorderLayout(0, 0));

        // Tạo một danh sách dữ liệu mẫu
        ArrayList<DuLieuBieuDoThongKeDoanhThu> data = new ArrayList<>();
        data.add(new DuLieuBieuDoThongKeDoanhThu("Ngày 1", 1000));
        data.add(new DuLieuBieuDoThongKeDoanhThu("Ngày 2", 1500));
        data.add(new DuLieuBieuDoThongKeDoanhThu("Ngày 3", 800));
        data.add(new DuLieuBieuDoThongKeDoanhThu("Ngày 4", 1200));

        // Tạo và hiển thị biểu đồ trong panelBieuDoThongKeTheoNgay
        BieuDoThongKePanel chartPanel = new BieuDoThongKePanel(data, "Doanh thu hôm nay và 5 ngày có doanh thu cao nhất tháng");
        panelBieuDoThongKeTheoNgay.setLayout(new BorderLayout());
        panelBieuDoThongKeTheoNgay.add(chartPanel, BorderLayout.CENTER);

        frame.getContentPane().add(panelBieuDoThongKeTheoNgay);
        frame.pack();
        frame.setVisible(true);
    }
}
