package PVP;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveThread extends Thread {
	public static boolean upPressingP1 = false;
	public static boolean upPressingP2 = false;
	static MainGame mainGame;
	
	public static void P1Jump() {
MainGame main = mainGame;
		
		double drawInterval = 1000000000/60;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		
		double time = 0;
		int passedFrame = 0;
		
		int drawCount = 0;
		
		while(passedFrame < 60) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				passedFrame += 1;
				delta--;
				drawCount++;
				
				main.p1.setLocation(main.p1.getX(), 785 + (1200*passedFrame/60*passedFrame/60) - (1200*passedFrame/60));
			}
			
			if(timer >= 1000000000) {
//				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
		
		main.p1.setLocation(main.p1.getX(), 785);
	}
	
	public void run() {  // Thread 를 상속하면 run 메서드를 구현해야 한다.
		
    }	
	
	public static void move(MainGame main) {
		if(main.P1upPressed == true && upPressingP1 == false) {
			upPressingP1 = true;
			mainGame = main;
			
			MoveThread sample = new MoveThread();
	        sample.start();
		}
		if(main.P1rightPressed == true) {
			if(main.p1.getX() >= 1653) {	
				main.p1.setLocation(1658, main.p1.getY());
			} else {
				main.p1.setLocation(main.p1.getX()+5, main.p1.getY());
			}
		}
		if(main.P1leftPressed == true) {
			if(main.p1.getX() <= 5) {
				main.p1.setLocation(0, main.p1.getY());
			} else {
				main.p1.setLocation(main.p1.getX()-5, main.p1.getY());
			}
		}
		
		if(main.P2upPressed == true && upPressingP2 == false) {
			upPressingP2 = true;
			mainGame = main;
			
			MoveThread sample = new MoveThread();
	        sample.start();
		}
		if(main.P2rightPressed == true) {
			if(main.p2.getX() >= 1653) {
				main.p2.setLocation(1658, main.p2.getY());
			} else {
				main.p2.setLocation(main.p2.getX()+5, main.p2.getY());
			}
		}
		if(main.P2leftPressed == true) {
			if(main.p2.getX() <= 5) {
				main.p2.setLocation(0, main.p2.getY());
			} else {
				main.p2.setLocation(main.p2.getX()-5, main.p2.getY());
			}
		}
	}
}

/*
double drawInterval = 1000000000/60;
			double delta = 0;
			long lastTime = System.nanoTime();
			long currentTime;
			long timer = 0;
			
			double time = 0;
			int passedFrame = 0;
			
			int drawCount = 0;
			
			while(passedFrame < 60) {
				currentTime = System.nanoTime();
				
				delta += (currentTime - lastTime) / drawInterval;
				timer += (currentTime - lastTime);
				lastTime = currentTime;
				
				if(delta >= 1) {
					passedFrame += 1;
					delta--;
					drawCount++;
					
					main.p1.setLocation(main.p1.getX(), 785 + (1200*passedFrame/60*passedFrame/60) - (1200*passedFrame/60));
				}
				
				if(timer >= 1000000000) {
//					System.out.println("FPS:" + drawCount);
					drawCount = 0;
					timer = 0;
				}
			}
 */
