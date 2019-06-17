package myOwnAnthill;

import java.util.Random;

public abstract class Organism implements I_Organism {
	protected int positionX;
	protected int positionY;
	protected int hunger;
	protected boolean died;
	protected final int maxHunger = 100;
	protected char type;
	
	Organism(int x, int y) {
		this.positionX = x;
		this.positionY = y;
		this.hunger = 100;
	}
	
	@Override
	public void setPlace(Map map) {
		map.setField(positionX, positionY, type);
	}
	
	@Override
	public void turn(Map map) {
		if(isAlive(map)) {
			if(foodNearby(map))
				eat(map);
			else 
				move(map);
			
			hunger--;
		}
		//do nothing if not alive
	}
	
	@Override
	public void move(Map map) {		
		map.unsetField(positionX, positionY);
				
		Random r = new Random();
		int change;
		int iteration = 0;
				
		do {
			change = r.nextInt(4);
			if((positionX == 0 && positionY == 0) && (change == 0 || change == 3)) continue; //leftUpper corner
			if((positionX == map.width - 1 && positionY == 0) && (change == 0 || change == 1)) continue; //rightUpper corner
			if((positionX == 0 && positionY == map.height - 1) && (change == 2 || change == 3)) continue; //leftDowner corner
			if((positionX == map.width - 1 && positionY == map.height - 1) && (change == 1 || change == 2)) continue; //rightDowner corner
					
			if((positionY == 0 && (positionX > 0 && positionX < map.width - 1)) && (change == 0)) continue; //up
			if(((positionY < map.height - 1 && positionY > 0) && positionX == map.width - 1) && (change == 1)) continue; //right
			if(((positionX < map.width - 1 && positionX > 0) && positionY == map.height - 1) && (change == 2)) continue; //down
			if((positionX == 0 && (positionY < map.height - 1 && positionY > 0)) && (change == 3)) continue; //left
					
			if(change == 0 && !(map.field[positionY - 1][positionX].visualization == '-')) continue; 
			if(change == 1 && !(map.field[positionY][positionX + 1].visualization == '-')) continue;
			if(change == 2 && !(map.field[positionY + 1][positionX].visualization == '-')) continue;
			if(change == 3 && !(map.field[positionY][positionX - 1].visualization == '-')) continue;
					
			if(change == 0) positionY--;
			if(change == 1) positionX++;
			if(change == 2) positionY++;
			if(change == 3) positionX--;
			break;
		}while(iteration++ < 100);
				
		setPlace(map);
	}
	
	@Override
	public boolean isAlive(Map map) {
		if(hunger > 0 && map.field[positionY][positionX].visualization == type)
			return true;
		else {
			die(map);
			return false;
		}
	}
	
	@Override
	public void die(Map map) {
		if(!died) {
			map.unsetField(positionX, positionY);
			died = true;
		}
	}
	
	@Override
	public boolean foodNearby(Map map) {
		if(positionX == 0 && positionY == 0)	//leftUpper corner
		   if(map.field[positionY][positionX + 1].visualization == 'F' || map.field[positionY + 1][positionX].visualization == 'F')
				return true; 
			else
				return false;
		if(positionX == map.width - 1 && positionY == 0)	//rightUpper corner
		   if(map.field[positionY][positionX - 1].visualization == 'F' || map.field[positionY + 1][positionX].visualization == 'F')
			   return true; 
		   else
			   return false;
		if(positionX == 0 && positionY == map.height - 1) 	 //leftDowner corner
		   if(map.field[positionY][positionX + 1].visualization == 'F' || map.field[positionY - 1][positionX].visualization == 'F')
			   return true; //leftDowner corner
		   else
			   return false;
		if(positionX == map.width - 1 && positionY == map.height - 1)	//rightDowner corner
		   if(map.field[positionY][positionX - 1].visualization == 'F' || map.field[positionY - 1][positionX].visualization == 'F')
			   return true; //rightDowner corner
		   else
			   return false;
		
		if(positionY == 0 && (positionX > 0 && positionX < map.width - 1))	 //up
		   if((map.field[positionY][positionX - 1].visualization == 'F') ||
			  (map.field[positionY][positionX + 1].visualization == 'F') ||
		      (map.field[positionY + 1][positionX].visualization == 'F'))
		   	   return true;
		   else
			   return false;
		if((positionY < map.height - 1 && positionY > 0) && positionX == map.width - 1)	 //right
		    if((map.field[positionY + 1][positionX].visualization == 'F') ||
		       (map.field[positionY - 1][positionX].visualization == 'F') ||
		       (map.field[positionY][positionX - 1].visualization == 'F'))
		    	return true;
		    else
		    	return false;
		if((positionX < map.width - 1 && positionX > 0) && positionY == map.height - 1)	//down
			if((map.field[positionY][positionX - 1].visualization == 'F') ||
			   (map.field[positionY][positionX + 1].visualization == 'F') ||
			   (map.field[positionY - 1][positionX].visualization == 'F'))
				return true; 
			else
				return false;
		if(positionX == 0 && (positionY < map.height - 1 && positionY > 0))	 //left
			if((map.field[positionY + 1][positionX].visualization == 'F') ||
			   (map.field[positionY - 1][positionX].visualization == 'F') ||
			   (map.field[positionY][positionX + 1].visualization == 'F'))
				return true;
			else
				return false;
		
		if((map.field[positionY - 1][positionX].visualization == 'F') ||	//middle
		   (map.field[positionY][positionX + 1].visualization == 'F') ||
		   (map.field[positionY + 1][positionX].visualization == 'F') ||
		   (map.field[positionY][positionX - 1].visualization == 'F'))
			return true;
		else
			return false;
	}
	
