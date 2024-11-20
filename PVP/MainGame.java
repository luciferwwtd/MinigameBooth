package PVP;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.ImageIcon;
//import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import PVP.MoveThread;

public class MainGame extends JFrame implements KeyListener, Runnable {
	public JFrame frame = new JFrame();
	
	public JLabel p1, p2, riceKeyP1, riceKeyP2, changUlt, soap, hider, bas;
	public JLabel P1HPDisplay, P2HPDisplay;
	
	public boolean P1onGround;
	public boolean P2onGround;
	public int P1HP, P2HP, P1atk, P2atk;
	public int monkeyStackP1, monkeyStackP2 = 0;
	
	public int FPS = 60;
	public int p1UltCooldown = 0;
	public int p2UltCooldown = 0;
	
	public boolean P1upPressed, P1downPressed, P1leftPressed, P1rightPressed, P1attackPressed, P1faceLeft, P1UltPressed;
	public boolean P2upPressed, P2downPressed, P2leftPressed, P2rightPressed, P2attackPressed, P2faceLeft, P2UltPressed;
	
	public String class1, class2;
	
	MainGame() {
		
	}
	
	MainGame(String character1, String character2) {
		p1 = new JLabel();
		p2 = new JLabel();
		riceKeyP1 = new JLabel();
		riceKeyP2 = new JLabel();
		changUlt = new JLabel();
		P1HPDisplay = new JLabel();
		P2HPDisplay = new JLabel();
		soap = new JLabel();
		hider = new JLabel();
		bas = new JLabel();
		
		P1faceLeft = false;
		P2faceLeft = true;
		
		class1 = character1;
		class2 = character2;
		
		hider.setBounds(0, 0, 1800, 1020);
		hider.setOpaque(true);
		hider.setEnabled(true);
		hider.setVisible(false);
		
		
		P1HPDisplay.setBounds(0, 0, 300, 100);
		P1HPDisplay.setHorizontalTextPosition(JLabel.CENTER); // 텍스트를 이미지 아이콘에 대해 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		P1HPDisplay.setVerticalTextPosition(JLabel.TOP); // 텍스트를 이미지 아이콘에 대해 위(TOP), 중앙(CENTER), 아래(BOTTOM)에 정렬시킨다.
		P1HPDisplay.setForeground(Color.black); // 텍스트의 색깔을 설정한다(RGB) 
		P1HPDisplay.setIconTextGap(50); // 텍스트가 이미지 아이콘과 50만큼 떨어지게 설정한다. 음수로 설정하면 더 가까워진다.
		P1HPDisplay.setOpaque(true); // 배경색을 적용시킨다.
		P1HPDisplay.setHorizontalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 위(TOP), 아래(BOTTOM)에 정렬시킨다.
		P1HPDisplay.setVerticalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		P1HPDisplay.setEnabled(true);
		P1HPDisplay.setVisible(true);
		
		P2HPDisplay.setBounds(1500, 0, 300, 100);
		P2HPDisplay.setHorizontalTextPosition(JLabel.CENTER); // 텍스트를 이미지 아이콘에 대해 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		P2HPDisplay.setVerticalTextPosition(JLabel.TOP); // 텍스트를 이미지 아이콘에 대해 위(TOP), 중앙(CENTER), 아래(BOTTOM)에 정렬시킨다.
		P2HPDisplay.setForeground(new Color(255, 0, 0)); // 텍스트의 색깔을 설정한다(RGB) 
		P2HPDisplay.setIconTextGap(50); // 텍스트가 이미지 아이콘과 50만큼 떨어지게 설정한다. 음수로 설정하면 더 가까워진다.
		P2HPDisplay.setOpaque(true); // 배경색을 적용시킨다.
		P2HPDisplay.setHorizontalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 위(TOP), 아래(BOTTOM)에 정렬시킨다.
		P2HPDisplay.setVerticalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		P2HPDisplay.setEnabled(true);
		P2HPDisplay.setVisible(true);
		
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
		
		bas.setBounds(0, 0, 209, 98);
		bas.setHorizontalTextPosition(JLabel.CENTER); // 텍스트를 이미지 아이콘에 대해 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		bas.setVerticalTextPosition(JLabel.TOP); // 텍스트를 이미지 아이콘에 대해 위(TOP), 중앙(CENTER), 아래(BOTTOM)에 정렬시킨다.
		bas.setForeground(new Color(255, 0, 0)); // 텍스트의 색깔을 설정한다(RGB) 
		bas.setIconTextGap(50); // 텍스트가 이미지 아이콘과 50만큼 떨어지게 설정한다. 음수로 설정하면 더 가까워진다.
		bas.setOpaque(true); // 배경색을 적용시킨다.
		bas.setHorizontalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 위(TOP), 아래(BOTTOM)에 정렬시킨다.
		bas.setVerticalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		bas.setEnabled(true);
		
		changUlt.setBounds(0, -300, 1800, 1800);
		changUlt.setHorizontalTextPosition(JLabel.CENTER); // 텍스트를 이미지 아이콘에 대해 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		changUlt.setVerticalTextPosition(JLabel.TOP); // 텍스트를 이미지 아이콘에 대해 위(TOP), 중앙(CENTER), 아래(BOTTOM)에 정렬시킨다.
		changUlt.setForeground(new Color(255, 0, 0)); // 텍스트의 색깔을 설정한다(RGB) 
		changUlt.setIconTextGap(50); // 텍스트가 이미지 아이콘과 50만큼 떨어지게 설정한다. 음수로 설정하면 더 가까워진다.
		changUlt.setOpaque(true); // 배경색을 적용시킨다.
		changUlt.setHorizontalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 위(TOP), 아래(BOTTOM)에 정렬시킨다.
		changUlt.setVerticalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		changUlt.setEnabled(true);
		changUlt.setVisible(false);
		
		soap.setBounds(0, 0, 100, 100);
		soap.setHorizontalTextPosition(JLabel.CENTER); // 텍스트를 이미지 아이콘에 대해 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		soap.setVerticalTextPosition(JLabel.TOP); // 텍스트를 이미지 아이콘에 대해 위(TOP), 중앙(CENTER), 아래(BOTTOM)에 정렬시킨다.
		soap.setForeground(new Color(255, 0, 0)); // 텍스트의 색깔을 설정한다(RGB) 
		soap.setIconTextGap(50); // 텍스트가 이미지 아이콘과 50만큼 떨어지게 설정한다. 음수로 설정하면 더 가까워진다.
		soap.setOpaque(true); // 배경색을 적용시킨다.
		soap.setHorizontalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 위(TOP), 아래(BOTTOM)에 정렬시킨다.
		soap.setVerticalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		soap.setEnabled(true);
		soap.setVisible(false);
		
		ImageIcon basImage = new ImageIcon("Bas.png");
		bas.setIcon(basImage);
		
		ImageIcon soapImage = new ImageIcon("ㄱㅇ무기.png");
		soap.setIcon(soapImage);
		
		ImageIcon ssalImage = new ImageIcon("쌀숭이.jpg");
		riceKeyP1.setIcon(ssalImage);
		riceKeyP2.setIcon(ssalImage);
		
		ImageIcon changUltImg = new ImageIcon("신창섭 궁.jpg");
		changUlt.setIcon(changUltImg);
		
		p1.setBackground(Color.green);
		p2.setBackground(Color.blue);
		bas.setBackground(Color.orange);
		
		
		if(character1.equals("신창섭")) {
			P1HP = 400;
			P1atk = 10;
			p1.setBackground(null);
			ImageIcon imageIcon = new ImageIcon("신창섭캐릭터.gif");
			p1.setIcon(imageIcon);
		} else if(character1.equals("게이")) {
			P1HP = 400;
			P1atk = 10;
			p1.setBackground(null);
			ImageIcon imageIcon = new ImageIcon("ㄱㅇ.png");
			p1.setIcon(imageIcon);
		} else if(character1.equals("페이커")) {
			P1HP = 400;
			P1atk = 2;
			p1.setBackground(null);
			ImageIcon imageIcon = new ImageIcon("페이커캐릭터.png");
			p1.setIcon(imageIcon);
		} else if(character1.equals("백종원")) {
			P1HP = 500;
			P1atk = 20;
			p1.setBackground(null);
			ImageIcon imageIcon = new ImageIcon("백종원캐릭터.png");
			p1.setIcon(imageIcon);
		}
		
		if(character2.equals("신창섭")) {
			P2HP = 400;
			P2atk = 10;
			p2.setBackground(null);
			ImageIcon imageIcon = new ImageIcon("신창섭캐릭터.gif");
			p2.setIcon(imageIcon);;
		} else if(character2.equals("게이")) {
			P2HP = 400;
			P2atk = 10;
			p2.setBackground(null);
			ImageIcon imageIcon = new ImageIcon("ㄱㅇ.png");
			p2.setIcon(imageIcon);
		} else if(character2.equals("페이커")) {
			P2HP = 400;
			P2atk = 2;
			p2.setBackground(null);
			ImageIcon imageIcon = new ImageIcon("페이커캐릭터.png");
			p2.setIcon(imageIcon);
		} else if(character2.equals("백종원")) {
			P2HP = 500;
			P2atk = 20;
			p2.setBackground(null);
			ImageIcon imageIcon = new ImageIcon("백종원캐릭터.png");
			p2.setIcon(imageIcon);
		}
		
		frame.add(p1);
		frame.add(p2);
		frame.add(riceKeyP1);
		frame.add(riceKeyP2);
		frame.add(changUlt);
		frame.add(P1HPDisplay);
		frame.add(P2HPDisplay);
		frame.add(soap);
		frame.add(hider);
		frame.add(bas);
		
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
		if(code == KeyEvent.VK_F) {
			P1UltPressed = true;
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
		if(code == KeyEvent.VK_ENTER) {
			P2UltPressed = true;
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
		if(code == KeyEvent.VK_F) {
			P1UltPressed = false;
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
		if(code == KeyEvent.VK_ENTER) {
			P2UltPressed = false;
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
		int passedFrame = 0;
		
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
				P1HPDisplay.setText("플레이어 1 체력: " + P1HP);
				P2HPDisplay.setText("플레이어 2 체력: " + P2HP);
				passedFrame++;
				delta--;
				drawCount++;
				
				if(P1HP <= 0) {
					JOptionPane.showMessageDialog(null, "플레이어 2가 승리했습니다!");
				} else if (P2HP <= 0) {
					JOptionPane.showMessageDialog(null, "플레이어 1이 승리했습니다!");
				}
			}
			
			if(timer >= 1000000000) {
//				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
			
			if(passedFrame == 60) {
				if(p1UltCooldown > 0) {
					p1UltCooldown--;
				}
				if(p2UltCooldown > 0) {
					p2UltCooldown--;
				}
				passedFrame = 0;
			}
		}
	}
}
