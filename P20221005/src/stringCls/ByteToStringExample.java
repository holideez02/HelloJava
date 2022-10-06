package stringCls;

public class ByteToStringExample {
	public static void main(String[] args) {
		//바이트 배열을 문자열로 변환
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		
		String str1 = new String(bytes); // 배열 전체를 String 객체로 생성
		System.out.println(str1);
		
		String str2 = new String(bytes, 6, 4); //배열에서 6위치부터 4개까지 객체 생성
		System.out.println(str2);
	}
}
