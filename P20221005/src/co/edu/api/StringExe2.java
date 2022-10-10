package co.edu.api;

import java.io.IOException;
import java.util.Scanner;

public class StringExe2 {
	public static void main(String[] args) {
//		System.out.println("abcDEF".toLowerCase());
//		while(true) {
//			try {
//				int bytes = System.in.read();
//				if(bytes == 122)//z 값이 122. z누르면 종료
//					break;
//				
//				System.out.println("입력값: " + bytes);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} 
//		System.out.println("end of prog.");
//	}
		try {
			changeCapital("abcDEF");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void changeCapital(String msg) throws IOException {
		// 대문자 -> 소문자, 소문자-> 대문자로 바꾸는 기능 32씩 차이남.
		// aBcD => AbCd a97:A65 (-32), b98:B66(-32)
		// 소문자: 97~122, 대문자: 65~90
		byte[] bytes = new byte[100];

		Scanner scn = new Scanner(System.in);
		System.out.println("입력하세요.");
		String input = scn.nextLine();
		char[] arr= input.toCharArray(); // 문자열을 문자 배열로

		for (int i = 0; i < arr.length; i++) {
			if (65 <= arr[i] && arr[i] <= 90) { // 대문자일때 값에 +32해서 소문자로 변환
				arr[i] = (char) (arr[i] + 32);
				continue;
			} else if (97 <= arr[i] && 122 >= arr[i]) { // 소문자일때 값에 -32해서 대문자로 변환
				arr[i] = (char) (arr[i] - 32);
				continue;
			}

		}
		System.out.println(arr);
		
//		String[] msgAry = msg.split("");
//		byte[] bytes = new byte[msg.length()];
//		int i=0;
//		for (String str: msgAry) {
//			char chr = str.charAt(0);
//			int chr2 = 0;
//			
//			if(chr>=97){
//				chr2 = chr-32;
//			}else if (chr<=92) {
//				chr2 = chr +32;
//			}
//		}

	}
}