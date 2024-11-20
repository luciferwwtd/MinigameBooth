package Casino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.border.Border;

public class Blackjack extends JFrame implements KeyListener {
   JLabel score = new JLabel("승: 0  패: 0");

    int win = 0;
    int lose = 0;
    JButton backButton = new JButton("돌아가기");

    private SecondWindow mainFrame2; // SecondWindow 참조 추가
    
    private static final int CARD_LIMIT = 21; // 블랙잭 점수 제한
    private JLabel instructionsLabel;  // 사용법 라벨
    private JLabel scoreLabel;         // 점수 표시 라벨
    private JLabel dealerLabel;        // 딜러 카드 표시 라벨
    private JLabel playerLabel;        // 플레이어 카드 표시 라벨
    private JLabel HS;  
    private JButton restartButton;     // 게임 재시작 버튼
    private JPanel panel;
    

    private List deck;         // 카드 덱
    private List playerHand;   // 플레이어 손패
    private List dealerHand;   // 딜러 손패
    private int playerScore;           // 플레이어 점수
    private int dealerScore;           // 딜러 점수
    private boolean isGameActive; // 게임 상태 관리 플래그

    public Blackjack(SecondWindow mainFrame) {
        this.mainFrame2 = mainFrame; // SecondWindow 참조 저장
        
       // JFrame 설정
        setTitle("카지노 게임 - 블랙잭");
        setSize(700, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 241, 255));
        
        Border border = BorderFactory.createLineBorder(new Color(201, 130, 107), 10); // 초록색(Color.green)의 3만큼의 두께를 가진 테두리 선을 생성한다.
        
        panel = new JPanel(); // 새로운 JPanel을 생성한다.
        panel.setBackground(new Color(139, 236, 143)); // 배경색을 빨간색으로 설정한다.
      panel.setBounds(700/2-500/2-5, 100, 500, 500); // 이 JPanel의 위치와 크기를 설정한다.
      panel.setLayout(null);
      panel.setBorder(border); // 태두리 선을 적용시킨다.
      
      HS = new JLabel("재시작(r)");
        HS.setBounds(520, 62, 700, 50);
        HS.setForeground(Color.DARK_GRAY);
        HS.setFont(new Font(null, Font.PLAIN, 17));


        // 라벨 초기화
        instructionsLabel = new JLabel("Hit(H) 또는 Stand(S)를 누르세요.");
        instructionsLabel.setBounds(75, 25, 700, 50);
        instructionsLabel.setForeground(Color.BLACK);
        instructionsLabel.setFont(new Font(null, Font.PLAIN, 37));

        scoreLabel = new JLabel("내 점수: ");
        scoreLabel.setBounds(240, 160, 300, 40);
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setFont(new Font(null, Font.BOLD, 30));

        dealerLabel = new JLabel("딜러 카드: ");
        dealerLabel.setBounds(240, 240, 300, 40);
        dealerLabel.setForeground(Color.BLACK);
        dealerLabel.setFont(new Font(null, Font.BOLD, 30));

        playerLabel = new JLabel("내 카드: ");
        playerLabel.setBounds(240, 320, 300, 40);
        playerLabel.setForeground(Color.BLACK);
        playerLabel.setFont(new Font(null, Font.BOLD, 30));

        score.setBounds(30, 3, 200, 30);
        score.setFont(new Font(null, Font.BOLD, 18));
        
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

        // 컴포넌트 추가
        add(instructionsLabel);
        add(scoreLabel);
        add(dealerLabel);
        add(playerLabel);
        add(panel);
        add(score);

        addKeyListener(this); // KeyListener 등록
        setFocusable(true);   // 포커스 설정
        requestFocusInWindow(); // JFrame에 포커스 강제 설정

        // 게임 자동 시작
        startGame();

