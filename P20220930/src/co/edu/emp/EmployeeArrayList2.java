package co.edu.emp;

import java.util.ArrayList;
import java.util.Scanner;

//배열을 활용해서 정보를 저장.
public class EmployeeArrayList2 implements EmployeeService{
	// 저장공간 생성.
	ArrayList<Employee> list; // 필드는 설정 안해도 배열이니까 null
	int idx; //필드는 설정 안해도 0으로 설정
	Scanner scn = new Scanner(System.in);
	
	@Override
	public void init() {
		list = new ArrayList<Employee>(); // 크기는 이제 의미없다. 새로 객체 생성해서 공간만 만들어주자!
		System.out.println("초기화 완료.");
	}

	@Override
	public void input() {
		
		System.out.println("사번>>> ");
		int eId =-1;
		while(true) {
			try {
			eId = Integer.parseInt(scn.nextLine());
			break;
			} catch(NumberFormatException e) {
				System.out.println("사원번호를 입력");
				System.out.println("사번>>> ");
			}
		}
		
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
		list.add(emp); //list에 input 하나 넣고 그다음은 idx가 1 증가 되니까 그 다음 배열에 값이 들어간다.
		
	}

	@Override
	public String search(int employeeId) {
		//입력된 값중에서 찾도록. list[5] => idx값이 실제 입력되어진 크기어야함.
		// 사원번호 100, 200, 300
		String result = null;
		for(int i=0; i<idx; i++) {
			if(list.get(i).getEmployeeId() == employeeId) {
				result = list.get(i).getName();
				break;
			}
		}
		return result;
	}

	@Override
	public void print() {
		for(int i=0; i<idx; i++) { //배열동안만큼만 돌게된다.
			System.out.printf("%5d %10s %7d\n", 
					list.get(i).getEmployeeId(), //%5d
					list.get(i).getName(), //%10s
					list.get(i).getSalary()); //%7d d는 int, s는 문자열. 
		}
	}
	@Override
	public int searchSal(int employeeId) {
		int result = -1;
		for(int i=0; i<idx; i++) {
			if(list.get(i).getEmployeeId() == employeeId) {
				result = list.get(i).getSalary();
				break;
			}
		}
		return result;
	}

}
