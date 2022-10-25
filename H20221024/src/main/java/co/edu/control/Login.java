package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Command;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;
import co.edu.vo.MemberVO;

public class Login implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String pass = req.getParameter("passwd");

		MemberService service = new MemberServiceImpl();
		MemberVO result = service.login(id, pass);

		//회원 아이디와 비밀번호가 맞으면 메인페이지로 이동(main.jsp)
		if (result != null) {
			req.setAttribute("logInfo", result);

			HttpSession session = req.getSession(); // 요청정보가 가지고 있는
			session.setAttribute("id", result.getId());
			session.setAttribute("auth", result.getResponsibility()); //admin/user권한

			HttpUtil.forward(req, resp, "memberView/main.jsp"); // 로그인했을때 널이 아니면 이리로 넘어가기
		} else {
			HttpUtil.forward(req, resp, "memberLog/loginForm.jsp"); //값이 없으면(null 이면) 다시 로그인폼으로 돌아가기.
		}

	}

}
