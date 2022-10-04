package co.edu.friend;

public class Friends {
	private String name; //이름
	private int shortNo;
	private String number; //번호
	private String memo; //메모
	
	public Friends() {}

	public Friends(String name, int shortNo, String number, String memo) {
		super();
		this.number = number;
		this.shortNo = shortNo;
		this.name = name;
		this.memo = memo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getShortNo() {
		return shortNo;
	}

	public void setShortNo(int shortNo) {
		this.shortNo = shortNo;
	}
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}


	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "Friends [이름=" + name + ", 단축번호=" + shortNo + ", 연락처=" + number + ", 메모=" + memo + "]";
	}

	

	
	
	
}