        setVisible(true);
    }

    
    private void startGame() {
        // 게임 초기화
       isGameActive = true; // 게임 상태 활성화
        deck = createDeck();
        Collections.shuffle(deck);
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();

        // 초기 카드 분배
        dealCard(playerHand);
        dealCard(playerHand);
        dealCard(dealerHand);
        dealCard(dealerHand);

        updateLabels();
        
        add(instructionsLabel);
        add(scoreLabel);
        add(dealerLabel);
        add(playerLabel);
        add(panel);

    }

    private void dealCard(List<String> hand) {
        if (!deck.isEmpty()) {
            hand.add((String) deck.remove(0));
        }
    }

    private int getHandValue(List<String> hand) {
        int value = 0;
        int aces = 0;

        for (String card : hand) {
            if (card.equals("J") || card.equals("Q") || card.equals("K")) {
                value += 10;
            } else if (card.equals("A")) {
                aces++;
            } else {
                value += Integer.parseInt(card);
            }
        }

        for (int i = 0; i < aces; i++) {
            if (value + 11 > CARD_LIMIT) {
                value += 1;
            } else {
                value += 11;
            }
        }

        return value;
    }

    private List<String> createDeck() {
        List<String> deck = new ArrayList<>();
        for (int i = 2; i <= 10; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(String.valueOf(i));
            }
        }
        for (int i = 0; i < 4; i++) {
            deck.add("J");
            deck.add("Q");
            deck.add("K");
            deck.add("A");
        }
        return deck;
    }

    private void updateLabels() {
        playerScore = getHandValue(playerHand);
        dealerScore = getHandValue(dealerHand);

        scoreLabel.setText("내 점수: " + playerScore);
        playerLabel.setText("내 카드: " + playerHand);
        
     // 딜러의 첫 번째 카드만 공개, 나머지는 숨김
        if (dealerHand.size() > 1) {
            dealerLabel.setText("딜러 카드: " + dealerHand.get(0) + ", *");
        } else {
            dealerLabel.setText("딜러 카드: " + dealerHand);
        }
        
        if (playerScore > CARD_LIMIT) {
            instructionsLabel.setText("버스트! 패배하였습니다.");
            instructionsLabel.setBounds(140, 25, 700, 50);
            instructionsLabel.setForeground(Color.BLACK);
            instructionsLabel.setFont(new Font(null, Font.BOLD, 37));
            
            isGameActive = false; // 게임 종료
            
            showRestartOption(); // 재시작 옵션 제공
            
            lose++;
            score.setText("승: " + win + "  패: " + lose);
            mainFrame2.updateScore2(win, lose); // SecondWindow로 score 업데이트
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!isGameActive) return; // 게임 종료 시 동작 제한

        if (e.getKeyChar() == 'h') { // Hit
            dealCard(playerHand);
            updateLabels();
        } else if (e.getKeyChar() == 's') { // Stand
            dealerTurn();
        } else if (e.getKeyChar() == 'r') { // Restart
            restartGame();
        }
    }

    private void dealerTurn() {
        // 딜러의 턴 시작 메시지
        instructionsLabel.setText("딜러의 턴...");

        // 딜러가 17점 이상이 될 때까지 카드 받기
        while (dealerScore < 17) {
            dealCard(dealerHand);
            dealerScore = getHandValue(dealerHand);
        }

        // 딜러의 모든 카드 공개
        dealerLabel.setText("딜러 카드: " + dealerHand);

        updateLabels();

        // 결과 확인 및 승패 결정
        determineWinner();
    }

    private void determineWinner() {
        isGameActive = false; // 게임 종료
        
        if (dealerScore > CARD_LIMIT) {
            instructionsLabel.setText("딜러의 버스트! 승리하였습니다!");
            instructionsLabel.setBounds(77, 25, 700, 50);
            instructionsLabel.setForeground(Color.BLACK);
            instructionsLabel.setFont(new Font(null, Font.BOLD, 37));

            win++;
            score.setText("승: " + win + "  패: " + lose);
            mainFrame2.updateScore2(win, lose); // SecondWindow로 score 업데이트
            
        } else if (playerScore > dealerScore) {
            instructionsLabel.setText("승리하였습니다!");
            instructionsLabel.setBounds(200, 25, 700, 50);
            instructionsLabel.setForeground(Color.BLACK);
            instructionsLabel.setFont(new Font(null, Font.BOLD, 37));

            win++;
            score.setText("승: " + win + "  패: " + lose);
            mainFrame2.updateScore2(win,lose); // SecondWindow로 score 업데이트
            
        } else if (playerScore < dealerScore) {
            instructionsLabel.setText("패배하였습니다.");
            instructionsLabel.setBounds(200, 25, 700, 50);
            instructionsLabel.setForeground(Color.BLACK);
            instructionsLabel.setFont(new Font(null, Font.BOLD, 37));

            lose++;
            score.setText("승: " + win + "  패: " + lose);
            mainFrame2.updateScore2(win, lose); // SecondWindow로 score 업데이트
            
        } else {
            instructionsLabel.setText("무승부!");
            instructionsLabel.setBounds(280, 25, 700, 50);
            instructionsLabel.setForeground(Color.BLACK);
            instructionsLabel.setFont(new Font(null, Font.BOLD, 37));
            
        }
     // 딜러의 모든 카드 최종 확인
        dealerLabel.setText("딜러 카드: " + dealerHand);
    
        showRestartOption();
    }
    
    private void showRestartOption() {
        // 재시작 버튼 또는 키보드 입력 옵션 제공
        add(HS);
        addKeyListenerToRestart();
    }

    private void addKeyListenerToRestart() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'r') {
                    restartGame();
                }
            }
        });
        
    }
    
 // 게임 재시작 로직
    private void restartGame() {
       instructionsLabel.setText("Hit(H) 또는 Stand(S)를 누르세요.");
        instructionsLabel.setBounds(75, 25, 700, 50);
        instructionsLabel.setForeground(Color.BLACK);
        instructionsLabel.setFont(new Font(null, Font.PLAIN, 37));
        startGame();
    }


    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new SecondWindow(); // SecondWindow에서 Blackjack을 호출할 수 있도록 변경
    }
}

