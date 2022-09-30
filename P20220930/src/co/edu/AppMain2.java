package co.edu;

public class AppMain2 { //public 이라서 다른 객체에서도 클래스나 메소드 사용가능함
	public static void main(String[] args) {
		
		Student.staticMethod(); //인스턴스를 안만들어도 메모리상에 준비되서 쓸 수 있음. 클래스이름.메소드이름() 의 형식.
		
		Math.random();
		Math.round(.5); //둘다 정적 메소드
		
		
		Student s1 = new Student(); //하나의 학생인스턴스를 생성해서 s1에 저장
//		s1.staticMethod(); //error 아닌데 warning.
		
		//인스턴스에 값 넣어줄때 private으로 설정되어있었으니 메서드를 불러와서 사용
		s1.setStudNo("111-111");
		s1.setStudName("홍길동");
		s1.setMajor("컴퓨터공학");
		s1.setAge(20);
		
		System.out.println(s1.getStudNo()); // 값을 넣지 않으면 초기값(null> 산출)
		System.out.println(s1.getAge()); // int의 초기값은 0;
		System.out.println(s1.showInfo());
		
		System.out.println("여기 =>>> "+ s1); //주소값만 리턴

		Student s2 = new Student();
		s2.setStudName("김민숙");
		s2.setStudNo("111-222");
		s2.setMajor("역사학과");
		System.out.println(s2.showInfo());
		
		String[] hob = {"독서", "자전거"};
		s1.setHobbies(hob);
		s1.addHobby("음악듣기");
		System.out.println(s1.getHobb());
		
		String[] hob2 = {"음악"};
		s2.setHobbies(hob2);
		s2.addHobby("유튜브보기");
		System.out.println(s2.getHobb());
		
		Student s3 = new Student(); 
		System.out.println(s3.getStudName()); //기본 생성자 안에 기본값이라고 초기화 해주어서 null이 아니고 기본값으로 뜬다!
		
		Student s4 = new Student("111-234", "주소영");
		System.out.println(s4.showInfo());
		
		Student s5 = new Student("222-222", "송지은", "역사학과");
		System.out.println(s5.showInfo());
	}
}
