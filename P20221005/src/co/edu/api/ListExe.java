package co.edu.api;

import java.util.ArrayList;

public class ListExe {
	public static void main(String[] args) {
		//컬렉션
		int[] intAry = new int[5];
		ArrayList<Integer> list = new ArrayList<Integer>(); // 제네릭(<>)안에는 기본 타입을 못씀. int라던지.. 클래스타입으로만 쓸 수 있음.integer.
		list.add(100); //100은 int지만 알아서 기본데이터타입을 wrapper로 변경해줌. 박싱
		
		int a = 5;
		Integer b = 10; // int -> Integer로 박싱. 기본데이터 타입을 클래스타입으로 박싱해줌.
		a = b; //b는 클래스인데, 기본데이터인 a에도 담을 수 있음. 이런걸 언박싱!
		System.out.println(a);
	}
}
