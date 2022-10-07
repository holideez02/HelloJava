package co.edu.api;

import java.util.ArrayList;
import java.util.List;

class Box<T>{ //어떤 내용물을 담기위한 박스. 모든 형태의 형태를 담음. 어떤형태의 필드든지 다 담음! <T>는 어떤 타입을 쓰겠다는걸 지금 정하지 않고 나중에 정할게요~하고 알려주는 것.
	T obj; //클래스를 사용하는 시점에 쓸게요
	void set(T obj) {
		this.obj = obj;
	}
	T get() {
		return obj;
	}
}

class Member{
	private String name;
	private String id;
	private int point;
	
	public Member(String name, String id, int point) {
		super();
		this.name = name;
		this.id = id;
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}

class Employee{
	private String empName;
	private String empId;
	private int salary;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}

public class StringExe3 {
	public static void main(String[] args) {
		
		Box<String> box = new Box();//이제 실행할때 박스라고 하는 참조변수는 스트링만 담도록 제한할게요~
		box.set("Hello");
//		box.set(200); //필드가 무슨 형태든지 다 담을 수 있는 object로 선언되어서 되었지만, <T>를 쓰고 문자열로 쓰겠다고 선언했기 때문에 이제 문자열밖에 못쓴다 ㅠㅠ 
//		String result = (String) box.get(); // 문자열의 값을 가지고 오려면 캐스팅작업을 해줘야 함. 담을땐 맘대로지만 나올때는 까다롭단다. 
//		Integer result = (Integer) box.get(); // 문자열 타입을 가지고 올때 근데 정수타입도 함께 담겨져있다면 에러뜸. 조심. integer은 아무거나 담겨있어도 괜찮다
		String result = box.get();
		System.out.println(result); 
		
		String[] stAry; // 문자열을 담는 배열의 의미
		List<String> list = new ArrayList<String> (); // 컬렉션. 모든 객체 다 담아도 되지만 문자열만 받겠다 하고 선언. 보통은 같은타입만 담는듯..
		list.add("Hello");
//		list.add(200); 정수는 안된다~
		
		List<Member> members = new ArrayList<Member>();
		members.add(new Member("홍길동", "hong", 10000)); //member의 변수들만 담을 수 있음
		members.add(new Member("김민기", "kim", 20000));
		members.add(new Member("박인기", "park", 30000));
		
		List<Employee> employees = changeType(members); // member클래스의 각각의 값들을 employee클래스 타입으로 바꿔주는.
		for(Employee emp: employees) {
//			System.out.println(emp); //toString을 오버라이딩 하지 않아서 주소값만 뜸
			System.out.println("name" + emp.getEmpName() + ", id: " + emp.getEmpId()); //데이터를 받아서 값을 넘기기위한 용도
		}
	}
	
	public static List<Employee> changeType(List<Member> collect){ //반환값은 List<employee>, 리턴값은 List<Member> collect
		//3->3개. 
		//coding
		List<Employee> empls = new ArrayList<Employee>(); // 
		for(Member member : collect) {
			Employee emp = new Employee();
			emp.setEmpId(member.getId());
			emp.setEmpName(member.getName());
			emp.setSalary(member.getPoint());
			
			empls.add(emp);
		}
		return empls;
	}
	}

