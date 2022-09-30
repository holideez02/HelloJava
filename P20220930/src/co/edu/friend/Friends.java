package co.edu.friend;

public class Friends {
	private String name; //이름
	private int number; //번호
	private String school; //학교
	private String memo; //메모
	
	public Friends() {}

	public Friends(String name, int number, String school, String memo) {
		super();
		this.name = name;
		this.number = number;
		this.school = school;
		this.memo = memo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	};
	
	
}
