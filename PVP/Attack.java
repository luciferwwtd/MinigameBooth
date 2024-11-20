package PVP;

import Attacks.Bas;
import Attacks.Faker;
import Attacks.GAY;
import Attacks.GodChangSupP1;
import Attacks.GodChangSupP2;
import Attacks.GodChangSupUlt;
import Attacks.ShadowLeap;
import Attacks.TurnOff;

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
			} else if(character1.equals("게이")) {
				GAY p1atk = new GAY();
				p1atk.getMain(main, atkPressingP1, 1);
				p1atk.start();
			} else if(character1.equals("페이커")) {
				Faker p1atk = new Faker();
				p1atk.getMain(main, atkPressingP1, 1);
				p1atk.start();
			} else if(character1.equals("백종원")) {
				Bas p1atk = new Bas();
				p1atk.getMain(main, atkPressingP1, 1);
				p1atk.start();
			}
		}
		
		if(main.P1UltPressed == true && main.p1UltCooldown == 0) {
			main.p1UltCooldown = 70;
			mainGame = main;
			
			if(character1.equals("신창섭")) {
				GodChangSupUlt changUlt = new GodChangSupUlt();
				changUlt.getMain(mainGame, 1);
				changUlt.start();
			} else if(character1.equals("게이")) {
				ShadowLeap gayUlt = new ShadowLeap();
				gayUlt.getMain(mainGame, 1);
				gayUlt.start();
			} else if(character1.equals("페이커")) {
				TurnOff gayUlt = new TurnOff();
				gayUlt.getMain(mainGame);
				gayUlt.start();
			}
		}
		
		if(main.P2attackPressed == true && atkPressingP2 == false) {
			atkPressingP2 = true;
			mainGame = main;
			
			if(character2.equals("신창섭")) {
				GodChangSupP2 p2Atk = new GodChangSupP2();
				p2Atk.getMain(main, atkPressingP2, attack);
				p2Atk.start();
			} else if(character2.equals("게이")) {
				GAY p2atk = new GAY();
				p2atk.getMain(main, atkPressingP2, 2);
				p2atk.start();
			} else if(character2.equals("페이커")) {
				Faker p2atk = new Faker();
				p2atk.getMain(main, atkPressingP2, 2);
				p2atk.start();
			} else if(character2.equals("백종원")) {
				Bas p2atk = new Bas();
				p2atk.getMain(main, atkPressingP2, 2);
				p2atk.start();
			}
		}
		
		if(main.P2UltPressed == true && main.p2UltCooldown == 0) {
			main.p2UltCooldown = 70;
			mainGame = main;
			
			if(character2.equals("신창섭")) {
				GodChangSupUlt changUlt = new GodChangSupUlt();
				changUlt.getMain(mainGame, 2);
				changUlt.start();
			} else if(character2.equals("게이")) {
				ShadowLeap gayUlt = new ShadowLeap();
				gayUlt.getMain(mainGame, 2);
				gayUlt.start();
			} else if(character2.equals("페이커")) {
				TurnOff gayUlt = new TurnOff();
				gayUlt.getMain(mainGame);
				gayUlt.start();
			}
		}
	}
}
