package myOwnAnthill;
/**
 * This is the interface which contains methods for the queen.
 * @authors K.O.  A.P.  E.B.K
 *
 */
public interface I_Queen {
	/**
	 * This method implements how the queen eats.
	 * @param map stores position?.
	 */
	void eat(Map map);
	/**
	 * This method implements producing the ants by the queen.
	 * @param map
	 * @return 'true' - ants produced,'false' - bad conditions for producing.
	 */
	boolean produce(Map map);
}
