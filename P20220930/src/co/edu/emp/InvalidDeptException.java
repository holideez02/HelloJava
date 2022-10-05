package co.edu.emp;

public class InvalidDeptException extends RuntimeException {
	InvalidDeptException(){} //기본생성자
	InvalidDeptException(String msg){ //메세지를 매개변수로 받는 생성자
		super(msg);
	}
}
