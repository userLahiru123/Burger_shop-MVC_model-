package View;

import Controller.ShopController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IFdashboard extends JFrame {
     private JLabel lblTitle;
     private JPanel leftPanel;
     private JPanel titlePanel;
     private JPanel imagePanel;
     private JPanel rightPanel;
     private JPanel buttonPanel;
     private MyButton btnPlaceOrder;
     private MyButton btnSearch;
     private MyButton btnViewOrder;
     private MyButton btnUpdateOrder;
     private MyButton btnExit;
     private ImageIcon image;

     IFdashboard(ShopController controller) {
          setTitle("BURGERSHOP");
          setSize(600, 400);
          setResizable(false);
          setLayout(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setLocationRelativeTo(null);

          leftPanel = new JPanel();
          leftPanel.setLayout(null);
          leftPanel.setBounds(0, 0, 250, 400);
          leftPanel.setBackground(Color.white);

          titlePanel = new JPanel(new BorderLayout());
          titlePanel.setBounds(0, 0, 250, 50);

          lblTitle = new JLabel("Welcome to Burgers", JLabel.CENTER);
          lblTitle.setFont(new Font("Serif", Font.BOLD, 18));
          lblTitle.setForeground(new Color(200, 164, 27));
          lblTitle.setOpaque(true);
          lblTitle.setBackground(Color.white);

          titlePanel.add(lblTitle, BorderLayout.CENTER);
          leftPanel.add(titlePanel);

          imagePanel = new JPanel(new BorderLayout());
          imagePanel.setBounds(0, 50, 250, 300);
          image = new ImageIcon(getClass().getResource("Assets/burgerShop.jpg"));
          imagePanel.add(new JLabel(image));
          imagePanel.setBackground(Color.white);

          leftPanel.add(imagePanel, BorderLayout.CENTER);
          add(leftPanel);

          rightPanel = new JPanel();
          rightPanel.setLayout(null);
          rightPanel.setBounds(250, 0, 350, 400);
          add(rightPanel);

          buttonPanel = new JPanel(new FlowLayout());
          buttonPanel.setBounds(60, 110, 200, 170);
          buttonPanel.setFocusable(false);
          rightPanel.add(buttonPanel);

          btnPlaceOrder = new MyButton();
          btnPlaceOrder.setRadius(25);
          btnPlaceOrder.setBorderColor(Color.red);
          btnPlaceOrder.setText("  Place order  ");
          btnPlaceOrder.setBorderPainted(false);
          btnPlaceOrder.setFocusable(false);
          btnPlaceOrder.setBackground(Color.red);
          btnPlaceOrder.setForeground(Color.white);
          btnPlaceOrder.setColor(Color.red);
          btnPlaceOrder.setColorClick(Color.red);
          btnPlaceOrder.setColorOver(Color.black);
          btnPlaceOrder.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    new IFplaceOrder(controller).setVisible(true);
               }
          });

          btnSearch = new MyButton();
          btnSearch.setRadius(25);
          btnSearch.setBorderColor(Color.red);
          btnSearch.setBorderPainted(false);
          btnSearch.setText("      Search      ");
          btnSearch.setFocusable(false);
          btnSearch.setBackground(Color.red);
          btnSearch.setForeground(Color.white);
          btnSearch.setColor(Color.red);
          btnSearch.setColorClick(Color.red);
          btnSearch.setColorOver(Color.black);
          btnSearch.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    new IFsearchBestCustomer(controller).setVisible(true);
               }
          });

          btnViewOrder = new MyButton();
          btnViewOrder.setRadius(25);
          btnViewOrder.setBorderColor(Color.red);
          btnViewOrder.setText("  View Order  ");
          btnViewOrder.setBorderPainted(false);
          btnViewOrder.setFocusable(false);
          btnViewOrder.setBackground(Color.red);
          btnViewOrder.setForeground(Color.white);
          btnViewOrder.setColor(Color.red);
          btnViewOrder.setColorClick(Color.red);
          btnViewOrder.setColorOver(Color.black);
          btnViewOrder.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    new IFviewOrders(controller).setVisible(true);
               }
          });

          btnUpdateOrder = new MyButton();
          btnUpdateOrder.setRadius(25);
          btnUpdateOrder.setBorderColor(Color.red);
          btnUpdateOrder.setText("Update Order");
          btnUpdateOrder.setBorderPainted(false);
          btnUpdateOrder.setFocusable(false);
          btnUpdateOrder.setBackground(Color.red);
          btnUpdateOrder.setForeground(Color.white);
          btnUpdateOrder.setColor(Color.red);
          btnUpdateOrder.setColorClick(Color.red);
          btnUpdateOrder.setColorOver(Color.black);
          btnUpdateOrder.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    new IFupdateOrder(controller).setVisible(true);
               }
          });

          btnExit = new MyButton();
          btnExit.setBounds(230, 300, 90, 30);
          btnExit.setRadius(25);
          btnExit.setBorderColor(Color.red);
          btnExit.setText("Exit");
          btnExit.setBorderPainted(false);
          btnExit.setFocusable(false);
          btnExit.setBackground(Color.red);
          btnExit.setForeground(Color.white);
          btnExit.setColor(Color.red);
          btnExit.setColorClick(Color.red);
          btnExit.setColorOver(Color.black);
          btnExit.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    System.exit(0);
               }
          });
          rightPanel.add(btnExit);

          buttonPanel.add(btnPlaceOrder);
          buttonPanel.add(btnSearch);
          buttonPanel.add(btnViewOrder);
          buttonPanel.add(btnUpdateOrder);

          setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Assets/Hamburger.png")));
     }
}
