package Touhou;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveThread extends Thread {
	
	MoveThread() {
		
	}
	
	public static void move(MainGame main) {
		if(main.P1upPressed == true) {
			if(main.p1.getY() <= 5) {
				main.p1.setLocation(main.p1.getX(), 0);
			} else {
				main.p1.setLocation(main.p1.getX(), main.p1.getY() - main.speed);
			}
		}
		if(main.P1downPressed == true) {
			if(main.p1.getY() >= 650) {
				main.p1.setLocation(main.p1.getX(), 650);
			} else {
				main.p1.setLocation(main.p1.getX(), main.p1.getY() + main.speed);
			}
		}
		if(main.P1rightPressed == true) {
			if(main.p1.getX() >= 650) {
				main.p1.setLocation(650, main.p1.getY());
			} else {
				main.p1.setLocation(main.p1.getX()+main.speed, main.p1.getY());
			}
		}
		if(main.P1leftPressed == true) {
			if(main.p1.getX() <= 5) {
				main.p1.setLocation(0, main.p1.getY());
			} else {
				main.p1.setLocation(main.p1.getX()-main.speed, main.p1.getY());
			}
		}
	}
}
