package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;
import co.edu.vo.MemberVO;

public class MemberModify implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자가 입력한 정보를 parameter 읽어와야 한다.
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String nm = req.getParameter("name");
		String ml = req.getParameter("mail");
		
		MemberVO vo = new MemberVO(id, pw, nm, ml);
		
		MemberService service = new MemberServiceImpl();
		service.modifyMember(vo); 
		
		//처리가 끝나면 결과 화면으로!
		HttpUtil.forward(req, resp, "memberResult/memberUpdateOutput.jsp");
	}

}
