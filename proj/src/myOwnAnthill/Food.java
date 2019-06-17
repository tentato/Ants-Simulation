package myOwnAnthill;

public class Food {
	
	public int postionX;
	public int postionY;
	public int nutrition = 100;	//For now there is 100
	
	public static int numberOfFood = 0;
	
	public Food(int x, int y) {
		this.postionY = y;
		this.postionX = x;
		numberOfFood++;
	}
}
