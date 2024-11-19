package PVP;

public class P2Jump extends Thread {
	public static MainGame main;
	public static boolean upPressingP2;
	
	P2Jump() {
		
	}
	
	public static void getMain(MainGame mainGame, boolean upPressing, MoveThread moveThread) {
		main = mainGame;
		upPressingP2 = upPressing;
	}
	
	public void run() {
		double drawInterval = 1000000000/60;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		
		double time = 0;
		int passedFrame = 0;
		
		int drawCount = 0;
		
		while(passedFrame < 60) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				passedFrame += 1;
				delta--;
				drawCount++;
				
				main.p2.setLocation(main.p2.getX(), 785 + (1200*passedFrame/60*passedFrame/60) - (1200*passedFrame/60));
			}
			
			if(timer >= 1000000000) {
//				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
		
		main.p2.setLocation(main.p2.getX(), 785);
		MoveThread.P2UpPressOff();
	}
}
