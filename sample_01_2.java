public class sample_01_2 {
   public static void main (String[] args) {
   
   
   String[] caller = {"03-1111-2222", 
                           "03-3333-4444"}; // ���M�҂̓d�b�ԍ�

       /* �I�u�W�F�N�g���� */
       CellularPhone cp = new CellularPhone("318-318");

       /* 1��ڂ̒ʘb */
       System.out.println("-----------------------------");
       cp.receiveCall(caller[0]);
       cp.talkSomething("���������C�T�C�o�[���Z�́~�~�ł��D");
       cp.talkSomething("���肪�Ƃ��������܂����D");
       cp.hungUp();
       System.out.println("-----------------------------");

       /* 2��ڂ̒ʘb */
       System.out.println("-----------------------------");
       cp.receiveCall(caller[1]);
       cp.talkSomething("����ɂ��́D�T�C�o�[��w�́����ł��D");
       cp.talkSomething("��낵�����肢���܂��D");
       cp.hungUp();
       System.out.println("-----------------------------");
       
   }
}