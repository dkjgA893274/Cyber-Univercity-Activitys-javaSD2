import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample_06_2 extends JFrame {
    public static void main(String[] args){
        new Sample_06_2();
    }

    public Sample_06_2() {
        setSize(400, 200);
        setTitle("Software Development II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
        c.add(panel);
        setVisible(true);
    }

    public class MyJPanel extends JPanel implements ActionListener {
        JLabel  label;
        JSlider slider;
        JButton button;
        int value;

        public MyJPanel() {
            setLayout(null);

            label = new JLabel("スライダー");
            label.setBounds(30,80,80,20);
            
            slider = new JSlider(1,50,10);
            slider.setBounds(100,80,250,20);

            button = new JButton("値の取得");
            button.setBounds(70,110,250,30);
            button.addActionListener(this);

            add(label);
            add(slider);
            add(button);
        }

        public void paintComponent(Graphics g) {              /* パネル上の描画 */
            super.paintComponent(g);
            g.drawString("スライダーの値：" + Integer.toString(value), 100,50);
        }

        public void actionPerformed(ActionEvent e) {          /* ボタンをクリックした時の処理 */
            value = slider.getValue();
            repaint();
        }
    }
}
