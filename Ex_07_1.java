import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex_07_1 extends JFrame {
   public static void main(String[] args){
       new Ex_07_1();
   }

   public Ex_07_1() {
       Dimension dimOfScreen =
               Toolkit.getDefaultToolkit().getScreenSize();

       setBounds(dimOfScreen.width/2 - 400, 
                      dimOfScreen.height/2 - 250, 800, 500);
        setResizable(false);
       setTitle("Software Development II");
       setDefaultCloseOperation(EXIT_ON_CLOSE);

       MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
       c.add(panel);
        setVisible(true);
   }

   public class MyJPanel extends JPanel implements
        ActionListener, MouseListener, MouseMotionListener {
       /* 全体の設定に関する変数 */
        Dimension dimOfPanel;
       Timer timer;
       ImageIcon iconMe, iconEnemy;
       Image imgMe, imgEnemy;

       /* 自機に関する変数 */
       int myHeight, myWidth;
       int myX;

       /* 敵機に関する変数 */
       int numOfEnemy = 12;
       int numOfAlive = numOfEnemy;
       int enemyWidth, enemyHeight;
       int[] enemyX = new int[numOfEnemy];
       int[] enemyY = new int[numOfEnemy];
        int[] enemyMove = new int[numOfEnemy];
       boolean[] isEnemyAlive = new boolean[numOfEnemy];

       /* コンストラクタ（ゲーム開始時の初期化）*/
       public MyJPanel() {
           // 全体の設定
           setBackground(Color.black);
            addMouseListener(this);
           addMouseMotionListener(this);
           timer = new Timer(50, this);
           timer.start();

           // 画像の取り込み
           iconMe = new ImageIcon("jiki.jpg");
           imgMe = iconMe.getImage();
            myWidth = imgMe.getWidth(this);
            myHeight = imgMe.getHeight(this);

           iconEnemy = new ImageIcon("teki.jpg");
           imgEnemy = iconEnemy.getImage();
           enemyWidth = imgEnemy.getWidth(this);
            enemyHeight = imgEnemy.getHeight(this);

           // 自機の初期化
            myX = 400;

           // 敵機の初期化
           for (int i=0; i<7; i++) {
               enemyX[i] = 70*i;
               enemyY[i] = 50;
           }

           for (int i=7; i<numOfEnemy; i++) {
               enemyX[i] = 70*(i-6);
               enemyY[i] = 100;
           }

           for (int i=0; i<numOfEnemy; i++) {
               isEnemyAlive[i] = true;
               enemyMove[i] = 1;
            }
       }

       /* パネル上の描画 */
       public void paintComponent(Graphics g) {
           dimOfPanel = getSize();
           super.paintComponent(g);

           // 自機の描画
           if (myX+myWidth > dimOfPanel.width) {
                myX = dimOfPanel.width - myWidth;
           }
           g.drawImage(imgMe, myX, 400, this);

           // 敵機の描画
           for (int i=0; i<numOfEnemy; i++) {
               if (isEnemyAlive[i]) {
                   if (enemyX[i] >
                           dimOfPanel.width - enemyWidth) {
                       enemyMove[i] = -1;
                   } else if (enemyX[i] < 0) {
                        enemyMove[i] = 1;
                   }
                   enemyX[i] += enemyMove[i]*10;
                    g.drawImage(imgEnemy, enemyX[i],
                                          enemyY[i], this);
                }
           }
       }

        /* 一定時間ごとの処理（ActionListener に対する処理）*/
       public void actionPerformed(ActionEvent e) {
            repaint();
       }

       /* MouseListener に対する処理 */
        public void mouseClicked(MouseEvent e) {
       }

       public void mousePressed(MouseEvent e) {
       }

       public void mouseReleased(MouseEvent e) {
       }

       public void mouseExited(MouseEvent e) {
        }

       public void mouseEntered(MouseEvent e) {
       }

       /* MouseMotionListener に対する処理 */
       public void mouseMoved(MouseEvent e) {
            myX = e.getX();
       }

       public void mouseDragged(MouseEvent e) {
       }
   }
}