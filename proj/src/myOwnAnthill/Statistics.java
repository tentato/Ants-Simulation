package myOwnAnthill;

import java.io.File;
import java.io.FileWriter;

public class Statistics {
	
	public static void saveStatistics() {
		try {
			File file = new File("Statistics.txt");
			FileWriter writer = new FileWriter(file);
			writer.write("Number of Rocks: " + Rock.numberOfRocks + "\n");
			writer.write("Number of Food: " + Food.numberOfFood + "\n");
			writer.write("Number of Workers: " + Worker.numberOfWorkers + "\n");
			writer.write("Number of Warriors: " + Warrior.numberOfWarriors + "\n");
			writer.write("Number of Sponges: " + Sponge.numberOfSponges + "\n");
			writer.write("Number of Queens: " + Queen.numberOfQueens + "\n");
			writer.write("Number of Hatches: " + Queen.numberOfHatches + "\n");
			writer.close();
		}
		catch(Exception e){
			//ignore
		}
	}
}
