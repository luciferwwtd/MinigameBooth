package PVP;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Random;

public class SecondWindow extends JFrame implements ActionListener {
	JFrame frame = new JFrame();
	
	JLabel label = new JLabel("Choose Character!"); // 전과의 버튼과 마찬가지로 이렇게 하면 label의 텍스트를 간편하게 설정할 수 있다.
	JButton godChangSup;
	JButton meow;
	JButton faker;
	JButton steve;
	JButton gay;
	JButton random;
	
	SecondWindow() {
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
		
		faker = new JButton(); // 새로운 JButton 생성
		faker.setBounds(70, 300, 250, 100); // 버튼의 크기 설정
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
		
		steve = new JButton(); // 새로운 JButton 생성
		steve.setBounds(320, 100, 250, 100); // 버튼의 크기 설정
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
		
//		gay = new JButton(); // 새로운 JButton 생성
//		gay.setBounds(320, 200, 250, 100); // 버튼의 크기 설정
//		gay.addActionListener(this); // 버튼을 클릭했을 떄 작업을 수행할 함수 연결(
//		gay.setText("GAY(랜덤으로 돌릴 시 50%로 선택 가능)"); // 버튼의 텍스트 설정
//		gay.setFocusable(false); // 버튼 텍스트에 있는 틀을 없앤다.
//		gay.setHorizontalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수평 방향으로 버튼의 중앙(CENTER)에 정렬
//		gay.setVerticalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수직 방향으로 버튼의 중앙(CENTER)에 정렬
//		gay.setIconTextGap(-15); // 버튼에서 텍스트와 아이콘의 간격을 설정. 음수로 설정하면 가까워지고 양수로 설정하면 멀어진다.
//		gay.setForeground(Color.BLACK); // 버튼의 텍스트의 색깔을 설정한다.
//		gay.setBackground(Color.PINK); // 버튼의 색깔을 설정한다.
//		gay.setBorder(BorderFactory.createEtchedBorder()); // 버튼에 태두리를 넣는다.
//		gay.setEnabled(true); // 버튼을 활성화시킨다. false로 설정하면 누를 수 없는 버튼이 된다.
		
		random = new JButton(); // 새로운 JButton 생성
		random.setBounds(320, 200, 250, 100); // 버튼의 크기 설정
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
		frame.add(faker);
		frame.add(steve);
//		frame.add(gay);
		frame.add(random);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(670, 520);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==godChangSup) {
			System.out.println("신창섭");
		}
		if(e.getSource()==meow) {
			System.out.println("애용이");
		}
		if(e.getSource()==faker) {
			System.out.println("페이커");
		}
		if(e.getSource()==steve) {
			System.out.println("스티브");
		}
		if(e.getSource()==steve) {
			System.out.println("스티브");
		}
//		if(e.getSource()==steve) {
//			System.out.println("GAY");
//		}
		if(e.getSource()==random) {
			//
			int value = (int) (Math.random() * 10) + 1;
//			System.out.println(value);
			if(value < 7) {
				JOptionPane.showMessageDialog(null, "GAY \n GAY \n GAY \n GAY \n GAY");
			}
			if(value == 7) {
				JOptionPane.showMessageDialog(null, "신 창 섭");
			}
			if(value == 8) {
				JOptionPane.showMessageDialog(null, "애용이");
			}
			if(value == 9) {
				JOptionPane.showMessageDialog(null, "FAKER");
			}
			if(value == 10) {
				JOptionPane.showMessageDialog(null, "I, AM STEVE.Y");
			}
			
		}
	}
}
