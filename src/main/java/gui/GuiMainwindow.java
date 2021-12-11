package gui;

import javax.swing.JFrame;

import game.SnakeGame;

public class GuiMainwindow {

	SnakeGame snakeGame;
	
	JFrame frame;
	
	public GuiMainwindow(SnakeGame game) {
		this.snakeGame = game;
	}

	public static int pixelSize = 10;
	
	public void visualise() {
	
		frame = new JFrame("Snake");
		frame.setSize(getWidth(),getHeigth());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);	
		frame.setResizable(false);
		
		frame.addKeyListener(new Keyhandler(snakeGame));

		GuiElement draw =new GuiElement(snakeGame);
		draw.setBounds(0, 0, snakeGame.getPlayfield().getMaxX() * pixelSize, snakeGame.getPlayfield().getMaxY() * pixelSize);
		draw.setVisible(true);
		frame.add(draw);
		
		GameClock gameclock=new GameClock(this);
		gameclock.start();
		
		frame.requestFocus();			//Holt Fokus zur Anerkennung der Tastatureingaben
		frame.setVisible(true);
		
	}

	public int getWidth() {
		return snakeGame.getPlayfield().getMaxX() * pixelSize;
	}

	
	public int getHeigth() {
		return snakeGame.getPlayfield().getMaxY() * pixelSize;
	}

	
}
