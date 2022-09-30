package co.edu;

public class Singleton {
	//외부에서 접근 못하도록 private 정적 필드
	private static Singleton singleton = new Singleton();
	//밑의 싱글톤을 가지고와서 실행할게요
	
	// private 생성자. 외부에서 이 싱글톤을 쓰지 못한다
	private Singleton() { 
		
	}
	
	//public getInstance();로만 유일하게 밖에서도 생성자를 만들 수 있음 
	public static Singleton getInstace(){//정적메소드
		return singleton; //위에서 만든 필드값 singleton 리턴
	}
}
