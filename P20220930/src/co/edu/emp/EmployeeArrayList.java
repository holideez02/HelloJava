package co.edu.emp;

import java.util.ArrayList;
import java.util.Scanner;

//컬렉션(ArrayList)을 활용해서 데이터 저장.
public class EmployeeArrayList implements EmployeeService{
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
		
		//사번 입력 & 예외처리
		int eId = readInt("사번 >> ");
		
		System.out.println("이름>>> "); //어차피 문자니까 안해줘도 된다
		String name = scn.nextLine();
		
		//부서입력 & 예외처리(10,20,30 이외 부서는 부적절)
		int deptId = -1;
		while (true) {
			deptId = readInt("부서 >> "); //예외처리. 숫자값은 들어와도 원래부서값이 아니라면 예외처리도 발생해줘야지
			try {
				validDept(deptId);
				break;
			} catch (InvalidDeptException e1) { //잘못된 부서정보일때
				System.out.println(e1.getMessage()); //validDept에서 에러가 발생했으니까 예외처리
			}
		}
		
		//급여입력 & 예외처리.
		int sal = readInt("급여 >> ");
		
		System.out.println("이메일>>> ");
		String email= scn.nextLine();
	
		Employee emp = new Employee(eId, name, sal, deptId);
		//list라는 배열 변수에 이제 담을거야
		list.add(emp);
	}

	@Override
	public String search(int employeeId) {
		String result = null;
//		for(int i=0; i<list.size(); i++) {
////			Employee emp = list.get(i); //list.get(i)대신 emp로 바꿔서 하면 좀..더..보기쉽나..?
//			if(list.get(i).getEmployeeId() == employeeId) {
//				result = list.get(i).getName();
//				break;
//			}
//		}
		for(Employee emp : list) {
			if(emp.getEmployeeId() == employeeId) {
				result = emp.getName();
				break;
			}
		}
		return result;
	}

	@Override
	public void print() {
		System.out.printf("%5s %10s %7s\n",
				"사원번호",
				"이름  ",
				"급여  ");
		System.out.println("==========================");
		for(int i=0; i<list.size(); i++) { //배열동안만큼만 돌게된다.
			System.out.printf("%5d %10s %7d\n", 
					list.get(i).getEmployeeId(), //%5d
					list.get(i).getName(), //%10s
					list.get(i).getSalary()); //%7d d는 int, s는 문자열. 
		}
	}

	@Override
	public int searchSal(int employeeId) {
		int result = -1;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getEmployeeId() == employeeId) {
				result = list.get(i).getSalary();
				break;
			}
		}
		return result;
	}
	
	public void validDept(int dept) throws InvalidDeptException {
		int validDept = dept % 10;
		if(validDept != 0 || dept >30 ) {
			throw new InvalidDeptException("잘못된 부서정보입니다.");
		}
	}
	
	public int readInt(String msg) { //정수 읽는 메서드
		int result = -1;
		while(true) {
			System.out.println(msg);
			try {
				result = Integer.parseInt(scn.nextLine()); //값 입력하고 변경가능한 숫자들 넣어주면 
				break;
			} catch(NumberFormatException e) { //정상적인 숫자가 들어오지 않으면
				System.out.println("숫자를 입력하세요.");
			}
		}
		return result;
	}

}
