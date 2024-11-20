package Pattern;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Touhou.MainGame;

public class Pattern2 extends Thread {
	public static JFrame main;
	public static MainGame mainGame;
	
	public static JLabel wall;
	
	public static void getMain(JFrame frame, MainGame mainClass) {
		main = frame;
		mainGame = mainClass;
	}
	
	@Override
	public void run() {
		wall = new JLabel();
	
		wall.setBounds(350, 0, 350, 700); // -235
		wall.setBackground(Color.pink);
		wall.setOpaque(true); // 배경색을 적용시킨다.
		wall.setEnabled(true);
		
		wall.setVisible(true);
		
		main.add(wall);
		
		try {
			int i = 0;
			while(i < 10) {
				Thread.sleep(100);
				wall.setBackground(Color.red);
				
				Thread.sleep(100);
				wall.setBackground(Color.pink);
				
				i++;
			}
			
			wall.setBackground(Color.red);
			
			double drawInterval = 1000000000/60;
			double delta = 0;
			long lastTime = System.nanoTime();
			long currentTime;
			long timer = 0;
			int drawCount = 0;
			int passedFrame = 0;
			
			while(passedFrame < 1800) {
				currentTime = System.nanoTime();
				
				delta += (currentTime - lastTime) / drawInterval;
				timer += (currentTime - lastTime);
				lastTime = currentTime;
				
				if(delta >= 1) {
					if(mainGame.p1.getX() > 300) {
						main.dispose();
//						MainGame newMain = new MainGame();
					}
					delta--;
					drawCount++;
					passedFrame++;
				}
				
				if(timer >= 1000000000) {
//					System.out.println("FPS:" + drawCount);
					drawCount = 0;
					timer = 0;
				}
			}
			
			wall.setVisible(false);
			
			main.remove(wall);
			mainGame.Pattern2Running = false;
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
