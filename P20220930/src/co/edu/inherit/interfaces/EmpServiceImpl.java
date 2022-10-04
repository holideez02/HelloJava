package co.edu.inherit.interfaces;

//구현 클래스(인터페이스를 상속하는 클래스)
public class EmpServiceImpl implements DaoService{// daoservice인터페이스를 구현하는 실체 클래스
	private String db;
	
	public EmpServiceImpl() {}
	public EmpServiceImpl(String db) {
		this.db = db;
	}
	public void setDb(String db) { //setter도 정의가능
		this.db = db;
	}
	public String getDb() { //getter도 정의가능
		return this.db;
	}
	@Override // 반드시 구현해줘야겠지? 자식이니까!
	public void insert() {
		System.out.println(db + "저장");
	}

	@Override
	public void search() {
		System.out.println(db + "조회");
	}

	@Override
	public void delete() {
		System.out.println(db + "삭제");
	} 

}
