package myOwnAnthill;
/**
 * This class implements food for the ants and sponges.
 * @authos K.O.  A.P.  E.B.K
 * 
 */
public class Food {
	
	public int postionX;
	public int postionY;
	public int nutrition = 100;	//For now there is 100, it could be changed.
	public static int numberOfFood = 0;
	/**
	 * This is the constructor of the food. It counts the amount of the food.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 */
	public Food(int x, int y) {
		this.postionY = y;
		this.postionX = x;
		numberOfFood++;
	}
}
