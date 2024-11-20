package Casino;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondWindow extends JFrame implements ActionListener {
   
   JFrame frame = new JFrame();
   JButton a = new JButton("홀짝게임");
   JButton b = new JButton("블랙잭");
   JLabel scoreLabel = new JLabel("score: "); // 점수를 표시할 라벨
    int finalScore = -1; // 마지막 점수를 저장할 변수 (-1은 게임 시작 전 상태)
    JLabel winlose = new JLabel("승: " + "  패: "); // 점수를 표시할 라벨
    int win = -1; // 마지막 점수를 저장할 변수 (-1은 게임 시작 전 상태)
    int lose = -1; // 마지막 점수를 저장할 변수 (-1은 게임 시작 전 상태)
   JLabel label = new JLabel("Choose The Game"); // 전과의 버튼과 마찬가지로 이렇게 하면 label의 텍스트를 간편하게 설정할 수 있다.
   
   SecondWindow() {
      
      label.setBounds(115, 20, 200, 50);
      label.setFont(new Font("Georgia", Font.PLAIN, 20)); // 폰트에 null을 넣으면 기본 폰트가 설정된다.
      
      frame.add(label);
      
      // 점수 라벨 설정// score 라벨 설정
        scoreLabel.setBounds(250,87,200,30);
        scoreLabel.setFont(new Font("Georgia", Font.PLAIN, 16));
        scoreLabel.setForeground(Color.GRAY);
        frame.add(scoreLabel);
        
     // 점수 라벨 설정// score 라벨 설정
        winlose.setBounds(238,182,200,30);
        winlose.setFont(new Font(null, Font.PLAIN, 15));
        winlose.setForeground(Color.GRAY);
        frame.add(winlose);
      
      a.setBackground(new Color(255, 209, 255));
      a.addActionListener(this);
      a.setFocusable(false);
      a.setFont(new Font(null, Font.PLAIN, 20));
      a.setBounds(400/2-250/2-5, 115, 250, 50);
      a.setEnabled(true); // 버튼을 활성화시킨다.
      
      frame.add(a);
      
      b.setBackground(new Color(255, 209, 255));
      b.addActionListener(this);
      b.setFocusable(false);
      b.setFont(new Font(null, Font.PLAIN, 20));
      b.setBounds(400/2-250/2-5, 210, 250, 50);
      b.setEnabled(true); // 버튼을 활성화시킨다.
      
      frame.add(b);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 425);
      frame.setLayout(null);
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setTitle("카지노 게임");
      frame.getContentPane().setBackground(new Color(255, 241, 255));
   
       
   }
   
    @Override
       public void actionPerformed(ActionEvent e) {
           if (e.getSource() == a) {
               //a.setEnabled(false); // 버튼 비활성화
               new OneTwoGame(this); // MyFrame을 전달하여 종료 시 점수를 업데이트할 수 있도록 함
           }else if (e.getSource() == b) { // b 버튼에 대한 처리 추가
               //b.setEnabled(false); // 버튼 비활성화3
               new Blackjack(this); // Blackjack 클래스를 실행
           }
    }

       public void updateScore1(int score) {
           finalScore = score;
           scoreLabel.setText("score: " + finalScore);
       }
       
       public void updateScore2(int win1, int lose1) {
           win = win1;
           lose = lose1;
           winlose.setText("승: " + win1 + "  패: " + lose1);
       }
   
   }
