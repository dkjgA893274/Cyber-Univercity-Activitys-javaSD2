import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample_06_4 extends JFrame {
    public static void main(String[] args){
        new Sample_06_4();
    }

    public Sample_06_4() {
        setSize(600, 450);
        setTitle("Software Development II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
        c.add(panel);
        setVisible(true);
    }

    public class MyJPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
       JButton button;
       int colorR = 0, colorG = 0, colorB = 255;
       int rad = 25;
       int x = -100, y = -100;
       boolean isButtonClicked = false;

       public MyJPanel() {
           addMouseListener(this);
           addMouseMotionListener(this);
           
           button = new JButton("消去");
           button.addActionListener(this);
           
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

       public void actionPerformed(ActionEvent e) {          /* ボタンをクリックした時の処理 */
           isButtonClicked = true;
           repaint();
       }

       public void mouseClicked(MouseEvent e) {
           /* マウスボタンをクリックした時の処理 */
       }

       public void mousePressed(MouseEvent e) {
           /* マウスボタンを押した時の処理 */
       }

       public void mouseReleased(MouseEvent e) {          /* マウスボタンを離したときの処理 */
           x = -100;
           y = -100;
           repaint();
       }

       public void mouseExited(MouseEvent e) {
           /* マウスが領域外に出た時の処理 */
       }

       public void mouseEntered(MouseEvent e) {
           /* マウスが領域内に入った時の処理 */
       }

       public void mouseMoved(MouseEvent e) {
           /* マウスを動かしたときの処理 */
       }

       public void mouseDragged(MouseEvent e) {
           x = e.getX();
           y = e.getY();
           repaint();
       }
    }
}
