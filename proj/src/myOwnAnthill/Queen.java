package myOwnAnthill;

public class Queen extends Inhabitant implements I_Queen {
	public boolean wayToDepo;
	public boolean wayFromDepo;
	public int distanceFromNest;

	public static int numberOfQueens = 0; //will always be 1
	public static int numberOfHatches = 0; 
	
	public Queen(int x, int y) {
		super(x, y);
		this.type = 'Q';
		distanceFromNest = 0;
		wayToDepo = false;
		wayFromDepo = false;
		numberOfQueens++;
	}
	
	@Override
	public void turn(Map map) {	
		if(isAlive(map)) {
			if(hunger > 40 && (positionX == 18 && positionY == 15)) {
				if(produce(map))
					hunger -= 20;
				else
					hunger--;
			}
			else {
				if(wayToDepo) {
					if(distanceFromNest == 7) {
						wayToDepo = false;
						eat(map);
						wayFromDepo = true;
					}
					else {
						switch(distanceFromNest) {
						case 0:	if(goLeft(map)) distanceFromNest++; break;
						case 1:	if(goLeft(map)) distanceFromNest++; break;
						case 2:	if(goLeft(map)) distanceFromNest++; break;
						case 3:	if(goUp(map)) distanceFromNest++; break;
						case 4:	if(goUp(map)) distanceFromNest++; break;
						case 5:	if(goLeft(map)) distanceFromNest++; break;
						case 6:	if(goLeft(map)) distanceFromNest++; break;
						}
					}
				}
				
				if(wayFromDepo && hunger < 100) {
					switch(distanceFromNest) {
					case 7:	if(goRight(map)) distanceFromNest--; break;
					case 6:	if(goRight(map)) distanceFromNest--; break;
					case 5:	if(goDown(map)) distanceFromNest--; break;
					case 4:	if(goDown(map)) distanceFromNest--; break;
					case 3:	if(goRight(map)) distanceFromNest--; break;
					case 2:	if(goRight(map)) distanceFromNest--; break;
					case 1:	if(goRight(map)) {distanceFromNest--; wayFromDepo = false;} break;
					}	
				}
				
				if(!(wayFromDepo || wayToDepo))
					if(hunger < 20)
						wayToDepo = true;
	
				hunger--;
			}
		}
	}
	
	@Override
	public void eat(Map map) { //From depot
			if(map.depot[0].nutrition > maxHunger - hunger) {
				map.depot[0].nutrition -= maxHunger - hunger;
				hunger += maxHunger - hunger;
			}
				
	}
	
	@Override
	public boolean produce(Map map) {
		
		if(map.field[positionY][positionX - 1].visualization == '-') {
			if(numberOfHatches % 5 == 0) {
				map.putWarrior(positionX - 1, positionY);
				map.warrior[Warrior.numberOfWarriors - 1].wayToExit = true;
				map.warrior[Warrior.numberOfWarriors - 1].distanceFromNest = 1;
				if(numberOfHatches % 2 == 0) {
					map.warrior[Warrior.numberOfWarriors - 1].direction = "Left";
				} else {
					map.warrior[Warrior.numberOfWarriors - 1].direction = "Right";
				}
			}
			else {
				map.putWorker(positionX - 1, positionY);
				map.ant[Worker.numberOfWorkers - 1].wayToExit = true;
				map.ant[Worker.numberOfWorkers - 1].distanceFromNest = 1;
				if(numberOfHatches % 2 == 0) {
					map.ant[Worker.numberOfWorkers - 1].direction = "Left";
				} else {
					map.ant[Worker.numberOfWorkers - 1].direction = "Right";
				}
					
			}
			numberOfHatches++;
			return true;
		}
		
		return false;
	}
}
