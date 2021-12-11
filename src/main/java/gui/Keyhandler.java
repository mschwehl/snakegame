package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Currency;

import game.SnakeGame;
import model.EDirection;

public class Keyhandler  implements KeyListener{

	SnakeGame game;
	
	public Keyhandler(SnakeGame game) {
	  this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		game.getPlayerList().forEach( x -> {
			
			EDirection current = x.getSnake().getDirection();
			EDirection newWay = x.getKeyMap().get(e.getKeyCode());

			if (newWay != null) {
				if (!isBackward(newWay,current)) {
					x.getSnake().setDirection(newWay);
				}
			}
						
		} );
	}

	
	/*
	 * Backward shall not be an error
	 */
	
	private boolean isBackward(EDirection newWay, EDirection current) {
		
		switch (newWay) {
		
		case DOWN:
			return current==EDirection.UP;

		case UP:
			return current==EDirection.DOWN;

		case RIGHT:
			return current==EDirection.LEFT;

		case LEFT:
			return current==EDirection.RIGHT;

			
		default:
			break;
		}
		
		throw new IllegalStateException("Ich sollte nicht hier sein");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
