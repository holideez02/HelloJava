package co.edu.inherit;

public class Parent{ //모든 클래스의 제일 상위에는 Object. Object에서 상속이 쭉쭉 내려오는것. 굳이 안써도됨
	String field;
	Parent() {
		System.out.println("Parent() call."); 
	}; //기본생성자를 만들어줘야함
	Parent(String args){ //안에 매개변수를 받는 생성자
		System.out.println("Parent(String args) call."); //생성자 호출입니다.
	}
	void method() {
		System.out.println("parent method() call."); //메서드 호출입니다.
	}
	@Override
	public String toString() { //toString()도 object에게서 상속되어짐
		return "Parent [field=" + field + "]";
	}
	
	
}
