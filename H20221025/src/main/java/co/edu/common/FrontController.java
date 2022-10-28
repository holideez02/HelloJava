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
import co.edu.control.SignIn;
import co.edu.control.SignInForm;
import co.edu.control.SignOut;
import co.edu.control.MainControl;
import co.edu.control.MemberList;
import co.edu.control.faqControl;
import co.edu.control.passwdReConfirm;
import co.edu.control.passwdReConfirmForm;
import co.edu.control.SearchBoard;
import co.edu.control.SignUp;
import co.edu.control.SignUpForm;
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
		controlList.put("/faq.do", new faqControl());//FAQ게시판
		
		//회원가입.
		controlList.put("/signUpForm.do", new SignUpForm()); //회원가입화면
		controlList.put("/signUp.do", new SignUp()); //회원가입처리=> 회원가입 되었습니다. 메시지
		controlList.put("/memberList.do", new MemberList()); //회원목록보기
		
		//로그인
		controlList.put("/signInForm.do", new SignInForm()); //로그인 화면
		controlList.put("/signIn.do", new SignIn()); //로그인처리
		controlList.put("/signOut.do", new SignOut()); //로그아웃
		
		//비밀번호 찾기
		controlList.put("/passwdReConfirmForm.do", new passwdReConfirmForm());
		controlList.put("/passwdReConfirm.do", new passwdReConfirm());
	}
	
	//서블릿이 호출될 때 마다 실행되는 service()
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding(charset); //요청정보에서 한글처리. 
		resp.setCharacterEncoding(charset); //응답정보에서 한글처리.
		
		String uri = req.getRequestURI(); //uri값을 읽어와서 .. http://localhost:8081/H20221025/main.do 요청정보에서 uri값읽어옴.
		String context = req.getContextPath(); //H20221025만.
		String path = uri.substring(context.length()); //main.do만.
		
		System.out.println(path);
		System.out.println(uri);
		Control subControl = controlList.get(path);
		subControl.exec(req, resp); //main.do를 호출해서 맵핑되어진 control을 실행.
	}
	
	
	
	
}
