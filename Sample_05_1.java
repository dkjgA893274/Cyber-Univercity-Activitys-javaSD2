import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample_05_1 extends JFrame {
    public static void main(String[] args){
        new Sample_05_1();
    }

    public Sample_05_1() {
        setSize(200, 150);
        setTitle("Software Development II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
        c.add(panel);
        setVisible(true);
    }

    public class MyJPanel extends JPanel implements ActionListener {
        Timer timer;
        JLabel label;
        int sec = 0;

        public MyJPanel() {
            label = new JLabel();
            add(label);

            timer = new Timer(1000, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent e) {
            label.setText(sec + " 秒");

            if (sec >= 100) timer.stop();
            else            sec++;
        }
    }
}
