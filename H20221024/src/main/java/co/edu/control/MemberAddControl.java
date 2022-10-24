package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;
import co.edu.service.MemberServiceMysql;
import co.edu.vo.MemberVO;

public class MemberAddControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//parameter 값에 따라서..
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String nm = req.getParameter("name");
		String ml = req.getParameter("mail");
		
		MemberVO vo = new MemberVO(id, pw, nm, ml);
		
		// DB 입력처리.
		MemberService service = new MemberServiceImpl(); //객체를 호출할때 mySql인지 impl인지 알려주면 crud는 수정하지 않아도 된다.
		service.addMember(vo);
		//처리된 결과를 보여주는 페이지.
		HttpUtil.forward(req, resp, "memberResult/memberInsertOutput.jsp"); //재 호출하는것 
		
		
	}

}
