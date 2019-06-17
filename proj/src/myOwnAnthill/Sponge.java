package myOwnAnthill;
/**
 * This is the class which implements sponge.
 * @authors K.O.  A.P.  E.B.K
 *
 */
public class Sponge extends Organism {

	public static int numberOfSponges = 0;
	/**
	 * This is the constructor of the sponge. It counts the number of the sponges.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 */
	public Sponge(int x, int y) {
		super(x, y);
		this.type = 'S';
		numberOfSponges++;
	}
}
