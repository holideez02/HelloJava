package co.edu.friend;

import java.util.Scanner;

//기능만.
public class FriendsDAO {

	private static FriendsDAO instance = new FriendsDAO();
	private FriendsDAO() {}
	public static FriendsDAO getInstance() {
		return instance;
	}
	
	
	Scanner scn = new Scanner(System.in);
	Friends[] myFriends = new Friends[100]; 
	boolean isCheck = false;
	
	//1. 연락처 생성
	public void addNumber() {
		System.out.println("연락처를 새롭게 생성합니다.");
		scn.nextLine();
		System.out.print("이름 입력>> ");
		String Name = scn.nextLine();
		System.out.print("연락처 입력>> ");
		String Num = scn.nextLine();
		System.out.print("메모 입력>> ");
		String Memo = scn.nextLine();
		
		Friends phoneNum = new Friends(Name, Num, Memo);
		
		for(int i=0; i<myFriends.length; i++) {
			if(myFriends[i] == null) {
				myFriends[i] = phoneNum;
				break;
			}
		}
	}
	//2. 연락처 보기
	public void numberList() {
		System.out.println("연락처를 조회합니다.");
		for(Friends phoneNum : myFriends) {
			if(phoneNum != null) {
				System.out.println(phoneNum.toString());
			} 
		}
	}
	//3. 연락처 수정
	public void changeNumber() {
		System.out.println("연락처를 수정합니다.");
		scn.nextLine();
		System.out.println("수정할 이름 선택>>> ");
		String name = scn.nextLine();
		
		for(int i=0; i<myFriends.length; i++) {
			if(myFriends[i] != null && myFriends[i].getName().equals(name)) {
				System.out.println(name + "의 정보를 수정합니다. 어떤 정보를 수정할까요? 1.이름 2.번호  3.메모  0.나가기");
				int menu = scn.nextInt();
				switch(menu) {
					case 1: 
						System.out.println("변경할 이름을 적어주세요.");
						String cName = scn.nextLine(); //변경할 이름 적기
						scn.nextLine();
						myFriends[i].setName(cName);
						System.out.println(myFriends[i].toString());
						break;
					case 2:
						System.out.println("변경할 번호를 적어주세요.");
						break;
					case 3:
						System.out.println("변경할 메모를 적어주세요.");
						break;
						default:
						System.out.println("나갑니다.");
				}
				break;
			}
		}
		
	}
	//4. 연락처 삭제
	public void delNumber() {
		System.out.println("연락처를 삭제합니다.");
		System.out.println("삭제할 이름 >>");
		String delName = scn.nextLine();
		
//		 연락처 없을때
		for(int i=0; i<myFriends.length; i++) {
			if(myFriends[i] != null && myFriends[i].getName().equals(delName)) {
				isCheck = true;
				break;
			}
		}
		if(!isCheck) {
			System.out.println("그런 이름은 없습니다.");
		}
		
		for(int i=0; i<myFriends.length; i++) {
			if(myFriends[i] != null && myFriends[i].getName().equals(delName)){
				myFriends[i] = null;
				break;
			}
		}System.out.println("삭제완료.");
	}
	//5. 전체메뉴
	public void exe() {
		boolean run = true;
		while(run) {
			System.out.println("1.연락처 생성 2.연락처 조회 3.연락처 수정 4.연락처 삭제 0.종료");
			System.out.println("선택하세요~ >>>");
			
			int menu = scn.nextInt();
			switch(menu) {
			case 1:
				addNumber();
				break;
			case 2:
				numberList();
				break;
			case 3:
				changeNumber();
				break;
			case 4:
				delNumber();
				break;
			case 0:
				run = false;
				break;
				default:
					System.out.println("잘못된 메뉴입니다.");
				
			}
		}
		System.out.println("프로그램 종료합니다.");
	}
	
	
}

