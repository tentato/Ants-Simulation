package myOwnAnthill;
/**
 * This class implements rocks, rocks are made to block some fields.
 * @authors K.O.  A.P.  E.B.K
 *
 */
public class Rock {

	public int postionX;
	public int postionY;
	public static int numberOfRocks = 0; //Not working as I want
	/**
	 * This is the constructor of the rock.
	 * It count the number of rocks.
	 */
	public Rock() {
		numberOfRocks++;
	}
	
}
