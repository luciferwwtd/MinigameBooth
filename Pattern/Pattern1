package Pattern;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Touhou.MainGame;

public class Pattern1 extends Thread {
	public static JFrame main;
	public static MainGame mainGame;
	
	public static JLabel vert1, vert2, vert3, vert4, hor1, hor2, hor3, hor4;
	
	public static void getMain(JFrame frame, MainGame mainClass) {
		main = frame;
		mainGame = mainClass;
	}
	
	@Override
	public void run() {
		hor1 = new JLabel();
		hor2 = new JLabel();
		hor3 = new JLabel();
		hor4 = new JLabel();
		vert1 = new JLabel();
		vert2 = new JLabel();
		vert3 = new JLabel();
		vert4 = new JLabel();
	
		vert1.setBounds(100, 0, 50, 700); // -235
		vert1.setBackground(Color.pink);
		vert1.setOpaque(true); // 배경색을 적용시킨다.
		vert1.setEnabled(true);
		
		vert2.setBounds(250, 0, 50, 700); // -235
		vert2.setBackground(Color.pink);
		vert2.setOpaque(true); // 배경색을 적용시킨다.
		vert2.setEnabled(true);
		
		vert3.setBounds(400, 0, 50, 700); // -235
		vert3.setBackground(Color.pink);
		vert3.setOpaque(true); // 배경색을 적용시킨다.
		vert3.setEnabled(true);
		
		vert4.setBounds(550, 0, 50, 700); // -235
		vert4.setBackground(Color.pink);
		vert4.setOpaque(true); // 배경색을 적용시킨다.
		vert4.setEnabled(true);
		
		hor1.setBounds(0, 100, 700, 50); // -235
		hor1.setBackground(Color.pink);
		hor1.setOpaque(true); // 배경색을 적용시킨다.
		hor1.setEnabled(true);
		
		hor2.setBounds(0, 250, 700, 50); // -235
		hor2.setBackground(Color.pink);
		hor2.setOpaque(true); // 배경색을 적용시킨다.
		hor2.setEnabled(true);
		
		hor3.setBounds(0, 400, 700, 50); // -235
		hor3.setBackground(Color.pink);
		hor3.setOpaque(true); // 배경색을 적용시킨다.
		hor3.setEnabled(true);
		
		hor4.setBounds(0, 550, 700, 50); // -235
		hor4.setBackground(Color.pink);
		hor4.setOpaque(true); // 배경색을 적용시킨다.
		hor4.setEnabled(true);
		
		hor1.setVisible(true);
		hor2.setVisible(true);
		hor3.setVisible(true);
		hor4.setVisible(true);
		vert1.setVisible(true);
		vert2.setVisible(true);
		vert3.setVisible(true);
		vert4.setVisible(true);
		
		main.add(hor1);
		main.add(hor2);
		main.add(hor3);
		main.add(hor4);
		main.add(vert1);
		main.add(vert2);
		main.add(vert3);
		main.add(vert4);
		
		try {
			int i = 0;
			while(i < 5) {
				Thread.sleep(100);
				vert1.setBackground(Color.red);
				vert2.setBackground(Color.red);
				vert3.setBackground(Color.red);
				vert4.setBackground(Color.red);
				hor1.setBackground(Color.red);
				hor2.setBackground(Color.red);
				hor3.setBackground(Color.red);
				hor4.setBackground(Color.red);
				
				Thread.sleep(100);
				vert1.setBackground(Color.pink);
				vert2.setBackground(Color.pink);
				vert3.setBackground(Color.pink);
				vert4.setBackground(Color.pink);
				hor1.setBackground(Color.pink);
				hor2.setBackground(Color.pink);
				hor3.setBackground(Color.pink);
				hor4.setBackground(Color.pink);
				
				i++;
			}
			
			vert1.setBackground(Color.red);
			vert2.setBackground(Color.red);
			vert3.setBackground(Color.red);
			vert4.setBackground(Color.red);
			hor1.setBackground(Color.red);
			hor2.setBackground(Color.red);
			hor3.setBackground(Color.red);
			hor4.setBackground(Color.red);
			
			double drawInterval = 1000000000/60;
			double delta = 0;
			long lastTime = System.nanoTime();
			long currentTime;
			long timer = 0;
			int drawCount = 0;
			int passedFrame = 0;
			
			while(passedFrame < 60) {
				currentTime = System.nanoTime();
				
				delta += (currentTime - lastTime) / drawInterval;
				timer += (currentTime - lastTime);
				lastTime = currentTime;
				
				if(delta >= 1) {
					if((50 < mainGame.p1.getX() && mainGame.p1.getX() < 150) || (200 < mainGame.p1.getX() && mainGame.p1.getX() < 300) || (350 < mainGame.p1.getX() && mainGame.p1.getX() < 450) || (500 < mainGame.p1.getX() && mainGame.p1.getX() < 600)) {
						main.dispose();
//						MainGame newMain = new MainGame();
					}
					if((50 < mainGame.p1.getY() && mainGame.p1.getY() < 150) || (200 < mainGame.p1.getY() && mainGame.p1.getY() < 300) || (350 < mainGame.p1.getY() && mainGame.p1.getY() < 450) || (500 < mainGame.p1.getY() && mainGame.p1.getY() < 600)) {
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
			
			hor1.setVisible(false);
			hor2.setVisible(false);
			hor3.setVisible(false);
			hor4.setVisible(false);
			vert1.setVisible(false);
			vert2.setVisible(false);
			vert3.setVisible(false);
			vert4.setVisible(false);
			
			main.remove(hor1);
			main.remove(hor2);
			main.remove(hor3);
			main.remove(hor4);
			main.remove(vert1);
			main.remove(vert2);
			main.remove(vert3);
			main.remove(vert4);
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
