package myOwnAnthill;

public class Simulation {
	
	public static void main(String[] args) {
		
		final int numberOfIterations = 200;
		final int timeBetweenIteration = 150; //milliseconds
		
		Map map = new Map();
		map.create();
		
		map.show();
		
		for(int i = 0; i < numberOfIterations; i++) {
			for(int j = 0; j < Worker.numberOfWorkers; j++) {
				map.ant[j].turn(map);
			}
			for(int j = 0; j < Warrior.numberOfWarriors; j++) {
				map.warrior[j].turn(map);
			}
			for(int j = 0; j < Sponge.numberOfSponges; j++) {
				map.sponge[j].turn(map);
			}
			map.queen[0].turn(map);
			map.show();
			sleep(timeBetweenIteration);
		}
		
		Statistics.saveStatistics();
	}
	
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {}
	}

}
