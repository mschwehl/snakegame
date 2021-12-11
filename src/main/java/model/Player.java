package model;

import java.util.Map;

public class Player {
	

	Map<Integer, EDirection> keyMap;
	String name;
	int score = 0;
	
	Snake snake = new Snake(this);
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	public Snake getSnake() {
		return snake;
	}
	
	
	
	public Map<Integer, EDirection> getKeyMap() {
		return keyMap;
	}
	public void setKeymap(Map<Integer, EDirection> keyMap) {
			this.keyMap = keyMap;
	}
	

}
