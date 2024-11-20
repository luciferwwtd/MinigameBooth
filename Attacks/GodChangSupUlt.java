package Attacks;

import PVP.MainGame;
import PVP.Attack;

public class GodChangSupUlt extends Thread {
	public static MainGame main;
	public static boolean breakBoolean;
	public static int player;
	
	public void getMain(MainGame mainGame, int usedPlayer) {
		main = mainGame;
		player = usedPlayer;
	}
	
	public void run() {
		int i = 0;
		while(i<25) {
			i++;
			try {
				main.changUlt.setVisible(true);
				Thread.sleep(20);
				
				main.changUlt.setVisible(false);
				Thread.sleep(20);
				
			} catch(Exception exception) {
				System.out.println(exception);
			}
		}
		
		System.out.println("Damage");
		
		if(player == 1) {
			int stack = main.monkeyStackP2;
			main.P2HP -= stack*5;
			main.monkeyStackP2 = 0;
		} else {
			int stack = main.monkeyStackP1;
			main.P1HP -= stack*5;
			main.monkeyStackP1 = 0;
		}
	}
}
