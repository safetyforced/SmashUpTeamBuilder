package teamBuilder;

import java.util.Scanner;

public class Validator {

	static Scanner scan = new Scanner(System.in);
	
	public static int readValidInt() {
		while (!scan.hasNextInt()) {
			scan.nextLine();
			System.out.print("Please enter a number: ");
		}
		int x = scan.nextInt();
		scan.nextLine();
		return x;
	}

	public static int getValidInt(int min, int max) {
		int i = readValidInt();
		while (i < min || i > max) {
			System.out.print("Please enter a number within range! (" + min + "-" + max + "): ");
			i = readValidInt();
		}
		return i;
	}
	
	public static String readValidString(int l) {
		while (!scan.hasNextLine() && scan.nextLine().length() > l) {
			scan.nextLine();
			System.out.print("Please enter a valid option: ");
		}
		String x = scan.nextLine();
		return x;
	}

	public static String getValidString(String inputs, int length) {
		String i = readValidString(length);
		while (!(i.matches(inputs))) {
			System.out.print("Please input a valid team name: ");
			i = readValidString(length);
		}
		return i;
	}
	
}
