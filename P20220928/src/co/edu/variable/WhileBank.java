package co.edu.variable;

import java.util.Scanner;

public class WhileBank {
	
	public static void main(String[] args) {
		bankApp();
	}
	
	public static void bankApp() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int money = 0;
		
		//메뉴: 1:예금, 2:출금, 3:잔고확인, 4:종료
		//10만원이 넘으면 예금불가.
		while(run) {
			System.out.println("메뉴: 1:예금, 2:출금, 3:잔고, 4:종료");
			int menu = scn.nextInt();
			
			switch(menu) {
			case 1: //예금
				System.out.println("예금처리하는 메뉴.");
				System.out.println("예금액을 입력 >>> ");
				int input = scn.nextInt(); //입력금액을 input에 저장
					if(input+money <= 100000) {
						money = money + input;
					} else {						
						System.out.println("10만원 이상은 안됩니다.");
					}
				break;
			case 2: //출금
				System.out.println("출금처리하는 메뉴.");
				System.out.println("출금액을 입력 >>> ");
				int output = scn.nextInt(); 
					if(money-output > 0) {
						money = money - output;
					} else {
						System.out.println("마이너스 금액은 안됩니다.");						
					}
				break;
			case 3: //잔액
				System.out.println("잔고확인하는 메뉴.");
				System.out.println("현재 잔고는: " + money+"원 입니다.");
				break;
			case 4:
				System.out.println("종료하는 메뉴.");
				run = false; // false로 바뀌지 않으면 계속 실행을 시켜주는 것
			}
			
		}//end of while
		System.out.println("end of pgm");
	} //end of bankApp();
}
