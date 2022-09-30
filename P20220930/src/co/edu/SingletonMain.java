package co.edu;

public class SingletonMain {
	public static void main(String[] args) {
		//1) Student : 인스턴스 생성할 때 마다 다른 주소값에 생성됨.
		Student s1 = new Student(); 
		Student s2 = new Student();
		
		//2) Singleton : 인스턴스가 클래스에 할당되어 있어서 동일한 인스턴스가 만들어짐. 
//		Singleton sg1 = new Singleton(); // 불가.
		Singleton sg1 = Singleton.getInstace();
		Singleton sg2 = Singleton.getInstace();
		
		System.out.println(s1 == s2); //false
		System.out.println(sg1 == sg2); //true
	}
}
