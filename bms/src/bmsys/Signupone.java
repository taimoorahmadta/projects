package bmsys;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import  com.toedter.calendar.*;
import java.awt.event.*;


public class Signupone extends JFrame implements ActionListener{
    int random;
    JTextField nametextfield, fathernamefield, emailfield, adressfield, cityfield, statefield, pinfield;
    JButton next;
    JRadioButton male,femail,married,unmarried;
    JDateChooser datechooser;
    ButtonGroup gendergroup,maritalgroup;
    Signupone(){

        {
            Random ran = new Random();
            random = Math.abs(ran.nextInt());
            JLabel formno = new JLabel("Form No: " +  random);
            formno.setFont(new Font("Raleway",Font.BOLD,38));
            formno.setBounds(200,10,600,40);
            add(formno);
        }
        {
            JLabel pname = new JLabel("Page 1: Personal Details");
            pname.setBounds(290,60,400,30);
            pname.setFont(new Font("Raleway", Font.BOLD, 22));
            add(pname);
        }
        {
            JLabel Name = new JLabel("Name:");
            Name.setBounds(100,140,100,30);
            Name.setFont(new Font("Raleway", Font.BOLD, 20));
            add(Name);

            nametextfield = new JTextField();
            nametextfield.setFont(new Font("Raleway",Font.BOLD,14));
            nametextfield.setBounds(300,140,200,30);
            add(nametextfield);
        }
        {
            JLabel fathername = new JLabel("Father Name:");
            fathername.setBounds(100,190,200,30);
            fathername.setFont(new Font("Raleway", Font.BOLD, 20));
            add(fathername);

            fathernamefield = new JTextField();
            fathernamefield.setFont(new Font("Raleway",Font.BOLD,14));
            fathernamefield.setBounds(300,190,200,30);
            add(fathernamefield);
        }
        //here
        {
            JLabel dob = new JLabel("DOB:");
            dob.setBounds(100,240,200,30);
            dob.setFont(new Font("Raleway", Font.BOLD, 20));
            add(dob);

            datechooser = new JDateChooser();
            datechooser.setBounds(300,240,200,30);
            add(datechooser);
        }
        {
            JLabel gender = new JLabel("Gender:");
            gender.setBounds(100,290,200,30);
            gender.setFont(new Font("Raleway", Font.BOLD, 20));
            add(gender);

            male = new JRadioButton("Male");
            femail = new JRadioButton("Female");
            male.setBounds(300,290,90,30);
            male.setBackground(Color.WHITE);
            add(male);
            femail.setBounds(400,290,90,30);
            femail.setBackground(Color.WHITE);
            add(femail);

            gendergroup = new ButtonGroup();
            gendergroup.add(male);
            gendergroup.add(femail);
        }
        {
            JLabel email = new JLabel("Email");
            email.setBounds(100,340,200,30);
            email.setFont(new Font("Raleway", Font.BOLD, 20));
            add(email);

            emailfield = new JTextField();
            emailfield.setFont(new Font("Raleway",Font.BOLD,14));
            emailfield.setBounds(300,340,200,30);
            add(emailfield);
        }
        {
            JLabel maritalstatus = new JLabel("Marital Status");
            maritalstatus.setBounds(100,390,200,30);
            maritalstatus.setFont(new Font("Raleway", Font.BOLD, 20));
            add(maritalstatus);

            married = new JRadioButton("Married");
            unmarried = new JRadioButton("Unmarried");
            married.setBounds(300,390,90,30);
            married.setBackground(Color.WHITE);
            add(married);
            unmarried.setBounds(400,390,90,30);
            unmarried.setBackground(Color.WHITE);
            add(unmarried);

            maritalgroup = new ButtonGroup();
            maritalgroup.add(married);
            maritalgroup.add(unmarried);
        }
        {
            JLabel address = new JLabel("Address:");
            address.setBounds(100,440,200,30);
            address.setFont(new Font("Raleway", Font.BOLD, 20));
            add(address);

            adressfield = new JTextField();
            adressfield.setFont(new Font("Raleway",Font.BOLD,14));
            adressfield.setBounds(300,440,200,30);
            add(adressfield);
        }
        {
            JLabel city = new JLabel("City:");
            city.setBounds(100,490,200,30);
            city.setFont(new Font("Raleway", Font.BOLD, 20));
            add(city);

            cityfield = new JTextField();
            cityfield.setFont(new Font("Raleway",Font.BOLD,14));
            cityfield.setBounds(300,490,200,30);
            add(cityfield);
        }
        {
            JLabel state = new JLabel("State:");
            state.setBounds(100,540,200,30);
            state.setFont(new Font("Raleway", Font.BOLD, 20));
            add(state);

            statefield = new JTextField();
            statefield.setFont(new Font("Raleway",Font.BOLD,14));
            statefield.setBounds(300,540,200,30);
            add(statefield);
        }
        {
            JLabel pinCode = new JLabel("Pin Code:");
            pinCode.setBounds(100,590,200,30);
            pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
            add(pinCode);

            pinfield = new JTextField();
            pinfield.setFont(new Font("Raleway",Font.BOLD,14));
            pinfield.setBounds(300,590,200,30);
            add(pinfield);
        }
        {
            next = new JButton("next");
            next.setBounds(420,640,80,40);
            next.setBackground(Color.black);
            next.setForeground(Color.WHITE);
            next.addActionListener(this);
            add(next);
        }
        {
            setTitle("Page 1: Personal Details");
            setLayout(null);
            setSize(800,800);
            setLocationRelativeTo(null);
            setVisible(true);
            getContentPane().setBackground(Color.white);
        }
    }
    public static void main(String[] args) {
        new Signupone();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = "" + random;
        String name = nametextfield.getText();
        String fathername = fathernamefield.getText();
        String dob = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "male";
        } else if (femail.isSelected()) {
            gender = "female";
        }
        String email = emailfield.getText();

        String maritalstatus = null;
        if (married.isSelected()){
            maritalstatus = "married";
        } else if (unmarried.isSelected()) {
            maritalstatus = "unmarried";
        }

        String adress= adressfield.getText();
        String city= cityfield.getText();
        String state = statefield.getText();
        String pin = pinfield.getText();

        try{
            // some medatory inputs
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }
            if (email.equals("")){
                JOptionPane.showMessageDialog(null, "email is required");
            }
            if (pin.equals("")){
                JOptionPane.showMessageDialog(null, "pin is required");
            }
            //djfasdjfsad
            conn c = new conn();
            String query = "insert into signup values('"+formno+"','"+name+"','"+fathername+"','"+dob+"','"+gender+"','"+email+"','"+maritalstatus+"','"+adress+"','"+city+"','"+state+"','"+pin+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new Signuptwo(formno).setVisible(true);
            //sadjfksdjf
        }catch (Exception e1){
            System.out.println(e1);
        }
    }
}
