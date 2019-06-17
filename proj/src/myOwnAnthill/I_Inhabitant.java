package myOwnAnthill;

public interface I_Inhabitant {
	void turn(Map map);
	void escape(Map map);
	boolean goUp(Map map);
	boolean goRight(Map map);
	boolean goDown(Map map);
	boolean goLeft(Map map);
}
