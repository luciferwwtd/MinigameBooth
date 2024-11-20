package Pattern;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Touhou.MainGame;

public class Pattern3 extends Thread {
	public static JFrame main;
	public static MainGame mainGame;
	
	public static JLabel vert1, vert2, vert3, vert4, vert5;
	
	public static void getMain(JFrame frame, MainGame mainClass) {
		main = frame;
		mainGame = mainClass;
	}
	
	@Override
	public void run() {
		vert1 = new JLabel();
		vert2 = new JLabel();
		vert3 = new JLabel();
		vert4 = new JLabel();
		vert5 = new JLabel();
	
		vert1.setBounds(25, 0, 50, 700); // -235
		vert1.setBackground(Color.green);
		vert1.setOpaque(true); // 배경색을 적용시킨다.
		vert1.setEnabled(true);
		
		vert2.setBounds(175, 0, 50, 700); // -235
		vert2.setBackground(Color.green);
		vert2.setOpaque(true); // 배경색을 적용시킨다.
		vert2.setEnabled(true);
		
		vert3.setBounds(325, 0, 50, 700); // -235
		vert3.setBackground(Color.green);
		vert3.setOpaque(true); // 배경색을 적용시킨다.
		vert3.setEnabled(true);
		
		vert4.setBounds(475, 0, 50, 700); // -235
		vert4.setBackground(Color.green);
		vert4.setOpaque(true); // 배경색을 적용시킨다.
		vert4.setEnabled(true);
		
		vert5.setBounds(625, 0, 50, 700); // -235
		vert5.setBackground(Color.green);
		vert5.setOpaque(true); // 배경색을 적용시킨다.
		vert5.setEnabled(true);
		
		vert1.setVisible(true);
		vert2.setVisible(true);
		vert3.setVisible(true);
		vert4.setVisible(true);
		
		main.add(vert1);
		main.add(vert2);
		main.add(vert3);
		main.add(vert4);
		main.add(vert5);
		
		try {
			int i = 0;
			while(i < 3) {
				Thread.sleep(100);
				vert1.setBackground(Color.white);
				vert2.setBackground(Color.white);
				vert3.setBackground(Color.white);
				vert4.setBackground(Color.white);
				vert5.setBackground(Color.white);
				
				Thread.sleep(100);
				vert1.setBackground(Color.green);
				vert2.setBackground(Color.green);
				vert3.setBackground(Color.green);
				vert4.setBackground(Color.green);
				vert5.setBackground(Color.green);
				
				i++;
			}
			
			vert1.setBounds(25, 0, 50, 50);
			vert2.setBounds(175, 0, 50, 50);
			vert3.setBounds(325, 0, 50, 50);
			vert4.setBounds(475, 0, 50, 50);
			vert5.setBounds(625, 0, 50, 50);
			
			double drawInterval = 1000000000/60;
			double delta = 0;
			long lastTime = System.nanoTime();
			long currentTime;
			long timer = 0;
			int drawCount = 0;
			
			while(vert1.getY() < 750) {
				currentTime = System.nanoTime();
				
				delta += (currentTime - lastTime) / drawInterval;
				timer += (currentTime - lastTime);
				lastTime = currentTime;
				
				if(delta >= 1) {
					vert1.setLocation(vert1.getX(), vert1.getY()+25);
					vert2.setLocation(vert2.getX(), vert2.getY()+25);
					vert3.setLocation(vert3.getX(), vert3.getY()+25);
					vert4.setLocation(vert4.getX(), vert4.getY()+25);
					vert5.setLocation(vert5.getX(), vert5.getY()+25);
					
					if((-25 < mainGame.p1.getX() && mainGame.p1.getX() < 75) || (125 < mainGame.p1.getX() && mainGame.p1.getX() < 225) || (275 < mainGame.p1.getX() && mainGame.p1.getX() < 375) || (425 < mainGame.p1.getX() && mainGame.p1.getX() < 525) || (575 < mainGame.p1.getX() && mainGame.p1.getX() < 675)) {
						if(mainGame.p1.getY() < vert1.getY() + 50 && mainGame.p1.getY() + 50 > vert1.getY()) {
//							main.dispose();
							mainGame.speed = 2;
						}
					}
					delta--;
					drawCount++;
				}
				
				if(timer >= 1000000000) {
//					System.out.println("FPS:" + drawCount);
					drawCount = 0;
					timer = 0;
				}
			}
			
			vert1.setVisible(false);
			vert2.setVisible(false);
			vert3.setVisible(false);
			vert4.setVisible(false);
			vert5.setVisible(false);
			
			main.remove(vert1);
			main.remove(vert2);
			main.remove(vert3);
			main.remove(vert4);
			main.remove(vert5);
			
			Thread.sleep(15000);
			mainGame.speed = 5;
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
