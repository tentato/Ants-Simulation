package myOwnAnthill;
/**
 * This is the abstract class which implements inhabitants.
 * @authors K.O.  A.P.  E.B.K
 *
 */
public abstract class Inhabitant extends Organism implements I_Inhabitant {

	protected int distanceFromNest;
	protected String direction;
	protected boolean wayToExit = false;
	/**
	 * This is the constructor of the inhabitant.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 */
	public Inhabitant(int x, int y) {
		super(x, y);
	}
	/**
	 * 
	 */
	@Override
	public void turn(Map map) {
		if(isAlive(map)) {
			if(foodNearby(map))
				eat(map);
			else {
				if(wayToExit)
					escape(map);
				else
					move(map);
			}
			hunger--;
		}
		//do nothing if not alive
	}
	/**
	 * 
	 */
	@Override
	public void escape(Map map) {
		if(direction == "Right") {
			switch(distanceFromNest) {
			case 1:	if(goLeft(map)) distanceFromNest++; break;
			case 2:	if(goLeft(map)) distanceFromNest++; break;
			case 3:	if(goUp(map)) distanceFromNest++; break;
			case 4:	if(goUp(map)) distanceFromNest++; break;
			case 5:	if(goUp(map)) distanceFromNest++; break;
			case 6:	if(goRight(map)) distanceFromNest++; break;
			case 7:	if(goUp(map)) distanceFromNest++; break;
			case 8:	if(goUp(map)) distanceFromNest++; break;
			case 9:	if(goUp(map)) {distanceFromNest++; wayToExit = false;} break;
			}
		}
		if(direction == "Left") {
			switch(distanceFromNest) {
			case 1:	if(goLeft(map)) distanceFromNest++; break;
			case 2:	if(goLeft(map)) distanceFromNest++; break;
			case 3:	if(goDown(map)) distanceFromNest++; break;
			case 4:	if(goLeft(map)) distanceFromNest++; break;
			case 5:	if(goDown(map)) distanceFromNest++; break;
			case 6:	if(goDown(map)) distanceFromNest++; break;
			case 7:	if(goLeft(map)) distanceFromNest++; break;
			case 8:	if(goLeft(map)) distanceFromNest++; break;
			case 9:	if(goUp(map)) distanceFromNest++; break;
			case 10: if(goLeft(map)) distanceFromNest++; break;
			case 11: if(goLeft(map)) distanceFromNest++; break;
			case 12: if(goLeft(map)) {distanceFromNest++; wayToExit = false;} break;
			}
		}
		
	}
	/**
	 * 
	 */
	@Override
	public boolean goUp(Map map) {
		if(map.field[positionY - 1][positionX].visualization == '-') {
			map.unsetField(positionX, positionY);
			positionY--;
			map.setField(positionX, positionY, type);
			return true;
		}
		return false;
	}
	/**
	 * 
	 */
	@Override
	public boolean goRight(Map map) {
		if(map.field[positionY][positionX + 1].visualization == '-') {
			map.unsetField(positionX, positionY);
			positionX++;
			map.setField(positionX, positionY, type);
			return true;
		}
		return false;
	}
	/**
	 * 
	 */
	@Override
	public boolean goDown(Map map) {
		if(map.field[positionY + 1][positionX].visualization == '-') {
			map.unsetField(positionX, positionY);
			positionY++;
			map.setField(positionX, positionY, type);
			return true;
		}
		return false;
	}
	/**
	 * 
	 */
	@Override
	public boolean goLeft(Map map) {
		if(map.field[positionY][positionX - 1].visualization == '-') {
			map.unsetField(positionX, positionY);
			positionX--;
			map.setField(positionX, positionY, type);
			return true;
		}
		return false;
	}
}
