package co.edu;

import java.util.Arrays;

public class Student { // Student 클래스는 외부 객체에 오픈되어 있음(public)  => Appmain(외부객체)에서 사용가능
	// 필드(속성)
	private String studNo;
	private String studName; //이름
	private String major; //전공
	// 외부 객체에서 접근하지 못하도록 숨길게요. (private)
	private int age; //정수값 23, 0, -12
	private String[] hobbies = new String[5]; //취미는 여러개일 수 있으니까 배열로 넣음. 크기 지정해주지 않으면 한번 set 했을때 
											  //그 값이 고정이 되버리니까 넉넉하게 설정
	// static이 붙어서 정적 메소드.
	public static void staticMethod() {
		System.out.println("staticMethod call.");
	}
	//생성자(필드의 값을 초기화 해주는 역할)
	//여기서는 선언하지않았지만 기본생성자가 자동으로 만들어졌음. 원래 밑과 같음.
	//메소드와 비슷하게 생겼지만 메소드는 무조건 반환타입이 있어아햐지만 생성자는 없음. 구분 잘하기
	//생성자의 오버로딩: 동일한 이름으로 생성자를 여러번 정의하지만 받는 매개변수는 차이가 나야한다.
	public Student() { 
		//매개값이 없는 생성자 => 기본생성자. 만약에 기본생성자 없이 밑에 생성자만 만들어지면 오브젝트 만들었을때 오류날 수 있음..
		this.studName = "기본값";
		this.studNo = "000-000";
	}
	public Student(String studNo, String studName) { //appmain2에 s4 확인해보기!
		this.studNo = studNo;
		this.studName = studName;
	}
	public Student(String studNo, String studName, String major) { // 매개값 3개 받는 생성자!
		this(studNo, studName); // 위에 매개변수 두개받는 기본생성자 호출하는 것!
		this.major = major;
	}
	
	
	//  메소드 시작 !
	// 취미 set, get
	void setHobbies(String[] hobbies) {
//		this.hobbies = hobbies;
		for(String hobby : hobbies) {
			for(int i=0; i<this.hobbies.length; i++) {
				if(this.hobbies[i] == null) {
					this.hobbies[i] = hobby;
					break;
				}
			}
		}
	}
	String[] getHobbies() {
		return this.hobbies;
	}
	String getHobb() {
		String str = "취미는 ";
		for(String hobby : hobbies) { //빙글빙글 돌면서
			if(hobby != null) { //hobby가 null이 아니면
			str += hobby + " "; //hobby 누적
			}
		}
		str +="입니다. ";
		return str;
	}
	// 취미 추가.
	void addHobby(String hobby) {
		for(int i=0; i<hobbies.length; i++) {
			if(hobbies[i] == null) {
				hobbies[i] = hobby;
				break;
			}
		}
	}
	
	//보통 메소드를 이용해서 값을 정의하도록 한다.
	// 설정은 set, 가지고 오는건 get.
	void setStudNo(String studNo) {
		this.studNo = studNo;
	}
	String getStudNo() {
		return this.studNo;
	}
	//학생이름 set, get
	void setStudName(String studName) {
		this.studName = studName;
	}
	String getStudName() {
		return this.studName;
	}
	//전공 set, get
	void setMajor(String major) {
		this.major = major;
	}
	String getMajor() {
		return this.major;
	}
	void setAge(int age) {
		if(age < 0) { //0보다 작은 수가 들어가면
			this.age = 0; //0으로 초기화 할게요.new 하고 인스턴스 생성했을때 그 인스턴스의 나이(값)을 0으로 설정
		} else{
			this.age = age;
		}
	}
	int getAge() {
		return this.age;
	}
	//showInfo(); : 이름, 학번, 전공정보를 반환해주는 메소드
	public String showInfo() {
		return "이름은 " +this.studName 
				+ "이고 학번은 " + this.studNo 
				+ "입니다. 전공은 " + this.major 
				+ " 입니다." ;
	}
	
	void study() {
		System.out.println(studName + "이 공부합니다.");
	}
	void game() {
		System.out.println(studName + "이 게임합니다.");
	}
	void sleep() {
		System.out.println(studName + "이 잠을 잡니다.");
	}
	@Override
	public String toString() {
		return "Student [studNo=" + studNo + ", studName=" + studName + ", major=" + major + ", age=" + age
				+ ", hobbies=" + Arrays.toString(hobbies) + "]";
	}
	
}


