public class CellularPhone {


   /* �t�B�[���h */
   String telephoneNumber;     // �d�b�ԍ�
   int batteryRemaining = 100; // �o�b�e���[�c��

   /* �R���X�g���N�^ */
   public CellularPhone(String telNum) {
       telephoneNumber = telNum;
   }

   /* ���\�b�h */
   // ���M���\�b�h
   public void receiveCall(String caller) {
       System.out.println("�����I�����I�����I");
       System.out.println(caller + " ���� " +
                          telephoneNumber + " �ւ̒��M");
   }

   // �ʘb���\�b�h
    public void talkSomething(String msg) {
       System.out.println("[" + msg + "]");
   }

   // �ؒf���\�b�h
   public void hungUp() {
       System.out.println("�ʘb�I��");
        batteryRemaining = batteryRemaining - 10;
       System.out.println("�o�b�e���[�c�� = " + 
                                     batteryRemaining);
   }
   
   
}