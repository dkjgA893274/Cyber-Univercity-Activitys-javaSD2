import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test extends JFrame {
    public static void main(String[] args){
        new test();
    }

    public test() {
        setSize(400, 300);
        setTitle("Software Development II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
        c.add(panel);
        setVisible(true);
    }

    public class MyJPanel extends JPanel implements ActionListener {
        Timer timer;
        int x = 0;

        public MyJPanel() {
            timer = new Timer(1000, this);
            timer.start();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.fillOval(x, 120, 50, 20);
        }

        public void actionPerformed(ActionEvent e) {
            x = x + 2;
            if (x > 300) timer.stop();

            repaint();
        }
    }
}
