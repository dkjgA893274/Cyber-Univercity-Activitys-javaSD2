public class sample_01_2 {
   public static void main (String[] args) {
   
   
   String[] caller = {"03-1111-2222", 
                           "03-3333-4444"}; // 発信者の電話番号

       /* オブジェクト生成 */
       CellularPhone cp = new CellularPhone("318-318");

       /* 1回目の通話 */
       System.out.println("-----------------------------");
       cp.receiveCall(caller[0]);
       cp.talkSomething("もしもし，サイバー金融の××です．");
       cp.talkSomething("ありがとうございました．");
       cp.hungUp();
       System.out.println("-----------------------------");

       /* 2回目の通話 */
       System.out.println("-----------------------------");
       cp.receiveCall(caller[1]);
       cp.talkSomething("こんにちは．サイバー大学の○○です．");
       cp.talkSomething("よろしくお願いします．");
       cp.hungUp();
       System.out.println("-----------------------------");
       
   }
}