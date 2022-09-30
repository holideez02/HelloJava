package co.edu;

// 하나의 실행클래스와 여러개의 라이브러리 클래스가 필요함.
public class AppMain {
	public static void main(String[] args) {
		// Object -> Class -> Instance
		Person kim = new Person(); // new 클래스이름(); :: 인스턴스 생성.
		kim.name = "김민기";
		kim.age = 20;
		kim.sleep();
		kim.eat("사과");
		
		// 새로운 인스턴스(복제본) 생성도 가능!
		Person lee = new Person();
		lee.name = "이순신";
		lee.age = 25;
		lee.sleep();
		lee.eat("피자");
		
		Student stud1 = new Student();
//		stud1.studName = "주소영"; //다른 클래스에서 private로 숨겨서 접근 불가
		stud1.setStudName("주소영"); //이름설정 메소드 불러와서 설정
//		stud1.studNo = "1234";
		stud1.setStudNo("123-123"); //매개값으로 들어가야 함
//		stud1.major = "컴퓨터공학";
		stud1.setMajor("컴퓨터공학");

		
		Student stud2 = new Student();
//		stud2.studName = "김땡땡";
		stud2.setStudName("김땡땡");
//		stud2.studNo = "1111";
		stud2.setStudNo("123-222");
//		stud2.major = "컴퓨터공학";
		stud2.setMajor("컴퓨터공학");

		
		Student stud3 = new Student();
		//아무것도 안정해주면 값을 불러왔을때 int는 0, string은 null로 출력
		
		Student[] students;
		students = new Student[] {stud1, stud2, stud3};
		for(Student stud : students) { //배열에 있는 요소만큼 빙글빙글 돌아요
			System.out.println("학번: " + stud.getStudNo() + ", 학생이름: " + stud.getStudName());
		}
//		System.out.println(kim); // 이 위치에 만들어졌습니다~ 주소값 반환
		
		// 상속.
		WorkMan wman = new WorkMan();
		wman.name = "직장인"; //WorkMan에 직접 name이라는 속성을 써주진 않았지만 person에서 상속받아 같이 사용가능.
		wman.age = 30; //부모가 가지고 있는 기능을 그대로 물려받았음! 자식은 추가적으로 필요한것만 더 써주면 된다.
		
		StudMan sman = new StudMan();
		sman.school = "고등학교";
		sman.height = 164.3;
	}
}
