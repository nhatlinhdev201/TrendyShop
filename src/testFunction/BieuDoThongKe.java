//package testFunction;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.data.category.CategoryDataset;
//import org.jfree.data.category.DefaultCategoryDataset;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.List;
//
//public class BieuDoThongKe extends JPanel {
//    private List<ModelThongKeMatHang> danhSachMatHang;
//
//    public BieuDoThongKe(List<ModelThongKeMatHang> danhSachMatHang) {
//        this.danhSachMatHang = danhSachMatHang;
//
//        initUI();
//    }
//
//    private void initUI() {
//        CategoryDataset dataset = createDataset();
//        JFreeChart barChart = createBarChart(dataset);
//
//        ChartPanel chartPanel = new ChartPanel(barChart);
//        chartPanel.setPreferredSize(new Dimension(600, 300));
//
//        add(chartPanel);
//    }
//
//    private CategoryDataset createDataset() {
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        for (ModelThongKeMatHang matHang : danhSachMatHang) {
//            dataset.addValue(matHang.getSoLuongDaBan(), "Số lượng đã bán", matHang.getMaHangHoa());
//            dataset.addValue(matHang.getDoanhThu(), "Doanh thu", matHang.getMaHangHoa());
//        }
//
//        return dataset;
//    }
//
//    private JFreeChart createBarChart(CategoryDataset dataset) {
//        return ChartFactory.createBarChart(
//                "Biểu đồ thống kê mặt hàng",
//                "Mã hàng hóa",
//                "Số lượng/Doanh thu",
//                dataset
//        );
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            List<ModelThongKeMatHang> danhSachMatHang = // Nạp dữ liệu từ cơ sở dữ liệu hoặc nơi khác
//
//            JFrame frame = new JFrame();
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.getContentPane().add(new BieuDoThongKe(danhSachMatHang));
//            frame.setSize(650, 400);
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
//        });
//    }
//}
