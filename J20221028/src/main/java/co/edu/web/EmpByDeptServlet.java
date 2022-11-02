package co.edu.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.service.memberDAO;


@WebServlet("/EmpByDeptServlet")
public class EmpByDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmpByDeptServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8"); //자료 넘기는 방식을 JSON타입으로 지정
		memberDAO dao = new memberDAO();
		Map<String, Integer> result = dao.getEmpByDept(); 
		Gson gson = new GsonBuilder().create();
		
		response.getWriter().print(gson.toJson(result)); //데이터를 가지고와서 json으로 작업.
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
