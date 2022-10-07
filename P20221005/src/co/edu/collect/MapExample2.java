package co.edu.collect;

import java.util.HashMap;
import java.util.Map;

class Book {
	String bookCode;
	String author;
	String publish;

	public Book(String bookCode, String author, String publish) {
		this.bookCode = bookCode;
		this.author = author;
		this.publish = publish;
	}

	// hashCode, equals 메소드가 동일한 값이면 동일한 객체로 판단하도록 오버라이딩
	@Override
	public int hashCode() {
		return bookCode.hashCode(); // 문자열이기 때문에 같은 hashcode 스트링클래스가 가지고 있는 해시코드 가지고옴
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) { // obj가 book의 인스턴스 클래스가 맞으면?
			Book target = (Book) obj;
			return this.bookCode.equals(target.bookCode); //타겟으로 들어온 책번호랑 가지고있는거랑 같으면 같은객체로 인식
		} else {
			return false;
		}
	}

}

public class MapExample2 {
	public static void main(String[] args) {
		Map<Book, Integer> map = new HashMap<>(); // 오른쪽에 생략해줘도 왼쪽편에 있는걸로 알아서 인식해줌.
		map.put(new Book("239208", "홍길동", "순수출판사"), 2000); // 2000이 값. 인스턴스는 키.
		map.put(new Book("wewew8", "김민수", "좋은출판사"), 3000);
		map.put(new Book("abcdef", "홍성은", "우리출판사"), 4000);

		Integer val = map.get(new Book("239208", "홍길동", "순수출판사")); // 이러면 null로 뜸. 다른객체로 인식해서ㅜㅜ
		System.out.println("값: " + val);
	}
}
