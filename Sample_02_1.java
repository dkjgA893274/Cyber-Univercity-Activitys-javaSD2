import java.awt.*;
import javax.swing.*;

public class Sample_02_1 extends JFrame {
    public static void main(String[] args){
        new Sample_02_1();
    }

    public Sample_02_1() {
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
            g.setColor(new Color(255, 0, 0));
            g.drawLine( 0, 250, 500, 250);     // x��
            g.drawLine(250, 0, 250, 500);      // y��
            g.drawString("x", 470, 265);
            g.drawString("y", 260, 15);
            g.drawString("O", 240, 265);
            }
    }

}
