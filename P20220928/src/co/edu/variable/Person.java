package co.edu.variable;

// 추상화: 사람이라고 하는 오브젝트의 값을 필요한만큼만 생성해서 사용
public class Person {
	//속성 => 필드. 값을 담기위함
	String name;
	int age;
	double height;
	
	//기능=> 메소드. 
	void laugh() {
		System.out.println("웃는다.");
	}
	void sleep() {
		System.out.println("잠을 잡니다.");
	}
}
