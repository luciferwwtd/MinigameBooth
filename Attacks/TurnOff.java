package Attacks;

import PVP.MainGame;

import java.awt.Color;

import javax.swing.JLabel;

import PVP.Attack;

public class TurnOff extends Thread {
	public static MainGame main;
	
	public void getMain(MainGame mainGame) {
		main = mainGame;
	}
	
	public void run() {
		main.p1.setVisible(false);
		main.p2.setVisible(false);
		
		main.hider.setVisible(true);
		
//		JLabel hider = new JLabel();
//		
//		hider.setBounds(0, 0, 1800, 1020);
//		hider.setBackground(Color.black);
//		hider.setOpaque(true);
//		hider.setEnabled(true);
		
		
		
//		main.add(hider);
		
		try {
			Thread.sleep(5000);
		} catch(Exception exception) {
			System.out.println(exception);
		}
		
		main.p1.setVisible(true);
		main.p2.setVisible(true);
		
		main.hider.setVisible(false);
		
//		main.remove(hider);
	}
}
