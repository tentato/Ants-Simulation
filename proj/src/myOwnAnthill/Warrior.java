package myOwnAnthill;
/**
 * This class implements warriors
 * @authors K.O.  A.P.  E.B.K
 *
 */
public class Warrior extends Inhabitant implements I_Warrior {
	
	public static int numberOfWarriors = 0; 
	/**
	 * This is the constructor of the warrior. It counts the number od the warriors.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 */
	public Warrior(int x, int y) {
		super(x, y);
		this.type = 'W';
		numberOfWarriors++;
	}
	/**
	 * 
	 */
	@Override
	public void turn(Map map) {
		if(isAlive(map)) {
			if(spongeNearby(map)) {
				this.attack(map);
			}
			else {
				if(foodNearby(map))
					eat(map);
				else {	
					if(wayToExit)
						escape(map);
					else
						move(map);
				}
			}
		}
	}
	/**
	 * 
	 */
	@Override
	public boolean spongeNearby(Map map) {
		if(positionX == 0 && positionY == 0)	//leftUpper corner
		   if(map.field[positionY][positionX + 1].visualization == 'S' || map.field[positionY + 1][positionX].visualization == 'S')
				return true; 
			else
				return false;
		if(positionX == map.width - 1 && positionY == 0)	//rightUpper corner
		   if(map.field[positionY][positionX - 1].visualization == 'S' || map.field[positionY + 1][positionX].visualization == 'S')
			   return true; 
		   else
			   return false;
		if(positionX == 0 && positionY == map.height - 1) 	 //leftDowner corner
		   if(map.field[positionY][positionX + 1].visualization == 'S' || map.field[positionY - 1][positionX].visualization == 'S')
			   return true; //leftDowner corner
		   else
			   return false;
		if(positionX == map.width - 1 && positionY == map.height - 1)	//rightDowner corner
		   if(map.field[positionY][positionX - 1].visualization == 'S' || map.field[positionY - 1][positionX].visualization == 'S')
			   return true; //rightDowner corner
		   else
			   return false;
		
		if(positionY == 0 && (positionX > 0 && positionX < map.width - 1))	 //up
		   if((map.field[positionY][positionX - 1].visualization == 'S') ||
			  (map.field[positionY][positionX + 1].visualization == 'S') ||
		      (map.field[positionY + 1][positionX].visualization == 'S'))
		   	   return true;
		   else
			   return false;
		if((positionY < map.height - 1 && positionY > 0) && positionX == map.width - 1)	 //right
		    if((map.field[positionY + 1][positionX].visualization == 'S') ||
		       (map.field[positionY - 1][positionX].visualization == 'S') ||
		       (map.field[positionY][positionX - 1].visualization == 'S'))
		    	return true;
		    else
		    	return false;
		if((positionX < map.width - 1 && positionX > 0) && positionY == map.height - 1)	//down
			if((map.field[positionY][positionX - 1].visualization == 'S') ||
			   (map.field[positionY][positionX + 1].visualization == 'S') ||
			   (map.field[positionY - 1][positionX].visualization == 'S'))
				return true; 
			else
				return false;
		if(positionX == 0 && (positionY < map.height - 1 && positionY > 0))	 //left
			if((map.field[positionY + 1][positionX].visualization == 'S') ||
			   (map.field[positionY - 1][positionX].visualization == 'S') ||
			   (map.field[positionY][positionX + 1].visualization == 'S'))
				return true;
			else
				return false;
		
		if((map.field[positionY - 1][positionX].visualization == 'S') ||	//middle
		   (map.field[positionY][positionX + 1].visualization == 'S') ||
		   (map.field[positionY + 1][positionX].visualization == 'S') ||
		   (map.field[positionY][positionX - 1].visualization == 'S'))
			return true;
		else
			return false;
	}
	/**
	 * 
	 */
	@Override
	public void attack(Map map) {
		for(int i = 0; i < 1; i++) {	//loop which is giving possible to break
			if(positionX == 0 && positionY == 0) {	//leftUpper corner
				if(map.field[positionY][positionX + 1].visualization == 'S') {
					this.attackRight(positionX, positionY, map);
					break;
				}
				if(map.field[positionY + 1][positionX].visualization == 'S') {
					this.attackDown(positionX, positionY, map);
					break;
				}
			}
			if(positionX == map.width - 1 && positionY == 0) {	//rightUpper corner
				if(map.field[positionY + 1][positionX].visualization == 'S') {
					this.attackDown(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX - 1].visualization == 'S') {
					this.attackLeft(positionX, positionY, map);
					break;
				}
			}
			if(positionX == 0 && positionY == map.height - 1) { 	 //leftDowner corner
				if(map.field[positionY - 1][positionX].visualization == 'S') {
					this.attackUp(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX + 1].visualization == 'S') {
					this.attackRight(positionX, positionY, map);
					break;
				}
			}
			if(positionX == map.width - 1 && positionY == map.height - 1) {	//rightDowner corner
				if(map.field[positionY - 1][positionX].visualization == 'S') {
					this.attackUp(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX - 1].visualization == 'S') {
					this.attackLeft(positionX, positionY, map);
					break;
				}
			}
			
			if(positionY == 0 && (positionX > 0 && positionX < map.width - 1)) {	 //up
				if(map.field[positionY][positionX + 1].visualization == 'S') {
					this.attackRight(positionX, positionY, map);
					break;
				}
				if(map.field[positionY + 1][positionX].visualization == 'S') {
					this.attackDown(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX - 1].visualization == 'S') {
					this.attackLeft(positionX, positionY, map);
					break;
				}
			}
			if((positionY < map.height - 1 && positionY > 0) && positionX == map.width - 1) {	 //right
				if(map.field[positionY - 1][positionX].visualization == 'S') {
					this.attackUp(positionX, positionY, map);
					break;
				}
				if(map.field[positionY + 1][positionX].visualization == 'S') {
					this.attackDown(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX - 1].visualization == 'S') {
					this.attackLeft(positionX, positionY, map);
					break;
				}
			}
			if((positionX < map.width - 1 && positionX > 0) && positionY == map.height - 1) {	//down
				if(map.field[positionY - 1][positionX].visualization == 'S') {
					this.attackUp(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX + 1].visualization == 'S') {
					this.attackRight(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX - 1].visualization == 'S') {
					this.attackLeft(positionX, positionY, map);
					break;
				}
			}
			if(positionX == 0 && (positionY < map.height - 1 && positionY > 0)) {	 //left
				if(map.field[positionY - 1][positionX].visualization == 'S') {
					this.attackUp(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX + 1].visualization == 'S') {
					this.attackRight(positionX, positionY, map);
					break;
				}
				if(map.field[positionY + 1][positionX].visualization == 'S') {
					this.attackDown(positionX, positionY, map);
					break;
				}
			}
				
			if(map.field[positionY - 1][positionX].visualization == 'S') {	//middle
				this.attackUp(positionX, positionY, map);
				break;
			}
			if(map.field[positionY][positionX + 1].visualization == 'S') {
				this.attackRight(positionX, positionY, map);
				break;
			}
			if(map.field[positionY + 1][positionX].visualization == 'S') {
				this.attackDown(positionX, positionY, map);
					break;
			}
			if(map.field[positionY][positionX - 1].visualization == 'S') {
				this.attackLeft(positionX, positionY, map);
				break;
			}
		}
	}
	/**
	 * 
	 */
	@Override
	public void attackUp(int x, int y, Map map) {
		map.field[y - 1][x].visualization = '-';
	}
	/**
	 * 
	 */
	@Override
	public void attackRight(int x, int y, Map map) {
		map.field[y][x + 1].visualization = '-';
	}
	/**
	 * 
	 */
	@Override
	public void attackDown(int x, int y, Map map) {
		map.field[y + 1][x].visualization = '-';
	}
	/**
	 * 
	 */
	@Override
	public void attackLeft(int x, int y, Map map) {
		map.field[y][x - 1].visualization = '-';
	}
}