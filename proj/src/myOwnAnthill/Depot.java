package myOwnAnthill;
/**
 * This class implements the depot, a place where the nutrition is stored, the depot has its own place on the map. 
 * @authors K.O.  A.P.  E.B.K
 */
public class Depot {
	public int positonX;
	public int positonY;
	public int nutrition;	
	/**
	 * This is the method's constructor.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'x' position on the map.
	 * @param nutrition stores current value of the nutrition.
	 */
	public Depot(int x, int y) {
		this.positonX = x;
		this.positonY = y;
		nutrition = 0;
	}
}
