import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Sample_04_1 extends JFrame {

    public static void main(String[] args){
        new Sample_04_1();
    }

    public Sample_04_1() {
        setSize(400, 300);
        setTitle("Software Development II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
        c.add(panel);
        setVisible(true);
    }

    public class MyJPanel extends JPanel implements ActionListener {
        JRadioButton button1, button2;
        ButtonGroup group;

        public MyJPanel() {
            button1 = new JRadioButton("ラジオボタン1",false);
            button1.addActionListener(this);

            button2 = new JRadioButton("ラジオボタン2",true);
            button2.addActionListener(this);
            
            group = new ButtonGroup();
            group.add(button1);
            group.add(button2);

            add(button1);
            add(button2);
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);

            if (button1.isSelected()) {
                g.setColor(Color.blue);
                g.drawString("【ラジオボタン1】が選択されています．", 50, 100);
            }

            if (button2.isSelected()) {
                g.setColor(Color.red);
                g.drawString("【ラジオボタン2】が選択されています．", 50, 150);
            }
        }

        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
}
