package co.edu.inherit.friend;

import java.util.ArrayList;

public class ArrayExam {
	public static void main(String[] args) {
		String[] flowers = new String[3];
		flowers[0] = "장미";
		flowers[1] = "해바라기";
		flowers[2] = "무궁화꽃";
//		flowers[3] = "목련"; //에러가 나겠지. 
		
		// flowers2 선언
		String[] flowers2 = new String[6];
		
		for(String str : flowers2) {
			if(str != null) {
				System.out.println(str);
			}
		}
		
		//배열의 크기 고정 => 컬렉션(ArrayList);
		//Object 모든 클래스의 최상위 클래스. ArrayList에는 모든 형태의 데이터를 다 담을 수 있음.
		
		ArrayList flowers3 = new ArrayList(); //크기가 10개짜리인 공간이 자동으로 생성.
		flowers3.add("장미"); //첫번째 위치에 장미저장.
		flowers3.add("해바라기");
		flowers3.add("무궁화꽃");
//		flowers3.add(123); 담을수는 있어도 오류가 날 수 있으니 조심 
		
		for(Object str : flowers3) {
			String result = (String)str; //담겨져있는 값을 문자로 바꿀거야~한다면 형변환. 
			System.out.println(result);
		}
		
		//컬렉션의 크기:size()
		for(int i=0; i<flowers3.size(); i++) { // ArrayList에서는 length 대신 size라는 메소드로 크기 제공 
			String result = (String) flowers3.get(i);
			System.out.println(result);
		}
	}
}
