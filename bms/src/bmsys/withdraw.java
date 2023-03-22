package bmsys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class withdraw extends JFrame implements ActionListener {
    JLabel image, enteramountJLable;
    JTextField enteramountJTextField;
    JButton withdrawJButton, backJButton;
    String pinnumber;
    public withdraw(String pinnumber){
        this.pinnumber = pinnumber;
        {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            image = new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);
        }

        {
            enteramountJLable = new JLabel("Enter amount to withdraw:");
            enteramountJLable.setBounds(220,300,210,35);
            enteramountJLable.setFont(new Font("Raleway", Font.BOLD, 16));
            enteramountJLable.setForeground(Color.WHITE);
            image.add(enteramountJLable);
        }

        {
            enteramountJTextField = new JTextField();
            enteramountJTextField.setBounds(220,350,190,30);
            enteramountJTextField.setFont(new Font("Raleway",Font.BOLD,22));
            image.add(enteramountJTextField);
        }

        {
            withdrawJButton = new JButton("withdraw");
            withdrawJButton.setBounds(350,485,150,30);
            withdrawJButton.addActionListener(this);
            image.add(withdrawJButton);
        }

        {
            backJButton = new JButton("Back");
            backJButton.setBounds(350,520,150,30);
            backJButton.addActionListener(this);
            image.add(backJButton);
        }

        //the frame
        {
            setSize(900,900);
            setLocationRelativeTo(null);
            getContentPane().setBackground(Color.white);
            setLayout(null);
            setVisible(true);
        }
    }

    //main function
    public static void main(String[] args) {
        new withdraw("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String amount = enteramountJTextField.getText();
        Date date = new Date();

        if (e.getSource() == withdrawJButton){
            try {
                conn c = new conn();
                String query = "INSERT INTO bank VALUES('"+pinnumber+"','"+date+"','Withdraw','"+amount+"');";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" withdrawawn successfully");
                setVisible(false);
                new transaction(pinnumber).setVisible(true);
            }catch (Exception e5){
                System.out.println(e5);
            }

        } else if (e.getSource()== backJButton) {
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
        }
    }
}
