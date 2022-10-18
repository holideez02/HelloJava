package myProject;

import java.util.Scanner;

public class Utils {
	static Scanner scn = new Scanner(System.in);

	public static String readStr(String prompt) {

		System.out.printf(prompt);
		String inputVal = scn.nextLine();
		if (inputVal.indexOf("quit") != -1) { //quit값을 입력받는다면
			return "quit";
		}
		return inputVal; //quit가 아니라면 입력값 그대로 출력
	}
}
