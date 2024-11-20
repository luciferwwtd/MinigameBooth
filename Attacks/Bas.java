package Attacks;

import PVP.MainGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import PVP.Attack;

public class Bas extends Thread {
	public static MainGame main;
	public static boolean atkPressingP1, breakBoolean;
	public boolean initP1faceLeft;
	public static int player;
	
	public void getMain(MainGame mainGame, boolean attackPressing, int user) {
		atkPressingP1 = attackPressing;
		main = mainGame;
		player = user;
	}
	
	public void run() {
		double drawInterval = 1000000000/60;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		breakBoolean = true;
		if(player == 1) {
			initP1faceLeft = main.P1faceLeft;
		} else {
			initP1faceLeft = main.P2faceLeft;
		}
		
		double time = 0;
		int passedFrame = 0;
		
		int drawCount = 0;
		
		main.bas.setVisible(true);
		if(player == 1) {
			if(main.P1faceLeft == true) {
				main.bas.setLocation(main.p1.getX()-209, main.p1.getY()+25);
			} else {
				main.bas.setLocation(main.p1.getX()+130, main.p1.getY()+25);
			}
			
			main.bas.setBackground(null);
			main.add(main.bas);
		} else {
			if(main.P2faceLeft == true) {
				main.bas.setLocation(main.p2.getX()-209, main.p2.getY()+25);
			} else {
				main.bas.setLocation(main.p2.getX()+130, main.p2.getY()+25);
			}
			
			main.bas.setBackground(null);
			main.add(main.bas);
			
			
		}
			
		while(breakBoolean == true) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				
				if(player == 1) {
					if(main.p2.getX()+130 > main.bas.getX() && main.p2.getX() < main.bas.getX()+209 && main.p2.getY() < main.bas.getY()+98 && main.p2.getY()+200 < main.bas.getY()) {
						System.out.println("detected");
						main.P2HP -= main.P1atk;
						main.bas.setVisible(false);
						breakBoolean = false;
					}
				} else {
					if(main.p1.getX()+130 > main.bas.getX() && main.p1.getX() < main.bas.getX()+209 && main.p1.getY() < main.bas.getY()+98 && main.p1.getY()+200 < main.bas.getY()) {
						System.out.println("detected");
						main.P1HP -= main.P2atk;
						main.bas.setVisible(false);
						breakBoolean = false;
					}
				}
				
				passedFrame += 1;
				delta--;
				drawCount++;
				
				if(passedFrame == 60) {
					main.bas.setVisible(false);
					breakBoolean = false;
				}
			}
			
			if(timer >= 1000000000) {
//				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
		
		if(player == 1) {
			Attack.P1AtkPressOff();
		} else {
			Attack.P2AtkPressOff();
		}
	}
}
