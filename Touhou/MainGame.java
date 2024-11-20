package Touhou;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import PVP.MoveThread;

import Pattern.*;

public class MainGame extends JFrame implements KeyListener, Runnable {
	public JFrame frame = new JFrame();
	
	public JLabel p1;
	
	public int P1HP;
	
	public int FPS = 60;
	public int speed = 5;
	
	public boolean P1upPressed, P1downPressed, P1leftPressed, P1rightPressed;
	public static boolean Pattern2Running;
	
	public Pattern1 pattern1;
	public Pattern2 pattern2;
	
	public MainGame() {
		p1 = new JLabel();
		Pattern2Running = false;
		
		p1.setBounds(325, 325, 50, 50); // -235
		p1.setHorizontalTextPosition(JLabel.CENTER); // 텍스트를 이미지 아이콘에 대해 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		p1.setVerticalTextPosition(JLabel.TOP); // 텍스트를 이미지 아이콘에 대해 위(TOP), 중앙(CENTER), 아래(BOTTOM)에 정렬시킨다.
		p1.setForeground(new Color(0, 0, 255)); // 텍스트의 색깔을 설정한다(RGB)
		p1.setIconTextGap(50); // 텍스트가 이미지 아이콘과 50만큼 떨어지게 설정한다. 음수로 설정하면 더 가까워진다.
		p1.setOpaque(true); // 배경색을 적용시킨다.
		p1.setHorizontalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 위(TOP), 아래(BOTTOM)에 정렬시킨다.
		p1.setVerticalAlignment(JLabel.CENTER); // 아이콘과 텍스트를 label의 중앙(CENTER), 왼쪽(LEFT), 오른쪽(RIGHT)에 정렬시킨다.
		p1.setEnabled(true);
		
		p1.setBackground(Color.blue);
		
		frame.add(p1);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((screen.getWidth() - getWidth()) /2) - 350;
		int y = (int) ((screen.getHeight() -getHeight()) /2) - 350;
		
//		Thread moveThread = new Thread(this);
//		moveThread.start();
		
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(x, y, 700, 700);
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
		}
		if(code == KeyEvent.VK_D) {
			P1rightPressed = true;
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
	}

	@Override
	public void run() {
		Random ran = new Random();
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		int passedFrame = 0;
		
		while(frame != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				Touhou.MoveThread.move(this);
				delta--;
				drawCount++;
				passedFrame++;
			}
			
			if(timer >= 1000000000) {
//				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
			
			if(passedFrame == 150) {
				passedFrame = 0;
				int ranNum=ran.nextInt(4)+1;
				if(ranNum == 1) {
					Pattern1 pattern1Thread = new Pattern1();
					pattern1Thread.getMain(frame, this);
					pattern1Thread.start();
				} else if(ranNum == 2) {
						if(Pattern2Running == false) {
							Pattern2Running = true;
							Pattern2 pattern2Thread = new Pattern2();
							pattern2Thread.getMain(frame, this);
							pattern2Thread.start();
						} else {
							ranNum = ran.nextInt(2)+1;
							if(ranNum == 1) {
								Pattern1 pattern1Thread = new Pattern1();
								pattern1Thread.getMain(frame, this);
								pattern1Thread.start();
							} else if(ranNum == 2) {
								Pattern3 pattern3Thread = new Pattern3();
								pattern3Thread.getMain(frame, this);
								pattern3Thread.start();
							}
						}
				} else if(ranNum == 3) {
					Pattern3 pattern3Thread = new Pattern3();
					pattern3Thread.getMain(frame, this);
					pattern3Thread.start();
				} else if(ranNum == 4) {
					if(p1.getBackground() == Color.white) {
						ranNum = ran.nextInt(3)+1;
						if(ranNum == 1) {
							Pattern1 pattern1Thread = new Pattern1();
							pattern1Thread.getMain(frame, this);
							pattern1Thread.start();
						} else if(ranNum == 2) {
							if(Pattern2Running == false) {
								Pattern2Running = true;
								Pattern2 pattern2Thread = new Pattern2();
								pattern2Thread.getMain(frame, this);
								pattern2Thread.start();
							} else {
								ranNum = ran.nextInt(2)+1;
								if(ranNum == 1) {
									Pattern1 pattern1Thread = new Pattern1();
									pattern1Thread.getMain(frame, this);
									pattern1Thread.start();
								} else if(ranNum == 2) {
									Pattern3 pattern3Thread = new Pattern3();
									pattern3Thread.getMain(frame, this);
									pattern3Thread.start();
								}
							}
						} else if(ranNum == 3) {
							Pattern3 pattern3Thread = new Pattern3();
							pattern3Thread.getMain(frame, this);
							pattern3Thread.start();
						}
					} else {
						Pattern4 pattern4Thread = new Pattern4();
						pattern4Thread.getMain(frame, this);
						pattern4Thread.start();
					}
				}
			}
		}
	}
}
