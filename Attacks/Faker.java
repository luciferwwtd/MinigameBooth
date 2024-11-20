package Attacks;

import PVP.MainGame;

import javax.swing.ImageIcon;

import PVP.Attack;

public class Faker extends Thread {
	public static MainGame main;
	public static boolean atkPressingP1, breakBoolean;
	public boolean initP1faceLeft;
	public static int player;
	
	public void getMain(MainGame mainGame, boolean attackPressing, int user) {
		atkPressingP1 = attackPressing;
		main = mainGame;
		player = user;
	}
	
	public void run() {
		ImageIcon iconshush = new ImageIcon("페이커쉿.png");
		ImageIcon iconNormal = new ImageIcon("페이커캐릭터.png");
		
		if(player == 1) {
			try {
				main.p1.setIcon(iconshush);
				main.P2HP -= main.P1atk;
				Thread.sleep(100); //1초 대기
				main.p1.setIcon(iconNormal);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				main.p2.setIcon(iconshush);
				main.P1HP -= main.P2atk;
				Thread.sleep(100); //1초 대기
				main.p2.setIcon(iconNormal);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(200); //1초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(player == 1) {
			Attack.P1AtkPressOff();
		} else {
			Attack.P2AtkPressOff();
		}
	}
}
