package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
/* that is use to click action on the button */
import java.awt.event.*;
import java.sql.ResultSet;

public class Signup extends JFrame implements ActionListener {

    Choice loginAsCho;

    TextField meterText,EmployerText,userNameText, nameText, passwordText;

    JButton create,back;

   Signup(){
     super("Signup Page");
     getContentPane().setBackground(new Color(168, 203, 255));

     JLabel createAs = new JLabel("Create Account As");
     createAs.setBounds(20, 50, 125, 20);
     add(createAs);


     // to make choice option
     loginAsCho = new Choice();
     loginAsCho.add("Admin");
     loginAsCho.add("Customer");
     loginAsCho.setBounds(170, 50, 120, 20);
     add(loginAsCho);

     // to create text
     JLabel meterNo = new JLabel("Meter Number");
     meterNo.setBounds(30, 100, 120, 20);
     meterNo.setVisible(false);
     add(meterNo);


     //to create text box
     meterText = new TextField();
     meterText.setBounds(170,100, 125, 20);
     meterText.setVisible(false);
     add(meterText);

       JLabel Employer = new JLabel("Employer ID");
       Employer.setBounds(30, 100, 120, 20);
        Employer.setVisible(true);
       add(Employer);


       EmployerText = new TextField();
       EmployerText.setBounds(170,100, 125, 20);
       EmployerText.setVisible(true);
       add(EmployerText);


       JLabel userName = new JLabel("User Name");
       userName.setBounds(30, 140, 125, 20);
       add(userName);

       userNameText = new TextField();
       userNameText.setBounds(170, 140, 125, 20);
       add(userNameText);

       JLabel name = new JLabel("Name");
       name.setBounds(30, 180, 125, 20);
       add(name);

       nameText = new TextField("");
       nameText.setBounds(170, 180, 125, 20);;
       add(nameText);

       /* to get the name in the database using focusListener */
       meterText.addFocusListener(new FocusListener() {
           @Override
           public void focusGained(FocusEvent e) {

           }

           @Override
           public void focusLost(FocusEvent e) {

               try{
                   database c = new database();
                   ResultSet resultSet = c.statement.executeQuery("select * from Signup where meter_no= '"+meterText.getText()+"'");
                   if(resultSet.next()){
                       nameText.setText(resultSet.getString("name"));
                   }
               }catch (Exception E){
                   E.printStackTrace();;
               }
           }
       });



       JLabel password = new JLabel("Password");
       password.setBounds(30, 220, 125, 20);
       add(password);

       passwordText = new TextField();
       passwordText.setBounds(170, 220, 125, 20);
       add(passwordText);

       loginAsCho.addItemListener(new ItemListener() {
           @Override
           public void itemStateChanged(ItemEvent e) {
               // it is use to know what user selected
               String user = loginAsCho.getSelectedItem();
               if(user.equals("Customer")){
                   Employer.setVisible(false);
                   /* that is use to not edit name in the table */
                   nameText.setEditable(false);
                   EmployerText.setVisible(false);
                   meterNo.setVisible(true);
                   meterText.setVisible(true);
               } else {
                   Employer.setVisible(true);
                   EmployerText.setVisible(true);
                   meterNo.setVisible(false);
                   meterText.setVisible(false);
               }


           }
       });

       create = new JButton("Create");
       // to add the text bg color
       create.setBackground(new Color(66, 127, 219));
       // to add the text color;
       create.setForeground(Color.BLACK);
       create.setBounds(50, 285, 100, 25);
       create.addActionListener(this);
       add(create);

       back = new JButton("Back");
       back.setBackground(new Color(66, 127, 219));
       back.setForeground(Color.BLACK);
       back.setBounds(180, 285, 100, 25);
       back.addActionListener(this);
       add(back);

       ImageIcon boyIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/boy.png"));
       Image BoyIng = boyIcon.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
       ImageIcon boyIcon2 = new ImageIcon(BoyIng);
       JLabel boyLabel = new JLabel(boyIcon2);
       boyLabel.setBounds(320,30, 250, 250);
       add(boyLabel);


       setSize(600, 380);
       setLocation(500, 200);
       setLayout(null);
       setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
         // e tell us what the user choose
         if(e.getSource() == create)  {
             String sloginAs = loginAsCho.getSelectedItem(); /* this all 4 thing is work in dataBase Firstly we make table in sql then we paas the in getSource */
             String susername = userNameText.getText();
             String sname = nameText.getText();
             String spassword = passwordText.getText();
             String smeter = meterText.getText();

             try{

                // connect the database using method
                database c = new database();
                String query = null;
                if(loginAsCho.equals("Admin")) {
                    query = "insert into Signup value('" + smeter + "','" + susername + "', '" + sname + "', '" + spassword + "', '" + sloginAs + "')";
                }else {
                    query = "update Signup set username = '"+susername+"', password = '"+spassword+"', usertype = '"+sloginAs+"' where meter_no = '"+smeter+"'";
                }
                // to execute our query using executeUpdate
                c.statement.executeUpdate(query);

                // To print the message when user create account using JOptionPane
                JOptionPane.showMessageDialog(null, "Account Created");
                setVisible(false);
                new Login();

             }catch (Exception E){
                 E.printStackTrace();
             }
        } else if (e.getSource()== back){
             setVisible(false);
             // redirect login page
             new Login();
         }

    }

    public static void main(String[] args) {
        new Signup();
    }
}
