package teamBuilder;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class TeamBuilder {

	static int teamSelection;
	static int[][] playerTeam;
	static Team[][] teamReturn;
	static ArrayList<Team> list;

	public static void main(String[] args) {

		System.out.println("How many players do you have?: ");

		int numberOfPlayers = Validator.getValidInt(1, 19);
		int[] exceptionList = new int[2 * (numberOfPlayers + 1)];
		exceptionList[0] = 0;
		teamReturn = new Team[2][numberOfPlayers];
		playerTeam = new int[2][numberOfPlayers];
		int exceptionListIncrement;
		list = fileIOHandler.readData();

		for (int x = 1; x <= 2; x++) {

			exceptionListIncrement = (x - 1) * numberOfPlayers;
			System.out.println("");

			for (int i = 1; i <= numberOfPlayers; i++) {

				teamSelection = randomTeam();

				if (IntStream.of(exceptionList).anyMatch(y -> y == teamSelection)) {
					i--;
				} else {
					playerTeam[x - 1][i - 1] = teamSelection;
					teamReturn[x - 1][i - 1] = findTeam(list, teamSelection);
					exceptionList[exceptionListIncrement + (i)] = teamSelection;
					System.out.print(list.get(teamSelection).getName() + "\t" + "\t");

				}

			}
		}

	}

	public static int randomTeam() {
		Random rand = new Random();
		return rand.nextInt(41) + 1;
	}

	public static Team findTeam(ArrayList<Team> teams, int index) {
		Team team = teams.get(index);
		return team;
	}

}
