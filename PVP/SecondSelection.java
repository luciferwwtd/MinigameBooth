package PVP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SecondSelection extends JFrame implements ActionListener {
	JFrame frame = new JFrame();
	
	JLabel label = new JLabel("P2의 캐릭터를 선택하세요!"); // 전과의 버튼과 마찬가지로 이렇게 하면 label의 텍스트를 간편하게 설정할 수 있다.
	JButton godChangSup;
	JButton meow;
	JButton ping;
	JButton faker;
	JButton domain;
	JButton steve;
	JButton gay;
	JButton random;
	public String character;
	public int i;
	
	SecondSelection() {
		
	}
	
	SecondSelection(String character1) {
		character = character1;
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((screen.getWidth() - getWidth()) /2) - 335;
		int y = (int) ((screen.getHeight() -getHeight()) /2) - 310;
		frame.setLocation(x, y);
		
		label.setBounds(200, 10, 250, 100);
		label.setHorizontalTextPosition(JLabel.CENTER); // 텍스트를 이미지 아이콘에 대해 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		label.setVerticalTextPosition(JLabel.TOP); // 텍스트를 이미지 아이콘에 대해 위(TOP), 중앙(CENTER), 아래(BOTTOM)에 정렬시킨다.
		label.setForeground(new Color(0, 0, 255)); // 텍스트의 색깔을 설정한다(RGB) 
		label.setIconTextGap(50); // 텍스트가 이미지 아이콘과 50만큼 떨어지게 설정한다. 음수로 설정하면 더 가까워진다.
		label.setOpaque(true); // 배경색을 적용시킨다.
		label.setHorizontalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 위(TOP), 아래(BOTTOM)에 정렬시킨다.
		label.setVerticalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		
		godChangSup = new JButton(); // 새로운 JButton 생성
		godChangSup.setBounds(70, 100, 250, 100); // 버튼의 크기 설정
		godChangSup.addActionListener(this); // 버튼을 클릭했을 떄 작업을 수행할 함수 연결(
		godChangSup.setText("신창섭"); // 버튼의 텍스트 설정
		godChangSup.setFocusable(false); // 버튼 텍스트에 있는 틀을 없앤다.
		godChangSup.setHorizontalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수평 방향으로 버튼의 중앙(CENTER)에 정렬
		godChangSup.setVerticalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수직 방향으로 버튼의 중앙(CENTER)에 정렬
		godChangSup.setIconTextGap(-15); // 버튼에서 텍스트와 아이콘의 간격을 설정. 음수로 설정하면 가까워지고 양수로 설정하면 멀어진다.
		godChangSup.setForeground(Color.BLACK); // 버튼의 텍스트의 색깔을 설정한다.
		godChangSup.setBackground(Color.YELLOW); // 버튼의 색깔을 설정한다.
		godChangSup.setBorder(BorderFactory.createEtchedBorder()); // 버튼에 태두리를 넣는다.
		godChangSup.setEnabled(true); // 버튼을 활성화시킨다. false로 설정하면 누를 수 없는 버튼이 된다.
		
		meow = new JButton(); // 새로운 JButton 생성
		meow.setBounds(70, 200, 250, 100); // 버튼의 크기 설정
		meow.addActionListener(this); // 버튼을 클릭했을 떄 작업을 수행할 함수 연결(
		meow.setText("애용이"); // 버튼의 텍스트 설정
		meow.setFocusable(false); // 버튼 텍스트에 있는 틀을 없앤다.
		meow.setHorizontalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수평 방향으로 버튼의 중앙(CENTER)에 정렬
		meow.setVerticalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수직 방향으로 버튼의 중앙(CENTER)에 정렬
		meow.setIconTextGap(-15); // 버튼에서 텍스트와 아이콘의 간격을 설정. 음수로 설정하면 가까워지고 양수로 설정하면 멀어진다.
		meow.setForeground(Color.BLACK); // 버튼의 텍스트의 색깔을 설정한다.
		meow.setBackground(Color.WHITE); // 버튼의 색깔을 설정한다.
		meow.setBorder(BorderFactory.createEtchedBorder()); // 버튼에 태두리를 넣는다.
		meow.setEnabled(true); // 버튼을 활성화시킨다. false로 설정하면 누를 수 없는 버튼이 된다.
		
		ping = new JButton(); // 새로운 JButton 생성
		ping.setBounds(70, 300, 250, 100); // 버튼의 크기 설정
		ping.addActionListener(this); // 버튼을 클릭했을 떄 작업을 수행할 함수 연결(
		ping.setText("하츄핑"); // 버튼의 텍스트 설정
		ping.setFocusable(false); // 버튼 텍스트에 있는 틀을 없앤다.
		ping.setHorizontalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수평 방향으로 버튼의 중앙(CENTER)에 정렬
		ping.setVerticalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수직 방향으로 버튼의 중앙(CENTER)에 정렬
		ping.setIconTextGap(-15); // 버튼에서 텍스트와 아이콘의 간격을 설정. 음수로 설정하면 가까워지고 양수로 설정하면 멀어진다.
		ping.setForeground(Color.BLACK); // 버튼의 텍스트의 색깔을 설정한다.
		ping.setBackground(Color.PINK); // 버튼의 색깔을 설정한다.
		ping.setBorder(BorderFactory.createEtchedBorder()); // 버튼에 태두리를 넣는다.
		ping.setEnabled(true); // 버튼을 활성화시킨다. false로 설정하면 누를 수 없는 버튼이 된다.
		
		faker = new JButton(); // 새로운 JButton 생성
		faker.setBounds(70, 400, 250, 100); // 버튼의 크기 설정
		faker.addActionListener(this); // 버튼을 클릭했을 떄 작업을 수행할 함수 연결(
		faker.setText("페이커"); // 버튼의 텍스트 설정
		faker.setFocusable(false); // 버튼 텍스트에 있는 틀을 없앤다.
		faker.setHorizontalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수평 방향으로 버튼의 중앙(CENTER)에 정렬
		faker.setVerticalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수직 방향으로 버튼의 중앙(CENTER)에 정렬
		faker.setIconTextGap(-15); // 버튼에서 텍스트와 아이콘의 간격을 설정. 음수로 설정하면 가까워지고 양수로 설정하면 멀어진다.
		faker.setForeground(Color.BLACK); // 버튼의 텍스트의 색깔을 설정한다.
		faker.setBackground(Color.YELLOW); // 버튼의 색깔을 설정한다.
		faker.setBorder(BorderFactory.createEtchedBorder()); // 버튼에 태두리를 넣는다.
		faker.setEnabled(true); // 버튼을 활성화시킨다. false로 설정하면 누를 수 없는 버튼이 된다.
		
		domain = new JButton(); // 새로운 JButton 생성
		domain.setBounds(320, 100, 250, 100); // 버튼의 크기 설정
		domain.addActionListener(this); // 버튼을 클릭했을 떄 작업을 수행할 함수 연결(
		domain.setText("백종원"); // 버튼의 텍스트 설정
		domain.setFocusable(false); // 버튼 텍스트에 있는 틀을 없앤다.
		domain.setHorizontalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수평 방향으로 버튼의 중앙(CENTER)에 정렬
		domain.setVerticalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수직 방향으로 버튼의 중앙(CENTER)에 정렬
		domain.setIconTextGap(-15); // 버튼에서 텍스트와 아이콘의 간격을 설정. 음수로 설정하면 가까워지고 양수로 설정하면 멀어진다.
		domain.setForeground(Color.WHITE); // 버튼의 텍스트의 색깔을 설정한다.
		domain.setBackground(Color.BLACK); // 버튼의 색깔을 설정한다.
		domain.setBorder(BorderFactory.createEtchedBorder()); // 버튼에 태두리를 넣는다.
		domain.setEnabled(true); // 버튼을 활성화시킨다. false로 설정하면 누를 수 없는 버튼이 된다.
		
		steve = new JButton(); // 새로운 JButton 생성
		steve.setBounds(320, 200, 250, 100); // 버튼의 크기 설정
		steve.addActionListener(this); // 버튼을 클릭했을 떄 작업을 수행할 함수 연결(
		steve.setText("스티브"); // 버튼의 텍스트 설정
		steve.setFocusable(false); // 버튼 텍스트에 있는 틀을 없앤다.
		steve.setHorizontalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수평 방향으로 버튼의 중앙(CENTER)에 정렬
		steve.setVerticalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수직 방향으로 버튼의 중앙(CENTER)에 정렬
		steve.setIconTextGap(-15); // 버튼에서 텍스트와 아이콘의 간격을 설정. 음수로 설정하면 가까워지고 양수로 설정하면 멀어진다.
		steve.setForeground(Color.BLACK); // 버튼의 텍스트의 색깔을 설정한다.
		steve.setBackground(Color.WHITE); // 버튼의 색깔을 설정한다.
		steve.setBorder(BorderFactory.createEtchedBorder()); // 버튼에 태두리를 넣는다.
		steve.setEnabled(true); // 버튼을 활성화시킨다. false로 설정하면 누를 수 없는 버튼이 된다.
		
		random = new JButton(); // 새로운 JButton 생성
		random.setBounds(320, 300, 250, 100); // 버튼의 크기 설정
		random.addActionListener(this); // 버튼을 클릭했을 떄 작업을 수행할 함수 연결(
		random.setText("랜덤 선택"); // 버튼의 텍스트 설정
		random.setFocusable(false); // 버튼 텍스트에 있는 틀을 없앤다.
		random.setHorizontalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수평 방향으로 버튼의 중앙(CENTER)에 정렬
		random.setVerticalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수직 방향으로 버튼의 중앙(CENTER)에 정렬
		random.setIconTextGap(-15); // 버튼에서 텍스트와 아이콘의 간격을 설정. 음수로 설정하면 가까워지고 양수로 설정하면 멀어진다.
		random.setForeground(Color.BLACK); // 버튼의 텍스트의 색깔을 설정한다.
		random.setBackground(Color.GREEN); // 버튼의 색깔을 설정한다.
		random.setBorder(BorderFactory.createEtchedBorder()); // 버튼에 태두리를 넣는다.
		random.setEnabled(true); // 버튼을 활성화시킨다. false로 설정하면 누를 수 없는 버튼이 된다.
		
		
		frame.add(label);
		frame.add(godChangSup);
		frame.add(meow);
		frame.add(ping);
		frame.add(faker);
		frame.add(domain);
		frame.add(steve);
		frame.add(random);
		
		if(character == "신창섭") {
			godChangSup.setEnabled(false);
		} else if(character == "애용이") {
			meow.setEnabled(false);
		} else if(character == "하츄핑") {
			ping.setEnabled(false);
		} else if(character == "페이커") {
			faker.setEnabled(false);
		} else if(character == "백종원") {
			domain.setEnabled(false);
		} else if(character == "스티브") {
			steve.setEnabled(false);
		}
		
		frame.setTitle("P2 Selection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(670, 620);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		i = 0;
//		System.out.println(character);
		if(e.getSource()==godChangSup) {
			JOptionPane.showMessageDialog(null, "신 창 섭이 선택되었습니다!");
			frame.dispose();
			MainGame mainGame = new MainGame(character, "신창섭");
		} else if(e.getSource()==meow) {
			JOptionPane.showMessageDialog(null, "애용이가 선택되었습니다!");
			frame.dispose();
			MainGame mainGame = new MainGame(character, "애용이");
		} else if(e.getSource()==ping) {
			JOptionPane.showMessageDialog(null, "하츄핑이 선택되었습니다!");
			frame.dispose();
			MainGame mainGame = new MainGame(character, "하츄핑");
		} else if(e.getSource()==faker) {
			JOptionPane.showMessageDialog(null, "대상혁이 선택되었습니다!");
			frame.dispose();
			MainGame mainGame = new MainGame(character, "페이커");
		} else if(e.getSource()==domain) {
			JOptionPane.showMessageDialog(null, "백종원이 선택되었습니다!");
			frame.dispose();
			MainGame mainGame = new MainGame(character, "백종원");
		} else if(e.getSource()==steve) {
			JOptionPane.showMessageDialog(null, "스티브가 선택되었습니다!");
			frame.dispose();
			MainGame mainGame = new MainGame(character, "스티브");
		} else if(e.getSource()==random) {
			while(i==0) {
				int value = (int) (Math.random() * 12) + 1;
				if(value < 7 && character!="게이") {
					i = 1;
					JOptionPane.showMessageDialog(null, "게이가 선택ㅋㅋ되었습니다ㅋㅋㅋㅋ");
					frame.dispose();
					MainGame mainGame = new MainGame(character, "게이");
				} else if(value == 7 && character!="신창섭") {
					i = 1;
					JOptionPane.showMessageDialog(null, "신 창 섭이 선택되었습니다!");
					frame.dispose();
					MainGame mainGame = new MainGame(character, "신창섭");
				} else if(value == 8 && character!="애용이") {
					i = 1;
					JOptionPane.showMessageDialog(null, "애용이가 선택되었습니다!");
					frame.dispose();
					MainGame mainGame = new MainGame(character, "애용이");
				} else if(value == 9 && character!="하츄핑") {
					i = 1;
					JOptionPane.showMessageDialog(null, "하츄핑이 선택되었습니다!");
					frame.dispose();
					MainGame mainGame = new MainGame(character, "하츄핑");
				} else if(value == 10 && character!="페이커") {
					i = 1;
					JOptionPane.showMessageDialog(null, "대상혁이 선택되었습니다!");
					frame.dispose();
					MainGame mainGame = new MainGame(character, "페이커");
				} else if(value == 11 && character!="백종원") {
					i = 1;
					JOptionPane.showMessageDialog(null, "백종원이 선택되었습니다!");
					frame.dispose();
					MainGame mainGame = new MainGame(character, "백종원");
				} else if(value == 12 && character!="스티브") {
					i = 1;
					JOptionPane.showMessageDialog(null, "스티브가 선택되었습니다!");
					frame.dispose();
					MainGame mainGame = new MainGame(character, "스티브");
				}
			}
		}
	}
}
