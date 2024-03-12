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
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.TableCellRenderer;

class IFsearchCustomer extends JFrame {
    private JPanel titlePanel;
    private JLabel label;
    private JLabel lblDisplayCustomerName;
    private JTextField txtCustomerId;
    private MyButton btnBack;
    private MyButton btnSearchCustomer;
    private MyButton btnClear;
    private Component frame;
    private JTable table;

    IFsearchCustomer(ShopController controller) {
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

        label = new JLabel("Search Customer");
        label.setFont(new Font("", Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setOpaque(true);
        label.setBackground(Color.red);
        titlePanel.add(label);

        label = new JLabel("Enter Customer id: ");
        label.setOpaque(true);
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(50, 70, 150, 30);
        add(label);

        txtCustomerId = new JTextField();
        txtCustomerId.setBounds(190, 73, 100, 25);
        txtCustomerId.setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
        add(txtCustomerId);

        btnSearchCustomer = new MyButton();
        btnSearchCustomer.setRadius(25);
        btnSearchCustomer.setBorderColor(Color.green);
        btnSearchCustomer.setText("Search");
        btnSearchCustomer.setBorderPainted(false);
        btnSearchCustomer.setFocusable(false);
        btnSearchCustomer.setBounds(320, 70, 100, 30);
        btnSearchCustomer.setBackground(Color.green);
        btnSearchCustomer.setForeground(Color.white);
        btnSearchCustomer.setColor(Color.green);
        btnSearchCustomer.setColorClick(Color.green);
        btnSearchCustomer.setColorOver(Color.black);
        btnSearchCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerId = txtCustomerId.getText();
                if (controller.isExitCustomer(customerId)) {
                    lblDisplayCustomerName.setText(controller.getCustomerName(customerId));

                    Burger[] searchCustomerArray = controller.searchCustomer(customerId);
                    String[][] data = new String[searchCustomerArray.length][3];
                    for (int i = 0; i < searchCustomerArray.length; i++) {
                        data[i][0] = controller.getOrderId(searchCustomerArray[i]);
                        data[i][1] = String.valueOf(controller.getOrderQTY(searchCustomerArray[i]));
                        data[i][2] = String.format("%.2f", controller.getOrderValue(searchCustomerArray[i]));
                    }

                    // Column Names
                    String column[] = { "Order ID", "QTY", "Total" };
                    table = new JTable(data, column) {
                        @Override
                        public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                            Component comp = super.prepareRenderer(renderer, row, col);
                            ((JLabel) comp).setHorizontalAlignment(JLabel.CENTER);
                            return comp;
                        }
                    };
                    JScrollPane sp = new JScrollPane(table);
                    sp.setBounds(50, 180, 500, 150);
                    add(sp);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter valid Customer ID...");
                    txtCustomerId.setText("");
                }
            }
        });
        add(btnSearchCustomer);

        btnClear = new MyButton();
        btnClear.setRadius(25);
        btnClear.setBorderColor(Color.red);
        btnClear.setText("Clear");
        btnClear.setBorderPainted(false);
        btnClear.setFocusable(false);
        btnClear.setBounds(450, 70, 100, 30);
        btnClear.setBackground(Color.red);
        btnClear.setForeground(Color.white);
        btnClear.setColor(Color.red);
        btnClear.setColorClick(Color.red);
        btnClear.setColorOver(Color.black);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCustomerId.setText("");
                lblDisplayCustomerName.setText("");
            }
        });
        add(btnClear);

        label = new JLabel("Name                     : ");
        label.setOpaque(true);
        label.setFont(new Font("", Font.BOLD, 15));
        label.setBounds(50, 100, 140, 30);
        add(label);

        lblDisplayCustomerName = new JLabel();
        lblDisplayCustomerName.setOpaque(true);
        lblDisplayCustomerName.setFont(new Font("", Font.BOLD, 15));
        lblDisplayCustomerName.setBounds(190, 100, 100, 30);
        add(lblDisplayCustomerName);

        titlePanel = new JPanel(new FlowLayout());
        titlePanel.setBounds(0, 140, 600, 30);
        titlePanel.setBackground(Color.red);
        add(titlePanel);

        label = new JLabel("Order Details");
        label.setFont(new Font("", Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setOpaque(true);
        label.setBackground(Color.red);
        titlePanel.add(label);

        btnBack = new MyButton();
        btnBack.setBounds(480, 335, 80, 20);
        btnBack.setRadius(20);
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
