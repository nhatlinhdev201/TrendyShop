package testFunction;

import javax.swing.*;
import java.awt.*;

public class ThongKePanel extends JPanel {

    public ThongKePanel() {
        setLayout(new BorderLayout());
        
        // Thêm các thành phần và thiết kế giao diện cho trang thống kê ở đây
        JLabel label = new JLabel("Thống kê");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
