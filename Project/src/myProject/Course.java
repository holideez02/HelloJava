package myProject;

public class Course {
	private String course; // 강좌
	private String money; // 수강료
	private String teacher; // 강사
	
	public Course() {}

	public Course(String course, String money, String teacher) {
		super();
		this.course = course;
		this.money = money;
		this.teacher = teacher;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "강좌 [강좌명=" + course + ", 수강료=" + money + ", 강사명=" + teacher + "]";
	};
	
	
}
