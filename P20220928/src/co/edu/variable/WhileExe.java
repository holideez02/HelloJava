package co.edu.variable;

import java.util.Scanner;

public class WhileExe {

	public static void main(String[] args) {
//		whileFnc();
		whileFnc2();
//		whileFnc3();
	}
	
	public static void whileFnc3() {
		// 보고싶은 달을 입력. 종료하고 싶으면 9 입력.
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("   월을 선택하세요. 종료는 -1번입니다.");
			int input = scn.nextInt(); // 정수값으로 받아오는 값
			if(input == -1) {
				break;
			}
			MethodCalendar.makeCal(input); //methodcalendar라는 클래스의 makecal메소드를 불러오는것
			System.out.println();
		}
		System.out.println("end of pgm");
		scn.close();
	}
	
	public static void whileFnc2() {
		// while 구문. 조건이 되면 실행하거나 멈추는 것.. 횟수보다 조건이 더 중요시됨
		Scanner scn = new Scanner(System.in); //키보드에 입력된 어떤 값을 읽어올게요. 가지고 와야하니까 import : ctrl+shift+O
		while(true) { 
			System.out.println("값을 입력하세요. 종료하려면 stop입력.");
			String inputVal = scn.nextLine();
			if(inputVal.equals("stop")) { //stop이라고 쓰면 멈춰
				break; // 안멈추면 그대로 무한반복이겠지
			}
			System.out.println("사용자 입력값> " + inputVal);
		}
		System.out.println("end of program");
		scn.close(); //시스템 자원을 반환.
	}
	
	public static void whileFnc() {
		//for 반복문: 반복횟수가 정해져 있다면 씀. for(int i=0; i<10; i++){}
		int i=0;
		while(i<4) { //()안의 값이 true이면 괄호안의 것을 실행함
			System.out.println(i);
			i++; //i값을 증가시켜야 무한반복이 되지 않겠지
		}
		System.out.println("end of program");
	}
}
