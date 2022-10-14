package co.test;

// 학생번호, 이름, 나이, 영어, 수학
public class Student {
	private int studNo;
	private String studName;
	private int studAge;
	private int engScore;
	private int mathScore;
	private int sumScore;

	public Student(int studNo, String studName, int studAge, int engScore, int mathScore, int sumScore) {
		super();
		this.studNo = studNo;
		this.studName = studName;
		this.studAge = studAge;
		this.engScore = engScore;
		this.mathScore = mathScore;
		this.sumScore = sumScore;
	}

	public int getStudNo() {
		return studNo;
	}

	public void setStudNo(int studNo) {
		this.studNo = studNo;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getStudAge() {
		return studAge;
	}

	public void setStudAge(int studAge) {
		this.studAge = studAge;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	public int getSumScore() {
		return sumScore;
	}

	public void setSumScore(int mathScore) {
		this.sumScore = (this.engScore + this.mathScore);
	}

	@Override
	public String toString() {
		return studNo + " "+ studName + " "+ studAge + " "+ engScore + " "+ mathScore + " "+ sumScore;
	}


}
