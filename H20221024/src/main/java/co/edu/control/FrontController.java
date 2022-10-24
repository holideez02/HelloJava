package co.edu.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;

public class FrontController extends HttpServlet{
	
	Map<String, Command> control = new HashMap<>();
	
	@Override
	public void init() throws ServletException { //최초의 호출일때 실행.
		control.put("/main.do", new MainControl()); //main.do를 호출하면 maincontrol 실행
		control.put("/memberAddForm.do", new MemberAddForm()); //form은 단순히 화면.
		control.put("/memberAdd.do", new MemberAddControl()); //command를 구현하는 객체.
		control.put("/memberModifyForm.do", new MemberModifyForm());//form은 단순히 화면.
		control.put("/memberModify.do", new MemberModify());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Command command = control.get(path);
		command.exec(req, resp);
	}
}
