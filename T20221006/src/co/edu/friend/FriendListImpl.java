package co.edu.friend;

import java.util.Scanner;

public class FriendListImpl implements FriendService {
	Scanner scn = new Scanner(System.in);
	Friend[] friendList = new Friend[10]; // 친구정보 10명을 저장할 수 있는 공간생성 완료.

	private static FriendListImpl instance = new FriendListImpl();

	private FriendListImpl() {
	}

	public static FriendListImpl getInstance() {
		return instance;
	}

	@Override
	public void addFriend(Friend friend) {
		// 배열에 친구정보를 저장하도록 추가하세요.
		System.out.println("연락처를 새롭게 생성합니다.");
		System.out.println("이름 >>>");
		String name = scn.nextLine();
		System.out.println("전화번호 >>>");
		String phone = scn.nextLine();

		Friend frd = new Friend(name, phone);
		for (int i = 0; i < friendList.length; i++) {
			if (friendList[i] == null) {
				friendList[i] = frd;
				break;
			}
		}
		System.out.println("친구가 생성되었습니다.");
	}

	@Override
	public void CoFriend(Friend coFriend) {
		// 배열에 회사친구정보를 저장하도록 추가하세요.
		System.out.println("회사친구 연락처를 새롭게 생성합니다.");
		System.out.println("이름 >>>");
		String name = scn.nextLine();
		System.out.println("전화번호 >>>");
		String phone = scn.nextLine();
		System.out.println("회사명 >>>");
		String company = scn.nextLine();
		//예외처리 위해 부서번호 int로 설정하였습니다!!!!
		int department = -1;
		while(true) {
			try {
				System.out.println("부서번호 >>>");
				department = Integer.parseInt(scn.nextLine());
				break;
			} catch(NumberFormatException e) {
				System.out.println("부서번호는 숫자로 입력하세요");
			}
		}
		CoFriend frd = new CoFriend(name, phone, company, department);
		for(int i=0; i<friendList.length; i++) {
			if(friendList[i] == null) {
				friendList[i] = frd;
				break;
			}
		}
		System.out.println("회사친구가 생성되었습니다.");
	}

	@Override
	public void UniFriend(Friend uniFriend) {
		System.out.println("대학친구 연락처를 새롭게 생성합니다.");
		System.out.println("이름 >>>");
		String name = scn.nextLine();
		System.out.println("전화번호 >>>");
		String phone = scn.nextLine();
		System.out.println("대학명 >>>");
		String college = scn.nextLine();
		System.out.println("전공 >>>");
		String major = scn.nextLine();

		UniFriend frd = new UniFriend(name, phone, college, major);
		for (int i = 0; i < friendList.length; i++) {
			if (friendList[i] == null) {
				friendList[i] = frd;
				break;
			}
		}
		System.out.println("대학친구가 생성되었습니다.");

	}

	@Override
	public Friend[] friendList() {
		// 전체 친구목록을 반환하도록 수정하세요(반환유형에 유의).
		System.out.println("친구를 조회합니다.");
		Friend[] result = null;
		for (int i = 0; i < friendList.length; i++) {
			if (friendList[i] != null) {
				System.out.println(friendList[i].getInfo());
			}
		}
		return result;
	}

	@Override
	public void modFriend(String name, String phoneNumber) {
		// 친구이름을 찾아서 연락처를 변경하도록 추가하세요.
		for (int i = 0; i < friendList.length; i++) {
			if (friendList[i] != null && friendList[i].getName().equals(name)) {
				friendList[i].setPhoneNumber(phoneNumber);
			}
		}
		System.out.println(phoneNumber + "번으로 연락처 변경 완료.");
	}

	@Override
	public void delFriend(String phoneNo) {
		// 삭제할 연락처를 입력받아서 배열에서 찾아 삭제하세요.
		for (int i = 0; i < friendList.length; i++) {
			if (friendList[i] != null && friendList[i].getPhoneNumber().equals(phoneNo)) {
				friendList[i] = null;
				break;
			}
		}
		System.out.println("삭제완료.");

	}

}
