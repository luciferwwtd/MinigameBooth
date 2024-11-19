package PVP;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class MyFrame extends JFrame implements ActionListener {
	JButton button;
	JLabel label;
	
	MyFrame(){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((screen.getWidth() - getWidth()) /2) - 250;
		int y = (int) ((screen.getHeight() -getHeight()) /2) - 150;
		this.setLocation(x, y);
		
		button = new JButton(); // 새로운 JButton 생성
		button.setBounds(110, 100, 250, 100); // 버튼의 크기 설정
		button.addActionListener(this); // 버튼을 클릭했을 떄 작업을 수행할 함수 연결(
		button.setText("GAME START"); // 버튼의 텍스트 설정
		button.setFocusable(false); // 버튼 텍스트에 있는 틀을 없앤다.
		button.setHorizontalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수평 방향으로 버튼의 중앙(CENTER)에 정렬
		button.setVerticalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수직 방향으로 버튼의 중앙(CENTER)에 정렬
		button.setIconTextGap(-15); // 버튼에서 텍스트와 아이콘의 간격을 설정. 음수로 설정하면 가까워지고 양수로 설정하면 멀어진다.
		button.setForeground(Color.BLACK); // 버튼의 텍스트의 색깔을 설정한다.
		button.setBackground(Color.WHITE); // 버튼의 색깔을 설정한다.
		button.setBorder(BorderFactory.createEtchedBorder()); // 버튼에 태두리를 넣는다.
		button.setEnabled(true); // 버튼을 활성화시킨다. false로 설정하면 누를 수 없는 버튼이 된다.
		
		JLabel label = new JLabel(); // 새로운 JLabel 생성
		
		label.setText("PVP"); // 텍스트를 설정한다.
		label.setHorizontalTextPosition(JLabel.CENTER); // 텍스트를 이미지 아이콘에 대해 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		label.setVerticalTextPosition(JLabel.TOP); // 텍스트를 이미지 아이콘에 대해 위(TOP), 중앙(CENTER), 아래(BOTTOM)에 정렬시킨다.
		label.setForeground(new Color(0, 0, 255)); // 텍스트의 색깔을 설정한다(RGB) 
		label.setIconTextGap(50); // 텍스트가 이미지 아이콘과 50만큼 떨어지게 설정한다. 음수로 설정하면 더 가까워진다.
		label.setOpaque(true); // 배경색을 적용시킨다.
		label.setHorizontalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 위(TOP), 아래(BOTTOM)에 정렬시킨다.
		label.setVerticalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		label.setBounds(110, 10, 250, 100); // Label의 위치(x, y), 크기(x, y)를 설정한다.
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Pvp Game"); // 화면의 제목을 설정한다.
		this.setSize(500, 300);
		this.setVisible(true);
		this.add(button); // 화면에 button을 추가시킨다.
		this.add(label);
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			this.dispose();
			FirstSelection firstSelection = new FirstSelection(); // SecondWindow 화면을 새로 생성해낸다.(JFrameTest에서 하던것과 같이)
		}
	}
}
