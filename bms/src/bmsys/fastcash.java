package bmsys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*import java.sql.Date;*/
import java.sql.ResultSet;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener {
    JButton cash100JButton, cash500JButton, cash1000JButton, cash5000JButton, cash8000JButton, cash10000JButton, exitJButton;

    String pinno;
    fastcash(String pinno){
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
            JLabel text = new JLabel("Select cash withdrawl amount:");
            text.setBounds(235,300,700,35);
            text.setFont(new Font("Raleway",Font.BOLD,16));
            text.setForeground(Color.WHITE);
            image.add(text);
        }

        {
            cash100JButton = new JButton("Rs 100");
            cash100JButton.setBounds(170,415,150,30);
            cash100JButton.addActionListener(this);
            image.add(cash100JButton);
        }

        {
            cash500JButton = new JButton("Rs 500");
            cash500JButton.setBounds(170,450,150,30);
            cash500JButton.addActionListener(this);
            image.add(cash500JButton);
        }

        {
            cash1000JButton = new JButton("Rs 1000");
            cash1000JButton.setBounds(170,485,150,30);
            cash1000JButton.addActionListener(this);
            image.add(cash1000JButton);
        }
// second column
        {
            cash5000JButton = new JButton("Rs 5000");
            cash5000JButton.setBounds(350,415,150,30);
            cash5000JButton.addActionListener(this);
            image.add(cash5000JButton);
        }

        {
            cash8000JButton = new JButton("Rs 8000");
            cash8000JButton.setBounds(350,450,150,30);
            cash8000JButton.addActionListener(this);
            image.add(cash8000JButton);
        }

        {
            cash10000JButton = new JButton("Rs 10000");
            cash10000JButton.setBounds(350,485,150,30);
            cash10000JButton.addActionListener(this);
            image.add(cash10000JButton);
        }

        {
            exitJButton = new JButton("Back");
            exitJButton.setBounds(350,520,150,30);
            exitJButton.addActionListener(this);
            image.add(exitJButton);
        }

        //end
        {
            setTitle("FastCash");
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
            setVisible(false);
            new transaction(pinno).setVisible(true);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(3);
            conn c = new conn();
            //here
            try {
                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinno+"';");
                int balance =0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance = balance + Integer.parseInt(rs.getString("amount"));
                    }else if((rs.getString("type").equals("Withdraw"))) {
                        balance = balance - Integer.parseInt(rs.getString("amount"));
                    }
                }

                if ((Integer.parseInt(amount)) > balance && e.getSource()!=exitJButton){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                }else{
                        Date date = new Date();
                        String query = "INSERT INTO bank VALUES('"+pinno+"','"+date+"','Withdraw','"+amount+"');";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Debited Successfully "+ amount);
                        balance = balance - Integer.parseInt(rs.getString("amount"));
                        setVisible(false);
                        new transaction(pinno).setVisible(true);
                }
            }catch (Exception e6){
                System.out.println(e6);
            }
        }
    }
    public static void main(String[] args) {
        new fastcash("");
    }
}
