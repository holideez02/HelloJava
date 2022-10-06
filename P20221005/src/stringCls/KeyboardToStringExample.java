package stringCls;

import java.io.IOException;

public class KeyboardToStringExample {
	public static void main(String[] args) throws IOException {
		//키보드로부터 읽은 바이트 배열을 문자열로 변환
		byte[] bytes = new byte[100]; //읽은 바이트를 저장하기 위한 배열 생성
		
		System.out.println("입력");
		int readByteNo = System.in.read(bytes); //배열에 읽은 바이트를 저장하고 읽은 바이트 수를 리턴
		
		String str = new String(bytes,0,readByteNo-2); //배열을 0(처음부터)위치부터 readByteNo-2(length)만큼 String 객체로 생성
		System.out.println(str);
	}
}
