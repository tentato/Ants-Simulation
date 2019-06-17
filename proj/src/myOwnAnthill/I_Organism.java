package myOwnAnthill;

public interface I_Organism {
	void setPlace(Map map);
	void turn(Map map);
	void move(Map map);
	boolean isAlive(Map map);
	void die(Map map);
	boolean foodNearby(Map map);
	void eat(Map map);
	void eatUp(int x, int y, Map map);
	void eatRight(int x, int y, Map map);
	void eatDown(int x, int y, Map map);
	void eatLeft(int x, int y, Map map);
}
