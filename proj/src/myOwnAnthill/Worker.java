package myOwnAnthill;
/**
 * This clas implements the worker.
 * @authors K.O.  A.P.  E.B.K
 *
 */
public class Worker extends Inhabitant {

	public static int numberOfWorkers = 0;
	/**
	 * This is the constructor of the worker. It counts the number of the workers.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 */
	public Worker(int x, int y) {
		super(x, y);
		this.type = 'A';
		numberOfWorkers++;
	}
	
}
