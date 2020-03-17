import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex_05_1 extends JFrame {
   public static void main(String[] args){
       new Ex_05_1();
   }

   public Ex_05_1() {
       setSize(800, 600);
       setTitle("Software Development II");
       setDefaultCloseOperation(EXIT_ON_CLOSE);

       MyJPanel panel= new MyJPanel();
       Container c = getContentPane();
       c.add(panel);
       setVisible(true);
   }

   public class MyJPanel extends JPanel implements ActionListener {
       JButton button;
       Dimension dim;
       Timer timer;
       int x = 0, y = 0;
       int dirX = 1, dirY = 1;
       int ball = 20;
       int add = 2;

       public MyJPanel() {
           timer = new Timer(1, this);

           button = new JButton("Start");
           button.addActionListener(this);
           add(button);
       }

       public void paintComponent(Graphics g) {
           super.paintComponent(g);
           g.setColor(Color.blue);
           g.fillOval(x, y, ball, ball);
       }

       public void actionPerformed(ActionEvent e) {
           dim = getSize();

           if (e.getSource() == button) {
               if (timer.isRunning()) {
                   timer.stop();
                   button.setText("Start");
               } else {
                   timer.start();
                   button.setText("Stop");
               }
           }

           if (x > dim.width-ball) dirX = -1;
           else if (x < 0)         dirX = 1;

           if (y > dim.height-ball) dirY = -1;
           else if (y < 0)          dirY = 1;

           x = x + dirX*add;
           y = y + dirY*add;

           repaint();
       }
   }
}