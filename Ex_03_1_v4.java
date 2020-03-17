import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex_03_1_v4 extends JFrame {
    public static void main(String[] args) {
       new Ex_03_1_v4();
    }

   public Ex_03_1_v4() {
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
       double a = 1.0, b = 0.0, c = 0.0;
       double s, x1, x2, y1, y2;
       int        originX, originY, xw1, xw2, yw1, yw2;
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

           g.setColor(new Color(255, 69, 0));
           s = 0.05;
           x1 = -1.0;
           y1 = func(x1);
           while (x1 <= 1.0) {
               x2 = x1 + s;
               y2 = func(x2);

               xw1 = (int)(originX*x1 + originX);
               yw1 = (int)(originY - originY*y1);
               xw2 = (int)(originX*x2 + originX);
               yw2 = (int)(originY - originY*y2);
               g.drawLine(xw1, yw1, xw2, yw2);

               x1 = x2;
               y1 = y2;
           }
        }

        public void actionPerformed(ActionEvent e) {// ボタンをクリックした時の処理
           a = Double.parseDouble(fieldA.getText());
           b = Double.parseDouble(fieldB.getText());
           c = Double.parseDouble(fieldC.getText());
           repaint();
        }

        public double func(double x) {
           return a*x*x + b*x + c;
       }
   }
}