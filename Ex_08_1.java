import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex_08_1 extends JFrame {
   public static void main(String[] args){
       new Ex_08_1();
   }

   public Ex_08_1() {
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
        int myMissileX, myMissileY;
        boolean isMyMissileActive;

       /* 敵機に関する変数 */
       int numOfEnemy = 12;
        int numOfAlive = numOfEnemy;
        int enemyWidth, enemyHeight;
        int[] enemyX = new int[numOfEnemy];
       int[] enemyY = new int[numOfEnemy];
        int[] enemyMove = new int[numOfEnemy];
       int[] enemyMissileX = new int[numOfEnemy];
        int[] enemyMissileY = new int[numOfEnemy];
       int[] enemyMissileSpeed = new int[numOfEnemy];
       boolean[] isEnemyAlive = new boolean[numOfEnemy];
        boolean[] isEnemyMissileActive = 
                                 new boolean[numOfEnemy];

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
           isMyMissileActive = false;

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

           for (int i=0; i<numOfEnemy; i++) {
                isEnemyMissileActive[i] = true;
                enemyMissileX[i] = enemyX[i] + enemyWidth/2;
                enemyMissileY[i] = enemyY[i];
                enemyMissileSpeed[i] = 10 + (i%6);
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

           // 自機のミサイルの描画
            if (isMyMissileActive) {
                // ミサイルの配置
               myMissileY -= 15;
               g.setColor(Color.white);
               g.fillRect(myMissileX, myMissileY, 2, 5);

               // 自機のミサイルの敵機各機への当たり判定
               for (int i=0; i<numOfEnemy; i++) {
                   if (isEnemyAlive[i]) {
                        if ((myMissileX >= enemyX[i]) && 
                           (myMissileX <= enemyX[i]+enemyWidth) && 
                           (myMissileY >= enemyY[i]) && 
                           (myMissileY <= enemyY[i]+enemyHeight)) {
                           isEnemyAlive[i] = false;
                            isMyMissileActive = false;
                           numOfAlive--;
                        }
                    }
                }

               // ミサイルがウィンドウ外に出たときのミサイルの再初期化
               if (myMissileY < 0) isMyMissileActive = false;
            }

           // 敵機の描画
           for (int i=0; i<numOfEnemy; i++) {
               if (isEnemyAlive[i]) {
                    if (enemyX[i] > dimOfPanel.width -
                                                  enemyWidth) {
                        enemyMove[i] = -1;
                   } else if (enemyX[i] < 0) {
                        enemyMove[i] = 1;
                    }
                    enemyX[i] += enemyMove[i]*10;
                   g.drawImage(imgEnemy, enemyX[i],
                                          enemyY[i], this);
                }
            }

            // 敵機のミサイルの描画
            for (int i=0; i<numOfEnemy; i++) {
                // ミサイルの配置
               if (isEnemyMissileActive[i]) {
                   enemyMissileY[i] += enemyMissileSpeed[i];
                   g.setColor(Color.red);
                    g.fillRect(enemyMissileX[i],
                               enemyMissileY[i], 2, 5);
                }

               // 敵機のミサイルの自機への当たり判定
                if ((enemyMissileX[i] >= myX) && 
                    (enemyMissileX[i] <= myX+myWidth) && 
                    (enemyMissileY[i]+5 >= 400) && 
                   (enemyMissileY[i]+5 <= 400+myHeight)) {
                   System.exit(0);
                }

               // ミサイルがウィンドウ外に出たときのミサイルの再初期化
               if (enemyMissileY[i] > dimOfPanel.height) {
                   if (isEnemyAlive[i]) {
                        enemyMissileX[i] = enemyX[i] +
                                                enemyWidth/2;
                        enemyMissileY[i] = enemyY[i];
                    } else {
                        isEnemyMissileActive[i] = false;
                   }
                }
            }

           // 敵機を全機撃墜した時の終了処理
            if (numOfAlive == 0) {
               System.exit(0);
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
           if (!isMyMissileActive) {
                myMissileX = myX + myWidth/2;
                myMissileY = 400;
               isMyMissileActive = true;
            }
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