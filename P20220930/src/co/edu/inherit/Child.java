package co.edu.inherit;

public class Child extends Parent { //부모 클래스를 상속하는 Child클래스.
	String field1;
	Child(){
		super("args"); //부모클래스의 생성자 호출. 보통 자동으로 되서 안쓸때도 있지만 부모클래스에 매개변수를 받아오는 생성자가 있다면 반드시 써주는 편이 좋아요 
		System.out.println("Child() call."); // Child 생성자 호출.
	}
	void method1() {
		System.out.println("method1() call."); // 메소드1 호출. 
	}
	//부모클래스의 메소드를 재정의. overriding (오버라이딩). 그대로 물려받을 수도 있지만 바꿀수도 있는 것
	//부모클래스가 가지고 있는 메소드에서 리턴타입, 메소드이름, 매개변수 타입이 그대로 같아야 오버라이딩. 다르면 그냥 오버로딩
	@Override	//어노테이션: 부모클래스의 메소드(반환값, 메소드의 이름, 매개값)를 자식클래스에서 오버라이딩 할게요~ 하고 규칙 알려주는것
	void method() { // 이미 부모클래스에 정해져있는 메소드지만 새롭게 정의해서 바꿀 수 있음! 입맛대로 ^_^
		System.out.println("이거 Child method() call.");
	}
	@Override
	public String toString() {
		return "Child [field1=" + field1 + "]";
	}
	
	
}
