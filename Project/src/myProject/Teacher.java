package myProject;

public class Teacher {
	private int tNo; // 강사번호
	private String name; //강사 이름
	private String id; //강사 직책
	private String course; // 강사가 맡고있는 강좌
	private String hireDate; //입사일
	private String phone; //강사 연락처
	private String licence; // 자격증
	
	public Teacher() {};
	public Teacher(int tNo, String name, String id, String course, String hireDate, String phone) {
		super();
		this.tNo = tNo;
		this.name = name;
		this.id = id;
		this.course = course;
		this.hireDate = hireDate;
		this.phone = phone;
	}
	
	public int gettNo() {
		return tNo;
	}
	public void settNo(int tNo) {
		this.tNo = tNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
	@Override
	public String toString() { //강사 목록조회
		return "강사번호: " + tNo + ", 강사이름: " + name + ", 직책: " + id  + ", 진행중인 강좌: " + course;
	}
	
	public String showInfo() { // 강사 상세조회
		return "강사번호: " + tNo + ", 강사이름: " + name + ", 직책: " + id + ", 연락처: " + phone + ", 진행중인 강좌: " + course + ", 입사일:"
				+ hireDate + ", 자격증: " +licence;
	}
	
}
