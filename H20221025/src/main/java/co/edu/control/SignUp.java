package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.MemberVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class SignUp implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pass = req.getParameter("pswd");
		String name = req.getParameter("name");
		String email = req.getParameter("mail");
		String user = req.getParameter("responsibility");

		MemberVO vo = new MemberVO(id, pass, name, email, user);

		BoardService service = new BoardServiceImpl();
		service.memberInsert(vo);
		
		//처리결과.
		HttpUtil.forward(req, resp, "member/member.tiles");
	}

}
