package model;
import java.awt.Color;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Snake {

	
	List<Field> feldList = new CopyOnWriteArrayList<>();
	Field startField;

	EDirection direction = EDirection.DOWN;
	Player player;

	Color farbe;
	
	
	public Snake(Player player) {
		this.player = player;
	}
	
	
	public EDirection getDirection() {
		return direction;
	}


	public synchronized void setDirection(EDirection direction) {
		this.direction = direction;
	}


	public synchronized List<Field> getFeldList() {
		return feldList;
	}

	public synchronized Field simulateNextMove() {
		Field f = feldList.get(0);
		return f.lookup(direction);
	}
	
	public synchronized void moveByDirection(Field f) {
		feldList.add(0,f);
	}


	public synchronized void move(int i, int j) {
		Field f = new Field(i,j);
		feldList.add(0,f);

	}


	public boolean contains(Field f) {
		
		for (Field t: feldList) {
			if (t.equals(f)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public void reset() {
		feldList = new CopyOnWriteArrayList<>();
		feldList.add(startField);
	}


	public Field getStartfield() {
		return startField;
	}


	public void setStartfield(Field startfeld) {
		this.startField = startfeld;
	}


	public Player getPlayer() {
		return player;
	}


	public Color getFarbe() {
		return farbe;
	}


	public void setFarbe(Color farbe) {
		this.farbe = farbe;
	}



}
