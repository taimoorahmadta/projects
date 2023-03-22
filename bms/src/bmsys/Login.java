package bmsys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    private JButton login, clear, signup;
    private JTextField cardfield;
    private JPasswordField pinfield;
    Login(){
        {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
            Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel lable = new JLabel(i3);
            lable.setBounds(70, 10, 100, 100);
            add(lable);
        }
        {
            JLabel text = new JLabel("Welcome to ATM");
            text.setBounds(200, 40, 160, 30);
            text.setFont(new Font("Osward", Font.BOLD, 20));
            add(text);
        }
        {
            JLabel cardno = new JLabel("Card No: ");
            cardno.setBounds(100, 120, 100, 30);
            cardno.setFont(new Font("Raleway", Font.BOLD, 20));
            add(cardno);

            cardfield = new JTextField();
            cardfield.setBounds(200,120,200,30);
            add(cardfield);
        }
        {
            JLabel pin = new JLabel("Pin: ");
            pin.setBounds(100, 190, 50, 30);
            pin.setFont(new Font("Raleway", Font.BOLD, 20));
            add(pin);

            pinfield = new JPasswordField();
            pinfield.setBounds(200,190,200,30);
            add(pinfield);
        }
        {
            login = new JButton("SIGNIN");
            login.setBounds(200,250,80,30);
            login.setBackground(Color.black);
            login.setForeground(Color.white);
            login.addActionListener(this);
            add(login);
        }
        {
            clear = new JButton("CLEAR");
            clear.setBounds(320,250,80,30);
            clear.setBackground(Color.black);
            clear.setForeground(Color.white);
            clear.addActionListener(this);
            add(clear);
        }
        {
            signup = new JButton("SIGNUP");
            signup.setBounds(200,300,200,30);
            signup.setBackground(Color.black);
            signup.setForeground(Color.white);
            signup.addActionListener(this);
            add(signup);
        }
        {
            setLayout(null);
            setSize(800, 480);
            setVisible(true);
            setLocationRelativeTo(null);
            getContentPane().setBackground(Color.white);
            setTitle("AUTOMATED TELLER MACHINE");
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear){
            cardfield.setText("");
            pinfield.setText("");
        } else if (e.getSource() == login) {
            conn c = new conn();
            String cardno = cardfield.getText();
            String pinno =pinfield.getText();
            String query = "(SELECT * FROM login WHERE cardnumber = '"+cardno+"' AND pin = '"+pinno+"');";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new transaction(pinno).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect Details");
                }
            }catch (Exception e4){
                System.out.println(e4);
            }
        } else if (e.getSource() == signup) {
            setVisible(false);
            new Signupone().setVisible(true);
            
        }
    }
}
