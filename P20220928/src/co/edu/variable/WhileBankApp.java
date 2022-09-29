package co.edu.variable;

import java.util.Scanner;

// 계좌정보 선언: 계좌번호, 예금주, 잔고 
// 은행 계좌생성: Account[] banks;
public class WhileBankApp {
	
	public static void main(String[] args) {
		//메뉴: 1.예금, 2:출금, 3:잔액, 4:종료
		Account[] banks = new Account[10]; //일단 뭐가 들어올지 모르니 10개 담을 수 있는 공간부터 생성.
		
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("0.계좌생성, 1.예금, 2:출금, 3:잔액, 4:종료");
			int menu = scn.nextInt();scn.nextLine();
			boolean isCheck =false;
			
			if(menu == 1) {
				//예금기능. 계좌번호, 얼마 예금할건지?
				System.out.println("계좌번호>>> ");
				String accNo = scn.nextLine(); //계좌번호 입력받기
				System.out.println("예금할 금액>>> ");
				int money = scn.nextInt(); //예금할 돈
				
				//계좌번호 존재 확인
				for(int i=0; i<banks.length; i++) {
					if(banks[i] != null && banks[i].accNo.equals(accNo)){
						isCheck = true;
						break;
					} 
				}
				if(!isCheck) {
					System.out.println("계좌번호가 없습니다..");
				}
				
				for(int i=0; i<banks.length; i++) { //배열 돌면서 찾기
					if(banks[i] != null && banks[i].accNo.equals(accNo)) { //비교할 수 있는 값이 없는데 null을 만나면 nullpoint어쩌고 오류. 그러니 null이 아닌경우도 조건으로 달아줘야 함!
						if(money+banks[i].balance <= 100000) {
						banks[i].balance = banks[i].balance + money; //현재 가지고 있는 금액을 가지고와서 거기에 더해주기(누적)
						} else {
							System.out.println("10만원 이상은 안됩니다.");
						}
					}
				}
				
			}else if(menu == 2) {
				//출금기능. 계좌번호. 얼마 출금할건지?
				System.out.println("계좌번호>>> ");
				String accNo = scn.nextLine(); //계좌번호 입력받기
				System.out.println("출금할 금액>>> ");
				int money = scn.nextInt(); //출금할 돈!
				
				//계좌번호 존재 확인
				for(int i=0; i<banks.length; i++) {
					if(banks[i] != null && banks[i].accNo.equals(accNo)){
						isCheck = true;
						break;
					} 
				}
				if(!isCheck) {
					System.out.println("계좌번호가 없습니다..");
				}
				
				for(int i=0; i<banks.length; i++) { //배열 돌면서 찾기
					if(banks[i] != null && banks[i].accNo.equals(accNo)) {
						if(banks[i].balance > money) {
						banks[i].balance = banks[i].balance - money; //현재 가지고 있는 금액을 가지고와서 거기에 더해주기
						} else {
							System.out.println("잔고 부족");
						}
					}
				}
				
			}else if(menu == 3) {
				System.out.println("조회할 계좌번호 입력>>> ");
				String accNo = scn.nextLine();
				
				//계좌번호 존재 확인
				for(int i=0; i<banks.length; i++) {
					if(banks[i] != null && banks[i].accNo.equals(accNo)){
						isCheck = true;
						break;
					} 
				}
				if(!isCheck) {
					System.out.println("계좌번호가 없습니다..");
				}
				
				for(int i=0; i<banks.length; i++) {
					if(banks[i] != null && banks[i].accNo.equals(accNo)) {
						System.out.println("잔액: " + banks[i].balance);
					}
				}
			}else if(menu == 4) {
				break;
				
			}else if(menu == 0) {
				System.out.println("계좌번호 입력>>> ");
				String accNo = scn.nextLine();
				System.out.println("예금주>>> ");
				String owner = scn.nextLine();
				
				Account acc = new Account(); //인스턴스 생성
				acc.accNo = accNo;
				acc.owner = owner;
				//계좌번호 생성.
				for(int i=0; i<banks.length; i++) { //배열을 빙글빙글 돌면서
					if(banks[i] == null) { //이 배열이 null 비어진 위치에다가 넣을거야
						//한건 입력. break;
						banks[i] = acc; //새로운 계좌번호와 예금주 acc인스턴스를 넣자!
						break; // 안쓴다면.. 그 뒤에 null값들한테도 그 값들이 들어가버린다. 하나만 넣을거니까! 넣고나면 break해서 빠져나오기.
					}
				}
				System.out.println("계좌생성 완료.");
			}
		}// end of program. 
		System.out.println("종료합니다.");
	}
}