	@Override
	public void eat(Map map) {
		for(int i = 0; i < 1; i++) {	//loop which is giving possible to break
			
			if(positionX == 0 && positionY == 0) {	//leftUpper corner
				if(map.field[positionY][positionX + 1].visualization == 'F') {
					eatRight(positionX, positionY, map);
					break;
				}
				if(map.field[positionY + 1][positionX].visualization == 'F') {
					eatDown(positionX, positionY, map);
					break;
				}
			}
			if(positionX == map.width - 1 && positionY == 0) {	//rightUpper corner
				if(map.field[positionY + 1][positionX].visualization == 'F') {
					eatDown(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX - 1].visualization == 'F') {
					eatLeft(positionX, positionY, map);
					break;
				}
			}
			if(positionX == 0 && positionY == map.height - 1) { 	 //leftDowner corner
				if(map.field[positionY - 1][positionX].visualization == 'F') {
					eatUp(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX + 1].visualization == 'F') {
					eatRight(positionX, positionY, map);
					break;
				}
			}
			if(positionX == map.width - 1 && positionY == map.height - 1) {	//rightDowner corner
				if(map.field[positionY - 1][positionX].visualization == 'F') {
					eatUp(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX - 1].visualization == 'F') {
					eatLeft(positionX, positionY, map);
					break;
				}
			}
			
			if(positionY == 0 && (positionX > 0 && positionX < map.width - 1)) {	 //up
				if(map.field[positionY][positionX + 1].visualization == 'F') {
					eatRight(positionX, positionY, map);
					break;
				}
				if(map.field[positionY + 1][positionX].visualization == 'F') {
					eatDown(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX - 1].visualization == 'F') {
					eatLeft(positionX, positionY, map);
					break;
				}
			}
			if((positionY < map.height - 1 && positionY > 0) && positionX == map.width - 1) {	 //right
				if(map.field[positionY - 1][positionX].visualization == 'F') {
					eatUp(positionX, positionY, map);
					break;
				}
				if(map.field[positionY + 1][positionX].visualization == 'F') {
					eatDown(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX - 1].visualization == 'F') {
					eatLeft(positionX, positionY, map);
					break;
				}
			}
			if((positionX < map.width - 1 && positionX > 0) && positionY == map.height - 1) {	//down
				if(map.field[positionY - 1][positionX].visualization == 'F') {
					eatUp(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX + 1].visualization == 'F') {
					eatRight(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX - 1].visualization == 'F') {
					eatLeft(positionX, positionY, map);
					break;
				}
			}
			if(positionX == 0 && (positionY < map.height - 1 && positionY > 0)) {	 //left
				if(map.field[positionY - 1][positionX].visualization == 'F') {
					eatUp(positionX, positionY, map);
					break;
				}
				if(map.field[positionY][positionX + 1].visualization == 'F') {
					eatRight(positionX, positionY, map);
					break;
				}
				if(map.field[positionY + 1][positionX].visualization == 'F') {
					eatDown(positionX, positionY, map);
					break;
				}
			}
				
			if(map.field[positionY - 1][positionX].visualization == 'F') {	//middle
				eatUp(positionX, positionY, map);
				break;
			}
			if(map.field[positionY][positionX + 1].visualization == 'F') {
				eatRight(positionX, positionY, map);
				break;
			}
			if(map.field[positionY + 1][positionX].visualization == 'F') {
				eatDown(positionX, positionY, map);
					break;
			}
			if(map.field[positionY][positionX - 1].visualization == 'F') {
				eatLeft(positionX, positionY, map);
				break;
			}
		}
	}
	
	@Override
	public void eatUp(int x, int y, Map map) {
		map.depot[0].nutrition += hunger;
		hunger = maxHunger;
		map.field[y - 1][x].visualization = '-';
	}
	
	@Override
	public void eatRight(int x, int y, Map map) {
		map.depot[0].nutrition += hunger;
		hunger = maxHunger;
		map.field[y][x + 1].visualization = '-';
	}
	
	@Override
	public void eatDown(int x, int y, Map map) {
		map.depot[0].nutrition += hunger;
		hunger = maxHunger;
		map.field[y + 1][x].visualization = '-';
	}
	
	@Override
	public void eatLeft(int x, int y, Map map) {
		map.depot[0].nutrition += hunger;
		hunger = maxHunger;
		map.field[y][x - 1].visualization = '-';
	}
}
