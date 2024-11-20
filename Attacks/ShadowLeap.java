package Attacks;

import PVP.MainGame;
import PVP.Attack;

public class ShadowLeap extends Thread {
	public static MainGame main;
	public static int player;
	
	public void getMain(MainGame mainGame, int user) {
		main = mainGame;
		player = user;
	}
	
	public void run() {
		if(player == 1) {
			if(main.P2faceLeft == true) {
				main.p1.setLocation(main.p2.getX()+130, 785);
				main.P1faceLeft = true;
			} else {
				main.p1.setLocation(main.p2.getX()-130, 785);
				main.P1faceLeft = false;
			}
		} else {
			if(main.P1faceLeft == true) {
				main.p2.setLocation(main.p1.getX()+130, 785);
				main.P2faceLeft = true;
			} else {
				main.p2.setLocation(main.p1.getX()-130, 785);
				main.P2faceLeft = false;
			}
		}
	}
}
