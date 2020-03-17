import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample_05_3 extends JFrame {
    public static void main(String[] args){
        new Sample_05_3();
    }

    public Sample_05_3() {
        setSize(400, 300);
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
       int x = 0;
       int dirX = 1;

       public MyJPanel() {
           timer = new Timer(10, this);

           button = new JButton("Start");
           button.addActionListener(this);
           add(button);
       }

       public void paintComponent(Graphics g) {
           super.paintComponent(g);
           g.fillOval(x, 120, 20, 20);
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

           if (x > dim.width-20) dirX = -1;
           else if (x < 0)       dirX = 1;

           x = x + dirX*2;

           repaint();
       }
   }
}

