import java.awt.*;
import javax.swing.*;

public class Ex_02_1601010010 extends JFrame {     //Ex_02_1601010010.java
   public static void main(String[] args){
       new Ex_02_1601010010();
   }

   public Ex_02_1601010010() {
       /* �p�l���̐����Ɠ\��t�� */
       MyJPanel myJPanel= new MyJPanel();
       Container cont = getContentPane();
       cont.add(myJPanel);

       /* �t���[���̐ݒ� */
       setSize(1000,600);
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
           g.setColor(new Color(0, 100, 0));
           g.fillOval( 15, 135, 150, 150);//�t
           g.fillOval( 45, 105, 150, 150);//�t
           g.fillOval( 60, 135, 150, 150);//�t
           g.setColor(new Color(183, 65, 14));
           g.fillRect(80, 280, 50, 200);//��
           g.setColor(new Color(210,105,30));
           g.fillOval( 600, 50, 150, 150);//�E�̎�
           g.fillOval( 250, 50, 150, 150);//���̎�
           g.fillOval( 250, 100, 500, 400);//�֊s
           g.setColor(new Color(191,154,8));
           g.fillOval( 420, 300, 160, 160);//�@�֊s
           g.setColor(new Color(124,96,53));
           g.fillOval( 470, 310, 60, 50);//�@
           g.setColor(Color.black);
           g.drawLine(450, 400, 550, 400);//��
           g.drawLine(500, 360, 500, 400);//��
           g.fillOval( 450, 250, 20, 20);//���̖�
           g.fillOval( 530, 250, 20, 20);//�E�̖�
       }
   }

}