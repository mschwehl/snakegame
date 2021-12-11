package model;

public class Playfield {
	
	int maxX, maxY;
	
	public Playfield(int x, int y) {
		maxX = x;
		maxY = y;
	}


	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}


	public boolean collides(Field f) {
		return f.x < 0 || f.x > maxX || f.y < 0 || f.y > maxY; 
	}

	
}
