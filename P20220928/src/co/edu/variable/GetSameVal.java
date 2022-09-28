package co.edu.variable;

import java.util.Scanner; // scanner를 데려오기 위해 다른패키지에 있는 scanner를 불러옴
import java.lang.System; // sysout하면 나타나는 패키지이름. 같은 패키지에 있어서 굳이 부르지 않아도 됨

//java.lang 이 베이스 패키지.
public class GetSameVal {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); //사용자 입력 값을 저장.
		System.out.println("이름을 입력하세요>>> ");
		String name = scn.nextLine(); // 사용자입력값을 읽어들이고 반환.
		
		String[] names = {"김현지", "김유리", "남미주", "송지은"};
		boolean isChecked = false;
		//김유리라는 이름을 입력하면 ~위치에 있습니다.라고 띄우기
		for(int i=0; i<names.length; i++) {
			//"몇번째 위치에 있습니다."출력
			if(names[i].equals(name)) {
				System.out.println((i+1)+"번째 위치에 있습니다"); //문자열 비교는 문자열.equals(비교문자열)!!!!!!
				isChecked = true;
				break;
			} 
		}
		if(!isChecked) {
			System.out.println("찾는 이름이 없습니다.");
		}
		System.out.println("입력값: " + name); 
		scn.close();
	}
}
