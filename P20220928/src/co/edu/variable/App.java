package co.edu.variable;

// 자바는 class에서 시작한다.
// 클래스의 main메소드로 시작.
public class App {
	public static void main(String[] args) {
		System.out.println("매개값을 출력."); // (괄호안의 매개값을 출력)
		
		//변수의 타입 지정.  => 정수(int, long), 실수(double, float)
		//참/거짓(boolean), 문자열(string)
		
		int myAge = 25; // 왼쪽 = 오른쪽 타입 항상 동일.
//		myAge ="스물다섯" ;  //타입이 다르기 때문에 컴파일 에러.
		String 내나이 = "스물다섯"; //한글로 변수설정 가능하지만 가급적 쓰지 않음
		내나이 = "28"; //문자열 28.
		
		int result = myAge + 30;
		System.out.println(myAge + "값과 30을 더하면 " + result + "입니다.ㅎㅎ");
		
		//배열.
		// 자바스크립트에서는 let numAry=[]; 가능하지만 자바에서는 조금 다르다
		int[] numAry = {20, 29, 13, 44, 88, 33}; // 정수를 담을 수 있는 배열 선언.
		int sum = 0;
//		1) 배열의 합계.
		for(int i=0; i< 6; i++) {
//			System.out.println(numAry[i]); //배열 보여줌
			//짝수 조건일 경우에만 합계. 짝수(i%2==0), 홀수(i%2==1)
//			if(numAry[i] %2==0) { 
//				sum = sum + numAry[i];
//			}
			//배열에서 0번, 2번, 4번 등 짝수인덱스의 합계.
			if(i % 2 == 0) {
				sum = sum + numAry[i];
			}
		}
		System.out.println("짝수 합계=>" + sum);
		
//		2) 배열 조건.
		sum = 0; //0값으로 초기화. 문제: sum의 값이 100을 넘어는 시점에 break;
		
		for(int i=0; i<numAry.length; i++) {
			sum = sum+ numAry[i];
			if(sum > 100) {
				break;
			}
		} System.out.println("값은 " + sum);
		
		
		
		
	}
}
