package co.edu.io;

import java.io.Serializable;

public class Emp implements Serializable {
	private static final long serialVersionUID = 6451210830835629502L;
// emp클래스를 스트림에 저장하고 불러옴 .serial 어쩌고는 아무 기능은 없지만 구현은 해줘야함

	int id;
	String name;
	String dept;

	public Emp(int id, String name, String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "사원id: " + id + ", 이름: " + name + ", 부서: " + dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}