package bmsys;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import  com.toedter.calendar.*;
import java.awt.event.*;


public class Signuptwo extends JFrame implements ActionListener{
    JTextField pamTextField,adharTextField;
    JComboBox religion, catagory, income, education, occupation;
    JButton next;
    JRadioButton eyes,eno,syes,sno;
    String formno;

    Signuptwo(String formno){
        this.formno = formno;

        {
            JLabel additionaldetails = new JLabel("Page 2: Additional Details");
            additionaldetails.setBounds(290,60,400,30);
            additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
            add(additionaldetails);
        }
        {
            JLabel religionTextLable = new JLabel("Religion:");
            religionTextLable.setBounds(100,140,100,30);
            religionTextLable.setFont(new Font("Raleway", Font.BOLD, 20));
            add(religionTextLable);

            String[] valreligion = {"Hindu", "Muslim", "Sikh", "Christian","Other"};
            religion = new JComboBox<>(valreligion);
            religion.setBounds(300,140,200,30);
            religion.setBackground(Color.white);
            add(religion);

        }
        {
            JLabel catagoryTextLable = new JLabel("Catagory:");
            catagoryTextLable.setBounds(100,190,200,30);
            catagoryTextLable.setFont(new Font("Raleway", Font.BOLD, 20));
            add(catagoryTextLable);

            String[] valcatagory = {"General","OBC", "BC", "ST", "Other"};
            catagory = new JComboBox<>(valcatagory);
            catagory.setBounds(300,190,200,30);
            add(catagory);

        }
        //here
        {
            JLabel incomeTextLable = new JLabel("Income:");
            incomeTextLable.setBounds(100,240,200,30);
            incomeTextLable.setFont(new Font("Raleway", Font.BOLD, 20));
            add(incomeTextLable);

            String[] valincome = {"Null","<1 LAC", "<3 LAC", "<4 LAC", "Other"};
            income = new JComboBox<>(valincome);
            income.setBounds(300,240,200,30);
            add(income);

        }
        {
            JLabel educationTextLable = new JLabel("Education:");
            educationTextLable.setBounds(100,290,200,30);
            educationTextLable.setFont(new Font("Raleway", Font.BOLD, 20));
            add(educationTextLable);

            String[] valeducation ={"Matric","Inter","Bachulers","Masters", "PHD","Others"};
            education = new JComboBox<>(valeducation);
            education.setBounds(300,290,200,30);
            add(education);

        }

        {
            JLabel occupationTextLable = new JLabel("Occupation");
            occupationTextLable.setBounds(100,390,200,30);
            occupationTextLable.setFont(new Font("Raleway", Font.BOLD, 20));
            add(occupationTextLable);

            String[] valoccupation ={"Govt. Job","Private Job","Self Paid","Business","Retired", "Student"};
            occupation = new JComboBox<>(valoccupation);
            occupation.setBounds(300,390,200,30);
            add(occupation);
        }
        {
            JLabel pamTextLable = new JLabel("PAM No:");
            pamTextLable.setBounds(100,440,200,30);
            pamTextLable.setFont(new Font("Raleway", Font.BOLD, 20));
            add(pamTextLable);

            pamTextField = new JTextField();
            pamTextField.setFont(new Font("Raleway",Font.BOLD,14));
            pamTextField.setBounds(300,440,200,30);
            add(pamTextField);
        }
        {
            JLabel adharTextLable = new JLabel("Adhar No:");
            adharTextLable.setBounds(100,490,200,30);
            adharTextLable.setFont(new Font("Raleway", Font.BOLD, 20));
            add(adharTextLable);

            adharTextField = new JTextField();
            adharTextField.setFont(new Font("Raleway",Font.BOLD,14));
            adharTextField.setBounds(300,490,200,30);
            add(adharTextField);
        }
        {
            JLabel seniorTextLable = new JLabel("Senior Citizen:");
            seniorTextLable.setBounds(100,540,200,30);
            seniorTextLable.setFont(new Font("Raleway", Font.BOLD, 20));
            add(seniorTextLable);

            syes = new JRadioButton("YES");
            sno = new JRadioButton("NO");
            syes.setBounds(300,540,90,30);
            syes.setBackground(Color.WHITE);
            add(syes);
            sno.setBounds(400,540,90,30);
            sno.setBackground(Color.WHITE);
            add(sno);

            ButtonGroup seniorgroup = new ButtonGroup();
            seniorgroup.add(syes);
            seniorgroup.add(sno);

        }
        {
            JLabel existTextLable = new JLabel("Existing account:");
            existTextLable.setBounds(100,590,200,30);
            existTextLable.setFont(new Font("Raleway", Font.BOLD, 20));
            add(existTextLable);

            eyes = new JRadioButton("YES");
            eno = new JRadioButton("NO");
            eyes.setBounds(300,590,90,30);
            eyes.setBackground(Color.WHITE);
            add(eyes);
            eno.setBounds(400,590,90,30);
            eno.setBackground(Color.WHITE);
            add(eno);

            ButtonGroup existgroup = new ButtonGroup();
            existgroup.add(eyes);
            existgroup.add(eno);
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
            setTitle("Page 2: Additional Details");
            setLayout(null);
            setSize(800,800);
            setLocationRelativeTo(null);
            setVisible(true);
            getContentPane().setBackground(Color.white);
        }
    }
    public static void main(String[] args) {
        new Signuptwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sreligion = (String) religion.getSelectedItem();
        String scatagory = (String) catagory.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String spamno = pamTextField.getText();
        String sadhar = adharTextField.getText();

        String ssenior = null;
        if (syes.isSelected()){
            ssenior = "YES";
        }else {
            ssenior = "NO";
        }

        String eexisting = null;
        if (eyes.isSelected()){
            eexisting = "YES";
        }else {
            eexisting = "NO";
        }
        try{
            conn c = new conn();
            String query = "INSERT INTO signuptwo VALUES('"+formno+"','"+sreligion+"','"+scatagory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+spamno+"','"+sadhar+"','"+ssenior+"','"+eexisting+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new signupthree(formno).setVisible(true);

        }catch (Exception e2){
            System.out.println(e2);
        }

    }

/*    @Override
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
            //sadjfksdjf
        }catch (Exception e1){
            System.out.println(e1);
        }
    }*/
}
