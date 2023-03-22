package bmsys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class signupthree extends JFrame implements ActionListener {
    JRadioButton savingaccRadioButton, fixedaccRadioButton, currentaccRadioButton, recurringaccRadioButton;
    JCheckBox atmcardCheckBox, internetbankingCheckBox, mobilebankingCheckBox, emailsmsalertCheckBox,checkbookCheckBox,estatementCheckBox,declarationCheckBox;
    JButton submitbutton, canclebutton;
    String formno;
    signupthree(String formno){
        this.formno = formno;
        {
            JLabel accountdetailsLable  = new JLabel("Page 3: Account Details");
            accountdetailsLable.setBounds(290,60,400,30);
            accountdetailsLable.setFont(new Font("Raleway", Font.BOLD, 22));
            add(accountdetailsLable);
        }

        {
            JLabel accounttypeLable = new JLabel("Account Type");
            accounttypeLable.setBounds(100,140,200,30);
            accounttypeLable.setFont(new Font("Raleway", Font.BOLD, 20));
            add(accounttypeLable);

            savingaccRadioButton = new JRadioButton("Saving Account");
            savingaccRadioButton.setBounds(100,170,180,30);
            savingaccRadioButton.setBackground(Color.white);
            add(savingaccRadioButton);

            fixedaccRadioButton = new JRadioButton("Fixed Deposit Account");
            fixedaccRadioButton.setBounds(300,170,180,30);
            fixedaccRadioButton.setBackground(Color.white);
            add(fixedaccRadioButton);

            currentaccRadioButton = new JRadioButton("Current Account");
            currentaccRadioButton.setBounds(100,200,180,30);
            currentaccRadioButton.setBackground(Color.white);
            add(currentaccRadioButton);

            recurringaccRadioButton = new JRadioButton("Recurring Deposit Account");
            recurringaccRadioButton.setBounds(300,200,180,30);
            recurringaccRadioButton.setBackground(Color.white);
            add(recurringaccRadioButton);

            ButtonGroup acctypeButtonGroup = new ButtonGroup();
            acctypeButtonGroup.add(savingaccRadioButton);
            acctypeButtonGroup.add(fixedaccRadioButton);
            acctypeButtonGroup.add(currentaccRadioButton);
            acctypeButtonGroup.add(recurringaccRadioButton);
        }

        {
            JLabel cardnoLable = new JLabel("Card Number");
            cardnoLable.setBounds(100,250,200,30);
            cardnoLable.setFont(new Font("Raleway", Font.BOLD, 20));
            add(cardnoLable);

            JLabel cardnosmallLable = new JLabel("XXXX-XXXX-XXXX-XXXX");
            cardnosmallLable.setBounds(100,270,200,30);
            cardnosmallLable.setFont(new Font("Raleway", Font.BOLD, 10));
            add(cardnosmallLable);

        }
        {
            JLabel pinLable = new JLabel("PIN");
            pinLable.setBounds(100,320,200,30);
            pinLable.setFont(new Font("Raleway", Font.BOLD, 20));
            add(pinLable);

            JLabel pinsmallLable = new JLabel("XXXX");
            pinsmallLable.setBounds(100,340,200,30);
            pinsmallLable.setFont(new Font("Raleway", Font.BOLD, 10));
            add(pinsmallLable);
        }
        {
            JLabel servicesrequiredLable = new JLabel("Services Required:");
            servicesrequiredLable.setBounds(100,390,200,30);
            servicesrequiredLable.setFont(new Font("Raleway", Font.BOLD, 20));
            add(servicesrequiredLable);

            atmcardCheckBox = new JCheckBox("ATM Card");
            atmcardCheckBox.setBounds(100,420,180,30);
            atmcardCheckBox.setBackground(Color.white);
            add(atmcardCheckBox);

            internetbankingCheckBox = new JCheckBox("Internet Banking");
            internetbankingCheckBox.setBounds(300,420,180,30);
            internetbankingCheckBox.setBackground(Color.white);
            add(internetbankingCheckBox);

            mobilebankingCheckBox = new JCheckBox("Mobile Banking");
            mobilebankingCheckBox.setBounds(100,450,180,30);
            mobilebankingCheckBox.setBackground(Color.white);
            add(mobilebankingCheckBox);

            emailsmsalertCheckBox = new JCheckBox("Email and SMS alert");
            emailsmsalertCheckBox.setBounds(300,450,180,30);
            emailsmsalertCheckBox.setBackground(Color.white);
            add(emailsmsalertCheckBox);

            checkbookCheckBox = new JCheckBox("Cheque Book");
            checkbookCheckBox.setBounds(100,480,180,30);
            checkbookCheckBox.setBackground(Color.white);
            add(checkbookCheckBox);

            estatementCheckBox = new JCheckBox("E-statement");
            estatementCheckBox.setBounds(300,480,180,30);
            estatementCheckBox.setBackground(Color.white);
            add(estatementCheckBox);
        }

        {
            declarationCheckBox = new JCheckBox("I hareby declare the all given information is true");
            declarationCheckBox.setBackground(Color.white);
            declarationCheckBox.setFont(new Font("Raleway",Font.BOLD,14));
            declarationCheckBox.setBounds(100,560,400,30);
            add(declarationCheckBox);
        }

        {
            submitbutton = new JButton("Submit");
            submitbutton.setBackground(Color.black);
            submitbutton.setForeground(Color.WHITE);
            submitbutton.setBounds(200,600,80,40);
            submitbutton.addActionListener(this);
            add(submitbutton);

            canclebutton = new JButton("Cancle");
            canclebutton.setBackground(Color.black);
            canclebutton.setForeground(Color.WHITE);
            canclebutton.addActionListener(this);
            canclebutton.setBounds(300,600,80,40);
            add(canclebutton);

        }
        {
            setTitle("Page 3: Account Details");
            setSize(850,820);
            setLayout(null);
            setLocationRelativeTo(null);
            setVisible(true);
            getContentPane().setBackground(Color.white);
        }
    }
    public static void main(String[] args) {
        new signupthree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitbutton){
            String accounttype = null;
            if (savingaccRadioButton.isSelected()){
                accounttype = "Saving Account";
            } else if (fixedaccRadioButton.isSelected()) {
                accounttype = "Fixed Deposit Account";
            } else if (currentaccRadioButton.isSelected()) {
                accounttype = "Current Account";
            } else if (recurringaccRadioButton.isSelected()) {
                accounttype = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs(random.nextLong() % 90000000L + 5040936000000000L);

            String pinnumber = "" + Math.abs(random.nextLong() % 9000L + 1000L);

            String service ="";
            if (atmcardCheckBox.isSelected()){
                service = service +" ATM Card";
            }
            if (mobilebankingCheckBox.isSelected()) {
                service = service +" Internet Banking";
            }
            if (emailsmsalertCheckBox.isSelected()) {
                service = service +" Mobile Banking";
            }
            if (checkbookCheckBox.isSelected()) {
                service = service +" Email and SMS alert";
            }
            if (estatementCheckBox.isSelected()) {
                service = service +" Cheque Book";
            }
            if (declarationCheckBox.isSelected()) {
                service = service +" E-statement";
            }

            try {
                conn c = new conn();
                String qurey = "INSERT INTO signupthree VALUES('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+service+"');";
                String qurey2 = "INSERT INTO login VALUES('"+formno+"','"+cardnumber+"','"+pinnumber+"');";

                c.s.executeUpdate(qurey);
                c.s.executeUpdate(qurey2);

                JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+ "\n Pin:" + pinnumber);
                setVisible(false);
                new deposit(pinnumber).setVisible(true);
            }catch (Exception e3){
                System.out.println(e3);
            }

        } else if (e.getSource() == canclebutton) {
            setVisible(false);
            new Login().setVisible(true);
        }

    }
}
