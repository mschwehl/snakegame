package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JLabel;

import game.SnakeGame;
import model.Field;
import model.Player;



public class GuiElement extends JLabel {

	SnakeGame snakeGame;
	
	public GuiElement(SnakeGame snakeGame) {
		this.snakeGame = snakeGame;
	}
	
	Point p; 

	protected void paintComponent(Graphics graph) {
		
		super.paintComponent(graph);
		Graphics2D graph2d=(Graphics2D) graph;
		graph2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);

		//Draw Background
		graph.setColor(Color.LIGHT_GRAY);
		graph.fillRect(0, 0, this.getParent().getWidth(), this.getParent().getHeight());
		
		graph.setColor(Color.BLACK);
		
		// Draw the scoreboard
		int i=0;
		for (Player p : snakeGame.getPlayerList()) {
			graph.drawString(p.getName() + ": " + p.getScore() ,20, 22 + (i++ * getFont().getSize()) + 3); 
		}
		
		for (Player player : snakeGame.getPlayerList()) {
			
			graph.setColor(  player.getSnake().getFarbe());
			
			for (Field f: player.getSnake().getFeldList() ) {
				p = new Point(f.getX() * GuiMainwindow.pixelSize , f.getY() * GuiMainwindow.pixelSize);
				graph.fillRect(p.x,p.y,GuiMainwindow.pixelSize ,GuiMainwindow.pixelSize );
			}
			
		}
		
		repaint();
	}

	
	
}