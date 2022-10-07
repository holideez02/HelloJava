package co.edu.collect;

import java.util.Scanner;

public class ExcitingGame {
	public static void main(String[] args) {

		long gameStart = System.currentTimeMillis();
		Scanner scn = new Scanner(System.in);
		String target = "is the API";
		String[] targetAry = target.split(" ");

		boolean run = false;
		System.out.println(target);
		while (true) {
			System.out.println("입력 >> ");
			String input = scn.nextLine();
			for (int i = 0; i < targetAry.length; i++) {
				if (targetAry[i] != null && targetAry[i].equals(input)) {
					targetAry[i] = null;
				}
			}
			run = true;
			for (String str : targetAry) {
				if (str != null) {
					System.out.printf("%s ", str);
					run = false; // while로 다시 돌아가기 위해
				}
			}
			long gameEnd = System.currentTimeMillis();
			long during = ((gameEnd - gameStart) / 1000); // 1분 30초 지나면 1*60*1000 + 30*1000 = 63000/60000분, 63000%6000 초(나머지) =>
			if (during > 10) {
				System.out.println("한 번 더 해보세요 ㅜㅜ!");
				System.out.println(during + "초입니다.");
				run = true;
			} 
			if (run) { // run이 true일때 내려옴
				System.out.println(during + "초입니다.");
				break;
			}

		}
	}
}
