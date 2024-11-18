package PVP;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveThread extends Thread {
	
	MoveThread() {
		
	}
	
	public static void move(MainGame main) {
		if(main.P1upPressed == true) {
//			double drawInterval = 1000000000/60;
//			double delta = 0;
//			long lastTime = System.nanoTime();
//			long currentTime;
//			long timer = 0;
//			
//			double time = 0;
//			
//			int drawCount = 0;
//			
//			while(true) {
//				currentTime = System.nanoTime();
//				
//				delta += (currentTime - lastTime) / drawInterval;
//				timer += (currentTime - lastTime);
//				lastTime = currentTime;
//				
//				if(delta >= 1) {
//					delta--;
//					drawCount++;
//				}
//				
//				if(timer >= 1000000000) {
////					System.out.println("FPS:" + drawCount);
//					drawCount = 0;
//					timer = 0;
//				}
//			}
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
