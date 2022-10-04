package co.edu.inherit.friend;

public class AnimalMain {
	public static void main(String[] args) {
//		Animal animal = new Animal(); // 추상클래스는 인스턴스 생성 불가.
		Animal cat = new Cat(); //cat클래스는 animal을 상속받았기 때문에 객체 생성 가능
		Animal dog = new Dog(); 
		
		cat.speak();
		dog.speak();
		//어떤 인스턴스에 담겨있는 speak메소드냐에따라 결과는 달라짐
	}
}
