package myOwnAnthill;

public class Sponge extends Organism {

	public static int numberOfSponges = 0;
	
	public Sponge(int x, int y) {
		super(x, y);
		this.type = 'S';
		numberOfSponges++;
	}
}
