package co.edu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{ //모든 요청들을 이 클래스를 통해 처리할것
	//servlet 관리.
	//url 주소와 실행할 서블릿을 map타입으로 관리할게요.
	Map<String, Command> map = new HashMap<String, Command>(); //command를 넣었으니 구현해주는게 필요
	@Override
	public void init() throws ServletException {
		map.put("/first.do", new FirstImpl()); //first라는 요청이 들어오면
		map.put("/second.do", new SecondImpl());
		map.put("/third.do", new ThirdImpl());
	}
	
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); //http://localhost:8081/HelloWeb/first.do를 호출하면 서버정보(localhost:8081)빼고 프로젝트와 페이지정보가 uri에 리턴.
		String contextPath = req.getContextPath(); //요청 uri에서 프로젝트의 정보를 반환
		String path = uri.substring(contextPath.length());
		
//		System.out.println("uri: " + uri); // /HelloWeb/first.do를 리턴.
//		System.out.println("contextPath: " + contextPath); // /HelloWeb
//		System.out.println("path: " + path); // /first.do
		
		Command command = map.get(path);
//		System.out.println(result); //first.do를 호출하면 firstServlet을 반환
		command.exec(req, resp);
	}
}
