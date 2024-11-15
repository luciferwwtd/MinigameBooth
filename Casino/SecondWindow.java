package Casino;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SecondWindow extends JFrame implements ActionListener {
	JFrame frame = new JFrame();
	
	JLabel label = new JLabel("Choose Game!"); // 전과의 버튼과 마찬가지로 이렇게 하면 label의 텍스트를 간편하게 설정할 수 있다.
	JButton oddEven;
	JButton blackJack;
	JButton poker;
	
	SecondWindow() {
		label.setBounds(70, 10, 250, 100);
		label.setHorizontalTextPosition(JLabel.CENTER); // 텍스트를 이미지 아이콘에 대해 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		label.setVerticalTextPosition(JLabel.TOP); // 텍스트를 이미지 아이콘에 대해 위(TOP), 중앙(CENTER), 아래(BOTTOM)에 정렬시킨다.
		label.setForeground(new Color(0, 0, 255)); // 텍스트의 색깔을 설정한다(RGB) 
		label.setIconTextGap(50); // 텍스트가 이미지 아이콘과 50만큼 떨어지게 설정한다. 음수로 설정하면 더 가까워진다.
		label.setOpaque(true); // 배경색을 적용시킨다.
		label.setHorizontalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 위(TOP), 아래(BOTTOM)에 정렬시킨다.
		label.setVerticalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		
		oddEven = new JButton(); // 새로운 JButton 생성
		oddEven.setBounds(70, 100, 250, 100); // 버튼의 크기 설정
		oddEven.addActionListener(this); // 버튼을 클릭했을 떄 작업을 수행할 함수 연결(
		oddEven.setText("홀짝"); // 버튼의 텍스트 설정
		oddEven.setFocusable(false); // 버튼 텍스트에 있는 틀을 없앤다.
		oddEven.setHorizontalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수평 방향으로 버튼의 중앙(CENTER)에 정렬
		oddEven.setVerticalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수직 방향으로 버튼의 중앙(CENTER)에 정렬
		oddEven.setIconTextGap(-15); // 버튼에서 텍스트와 아이콘의 간격을 설정. 음수로 설정하면 가까워지고 양수로 설정하면 멀어진다.
		oddEven.setForeground(Color.BLACK); // 버튼의 텍스트의 색깔을 설정한다.
		oddEven.setBackground(Color.WHITE); // 버튼의 색깔을 설정한다.
		oddEven.setBorder(BorderFactory.createEtchedBorder()); // 버튼에 태두리를 넣는다.
		oddEven.setEnabled(true); // 버튼을 활성화시킨다. false로 설정하면 누를 수 없는 버튼이 된다.
		
		blackJack = new JButton(); // 새로운 JButton 생성
		blackJack.setBounds(70, 200, 250, 100); // 버튼의 크기 설정
		blackJack.addActionListener(this); // 버튼을 클릭했을 떄 작업을 수행할 함수 연결(
		blackJack.setText("블랙잭"); // 버튼의 텍스트 설정
		blackJack.setFocusable(false); // 버튼 텍스트에 있는 틀을 없앤다.
		blackJack.setHorizontalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수평 방향으로 버튼의 중앙(CENTER)에 정렬
		blackJack.setVerticalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수직 방향으로 버튼의 중앙(CENTER)에 정렬
		blackJack.setIconTextGap(-15); // 버튼에서 텍스트와 아이콘의 간격을 설정. 음수로 설정하면 가까워지고 양수로 설정하면 멀어진다.
		blackJack.setForeground(Color.BLACK); // 버튼의 텍스트의 색깔을 설정한다.
		blackJack.setBackground(Color.WHITE); // 버튼의 색깔을 설정한다.
		blackJack.setBorder(BorderFactory.createEtchedBorder()); // 버튼에 태두리를 넣는다.
		blackJack.setEnabled(true); // 버튼을 활성화시킨다. false로 설정하면 누를 수 없는 버튼이 된다.
		
		poker = new JButton(); // 새로운 JButton 생성
		poker.setBounds(70, 300, 250, 100); // 버튼의 크기 설정
		poker.addActionListener(this); // 버튼을 클릭했을 떄 작업을 수행할 함수 연결(
		poker.setText("포커"); // 버튼의 텍스트 설정
		poker.setFocusable(false); // 버튼 텍스트에 있는 틀을 없앤다.
		poker.setHorizontalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수평 방향으로 버튼의 중앙(CENTER)에 정렬
		poker.setVerticalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수직 방향으로 버튼의 중앙(CENTER)에 정렬
		poker.setIconTextGap(-15); // 버튼에서 텍스트와 아이콘의 간격을 설정. 음수로 설정하면 가까워지고 양수로 설정하면 멀어진다.
		poker.setForeground(Color.BLACK); // 버튼의 텍스트의 색깔을 설정한다.
		poker.setBackground(Color.WHITE); // 버튼의 색깔을 설정한다.
		poker.setBorder(BorderFactory.createEtchedBorder()); // 버튼에 태두리를 넣는다.
		poker.setEnabled(true); // 버튼을 활성화시킨다. false로 설정하면 누를 수 없는 버튼이 된다.
		
		
		
		
		frame.add(label);
		frame.add(blackJack);
		frame.add(poker);
		frame.add(oddEven);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 520);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==oddEven) {
			this.dispose();
			OddEvenWindow secondWindow = new OddEvenWindow(); // SecondWindow 화면을 새로 생성해낸다.(JFrameTest에서 하던것과 같이)
		}
		if(e.getSource()==blackJack) {
			System.out.println("블랙잭");
		}
		if(e.getSource()==poker) {
			System.out.println("포커");
		}
	}
}
