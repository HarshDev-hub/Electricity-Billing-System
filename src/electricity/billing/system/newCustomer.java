package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class newCustomer extends JFrame implements ActionListener {

     // to daclare globaly;
     JLabel heading,meternumText,customerName,meterNum, addres, city, state, email, phone;
     TextField nameText, addresText, cityText, stateText, emailText, phoneText;
     JButton nextButton, cancelButton;


    newCustomer(){

        // to set the title
        super("New Customer");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        /* set the background of panel */
        panel.setBackground(new Color(0x22CCA403, true));
        add(panel);

         heading = new JLabel("New Customer");
        heading.setBounds(180, 10, 250, 20);
        heading.setFont(new Font("Tahomo", Font.BOLD, 15));
        panel.add(heading);


        customerName = new JLabel("New Customer");
        customerName.setBounds(50, 80, 100, 20);
        panel.add(customerName);

        nameText = new TextField();
        nameText.setBounds(180, 80, 150, 20);
        panel.add(nameText);


        meterNum = new JLabel("Meter Number");
        meterNum.setBounds(50, 120, 100, 20);
        panel.add(meterNum);

        meternumText = new JLabel("");
        meternumText.setBounds(180, 120, 150, 20);
        panel.add(meternumText);

        // to create random num for meter
        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        meternumText .setText(""+ Math.abs(number) );


        addres = new JLabel("Addres ");
        addres.setBounds(50, 160, 100, 20);
        panel.add(addres);

        addresText = new TextField();
        addresText.setBounds(180, 160, 150, 20);
        panel.add(addresText);


        city = new JLabel("City ");
        city.setBounds(50, 200, 100, 20);
        panel.add(city);

        cityText = new TextField();
        cityText.setBounds(180, 200, 150, 20);
        panel.add(cityText);


        state = new JLabel("State ");
        state.setBounds(50, 240, 100, 20);
        panel.add(state);

        stateText = new TextField();
        stateText.setBounds(180, 240, 150, 20);
        panel.add(stateText);

        email = new JLabel("Email ");
        email.setBounds(50, 280, 100, 20);
        panel.add(email);

        emailText = new TextField();
        emailText.setBounds(180, 280, 150, 20);
        panel.add(emailText);


        phone = new JLabel("Phone ");
        phone.setBounds(50, 320, 100, 20);
        panel.add(phone);

        phoneText = new TextField();
        phoneText.setBounds(180, 320, 150, 20);
        panel.add(phoneText);


        nextButton  = new JButton("Next");
        nextButton.setBounds(90, 380, 100, 25);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.white); /* to chane the button text color */
        nextButton.addActionListener(this);
        panel.add(nextButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(220, 380, 100, 25);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.white); /* to chane the button text color */
        cancelButton.addActionListener(this);
        panel.add(cancelButton);







        setLayout(new BorderLayout());
        add(panel, "Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image i2 = i1.getImage().getScaledInstance(230, 200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imgLabel = new JLabel(i3);
        add(imgLabel, "West");

        // size of the frame
        setSize(700, 500);
        setLocation(400, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==nextButton){

            String sname = nameText.getText();
            String smeter = meternumText.getText();
            String saddress = addresText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String eemail = emailText.getText();
            String sphone = phoneText.getText();


            String query_customer = "insert into new_customer values('"+sname+"', '"+smeter+"', '"+saddress+"', '"+scity+"', '"+sstate+"', '"+eemail+"', '"+sphone+"')";
            String query_signup = "insert into Signup values('"+smeter+"', '', '"+sname+"', '', '')";

            try{
                database c = new database();
                c.statement.executeUpdate(query_customer);
                c.statement.executeUpdate(query_signup);

                JOptionPane.showMessageDialog(null, "Customer details added successfully");
                setVisible(false);
                new meterInfo(smeter);
            }catch (Exception E){
                E.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
       new  newCustomer();
    }
}
