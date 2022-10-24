package co.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;

//servlet이 되려면 httpServlet 상속을 해야함.
//init()-> service() 구현되어야 한다.
//제어의 흐름을 개발자가 아니라 서블릿컨테이너가 대신 흐름을 제어해줌: 제어의 역전(IOC)
public class FirstServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출."); //인스턴스가 생성될 때 한번만 실행.
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출."); //FirstServlet이 호출될 때 마다 실행.
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		//사용자 파라메터 처리.
		String job = req.getParameter("job"); //job에다가 파라메터를 담아두고
		EmpDAO dao = new EmpDAO();
		if(req.getMethod().equals("GET")) {
			//요청정보를 담고있는 req가 get이면~.. 정보를 조회할때 사용
			List<EmployeeVO> list = dao.empList(new EmployeeVO(job));
			out.print("<table border='1'>");
			out.print("<tr><th>사원번호</th><th>이름</th><th>이메일</th><th>직무</th></tr>");
			for(EmployeeVO emp : list) {
				out.print("<tr><td>"+emp.getEmployeeId()+"</td>" 
						+"<td>"+ emp.getLastName()+"</td>"
						+"<td>"+ emp.getEmail()+ "</td>"
						+"<td>"+ emp.getJobId()+ "</td></tr>");
			}
			out.print("</table>");
		} else if(req.getMethod().equals("POST")) {//요청정보를 담고있는 req가 post이면
			//데이터를 입력할때. 이부분 중요!!
			String empId = req.getParameter("emp_id");//emp_id라는 파라메터를 넘겨받아서 empId에 저장
			String lName = req.getParameter("last_name");
			String email = req.getParameter("email");
			String hDate = req.getParameter("hire_date");
			
			dao.insertEmp(new EmployeeVO(Integer.parseInt(empId)
					,null //first_name
					,lName //last_name
					,email //email
					,hDate //hire_date
					,job //job_id
			));
			
			out.print("<script>alert('입력완료');</script>");
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 호출."); //FirstServlet이 종료될때 호출. 재실행될때도!
		
	}
}
