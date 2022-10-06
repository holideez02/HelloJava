package co.edu.api;

import java.io.IOException;

public class StringExe2 {
	public static void main(String[] args) {
//		System.out.println("abcDEF".toLowerCase());
		while(true) {
			try {
				int bytes = System.in.read();
				if(bytes == 122)//z 값이 122. z누르면 종료
					break;
				
				System.out.println("입력값: " + bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		System.out.println("end of prog.");
	}


public static void changeCapital(String msg) {
	//대문자 -> 소문자, 소문자-> 대문자로 바꾸는 기능 32씩 차이남.
	// aBcD => AbCd  a97:A65 (-32), b98:B66(-32)
	//소문자: 97~122, 대문자: 65~90
	
	
	}
}