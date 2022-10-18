package myProject;

import java.util.Scanner;

public class Utils {
	static Scanner scn = new Scanner(System.in);

	public static String readStr(String prompt) {

		System.out.printf(prompt);
		String inputVal = scn.nextLine();
		if (inputVal.indexOf("quit") != -1) {
			return "quit";
		}
		return inputVal;
	}
}
