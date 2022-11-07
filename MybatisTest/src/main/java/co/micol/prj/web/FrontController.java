package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.book.command.BookList;
import co.micol.prj.common.Command;
import co.micol.prj.main.MainCommand;

/**
 * 모든요청을 받아들이는 컨트롤러
 */
@WebServlet("*.do") //어노테이션을 이용해서 맵핑. .do라고 들어오면 내가 동작할게
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//사용할 맵컬렉션을 만들어주는것. 키값과 밸류값으로.
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
	//생성자
    public FrontController() { 
        super();
    }
    
    //요청한 것을 실행하는 명령을 모아두는 곳
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); //main.do로 들어오면 처음 보여줄 페이지.
		map.put("/bookList.do", new BookList()); // 책 목록보기
		
	
	}

	//요청을 분석하고 실행, 결과를 돌려주는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//분석
		request.setCharacterEncoding("utf-8"); //한글 깨짐 방지
		String uri = request.getRequestURI(); //요청한 uri를 구함. 도메인 네임을 제외한 부분을 uri라고 함. naver.com/다음에 오는 다른것들. 
		String contextPath = request.getContextPath(); //루트를 구함, 정확하게는 contextPath를 구하는것.
		String page = uri.substring(contextPath.length()); //실제 요청만 남음. 
		
		//수행할 요청 찾기
		Command command = map.get(page); //init 메소드에서 수행할 명령을 가져온다. get으로 가져왔으니 page라는 키값을 던져주면 그거의 value가지고 옴
//		Command command = new MainCommand(); 위에꺼랑 똑같다. 인터페이스는 자기자신을 초기화 시키지 못하기 때문에 mainCommand로 불러와서 초기화.
		String viewPage = command.exec(request, response); //명령을 수행하고 결과를 돌려받음.
		
		//viewResolve 만듬(결과)
		if(!viewPage.endsWith(".do") && viewPage != null) { //리턴되는 문자에서 .do가 포함되어있지 않고 널이 아니면 이렇게 처리해라
			//ajax : 요청한 페이지 처리.
			//타일즈 돌아가는 곳
			viewPage = "/WEB-INF/views/" + viewPage + ".jsp"; //문자열을 더해줌. 서버에서 접근가능하니까 바로 연결되도록			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response); //dispatcher는 request, response 값을 함께 가지고 가는것.(값까지 같이 전달가능) 내가 보내는 값을 같이 가지고 가서 처리. forward도 명령만 보내지만 dispatcher가 붙었기 때문에 값을 가지고 가는것
		} else {
			response.sendRedirect(viewPage); //*.do로 들어올때 돌아가는 곳 . 그냥 명령만 내린다. 받은 요청을 자기가 처리 안하고 다른객체한테 떠넘기는데 .. 권한을 위임하는데 그냥 값을 들고가지 않고 가는것 ㅜㅜ 필요한건 안들고가고. 명령만 보냄.
		}
	}
}
