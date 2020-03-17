import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.event.*;

public class test extends JFrame implements ChangeListener{

  JSlider slider;
  JLabel label;

  public static void main(String[] args){
    test frame = new test();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 300, 200);
    frame.setTitle("タイトル");
    frame.setVisible(true);
  }

  test(){

    slider = new JSlider();
    slider.setMajorTickSpacing(10);
    slider.setMinorTickSpacing(2);
    slider.setPaintTicks(true);
    slider.addChangeListener(this);

    JPanel p = new JPanel();
    

    label = new JLabel();
    label.setText("値：" + slider.getValue());

    getContentPane().add(p, BorderLayout.CENTER);
    getContentPane().add(label, BorderLayout.PAGE_END);
  }

  public void stateChanged(ChangeEvent e) {
    label.setText("値：" + slider.getValue());
  }
}