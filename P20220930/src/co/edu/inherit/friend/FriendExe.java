package co.edu.inherit.friend;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendExe {
	Scanner scn = new Scanner(System.in);
//	Friend[] friends = new Friend[10];
	ArrayList friends = new ArrayList();
	
	//친구를 등록 - 학교/회사/일반친구.. 구분해서 등록
	public void exe() {
		
		while(true) {
			System.out.println("1.친구등록 2.조회 3.종료");
			System.out.print("선택>> ");
			
			int menu = scn.nextInt();scn.nextLine();
			if(menu ==1) {
				System.out.println("1.회사친구 2.학교친구 3.친구");
				int subMenu = scn.nextInt();scn.nextLine();
				if(subMenu==1) {
					addComFriend();
				}else if(subMenu==2){
					addUnivFriend();
				}else if(subMenu==3) {
					addFriend();
				}
			}else if(menu ==2) {
				searchFriend();
			}else if(menu ==3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		}
		System.out.println("프로그램 종료.");
	} //end of exe();
	
	//추가 메소드 정의.
	//회사친구 등록.
	public void addComFriend() {
		System.out.println("이름?");
		String name = scn.nextLine();
		System.out.println("연락처?");
		String phone = scn.nextLine();
		System.out.println("회사명?");
		String company = scn.nextLine();
		System.out.println("부서?");
		String dept = scn.nextLine();
		
		ComFriend comFrnd = new ComFriend(name, phone, company, dept);
//		for(int i=0; i<friends.length; i++) {
//			if(friends[i] == null) {
//				friends[i] = comFrnd;
//				break;
//				}
//			}
		friends.add(comFrnd);
		
		System.out.println("회사친구가 생성되었습니다.");
	
	}
	
	//학교친구 등록.
	public void addUnivFriend() {
		System.out.println("이름?");
		String name = scn.nextLine();
		System.out.println("연락처?");
		String phone = scn.nextLine();
		System.out.println("학교이름?");
		String univ = scn.nextLine();
		System.out.println("전공?");
		String major = scn.nextLine();
		
		UnivFriend uniFrnd = new UnivFriend(name, phone, univ, major);
//		for(int i=0; i<friends.length; i++) {
//			if(friends[i] == null) {
//				friends[i] = uniFrnd;
//				break;
//				}
//			}
		friends.add(uniFrnd);
		
		System.out.println("학교친구가 생성되었습니다.");
		}
		
	
	// 일반친구 등록.
	public void addFriend() {
		System.out.println("이름?");
		String name = scn.nextLine();
		System.out.println("연락처?");
		String phone = scn.nextLine();
		
		Friend frd = new Friend(name, phone);
//		for(int i=0; i<friends.length; i++) {
//			if(friends[i] == null) {
//				friends[i] = frd;
//				break;
//			}
//		}
		friends.add(frd); //비워진 위치에 한건 등록. for문 대신 이렇게 간단히 할 수 있다
		System.out.println("일반친구가 생성되었습니다.");
	}
	
	// 조회.
	public void searchFriend() {
		//권수미, 권미현, 강민기. => 자바 문자열 포함. 
		System.out.println("어떤친구를 조회할까요?");
		String searchKey = scn.nextLine(); 
		
//		for(int i=0; i<friends.length(); i++) {
//			if(friends[i] != null && friends[i].getName().contains(searchKey)) //특정문자열이 포함되어 있으면 출력(contains), 완전히 같은거 찾으려면 equals로 바꾸기
//				System.out.println(friends[i].showInfo());
//			}
		for(int i=0; i<friends.size(); i++) {
			//Friend 클래스의 상속을 사용했었지. 어떤 인스턴스는 friend라는 클래스의 인스턴스, 어떤거는 comfriend,univ....
//			Friend frnd = (Friend) friends.get(i); //object로 가져오니 friend로 형변환 해줌. 근데 모두 friend로 (부모로) 바꿔버리면?
//			System.out.println(frnd.showInfo()); //부모클래스의 showInfo가 실행될거야. 안되겠지? 상황에따라서 comfriend로, univ로 바꿔줘야하는데..
			Object frnd = friends.get(i);
			if(frnd instanceof Friend) { //frnd 변수의 타입이 어떤 유형의 클래스인지 물어보고 
				Friend friend = (Friend) frnd;
				System.out.println(friend.showInfo());
				
			} else if(frnd instanceof ComFriend) {
				ComFriend friend = (ComFriend) frnd;
				System.out.println(friend.showInfo()); 
				
			} else if(frnd instanceof UnivFriend) {
				UnivFriend friend = (UnivFriend) frnd;
				System.out.println(friend.showInfo());
			}
		}
		
		
		}
	}

