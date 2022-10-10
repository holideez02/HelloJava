package co.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest1 {
	public static void main(String[] args) {
		// null pointer 참조.
		String str = "Hello World!!!";
		//예외처리. RuntimeException 상속받아서 처리하는 예외클래스.
		try {			//예외가 없으면 밑에문장 실행
			String result = str.substring(0, 10); //여기서 에러가 발생
//			char chr = result.charAt(2); //charAt(2): 인덱스 번호 2번에 있는 문자 출력
			char chr = result.charAt(20);
			System.out.println(chr);
		} catch(NullPointerException e) { //에러가 발생하면 밑의 문장 실행
			System.out.println("참조하는 값이 없습니다.");
		} catch(StringIndexOutOfBoundsException e1) {
			System.out.println("인덱스 범위를 벗어난 값입니다.");
		} catch(RuntimeException e2) {
			System.out.println("실행 예외가 발생했습니다.");
		} catch(Exception e3) { //가장 상위 예외. 모든 예외 처리 가능. 순서도 중요 가장 큰 범위의 예외는 가장 마지막에.
			System.out.println("알 수 없는 예외가 발생했습니다.");
		}
//		public static void exceptMethod()
//		//일반 예외: Exception 상속받아서 처리하는 예외클래스.
//		try {
//			Class.forName("java.lang.String");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
//		Scanner scn = new Scanner(System.in);
//		while(true) {
//			System.out.println("숫자입력 >>> ");
//			try {
//				int menu = scn.nextInt(); //만약에 입력값이 숫자가 아니고 문자도 섞였다면? InputMismatchException발생
//				System.out.println("입력 값은 : " + menu);
//				break;
//			} catch(InputMismatchException e) {
//				System.out.println("숫자를 입력하세요!");
//				scn.nextLine(); // abc(Enter)
//			} finally {
//				System.out.println("반드시 실행할 코드! 잘된다!");
//				//db connection 사용하고 resource 반환.
//			}
//		}
		
		try { //호출했으니 예외를 받아서 처리해야함.
			exceptMethod();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 종료.");
	}
	
	public static void exceptMethod() throws ClassNotFoundException { //호출한 곳으로 예외 떠넘기기
	//일반 예외: Exception 상속받아서 처리하는 예외클래스.
	try {
		Class.forName("java.lang.String");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
}
