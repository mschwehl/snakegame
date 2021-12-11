package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import model.Field;
import model.Player;

public class GameClock extends Thread{
	
	GuiMainwindow gui;
	
	public GameClock(GuiMainwindow gui) {
		this.gui = gui;
	}
	
	
	public void run() {
	

		while(true) {
	
			try {
				
				sleep(200);
	
				for (Player player : gui.snakeGame.getPlayerList()) {
					
					Field f = player.getSnake().simulateNextMove();
					
					if (gui.snakeGame.getPlayfield().collides(f)) {
						System.err.println("Hit the wall: " + player.getName());
						
						// Point to the other Players
						gui.snakeGame.getPlayerList().stream().filter(p -> !p.equals(player)).forEach(x -> x.setScore(x.getScore()+1));

						gui.snakeGame.reset();
						break;
					}
					
					List<Player> hitList = new ArrayList<Player>();
					
					 gui.snakeGame.getPlayerList().stream().forEach( x -> {
						 if (x.getSnake().contains(f)) {
							 hitList.add(x);
						 }
					 });

					 
					 hitList.forEach( p -> {
						 System.err.println("Hit Player: " + player.getName() + ": " + p.getName());
						 p.setScore( p.getScore() + 1);
					 });
					 
					 // Just show the first hit
					 if (hitList.size() > 0) {
							gui.snakeGame.reset();
							break;
					 }
					 
					player.getSnake().moveByDirection(f);
					
				}
				
				// Swing runs in an separat Thread and there will be problems calling methods directly
				
			  SwingUtilities.invokeAndWait(new Runnable() {
				    public void run() {
				    	gui.frame.repaint();
				    }
				  });
				  
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	
}