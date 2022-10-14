package co.edu.nested;

//익명 구현 객체
//추상메소드 하나만 존재하는 인터페이스 => Functional 인터페이스
interface MyInterface {
	void run(); // 매개값, 반환값 모두 없음.
}

interface MyInterface2 {
	void run(String kind); // 매개값 있음.
}

interface MyInterface3 {
	int sum(int num1, int num2); // 이번에는 반환되는 타입이 int, 매개값도 두개!
}

public class AnonymousExample3 {
	public static void main(String[] args) {
		// 인터페이스를 구현하는 익명의 객체를 만들겠음.
		// () 매개값을 받아서 {}을 구현할게요. {}도 하나면 괄호 안써줘도 된다. 실행할 구문이 두개면 {}넣구!
		// 람다표현식. 표현을 간단하게 만들고 싶을때!
		MyInterface intf = () -> System.out.println("MyInterface Run.");
		intf.run();

		// 익명구현객체 run 반드시 구현!
		// 매개변수가 하나면 데이터 타입도, ()도 없애도됨!
		MyInterface2 intf2 = kind -> System.out.println(kind + " Run.");
		intf2.run("농구종목");

		// 데이터타입이 둘다 int니까 int생략 가능
		// 반환되는 값이 return 뒤에 있을때 return 생략가능
		MyInterface3 intf3 = (num1, num2) -> num1 * 2 + num2;
		int result = intf3.sum(10, 20); // 반환되는 값이 있으니 결과값을 담아줌.

		// 또다른 기능을 가진 익명 객체를 만들어 주고 싶다.
		intf3 = (num1, num2) -> num1 * 2 + num2 * 3;
		result = intf3.sum(11, 22);
	}
}
