package PVP;

import Attacks.GodChangSupP1;
import Attacks.GodChangSupP2;

public class Attack extends Thread {
	public static boolean atkPressingP1 = false;
	public static boolean atkPressingP2 = false;
	static MainGame mainGame;
	
	public static void P1AtkPressOff() {
		atkPressingP1 = false;
	}
	
	public static void P2AtkPressOff() {
		atkPressingP2 = false;
	}
	
	public static void attack(MainGame main, String character1, String character2, Attack attack) {
		if(main.P1attackPressed == true && atkPressingP1 == false) {
			atkPressingP1 = true;
			mainGame = main;
			
			if(character1.equals("신창섭")) {
				GodChangSupP1 p1Atk = new GodChangSupP1();
				p1Atk.getMain(main, atkPressingP1, attack);
				p1Atk.start();
			}
		}
		
		if(main.P2attackPressed == true && atkPressingP2 == false) {
			atkPressingP2 = true;
			mainGame = main;
			
			if(character2.equals("신창섭")) {
				System.out.println("Selection Correct");
				GodChangSupP2 p2Atk = new GodChangSupP2();
				p2Atk.getMain(main, atkPressingP2, attack);
				p2Atk.start();
			}
		}
	}
}
