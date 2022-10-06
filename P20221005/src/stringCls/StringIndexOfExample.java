package stringCls;

public class StringIndexOfExample {
	public static void main(String[] args) {
		String subject = "자바 프로그래밍";
		
		int location = subject.indexOf("프로그래밍"); // 문자열 찾을거에요!
		System.out.println(location);
		
		if(subject.indexOf("자바") != -1) { //자바라는 문자열이 없는게(-1) 아니라면(!=) => 자바라는 문자열이 있다면!!!!
			System.out.println("자바랑 관련된 책이군요!");
		} else {
			System.out.println("자바랑 관련없는 책이군요!");
		}
	}
}
