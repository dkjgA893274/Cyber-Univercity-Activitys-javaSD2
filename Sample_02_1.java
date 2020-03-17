import java.awt.*;
import javax.swing.*;

public class Sample_02_1 extends JFrame {
    public static void main(String[] args){
        new Sample_02_1();
    }

    public Sample_02_1() {
        /* パネルの生成と貼り付け */
        MyJPanel myJPanel= new MyJPanel();        // パネルの生成
        Container cont = getContentPane();        // ペインの取得
        cont.add(myJPanel);                       // パネルを貼る

        /* フレームの設定 */
        setSize(500,500);                         // サイズの設定
        setTitle("Software Development II");      // タイトルの設定
        setDefaultCloseOperation(EXIT_ON_CLOSE);  // 終了ボタンの有効化
        setVisible(true);                         // 画面への表示
    }

    public class MyJPanel extends JPanel{
        /* パネルの設定 */
        public MyJPanel(){
            // コンストラクタの記述
        }

        /* 図形の描画 */
        public void paintComponent(Graphics g) {
            g.setColor(new Color(255, 0, 0));
            g.drawLine( 0, 250, 500, 250);     // x軸
            g.drawLine(250, 0, 250, 500);      // y軸
            g.drawString("x", 470, 265);
            g.drawString("y", 260, 15);
            g.drawString("O", 240, 265);
            }
    }

}
