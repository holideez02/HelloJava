package co.edu.inherit.interfaces;

public class DaoMain {
	public static void main(String[] args) {
		EmpServiceImpl service = new EmpServiceImpl();
		service.setDb("인사");
		service.insert();
		service.delete();
		service.search();
		
		DeptServiceImpl service2 = new DeptServiceImpl();
		service2.insert();
		service2.delete();
		service2.search();
		
		DaoService dao = new EmpServiceImpl(); //구현클래스. 앞은 인터페이스. 구현클래스가 인터페이스를 구현하니까 넣을 수 도 있다.
		dao = new DeptServiceImpl(); // 구현클래스에 할당 가능.
		dao.insert();
		dao.delete();
		dao.search(); // 각각 다른 인스턴스의 값으로 채워지면 그 값에 해당하는게나오겠지
	}
}
