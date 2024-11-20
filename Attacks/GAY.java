package Attacks;

import PVP.MainGame;
import PVP.Attack;

public class GAY extends Thread {
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
		
		main.soap.setVisible(true);
		if(initP1faceLeft == true) {
			if(player == 1) {
				main.soap.setLocation(main.p1.getX()-100, main.p1.getY()+50);
			} else {
				main.soap.setLocation(main.p2.getX()-100, main.p2.getY()+50);
			}
		} else if(initP1faceLeft == false) {
			if(player == 1) {
				main.soap.setLocation(main.p1.getX()+100, main.p1.getY()+50);
			} else {
				main.soap.setLocation(main.p2.getX()+100, main.p2.getY()+50);
			}
		}
		
		while(breakBoolean == true) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				passedFrame += 1;
				delta--;
				drawCount++;
				
				if(initP1faceLeft == true) {
					main.soap.setLocation(main.soap.getX()-20, main.soap.getY());
				} else if(initP1faceLeft == false) {
					main.soap.setLocation(main.soap.getX()+20, main.soap.getY());
				}
				
				if(player == 1) {
					if(-100 < main.soap.getX() - main.p2.getX() && main.soap.getX() - main.p2.getX() < 130 && -100 < main.soap.getY() - main.p2.getY() && main.soap.getY() - main.p2.getY() < 200) {
						main.soap.setVisible(false);
						if(initP1faceLeft == main.P2faceLeft) {
							main.P2HP -= main.P1atk*2;
						} else {
							main.P2HP -= main.P1atk;
						}
						breakBoolean = false;
					}
				} else {
					if(-100 < main.soap.getX() - main.p1.getX() && main.soap.getX() - main.p1.getX() < 130 && -100 < main.soap.getY() - main.p1.getY() && main.soap.getY() - main.p1.getY() < 200) {
						main.soap.setVisible(false);
						if(initP1faceLeft == main.P1faceLeft) {
							main.P1HP -= main.P2atk*2;
						} else {
							main.P1HP -= main.P2atk;
						}
						breakBoolean = false;
					}
				}
				
				
				if(main.soap.getX() > 1800 || main.soap.getX() < -100) {
					main.soap.setVisible(false);
					breakBoolean = false;
				}
			}
			
			if(timer >= 1000000000) {
//				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
		
		try {
			Thread.sleep(1000); //1초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(player == 1) {
			Attack.P1AtkPressOff();
		} else {
			Attack.P2AtkPressOff();
		}
	}
}
