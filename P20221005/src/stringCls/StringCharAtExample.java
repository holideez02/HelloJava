package stringCls;

public class StringCharAtExample {
	public static void main(String[] args) {
		//문자 추출 charAt.매개값으로 주어진 인덱스의 문자 리턴.
		String ssn = "010624-1230123";
		char sex = ssn.charAt(7); //7번째 위치의 문자를 읽어와서
		switch(sex) {
		case '1':
		case '3': 
			System.out.println("남자 입니다."); //문자 '1', 문자 '3' 이면 남자!
			break;
		case '2':
		case '4':
			System.out.println("여자 입니다."); //문자 '2', 문자 '4' 이면 여자!
			break;
		}
	}
}
