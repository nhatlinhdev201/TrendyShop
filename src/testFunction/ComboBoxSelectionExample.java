package testFunction;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxSelectionExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ComboBox Selection Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        String[] nam = {"2020", "2021", "2022", "2023"};
        JComboBox<String> cbxChonNamCuaThangThongKe = new JComboBox<>(nam);

        JButton btnChonNam2021 = new JButton("Chọn Năm 2021");
        btnChonNam2021.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chọn năm 2021 trong JComboBox
                cbxChonNamCuaThangThongKe.setSelectedItem("2021");
            }
        });

        JPanel panel = new JPanel();
        panel.add(cbxChonNamCuaThangThongKe);
        panel.add(btnChonNam2021);

        frame.add(panel);
        frame.setVisible(true);
    }
}
