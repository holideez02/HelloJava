package co.edu.nested;

import co.edu.nested.Person.Calculator;

class Person {
	//멤버로 선언되는 필드, 생성자, 메소드, 이너클래스!
	//필드.
	String name;
	int age;
	//생성자.
	Person(){};
	//메소드.
	void ShowInfo() {
		//로컬 클래스 : 메소드 안의 또다른 내부클래스. 메소드가 실행될때만 사용할 수 있다.
		class Local{
			
			void show() {
				System.out.println("show!");
			}
		}
		Local local = new Local();
		local.show();
	}
	//Inner(중첩, 내부클래스) 클래스 ( 인스턴스 멤버클래스) :person 객체를 만들어야 사용할 수 있는 car클래스
	class Car{
		String carName;
		
		void run() {
			System.out.println("run");
		}
	}
	
	//Inner 클래스(정적멤버 클래스): 인스턴스 없이 바로 사용할 수 있는 클래스!
	static class Calculator{
		void add() {
			System.out.println("add");
		}
	}
	
	class Run implements Runnable{
		@Override
		public void run() {
			System.out.println("run 구현.");
		}
	}
	
	//Inner 인터페이스.
	interface Runnable{
		void run();
	}
}

public class NestedExample {
	public static void main(String[] args) {
		Person p = new Person();
		
		// 인스턴스 멤버 클래스.
		Person.Car car = p.new Car(); //미리 person이라는 객체를 만들고 (p.) car라는 인스턴스를 만들기. (내부클래스 인스턴스)
		car.run();
		
		// 정적 멤버 클래스.
		Person.Calculator cal = new Person.Calculator(); //위에 미리 person이라는 객체 생성 안해도 괜찮음.
		cal.add();
		
		p.ShowInfo(); //로컬 클래스 호출.
	}
}
