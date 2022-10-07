package co.edu.collect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Employee {
	int empId;
	String name;
	int salary;

	public Employee(int empId, String name, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;

	}

	// 동일한 객체:
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			Employee target = (Employee) obj; // 가지고온 obj를 casting 하겠습니다. target의 id값이랑 같아야해요.

			return (this.empId == target.empId // 아이디도 같고
					&& this.name.equals(target.name) // 이름도 같고
					&& this.salary == target.salary); // 급여도 같아야 해요
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return empId;
	}
}

public class SetExample {
	public static void main(String[] args) {
		Set<Employee> employees = new HashSet<Employee>(); // employee인스턴스만 set에 담을게요
		employees.add(new Employee(100, "홍길동", 1000)); // 인덱스 값이 아니다. 순서도 아니고!
		employees.add(new Employee(200, "박유식", 2000));
		employees.add(new Employee(300, "최윤기", 3000));
		employees.add(new Employee(100, "김길동", 4000)); // 중복된값이라 사이즈는 3일줄 ㅇ라았는데 4가 나왔다?? equals랑 hashcode오버라이딩해서 설정해주기
		// 사원번호가 같으면 동일한 객체라고 표현하게 했으니까 이제 3이 뜸.
		// 다시 사원번호, 이름, 급여까지 같아야 같은 객체라고 설정했으니 또 다르게 뜸.

		employees.remove(new Employee(100, "박길동", 5000)); // 사원번호가 같으면 다 같다 했으니... 홍길동도 사라지지. 근데 이제 이 객체는 없다.
		employees.remove(new Employee(100, "김길동", 4000));

		System.out.println(employees.size());

		Iterator<Employee> iter = employees.iterator(); // 반복자를 통해 요소를 하나씩 호출
		while (iter.hasNext()) {
			Employee emp = iter.next(); // 객체의 요소 한 건 가지고 와서 출력함
			System.out.printf("사번은 %d, 이름은 %s, 급여는 %d\n", emp.empId, emp.name, emp.salary);
		}

		Set<Integer> set = new HashSet<Integer>();
		
		//중복허용 하지 않는 hashSet
		while (set.size() <7) {
			set.add((int) (Math.random() * 45) + 1); //
		}
		for(int n: set) {
			System.out.println(n);
		}
		// 중복저장 불가.
//		int[] lotto = new int[7];
//		for(int i=0; i<lotto.length; i++) {
//			int temp = (int) (Math.random() * 7)+ 1; //1부터 시작해야 하니까 +1
//			//현재 인덱스 값보다 적은 위치에 temp와 같은 값이 있는지 체크.
//			boolean exists = false;
//			for(int j = 0; j<i; j++) {
//				//같은 값이 있으면 이전으로 돌아가게끔 (continue);
//				if(lotto[j]==temp) {
//					i--;
//					exists = true;
//				}
//			}
//			//continue;
//			if(exists)
//				continue;
//			lotto[i] = temp;
//		}
//		for(int n : lotto) {
//			System.out.printf("%d ",n);
//		}
	}
}
