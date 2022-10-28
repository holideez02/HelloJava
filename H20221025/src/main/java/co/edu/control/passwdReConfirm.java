package co.edu.control;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.MemberVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class passwdReConfirm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random random = new Random();
		int createNum = 0;
		String ranNum = "";
		int letter = 6;
		String result = "";

		for (int i = 0; i < letter; i++) {
			createNum = random.nextInt(9); // 0~9까지의 난수
			ranNum = Integer.toString(createNum);
			result += ranNum;
		}
		
		String id = req.getParameter("id");
		
		BoardService service = new BoardServiceImpl();
		
		MemberVO vo = service.getPassWd(id);
		
		String from = "holideez02@naver.com";
		String to = vo.getEmail();
		String subject = "임시 비밀번호입니다.";
		String content = "비밀번호는 " + result + "입니다. ";
		service.sendMail(from, to, subject, content);
		
		MemberVO user = new MemberVO(vo.getId(), result, vo.getName(), vo.getEmail(), vo.getResponsibility());
		service.update(user);
		
		HttpUtil.forward(req, resp, "member/passwd.tiles");
	}

}
