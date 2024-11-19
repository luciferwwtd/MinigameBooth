package PVP;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import PVP.MoveThread;

public class MainGame extends JFrame implements KeyListener, Runnable {
	public JFrame frame = new JFrame();
	
	public JLabel p1, p2, riceKeyP1, riceKeyP2;
	
	public boolean P1onGround;
	public boolean P2onGround;
	public int P1HP;
	public int P2HP;
	public int monkeyStackP1, monkeyStackP2 = 0;
	
	public int FPS = 60;
	
	public boolean P1upPressed, P1downPressed, P1leftPressed, P1rightPressed, P1attackPressed, P1faceLeft;
	public boolean P2upPressed, P2downPressed, P2leftPressed, P2rightPressed, P2attackPressed, P2faceLeft;
	
	public String class1, class2;
	
	MainGame() {
		
	}
	
	MainGame(String character1, String character2) {
		p1 = new JLabel();
		p2 = new JLabel();
		riceKeyP1 = new JLabel();
		riceKeyP2 = new JLabel();
		
		P1faceLeft = false;
		P2faceLeft = true;
		
		class1 = character1;
		class2 = character2;
		
		p1.setBounds(0, 785, 130, 200); // -235
		p1.setHorizontalTextPosition(JLabel.CENTER); // 텍스트를 이미지 아이콘에 대해 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		p1.setVerticalTextPosition(JLabel.TOP); // 텍스트를 이미지 아이콘에 대해 위(TOP), 중앙(CENTER), 아래(BOTTOM)에 정렬시킨다.
		p1.setForeground(new Color(0, 0, 255)); // 텍스트의 색깔을 설정한다(RGB)
		p1.setIconTextGap(50); // 텍스트가 이미지 아이콘과 50만큼 떨어지게 설정한다. 음수로 설정하면 더 가까워진다.
		p1.setOpaque(true); // 배경색을 적용시킨다.
		p1.setHorizontalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 위(TOP), 아래(BOTTOM)에 정렬시킨다.
		p1.setVerticalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		p1.setEnabled(true);
		
		p2.setBounds(1658, 785, 130, 200); // -142
		p2.setHorizontalTextPosition(JLabel.CENTER); // 텍스트를 이미지 아이콘에 대해 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		p2.setVerticalTextPosition(JLabel.TOP); // 텍스트를 이미지 아이콘에 대해 위(TOP), 중앙(CENTER), 아래(BOTTOM)에 정렬시킨다.
		p2.setForeground(new Color(0, 0, 255)); // 텍스트의 색깔을 설정한다(RGB) 
		p2.setIconTextGap(50); // 텍스트가 이미지 아이콘과 50만큼 떨어지게 설정한다. 음수로 설정하면 더 가까워진다.
		p2.setOpaque(true); // 배경색을 적용시킨다.
		p2.setHorizontalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 위(TOP), 아래(BOTTOM)에 정렬시킨다.
		p2.setVerticalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		p2.setEnabled(true);
		
		riceKeyP1.setBounds(0, 0, 100, 100);
		riceKeyP1.setHorizontalTextPosition(JLabel.CENTER); // 텍스트를 이미지 아이콘에 대해 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		riceKeyP1.setVerticalTextPosition(JLabel.TOP); // 텍스트를 이미지 아이콘에 대해 위(TOP), 중앙(CENTER), 아래(BOTTOM)에 정렬시킨다.
		riceKeyP1.setForeground(new Color(255, 0, 0)); // 텍스트의 색깔을 설정한다(RGB) 
		riceKeyP1.setIconTextGap(50); // 텍스트가 이미지 아이콘과 50만큼 떨어지게 설정한다. 음수로 설정하면 더 가까워진다.
		riceKeyP1.setOpaque(true); // 배경색을 적용시킨다.
		riceKeyP1.setHorizontalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 위(TOP), 아래(BOTTOM)에 정렬시킨다.
		riceKeyP1.setVerticalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		riceKeyP1.setEnabled(true);
		riceKeyP1.setVisible(false);
		
		riceKeyP2.setBounds(0, 0, 100, 100);
		riceKeyP2.setHorizontalTextPosition(JLabel.CENTER); // 텍스트를 이미지 아이콘에 대해 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		riceKeyP2.setVerticalTextPosition(JLabel.TOP); // 텍스트를 이미지 아이콘에 대해 위(TOP), 중앙(CENTER), 아래(BOTTOM)에 정렬시킨다.
		riceKeyP2.setForeground(new Color(255, 0, 0)); // 텍스트의 색깔을 설정한다(RGB) 
		riceKeyP2.setIconTextGap(50); // 텍스트가 이미지 아이콘과 50만큼 떨어지게 설정한다. 음수로 설정하면 더 가까워진다.
		riceKeyP2.setOpaque(true); // 배경색을 적용시킨다.
		riceKeyP2.setHorizontalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 위(TOP), 아래(BOTTOM)에 정렬시킨다.
		riceKeyP2.setVerticalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		riceKeyP2.setEnabled(true);
		riceKeyP2.setVisible(false);
		
		p1.setBackground(Color.green);
		p2.setBackground(Color.blue);
		riceKeyP1.setBackground(Color.red);
		
		frame.add(p1);
		frame.add(p2);
		frame.add(riceKeyP1);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((screen.getWidth() - getWidth()) /2) - 900;
		int y = (int) ((screen.getHeight() -getHeight()) /2) - 520;
		frame.setLocation(x, y);
		
//		Thread moveThread = new Thread(this);
//		moveThread.start();
		
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1800, 1020);
		frame.setLayout(null);
		frame.setVisible(true);
		
