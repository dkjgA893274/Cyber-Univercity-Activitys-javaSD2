import java.awt.*;
import javax.swing.*;

public class Ex_02_1 extends JFrame {
    public static void main(String[] args){
        new Ex_02_1();
    }

    public Ex_02_1() {
        /* �p�l���̐����Ɠ\��t�� */
        MyJPanel myJPanel= new MyJPanel();        // �p�l���̐���
        Container cont = getContentPane();        // �y�C���̎擾
        cont.add(myJPanel);                       // �p�l����\��

        /* �t���[���̐ݒ� */
        setSize(500,500);                         // �T�C�Y�̐ݒ�
        setTitle("Software Development II");      // �^�C�g���̐ݒ�
        setDefaultCloseOperation(EXIT_ON_CLOSE);  // �I���{�^���̗L����
        setVisible(true);                         // ��ʂւ̕\��
    }

    public class MyJPanel extends JPanel{
        /* �p�l���̐ݒ� */
        public MyJPanel(){
            // �R���X�g���N�^�̋L�q
        }

        /* �}�`�̕`�� */
        public void paintComponent(Graphics g) {
            double s, x1, x2, y1, y2;
            int    xw1, xw2, yw1, yw2;
            
            g.setColor(new Color(255, 0, 0));
            g.drawLine( 0, 250, 500, 250);     // x��
            g.drawLine(250, 0, 250, 500);      // y��
            g.drawString("x", 470, 265);
            g.drawString("y", 260, 15);
            g.drawString("O", 240, 265);

            g.setColor(new Color(0, 0, 0));
            s = 0.1;
            x1 = -1.0;
            y1 = func(x1);

                while (x1 <= 1.0) {
                   x2 = x1 + s;
                   y2 = func(x2);

                   xw1 = (int)(250*x1 + 250);
                   yw1 = (int)(250 - 250*y1);
                   xw2 = (int)(250*x2 + 250);
                   yw2 = (int)(250 - 250*y2);
                   g.drawLine(xw1, yw1, xw2, yw2);

                   x1 = x2;
                   y1 = y2;
                }
            }
            
            public double func(double x) {
                   return x*x;
            }
    }

}
