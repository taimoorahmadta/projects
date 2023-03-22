package bmsys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transaction extends JFrame implements ActionListener {
    JButton depositJButton, fastcashJButton, pinchangeJButton, withdrawlJButton, ministatementJButton, balanceenquiryJButton, exitJButton;

    String pinno;
    transaction(String pinno){
        JLabel image;
        this.pinno = pinno;

        {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            image = new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);
        }

        {
            JLabel text = new JLabel("Please select transaction:");
            text.setBounds(235,300,700,35);
            text.setFont(new Font("Raleway",Font.BOLD,16));
            text.setForeground(Color.WHITE);
            image.add(text);
        }

        {
            depositJButton = new JButton("Deposit");
            depositJButton.setBounds(170,415,150,30);
            depositJButton.addActionListener(this);
            image.add(depositJButton);
        }

        {
            fastcashJButton = new JButton("Fast Cash");
            fastcashJButton.setBounds(170,450,150,30);
            fastcashJButton.addActionListener(this);
            image.add(fastcashJButton);
        }

        {
            pinchangeJButton = new JButton("Pin Change");
            pinchangeJButton.setBounds(170,485,150,30);
            pinchangeJButton.addActionListener(this);
            image.add(pinchangeJButton);
        }
// second column
        {
            withdrawlJButton = new JButton("Withdraw");
            withdrawlJButton.setBounds(350,415,150,30);
            withdrawlJButton.addActionListener(this);
            image.add(withdrawlJButton);
        }

        {
            ministatementJButton = new JButton("Mini Statement");
            ministatementJButton.setBounds(350,450,150,30);
            ministatementJButton.addActionListener(this);
            image.add(ministatementJButton);
        }

        {
            balanceenquiryJButton = new JButton("Balance Enquiry");
            balanceenquiryJButton.setBounds(350,485,150,30);
            balanceenquiryJButton.addActionListener(this);
            image.add(balanceenquiryJButton);
        }

        {
            exitJButton = new JButton("Exit");
            exitJButton.setBounds(350,520,150,30);
            exitJButton.addActionListener(this);
            image.add(exitJButton);
        }

        //end
        {
            setTitle("Transaction");
            setLayout(null);
            setSize(900,900);
            getContentPane().setBackground(Color.white);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitJButton){
            System.exit(0);
        } else if (e.getSource() == depositJButton) {
            setVisible(false);
            new deposit(pinno).setVisible(true);
        } else if (e.getSource() == withdrawlJButton) {
            setVisible(false);
            new withdraw(pinno).setVisible(true);
        } else if (e.getSource() == fastcashJButton) {
            setVisible(false);
            new fastcash(pinno).setVisible(true);
        }

    }
    public static void main(String[] args) {
        new transaction("");
    }
}
