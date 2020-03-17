import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample_07_3 extends JFrame { public static void main(String[] args){
        new Sample_07_3();
    }

    public Sample_07_3() {
        setSize(800, 500);
        setTitle("Software Development II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
        c.add(panel);
        setVisible(true);
    }

    
public class MyJPanel extends JPanel implements ActionListener {
   Dimension dimOfPanel;
   Timer timer;
   ImageIcon iconEnemy;
   Image imgEnemy;

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

 	 	
   public MyJPanel() {
       setBackground(Color.black);
       timer = new Timer(50, this);
       timer.start();

       iconEnemy = new ImageIcon("teki.jpg");
       imgEnemy = iconEnemy.getImage();
       enemyWidth = imgEnemy.getWidth(this);
       enemyHeight = imgEnemy.getHeight(this);

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

   public void paintComponent(Graphics g) {
       dimOfPanel = getSize();
       super.paintComponent(g);

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

       for (int i=0; i<numOfEnemy; i++) {
           if (isEnemyMissileActive[i]) {
               g.setColor(Color.red);
               g.fillRect(enemyMissileX[i],
                                 enemyMissileY[i], 2, 5);
               enemyMissileY[i] += enemyMissileSpeed[i];
           }

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
}

   public void actionPerformed(ActionEvent e) {
        repaint();
   }
}
}
