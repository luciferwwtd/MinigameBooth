package Casino;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;


import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MyFrame extends JFrame implements ActionListener {
   
   JFrame frame = new JFrame();
   JButton myButton = new JButton("Start Casino Game !"); // JButton을 생성할 때 텍스트를 넣어주면 버튼의 텍스트를 간편하게 설정할 수 있다.
   JLabel label = new JLabel(); // 새로운 JLabel 생성
   JTextField textField = new JTextField(); // 새로운 텍스트 필드를 생성
   
   MyFrame() {
      myButton.setBackground(new Color(255, 209, 255));
      myButton.addActionListener(this);
      myButton.setFocusable(false);
      myButton.setFont(new Font("Georgia", Font.PLAIN, 20));
      myButton.setBounds(300/2-130, 110/2-45, 250, 50);
      myButton.setEnabled(true); // 버튼을 활성화시킨다.
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300, 110);
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setTitle("카지노 게임");
      frame.getContentPane().setBackground(new Color(255, 241, 255));
   
      frame.add(myButton);
      frame.add(label); // 화면에 label을 추가시킨다.
      
   }
   public static void main(String[] args) {
        new MyFrame();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==myButton) {
         frame.dispose(); // frame, 즉 기존의 화면은 제거한다
         SecondWindow secondWindow = new SecondWindow(); // SecondWindow 화면을 새로 생성해낸다.(JFrameTest에서 하던것과 같이)
      }
   }
}
