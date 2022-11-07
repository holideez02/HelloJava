package co.micol.prj.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class MainCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 처음 들어올때 보여줄 페이지 호출.
		return "main/main"; //실제로 찾는건 /WEB-INF/views/main/main.jsp로 받아지겠지.
		
	}

}