		startGameThread();
	}
	
	public void startGameThread() {
		Thread moveThread = new Thread(this);
		moveThread.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			P1upPressed = true;
		}
		if(code == KeyEvent.VK_S) {
			P1downPressed = true;
		}
		if(code == KeyEvent.VK_A) {
			P1leftPressed = true;
			P1faceLeft = true;
		}
		if(code == KeyEvent.VK_D) {
			P1rightPressed = true;
			P1faceLeft = false;
		}
		if(code == KeyEvent.VK_E) {
			P1attackPressed = true;
		}
		
		if(code == KeyEvent.VK_UP) {
			P2upPressed = true;
		}
		if(code == KeyEvent.VK_DOWN) {
			P2downPressed = true;
		}
		if(code == KeyEvent.VK_LEFT) {
			P2leftPressed = true;
			P2faceLeft = true;
		}
		if(code == KeyEvent.VK_RIGHT) {
			P2rightPressed = true;
			P2faceLeft = false;
		}
		if(code == KeyEvent.VK_SHIFT) {
			P2attackPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			P1upPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			P1downPressed = false;
		}
		if(code == KeyEvent.VK_A) {
			P1leftPressed = false;
		}
		if(code == KeyEvent.VK_D) {
			P1rightPressed = false;
		}
		if(code == KeyEvent.VK_E) {
			P1attackPressed = false;
		}
		
		if(code == KeyEvent.VK_UP) {
			P2upPressed = false;
		}
		if(code == KeyEvent.VK_DOWN) {
			P2downPressed = false;
		}
		if(code == KeyEvent.VK_LEFT) {
			P2leftPressed = false;
		}
		if(code == KeyEvent.VK_RIGHT) {
			P2rightPressed = false;
		}
		if(code == KeyEvent.VK_SHIFT) {
			P2attackPressed = false;
		}
	}

	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		MoveThread moveThread = new MoveThread();
		Attack attack = new Attack();
		
		while(frame != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
//			System.out.println(delta+"delta");
//			System.out.println(timer+"timer");
//			System.out.println(lastTime+"lastTimer");
			
			if(delta >= 1) {
				moveThread.move(this, moveThread);
				attack.attack(this, class1, class2, attack);
				delta--;
				drawCount++;
			}
			
			if(timer >= 1000000000) {
//				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}
}
