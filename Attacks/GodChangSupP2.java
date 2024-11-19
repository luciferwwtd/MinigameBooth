package Attacks;

import PVP.MainGame;
import PVP.Attack;

public class GodChangSupP2 extends Thread {
	public static MainGame main;
	public static boolean atkPressingP2, breakBoolean;
	public boolean initP2faceLeft;
	
	public void getMain(MainGame mainGame, boolean atkPressing, Attack attack) {
		main = mainGame;
		atkPressingP2 = atkPressing;
	}
	
	public void run() {
		double drawInterval = 1000000000/60;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		breakBoolean = true;
		initP2faceLeft = main.P1faceLeft;
		System.out.println("Run started");
		
		double time = 0;
		int passedFrame = 0;
		
		int drawCount = 0;
		
		main.riceKeyP2.setVisible(true);
		if(initP2faceLeft == true) {
			main.riceKeyP2.setLocation(main.p2.getX()-100, main.p2.getY()+50);
		} else if(initP2faceLeft == false) {
			main.riceKeyP2.setLocation(main.p2.getX()+100, main.p2.getY()+50);
		}
		
		while(breakBoolean == true) {
			System.out.println(main.riceKeyP2.getX());
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				passedFrame += 1;
				delta--;
				drawCount++;
				
				if(initP2faceLeft == true) {
					main.riceKeyP2.setLocation(main.riceKeyP2.getX()-20, main.riceKeyP2.getY());
				} else if(initP2faceLeft == false) {
					main.riceKeyP2.setLocation(main.riceKeyP2.getX()+20, main.riceKeyP2.getY());
				}
				
				
				if(-100 < main.riceKeyP2.getX() - main.p2.getX() && main.riceKeyP2.getX() - main.p2.getX() < 130 && -100 < main.riceKeyP2.getY() - main.p2.getY() && main.riceKeyP2.getY() - main.p2.getY() < 200) {
					main.riceKeyP2.setVisible(false);
					main.P1HP -= 10;
					main.monkeyStackP1 += 1;
					breakBoolean = false;
				}
				
				if(main.riceKeyP2.getX() > 1800 || main.riceKeyP2.getX() < -100) {
					main.riceKeyP2.setVisible(false);
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
		
		System.out.println("Finished");
		Attack.P2AtkPressOff();
	}
}
