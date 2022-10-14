package co.dev;

public class Student {
	private int studNo;
	private String studName;
	private int score; //private으로 선언됐기 때문에 메소드를 통해 불러와야함 (getter, setter)
	
	Student(int studNo, String studName, int score){ // 이 생성자를 통해 값을 담겠습니다
		this.studNo = studNo;
		this.studName = studName;
		this.score = score;
	}
	
	public void setStudNo(int studNo) {
		this.studNo =  studNo;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getStudNo() { //반환되는 타입은 int. 리턴값을 설정해주기
		return studNo;
	}
	public String getStudName() {
		return studName;
	}
	public int getScore() {
		return score;
	}
}
