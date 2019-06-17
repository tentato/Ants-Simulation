package myOwnAnthill;
/**
 * This is the interface which contains methods for the queen.
 * @authors K.O.  A.P.  E.B.K
 *
 */
public interface I_Warrior {
	/**
	 * This method checks if there is any sponge nearby.
	 * @param map stores position?.
	 * @return 'true' - sponge nearby,'false' - no sponge nearby.
	 */
	public boolean spongeNearby(Map map);
	/**
	 * This method implements how warrior attacks the sponge.
	 * @param map stores position?.
	 */
	public void attack(Map map);
	/**
	 * This method implements how warrior attacks the sponge when it's up.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 * @param map stores position?.
	 */
	public void attackUp(int x, int y, Map map);
	/**
	 * This method implements how warrior attacks the sponge when it's right.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 * @param map stores position?.
	 */
	public void attackRight(int x, int y, Map map);
	/**
	 * This method implements how warrior attacks the sponge when it's down.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 * @param map stores position?.
	 */
	public void attackDown(int x, int y, Map map);
	/**
	 * This method implements how warrior attacks the sponge when it's left.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 * @param map stores position?.
	 */
	public void attackLeft(int x, int y, Map map);
}
