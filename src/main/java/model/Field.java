package model;

public class Field  {
	

	int x, y;
	
	public Field(int x, int y) {
		this.x=x;
		this.y=y;
	}


	public Field lookup(EDirection direction) {

		switch (direction) {
		case UP:
			return new Field(x, y-1);
			
		case DOWN:
			return new Field(x, y+1);

		case LEFT:
			return new Field(x-1, y);

		case RIGHT:
			return new Field(x+1, y);
			
		}
		
		throw new IllegalStateException("Unbekannte Richtung");
		

		
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Field) {
			
			Field other = (Field) obj;
			return other.x == this.x && other.y == y;
			
		}
		
		return false;
		
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	
	
}
