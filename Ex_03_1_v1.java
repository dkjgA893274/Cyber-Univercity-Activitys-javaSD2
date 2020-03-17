import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex_03_1 extends JFrame {
    public static void main(String[] args) {
       new Ex_03_1();
   }

   public Ex_03_1() {
       setSize(500, 500);
       setTitle("Software Development II");
       setDefaultCloseOperation(EXIT_ON_CLOSE);

       MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
       c.add(panel);
        setVisible(true);
   }

    public class MyJPanel extends JPanel
                                  implements ActionListener {
       JLabel     labelA, labelB, labelC;
       JTextField fieldA, fieldB, fieldC;
       Font romanItalic =
                new Font("Times New Roman", Font.ITALIC, 16);
       Font romanPlain =
                new Font("Times New Roman", Font.PLAIN, 16);

        public MyJPanel() {
           labelA = new JLabel("a");
           labelA.setFont(romanItalic);
           fieldA = new JTextField("1.0", 4);
           fieldA.setFont(romanPlain);

           labelB = new JLabel("b");
           labelB.setFont(romanItalic);
           fieldB = new JTextField("0.0", 4);
           fieldB.setFont(romanPlain);

           labelC = new JLabel("c");
           labelC.setFont(romanItalic);
           fieldC = new JTextField("0.0", 4);
           fieldC.setFont(romanPlain);

           add(labelA);
           add(fieldA);
           add(labelB);
           add(fieldB);
           add(labelC);
           add(fieldC);
       }

        public void paintComponent(Graphics g) {
           // グラフの描画
       }

       public void actionPerformed(ActionEvent e) {
           // ボタンをクリックした時の処理
        }
   }
}