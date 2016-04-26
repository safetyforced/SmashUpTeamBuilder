package teamBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class fileIOHandler {

	static String teamName;

	public static ArrayList<Team> readData() {
		String teamIndex = "";
		int i = 0;
		ArrayList<Team> teams = new ArrayList<Team>();

		Path TeamPath = Paths.get("TeamInformation.txt");
		File TeamFile = TeamPath.toFile();

		try {
			FileReader r = new FileReader(TeamFile);
			BufferedReader in = new BufferedReader(r);
			String line = in.readLine();

			while (line != null) {
				if (!line.equals(""))
					i++;
				teamIndex = line;
				Team team = new Team(teamIndex, i);
				teams.add(team);
				line = in.readLine();
			}
			in.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return teams;
	}

}
