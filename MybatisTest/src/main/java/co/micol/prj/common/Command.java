package co.micol.prj.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트에서 요청할때의 값들 받아놓음 = request 객체 , 내가 응답하는 객체 = response객체
public interface Command { //
	public String exec(HttpServletRequest request, HttpServletResponse response);

}
