package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Control;
import co.edu.common.HttpUtil;

public class SignOut implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate(); //웹브라우저의 session 삭제
		
		HttpUtil.forward(req, resp, "member/signInForm.tiles");
		
	}

}