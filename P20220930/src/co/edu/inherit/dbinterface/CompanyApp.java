package co.edu.inherit.dbinterface;

public class CompanyApp {
	public static void main(String[] args) {
		//추가, 수정, 삭제, 조회기능.
//		MysqlDAO dao = new MysqlDAO();
//		dao.insert();
//		dao.update();
//		dao.search();
//		dao.delete(); 이제 오라클로 옮길거라서 못쓴다면?
		
//		OracleDAO dao = new OracleDAO();
//		dao.add();
//		dao.modify();
//		dao.find();
//		dao.remove();
		
		//위에처럼 할 필요 없다. 우리는 인터페이스를 설정해줬기 때문에 !
		DaoService dao = new MysqlDAO();  // mysql버전의 ver.1 쓰다가
		dao = new OracleDAO(); //오라클 버전의 ver.2로 바꿔용. 인터페이스가 가지고 있는 메소드는 동일하니까 훨씬 간단해짐. 객체만 수정해주면 되니까!
		dao.insert();
		dao.modify();
		dao.remove();
		dao.search();
		
		//익명 구현 객체: 기능만 구현하고 싶을 때. 클래스 이름 없이 인터페이스 구현하는 코드만. 굳이 클래스를 선언하지 않음.
		DaoService anonym = new DaoService() { //new뒤에 인터페이스 이름을 넣기. {}안에 기능만 넣을게요.
			@Override
			public void insert() {
				System.out.println("익명db 입력.");
			}
			@Override
			public void modify() {
				System.out.println("익명db 수정.");
			}
			@Override
			public void remove() {
				System.out.println("익명db 삭제.");
			}
			@Override
			public void search() {
				System.out.println("익명db 조회.");
			} 
			
		};
		anonym.insert();
		anonym.search();
		
	}
}
