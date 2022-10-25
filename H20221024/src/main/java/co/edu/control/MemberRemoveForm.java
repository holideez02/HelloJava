package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import co.edu.common.Command;
import co.edu.common.HttpUtil;

public class MemberRemoveForm implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//memberView/memberDelete.jsp 화면 열어줌.
		HttpUtil.forward(req, resp, "/memberView/memberDelete.jsp");
	}

}
