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

class IFprocessingOrders extends JFrame {
  private JPanel titlePanel;
  private JLabel label;
  private MyButton btnBack;
  private JTable table;

  IFprocessingOrders(ShopController controller) {
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

    label = new JLabel("Processsing Orders");
    label.setFont(new Font("", Font.BOLD, 20));
    label.setForeground(Color.white);
    label.setOpaque(true);
    label.setBackground(Color.red);
    titlePanel.add(label);

    Burger[] deliveredOrders = controller.viewOreders(Burger.PREPARING);
    String[][] data = new String[deliveredOrders.length][5];
    for (int i = 0; i < deliveredOrders.length; i++) {
      data[i][0] = controller.getOrderId(deliveredOrders[i]);
      data[i][1] = controller.getCustomerId(deliveredOrders[i]);
      data[i][2] = controller.getCustomerName(deliveredOrders[i]);
      data[i][3] = String.valueOf(controller.getOrderQTY(deliveredOrders[i]));
      data[i][4] = String.format("%-15.2f", controller.getOrderValue(deliveredOrders[i]));
    }

    // Column Names
    String column[] = { "Order ID", "Customer ID", "Name", "Order QTY", "Total" };
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
