import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz_03_1 extends JFrame {
   public static void main(String[] args) {
       new Quiz_03_1();
   }

   public Quiz_03_1() {
       setSize(300, 200);
       setTitle("Quiz");
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
           label1 = new JLabel("ラベル1");
           field1 = new JTextField("フィールド1", 15);

           label2 = new JLabel("ラベル2");
           field2 = new JTextField("フィールド2", 20);

           add(field1);
           add(label1);
           add(field2);
           add(label2);
       }
   }
}