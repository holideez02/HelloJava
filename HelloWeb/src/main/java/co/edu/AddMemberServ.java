package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;

@WebServlet({ "/addMemberServlet", "/addMember" })
public class AddMemberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddMemberServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, //
			HttpServletResponse response) //처리된 서버 상태나, 사용자가 요청했던 값..같은 것들을 웹브라우저로 던져줌.
			throws ServletException, IOException {
		//contenttype을 지정. html이라고 알려줘야 웹브라우저가 인식을 할 수 있음
		response.setContentType("text/html;charset=UTF-8"); //보여지는 페이지가 html이니 그 형태로 해석되게 해주세요.
		
		
		System.out.println("/addMemberSer 페이지입니다.");
		String empId = request.getParameter("employee_id"); // 사용자가 보내온 요청정보 중 뒤에 파라메터의 값을 읽어옴
		String lName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hire_date");
		String jobId = request.getParameter("job_id");

		System.out.println(empId);

		// 입력.
		EmpDAO dao = new EmpDAO();
		EmployeeVO vo = new EmployeeVO(0, lName, email, hireDate, jobId);
		dao.insertEmp(vo);

		System.out.println("입력완료.");
		
		PrintWriter out = response.getWriter(); //출력스트림. 사용자의 응답에 요청해서 보여주는. 2byte씩 받아서 출력
		out.print("<h3>* 사원정보 입력결과 *</h3>");
		out.print("<p>사원번호: " + vo.getEmployeeId() +"번 </p>");
		out.print("<p>성씨: " + vo.getLastName() +"</p>");
		out.print("<p>이메일: " + vo.getEmail() +"</p>");
		out.print("<p>입사일: " + vo.getHireDate() +"</p>");
		out.print("<p>직무: " + vo.getJobId() +"</p>");
		
		out.print("<a href=\"index.html\"> 회원등록 페이지 이동 </a>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
