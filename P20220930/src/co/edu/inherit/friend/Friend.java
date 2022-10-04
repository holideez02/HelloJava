package co.edu.inherit.friend;

public class Friend { //상속할 수 없는 클래스로 붙이려면 final class 붙여주기.
	//필드.
	private String name;
	private String phone;
	
	public Friend() {} //기본 생성자 정의.
	public Friend(String name, String phone) { //생성자 호출
		super(); //오브젝트의 생성자도 호출하는 것.
		this.name = name;
		this.phone = phone;
	}
	
	//메소드.
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return this.name;
	}
	public String getPhone() {
		return this.phone; //phone이라는 필드 값을 반환해줌
	}
	public String showInfo() {
		return "친구의 이름은 " + name + ", 연락처는 " + phone;
	}
	
	
}
