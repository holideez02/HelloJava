package co.edu.emp;

import java.util.Scanner;

//배열을 활용해서 정보를 저장.
public class EmployeeArray implements EmployeeService{
	// 저장공간 생성.
	Employee[] list; // 필드는 설정 안해도 배열이니까 null
	int idx; //필드는 설정 안해도 0으로 설정
	Scanner scn = new Scanner(System.in);
	
	@Override
	public void init() {
		System.out.println("사원수 입력>> ");
		int cnt = Integer.parseInt(scn.nextLine());
		list = new Employee[cnt]; // employee에다가 입력받은 값대로 몇명 담도록 할게요~ ex.5개 인스턴스를 저장할 수 있는 공간!  
	}

	@Override
	public void input() {
		
		if(idx >= list.length) { //배열보다 인덱스가 더욱 커진다면 실행 불가
			System.out.println("더 이상 입력 불가.");
			return; //메소드 종료.
		}
		System.out.println("사번>>> ");
		int eId = Integer.parseInt(scn.nextLine());
		System.out.println("이름>>> ");
		String name = scn.nextLine();
		System.out.println("부서>>> ");
		int deptId = Integer.parseInt(scn.nextLine());
		System.out.println("급여>>> ");
		int sal = Integer.parseInt(scn.nextLine());
		System.out.println("이메일>>> ");
		String email= scn.nextLine();
	
		Employee emp = new Employee(eId, name, sal, deptId, email);
		//list라는 배열 변수에 이제 담을거야
		list[idx++] = emp; //list에 input 하나 넣고 그다음은 idx가 1 증가 되니까 그 다음 배열에 값이 들어간다.
		
	}

	@Override
	public String search(int employeeId) {
		return null;
	}

	@Override
	public void print() {
		for(int i=0; i<idx; i++) { //배열동안만큼만 돌게된다.
			System.out.printf("%5d %10s %7d\n", 
					list[i].getEmployeeId(), //%5d
					list[i].getName(), //%10s
					list[i].getSalary()); //%7d d는 int, s는 문자열. 
		}
	}

}
