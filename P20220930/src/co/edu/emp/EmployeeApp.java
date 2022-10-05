package co.edu.emp;

import java.util.Scanner;

//메인 클래스.
public class EmployeeApp {
	public static void main(String[] args) {
		//1.사원수(초기화) 2.사원정보입력 3.사원검색 4.사원리스트 9.종료
		Scanner scn = new Scanner(System.in);
//		EmployeeService service = new EmployeeArray(); //배열로 정의
		EmployeeService service = new EmployeeArrayList(); //컬렉션으로 정의
		
		
		while(true) {
			System.out.println("1.사원수(초기화) 2.사원정보입력 3.사원검색 4.사원리스트 5.사원급여 9.종료");
			System.out.print("선택>>> ");
			try {
				int menu = Integer.parseInt(scn.nextLine()); // "1" -> 1로 변경해줌
				if(menu == 1) {
					service.init();
				}else if(menu == 2) {
					service.input();
				}else if(menu == 3) {
					System.out.println("검색할 사원번호 입력 >>> ");
					int eId = Integer.parseInt(scn.nextLine());
					String name = service.search(eId);
					if(name == null) {
						System.out.println("찾는 사원정보가 없습니다.");
					} else {
						System.out.println("사원의 이름은 " + name);
					}
				}else if(menu == 4) {
					service.print();
				}else if(menu == 5) {
					//사번을 입력하면 급여정보를 반환
					System.out.println("검색할 사원번호 입력 >>> ");
					int eId = Integer.parseInt(scn.nextLine());
					int sal = service.searchSal(eId);
					if(sal == -1) {
						System.out.println("찾는 사원정보가 없습니다.");
					} else {
						System.out.println("사원의 급여는 " + sal);
					}
				}else if(menu == 9) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}else {
					System.out.println("잘못된 메뉴 선택입니다.");
				}
			}catch(NumberFormatException n1){ //문자를 입력했다면
				System.out.println("번호를 입력하세요.");
			}
		}
		System.out.println("프로그램 종료.");
	} //end of main()
} //end of class
