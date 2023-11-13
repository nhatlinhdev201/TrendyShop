package testFunction;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExportDialogExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Tạo frame
            JFrame frame = new JFrame("Export Dialog Example");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Tạo button để mở dialog
            JButton exportButton = new JButton("Xuất");
            exportButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showExportDialog(frame);
                }
            });

            // Thêm button vào frame
            frame.getContentPane().add(exportButton, BorderLayout.CENTER);

            // Hiển thị frame
            frame.setVisible(true);
        });
    }

    private static void showExportDialog(JFrame parentFrame) {
        // Dữ liệu mẫu cho JTable
        Object[][] data = {
                {"Ngày 1", 100.5},
                {"Ngày 2", 150.0},
                {"Ngày 3", 200.75}
        };

        // Định dạng cột
        String[] columnNames = {"Thời gian", "Doanh thu"};

        // Tạo model cho JTable
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Tạo JTable
        JTable table = new JTable(model);

        // Tạo JScrollPane để chứa JTable
        JScrollPane scrollPane = new JScrollPane(table);

        // Tạo dialog
        JDialog exportDialog = new JDialog(parentFrame, "Xuất Dữ Liệu", true);
        exportDialog.setLayout(new BorderLayout());
        exportDialog.setSize(300, 200);

        // Thêm JTable vào dialog
        exportDialog.add(scrollPane, BorderLayout.CENTER);

        // Tạo panel cho nút xuất và hủy
        JPanel buttonPanel = new JPanel();

        // Tạo nút xuất
        JButton exportButton = new JButton("Xuất");
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gọi phương thức xuất dữ liệu ở đây
                exportDataToExcel();
                // Đóng dialog sau khi xuất xong
                exportDialog.dispose();
            }
        });

        // Tạo nút hủy
        JButton cancelButton = new JButton("Hủy");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Đóng dialog khi bấm nút hủy
                exportDialog.dispose();
            }
        });

        // Thêm nút vào panel
        buttonPanel.add(exportButton);
        buttonPanel.add(cancelButton);

        // Thêm panel vào dialog
        exportDialog.add(buttonPanel, BorderLayout.SOUTH);

        // Hiển thị dialog
        exportDialog.setVisible(true);
    }

    private static void exportDataToExcel() {
        // Đây là nơi bạn triển khai phương thức xuất dữ liệu ra Excel
        System.out.println("Xuất dữ liệu ra Excel");
    }
}
