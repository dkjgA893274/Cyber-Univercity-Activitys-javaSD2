import java.awt.*;
import javax.swing.*;

public class Sample_02_2 extends JFrame {
   public static void main(String[] args){
       new Sample_02_2();
   }

   public Sample_02_2() {
       /* �p�l���̐����Ɠ\��t�� */
       MyJPanel myJPanel= new MyJPanel();
       Container cont = getContentPane();
       cont.add(myJPanel);

       /* �t���[���̐ݒ� */
       setSize(240,400);
       setTitle("Software Development II");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
   }

   public class MyJPanel extends JPanel{
        /* �p�l���̐ݒ� */
       public MyJPanel(){

           // �R���X�g���N�^�̋L�q
           
       }

        /* �}�`�̕`�� */
       public void paintComponent(Graphics g) {
           g.drawOval( 50, 70, 120, 120);
           g.drawOval( 30, 189, 160, 160);
           g.fillOval( 75, 100, 20, 20);
           g.fillOval(120, 100, 20, 20);
           g.fillRect(102, 123, 14, 30);
           g.fillRect( 95, 162, 30, 14);
       }
   }

}