package co.edu.friend;

import java.util.Scanner;

public class FriendApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		FriendService service = FriendListImpl.getInstance(); // FriendListImpl 인스턴스 생성.

		while (true) {
			System.out.println("1.추가 2.리스트 3.수정 4.삭제 9.종료");
			System.out.print("선택>> ");

			int menu = scn.nextInt(); scn.nextLine();
			
			if (menu == 1) { //추가메뉴
					System.out.println("1.회사친구 2. 학교친구 3.친구");
					Friend friend = null;
					int subMenu = scn.nextInt();
					if (subMenu == 1) {
						// 회사친구정보등록
						service.CoFriend(friend); 
					} else if (subMenu == 2) {
						// 학교친구등록
						service.UniFriend(friend);
					} else {
						// 친구정보등록
						service.addFriend(friend);
					}
				

			} else if (menu == 2) { //리스트메뉴
				// 친구의 정보를 출력하는데 getInfo()를 사용해서 출력. for사용.
				Friend[] list = service.friendList();
				Friend[] result = null;
				for (int i = 0; i < list.length; i++) {
					if (list[i] != null) {
						System.out.println(list[i].getInfo());
					}
				} 

			} else if (menu == 3) { //그냥 친구생성 메뉴
				System.out.println("변경할 친구이름입력>> ");
				String name = scn.nextLine();
				System.out.println("변경할 연락처 입력>> ");
				String number = scn.nextLine();

				service.modFriend(name, number);

			} else if (menu == 4) { // phoneNo를 매개값으로 사용하도록 관련된 인터페이스와 클래스를 수정.
				System.out.println("삭제할 친구의 연락처를 입력>> ");
				String phoneNo = scn.nextLine();
				try {
					service.delFriend(phoneNo); 
				} catch(Exception e2) {
					System.out.println("정보가 없습니다.");
				}

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else {
				System.out.println("잘못된 메뉴입니다.");
			}

		}
		System.out.println("프로그램 종료.");
		scn.close();
	}
}
