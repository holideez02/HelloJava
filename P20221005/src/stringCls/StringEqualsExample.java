package stringCls;

public class StringEqualsExample {
	public static void main(String[] args) {
		String strVar1 = new String("신민철");
		String strVar2 = "신민철";
		
		if(strVar1 == strVar2) { //변수에 저장된 주소값을 비교함. 당연히 다르겠지 ~~ 둘은 다른 객체잖아~~~
			System.out.println("같은 String 객체를 참조");
		} else {
			System.out.println("다른 String 객체를 참조");
		}
		
		if(strVar1.equals(strVar2)) { // String에서 쓰는 equals는 문자열을 비교하는거니까 같지 ~~~
			System.out.println("같은 문자열을 가짐");
		} else {
			System.out.println("다른 문자열을 가짐.");
		}
	}
}
