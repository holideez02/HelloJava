package co.edu.inherit.interfaces;

public interface DaoService {
	// 인터페이스는 생성자, 필드 있으면 안돼!
	// 메소드는 있지만 전부 추상메소드여야 한다.
	// 필드 대신 상수값을 정의해서 사용!
	
	public abstract void insert(); //추상메소드. abstract 를 안붙여도 자동으로 추상메소드
	public void search(); //추상메소드.
	public void delete(); //추상메소드.
	
}
