import java.awt.*;
import javax.swing.*;

public class sample_01_3 extends JFrame {
  public static void main(String[] args){
   new sample_01_3();
 }

 public sample_01_3() {
   /* �p�l���̐����Ɠ\��t�� */
   MyJPanel myJPanel= new MyJPanel();       // �p�l���̐���
   Container cont = getContentPane();       // �y�C���̎擾
   cont.add(myJPanel);                      // �p�l����\��

   /* �t���[���̐ݒ� */
   setSize(400,300);                        // �T�C�Y�̐ݒ�
    setTitle("Cyber University");            // �^�C�g���̐ݒ�
   setDefaultCloseOperation(EXIT_ON_CLOSE); // �I���{�^���̗L����
   setVisible(true);                        // ��ʂւ̕\��
}

 public class MyJPanel extends JPanel{
   /* �p�l���̐ݒ� */
   public MyJPanel(){
     // �R���X�g���N�^�̋L�q
   }

   /* �p�l����ł̏��� */

 }
}