package myProject;

public class Swim {
	private int userNo; // 회원번호
	private String name; // 회원이름
	private String sex; // 성별
	private String birth; //생년월일
	private String phoneNum; // 폰번호
	private String email; // 메일
	private String address; // 주소
	private String course; // 강좌
	private int money; // 수강료
	private String date; // 등록일자
	private String tName; //등록한 강좌의 강사이름

	public Swim() {};
	public Swim(int userNo, String name, String sex, String birth, String phoneNum, String email, String address, String course,
			int money, String date, String tName) {
		super();
		this.userNo = userNo;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
		this.course = course;
		this.money = money;
		this.date = date;
		this.tName = tName;
	}

	
	public Swim(int userNo, String name, String sex, String birth, String phoneNum, String course) {
		super();
		this.userNo = userNo;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.phoneNum = phoneNum;
		this.course = course;
	}
	
	

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}

	@Override
	public String toString() { // 상세조회
		return "회원번호 : " + userNo + ", 이름: " + name + ", 성별: " + sex + ", 생년월일: " + birth + ", 연락처: " + phoneNum + ", 이메일: " + email
				+ ", 주소: " + address + ", 강좌명: " + course + ", 수강료: " + money + ", 수강등록일: " + date + ", 강사명: " + tName;
	}

	public String showInfo() { // 목록 조회
		return "회원번호 : " + userNo + ", 이름: " + name + ", 성별: " + sex + ", 연락처: " + phoneNum + ", 강좌명: " + course;
	}
	

}
