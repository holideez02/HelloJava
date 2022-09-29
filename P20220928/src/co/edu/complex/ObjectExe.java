package co.edu.complex;

import java.util.Scanner;

public class ObjectExe {
	public static void main(String[] args) {
		
		String s1 = "홍길동";
		int i1 = 10;
		double h1 = 162; //double로 선언되어도 162.0으로 자동형변환(promotion)
		
		Person p1 = new Person(); // 인스턴스 생성. 비어있는 공간을 만든 후 거기에 채워놓는 것
		p1.name = "김민기";
		p1.age = 22;
		p1.height = 172.3;
//		System.out.println(p1); //주소값만 반환된다
		
		Person p2 = new Person(); //인스턴스 생성
		p2.name = "김경미";
		p2.age = 23;
		p2.height = 163.2;
		
		Person p3 = new Person(); // 인스턴스 생성. 
		p3.name = "주소영";
		p3.age = 22;
		p3.height = 172.3;
//		System.out.println(p3); //주소값만 반환된다. 참조형이라
		
//		System.out.println(p1 == p3); // p1과 p3가 값은 같아도 주소가 다르기 때문에 false 
		System.out.println("이름: " +p1.name);
		System.out.println("나이: " +p1.age);
		System.out.println("키: " +p1.height);
		
		Person[] persons = {p1, p2, p3};
		System.out.println(persons[1].name);
		System.out.println(persons[1].age);
		System.out.println(persons[1].height);
		
//		persons[2].name ="송지은"; // 원래 주소영이었던 이름을 송지은으로 변경
//		p3.name = "송지은"; //위와 같음 
		
		//p1변수값과 persons[0]값 비교 
		System.out.println(persons[0] == p1); //true
		
		//김경미 이름을 찾아서 나이를 22살로 변경
		//문자열을 비교할때는 ==가 될때도 있고 안될때도 있으니 equals를 사용할 수 있게끔. 
		for(int i=0; i<persons.length; i++) {
			if(persons[i].name.equals("김경미")){	
				persons[i].age = 22;
				System.out.println(persons[i].age);
			}
		}
		//
//		String kim = "김경미"; //문자열리터럴, 코드 안에 직접 고정된 값을 넣는것.
//		System.out.println(kim == persons[1].name); //p1.~ 하면 주소값이 아니라 실제 값. 문자열을 담고있는 속성.
		
		Scanner scn = new Scanner(System.in);
		System.out.println("변경할 이름 >>> ");
		String name = scn.nextLine();
		System.out.println("변경할 나이 >>> ");
		int age = scn.nextInt();
		for(int i=0; i<persons.length; i++) {
			if(name.equals(persons[i].name)) {
				persons[i].age = age;
				System.out.println(name+"의 변경된 나이는"+age);
			}
		}
		
		//전체 목록 출력
		for(int i=0; i<persons.length; i++) {
			System.out.println(i + 1 + "번째 이름: " + persons[i].name + ", 나이: " + persons[i].age);
		}
		
//		String n1 = new String("홍길동"); //n1과 n2은 주소값을 가지고 있음.
//		String n2 = new String("홍길동");
//		String m1 = "홍길동";
//		String m2 = "홍길동";
//		System.out.println(n1 == n2); // 값이 같아도 주소값이 다르기 때문에 false
//		System.out.println(m1 == m2); // 같은 문자열을 선언하면 m2에 m1의 주소값이 복사가 되어서 true로 나옴
		
	}
}
