package View;

import Controller.ShopController;
import Model.Burger;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class IFplaceOrder extends JFrame {
    private JPanel titlePanel;
    private JLabel label;
    private JLabel lblDisplayOrderId;
    private JLabel lblDisplayOrderStatus;
    private JLabel lblDisplayNetTotal;
    private JTextField txtCustomerId;
    private JTextField txtCustomerName;
    private JTextField txtBurgerQTY;
    private MyButton btnPlaceOrder;
    private MyButton btnBack;
    private MyButton btnCancel;
    private Component frame;

    IFplaceOrder(ShopController controller) {
        String orderId = controller.generateOrderId();
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

        label = new JLabel("Place Order");
        label.setFont(new Font("", Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setOpaque(true);
        label.setBackground(Color.red);
        titlePanel.add(label);

        label = new JLabel("Order id: ");
        label.setOpaque(true);
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(80, 70, 100, 50);
        add(label);

        label = new JLabel("Customer id: ");
        label.setOpaque(true);
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(80, 120, 100, 50);
        add(label);

        txtCustomerId = new JTextField();
        txtCustomerId.setBounds(180, 134, 100, 25);
        txtCustomerId.setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
        add(txtCustomerId);

        label = new JLabel("Name: ");
        label.setOpaque(true);
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(80, 165, 100, 50);
        add(label);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(180, 175, 100, 25);
        txtCustomerName.setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
        add(txtCustomerName);

        label = new JLabel();
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setBounds(80, 205, 250, 1);
        add(label);

        label = new JLabel("Burger QTY: ");
        label.setOpaque(true);
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(80, 207, 100, 50);
        add(label);

        txtBurgerQTY = new JTextField();
        txtBurgerQTY.setBounds(180, 220, 100, 25);
        txtBurgerQTY.setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
        add(txtBurgerQTY);

        label = new JLabel("Order Status: ");
        label.setOpaque(true);
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(80, 260, 100, 50);
        add(label);

        lblDisplayOrderId = new JLabel();
        lblDisplayOrderId.setText(orderId);
        lblDisplayOrderId.setOpaque(true);
        lblDisplayOrderId.setFont(new Font("", Font.BOLD, 15));
        lblDisplayOrderId.setBounds(180, 70, 100, 50);
        add(lblDisplayOrderId);

        lblDisplayOrderStatus = new JLabel();
        lblDisplayOrderStatus.setOpaque(true);
        lblDisplayOrderStatus.setFont(new Font("", Font.BOLD, 15));
        lblDisplayOrderStatus.setBounds(180, 260, 100, 50);
        add(lblDisplayOrderStatus);

        btnPlaceOrder = new MyButton();
        btnPlaceOrder.setBounds(380, 100, 150, 30);
        btnPlaceOrder.setRadius(30);
        btnPlaceOrder.setColor(Color.green);
        btnPlaceOrder.setBorderColor(Color.green);
        btnPlaceOrder.setColorOver(Color.black);
        btnPlaceOrder.setColorClick(Color.green);
        btnPlaceOrder.setText("  Place Order  ");
        btnPlaceOrder.setBorderPainted(false);
        btnPlaceOrder.setFocusable(false);
        btnPlaceOrder.setBackground(Color.green);
        btnPlaceOrder.setForeground(Color.white);
        btnPlaceOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerId = txtCustomerId.getText();
                if (customerId.equals("") || customerId.charAt(0) != '0' || customerId.length() != 10) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid ID");
                    txtCustomerId.setText("");
                } else {
                    Pattern p = Pattern.compile("(.)*(\\d)(.)*");
                    if(txtCustomerName.getText().equals("") || p.matcher(txtCustomerName.getText()).matches()){
                        JOptionPane.showMessageDialog(frame, "Please enter valid name");
                        txtCustomerName.setText("");
                    }else{
                        boolean isExistCustomer = false;
                        String customerName = "";
                        double billValue = 0;
                        isExistCustomer = controller.isExitCustomer(customerId);
                        if (isExistCustomer) {
                            customerName = controller.getCustomerName(customerId);
                        } else {
                            customerName = txtCustomerName.getText();
                        }

                        Pattern p1 = Pattern.compile("[0-9]+");
                        if(txtBurgerQTY.getText().equals("") || !p1.matcher(txtBurgerQTY.getText()).matches()){
                            JOptionPane.showMessageDialog(frame, "Please enter valid quantity");
                            txtBurgerQTY.setText("");
                        }else{
                            // get burger quantity.................
                            int qty = Integer.parseInt(txtBurgerQTY.getText());
                            if (qty > 0) {
                                billValue = qty * Burger.BURGERPRICE;
                                lblDisplayNetTotal.setText(String.format("%.2f", billValue));
                        
                                controller.addOrder(orderId, customerName, customerId, qty, billValue);
                                lblDisplayOrderStatus.setText("Pending...");

                                JOptionPane.showMessageDialog(frame,"Your order is comfirmed.....\n Rs." + String.format("%.2f", billValue));
                                new IFplaceOrder(controller).setVisible(true);
                                setVisible(false);
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(frame, "Please enter valid quantity");
                                txtBurgerQTY.setText("");
                            }
                        }
                    }
                }
            }
        });
        add(btnPlaceOrder);

        btnBack = new MyButton();
        btnBack.setBounds(380, 160, 150, 30);
        btnBack.setRadius(30);
        btnBack.setColor(Color.red);
        btnBack.setBorderColor(Color.red);
        btnBack.setColorOver(Color.black);
        btnBack.setColorClick(Color.red);
        btnBack.setText("Back to Main Menu");
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

        btnCancel = new MyButton();
        btnCancel.setBounds(380, 220, 150, 30);
        btnCancel.setRadius(30);
        btnCancel.setColor(Color.red);
        btnCancel.setBorderColor(Color.red);
        btnCancel.setColorOver(Color.black);
        btnCancel.setColorClick(Color.red);
        btnCancel.setText("Cancel");
        btnCancel.setBorderPainted(false);
        btnCancel.setFocusable(false);
        btnCancel.setBackground(Color.red);
        btnCancel.setForeground(Color.white);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCustomerId.setText("");
                txtBurgerQTY.setText("");
                lblDisplayOrderStatus.setText("");
                lblDisplayNetTotal.setText("");
                txtCustomerName.setText("");
            }
        });
        add(btnCancel);

        label = new JLabel("NET Total: ");
        label.setOpaque(true);
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(380, 270, 80, 50);
        add(label);

        lblDisplayNetTotal = new JLabel("");
        lblDisplayNetTotal.setOpaque(true);
        lblDisplayNetTotal.setFont(new Font("", Font.BOLD, 15));
        lblDisplayNetTotal.setBounds(463, 270, 95, 50);
        add(lblDisplayNetTotal);

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Assets/Hamburger.png")));
    }
}
