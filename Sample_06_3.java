import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample_06_3 extends JFrame {
    public static void main(String[] args){
        new Sample_06_3();
    }

    public Sample_06_3() {
        setSize(600, 450);
        setTitle("Software Development II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
        c.add(panel);
        setVisible(true);
    }

    public class MyJPanel extends JPanel implements ActionListener {
        JSlider sliderR, sliderG, sliderB, sliderPen;
        JLabel labelR, labelG, labelB, labelPen;
        JButton button;
        int colorR, colorG, colorB;
        int rad;

        public MyJPanel() {                              /* コンストラクタ */
            setLayout(null);

            labelR = new JLabel("赤");
            labelR.setBounds(40, 10, 20, 25);
            sliderR = new JSlider(0, 255, 0);
            sliderR.setBounds(60, 10, 200, 25);

            labelG = new JLabel("緑");
            labelG.setBounds(40, 35, 20, 25);
            sliderG = new JSlider(0, 255, 0);
            sliderG.setBounds(60, 35, 200, 25);

            labelB = new JLabel("青");
            labelB.setBounds(40, 60, 20, 25);
            sliderB = new JSlider(0, 255, 0);
            sliderB.setBounds(60, 60, 200, 25);

            labelPen = new JLabel("ペンの大きさ");
            labelPen.setBounds(280, 10, 100, 25);
            sliderPen = new JSlider(2, 50, 25);
            sliderPen.setBounds(360, 10, 200, 25); 
 
            button = new JButton("描く");
            button.setBounds(410, 45, 100, 30);
            button.addActionListener(this);
     
            add(labelR);
            add(sliderR);
            add(labelG);
            add(sliderG);
            add(labelB);
            add(sliderB);
            add(labelPen);
            add(sliderPen);
            add(button);
        }

        public void paintComponent(Graphics g) {         //描画の処理
           super.paintComponent(g);

           g.setColor(new Color(colorR, colorG, colorB));
           g.fillOval(250, 200, rad, rad);
           repaint();
        }

        public void actionPerformed(ActionEvent e) {
           colorR = sliderR.getValue();
           colorG = sliderG.getValue();
           colorB = sliderB.getValue();
           rad = sliderPen.getValue();

           repaint();
        }
    }
}
