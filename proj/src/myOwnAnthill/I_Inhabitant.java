package myOwnAnthill;
/**
 * This is the interface which contains methods for the inhabitants.
 * @authors K.O.  A.P.  E.B.K
 *
 */
public interface I_Inhabitant {
	/**
	 * This method ...???
	 * @param map stores position?
	 */
	void turn(Map map);
	/**
	 * This method implements the way ant escapes the anthill.
	 * @param map stores position?
	 */
	void escape(Map map);
	/**
	 * This method implements going up.
	 * @param map stores the position on the map.
	 * @return 'true' or 'false'
	 */
	boolean goUp(Map map);
	/**
	 * This method implements going right.
	 * @param map stores the position on the map.
	 * @return 'true' or 'false'
	 */
	boolean goRight(Map map);
	/**
	 * This method implements going down.
	 * @param map stores the position on the map.
	 * @return 'true' or 'false'
	 */
	boolean goDown(Map map);
	/**
	 * This method implements going left.
	 * @param map stores the position on the map.
	 * @return 'true' or 'false'
	 */
	boolean goLeft(Map map);
}
