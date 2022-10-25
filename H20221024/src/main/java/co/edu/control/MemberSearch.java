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

public class MemberSearch implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//id를 입력받고 결과는 memberResult/memberSearchOutput.jsp로 보냄
		String path = "";
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		
		if(job.equals("search")) { //받아온 값이 search면 상세검색으로
			path="memberResult/memberSearchOutput.jsp";
		} else if(job.equals("update")) { //받아온 값이 update면 수정으로
			path= "memberView/memberUpdate.jsp";
		} else if(job.equals("delete")) {
			path="memberView/memberDelete.jsp";
		}
		
		MemberService service = new MemberServiceImpl();
		MemberVO vo = service.findMember(id);
		
		//요청정보(req)의 속성에 vo값을 담아서 넘기기.
		req.setAttribute("memberInfo", vo);
		
		HttpUtil.forward(req, resp, path);
	}

}
