package testFunction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import gui.TrangChuPanel;

import java.awt.*;
import java.awt.event.*;

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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


