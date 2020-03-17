import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample_06_1 extends JFrame {
    public static void main(String[] args){
        new Sample_06_1();
    }

    public Sample_06_1() {
        setSize(400, 300);
        setTitle("Software Development II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
        c.add(panel);
        setVisible(true);
    }

    public class MyJPanel extends JPanel implements MouseListener, MouseMotionListener {
        int flag;

        public MyJPanel() {
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            switch (flag) {
            case 1: g.drawString("クリックしました．", 100, 100);
                    break;
            case 2: g.drawString("押しています．", 100, 100);
                    break;
            case 3: g.drawString("離しました．", 100, 100);
                    break;
            case 4: g.drawString("ウィンドウに入りました．", 100, 100);
                    break;
            case 5: g.drawString("ウィンドウから出ました．", 100, 100);
                    break;
            case 6: g.drawString("動かしています．", 100, 100);
                    break;
            case 7: g.drawString("ドラッグしています．", 100, 100);
                    break;
            }
        }

        public void mouseClicked(MouseEvent me) {
            flag = 1;
            repaint();
        }

        public void mousePressed(MouseEvent me) {
            flag = 2;
            repaint();
        }

        public void mouseReleased(MouseEvent me) {
            flag = 3;
            repaint();
        }

        public void mouseEntered(MouseEvent me) {
            flag = 4;
            repaint();
        }

        public void mouseExited(MouseEvent me) {
            flag = 5;
            repaint();
        }

        public void mouseMoved(MouseEvent me) {
            flag = 6;
            repaint();
        }

        public void mouseDragged(MouseEvent me) {
            flag = 7;
            repaint();
        }
    }
}
