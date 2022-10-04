package co.edu.inherit.friend;

public abstract class Animal { //Animal 클래스는 new라고 새로 인스턴스를 생성할 수 없다
	private String kind;
	public Animal() {
		
	}
	public Animal(String kind) { // 생성자도 선언은 가능하지만 상속받는 하위클래스에서..?
		this.kind =kind;
	}
	public void move() {
		System.out.println("움직입니다.");
	}
	public abstract void eat(); //추상 메소드: 자식클래스에서 반드시 구현해야함! 여기서는 정의를 안해줌! 그래서 지금 {}을 안씀 
	public abstract void speak(); 
	
}
