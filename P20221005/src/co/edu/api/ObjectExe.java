package co.edu.api;

import java.util.HashSet;
import java.util.Set;

class Student { // extend가 따로 없어도 object를 상속받음. 그래서 equals도 쓸 수 있는 것!
	String name;
	int age;
	
	//Set 컬렉션: 동일한 인스턴스는 담아주지 않는 함수같은 역할을 하는 컬렉션.
	@Override
		public int hashCode() { //주소값이나 객체가 가지고 있는 독특한 값을 16진수로 나타냄. 동일한 객체면 동일한 값을 리턴함
			return age;
		}
	
	@Override
		public String toString() {
			return "학생의 이름은 "+name + ", 나이는 " + age +"입니다.";
		}
	

	@Override // extends의 equals를 오버라이드.
	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) {
			return false;
		}Student str = (Student) obj;
//		return super.equals(obj);
			if (this.name.equals(str.name) && this.age == str.age)
				return true;
			return false;

	}
}

// 모든 클래스의 최상위 Object.
public class ObjectExe {

	public static void main(String[] args) {
		Object obj = new Object();
		Object obj2 = new Object();

//		System.out.println(obj.equals(obj2)); // obj == obj2 주소값을 비교. false

		Student s1 = new Student();
		s1.name = "Hong";
		s1.age = 10;
		Student s2 = new Student();
		s2.name = "Hong";
		s2.age = 10;
		String s3 = "Hong"; //형변환도 안되기때문에 에러.

//		System.out.println(s1.equals(s2)); // 이름과 나이가 같아야 true
//		System.out.println(s1.equals(s3)); // error. s3이 문자열인데 오브젝트 매개값으로 받는데다가 들어가니까 오류.
		System.out.println(s1.toString()); //s1만넣으면 주소값. toString 써서 재정의 해줘야함
		System.out.println(s1.hashCode()); //hashcode를 뭘로 정의하냐에따라서 결과값이 달라짐.
		System.out.println(s2.hashCode());
		
		//Set 컬렉션: 인터페이스 -> 구현클래스 통해서 인스턴스 생성가능.
		Set<Integer> set = new HashSet<Integer>(); //set에는 정수만 담을 수 있음. 데이터를 중복 저장할 수 없고 순서를 보장하지 않는다
		set.add(new Integer(100));
		set.add(new Integer(110));
		set.add(new Integer(100));
		
		System.out.println("컬렉션의 크기: " + set.size()); //100이 두개 담겨도 중복된 값은 받지 않기 때문에 2로 출력.
		
		//Set 컬렉션에 Student 인스턴스 저장시 논리적으로 동일한 인스턴스 판단하는 근거?
		// hashCode(), equals()의 반환값이 동일하면 인스턴스가 동일하다고 판단함!
		Set<Student> students = new HashSet<Student>();
		students.add(s1);
		students.add(s2);
		
		System.out.println("컬렉션의 크기: " + students.size()); //s1과 s2가 동일한 값이라서 하나로 인식. hashcode와 equals의 반환타입이 같으면 같은 인스턴스라고 인식.
	}
}
