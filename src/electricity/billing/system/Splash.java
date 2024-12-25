package electricity.billing.system;

import javax.swing.*;
import java.awt.*;


public class Splash extends JFrame {

    Splash(){
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash.jpg"));// that is the process of get image
        Image imageOne = imageIcon.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(imageOne);
        JLabel imageLabel = new JLabel(imageIcon2);
        add(imageLabel);

        setSize(600, 400); // it is value of jFrame
        setLocation(500, 200);
        setVisible(true); /* it is normally not visible thats why we use setVisile() always write all the code to upper to see things */


        try {
            Thread.sleep(3000);
            setVisible(false);

            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

         new Splash();
    }
}
