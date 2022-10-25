package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Command;
import co.edu.common.HttpUtil;

public class MainControl implements Command {
//제일 첫번째 호출되는 페이지
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(); //웹브라우저로 어떤 페이지를 요청하면 서버의 정보를 클라이언트에서 가져와서 페이지에 올때마다 session을 가져옴
		//요청정보에서 session 정보를 읽어옴. 그리고 session에 담음.
		
		//session 정보가 있으면 main으로 이동, 없으면 로그인하러 가기.
		String id = (String) session.getAttribute("id"); 
		if(id != null) {//id라는 정보가 있는지 찾고 있으면 메인페이지로 이동
		HttpUtil.forward(req, resp, "memberView/main.jsp");
		//memberView/main.jsp를 찾아!
		} else { //session 정보가 없으면 로그인 페이지로 이동.
			HttpUtil.forward(req, resp, "memberLog/loginForm.jsp");
		}
	}

}
