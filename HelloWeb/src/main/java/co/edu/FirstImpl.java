package co.edu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstImpl implements Command {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// first.do를 호출하면 first.jsp 페이지를 호출하도록. forwarding을 활용
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/first.jsp");
		rd.forward(req, resp); //해당되는 페이지로 이동.
//		resp.sendRedirect("WEB-INF/jsp.first.jsp");  //요청정보를 jsp/first.jsp로 이동.
		
	}

}
