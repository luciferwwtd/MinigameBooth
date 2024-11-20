package Attacks;

import PVP.MainGame;
import PVP.Attack;

public class GodChangSupP1 extends Thread {
	public static MainGame main;
	public static boolean atkPressingP1, breakBoolean;
	public boolean initP1faceLeft;
	
	public void getMain(MainGame mainGame, boolean atkPressing, Attack attack) {
		main = mainGame;
		atkPressingP1 = atkPressing;
	}
	
	public void run() {
		double drawInterval = 1000000000/60;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		breakBoolean = true;
		initP1faceLeft = main.P1faceLeft;
		
		double time = 0;
		int passedFrame = 0;
		
		int drawCount = 0;
		
		main.riceKeyP1.setVisible(true);
		if(initP1faceLeft == true) {
			main.riceKeyP1.setLocation(main.p1.getX()-100, main.p1.getY()+50);
		} else if(initP1faceLeft == false) {
			main.riceKeyP1.setLocation(main.p1.getX()+100, main.p1.getY()+50);
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
					main.riceKeyP1.setLocation(main.riceKeyP1.getX()-20, main.riceKeyP1.getY());
				} else if(initP1faceLeft == false) {
					main.riceKeyP1.setLocation(main.riceKeyP1.getX()+20, main.riceKeyP1.getY());
				}
				
				
				if(-100 < main.riceKeyP1.getX() - main.p2.getX() && main.riceKeyP1.getX() - main.p2.getX() < 130 && -100 < main.riceKeyP1.getY() - main.p2.getY() && main.riceKeyP1.getY() - main.p2.getY() < 200) {
					main.riceKeyP1.setVisible(false);
					main.P2HP -= main.P1atk;
					main.monkeyStackP2 += 1;
					breakBoolean = false;
				}
				
				if(main.riceKeyP1.getX() > 1800 || main.riceKeyP1.getX() < -100) {
					main.riceKeyP1.setVisible(false);
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
		
		Attack.P1AtkPressOff();
	}
}
