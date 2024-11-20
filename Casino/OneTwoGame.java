package Casino;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class OneTwoGame extends JFrame implements KeyListener {
   private SecondWindow mainFrame; // SecondWindow 참조 저장

    private boolean isGameActive; // 게임 상태 관리 플래그
    private JLabel HS;  
    
    
   Random rand = new Random();
    JLabel one = new JLabel("홀(1) 또는 짝(2)을 눌러주세요.");
    JLabel scoreLabel = new JLabel("Score: 0");
    JLabel resultLabel = new JLabel("");
    JLabel originalNumberLabel = new JLabel(""); // 원래 숫자를 보여줄 라벨
    JButton backButton = new JButton("돌아가기");

    int score = 0; // 현재 점수
    
    public OneTwoGame(SecondWindow mainFrame) {
        this.mainFrame = mainFrame; // SecondWindow 참조 저장
       
        // JFrame 설정
        setTitle("카지노 게임 - 홀짝게임");
        setSize(700, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 241, 255));

        HS = new JLabel("재시작(r)");
        HS.setBounds(15, 0, 700, 50);
        HS.setForeground(Color.DARK_GRAY);
        HS.setFont(new Font(null, Font.PLAIN, 17));
        
        // 라벨 설정
        one.setBounds(80, 175, 700, 50);
        one.setFont(new Font(null, Font.PLAIN, 40));
        add(one);

        scoreLabel.setBounds(550, 15, 200, 30);
        scoreLabel.setFont(new Font(null, Font.PLAIN, 20));
        add(scoreLabel);

        resultLabel.setBounds(0, 250, 700, 50);
        resultLabel.setFont(new Font(null, Font.PLAIN, 30));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(resultLabel);

        originalNumberLabel.setBounds(0, 300, 700, 50);
        originalNumberLabel.setFont(new Font(null, Font.PLAIN, 30));
        originalNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        originalNumberLabel.setForeground(Color.GRAY);
        add(originalNumberLabel);
        
     // "처음으로 돌아가기" 버튼 설정
        backButton.setBounds(5, 422, 85, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Go back to the previous screen
                dispose(); // Close current frame
            }
        });
        backButton.setFocusable(false);
        backButton.setBackground(new Color(255, 209, 255));
        add(backButton);

        addKeyListener(this);
        setVisible(true);

        restartGame();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        if (!isGameActive) {
            if (e.getKeyChar() == 'r') {
                restartGame(); // 게임 재시작
            }
            return; // 게임이 비활성화되면 키 이벤트 무시
        }
       
        int ranNum = rand.nextInt(2); // 랜덤값 0 또는 1
        String expectedText = (ranNum == 0) ? "홀수" : "짝수"; // 0이면 홀수, 1이면 짝수
        char expected = (ranNum == 0) ? '1' : '2'; // 0이면 '1', 1이면 '2'
        char input = e.getKeyChar(); // 사용자가 입력한 값

        originalNumberLabel.setText(expectedText);

        if (input == '1' || input == '2') {
            if (input == expected) {
                score++;
                resultLabel.setText("정답입니다!");
                resultLabel.setForeground(Color.DARK_GRAY);
                scoreLabel.setText("Score: " + score);
                mainFrame.updateScore1(score); // SecondWindow로 score 업데이트
            } else {
                resultLabel.setText("틀렸습니다.");
                resultLabel.setForeground(Color.DARK_GRAY);
//                openRetryWindow();
                add(HS);
                HS.setVisible(true); // 보이게 하기
                isGameActive = false; // 게임 종료
                
            }
        } else {
            resultLabel.setText("잘못된 입력입니다. 1 또는 2만 눌러주세요.");
            resultLabel.setForeground(Color.GRAY); // 텍스트 색상 변경
        }
    }

    private void restartGame() {
        isGameActive = true; // 게임 활성화
        score = 0; // 점수 초기화
        resultLabel.setText(""); // 결과 라벨 초기화
        originalNumberLabel.setText(""); // 원래 숫자 라벨 초기화
        HS.setVisible(false);
        revalidate(); // GUI 재구성
        repaint(); // 화면 갱신
    }

    

    public static void main(String[] args) {
        // 먼저 SecondWindow를 생성하고 OneTwoGame을 실행
        SecondWindow secondWindow = new SecondWindow();  // SecondWindow 객체 생성
        new OneTwoGame(secondWindow); // mainFrame을 OneTwoGame에 전달
    }
}
