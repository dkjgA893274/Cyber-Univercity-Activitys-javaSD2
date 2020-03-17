import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample_03_2 extends JFrame {
    public static void main(String[] args) {
        new Sample_03_2();
    }

    public Sample_03_2() {
        setSize(400, 300);
        setTitle("Software Development II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
        c.add(panel);
        setVisible(true);
    }

public class MyJPanel extends JPanel {
   JLabel label1, label2;
   JTextField field1, field2;

   public MyJPanel() {
       label1 = new JLabel("テキストフィールド1");
       field1 = new JTextField("ソフトウェア開発論II", 20);
       String str = field1.getText();

       label2 = new JLabel("テキストフィールド2");
       field2 = new JTextField(str, 15);

       add(label1);
       add(field1);
       add(label2);
       add(field2);
   }
}
}
