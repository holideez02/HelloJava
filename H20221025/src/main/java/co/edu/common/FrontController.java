package co.edu.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.control.BulletinControl;
import co.edu.control.MainControl;
import co.edu.control.SearchBoard;
import co.edu.control.WriteBoard;
import co.edu.control.WriteForm;

public class FrontController extends HttpServlet{

	HashMap<String, Control> controlList;
	String charset;
	
//	//서블릿이 최초로 한번 호출되면 실행되는 init()
//	@Override
//	public void init() throws ServletException {
//		ServletContext sc = this.getServletContext(); //이 메소드로 servletContext를 가지고 옴
//		sc.getInitParameter("charset"); //이 값으로 셋팅되어져 있는 키 값(UTF-8) 읽어옴.
//	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset"); //위와 같다. 둘 중 아무거나 사용.
		controlList = new HashMap<String, Control>();
		
		controlList.put("/main.do", new MainControl()); //메인
		controlList.put("/bulletin.do", new BulletinControl()); //목록보기	
		controlList.put("/searchBoard.do", new SearchBoard()); //상세조회
		controlList.put("/writeBoardForm.do", new WriteForm()); //글등록form
		controlList.put("/writeBoard.do", new WriteBoard());//글등록
	}
	
	//서블릿이 호출될 때 마다 실행되는 service()
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI(); //uri값을 읽어와서 .. http://localhost:8081/H20221025/main.do 요청정보에서 uri값읽어옴.
		String context = req.getContextPath(); //H20221025만.
		String path = uri.substring(context.length()); //main.do만.
		
		System.out.println(path);
		System.out.println(uri);
		Control subControl = controlList.get(path);
		subControl.exec(req, resp); //main.do를 호출해서 맵핑되어진 control을 실행.
	}
	
	
	
	
}
