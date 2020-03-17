import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample_07_1 extends JFrame {
    public static void main(String[] args){
        new Sample_07_1();
    }

    public Sample_07_1() {
        Dimension dimOfScreen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimOfScreen.width/2 - 400, dimOfScreen.height/2 - 250, 800, 500);
        setResizable(false);
        setTitle("Software Development II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
        c.add(panel);
        setVisible(true);
    }

    public class MyJPanel extends JPanel {
        public MyJPanel() {
            /* コンストラクタ */
        }
    }
}
