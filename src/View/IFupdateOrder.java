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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class IFupdateOrder extends JFrame {
    private JPanel titlePanel;
    private JLabel label;
    private JLabel lblDisplayCustomerId;
    private JLabel lblDisplayCustomerName;
    private JLabel lblDisplayTotal;
    private JTextPane txtError;
    private JTextField txtOrderId;
    private JTextField txtQTY;
    private MyButton btnUpdate;
    private MyButton btnBack;
    private MyButton btnClear;
    private MyButton btnSearchOrder;
    private Component frame;
    private JComboBox<String> cb;
    String orderId = "";

    IFupdateOrder(ShopController controller) {
        setTitle("BURGERSHOP");
        setSize(600, 400);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);

        titlePanel = new JPanel(new FlowLayout());
        titlePanel.setBounds(0, 0, 600, 50);
        titlePanel.setBackground(Color.red);
        add(titlePanel);

        label = new JLabel("Update Orders");
        label.setFont(new Font("", Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setOpaque(true);
        label.setBackground(Color.red);
        titlePanel.add(label);

        label = new JLabel("Order Status ");
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(50, 70, 150, 30);
        add(label);

        String[] choices = { "Cancelled...", "Processing...", "Delivered...", };

        cb = new JComboBox<String>(choices);
        cb.setBounds(200, 70, 100, 30);
        cb.setVisible(true);
        add(cb);

        txtError = new JTextPane();
        txtError.setContentType("text");
        txtError.setText("");
        txtError.setOpaque(false);
        txtError.setEditable(false);
        txtError.setFont(new Font("", Font.BOLD, 10));
        txtError.setForeground(Color.red);
        txtError.setBounds(320, 70, 200, 40);
        add(txtError);

        label = new JLabel("Order id ");
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(50, 115, 150, 30);
        add(label);

        txtOrderId = new JTextField();
        txtOrderId.setBounds(200, 116, 100, 25);
        txtOrderId.setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
        add(txtOrderId);

        btnSearchOrder = new MyButton();
        btnSearchOrder.setRadius(25);
        btnSearchOrder.setBorderColor(Color.green);
        btnSearchOrder.setText("Search");
        btnSearchOrder.setBorderPainted(false);
        btnSearchOrder.setFocusable(false);
        btnSearchOrder.setBounds(400, 116, 100, 30);
        btnSearchOrder.setBackground(Color.green);
        btnSearchOrder.setForeground(Color.white);
        btnSearchOrder.setColor(Color.green);
        btnSearchOrder.setColorClick(Color.green);
        btnSearchOrder.setColorOver(Color.black);
        btnSearchOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderId = txtOrderId.getText();
                if (controller.isExitOrder(orderId)) {
                    btnSearchOrder.setEnabled(false);
                    // search order..............
                    lblDisplayCustomerId.setText(controller.getCustomerId(orderId));
                    lblDisplayCustomerName.setText(controller.getCustomer(orderId));
                    txtQTY.setText(String.valueOf(controller.getOrderQTY(orderId)));
                    lblDisplayTotal.setText(String.format("%.2f", controller.getOrderValue(orderId)));
                    switch (controller.getOrderStatus(orderId)) {
                        case "Cancel":
                            cb.setSelectedIndex(0);
                            break;
                        case "Preparing":
                            cb.setSelectedIndex(1);
                            break;
                        case "Delivered":
                            cb.setSelectedIndex(2);
                            break;
                        default:
                            throw new AssertionError();
                    }

                    if (controller.getOrderStatus(orderId).equals("Cancel")) {
                        txtError.setText("This order has been cancelled.\nSorry, You can not update this order...");
                        cb.setSelectedIndex(0);
                        cb.setEnabled(false);
                    } else if (controller.getOrderStatus(orderId).equals("Delivered")) {
                        txtError.setText("This order has been delivered.\nSorry, You can not update this order...");
                        cb.setSelectedIndex(2);
                        cb.setEnabled(false);
                    }

                    if (controller.getOrderStatus(orderId).equals("Preparing")) {
                        btnUpdate.setEnabled(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter valid Order ID...");
                    txtOrderId.setText("");
                }
            }
        });
        add(btnSearchOrder);

        label = new JLabel("Customer id ");
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(50, 150, 150, 30);
        add(label);

        lblDisplayCustomerId = new JLabel();
        lblDisplayCustomerId.setBounds(200, 152, 100, 25);
        lblDisplayCustomerId.setBackground(Color.gray);
        lblDisplayCustomerId.setOpaque(true);
        lblDisplayCustomerId.setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
        add(lblDisplayCustomerId);

        label = new JLabel("Name ");
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(50, 185, 150, 30);
        add(label);

        lblDisplayCustomerName = new JLabel();
        lblDisplayCustomerName.setBounds(200, 188, 100, 25);
        lblDisplayCustomerName.setBackground(Color.gray);
        lblDisplayCustomerName.setOpaque(true);
        lblDisplayCustomerName.setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
        add(lblDisplayCustomerName);

        label = new JLabel("QTY ");
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(50, 220, 150, 30);
        add(label);

        txtQTY = new JTextField();
        txtQTY.setBounds(200, 222, 100, 25);
        txtQTY.setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
        add(txtQTY);

        label = new JLabel("Total ");
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(50, 255, 150, 30);
        add(label);

        lblDisplayTotal = new JLabel("");
        lblDisplayTotal.setBounds(210, 257, 100, 25);
        lblDisplayTotal.setForeground(Color.red);
        add(lblDisplayTotal);

        btnUpdate = new MyButton();
        btnUpdate.setBounds(200, 310, 140, 30);
        btnUpdate.setRadius(30);
        btnUpdate.setColor(Color.green);
        btnUpdate.setBorderColor(Color.green);
        btnUpdate.setColorOver(Color.black);
        btnUpdate.setColorClick(Color.green);
        btnUpdate.setText("Update Order");
        btnUpdate.setBorderPainted(false);
        btnUpdate.setFocusable(false);
        btnUpdate.setBackground(Color.green);
        btnUpdate.setForeground(Color.white);
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdate.setEnabled(false);

                int s = -1;
                s = cb.getSelectedIndex();
                int qty = Integer.parseInt(txtQTY.getText());
                if (qty > 0) {
                    // quantity update...............
                    controller.updateQTY(orderId, qty);

                    // status update..............
                    controller.updateStatus(orderId, s);
                    lblDisplayTotal.setText(String.format("%.2f", controller.getOrderValue(orderId)));
                    JOptionPane.showMessageDialog(frame, "Your order successfully updated...\n New order Status: " + controller.getOrderStatus(orderId) + "\nNew Total: Rs." + String.format("%.2f", controller.getOrderValue(orderId)));
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter valid quantity");
                    txtQTY.setText("");
                }
            }
        });
        add(btnUpdate);

        btnClear = new MyButton();
        btnClear.setBounds(345, 310, 100, 30);
        btnClear.setRadius(30);
        btnClear.setColor(Color.red);
        btnClear.setBorderColor(Color.red);
        btnClear.setColorOver(Color.black);
        btnClear.setColorClick(Color.red);
        btnClear.setText("Clear");
        btnClear.setBorderPainted(false);
        btnClear.setFocusable(false);
        btnClear.setBackground(Color.red);
        btnClear.setForeground(Color.white);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtOrderId.setText("");
                lblDisplayCustomerId.setText("");
                lblDisplayCustomerName.setText("");
                txtQTY.setText("");
                lblDisplayTotal.setText("");
                txtError.setText("");
                btnUpdate.setEnabled(false);
                btnSearchOrder.setEnabled(true);
                cb.setEnabled(true);
            }
        });
        add(btnClear);

        btnBack = new MyButton();
        btnBack.setBounds(450, 310, 100, 30);
        btnBack.setRadius(30);
        btnBack.setColor(Color.red);
        btnBack.setBorderColor(Color.red);
        btnBack.setColorOver(Color.black);
        btnBack.setColorClick(Color.red);
        btnBack.setText("Back");
        btnBack.setBorderPainted(false);
        btnBack.setFocusable(false);
        btnBack.setBackground(Color.red);
        btnBack.setForeground(Color.white);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(btnBack);

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Assets/Hamburger.png")));
    }
}
