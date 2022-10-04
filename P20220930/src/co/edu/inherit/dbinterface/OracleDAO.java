package co.edu.inherit.dbinterface;

public class OracleDAO implements DaoService{
	//인터페이스로 추가, 수정, 삭제, 조회.

	@Override
	public void insert() {
		System.out.println("oracle 저장.");
	}

	@Override
	public void modify() {
		System.out.println("oracle 수정.");
	}

	@Override
	public void remove() {
		System.out.println("oracle 삭제.");
	}

	@Override
	public void search() {
		System.out.println("oracle 조회.");
	}
	
//	public void add() {
//		System.out.println("oracle 저장.");
//	}
//	public void modify() {
//		System.out.println("oracle 수정.");
//	}
//	public void find() {
//		System.out.println("oracle 조회.");
//	}
//	public void remove() {
//		System.out.println("oracle 삭제.");
//	}
}
