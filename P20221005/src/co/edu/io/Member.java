package co.edu.io;

import java.io.Serializable;

public class Member implements Serializable {
	private String userId;
	private String name;
	private int point;
	
	public Member(String userId, String name, int point) {
		super();
		this.userId = userId;
		this.name = name;
		this.point = point;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "회원아이디 " + userId + ", 회원이름 " + name + ", 회원포인트";
	}
}
