import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex_05_2 extends JFrame {
    public static void main(String[] args){
        new Ex_05_2();
    }

    public Ex_05_2() {
        setSize(200, 130);
        setTitle("Software Development II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
        c.add(panel);
        setVisible(true);
    }

    public class MyJPanel extends JPanel implements ActionListener {
        Timer timer;
        JLabel label;
        JButton button;
        int count = 0;
        int second, decimal;

        public MyJPanel() {
            timer = new Timer(100, this);

            label = new JLabel("0 秒 0");
            label.setFont(new Font("MS ゴシック", Font.BOLD, 24));

            button = new JButton("Start");
            button.setPreferredSize(new Dimension(150,40));
            button.addActionListener(this);

            add(label);
            add(button);
        }

        public void actionPerformed(ActionEvent e) {
           if (e.getSource() == button) {                    //ボタンをクリックした時の処理
               if (timer.isRunning()) {
                   timer.stop();
                   button.setText("Start");
               } else {
               timer.start();
               button.setText("Stop");
               }
           }
           
           count++;                                          // タイマーが動いている時の一定時間ごとの処理 */
           second = count / 10;
           decimal = count % 10;
           label.setText(second + "秒" + "0" + decimal);

            
        }
    }
}
