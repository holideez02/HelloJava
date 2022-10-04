package co.edu.inherit;

public class MainApp {
	public static void main(String[] args) {
		Child child = new Child(); //field1, method1()이 있음
		child.method(); //Parent가 가지고 있던 메소드
		child.method1(); //child의 메소드.
		//실행하면 생성자도 둘다 호출, 메서드도 둘다 호출. (상속관계니까). 부모에서 어떤것이 변경되면 자식들한테도 그대로 적용됨
		
		Child2 child2 = new Child2();
		child2.method(); // parent에게 상속받지 않아서 부모가 없음. 상속 추가해주면 가능!
		child2.method2(); // Child2의 메소드.
		
		Parent c1 = new Parent(); // 왼쪽 오른쪽 타입이 항상 같아야 한다. 그래서 가능!
		c1 = new Child(); // 부모클래스의 변수에 자식 인스턴스 대입이 가능.
		c1 = new Child2(); // 부모클래스의 참조변수에다가 자식 클래스 인스턴스 대입이 가능. 자동 형변환이 됨.(자식클래스의 인스턴스 -> 부모클래스의 인스턴스)
		
//		c1.method2(); //호출 불가! 부모가 가지고 있는 멤버들만 호출이 가능. c1에서 child2를 담았더라도 ㅠㅠ 
		
		if(c1 instanceof Child2) {
			Child2 c2 = (Child2) c1; // instanceof(c1이라는 참조변수가 child2의 인스턴스면 true) 을 사용해서 강제형변환(casting)
			c2.method2(); // 이러면 본인것도 호출 가능!
		}
		
		Parent c3 = new Parent(); // parent클래스의 인스턴스 생성해서 c3에다가 담고
		if(c3 instanceof Child2) { //상속의 관계에 있긴 하지만 인스턴스로 바꿀 수 있는지 체크.
			Child2 c4 = (Child2) c3; //casting c3이 자식클래스의 인스턴스로 형변환을 해볼게
			c4.method2(); //문법상으로는 오류가 없지만 에러가 뜸. 	
		} // 그래서 활용할 수 있는 부분만 뜸..
		
	}
}
