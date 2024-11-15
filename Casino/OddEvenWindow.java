package Casino;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Random;

public class OddEvenWindow extends JFrame implements ActionListener {
	JFrame frame = new JFrame();
	
	JLabel label = new JLabel("Choose Odd or Even!"); // 전과의 버튼과 마찬가지로 이렇게 하면 label의 텍스트를 간편하게 설정할 수 있다.
	JButton odd;
	JButton even;
	
	OddEvenWindow() {
		label.setBounds(70, 10, 250, 100);
		label.setHorizontalTextPosition(JLabel.CENTER); // 텍스트를 이미지 아이콘에 대해 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		label.setVerticalTextPosition(JLabel.TOP); // 텍스트를 이미지 아이콘에 대해 위(TOP), 중앙(CENTER), 아래(BOTTOM)에 정렬시킨다.
		label.setForeground(new Color(0, 0, 255)); // 텍스트의 색깔을 설정한다(RGB) 
		label.setIconTextGap(50); // 텍스트가 이미지 아이콘과 50만큼 떨어지게 설정한다. 음수로 설정하면 더 가까워진다.
		label.setOpaque(true); // 배경색을 적용시킨다.
		label.setHorizontalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 위(TOP), 아래(BOTTOM)에 정렬시킨다.
		label.setVerticalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		
		odd = new JButton(); // 새로운 JButton 생성
		odd.setBounds(70, 100, 250, 100); // 버튼의 크기 설정
		odd.addActionListener(this); // 버튼을 클릭했을 떄 작업을 수행할 함수 연결(
		odd.setText("홀수"); // 버튼의 텍스트 설정
		odd.setFocusable(false); // 버튼 텍스트에 있는 틀을 없앤다.
		odd.setHorizontalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수평 방향으로 버튼의 중앙(CENTER)에 정렬
		odd.setVerticalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수직 방향으로 버튼의 중앙(CENTER)에 정렬
		odd.setIconTextGap(-15); // 버튼에서 텍스트와 아이콘의 간격을 설정. 음수로 설정하면 가까워지고 양수로 설정하면 멀어진다.
		odd.setForeground(Color.BLACK); // 버튼의 텍스트의 색깔을 설정한다.
		odd.setBackground(Color.WHITE); // 버튼의 색깔을 설정한다.
		odd.setBorder(BorderFactory.createEtchedBorder()); // 버튼에 태두리를 넣는다.
		odd.setEnabled(true); // 버튼을 활성화시킨다. false로 설정하면 누를 수 없는 버튼이 된다.
		
		even = new JButton(); // 새로운 JButton 생성
		even.setBounds(70, 200, 250, 100); // 버튼의 크기 설정
		even.addActionListener(this); // 버튼을 클릭했을 떄 작업을 수행할 함수 연결(
		even.setText("짝수"); // 버튼의 텍스트 설정
		even.setFocusable(false); // 버튼 텍스트에 있는 틀을 없앤다.
		even.setHorizontalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수평 방향으로 버튼의 중앙(CENTER)에 정렬
		even.setVerticalTextPosition(JButton.CENTER); // 버튼의 텍스트를 수직 방향으로 버튼의 중앙(CENTER)에 정렬
		even.setIconTextGap(-15); // 버튼에서 텍스트와 아이콘의 간격을 설정. 음수로 설정하면 가까워지고 양수로 설정하면 멀어진다.
		even.setForeground(Color.BLACK); // 버튼의 텍스트의 색깔을 설정한다.
		even.setBackground(Color.WHITE); // 버튼의 색깔을 설정한다.
		even.setBorder(BorderFactory.createEtchedBorder()); // 버튼에 태두리를 넣는다.
		even.setEnabled(true); // 버튼을 활성화시킨다. false로 설정하면 누를 수 없는 버튼이 된다.
		
		frame.add(label);
		frame.add(odd);
		frame.add(even);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 520);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Random rand=new Random();
		int ranNum=rand.nextInt(100)+1;
		int ans=0;
		if(ranNum%2==0) {
			ans=2;
		}else if(ranNum%2==1) {
			ans=1;
		}
		if(e.getSource()==odd) {
			if(ans==1) {
				JOptionPane.showMessageDialog(null, "정답입니다!");
			} else {
				JOptionPane.showMessageDialog(null, "틀렸습니다!");
			}
		}
		if(e.getSource()==even) {
			if(ans==2) {
				JOptionPane.showMessageDialog(null, "정답입니다!");
			} else {
				JOptionPane.showMessageDialog(null, "틀렸습니다!");
			}
		}
	}
}
