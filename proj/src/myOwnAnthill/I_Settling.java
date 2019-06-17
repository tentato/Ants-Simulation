package myOwnAnthill;
/**
 * This is the interface which contains methods which put the organisms on the map..
 * @authors K.O.  A.P.  E.B.K
 *
 */
public interface I_Settling {
	/**
	 * This method implements settling the worker.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 */
	public void putWorker(int x, int y);
	/**
	 * This method implements settling the warrior.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 */
	public void putWarrior(int x, int y);
	/**
	 * This method implements settling the sponge.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 */
	public void putSponge(int x, int y);
	/**
	 * This method implements settling the queen.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 */
	public void putQueen(int x, int y);
}
