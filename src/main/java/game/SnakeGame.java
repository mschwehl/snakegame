package game;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gui.GuiMainwindow;
import model.EDirection;
import model.Field;
import model.Player;
import model.Playfield;

public class SnakeGame {



	Playfield playfield;
	
	List <Player> playerList = new ArrayList<>();
	
	public static void main(String[] args) {
		new SnakeGame().play();
	}

	private void play() {

		playfield = new Playfield(120,60);

		{
			Player playerA;
			playerA = new Player();
			playerA.setName("Player One");
			playerA.getSnake().setStartfield(new Field(20,30));
			playerA.getSnake().reset();
			playerA.getSnake().setFarbe(Color.BLUE);
			
			Map<Integer,EDirection> keyMap = new HashMap<>();
				keyMap.put(KeyEvent.VK_W, EDirection.UP);
				keyMap.put(KeyEvent.VK_S, EDirection.DOWN);
				keyMap.put(KeyEvent.VK_D, EDirection.RIGHT);
				keyMap.put(KeyEvent.VK_A, EDirection.LEFT);
			playerA.setKeymap(keyMap);
			
			playerList.add(playerA);
			
		}
		
		{
			Player playerB;
			playerB = new Player();
			playerB.setName("Player Two");
			playerB.getSnake().setStartfield(new Field(100,30));
			playerB.getSnake().reset();
			playerB.getSnake().setFarbe(Color.RED);
			
			Map<Integer,EDirection> keyMap = new HashMap<>();
				keyMap.put(KeyEvent.VK_UP, EDirection.UP);
				keyMap.put(KeyEvent.VK_DOWN, EDirection.DOWN);
				keyMap.put(KeyEvent.VK_RIGHT, EDirection.RIGHT);
				keyMap.put(KeyEvent.VK_LEFT, EDirection.LEFT);
			playerB.setKeymap(keyMap);
			
			playerList.add(playerB);
		}
		
		// initialer Zug
		
		
		
		
		GuiMainwindow gui = new GuiMainwindow(this);								
		gui.visualise();
		
		
	}

	

	public List<Player> getPlayerList() {
		return playerList;
	}

	public Playfield getPlayfield() {
		return playfield;
	}

	public void reset() {
		playerList.stream().forEach(e -> e.getSnake().reset());
	}
	
	
}
