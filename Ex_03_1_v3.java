import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex_03_1_v3 extends JFrame {
    public static void main(String[] args) {
       new Ex_03_1_v3();
    }

   public Ex_03_1_v3() {
       setSize(500, 500);
       setTitle("Software Development II");
       setDefaultCloseOperation(EXIT_ON_CLOSE);

       MyJPanel panel= new MyJPanel();
       Container c = getContentPane();
       c.add(panel);
       setVisible(true);
   }

    public class MyJPanel extends JPanel implements ActionListener {
       Dimension  dim;
       JLabel     labelA, labelB, labelC;
       JTextField fieldA, fieldB, fieldC;
       JButton drawButton;
       String a = "", b = "", c = "";
       int        originX, originY;
       Font romanItalic = new Font("Times New Roman", Font.ITALIC, 16);
       Font romanPlain =  new Font("Times New Roman", Font.PLAIN, 16);

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

           drawButton = new JButton("描く");
           drawButton.addActionListener(this);

           add(labelA);
           add(fieldA);
           add(labelB);
           add(fieldB);
           add(labelC);
           add(fieldC);
           add(drawButton);
        }

        public void paintComponent(Graphics g) {
           dim = getSize();
           super.paintComponent(g);

           originX = dim.width / 2;
           originY = dim.height / 2;

           g.setColor(new Color(128, 128, 128));
           g.setFont(romanItalic);
           g.drawLine(0, originY, dim.width, originY);   // x軸
           g.drawLine(originX, 0, originX, dim.height);  // y軸
           g.drawString("x", dim.width-15, originY+15);
           g.drawString("y", originX+10, 45);
           g.drawString("O", originX-12, originY+15);
        }

        public void actionPerformed(ActionEvent e) {
           // ボタンをクリックした時の処理
           a = fieldA.getText();
           b = fieldB.getText();
           c = fieldC.getText();
           repaint();
        }
   }
}