package myOwnAnthill;
import java.util.Random;

public class Map implements I_Settling {
	
	public int height = 20; //Y
	public int width = 20;	//X
	
	public final int rockPossibility = 18;	//0-never, 1-always, 2-usually, 20-rare... infinity...
	public final int foodPossibility = 15;
	
	Field field[][] = new Field[height][width];
	Rock rock[] = new Rock[1000];
	Food food[] = new Food[1000];
	Worker ant[] = new Worker[100];
	Warrior warrior[] = new Warrior[100];
	Sponge sponge[] = new Sponge[100];
	Queen queen[] = new Queen[1];	//It's not working differently
	Depot depot[] = new Depot[1];
	
	
	public void create() {
		//Making fields
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				field[i][j] = new Field();
				//Setting fields coordinates
				field[i][j].positionY = i;		//"y = -y"
				field[i][j].positionX = j;
			}
		}
		
		//Rock settlements
		//Upper half of the map
		for(int i = 0; i < height / 2; i++) {	
			for(int j = 0; j < width ; j++) {	
				Random r = new Random();
				int chance = r.nextInt(rockPossibility);	//There is possibility that rock spawn in entrance to ant nest
				if(chance == 0) {
					rock[Rock.numberOfRocks] = new Rock();
					field[i][j].visualization = 'R';
				}
			}
		}
		//Quarter of the map
		for(int i = height / 2; i < height; i++) {	
			for(int j = 0; j < width / 2 ; j++) {	
				Random r = new Random();
				int chance = r.nextInt(rockPossibility);	//There is possibility that rock spawn in entrance to ant nest
				if(chance == 0) {
					rock[Rock.numberOfRocks] = new Rock();
					field[i][j].visualization = 'R';
				}
			}
		}
		
		//Draw caves (1 - rock, 0 - empty) HAVE TO BE MADE IN THE FILE!
		int cave[][] = {{1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
						{1, 1, 1, 1, 1, 1, 0, 1, 0, 0},
						{1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
						{1, 0, 0, 0, 0, 0, 1, 1, 1, 1},
						{1, 0, 0, 0, 1, 0, 1, 0, 0, 0},
						{1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
						{1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
						{0, 0, 0, 1, 0, 1, 1, 1, 1, 1},
						{1, 1, 0, 0, 0, 1, 0, 0, 0, 1},
						{1, 1, 1, 1, 0, 0, 0, 0, 1, 1},
						};
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(cave[i][j]==1) {
					rock[Rock.numberOfRocks] = new Rock();
					field[width - 10 + i][height - 10 + j].visualization = 'R';
				}
			}
		}
		
		//Food settlements
		for(int i = 0; i < height / 2; i++) {	
			for(int j = 0; j < width ; j++) {	
				Random r = new Random();
				int chance = r.nextInt(foodPossibility);	//There is possibility that food spawn in entrance to ant nest
				if(chance == 0 && field[i][j].visualization == '-')
				{
					food[Food.numberOfFood] = new Food(i, j);
					field[i][j].visualization = 'F';
				}
			}
		}
		for(int i = height / 2; i < height; i++) {	
			for(int j = 0; j < width / 2; j++) {	
				Random r = new Random();
				int chance = r.nextInt(foodPossibility);	//There is possibility that food spawn in entrance to ant nest
				if(chance == 0 && field[i][j].visualization == '-')
				{
					food[Food.numberOfFood] = new Food(i, j);
					field[i][j].visualization = 'F';
				}
			}
		}
		
		//Depot settlement
		depot[0] = new Depot(12, 13);
		field[13][12].visualization = 'D';
		
		//Queen settlement
		putQueen(18,15);
				
		//Workers settlements
		putWorker(16, 8);
		putWorker(16, 9);
		putWorker(8, 17);
		putWorker(9, 17);
		
		putWarrior(16, 3);
		
		//Sponges settlement
		putSponge(0, 0);
		putSponge(19, 0);
		putSponge(0, 19);
	}
	
	public void show() {
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				System.out.print(field[i][j].visualization + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void unsetField(int x, int y) {
		field[y][x].visualization = '-';
	}
	
	public void setField(int x, int y, char species) {
		field[y][x].visualization = species;
	}
	
	@Override
	public void putWorker(int x, int y) {
		ant[Worker.numberOfWorkers] = new Worker(x, y);
		if(field[y][x].visualization == 'R') Rock.numberOfRocks--; 
		if(field[y][x].visualization == 'F') Food.numberOfFood--;
		setField(x, y, 'A');
	}
	
	@Override
	public void putWarrior(int x, int y) {
		warrior[Warrior.numberOfWarriors] = new Warrior(x, y);
		if(field[y][x].visualization == 'R') Rock.numberOfRocks--; 
		if(field[y][x].visualization == 'F') Food.numberOfFood--;
		setField(x, y, 'W');
	}
	
	@Override
	public void putSponge(int x, int y) {
		sponge[Sponge.numberOfSponges] = new Sponge(x, y);
		if(field[y][x].visualization == 'R') Rock.numberOfRocks--; 
		if(field[y][x].visualization == 'F') Food.numberOfFood--;
		setField(x, y, 'S');
	}
	
	@Override
	public void putQueen(int x, int y) {
		queen[Queen.numberOfQueens] = new Queen(x, y);
		if(field[y][x].visualization == 'R') Rock.numberOfRocks--; 
		if(field[y][x].visualization == 'F') Food.numberOfFood--;
		setField(x, y, 'Q');
	}
}
