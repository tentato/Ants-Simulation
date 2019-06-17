package myOwnAnthill;

public class Worker extends Inhabitant {

	public static int numberOfWorkers = 0;
	
	public Worker(int x, int y) {
		super(x, y);
		this.type = 'A';
		numberOfWorkers++;
	}
	
}
