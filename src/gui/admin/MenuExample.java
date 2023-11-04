package gui.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuExample {
    private JPanel mainPanel;
    private JPanel function1Panel;
    private JPanel function2Panel;
    private JPanel function3Panel;

    /**
     * @wbp.parser.entryPoint
     */
    public MenuExample() {
        mainPanel = new JPanel(new BorderLayout());

        function1Panel = createFunction1Panel();
        function2Panel = createFunction2Panel();
        function3Panel = createFunction3Panel();

        JPanel contentPanel = new JPanel(new CardLayout());
        contentPanel.add(function1Panel, "function1");
        contentPanel.add(function2Panel, "function2");
        contentPanel.add(function3Panel, "function3");

        mainPanel.add(createMenuPanel(contentPanel), BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JFrame frame = new JFrame("Menu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private JPanel createMenuPanel(JPanel contentPanel) {
        JPanel menuPanel = new JPanel(new FlowLayout());

        JButton btnFunction1 = new JButton("Chức năng 1");
        JButton btnFunction2 = new JButton("Chức năng 2");
        JButton btnFunction3 = new JButton("Chức năng 3");

        btnFunction1.addActionListener(e -> ((CardLayout) contentPanel.getLayout()).show(contentPanel, "function1"));
        btnFunction2.addActionListener(e -> ((CardLayout) contentPanel.getLayout()).show(contentPanel, "function2"));
        btnFunction3.addActionListener(e -> ((CardLayout) contentPanel.getLayout()).show(contentPanel, "function3"));

        menuPanel.add(btnFunction1);
        menuPanel.add(btnFunction2);
        menuPanel.add(btnFunction3);

        return menuPanel;
    }

    private JPanel createFunction1Panel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Màn hình chức năng 1"));
        return panel;
    }

    private JPanel createFunction2Panel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Màn hình chức năng 2"));
        return panel;
    }

    private JPanel createFunction3Panel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Màn hình chức năng 3"));
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuExample::new);
    }
}
