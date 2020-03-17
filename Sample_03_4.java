import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample_03_4 extends JFrame {
    public static void main(String[] args) {
        new Sample_03_4();
    }

    public Sample_03_4() {
        setSize(300, 200);
        setTitle("Software Development II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
        c.add(panel);
        setVisible(true);
    }

    public class MyJPanel extends JPanel implements ActionListener {
        JTextField field;
        JButton button;
        String str = "";

        public MyJPanel() {
            field = new JTextField(20);

            button = new JButton("ƒ{ƒ^ƒ“");
            button.addActionListener(this);

            add(field);
            add(button);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString(str, 30, 100);
        }

        public void actionPerformed(ActionEvent e) {
            str = field.getText();
            repaint();
        }
    }
}
