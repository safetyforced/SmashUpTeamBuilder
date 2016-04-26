package teamBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class fileIOHandler {

	static String teamName;

public static void saveData(ArrayList<Team> teams) {

	Path TeamPath = Paths.get("TeamInformation.txt");
	File TeamFile = TeamPath.toFile();

	try {
		FileReader read = new FileReader(TeamFile);
		BufferedReader in = new BufferedReader(read);
		
		FileWriter out = new FileWriter(TeamFile);
			
			for (int i = 0; i < teams.size(); i++) {
		Team team = teams.get(i);
		teamName = team.getName();
		
		out.append(teamName + "\n");
			}
		out.close();
		in.close();
		
		} catch (FileNotFoundException e) {
		// catches file not found exception and prints

		e.printStackTrace();
	} catch (IOException e) {
		// catches file not found exception and prints

		e.printStackTrace();
	}
}

public static ArrayList<Team> readData() {
	int teamIndex = -1;
	ArrayList<Team> customers = new ArrayList<Team>();

	Path TeamPath = Paths.get("TeamInformation.txt");
	File TeamFile = TeamPath.toFile();

	try {
		FileReader r = new FileReader(TeamFile);
		BufferedReader in = new BufferedReader(r);
		String line = in.readLine();

		while (line != null) {
			if (!line.equals(""))

			teamIndex = Integer.parseInt(line);
			Team team = new Team(teamIndex);
			customers.add(team);
			line = in.readLine();
		}
		in.close();
	}

	catch (Exception e) {
		e.printStackTrace();
	}
	return customers;
}


}

