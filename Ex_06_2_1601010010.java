import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex_06_2_1601010010 extends JFrame {
   public static void main(String[] args){
       new Ex_06_2_1601010010();
   }

   public Ex_06_2_1601010010() {
       setSize(600, 450);
       setTitle("Software Development II");
       setDefaultCloseOperation(EXIT_ON_CLOSE);

       MyJPanel panel= new MyJPanel();
       Container c = getContentPane();
       c.add(panel);
       setVisible(true);
   }

   public class MyJPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
       JSlider sliderR, sliderG, sliderB, sliderPen;
       JLabel labelR, labelG, labelB, labelPen;
       JButton button;
       int colorR, colorG, colorB;
       int rad, x = -100, y = -100;
       boolean isButtonClicked = false;

       public MyJPanel() {
           setLayout(null);

           addMouseListener(this);
           addMouseMotionListener(this);

           labelR = new JLabel("赤");
           labelR.setBounds(40, 20, 20, 25);
           sliderR = new JSlider(0, 255, 0);
           sliderR.setBounds(60, 20, 200, 35);
           sliderR.setPaintTicks(true);
           sliderR.setMinorTickSpacing(10);
           sliderR.setMajorTickSpacing(50);
           sliderR.setPaintLabels(true);

           labelG = new JLabel("緑");
           labelG.setBounds(40, 60, 20, 25);
           sliderG = new JSlider(0, 255, 0);
           sliderG.setBounds(60, 60, 200, 35);
           sliderG.setPaintTicks(true);
           sliderG.setMinorTickSpacing(10);
           sliderG.setMajorTickSpacing(50);
           sliderG.setPaintLabels(true);

           labelB = new JLabel("青");
           labelB.setBounds(40, 100, 20, 25);
           sliderB = new JSlider(0, 255, 0);
           sliderB.setBounds(60, 100, 200, 35);
           sliderB.setPaintTicks(true);
           sliderB.setMinorTickSpacing(10);
           sliderB.setMajorTickSpacing(50);
           sliderB.setPaintLabels(true);

           labelPen = new JLabel("ペンの大きさ");
           labelPen.setBounds(280, 20, 100, 25);
           sliderPen = new JSlider(2, 50, 32);
           sliderPen.setBounds(360, 20, 200, 35);
           sliderPen.setPaintTicks(true);
           sliderPen.setMinorTickSpacing(5);
           sliderPen.setMajorTickSpacing(10);
           sliderPen.setPaintLabels(true);

           button = new JButton("消去");
           button.setBounds(410, 75, 100, 30);
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

       public void paintComponent(Graphics g) {
           if (isButtonClicked) {
               super.paintComponent(g);
               isButtonClicked = false;
           }

           g.setColor(new Color(colorR, colorG, colorB));
           g.fillOval(x-rad/2, y-rad/2, rad, rad);
           repaint();
       }

       public void actionPerformed(ActionEvent e) {
           isButtonClicked = true;
           repaint();
       }

       public void mouseClicked(MouseEvent e) {
       }

       public void mousePressed(MouseEvent e) {
       }

       public void mouseReleased(MouseEvent e) {
           x = -100;
           y = -100;
           repaint();
       }

       public void mouseExited(MouseEvent e) {
       }

       public void mouseEntered(MouseEvent e) {
       }

       public void mouseMoved(MouseEvent e) {
       }

       public void mouseDragged(MouseEvent e) {
           colorR = sliderR.getValue();
           colorG = sliderG.getValue();
           colorB = sliderB.getValue();
           rad = sliderPen.getValue();
            x = e.getX();
           y = e.getY();
          repaint();
       }
   }
}