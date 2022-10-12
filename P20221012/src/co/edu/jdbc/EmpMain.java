package co.edu.jdbc;

import java.util.List;
import java.util.Scanner;

public class EmpMain {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		Scanner scn = new Scanner(System.in);

		// 메뉴 => 1.사원등록(insert) 2.한건조회(GetEmp) 3.수정(Update) 4.삭제 5.목록조회 9.종료
		while (true) {
			System.out.println("1.사원등록 2.한건조회 3.수정 4.삭제 5.목록조회 6.일괄등록 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) { //사원등록
				System.out.println("사원 등록 페이지입니다.");
				System.out.println("사원번호 >>");
				int empId = Integer.parseInt(scn.nextLine());
				System.out.println("이름 >> ");
				String name = scn.nextLine();
				System.out.println("이메일 >> ");
				String email = scn.nextLine();
				System.out.println("입사일자 >> ");
				String hireDate = scn.nextLine();
				System.out.println("직무 >> ");
				String jobId = scn.nextLine();
				
				Employee emp1 = new Employee(empId, name, email, hireDate, jobId);
				dao.insert(emp1);
				
			} else if (menu == 2) { //한 건 조회
				System.out.println("조회할 사원번호 입력>> ");
				int empId = Integer.parseInt(scn.nextLine());
				
				System.out.println(dao.getEmp(empId));
				
			} else if (menu == 3) { // 수정
				System.out.println("수정할 사원 번호? >> ");
				int empId = Integer.parseInt(scn.nextLine());
				System.out.println("수정할 이름 >> ");
				String name = scn.nextLine();
				System.out.println("수정할 이메일 >> ");
				String email = scn.nextLine();
				System.out.println("수정할 입사일자 >> ");
				String hireDate = scn.nextLine();
				System.out.println("수정할 직무 >> ");
				String jobId = scn.nextLine();
				
				Employee emp2 = new Employee(empId, name, email, hireDate, jobId);
				dao.update(emp2);
				
			} else if (menu == 4) { //삭제
				System.out.println("삭제할 사원번호 입력>>");
				int empId = Integer.parseInt(scn.nextLine());
				
				if(dao.delete(empId)) {
					System.out.println("정상 삭제 되었습니다.");
				} else {
					System.out.println("삭제할 데이터 없습니다!");
				}
			} else if (menu == 5) { //목록조회
				System.out.println("목록을 조회합니다.");
				List<Employee> employees = dao.search();
				
				for(Employee emp : employees) {
					System.out.println(emp);
				}
			} else if(menu == 6) {
				System.out.println("일괄등록 진행");
				
			}
			else if (menu == 9) {
				System.out.println("종료.");
				break;
			} else {
				System.out.println("잘못된 메뉴입니다.");
			}
		}
		scn.close();
		System.out.println("프로그램 종료");

	}
}
