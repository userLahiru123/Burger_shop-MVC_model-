package View;

import Controller.ShopController;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class IFsearchOrder extends JFrame {
    private JPanel titlePanel;
    private JTextField txtOrderId;
    private JLabel lblDisplayName;
    private JLabel label;
    private JLabel lblDisplayQTY;
    private JLabel lblDisplayCustomerId;
    private JLabel lblDisplayTotal;
    private JLabel lblDisplayOrderStatus;
    private MyButton btnSearchOrder;
    private MyButton btnClear;
    private MyButton btnBack;
    private Component frame;

    IFsearchOrder(ShopController controller) {
        setTitle("BURGERSHOP");
        setSize(600, 400);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        titlePanel = new JPanel(new FlowLayout());
        titlePanel.setBounds(0, 0, 600, 50);
        titlePanel.setBackground(Color.red);
        add(titlePanel);

        label = new JLabel("Search Order Details");
        label.setFont(new Font("", Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setOpaque(true);
        label.setBackground(Color.red);
        titlePanel.add(label);

        label = new JLabel("Enter Order id: ");
        label.setOpaque(true);
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(50, 70, 120, 50);
        add(label);

        txtOrderId = new JTextField();
        txtOrderId.setBounds(180, 85, 100, 25);
        txtOrderId.setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
        add(txtOrderId);

        btnSearchOrder = new MyButton();
        btnSearchOrder.setRadius(25);
        btnSearchOrder.setBorderColor(Color.green);
        btnSearchOrder.setText("Search");
        btnSearchOrder.setBorderPainted(false);
        btnSearchOrder.setFocusable(false);
        btnSearchOrder.setBounds(300, 80, 100, 30);
        btnSearchOrder.setBackground(Color.green);
        btnSearchOrder.setForeground(Color.white);
        btnSearchOrder.setColor(Color.green);
        btnSearchOrder.setColorClick(Color.green);
        btnSearchOrder.setColorOver(Color.black);
        btnSearchOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderId = txtOrderId.getText();
                if (controller.isExitOrder(orderId)) {
                    lblDisplayCustomerId.setText(controller.getCustomerId(orderId));
                    lblDisplayName.setText(controller.getCustomer(orderId));
                    lblDisplayOrderStatus.setText(controller.getOrderStatus(orderId));
                    lblDisplayQTY.setText(String.valueOf(controller.getOrderQTY(orderId)));
                    lblDisplayTotal.setText(String.format("%.2f", controller.getOrderValue(orderId)));
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter valid Order ID...");
                    txtOrderId.setText("");
                }
            }
        });
        add(btnSearchOrder);

        btnClear = new MyButton();
        btnClear.setRadius(25);
        btnClear.setBorderColor(Color.red);
        btnClear.setText("Clear");
        btnClear.setBorderPainted(false);
        btnClear.setFocusable(false);
        btnClear.setBounds(300, 220, 100, 30);
        btnClear.setBackground(Color.red);
        btnClear.setForeground(Color.white);
        btnClear.setColor(Color.red);
        btnClear.setColorClick(Color.red);
        btnClear.setColorOver(Color.black);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtOrderId.setText("");
                lblDisplayCustomerId.setText("");
                lblDisplayName.setText("");
                lblDisplayOrderStatus.setText("");
                lblDisplayQTY.setText("");
                lblDisplayTotal.setText("");
            }
        });
        add(btnClear);

        btnBack = new MyButton();
        btnBack.setRadius(25);
        btnBack.setBorderColor(Color.red);
        btnBack.setText("Back");
        btnBack.setBorderPainted(false);
        btnBack.setFocusable(false);
        btnBack.setBounds(300, 260, 100, 30);
        btnBack.setBackground(Color.red);
        btnBack.setForeground(Color.white);
        btnBack.setColor(Color.red);
        btnBack.setColorClick(Color.red);
        btnBack.setColorOver(Color.black);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(btnBack);

        label = new JLabel("Customer ID: ");
        label.setOpaque(true);
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(80, 120, 100, 30);
        add(label);

        lblDisplayCustomerId = new JLabel();
        lblDisplayCustomerId.setOpaque(true);
        lblDisplayCustomerId.setFont(new Font("", Font.BOLD, 15));
        lblDisplayCustomerId.setBounds(180, 120, 100, 30);
        add(lblDisplayCustomerId);

        label = new JLabel("Name            : ");
        label.setOpaque(true);
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(80, 150, 100, 30);
        add(label);

        lblDisplayName = new JLabel();
        lblDisplayName.setOpaque(true);
        lblDisplayName.setFont(new Font("", Font.BOLD, 15));
        lblDisplayName.setBounds(180, 150, 100, 30);
        add(lblDisplayName);

        label = new JLabel("QTY              : ");
        label.setOpaque(true);
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(80, 185, 100, 30);
        add(label);

        lblDisplayQTY = new JLabel();
        lblDisplayQTY.setOpaque(true);
        lblDisplayQTY.setFont(new Font("", Font.BOLD, 15));
        lblDisplayQTY.setBounds(180, 185, 100, 30);
        add(lblDisplayQTY);

        label = new JLabel("Total             : ");
        label.setOpaque(true);
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(80, 220, 100, 30);
        add(label);

        lblDisplayTotal = new JLabel();
        lblDisplayTotal.setOpaque(true);
        lblDisplayTotal.setFont(new Font("", Font.BOLD, 15));
        lblDisplayTotal.setBounds(180, 220, 100, 30);
        add(lblDisplayTotal);

        label = new JLabel("Order Status: ");
        label.setOpaque(true);
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(80, 260, 100, 30);
        add(label);

        lblDisplayOrderStatus = new JLabel();
        lblDisplayOrderStatus.setOpaque(true);
        lblDisplayOrderStatus.setFont(new Font("", Font.BOLD, 15));
        lblDisplayOrderStatus.setBounds(180, 260, 100, 30);
        add(lblDisplayOrderStatus);

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Assets/Hamburger.png")));
    }
}
