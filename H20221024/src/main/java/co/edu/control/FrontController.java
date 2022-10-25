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
		//메인화면
		control.put("/main.do", new MainControl()); //main.do를 호출하면 maincontrol 실행
		//추가
		control.put("/memberAddForm.do", new MemberAddForm()); //form은 단순히 화면.
		control.put("/memberAdd.do", new MemberAddControl()); //command를 구현하는 객체.
		//수정
		control.put("/memberModifyForm.do", new MemberModifyForm());//form은 단순히 화면.
		control.put("/memberModify.do", new MemberModify());
		//삭제
		control.put("/memberRemoveForm.do", new MemberRemoveForm());
		control.put("/memberRemove.do",  new MemberRemove());
		//단건 조회
		control.put("/memberSearchForm.do",  new MemberSearchForm());
		control.put("/memberSearch.do",  new MemberSearch());
		//목록.
		control.put("/memberList.do", new MemberList());
		//로그인 처리.
		control.put("/loginForm.do", new LoginForm());
		control.put("/login.do", new Login());
		control.put("/loginOut.do", new LogOut());
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
