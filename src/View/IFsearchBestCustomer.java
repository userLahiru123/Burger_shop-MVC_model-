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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.TableCellRenderer;

class IFsearchBestCustomer extends JFrame {
    private JPanel titlePanel;
    private JLabel label;
    private MyButton btnBack;
    private MyButton btnSearchCustomer;
    private MyButton btnSearchOrder;
    private JTable table;

    IFsearchBestCustomer(ShopController controller) {
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

        label = new JLabel("Search Best Customer");
        label.setFont(new Font("", Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setOpaque(true);
        label.setBackground(Color.red);
        titlePanel.add(label);

        Burger[] sortBurgerArray = controller.sort();
        String[][] data = new String[sortBurgerArray.length][3];
        for (int i = 0; i < sortBurgerArray.length; i++) {
            data[i][0] = controller.getCustomerId(sortBurgerArray[i]);
            data[i][1] = controller.getCustomerName(sortBurgerArray[i]);
            data[i][2] = String.format("%-15.2f", controller.getOrderValue(sortBurgerArray[i]));
        }

        // Column Names
        String column[] = { "Customer ID", "Name", "Total" };
        table = new JTable(data, column) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component comp = super.prepareRenderer(renderer, row, col);
                ((JLabel) comp).setHorizontalAlignment(JLabel.CENTER);
                return comp;
            }
        };
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(60, 70, 460, 230);
        add(sp);

        btnSearchOrder = new MyButton();
        btnSearchOrder.setBounds(150, 310, 140, 30);
        btnSearchOrder.setRadius(30);
        btnSearchOrder.setColor(Color.red);
        btnSearchOrder.setBorderColor(Color.red);
        btnSearchOrder.setColorOver(Color.black);
        btnSearchOrder.setColorClick(Color.red);
        btnSearchOrder.setText("Search Order");
        btnSearchOrder.setBorderPainted(false);
        btnSearchOrder.setFocusable(false);
        btnSearchOrder.setBackground(Color.red);
        btnSearchOrder.setForeground(Color.white);
        btnSearchOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new IFsearchOrder(controller).setVisible(true);
            }
        });
        add(btnSearchOrder);

        btnSearchCustomer = new MyButton();
        btnSearchCustomer.setBounds(300, 310, 140, 30);
        btnSearchCustomer.setRadius(30);
        btnSearchCustomer.setColor(Color.red);
        btnSearchCustomer.setBorderColor(Color.red);
        btnSearchCustomer.setColorOver(Color.black);
        btnSearchCustomer.setColorClick(Color.red);
        btnSearchCustomer.setText("Search Customer");
        btnSearchCustomer.setBorderPainted(false);
        btnSearchCustomer.setFocusable(false);
        btnSearchCustomer.setBackground(Color.red);
        btnSearchCustomer.setForeground(Color.white);
        btnSearchCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new IFsearchCustomer(controller).setVisible(true);
            }
        });
        add(btnSearchCustomer);

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
