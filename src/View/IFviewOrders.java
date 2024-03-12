package View;

import Controller.ShopController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class IFviewOrders extends JFrame {
     private JLabel lblTitle;
     private JLabel label;
     private JPanel leftPanel;
     private JPanel titlePanel;
     private JPanel imagePanel;
     private JPanel rightPanel;
     private JPanel buttonPanel;
     private MyButton btnDeliveredOrder;
     private MyButton btnProcessingOrder;
     private MyButton btnCancelOrder;
     private MyButton btnExit;
     private MyButton btnBack;
     private ImageIcon image;

     IFviewOrders(ShopController controller) {
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

          titlePanel = new JPanel(new FlowLayout());
          titlePanel.setBounds(0, 0, 348, 50);
          titlePanel.setBackground(Color.red);
          rightPanel.add(titlePanel);

          label = new JLabel("View Orders");
          label.setFont(new Font("", Font.BOLD, 20));
          label.setForeground(Color.white);
          label.setOpaque(true);
          label.setBackground(Color.red);
          titlePanel.add(label);

          buttonPanel = new JPanel(new FlowLayout());
          buttonPanel.setBounds(60, 110, 200, 170);
          buttonPanel.setFocusable(false);
          rightPanel.add(buttonPanel);

          btnDeliveredOrder = new MyButton();
          btnDeliveredOrder.setRadius(25);
          btnDeliveredOrder.setBorderColor(Color.red);
          btnDeliveredOrder.setText("  Delivered Orders    ");
          btnDeliveredOrder.setBorderPainted(false);
          btnDeliveredOrder.setFocusable(false);
          btnDeliveredOrder.setBackground(Color.red);
          btnDeliveredOrder.setForeground(Color.white);
          btnDeliveredOrder.setColorOver(Color.black);
          btnDeliveredOrder.setColorClick(Color.red);
          btnDeliveredOrder.setColor(Color.red);
          btnDeliveredOrder.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    new IFdeliveredOrders(controller).setVisible(true);
               }
          });

          btnProcessingOrder = new MyButton();
          btnProcessingOrder.setRadius(25);
          btnProcessingOrder.setBorderColor(Color.red);
          btnProcessingOrder.setBorderPainted(false);
          btnProcessingOrder.setText("Processing Orders");
          btnProcessingOrder.setFocusable(false);
          btnProcessingOrder.setBackground(Color.red);
          btnProcessingOrder.setForeground(Color.white);
          btnProcessingOrder.setColorOver(Color.black);
          btnProcessingOrder.setColorClick(Color.red);
          btnProcessingOrder.setColor(Color.red);
          btnProcessingOrder.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    new IFprocessingOrders(controller).setVisible(true);
               }
          });

          btnCancelOrder = new MyButton();
          btnCancelOrder.setRadius(25);
          btnCancelOrder.setBorderColor(Color.red);
          btnCancelOrder.setText("   Canceled Orders   ");
          btnCancelOrder.setBorderPainted(false);
          btnCancelOrder.setFocusable(false);
          btnCancelOrder.setBackground(Color.red);
          btnCancelOrder.setForeground(Color.white);
          btnCancelOrder.setColorOver(Color.black);
          btnCancelOrder.setColorClick(Color.red);
          btnCancelOrder.setColor(Color.red);
          btnCancelOrder.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    new IFcancelledOrders(controller).setVisible(true);
               }
          });
          
          btnBack = new MyButton();
          btnBack.setBounds(50, 300, 150, 30);
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
          rightPanel.add(btnBack);

          btnExit = new MyButton();
          btnExit.setBounds(230, 300, 90, 30);
          btnExit.setRadius(30);
          btnExit.setBorderColor(Color.red);
          btnExit.setText("Exit");
          btnExit.setBorderPainted(false);
          btnExit.setFocusable(false);
          btnExit.setBackground(Color.red);
          btnExit.setForeground(Color.white);
          btnExit.setColorOver(Color.black);
          btnExit.setColorClick(Color.red);
          btnExit.setColor(Color.red);
          btnExit.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    System.exit(0);
               }
          });
          rightPanel.add(btnExit);

          buttonPanel.add(btnDeliveredOrder);
          buttonPanel.add(btnProcessingOrder);
          buttonPanel.add(btnCancelOrder);

          setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Assets/Hamburger.png")));
     }
}
