import java.awt.*;
import javax.swing.*;

public class sample_01_3 extends JFrame {
  public static void main(String[] args){
   new sample_01_3();
 }

 public sample_01_3() {
   /* パネルの生成と貼り付け */
   MyJPanel myJPanel= new MyJPanel();       // パネルの生成
   Container cont = getContentPane();       // ペインの取得
   cont.add(myJPanel);                      // パネルを貼る

   /* フレームの設定 */
   setSize(400,300);                        // サイズの設定
    setTitle("Cyber University");            // タイトルの設定
   setDefaultCloseOperation(EXIT_ON_CLOSE); // 終了ボタンの有効化
   setVisible(true);                        // 画面への表示
}

 public class MyJPanel extends JPanel{
   /* パネルの設定 */
   public MyJPanel(){
     // コンストラクタの記述
   }

   /* パネル上での処理 */

 }
}