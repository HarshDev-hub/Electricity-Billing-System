package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    JTextField userText,passwordText;
    Choice loginChoice;

    JButton loginButton,cancelButton,signButton;

    Login(){
        super("Login");/* super is always write 1st in constructor it is rule in java */
        JLabel username = new JLabel("UserName");
       username.setBounds(300, 60, 100, 20);
        add(username);

        userText = new JTextField();
        userText.setBounds(400, 60, 150, 20);
        add(userText);

        JLabel password = new JLabel("Password");
        password.setBounds(300, 40, 100, 120);
        add(password);

        passwordText = new JTextField();
        passwordText.setBounds(400, 90, 150, 20);
        add(passwordText);


        JLabel loggin = new JLabel("Loggin In As");
        loggin.setBounds(300, 68, 100, 120);
        add(loggin);

        loginChoice = new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400, 120, 150, 20);
        add(loginChoice);

        loginButton = new JButton("Login");
        loginButton.setBounds(330, 180, 100, 20);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(450, 180, 100, 20);
        add(cancelButton);

        signButton = new JButton("Signup");
        signButton.setBounds(400, 230, 100, 20);
        add(signButton);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));

        setSize(640, 300);
        setLocation(400, 200);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }
}
