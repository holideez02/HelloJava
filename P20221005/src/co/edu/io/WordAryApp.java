package co.edu.io;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordAryApp {

	public static void main(String[] args) throws Exception {
		// 임의 문장을 10개씩 출력하고 타이핑해서 맞으면 사라지고...
		Scanner scn = new Scanner(System.in);
		ArrayList<String> words = randomWords(10);

		for (String word : words) {
			System.out.println(word);
		}
		// 하나씩 찾아서 지우기
		while (true) {
			System.out.println("입력>>");
			String inputVal = scn.nextLine();
			for (int i = 0; i < words.size(); i++) {
				if (words.get(i) != null && words.get(i).equals(inputVal)) {
					words.remove(i);
				}
			}
			System.out.println("삭제되었습니다.");

			for (String word : words) {
				if (word != null) {
					System.out.printf("%s", word);
				}
			}
			if (words.isEmpty()) {
				System.out.println("모든 문장 삭제 되었어요");
				break;
			}
		}
	}

	public static ArrayList<String> randomWords(int times) throws Exception {
		// ArrayList<String>에 전체 문장을 담고.. 매개값에따라 출력되는 갯수 다르게
		ArrayList<String> words = new ArrayList<String>();
		String path = "src/co/edu/io/wordAry.txt";
		File file = new File(path); // 파일객체를 만들고
		Scanner scn = new Scanner(file); // 스캐너에 매개값으로 file
		while (scn.hasNext()) { // 값이있다면 true 한줄씩 읽어오세요
			String readStr = scn.nextLine();
			readStr = readStr.replaceAll("\"", "").trim(); // 따옴표는 삭제, trim으로 공백 제거
//			System.out.println(readStr);
			words.add(readStr.substring(0, readStr.indexOf(","))); // , 가 있는 문자의 인덱스 값 반환해서 자를거야
		}

		// 임의로 times 갯수만큼을 반환하도록.
		ArrayList<String> randomWords = new ArrayList<String>();
//		for(int i=0; i<times; i++) {
//			int random = (int) (Math.random() * 494);
//			randomWords.add(words.get(random));
//		}
		// 중복된 값 제거하기 위해서 Set 컬렉션을 사용하여 저장.
		Set<Integer> idxSet = new HashSet<>();
		while (idxSet.size() < times) {
			idxSet.add((int) (Math.random() * words.size()));
		}
		for (int idx : idxSet) {
			randomWords.add(words.get(idx));
		}

		scn.close();
		return randomWords;
	}
}
