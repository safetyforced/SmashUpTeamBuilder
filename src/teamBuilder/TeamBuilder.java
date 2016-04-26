package teamBuilder;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TeamBuilder {

	static int teamSelection;
	static int[][] playerTeam;
	static String[][] teamReturn;


	public static void main(String[] args) {

		Random rand = new Random();
		int numberOfPlayers;

		System.out.println("How many players do you have?: ");
		numberOfPlayers = Validator.getValidInt(1, 19);

		int[] exceptionList = new int[2 * (numberOfPlayers + 1)];
		exceptionList[0] = 0;
		teamReturn = new String[2][numberOfPlayers];
		playerTeam = new int[2][numberOfPlayers];


		int exceptionListIncrement;
		for (int x = 1; x <= 2; x++) {

			exceptionListIncrement = (x - 1) * numberOfPlayers;
			System.out.println("");

			for (int i = 1; i <= numberOfPlayers; i++) {

				teamSelection = rand.nextInt(41) + 1;

				if (IntStream.of(exceptionList).anyMatch(y -> y == teamSelection)) {
					i--;
				} else {
					playerTeam[x - 1][i-1] = teamSelection;
					exceptionList[exceptionListIncrement + (i)] = teamSelection;
					System.out.print(teamSelection + "\t");


				}

			}
		}

	}

	public static int readValidInt(Scanner input) {
		int players = 0;

		while (true) {

			try {
				System.out.print("How many players do you have?: ");
				players = input.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Please enter a valid number (1-19).");
				input.nextLine();
				continue;
			}

		}
		return players;
	}

}
