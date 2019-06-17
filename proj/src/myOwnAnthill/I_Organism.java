package myOwnAnthill;
/**
 * This is the interface which contains methods for the organisms.
 * @authors K.O.  A.P.  E.B.K
 *
 */
public interface I_Organism {
	/**
	 * This method implements where the organism is setting.
	 * @param map stores position?.
	 */
	void setPlace(Map map);
	/**
	 * This method implements the way organism is changing the way. 
	 * @param map stores position?.
	 */
	void turn(Map map);
	/**
	 * This method implements moving.
	 * @param map stores position?
	 */
	void move(Map map);
	/**
	 * This method checks if organism lives.
	 * @param map stores position?
	 * @return 'true' - it lives,'false' - it doesn't live.
	 */
	boolean isAlive(Map map);
	/**
	 * This method implements organisms dying.
	 * @param map stores position?
	 */
	void die(Map map);
	/**
	 * This method checks if there is a food nearby.
	 * @param map stores position?
	 * @return 'true' - there is a food,'false' - there is no food.
	 */
	boolean foodNearby(Map map);
	/**
	 * This method implements organisms eating.
	 * @param map stores position?
	 */
	void eat(Map map);
	/**
	 * This method implements eating a food from up.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 * @param map ??
	 */
	void eatUp(int x, int y, Map map);
	/**
	 * This method implements eating a food from right.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 * @param map ??
	 */
	void eatRight(int x, int y, Map map);
	/**
	 * This method implements eating a food from down.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 * @param map ??
	 */
	void eatDown(int x, int y, Map map);
	/**
	 * This method implements eating a food from left.
	 * @param x stores the 'x' position on the map.
	 * @param y stores the 'y' position on the map.
	 * @param map ??
	 */
	void eatLeft(int x, int y, Map map);
}
