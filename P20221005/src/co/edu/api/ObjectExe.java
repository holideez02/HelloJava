package co.edu.api;

class Student { // 따로 없어도 object를 상속받음. 그래서 equals도 쓸 수 있는 것!
	String name;
	int age;
	
	@Override
		public boolean equals(Object obj) {
			
			return super.equals(obj);
		}
}
public class ObjectExe {
	public static void main(String[] args) {
		Object obj = new Object();
		Object obj2 = new Object();
		
		System.out.println(obj.equals(obj2)); // obj == obj2 주소값을 비교. false
		
		Student s1 = new Student();
		Student s2 = new Student();
		
		System.out.println(s1.equals(s2)); //똑같이 false.
	}
}
