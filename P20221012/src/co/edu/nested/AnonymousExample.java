package co.edu.nested;

class People{
	int height;
	int weight;
	
	void showInfo() {
		System.out.println("showInfo.");
	}
}

class Student extends People{
	int studNo;
	
}
public class AnonymousExample {
	public static void main(String[] args) {
		//익명 상속 클래스. 자주 쓰지 않을거라서 클래스를 따로 선언 안할때! 
		People people = new People() {  //people이라는 클래스를 상속받는 익명의 클래스 선언
			
			String color;
			
			@Override
			void showInfo() {
				System.out.println("익명 showInfo.");
				showColor();
			}
			
			void showColor() {
				System.out.println(this.color);
			}
		};
		people.showInfo();
	}
}
