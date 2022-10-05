package co.edu.emp.list;

import java.util.ArrayList;

import co.edu.emp.Employee;

public class ListApp {
	public static void main(String[] args) {
		//배열은 크기가 한번 정해지면 변경불가. 그래서 변경가능한 컬렉션(ArrayList,HashSet, HashMap)을 사용.
//		String[] strAry = new String[10]; //보통 배열은 유형과 크기를 지정해주는데.
		//Object <- 모든클래스를 담겠다는 뜻. 
//		ArrayList list = new ArrayList(); // 따로 선언이 없으면 모든형태를 담을 수 있게 함.
		ArrayList<String> list = new ArrayList<String>(); //문자열만 담는 arraylist
		list.add("Hello");
		list.add("Employee");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i)); //list의 전체 값을 출력.
		}

//		System.out.println(list.get(0)); //list의 0번째 인덱스 값을 불러올게요.
		
		ArrayList<Integer> intList = new ArrayList<Integer>(); //정수형만 담는 arraylist
		intList.add(100);
//		intList.add("100"); //문자열이라 불가
		
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(100, "홍길동", 1000));
		empList.add(new Employee(200, "김민수", 2000));
		empList.add(new Employee(300, "박인기", 3000));
		empList.add(new Employee(400, "황석용", 4000));
//		empList.add(100); // 정수형이라 안됨
		
		String result = null;
		int salary = 0;
		for(int i=0; i<empList.size(); i++) {
			if(empList.get(i).getEmployeeId() == 200) {
				result = empList.get(i).getName();
				salary = empList.get(i).getSalary();
			}
		} System.out.println("이름은 " + result + "이고, 급여는 " + salary + "만원 입니다.");
		
	}
}
