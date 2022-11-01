package co.edu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.member.MemberVO;
import co.edu.service.memberDAO;

@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/json;charset=utf-8");
		memberDAO dao = new memberDAO();
		List<MemberVO> list = dao.memberList();
		// [{"id":"user1", "name":"홍길동", "email":"email.com", "responsibility": "user"},
		// {}, {}] 형태로 오는것. 맨마지막엔 콤마빼고!
		// 데이터가 3건이라면. 1, 2, 3 끝에는 콤마 없어야 함. 인덱스-1

		// 이렇게 만들어지는게 json 포멧이지만, 간단한건 라이브러리를 이용하면 끝!
//		String json = "[";
//		for(int i=0; i<list.size(); i++) { // \는 escape. \뒤에 뭔가 오면 그 뒤에것은 문자열로 인식.
//			json += "{\"id\":\""+list.get(i).getId()
//					+"\", \"name\":\""+list.get(i).getName()
//					+"\", \"email\":\""+list.get(i).getEmail()
//					+"\", \"responsibility\": \""+list.get(i).getResponsibility() + "\"}"; 
//			if(i <list.size()-1) { //작을동안은 콤마 붙임.
//				json +=",";
//			}
//		}
//		json += "]"; //끝부분. 계속 누적해나가는 것.
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list)); // 바꿀 자바 객체를 넣어주면 끝!
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost");
		request.setCharacterEncoding("utf-8"); // 한글 인코딩 방식 설정
		response.setCharacterEncoding("utf-8"); // 받아와도 한글.
		response.setContentType("text/json;charset=utf-8");

		String job = request.getParameter("job");

		String id = request.getParameter("id");
		memberDAO dao = new memberDAO();
		// job이 등록인지 삭제인지 구분!
		if (job.equals("delete")) {
			if (dao.deleteMember(id)) {
				response.getWriter().print("success"); // 정상적으로 처리되면!
			} else {
				response.getWriter().print("fail");
			}
		} else if (job.equals("insert")) { // 등록이라면!
			String pw = request.getParameter("passwd");
			String em = request.getParameter("email");
			String nm = request.getParameter("name");

			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPasswd(pw);
			vo.setEmail(em);
			vo.setName(nm);

			dao.insertMember(vo);
			// gson 라이브러리로 자바의 객체를 json 형태로 바꿔줌!
			Gson gson = new GsonBuilder().create(); // gson 인스턴스 호출
			// gson.toJson(vo); // {"id" : "user1", "passwd":...}
			response.getWriter().print(gson.toJson(vo)); // 결과값을 Json으로 바꿔준다음 받아온것. 웹브라우저에 print
		}

	}

}
