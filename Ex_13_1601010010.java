import java.io.File;
import java.net.MalformedURLException;
import javafx.scene.media.AudioClip;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex_13_1601010010 extends JFrame {
    final int windowWidth = 500;                                                           //1・追加181226 背景画像取込
    final int windowHeight = 750;

    public static void main(String[] args){
        new Ex_13_1601010010();
    }

    public Ex_13_1601010010() {
        Dimension dimOfScreen = Toolkit.getDefaultToolkit().getScreenSize();

        setBounds(dimOfScreen.width/2 - windowWidth/2, 
                  dimOfScreen.height/2 - windowHeight/2, 
                  windowWidth, windowHeight);
        setResizable(false);
        setTitle("Software Development II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
        c.add(panel);
        setVisible(true);
    }

    public class MyJPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
        /* 全体の設定に関する変数 */
        JButton button, endButton;
        JLabel label;
        Dimension dimOfPanel;
        Timer timer;
        ImageIcon iconMe, iconEnemy;
        Image imgMe, imgEnemy, bgImg, bgGameclear, bgGameover;                             //1・2・3追加181226 変数追加
        AudioClip c;
        AudioClip c2;

        /* 自機に関する変数 */
        int myHeight, myWidth;
        int myX, myY, tempMyX;
        int gap = 100;
        int damage = 0;
        int myMissileX, myMissileY, myMissile2X, myMissile2Y, myMissile3X, myMissile3Y;    //4ミサイル追加190110
        int count = 0, sec = 0;
        boolean isMyMissileActive  = false;
        boolean isMyMissileActive2 = false;
        boolean isMyMissileActive3 = false;

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
        boolean[] isEnemyMissileActive = new boolean[numOfEnemy];

        /* コンストラクタ（ゲーム開始時の初期化）*/
        public MyJPanel() {
            // 全体の設定
            setBackground(Color.black);
            addMouseListener(this);
            addMouseMotionListener(this);
            timer = new Timer(50, this);
            button = new JButton("Start");
            endButton = new JButton("ゲームを終わりにしますか？");
            button.addActionListener(this);
            endButton.addActionListener(this);
            label = new JLabel("TIME" + "　" + sec + "　" + "秒");
            add(button);
            add(endButton);
            add(label);

            // 音源、画像の取り込み
            c2 = new AudioClip(new File("Music for java report 13.mp3").toURI().toString());
            c = new AudioClip(new File("Music for java report 12.mp3").toURI().toString());
            bgImg = getImg("BackGround.png");                                              //2・追加181226 背景画像取込
            bgGameclear = getImg("BackGround_GameClear.png");                              //3・追加181226 背景画像取込
            bgGameover = getImg("BackGround_GameOver.png");  
            imgMe = getImg("jiki2.png");
            myWidth = imgMe.getWidth(this);
            myHeight = imgMe.getHeight(this);

            imgEnemy = getImg("teki2.png");
            enemyWidth = imgEnemy.getWidth(this);
            enemyHeight = imgEnemy.getHeight(this);

            // 自機と敵機の初期化
            initMyPlane();
            initEnemyPlane();
        }

        /* パネル上の描画 */
        public void paintComponent(Graphics g) {
            dimOfPanel = getSize();
            super.paintComponent(g);

            // 各要素の描画
            g.drawImage(bgImg, 0, 0,windowWidth,windowHeight, this);                       //2・追加181226 背景画像
            drawMyPlane(g);       // 自機
            drawMyMissile(g);     // 自機のミサイル                                          //4ミサイル追加190110
            drawEnemyPlane(g);    // 敵機
            drawEnemyMissile(g);  // 敵機のミサイル

            // 敵機を全機撃墜した時の終了処理
            if (numOfAlive == 0) {
                timer.stop();
                g.drawImage(bgGameclear, 0, 0,windowWidth,windowHeight, this);             //3・追加181226 GameClear
            }
        }

        /* 一定時間ごとの処理（ActionListener に対する処理）*/
        public void actionPerformed(ActionEvent e) { 

            if (e.getSource() == endButton) {                                              //3・追加181226 Game終わり
                    System.exit(0);
            }
            
            if (e.getSource() == button) {
                if (timer.isRunning()) {
                    timer.stop();
                    c.stop();
                    button.setText("Start");
                } else {
                    timer.start();
                    c.play();
                    button.setText("Stop");
                  }
            }
            
            if (sec >= 600) {
                timer.stop();
                } else {
                  count++;
                  sec = count / 20;
                  label.setText("TIME" + "　" + sec + "　" + "秒");
                }


            repaint();
        }

        /* MouseListener に対する処理 */
        // マウスボタンをクリックする
        public void mouseClicked(MouseEvent e) {
        }

        // マウスボタンを押下する
        public void mousePressed(MouseEvent e) {
            
            if (!isMyMissileActive) {
                myMissileX = tempMyX + myWidth/2;
                myMissileY = myY;
                c2.play();
                isMyMissileActive = true;
            } else if (!isMyMissileActive2) {
                myMissile2X = tempMyX + myWidth/2;
                myMissile2Y = myY;
                c2.play();
                isMyMissileActive2 = true;
            } else if (!isMyMissileActive3) {
                myMissile3X = tempMyX + myWidth/2;
                myMissile3Y = myY;
                c2.play();
                isMyMissileActive3 = true;
            }
        }

        // マウスボタンを離す
        public void mouseReleased(MouseEvent e) {
        }

        // マウスが領域外へ出る
        public void mouseExited(MouseEvent e) {
        }

        // マウスが領域内に入る
        public void mouseEntered(MouseEvent e) {
        }

        /* MouseMotionListener に対する処理 */
        // マウスを動かす
        public void mouseMoved(MouseEvent e) {
            myX = e.getX();
        }

        // マウスをドラッグする
        public void mouseDragged(MouseEvent e) {
            myX = e.getX();
        }

        /* 画像ファイルから Image クラスへの変換 */
        public Image getImg(String filename) {
            ImageIcon icon = new ImageIcon(filename);
            Image img = icon.getImage();

            return img;
        }

        /* 自機の初期化 */
        public void initMyPlane() {
            myX = windowWidth / 2;
            myY = windowHeight - 100;
            tempMyX = windowWidth / 2;
            isMyMissileActive =  false;
            isMyMissileActive2 = false;
            isMyMissileActive3 = false;
        }

        /* 敵機の初期化 */
        public void initEnemyPlane() {
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

        /* 自機の描画 */
        public void drawMyPlane(Graphics g) {
            if (Math.abs(tempMyX - myX) < gap) {
                if (myX < 0) {
                    myX = 0;
                } else if (myX+myWidth > dimOfPanel.width) {
                    myX = dimOfPanel.width - myWidth;
                }
                tempMyX = myX;
                g.drawImage(imgMe, tempMyX, myY, this);
            } else {
                g.drawImage(imgMe, tempMyX, myY, this);
            }
        }

        /* 自機ミサイルの描画 */
        public void drawMyMissile(Graphics g) {
            if (isMyMissileActive) {
                // ミサイルの配置
                myMissileY -= 15;
                g.setColor(Color.white);
                g.fillRect(myMissileX, myMissileY, 2, 5);
                };
                if (isMyMissileActive2) {
                // ミサイル2の配置
                myMissile2Y -= 15;
                g.setColor(Color.black);
                g.fillRect(myMissile2X, myMissile2Y, 2, 5);
                };
                if (isMyMissileActive3) {
                // ミサイル3の配置
                myMissile3Y -= 15;
                g.setColor(Color.gray);
                g.fillRect(myMissile3X, myMissile3Y, 2, 5);
                };
                // 自機ミサイルの敵機各機への当たり判定
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
                // 自機ミサイル2の敵機各機への当たり判定
                for (int i=0; i<numOfEnemy; i++) {
                    if (isEnemyAlive[i]) {
                        if ((myMissile2X >= enemyX[i]) && 
                            (myMissile2X <= enemyX[i]+enemyWidth) && 
                            (myMissile2Y >= enemyY[i]) && 
                            (myMissile2Y <= enemyY[i]+enemyHeight)) {
                            isEnemyAlive[i] = false;
                            isMyMissileActive2 = false;
                            numOfAlive--;
                        }
                    }
                }
                // 自機ミサイル3の敵機各機への当たり判定
                for (int i=0; i<numOfEnemy; i++) {
                    if (isEnemyAlive[i]) {
                        if ((myMissile3X >= enemyX[i]) && 
                            (myMissile3X <= enemyX[i]+enemyWidth) && 
                            (myMissile3Y >= enemyY[i]) && 
                            (myMissile3Y <= enemyY[i]+enemyHeight)) {
                            isEnemyAlive[i] = false;
                            isMyMissileActive3 = false;
                            numOfAlive--;
                        }
                    }
                }

                // ミサイルがウィンドウ外に出たときのミサイルの再初期化
                if (myMissileY < 0) isMyMissileActive =   false;
                // ミサイル2がウィンドウ外に出たときのミサイルの再初期化
                if (myMissile2Y < 0) isMyMissileActive2 = false;
                // ミサイル3がウィンドウ外に出たときのミサイルの再初期化
                if (myMissile3Y < 0) isMyMissileActive3 = false;
            
        }

        /* 敵機の描画 */
        public void drawEnemyPlane(Graphics g) {
            for (int i=0; i<numOfEnemy; i++) {
                if (isEnemyAlive[i]) {
                    if (enemyX[i] > dimOfPanel.width - 
                                                   enemyWidth) {
                        enemyMove[i] = -1;
                    } else if (enemyX[i] < 0) {
                        enemyMove[i] = 1;
                    }
                    enemyX[i] += enemyMove[i]*10;
                    g.drawImage(imgEnemy, enemyX[i], enemyY[i], this);
                }
            }
        }

        /* 敵機のミサイルの描画 */
        public void drawEnemyMissile(Graphics g) {
            for (int i=0; i<numOfEnemy; i++) {
                // ミサイルの配置
                if (isEnemyMissileActive[i]) {
                    enemyMissileY[i] += enemyMissileSpeed[i];
                    g.setColor(Color.red);
                    g.fillRect(enemyMissileX[i], enemyMissileY[i], 2, 5);
                }

                // 敵機ミサイルの自機への当たり判定
                if ((enemyMissileX[i] >= tempMyX) && 
                    (enemyMissileX[i] <= tempMyX+myWidth) && 
                    (enemyMissileY[i]+5 >= myY) && 
                    (enemyMissileY[i]+5 <= myY+myHeight) &&
                    (damage < 3)){
                    damage++;
                    } else if (damage >= 3){
                    g.drawImage(bgGameover, 0, 0,windowWidth,windowHeight, this);          //3・追加181226 GameOver
                    timer.stop();
                    c.stop();
                }

                // ミサイルがウィンドウ外に出たときのミサイルの再初期化
                if (enemyMissileY[i] > dimOfPanel.height) {
                    if (isEnemyAlive[i]) {
                        enemyMissileX[i] = enemyX[i] + 
                                                 enemyWidth/2;
                        enemyMissileY[i] = enemyY[i] + 
                                                  enemyHeight;
                    } else {
                        isEnemyMissileActive[i] = false;
                    }
                }
            }
        }
    }
}