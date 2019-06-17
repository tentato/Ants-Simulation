package myOwnAnthill;

public interface I_Warrior {
	
	public boolean spongeNearby(Map map);
	public void attack(Map map);
	public void attackUp(int x, int y, Map map);
	public void attackRight(int x, int y, Map map);
	public void attackDown(int x, int y, Map map);
	public void attackLeft(int x, int y, Map map);
}
