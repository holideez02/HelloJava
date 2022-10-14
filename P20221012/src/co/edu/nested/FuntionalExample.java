package co.edu.nested;

import java.util.List;
import java.util.function.Consumer;

import co.edu.jdbc.Employee;
import co.edu.jdbc.EmployeeDAO;

public class FuntionalExample {
	public static void main(String[] args) {

		// 원래 매개값은 값을 가지고있는 녀석들이었는데, 기능도 매개값으로 받을 수 있다.
		// 매개값만 있고 리턴값이 없는 추상메소드 = consumer 함수적 인터페이스.
		// 매개값은 없고 리턴값만 있는 추상 메소드 = supplier 함수적 인터페이스
		// 매개값과 리턴값이 모두 있는 추상메소드 = function함수적 인터페이스. 매개값을 리턴값으로 타입변환할 경우 사용
		// 매개값을 연산하고 그 결과를 리턴할경우 사용. operator
		// 매개값 조사해 true / false를 리턴할때 사용 predicate함수적 인터페이스

		// accept를 구현해줘야함.
		Consumer<String> consumer = (String t) -> {
			System.out.println(t + "는 흥미롭습니다.");
		};
		consumer.accept("자바");

		// 함수적 프로그래밍 -> 데이터 처리할때 많이 사용.
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> list = dao.search();

		// 시냇물이 흘러가는 것 처럼 데이터가 흘러가는. list에 담겨진 데이터를 하나씩 흘려보냄.(데이터의 흐름)
		list.stream().forEach((t) -> System.out.println(t.toString())); //종료는 foreach 끝에다가.
	}
}
