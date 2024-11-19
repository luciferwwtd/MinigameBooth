package PVP;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveThread extends Thread {
	public static boolean upPressingP1 = false;
	public static boolean upPressingP2 = false;
	static MainGame mainGame;
	
	public static void P1UpPressOff() {
		upPressingP1 = false;
	}
	
	public static void P2UpPressOff() {
		upPressingP2 = false;
	}
	
	public static void move(MainGame main, MoveThread moveThread) {
		if(main.P1upPressed == true && upPressingP1 == false) {
			upPressingP1 = true;
			mainGame = main;
			
			P1Jump p1Jump = new P1Jump();
			p1Jump.getMain(mainGame, upPressingP1, moveThread);
			p1Jump.start();
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
			
			P2Jump p2Jump = new P2Jump();
			p2Jump.getMain(mainGame, upPressingP2, moveThread);
			p2Jump.start();
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
