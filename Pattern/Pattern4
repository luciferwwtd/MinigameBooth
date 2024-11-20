package Pattern;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import Touhou.MainGame;

public class Pattern4 extends Thread {
	public static JFrame main;
	public static MainGame mainGame;
	
	public static void getMain(JFrame frame, MainGame mainClass) {
		main = frame;
		mainGame = mainClass;
	}
	
	@Override
	public void run() {
		
		Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
		
		try {
			mainGame.p1.setBackground(null);
			mainGame.p1.setBorder(border);
			
			Thread.sleep(15000);
			
			mainGame.p1.setBackground(Color.blue);
			mainGame.p1.setBorder(null);
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
